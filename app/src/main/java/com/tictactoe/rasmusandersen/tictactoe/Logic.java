package com.tictactoe.rasmusandersen.tictactoe;

import java.util.Map;

/**
 * Created by rasmusandersen on 05/09/2017.
 */

public class Logic {


    public int init(GameState state){
        int action = 0;
        int currentValueOfAction = 0;

        int count = 0;
        for (int i = 0; i<3; i++) {
            for (int u = 0; u < 3; u++) {
                GameState tempState = new GameState(state);
                if (state.getState()[i][u]==0) {
                    int temp = Math.max(min(tempState), currentValueOfAction);
                    if (temp > currentValueOfAction) {
                        currentValueOfAction = temp;
                        action = count;
                    }
                }
                count++;
            }
        }
        return action;


    }

    private int min(GameState state){
        GameState newState = null;
        int currentValueOfAction = 0;
        if(state.checkFinished()){
            return onFinished(state.checkWinner());
        }

        int count = 0;
        for (int i = 0; i<3; i++) {
            for (int u = 0; u < 3; u++) {
                GameState tempState = new GameState(state);
                if (state.getState()[i][u]==0) {
                    int temp = Math.min(max(tempState), currentValueOfAction);
                    if (temp < currentValueOfAction) {
                        currentValueOfAction = temp;
                        newState = tempState;
                    }
                }
                count++;
            }
        }
        return currentValueOfAction;
    }
    private int max(GameState state){
        GameState newState = null;
        int currentValueOfAction = 0;
        if(state.checkFinished()){
            return onFinished(state.checkWinner());
        }

        int count = 0;
        for (int i = 0; i<3; i++) {
            for (int u = 0; u < 3; u++) {
                GameState tempState = new GameState(state);
                if (state.getState()[i][u]==0) {
                    int temp = Math.max(min(tempState), currentValueOfAction);
                    if (temp > currentValueOfAction) {
                        currentValueOfAction = temp;
                        newState = tempState;
                    }
                }
                count++;
            }
        }
        return currentValueOfAction;
    }


    private int onFinished(int winner){
        if (winner == 0)
            return 0;
        if (winner == 1)
            return 1;
        if (winner == 2)
            return -1;
        return 0;
    }


    //Method to check whether the game is finished

}
