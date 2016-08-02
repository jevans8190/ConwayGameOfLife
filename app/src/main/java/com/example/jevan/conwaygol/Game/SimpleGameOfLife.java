package com.example.jevan.conwaygol.Game;

import java.util.List;

/**
 * Simple implementation of GameOfLife
 *
 * When time-stepping, this game makes a copy of the cells,
 * iterates through each cell, and applies changes to the copy
 *
 * Created by jevan on 8/2/2016.
 */
public class SimpleGameOfLife implements GameOfLife{
    private List<List<Boolean>> grid;

    @Override
    public List<List<Boolean>> getState() {
        return null;
    }


    @Override
    public void setState(List<List<Boolean>> grid) {
        this.grid = grid;
    }

    @Override
    public void timeStep() {

    }
}
