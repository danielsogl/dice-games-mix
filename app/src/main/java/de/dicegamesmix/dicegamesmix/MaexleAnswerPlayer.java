package de.dicegamesmix.dicegamesmix;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import io.paperdb.Paper;

public class MaexleAnswerPlayer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maexle_answer_player);

        //objects for the graphical elements
        Button maexle_ansPl_menu_btn = (Button) findViewById(R.id.maexle_ansPl_menu_btn);
        Button maexle_ansPl_ready_btn = (Button) findViewById(R.id.maexle_ansPl_ready_btn);
        TextView maexle_ansPl_playerName_tv = (TextView) findViewById(R.id.maexle_ansPl_playerName_tv);
        TextView maexle_ansPl_result_tv = (TextView) findViewById(R.id.maexle_ansPl_result_tv);
        final EditText maexle_ansPl_ansInput_et = (EditText) findViewById(R.id.maexle_ansPl_ansInput_et);

        //Intent to go to the other sites
        final Intent ansPl_maexle_throwMiddle = new Intent(getApplicationContext(), MaexleThrowMiddle.class);
        final Intent ansPl_main_menu = new Intent(getApplicationContext(), MainActivity.class);

        //string-list for names of the players
        List<String> playerNames = new ArrayList<>();
        //string-list for the points of the players
        List<String> playerPoints = new ArrayList<>();

        //variable for answer of the player
        //final Integer answer = 0;
        //variable for result of the player
        Integer result = 0;
        //variable for the index of the player in the array-lists
        Integer index = 0;

        //read and save playerNames and playerPoints in the array-lists
        playerNames = Paper.book().read("Players");
        playerPoints = Paper.book().read("Points");

        //read the index of the player
        index = Paper.book().read("index");
        //read the result of the player
        String zwischenspeicher = Paper.book().read("result");
        result = Integer.parseInt(zwischenspeicher);

        //write playerName in header
        String debug_string = playerNames.get(index);
        maexle_ansPl_playerName_tv.setText(debug_string);

        //display result
        maexle_ansPl_result_tv.setText(result + "");
        
        //increase index by one to get to the next player
        if (index < playerNames.size()) {
            index++;
        } else {
            index = 0;
        }

        //write changes to device
        Paper.book().write("index", index);

        //menu-button
        maexle_ansPl_menu_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(ansPl_main_menu);
            }
        });

        //ready-button
        maexle_ansPl_ready_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //variable
                int answer = 0;

                //read answer input
                answer = Integer.parseInt(maexle_ansPl_ansInput_et.getText().toString());

                //write the answerInput to the device
                Paper.book().write("answer", answer);

                //chenge screen
                startActivity(ansPl_maexle_throwMiddle);
            }
        });


    }
}
