// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.hls.playlist;

import com.google.android.exoplayer2.drm.DrmInitData;
import java.util.Map;
import com.google.android.exoplayer2.Format;
import java.util.List;

@Deprecated
public final class HlsMasterPlaylist extends HlsMultivariantPlaylist
{
    @Deprecated
    public HlsMasterPlaylist(final String s, final List<String> list, final List<Variant> list2, final List<Rendition> list3, final List<Rendition> list4, final List<Rendition> list5, final List<Rendition> list6, final Format format, final List<Format> list7, final boolean b, final Map<String, String> map, final List<DrmInitData> list8) {
        super(s, list, list2, list3, list4, list5, list6, format, list7, b, map, list8);
    }
}
