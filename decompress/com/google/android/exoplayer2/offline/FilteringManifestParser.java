// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.offline;

import java.io.IOException;
import java.io.InputStream;
import android.net.Uri;
import java.util.List;
import com.google.android.exoplayer2.upstream.ParsingLoadable;

public final class FilteringManifestParser<T extends FilterableManifest<T>> implements Parser<T>
{
    private final Parser<? extends T> a;
    private final List<StreamKey> b;
    
    public FilteringManifestParser(final Parser<? extends T> a, final List<StreamKey> b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public /* bridge */ Object a(final Uri uri, final InputStream inputStream) throws IOException {
        return this.b(uri, inputStream);
    }
    
    public T b(final Uri uri, final InputStream inputStream) throws IOException {
        final FilterableManifest filterableManifest = (FilterableManifest)this.a.a(uri, inputStream);
        final List<StreamKey> b = this.b;
        FilterableManifest<T> filterableManifest2 = filterableManifest;
        if (b != null) {
            if (b.isEmpty()) {
                filterableManifest2 = filterableManifest;
            }
            else {
                filterableManifest2 = filterableManifest.a(this.b);
            }
        }
        return (T)filterableManifest2;
    }
}
