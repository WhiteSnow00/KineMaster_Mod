// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core;

public interface ThreadInitializer
{
    public static final ThreadInitializer a = new ThreadInitializer() {
        @Override
        public void a(final Thread thread, final String name) {
            thread.setName(name);
        }
        
        @Override
        public void b(final Thread thread, final boolean daemon) {
            thread.setDaemon(daemon);
        }
        
        @Override
        public void c(final Thread thread, final Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            thread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
        }
    };
    
    void a(final Thread p0, final String p1);
    
    void b(final Thread p0, final boolean p1);
    
    void c(final Thread p0, final Thread.UncaughtExceptionHandler p1);
}
