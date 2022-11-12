// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.Logger;
import java.util.concurrent.atomic.AtomicBoolean;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.settings.SettingsProvider;

class i implements UncaughtExceptionHandler
{
    private final a a;
    private final SettingsProvider b;
    private final UncaughtExceptionHandler c;
    private final CrashlyticsNativeComponent d;
    private final AtomicBoolean e;
    
    public i(final a a, final SettingsProvider b, final UncaughtExceptionHandler c, final CrashlyticsNativeComponent d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.e = new AtomicBoolean(false);
        this.d = d;
    }
    
    private boolean b(final Thread thread, final Throwable t) {
        if (thread == null) {
            Logger.f().d("Crashlytics will not record uncaught exception; null thread");
            return false;
        }
        if (t == null) {
            Logger.f().d("Crashlytics will not record uncaught exception; null throwable");
            return false;
        }
        if (this.d.b()) {
            Logger.f().b("Crashlytics will not record uncaught exception; native crash exists for session.");
            return false;
        }
        return true;
    }
    
    boolean a() {
        return this.e.get();
    }
    
    @Override
    public void uncaughtException(final Thread thread, final Throwable t) {
        this.e.set(true);
        try {
            try {
                if (this.b(thread, t)) {
                    this.a.a(this.b, thread, t);
                }
                Logger.f().b("Uncaught exception will not be recorded by Crashlytics.");
            }
            finally {}
        }
        catch (final Exception ex) {
            Logger.f().e("An error occurred in the uncaught exception handler", ex);
        }
        Logger.f().b("Completed exception processing. Invoking default exception handler.");
        this.c.uncaughtException(thread, t);
        this.e.set(false);
        return;
        Logger.f().b("Completed exception processing. Invoking default exception handler.");
        this.c.uncaughtException(thread, t);
        this.e.set(false);
    }
    
    interface a
    {
        void a(final SettingsProvider p0, final Thread p1, final Throwable p2);
    }
}
