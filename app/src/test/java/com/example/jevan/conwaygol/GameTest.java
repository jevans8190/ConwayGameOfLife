package com.example.jevan.conwaygol;

import com.example.jevan.conwaygol.Game.GameOfLife;
import com.example.jevan.conwaygol.Game.SimpleGameOfLife;
import com.google.common.collect.Lists;
import com.google.common.primitives.Booleans;

import junit.framework.TestCase;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Tests GameOfLife functionality for each implementation
 *
 * Created by jevan on 8/2/2016.
 */
public class GameTest extends TestCase {
    private List<GameOfLife> games;
    private List<ArrayList<Boolean>> initial1;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        // create games
        games = new ArrayList<>(Lists.newArrayList(
                (GameOfLife) new SimpleGameOfLife()
        ));
        // set up initial states
        initial1 = new ArrayList<>(Lists.newArrayList(
                new ArrayList<>(Booleans.asList(true, false, false)),   // 1 0 0
                new ArrayList<>(Booleans.asList(false, true, false)),   // 0 1 0
                new ArrayList<>(Booleans.asList(true, false, true))     // 1 0 1
        ));
        // set the initial state in each game
        for (GameOfLife g : games) {
            g.setInitialState(initial1);
        }
    }

    @Test
    public void testTimeStep1() throws Exception {
        // define the correct next state of initial1
        List<ArrayList<Boolean>> correct = new ArrayList<>(Lists.newArrayList(
                new ArrayList<>(Booleans.asList(false, false, false)),  // 0 0 0
                new ArrayList<>(Booleans.asList(true, true, false)),    // 1 1 0
                new ArrayList<>(Booleans.asList(false, true, false))    // 0 1 0
        ));
        // time-step each game
        // compare new state with correct
        for (GameOfLife g : games) {
            System.out.println("Initial:");
            g.print();
            g.timeStep();
            System.out.println("Next gen:");
            g.print();
            compareStates(g.getState(), correct);
        }
        System.out.println("Pass!");
    }

    public void compareStates(List<ArrayList<Boolean>> result, List<ArrayList<Boolean>> correct) {
        // make sure dimensions are the same
        int rows = result.size();
        int cols = (rows==0) ? 0 : result.get(0).size();
        assertEquals(rows, correct.size());
        assertEquals(cols, correct.get(0).size());
        // compare each index in each row
        for (int i = 0; i < rows; i++) {
            List<Boolean> rRow = result.get(i);
            List<Boolean> cRow = correct.get(i);
            for (int j = 0; j < cols; j++) {
                assertEquals(rRow.get(j), cRow.get(j));
            }
        }
    }
}
