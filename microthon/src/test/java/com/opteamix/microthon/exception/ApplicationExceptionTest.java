/**
 * 
 */
package com.opteamix.microthon.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

/**
 * Test case for {@link ApplicationException}.
 * 
 * @author sanjay.madnani
 * 
 */
public class ApplicationExceptionTest {

    private static final Logger logger = LogManager.getLogger(ApplicationExceptionTest.class);

    /**
     * Test method for
     * {@link com.sanjay.common.exception.ApplicationException#ApplicationException(java.lang.String, com.sanjay.common.exception.ApplicationSeverityEnum, java.lang.Throwable, java.lang.String[])}
     * .
     */
    @Test
    public void testApplicationExceptionStringApplicationSeverityEnumThrowableStringArray() {
        try {
            throw new ApplicationException("INVALID_DATA1", ApplicationSeverityEnum.ERROR, new Throwable("Cause1"),
                    "test case1");
        } catch (ApplicationException e) {
            assertEquals("INVALID_DATA1", e.getErrorKey());
            assertEquals(ApplicationSeverityEnum.ERROR, e.getSeverity());
            String[] param = e.getParams();
            assertEquals("test case1", param[0]);
            logger.debug(e);
        }
    }

    /**
     * Test method for
     * {@link com.sanjay.common.exception.ApplicationException#ApplicationException(java.lang.String, com.sanjay.common.exception.ApplicationSeverityEnum, java.lang.Throwable, java.lang.Object[])}
     * .
     */
    @Test
    public void testApplicationExceptionStringApplicationSeverityEnumThrowableObjectArray() {
        Exception ex = null;
        try {
            throw new ApplicationException("INVALID_DATA2", ApplicationSeverityEnum.ERROR, new Throwable("Cause2"), ex);
        } catch (ApplicationException e) {
            assertEquals("INVALID_DATA2", e.getErrorKey());
            assertEquals(ApplicationSeverityEnum.ERROR, e.getSeverity());
            Object[] param = e.getObjects();
            assertEquals(null, param[0]);
            logger.debug(e);
        }
    }

    /**
     * Test method for
     * {@link com.sanjay.common.exception.ApplicationException#ApplicationException(java.lang.String, com.sanjay.common.exception.ApplicationSeverityEnum, java.lang.Throwable)}
     * .
     */
    @Test
    public void testApplicationExceptionStringApplicationSeverityEnumThrowable() {
        try {
            throw new ApplicationException("INVALID_DATA3", ApplicationSeverityEnum.ERROR, new Throwable("Cause3"));
        } catch (ApplicationException e) {
            assertEquals("INVALID_DATA3", e.getErrorKey());
            assertEquals(ApplicationSeverityEnum.ERROR, e.getSeverity());
            assertEquals("java.lang.Throwable: Cause3", e.getMessage());
            logger.debug(e);
        }
    }

    /**
     * Test method for
     * {@link com.sanjay.common.exception.ApplicationException#ApplicationException(int, com.sanjay.common.exception.ApplicationSeverityEnum, java.lang.Throwable, java.lang.Object[])}
     * .
     */
    @Test
    public void testApplicationExceptionIntApplicationSeverityEnumThrowableObjectArray() {
        Exception ex = null;
        try {
            throw new ApplicationException(10, ApplicationSeverityEnum.ERROR, new Throwable("Cause4"), ex);
        } catch (ApplicationException e) {
            assertEquals(10, e.getErrorCode().intValue());
            assertEquals(ApplicationSeverityEnum.ERROR, e.getSeverity());
            Object[] param = e.getObjects();
            assertEquals(null, param[0]);
            logger.debug(e);
        }
    }

    /**
     * Test method for
     * {@link com.sanjay.common.exception.ApplicationException#ApplicationException(java.lang.String, com.sanjay.common.exception.ApplicationSeverityEnum)}
     * .
     */
    @Test
    public void testApplicationExceptionStringApplicationSeverityEnum() {
        try {
            throw new ApplicationException("INVALID_DATA5", ApplicationSeverityEnum.ERROR);
        } catch (ApplicationException e) {
            assertEquals("INVALID_DATA5", e.getErrorKey());
            assertEquals(ApplicationSeverityEnum.ERROR, e.getSeverity());
            logger.debug(e);
        }
    }

    /**
     * Test method for
     * {@link com.sanjay.common.exception.ApplicationException#ApplicationException(int, com.sanjay.common.exception.ApplicationSeverityEnum)}
     * .
     */
    @Test
    public void testApplicationExceptionIntApplicationSeverityEnum() {
        try {
            throw new ApplicationException(10, ApplicationSeverityEnum.ERROR);
        } catch (ApplicationException e) {
            assertEquals(10, e.getErrorCode().intValue());
            assertEquals(ApplicationSeverityEnum.ERROR, e.getSeverity());
            logger.debug(e);
        }
    }

    /**
     * Test method for
     * {@link com.sanjay.common.exception.ApplicationException#ApplicationException(int, java.lang.Throwable)}.
     */
    @Test
    public void testApplicationExceptionIntThrowable() {
        try {
            throw new ApplicationException(10, new Throwable("Cause6"));
        } catch (ApplicationException e) {
            assertEquals(10, e.getErrorCode().intValue());
            assertNotNull(e.getMessage());
            logger.debug(e);
        }
    }

    /**
     * Test method for {@link com.sanjay.common.exception.ApplicationException#ApplicationException(java.lang.String)}.
     */
    @Test
    public void testApplicationExceptionString() {
        try {
            throw new ApplicationException("INVALID_DATA7");
        } catch (ApplicationException e) {
            assertEquals("INVALID_DATA7", e.getErrorKey());
            logger.debug(e);
        }
    }

    /**
     * Test method for {@link com.sanjay.common.exception.ApplicationException#toString()}.
     */
    @Test
    public void testToString() {
        String exceptionString =
                new ApplicationException("INVALID_DATA8", ApplicationSeverityEnum.ERROR, new Throwable("Cause8"),
                        "test case8").toString();
        assertNotNull(exceptionString);
        assertEquals(
                "ApplicationRuntimeException: Errorkey: INVALID_DATA8. Severity: ERROR. Root Cause: java.lang.Throwable: Cause8 Additional information associated to exception: [test case8]",
                exceptionString);
    }

}
