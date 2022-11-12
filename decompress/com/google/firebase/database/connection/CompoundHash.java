// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.connection;

import java.util.Collections;
import java.util.List;

public class CompoundHash
{
    private final List<List<String>> a;
    private final List<String> b;
    
    public CompoundHash(final List<List<String>> a, final List<String> b) {
        if (a.size() == b.size() - 1) {
            this.a = a;
            this.b = b;
            return;
        }
        throw new IllegalArgumentException("Number of posts need to be n-1 for n hashes in CompoundHash");
    }
    
    public List<String> a() {
        return Collections.unmodifiableList((List<? extends String>)this.b);
    }
    
    public List<List<String>> b() {
        return Collections.unmodifiableList((List<? extends List<String>>)this.a);
    }
}
