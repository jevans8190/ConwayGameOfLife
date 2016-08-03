package com.example.jevan.conwaygol.Game;

import java.util.ArrayList;
import java.util.List;

/**
 * Cell data implementation of BaseGameOfLife
 *
 *
 * Created by jevan on 8/2/2016.
 */
public class CellDataGame extends BaseGameOfLife{
    private List<ArrayList<GridCell>> grid;

    @Override
    public List<ArrayList<Boolean>> getState() {
        return null;
    }


    public CellDataGame(List<ArrayList<Boolean>> grid) {
        super(grid);
    }

    @Override
    public void timeStep() {

    }

    @Override
    public void print() {

    }

    /**
     * Gridcell (Inner class for CellDataGame)
     *
     * Stores data for each cell in the grid
     */
    class GridCell {
        private int x, y;
        private int neighbors;
        private boolean value;

        public GridCell(int x, int y) {
            this(x, y, false, 0);
        }

        public GridCell(int x, int y, boolean value) {
            this(x, y, value, 0);
        }

        public GridCell(int x, int y, boolean value, int neighbors) {
            this.x = x;
            this.y = y;
            this.value = value;
            this.neighbors = neighbors;
        }
    }
}
