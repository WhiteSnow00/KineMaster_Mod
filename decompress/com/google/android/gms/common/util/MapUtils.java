// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.util;

import java.util.Iterator;
import java.util.HashMap;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class MapUtils
{
    @KeepForSdk
    public static void a(final StringBuilder sb, final HashMap<String, String> hashMap) {
        sb.append("{");
        final Iterator<String> iterator = hashMap.keySet().iterator();
        int n = 1;
        while (iterator.hasNext()) {
            final String s = iterator.next();
            if (n == 0) {
                sb.append(",");
            }
            final String s2 = hashMap.get(s);
            sb.append("\"");
            sb.append(s);
            sb.append("\":");
            if (s2 == null) {
                sb.append("null");
            }
            else {
                sb.append("\"");
                sb.append(s2);
                sb.append("\"");
            }
            n = 0;
        }
        sb.append("}");
    }
}
