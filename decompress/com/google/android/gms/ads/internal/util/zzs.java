// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.util;

import android.widget.FrameLayout;
import java.util.concurrent.Future;
import java.util.concurrent.Callable;
import com.google.android.gms.internal.ads.zzfva;
import com.google.android.gms.internal.ads.zzfvj;
import com.google.android.gms.internal.ads.zzbhq;
import com.google.android.gms.internal.ads.zzgqi;
import androidx.browser.customtabs.d;
import com.google.android.gms.internal.ads.zzbiu;
import com.google.android.gms.internal.ads.zzbiw;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import java.util.regex.PatternSyntaxException;
import java.util.regex.Pattern;
import android.content.pm.PackageManager$NameNotFoundException;
import android.content.ActivityNotFoundException;
import com.google.android.gms.ads.internal.client.zzaw;
import java.net.HttpURLConnection;
import android.net.Uri;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.internal.ads.zzbjw;
import java.util.ArrayList;
import com.google.android.gms.internal.ads.zzfbj;
import com.google.android.gms.internal.ads.zzfbg;
import com.google.android.gms.internal.ads.zzckz;
import com.google.android.gms.internal.ads.zzcmf;
import com.google.android.gms.ads.nativead.NativeAdView;
import com.google.android.gms.ads.formats.zzg;
import com.google.android.gms.internal.ads.zzdtr;
import android.view.MotionEvent;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;
import android.os.PowerManager;
import android.app.ActivityManager$RunningAppProcessInfo;
import android.app.ActivityManager;
import android.os.Process;
import android.app.KeyguardManager;
import com.google.android.gms.internal.ads.zzbhy;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.internal.ads.zzcfh;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzcai;
import android.os.IInterface;
import android.content.res.Resources;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.internal.ads.zzcfi;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.util.concurrent.TimeUnit;
import java.util.Map;
import com.google.android.gms.ads.internal.zzt;
import java.util.HashMap;
import android.webkit.WebResourceResponse;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.os.Build;
import java.util.Locale;
import android.os.Build$VERSION;
import android.view.ViewGroup$LayoutParams;
import android.os.IBinder;
import android.os.Bundle;
import android.content.Intent;
import android.view.Window;
import android.content.Context;
import android.view.WindowManager$LayoutParams;
import android.app.Activity;
import android.view.View;
import com.google.android.gms.internal.ads.zzcfv;
import java.util.concurrent.Executors;
import android.os.Looper;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
import java.util.concurrent.atomic.AtomicReference;
import com.google.android.gms.internal.ads.zzfnu;

public final class zzs
{
    public static final zzfnu i;
    private final AtomicReference a;
    private final AtomicReference b;
    private boolean c;
    private final Object d;
    @GuardedBy
    private String e;
    private boolean f;
    private boolean g;
    private final Executor h;
    
    static {
        i = new zzf(Looper.getMainLooper());
    }
    
    public zzs() {
        this.a = new AtomicReference(null);
        this.b = new AtomicReference(null);
        this.c = true;
        this.d = new Object();
        this.f = false;
        this.g = false;
        this.h = Executors.newSingleThreadExecutor();
    }
    
    public static void B(final Runnable runnable) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            runnable.run();
            return;
        }
        ((Executor)zzcfv.zza).execute(runnable);
    }
    
    public static final boolean H(View rootView) {
        rootView = rootView.getRootView();
        final WindowManager$LayoutParams windowManager$LayoutParams = null;
        Activity activity = null;
        Label_0033: {
            if (rootView != null) {
                final Context context = rootView.getContext();
                if (context instanceof Activity) {
                    activity = (Activity)context;
                    break Label_0033;
                }
            }
            activity = null;
        }
        if (activity == null) {
            return false;
        }
        final Window window = activity.getWindow();
        WindowManager$LayoutParams attributes;
        if (window == null) {
            attributes = windowManager$LayoutParams;
        }
        else {
            attributes = window.getAttributes();
        }
        return attributes != null && (attributes.flags & 0x80000) != 0x0;
    }
    
    public static final void I(final Context context, final Intent intent) {
        if (intent == null) {
            return;
        }
        Bundle extras;
        if (intent.getExtras() != null) {
            extras = intent.getExtras();
        }
        else {
            extras = new Bundle();
        }
        extras.putBinder("android.support.customtabs.extra.SESSION", (IBinder)null);
        extras.putString("com.android.browser.application_id", context.getPackageName());
        intent.putExtras(extras);
    }
    
    public static final ViewGroup$LayoutParams J() {
        return new ViewGroup$LayoutParams(-1, -1);
    }
    
    public static final String K(final Context context) {
        Context applicationContext = context;
        if (context.getApplicationContext() != null) {
            applicationContext = context.getApplicationContext();
        }
        return u(t(applicationContext));
    }
    
    static final String L() {
        final StringBuilder sb = new StringBuilder(256);
        sb.append("Mozilla/5.0 (Linux; U; Android");
        final String release = Build$VERSION.RELEASE;
        if (release != null) {
            sb.append(" ");
            sb.append(release);
        }
        sb.append("; ");
        sb.append(Locale.getDefault());
        final String device = Build.DEVICE;
        if (device != null) {
            sb.append("; ");
            sb.append(device);
            final String display = Build.DISPLAY;
            if (display != null) {
                sb.append(" Build/");
                sb.append(display);
            }
        }
        sb.append(") AppleWebKit/533 Version/4.0 Safari/533");
        return sb.toString();
    }
    
    public static final String M() {
        final String manufacturer = Build.MANUFACTURER;
        final String model = Build.MODEL;
        if (model.startsWith(manufacturer)) {
            return model;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(manufacturer);
        sb.append(" ");
        sb.append(model);
        return sb.toString();
    }
    
    public static final DisplayMetrics N(final WindowManager windowManager) {
        final DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }
    
    protected static final int[] O() {
        return new int[] { 0, 0 };
    }
    
    public static final long P(View parent) {
        float n = Float.MAX_VALUE;
        float min;
        float n2;
        do {
            final boolean b = parent instanceof View;
            n2 = 0.0f;
            min = n;
            if (!b) {
                break;
            }
            parent = parent;
            min = Math.min(n, ((View)parent).getAlpha());
            parent = ((View)parent).getParent();
            n = min;
        } while (min > 0.0f);
        if (min < 0.0f) {
            min = n2;
        }
        return Math.round(min * 100.0f);
    }
    
    public static final WebResourceResponse Q(Context ex, String s, final String s2) {
        try {
            final HashMap hashMap = new HashMap();
            hashMap.put("User-Agent", zzt.q().y((Context)ex, s));
            hashMap.put("Cache-Control", "max-stale=3600");
            s = (String)((Future<Object>)new zzbo((Context)ex).b(0, s2, hashMap, null)).get(60L, TimeUnit.SECONDS);
            if (s != null) {
                ex = (TimeoutException)new ByteArrayInputStream(s.getBytes("UTF-8"));
                ex = (TimeoutException)new WebResourceResponse("application/javascript", "UTF-8", (InputStream)ex);
                return (WebResourceResponse)ex;
            }
            return null;
        }
        catch (final TimeoutException ex) {}
        catch (final InterruptedException ex) {}
        catch (final ExecutionException ex) {}
        catch (final IOException ex2) {}
        zzcfi.zzk("Could not fetch MRAID JS.", (Throwable)ex);
        return null;
    }
    
    public static final String R() {
        final Resources zzd = zzt.p().zzd();
        String string;
        if (zzd != null) {
            string = zzd.getString(R.string.n);
        }
        else {
            string = "Test Ad";
        }
        return string;
    }
    
    public static final zzbr S(final Context context) {
        final zzbr zzbr = null;
        try {
            final Object instance = context.getClassLoader().loadClass("com.google.android.gms.ads.internal.util.WorkManagerUtil").getDeclaredConstructor((Class<?>[])new Class[0]).newInstance(new Object[0]);
            if (!(instance instanceof IBinder)) {
                zzcfi.zzg("Instantiated WorkManagerUtil not instance of IBinder.");
                return null;
            }
            final IBinder binder = (IBinder)instance;
            zzbr zzbr2;
            if (binder == null) {
                zzbr2 = zzbr;
            }
            else {
                final IInterface queryLocalInterface = binder.queryLocalInterface("com.google.android.gms.ads.internal.util.IWorkManagerUtil");
                if (queryLocalInterface instanceof zzbr) {
                    zzbr2 = (zzbr)queryLocalInterface;
                }
                else {
                    zzbr2 = new zzbp(binder);
                }
            }
            return zzbr2;
        }
        catch (final Exception ex) {
            zzt.p().zzt((Throwable)ex, "Failed to instantiate WorkManagerUtil");
            return null;
        }
    }
    
    public static final boolean T(final Context context, final String s) {
        final Context zza = zzcai.zza(context);
        return Wrappers.a(zza).b(s, zza.getPackageName()) == 0;
    }
    
    public static final boolean U(final String s) {
        if (!zzcfh.zzl()) {
            return false;
        }
        if (!(boolean)zzay.c().zzb(zzbhy.zzdW)) {
            return false;
        }
        final String s2 = (String)zzay.c().zzb(zzbhy.zzdY);
        if (!s2.isEmpty()) {
            final String[] split = s2.split(";");
            for (int length = split.length, i = 0; i < length; ++i) {
                if (split[i].equals(s)) {
                    return false;
                }
            }
        }
        final String s3 = (String)zzay.c().zzb(zzbhy.zzdX);
        if (s3.isEmpty()) {
            return true;
        }
        final String[] split2 = s3.split(";");
        for (int length2 = split2.length, j = 0; j < length2; ++j) {
            if (split2[j].equals(s)) {
                return true;
            }
        }
        return false;
    }
    
    public static final boolean V(final Context context) {
        if (context == null) {
            return false;
        }
        final KeyguardManager s = s(context);
        return s != null && s.isKeyguardLocked();
    }
    
    public static final boolean a(final Context context) {
        try {
            context.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi");
            return false;
        }
        catch (final ClassNotFoundException ex) {
            return true;
        }
        finally {
            final Throwable t;
            zzcfi.zzh("Error loading class.", t);
            zzt.p().zzt(t, "AdUtil.isLiteSdk");
            return false;
        }
    }
    
    public static final boolean b() {
        final int myUid = Process.myUid();
        return myUid == 0 || myUid == 1000;
    }
    
    public static final boolean c(final Context context) {
        try {
            final ActivityManager activityManager = (ActivityManager)context.getSystemService("activity");
            final KeyguardManager keyguardManager = (KeyguardManager)context.getSystemService("keyguard");
            if (activityManager != null) {
                if (keyguardManager != null) {
                    final List runningAppProcesses = activityManager.getRunningAppProcesses();
                    if (runningAppProcesses == null) {
                        return false;
                    }
                    for (final ActivityManager$RunningAppProcessInfo activityManager$RunningAppProcessInfo : runningAppProcesses) {
                        if (Process.myPid() == activityManager$RunningAppProcessInfo.pid) {
                            if (activityManager$RunningAppProcessInfo.importance != 100 || keyguardManager.inKeyguardRestrictedInputMode()) {
                                break;
                            }
                            final PowerManager powerManager = (PowerManager)context.getSystemService("power");
                            if (powerManager == null) {
                                break;
                            }
                            if (powerManager.isScreenOn()) {
                                return false;
                            }
                            break;
                        }
                    }
                    return true;
                }
            }
            return false;
        }
        finally {
            return false;
        }
    }
    
    public static final boolean d(final Context context) {
        final Bundle t = t(context);
        final String string = t.getString("com.google.android.gms.ads.INTEGRATION_MANAGER");
        return TextUtils.isEmpty((CharSequence)u(t)) && !TextUtils.isEmpty((CharSequence)string);
    }
    
    public static final boolean e(final Context context) {
        if (!(context instanceof Activity)) {
            return false;
        }
        final Window window = ((Activity)context).getWindow();
        if (window != null) {
            if (window.getDecorView() != null) {
                final Rect rect = new Rect();
                final Rect rect2 = new Rect();
                window.getDecorView().getGlobalVisibleRect(rect, (Point)null);
                window.getDecorView().getWindowVisibleDisplayFrame(rect2);
                if (rect.bottom != 0 && rect2.bottom != 0 && rect.top == rect2.top) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static final void f(final View view, final int n, final MotionEvent motionEvent) {
        final int[] array = new int[2];
        final Rect rect = new Rect();
        try {
            final String packageName = view.getContext().getPackageName();
            View child = view;
            if (view instanceof zzdtr) {
                child = ((FrameLayout)view).getChildAt(0);
            }
            String s;
            boolean b;
            if (!(child instanceof zzg) && !(child instanceof NativeAdView)) {
                s = "UNKNOWN";
                b = false;
            }
            else {
                s = "NATIVE";
                b = true;
            }
            int width;
            int height;
            if (child.getLocalVisibleRect(rect)) {
                width = rect.width();
                height = rect.height();
            }
            else {
                height = 0;
                width = 0;
            }
            zzt.q();
            final long p3 = P(child);
            child.getLocationOnScreen(array);
            final int n2 = array[0];
            final int n3 = array[1];
            final boolean b2 = child instanceof zzcmf;
            final String s2 = "none";
            String zzb = null;
            Label_0240: {
                if (b2) {
                    final zzfbj zzR = ((zzcmf)child).zzR();
                    if (zzR != null) {
                        zzb = zzR.zzb;
                        final int hashCode = child.hashCode();
                        final StringBuilder sb = new StringBuilder();
                        sb.append(zzb);
                        sb.append(":");
                        sb.append(hashCode);
                        child.setContentDescription((CharSequence)sb.toString());
                        break Label_0240;
                    }
                }
                zzb = "none";
            }
            String zza = s;
            int zzf = b ? 1 : 0;
            String zzF = s2;
            if (child instanceof zzckz) {
                final zzfbg zzF2 = ((zzckz)child).zzF();
                zza = s;
                zzf = (b ? 1 : 0);
                zzF = s2;
                if (zzF2 != null) {
                    zza = zzfbg.zza(zzF2.zzb);
                    zzf = zzF2.zzf;
                    zzF = zzF2.zzF;
                }
            }
            zzcfi.zzi(String.format(Locale.US, "<Ad hashCode=%d, package=%s, adNetCls=%s, gwsQueryId=%s, format=%s, impType=%d, class=%s, x=%d, y=%d, width=%d, height=%d, vWidth=%d, vHeight=%d, alpha=%d, state=%s>", child.hashCode(), packageName, zzF, zzb, zza, zzf, ((zzckz)child).getClass().getName(), n2, n3, child.getWidth(), child.getHeight(), width, height, p3, Integer.toString(n, 2)));
        }
        catch (final Exception ex) {
            zzcfi.zzh("Failure getting view location.", (Throwable)ex);
        }
    }
    
    public static final void g(final Context context, final String s, final String s2) {
        final ArrayList list = new ArrayList();
        list.add(s2);
        final Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            new zzby(context, s, (String)iterator.next()).zzb();
        }
    }
    
    public static final void h(final Context context, final Throwable t) {
        if (context == null) {
            return;
        }
        try {
            if (zzbjw.zzb.zze()) {
                CrashUtils.a(context, t);
            }
        }
        catch (final IllegalStateException ex) {}
    }
    
    public static final void i(final Context context, final Intent intent) {
        try {
            context.startActivity(intent);
        }
        finally {
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }
    
    public static final int j(final String s) {
        try {
            return Integer.parseInt(s);
        }
        catch (final NumberFormatException ex) {
            zzcfi.zzj("Could not parse value:".concat(ex.toString()));
            return 0;
        }
    }
    
    public static final Map k(final Uri uri) {
        if (uri == null) {
            return null;
        }
        final HashMap hashMap = new HashMap();
        for (final String s : uri.getQueryParameterNames()) {
            if (!TextUtils.isEmpty((CharSequence)s)) {
                hashMap.put(s, uri.getQueryParameter(s));
            }
        }
        return hashMap;
    }
    
    public static final WebResourceResponse l(final HttpURLConnection httpURLConnection) throws IOException {
        zzt.q();
        final String contentType = httpURLConnection.getContentType();
        final boolean empty = TextUtils.isEmpty((CharSequence)contentType);
        final String s = "";
        String trim;
        if (empty) {
            trim = "";
        }
        else {
            trim = contentType.split(";")[0].trim();
        }
        zzt.q();
        final String contentType2 = httpURLConnection.getContentType();
        String trim2 = null;
        Label_0065: {
            if (TextUtils.isEmpty((CharSequence)contentType2)) {
                trim2 = s;
            }
            else {
                final String[] split = contentType2.split(";");
                if (split.length == 1) {
                    trim2 = s;
                }
                else {
                    int n = 1;
                    String[] split2;
                    while (true) {
                        trim2 = s;
                        if (n >= split.length) {
                            break Label_0065;
                        }
                        if (split[n].trim().startsWith("charset")) {
                            split2 = split[n].trim().split("=");
                            if (split2.length > 1) {
                                break;
                            }
                        }
                        ++n;
                    }
                    trim2 = split2[1].trim();
                }
            }
        }
        final Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        final HashMap hashMap = new HashMap(headerFields.size());
        for (final Map.Entry<K, List> entry : headerFields.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null && entry.getValue().size() > 0) {
                hashMap.put((Object)entry.getKey(), (Object)entry.getValue().get(0));
            }
        }
        return zzt.r().c(trim, trim2, httpURLConnection.getResponseCode(), httpURLConnection.getResponseMessage(), hashMap, httpURLConnection.getInputStream());
    }
    
    public static final int[] m(final Activity activity) {
        final Window window = activity.getWindow();
        if (window != null) {
            final View viewById = window.findViewById(16908290);
            if (viewById != null) {
                return new int[] { viewById.getWidth(), viewById.getHeight() };
            }
        }
        return O();
    }
    
    public static final int[] n(final Activity activity) {
        final Window window = activity.getWindow();
        if (window != null) {
            final View viewById = window.findViewById(16908290);
            if (viewById != null) {
                final int[] o = { viewById.getTop(), viewById.getBottom() };
                return new int[] { zzaw.b().zzb((Context)activity, o[0]), zzaw.b().zzb((Context)activity, o[1]) };
            }
        }
        final int[] o = O();
        return new int[] { zzaw.b().zzb((Context)activity, o[0]), zzaw.b().zzb((Context)activity, o[1]) };
    }
    
    public static final boolean o(final View view, final PowerManager powerManager, final KeyguardManager keyguardManager) {
        final boolean c = zzt.q().c;
        boolean b = true;
        boolean b2 = false;
        Label_0047: {
            if (!c) {
                if (keyguardManager != null) {
                    if (keyguardManager.inKeyguardRestrictedInputMode()) {
                        if (!H(view)) {
                            b2 = false;
                            break Label_0047;
                        }
                    }
                }
            }
            b2 = true;
        }
        final long p3 = P(view);
        if (view.getVisibility() == 0 && view.isShown() && (powerManager == null || powerManager.isScreenOn()) && b2 && (!(boolean)zzay.c().zzb(zzbhy.zzbe) || view.getLocalVisibleRect(new Rect()) || view.getGlobalVisibleRect(new Rect()))) {
            if (!(boolean)zzay.c().zzb(zzbhy.zzhW)) {
                return b;
            }
            if (p3 >= (int)zzay.c().zzb(zzbhy.zzhY)) {
                return true;
            }
        }
        b = false;
        return b;
    }
    
    public static final void p(final Context context, final Uri uri) {
        try {
            final Intent intent = new Intent("android.intent.action.VIEW", uri);
            final Bundle bundle = new Bundle();
            intent.putExtras(bundle);
            I(context, intent);
            bundle.putString("com.android.browser.application_id", context.getPackageName());
            context.startActivity(intent);
            final String string = uri.toString();
            final StringBuilder sb = new StringBuilder();
            sb.append("Opening ");
            sb.append(string);
            sb.append(" in a new browser.");
            zzcfi.zze(sb.toString());
        }
        catch (final ActivityNotFoundException ex) {
            zzcfi.zzh("No browser is found.", (Throwable)ex);
        }
    }
    
    public static final int[] q(final Activity activity) {
        final int[] m = m(activity);
        return new int[] { zzaw.b().zzb((Context)activity, m[0]), zzaw.b().zzb((Context)activity, m[1]) };
    }
    
    public static final boolean r(final View view, final Context context) {
        final Context applicationContext = context.getApplicationContext();
        PowerManager powerManager;
        if (applicationContext != null) {
            powerManager = (PowerManager)applicationContext.getSystemService("power");
        }
        else {
            powerManager = null;
        }
        return o(view, powerManager, s(context));
    }
    
    private static KeyguardManager s(final Context context) {
        final Object systemService = context.getSystemService("keyguard");
        if (systemService != null && systemService instanceof KeyguardManager) {
            return (KeyguardManager)systemService;
        }
        return null;
    }
    
    private static Bundle t(Context metaData) {
        try {
            metaData = (NullPointerException)Wrappers.a((Context)metaData).c(((Context)metaData).getPackageName(), 128).metaData;
            return (Bundle)metaData;
        }
        catch (final NullPointerException metaData) {}
        catch (final PackageManager$NameNotFoundException ex) {}
        zze.b("Error getting metadata", metaData);
        return null;
    }
    
    private static String u(final Bundle bundle) {
        if (bundle == null) {
            return "";
        }
        final String string = bundle.getString("com.google.android.gms.ads.APPLICATION_ID");
        if (TextUtils.isEmpty((CharSequence)string)) {
            return "";
        }
        if (!string.matches("^ca-app-pub-[0-9]{16}~[0-9]{10}$") && !string.matches("^/\\d+~.+$")) {
            return "";
        }
        return string;
    }
    
    private static boolean v(final String s, final AtomicReference atomicReference, final String s2) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            return false;
        }
        try {
            final Pattern pattern = atomicReference.get();
            if (pattern != null) {
                final Pattern compile = pattern;
                if (s2.equals(pattern.pattern())) {
                    return compile.matcher(s).matches();
                }
            }
            final Pattern compile = Pattern.compile(s2);
            atomicReference.set(compile);
            return compile.matcher(s).matches();
        }
        catch (final PatternSyntaxException ex) {
            return false;
        }
    }
    
    public static int w(final int n) {
        if (n >= 5000) {
            return n;
        }
        if (n > 0) {
            final StringBuilder sb = new StringBuilder();
            sb.append("HTTP timeout too low: ");
            sb.append(n);
            sb.append(" milliseconds. Reverting to default timeout: 60000 milliseconds.");
            zzcfi.zzj(sb.toString());
        }
        return 60000;
    }
    
    static /* bridge */ void z(final zzs zzs, final boolean c) {
        zzs.c = c;
    }
    
    public final void A(final Context context, final String s, final boolean b, final HttpURLConnection httpURLConnection, final boolean b2, int w) {
        w = w(w);
        final StringBuilder sb = new StringBuilder();
        sb.append("HTTP timeout: ");
        sb.append(w);
        sb.append(" milliseconds.");
        zzcfi.zzi(sb.toString());
        httpURLConnection.setConnectTimeout(w);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setReadTimeout(w);
        httpURLConnection.setRequestProperty("User-Agent", this.y(context, s));
        httpURLConnection.setUseCaches(false);
    }
    
    public final boolean C(final String s) {
        return v(s, this.a, (String)zzay.c().zzb(zzbhy.zzZ));
    }
    
    public final boolean D(final String s) {
        return v(s, this.b, (String)zzay.c().zzb(zzbhy.zzaa));
    }
    
    public final boolean E(final Context context) {
        if (this.g) {
            return false;
        }
        final IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.google.android.ads.intent.DEBUG_LOGGING_ENABLEMENT_CHANGED");
        context.getApplicationContext().registerReceiver((BroadcastReceiver)new n(this, null), intentFilter);
        return this.g = true;
    }
    
    public final boolean F(final Context context) {
        if (this.f) {
            return false;
        }
        final IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        context.getApplicationContext().registerReceiver((BroadcastReceiver)new o(this, null), intentFilter);
        return this.f = true;
    }
    
    public final int G(final Context context, final Uri data) {
        if (context == null) {
            zze.a("Trying to open chrome custom tab on a null context");
            return 3;
        }
        int n;
        if (!(context instanceof Activity)) {
            zze.a("Chrome Custom Tabs can only work with Activity context.");
            n = 2;
        }
        else {
            n = 0;
        }
        final zzbhq zzdC = zzbhy.zzdC;
        final Boolean b = (Boolean)zzay.c().zzb(zzdC);
        final zzbhq zzdD = zzbhy.zzdD;
        if (b.equals(zzay.c().zzb(zzdD))) {
            n = 9;
        }
        if (n != 0) {
            final Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(data);
            intent.addFlags(268435456);
            context.startActivity(intent);
            return n;
        }
        if (zzay.c().zzb(zzdC)) {
            final zzbiw zzbiw = new zzbiw();
            zzbiw.zze((zzbiu)new m(this, zzbiw, context, data));
            zzbiw.zzb((Activity)context);
        }
        if (zzay.c().zzb(zzdD)) {
            final d a = new d.a().a();
            a.a.setPackage(zzgqi.zza(context));
            a.a(context, data);
        }
        return 5;
    }
    
    public final zzfvj x(final Uri uri) {
        return zzfva.zzk((Callable)new zzl(uri), this.h);
    }
    
    public final String y(final Context p0, final String p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        com/google/android/gms/ads/internal/util/zzs.d:Ljava/lang/Object;
        //     4: astore          4
        //     6: aload           4
        //     8: monitorenter   
        //     9: aload_0        
        //    10: getfield        com/google/android/gms/ads/internal/util/zzs.e:Ljava/lang/String;
        //    13: astore_3       
        //    14: aload_3        
        //    15: ifnull          23
        //    18: aload           4
        //    20: monitorexit    
        //    21: aload_3        
        //    22: areturn        
        //    23: aload_2        
        //    24: ifnonnull       36
        //    27: invokestatic    com/google/android/gms/ads/internal/util/zzs.L:()Ljava/lang/String;
        //    30: astore_1       
        //    31: aload           4
        //    33: monitorexit    
        //    34: aload_1        
        //    35: areturn        
        //    36: invokestatic    com/google/android/gms/ads/internal/util/zzce.a:()Lcom/google/android/gms/ads/internal/util/zzce;
        //    39: astore          5
        //    41: aload           5
        //    43: getfield        com/google/android/gms/ads/internal/util/zzce.a:Ljava/lang/String;
        //    46: invokestatic    android/text/TextUtils.isEmpty:(Ljava/lang/CharSequence;)Z
        //    49: ifne            55
        //    52: goto            115
        //    55: invokestatic    com/google/android/gms/common/util/ClientLibraryUtils.a:()Z
        //    58: ifeq            82
        //    61: new             Lcom/google/android/gms/ads/internal/util/zzcc;
        //    64: astore_3       
        //    65: aload_3        
        //    66: aload_1        
        //    67: invokespecial   com/google/android/gms/ads/internal/util/zzcc.<init>:(Landroid/content/Context;)V
        //    70: aload_1        
        //    71: aload_3        
        //    72: invokestatic    com/google/android/gms/ads/internal/util/zzcb.a:(Landroid/content/Context;Ljava/util/concurrent/Callable;)Ljava/lang/Object;
        //    75: checkcast       Ljava/lang/String;
        //    78: astore_3       
        //    79: goto            109
        //    82: aload_1        
        //    83: invokestatic    com/google/android/gms/common/GooglePlayServicesUtilLight.e:(Landroid/content/Context;)Landroid/content/Context;
        //    86: astore_3       
        //    87: new             Lcom/google/android/gms/ads/internal/util/zzcd;
        //    90: astore          6
        //    92: aload           6
        //    94: aload_3        
        //    95: aload_1        
        //    96: invokespecial   com/google/android/gms/ads/internal/util/zzcd.<init>:(Landroid/content/Context;Landroid/content/Context;)V
        //    99: aload_1        
        //   100: aload           6
        //   102: invokestatic    com/google/android/gms/ads/internal/util/zzcb.a:(Landroid/content/Context;Ljava/util/concurrent/Callable;)Ljava/lang/Object;
        //   105: checkcast       Ljava/lang/String;
        //   108: astore_3       
        //   109: aload           5
        //   111: aload_3        
        //   112: putfield        com/google/android/gms/ads/internal/util/zzce.a:Ljava/lang/String;
        //   115: aload_0        
        //   116: aload           5
        //   118: getfield        com/google/android/gms/ads/internal/util/zzce.a:Ljava/lang/String;
        //   121: putfield        com/google/android/gms/ads/internal/util/zzs.e:Ljava/lang/String;
        //   124: aload_0        
        //   125: getfield        com/google/android/gms/ads/internal/util/zzs.e:Ljava/lang/String;
        //   128: invokestatic    android/text/TextUtils.isEmpty:(Ljava/lang/CharSequence;)Z
        //   131: ifeq            142
        //   134: aload_0        
        //   135: aload_1        
        //   136: invokestatic    android/webkit/WebSettings.getDefaultUserAgent:(Landroid/content/Context;)Ljava/lang/String;
        //   139: putfield        com/google/android/gms/ads/internal/util/zzs.e:Ljava/lang/String;
        //   142: aload_0        
        //   143: getfield        com/google/android/gms/ads/internal/util/zzs.e:Ljava/lang/String;
        //   146: invokestatic    android/text/TextUtils.isEmpty:(Ljava/lang/CharSequence;)Z
        //   149: ifeq            159
        //   152: aload_0        
        //   153: invokestatic    com/google/android/gms/ads/internal/util/zzs.L:()Ljava/lang/String;
        //   156: putfield        com/google/android/gms/ads/internal/util/zzs.e:Ljava/lang/String;
        //   159: aload_0        
        //   160: getfield        com/google/android/gms/ads/internal/util/zzs.e:Ljava/lang/String;
        //   163: astore          5
        //   165: new             Ljava/lang/StringBuilder;
        //   168: astore_3       
        //   169: aload_3        
        //   170: invokespecial   java/lang/StringBuilder.<init>:()V
        //   173: aload_3        
        //   174: aload           5
        //   176: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   179: pop            
        //   180: aload_3        
        //   181: ldc_w           " (Mobile; "
        //   184: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   187: pop            
        //   188: aload_3        
        //   189: aload_2        
        //   190: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   193: pop            
        //   194: aload_0        
        //   195: aload_3        
        //   196: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   199: putfield        com/google/android/gms/ads/internal/util/zzs.e:Ljava/lang/String;
        //   202: aload_1        
        //   203: invokestatic    com/google/android/gms/common/wrappers/Wrappers.a:(Landroid/content/Context;)Lcom/google/android/gms/common/wrappers/PackageManagerWrapper;
        //   206: invokevirtual   com/google/android/gms/common/wrappers/PackageManagerWrapper.g:()Z
        //   209: ifeq            261
        //   212: aload_0        
        //   213: getfield        com/google/android/gms/ads/internal/util/zzs.e:Ljava/lang/String;
        //   216: astore_1       
        //   217: new             Ljava/lang/StringBuilder;
        //   220: astore_2       
        //   221: aload_2        
        //   222: invokespecial   java/lang/StringBuilder.<init>:()V
        //   225: aload_2        
        //   226: aload_1        
        //   227: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   230: pop            
        //   231: aload_2        
        //   232: ldc_w           ";aia"
        //   235: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   238: pop            
        //   239: aload_0        
        //   240: aload_2        
        //   241: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   244: putfield        com/google/android/gms/ads/internal/util/zzs.e:Ljava/lang/String;
        //   247: goto            261
        //   250: astore_1       
        //   251: invokestatic    com/google/android/gms/ads/internal/zzt.p:()Lcom/google/android/gms/internal/ads/zzcer;
        //   254: aload_1        
        //   255: ldc_w           "AdUtil.getUserAgent"
        //   258: invokevirtual   com/google/android/gms/internal/ads/zzcer.zzt:(Ljava/lang/Throwable;Ljava/lang/String;)V
        //   261: aload_0        
        //   262: getfield        com/google/android/gms/ads/internal/util/zzs.e:Ljava/lang/String;
        //   265: astore_1       
        //   266: new             Ljava/lang/StringBuilder;
        //   269: astore_2       
        //   270: aload_2        
        //   271: invokespecial   java/lang/StringBuilder.<init>:()V
        //   274: aload_2        
        //   275: aload_1        
        //   276: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   279: pop            
        //   280: aload_2        
        //   281: ldc_w           ")"
        //   284: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   287: pop            
        //   288: aload_2        
        //   289: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   292: astore_1       
        //   293: aload_0        
        //   294: aload_1        
        //   295: putfield        com/google/android/gms/ads/internal/util/zzs.e:Ljava/lang/String;
        //   298: aload           4
        //   300: monitorexit    
        //   301: aload_1        
        //   302: areturn        
        //   303: astore_1       
        //   304: aload           4
        //   306: monitorexit    
        //   307: aload_1        
        //   308: athrow         
        //   309: astore_3       
        //   310: goto            124
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  9      14     303    309    Any
        //  18     21     303    309    Any
        //  27     34     303    309    Any
        //  36     52     309    313    Ljava/lang/Exception;
        //  36     52     303    309    Any
        //  55     79     309    313    Ljava/lang/Exception;
        //  55     79     303    309    Any
        //  82     109    309    313    Ljava/lang/Exception;
        //  82     109    303    309    Any
        //  109    115    309    313    Ljava/lang/Exception;
        //  109    115    303    309    Any
        //  115    124    309    313    Ljava/lang/Exception;
        //  115    124    303    309    Any
        //  124    142    303    309    Any
        //  142    159    303    309    Any
        //  159    202    303    309    Any
        //  202    247    250    261    Ljava/lang/Exception;
        //  202    247    303    309    Any
        //  251    261    303    309    Any
        //  261    301    303    309    Any
        //  304    307    303    309    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0036:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2604)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:206)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:93)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:868)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:761)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:638)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:605)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:195)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:162)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:137)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:333)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:254)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:129)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
}
