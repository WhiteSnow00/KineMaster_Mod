// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.connection;

import java.util.List;

public class RangeMerge
{
    private final List<String> a;
    private final List<String> b;
    private final Object c;
    
    public RangeMerge(final List<String> a, final List<String> b, final Object c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public List<String> a() {
        return this.a;
    }
    
    public List<String> b() {
        return this.b;
    }
    
    public Object c() {
        return this.c;
    }
}
