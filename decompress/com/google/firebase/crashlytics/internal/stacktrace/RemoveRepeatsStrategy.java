// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.stacktrace;

import java.util.HashMap;

public class RemoveRepeatsStrategy implements StackTraceTrimmingStrategy
{
    private final int a;
    
    public RemoveRepeatsStrategy() {
        this(1);
    }
    
    public RemoveRepeatsStrategy(final int a) {
        this.a = a;
    }
    
    private static boolean b(final StackTraceElement[] array, final int n, final int n2) {
        final int n3 = n2 - n;
        if (n2 + n3 > array.length) {
            return false;
        }
        for (int i = 0; i < n3; ++i) {
            if (!array[n + i].equals(array[n2 + i])) {
                return false;
            }
        }
        return true;
    }
    
    private static StackTraceElement[] c(StackTraceElement[] array, final int n) {
        final HashMap hashMap = new HashMap();
        final StackTraceElement[] array2 = new StackTraceElement[array.length];
        int i = 0;
        int n2 = 0;
        int n3 = 1;
        while (i < array.length) {
            final StackTraceElement stackTraceElement = array[i];
            final Integer n4 = (Integer)hashMap.get(stackTraceElement);
            int n7;
            int n8;
            if (n4 != null && b(array, n4, i)) {
                final int n5 = i - n4;
                int n6 = n2;
                if ((n7 = n3) < n) {
                    System.arraycopy(array, i, array2, n2, n5);
                    n6 = n2 + n5;
                    n7 = n3 + 1;
                }
                n8 = n5 - 1 + i;
                n2 = n6;
            }
            else {
                array2[n2] = array[i];
                ++n2;
                n7 = 1;
                n8 = i;
            }
            hashMap.put(stackTraceElement, i);
            i = n8 + 1;
            n3 = n7;
        }
        array = new StackTraceElement[n2];
        System.arraycopy(array2, 0, array, 0, n2);
        return array;
    }
    
    @Override
    public StackTraceElement[] a(final StackTraceElement[] array) {
        final StackTraceElement[] c = c(array, this.a);
        if (c.length < array.length) {
            return c;
        }
        return array;
    }
}
