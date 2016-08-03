package com.example.jevan.conwaygol.Game;

import java.util.ArrayList;
import java.util.List;

/**
 * SmartNeighborCounter
 *
 * Created by jevan on 8/2/2016.
 */
public class SmartNeighborCounter implements NeighborCounter {
    private int[][] mNeighborGrid;
    private int rows, cols;

    public SmartNeighborCounter() {}

    @Override
    public void setPopulation(List<ArrayList<Boolean>> grid) {
        rows = grid.size();
        cols = (rows == 0) ? 0 : grid.get(0).size();
        // initialize mNeighborGrid to rows x cols zeros
        mNeighborGrid = new int[rows][cols];
        parseGrid2Neighbors(grid);
    }

    @Override
    public int getNeighbors(int x, int y) {
        return mNeighborGrid[x][y];
    }

    private void parseGrid2Neighbors(List<ArrayList<Boolean>> grid) {
        int a, b, c, d;
        b=c=0;
        for (int i = 0; i < rows-1; i++) {
            for (int j = 0; j < cols-1; j++) {
                // convert each of the living states to ints
                if (j > 0) {
                    a = b;
                    d = c;
                } else {
                    a = grid.get(i).get(j) ? 1 : 0;
                    d = grid.get(i+1).get(j) ? 1 : 0;
                }
                b = grid.get(i).get(j+1) ? 1 : 0;
                c = grid.get(i+1).get(j+1) ? 1 : 0;
                // add the neighbors
                if (i == 0) {
                    mNeighborGrid[i][j] += b;
                    mNeighborGrid[i][j + 1] += a;
                } if (j == 0) {
                    mNeighborGrid[i][j] += d;
                    mNeighborGrid[i + 1][j] += a;
                }
                mNeighborGrid[i][j] += c;
                mNeighborGrid[i][j + 1] += c + d;
                mNeighborGrid[i + 1][j + 1] += a + b + d;
                mNeighborGrid[i + 1][j] += b + c;
            }
        }
    }
}
