// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.components;

import java.util.Collections;
import com.google.firebase.inject.Provider;

public final class f implements Provider
{
    public static final f a;
    
    static {
        a = new f();
    }
    
    private f() {
    }
    
    public final Object get() {
        return Collections.emptySet();
    }
}
