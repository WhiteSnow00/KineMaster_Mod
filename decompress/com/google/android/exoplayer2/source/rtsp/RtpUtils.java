// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.upstream.DataSpec;

public final class RtpUtils
{
    private RtpUtils() {
    }
    
    public static DataSpec a(final int n) {
        return new DataSpec(Uri.parse(Util.C("%s:%d", "rtp://0.0.0.0", n)));
    }
}
