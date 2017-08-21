package com.tictactoe.rasmusandersen.tictactoe;

/**
 * Created by rasmusandersen on 20/08/2017.
 */
public class TicTacToeState {
    private int [][] gameState = new int[3][3];

    public TicTacToeState(){
        for (int i = 0; i<3; i++){
            for (int u = 0; u<3; u++){
               gameState[i][u] = 0;
            }
        }
    }
}
