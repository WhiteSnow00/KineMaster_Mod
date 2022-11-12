// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.nativead;

import com.google.android.gms.internal.ads.zzbhy;
import com.google.android.gms.ads.internal.client.zzay;
import android.view.MotionEvent;
import android.widget.ImageView$ScaleType;
import com.google.android.gms.internal.ads.zzbkx;
import com.google.android.gms.ads.internal.client.zzek;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.dynamic.IObjectWrapper;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzcfi;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.ads.internal.client.zzaw;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.widget.FrameLayout$LayoutParams;
import android.util.AttributeSet;
import android.content.Context;
import com.google.android.gms.internal.ads.zzble;
import android.widget.FrameLayout;

public final class NativeAdView extends FrameLayout
{
    private final FrameLayout a;
    private final zzble b;
    
    public NativeAdView(final Context context, final AttributeSet set) {
        super(context, set);
        this.a = this.e(context);
        this.b = this.f();
    }
    
    private final FrameLayout e(final Context context) {
        final FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams((ViewGroup$LayoutParams)new FrameLayout$LayoutParams(-1, -1));
        this.addView((View)frameLayout);
        return frameLayout;
    }
    
    private final zzble f() {
        if (this.isInEditMode()) {
            return null;
        }
        return zzaw.a().g(this.a.getContext(), this, this.a);
    }
    
    private final void g(final String s, final View view) {
        final zzble b = this.b;
        if (b != null) {
            try {
                b.zzbw(s, ObjectWrapper.q1(view));
            }
            catch (final RemoteException ex) {
                zzcfi.zzh("Unable to call setAssetView on delegate", (Throwable)ex);
            }
        }
    }
    
    public void a() {
        final zzble b = this.b;
        if (b != null) {
            try {
                b.zzc();
            }
            catch (final RemoteException ex) {
                zzcfi.zzh("Unable to destroy native ad view", (Throwable)ex);
            }
        }
    }
    
    public final void addView(final View view, final int n, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        super.addView(view, n, viewGroup$LayoutParams);
        super.bringChildToFront((View)this.a);
    }
    
    protected final View b(final String s) {
        final zzble b = this.b;
        if (b != null) {
            try {
                final IObjectWrapper zzb = b.zzb(s);
                if (zzb != null) {
                    return (View)ObjectWrapper.p1(zzb);
                }
            }
            catch (final RemoteException ex) {
                zzcfi.zzh("Unable to call getAssetView on delegate", (Throwable)ex);
            }
        }
        return null;
    }
    
    public final void bringChildToFront(final View view) {
        super.bringChildToFront(view);
        final FrameLayout a = this.a;
        if (a != view) {
            super.bringChildToFront((View)a);
        }
    }
    
    final void c(final MediaContent mediaContent) {
        final zzble b = this.b;
        if (b == null) {
            return;
        }
        try {
            if (mediaContent instanceof zzek) {
                b.zzby(((zzek)mediaContent).a());
                return;
            }
            if (mediaContent == null) {
                b.zzby((zzbkx)null);
                return;
            }
            zzcfi.zze("Use MediaContent provided by NativeAd.getMediaContent");
        }
        catch (final RemoteException ex) {
            zzcfi.zzh("Unable to call setMediaContent on delegate", (Throwable)ex);
        }
    }
    
    final void d(final ImageView$ScaleType imageView$ScaleType) {
        final zzble b = this.b;
        if (b == null) {
            return;
        }
        if (imageView$ScaleType != null) {
            try {
                b.zzbz(ObjectWrapper.q1(imageView$ScaleType));
            }
            catch (final RemoteException ex) {
                zzcfi.zzh("Unable to call setMediaViewImageScaleType on delegate", (Throwable)ex);
            }
        }
    }
    
    public final boolean dispatchTouchEvent(final MotionEvent motionEvent) {
        if (zzay.c().zzb(zzbhy.zzcC)) {
            final zzble b = this.b;
            if (b != null) {
                try {
                    b.zzd(ObjectWrapper.q1(motionEvent));
                }
                catch (final RemoteException ex) {
                    zzcfi.zzh("Unable to call handleTouchEvent on delegate", (Throwable)ex);
                }
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }
    
    public AdChoicesView getAdChoicesView() {
        final View b = this.b("3011");
        if (b instanceof AdChoicesView) {
            return (AdChoicesView)b;
        }
        return null;
    }
    
    public final View getAdvertiserView() {
        return this.b("3005");
    }
    
    public final View getBodyView() {
        return this.b("3004");
    }
    
    public final View getCallToActionView() {
        return this.b("3002");
    }
    
    public final View getHeadlineView() {
        return this.b("3001");
    }
    
    public final View getIconView() {
        return this.b("3003");
    }
    
    public final View getImageView() {
        return this.b("3008");
    }
    
    public final MediaView getMediaView() {
        final View b = this.b("3010");
        if (b instanceof MediaView) {
            return (MediaView)b;
        }
        if (b != null) {
            zzcfi.zze("View is not an instance of MediaView");
        }
        return null;
    }
    
    public final View getPriceView() {
        return this.b("3007");
    }
    
    public final View getStarRatingView() {
        return this.b("3009");
    }
    
    public final View getStoreView() {
        return this.b("3006");
    }
    
    public final void onVisibilityChanged(final View view, final int n) {
        super.onVisibilityChanged(view, n);
        final zzble b = this.b;
        if (b != null) {
            try {
                b.zze(ObjectWrapper.q1(view), n);
            }
            catch (final RemoteException ex) {
                zzcfi.zzh("Unable to call onVisibilityChanged on delegate", (Throwable)ex);
            }
        }
    }
    
    public final void removeAllViews() {
        super.removeAllViews();
        super.addView((View)this.a);
    }
    
    public final void removeView(final View view) {
        if (this.a == view) {
            return;
        }
        super.removeView(view);
    }
    
    public void setAdChoicesView(final AdChoicesView adChoicesView) {
        this.g("3011", (View)adChoicesView);
    }
    
    public final void setAdvertiserView(final View view) {
        this.g("3005", view);
    }
    
    public final void setBodyView(final View view) {
        this.g("3004", view);
    }
    
    public final void setCallToActionView(final View view) {
        this.g("3002", view);
    }
    
    public final void setClickConfirmingView(final View view) {
        final zzble b = this.b;
        if (b != null) {
            try {
                b.zzbx(ObjectWrapper.q1(view));
            }
            catch (final RemoteException ex) {
                zzcfi.zzh("Unable to call setClickConfirmingView on delegate", (Throwable)ex);
            }
        }
    }
    
    public final void setHeadlineView(final View view) {
        this.g("3001", view);
    }
    
    public final void setIconView(final View view) {
        this.g("3003", view);
    }
    
    public final void setImageView(final View view) {
        this.g("3008", view);
    }
    
    public final void setMediaView(final MediaView mediaView) {
        this.g("3010", (View)mediaView);
        if (mediaView == null) {
            return;
        }
        mediaView.a(new zzb(this));
        mediaView.b(new zzc(this));
    }
    
    public void setNativeAd(final NativeAd nativeAd) {
        final zzble b = this.b;
        if (b != null) {
            try {
                b.zzbA((IObjectWrapper)nativeAd.zza());
            }
            catch (final RemoteException ex) {
                zzcfi.zzh("Unable to call setNativeAd on delegate", (Throwable)ex);
            }
        }
    }
    
    public final void setPriceView(final View view) {
        this.g("3007", view);
    }
    
    public final void setStarRatingView(final View view) {
        this.g("3009", view);
    }
    
    public final void setStoreView(final View view) {
        this.g("3006", view);
    }
}
