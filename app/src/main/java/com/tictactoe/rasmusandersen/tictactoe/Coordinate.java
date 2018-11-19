package com.tictactoe.rasmusandersen.tictactoe;

/**
 * Created by rasmusandersen on 24/08/2017.
 */
public class Coordinate {
    private Integer column;
    private Integer row;

    Coordinate(Integer column, Integer row){
        this.column = column;
        this.row = row;

    }
    public Integer getColumn(){
        return column;
    }
    public Integer getRow(){
        return row;
    }

}