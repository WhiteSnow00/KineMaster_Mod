// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.metadata;

import java.io.File;
import com.google.firebase.crashlytics.internal.persistence.FileStore;

public class LogFileManager
{
    private static final b c;
    private final FileStore a;
    private a b;
    
    static {
        c = new b(null);
    }
    
    public LogFileManager(final FileStore a) {
        this.a = a;
        this.b = LogFileManager.c;
    }
    
    public LogFileManager(final FileStore fileStore, final String s) {
        this(fileStore);
        this.e(s);
    }
    
    private File d(final String s) {
        return this.a.o(s, "userlog");
    }
    
    public void a() {
        this.b.d();
    }
    
    public byte[] b() {
        return this.b.c();
    }
    
    public String c() {
        return this.b.b();
    }
    
    public final void e(final String s) {
        this.b.a();
        this.b = LogFileManager.c;
        if (s == null) {
            return;
        }
        this.f(this.d(s), 65536);
    }
    
    void f(final File file, final int n) {
        this.b = new d(file, n);
    }
    
    public void g(final long n, final String s) {
        this.b.e(n, s);
    }
    
    private static final class b implements a
    {
        private b() {
        }
        
        b(final LogFileManager$a object) {
            this();
        }
        
        @Override
        public void a() {
        }
        
        @Override
        public String b() {
            return null;
        }
        
        @Override
        public byte[] c() {
            return null;
        }
        
        @Override
        public void d() {
        }
        
        @Override
        public void e(final long n, final String s) {
        }
    }
}
