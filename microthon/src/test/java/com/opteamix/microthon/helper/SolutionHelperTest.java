/**
 * 
 */
package com.opteamix.microthon.helper;

import java.util.Map;

import org.junit.Test;

import com.opteamix.microthon.enumeration.FruitEnum;
import com.opteamix.microthon.enumeration.LabelEnum;

/**
 * @author smadnani
 *
 */
//TODO Logger implementation.
//FIXME invalid test case, remove sysout and use assert.
public class SolutionHelperTest {
    /**
     * Test method for {@link com.opteamix.microthon.helper.SolutionHelper#getOldVsCorrectLabels(com.opteamix.microthon.enumeration.FruitEnum)}.
     */
    @Test
    public final void testGetOldVsCorrectLabels() {
        final Map<LabelEnum, LabelEnum> INCORRECT_CORRECT_LABEL = SolutionHelper.getOldVsCorrectLabels(FruitEnum.ORANGE);
        for(Map.Entry<LabelEnum, LabelEnum> entrySet : INCORRECT_CORRECT_LABEL.entrySet()) {
            System.out.println("Inside for loop of testGetOldVsCorrectLabels test case");
            System.out.println("Key: " + entrySet.getKey());
            System.out.println("Value: " + entrySet.getValue());
        }
    }

}
