package de.dicegamesmix.dicegamesmix;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MaexleGameScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maexle_game_screen);

        TextView game_result = (TextView) findViewById(R.id.game_result);
        TextView game_result_number = (TextView) findViewById(R.id.game_result_number);
        TextView game_answer = (TextView) findViewById(R.id.game_answer);
        EditText game_answer_player = (EditText) findViewById(R.id.game_answer_player);
        Button game_roll_btn = (Button) findViewById(R.id.game_roll_btn);
        Button game_uncover_btn = (Button) findViewById(R.id.game_uncover_btn);

        //place where the game takes place
    }
}
