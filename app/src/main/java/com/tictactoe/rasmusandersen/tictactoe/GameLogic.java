package com.tictactoe.rasmusandersen.tictactoe;

import java.util.Map;

/**
 * Created by rasmusandersen on 20/08/2017.
 */
public class GameLogic {

    public Coordinate init(TicTacToeState state){
        Coordinate action = null;
        int currentValueOfAction = 0;


        for (Map.Entry<Coordinate,TicTacOrToe> item : state.getNotSelected().entrySet()){
            TicTacToeState tempState = new TicTacToeState(state);
            tempState.getSelected().put(item.getKey(),item.getValue());
            tempState.getNotSelected().remove(item.getKey());
            int temp = Math.max(min(tempState),currentValueOfAction);
            if (temp>currentValueOfAction){
                currentValueOfAction = temp;
                action = item.getKey();
            }
        }
    return action;


    }

    private int min(TicTacToeState state){
            TicTacToeState newState = null;
            int currentValueOfAction = 0;
            if(state.getNotSelected().isEmpty()){
                return onFinished(state);
            }

            for (Map.Entry<Coordinate,TicTacOrToe> item : state.getNotSelected().entrySet()){
                TicTacToeState tempState = new TicTacToeState(state);
                tempState.getSelected().put(item.getKey(),item.getValue());
                tempState.getNotSelected().remove(item.getKey());
                int temp = Math.max(max(tempState),currentValueOfAction);
                if (temp>currentValueOfAction){
                    currentValueOfAction= temp;
                    newState = tempState;
                }
            }
        return currentValueOfAction;
    }
    private int max(TicTacToeState state){
            TicTacToeState newState = null;
            int currentValueOfAction = 0;
            if(state.getNotSelected().isEmpty()){
                return onFinished(state);
            }
            for (Map.Entry<Coordinate,TicTacOrToe> item : state.getNotSelected().entrySet()){
                TicTacToeState tempState = new TicTacToeState(state);
                tempState.getSelected().put(item.getKey(),item.getValue());
                tempState.getNotSelected().remove(item.getKey());
                int temp = Math.max(min(tempState),currentValueOfAction);
                if (temp>currentValueOfAction){
                    currentValueOfAction= temp;
                    newState = tempState;
                }
            }
        return currentValueOfAction;
    }


    private int onFinished(TicTacToeState state){
         TicTacToeState.GameWon value = checkFinished(state);
         if (value == TicTacToeState.GameWon.DRAW)
             return 0;
         if(value== TicTacToeState.GameWon.TACWIN)
             return 1;
         if(value==TicTacToeState.GameWon.TICWIN)
             return -1;
        return 0;
    }


    //Method to check whether the game is finished
    private TicTacToeState.GameWon checkFinished(TicTacToeState state){
        int countTicHor = 0;
        int countTicVert = 0;
        int countTicDia = 0;
        int countTacDia = 0;
        int countTacHor = 0;
        int countTacVert = 0;
        Coordinate [] cord = new Coordinate[10];
        int count = 0;
        for (Map.Entry<Coordinate,TicTacOrToe> item : state.getSelected().entrySet()){
            cord[count] = item.getKey();
            count++;
        }

        for (int i = 0; i<3; i++){
            for (int u = 0; u<3; u++){
                Coordinate cordIs = null;
                for (int y = 0; y<9; y++){
                    if(cord[y].getColumn()==i&&cord[y].getRow()==u){
                        cordIs = cord[y];
                    }
                }
                if (state.getSelected().get(cordIs).getState() == TicTacToeState.Tictac.TAC){
                    countTacVert++;
                    countTicVert = 0;
                }
                if (state.getSelected().get(cordIs).getState() == TicTacToeState.Tictac.TIC){
                    countTacVert = 0;
                    countTicVert++;
                }
                if (state.getSelected().get(cordIs).getState() == TicTacToeState.Tictac.EMPTY){
                    countTicVert = 0;
                    countTacVert = 0;
                }
                if(countTicVert == 3){
                    return TicTacToeState.GameWon.TICWIN;
                }
                if(countTacVert==3){
                    return TicTacToeState.GameWon.TACWIN;
                }
            }
        }
        for (int i = 0; i<3; i++){
            for (int u = 0; u<3; u++){

                Coordinate cordIs = null;
                for (int y = 0; y<9; y++){
                    if(cord[y].getColumn()==u&&cord[y].getRow()==i){
                        cordIs = cord[y];
                    }
                }

                if (state.getSelected().get(cordIs).getState() == TicTacToeState.Tictac.TAC){
                    countTacHor++;
                    countTicHor = 0;
                }
                if (state.getSelected().get(cordIs).getState() == TicTacToeState.Tictac.TIC){
                    countTacHor = 0;
                    countTicHor++;
                }
                if (state.getSelected().get(cordIs).getState() == TicTacToeState.Tictac.EMPTY){
                    countTicHor = 0;
                    countTacHor = 0;
                }
                if(countTicHor == 3){
                    return TicTacToeState.GameWon.TICWIN;
                }
                if(countTacHor==3){
                    return TicTacToeState.GameWon.TACWIN;
                }
            }
        }
        if(state.getSelected().get(cord[0]).getState().equals(state.getSelected().get(cord[4]).getState().equals(state.getSelected().get(cord[9]).getState()))){
            if(state.getSelected().get(new Coordinate(0,0)).getState() == TicTacToeState.Tictac.TAC) {
                return TicTacToeState.GameWon.TACWIN;
            }
            if(state.getSelected().get(cord[0]).getState() == TicTacToeState.Tictac.TIC){
                return TicTacToeState.GameWon.TICWIN;
            }
        }
        if(state.getSelected().get(cord[7]).getState().equals(state.getSelected().get(cord[4]).getState().equals(state.getSelected().get(cord[2]).getState()))){
            if(state.getSelected().get(cord[7]).getState() == TicTacToeState.Tictac.TAC) {
                return TicTacToeState.GameWon.TACWIN;
            }
            if(state.getSelected().get(cord[7]).getState() == TicTacToeState.Tictac.TIC){
                return TicTacToeState.GameWon.TICWIN;
            }
        }

        if(!state.getNotSelected().isEmpty()){
            return TicTacToeState.GameWon.NOT_FINISHED;
        }

        return TicTacToeState.GameWon.DRAW;


    }
}
