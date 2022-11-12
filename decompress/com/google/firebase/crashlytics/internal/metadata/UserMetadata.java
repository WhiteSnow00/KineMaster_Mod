// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.metadata;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import java.util.Map;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import java.util.concurrent.atomic.AtomicMarkableReference;
import com.google.firebase.crashlytics.internal.common.CrashlyticsBackgroundWorker;

public class UserMetadata
{
    private final c a;
    private final CrashlyticsBackgroundWorker b;
    private final String c;
    private final a d;
    private final a e;
    private final AtomicMarkableReference<String> f;
    
    public UserMetadata(final String c, final FileStore fileStore, final CrashlyticsBackgroundWorker b) {
        this.d = new a(false);
        this.e = new a(true);
        this.f = new AtomicMarkableReference<String>(null, false);
        this.c = c;
        this.a = new c(fileStore);
        this.b = b;
    }
    
    public static UserMetadata c(final String s, final FileStore fileStore, final CrashlyticsBackgroundWorker crashlyticsBackgroundWorker) {
        final c c = new c(fileStore);
        final UserMetadata userMetadata = new UserMetadata(s, fileStore, crashlyticsBackgroundWorker);
        userMetadata.d.a.getReference().d(c.f(s, false));
        userMetadata.e.a.getReference().d(c.f(s, true));
        userMetadata.f.set(c.g(s), false);
        return userMetadata;
    }
    
    public static String d(final String s, final FileStore fileStore) {
        return new c(fileStore).g(s);
    }
    
    public Map<String, String> a() {
        return this.d.a();
    }
    
    public Map<String, String> b() {
        return this.e.a();
    }
    
    private class a
    {
        final AtomicMarkableReference<b> a;
        private final AtomicReference<Callable<Void>> b;
        private final boolean c;
        final UserMetadata d;
        
        public a(final UserMetadata d, final boolean c) {
            this.d = d;
            this.b = new AtomicReference<Callable<Void>>(null);
            this.c = c;
            int n;
            if (c) {
                n = 8192;
            }
            else {
                n = 1024;
            }
            this.a = new AtomicMarkableReference<b>(new b(64, n), false);
        }
        
        public Map<String, String> a() {
            return this.a.getReference().a();
        }
    }
}
