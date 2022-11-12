// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.mediaparser;

import android.media.metrics.LogSessionId;
import android.media.MediaFormat;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.analytics.PlayerId;
import android.media.MediaParser;

public final class MediaParserUtil
{
    private MediaParserUtil() {
    }
    
    public static void a(final MediaParser mediaParser, final PlayerId playerId) {
        a.a(mediaParser, playerId);
    }
    
    public static MediaFormat b(final Format format) {
        final MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", format.w);
        final int o = format.O;
        if (o != -1) {
            mediaFormat.setInteger("caption-service-number", o);
        }
        return mediaFormat;
    }
    
    private static final class a
    {
        public static void a(final MediaParser mediaParser, final PlayerId playerId) {
            final LogSessionId a = playerId.a();
            if (!a.equals((Object)LogSessionId.LOG_SESSION_ID_NONE)) {
                mediaParser.setLogSessionId(a);
            }
        }
    }
}
