package de.dicegamesmix.dicegamesmix;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MaexleThrowBeginning extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maexle_throw_beginning);

        TextView beginning_player_name = (TextView) findViewById(R.id.beginning_player_name);
        TextView beginning_result = (TextView) findViewById(R.id.beginning_result);
        final TextView beginning_result_number = (TextView) findViewById(R.id.beginning_result_number);
        Button beginning_throw_btn = (Button) findViewById(R.id.beginning_throw_btn);
        final Integer throw1 = (int) (Math.random()*6)+1;
        final Integer throw2 = (int) (Math.random()*6)+1;
        final Intent maexle_answerPlayer = new Intent(getApplicationContext(), MaexleAnswerPlayer
        .class);
        final Integer result = 0; //variabel for saving the result of the dice from this screen. have to test how to programm so it
        //works like ist should work. has to be after each of the if-conditions.

        beginning_throw_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(throw1==throw2){
                    beginning_result_number.setText(throw1.toString()+throw2.toString());
                }
                if(throw1>throw2){
                    beginning_result_number.setText(throw1.toString()+throw2.toString());
                }
                else if(throw1<throw2){
                    beginning_result_number.setText(throw2.toString()+throw1.toString());
                }
                maexle_answerPlayer.putExtra("de.dicegamesmix.dicegamesmix.result", result);
            }
        });
        beginning_player_name.setText(result);
    }
}
