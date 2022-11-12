// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.stacktrace;

public class MiddleOutStrategy implements StackTraceTrimmingStrategy
{
    private final int a;
    
    public MiddleOutStrategy(final int a) {
        this.a = a;
    }
    
    @Override
    public StackTraceElement[] a(final StackTraceElement[] array) {
        final int length = array.length;
        final int a = this.a;
        if (length <= a) {
            return array;
        }
        final int n = a / 2;
        final int n2 = a - n;
        final StackTraceElement[] array2 = new StackTraceElement[a];
        System.arraycopy(array, 0, array2, 0, n2);
        System.arraycopy(array, array.length - n, array2, n2, n);
        return array2;
    }
}
