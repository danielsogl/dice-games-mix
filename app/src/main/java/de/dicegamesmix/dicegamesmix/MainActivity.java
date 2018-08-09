package de.dicegamesmix.dicegamesmix;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import io.paperdb.Paper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Paper.init(this);

        Button maexle_button = (Button) findViewById(R.id.maexle_button);
        Button dice_button = (Button) findViewById(R.id.Dice);
        //Button um auf eine weitere Seite zu kommen.
        Button test = (Button) findViewById(R.id.test);

        //intent to open the other games
        final Intent maexle_welcomeScreen = new Intent(getApplicationContext(), MaexleWelcomeScreen.class);
        final Intent dice_game = new Intent(getApplicationContext(), Dice.class);
        //intent um auf weitere Seite zu kommen.
        final Intent MaexlePlayerScreen = new Intent(getApplicationContext(), MaexlePlayerScreen.class);

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

        //Button ausführen um auf andere Seite zu kommen.
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(MaexlePlayerScreen);
            }
        });
    }
}
