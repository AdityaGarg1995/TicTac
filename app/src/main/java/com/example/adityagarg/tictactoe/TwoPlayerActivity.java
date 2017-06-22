package com.example.adityagarg.tictactoe;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
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

public class TwoPlayerActivity extends AppCompatActivity implements View.OnClickListener {

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
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_player);

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


    public void buttonSetting(Button b, String symbol){
        b.setText(symbol);
        b.setEnabled(false);
        b.setBackgroundResource(R.color.lightgray);

        countOfMoves++;
        checkResult();

        playerOTurn = !playerOTurn;
    }


    @Override
    public void onClick(View v) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (v == buttons[i][j] && buttons[i][j].getText() == "") {
                    if (playerOTurn) {
                        buttonSetting(buttons[i][j], "O");
                        playerTurn.setText("Player X Turn");
                    }
                    else if (!playerOTurn) {
                        buttonSetting(buttons[i][j], "X");
                        playerTurn.setText("Player O Turn");
                    }
                }
                break;
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


    public AlertDialog.Builder createAlertDialog(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        return builder;
    }


    public boolean checkResultHelper(Button b1, Button b2, Button b3){

        boolean win;
        String symbol = b1.getText().toString();

        if((b1.getText().equals(b2.getText()))
                && (b2.getText().equals(b3.getText()))
                && !b1.getText().equals("")) {

            b1.setBackgroundResource(R.color.red);
            b2.setBackgroundResource(R.color.red);
            b3.setBackgroundResource(R.color.red);


            if (symbol.equals("X")) {
                playerXScore++;
                xWins.setText(playerXScore + "");
            }

            else if (symbol.equals("O")) {
                playerOScore++;
                oWins.setText(playerOScore + "");
            }
            playerTurn.setText("Player" + symbol + "Wins");
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
                AlertDialog.Builder builder = createAlertDialog("CONGRATULATIONS!!",
                                                                 playerTurn.getText().toString() + " \n Start new game?");
                builder.setPositiveButton("OK!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
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

                for (int i = 0; i < 3; i++)
                    for (int j = 0; j < 3; j++)
                        buttons[i][j].setEnabled(false);
        }

        else if(countOfMoves == 9 && !aPlayerWon){
            countOfMoves = 0;
            playerTurn.setText("Draw");
            numberOfDraws++;
            drawNumber.setText(numberOfDraws + "");

            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++)
                    buttons[i][j].setEnabled(false);

            AlertDialog.Builder builder = createAlertDialog("DRAW!!",
                                                            "The game is a draw \n Start new game?");
            builder.setPositiveButton("OK!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
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

            //noinspection SimplifiableIfStatement
            case R.id.action_settings:
                try {
                    startActivity(new Intent(this, SettingsActivity.class));
                } catch (Exception e){ }
                break;

            case R.id.newGame:
                try {
                    AlertDialog.Builder builder = createAlertDialog("NEW GAME", "Start New Game?");
                    builder.setPositiveButton("OK!", new DialogInterface.OnClickListener() {
                               @Override
                               public void onClick(DialogInterface dialog, int which) {
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