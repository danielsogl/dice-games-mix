package de.dicegamesmix.dicegamesmix;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MaexleWelcomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maexle_welcome_screen);

        //welcome screen for maexle
        //here is displayed: the rules and a button to start the game and ont to exit

        //objects
        //TextView maexle_welc_header = (TextView) findViewById(R.id.maexle_welc_header);
        TextView maexle_welc_rules = (TextView) findViewById(R.id.maexle_welc_rules);
        Button maexle_welc_back_btn = (Button) findViewById(R.id.maexle_welc_back_btn);
        Button maexle_welc_start_btn = (Button) findViewById(R.id.maexle_welc_start_btn);

        //reference the resources
        Resources res = getResources();

        //variables form the resources
        String manual_maexle = res.getString(R.string.rules_of_maexle);

        //display the manual
        maexle_welc_rules.setText(manual_maexle);

        //create Intent
        final Intent to_maexlePlayerScreen = new Intent(getApplicationContext(), MaexlePlayerScreen.class);

        //when Buttons are clicked, perform action
        //go further - Button
        maexle_welc_start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //go to the "MaexlePlayerScreen"-Activity
                startActivity(to_maexlePlayerScreen);
            }
        });

        //go back - Button#
        maexle_welc_back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //go back
                onBackPressed();
            }
        });

    }
}
