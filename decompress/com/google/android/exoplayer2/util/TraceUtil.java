// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.util;

import android.os.Trace;

public final class TraceUtil
{
    private TraceUtil() {
    }
    
    public static void a(final String s) {
        if (Util.a >= 18) {
            b(s);
        }
    }
    
    private static void b(final String s) {
        Trace.beginSection(s);
    }
    
    public static void c() {
        if (Util.a >= 18) {
            d();
        }
    }
    
    private static void d() {
        Trace.endSection();
    }
}
