package eu.laramartin.quidditchscoretracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int scoreA = 0;
    int scoreB = 0;
    boolean endGame = false;
    boolean snitchFound = false;
    TextView scoreAView;
    TextView scoreBView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scoreAView = (TextView) findViewById(R.id.team_a_score);
        scoreBView = (TextView) findViewById(R.id.team_b_score);
    }

    public void addTenToA(View view) {
        if (endGame) {
            reset(view);
        }
        scoreA += 10;
        scoreAView.setText(String.valueOf(scoreA));
        checkIfWin();
    }

    public void addTenToB(View view) {
        if (endGame) {
            reset(view);
        }
        scoreB += 10;
        scoreBView.setText(String.valueOf(scoreB));
        checkIfWin();
    }

    public void snitchA(View view) {
        if (endGame) {
            reset(view);
        }
        scoreA += 150;
        snitchFound = true;
        scoreAView.setText(String.valueOf(scoreA));
        checkIfWin();
    }

    public void snitchB(View view) {
        if (endGame) {
            reset(view);
        }
        scoreB += 150;
        snitchFound = true;
        scoreBView.setText(String.valueOf(scoreB));
        checkIfWin();
    }

    public void reset(View view) {
        scoreA = 0;
        scoreB = 0;
        endGame = false;
        snitchFound = false;
        scoreAView.setText(String.valueOf(this.scoreA));
        scoreBView.setText(String.valueOf(this.scoreB));
    }

    public void checkIfWin(){
        if (!snitchFound){
            return;
        }
        if (scoreA != scoreB){
            if (scoreA > scoreB){
                Toast.makeText(MainActivity.this, "Team A wins!", Toast.LENGTH_SHORT).show();
                endGame = true;
            } else if (scoreA < scoreB){
                Toast.makeText(MainActivity.this, "Team B wins!", Toast.LENGTH_SHORT).show();
                endGame = true;
            }
        } else {
            Toast.makeText(MainActivity.this, "Continue Playing!", Toast.LENGTH_SHORT).show();
            endGame = false;
        }
    }
}
