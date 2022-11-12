// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth;

import java.util.Set;
import android.net.Uri;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ActionCodeUrl
{
    private static final Map g;
    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    
    static {
        final HashMap hashMap = new HashMap();
        hashMap.put("recoverEmail", 2);
        hashMap.put("resetPassword", 0);
        hashMap.put("signIn", 4);
        hashMap.put("verifyEmail", 1);
        hashMap.put("verifyBeforeChangeEmail", 5);
        hashMap.put("revertSecondFactorAddition", 6);
        g = Collections.unmodifiableMap((Map<?, ?>)hashMap);
    }
    
    private ActionCodeUrl(final String s) {
        final String e = e(s, "apiKey");
        final String e2 = e(s, "oobCode");
        final String e3 = e(s, "mode");
        if (e != null && e2 != null && e3 != null) {
            this.a = Preconditions.g(e);
            this.b = Preconditions.g(e2);
            this.c = Preconditions.g(e3);
            this.d = e(s, "continueUrl");
            this.e = e(s, "languageCode");
            this.f = e(s, "tenantId");
            return;
        }
        throw new IllegalArgumentException(String.format("%s, %s and %s are required in a valid action code URL", "apiKey", "oobCode", "mode"));
    }
    
    public static ActionCodeUrl c(final String s) {
        Preconditions.g(s);
        try {
            return new ActionCodeUrl(s);
        }
        catch (final IllegalArgumentException ex) {
            return null;
        }
    }
    
    private static String e(String queryParameter, final String s) {
        final Uri parse = Uri.parse(queryParameter);
        try {
            final Set queryParameterNames = parse.getQueryParameterNames();
            if (queryParameterNames.contains(s)) {
                return parse.getQueryParameter(s);
            }
            if (queryParameterNames.contains("link")) {
                queryParameter = Uri.parse(Preconditions.g(parse.getQueryParameter("link"))).getQueryParameter(s);
                return queryParameter;
            }
            return null;
        }
        catch (final UnsupportedOperationException | NullPointerException ex) {
            return null;
        }
    }
    
    public String a() {
        return this.b;
    }
    
    public int b() {
        final Map g = ActionCodeUrl.g;
        if (g.containsKey(this.c)) {
            return (int)g.get(this.c);
        }
        return 3;
    }
    
    public final String d() {
        return this.f;
    }
}
