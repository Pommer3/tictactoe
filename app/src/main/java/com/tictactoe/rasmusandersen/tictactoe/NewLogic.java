package com.tictactoe.rasmusandersen.tictactoe;

/**
 * Created by rasmusandersen on 09/10/2017.
 */

public class NewLogic {

    public int decideNextMove(State state){
        int bestMove = 0;
        int bestValueMove = Integer.MIN_VALUE;
        if(state.checkFinished() == State.WINNER.NOT_FINISHED){

            for(int i = 1; i <=9; i++){
                if(state.getState().get(i) == State.VALUE.EMPTY){
                    State newState = new State(state);
                    newState.getState().put(i,State.VALUE.PLAYER2);
                    int tempMaxVal = Math.max(bestValueMove,min(newState));
                    if (tempMaxVal>bestValueMove || bestMove == 0){
                        bestMove = i;
                    }
                }
            }
        }

        return bestMove;
    }

    private int min(State state){
        int bestValue = Integer.MAX_VALUE;
        if(state.checkFinished() == State.WINNER.NOT_FINISHED){
            for(int i = 1; i <=9; i++){
                if(state.getState().get(i) == State.VALUE.EMPTY){
                    State newState = new State(state);
                    newState.getState().put(i,State.VALUE.PLAYER1);
                    int tempMaxVal = Math.min(bestValue,max(newState));
                    if (tempMaxVal<bestValue){
                        bestValue = tempMaxVal;
                    }
                }
            }
        }
        else if(state.checkFinished() == State.WINNER.PLAYER1){
            return -3;
        }
        else if(state.checkFinished() == State.WINNER.PLAYER2){
            return 3;
        }
        else if(state.checkFinished() == State.WINNER.DRAW){
            return 0;
        }
        return bestValue;
    }

    private int max(State state){
        int bestValue = Integer.MIN_VALUE;
        if(state.checkFinished() == State.WINNER.NOT_FINISHED){

            for(int i = 1; i <=9; i++){
                if(state.getState().get(i) == State.VALUE.EMPTY){
                    State newState = new State(state);
                    newState.getState().put(i,State.VALUE.PLAYER2);
                    int tempMaxVal = Math.max(bestValue,min(newState));
                    if (tempMaxVal>bestValue){
                        bestValue = tempMaxVal;
                    }
                }
            }
        }
        else if(state.checkFinished() == State.WINNER.PLAYER1){
            return -3;
        }
        else if(state.checkFinished() == State.WINNER.PLAYER2){
            return 3;
        }
        else if(state.checkFinished() == State.WINNER.DRAW){
            return 0;
        }

        return bestValue;
    }
}
