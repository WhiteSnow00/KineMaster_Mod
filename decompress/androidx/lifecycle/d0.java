// 
// Decompiled by Procyon v0.6.0
// 

package androidx.lifecycle;

import android.app.Application$ActivityLifecycleCallbacks;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Handler;

public class d0 implements r
{
    private static final d0 i;
    private int a;
    private int b;
    private boolean c;
    private boolean d;
    private Handler e;
    private final t f;
    private Runnable g;
    e0.a h;
    
    static {
        i = new d0();
    }
    
    private d0() {
        this.a = 0;
        this.b = 0;
        this.c = true;
        this.d = true;
        this.f = new t(this);
        this.g = new Runnable() {
            final d0 a;
            
            @Override
            public void run() {
                this.a.f();
                this.a.g();
            }
        };
        this.h = new e0.a() {
            final d0 a;
            
            @Override
            public void a() {
            }
            
            @Override
            public void onResume() {
                this.a.b();
            }
            
            @Override
            public void onStart() {
                this.a.c();
            }
        };
    }
    
    public static r h() {
        return d0.i;
    }
    
    static void i(final Context context) {
        d0.i.e(context);
    }
    
    void a() {
        final int b = this.b - 1;
        this.b = b;
        if (b == 0) {
            this.e.postDelayed(this.g, 700L);
        }
    }
    
    void b() {
        final int b = this.b + 1;
        this.b = b;
        if (b == 1) {
            if (this.c) {
                this.f.h(Lifecycle.Event.ON_RESUME);
                this.c = false;
            }
            else {
                this.e.removeCallbacks(this.g);
            }
        }
    }
    
    void c() {
        final int a = this.a + 1;
        this.a = a;
        if (a == 1 && this.d) {
            this.f.h(Lifecycle.Event.ON_START);
            this.d = false;
        }
    }
    
    void d() {
        --this.a;
        this.g();
    }
    
    void e(final Context context) {
        this.e = new Handler();
        this.f.h(Lifecycle.Event.ON_CREATE);
        ((Application)context.getApplicationContext()).registerActivityLifecycleCallbacks((Application$ActivityLifecycleCallbacks)new h(this) {
            final d0 this$0;
            
            @Override
            public void onActivityCreated(final Activity activity, final Bundle bundle) {
                if (Build$VERSION.SDK_INT < 29) {
                    e0.f(activity).h(this.this$0.h);
                }
            }
            
            @Override
            public void onActivityPaused(final Activity activity) {
                this.this$0.a();
            }
            
            public void onActivityPreCreated(final Activity activity, final Bundle bundle) {
                d0.d.a(activity, (Application$ActivityLifecycleCallbacks)new h(this) {
                    final d0$c this$1;
                    
                    public void onActivityPostResumed(final Activity activity) {
                        this.this$1.this$0.b();
                    }
                    
                    public void onActivityPostStarted(final Activity activity) {
                        this.this$1.this$0.c();
                    }
                });
            }
            
            @Override
            public void onActivityStopped(final Activity activity) {
                this.this$0.d();
            }
        });
    }
    
    void f() {
        if (this.b == 0) {
            this.c = true;
            this.f.h(Lifecycle.Event.ON_PAUSE);
        }
    }
    
    void g() {
        if (this.a == 0 && this.c) {
            this.f.h(Lifecycle.Event.ON_STOP);
            this.d = true;
        }
    }
    
    @Override
    public Lifecycle getLifecycle() {
        return this.f;
    }
    
    static class d
    {
        static void a(final Activity activity, final Application$ActivityLifecycleCallbacks application$ActivityLifecycleCallbacks) {
            activity.registerActivityLifecycleCallbacks(application$ActivityLifecycleCallbacks);
        }
    }
}
