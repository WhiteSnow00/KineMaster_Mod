// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.stacktrace;

public class TrimmedThrowableData
{
    public final String a;
    public final String b;
    public final StackTraceElement[] c;
    public final TrimmedThrowableData d;
    
    public TrimmedThrowableData(Throwable cause, final StackTraceTrimmingStrategy stackTraceTrimmingStrategy) {
        this.a = cause.getLocalizedMessage();
        this.b = cause.getClass().getName();
        this.c = stackTraceTrimmingStrategy.a(cause.getStackTrace());
        cause = cause.getCause();
        TrimmedThrowableData d;
        if (cause != null) {
            d = new TrimmedThrowableData(cause, stackTraceTrimmingStrategy);
        }
        else {
            d = null;
        }
        this.d = d;
    }
}
