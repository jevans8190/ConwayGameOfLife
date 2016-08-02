package com.example.jevan.conwaygol.Game;

import java.util.ArrayList;
import java.util.List;

/**
 * Simple implementation of GameOfLife
 *
 * When time-stepping, this game creates a new grid of cells.
 * While iterating through each cell in the previous state, it marks the
 * appropriate value in the next state based on the rules
 *
 * Created by jevan on 8/2/2016.
 */
public class SimpleGameOfLife implements GameOfLife{
    private List<ArrayList<Boolean>> grid;
    private int rows, cols;

    @Override
    public List<ArrayList<Boolean>> getState() {
        return grid;
    }

    @Override
    public void setInitialState(List<ArrayList<Boolean>> grid) {
        this.grid = grid;
        this.rows = grid.size();
        this.cols = grid.get(0).size();
    }

    @Override
    public void timeStep() {
        // Create a copy of grid
        List<ArrayList<Boolean>> nextGeneration = new ArrayList<>(rows);
        for (List<Boolean> row : grid) {
            nextGeneration.add(new ArrayList<Boolean>(row));
        }

    }

    @Override
    public void print() {
        for (int i = 0; i < rows; i++) {
            List<Boolean> row = grid.get(i);
            String line = "";
            for (int j = 0; j < cols; j++) {
                line += (row.get(j) ? 1 : 0) + " ";
            }
            System.out.println(line);
        }
    }
}
