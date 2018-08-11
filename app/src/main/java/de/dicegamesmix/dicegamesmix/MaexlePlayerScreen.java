package de.dicegamesmix.dicegamesmix;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import io.paperdb.Paper;

public class MaexlePlayerScreen extends AppCompatActivity {

    List<String> playerList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maexle_player_screen);
        playerList = Paper.book().read("Players", new ArrayList<String>());

        //set the index, answer and result saved on the device to zero, to start the session
        Paper.book().write("index", 0);
        Paper.book().write("answer", 0);
        Paper.book().write("resutl", "");

        //code: has to be commented
        final ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.playerscreen_listview_layout, playerList);
        final ListView maexle_player_playerList = (ListView) findViewById(R.id.maexle_player_playerList);
        maexle_player_playerList.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        Button start_game_btn = (Button) findViewById(R.id.start_game_btn);
        start_game_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent maexle_beginningscreen = new Intent(getApplicationContext(), MaexleThrowBeginning.class);
                /*maexle_Gamescreen.putExtra("de.dicegamesmix.dicegamesmix", );*/
                startActivity(maexle_beginningscreen);
            }
        });

        Button maexle_player_back_btn = (Button) findViewById(R.id.maexle_player_back_btn);
        maexle_player_back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        final Button maexle_player_btn_add = (Button) findViewById(R.id.maexle_player_btn_add);

        //OnClickListener for the plus-button
        maexle_player_btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //alert-dialog declared and initialized
                AlertDialog.Builder playername = new AlertDialog.Builder(MaexlePlayerScreen.this);
                playername.setMessage("Please enter your name.")
                        .setTitle("add player");
                //object for EditText
                final EditText playerInput = new EditText(MaexlePlayerScreen.this);
                //added the EditText to the AlertDialogue
                playername.setView(playerInput);

                //aded buttons to the AlertDialogue
                playername.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String playerInputValue = playerInput.getText().toString();

                        //saving
                        playerList.add(playerInputValue);

                        //updates the list on screen
                        adapter.notifyDataSetChanged();

                        //saving on device
                        Paper.book().write("Players", playerList);
                    }
                });
                playername.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                //Dialog-builder is transformed into a "real" dialog
                AlertDialog dialog = playername.create();
                dialog.show();

                //deletion of the player with al long click
                maexle_player_playerList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int p, long l) {
                        //declare and initialize Dialog
                        AlertDialog.Builder deletePlayer = new AlertDialog.Builder(MaexlePlayerScreen.this);
                        deletePlayer.setMessage("Are you sure you want to delete this player?")
                                .setTitle("delete player")
                                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        //selected item in the arrayList
                                        playerList.remove(p);
                                        //refresh the List on the screen
                                        adapter.notifyDataSetChanged();
                                        //overwrite List on device to commit changes
                                        Paper.book().write("Players", playerList);
                                    }
                                })
                                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.dismiss();
                                    }
                                });
                        AlertDialog deleteDialog = deletePlayer.create();
                        //show dialogue
                        deleteDialog.show();
                        return true;
                    }
                });



            }
        });

    }
}
