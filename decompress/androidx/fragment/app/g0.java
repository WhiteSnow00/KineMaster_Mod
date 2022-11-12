// 
// Decompiled by Procyon v0.6.0
// 

package androidx.fragment.app;

import u0.c;
import androidx.lifecycle.i0;
import android.content.Context;
import android.app.Application;
import android.content.ContextWrapper;
import k0.a;
import android.os.Bundle;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.r;
import androidx.lifecycle.Lifecycle;
import u0.d;
import androidx.lifecycle.t;
import androidx.lifecycle.o0;
import androidx.lifecycle.q0;
import androidx.lifecycle.r0;
import u0.e;
import androidx.lifecycle.k;

class g0 implements k, e, r0
{
    private final Fragment a;
    private final q0 b;
    private o0.b c;
    private t d;
    private d e;
    
    g0(final Fragment a, final q0 b) {
        this.d = null;
        this.e = null;
        this.a = a;
        this.b = b;
    }
    
    void a(final Lifecycle.Event event) {
        this.d.h(event);
    }
    
    void b() {
        if (this.d == null) {
            this.d = new t(this);
            (this.e = u0.d.a(this)).c();
            SavedStateHandleSupport.c(this);
        }
    }
    
    boolean c() {
        return this.d != null;
    }
    
    void d(final Bundle bundle) {
        this.e.d(bundle);
    }
    
    void e(final Bundle bundle) {
        this.e.e(bundle);
    }
    
    void f(final Lifecycle.State state) {
        this.d.o(state);
    }
    
    @Override
    public a getDefaultViewModelCreationExtras() {
        while (true) {
            for (Context context = this.a.requireContext().getApplicationContext(); context instanceof ContextWrapper; context = ((ContextWrapper)context).getBaseContext()) {
                if (context instanceof Application) {
                    final Application application = (Application)context;
                    final k0.d d = new k0.d();
                    if (application != null) {
                        d.c(o0.a.h, application);
                    }
                    d.c(SavedStateHandleSupport.a, this);
                    d.c(SavedStateHandleSupport.b, this);
                    if (this.a.getArguments() != null) {
                        d.c(SavedStateHandleSupport.c, this.a.getArguments());
                    }
                    return d;
                }
            }
            final Application application = null;
            continue;
        }
    }
    
    @Override
    public o0.b getDefaultViewModelProviderFactory() {
        final o0.b defaultViewModelProviderFactory = this.a.getDefaultViewModelProviderFactory();
        if (!defaultViewModelProviderFactory.equals(this.a.mDefaultFactory)) {
            return this.c = defaultViewModelProviderFactory;
        }
        if (this.c == null) {
            final Application application = null;
            Context context = this.a.requireContext().getApplicationContext();
            Application application2;
            while (true) {
                application2 = application;
                if (!(context instanceof ContextWrapper)) {
                    break;
                }
                if (context instanceof Application) {
                    application2 = (Application)context;
                    break;
                }
                context = ((ContextWrapper)context).getBaseContext();
            }
            this.c = new i0(application2, this, this.a.getArguments());
        }
        return this.c;
    }
    
    @Override
    public Lifecycle getLifecycle() {
        this.b();
        return this.d;
    }
    
    @Override
    public c getSavedStateRegistry() {
        this.b();
        return this.e.b();
    }
    
    @Override
    public q0 getViewModelStore() {
        this.b();
        return this.b;
    }
}
