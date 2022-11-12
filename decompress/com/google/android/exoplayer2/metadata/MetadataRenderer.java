// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.metadata;

import android.os.Message;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.FormatHolder;
import java.util.ArrayList;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.Format;
import java.nio.ByteBuffer;
import java.util.List;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.Assertions;
import android.os.Looper;
import android.os.Handler;
import android.os.Handler$Callback;
import com.google.android.exoplayer2.BaseRenderer;

public final class MetadataRenderer extends BaseRenderer implements Handler$Callback
{
    private final Handler A;
    private final MetadataInputBuffer B;
    private MetadataDecoder C;
    private boolean D;
    private boolean E;
    private long F;
    private long G;
    private Metadata H;
    private final MetadataDecoderFactory y;
    private final MetadataOutput z;
    
    public MetadataRenderer(final MetadataOutput metadataOutput, final Looper looper) {
        this(metadataOutput, looper, MetadataDecoderFactory.a);
    }
    
    public MetadataRenderer(final MetadataOutput metadataOutput, final Looper looper, final MetadataDecoderFactory metadataDecoderFactory) {
        super(5);
        this.z = Assertions.e(metadataOutput);
        Handler v;
        if (looper == null) {
            v = null;
        }
        else {
            v = Util.v(looper, (Handler$Callback)this);
        }
        this.A = v;
        this.y = Assertions.e(metadataDecoderFactory);
        this.B = new MetadataInputBuffer();
        this.G = -9223372036854775807L;
    }
    
    private void X(final Metadata metadata, final List<Metadata.Entry> list) {
        for (int i = 0; i < metadata.d(); ++i) {
            final Format m = metadata.c(i).M();
            if (m != null && this.y.a(m)) {
                final MetadataDecoder b = this.y.b(m);
                final byte[] array = Assertions.e(metadata.c(i).C1());
                this.B.h();
                this.B.s(array.length);
                Util.j(this.B.d).put(array);
                this.B.t();
                final Metadata a = b.a(this.B);
                if (a != null) {
                    this.X(a, list);
                }
            }
            else {
                list.add(metadata.c(i));
            }
        }
    }
    
    private void Y(final Metadata metadata) {
        final Handler a = this.A;
        if (a != null) {
            a.obtainMessage(0, (Object)metadata).sendToTarget();
        }
        else {
            this.Z(metadata);
        }
    }
    
    private void Z(final Metadata metadata) {
        this.z.onMetadata(metadata);
    }
    
    private boolean a0(final long n) {
        final Metadata h = this.H;
        boolean b;
        if (h != null && this.G <= n) {
            this.Y(h);
            this.H = null;
            this.G = -9223372036854775807L;
            b = true;
        }
        else {
            b = false;
        }
        if (this.D && this.H == null) {
            this.E = true;
        }
        return b;
    }
    
    private void b0() {
        if (!this.D && this.H == null) {
            this.B.h();
            final FormatHolder i = this.I();
            final int u = this.U(i, this.B, 0);
            if (u == -4) {
                if (this.B.n()) {
                    this.D = true;
                }
                else {
                    final MetadataInputBuffer b = this.B;
                    b.j = this.F;
                    b.t();
                    final Metadata a = Util.j(this.C).a(this.B);
                    if (a != null) {
                        final ArrayList list = new ArrayList<Metadata.Entry>(a.d());
                        this.X(a, (List<Metadata.Entry>)list);
                        if (!list.isEmpty()) {
                            this.H = new Metadata((List<? extends Metadata.Entry>)list);
                            this.G = this.B.f;
                        }
                    }
                }
            }
            else if (u == -5) {
                this.F = Assertions.e(i.b).A;
            }
        }
    }
    
    public void A(final long n, final long n2) {
        for (boolean a0 = true; a0; a0 = this.a0(n)) {
            this.b0();
        }
    }
    
    @Override
    protected void N() {
        this.H = null;
        this.G = -9223372036854775807L;
        this.C = null;
    }
    
    @Override
    protected void P(final long n, final boolean b) {
        this.H = null;
        this.G = -9223372036854775807L;
        this.D = false;
        this.E = false;
    }
    
    @Override
    protected void T(final Format[] array, final long n, final long n2) {
        this.C = this.y.b(array[0]);
    }
    
    public int a(final Format format) {
        if (this.y.a(format)) {
            int n;
            if (format.P == 0) {
                n = 4;
            }
            else {
                n = 2;
            }
            return RendererCapabilities.o(n);
        }
        return RendererCapabilities.o(0);
    }
    
    public boolean c() {
        return this.E;
    }
    
    public String getName() {
        return "MetadataRenderer";
    }
    
    public boolean handleMessage(final Message message) {
        if (message.what == 0) {
            this.Z((Metadata)message.obj);
            return true;
        }
        throw new IllegalStateException();
    }
    
    public boolean isReady() {
        return true;
    }
}
