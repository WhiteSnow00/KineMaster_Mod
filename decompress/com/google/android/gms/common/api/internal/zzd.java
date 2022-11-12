// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.content.Intent;
import java.util.Iterator;
import java.io.PrintWriter;
import java.io.FileDescriptor;
import android.app.Activity;
import com.google.android.gms.internal.common.zzi;
import android.os.Looper;
import java.lang.ref.WeakReference;
import androidx.fragment.app.h;
import java.util.Collections;
import androidx.collection.a;
import android.os.Bundle;
import java.util.Map;
import java.util.WeakHashMap;
import androidx.fragment.app.Fragment;

public final class zzd extends Fragment implements LifecycleFragment
{
    private static final WeakHashMap d;
    private final Map a;
    private int b;
    private Bundle c;
    
    static {
        d = new WeakHashMap();
    }
    
    public zzd() {
        this.a = Collections.synchronizedMap(new a<Object, Object>());
        this.b = 0;
    }
    
    static /* bridge */ int g4(final zzd zzd) {
        return zzd.b;
    }
    
    static /* bridge */ Bundle h4(final zzd zzd) {
        return zzd.c;
    }
    
    public static zzd i4(final h h) {
        final WeakHashMap d = zzd.d;
        final WeakReference weakReference = d.get(h);
        if (weakReference != null) {
            final zzd zzd = (zzd)weakReference.get();
            if (zzd != null) {
                return zzd;
            }
        }
        try {
            final zzd zzd2 = (zzd)h.getSupportFragmentManager().k0("SupportLifecycleFragmentImpl");
            zzd zzd3 = null;
            Label_0085: {
                if (zzd2 != null) {
                    zzd3 = zzd2;
                    if (!zzd2.isRemoving()) {
                        break Label_0085;
                    }
                }
                zzd3 = new zzd();
                h.getSupportFragmentManager().q().e(zzd3, "SupportLifecycleFragmentImpl").j();
            }
            d.put(h, new WeakReference(zzd3));
            return zzd3;
        }
        catch (final ClassCastException ex) {
            throw new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", ex);
        }
    }
    
    @Override
    public final void J(final String s, final LifecycleCallback lifecycleCallback) {
        if (!this.a.containsKey(s)) {
            this.a.put(s, lifecycleCallback);
            if (this.b > 0) {
                ((Handler)new zzi(Looper.getMainLooper())).post((Runnable)new w0(this, lifecycleCallback, s));
            }
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("LifecycleCallback with tag ");
        sb.append(s);
        sb.append(" already added to this fragment.");
        throw new IllegalArgumentException(sb.toString());
    }
    
    @Override
    public final Activity T2() {
        return this.getActivity();
    }
    
    @Override
    public final void dump(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
        super.dump(s, fileDescriptor, printWriter, array);
        final Iterator iterator = this.a.values().iterator();
        while (iterator.hasNext()) {
            ((LifecycleCallback)iterator.next()).a(s, fileDescriptor, printWriter, array);
        }
    }
    
    @Override
    public final void onActivityResult(final int n, final int n2, final Intent intent) {
        super.onActivityResult(n, n2, intent);
        final Iterator iterator = this.a.values().iterator();
        while (iterator.hasNext()) {
            ((LifecycleCallback)iterator.next()).e(n, n2, intent);
        }
    }
    
    @Override
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
    
    @Override
    public final void onDestroy() {
        super.onDestroy();
        this.b = 5;
        final Iterator iterator = this.a.values().iterator();
        while (iterator.hasNext()) {
            ((LifecycleCallback)iterator.next()).g();
        }
    }
    
    @Override
    public final void onResume() {
        super.onResume();
        this.b = 3;
        final Iterator iterator = this.a.values().iterator();
        while (iterator.hasNext()) {
            ((LifecycleCallback)iterator.next()).h();
        }
    }
    
    @Override
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
    
    @Override
    public final void onStart() {
        super.onStart();
        this.b = 2;
        final Iterator iterator = this.a.values().iterator();
        while (iterator.hasNext()) {
            ((LifecycleCallback)iterator.next()).j();
        }
    }
    
    @Override
    public final void onStop() {
        super.onStop();
        this.b = 4;
        final Iterator iterator = this.a.values().iterator();
        while (iterator.hasNext()) {
            ((LifecycleCallback)iterator.next()).k();
        }
    }
    
    @Override
    public final <T extends LifecycleCallback> T u0(final String s, final Class<T> clazz) {
        return clazz.cast(this.a.get(s));
    }
}
