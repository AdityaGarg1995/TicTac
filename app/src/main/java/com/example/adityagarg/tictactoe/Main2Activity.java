package com.example.adityagarg.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.adityagarg.tictactoe.Settings.SettingsActivity;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    Button buttons[][] = new Button[3][3];

    TextView playerTurn, xScore, xWins, oScore, oWins, draws, drawNumber;

    boolean playerOTurn = true, aPlayerWon = false;

    int playerXScore = 0, playerOScore = 0, numberOfDraws = 0, countOfMoves = 0;


    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            // Show the Up button in the action bar.
            actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setupActionBar();

        buttons[0][0] = (Button) findViewById(R.id.button1);
        buttons[0][1] = (Button) findViewById(R.id.button2);
        buttons[0][2] = (Button) findViewById(R.id.button3);
        buttons[1][0] = (Button) findViewById(R.id.button4);
        buttons[1][1] = (Button) findViewById(R.id.button5);
        buttons[1][2] = (Button) findViewById(R.id.button6);
        buttons[2][0] = (Button) findViewById(R.id.button7);
        buttons[2][1] = (Button) findViewById(R.id.button8);
        buttons[2][2] = (Button) findViewById(R.id.button9);

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                 buttons[i][j].setOnClickListener(this);

        playerTurn = (TextView) findViewById(R.id.playerTurn);

        xScore = (TextView) findViewById(R.id.playerXScore);
        xWins = (TextView) findViewById(R.id.playerX);

        oScore = (TextView) findViewById(R.id.playerOScore);
        oWins = (TextView) findViewById(R.id.playerO);

        draws = (TextView) findViewById(R.id.draws);
        drawNumber = (TextView) findViewById(R.id.drawsNumber);

        initialise();
    }

    @Override
    public void onClick(View v) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (v == buttons[i][j]) {

                    if (buttons[i][j].getText() == "") {
                        if (playerOTurn) {
                            buttons[i][j].setText("O");
                            playerOTurn = false;
                            buttons[i][j].setEnabled(false);
                            buttons[i][j].setBackgroundResource(R.color.lightgray);
                            playerTurn.setText("Player X Turn");
                            countOfMoves++;
                            checkResult();
                        }
                        else if (!playerOTurn) {
                            buttons[i][j].setText("X");
                            playerOTurn = true;
                            buttons[i][j].setEnabled(false);
                            buttons[i][j].setBackgroundResource(R.color.lightgray);
                            playerTurn.setText("Player O Turn");
                            countOfMoves++;
                            checkResult();
                        }
                    }
                    break;
                }

            }
        }
    }

    public void initialise() {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
                buttons[i][j].setEnabled(true);
                buttons[i][j].setBackgroundResource(R.color.deepblue);
            }
        }

        countOfMoves = 0;
        playerOTurn = true;
        aPlayerWon = false;
        playerTurn.setText("Player O Turn");
    }

    public void checkResult() {

        // 123
        if((buttons[0][0].getText().equals(buttons[0][1].getText()))
                && (buttons[0][1].getText().equals(buttons[0][2].getText()))
                && !buttons[0][0].getText().equals("")) {

            if (buttons[0][0].getText().equals("X")) {

                buttons[0][0].setBackgroundResource(R.color.red);
                buttons[0][1].setBackgroundResource(R.color.red);
                buttons[0][2].setBackgroundResource(R.color.red);

                playerTurn.setText("Player X Wins");

                playerXScore++;
                xWins.setText(playerXScore + "");
                aPlayerWon = true;

                for (int i = 0; i < 3; i++)
                    for (int j = 0; j < 3; j++)
                        buttons[i][j].setEnabled(false);

            } else if (buttons[0][0].getText().equals("O")) {

                buttons[0][0].setBackgroundResource(R.color.red);
                buttons[0][1].setBackgroundResource(R.color.red);
                buttons[0][2].setBackgroundResource(R.color.red);

                playerTurn.setText("Player O Wins");

                playerOScore++;
                oWins.setText(playerOScore + "");
                aPlayerWon = true;

                for (int i = 0; i < 3; i++)
                    for (int j = 0; j < 3; j++)
                        buttons[i][j].setEnabled(false);
            }

        // 147
        } else if((buttons[0][0].getText().equals(buttons[1][0].getText()))
                && (buttons[1][0].getText().equals(buttons[2][0].getText()))
                && !buttons[0][0].getText().equals("")) {

            if (buttons[0][0].getText().equals("X")) {

                buttons[0][0].setBackgroundResource(R.color.red);
                buttons[1][0].setBackgroundResource(R.color.red);
                buttons[2][0].setBackgroundResource(R.color.red);

                playerTurn.setText("Player X Wins");

                playerXScore++;
                xWins.setText(playerXScore + "");
                aPlayerWon = true;

                for (int i = 0; i < 3; i++)
                    for (int j = 0; j < 3; j++)
                        buttons[i][j].setEnabled(false);

            } else if (buttons[0][0].getText().equals("O")) {

                buttons[0][0].setBackgroundResource(R.color.red);
                buttons[1][0].setBackgroundResource(R.color.red);
                buttons[2][0].setBackgroundResource(R.color.red);

                playerTurn.setText("Player O Wins");

                playerOScore++;
                oWins.setText(playerOScore + "");
                aPlayerWon = true;

                for (int i = 0; i < 3; i++)
                    for (int j = 0; j < 3; j++)
                        buttons[i][j].setEnabled(false);
            }

        // 258
        } else if((buttons[0][1].getText().equals(buttons[1][1].getText()))
                && (buttons[1][1].getText().equals(buttons[2][1].getText()))
                && !buttons[0][1].getText().equals("")) {

            if (buttons[0][1].getText().equals("X")) {

                buttons[0][1].setBackgroundResource(R.color.red);
                buttons[1][1].setBackgroundResource(R.color.red);
                buttons[2][1].setBackgroundResource(R.color.red);

                playerTurn.setText("Player X Wins");

                playerXScore++;
                xWins.setText(playerXScore + "");
                aPlayerWon = true;

                for (int i = 0; i < 3; i++)
                    for (int j = 0; j < 3; j++)
                        buttons[i][j].setEnabled(false);

            } else if (buttons[0][1].getText().equals("O")) {

                buttons[0][1].setBackgroundResource(R.color.red);
                buttons[1][1].setBackgroundResource(R.color.red);
                buttons[2][1].setBackgroundResource(R.color.red);

                playerTurn.setText("Player O Wins");

                playerOScore++;
                oWins.setText(playerOScore + "");
                aPlayerWon = true;

                for (int i = 0; i < 3; i++)
                    for (int j = 0; j < 3; j++)
                        buttons[i][j].setEnabled(false);
            }

        // 369
        } else if((buttons[0][2].getText().equals(buttons[1][2].getText()))
                && (buttons[1][2].getText().equals(buttons[2][2].getText()))
                && !buttons[0][2].getText().equals("")) {

            if (buttons[0][2].getText().equals("X")) {

                buttons[0][2].setBackgroundResource(R.color.red);
                buttons[1][2].setBackgroundResource(R.color.red);
                buttons[2][2].setBackgroundResource(R.color.red);

                playerTurn.setText("Player X Wins");

                playerXScore++;
                xWins.setText(playerXScore + "");
                aPlayerWon = true;

                for (int i = 0; i < 3; i++)
                    for (int j = 0; j < 3; j++)
                        buttons[i][j].setEnabled(false);

            } else if (buttons[0][2].getText().equals("O")) {

                buttons[0][2].setBackgroundResource(R.color.red);
                buttons[1][2].setBackgroundResource(R.color.red);
                buttons[2][2].setBackgroundResource(R.color.red);

                playerTurn.setText("Player O Wins");

                playerOScore++;
                oWins.setText(playerOScore + "");
                aPlayerWon = true;

                for (int i = 0; i < 3; i++)
                    for (int j = 0; j < 3; j++)
                        buttons[i][j].setEnabled(false);
            }

        // 456
        }else if((buttons[1][0].getText().equals(buttons[1][1].getText()))
                && (buttons[1][1].getText().equals(buttons[1][2].getText()))
                && !buttons[1][0].getText().equals("")) {

            if (buttons[1][0].getText().equals("X")) {

                buttons[1][0].setBackgroundResource(R.color.red);
                buttons[1][1].setBackgroundResource(R.color.red);
                buttons[1][2].setBackgroundResource(R.color.red);

                playerTurn.setText("Player X Wins");

                playerXScore++;
                xWins.setText(playerXScore + "");
                aPlayerWon = true;

                for (int i = 0; i < 3; i++)
                    for (int j = 0; j < 3; j++)
                        buttons[i][j].setEnabled(false);

            } else if (buttons[1][0].getText().equals("O")) {

                buttons[1][0].setBackgroundResource(R.color.red);
                buttons[1][1].setBackgroundResource(R.color.red);
                buttons[1][2].setBackgroundResource(R.color.red);

                playerTurn.setText("Player O Wins");

                playerOScore++;
                oWins.setText(playerOScore + "");

                for (int i = 0; i < 3; i++)
                    for (int j = 0; j < 3; j++)
                        buttons[i][j].setEnabled(false);
            }
        // 789
        }else if((buttons[2][0].getText().equals(buttons[2][1].getText()))
                && (buttons[2][1].getText().equals(buttons[2][2].getText()))
                && !buttons[2][0].getText().equals("")) {

                if (buttons[2][0].getText().equals("X")) {

                    buttons[2][0].setBackgroundResource(R.color.red);
                    buttons[2][1].setBackgroundResource(R.color.red);
                    buttons[2][2].setBackgroundResource(R.color.red);

                    playerTurn.setText("Player X Wins");

                    playerXScore++;
                    xWins.setText(playerXScore + "");
                    aPlayerWon = true;

                    for (int i = 0; i < 3; i++)
                        for (int j = 0; j < 3; j++)
                            buttons[i][j].setEnabled(false);

                } else if (buttons[2][0].getText().equals("O")) {

                    buttons[2][0].setBackgroundResource(R.color.red);
                    buttons[2][1].setBackgroundResource(R.color.red);
                    buttons[2][2].setBackgroundResource(R.color.red);

                    playerTurn.setText("Player O Wins");

                    playerOScore++;
                    oWins.setText(playerOScore + "");
                    aPlayerWon = true;

                    for (int i = 0; i < 3; i++)
                        for (int j = 0; j < 3; j++)
                            buttons[i][j].setEnabled(false);
                }


        // 159
        }else if((buttons[0][0].getText().equals(buttons[1][1].getText()))
                && (buttons[1][1].getText().equals(buttons[2][2].getText()))
                && !buttons[0][0].getText().equals("")) {

                if (buttons[0][0].getText().equals("X")) {

                    buttons[0][0].setBackgroundResource(R.color.red);
                    buttons[1][1].setBackgroundResource(R.color.red);
                    buttons[2][2].setBackgroundResource(R.color.red);

                    playerTurn.setText("Player X Wins");

                    playerXScore++;
                    xWins.setText(playerXScore + "");
                    aPlayerWon = true;

                    for (int i = 0; i < 3; i++)
                        for (int j = 0; j < 3; j++)
                            buttons[i][j].setEnabled(false);
                }
                else if (buttons[0][0].getText().equals("O")) {

                    buttons[0][0].setBackgroundResource(R.color.red);
                    buttons[1][1].setBackgroundResource(R.color.red);
                    buttons[2][2].setBackgroundResource(R.color.red);

                    playerTurn.setText("Player O Wins");

                    playerOScore++;
                    oWins.setText(playerOScore + "");
                    aPlayerWon = true;

                    for (int i = 0; i < 3; i++)
                        for (int j = 0; j < 3; j++)
                            buttons[i][j].setEnabled(false);
                }


                // 357
        }else if((buttons[0][2].getText().equals(buttons[1][1].getText()))
                && (buttons[1][1].getText().equals(buttons[2][0].getText()))
                && !buttons[0][2].getText().equals("")){

            if(buttons[0][2].getText().equals("X")){

                buttons[0][2].setBackgroundResource(R.color.red);
                buttons[1][1].setBackgroundResource(R.color.red);
                buttons[2][0].setBackgroundResource(R.color.red);

                playerTurn.setText("Player X Wins");

                playerXScore++;
                xWins.setText(playerXScore + "");
                aPlayerWon = true;

                for (int i = 0; i < 3; i++)
                    for (int j = 0; j < 3; j++)
                        buttons[i][j].setEnabled(false);
            }
            else if(buttons[0][2].getText().equals("O")){

                buttons[2][0].setBackgroundResource(R.color.red);
                buttons[1][1].setBackgroundResource(R.color.red);
                buttons[0][2].setBackgroundResource(R.color.red);

                playerTurn.setText("Player O Wins");

                playerOScore++;
                oWins.setText(playerOScore + "");
                aPlayerWon = true;

                for (int i = 0; i < 3; i++)
                    for (int j = 0; j < 3; j++)
                        buttons[i][j].setEnabled(false);
            }
        }

        else if(countOfMoves == 9 && !aPlayerWon){
            countOfMoves = 0;
            playerTurn.setText("Draw");
            numberOfDraws++;
            drawNumber.setText(numberOfDraws + "");
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        }
        else if(id == R.id.newGame){
            initialise();
            return true;
        }
        else if(id == R.id.exit){
            System.exit(0);
            return true;
        }
        else if(id == R.id.onePlayer){
            finish();
            startActivity(new Intent(this, OnePlayerActivity.class));
            return true;
        }
        else if(id == R.id.twoPlayer){
        }
        return super.onOptionsItemSelected(item);
    }
}