// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase;

import android.content.Context;
import com.google.firebase.platforminfo.LibraryVersionComponent$VersionExtractor;

public final class f implements LibraryVersionComponent$VersionExtractor
{
    public static final f a;
    
    static {
        a = new f();
    }
    
    private f() {
    }
    
    public final String a(final Object o) {
        return FirebaseCommonRegistrar.d((Context)o);
    }
}
