// 
// Decompiled by Procyon v0.6.0
// 

package p2;

import android.os.Message;
import android.app.Application;
import androidx.fragment.app.c0;
import android.app.FragmentTransaction;
import android.util.Log;
import android.content.ContextWrapper;
import com.bumptech.glide.d;
import android.app.Activity;
import android.os.Looper;
import java.util.HashMap;
import com.bumptech.glide.f;
import android.content.Context;
import com.bumptech.glide.c;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.View;
import androidx.collection.a;
import android.os.Handler;
import android.app.FragmentManager;
import java.util.Map;
import com.bumptech.glide.i;
import android.os.Handler$Callback;

public class p implements Handler$Callback
{
    private static final b j;
    private volatile i a;
    final Map<FragmentManager, o> b;
    final Map<androidx.fragment.app.FragmentManager, t> c;
    private final Handler d;
    private final b e;
    private final a<View, Fragment> f;
    private final a<View, android.app.Fragment> g;
    private final Bundle h;
    private final k i;
    
    static {
        j = (b)new b() {
            @Override
            public i a(final c c, final l l, final q q, final Context context) {
                return new i(c, l, q, context);
            }
        };
    }
    
    public p(b j, final f f) {
        this.b = new HashMap<FragmentManager, o>();
        this.c = new HashMap<androidx.fragment.app.FragmentManager, t>();
        this.f = new a<View, Fragment>();
        this.g = new a<View, android.app.Fragment>();
        this.h = new Bundle();
        if (j == null) {
            j = p.j;
        }
        this.e = j;
        this.d = new Handler(Looper.getMainLooper(), (Handler$Callback)this);
        this.i = b(f);
    }
    
    private static void a(final Activity activity) {
        if (!activity.isDestroyed()) {
            return;
        }
        throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
    }
    
    private static k b(final f f) {
        if (com.bumptech.glide.load.resource.bitmap.q.h && com.bumptech.glide.load.resource.bitmap.q.g) {
            k k;
            if (f.a((Class<Object>)d.e.class)) {
                k = new p2.i();
            }
            else {
                k = new j();
            }
            return k;
        }
        return new g();
    }
    
    private static Activity c(final Context context) {
        if (context instanceof Activity) {
            return (Activity)context;
        }
        if (context instanceof ContextWrapper) {
            return c(((ContextWrapper)context).getBaseContext());
        }
        return null;
    }
    
    @Deprecated
    private i d(final Context context, final FragmentManager fragmentManager, final android.app.Fragment fragment, final boolean b) {
        final o k = this.k(fragmentManager, fragment);
        i i;
        if ((i = k.e()) == null) {
            i = this.e.a(com.bumptech.glide.c.c(context), k.c(), k.f(), context);
            if (b) {
                i.onStart();
            }
            k.k(i);
        }
        return i;
    }
    
    private i i(final Context context) {
        if (this.a == null) {
            synchronized (this) {
                if (this.a == null) {
                    this.a = this.e.a(com.bumptech.glide.c.c(context.getApplicationContext()), new p2.b(), new h(), context.getApplicationContext());
                }
            }
        }
        return this.a;
    }
    
    private o k(final FragmentManager fragmentManager, final android.app.Fragment fragment) {
        o o;
        if ((o = this.b.get(fragmentManager)) == null && (o = (o)fragmentManager.findFragmentByTag("com.bumptech.glide.manager")) == null) {
            o = new o();
            o.j(fragment);
            this.b.put(fragmentManager, o);
            fragmentManager.beginTransaction().add((android.app.Fragment)o, "com.bumptech.glide.manager").commitAllowingStateLoss();
            this.d.obtainMessage(1, (Object)fragmentManager).sendToTarget();
        }
        return o;
    }
    
    private t m(final androidx.fragment.app.FragmentManager fragmentManager, final Fragment fragment) {
        t t;
        if ((t = this.c.get(fragmentManager)) == null && (t = (t)fragmentManager.k0("com.bumptech.glide.manager")) == null) {
            t = new t();
            t.q4(fragment);
            this.c.put(fragmentManager, t);
            fragmentManager.q().e(t, "com.bumptech.glide.manager").j();
            this.d.obtainMessage(2, (Object)fragmentManager).sendToTarget();
        }
        return t;
    }
    
    private static boolean n(final Context context) {
        final Activity c = c(context);
        return c == null || !c.isFinishing();
    }
    
    private i o(final Context context, final androidx.fragment.app.FragmentManager fragmentManager, final Fragment fragment, final boolean b) {
        final t m = this.m(fragmentManager, fragment);
        i i;
        if ((i = m.k4()) == null) {
            i = this.e.a(com.bumptech.glide.c.c(context), m.i4(), m.l4(), context);
            if (b) {
                i.onStart();
            }
            m.r4(i);
        }
        return i;
    }
    
    private boolean p(final FragmentManager fragmentManager, final boolean b) {
        final o o = this.b.get(fragmentManager);
        final o o2 = (o)fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (o2 == o) {
            return true;
        }
        if (o2 != null && o2.e() != null) {
            final StringBuilder sb = new StringBuilder();
            sb.append("We've added two fragments with requests! Old: ");
            sb.append(o2);
            sb.append(" New: ");
            sb.append(o);
            throw new IllegalStateException(sb.toString());
        }
        if (!b && !fragmentManager.isDestroyed()) {
            final FragmentTransaction add = fragmentManager.beginTransaction().add((android.app.Fragment)o, "com.bumptech.glide.manager");
            if (o2 != null) {
                add.remove((android.app.Fragment)o2);
            }
            add.commitAllowingStateLoss();
            this.d.obtainMessage(1, 1, 0, (Object)fragmentManager).sendToTarget();
            if (Log.isLoggable("RMRetriever", 3)) {
                Log.d("RMRetriever", "We failed to add our Fragment the first time around, trying again...");
            }
            return false;
        }
        if (Log.isLoggable("RMRetriever", 5)) {
            if (fragmentManager.isDestroyed()) {
                Log.w("RMRetriever", "Parent was destroyed before our Fragment could be added");
            }
            else {
                Log.w("RMRetriever", "Tried adding Fragment twice and failed twice, giving up!");
            }
        }
        o.c().c();
        return true;
    }
    
    private boolean q(final androidx.fragment.app.FragmentManager fragmentManager, final boolean b) {
        final t t = this.c.get(fragmentManager);
        final t t2 = (t)fragmentManager.k0("com.bumptech.glide.manager");
        if (t2 == t) {
            return true;
        }
        if (t2 != null && t2.k4() != null) {
            final StringBuilder sb = new StringBuilder();
            sb.append("We've added two fragments with requests! Old: ");
            sb.append(t2);
            sb.append(" New: ");
            sb.append(t);
            throw new IllegalStateException(sb.toString());
        }
        if (!b && !fragmentManager.M0()) {
            final c0 e = fragmentManager.q().e(t, "com.bumptech.glide.manager");
            if (t2 != null) {
                e.p(t2);
            }
            e.l();
            this.d.obtainMessage(2, 1, 0, (Object)fragmentManager).sendToTarget();
            if (Log.isLoggable("RMRetriever", 3)) {
                Log.d("RMRetriever", "We failed to add our Fragment the first time around, trying again...");
            }
            return false;
        }
        if (fragmentManager.M0()) {
            if (Log.isLoggable("RMRetriever", 5)) {
                Log.w("RMRetriever", "Parent was destroyed before our Fragment could be added, all requests for the destroyed parent are cancelled");
            }
        }
        else if (Log.isLoggable("RMRetriever", 6)) {
            Log.e("RMRetriever", "ERROR: Tried adding Fragment twice and failed twice, giving up and cancelling all associated requests! This probably means you're starting loads in a unit test with an Activity that you haven't created and never create. If you're using Robolectric, create the Activity as part of your test setup");
        }
        t.i4().c();
        return true;
    }
    
    public i e(final Activity activity) {
        if (v2.l.r()) {
            return this.f(activity.getApplicationContext());
        }
        if (activity instanceof androidx.fragment.app.h) {
            return this.h((androidx.fragment.app.h)activity);
        }
        a(activity);
        this.i.a(activity);
        return this.d((Context)activity, activity.getFragmentManager(), null, n((Context)activity));
    }
    
    public i f(final Context context) {
        if (context != null) {
            if (v2.l.s() && !(context instanceof Application)) {
                if (context instanceof androidx.fragment.app.h) {
                    return this.h((androidx.fragment.app.h)context);
                }
                if (context instanceof Activity) {
                    return this.e((Activity)context);
                }
                if (context instanceof ContextWrapper) {
                    final ContextWrapper contextWrapper = (ContextWrapper)context;
                    if (contextWrapper.getBaseContext().getApplicationContext() != null) {
                        return this.f(contextWrapper.getBaseContext());
                    }
                }
            }
            return this.i(context);
        }
        throw new IllegalArgumentException("You cannot start a load on a null Context");
    }
    
    public i g(final Fragment fragment) {
        v2.k.e(fragment.getContext(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
        if (v2.l.r()) {
            return this.f(fragment.getContext().getApplicationContext());
        }
        if (fragment.getActivity() != null) {
            this.i.a(fragment.getActivity());
        }
        return this.o(fragment.getContext(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
    }
    
    public i h(final androidx.fragment.app.h h) {
        if (v2.l.r()) {
            return this.f(h.getApplicationContext());
        }
        a(h);
        this.i.a(h);
        return this.o((Context)h, h.getSupportFragmentManager(), null, n((Context)h));
    }
    
    public boolean handleMessage(final Message message) {
        final int arg1 = message.arg1;
        boolean b = false;
        final boolean b2 = true;
        boolean b3 = true;
        final boolean b4 = arg1 == 1;
        final int what = message.what;
        Object o = null;
        Object o2 = null;
        Label_0125: {
            Label_0123: {
                if (what != 1) {
                    if (what != 2) {
                        b3 = false;
                        break Label_0123;
                    }
                    o2 = message.obj;
                    if (!this.q((androidx.fragment.app.FragmentManager)o2, b4)) {
                        break Label_0123;
                    }
                    o = this.c.remove(o2);
                }
                else {
                    o2 = message.obj;
                    if (!this.p((FragmentManager)o2, b4)) {
                        break Label_0123;
                    }
                    o = this.b.remove(o2);
                }
                b = true;
                b3 = b2;
                break Label_0125;
            }
            o2 = null;
        }
        if (Log.isLoggable("RMRetriever", 5) && b && o == null) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Failed to remove expected request manager fragment, manager: ");
            sb.append(o2);
            Log.w("RMRetriever", sb.toString());
        }
        return b3;
    }
    
    @Deprecated
    o j(final Activity activity) {
        return this.k(activity.getFragmentManager(), null);
    }
    
    t l(final androidx.fragment.app.FragmentManager fragmentManager) {
        return this.m(fragmentManager, null);
    }
    
    public interface b
    {
        i a(final c p0, final l p1, final q p2, final Context p3);
    }
}
