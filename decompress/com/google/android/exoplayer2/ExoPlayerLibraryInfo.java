// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import java.util.HashSet;

public final class ExoPlayerLibraryInfo
{
    private static final HashSet<String> a;
    private static String b;
    
    static {
        a = new HashSet<String>();
        ExoPlayerLibraryInfo.b = "goog.exo.core";
    }
    
    private ExoPlayerLibraryInfo() {
    }
    
    public static void a(final String s) {
        synchronized (ExoPlayerLibraryInfo.class) {
            if (ExoPlayerLibraryInfo.a.add(s)) {
                final StringBuilder sb = new StringBuilder();
                sb.append(ExoPlayerLibraryInfo.b);
                sb.append(", ");
                sb.append(s);
                ExoPlayerLibraryInfo.b = sb.toString();
            }
        }
    }
    
    public static String b() {
        synchronized (ExoPlayerLibraryInfo.class) {
            return ExoPlayerLibraryInfo.b;
        }
    }
}
