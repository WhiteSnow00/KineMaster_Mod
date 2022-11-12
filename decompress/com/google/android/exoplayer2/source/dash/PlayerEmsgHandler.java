// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.dash;

import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.Format;
import java.io.IOException;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.metadata.MetadataInputBuffer;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.chunk.Chunk;
import android.os.Message;
import java.util.Iterator;
import com.google.android.exoplayer2.ParserException;
import java.util.Map;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import java.util.TreeMap;
import android.os.Handler;
import com.google.android.exoplayer2.metadata.emsg.EventMessageDecoder;
import com.google.android.exoplayer2.upstream.Allocator;
import android.os.Handler$Callback;

public final class PlayerEmsgHandler implements Handler$Callback
{
    private final Allocator a;
    private final PlayerEmsgCallback b;
    private final EventMessageDecoder c;
    private final Handler d;
    private final TreeMap<Long, Long> e;
    private DashManifest f;
    private long g;
    private boolean h;
    private boolean i;
    private boolean j;
    
    public PlayerEmsgHandler(final DashManifest f, final PlayerEmsgCallback b, final Allocator a) {
        this.f = f;
        this.b = b;
        this.a = a;
        this.e = new TreeMap<Long, Long>();
        this.d = Util.x((Handler$Callback)this);
        this.c = new EventMessageDecoder();
    }
    
    static EventMessageDecoder a(final PlayerEmsgHandler playerEmsgHandler) {
        return playerEmsgHandler.c;
    }
    
    static boolean b(final String s, final String s2) {
        return h(s, s2);
    }
    
    static long c(final EventMessage eventMessage) {
        return f(eventMessage);
    }
    
    static Handler d(final PlayerEmsgHandler playerEmsgHandler) {
        return playerEmsgHandler.d;
    }
    
    private Map.Entry<Long, Long> e(final long n) {
        return this.e.ceilingEntry(n);
    }
    
    private static long f(final EventMessage eventMessage) {
        try {
            return Util.J0(Util.D(eventMessage.e));
        }
        catch (final ParserException ex) {
            return -9223372036854775807L;
        }
    }
    
    private void g(final long n, final long n2) {
        final Long n3 = this.e.get(n2);
        if (n3 == null) {
            this.e.put(n2, n);
        }
        else if (n3 > n) {
            this.e.put(n2, n);
        }
    }
    
    private static boolean h(final String s, final String s2) {
        return "urn:mpeg:dash:event:2012".equals(s) && ("1".equals(s2) || "2".equals(s2) || "3".equals(s2));
    }
    
    private void i() {
        if (!this.h) {
            return;
        }
        this.i = true;
        this.h = false;
        this.b.b();
    }
    
    private void l() {
        this.b.a(this.g);
    }
    
    private void p() {
        final Iterator<Map.Entry<Long, Long>> iterator = this.e.entrySet().iterator();
        while (iterator.hasNext()) {
            if (((Map.Entry<Long, V>)iterator.next()).getKey() < this.f.h) {
                iterator.remove();
            }
        }
    }
    
    public boolean handleMessage(final Message message) {
        if (this.j) {
            return true;
        }
        if (message.what != 1) {
            return false;
        }
        final a a = (a)message.obj;
        this.g(a.a, a.b);
        return true;
    }
    
    boolean j(final long n) {
        final DashManifest f = this.f;
        final boolean d = f.d;
        final boolean b = false;
        if (!d) {
            return false;
        }
        if (this.i) {
            return true;
        }
        final Map.Entry<Long, Long> e = this.e(f.h);
        boolean b2 = b;
        if (e != null) {
            b2 = b;
            if (e.getValue() < n) {
                this.g = e.getKey();
                this.l();
                b2 = true;
            }
        }
        if (b2) {
            this.i();
        }
        return b2;
    }
    
    public PlayerTrackEmsgHandler k() {
        return new PlayerTrackEmsgHandler(this.a);
    }
    
    void m(final Chunk chunk) {
        this.h = true;
    }
    
    boolean n(final boolean b) {
        if (!this.f.d) {
            return false;
        }
        if (this.i) {
            return true;
        }
        if (b) {
            this.i();
            return true;
        }
        return false;
    }
    
    public void o() {
        this.j = true;
        this.d.removeCallbacksAndMessages((Object)null);
    }
    
    public void q(final DashManifest f) {
        this.i = false;
        this.g = -9223372036854775807L;
        this.f = f;
        this.p();
    }
    
    public interface PlayerEmsgCallback
    {
        void a(final long p0);
        
        void b();
    }
    
    public final class PlayerTrackEmsgHandler implements TrackOutput
    {
        private final SampleQueue a;
        private final FormatHolder b;
        private final MetadataInputBuffer c;
        private long d;
        final PlayerEmsgHandler e;
        
        PlayerTrackEmsgHandler(final PlayerEmsgHandler e, final Allocator allocator) {
            this.e = e;
            this.a = SampleQueue.l(allocator);
            this.b = new FormatHolder();
            this.c = new MetadataInputBuffer();
            this.d = -9223372036854775807L;
        }
        
        private MetadataInputBuffer g() {
            this.c.h();
            if (this.a.S(this.b, this.c, 0, false) == -4) {
                this.c.t();
                return this.c;
            }
            return null;
        }
        
        private void k(final long n, final long n2) {
            PlayerEmsgHandler.d(this.e).sendMessage(PlayerEmsgHandler.d(this.e).obtainMessage(1, (Object)new a(n, n2)));
        }
        
        private void l() {
            while (this.a.K(false)) {
                final MetadataInputBuffer g = this.g();
                if (g == null) {
                    continue;
                }
                final long f = g.f;
                final Metadata a = PlayerEmsgHandler.a(this.e).a(g);
                if (a == null) {
                    continue;
                }
                final EventMessage eventMessage = (EventMessage)a.c(0);
                if (!PlayerEmsgHandler.b(eventMessage.a, eventMessage.b)) {
                    continue;
                }
                this.m(f, eventMessage);
            }
            this.a.s();
        }
        
        private void m(final long n, final EventMessage eventMessage) {
            final long c = PlayerEmsgHandler.c(eventMessage);
            if (c == -9223372036854775807L) {
                return;
            }
            this.k(n, c);
        }
        
        @Override
        public int a(final DataReader dataReader, final int n, final boolean b, final int n2) throws IOException {
            return this.a.b(dataReader, n, b);
        }
        
        @Override
        public void d(final Format format) {
            this.a.d(format);
        }
        
        @Override
        public void e(final long n, final int n2, final int n3, final int n4, final CryptoData cryptoData) {
            this.a.e(n, n2, n3, n4, cryptoData);
            this.l();
        }
        
        @Override
        public void f(final ParsableByteArray parsableByteArray, final int n, final int n2) {
            this.a.c(parsableByteArray, n);
        }
        
        public boolean h(final long n) {
            return this.e.j(n);
        }
        
        public void i(final Chunk chunk) {
            final long d = this.d;
            if (d == -9223372036854775807L || chunk.h > d) {
                this.d = chunk.h;
            }
            this.e.m(chunk);
        }
        
        public boolean j(final Chunk chunk) {
            final long d = this.d;
            return this.e.n(d != -9223372036854775807L && d < chunk.g);
        }
        
        public void n() {
            this.a.T();
        }
    }
    
    private static final class a
    {
        public final long a;
        public final long b;
        
        public a(final long a, final long b) {
            this.a = a;
            this.b = b;
        }
    }
}
