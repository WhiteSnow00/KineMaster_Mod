// 
// Decompiled by Procyon v0.6.0
// 

package com.airbnb.lottie;

import java.util.HashMap;
import java.util.Map;

public class r
{
    private final Map<String, String> a;
    private final LottieAnimationView b;
    private final f c;
    private boolean d;
    
    public r(final f c) {
        this.a = new HashMap<String, String>();
        this.d = true;
        this.c = c;
        this.b = null;
    }
    
    private String a(final String s) {
        return s;
    }
    
    public final String b(final String s) {
        if (this.d && this.a.containsKey(s)) {
            return this.a.get(s);
        }
        final String a = this.a(s);
        if (this.d) {
            this.a.put(s, a);
        }
        return a;
    }
}
