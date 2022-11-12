// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.ui;

import com.google.android.exoplayer2.util.Util;
import android.graphics.Color;

final class b
{
    public static String a(final String s) {
        final StringBuilder sb = new StringBuilder();
        sb.append(".");
        sb.append(s);
        sb.append(",.");
        sb.append(s);
        sb.append(" *");
        return sb.toString();
    }
    
    public static String b(final int n) {
        return Util.C("rgba(%d,%d,%d,%.3f)", Color.red(n), Color.green(n), Color.blue(n), Color.alpha(n) / 255.0);
    }
}
