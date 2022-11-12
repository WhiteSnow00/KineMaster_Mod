// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;

public final class RepeatModeUtil
{
    private RepeatModeUtil() {
    }
    
    public static int a(final int n, final int n2) {
        for (int i = 1; i <= 2; ++i) {
            final int n3 = (n + i) % 3;
            if (b(n3, n2)) {
                return n3;
            }
        }
        return n;
    }
    
    public static boolean b(final int n, final int n2) {
        final boolean b = true;
        final boolean b2 = true;
        boolean b3 = b;
        if (n != 0) {
            if (n != 1) {
                return n == 2 && (n2 & 0x2) != 0x0 && b2;
            }
            b3 = ((n2 & 0x1) != 0x0 && b);
        }
        return b3;
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE })
    public @interface RepeatToggleModes {
    }
}
