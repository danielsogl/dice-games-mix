package de.dicegamesmix.dicegamesmix;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
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

        final ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.playerscreen_listview_layout, playerList);
        ListView maexle_player_playerList = (ListView) findViewById(R.id.maexle_player_playerList);
        maexle_player_playerList.setAdapter(adapter);

        Button maexle_player_btn_add = (Button) findViewById(R.id.maexle_player_btn_add);
        maexle_player_btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder playername = new AlertDialog.Builder(MaexlePlayerScreen.this);
                playername.setMessage("Please enter your name.")
                        .setTitle("add player");
                final EditText playerInput = new EditText(MaexlePlayerScreen.this);
                playername.setView(playerInput);

                playername.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String playerInputValue = playerInput.getText().toString();
                        playerList.add(playerInputValue);
                        adapter.notifyDataSetChanged();
                        Paper.book().write("Players", playerList);
                    }
                });
                playername.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog dialog = playername.create();
                dialog.show();


            }
        });

        //here you can add the players
    }
}
