/**
 * 
 */
package com.opteamix.microthon;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.opteamix.microthon.exception.ApplicationException;

/**
 * @author smadnani
 *
 */
public class BasketPuzzleGameTest {

    private BasketPuzzleGame basketGame;
    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        basketGame = new BasketPuzzleGame();
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
        basketGame = null;
    }

    /**
     * Test method for {@link com.opteamix.microthon.BasketPuzzleGame#basketPuzzleGame()}.
     */
    @Test
    public final void testBasketPuzzleGame() {
        try {
            basketGame.basketPuzzleGame();
        } catch (ApplicationException e) {
            fail(e.getMessage());
            e.printStackTrace();
        }
    }

}
