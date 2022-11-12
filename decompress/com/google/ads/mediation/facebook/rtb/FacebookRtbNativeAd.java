// 
// Decompiled by Procyon v0.6.0
// 

package com.google.ads.mediation.facebook.rtb;

import com.facebook.ads.Ad;
import java.lang.ref.WeakReference;
import com.facebook.ads.AdListener;
import android.graphics.drawable.Drawable;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.ExtraHints;
import com.google.android.gms.ads.mediation.MediationAdConfiguration;
import android.text.TextUtils;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.AdOptionsView;
import android.os.Bundle;
import com.facebook.ads.MediaViewListener;
import android.net.Uri;
import com.google.android.gms.ads.AdError;
import android.content.Context;
import com.facebook.ads.NativeAd;
import java.util.List;
import android.widget.ImageView;
import android.util.Log;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Map;
import android.view.View;
import com.facebook.ads.NativeBannerAd;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAdBase;
import com.google.android.gms.ads.mediation.MediationNativeAdCallback;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;

public class FacebookRtbNativeAd extends UnifiedNativeAdMapper
{
    private final MediationNativeAdConfiguration s;
    private final MediationAdLoadCallback<UnifiedNativeAdMapper, MediationNativeAdCallback> t;
    private NativeAdBase u;
    private MediationNativeAdCallback v;
    private MediaView w;
    
    public FacebookRtbNativeAd(final MediationNativeAdConfiguration s, final MediationAdLoadCallback<UnifiedNativeAdMapper, MediationNativeAdCallback> t) {
        this.t = t;
        this.s = s;
    }
    
    static MediationNativeAdCallback P(final FacebookRtbNativeAd facebookRtbNativeAd) {
        return facebookRtbNativeAd.v;
    }
    
    static MediationNativeAdCallback Q(final FacebookRtbNativeAd facebookRtbNativeAd, final MediationNativeAdCallback v) {
        return facebookRtbNativeAd.v = v;
    }
    
    static MediationAdLoadCallback R(final FacebookRtbNativeAd facebookRtbNativeAd) {
        return facebookRtbNativeAd.t;
    }
    
    private boolean S(final NativeAdBase nativeAdBase) {
        final String adHeadline = nativeAdBase.getAdHeadline();
        final boolean b = true;
        final boolean b2 = adHeadline != null && nativeAdBase.getAdBodyText() != null && nativeAdBase.getAdIcon() != null && nativeAdBase.getAdCallToAction() != null;
        if (nativeAdBase instanceof NativeBannerAd) {
            return b2;
        }
        return b2 && nativeAdBase.getAdCoverImage() != null && this.w != null && b;
    }
    
    @Override
    public void I(final View view, final Map<String, View> map, final Map<String, View> map2) {
        this.D(true);
        final ArrayList list = new ArrayList((Collection<? extends E>)map.values());
        final View view2 = map.get("3003");
        final NativeAdBase u = this.u;
        if (u instanceof NativeBannerAd) {
            if (view2 == null) {
                Log.w(FacebookMediationAdapter.TAG, "Missing or invalid native ad icon asset. Facebook impression recording might be impacted for this ad.");
                return;
            }
            if (!(view2 instanceof ImageView)) {
                Log.w(FacebookMediationAdapter.TAG, String.format("Native ad icon asset is rendered with an incompatible class type. Facebook impression recording might be impacted for this ad. Expected: ImageView, actual: %s.", view2.getClass()));
                return;
            }
            ((NativeBannerAd)u).registerViewForInteraction(view, (ImageView)view2, list);
        }
        else if (u instanceof NativeAd) {
            final NativeAd nativeAd = (NativeAd)u;
            if (view2 instanceof ImageView) {
                nativeAd.registerViewForInteraction(view, this.w, (ImageView)view2, list);
            }
            else {
                Log.w(FacebookMediationAdapter.TAG, "Native icon asset is not of type ImageView. Calling registerViewForInteraction() without a reference to the icon view.");
                nativeAd.registerViewForInteraction(view, this.w, list);
            }
        }
        else {
            Log.w(FacebookMediationAdapter.TAG, "Native ad type is not of type NativeAd or NativeBannerAd. It is not currently supported by the Facebook Adapter. Facebook impression recording might be impacted for this ad.");
        }
    }
    
    @Override
    public void J(final View view) {
        final NativeAdBase u = this.u;
        if (u != null) {
            u.unregisterView();
        }
        super.J(view);
    }
    
    public void T(final Context context, final c c) {
        if (!this.S(this.u)) {
            final AdError adError = new AdError(108, "Ad from Facebook doesn't have all required assets.", "com.google.ads.mediation.facebook");
            Log.w(FacebookMediationAdapter.TAG, adError.c());
            c.a(adError);
            return;
        }
        this.z(this.u.getAdHeadline());
        if (this.u.getAdCoverImage() != null) {
            final ArrayList list = new ArrayList();
            list.add(new b(Uri.parse(this.u.getAdCoverImage().getUrl())));
            this.B(list);
        }
        this.v(this.u.getAdBodyText());
        if (this.u.getPreloadedIconViewDrawable() == null) {
            if (this.u.getAdIcon() == null) {
                this.A(new b());
            }
            else {
                this.A(new b(Uri.parse(this.u.getAdIcon().getUrl())));
            }
        }
        else {
            this.A(new b(this.u.getPreloadedIconViewDrawable()));
        }
        this.w(this.u.getAdCallToAction());
        this.u(this.u.getAdvertiserName());
        this.w.setListener(new MediaViewListener(this) {
            final FacebookRtbNativeAd a;
            
            @Override
            public void onComplete(final MediaView mediaView) {
                if (FacebookRtbNativeAd.P(this.a) != null) {
                    FacebookRtbNativeAd.P(this.a).onVideoComplete();
                }
            }
            
            @Override
            public void onEnterFullscreen(final MediaView mediaView) {
            }
            
            @Override
            public void onExitFullscreen(final MediaView mediaView) {
            }
            
            @Override
            public void onFullscreenBackground(final MediaView mediaView) {
            }
            
            @Override
            public void onFullscreenForeground(final MediaView mediaView) {
            }
            
            @Override
            public void onPause(final MediaView mediaView) {
            }
            
            @Override
            public void onPlay(final MediaView mediaView) {
            }
            
            @Override
            public void onVolumeChange(final MediaView mediaView, final float n) {
            }
        });
        this.y(true);
        this.C((View)this.w);
        this.G(null);
        final Bundle bundle = new Bundle();
        bundle.putCharSequence("id", (CharSequence)this.u.getId());
        bundle.putCharSequence("social_context", (CharSequence)this.u.getAdSocialContext());
        this.x(bundle);
        this.t((View)new AdOptionsView(context, this.u, null));
        c.b();
    }
    
    public void U() {
        final String placementID = FacebookMediationAdapter.getPlacementID(this.s.c());
        if (TextUtils.isEmpty((CharSequence)placementID)) {
            final AdError adError = new AdError(101, "Failed to request ad. PlacementID is null or empty.", "com.google.ads.mediation.facebook");
            Log.e(FacebookMediationAdapter.TAG, adError.c());
            this.t.a(adError);
            return;
        }
        FacebookMediationAdapter.setMixedAudience(this.s);
        this.w = new MediaView(this.s.b());
        try {
            this.u = NativeAdBase.fromBidPayload(this.s.b(), placementID, this.s.a());
            if (!TextUtils.isEmpty((CharSequence)this.s.d())) {
                this.u.setExtraHints(new ExtraHints.Builder().mediationData(this.s.d()).build());
            }
            final NativeAdBase u = this.u;
            u.loadAd(u.buildLoadAdConfig().withAdListener(new d(this.s.b(), this.u)).withBid(this.s.a()).withMediaCacheFlag(NativeAdBase.MediaCacheFlag.ALL).withPreloadedIconView(-1, -1).build());
        }
        catch (final Exception ex) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Failed to create native ad from bid payload: ");
            sb.append(ex.getMessage());
            final AdError adError2 = new AdError(109, sb.toString(), "com.google.ads.mediation.facebook");
            Log.w(FacebookMediationAdapter.TAG, adError2.c());
            this.t.a(adError2);
        }
    }
    
    private class b extends Image
    {
        private Drawable a;
        private Uri b;
        final FacebookRtbNativeAd c;
        
        public b(final FacebookRtbNativeAd c) {
            this.c = c;
        }
        
        public b(final FacebookRtbNativeAd c, final Drawable a) {
            this.c = c;
            this.a = a;
        }
        
        public b(final FacebookRtbNativeAd c, final Uri b) {
            this.c = c;
            this.b = b;
        }
        
        @Override
        public Drawable getDrawable() {
            return this.a;
        }
        
        @Override
        public double getScale() {
            return 1.0;
        }
        
        @Override
        public Uri getUri() {
            return this.b;
        }
    }
    
    private interface c
    {
        void a(final AdError p0);
        
        void b();
    }
    
    private class d implements AdListener, NativeAdListener
    {
        private final WeakReference<Context> a;
        private final NativeAdBase b;
        final FacebookRtbNativeAd c;
        
        d(final FacebookRtbNativeAd c, final Context context, final NativeAdBase b) {
            this.c = c;
            this.b = b;
            this.a = new WeakReference<Context>(context);
        }
        
        @Override
        public void onAdClicked(final Ad ad) {
            FacebookRtbNativeAd.P(this.c).reportAdClicked();
            FacebookRtbNativeAd.P(this.c).onAdOpened();
            FacebookRtbNativeAd.P(this.c).onAdLeftApplication();
        }
        
        @Override
        public void onAdLoaded(final Ad ad) {
            if (ad != this.b) {
                final AdError adError = new AdError(106, "Ad Loaded is not a Native Ad.", "com.google.ads.mediation.facebook");
                Log.e(FacebookMediationAdapter.TAG, adError.c());
                FacebookRtbNativeAd.R(this.c).a(adError);
                return;
            }
            final Context context = this.a.get();
            if (context == null) {
                final AdError adError2 = new AdError(107, "Context is null.", "com.google.ads.mediation.facebook");
                Log.e(FacebookMediationAdapter.TAG, adError2.c());
                FacebookRtbNativeAd.R(this.c).a(adError2);
                return;
            }
            this.c.T(context, (c)new c(this) {
                final d a;
                
                @Override
                public void a(final AdError adError) {
                    Log.w(FacebookMediationAdapter.TAG, adError.c());
                    FacebookRtbNativeAd.R(this.a.c).a(adError);
                }
                
                @Override
                public void b() {
                    final FacebookRtbNativeAd c = this.a.c;
                    FacebookRtbNativeAd.Q(c, (MediationNativeAdCallback)FacebookRtbNativeAd.R(c).onSuccess(this.a.c));
                }
            });
        }
        
        @Override
        public void onError(final Ad ad, final com.facebook.ads.AdError adError) {
            final AdError adError2 = FacebookMediationAdapter.getAdError(adError);
            Log.w(FacebookMediationAdapter.TAG, adError2.c());
            FacebookRtbNativeAd.R(this.c).a(adError2);
        }
        
        @Override
        public void onLoggingImpression(final Ad ad) {
        }
        
        @Override
        public void onMediaDownloaded(final Ad ad) {
            Log.d(FacebookMediationAdapter.TAG, "onMediaDownloaded");
        }
    }
}
