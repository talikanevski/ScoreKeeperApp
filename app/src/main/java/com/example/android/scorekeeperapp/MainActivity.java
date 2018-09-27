package com.example.android.scorekeeperapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import android.view.Gravity;
import android.view.Menu;


import com.example.android.scorekeeperapp.R;

public class MainActivity extends AppCompatActivity {

    private TextView scoreView1;
    private TextView scoreView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreView1 = (TextView) findViewById(R.id.player_1_score);
        scoreView2 = (TextView) findViewById(R.id.player_2_score);

        displayForPlayer1(0);
        displayForPlayer2(0);
    }

    int scorePlayer1 = 0;
    int scorePlayer2 = 0;

    /**
     * Displays the given score for Player 1.
     */
    public void displayForPlayer1(int score) {
        if (score >= 21) {
            score = 21;
            Toast.makeText(this, "We have a winner!",
                    Toast.LENGTH_LONG).show();
        }

        if (score<=0){
            score = 0;
            Toast.makeText(this, "You can not go below zero!",
                    Toast.LENGTH_SHORT).show();
        }

        scoreView1.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Player 2.
     */
    public void displayForPlayer2(int score) {
        if (score >= 21) {
            score = 21;
            Toast.makeText(this, "We have a winner!",
                    Toast.LENGTH_LONG).show();
        }
        if (score<=0){
            score = 0;
            Toast.makeText(this, "You can not go below zero!",
                    Toast.LENGTH_SHORT).show();
        }
        scoreView2.setText(String.valueOf(score));
    }

    public void onClick(View v) {

        switch (v.getId()) {

             //buttons of player 1

            case R.id.plus1PointBenefitPlayer1: //"win" button
                scorePlayer1 = scorePlayer1 + 1;
                displayForPlayer1(scorePlayer1);
                break;

            case R.id.faultPlus1PointBenefitPlayer2: //"fault" button
                scorePlayer2 = scorePlayer2 + 1;
                displayForPlayer2(scorePlayer2);
                break;

            case R.id.redCardPlayer1: // "red cart 1" button
                scorePlayer1 = scorePlayer1 - 1;
                displayForPlayer1(scorePlayer1);
                break;

            case R.id.player2Win: // "red card 2" button
                scorePlayer1 = 0;
                scorePlayer2 = 21;
                displayForPlayer1(scorePlayer1);
                displayForPlayer2(scorePlayer2);
                break;

            //buttons of player 2

            case R.id.plus1PointBenefitPlayer2: //"win" button
                scorePlayer2 = scorePlayer2 + 1;
                displayForPlayer2(scorePlayer2);
                break;

            case R.id.faultPlus1PointBenefitPlayer1: //"fault" button
                scorePlayer1 = scorePlayer1 + 1;
                displayForPlayer1(scorePlayer1);
                break;

            case R.id.redCardPlayer2:  // "red cart 1" button
                scorePlayer2 = scorePlayer2 - 1;
                displayForPlayer2(scorePlayer2);
                break;

            case R.id.player1Win: // "red card 2" button
                scorePlayer2 = 0;
                scorePlayer1 = 21;
                displayForPlayer1(scorePlayer1);
                displayForPlayer2(scorePlayer2);
                break;
        }
    }

    public void resetMethod(View v) { //"play again" button
        scorePlayer1 = 0;
        scorePlayer2 = 0;
        displayForPlayer1(0);
        displayForPlayer2(0);
    }

}
