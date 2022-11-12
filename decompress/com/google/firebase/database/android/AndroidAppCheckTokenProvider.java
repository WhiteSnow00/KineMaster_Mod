// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.android;

import p4.e;
import com.google.android.gms.tasks.OnFailureListener;
import p4.a;
import com.google.android.gms.tasks.OnSuccessListener;
import p4.b;
import com.google.firebase.appcheck.interop.AppCheckTokenListener;
import p4.c;
import com.google.firebase.appcheck.AppCheckTokenResult;
import com.google.firebase.inject.Provider;
import java.util.concurrent.ExecutorService;
import com.google.firebase.inject.Deferred$DeferredHandler;
import p4.d;
import java.util.concurrent.atomic.AtomicReference;
import com.google.firebase.appcheck.interop.InternalAppCheckTokenProvider;
import com.google.firebase.inject.Deferred;
import com.google.firebase.database.core.TokenProvider;

public class AndroidAppCheckTokenProvider implements TokenProvider
{
    private final Deferred<InternalAppCheckTokenProvider> a;
    private final AtomicReference<InternalAppCheckTokenProvider> b;
    
    public AndroidAppCheckTokenProvider(final Deferred<InternalAppCheckTokenProvider> a) {
        this.a = a;
        this.b = new AtomicReference<InternalAppCheckTokenProvider>();
        a.a((Deferred$DeferredHandler)new d(this));
    }
    
    public static void c(final ExecutorService executorService, final TokenChangeListener tokenChangeListener, final Provider provider) {
        g(executorService, tokenChangeListener, provider);
    }
    
    public static void d(final AndroidAppCheckTokenProvider androidAppCheckTokenProvider, final Provider provider) {
        androidAppCheckTokenProvider.j(provider);
    }
    
    public static void e(final GetTokenCompletionListener getTokenCompletionListener, final AppCheckTokenResult appCheckTokenResult) {
        h(getTokenCompletionListener, appCheckTokenResult);
    }
    
    public static void f(final GetTokenCompletionListener getTokenCompletionListener, final Exception ex) {
        i(getTokenCompletionListener, ex);
    }
    
    private static void g(final ExecutorService executorService, final TokenChangeListener tokenChangeListener, final Provider provider) {
        ((InternalAppCheckTokenProvider)provider.get()).b((AppCheckTokenListener)new c(executorService, tokenChangeListener));
    }
    
    private static void h(final GetTokenCompletionListener getTokenCompletionListener, final AppCheckTokenResult appCheckTokenResult) {
        getTokenCompletionListener.a(appCheckTokenResult.b());
    }
    
    private static void i(final GetTokenCompletionListener getTokenCompletionListener, final Exception ex) {
        getTokenCompletionListener.g(ex.getMessage());
    }
    
    private void j(final Provider provider) {
        this.b.set((InternalAppCheckTokenProvider)provider.get());
    }
    
    @Override
    public void a(final boolean b, final GetTokenCompletionListener getTokenCompletionListener) {
        final InternalAppCheckTokenProvider internalAppCheckTokenProvider = this.b.get();
        if (internalAppCheckTokenProvider != null) {
            internalAppCheckTokenProvider.a(b).i((OnSuccessListener)new b(getTokenCompletionListener)).f((OnFailureListener)new a(getTokenCompletionListener));
        }
        else {
            getTokenCompletionListener.a(null);
        }
    }
    
    @Override
    public void b(final ExecutorService executorService, final TokenChangeListener tokenChangeListener) {
        this.a.a((Deferred$DeferredHandler)new e(executorService, tokenChangeListener));
    }
}
