// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.common;

import java.io.File;
import java.io.FilenameFilter;

public final class e implements FilenameFilter
{
    public static final e a;
    
    static {
        a = new e();
    }
    
    private e() {
    }
    
    @Override
    public final boolean accept(final File file, final String s) {
        return f.a(file, s);
    }
}
