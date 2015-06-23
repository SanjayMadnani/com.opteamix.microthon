/**
 * 
 */
package com.opteamix.microthon.exception;

import static org.junit.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

/**
 * Test case for {@link ApplicationSeverityEnum}.
 * 
 * @author smadnani
 * 
 */
public class ApplicationSeverityEnumTest {

    private static final Logger LOGGER = LogManager.getLogger(ApplicationSeverityEnumTest.class);

    /**
     * Test case for {@link ApplicationSeverityEnum}.
     */
    @Test
    public void testApplicationSeverity() {
        LOGGER.trace("Invoking testApplicationSeverity...");
        assertEquals("DEBUG", ApplicationSeverityEnum.DEBUG.name());
        assertEquals("INFO", ApplicationSeverityEnum.INFO.name());
        assertEquals("WARN", ApplicationSeverityEnum.WARN.name());
        assertEquals("ERROR", ApplicationSeverityEnum.ERROR.name());
        assertEquals("FATAL", ApplicationSeverityEnum.FATAL.name());
    }

}
