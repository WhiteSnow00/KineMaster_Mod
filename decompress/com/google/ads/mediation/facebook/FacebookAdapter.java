// 
// Decompiled by Procyon v0.6.0
// 

package com.google.ads.mediation.facebook;

import com.facebook.ads.AdOptionsView;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.MediaViewListener;
import java.util.Iterator;
import android.widget.ImageView;
import java.util.Map;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import java.lang.ref.WeakReference;
import com.facebook.ads.InterstitialAdExtendedListener;
import android.net.Uri;
import android.graphics.drawable.Drawable;
import com.facebook.ads.Ad;
import com.facebook.ads.AdListener;
import android.view.ViewGroup$LayoutParams;
import android.widget.FrameLayout$LayoutParams;
import com.google.android.gms.ads.AdError;
import android.text.TextUtils;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import android.view.View;
import java.util.List;
import com.google.android.gms.ads.MediationUtils;
import android.util.Log;
import java.util.ArrayList;
import com.google.android.gms.ads.AdSize;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.InterstitialAdListener;
import com.facebook.ads.AdSettings;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import android.content.Context;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import android.widget.FrameLayout;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.facebook.ads.NativeBannerAd;
import com.facebook.ads.NativeAd;
import com.facebook.ads.MediaView;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.facebook.ads.InterstitialAd;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.facebook.ads.AdView;
import java.util.concurrent.atomic.AtomicBoolean;
import androidx.annotation.Keep;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;

@Keep
public final class FacebookAdapter extends FacebookMediationAdapter implements MediationBannerAdapter, MediationInterstitialAdapter, MediationNativeAdapter
{
    public static final String KEY_ID = "id";
    public static final String KEY_SOCIAL_CONTEXT_ASSET = "social_context";
    private static final int MAX_STAR_RATING = 5;
    private final AtomicBoolean didInterstitialAdClose;
    private boolean isNativeBanner;
    private AdView mAdView;
    private MediationBannerListener mBannerListener;
    private InterstitialAd mInterstitialAd;
    private MediationInterstitialListener mInterstitialListener;
    private boolean mIsImpressionRecorded;
    private MediaView mMediaView;
    private NativeAd mNativeAd;
    private NativeBannerAd mNativeBannerAd;
    private MediationNativeListener mNativeListener;
    private FrameLayout mWrappedAdView;
    private final AtomicBoolean showInterstitialCalled;
    
    public FacebookAdapter() {
        this.showInterstitialCalled = new AtomicBoolean();
        this.didInterstitialAdClose = new AtomicBoolean();
    }
    
    static AdView access$000(final FacebookAdapter facebookAdapter) {
        return facebookAdapter.mAdView;
    }
    
    static AdView access$002(final FacebookAdapter facebookAdapter, final AdView mAdView) {
        return facebookAdapter.mAdView = mAdView;
    }
    
    static void access$100(final FacebookAdapter facebookAdapter, final MediationAdRequest mediationAdRequest) {
        facebookAdapter.buildAdRequest(mediationAdRequest);
    }
    
    static AtomicBoolean access$1000(final FacebookAdapter facebookAdapter) {
        return facebookAdapter.showInterstitialCalled;
    }
    
    static AtomicBoolean access$1100(final FacebookAdapter facebookAdapter) {
        return facebookAdapter.didInterstitialAdClose;
    }
    
    static boolean access$1400(final FacebookAdapter facebookAdapter) {
        return facebookAdapter.mIsImpressionRecorded;
    }
    
    static boolean access$1402(final FacebookAdapter facebookAdapter, final boolean mIsImpressionRecorded) {
        return facebookAdapter.mIsImpressionRecorded = mIsImpressionRecorded;
    }
    
    static boolean access$1500(final FacebookAdapter facebookAdapter) {
        return facebookAdapter.isNativeBanner;
    }
    
    static MediaView access$1600(final FacebookAdapter facebookAdapter) {
        return facebookAdapter.mMediaView;
    }
    
    static FrameLayout access$200(final FacebookAdapter facebookAdapter) {
        return facebookAdapter.mWrappedAdView;
    }
    
    static FrameLayout access$202(final FacebookAdapter facebookAdapter, final FrameLayout mWrappedAdView) {
        return facebookAdapter.mWrappedAdView = mWrappedAdView;
    }
    
    static MediationBannerListener access$400(final FacebookAdapter facebookAdapter) {
        return facebookAdapter.mBannerListener;
    }
    
    static void access$500(final FacebookAdapter facebookAdapter, final Context context, final String s, final MediationAdRequest mediationAdRequest) {
        facebookAdapter.createAndLoadInterstitial(context, s, mediationAdRequest);
    }
    
    static MediationInterstitialListener access$600(final FacebookAdapter facebookAdapter) {
        return facebookAdapter.mInterstitialListener;
    }
    
    static void access$700(final FacebookAdapter facebookAdapter, final Context context, final String s, final NativeMediationAdRequest nativeMediationAdRequest, final Bundle bundle) {
        facebookAdapter.createAndLoadNativeAd(context, s, nativeMediationAdRequest, bundle);
    }
    
    static MediationNativeListener access$800(final FacebookAdapter facebookAdapter) {
        return facebookAdapter.mNativeListener;
    }
    
    private void buildAdRequest(final MediationAdRequest mediationAdRequest) {
        if (mediationAdRequest != null) {
            if (mediationAdRequest.taggedForChildDirectedTreatment() == 1) {
                AdSettings.setMixedAudience(true);
            }
            else if (mediationAdRequest.taggedForChildDirectedTreatment() == 0) {
                AdSettings.setMixedAudience(false);
            }
        }
    }
    
    private void createAndLoadInterstitial(final Context context, final String s, final MediationAdRequest mediationAdRequest) {
        this.mInterstitialAd = new InterstitialAd(context, s);
        this.buildAdRequest(mediationAdRequest);
        final InterstitialAd mInterstitialAd = this.mInterstitialAd;
        mInterstitialAd.loadAd(mInterstitialAd.buildLoadAdConfig().withAdListener(new f(null)).build());
    }
    
    private void createAndLoadNativeAd(final Context context, final String s, final NativeMediationAdRequest nativeMediationAdRequest, final Bundle bundle) {
        if (bundle != null) {
            this.isNativeBanner = bundle.getBoolean("native_banner");
        }
        if (this.isNativeBanner) {
            this.mNativeBannerAd = new NativeBannerAd(context, s);
            this.buildAdRequest(nativeMediationAdRequest);
            final NativeBannerAd mNativeBannerAd = this.mNativeBannerAd;
            mNativeBannerAd.loadAd(mNativeBannerAd.buildLoadAdConfig().withAdListener(new h(context, this.mNativeBannerAd, null)).withMediaCacheFlag(NativeAdBase.MediaCacheFlag.ALL).withPreloadedIconView(-1, -1).build());
        }
        else {
            this.mMediaView = new MediaView(context);
            this.mNativeAd = new NativeAd(context, s);
            this.buildAdRequest(nativeMediationAdRequest);
            final NativeAd mNativeAd = this.mNativeAd;
            mNativeAd.loadAd(mNativeAd.buildLoadAdConfig().withAdListener(new i(context, this.mNativeAd, null)).withMediaCacheFlag(NativeAdBase.MediaCacheFlag.ALL).withPreloadedIconView(-1, -1).build());
        }
    }
    
    private com.facebook.ads.AdSize getAdSize(final Context context, AdSize a) {
        int n;
        if ((n = a.c()) < 0) {
            n = Math.round(a.d(context) / context.getResources().getDisplayMetrics().density);
        }
        final ArrayList<AdSize> list = new ArrayList<AdSize>(3);
        list.add(0, new AdSize(n, 50));
        list.add(1, new AdSize(n, 90));
        list.add(2, new AdSize(n, 250));
        final String tag = FacebookMediationAdapter.TAG;
        final StringBuilder sb = new StringBuilder();
        sb.append("Potential ad sizes: ");
        sb.append(list);
        Log.i(tag, sb.toString());
        a = MediationUtils.a(context, a, list);
        if (a == null) {
            return null;
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("Found closest ad size: ");
        sb2.append(a);
        Log.i(tag, sb2.toString());
        final int a2 = a.a();
        final com.facebook.ads.AdSize banner_HEIGHT_50 = com.facebook.ads.AdSize.BANNER_HEIGHT_50;
        if (a2 == banner_HEIGHT_50.getHeight()) {
            return banner_HEIGHT_50;
        }
        final com.facebook.ads.AdSize banner_HEIGHT_51 = com.facebook.ads.AdSize.BANNER_HEIGHT_90;
        if (a2 == banner_HEIGHT_51.getHeight()) {
            return banner_HEIGHT_51;
        }
        final com.facebook.ads.AdSize rectangle_HEIGHT_250 = com.facebook.ads.AdSize.RECTANGLE_HEIGHT_250;
        if (a2 == rectangle_HEIGHT_250.getHeight()) {
            return rectangle_HEIGHT_250;
        }
        return null;
    }
    
    @Override
    public View getBannerView() {
        return (View)this.mWrappedAdView;
    }
    
    @Override
    public void loadRewardedAd(final MediationRewardedAdConfiguration mediationRewardedAdConfiguration, final MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        Log.w(FacebookMediationAdapter.TAG, "Facebook waterfall mediation is deprecated and will be removed in a future adapter version. Please update to serve bidding ads instead. See https://fb.me/bNFn7qt6Z0sKtF for more information.");
        super.loadRewardedAd(mediationRewardedAdConfiguration, mediationAdLoadCallback);
    }
    
    @Override
    public void onDestroy() {
        final AdView mAdView = this.mAdView;
        if (mAdView != null) {
            mAdView.destroy();
        }
        final InterstitialAd mInterstitialAd = this.mInterstitialAd;
        if (mInterstitialAd != null) {
            mInterstitialAd.destroy();
        }
        final NativeAd mNativeAd = this.mNativeAd;
        if (mNativeAd != null) {
            mNativeAd.unregisterView();
            this.mNativeAd.destroy();
        }
        final MediaView mMediaView = this.mMediaView;
        if (mMediaView != null) {
            mMediaView.destroy();
        }
        final NativeBannerAd mNativeBannerAd = this.mNativeBannerAd;
        if (mNativeBannerAd != null) {
            mNativeBannerAd.unregisterView();
            this.mNativeBannerAd.destroy();
        }
    }
    
    @Override
    public void onPause() {
    }
    
    @Override
    public void onResume() {
    }
    
    @Override
    public void requestBannerAd(final Context context, final MediationBannerListener mBannerListener, final Bundle bundle, final AdSize adSize, final MediationAdRequest mediationAdRequest, final Bundle bundle2) {
        final String tag = FacebookMediationAdapter.TAG;
        Log.w(tag, "Facebook waterfall mediation is deprecated and will be removed in a future adapter version. Please update to serve bidding ads instead. See https://fb.me/bNFn7qt6Z0sKtF for more information.");
        this.mBannerListener = mBannerListener;
        final String placementID = FacebookMediationAdapter.getPlacementID(bundle);
        if (TextUtils.isEmpty((CharSequence)placementID)) {
            final AdError adError = new AdError(101, "Failed to request ad. PlacementID is null or empty.", "com.google.ads.mediation.facebook");
            Log.w(tag, adError.c());
            this.mBannerListener.onAdFailedToLoad(this, adError);
            return;
        }
        final com.facebook.ads.AdSize adSize2 = this.getAdSize(context, adSize);
        if (adSize2 == null) {
            final AdError adError2 = new AdError(102, "There is no matching Facebook ad size for Google ad size.", "com.google.ads.mediation.facebook");
            Log.w(tag, adError2.c());
            this.mBannerListener.onAdFailedToLoad(this, adError2);
            return;
        }
        a.a().b(context, placementID, (a.a)new a.a(this, context, placementID, adSize2, mediationAdRequest, adSize) {
            final Context a;
            final String b;
            final com.facebook.ads.AdSize c;
            final MediationAdRequest d;
            final AdSize e;
            final FacebookAdapter f;
            
            @Override
            public void a(final AdError adError) {
                if (FacebookAdapter.access$400(this.f) != null) {
                    FacebookAdapter.access$400(this.f).onAdFailedToLoad(this.f, adError);
                }
            }
            
            @Override
            public void b() {
                FacebookAdapter.access$002(this.f, new AdView(this.a, this.b, this.c));
                FacebookAdapter.access$100(this.f, this.d);
                final FrameLayout$LayoutParams layoutParams = new FrameLayout$LayoutParams(this.e.d(this.a), -2);
                FacebookAdapter.access$202(this.f, new FrameLayout(this.a));
                FacebookAdapter.access$000(this.f).setLayoutParams((ViewGroup$LayoutParams)layoutParams);
                FacebookAdapter.access$200(this.f).addView((View)FacebookAdapter.access$000(this.f));
                FacebookAdapter.access$000(this.f).loadAd(FacebookAdapter.access$000(this.f).buildLoadAdConfig().withAdListener(this.f.new d(null)).build());
            }
        });
    }
    
    @Override
    public void requestInterstitialAd(final Context context, final MediationInterstitialListener mInterstitialListener, final Bundle bundle, final MediationAdRequest mediationAdRequest, final Bundle bundle2) {
        Log.w(FacebookMediationAdapter.TAG, "Facebook waterfall mediation is deprecated and will be removed in a future adapter version. Please update to serve bidding ads instead. See https://fb.me/bNFn7qt6Z0sKtF for more information.");
        this.mInterstitialListener = mInterstitialListener;
        final String placementID = FacebookMediationAdapter.getPlacementID(bundle);
        if (TextUtils.isEmpty((CharSequence)placementID)) {
            this.mInterstitialListener.onAdFailedToLoad(this, new AdError(101, "Failed to request ad. PlacementID is null or empty.", "com.google.ads.mediation.facebook"));
            return;
        }
        a.a().b(context, placementID, (a.a)new a.a(this, context, placementID, mediationAdRequest) {
            final Context a;
            final String b;
            final MediationAdRequest c;
            final FacebookAdapter d;
            
            @Override
            public void a(final AdError adError) {
                if (FacebookAdapter.access$600(this.d) != null) {
                    FacebookAdapter.access$600(this.d).onAdFailedToLoad(this.d, adError);
                }
            }
            
            @Override
            public void b() {
                FacebookAdapter.access$500(this.d, this.a, this.b, this.c);
            }
        });
    }
    
    @Override
    public void requestNativeAd(final Context context, final MediationNativeListener mNativeListener, final Bundle bundle, final NativeMediationAdRequest nativeMediationAdRequest, final Bundle bundle2) {
        final String tag = FacebookMediationAdapter.TAG;
        Log.w(tag, "Facebook waterfall mediation is deprecated and will be removed in a future adapter version. Please update to serve bidding ads instead. See https://fb.me/bNFn7qt6Z0sKtF for more information.");
        this.mNativeListener = mNativeListener;
        final String placementID = FacebookMediationAdapter.getPlacementID(bundle);
        if (TextUtils.isEmpty((CharSequence)placementID)) {
            final AdError adError = new AdError(101, "Failed to request ad. PlacementID is null or empty.", "com.google.ads.mediation.facebook");
            Log.w(tag, adError.c());
            this.mNativeListener.onAdFailedToLoad(this, adError);
            return;
        }
        if (!nativeMediationAdRequest.isUnifiedNativeAdRequested()) {
            final AdError adError2 = new AdError(105, "Unified Native Ads should be requested.", "com.google.ads.mediation.facebook");
            Log.w(tag, adError2.c());
            this.mNativeListener.onAdFailedToLoad(this, adError2);
            return;
        }
        a.a().b(context, placementID, (a.a)new a.a(this, context, placementID, nativeMediationAdRequest, bundle2) {
            final Context a;
            final String b;
            final NativeMediationAdRequest c;
            final Bundle d;
            final FacebookAdapter e;
            
            @Override
            public void a(final AdError adError) {
                Log.w(FacebookMediationAdapter.TAG, adError.c());
                if (FacebookAdapter.access$800(this.e) != null) {
                    FacebookAdapter.access$800(this.e).onAdFailedToLoad(this.e, adError);
                }
            }
            
            @Override
            public void b() {
                FacebookAdapter.access$700(this.e, this.a, this.b, this.c, this.d);
            }
        });
    }
    
    @Override
    public void showInterstitial() {
        this.showInterstitialCalled.set(true);
        if (!this.mInterstitialAd.show()) {
            Log.w(FacebookMediationAdapter.TAG, new AdError(110, "Failed to present interstitial ad.", "com.google.ads.mediation.facebook").c());
            final MediationInterstitialListener mInterstitialListener = this.mInterstitialListener;
            if (mInterstitialListener != null) {
                mInterstitialListener.onAdOpened(this);
                this.mInterstitialListener.onAdClosed(this);
            }
        }
    }
    
    private class d implements AdListener
    {
        final FacebookAdapter a;
        
        private d(final FacebookAdapter a) {
            this.a = a;
        }
        
        d(final FacebookAdapter facebookAdapter, final FacebookAdapter$a a) {
            this(facebookAdapter);
        }
        
        @Override
        public void onAdClicked(final Ad ad) {
            FacebookAdapter.access$400(this.a).onAdClicked(this.a);
            FacebookAdapter.access$400(this.a).onAdOpened(this.a);
            FacebookAdapter.access$400(this.a).onAdLeftApplication(this.a);
        }
        
        @Override
        public void onAdLoaded(final Ad ad) {
            FacebookAdapter.access$400(this.a).onAdLoaded(this.a);
        }
        
        @Override
        public void onError(final Ad ad, final com.facebook.ads.AdError adError) {
            final AdError adError2 = FacebookMediationAdapter.getAdError(adError);
            Log.w(FacebookMediationAdapter.TAG, adError2.c());
            FacebookAdapter.access$400(this.a).onAdFailedToLoad(this.a, adError2);
        }
        
        @Override
        public void onLoggingImpression(final Ad ad) {
        }
    }
    
    private class e extends Image
    {
        private Drawable a;
        private Uri b;
        final FacebookAdapter c;
        
        public e(final FacebookAdapter c) {
            this.c = c;
        }
        
        public e(final FacebookAdapter c, final Drawable a) {
            this.c = c;
            this.a = a;
        }
        
        public e(final FacebookAdapter c, final Uri b) {
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
    
    private class f implements InterstitialAdExtendedListener
    {
        final FacebookAdapter a;
        
        private f(final FacebookAdapter a) {
            this.a = a;
        }
        
        f(final FacebookAdapter facebookAdapter, final FacebookAdapter$a a) {
            this(facebookAdapter);
        }
        
        @Override
        public void onAdClicked(final Ad ad) {
            FacebookAdapter.access$600(this.a).onAdClicked(this.a);
            FacebookAdapter.access$600(this.a).onAdLeftApplication(this.a);
        }
        
        @Override
        public void onAdLoaded(final Ad ad) {
            FacebookAdapter.access$600(this.a).onAdLoaded(this.a);
        }
        
        @Override
        public void onError(final Ad ad, final com.facebook.ads.AdError adError) {
            Log.w(FacebookMediationAdapter.TAG, FacebookMediationAdapter.getAdError(adError).c());
            if (FacebookAdapter.access$1000(this.a).get()) {
                FacebookAdapter.access$600(this.a).onAdOpened(this.a);
                FacebookAdapter.access$600(this.a).onAdClosed(this.a);
                return;
            }
            FacebookAdapter.access$600(this.a).onAdFailedToLoad(this.a, adError.getErrorCode());
        }
        
        @Override
        public void onInterstitialActivityDestroyed() {
            if (!FacebookAdapter.access$1100(this.a).getAndSet(true)) {
                FacebookAdapter.access$600(this.a).onAdClosed(this.a);
            }
        }
        
        @Override
        public void onInterstitialDismissed(final Ad ad) {
            if (!FacebookAdapter.access$1100(this.a).getAndSet(true)) {
                FacebookAdapter.access$600(this.a).onAdClosed(this.a);
            }
        }
        
        @Override
        public void onInterstitialDisplayed(final Ad ad) {
            FacebookAdapter.access$600(this.a).onAdOpened(this.a);
        }
        
        @Override
        public void onLoggingImpression(final Ad ad) {
        }
        
        @Override
        public void onRewardedAdCompleted() {
        }
        
        @Override
        public void onRewardedAdServerFailed() {
        }
        
        @Override
        public void onRewardedAdServerSucceeded() {
        }
    }
    
    private interface g
    {
        void a(final AdError p0);
        
        void b();
    }
    
    private class h implements AdListener, NativeAdListener
    {
        private final WeakReference<Context> a;
        private final NativeBannerAd b;
        final FacebookAdapter c;
        
        private h(final FacebookAdapter c, final Context context, final NativeBannerAd b) {
            this.c = c;
            this.a = new WeakReference<Context>(context);
            this.b = b;
        }
        
        h(final FacebookAdapter facebookAdapter, final Context context, final NativeBannerAd nativeBannerAd, final FacebookAdapter$a a) {
            this(facebookAdapter, context, nativeBannerAd);
        }
        
        @Override
        public void onAdClicked(final Ad ad) {
            FacebookAdapter.access$800(this.c).onAdClicked(this.c);
            FacebookAdapter.access$800(this.c).onAdOpened(this.c);
            FacebookAdapter.access$800(this.c).onAdLeftApplication(this.c);
        }
        
        @Override
        public void onAdLoaded(final Ad ad) {
            if (ad != this.b) {
                FacebookAdapter.access$800(this.c).onAdFailedToLoad(this.c, new AdError(106, "Ad loaded is not a native banner ad.", "com.google.ads.mediation.facebook"));
                return;
            }
            final Context context = this.a.get();
            if (context == null) {
                FacebookAdapter.access$800(this.c).onAdFailedToLoad(this.c, new AdError(107, "Failed to create ad options view. Context is null.", "com.google.ads.mediation.facebook"));
                return;
            }
            final j j = this.c.new j(this.b);
            j.S(context, new g(this, j) {
                final j a;
                final h b;
                
                @Override
                public void a(final AdError adError) {
                    Log.w(FacebookMediationAdapter.TAG, adError.c());
                    FacebookAdapter.access$800(this.b.c).onAdFailedToLoad(this.b.c, adError);
                }
                
                @Override
                public void b() {
                    FacebookAdapter.access$800(this.b.c).onAdLoaded(this.b.c, this.a);
                }
            });
        }
        
        @Override
        public void onError(final Ad ad, final com.facebook.ads.AdError adError) {
            final AdError adError2 = FacebookMediationAdapter.getAdError(adError);
            Log.w(FacebookMediationAdapter.TAG, adError2.c());
            FacebookAdapter.access$800(this.c).onAdFailedToLoad(this.c, adError2);
        }
        
        @Override
        public void onLoggingImpression(final Ad ad) {
            if (FacebookAdapter.access$1400(this.c)) {
                Log.d(FacebookMediationAdapter.TAG, "Received onLoggingImpression callback for a native whose impression is already recorded. Ignoring the duplicate callback.");
                return;
            }
            FacebookAdapter.access$800(this.c).onAdImpression(this.c);
            FacebookAdapter.access$1402(this.c, true);
        }
        
        @Override
        public void onMediaDownloaded(final Ad ad) {
            Log.d(FacebookMediationAdapter.TAG, "onMediaDownloaded");
        }
    }
    
    private class i implements AdListener, NativeAdListener
    {
        private final WeakReference<Context> a;
        private final NativeAd b;
        final FacebookAdapter c;
        
        private i(final FacebookAdapter c, final Context context, final NativeAd b) {
            this.c = c;
            this.a = new WeakReference<Context>(context);
            this.b = b;
        }
        
        i(final FacebookAdapter facebookAdapter, final Context context, final NativeAd nativeAd, final FacebookAdapter$a a) {
            this(facebookAdapter, context, nativeAd);
        }
        
        @Override
        public void onAdClicked(final Ad ad) {
            FacebookAdapter.access$800(this.c).onAdClicked(this.c);
            FacebookAdapter.access$800(this.c).onAdOpened(this.c);
            FacebookAdapter.access$800(this.c).onAdLeftApplication(this.c);
        }
        
        @Override
        public void onAdLoaded(final Ad ad) {
            if (ad != this.b) {
                final AdError adError = new AdError(106, "Ad loaded is not a native ad.", "com.google.ads.mediation.facebook");
                Log.w(FacebookMediationAdapter.TAG, adError.c());
                FacebookAdapter.access$800(this.c).onAdFailedToLoad(this.c, adError);
                return;
            }
            final Context context = this.a.get();
            if (context == null) {
                final AdError adError2 = new AdError(107, "Failed to create ad options view. Context is null", "com.google.ads.mediation.facebook");
                Log.w(FacebookMediationAdapter.TAG, adError2.c());
                FacebookAdapter.access$800(this.c).onAdFailedToLoad(this.c, adError2);
                return;
            }
            final j j = this.c.new j(this.b);
            j.S(context, new g(this, j) {
                final j a;
                final i b;
                
                @Override
                public void a(final AdError adError) {
                    Log.w(FacebookMediationAdapter.TAG, adError.c());
                    FacebookAdapter.access$800(this.b.c).onAdFailedToLoad(this.b.c, adError);
                }
                
                @Override
                public void b() {
                    FacebookAdapter.access$800(this.b.c).onAdLoaded(this.b.c, this.a);
                }
            });
        }
        
        @Override
        public void onError(final Ad ad, final com.facebook.ads.AdError adError) {
            final AdError adError2 = FacebookMediationAdapter.getAdError(adError);
            if (!TextUtils.isEmpty((CharSequence)adError.getErrorMessage())) {
                Log.w(FacebookMediationAdapter.TAG, adError2.c());
            }
            FacebookAdapter.access$800(this.c).onAdFailedToLoad(this.c, adError.getErrorCode());
        }
        
        @Override
        public void onLoggingImpression(final Ad ad) {
            if (FacebookAdapter.access$1400(this.c)) {
                Log.d(FacebookMediationAdapter.TAG, "Received onLoggingImpression callback for a native whose impression is already recorded. Ignoring the duplicate callback.");
                return;
            }
            FacebookAdapter.access$800(this.c).onAdImpression(this.c);
            FacebookAdapter.access$1402(this.c, true);
        }
        
        @Override
        public void onMediaDownloaded(final Ad ad) {
            Log.d(FacebookMediationAdapter.TAG, "onMediaDownloaded");
        }
    }
    
    class j extends UnifiedNativeAdMapper
    {
        private NativeAd s;
        private NativeBannerAd t;
        final FacebookAdapter u;
        
        public j(final FacebookAdapter u, final NativeAd s) {
            this.u = u;
            this.s = s;
        }
        
        public j(final FacebookAdapter u, final NativeBannerAd t) {
            this.u = u;
            this.t = t;
        }
        
        private boolean P(final NativeBannerAd nativeBannerAd) {
            return nativeBannerAd.getAdHeadline() != null && nativeBannerAd.getAdBodyText() != null && nativeBannerAd.getAdIcon() != null && nativeBannerAd.getAdCallToAction() != null;
        }
        
        private boolean Q(final NativeAd nativeAd) {
            return nativeAd.getAdHeadline() != null && nativeAd.getAdCoverImage() != null && nativeAd.getAdBodyText() != null && nativeAd.getAdIcon() != null && nativeAd.getAdCallToAction() != null && FacebookAdapter.access$1600(this.u) != null;
        }
        
        private Double R(final NativeAdBase.Rating rating) {
            if (rating == null) {
                return null;
            }
            return rating.getValue() * 5.0 / rating.getScale();
        }
        
        @Override
        public void I(final View view, final Map<String, View> map, final Map<String, View> map2) {
            this.E(true);
            this.D(true);
            final ArrayList list = new ArrayList();
            final Iterator<Map.Entry<String, View>> iterator = map.entrySet().iterator();
            View view2 = null;
            while (iterator.hasNext()) {
                final Map.Entry<K, View> entry = (Map.Entry<K, View>)iterator.next();
                list.add(entry.getValue());
                if (((String)entry.getKey()).equals("3003")) {
                    view2 = entry.getValue();
                }
            }
            if (!FacebookAdapter.access$1500(this.u)) {
                if (view2 instanceof ImageView) {
                    this.s.registerViewForInteraction(view, FacebookAdapter.access$1600(this.u), (ImageView)view2, list);
                }
                else {
                    Log.w(FacebookMediationAdapter.TAG, "Native icon asset is not of type ImageView.Calling registerViewForInteraction() without a reference to the icon view.");
                    this.s.registerViewForInteraction(view, FacebookAdapter.access$1600(this.u), list);
                }
                return;
            }
            if (view2 == null) {
                Log.w(FacebookMediationAdapter.TAG, "Missing or invalid native ad icon asset. Facebook impression recording might be impacted for this ad.");
                return;
            }
            if (!(view2 instanceof ImageView)) {
                Log.w(FacebookMediationAdapter.TAG, String.format("Native ad icon asset is rendered with an incompatible class type. Facebook impression recording might be impacted for this ad. Expected: ImageView, actual: %s.", view2.getClass()));
                return;
            }
            this.t.registerViewForInteraction(view, (ImageView)view2);
        }
        
        @Override
        public void J(final View view) {
            Label_0039: {
                if (FacebookAdapter.access$1500(this.u)) {
                    final NativeBannerAd t = this.t;
                    if (t != null) {
                        t.unregisterView();
                        break Label_0039;
                    }
                }
                final NativeAd s = this.s;
                if (s != null) {
                    s.unregisterView();
                }
            }
            super.J(view);
        }
        
        public void S(final Context context, final g g) {
            if (FacebookAdapter.access$1500(this.u)) {
                if (!this.P(this.t)) {
                    final AdError adError = new AdError(108, "Ad from Facebook doesn't have all assets required for the Native Banner Ad format.", "com.google.ads.mediation.facebook");
                    Log.w(FacebookMediationAdapter.TAG, adError.c());
                    g.a(adError);
                    return;
                }
                this.z(this.t.getAdHeadline());
                this.v(this.t.getAdBodyText());
                if (this.t.getPreloadedIconViewDrawable() == null) {
                    if (this.t.getAdIcon() == null) {
                        this.A(this.u.new e());
                    }
                    else {
                        this.A(this.u.new e(Uri.parse(this.t.getAdIcon().getUrl())));
                    }
                }
                else {
                    this.A(this.u.new e(this.t.getPreloadedIconViewDrawable()));
                }
                this.w(this.t.getAdCallToAction());
                this.u(this.t.getAdvertiserName());
                final Bundle bundle = new Bundle();
                bundle.putCharSequence("id", (CharSequence)this.t.getId());
                bundle.putCharSequence("social_context", (CharSequence)this.t.getAdSocialContext());
                this.x(bundle);
            }
            else {
                if (!this.Q(this.s)) {
                    final AdError adError2 = new AdError(108, "Ad from Facebook doesn't have all assets required for the Native Banner Ad format.", "com.google.ads.mediation.facebook");
                    Log.w(FacebookMediationAdapter.TAG, adError2.c());
                    g.a(adError2);
                    return;
                }
                this.z(this.s.getAdHeadline());
                final ArrayList list = new ArrayList();
                list.add(this.u.new e(Uri.parse(this.s.getAdCoverImage().getUrl())));
                this.B(list);
                this.v(this.s.getAdBodyText());
                if (this.s.getPreloadedIconViewDrawable() == null) {
                    if (this.s.getAdIcon() == null) {
                        this.A(this.u.new e());
                    }
                    else {
                        this.A(this.u.new e(Uri.parse(this.s.getAdIcon().getUrl())));
                    }
                }
                else {
                    this.A(this.u.new e(this.s.getPreloadedIconViewDrawable()));
                }
                this.w(this.s.getAdCallToAction());
                this.u(this.s.getAdvertiserName());
                FacebookAdapter.access$1600(this.u).setListener(new MediaViewListener(this) {
                    final j a;
                    
                    @Override
                    public void onComplete(final MediaView mediaView) {
                        if (FacebookAdapter.access$800(this.a.u) != null) {
                            FacebookAdapter.access$800(this.a.u).onVideoEnd(this.a.u);
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
                this.C((View)FacebookAdapter.access$1600(this.u));
                this.y(true);
                final Double r = this.R(this.s.getAdStarRating());
                if (r != null) {
                    this.G(r);
                }
                final Bundle bundle2 = new Bundle();
                bundle2.putCharSequence("id", (CharSequence)this.s.getId());
                bundle2.putCharSequence("social_context", (CharSequence)this.s.getAdSocialContext());
                this.x(bundle2);
            }
            final NativeAdLayout nativeAdLayout = new NativeAdLayout(context);
            AdOptionsView adOptionsView;
            if (FacebookAdapter.access$1500(this.u)) {
                adOptionsView = new AdOptionsView(context, this.t, nativeAdLayout);
            }
            else {
                adOptionsView = new AdOptionsView(context, this.s, nativeAdLayout);
            }
            this.t((View)adOptionsView);
            g.b();
        }
    }
}
