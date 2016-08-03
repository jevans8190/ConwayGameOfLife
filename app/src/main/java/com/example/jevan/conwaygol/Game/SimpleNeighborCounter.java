package com.example.jevan.conwaygol.Game;

import java.util.ArrayList;
import java.util.List;

/**
 * Simple implementation of NeighborCounter
 *
 * Created by jevan on 8/2/2016.
 */
public class SimpleNeighborCounter implements NeighborCounter{
    private List<ArrayList<Boolean>> grid;
    int rows; int cols;

    @Override
    public void setPopulation(List<ArrayList<Boolean>> grid) {
        this.grid = grid;
        rows = grid.size();
        cols = (rows == 0) ? 0 : grid.get(0).size();
    }

    @Override
    public int getNeighbors(int x, int y) {
        int aliveNeighbors = 0;
        // Iterate through each neighbor of the cell
        // count number of alive neighbors
        for (int i = (int) Math.max(x-1, 0); i < (int) Math.min(x+2, rows); i++) {
            for (int j = (int) Math.max(y-1,0); j < (int) Math.min(y+2, cols); j++) {
                if (i==x && j==y) continue;
                aliveNeighbors += (grid.get(i).get(j)) ? 1 : 0;
            }
        }
        // return number of alive neighbors
        return aliveNeighbors;
    }
}
