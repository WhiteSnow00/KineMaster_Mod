// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.upstream.cache;

import android.net.Uri;

public interface ContentMetadata
{
    default Uri b(final ContentMetadata contentMetadata) {
        final Uri uri = null;
        final String c = contentMetadata.c("exo_redir", null);
        Uri parse;
        if (c == null) {
            parse = uri;
        }
        else {
            parse = Uri.parse(c);
        }
        return parse;
    }
    
    default long d(final ContentMetadata contentMetadata) {
        return contentMetadata.a("exo_len", -1L);
    }
    
    long a(final String p0, final long p1);
    
    String c(final String p0, final String p1);
}
