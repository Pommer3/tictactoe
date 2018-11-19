package com.tictactoe.rasmusandersen.tictactoe;

/**
 * Created by rasmusandersen on 24/08/2017.
 */
public class TicTacOrToe{
    private TicTacToeState.Tictac state = TicTacToeState.Tictac.EMPTY;

    public TicTacOrToe(){
        state = TicTacToeState.Tictac.EMPTY;
    }
    public TicTacOrToe(TicTacToeState.Tictac state){
        this.state = state;
    }

    public void setState(TicTacToeState.Tictac newState) {
        this.state = newState;
    }
    public TicTacToeState.Tictac getState (){
        return state;
    }
}