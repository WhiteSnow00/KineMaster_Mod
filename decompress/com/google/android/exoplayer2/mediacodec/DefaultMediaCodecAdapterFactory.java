// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.mediacodec;

import java.io.IOException;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;

public final class DefaultMediaCodecAdapterFactory implements Factory
{
    private int a;
    private boolean b;
    
    public DefaultMediaCodecAdapterFactory() {
        this.a = 0;
    }
    
    @Override
    public MediaCodecAdapter a(final Configuration configuration) throws IOException {
        final int a = Util.a;
        if (a >= 23) {
            final int a2 = this.a;
            if (a2 == 1 || (a2 == 0 && a >= 31)) {
                final int k = MimeTypes.k(configuration.c.w);
                final StringBuilder sb = new StringBuilder();
                sb.append("Creating an asynchronous MediaCodec adapter for track type ");
                sb.append(Util.m0(k));
                Log.f("DMCodecAdapterFactory", sb.toString());
                return new AsynchronousMediaCodecAdapter.Factory(k, this.b).d(configuration);
            }
        }
        return new SynchronousMediaCodecAdapter.Factory().a(configuration);
    }
}
