package com.example.jevan.conwaygol;

import com.example.jevan.conwaygol.Game.NeighborCounter;
import com.example.jevan.conwaygol.Game.SimpleNeighborCounter;
import com.example.jevan.conwaygol.Game.SmartNeighborCounter;
import com.google.common.collect.Lists;
import com.google.common.primitives.Booleans;
import com.google.common.primitives.Ints;

import junit.framework.TestCase;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Tests for accuracy and performance of the NeighborCounter implementations
 *
 * Created by jevan on 8/2/2016.
 */
public class NeighborCounterTest extends TestCase {
    protected List<ArrayList<Boolean>> testGrid1;
    protected List<ArrayList<Integer>> neighborsGrid1;
    protected NeighborCounter[] counters;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        // Declare NeighborCounters
        counters = new NeighborCounter[]{
                new SimpleNeighborCounter(),
                new SmartNeighborCounter()
        };
        // Setup test grid 1
        testGrid1 = new ArrayList<>(Lists.newArrayList(
                new ArrayList<>(Booleans.asList(false, false, true, true, false)),  // 0 0 1 1 0
                new ArrayList<>(Booleans.asList(true, true, true, false, true)),    // 1 1 1 0 1
                new ArrayList<>(Booleans.asList(false, false, false, true, false))  // 0 0 0 1 0
        ));
        neighborsGrid1 = new ArrayList<>(Lists.newArrayList(
                new ArrayList<>(Ints.asList(2, 4, 3, 3, 2)),
                new ArrayList<>(Ints.asList(1, 3, 4, 5, 2)),
                new ArrayList<>(Ints.asList(2, 3, 3, 2, 2))
        ));
    }

    @Test
    public void testCountNeighbors() throws Exception {
        for (NeighborCounter c : counters) {
            c.setPopulation(testGrid1);
        }
        for (int i = 0; i < neighborsGrid1.size(); i++) {
            for (int j = 0; j < neighborsGrid1.get(0).size(); j++) {
                for (NeighborCounter c : counters) {
                    assertEquals(c.getNeighbors(i, j), (int) neighborsGrid1.get(i).get(j));
                }
            }
        }
    }

    @Test
    public void testPerformance() throws Exception {
        // create test array of random booleans
        // time how long each counter takes to compute each cell
        int testX, testY;
        testX = testY = 10000;
        Random random = new Random();
        List<ArrayList<Boolean>> test = new ArrayList<>(testX);
        Boolean[] temp;
        for (int i = 0; i < testX; i++) {
            temp = new Boolean[testY];
            for (int j = 0; j < testY; j++){
                temp[j] = random.nextBoolean();
            }
            test.add(new ArrayList<>(Arrays.asList(temp)));
        }
        for (NeighborCounter c : counters) {
            c.setPopulation(test);
            long timeStart = System.currentTimeMillis();
            for (int i = 0; i < testX; i++) {
                for (int j = 0; j < testY; j++) {
                    c.getNeighbors(i, j);
                }
            }
            long timeEnd = System.currentTimeMillis();
            System.out.println(c.getClass().getSimpleName() + ": " + (timeEnd - timeStart));
        }
    }
}
