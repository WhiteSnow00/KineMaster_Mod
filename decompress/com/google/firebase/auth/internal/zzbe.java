// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth.internal;

import java.util.Map;
import android.text.TextUtils;

public final class zzbe
{
    private boolean a;
    private String b;
    
    private zzbe() {
    }
    
    public static zzbe a(String b) {
        if (TextUtils.isEmpty((CharSequence)b)) {
            return null;
        }
        final Map b2 = l.b(b);
        try {
            final zzbe zzbe = new zzbe();
            final Object value = b2.get("basicIntegrity");
            boolean a = false;
            if (value != null) {
                a = a;
                if (value) {
                    a = true;
                }
            }
            zzbe.a = a;
            if ((b = (String)b2.get("advice")) == null) {
                b = "";
            }
            zzbe.b = b;
            return zzbe;
        }
        catch (final ClassCastException ex) {
            return null;
        }
    }
    
    public final String b() {
        return this.b;
    }
    
    public final boolean c() {
        return this.a;
    }
}
