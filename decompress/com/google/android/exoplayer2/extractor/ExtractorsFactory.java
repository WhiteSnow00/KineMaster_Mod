// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor;

import java.util.List;
import java.util.Map;
import android.net.Uri;
import k3.c;

public interface ExtractorsFactory
{
    public static final ExtractorsFactory a = c.b;
    
    default Extractor[] a() {
        return new Extractor[0];
    }
    
    default Extractor[] d() {
        return a();
    }
    
    default Extractor[] b(final Uri uri, final Map<String, List<String>> map) {
        return this.c();
    }
    
    Extractor[] c();
}
