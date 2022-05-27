package android.tangleddroid.roger.android_udacity.scorekeeper;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import android.tangleddroid.roger.R;

public class ScorekeeperActivity extends AppCompatActivity {

    private int scoreTeamA = 0, scoreTeamB = 0;
    private int wicketTeamA = 0, wicketTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scorekeeper);
    }

    // Save UI state changes to the savedInstanceState.
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // This bundle will be passed to onCreate if the process is
        // killed and restarted.
        savedInstanceState.putInt("scoreTeamA", scoreTeamA);
        savedInstanceState.putInt("scoreTeamB", scoreTeamB);
        savedInstanceState.putInt("wicketTeamA", wicketTeamA);
        savedInstanceState.putInt("wicketTeamB", wicketTeamB);
        super.onSaveInstanceState(savedInstanceState);
    }
    //onRestoreInstanceState
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.
        scoreTeamA = savedInstanceState.getInt("scoreTeamA");
        scoreTeamB = savedInstanceState.getInt("scoreTeamB");
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        wicketTeamA = savedInstanceState.getInt("wicketTeamA");
        wicketTeamB = savedInstanceState.getInt("wicketTeamB");
        displayWicketForTeamA(wicketTeamA);
        displayWicketForTeamB(wicketTeamB);
    }

    public void addSixforTeamA(View view) {
        scoreTeamA = scoreTeamA + 6;
        displayForTeamA(scoreTeamA);
    }

    public void addFourforTeamA(View view) {
        scoreTeamA = scoreTeamA + 4;
        displayForTeamA(scoreTeamA);
    }

    public void addOneforTeamA(View view) {
        scoreTeamA = scoreTeamA + 1;
        displayForTeamA(scoreTeamA);
    }

    public void addWicketforTeamA(View view) {
        if(wicketTeamA < 10) {
            wicketTeamA = wicketTeamA + 1;
        }else {
            wicketTeamA = 11;
        }
        displayWicketForTeamA(wicketTeamA);
    }

    public void addSixforTeamB(View view) {
        scoreTeamB = scoreTeamB + 6;
        displayForTeamB(scoreTeamB);
    }

    public void addFourforTeamB(View view) {
        scoreTeamB = scoreTeamB + 4;
        displayForTeamB(scoreTeamB);
    }

    public void addOneforTeamB(View view) {
        scoreTeamB = scoreTeamB + 1;
        displayForTeamB(scoreTeamB);
    }

    public void addWicketforTeamB(View view) {
        if(wicketTeamB < 10) {
            wicketTeamB = wicketTeamB + 1;
        } else {
            wicketTeamB = 11;
        }
        displayWicketForTeamB(wicketTeamB);
    }

    public void resetScore(View view) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        wicketTeamA = 0;
        wicketTeamB = 0;
        displayWicketForTeamA(wicketTeamA);
        displayWicketForTeamB(wicketTeamB);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the amount of wickets for Team A.
     */
    public void displayWicketForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_wicket);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the amount of wickets for Team B.
     */
    public void displayWicketForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_wicket);
        scoreView.setText(String.valueOf(score));
    }
}