// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.util.Assertions;
import java.util.Map;
import android.net.Uri;
import java.util.LinkedHashMap;

final class FullSegmentEncryptionKeyCache
{
    private final LinkedHashMap<Uri, byte[]> a;
    
    public FullSegmentEncryptionKeyCache(final int n) {
        this.a = new LinkedHashMap<Uri, byte[]>(this, n + 1, 1.0f, false, n) {
            final int val$maxSize;
            
            @Override
            protected boolean removeEldestEntry(final Map.Entry<Uri, byte[]> entry) {
                return this.size() > this.val$maxSize;
            }
        };
    }
    
    public byte[] a(final Uri uri) {
        if (uri == null) {
            return null;
        }
        return this.a.get(uri);
    }
    
    public byte[] b(final Uri uri, final byte[] array) {
        return this.a.put(Assertions.e(uri), Assertions.e(array));
    }
    
    public byte[] c(final Uri uri) {
        return this.a.remove(Assertions.e(uri));
    }
}
