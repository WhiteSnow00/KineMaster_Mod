// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.rtsp;

import java.io.IOException;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSourceUtil;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.DefaultExtractorInput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.Util;
import android.os.Handler;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.upstream.Loader;

final class RtpDataLoadable implements Loadable
{
    public final int a;
    public final l b;
    private final EventListener c;
    private final ExtractorOutput d;
    private final Handler e;
    private final RtpDataChannel.Factory f;
    private com.google.android.exoplayer2.source.rtsp.b g;
    private volatile boolean h;
    private volatile long i;
    private volatile long j;
    
    public RtpDataLoadable(final int a, final l b, final EventListener c, final ExtractorOutput d, final RtpDataChannel.Factory f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = Util.w();
        this.f = f;
        this.i = -9223372036854775807L;
    }
    
    public static void b(final RtpDataLoadable rtpDataLoadable, final String s, final RtpDataChannel rtpDataChannel) {
        rtpDataLoadable.d(s, rtpDataChannel);
    }
    
    private void d(final String s, final RtpDataChannel rtpDataChannel) {
        this.c.a(s, rtpDataChannel);
    }
    
    @Override
    public void a() throws IOException {
        DataSource a = null;
        try {
            final RtpDataChannel rtpDataChannel = (RtpDataChannel)(a = this.f.a(this.a));
            final String c = rtpDataChannel.c();
            a = rtpDataChannel;
            final Handler e = this.e;
            a = rtpDataChannel;
            a = rtpDataChannel;
            final a a2 = new a(this, c, rtpDataChannel);
            a = rtpDataChannel;
            e.post((Runnable)a2);
            a = rtpDataChannel;
            a = rtpDataChannel;
            final DefaultExtractorInput defaultExtractorInput = new DefaultExtractorInput(Assertions.e(rtpDataChannel), 0L, -1L);
            a = rtpDataChannel;
            a = rtpDataChannel;
            final com.google.android.exoplayer2.source.rtsp.b g = new com.google.android.exoplayer2.source.rtsp.b(this.b.a, this.a);
            a = rtpDataChannel;
            this.g = g;
            a = rtpDataChannel;
            g.b(this.d);
            com.google.android.exoplayer2.source.rtsp.b g2;
            PositionHolder positionHolder;
            do {
                a = rtpDataChannel;
                if (this.h) {
                    break;
                }
                a = rtpDataChannel;
                if (this.i != -9223372036854775807L) {
                    a = rtpDataChannel;
                    this.g.a(this.j, this.i);
                    a = rtpDataChannel;
                    this.i = -9223372036854775807L;
                }
                a = rtpDataChannel;
                g2 = this.g;
                a = rtpDataChannel;
                a = rtpDataChannel;
                positionHolder = new PositionHolder();
                a = rtpDataChannel;
            } while (g2.e(defaultExtractorInput, positionHolder) != -1);
        }
        finally {
            DataSourceUtil.a(a);
        }
    }
    
    @Override
    public void c() {
        this.h = true;
    }
    
    public void e() {
        Assertions.e(this.g).g();
    }
    
    public void f(final long i, final long j) {
        this.i = i;
        this.j = j;
    }
    
    public void g(final int n) {
        if (!Assertions.e(this.g).f()) {
            this.g.h(n);
        }
    }
    
    public void h(final long n) {
        if (n != -9223372036854775807L && !Assertions.e(this.g).f()) {
            this.g.i(n);
        }
    }
    
    public interface EventListener
    {
        void a(final String p0, final RtpDataChannel p1);
    }
}
