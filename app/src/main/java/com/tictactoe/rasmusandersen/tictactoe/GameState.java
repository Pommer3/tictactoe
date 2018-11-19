package com.tictactoe.rasmusandersen.tictactoe;

public class GameState {
    private int[][] state = new int[3][3];

    public int[][] getState() {
        return state;
    }

    public void setState(int[][] state) {
        this.state = state;
    }

    public GameState(GameState state){
        this.state = state.getState();
    }

    public GameState(){
        for(int i = 0; i<state.length;i++){
            for(int u = 0; u<state.length;u++){
                state[i][u] = 0;
            }
        }
    }

    public boolean checkFinished(){
        for(int i = 0; i<state.length;i++){
            for(int u = 0; u<state.length;u++){
                if(state[i][u] == 0){
                    return false;}
            }
        }
        return true;
    }

    public int checkWinner(){
        int count = 0;
        int temp = 0;
        //Check horizontal
        for(int i = 0; i<state.length;i++){
            count = 0;
            for(int u = 0; u<state.length;u++){
                if(state[i][u] == temp){
                    count++;
                }
                else{
                    count = 0;
                    temp = state[i][u];
                    count++;
                }
                if (count == 3){
                    if(temp !=0){
                        return temp;
                    }
                }
            }
        }
        //Check Vertical
        for(int i = 0; i<state.length;i++){
            count = 0;
            for(int u = 0; u<state.length;u++){
                if(state[u][i] == temp){
                    count++;
                }
                else{
                    temp = state[u][i];
                    count++;
                }
                if (count == 3){
                    if(temp !=0){
                        return temp;
                    }
                }
            }
        }

        //Check diagonal
        if(state[0][0]==state[1][1]&&state[1][1]==state[2][2]){
            if(state[1][1] !=0){
                return state[1][1];
            }
        }
        if(state[2][0]==state[1][1]&&state[1][1]==state[0][2]){
            if(state[1][1] !=0){
                return state[1][1];
            }
        }

        return 0;

    }


}