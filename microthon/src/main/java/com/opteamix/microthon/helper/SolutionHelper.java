/**
 * 
 */
package com.opteamix.microthon.helper;

import java.util.HashMap;
import java.util.Map;

import com.opteamix.microthon.enumeration.FruitEnum;
import com.opteamix.microthon.enumeration.LabelEnum;
import static com.opteamix.microthon.enumeration.LabelEnum.*;
/**
 * @author smadnani
 *
 */
// TODO logger, exception and documentation comment.
public final class SolutionHelper {
    private static final Map<LabelEnum, LabelEnum> INCORRECT_CORRECT_LABEL = new HashMap<LabelEnum, LabelEnum>();

    public static final Map<LabelEnum, LabelEnum> getOldVsCorrectLabels(final FruitEnum FRUIT) {
        switch (FRUIT) {
            case APPLE:
                INCORRECT_CORRECT_LABEL.put(APPLE, ORANGE);
                INCORRECT_CORRECT_LABEL.put(ORANGE, APPLE_ORANGE);
                INCORRECT_CORRECT_LABEL.put(APPLE_ORANGE, APPLE);
                break;

            case ORANGE:
                INCORRECT_CORRECT_LABEL.put(APPLE, APPLE_ORANGE);
                INCORRECT_CORRECT_LABEL.put(ORANGE, APPLE);
                INCORRECT_CORRECT_LABEL.put(APPLE_ORANGE, ORANGE);
                break;
            
            default:
                //TODO throw exception
                break;
        }
        return INCORRECT_CORRECT_LABEL;
    }
    
    private SolutionHelper() {
        
    }

}
