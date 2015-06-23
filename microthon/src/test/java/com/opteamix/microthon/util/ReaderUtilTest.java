/**
 * 
 */
package com.opteamix.microthon.util;

import static org.junit.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import com.opteamix.microthon.exception.ApplicationException;

/**
 * @author smadnani
 *
 */
public class ReaderUtilTest {
    
    private static final Logger LOGGER = LogManager.getLogger(ReaderUtilTest.class);

    /**
     * Test method for {@link com.opteamix.microthon.util.ReaderUtil#readConsole()}.
     */
    @Test
    public final void testReadConsole() {
        LOGGER.trace("Invoking testReadConsole...");
        System.out.println("Pass the input 3:");
        try {
            assertEquals("3", ReaderUtil.readConsole());
        } catch (ApplicationException e) {
            LOGGER.error("Exception occured while reading input from console", e);
            fail("Exception occured while reading cosole input");
        }
    }

}
