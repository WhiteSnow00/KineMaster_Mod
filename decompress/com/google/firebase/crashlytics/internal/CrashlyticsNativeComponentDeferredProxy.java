// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal;

import java.io.File;
import l4.b;
import com.google.firebase.crashlytics.internal.model.StaticSessionData;
import com.google.firebase.inject.Provider;
import com.google.firebase.inject.Deferred$DeferredHandler;
import l4.a;
import java.util.concurrent.atomic.AtomicReference;
import com.google.firebase.inject.Deferred;

public final class CrashlyticsNativeComponentDeferredProxy implements CrashlyticsNativeComponent
{
    private static final NativeSessionFileProvider c;
    private final Deferred<CrashlyticsNativeComponent> a;
    private final AtomicReference<CrashlyticsNativeComponent> b;
    
    static {
        c = new b(null);
    }
    
    public CrashlyticsNativeComponentDeferredProxy(final Deferred<CrashlyticsNativeComponent> a) {
        this.b = new AtomicReference<CrashlyticsNativeComponent>(null);
        (this.a = a).a((Deferred$DeferredHandler)new a(this));
    }
    
    public static void e(final CrashlyticsNativeComponentDeferredProxy crashlyticsNativeComponentDeferredProxy, final Provider provider) {
        crashlyticsNativeComponentDeferredProxy.g(provider);
    }
    
    public static void f(final String s, final String s2, final long n, final StaticSessionData staticSessionData, final Provider provider) {
        h(s, s2, n, staticSessionData, provider);
    }
    
    private void g(final Provider provider) {
        Logger.f().b("Crashlytics native component now available.");
        this.b.set((CrashlyticsNativeComponent)provider.get());
    }
    
    private static void h(final String s, final String s2, final long n, final StaticSessionData staticSessionData, final Provider provider) {
        ((CrashlyticsNativeComponent)provider.get()).c(s, s2, n, staticSessionData);
    }
    
    @Override
    public NativeSessionFileProvider a(final String s) {
        final CrashlyticsNativeComponent crashlyticsNativeComponent = this.b.get();
        NativeSessionFileProvider nativeSessionFileProvider;
        if (crashlyticsNativeComponent == null) {
            nativeSessionFileProvider = CrashlyticsNativeComponentDeferredProxy.c;
        }
        else {
            nativeSessionFileProvider = crashlyticsNativeComponent.a(s);
        }
        return nativeSessionFileProvider;
    }
    
    @Override
    public boolean b() {
        final CrashlyticsNativeComponent crashlyticsNativeComponent = this.b.get();
        return crashlyticsNativeComponent != null && crashlyticsNativeComponent.b();
    }
    
    @Override
    public void c(final String s, final String s2, final long n, final StaticSessionData staticSessionData) {
        final Logger f = Logger.f();
        final StringBuilder sb = new StringBuilder();
        sb.append("Deferring native open session: ");
        sb.append(s);
        f.i(sb.toString());
        this.a.a((Deferred$DeferredHandler)new l4.b(s, s2, n, staticSessionData));
    }
    
    @Override
    public boolean d(final String s) {
        final CrashlyticsNativeComponent crashlyticsNativeComponent = this.b.get();
        return crashlyticsNativeComponent != null && crashlyticsNativeComponent.d(s);
    }
    
    private static final class b implements NativeSessionFileProvider
    {
        private b() {
        }
        
        b(final CrashlyticsNativeComponentDeferredProxy$a object) {
            this();
        }
        
        @Override
        public File a() {
            return null;
        }
        
        @Override
        public File b() {
            return null;
        }
        
        @Override
        public File c() {
            return null;
        }
        
        @Override
        public File d() {
            return null;
        }
        
        @Override
        public File e() {
            return null;
        }
        
        @Override
        public File f() {
            return null;
        }
    }
}
