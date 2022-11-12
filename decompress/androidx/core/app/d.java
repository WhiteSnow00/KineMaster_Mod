// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.app;

import android.os.Bundle;
import android.app.Application;
import android.app.Application$ActivityLifecycleCallbacks;
import android.util.Log;
import android.os.Build$VERSION;
import android.content.res.Configuration;
import java.util.List;
import android.os.IBinder;
import android.app.Activity;
import android.os.Looper;
import android.os.Handler;
import java.lang.reflect.Method;
import java.lang.reflect.Field;

final class d
{
    protected static final Class<?> a;
    protected static final Field b;
    protected static final Field c;
    protected static final Method d;
    protected static final Method e;
    protected static final Method f;
    private static final Handler g;
    
    static {
        g = new Handler(Looper.getMainLooper());
        final Class<?> clazz = a = a();
        b = b();
        c = f();
        d = d(clazz);
        e = c(clazz);
        f = e(clazz);
    }
    
    private static Class<?> a() {
        try {
            return Class.forName("android.app.ActivityThread");
        }
        finally {
            return null;
        }
    }
    
    private static Field b() {
        try {
            final Field declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
            return declaredField;
        }
        finally {
            return null;
        }
    }
    
    private static Method c(final Class<?> clazz) {
        if (clazz == null) {
            return null;
        }
        try {
            final Method declaredMethod = clazz.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        }
        finally {
            return null;
        }
    }
    
    private static Method d(final Class<?> clazz) {
        if (clazz == null) {
            return null;
        }
        try {
            final Method declaredMethod = clazz.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE, String.class);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        }
        finally {
            return null;
        }
    }
    
    private static Method e(final Class<?> clazz) {
        Label_0084: {
            if (!g()) {
                break Label_0084;
            }
            if (clazz == null) {
                break Label_0084;
            }
            try {
                final Class<Integer> type = Integer.TYPE;
                final Class<Boolean> type2 = Boolean.TYPE;
                final Method declaredMethod = clazz.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, type, type2, Configuration.class, Configuration.class, type2, type2);
                declaredMethod.setAccessible(true);
                return declaredMethod;
                return null;
            }
            finally {
                return null;
            }
        }
    }
    
    private static Field f() {
        try {
            final Field declaredField = Activity.class.getDeclaredField("mToken");
            declaredField.setAccessible(true);
            return declaredField;
        }
        finally {
            return null;
        }
    }
    
    private static boolean g() {
        final int sdk_INT = Build$VERSION.SDK_INT;
        return sdk_INT == 26 || sdk_INT == 27;
    }
    
    protected static boolean h(final Object o, final int n, final Activity activity) {
        try {
            final Object value = androidx.core.app.d.c.get(activity);
            if (value == o && activity.hashCode() == n) {
                androidx.core.app.d.g.postAtFrontOfQueue((Runnable)new Runnable(androidx.core.app.d.b.get(activity), value) {
                    final Object a;
                    final Object b;
                    
                    @Override
                    public void run() {
                        try {
                            final Method d = androidx.core.app.d.d;
                            if (d != null) {
                                d.invoke(this.a, this.b, Boolean.FALSE, "AppCompat recreation");
                            }
                            else {
                                androidx.core.app.d.e.invoke(this.a, this.b, Boolean.FALSE);
                            }
                        }
                        catch (final RuntimeException ex) {
                            if (ex.getClass() == RuntimeException.class && ex.getMessage() != null) {
                                if (ex.getMessage().startsWith("Unable to stop")) {
                                    throw ex;
                                }
                            }
                        }
                        finally {
                            final Throwable t;
                            Log.e("ActivityRecreator", "Exception while invoking performStopActivity", t);
                        }
                    }
                });
                return true;
            }
            return false;
        }
        finally {
            final Throwable t;
            Log.e("ActivityRecreator", "Exception while fetching field values", t);
            return false;
        }
    }
    
    static boolean i(final Activity activity) {
        if (Build$VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        }
        if (g() && androidx.core.app.d.f == null) {
            return false;
        }
        if (androidx.core.app.d.e == null && androidx.core.app.d.d == null) {
            return false;
        }
        try {
            final Object value = androidx.core.app.d.c.get(activity);
            if (value == null) {}
            final Object value2 = androidx.core.app.d.b.get(activity);
            if (value2 == null) {}
            final Application application = activity.getApplication();
            final d d = new d(activity);
            application.registerActivityLifecycleCallbacks((Application$ActivityLifecycleCallbacks)d);
            final Handler g = androidx.core.app.d.g;
            g.post((Runnable)new Runnable(d, value) {
                final d a;
                final Object b;
                
                @Override
                public void run() {
                    this.a.a = this.b;
                }
            });
            try {
                if (g()) {
                    final Method f = androidx.core.app.d.f;
                    final Boolean false = Boolean.FALSE;
                    f.invoke(value2, value, null, null, 0, false, null, null, false, false);
                }
                else {
                    activity.recreate();
                }
                g.post((Runnable)new Runnable(application, d) {
                    final Application a;
                    final d b;
                    
                    @Override
                    public void run() {
                        this.a.unregisterActivityLifecycleCallbacks((Application$ActivityLifecycleCallbacks)this.b);
                    }
                });
                return true;
            }
            finally {
                androidx.core.app.d.g.post((Runnable)new Runnable(application, d) {
                    final Application a;
                    final d b;
                    
                    @Override
                    public void run() {
                        this.a.unregisterActivityLifecycleCallbacks((Application$ActivityLifecycleCallbacks)this.b);
                    }
                });
            }
        }
        finally {
            return false;
        }
    }
    
    private static final class d implements Application$ActivityLifecycleCallbacks
    {
        Object a;
        private Activity b;
        private final int c;
        private boolean d;
        private boolean e;
        private boolean f;
        
        d(final Activity b) {
            this.d = false;
            this.e = false;
            this.f = false;
            this.b = b;
            this.c = b.hashCode();
        }
        
        public void onActivityCreated(final Activity activity, final Bundle bundle) {
        }
        
        public void onActivityDestroyed(final Activity activity) {
            if (this.b == activity) {
                this.b = null;
                this.e = true;
            }
        }
        
        public void onActivityPaused(final Activity activity) {
            if (this.e && !this.f && !this.d && androidx.core.app.d.h(this.a, this.c, activity)) {
                this.f = true;
                this.a = null;
            }
        }
        
        public void onActivityResumed(final Activity activity) {
        }
        
        public void onActivitySaveInstanceState(final Activity activity, final Bundle bundle) {
        }
        
        public void onActivityStarted(final Activity activity) {
            if (this.b == activity) {
                this.d = true;
            }
        }
        
        public void onActivityStopped(final Activity activity) {
        }
    }
}
