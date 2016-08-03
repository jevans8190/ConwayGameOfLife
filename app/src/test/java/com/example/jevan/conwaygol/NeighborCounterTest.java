package com.example.jevan.conwaygol;

import com.example.jevan.conwaygol.Game.NeighborCounter;
import com.example.jevan.conwaygol.Game.SimpleNeighborCounter;
import com.google.common.collect.Lists;
import com.google.common.primitives.Booleans;
import com.google.common.primitives.Ints;

import junit.framework.TestCase;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Tests for accuracy and performance of the NeighborCounter implementations
 *
 * Created by jevan on 8/2/2016.
 */
public class NeighborCounterTest extends TestCase {
    protected List<ArrayList<Boolean>> testGrid1;
    protected List<ArrayList<Integer>> neighborsGrid1;
    protected NeighborCounter simple;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        // Declare NeighborCounters
        simple = new SimpleNeighborCounter();
        // Setup test grid 1
        // Values  Neighbors
        // 0 1 0    2 2 2
        // 1 0 1    2 4 2
        // 0 1 0    2 2 2
        testGrid1 = new ArrayList<>(Lists.newArrayList(
                new ArrayList<>(Booleans.asList(false, true, false)),
                new ArrayList<>(Booleans.asList(true, false, true)),
                new ArrayList<>(Booleans.asList(false, true, false))
        ));
        neighborsGrid1 = new ArrayList<>(Lists.newArrayList(
                new ArrayList<>(Ints.asList(2, 2, 2)),
                new ArrayList<>(Ints.asList(2, 4, 2)),
                new ArrayList<>(Ints.asList(2, 2, 2))
        ));
    }

    @Test
    public void testCountNeighbors() throws Exception {
        simple.setPopulation(testGrid1);
        for (int i = 0; i < testGrid1.size(); i++) {
            List<Boolean> row = testGrid1.get(1);
            for (int j = 0; j < row.size(); j++) {
                System.out.print(simple.getNeighbors(i,j) + " ");
            }
            System.out.println("");
        }
    }
}
