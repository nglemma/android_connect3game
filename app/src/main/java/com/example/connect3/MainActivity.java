package com.example.connect3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    int activeplayer=0;
    int[] gamestate={2,2,2,2,2,2,2,2,2};
    int[][] winningpositions={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    boolean gameactive = true;


    public void dropin (View view)
    {
        ImageView counter = (ImageView) view;

        int tappedcounter = Integer.parseInt(counter.getTag().toString());


        if (gamestate[tappedcounter] == 2 && gameactive)
        {
            counter.setTranslationY(-1500);
            gamestate[tappedcounter] = activeplayer;
            if (activeplayer == 0)
            {
                counter.setImageResource(R.drawable.yellow);
                activeplayer = 1;
            }
            else
                {
                counter.setImageResource(R.drawable.red);
                activeplayer = 0;
                }
            counter.animate().translationYBy(1500).setDuration(300);

            for (int winningposition[] : winningpositions)
            {
                if (gamestate[winningposition[0]] == gamestate[winningposition[1]] && gamestate[winningposition[1]] == gamestate[winningposition[2]] && gamestate[winningposition[0]] != 2)
                {
                    String winner = "";
                    gameactive=false;

                    if (activeplayer == 1)
                    {
                        winner = "Yellow";
                    }
                    else
                        {
                        winner = "Red";
                        }

                    TextView winnereditText = findViewById(R.id.winnerTextView);
                    Button playagainbutton = findViewById(R.id.playagainbutton);
                    winnereditText.setText(winner + " has won!");
                    playagainbutton.setVisibility(View.VISIBLE);
                    winnereditText.setVisibility(View.VISIBLE);
                }
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
