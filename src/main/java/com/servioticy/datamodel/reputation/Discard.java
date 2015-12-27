package com.servioticy.datamodel.reputation;

/**
 * Created by alvaro on 26/12/15.
 */
public class Discard {
    public static final String REASON_SCRIPT_ERROR = "script-error";
    public static final String REASON_ACCESSIBILITY = "accessibility";
    public static final String REASON_COMPOSITION_ERROR = "composition_error";
    public static final String REASON_OLD_TRIGGER = "old_trigger";
    public static final String REASON_FILTERED = "filtered";

    String reason;
    String message;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
