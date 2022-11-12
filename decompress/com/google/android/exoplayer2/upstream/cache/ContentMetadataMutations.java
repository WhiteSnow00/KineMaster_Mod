// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.upstream.cache;

import java.util.Collection;
import java.util.Iterator;
import java.util.Collections;
import java.util.Arrays;
import android.net.Uri;
import com.google.android.exoplayer2.util.Assertions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContentMetadataMutations
{
    private final Map<String, Object> a;
    private final List<String> b;
    
    public ContentMetadataMutations() {
        this.a = new HashMap<String, Object>();
        this.b = new ArrayList<String>();
    }
    
    private ContentMetadataMutations a(final String s, final Object o) {
        this.a.put(Assertions.e(s), Assertions.e(o));
        this.b.remove(s);
        return this;
    }
    
    public static ContentMetadataMutations g(final ContentMetadataMutations contentMetadataMutations, final long n) {
        return contentMetadataMutations.e("exo_len", n);
    }
    
    public static ContentMetadataMutations h(final ContentMetadataMutations contentMetadataMutations, final Uri uri) {
        if (uri == null) {
            return contentMetadataMutations.d("exo_redir");
        }
        return contentMetadataMutations.f("exo_redir", uri.toString());
    }
    
    public Map<String, Object> b() {
        final HashMap hashMap = new HashMap((Map<? extends K, ? extends V>)this.a);
        for (final Map.Entry<K, Object> entry : hashMap.entrySet()) {
            final byte[] value = entry.getValue();
            if (value instanceof byte[]) {
                final byte[] array = value;
                entry.setValue(Arrays.copyOf(array, array.length));
            }
        }
        return (Map<String, Object>)Collections.unmodifiableMap((Map<?, ?>)hashMap);
    }
    
    public List<String> c() {
        return Collections.unmodifiableList((List<? extends String>)new ArrayList<String>(this.b));
    }
    
    public ContentMetadataMutations d(final String s) {
        this.b.add(s);
        this.a.remove(s);
        return this;
    }
    
    public ContentMetadataMutations e(final String s, final long n) {
        return this.a(s, n);
    }
    
    public ContentMetadataMutations f(final String s, final String s2) {
        return this.a(s, s2);
    }
}
