// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.overlay;

import android.graphics.drawable.Drawable;
import android.content.res.Resources;
import android.widget.ImageView$ScaleType;
import android.content.res.Resources$NotFoundException;
import com.google.android.gms.internal.ads.zzcfi;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.ads.internal.zzt;
import android.text.TextUtils;
import com.google.android.gms.common.util.PlatformVersion;
import android.animation.Animator$AnimatorListener;
import com.google.android.gms.internal.ads.zzbhy;
import com.google.android.gms.ads.internal.client.zzay;
import android.view.ViewGroup$LayoutParams;
import android.view.View;
import android.widget.FrameLayout$LayoutParams;
import com.google.android.gms.internal.ads.zzcfb;
import com.google.android.gms.ads.internal.client.zzaw;
import android.content.Context;
import android.widget.ImageButton;
import android.view.View$OnClickListener;
import android.widget.FrameLayout;

public final class zzr extends FrameLayout implements View$OnClickListener
{
    private final ImageButton a;
    private final zzaa b;
    
    public zzr(final Context context, final zzq zzq, final zzaa b) {
        super(context);
        this.b = b;
        this.setOnClickListener((View$OnClickListener)this);
        final ImageButton a = new ImageButton(context);
        this.a = a;
        this.c();
        a.setBackgroundColor(0);
        a.setOnClickListener((View$OnClickListener)this);
        zzaw.b();
        final int zzv = zzcfb.zzv(context, zzq.a);
        zzaw.b();
        final int zzv2 = zzcfb.zzv(context, 0);
        zzaw.b();
        final int zzv3 = zzcfb.zzv(context, zzq.b);
        zzaw.b();
        a.setPadding(zzv, zzv2, zzv3, zzcfb.zzv(context, zzq.c));
        a.setContentDescription((CharSequence)"Interstitial close button");
        zzaw.b();
        final int zzv4 = zzcfb.zzv(context, zzq.d + zzq.a + zzq.b);
        zzaw.b();
        this.addView((View)a, (ViewGroup$LayoutParams)new FrameLayout$LayoutParams(zzv4, zzcfb.zzv(context, zzq.d + zzq.c), 17));
        final long longValue = (long)zzay.c().zzb(zzbhy.zzaW);
        if (longValue <= 0L) {
            return;
        }
        Object listener;
        if (zzay.c().zzb(zzbhy.zzaX)) {
            listener = new c(this);
        }
        else {
            listener = null;
        }
        a.setAlpha(0.0f);
        a.animate().alpha(1.0f).setDuration(longValue).setListener((Animator$AnimatorListener)listener);
    }
    
    static /* bridge */ ImageButton a(final zzr zzr) {
        return zzr.a;
    }
    
    private final void c() {
        final String s = (String)zzay.c().zzb(zzbhy.zzaV);
        if (!PlatformVersion.f() || TextUtils.isEmpty((CharSequence)s) || "default".equals(s)) {
            this.a.setImageResource(17301527);
            return;
        }
        final Resources zzd = zzt.p().zzd();
        if (zzd == null) {
            this.a.setImageResource(17301527);
            return;
        }
        final Drawable drawable = null;
        Drawable imageDrawable;
        try {
            if ("white".equals(s)) {
                imageDrawable = zzd.getDrawable(R.drawable.b);
            }
            else {
                imageDrawable = drawable;
                if ("black".equals(s)) {
                    imageDrawable = zzd.getDrawable(R.drawable.a);
                }
            }
        }
        catch (final Resources$NotFoundException ex) {
            zzcfi.zze("Close button resource not found, falling back to default.");
            imageDrawable = drawable;
        }
        if (imageDrawable == null) {
            this.a.setImageResource(17301527);
            return;
        }
        this.a.setImageDrawable(imageDrawable);
        this.a.setScaleType(ImageView$ScaleType.CENTER);
    }
    
    public final void b(final boolean b) {
        if (b) {
            this.a.setVisibility(8);
            if ((long)zzay.c().zzb(zzbhy.zzaW) > 0L) {
                this.a.animate().cancel();
                this.a.clearAnimation();
            }
            return;
        }
        this.a.setVisibility(0);
    }
    
    public final void onClick(final View view) {
        final zzaa b = this.b;
        if (b != null) {
            b.zzbJ();
        }
    }
}
