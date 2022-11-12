// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import android.location.Location;
import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzm
{
    private Bundle a;
    private List b;
    private boolean c;
    private int d;
    private final Bundle e;
    private final Bundle f;
    private final List g;
    private int h;
    private String i;
    private final List j;
    private int k;
    
    public zzm() {
        this.a = new Bundle();
        this.b = new ArrayList();
        this.c = false;
        this.d = -1;
        this.e = new Bundle();
        this.f = new Bundle();
        this.g = new ArrayList();
        this.h = -1;
        this.i = null;
        this.j = new ArrayList();
        this.k = 60000;
    }
    
    public final zzl a() {
        return new zzl(8, -1L, this.a, -1, this.b, this.c, this.d, false, null, null, null, null, this.e, this.f, this.g, null, null, false, null, this.h, this.i, this.j, this.k, null);
    }
    
    public final zzm b(final Bundle a) {
        this.a = a;
        return this;
    }
    
    public final zzm c(final int k) {
        this.k = k;
        return this;
    }
    
    public final zzm d(final boolean c) {
        this.c = c;
        return this;
    }
    
    public final zzm e(final List b) {
        this.b = b;
        return this;
    }
    
    public final zzm f(final String i) {
        this.i = i;
        return this;
    }
    
    public final zzm g(final int d) {
        this.d = d;
        return this;
    }
    
    public final zzm h(final int h) {
        this.h = h;
        return this;
    }
}
