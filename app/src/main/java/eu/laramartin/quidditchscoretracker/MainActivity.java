package eu.laramartin.quidditchscoretracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    int score_a = 0;
    int score_b = 0;
    boolean check_if_win = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addTenToA(View view) {
        score_a += 10;
        TextView score = (TextView) findViewById(R.id.team_a_score);
        score.setText(String.valueOf(score_a));
        if (check_if_win){
            checkIfWin();
        }
    }

    public void addTenToB(View view) {
        score_b += 10;
        TextView score = (TextView) findViewById(R.id.team_b_score);
        score.setText(String.valueOf(score_b));
        if (check_if_win){
            checkIfWin();
        }
    }

    public void snitchA(View view) {
        score_a += 150;
        check_if_win = true;
        TextView score = (TextView) findViewById(R.id.team_a_score);
        score.setText(String.valueOf(score_a));
        checkIfWin();
    }
    public void snitchB(View view) {
        score_b += 150;
        check_if_win = true;
        TextView score = (TextView) findViewById(R.id.team_b_score);
        score.setText(String.valueOf(score_b));
        checkIfWin();
    }

    public void reset(View view) {
        score_a = 0;
        score_b = 0;
        check_if_win = false;
        TextView scoreA = (TextView) findViewById(R.id.team_a_score);
        scoreA.setText(String.valueOf(score_a));
        TextView scoreB = (TextView) findViewById(R.id.team_b_score);
        scoreB.setText(String.valueOf(score_b));
    }

    public void checkIfWin(){
        if (score_a != score_b){
            if (score_a > score_b){
                Toast.makeText(MainActivity.this, "Team A wins!", Toast.LENGTH_SHORT).show();
                check_if_win = false;
            } else if (score_a < score_b){
                Toast.makeText(MainActivity.this, "Team B wins!", Toast.LENGTH_SHORT).show();
                check_if_win = false;
            } else if (score_a == score_b){
                Toast.makeText(MainActivity.this, "Continue Playing!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
