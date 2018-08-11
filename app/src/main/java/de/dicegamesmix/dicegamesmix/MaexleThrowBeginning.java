package de.dicegamesmix.dicegamesmix;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import io.paperdb.Paper;

public class MaexleThrowBeginning extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maexle_throw_beginning);

        //declaration
        TextView beginning_player_name = (TextView) findViewById(R.id.beginning_player_name);
        TextView beginning_result = (TextView) findViewById(R.id.beginning_result);
        final TextView beginning_result_number = (TextView) findViewById(R.id.beginning_result_number);
        Button beginning_throw_btn = (Button) findViewById(R.id.beginning_throw_btn);
        Button beginning_back_btn = (Button) findViewById(R.id.beginning_back_btn);
        final Integer throw1 = (int) (Math.random() * 6) + 1;
        final Integer throw2 = (int) (Math.random() * 6) + 1;
        int index = 0;

        final Intent maexle_answerPlayer = new Intent(getApplicationContext(), MaexleAnswerPlayer
                .class);
        final Intent back_to_menu = new Intent(getApplicationContext(),MainActivity.class);

        //read index
        index = Paper.book().read("index");

        final String resultN = throw1.toString() + throw2.toString();
        //import all names
        List<String> playerNames = Paper.book().read("Players");

        //take the one you need with the index
        String playername = playerNames.get(index);
        beginning_player_name.setText(playername);

        beginning_throw_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (throw1 == throw2) {
                    beginning_result_number.setText(throw1.toString() + throw2.toString());
                    Paper.book().write("result", resultN);
                }
                else if (throw1 > throw2) {
                    beginning_result_number.setText(throw1.toString() + throw2.toString());
                    Paper.book().write("result", resultN);
                } else {
                    beginning_result_number.setText(throw2.toString() + throw1.toString());
                    Paper.book().write("result", resultN);
                }
            }
        });

        beginning_back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(back_to_menu);
            }
        });
        //put in delay or display

    }
}
