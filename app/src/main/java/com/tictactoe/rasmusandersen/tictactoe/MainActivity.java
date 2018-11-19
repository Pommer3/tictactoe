package com.tictactoe.rasmusandersen.tictactoe;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Initiate view
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final NewLogic gameLogic = new NewLogic();
        final Bool chosenTic = new Bool(true);
        final State state = new State();

        final int [][] valuesToCords = new int[3][3];
        int count = 1;
        for (int i = 0; i<=2; i++){
            for(int u = 0; u<=2; u++){
                valuesToCords[i][u]= count;
                count++;
            }
        }
        //Initiate game with state
        final ImageView [][] imgs = new ImageView[3][3];
        imgs[0][0] = (ImageView) findViewById(R.id.tic1);
        imgs[0][1] = (ImageView) findViewById(R.id.tic2);
        imgs[0][2] = (ImageView) findViewById(R.id.tic3);
        imgs[1][0] = (ImageView) findViewById(R.id.tic4);
        imgs[1][1] = (ImageView) findViewById(R.id.tic5);
        imgs[1][2] = (ImageView) findViewById(R.id.tic6);
        imgs[2][0] = (ImageView) findViewById(R.id.tic7);
        imgs[2][1] = (ImageView) findViewById(R.id.tic8);
        imgs[2][2] = (ImageView) findViewById(R.id.tic9);

        for (int i = 0; i < 3; i++){
            for (int u = 0; u < 3; u++){
                final int one = i;
                final int two = u;
                imgs[i][u].setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v)
                    {

                        if(state.getState().get(valuesToCords[one][two]) != State.VALUE.EMPTY){

                        }
                        else{


                        if(chosenTic.isTrue()) {
                            imgs[one][two].setImageResource(R.drawable.tic);

                            int columntoSetComp = 0;
                            int rowToSetComp = 0;
                            int valueOfMove;
                            state.getState().put(valuesToCords[one][two], State.VALUE.PLAYER1);
                            valueOfMove = gameLogic.decideNextMove(state);
                            state.getState().put(valueOfMove,State.VALUE.PLAYER2);

                            for (int y = 0; y<=2; y++){
                                for(int x = 0; x<=2; x++){
                                    if(valuesToCords[y][x] == valueOfMove){
                                        columntoSetComp = y;
                                        rowToSetComp = x;
                                    }
                                }
                            }

                                imgs[columntoSetComp][rowToSetComp].setImageResource(R.drawable.tac);
                        }
                        else {
                            imgs[one][two].setImageResource(R.drawable.tac);

                            int columntoSetComp = 0;
                            int rowToSetComp = 0;
                            int valueOfMove = 1;
                            state.getState().put(valuesToCords[one][two], State.VALUE.PLAYER1);
                            valueOfMove = gameLogic.decideNextMove(state);
                            state.getState().put(valueOfMove,State.VALUE.PLAYER2);

                            for (int y = 0; y<=2; y++){
                                for(int x = 0; x<=2; x++){
                                    if(valuesToCords[y][x] == valueOfMove){
                                        columntoSetComp = y;
                                        rowToSetComp = x;
                                    }
                                }
                            }

                                imgs[columntoSetComp][rowToSetComp].setImageResource(R.drawable.tic);

                        }
                        }


                    }
                });
            }
        }


    }
    private void makeCompChoice(){


    }
}
