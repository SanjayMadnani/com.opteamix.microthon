/**
 * 
 */
package com.opteamix.microthon.exception;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.opteamix.microthon.constants.CommonConstants;

/**
 * Compile time exception.
 * 
 * @author smadnani
 * 
 */
//TODO remove not used constructors and methods.
public class ApplicationException extends Exception {

    /**
     * serialVersionUID unique key.
     */
    private static final long serialVersionUID = 565698485L;

    private static final Logger LOGGER = LogManager.getLogger(ApplicationException.class);
    /**
     * error bundle key.
     */
    private transient String errorKey;

    private Integer errorCode;
    /**
     * The error severity.
     */
    private transient ApplicationSeverityEnum severity;
    /**
     * Specific error Info.
     */
    private transient String[] params;
    /**
     * Specific error Info.
     */
    private transient Object[] objects;

    /**
     * Instantiate an ApplicationException.
     * 
     * @param errorKey String bundle key for retrieving error message.
     * @param severity severity of the Exception.
     * @param cause the cause (which is saved for later retrieval by the {@link #getCause()} method). (A <tt>null</tt>
     *            value is permitted, and indicates that the cause is nonexistent or unknown.)
     * @param params array of string for error info.
     */
    public ApplicationException(final String errorKey, final ApplicationSeverityEnum severity, final Throwable cause,
            final String... params) {
        super(cause);
        LOGGER.trace(CommonConstants.EXCEPTION_TRACE_LOG, errorKey, severity, cause, params);
        this.errorKey = errorKey;
        this.severity = severity;
        this.params = params;
    }

    /**
     * Instantiate an ApplicationException.
     * 
     * @param errorKey String bundle key for retrieving error message.
     * @param severity severity of the Exception.
     * @param cause the cause (which is saved for later retrieval by the {@link #getCause()} method). (A <tt>null</tt>
     *            value is permitted, and indicates that the cause is nonexistent or unknown.)
     * @param objects array of objects for error info.
     */
    public ApplicationException(final String errorKey, final ApplicationSeverityEnum severity, final Throwable cause,
            final Object... objects) {
        super(cause);
        LOGGER.trace(CommonConstants.EXCEPTION_TRACE_LOG, errorKey, severity, cause, objects);
        this.errorKey = errorKey;
        this.severity = severity;
        this.objects = objects;
    }

    /**
     * Instantiate an ApplicationException.
     * 
     * @param errorKey String bundle key for retrieving error message.
     * @param severity severity of the Exception.
     * @param cause the cause (which is saved for later retrieval by the {@link #getCause()} method). (A <tt>null</tt>
     *            value is permitted, and indicates that the cause is nonexistent or unknown.)
     */
    public ApplicationException(final String errorKey, final ApplicationSeverityEnum severity, final Throwable cause) {
        super(cause);
        LOGGER.trace(CommonConstants.EXCEPTION_TRACE_LOG, errorKey, severity);
        this.errorKey = errorKey;
        this.severity = severity;
    }

    /**
     * Instantiate an ApplicationException.
     * 
     * @param errorCode int bundle code for retrieving error message.
     * @param severity severity of the Exception.
     * @param cause the cause (which is saved for later retrieval by the {@link #getCause()} method). (A <tt>null</tt>
     *            value is permitted, and indicates that the cause is nonexistent or unknown.)
     * @param objects array of objects for error info.
     */
    public ApplicationException(final int errorCode, final ApplicationSeverityEnum severity, final Throwable cause,
            final Object... objects) {
        super(cause);
        LOGGER.trace(CommonConstants.EXCEPTION_TRACE_LOG, errorCode, severity, objects);
        this.errorCode = errorCode;
        this.severity = severity;
        this.objects = objects;
    }

    /**
     * Instantiate an ApplicationException.
     * 
     * @param errorKey String bundle key for retrieving error message.
     * @param severity severity of the Exception.
     */
    public ApplicationException(final String errorKey, final ApplicationSeverityEnum severity) {
        this(errorKey, severity, null, (String[]) null);
    }

    /**
     * Instantiate an ApplicationException.
     * 
     * @param errorCode int bundle code for retrieving error message.
     * @param severity severity of the Exception.
     */
    public ApplicationException(final int errorCode, final ApplicationSeverityEnum severity) {
        this(errorCode, severity, null, (Object[]) null);
    }

    /**
     * Instantiate an ApplicationException.
     * 
     * @param errorCode int bundle code for retrieving error message.
     * @param throwable the cause (which is saved for later retrieval by the {@link #getCause()} method). (A
     *            <tt>null</tt> value is permitted, and indicates that the cause is nonexistent or unknown.)
     */
    public ApplicationException(final int errorCode, final Throwable throwable) {
        this(errorCode, null, throwable, (Object[]) null);
    }

    /**
     * Instantiate an ApplicationException.
     * 
     * @param errorKey String bundle key for retrieving error message.
     */
    public ApplicationException(final String errorKey) {
        this(errorKey, null, null, (String[]) null);
    }

    /**
     * @return the errorCode
     */
    public Integer getErrorCode() {
        return errorCode;
    }

    /**
     * @param errorCode the errorCode to set
     */
    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * @return the errorKey
     */
    public String getErrorKey() {
        return errorKey;
    }

    /**
     * @return the severity
     */
    public ApplicationSeverityEnum getSeverity() {
        return severity;
    }

    /**
     * @return the params
     */
    public String[] getParams() {
        if (params == CommonConstants.NULL) {
            return new String[0];
        } else {
            return Arrays.copyOf(params, params.length);
        }
    }

    /**
     * @return the objects
     */
    public Object[] getObjects() {
        if (objects == CommonConstants.NULL) {
            return new Object[0];
        } else {
            return Arrays.copyOf(objects, objects.length);
        }
    }

    /* (non-Javadoc)
     * 
     * @see java.lang.Object#toString() */
    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append(CommonConstants.EXCEPTION_STRING_APPENDER1);
        buffer.append(CommonConstants.EXCEPTION_STRING_APPENDER2);
        buffer.append(this.errorKey);
        buffer.append(CommonConstants.EXCEPTION_STRING_APPENDER3);
        buffer.append(this.severity);
        buffer.append(CommonConstants.EXCEPTION_STRING_APPENDER4);
        if (this.getCause() == CommonConstants.NULL) {
            buffer.append(CommonConstants.EXCEPTION_STRING_APPENDER5);
        } else {
            buffer.append(this.getCause().toString());
        }
        if (this.params != CommonConstants.NULL && this.params.length > 0) {
            buffer.append(CommonConstants.EXCEPTION_STRING_APPENDER6);
            buffer.append(Arrays.toString(this.params));
        }
        if (this.objects != CommonConstants.NULL && this.objects.length > 0) {
            buffer.append(CommonConstants.EXCEPTION_STRING_APPENDER6);
            buffer.append(Arrays.toString(this.objects));
        }
        return buffer.toString();
    }

}
