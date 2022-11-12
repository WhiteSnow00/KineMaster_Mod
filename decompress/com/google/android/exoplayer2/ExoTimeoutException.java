// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;

public final class ExoTimeoutException extends RuntimeException
{
    public static final int TIMEOUT_OPERATION_DETACH_SURFACE = 3;
    public static final int TIMEOUT_OPERATION_RELEASE = 1;
    public static final int TIMEOUT_OPERATION_SET_FOREGROUND_MODE = 2;
    public static final int TIMEOUT_OPERATION_UNDEFINED = 0;
    public final int timeoutOperation;
    
    public ExoTimeoutException(final int timeoutOperation) {
        super(a(timeoutOperation));
        this.timeoutOperation = timeoutOperation;
    }
    
    private static String a(final int n) {
        if (n == 1) {
            return "Player release timed out.";
        }
        if (n == 2) {
            return "Setting foreground mode timed out.";
        }
        if (n != 3) {
            return "Undefined timeout.";
        }
        return "Detaching surface timed out.";
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE })
    public @interface TimeoutOperation {
    }
}
