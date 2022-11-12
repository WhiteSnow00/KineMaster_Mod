// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.stacktrace;

public class MiddleOutFallbackStrategy implements StackTraceTrimmingStrategy
{
    private final int a;
    private final StackTraceTrimmingStrategy[] b;
    private final MiddleOutStrategy c;
    
    public MiddleOutFallbackStrategy(final int a, final StackTraceTrimmingStrategy... b) {
        this.a = a;
        this.b = b;
        this.c = new MiddleOutStrategy(a);
    }
    
    @Override
    public StackTraceElement[] a(StackTraceElement[] a) {
        if (a.length <= this.a) {
            return a;
        }
        final StackTraceTrimmingStrategy[] b = this.b;
        final int length = b.length;
        int i = 0;
        StackTraceElement[] a2 = a;
        while (i < length) {
            final StackTraceTrimmingStrategy stackTraceTrimmingStrategy = b[i];
            if (a2.length <= this.a) {
                break;
            }
            a2 = stackTraceTrimmingStrategy.a(a);
            ++i;
        }
        a = a2;
        if (a2.length > this.a) {
            a = this.c.a(a2);
        }
        return a;
    }
}
