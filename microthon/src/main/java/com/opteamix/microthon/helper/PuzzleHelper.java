/**
 * 
 */
package com.opteamix.microthon.helper;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.opteamix.microthon.enumeration.FruitEnum;
import com.opteamix.microthon.enumeration.LabelEnum;

/**
 * @author smadnani
 *
 */
public final class PuzzleHelper {
    //TODO Logger and documentation comments
    private static final Random RANDOM = new Random();
    private static final Map<LabelEnum, FruitEnum> BASKET = new HashMap<LabelEnum, FruitEnum>();
    
    static {
        for(LabelEnum lable: LabelEnum.values()) {
            BASKET.put(lable, FruitEnum.values()[RANDOM.nextInt(2)]);
        }
    }

    /**
     * @return the basket
     */
    public final static Map<LabelEnum, FruitEnum> getBasket() {
        return BASKET;
    }
    
    private PuzzleHelper() {
        
    }
}
