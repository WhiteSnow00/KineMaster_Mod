// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.appset;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;

public class AppSetIdInfo
{
    private final String a;
    private final int b;
    
    public AppSetIdInfo(final String a, final int b) {
        this.a = a;
        this.b = b;
    }
    
    public String a() {
        return this.a;
    }
    
    public int b() {
        return this.b;
    }
    
    @Retention(RetentionPolicy.SOURCE)
    public @interface Scope {
    }
}
