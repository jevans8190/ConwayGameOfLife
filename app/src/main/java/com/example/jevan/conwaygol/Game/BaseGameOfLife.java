package com.example.jevan.conwaygol.Game;

import java.util.ArrayList;
import java.util.List;

/**
 * BaseGame abstract class.
 *
 * All Game implementations should extend this class.
 *
 * Created by jevan on 8/2/2016.
 */
public abstract class BaseGameOfLife {
    protected NeighborCounter mNeighborCounter;
    protected List<ArrayList<Boolean>> mGrid;
    protected int nRows, nCols;

    /**
     * Constructor
     * Stores the grid and its dimensions
     *
     * @param grid 2d List of booleans representing alive/dead cells
     */
    public BaseGameOfLife(List<ArrayList<Boolean>> grid) {
        this.mGrid = grid;
        this.nRows = grid.size();
        this.nCols = (nRows == 0) ? 0 : grid.get(0).size();
    }

    /**
     * Change the alive state based on the rules of
     * Conway's Game of life.
     */
    abstract public void timeStep();

    /**
     * Follow the rules of Conway's Game of Life to figure out
     * the state of a cell after a time-step.
     *
     * @param alive the current alive state of the cell
     * @param neighbors how many living cells border the cell
     * @return the value of the cell in the next state
     */
    private static boolean advance(boolean alive, int neighbors) {
        return alive ? (neighbors == 2 || neighbors == 3) : neighbors == 3;
    }

    /**
     * Getter for mGrid
     *
     * @return mGrid representing alive/dead cells
     */
    public List<ArrayList<Boolean>> getState() {
        return mGrid;
    }

    /**
     * Prints mGrid to the screen
     */
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
}
