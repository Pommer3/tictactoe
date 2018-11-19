package com.tictactoe.rasmusandersen.tictactoe;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rasmusandersen on 09/10/2017.
 */

public class State {

    public enum VALUE {PLAYER1, PLAYER2, EMPTY}

    public enum WINNER {PLAYER1, PLAYER2, DRAW, NOT_FINISHED }

    private Map<Integer, VALUE> state = new HashMap<Integer,VALUE>();

    //Normal constructor
    public State() {
        for (int i = 1; i <= 9; i++) {
            state.put(i, VALUE.EMPTY);
        }
    }

    //Copy constructor
    public State(State oldState){
        this.state = deepCopy(oldState.getState());
    }
    private WINNER valueWithWinner(VALUE val){
        if(val==VALUE.PLAYER1){
            return WINNER.PLAYER1;
        }
        if(val==VALUE.PLAYER2) {
            return WINNER.PLAYER2;
        }
        return null;
    }

    public WINNER checkFinished(){
        //Horizontal checks:
       if(state.get(1)==state.get(2)&&state.get(2)==state.get(3)){
           if(state.get(1) != VALUE.EMPTY) {
               return valueWithWinner(state.get(1));
           }
       }
       if(state.get(4)==state.get(5)&&state.get(5)==state.get(6)){
           if(state.get(4) != VALUE.EMPTY) {
               return valueWithWinner(state.get(4));
           }
       }
       if(state.get(7)==state.get(8)&&state.get(8)==state.get(9)){
           if(state.get(7) != VALUE.EMPTY) {
               return valueWithWinner(state.get(7));
           }
       }
       //Vertical checks:
       if(state.get(1)==state.get(4)&&state.get(4)==state.get(7)){
           if(state.get(1) != VALUE.EMPTY) {
               return valueWithWinner(state.get(1));
           }
       }
       if(state.get(2)==state.get(5)&&state.get(5)==state.get(8)){
           if(state.get(2) != VALUE.EMPTY) {
               return valueWithWinner(state.get(2));
           }
       }
       if(state.get(3)==state.get(6)&&state.get(6)==state.get(9)){
           if(state.get(3) != VALUE.EMPTY) {
               return valueWithWinner(state.get(3));
           }
       }
        //Diagonal checks
       if(state.get(1)==state.get(5)&&state.get(5)==state.get(9)){
           if(state.get(1) != VALUE.EMPTY) {
               return valueWithWinner(state.get(1));
           }
       }
       if(state.get(3)==state.get(5)&&state.get(5)==state.get(7)){
           if(state.get(3) != VALUE.EMPTY) {
               return valueWithWinner(state.get(3));
           }
       }
       for(int i = 1; i<=9; i++){
           if(state.get(i)==VALUE.EMPTY){
               return WINNER.NOT_FINISHED;
           }
       }
       return WINNER.DRAW;
    }

    public Map<Integer, VALUE> getState() {
        return state;
    }

    public void setState(Map<Integer, VALUE> state) {
        this.state = state;
    }

    private <K, V> Map <K, V> deepCopy (Map<K, V> original){

        Map<K, V> copy = new HashMap<K, V>();

        for(Map.Entry<K, V> entry : original.entrySet()){

            copy.put(entry.getKey(), entry.getValue());
        }
        return copy;
    }

}
