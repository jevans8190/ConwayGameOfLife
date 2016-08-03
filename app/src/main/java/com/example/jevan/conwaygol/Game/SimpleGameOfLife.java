package com.example.jevan.conwaygol.Game;

import java.util.ArrayList;
import java.util.List;

/**
 * Simple implementation of BaseGameOfLife
 *
 * When time-stepping, this game creates a new grid of cells.
 * While iterating through each cell in the previous state, it marks the
 * appropriate value in the next state based on the rules
 *
 * Created by jevan on 8/2/2016.
 */
public class SimpleGameOfLife extends BaseGameOfLife {

    public SimpleGameOfLife(List<ArrayList<Boolean>> grid) {
        super(grid);
        // Initialize neighbor listener
        // set it's initial state
        mNeighborCounter = new SimpleNeighborCounter();
        mNeighborCounter.setPopulation(mGrid);
    }

    @Override
    public void timeStep() {
        // Create a copy of grid
        List<ArrayList<Boolean>> nextGeneration = new ArrayList<ArrayList<Boolean>>(nRows);
        for (int i = 0; i < nRows; i++) {
            List<Boolean> row = mGrid.get(i);
            ArrayList<Boolean> temp = new ArrayList<>();
            for(int j = 0; j < nCols; j++) {
                temp.add(aliveNextRound(row.get(j), mNeighborCounter.getNeighbors(i, j)));
            }
            nextGeneration.add(temp);
        }
        // replace the grid with the new generation
        mGrid = nextGeneration;
    }

    @Override
    public void print() {
        for (int i = 0; i < nRows; i++) {
            List<Boolean> row = mGrid.get(i);
            String line = "";
            for (int j = 0; j < nCols; j++) {
                line += (row.get(j) ? 1 : 0) + " ";
            }
            System.out.println(line);
        }
    }

    /**
     * Determine whether a cell will live based on its current environment.
     *
     * @param alive whether or not the cell is currently alive
     * @param neighbors how many living neighbors the cell has
     * @return whether the cell will be alive in the next state
     */
    private static boolean aliveNextRound(boolean alive, int neighbors) {
        if (alive) {
            return neighbors==2 || neighbors==3;
        } else {
            return neighbors==3;
        }
    }
}
