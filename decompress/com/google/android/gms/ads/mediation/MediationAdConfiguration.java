// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.mediation;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import android.location.Location;
import android.content.Context;
import android.os.Bundle;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class MediationAdConfiguration
{
    private final String a;
    private final Bundle b;
    private final Bundle c;
    private final Context d;
    private final boolean e;
    private final Location f;
    private final int g;
    private final int h;
    private final String i;
    private final String j;
    
    public MediationAdConfiguration(final Context d, final String a, final Bundle b, final Bundle c, final boolean e, final Location f, final int g, final int h, final String i, final String j) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
        this.j = j;
    }
    
    public String a() {
        return this.a;
    }
    
    public Context b() {
        return this.d;
    }
    
    public Bundle c() {
        return this.b;
    }
    
    public String d() {
        return this.j;
    }
    
    public int e() {
        return this.g;
    }
    
    @Retention(RetentionPolicy.SOURCE)
    public @interface TagForChildDirectedTreatment {
    }
}
