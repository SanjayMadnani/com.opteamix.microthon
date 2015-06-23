/**
 * 
 */
package com.opteamix.microthon.helper;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

import com.opteamix.microthon.enumeration.FruitEnum;
import com.opteamix.microthon.enumeration.LabelEnum;

/**
 * @author smadnani
 *
 */
public class PuzzleHelperTest {

    //TODO logger and comment
    /**
     * Test method for {@link com.opteamix.microthon.helper.PuzzleHelper#getBasket()}.
     */
    @Test
    public final void testGetBasket() {
        Map<LabelEnum, FruitEnum> basket = PuzzleHelper.getBasket();
        for(LabelEnum label : LabelEnum.values()) {
            assertTrue(basket.get(label) instanceof FruitEnum);
        }
    }

}
