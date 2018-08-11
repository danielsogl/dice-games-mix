package de.dicegamesmix.dicegamesmix;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.widget.Button;
        import android.widget.TextView;

public class MaexleThrowMiddle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maexle_throw_middle);

        TextView middle_player_name = (TextView) findViewById(R.id.middle_player_name);
        TextView middle_result = (TextView) findViewById(R.id. middle_result);
        TextView middle_result_number = (TextView) findViewById(R.id.middle_result_number);
        Button middle_uncover_btn = (Button) findViewById(R.id.middle_uncover_btn);
        Button middle_throw_btn = (Button) findViewById(R.id.middle_throw_btn);
        Intent maexle_answerPlayer = new Intent(getApplicationContext(), MaexleAnswerPlayer.class);
        Intent maexle_answerUncover = new Intent(getApplicationContext(), MaexleAnswerUncover.class);
    }
}
