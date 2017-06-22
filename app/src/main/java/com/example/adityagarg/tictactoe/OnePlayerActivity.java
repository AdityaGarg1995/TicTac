package com.example.adityagarg.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.adityagarg.tictactoe.Settings.SettingsActivity;

import java.util.ArrayList;
import java.util.Random;

public class OnePlayerActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttons[][] = new Button[3][3], newGame, exit;

    TextView playerTurn,
             playerScoreTextView,
             playerWinsTextView,
             computerScoreTextView,
             computerWinsTextView,
             drawsTextView,
             drawNumberTextView;

    boolean humanTurn = true,
            aPlayerWon = false;

    int playerScore = 0,
        computerScore = 0,
        numberOfDraws = 0,
        countOfMoves = 0,
        min = 0,
        max = 8;


    ArrayList<Button> availableButtons = new ArrayList<>();

    String playerSymbol, computerSymbol;

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            // Show the Up button in the action bar.
            actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_player);

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

        playerScoreTextView = (TextView) findViewById(R.id.playerXScore);
        playerWinsTextView = (TextView) findViewById(R.id.playerX);

        computerScoreTextView = (TextView) findViewById(R.id.playerOScore);
        computerWinsTextView = (TextView) findViewById(R.id.playerO);

        drawsTextView = (TextView) findViewById(R.id.draws);
        drawNumberTextView = (TextView) findViewById(R.id.drawsNumber);

        playerScoreTextView.setText("Player Score");
        computerScoreTextView.setText("Computer Score");

        playerSymbol = "O";
        computerSymbol = "X";

        initialise();
    }


    public void checkResult() {

        // 123
        if ((buttons[0][0].getText().equals(buttons[0][1].getText()))
                && (buttons[0][1].getText().equals(buttons[0][2].getText()))
                && !buttons[0][0].getText().equals("")) {

            if (buttons[0][0].getText().equals(playerSymbol)) {

                buttons[0][0].setBackgroundResource(R.color.red);
                buttons[0][1].setBackgroundResource(R.color.red);
                buttons[0][2].setBackgroundResource(R.color.red);

                playerTurn.setText("Player Wins");

                playerScore++;
                playerWinsTextView.setText(playerScore + "");
                aPlayerWon = true;

                for (int i = 0; i < 3; i++)
                    for (int j = 0; j < 3; j++)
                        buttons[i][j].setEnabled(false);

            } else if (buttons[0][0].getText().equals(computerSymbol)) {

                buttons[0][0].setBackgroundResource(R.color.red);
                buttons[0][1].setBackgroundResource(R.color.red);
                buttons[0][2].setBackgroundResource(R.color.red);

                playerTurn.setText("Computer Wins");

                computerScore++;
                computerWinsTextView.setText(computerScore + "");
                aPlayerWon = true;

                for (int i = 0; i < 3; i++)
                    for (int j = 0; j < 3; j++)
                        buttons[i][j].setEnabled(false);
            }
            // 147
        }

        else if ((buttons[0][0].getText().equals(buttons[1][0].getText()))
                && (buttons[1][0].getText().equals(buttons[2][0].getText()))
                && !buttons[0][0].getText().equals("")) {

            if (buttons[0][0].getText().equals(playerSymbol)) {

                buttons[0][0].setBackgroundResource(R.color.red);
                buttons[1][0].setBackgroundResource(R.color.red);
                buttons[2][0].setBackgroundResource(R.color.red);

                playerTurn.setText("Player Wins");

                playerScore++;
                playerWinsTextView.setText(playerScore + "");
                aPlayerWon = true;

                for (int i = 0; i < 3; i++)
                    for (int j = 0; j < 3; j++)
                        buttons[i][j].setEnabled(false);

            } else if (buttons[0][0].getText().equals(computerSymbol)) {

                buttons[0][0].setBackgroundResource(R.color.red);
                buttons[1][0].setBackgroundResource(R.color.red);
                buttons[2][0].setBackgroundResource(R.color.red);

                playerTurn.setText("Computer Wins");

                computerScore++;
                computerWinsTextView.setText(computerScore + "");
                aPlayerWon = true;

                for (int i = 0; i < 3; i++)
                    for (int j = 0; j < 3; j++)
                        buttons[i][j].setEnabled(false);
            }
            // 258
        }

        else if ((buttons[0][1].getText().equals(buttons[1][1].getText()))
                && (buttons[1][1].getText().equals(buttons[2][1].getText()))
                && !buttons[0][1].getText().equals("")) {

            if (buttons[0][1].getText().equals(playerSymbol)) {

                buttons[0][1].setBackgroundResource(R.color.red);
                buttons[1][1].setBackgroundResource(R.color.red);
                buttons[2][1].setBackgroundResource(R.color.red);

                playerTurn.setText("Player Wins");

                playerScore++;
                playerWinsTextView.setText(playerScore + "");
                aPlayerWon = true;

                for (int i = 0; i < 3; i++)
                    for (int j = 0; j < 3; j++)
                        buttons[i][j].setEnabled(false);

            } else if (buttons[0][1].getText().equals(computerSymbol)) {

                buttons[0][1].setBackgroundResource(R.color.red);
                buttons[1][1].setBackgroundResource(R.color.red);
                buttons[2][1].setBackgroundResource(R.color.red);

                playerTurn.setText("Computer Wins");

                computerScore++;
                computerWinsTextView.setText(computerScore + "");
                aPlayerWon = true;

                for (int i = 0; i < 3; i++)
                    for (int j = 0; j < 3; j++)
                        buttons[i][j].setEnabled(false);
            }
            // 369
        }
        else if ((buttons[0][2].getText().equals(buttons[1][2].getText()))
                && (buttons[1][2].getText().equals(buttons[2][2].getText()))
                && !buttons[0][2].getText().equals("")) {

            if (buttons[0][2].getText().equals(playerSymbol)) {

                buttons[0][2].setBackgroundResource(R.color.red);
                buttons[1][2].setBackgroundResource(R.color.red);
                buttons[2][2].setBackgroundResource(R.color.red);

                playerTurn.setText("Player Wins");

                playerScore++;
                playerWinsTextView.setText(playerScore + "");
                aPlayerWon = true;

                for (int i = 0; i < 3; i++)
                    for (int j = 0; j < 3; j++)
                        buttons[i][j].setEnabled(false);

            } else if (buttons[0][2].getText().equals(computerSymbol)) {

                buttons[0][2].setBackgroundResource(R.color.red);
                buttons[1][2].setBackgroundResource(R.color.red);
                buttons[2][2].setBackgroundResource(R.color.red);

                playerTurn.setText("Computer Wins");

                computerScore++;
                computerWinsTextView.setText(computerScore + "");
                aPlayerWon = true;

                for (int i = 0; i < 3; i++)
                    for (int j = 0; j < 3; j++)
                        buttons[i][j].setEnabled(false);
            }
            // 456
        }
        else if ((buttons[1][0].getText().equals(buttons[1][1].getText()))
                && (buttons[1][1].getText().equals(buttons[1][2].getText()))
                && !buttons[1][0].getText().equals("")) {

            if (buttons[1][0].getText().equals(playerSymbol)) {

                buttons[1][0].setBackgroundResource(R.color.red);
                buttons[1][1].setBackgroundResource(R.color.red);
                buttons[1][2].setBackgroundResource(R.color.red);

                playerTurn.setText("Player Wins");

                playerScore++;
                playerWinsTextView.setText(playerScore + "");
                aPlayerWon = true;

                for (int i = 0; i < 3; i++)
                    for (int j = 0; j < 3; j++)
                        buttons[i][j].setEnabled(false);

            } else if (buttons[1][0].getText().equals(computerSymbol)) {

                buttons[1][0].setBackgroundResource(R.color.red);
                buttons[1][1].setBackgroundResource(R.color.red);
                buttons[1][2].setBackgroundResource(R.color.red);

                playerTurn.setText("Computer Wins");

                computerScore++;
                computerWinsTextView.setText(computerScore + "");

                for (int i = 0; i < 3; i++)
                    for (int j = 0; j < 3; j++)
                        buttons[i][j].setEnabled(false);
            }
            // 789
        } else if ((buttons[2][0].getText().equals(buttons[2][1].getText()))
                && (buttons[2][1].getText().equals(buttons[2][2].getText()))
                && !buttons[2][0].getText().equals("")) {

            if (buttons[2][0].getText().equals(playerSymbol)) {

                buttons[2][0].setBackgroundResource(R.color.red);
                buttons[2][1].setBackgroundResource(R.color.red);
                buttons[2][2].setBackgroundResource(R.color.red);

                playerTurn.setText("Player Wins");

                playerScore++;
                playerWinsTextView.setText(playerScore + "");
                aPlayerWon = true;

                for (int i = 0; i < 3; i++)
                    for (int j = 0; j < 3; j++)
                        buttons[i][j].setEnabled(false);

            } else if (buttons[2][0].getText().equals(computerSymbol)) {

                buttons[2][0].setBackgroundResource(R.color.red);
                buttons[2][1].setBackgroundResource(R.color.red);
                buttons[2][2].setBackgroundResource(R.color.red);

                playerTurn.setText("Computer Wins");

                computerScore++;
                computerWinsTextView.setText(computerScore + "");
                aPlayerWon = true;

                for (int i = 0; i < 3; i++)
                    for (int j = 0; j < 3; j++)
                        buttons[i][j].setEnabled(false);
            }
            // 159
        } else if ((buttons[0][0].getText().equals(buttons[1][1].getText()))
                && (buttons[1][1].getText().equals(buttons[2][2].getText()))
                && !buttons[0][0].getText().equals("")) {

            if (buttons[0][0].getText().equals(playerSymbol)) {

                buttons[0][0].setBackgroundResource(R.color.red);
                buttons[1][1].setBackgroundResource(R.color.red);
                buttons[2][2].setBackgroundResource(R.color.red);

                playerTurn.setText("Player Wins");

                playerScore++;
                playerWinsTextView.setText(playerScore + "");
                aPlayerWon = true;

                for (int i = 0; i < 3; i++)
                    for (int j = 0; j < 3; j++)
                        buttons[i][j].setEnabled(false);

            } else if (buttons[0][0].getText().equals(computerSymbol)) {

                buttons[0][0].setBackgroundResource(R.color.red);
                buttons[1][1].setBackgroundResource(R.color.red);
                buttons[2][2].setBackgroundResource(R.color.red);

                playerTurn.setText("Computer Wins");

                computerScore++;
                computerWinsTextView.setText(computerScore + "");
                aPlayerWon = true;

                for (int i = 0; i < 3; i++)
                    for (int j = 0; j < 3; j++)
                        buttons[i][j].setEnabled(false);
            }
            // 357
        }
        else if ((buttons[0][2].getText().equals(buttons[1][1].getText()))
                && (buttons[1][1].getText().equals(buttons[2][0].getText()))
                && !buttons[0][2].getText().equals("")) {

            if (buttons[0][2].getText().equals(playerSymbol)) {

                buttons[0][2].setBackgroundResource(R.color.red);
                buttons[1][1].setBackgroundResource(R.color.red);
                buttons[2][0].setBackgroundResource(R.color.red);

                playerTurn.setText("Player Wins");

                playerScore++;
                playerWinsTextView.setText(playerScore + "");
                aPlayerWon = true;

                for (int i = 0; i < 3; i++)
                    for (int j = 0; j < 3; j++)
                        buttons[i][j].setEnabled(false);

            } else if (buttons[0][2].getText().equals(computerSymbol)) {

                buttons[2][0].setBackgroundResource(R.color.red);
                buttons[1][1].setBackgroundResource(R.color.red);
                buttons[0][2].setBackgroundResource(R.color.red);

                playerTurn.setText("Computer Wins");

                computerScore++;
                computerWinsTextView.setText(computerScore + "");
                aPlayerWon = true;

                for (int i = 0; i < 3; i++)
                    for (int j = 0; j < 3; j++)
                        buttons[i][j].setEnabled(false);

            }
        }
        else if (countOfMoves == 9 && !aPlayerWon) {
            playerTurn.setText("Draw");
            numberOfDraws++;
            drawNumberTextView.setText(numberOfDraws + "");
        }
    }



    @Override
    public void onClick(View v) {

        Button pressed = (Button) v;
        if(!aPlayerWon) {
            if (humanTurn) {
                for (int i = 0; i < availableButtons.size(); i++) {
                    if (pressed.equals(availableButtons.get(i)) && !pressed.getBackground().equals(R.color.lightgray)) {
                        humanTurn = false;
                        countOfMoves++;
                        pressed.setText(playerSymbol);
                        pressed.setEnabled(false);
                        pressed.setBackgroundResource(R.color.lightgray);
                        playerTurn.setText("Computer's Turn");
                        checkResult();
                        computersTurn();
                        break;
                    }
                }
            }
            else if (!humanTurn) {
//            Do Nothing
            }
        }

    }

    public void computersTurn() {

        Random ranNum = new Random();
        final int number = min + ranNum.nextInt(max - min);
//        final double x = Math.random() * availableButtons.size();

        final Button pressed = availableButtons.get(number);
        final Handler handler = new Handler();

        if(!aPlayerWon) {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Do something after 1s = 1000ms
                    humanTurn = true;
                    if (pressed.isEnabled() && !pressed.getBackground().equals(R.color.lightgray)) {
                        pressed.setText(computerSymbol);
                        pressed.setEnabled(false);
                        pressed.setBackgroundResource(R.color.lightgray);
                        playerTurn.setText("Player's Turn");
                        countOfMoves++;
                        checkResult();
                    }
                    else  computersTurn();
                }
            }, 1000);
        }

    }


    public void initialise() {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
                buttons[i][j].setEnabled(true);
                buttons[i][j].setBackgroundResource(R.color.deepblue);
                availableButtons.add(buttons[i][j]);
            }
        }

        countOfMoves = 0;
        humanTurn = true;
        aPlayerWon = false;
        playerTurn.setText("Player's Turn");
    }


    public void exchangeSymbols(){
        String temp = playerSymbol;
        playerSymbol = computerSymbol;
        computerSymbol = temp;
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
            try {
                startActivity(new Intent(this, SettingsActivity.class));
            }catch (Exception e){}
            return true;
        }

        if (id == R.id.newGame) {
            try {
                exchangeSymbols();
                initialise();
            }catch (Exception e){}
            return true;
        }
        else if (id == R.id.exit) {
            System.exit(0);
            return true;
        }
        else if(id == R.id.onePlayer){

        }
        else if(id == R.id.twoPlayer){
            try {
                finish();
                startActivity(new Intent(this, Main2Activity.class));
            } catch (Exception e){}
            return true;
        }
        return super.onOptionsItemSelected(item);
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
}