// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core;

import com.google.firebase.database.snapshot.ChildKey;

public class Constants
{
    public static final ChildKey a;
    public static final ChildKey b;
    public static final ChildKey c;
    public static final ChildKey d;
    
    static {
        a = ChildKey.f(".info");
        b = ChildKey.f("serverTimeOffset");
        c = ChildKey.f("authenticated");
        d = ChildKey.f("connected");
    }
}
