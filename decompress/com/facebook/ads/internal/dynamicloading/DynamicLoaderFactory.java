// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads.internal.dynamicloading;

import java.io.Writer;
import java.io.PrintWriter;
import java.io.StringWriter;
import com.facebook.ads.internal.util.common.Preconditions;
import dalvik.system.DexClassLoader;
import java.io.FileOutputStream;
import android.os.Build$VERSION;
import android.os.SystemClock;
import com.facebook.ads.internal.util.common.ANActivityLifecycleCallbacksListener;
import java.io.File;
import android.util.Log;
import android.os.Handler;
import android.os.Looper;
import java.io.IOException;
import java.io.InputStream;
import dalvik.system.InMemoryDexClassLoader;
import java.nio.ByteBuffer;
import java.io.ByteArrayOutputStream;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.internal.settings.MultithreadedBundleWrapper;
import android.content.Context;
import com.facebook.ads.BuildConfig;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import androidx.annotation.Keep;

@Keep
public class DynamicLoaderFactory
{
    private static final String AUDIENCE_NETWORK_CODE_PATH = "audience_network";
    public static final String AUDIENCE_NETWORK_DEX = "audience_network.dex";
    private static final String CODE_CACHE_DIR = "code_cache";
    static final String DEX_LOADING_ERROR_MESSAGE = "Can't load Audience Network Dex. Please, check that audience_network.dex is inside of assets folder.";
    private static final int DEX_LOAD_RETRY_COUNT = 3;
    private static final int DEX_LOAD_RETRY_DELAY_MS = 200;
    private static final String DYNAMIC_LOADING_BUILD_TYPE = "releaseDL";
    public static final boolean LOAD_FROM_ASSETS;
    private static final String OPTIMIZED_DEX_PATH = "optimized";
    private static final AtomicReference<DynamicLoader> sDynamicLoader;
    private static boolean sFallbackMode;
    private static final AtomicBoolean sInitializing;
    private static boolean sUseLegacyClassLoader;
    
    static {
        LOAD_FROM_ASSETS = "releaseDL".equals(BuildConfig.BUILD_TYPE);
        sDynamicLoader = new AtomicReference<DynamicLoader>();
        sInitializing = new AtomicBoolean();
        DynamicLoaderFactory.sUseLegacyClassLoader = true;
    }
    
    static DynamicLoader access$000(final Context context, final boolean b) throws Exception {
        return doMakeLoader(context, b);
    }
    
    static String access$100(final Throwable t) {
        return createErrorMessage(t);
    }
    
    static void access$200(final Context context, final DynamicLoader dynamicLoader, final Throwable t, final boolean b, final MultithreadedBundleWrapper multithreadedBundleWrapper, final AudienceNetworkAds.InitListener initListener) {
        doCallInitialize(context, dynamicLoader, t, b, multithreadedBundleWrapper, initListener);
    }
    
    static AtomicBoolean access$300() {
        return DynamicLoaderFactory.sInitializing;
    }
    
    static AudienceNetworkAds.InitResult access$400(final Throwable t) {
        return createErrorInitResult(t);
    }
    
    private static AudienceNetworkAds.InitResult createErrorInitResult(final Throwable t) {
        return new AudienceNetworkAds.InitResult(t) {
            final Throwable a;
            
            @Override
            public String getMessage() {
                return DynamicLoaderFactory.access$100(this.a);
            }
            
            @Override
            public boolean isSuccess() {
                return false;
            }
        };
    }
    
    private static String createErrorMessage(final Throwable t) {
        final StringBuilder sb = new StringBuilder();
        sb.append("Can't load Audience Network Dex. Please, check that audience_network.dex is inside of assets folder.\n");
        sb.append(stackTraceToString(t));
        return sb.toString();
    }
    
    private static ClassLoader createInMemoryClassLoader(final Context context) throws IOException {
        final InputStream open = context.getAssets().open("audience_network.dex");
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        final byte[] array = new byte[1024];
        while (true) {
            final int read = open.read(array);
            if (read <= 0) {
                break;
            }
            byteArrayOutputStream.write(array, 0, read);
        }
        open.close();
        byteArrayOutputStream.flush();
        byteArrayOutputStream.close();
        return (ClassLoader)new InMemoryDexClassLoader(ByteBuffer.wrap(byteArrayOutputStream.toByteArray()), DynamicLoaderFactory.class.getClassLoader());
    }
    
    private static void doCallInitialize(final Context context, final DynamicLoader dynamicLoader, final Throwable t, final boolean b, final MultithreadedBundleWrapper multithreadedBundleWrapper, final AudienceNetworkAds.InitListener initListener) {
        if (t != null) {
            if (initListener != null) {
                new Handler(Looper.getMainLooper()).postDelayed((Runnable)new Runnable(initListener, t) {
                    final AudienceNetworkAds.InitListener a;
                    final Throwable b;
                    
                    @Override
                    public void run() {
                        this.a.onInitialized(DynamicLoaderFactory.access$400(this.b));
                    }
                }, 100L);
            }
            else {
                Log.e("FBAudienceNetwork", "Can't load Audience Network Dex. Please, check that audience_network.dex is inside of assets folder.", t);
            }
        }
        else if (dynamicLoader != null) {
            if (b) {
                dynamicLoader.createAudienceNetworkAdsApi().onContentProviderCreated(context);
            }
            else {
                dynamicLoader.createAudienceNetworkAdsApi().initialize(context, multithreadedBundleWrapper, initListener);
            }
        }
    }
    
    private static DynamicLoader doMakeLoader(final Context context, final boolean b) throws Exception {
        final AtomicReference<DynamicLoader> sDynamicLoader = DynamicLoaderFactory.sDynamicLoader;
        DynamicLoader dynamicLoader;
        if ((dynamicLoader = sDynamicLoader.get()) == null) {
            if (!DynamicLoaderFactory.LOAD_FROM_ASSETS) {
                dynamicLoader = (DynamicLoader)Class.forName("com.facebook.ads.internal.dynamicloading.DynamicLoaderImpl").newInstance();
            }
            else {
                final long currentTimeMillis = System.currentTimeMillis();
                dynamicLoader = (DynamicLoader)makeAdsSdkClassLoader(context.getApplicationContext()).loadClass("com.facebook.ads.internal.dynamicloading.DynamicLoaderImpl").newInstance();
                final long currentTimeMillis2 = System.currentTimeMillis();
                final StringBuilder sb = new StringBuilder();
                sb.append("SDK dex loading time: ");
                sb.append(currentTimeMillis2 - currentTimeMillis);
                Log.d("FBAudienceNetwork", sb.toString());
            }
            if (b) {
                dynamicLoader.maybeInitInternally(context);
            }
            sDynamicLoader.set(dynamicLoader);
        }
        return dynamicLoader;
    }
    
    private static Context getApplicationContextViaReflection() {
        try {
            return (Context)Class.forName("android.app.ActivityThread").getMethod("currentApplication", (Class<?>[])new Class[0]).invoke(null, (Object[])null);
        }
        finally {
            final Throwable t;
            Log.e("FBAudienceNetwork", "Failed to fetch Context from  ActivityThread. Audience Network SDK won't work unless you call AudienceNetworkAds.buildInitSettings().withListener(InitListener).initialize().", t);
            return null;
        }
    }
    
    private static File getCacheCodeDirLegacy(Context dir, File file) throws IOException {
        file = new File(file, "code_cache");
        try {
            mkdirChecked(file);
            dir = (Context)file;
        }
        catch (final IOException ex) {
            dir = (Context)dir.getDir("code_cache", 0);
            mkdirChecked((File)dir);
        }
        return (File)dir;
    }
    
    private static File getCodeCacheDir(final Context context, final File file) throws IOException {
        return context.getCodeCacheDir();
    }
    
    public static DynamicLoader getDynamicLoader() {
        return DynamicLoaderFactory.sDynamicLoader.get();
    }
    
    private static File getSecondaryDir(File file) throws IOException {
        file = new File(file, "audience_network");
        mkdirChecked(file);
        return file;
    }
    
    public static void initialize(final Context context, final MultithreadedBundleWrapper multithreadedBundleWrapper, final AudienceNetworkAds.InitListener initListener, final boolean b) {
        if (b || !DynamicLoaderFactory.sInitializing.getAndSet(true)) {
            new Thread(new Runnable(context, b, multithreadedBundleWrapper, initListener) {
                final Context a;
                final boolean b;
                final MultithreadedBundleWrapper c;
                final AudienceNetworkAds.InitListener d;
                
                @Override
                public void run() {
                    ANActivityLifecycleCallbacksListener.registerActivityCallbacks(this.a);
                    monitorenter(DynamicLoaderFactory.class);
                    final DynamicLoader dynamicLoader = null;
                    Object o = null;
                    int n = 0;
                    DynamicLoader dynamicLoader2;
                    while (true) {
                        dynamicLoader2 = dynamicLoader;
                        if (n < 3) {
                            try {
                                DynamicLoaderFactory.access$000(this.a, false);
                            }
                            finally {
                                if (n == 2) {
                                    if (!this.b) {
                                        DexLoadErrorReporter.reportDexLoadingIssue(this.a, DynamicLoaderFactory.access$100((Throwable)dynamicLoader2), 0.1);
                                        DynamicLoaderFactory.setFallbackMode(true);
                                    }
                                    o = dynamicLoader2;
                                }
                                else {
                                    SystemClock.sleep(200L);
                                }
                                ++n;
                                continue;
                            }
                            break;
                        }
                        break;
                    }
                    try {
                        monitorexit(DynamicLoaderFactory.class);
                        DynamicLoaderFactory.access$200(this.a, dynamicLoader2, (Throwable)o, this.b, this.c, this.d);
                        DynamicLoaderFactory.access$300().set(false);
                    }
                    finally {
                        monitorexit(DynamicLoaderFactory.class);
                    }
                }
            }).start();
        }
    }
    
    public static boolean isFallbackMode() {
        synchronized (DynamicLoaderFactory.class) {
            return DynamicLoaderFactory.sFallbackMode;
        }
    }
    
    private static ClassLoader makeAdsSdkClassLoader(final Context context) throws Exception {
        if (Build$VERSION.SDK_INT >= 30) {
            return createInMemoryClassLoader(context);
        }
        if (DynamicLoaderFactory.sUseLegacyClassLoader) {
            return (ClassLoader)makeLegacyAdsSdkClassLoader(context);
        }
        final File secondaryDir = getSecondaryDir(getCodeCacheDir(context, new File(context.getApplicationInfo().dataDir)));
        final StringBuilder sb = new StringBuilder();
        sb.append(secondaryDir.getPath());
        sb.append(File.separator);
        sb.append("audience_network.dex");
        final String string = sb.toString();
        final InputStream open = context.getAssets().open("audience_network.dex");
        final FileOutputStream fileOutputStream = new FileOutputStream(string);
        final byte[] array = new byte[1024];
        while (true) {
            final int read = open.read(array);
            if (read <= 0) {
                break;
            }
            fileOutputStream.write(array, 0, read);
        }
        open.close();
        fileOutputStream.flush();
        fileOutputStream.close();
        final StringBuilder sb2 = new StringBuilder();
        sb2.append(secondaryDir.getPath());
        sb2.append(File.separator);
        sb2.append("optimized");
        final File file = new File(sb2.toString());
        mkdirChecked(file);
        return (ClassLoader)new DexClassLoader(string, file.getPath(), (String)null, context.getClassLoader());
    }
    
    private static DexClassLoader makeLegacyAdsSdkClassLoader(final Context context) throws Exception {
        final StringBuilder sb = new StringBuilder();
        sb.append(context.getFilesDir().getPath());
        sb.append(File.separator);
        sb.append("audience_network.dex");
        final String string = sb.toString();
        final InputStream open = context.getAssets().open("audience_network.dex");
        final FileOutputStream fileOutputStream = new FileOutputStream(string);
        final byte[] array = new byte[1024];
        while (true) {
            final int read = open.read(array);
            if (read <= 0) {
                break;
            }
            fileOutputStream.write(array, 0, read);
        }
        open.close();
        fileOutputStream.flush();
        fileOutputStream.close();
        return new DexClassLoader(string, context.getDir("optimized", 0).getPath(), (String)null, DynamicLoaderFactory.class.getClassLoader());
    }
    
    public static DynamicLoader makeLoader(final Context context) {
        synchronized (DynamicLoaderFactory.class) {
            return makeLoader(context, true);
        }
    }
    
    public static DynamicLoader makeLoader(final Context context, final boolean b) {
        synchronized (DynamicLoaderFactory.class) {
            Preconditions.checkNotNull(context, "Context can not be null.");
            try {
                return doMakeLoader(context, b);
            }
            finally {
                final Throwable t;
                Log.e("FBAudienceNetwork", "Can't load Audience Network Dex. Please, check that audience_network.dex is inside of assets folder.", t);
                DexLoadErrorReporter.reportDexLoadingIssue(context, createErrorMessage(t), 0.1);
                final DynamicLoader fallbackLoader = DynamicLoaderFallback.makeFallbackLoader();
                DynamicLoaderFactory.sDynamicLoader.set(fallbackLoader);
                DynamicLoaderFactory.sFallbackMode = true;
                return fallbackLoader;
            }
        }
    }
    
    public static DynamicLoader makeLoaderUnsafe() {
        synchronized (DynamicLoaderFactory.class) {
            final AtomicReference<DynamicLoader> sDynamicLoader = DynamicLoaderFactory.sDynamicLoader;
            if (sDynamicLoader.get() != null) {
                return sDynamicLoader.get();
            }
            final Context applicationContextViaReflection = getApplicationContextViaReflection();
            if (applicationContextViaReflection != null) {
                return makeLoader(applicationContextViaReflection, true);
            }
            throw new RuntimeException("You must call AudienceNetworkAds.buildInitSettings(Context).initialize() before you can use Audience Network SDK.");
        }
    }
    
    private static void mkdirChecked(final File file) throws IOException {
        file.mkdir();
        if (!file.isDirectory()) {
            final File parentFile = file.getParentFile();
            String s;
            if (parentFile == null) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Failed to create dir ");
                sb.append(file.getPath());
                sb.append(". Parent file is null.");
                s = sb.toString();
            }
            else {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("Failed to create dir ");
                sb2.append(file.getPath());
                sb2.append(". parent file is a dir ");
                sb2.append(parentFile.isDirectory());
                sb2.append(", a file ");
                sb2.append(parentFile.isFile());
                sb2.append(", exists ");
                sb2.append(parentFile.exists());
                sb2.append(", readable ");
                sb2.append(parentFile.canRead());
                sb2.append(", writable ");
                sb2.append(parentFile.canWrite());
                s = sb2.toString();
            }
            Log.e("FBAudienceNetwork", s);
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("Failed to create directory ");
            sb3.append(file.getPath());
            sb3.append(", detailed message: ");
            sb3.append(s);
            throw new IOException(sb3.toString());
        }
    }
    
    public static void setFallbackMode(final boolean b) {
        monitorenter(DynamicLoaderFactory.class);
        Label_0023: {
            if (!b) {
                break Label_0023;
            }
            try {
                DynamicLoaderFactory.sDynamicLoader.set(DynamicLoaderFallback.makeFallbackLoader());
                DynamicLoaderFactory.sFallbackMode = true;
                return;
                DynamicLoaderFactory.sDynamicLoader.set(null);
                DynamicLoaderFactory.sFallbackMode = false;
            }
            finally {
                monitorexit(DynamicLoaderFactory.class);
            }
        }
    }
    
    public static void setUseLegacyClassLoader(final boolean sUseLegacyClassLoader) {
        DynamicLoaderFactory.sUseLegacyClassLoader = sUseLegacyClassLoader;
    }
    
    private static String stackTraceToString(final Throwable t) {
        final StringWriter stringWriter = new StringWriter();
        t.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}
