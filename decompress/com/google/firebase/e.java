// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase;

import android.content.Context;
import com.google.firebase.platforminfo.LibraryVersionComponent$VersionExtractor;

public final class e implements LibraryVersionComponent$VersionExtractor
{
    public static final e a;
    
    static {
        a = new e();
    }
    
    private e() {
    }
    
    public final String a(final Object o) {
        return FirebaseCommonRegistrar.c((Context)o);
    }
}
