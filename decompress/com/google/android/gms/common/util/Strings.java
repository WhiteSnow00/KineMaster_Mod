// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.util;

import android.text.TextUtils;
import java.util.regex.Pattern;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
@VisibleForTesting
public class Strings
{
    private static final Pattern a;
    
    static {
        a = Pattern.compile("\\$\\{(.*?)\\}");
    }
    
    private Strings() {
    }
    
    @KeepForSdk
    public static String a(final String s) {
        String s2 = s;
        if (TextUtils.isEmpty((CharSequence)s)) {
            s2 = null;
        }
        return s2;
    }
    
    @KeepForSdk
    public static boolean b(final String s) {
        return s == null || s.trim().isEmpty();
    }
}
