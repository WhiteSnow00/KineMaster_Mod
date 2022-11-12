// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth.internal;

import com.google.firebase.auth.FirebaseAuthSettings;

public final class zzw extends FirebaseAuthSettings
{
    private String a;
    private String b;
    private boolean c;
    private boolean d;
    
    public zzw() {
        this.c = false;
        this.d = false;
    }
    
    public final String a() {
        return this.a;
    }
    
    public final String b() {
        return this.b;
    }
    
    public final boolean c() {
        return this.d;
    }
    
    public final boolean d() {
        return this.a != null && this.b != null;
    }
    
    public final boolean e() {
        return this.c;
    }
}
