package de.dicegamesmix.dicegamesmix;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;

        import java.util.List;

        import io.paperdb.Paper;

public class MaexleThrowMiddle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maexle_throw_middle);

        TextView middle_player_name = (TextView) findViewById(R.id.middle_player_name);
        TextView middle_answer = (TextView) findViewById(R.id. middle_answer);
        TextView middle_result_number = (TextView) findViewById(R.id.middle_result_number);
        Button middle_uncover_btn = (Button) findViewById(R.id.middle_uncover_btn);
        Button middle_throw_btn = (Button) findViewById(R.id.middle_throw_btn);
        Button middle_back_btn = (Button) findViewById(R.id.middle_back_btn);

        int index = 0;

        final Intent maexle_answerPlayer = new Intent(getApplicationContext(), MaexleAnswerPlayer.class);
        final Intent maexle_answerUncover = new Intent(getApplicationContext(), MaexleAnswerUncover.class);
        final Intent back_to_menu = new Intent(getApplicationContext(), MainActivity.class);

        //read index
        index = Paper.book().read("index");

        //import all names
        List<String> playerNames = Paper.book().read("Players");
        //take the one you need with the index
        String playername = playerNames.get(index);
        middle_player_name.setText(playername);

        middle_answer.setText("answer from"+ playerNames.get(index-1));

        middle_uncover_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(maexle_answerUncover);
            }
        });

        middle_throw_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(maexle_answerPlayer);
            }
        });

        middle_back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(back_to_menu);
            }
        });
    }
}
