// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.content.Intent;
import java.util.Iterator;
import java.io.PrintWriter;
import java.io.FileDescriptor;
import com.google.android.gms.internal.common.zzi;
import android.os.Looper;
import java.lang.ref.WeakReference;
import android.app.Activity;
import java.util.Collections;
import androidx.collection.a;
import android.os.Bundle;
import java.util.Map;
import java.util.WeakHashMap;
import android.app.Fragment;

public final class zzb extends Fragment implements LifecycleFragment
{
    private static final WeakHashMap d;
    private final Map a;
    private int b;
    private Bundle c;
    
    static {
        d = new WeakHashMap();
    }
    
    public zzb() {
        this.a = Collections.synchronizedMap(new a<Object, Object>());
        this.b = 0;
    }
    
    static /* bridge */ int a(final zzb zzb) {
        return zzb.b;
    }
    
    static /* bridge */ Bundle b(final zzb zzb) {
        return zzb.c;
    }
    
    public static zzb c(final Activity activity) {
        final WeakHashMap d = zzb.d;
        final WeakReference weakReference = d.get(activity);
        if (weakReference != null) {
            final zzb zzb = (zzb)weakReference.get();
            if (zzb != null) {
                return zzb;
            }
        }
        try {
            final zzb zzb2 = (zzb)activity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
            zzb zzb3 = null;
            Label_0085: {
                if (zzb2 != null) {
                    zzb3 = zzb2;
                    if (!zzb2.isRemoving()) {
                        break Label_0085;
                    }
                }
                zzb3 = new zzb();
                activity.getFragmentManager().beginTransaction().add((Fragment)zzb3, "LifecycleFragmentImpl").commitAllowingStateLoss();
            }
            d.put(activity, new WeakReference(zzb3));
            return zzb3;
        }
        catch (final ClassCastException ex) {
            throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", ex);
        }
    }
    
    public final void J(final String s, final LifecycleCallback lifecycleCallback) {
        if (!this.a.containsKey(s)) {
            this.a.put(s, lifecycleCallback);
            if (this.b > 0) {
                ((Handler)new zzi(Looper.getMainLooper())).post((Runnable)new v0(this, lifecycleCallback, s));
            }
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("LifecycleCallback with tag ");
        sb.append(s);
        sb.append(" already added to this fragment.");
        throw new IllegalArgumentException(sb.toString());
    }
    
    public final Activity T2() {
        return this.getActivity();
    }
    
    public final void dump(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
        super.dump(s, fileDescriptor, printWriter, array);
        final Iterator iterator = this.a.values().iterator();
        while (iterator.hasNext()) {
            ((LifecycleCallback)iterator.next()).a(s, fileDescriptor, printWriter, array);
        }
    }
    
    public final void onActivityResult(final int n, final int n2, final Intent intent) {
        super.onActivityResult(n, n2, intent);
        final Iterator iterator = this.a.values().iterator();
        while (iterator.hasNext()) {
            ((LifecycleCallback)iterator.next()).e(n, n2, intent);
        }
    }
    
    public final void onCreate(final Bundle c) {
        super.onCreate(c);
        this.b = 1;
        this.c = c;
        for (final Map.Entry<K, LifecycleCallback> entry : this.a.entrySet()) {
            final LifecycleCallback lifecycleCallback = entry.getValue();
            Bundle bundle;
            if (c != null) {
                bundle = c.getBundle((String)entry.getKey());
            }
            else {
                bundle = null;
            }
            lifecycleCallback.f(bundle);
        }
    }
    
    public final void onDestroy() {
        super.onDestroy();
        this.b = 5;
        final Iterator iterator = this.a.values().iterator();
        while (iterator.hasNext()) {
            ((LifecycleCallback)iterator.next()).g();
        }
    }
    
    public final void onResume() {
        super.onResume();
        this.b = 3;
        final Iterator iterator = this.a.values().iterator();
        while (iterator.hasNext()) {
            ((LifecycleCallback)iterator.next()).h();
        }
    }
    
    public final void onSaveInstanceState(final Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle == null) {
            return;
        }
        for (final Map.Entry<K, LifecycleCallback> entry : this.a.entrySet()) {
            final Bundle bundle2 = new Bundle();
            entry.getValue().i(bundle2);
            bundle.putBundle((String)entry.getKey(), bundle2);
        }
    }
    
    public final void onStart() {
        super.onStart();
        this.b = 2;
        final Iterator iterator = this.a.values().iterator();
        while (iterator.hasNext()) {
            ((LifecycleCallback)iterator.next()).j();
        }
    }
    
    public final void onStop() {
        super.onStop();
        this.b = 4;
        final Iterator iterator = this.a.values().iterator();
        while (iterator.hasNext()) {
            ((LifecycleCallback)iterator.next()).k();
        }
    }
    
    public final <T extends LifecycleCallback> T u0(final String s, final Class<T> clazz) {
        return clazz.cast(this.a.get(s));
    }
}
