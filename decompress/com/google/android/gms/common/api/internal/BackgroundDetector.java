// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import android.content.res.Configuration;
import android.os.Bundle;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager$RunningAppProcessInfo;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.Iterator;
import android.content.ComponentCallbacks;
import android.app.Application;
import javax.annotation.concurrent.GuardedBy;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import com.google.android.gms.common.annotation.KeepForSdk;
import android.content.ComponentCallbacks2;
import android.app.Application$ActivityLifecycleCallbacks;

@KeepForSdk
public final class BackgroundDetector implements Application$ActivityLifecycleCallbacks, ComponentCallbacks2
{
    private static final BackgroundDetector e;
    private final AtomicBoolean a;
    private final AtomicBoolean b;
    @GuardedBy
    private final ArrayList c;
    @GuardedBy
    private boolean d;
    
    static {
        e = new BackgroundDetector();
    }
    
    @KeepForSdk
    private BackgroundDetector() {
        this.a = new AtomicBoolean();
        this.b = new AtomicBoolean();
        this.c = new ArrayList();
        this.d = false;
    }
    
    @KeepForSdk
    public static BackgroundDetector b() {
        return BackgroundDetector.e;
    }
    
    @KeepForSdk
    public static void c(final Application application) {
        final BackgroundDetector e = BackgroundDetector.e;
        synchronized (e) {
            if (!e.d) {
                application.registerActivityLifecycleCallbacks((Application$ActivityLifecycleCallbacks)e);
                application.registerComponentCallbacks((ComponentCallbacks)e);
                e.d = true;
            }
        }
    }
    
    private final void f(final boolean b) {
        synchronized (BackgroundDetector.e) {
            final Iterator iterator = this.c.iterator();
            while (iterator.hasNext()) {
                ((BackgroundStateChangeListener)iterator.next()).a(b);
            }
        }
    }
    
    @KeepForSdk
    public void a(final BackgroundStateChangeListener backgroundStateChangeListener) {
        synchronized (BackgroundDetector.e) {
            this.c.add(backgroundStateChangeListener);
        }
    }
    
    @KeepForSdk
    public boolean d() {
        return this.a.get();
    }
    
    @KeepForSdk
    public boolean e(final boolean b) {
        if (!this.b.get()) {
            if (!PlatformVersion.b()) {
                return b;
            }
            final ActivityManager$RunningAppProcessInfo activityManager$RunningAppProcessInfo = new ActivityManager$RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(activityManager$RunningAppProcessInfo);
            if (!this.b.getAndSet(true) && activityManager$RunningAppProcessInfo.importance > 100) {
                this.a.set(true);
            }
        }
        return this.d();
    }
    
    public final void onActivityCreated(final Activity activity, final Bundle bundle) {
        final boolean compareAndSet = this.a.compareAndSet(true, false);
        this.b.set(true);
        if (compareAndSet) {
            this.f(false);
        }
    }
    
    public final void onActivityDestroyed(final Activity activity) {
    }
    
    public final void onActivityPaused(final Activity activity) {
    }
    
    public final void onActivityResumed(final Activity activity) {
        final boolean compareAndSet = this.a.compareAndSet(true, false);
        this.b.set(true);
        if (compareAndSet) {
            this.f(false);
        }
    }
    
    public final void onActivitySaveInstanceState(final Activity activity, final Bundle bundle) {
    }
    
    public final void onActivityStarted(final Activity activity) {
    }
    
    public final void onActivityStopped(final Activity activity) {
    }
    
    public final void onConfigurationChanged(final Configuration configuration) {
    }
    
    public final void onLowMemory() {
    }
    
    public final void onTrimMemory(final int n) {
        if (n == 20 && this.a.compareAndSet(false, true)) {
            this.b.set(true);
            this.f(true);
        }
    }
    
    @KeepForSdk
    public interface BackgroundStateChangeListener
    {
        @KeepForSdk
        void a(final boolean p0);
    }
}
