// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth.internal;

import java.util.Map;
import com.google.android.gms.internal.firebase_auth_api.zznp;
import java.util.HashMap;
import com.google.firebase.auth.GetTokenResult;
import com.google.android.gms.common.logging.Logger;

public final class zzay
{
    private static final Logger a;
    
    static {
        a = new Logger("GetTokenResultFactory", new String[0]);
    }
    
    public static GetTokenResult a(final String s) {
        Map b;
        try {
            b = l.b(s);
        }
        catch (final zznp zznp) {
            zzay.a.b("Error parsing token claims", (Throwable)zznp, new Object[0]);
            b = new HashMap();
        }
        return new GetTokenResult(s, b);
    }
}
