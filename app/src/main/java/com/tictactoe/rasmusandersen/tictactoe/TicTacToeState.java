package com.tictactoe.rasmusandersen.tictactoe;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rasmusandersen on 20/08/2017.
 */
public class TicTacToeState {
    public enum Tictac {TIC, TAC, EMPTY};
    private Map <Coordinate,TicTacOrToe> notSelected = new HashMap<>();
    private Map <Coordinate,TicTacOrToe> Selected = new HashMap<>();

    public enum GameWon {TICWIN, TACWIN, DRAW, NOT_FINISHED};

    public TicTacToeState(){
        for (int i = 0; i<3; i++){
            for (int u = 0; u<3; u++){
               Coordinate cord = new Coordinate(i,u);
               TicTacOrToe tictac = new TicTacOrToe();

                Selected.put(cord,tictac);
                notSelected.put(cord,tictac);

            }
        }
    }
    public TicTacToeState(TicTacToeState state){
        this.notSelected = state.getNotSelected();
        this.Selected = state.getSelected();
    }


    public Map<Coordinate, TicTacOrToe> getNotSelected() {
        return notSelected;
    }

    public void setNotSelected(Map<Coordinate, TicTacOrToe> notSelected) {
        this.notSelected = notSelected;
    }

    public Map<Coordinate, TicTacOrToe> getSelected() {
        return Selected;
    }

    public void setSelected(Map<Coordinate, TicTacOrToe> selected) {
        Selected = selected;
    }
}
