// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads.internal.dynamicloading;

import com.facebook.ads.AdError;
import android.os.Handler;
import android.os.Looper;
import java.util.Iterator;
import java.lang.reflect.Proxy;
import java.lang.reflect.Array;
import java.util.List;
import java.lang.reflect.InvocationHandler;
import com.facebook.ads.RewardedVideoAdListener;
import com.facebook.ads.InterstitialAdListener;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.internal.api.AdViewApi;
import com.facebook.ads.internal.api.RewardedVideoAdApi;
import com.facebook.ads.internal.api.InterstitialAdApi;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeBannerAd;
import com.facebook.ads.internal.api.NativeAdBaseApi;
import com.facebook.ads.NativeAd;
import com.facebook.ads.AdView;
import com.facebook.ads.internal.api.AdViewParentApi;
import com.facebook.ads.AdSize;
import com.facebook.ads.RewardedVideoAd;
import com.facebook.ads.InterstitialAd;
import android.content.Context;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import com.facebook.ads.Ad;
import java.util.Map;
import java.lang.reflect.Method;
import com.facebook.ads.AdListener;
import java.util.WeakHashMap;
import androidx.annotation.Keep;

@Keep
class DynamicLoaderFallback
{
    private static final WeakHashMap<Object, AdListener> sApiProxyToAdListenersMap;
    
    static {
        sApiProxyToAdListenersMap = new WeakHashMap<Object, AdListener>();
    }
    
    static boolean access$100(final Method method, final Method method2) {
        return equalsMethods(method, method2);
    }
    
    static boolean access$200(final Object o, final Map map) {
        return reportError(o, map);
    }
    
    static WeakHashMap access$300() {
        return DynamicLoaderFallback.sApiProxyToAdListenersMap;
    }
    
    private static boolean equalsMethodParams(final Method method, final Method method2) {
        return Arrays.equals(method.getParameterTypes(), method2.getParameterTypes());
    }
    
    private static boolean equalsMethods(final Method method, final Method method2) {
        return method != null && method2 != null && method.getDeclaringClass().equals(method2.getDeclaringClass()) && method.getName().equals(method2.getName()) && equalsMethodParams(method, method2);
    }
    
    static DynamicLoader makeFallbackLoader() {
        Object o = new ArrayList();
        final ArrayList list = new ArrayList();
        final ArrayList list2 = new ArrayList();
        final ArrayList list3 = new ArrayList();
        final ArrayList list4 = new ArrayList();
        final HashMap hashMap = new HashMap();
        final HashMap hashMap2 = new HashMap();
        final c c = new c(null);
        Object b = c.c(DynamicLoader.class);
        ((DynamicLoader)b).createInterstitialAd(null, null, null);
        list4.add(c.b());
        ((DynamicLoader)b).createRewardedVideoAd(null, null, null);
        list4.add(c.b());
        ((DynamicLoader)b).createAdViewApi(null, null, null, (AdViewParentApi)null, (AdView)null);
        list4.add(c.b());
        while (true) {
            try {
                ((DynamicLoader)b).createAdViewApi(null, null, null, (AdViewParentApi)null, (AdView)null);
                list4.add(c.b());
                ((DynamicLoader)b).createNativeAdApi(null, null);
                final Method b2 = c.b();
                ((DynamicLoader)b).createNativeBannerAdApi(null, null);
                b = c.b();
                final NativeAdBaseApi nativeAdBaseApi = c.c(NativeAdBaseApi.class);
                nativeAdBaseApi.loadAd();
                ((List<Method>)o).add(c.b());
                nativeAdBaseApi.loadAd(null);
                list.add(c.b());
                nativeAdBaseApi.buildLoadAdConfig(null);
                list3.add(c.b());
                final InterstitialAdApi interstitialAdApi = c.c(InterstitialAdApi.class);
                interstitialAdApi.loadAd();
                ((List<Method>)o).add(c.b());
                interstitialAdApi.loadAd(null);
                list.add(c.b());
                interstitialAdApi.buildLoadAdConfig();
                list3.add(c.b());
                final RewardedVideoAdApi rewardedVideoAdApi = c.c(RewardedVideoAdApi.class);
                rewardedVideoAdApi.loadAd();
                ((List<Method>)o).add(c.b());
                rewardedVideoAdApi.loadAd(null);
                list.add(c.b());
                rewardedVideoAdApi.buildLoadAdConfig();
                list3.add(c.b());
                final AdViewApi adViewApi = c.c(AdViewApi.class);
                adViewApi.loadAd();
                ((List<Method>)o).add(c.b());
                adViewApi.loadAd(null);
                list.add(c.b());
                adViewApi.buildLoadAdConfig();
                list3.add(c.b());
                c.c(AdView.AdViewLoadConfigBuilder.class).withAdListener(null);
                list2.add(c.b());
                c.c(NativeAdBase.NativeAdLoadConfigBuilder.class).withAdListener(null);
                list2.add(c.b());
                c.c(InterstitialAd.InterstitialAdLoadConfigBuilder.class).withAdListener(null);
                list2.add(c.b());
                c.c(RewardedVideoAd.RewardedVideoAdLoadConfigBuilder.class).withAdListener(null);
                list2.add(c.b());
                o = new InvocationHandler(o, hashMap, list, list2, hashMap2, list3, list4, b2, b) {
                    final List a;
                    final Map b;
                    final List c;
                    final List d;
                    final Map e;
                    final List f;
                    final List g;
                    final Method h;
                    final Method i;
                    
                    @Override
                    public Object invoke(Object o, final Method method, final Object[] array) {
                        if (method.getReturnType().isPrimitive()) {
                            if (method.getReturnType().equals(Void.TYPE)) {
                                final Iterator iterator = this.a.iterator();
                                while (iterator.hasNext() && (!DynamicLoaderFallback.access$100(method, (Method)iterator.next()) || !DynamicLoaderFallback.access$200(o, this.b))) {}
                                final Iterator iterator2 = this.c.iterator();
                                while (iterator2.hasNext() && (!DynamicLoaderFallback.access$100(method, (Method)iterator2.next()) || !DynamicLoaderFallback.access$200(o, this.b))) {}
                                return null;
                            }
                            return Array.get(Array.newInstance(method.getReturnType(), 1), 0);
                        }
                        else {
                            if (method.getReturnType().equals(String.class)) {
                                return "";
                            }
                            Object proxyInstance;
                            if (method.getReturnType().equals(o.getClass().getInterfaces()[0])) {
                                proxyInstance = o;
                            }
                            else {
                                proxyInstance = Proxy.newProxyInstance(DynamicLoaderFallback.class.getClassLoader(), new Class[] { method.getReturnType() }, this);
                            }
                            final Iterator iterator3 = this.d.iterator();
                            while (iterator3.hasNext()) {
                                if (DynamicLoaderFallback.access$100(method, (Method)iterator3.next())) {
                                    DynamicLoaderFallback.access$300().put(this.e.get(o), array[0]);
                                    break;
                                }
                            }
                            final Iterator iterator4 = this.f.iterator();
                            while (iterator4.hasNext()) {
                                if (DynamicLoaderFallback.access$100(method, (Method)iterator4.next())) {
                                    this.e.put(proxyInstance, o);
                                }
                            }
                            final Iterator iterator5 = this.g.iterator();
                            while (iterator5.hasNext()) {
                                if (DynamicLoaderFallback.access$100(method, (Method)iterator5.next())) {
                                    for (int length = array.length, i = 0; i < length; ++i) {
                                        o = array[i];
                                        if (o instanceof Ad) {
                                            this.b.put(proxyInstance, o);
                                        }
                                    }
                                }
                            }
                            if (DynamicLoaderFallback.access$100(method, this.h)) {
                                this.b.put(array[1], array[0]);
                            }
                            if (DynamicLoaderFallback.access$100(method, this.i)) {
                                this.b.put(array[1], array[0]);
                            }
                            return proxyInstance;
                        }
                    }
                };
                return (DynamicLoader)Proxy.newProxyInstance(DynamicLoaderFallback.class.getClassLoader(), new Class[] { DynamicLoader.class }, (InvocationHandler)o);
            }
            catch (final Exception ex) {
                continue;
            }
            break;
        }
    }
    
    private static boolean reportError(final Object o, final Map<Object, Ad> map) {
        if (o == null) {
            return false;
        }
        final AdListener adListener = DynamicLoaderFallback.sApiProxyToAdListenersMap.get(o);
        final Ad ad = map.get(o);
        if (adListener != null) {
            new Handler(Looper.getMainLooper()).postDelayed((Runnable)new Runnable(adListener, ad) {
                final AdListener a;
                final Ad b;
                
                @Override
                public void run() {
                    this.a.onError(this.b, new AdError(-1, "Can't load Audience Network Dex. Please, check that audience_network.dex is inside of assets folder."));
                }
            }, 500L);
            return true;
        }
        return false;
    }
    
    private static class c
    {
        private Method a;
        private final InvocationHandler b;
        
        private c() {
            this.b = new InvocationHandler() {
                final c a;
                
                @Override
                public Object invoke(final Object o, final Method method, final Object[] array) {
                    if (!"toString".equals(method.getName())) {
                        c.a(this.a, method);
                    }
                    return null;
                }
            };
        }
        
        c(final DynamicLoaderFallback$a invocationHandler) {
            this();
        }
        
        static Method a(final c c, final Method a) {
            return c.a = a;
        }
        
        Method b() {
            return this.a;
        }
        
        public <T> T c(final Class<T> clazz) {
            return clazz.cast(Proxy.newProxyInstance(DynamicLoaderFallback.class.getClassLoader(), new Class[] { clazz }, this.b));
        }
    }
}
