// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.dash;

import java.util.List;
import com.google.android.exoplayer2.source.dash.manifest.BaseUrl;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.source.dash.manifest.RangedUri;
import com.google.android.exoplayer2.source.dash.manifest.Representation;

public final class DashUtil
{
    private DashUtil() {
    }
    
    public static DataSpec a(final Representation representation, final String s, final RangedUri rangedUri, final int n) {
        return new DataSpec.Builder().i(rangedUri.b(s)).h(rangedUri.a).g(rangedUri.b).f(b(representation, rangedUri)).b(n).a();
    }
    
    public static String b(final Representation representation, final RangedUri rangedUri) {
        final String k = representation.k();
        String string;
        if (k != null) {
            string = k;
        }
        else {
            string = rangedUri.b(((List<BaseUrl>)representation.c).get(0).a).toString();
        }
        return string;
    }
}
