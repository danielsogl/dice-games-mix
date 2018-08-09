package de.dicegamesmix.dicegamesmix;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button maexle_button = (Button) findViewById(R.id.maexle_button);
        Button dice_button = (Button) findViewById(R.id.Dice);

        //intent to open the other games
        final Intent maexle_welcomeScreen = new Intent(getApplicationContext(), MaexleWelcomeScreen.class);
        final Intent dice_game = new Intent(getApplicationContext(), Dice.class);

        maexle_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(maexle_welcomeScreen);
            }
        });

        dice_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(dice_game);
            }
        });
    }
}
