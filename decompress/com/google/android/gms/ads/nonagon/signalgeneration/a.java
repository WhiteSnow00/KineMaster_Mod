// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.nonagon.signalgeneration;

import java.util.concurrent.Future;
import org.json.JSONException;
import android.view.MotionEvent;
import org.json.JSONObject;
import android.app.Activity;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdFormat;
import android.os.Bundle;
import java.util.UUID;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Callable;
import com.google.android.gms.internal.ads.zzcfv;
import com.google.android.gms.common.annotation.KeepForSdk;
import android.webkit.JavascriptInterface;
import com.google.android.gms.internal.ads.zzcfi;
import com.google.android.gms.internal.ads.zzdwb;
import android.util.Pair;
import android.view.View;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.internal.ads.zzbhy;
import com.google.android.gms.internal.ads.zzdwl;
import com.google.android.gms.internal.ads.zzaoc;
import android.webkit.WebView;
import android.content.Context;

final class a
{
    private final Context a;
    private final WebView b;
    private final zzaoc c;
    private final int d;
    private final zzdwl e;
    private final boolean f;
    
    a(final WebView b, final zzaoc c, final zzdwl e) {
        this.b = b;
        final Context context = b.getContext();
        this.a = context;
        this.c = c;
        this.e = e;
        zzbhy.zzc(context);
        this.d = (int)zzay.c().zzb(zzbhy.zzhM);
        this.f = (boolean)zzay.c().zzb(zzbhy.zzhN);
    }
    
    static /* bridge */ WebView a(final a a) {
        return a.b;
    }
    
    @JavascriptInterface
    @KeepForSdk
    public String getClickSignals(final String s) {
        try {
            final long a = zzt.a().a();
            final String zze = this.c.zzc().zze(this.a, s, (View)this.b);
            if (this.f) {
                zzf.c(this.e, null, "csg", new Pair((Object)"clat", (Object)String.valueOf(zzt.a().a() - a)));
            }
            return zze;
        }
        catch (final RuntimeException ex) {
            zzcfi.zzh("Exception getting click signals. ", (Throwable)ex);
            zzt.p().zzt((Throwable)ex, "TaggingLibraryJsInterface.getClickSignals");
            return "";
        }
    }
    
    @JavascriptInterface
    @KeepForSdk
    public String getClickSignalsWithTimeout(String zzb, int min) {
        if (min <= 0) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Invalid timeout for getting click signals. Timeout=");
            sb.append(min);
            zzcfi.zzg(sb.toString());
            return "";
        }
        min = Math.min(min, this.d);
        zzb = (ExecutionException)zzcfv.zza.zzb((Callable)new zzan(this, (String)zzb));
        final long n = min;
        try {
            zzb = (ExecutionException)((Future<Object>)zzb).get(n, TimeUnit.MILLISECONDS);
            return (String)zzb;
        }
        catch (final ExecutionException zzb) {}
        catch (final TimeoutException zzb) {}
        catch (final InterruptedException ex) {}
        zzcfi.zzh("Exception getting click signals with timeout. ", (Throwable)zzb);
        zzt.p().zzt((Throwable)zzb, "TaggingLibraryJsInterface.getClickSignalsWithTimeout");
        if (zzb instanceof TimeoutException) {
            return "17";
        }
        return "";
    }
    
    @JavascriptInterface
    @KeepForSdk
    public String getQueryInfo() {
        zzt.q();
        final String string = UUID.randomUUID().toString();
        final Bundle bundle = new Bundle();
        bundle.putString("query_info_type", "requester_type_6");
        final Context a = this.a;
        final AdFormat banner = AdFormat.BANNER;
        final AdRequest.Builder builder = new AdRequest.Builder();
        builder.b(AdMobAdapter.class, bundle);
        QueryInfo.a(a, banner, builder.c(), new b(this, string));
        return string;
    }
    
    @JavascriptInterface
    @KeepForSdk
    public String getViewSignals() {
        try {
            final long a = zzt.a().a();
            final String zzh = this.c.zzc().zzh(this.a, (View)this.b, (Activity)null);
            if (this.f) {
                zzf.c(this.e, null, "vsg", new Pair((Object)"vlat", (Object)String.valueOf(zzt.a().a() - a)));
            }
            return zzh;
        }
        catch (final RuntimeException ex) {
            zzcfi.zzh("Exception getting view signals. ", (Throwable)ex);
            zzt.p().zzt((Throwable)ex, "TaggingLibraryJsInterface.getViewSignals");
            return "";
        }
    }
    
    @JavascriptInterface
    @KeepForSdk
    public String getViewSignalsWithTimeout(int min) {
        if (min <= 0) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Invalid timeout for getting view signals. Timeout=");
            sb.append(min);
            zzcfi.zzg(sb.toString());
            return "";
        }
        min = Math.min(min, this.d);
        Object zzb = zzcfv.zza.zzb((Callable)new zzam(this));
        final long n = min;
        try {
            zzb = ((Future<String>)zzb).get(n, TimeUnit.MILLISECONDS);
            return (String)zzb;
        }
        catch (final ExecutionException zzb) {}
        catch (final TimeoutException zzb) {}
        catch (final InterruptedException ex) {}
        zzcfi.zzh("Exception getting view signals with timeout. ", (Throwable)zzb);
        zzt.p().zzt((Throwable)zzb, "TaggingLibraryJsInterface.getViewSignalsWithTimeout");
        if (zzb instanceof TimeoutException) {
            return "17";
        }
        return "";
    }
    
    @JavascriptInterface
    @KeepForSdk
    public void reportTouchEvent(String obtain) {
        try {
            final JSONObject jsonObject = new JSONObject((String)obtain);
            final int int1 = jsonObject.getInt("x");
            final int int2 = jsonObject.getInt("y");
            final int int3 = jsonObject.getInt("duration_ms");
            final float n = (float)jsonObject.getDouble("force");
            final int int4 = jsonObject.getInt("type");
            int n2;
            if (int4 != 0) {
                if (int4 != 1) {
                    if (int4 != 2) {
                        if (int4 != 3) {
                            n2 = -1;
                        }
                        else {
                            n2 = 3;
                        }
                    }
                    else {
                        n2 = 2;
                    }
                }
                else {
                    n2 = 1;
                }
            }
            else {
                n2 = 0;
            }
            obtain = (JSONException)MotionEvent.obtain(0L, (long)int3, n2, (float)int1, (float)int2, n, 1.0f, 0, 1.0f, 1.0f, 0, 0);
            try {
                this.c.zzd((MotionEvent)obtain);
                return;
            }
            catch (final JSONException obtain) {}
            catch (final RuntimeException obtain) {}
        }
        catch (final JSONException obtain) {}
        catch (final RuntimeException ex) {}
        zzcfi.zzh("Failed to parse the touch string. ", (Throwable)obtain);
        zzt.p().zzt((Throwable)obtain, "TaggingLibraryJsInterface.reportTouchEvent");
    }
}
