// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import androidx.fragment.app.h;
import com.google.android.gms.common.internal.Preconditions;
import android.app.Activity;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class LifecycleActivity
{
    private final Object a;
    
    public LifecycleActivity(final Activity a) {
        Preconditions.l(a, "Activity must not be null");
        this.a = a;
    }
    
    public final Activity a() {
        return (Activity)this.a;
    }
    
    public final h b() {
        return (h)this.a;
    }
    
    public final boolean c() {
        return this.a instanceof Activity;
    }
    
    public final boolean d() {
        return this.a instanceof h;
    }
}
