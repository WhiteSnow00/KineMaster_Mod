// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.text;

import com.google.android.exoplayer2.decoder.Decoder;
import android.os.Message;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import java.util.List;
import com.google.android.exoplayer2.util.Log;
import java.util.Collections;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.Assertions;
import android.os.Looper;
import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import android.os.Handler$Callback;
import com.google.android.exoplayer2.BaseRenderer;

public final class TextRenderer extends BaseRenderer implements Handler$Callback
{
    private final SubtitleDecoderFactory A;
    private final FormatHolder B;
    private boolean C;
    private boolean D;
    private boolean E;
    private int F;
    private Format G;
    private SubtitleDecoder H;
    private SubtitleInputBuffer I;
    private SubtitleOutputBuffer J;
    private SubtitleOutputBuffer K;
    private int L;
    private long M;
    private final Handler y;
    private final TextOutput z;
    
    public TextRenderer(final TextOutput textOutput, final Looper looper) {
        this(textOutput, looper, SubtitleDecoderFactory.a);
    }
    
    public TextRenderer(final TextOutput textOutput, final Looper looper, final SubtitleDecoderFactory a) {
        super(3);
        this.z = Assertions.e(textOutput);
        Handler v;
        if (looper == null) {
            v = null;
        }
        else {
            v = Util.v(looper, (Handler$Callback)this);
        }
        this.y = v;
        this.A = a;
        this.B = new FormatHolder();
        this.M = -9223372036854775807L;
    }
    
    private void X() {
        this.g0(Collections.emptyList());
    }
    
    private long Y() {
        final int l = this.L;
        long d = Long.MAX_VALUE;
        if (l == -1) {
            return Long.MAX_VALUE;
        }
        Assertions.e(this.J);
        if (this.L < this.J.f()) {
            d = this.J.d(this.L);
        }
        return d;
    }
    
    private void Z(final SubtitleDecoderException ex) {
        final StringBuilder sb = new StringBuilder();
        sb.append("Subtitle decoding failed. streamFormat=");
        sb.append(this.G);
        Log.d("TextRenderer", sb.toString(), ex);
        this.X();
        this.e0();
    }
    
    private void a0() {
        this.E = true;
        this.H = this.A.b(Assertions.e(this.G));
    }
    
    private void b0(final List<Cue> list) {
        this.z.onCues(list);
        this.z.onCues(new CueGroup(list));
    }
    
    private void c0() {
        this.I = null;
        this.L = -1;
        final SubtitleOutputBuffer j = this.J;
        if (j != null) {
            j.r();
            this.J = null;
        }
        final SubtitleOutputBuffer k = this.K;
        if (k != null) {
            k.r();
            this.K = null;
        }
    }
    
    private void d0() {
        this.c0();
        Assertions.e(this.H).release();
        this.H = null;
        this.F = 0;
    }
    
    private void e0() {
        this.d0();
        this.a0();
    }
    
    private void g0(final List<Cue> list) {
        final Handler y = this.y;
        if (y != null) {
            y.obtainMessage(0, (Object)list).sendToTarget();
        }
        else {
            this.b0(list);
        }
    }
    
    public void A(final long n, long n2) {
        if (this.r()) {
            n2 = this.M;
            if (n2 != -9223372036854775807L && n >= n2) {
                this.c0();
                this.D = true;
            }
        }
        if (this.D) {
            return;
        }
        if (this.K == null) {
            Assertions.e(this.H).a(n);
            try {
                this.K = ((Decoder<I, SubtitleOutputBuffer, E>)Assertions.e(this.H)).b();
            }
            catch (final SubtitleDecoderException ex) {
                this.Z(ex);
                return;
            }
        }
        if (this.getState() != 2) {
            return;
        }
        int n3;
        if (this.J != null) {
            n2 = this.Y();
            n3 = 0;
            while (n2 <= n) {
                ++this.L;
                n2 = this.Y();
                n3 = 1;
            }
        }
        else {
            n3 = 0;
        }
        final SubtitleOutputBuffer k = this.K;
        int n4 = n3;
        if (k != null) {
            if (k.n()) {
                n4 = n3;
                if (n3 == 0) {
                    n4 = n3;
                    if (this.Y() == Long.MAX_VALUE) {
                        if (this.F == 2) {
                            this.e0();
                            n4 = n3;
                        }
                        else {
                            this.c0();
                            this.D = true;
                            n4 = n3;
                        }
                    }
                }
            }
            else {
                n4 = n3;
                if (k.b <= n) {
                    final SubtitleOutputBuffer j = this.J;
                    if (j != null) {
                        j.r();
                    }
                    this.L = k.a(n);
                    this.J = k;
                    this.K = null;
                    n4 = 1;
                }
            }
        }
        if (n4 != 0) {
            Assertions.e(this.J);
            this.g0(this.J.c(n));
        }
        if (this.F == 2) {
            return;
        }
        try {
            SubtitleInputBuffer i = null;
            Block_25: {
                while (!this.C) {
                    if ((i = this.I) == null) {
                        i = ((Decoder<SubtitleInputBuffer, O, E>)Assertions.e(this.H)).d();
                        if (i == null) {
                            return;
                        }
                        this.I = i;
                    }
                    if (this.F == 1) {
                        break Block_25;
                    }
                    final int u = this.U(this.B, i, 0);
                    if (u == -4) {
                        if (i.n()) {
                            this.C = true;
                            this.E = false;
                        }
                        else {
                            final Format b = this.B.b;
                            if (b == null) {
                                return;
                            }
                            i.j = b.A;
                            i.t();
                            this.E &= !i.p();
                        }
                        if (this.E) {
                            continue;
                        }
                        ((Decoder<SubtitleInputBuffer, O, E>)Assertions.e(this.H)).c(i);
                        this.I = null;
                    }
                    else {
                        if (u == -3) {
                            return;
                        }
                        continue;
                    }
                }
                return;
            }
            i.q(4);
            ((Decoder<SubtitleInputBuffer, O, E>)Assertions.e(this.H)).c(i);
            this.I = null;
            this.F = 2;
        }
        catch (final SubtitleDecoderException ex2) {
            this.Z(ex2);
        }
    }
    
    @Override
    protected void N() {
        this.G = null;
        this.M = -9223372036854775807L;
        this.X();
        this.d0();
    }
    
    @Override
    protected void P(final long n, final boolean b) {
        this.X();
        this.C = false;
        this.D = false;
        this.M = -9223372036854775807L;
        if (this.F != 0) {
            this.e0();
        }
        else {
            this.c0();
            Assertions.e(this.H).flush();
        }
    }
    
    @Override
    protected void T(final Format[] array, final long n, final long n2) {
        this.G = array[0];
        if (this.H != null) {
            this.F = 1;
        }
        else {
            this.a0();
        }
    }
    
    public int a(final Format format) {
        if (this.A.a(format)) {
            int n;
            if (format.P == 0) {
                n = 4;
            }
            else {
                n = 2;
            }
            return RendererCapabilities.o(n);
        }
        if (MimeTypes.r(format.w)) {
            return RendererCapabilities.o(1);
        }
        return RendererCapabilities.o(0);
    }
    
    public boolean c() {
        return this.D;
    }
    
    public void f0(final long m) {
        Assertions.g(this.r());
        this.M = m;
    }
    
    public String getName() {
        return "TextRenderer";
    }
    
    public boolean handleMessage(final Message message) {
        if (message.what == 0) {
            this.b0((List<Cue>)message.obj);
            return true;
        }
        throw new IllegalStateException();
    }
    
    public boolean isReady() {
        return true;
    }
}
