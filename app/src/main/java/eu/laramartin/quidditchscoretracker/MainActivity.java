/*
PROJECT LICENSE
This project was submitted by Lara Martín as part of the Nanodegree At Udacity.
As part of Udacity Honor code, your submissions must be your own work, hence
submitting this project as yours will cause you to break the Udacity Honor Code
and the suspension of your account.
Me, the author of the project, allow you to check the code as a reference, but if
you submit it, it's your own responsibility if you get expelled.
Copyright (c) 2017 Lara Martín
Besides the above notice, the following license applies and this license notice
must be included in all works derived from this project.
MIT License
Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:
The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/

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
