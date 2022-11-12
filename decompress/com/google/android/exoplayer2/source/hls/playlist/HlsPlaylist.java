// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.hls.playlist;

import java.util.Collections;
import java.util.List;
import com.google.android.exoplayer2.offline.FilterableManifest;

public abstract class HlsPlaylist implements FilterableManifest<HlsPlaylist>
{
    public final String a;
    public final List<String> b;
    public final boolean c;
    
    protected HlsPlaylist(final String a, final List<String> list, final boolean c) {
        this.a = a;
        this.b = Collections.unmodifiableList((List<? extends String>)list);
        this.c = c;
    }
}
