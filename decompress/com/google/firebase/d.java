// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase;

import android.content.Context;
import com.google.firebase.platforminfo.LibraryVersionComponent$VersionExtractor;

public final class d implements LibraryVersionComponent$VersionExtractor
{
    public static final d a;
    
    static {
        a = new d();
    }
    
    private d() {
    }
    
    public final String a(final Object o) {
        return FirebaseCommonRegistrar.b((Context)o);
    }
}
