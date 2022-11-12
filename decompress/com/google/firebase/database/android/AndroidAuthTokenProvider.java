// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.android;

import p4.j;
import com.google.android.gms.tasks.OnFailureListener;
import p4.f;
import com.google.android.gms.tasks.OnSuccessListener;
import p4.g;
import com.google.firebase.auth.internal.IdTokenListener;
import p4.h;
import p4.k;
import com.google.firebase.internal.api.FirebaseNoSignedInUserException;
import com.google.firebase.FirebaseApiNotAvailableException;
import java.util.concurrent.ExecutorService;
import com.google.firebase.internal.InternalTokenResult;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.inject.Provider;
import com.google.firebase.inject.Deferred$DeferredHandler;
import p4.i;
import java.util.concurrent.atomic.AtomicReference;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.inject.Deferred;
import com.google.firebase.database.core.TokenProvider;

public class AndroidAuthTokenProvider implements TokenProvider
{
    private final Deferred<InternalAuthProvider> a;
    private final AtomicReference<InternalAuthProvider> b;
    
    public AndroidAuthTokenProvider(final Deferred<InternalAuthProvider> a) {
        this.a = a;
        this.b = new AtomicReference<InternalAuthProvider>();
        a.a((Deferred$DeferredHandler)new i(this));
    }
    
    public static void c(final AndroidAuthTokenProvider androidAuthTokenProvider, final Provider provider) {
        androidAuthTokenProvider.o(provider);
    }
    
    public static void d(final GetTokenCompletionListener getTokenCompletionListener, final GetTokenResult getTokenResult) {
        m(getTokenCompletionListener, getTokenResult);
    }
    
    public static void e(final TokenChangeListener tokenChangeListener, final InternalTokenResult internalTokenResult) {
        j(tokenChangeListener, internalTokenResult);
    }
    
    public static void f(final ExecutorService executorService, final TokenChangeListener tokenChangeListener, final InternalTokenResult internalTokenResult) {
        k(executorService, tokenChangeListener, internalTokenResult);
    }
    
    public static void g(final GetTokenCompletionListener getTokenCompletionListener, final Exception ex) {
        n(getTokenCompletionListener, ex);
    }
    
    public static void h(final ExecutorService executorService, final TokenChangeListener tokenChangeListener, final Provider provider) {
        l(executorService, tokenChangeListener, provider);
    }
    
    private static boolean i(final Exception ex) {
        return ex instanceof FirebaseApiNotAvailableException || ex instanceof FirebaseNoSignedInUserException;
    }
    
    private static void j(final TokenChangeListener tokenChangeListener, final InternalTokenResult internalTokenResult) {
        tokenChangeListener.a(internalTokenResult.a());
    }
    
    private static void k(final ExecutorService executorService, final TokenChangeListener tokenChangeListener, final InternalTokenResult internalTokenResult) {
        executorService.execute((Runnable)new k(tokenChangeListener, internalTokenResult));
    }
    
    private static void l(final ExecutorService executorService, final TokenChangeListener tokenChangeListener, final Provider provider) {
        ((InternalAuthProvider)provider.get()).b((IdTokenListener)new h(executorService, tokenChangeListener));
    }
    
    private static void m(final GetTokenCompletionListener getTokenCompletionListener, final GetTokenResult getTokenResult) {
        getTokenCompletionListener.a(getTokenResult.c());
    }
    
    private static void n(final GetTokenCompletionListener getTokenCompletionListener, final Exception ex) {
        if (i(ex)) {
            getTokenCompletionListener.a(null);
        }
        else {
            getTokenCompletionListener.g(ex.getMessage());
        }
    }
    
    private void o(final Provider provider) {
        this.b.set((InternalAuthProvider)provider.get());
    }
    
    @Override
    public void a(final boolean b, final GetTokenCompletionListener getTokenCompletionListener) {
        final InternalAuthProvider internalAuthProvider = this.b.get();
        if (internalAuthProvider != null) {
            internalAuthProvider.a(b).i((OnSuccessListener)new g(getTokenCompletionListener)).f((OnFailureListener)new f(getTokenCompletionListener));
        }
        else {
            getTokenCompletionListener.a(null);
        }
    }
    
    @Override
    public void b(final ExecutorService executorService, final TokenChangeListener tokenChangeListener) {
        this.a.a((Deferred$DeferredHandler)new j(executorService, tokenChangeListener));
    }
}
