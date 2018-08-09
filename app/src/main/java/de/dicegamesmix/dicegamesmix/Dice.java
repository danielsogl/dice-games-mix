package de.dicegamesmix.dicegamesmix;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Dice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice);

        //it simply roles the dice
        //just a placeholder, needs to be improved

        //objects
        final TextView simpleDice_diceResult_TextView = (TextView) findViewById(R.id.simpleDice_diceResult_TextView);
        Button simpleDice_rollDice_Button = (Button) findViewById(R.id.simpleDice_rollDice_Button);

        //set an OnClickListener, so we can display the result
        simpleDice_rollDice_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //initialize this string with a random number
                final Integer diceValue = (int) (Math.random()*6 + 1);

                //display this random number
                simpleDice_diceResult_TextView.setText(diceValue.toString());
            }
        });
    }
}
