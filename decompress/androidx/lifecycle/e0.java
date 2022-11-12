// 
// Decompiled by Procyon v0.6.0
// 

package androidx.lifecycle;

import android.app.Application$ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.app.FragmentManager;
import android.os.Build$VERSION;
import android.app.Activity;
import android.app.Fragment;

public class e0 extends Fragment
{
    private a a;
    
    static void a(final Activity activity, final Lifecycle.Event event) {
        if (activity instanceof u) {
            ((u)activity).getLifecycle().h(event);
            return;
        }
        if (activity instanceof r) {
            final Lifecycle lifecycle = ((r)activity).getLifecycle();
            if (lifecycle instanceof t) {
                ((t)lifecycle).h(event);
            }
        }
    }
    
    private void b(final Lifecycle.Event event) {
        if (Build$VERSION.SDK_INT < 29) {
            a(this.getActivity(), event);
        }
    }
    
    private void c(final a a) {
        if (a != null) {
            a.a();
        }
    }
    
    private void d(final a a) {
        if (a != null) {
            a.onResume();
        }
    }
    
    private void e(final a a) {
        if (a != null) {
            a.onStart();
        }
    }
    
    static e0 f(final Activity activity) {
        return (e0)activity.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag");
    }
    
    public static void g(final Activity activity) {
        if (Build$VERSION.SDK_INT >= 29) {
            b.registerIn(activity);
        }
        final FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add((Fragment)new e0(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }
    
    void h(final a a) {
        this.a = a;
    }
    
    public void onActivityCreated(final Bundle bundle) {
        super.onActivityCreated(bundle);
        this.c(this.a);
        this.b(Lifecycle.Event.ON_CREATE);
    }
    
    public void onDestroy() {
        super.onDestroy();
        this.b(Lifecycle.Event.ON_DESTROY);
        this.a = null;
    }
    
    public void onPause() {
        super.onPause();
        this.b(Lifecycle.Event.ON_PAUSE);
    }
    
    public void onResume() {
        super.onResume();
        this.d(this.a);
        this.b(Lifecycle.Event.ON_RESUME);
    }
    
    public void onStart() {
        super.onStart();
        this.e(this.a);
        this.b(Lifecycle.Event.ON_START);
    }
    
    public void onStop() {
        super.onStop();
        this.b(Lifecycle.Event.ON_STOP);
    }
    
    interface a
    {
        void a();
        
        void onResume();
        
        void onStart();
    }
    
    static class b implements Application$ActivityLifecycleCallbacks
    {
        static void registerIn(final Activity activity) {
            activity.registerActivityLifecycleCallbacks((Application$ActivityLifecycleCallbacks)new b());
        }
        
        public void onActivityCreated(final Activity activity, final Bundle bundle) {
        }
        
        public void onActivityDestroyed(final Activity activity) {
        }
        
        public void onActivityPaused(final Activity activity) {
        }
        
        public void onActivityPostCreated(final Activity activity, final Bundle bundle) {
            e0.a(activity, Lifecycle.Event.ON_CREATE);
        }
        
        public void onActivityPostResumed(final Activity activity) {
            e0.a(activity, Lifecycle.Event.ON_RESUME);
        }
        
        public void onActivityPostStarted(final Activity activity) {
            e0.a(activity, Lifecycle.Event.ON_START);
        }
        
        public void onActivityPreDestroyed(final Activity activity) {
            e0.a(activity, Lifecycle.Event.ON_DESTROY);
        }
        
        public void onActivityPrePaused(final Activity activity) {
            e0.a(activity, Lifecycle.Event.ON_PAUSE);
        }
        
        public void onActivityPreStopped(final Activity activity) {
            e0.a(activity, Lifecycle.Event.ON_STOP);
        }
        
        public void onActivityResumed(final Activity activity) {
        }
        
        public void onActivitySaveInstanceState(final Activity activity, final Bundle bundle) {
        }
        
        public void onActivityStarted(final Activity activity) {
        }
        
        public void onActivityStopped(final Activity activity) {
        }
    }
}
