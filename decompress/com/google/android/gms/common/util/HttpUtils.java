// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.util;

import java.util.regex.Pattern;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class HttpUtils
{
    private static final Pattern a;
    private static final Pattern b;
    private static final Pattern c;
    
    static {
        a = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
        b = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
        c = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");
    }
    
    private HttpUtils() {
    }
}
