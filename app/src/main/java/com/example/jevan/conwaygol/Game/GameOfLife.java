package com.example.jevan.conwaygol.Game;

import java.util.ArrayList;
import java.util.List;

/**
 * Conway's Game of Life
 *
 * Created by Jack Evans on 8/2/2016.
 */
public interface GameOfLife {

    void setInitialState(List<ArrayList<Boolean>> grid);

    List<ArrayList<Boolean>> getState();

    void timeStep();

    /**
     * Print the current state to the screen
     */
    void print();
}

