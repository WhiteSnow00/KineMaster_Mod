// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase;

import android.content.Context;
import com.google.firebase.platforminfo.LibraryVersionComponent$VersionExtractor;

public final class c implements LibraryVersionComponent$VersionExtractor
{
    public static final c a;
    
    static {
        a = new c();
    }
    
    private c() {
    }
    
    public final String a(final Object o) {
        return FirebaseCommonRegistrar.a((Context)o);
    }
}
