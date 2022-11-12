// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.overlay;

import android.view.ViewParent;
import com.google.android.gms.internal.ads.zzcli;
import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewGroup$LayoutParams;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
public final class zzh
{
    public final int a;
    public final ViewGroup$LayoutParams b;
    public final ViewGroup c;
    public final Context d;
    
    public zzh(final zzcli zzcli) throws zzf {
        this.b = zzcli.getLayoutParams();
        final ViewParent parent = zzcli.getParent();
        this.d = zzcli.zzG();
        if (parent != null && parent instanceof ViewGroup) {
            final ViewGroup c = (ViewGroup)parent;
            this.c = c;
            this.a = c.indexOfChild(zzcli.zzH());
            c.removeView(zzcli.zzH());
            zzcli.zzap(true);
            return;
        }
        throw new zzf("Could not get the parent of the WebView for an overlay.");
    }
}
