package com.example.adityagarg.tictactoe;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
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

    public boolean checkResultHelper(Button b1, Button b2, Button b3){

        boolean win;

        if((b1.getText().equals(b2.getText())) && (b2.getText().equals(b3.getText())) && !b1.getText().equals("")) {

            b1.setBackgroundResource(R.color.red);
            b2.setBackgroundResource(R.color.red);
            b3.setBackgroundResource(R.color.red);

            if (b1.getText().equals(playerSymbol)) {
                playerTurn.setText("Player Wins");
                playerScore++;
                playerWinsTextView.setText(playerScore + "");
            }

            else if (b1.getText().equals(computerSymbol)) {
                playerTurn.setText("Computer Wins");
                computerScore++;
                computerWinsTextView.setText(computerScore + "");
            }
            win = true;
        }

        else  win = false;

        return win;
    }

    public void checkResult() {

        aPlayerWon = /* 123 */ (checkResultHelper(buttons[0][0], buttons[0][1], buttons[0][2]))
                     /* 147 */ || (checkResultHelper(buttons[0][0], buttons[1][0], buttons[2][0]))
                     /* 159 */ || (checkResultHelper(buttons[0][0], buttons[1][1], buttons[2][2]))
                     /* 258 */ || (checkResultHelper(buttons[0][1], buttons[1][1], buttons[2][1]))
                     /* 369 */ || (checkResultHelper(buttons[0][2], buttons[1][2], buttons[2][2]))
                     /* 456 */ || (checkResultHelper(buttons[1][0], buttons[1][1], buttons[1][2]))
                     /* 789 */ || (checkResultHelper(buttons[2][0], buttons[2][1], buttons[2][2]))
                     /* 357 */ || (checkResultHelper(buttons[0][2], buttons[1][1], buttons[2][0]));

        if(aPlayerWon) {
            if (playerTurn.getText().toString().equals("Player Wins")) {
                AlertDialog.Builder builder = createAlertDialog("CONGRATULATIONS!!", "You Win \n Start new game?");
                builder.setPositiveButton("OK!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        exchangeSymbols();
                        initialise();
                    }
                })
                        .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                               finish();
                            }
                        });
                builder.create().show();
            }

            else if (playerTurn.getText().toString().equals("Computer Wins")) {
                AlertDialog.Builder builder = createAlertDialog("", "Computer Wins \n Start new game?");
                builder.setPositiveButton("OK!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        exchangeSymbols();
                        initialise();
                    }
                })
                        .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        });
                builder.create().show();
            }


            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++)
                    buttons[i][j].setEnabled(false);
        }

        else if(countOfMoves == 9 && !aPlayerWon){
            countOfMoves = 0;
            playerTurn.setText("Draw");
            numberOfDraws++;
            drawNumberTextView.setText(numberOfDraws + "");

            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++)
                    buttons[i][j].setEnabled(false);
        }
    }


    public void buttonSetting(Button b, String symbol){
        b.setText(symbol);
        b.setEnabled(false);
        b.setBackgroundResource(R.color.lightgray);
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
                        buttonSetting(pressed, computerSymbol);
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


    public AlertDialog.Builder createAlertDialog(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        return builder;
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
                        buttonSetting(pressed, playerSymbol);
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

        switch (item.getItemId()){

            case R.id.action_settings:
            try {
                startActivity(new Intent(this, SettingsActivity.class));
            }catch (Exception e){}
            break;

            case R.id.newGame:
            try {
                AlertDialog.Builder builder = createAlertDialog("NEW GAME", "Start New Game?");
                builder.setPositiveButton("OK!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        exchangeSymbols();
                        initialise();
                    }
                })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                builder.create().show();
            } catch (Exception e) { }
            break;
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