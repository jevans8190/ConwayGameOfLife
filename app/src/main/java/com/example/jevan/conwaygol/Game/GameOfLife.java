package com.example.jevan.conwaygol.Game;

import java.util.List;

/**
 * Conway's Game of Life
 *
 * Created by Jack Evans on 8/2/2016.
 */
public interface GameOfLife {

    void setState(List<List<Boolean>> grid);

    List<List<Boolean>> getState();

    void timeStep();
}

