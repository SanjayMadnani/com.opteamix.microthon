/**
 * 
 */
package com.opteamix.microthon.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.opteamix.microthon.exception.ApplicationException;
import com.opteamix.microthon.exception.ApplicationSeverityEnum;

/**
 * @author smadnani
 *
 */
public class ReaderUtil {
    //TODO Use Logger
    private static final Logger LOGGER = LogManager.getLogger(ReaderUtil.class);
    private static final BufferedReader BR;
    
    
    static {
        BR = new BufferedReader(new InputStreamReader(System.in));
    }
    
    /**
     * 
     * @return
     * @throws ApplicationException
     */
    public static String readConsole() throws ApplicationException {
        LOGGER.trace("Invoking readConsole...");
        try {
            return BR.readLine();
        } catch (IOException e) {
            LOGGER.error("Exception occured while reading from console.", e);
            throw new ApplicationException("Could not read Console", ApplicationSeverityEnum.ERROR, e);
        }
    }

}
