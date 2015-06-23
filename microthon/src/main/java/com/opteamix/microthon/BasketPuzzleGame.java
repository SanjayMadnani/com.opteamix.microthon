/**
 * 
 */
package com.opteamix.microthon;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.opteamix.microthon.enumeration.FruitEnum;
import com.opteamix.microthon.enumeration.LabelEnum;
import com.opteamix.microthon.exception.ApplicationException;
import com.opteamix.microthon.helper.PuzzleHelper;
import com.opteamix.microthon.helper.SolutionHelper;
import com.opteamix.microthon.util.ReaderUtil;

/**
 * @author smadnani
 *
 */
// TODO proper exception handling, logs, Naming convention.
// FIXME validation utility missing for console input.
// FIXME write all String (sysout) in commonConstants class to avoid duplication of writing.
public class BasketPuzzleGame {

    private static final Logger LOGGER = LogManager.getLogger(BasketPuzzleGame.class);
    private static Map<LabelEnum, LabelEnum> INCORRECT_CORRECT_LABEL;
    private static boolean flag = true;

    public void basketPuzzleGame() throws ApplicationException {
        LOGGER.trace("Invoking basketPuzzleGame...");
        final Map<LabelEnum, FruitEnum> basket = PuzzleHelper.getBasket();
        System.out.print("Choose the basket (Orange or Apple or Apple_Orange): ");
        String console = ReaderUtil.readConsole().toLowerCase().trim();
        // FIXME validate console string, Show message and let the user try again if invalid console input.
        // FIXME Let the user enter exit to exit the game.
        switch (LabelEnum.valueOfStrLabel(console)) {
            case APPLE:
                System.out.println("You lost game, Invalid step.");
                // TODO Print what was wrong.
                // TODO restart the game rather than exiting.
                break;

            case ORANGE:
                System.out.println("You lost game, Invalid step.");
                // TODO Print what was wrong.
                // TODO restart the game rather than exiting.
                break;
            case APPLE_ORANGE:
                System.out.println("Fruit is: " + basket.get(LabelEnum.APPLE_ORANGE));
                assignCorrectLableToBaskets(basket.get(LabelEnum.APPLE_ORANGE));
                break;
            default:
                //TODO throw exception and write log.
                break;
        }
    }
    
    private void assignCorrectLableToBaskets(final FruitEnum fruit) throws ApplicationException {
        INCORRECT_CORRECT_LABEL = SolutionHelper.getOldVsCorrectLabels(fruit);
        List<String> assignedLables = new ArrayList<String>();
        System.out.println("Assign Correct Label to baskets (Orange or Apple or Apple_Orange) now...");
        while(flag) {
            if(assignedLables.contains("apple") && assignedLables.contains("orange") && assignedLables.contains("apple_orange")) {
                flag = false;
                System.out.println("Congratulation! you won the game");
                break;
            }
            assignCorrectLable(assignedLables);
        }
        
    }
    
    private void assignCorrectLable(List<String> assignedLables) throws ApplicationException {
        System.out.print("Choose the basket: ");
        String console = ReaderUtil.readConsole().toLowerCase().trim();
        if(!assignedLables.isEmpty() && assignedLables.contains(console)) {
            System.out.println("Invalid Basket, Can not choose the same basket again.");
            return;
        }
        assignedLables.add(console);
        System.out.print("Enter Correct Label: ");
        String correctLabel = ReaderUtil.readConsole().toLowerCase().trim();
        flag = validResult(LabelEnum.valueOfStrLabel(correctLabel), LabelEnum.valueOfStrLabel(console));
    }
    
    private boolean validResult(final LabelEnum correctLabel, final LabelEnum basket) {
        if(!correctLabel.equals(INCORRECT_CORRECT_LABEL.get(basket))) {
            System.out.println("Wrong Answer");
            return false;
        } else {
            System.out.println("Correct Answer");
            return true;
        }
    }
}
