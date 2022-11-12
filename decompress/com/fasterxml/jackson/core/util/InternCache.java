// 
// Decompiled by Procyon v0.6.0
// 

package com.fasterxml.jackson.core.util;

import java.util.concurrent.ConcurrentHashMap;

public final class InternCache extends ConcurrentHashMap<String, String>
{
    public static final InternCache instance;
    private static final long serialVersionUID = 1L;
    private final Object lock;
    
    static {
        instance = new InternCache();
    }
    
    private InternCache() {
        super(180, 0.8f, 4);
        this.lock = new Object();
    }
    
    public String intern(String intern) {
        final String s = ((ConcurrentHashMap<K, String>)this).get(intern);
        if (s != null) {
            return s;
        }
        if (this.size() >= 180) {
            synchronized (this.lock) {
                if (this.size() >= 180) {
                    this.clear();
                }
            }
        }
        intern = intern.intern();
        this.put(intern, intern);
        return intern;
    }
}
