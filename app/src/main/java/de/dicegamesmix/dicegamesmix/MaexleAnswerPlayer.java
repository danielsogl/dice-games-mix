package de.dicegamesmix.dicegamesmix;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MaexleAnswerPlayer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maexle_answer_player);

        //object for the graphical elements
        Button maexle_ansPl_menu_btn = (Button) findViewById(R.id.maexle_ansPl_menu_btn);
        TextView maexle_ansPl_playerName_tv = (TextView) findViewById(R.id.maexle_answPl_playerName_tv);
        //TextView maexle_ansPl_


        /*notes:
                - answerPlayer: Ok button fehlt
                - answerUncover: weiter button fehlt

                ALLG: Programmlogik mit Tim besprechen!!
         */
    }
}
