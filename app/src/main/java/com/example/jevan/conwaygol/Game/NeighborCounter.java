package com.example.jevan.conwaygol.Game;

import java.util.ArrayList;
import java.util.List;

/**
 * Defines the NeighborCounter interface
 *
 * Created by jevan on 8/2/2016.
 */
public interface NeighborCounter {

    /**
     * Set the population, which is a 2d List of booleans
     * representing alive/dead cells to count neighbors of
     */
    void getPopulation(List<ArrayList<Boolean>> grid);

    /**
     * Counts neighbors touching a given cell
     *
     * @param x cell's row index
     * @param y cell's column index
     * @return number alive cells touching cell(x, y)
     */
    int getNeighbors(int x, int y);
}
