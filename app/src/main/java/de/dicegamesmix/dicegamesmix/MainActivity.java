package de.dicegamesmix.dicegamesmix;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import io.paperdb.Paper;

public class MainActivity extends AppCompatActivity {

    //objects and variables
    ListView mainMenu_ListView;
    String[] gameNames;
    String[] gameDescriptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize library
        Paper.init(this);

        //objects and variables
        Resources res = getResources();
        mainMenu_ListView = (ListView) findViewById(R.id.mainMenu_ListView);
        gameNames = res.getStringArray(R.array.gameNames);
        gameDescriptions = res.getStringArray(R.array.gameDescriptions);

        //set up the ItemAdapter (self created class)
        ItemAdapter adapter_mainMenu = new ItemAdapter(this, gameNames, gameDescriptions);
        mainMenu_ListView.setAdapter(adapter_mainMenu);

        //intent to open the other games
        final Intent maexle_welcomeScreen = new Intent(getApplicationContext(), MaexleWelcomeScreen.class);
        final Intent dice_game = new Intent(getApplicationContext(), Dice.class);

        //this 'thing' ensures, that we are able to click on the cells of our list
        mainMenu_ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //reacts depending on the clicked item of the list
                //'i' shows the clicked item
                if (i == 0) {
                    //open Mäxle
                    startActivity(maexle_welcomeScreen);
                } else if (i == 1) {
                    //open SimpleDice
                    startActivity(dice_game);
                }

            }
        });
    }
}
