// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.mediacodec;

import android.media.metrics.LogSessionId;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import android.media.MediaCryptoException;
import android.os.Bundle;
import com.google.android.exoplayer2.util.NalUnitUtil;
import android.media.MediaCodec$CryptoException;
import java.util.UUID;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.FormatHolder;
import java.util.List;
import com.google.android.exoplayer2.util.Log;
import java.util.Collection;
import android.media.MediaCodec$CodecException;
import com.google.android.exoplayer2.util.TraceUtil;
import android.os.SystemClock;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.decoder.CryptoConfig;
import com.google.android.exoplayer2.drm.FrameworkCryptoConfig;
import java.nio.ByteOrder;
import com.google.android.exoplayer2.util.Assertions;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import android.media.MediaFormat;
import android.media.MediaCrypto;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.ExoPlaybackException;
import android.media.MediaCodec$BufferInfo;
import java.util.ArrayList;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.TimedValueQueue;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.BaseRenderer;

public abstract class MediaCodecRenderer extends BaseRenderer
{
    private static final byte[] Q0;
    private final boolean A;
    private int A0;
    private final float B;
    private int B0;
    private final DecoderInputBuffer C;
    private boolean C0;
    private final DecoderInputBuffer D;
    private boolean D0;
    private final DecoderInputBuffer E;
    private boolean E0;
    private final g F;
    private long F0;
    private final TimedValueQueue<Format> G;
    private long G0;
    private final ArrayList<Long> H;
    private boolean H0;
    private final MediaCodec$BufferInfo I;
    private boolean I0;
    private final long[] J;
    private boolean J0;
    private final long[] K;
    private boolean K0;
    private final long[] L;
    private ExoPlaybackException L0;
    private Format M;
    protected DecoderCounters M0;
    private Format N;
    private long N0;
    private DrmSession O;
    private long O0;
    private DrmSession P;
    private int P0;
    private MediaCrypto Q;
    private boolean R;
    private long S;
    private float T;
    private float U;
    private MediaCodecAdapter V;
    private Format W;
    private MediaFormat X;
    private boolean Y;
    private float Z;
    private ArrayDeque<MediaCodecInfo> a0;
    private DecoderInitializationException b0;
    private MediaCodecInfo c0;
    private int d0;
    private boolean e0;
    private boolean f0;
    private boolean g0;
    private boolean h0;
    private boolean i0;
    private boolean j0;
    private boolean k0;
    private boolean l0;
    private boolean m0;
    private boolean n0;
    private h o0;
    private long p0;
    private int q0;
    private int r0;
    private ByteBuffer s0;
    private boolean t0;
    private boolean u0;
    private boolean v0;
    private boolean w0;
    private boolean x0;
    private final MediaCodecAdapter.Factory y;
    private boolean y0;
    private final MediaCodecSelector z;
    private int z0;
    
    static {
        Q0 = new byte[] { 0, 0, 1, 103, 66, -64, 11, -38, 37, -112, 0, 0, 1, 104, -50, 15, 19, 32, 0, 0, 1, 101, -120, -124, 13, -50, 113, 24, -96, 0, 47, -65, 28, 49, -61, 39, 93, 120 };
    }
    
    public MediaCodecRenderer(final int n, final MediaCodecAdapter.Factory y, final MediaCodecSelector mediaCodecSelector, final boolean a, final float b) {
        super(n);
        this.y = y;
        this.z = Assertions.e(mediaCodecSelector);
        this.A = a;
        this.B = b;
        this.C = DecoderInputBuffer.w();
        this.D = new DecoderInputBuffer(0);
        this.E = new DecoderInputBuffer(2);
        final g f = new g();
        this.F = f;
        this.G = new TimedValueQueue<Format>();
        this.H = new ArrayList<Long>();
        this.I = new MediaCodec$BufferInfo();
        this.T = 1.0f;
        this.U = 1.0f;
        this.S = -9223372036854775807L;
        this.J = new long[10];
        this.K = new long[10];
        this.L = new long[10];
        this.N0 = -9223372036854775807L;
        this.O0 = -9223372036854775807L;
        f.s(0);
        f.d.order(ByteOrder.nativeOrder());
        this.Z = -1.0f;
        this.d0 = 0;
        this.z0 = 0;
        this.q0 = -1;
        this.r0 = -1;
        this.p0 = -9223372036854775807L;
        this.F0 = -9223372036854775807L;
        this.G0 = -9223372036854775807L;
        this.A0 = 0;
        this.B0 = 0;
    }
    
    private FrameworkCryptoConfig B0(final DrmSession drmSession) throws ExoPlaybackException {
        final CryptoConfig f = drmSession.f();
        if (f != null && !(f instanceof FrameworkCryptoConfig)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Expecting FrameworkCryptoConfig but found: ");
            sb.append(f);
            throw this.F(new IllegalArgumentException(sb.toString()), this.M, 6001);
        }
        return (FrameworkCryptoConfig)f;
    }
    
    private boolean G0() {
        return this.r0 >= 0;
    }
    
    private void H0(final Format format) {
        this.k0();
        final String w = format.w;
        if (!"audio/mp4a-latm".equals(w) && !"audio/mpeg".equals(w) && !"audio/opus".equals(w)) {
            this.F.G(1);
        }
        else {
            this.F.G(32);
        }
        this.v0 = true;
    }
    
    private void I0(final MediaCodecInfo c0, final MediaCrypto mediaCrypto) throws Exception {
        final String a = c0.a;
        final int a2 = Util.a;
        final float n = -1.0f;
        float y0;
        if (a2 < 23) {
            y0 = -1.0f;
        }
        else {
            y0 = this.y0(this.U, this.M, this.L());
        }
        if (y0 <= this.B) {
            y0 = n;
        }
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        final MediaCodecAdapter.Configuration c2 = this.C0(c0, this.M, mediaCrypto, y0);
        if (a2 >= 31) {
            MediaCodecRenderer.a.a(c2, this.K());
        }
        try {
            final StringBuilder sb = new StringBuilder();
            sb.append("createCodec:");
            sb.append(a);
            TraceUtil.a(sb.toString());
            this.V = this.y.a(c2);
            TraceUtil.c();
            final long elapsedRealtime2 = SystemClock.elapsedRealtime();
            this.c0 = c0;
            this.Z = y0;
            this.W = this.M;
            this.d0 = this.a0(a);
            this.e0 = b0(a, this.W);
            this.f0 = g0(a);
            this.g0 = i0(a);
            this.h0 = d0(a);
            this.i0 = e0(a);
            this.j0 = c0(a);
            this.k0 = h0(a, this.W);
            final boolean f0 = f0(c0);
            final boolean b = false;
            this.n0 = (f0 || this.x0());
            if (this.V.h()) {
                this.y0 = true;
                this.z0 = 1;
                boolean l0 = b;
                if (this.d0 != 0) {
                    l0 = true;
                }
                this.l0 = l0;
            }
            if ("c2.android.mp3.decoder".equals(c0.a)) {
                this.o0 = new h();
            }
            if (this.getState() == 2) {
                this.p0 = SystemClock.elapsedRealtime() + 1000L;
            }
            final DecoderCounters m0 = this.M0;
            ++m0.a;
            this.Q0(a, c2, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
        }
        finally {
            TraceUtil.c();
        }
    }
    
    private boolean J0(final long n) {
        for (int size = this.H.size(), i = 0; i < size; ++i) {
            if (this.H.get(i) == n) {
                this.H.remove(i);
                return true;
            }
        }
        return false;
    }
    
    private static boolean K0(final IllegalStateException ex) {
        final int a = Util.a;
        boolean b = true;
        if (a >= 21 && L0(ex)) {
            return true;
        }
        final StackTraceElement[] stackTrace = ex.getStackTrace();
        if (stackTrace.length <= 0 || !stackTrace[0].getClassName().equals("android.media.MediaCodec")) {
            b = false;
        }
        return b;
    }
    
    private static boolean L0(final IllegalStateException ex) {
        return ex instanceof MediaCodec$CodecException;
    }
    
    private static boolean M0(final IllegalStateException ex) {
        return ex instanceof MediaCodec$CodecException && ((MediaCodec$CodecException)ex).isRecoverable();
    }
    
    private void O0(final MediaCrypto mediaCrypto, final boolean b) throws DecoderInitializationException {
        if (this.a0 == null) {
            try {
                final List<MediaCodecInfo> u0 = this.u0(b);
                final ArrayDeque<Object> a0 = new ArrayDeque<Object>();
                this.a0 = (ArrayDeque<MediaCodecInfo>)a0;
                if (this.A) {
                    a0.addAll(u0);
                }
                else if (!u0.isEmpty()) {
                    this.a0.add((MediaCodecInfo)u0.get(0));
                }
                this.b0 = null;
            }
            catch (final MediaCodecUtil.DecoderQueryException ex) {
                throw new DecoderInitializationException(this.M, ex, b, -49998);
            }
        }
        if (!this.a0.isEmpty()) {
            final MediaCodecInfo mediaCodecInfo = this.a0.peekFirst();
            while (this.V == null) {
                final MediaCodecInfo mediaCodecInfo2 = this.a0.peekFirst();
                if (!this.n1(mediaCodecInfo2)) {
                    return;
                }
                try {
                    this.I0(mediaCodecInfo2, mediaCrypto);
                    continue;
                }
                catch (final Exception ex2) {
                    Label_0192: {
                        if (mediaCodecInfo2 != mediaCodecInfo) {
                            break Label_0192;
                        }
                        try {
                            Log.i("MediaCodecRenderer", "Preferred decoder instantiation failed. Sleeping for 50ms then retrying.");
                            Thread.sleep(50L);
                            this.I0(mediaCodecInfo2, mediaCrypto);
                            continue;
                            throw ex2;
                        }
                        catch (final Exception ex3) {
                            final StringBuilder sb = new StringBuilder();
                            sb.append("Failed to initialize decoder: ");
                            sb.append(mediaCodecInfo2);
                            Log.j("MediaCodecRenderer", sb.toString(), ex3);
                            this.a0.removeFirst();
                            final DecoderInitializationException b2 = new DecoderInitializationException(this.M, ex3, b, mediaCodecInfo2);
                            this.P0(b2);
                            final DecoderInitializationException b3 = this.b0;
                            if (b3 == null) {
                                this.b0 = b2;
                            }
                            else {
                                this.b0 = DecoderInitializationException.access$000(b3, b2);
                            }
                            if (!this.a0.isEmpty()) {
                                continue;
                            }
                            throw this.b0;
                        }
                    }
                }
                break;
            }
            this.a0 = null;
            return;
        }
        throw new DecoderInitializationException(this.M, null, b, -49999);
    }
    
    private void X() throws ExoPlaybackException {
        Assertions.g(this.H0 ^ true);
        final FormatHolder i = this.I();
        this.E.h();
        do {
            this.E.h();
            final int u = this.U(i, this.E, 0);
            if (u == -5) {
                this.S0(i);
                return;
            }
            if (u != -4) {
                if (u == -3) {
                    return;
                }
                throw new IllegalStateException();
            }
            else {
                if (this.E.n()) {
                    this.H0 = true;
                    return;
                }
                if (this.J0) {
                    this.T0(this.N = Assertions.e(this.M), null);
                    this.J0 = false;
                }
                this.E.t();
            }
        } while (this.F.y(this.E));
        this.w0 = true;
    }
    
    private void X0() throws ExoPlaybackException {
        final int b0 = this.B0;
        if (b0 != 1) {
            if (b0 != 2) {
                if (b0 != 3) {
                    this.I0 = true;
                    this.d1();
                }
                else {
                    this.b1();
                }
            }
            else {
                this.r0();
                this.t1();
            }
        }
        else {
            this.r0();
        }
    }
    
    private boolean Y(final long n, final long n2) throws ExoPlaybackException {
        Assertions.g(this.I0 ^ true);
        if (this.F.E()) {
            final g f = this.F;
            if (!this.Y0(n, n2, null, f.d, this.r0, 0, f.C(), this.F.A(), this.F.m(), this.F.n(), this.N)) {
                return false;
            }
            this.U0(this.F.B());
            this.F.h();
        }
        if (this.H0) {
            this.I0 = true;
            return false;
        }
        if (this.w0) {
            Assertions.g(this.F.y(this.E));
            this.w0 = false;
        }
        if (this.x0) {
            if (this.F.E()) {
                return true;
            }
            this.k0();
            this.x0 = false;
            this.N0();
            if (!this.v0) {
                return false;
            }
        }
        this.X();
        if (this.F.E()) {
            this.F.t();
        }
        return this.F.E() || this.H0 || this.x0;
    }
    
    private void Z0() {
        this.E0 = true;
        final MediaFormat b = this.V.b();
        if (this.d0 != 0 && b.getInteger("width") == 32 && b.getInteger("height") == 32) {
            this.m0 = true;
            return;
        }
        if (this.k0) {
            b.setInteger("channel-count", 1);
        }
        this.X = b;
        this.Y = true;
    }
    
    private int a0(String b) {
        final int a = Util.a;
        if (a <= 25 && "OMX.Exynos.avc.dec.secure".equals(b)) {
            final String d = Util.d;
            if (d.startsWith("SM-T585") || d.startsWith("SM-A510") || d.startsWith("SM-A520") || d.startsWith("SM-J700")) {
                return 2;
            }
        }
        if (a < 24 && ("OMX.Nvidia.h264.decode".equals(b) || "OMX.Nvidia.h264.decode.secure".equals(b))) {
            b = Util.b;
            if ("flounder".equals(b) || "flounder_lte".equals(b) || "grouper".equals(b) || "tilapia".equals(b)) {
                return 1;
            }
        }
        return 0;
    }
    
    private boolean a1(int u) throws ExoPlaybackException {
        final FormatHolder i = this.I();
        this.C.h();
        u = this.U(i, this.C, u | 0x4);
        if (u == -5) {
            this.S0(i);
            return true;
        }
        if (u == -4 && this.C.n()) {
            this.H0 = true;
            this.X0();
        }
        return false;
    }
    
    private static boolean b0(final String s, final Format format) {
        return Util.a < 21 && format.y.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(s);
    }
    
    private void b1() throws ExoPlaybackException {
        this.c1();
        this.N0();
    }
    
    private static boolean c0(String b) {
        if (Util.a < 21 && "OMX.SEC.mp3.dec".equals(b) && "samsung".equals(Util.c)) {
            b = Util.b;
            if (b.startsWith("baffin") || b.startsWith("grand") || b.startsWith("fortuna") || b.startsWith("gprimelte") || b.startsWith("j2y18lte") || b.startsWith("ms01")) {
                return true;
            }
        }
        return false;
    }
    
    private static boolean d0(final String s) {
        final int a = Util.a;
        if (a > 23 || !"OMX.google.vorbis.decoder".equals(s)) {
            if (a <= 19) {
                final String b = Util.b;
                if (("hb2000".equals(b) || "stvm8".equals(b)) && ("OMX.amlogic.avc.decoder.awesome".equals(s) || "OMX.amlogic.avc.decoder.awesome.secure".equals(s))) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    private static boolean e0(final String s) {
        return Util.a == 21 && "OMX.google.aac.decoder".equals(s);
    }
    
    private static boolean f0(final MediaCodecInfo mediaCodecInfo) {
        final String a = mediaCodecInfo.a;
        final int a2 = Util.a;
        return (a2 <= 25 && "OMX.rk.video_decoder.avc".equals(a)) || (a2 <= 17 && "OMX.allwinner.video.decoder.avc".equals(a)) || (a2 <= 29 && ("OMX.broadcom.video_decoder.tunnel".equals(a) || "OMX.broadcom.video_decoder.tunnel.secure".equals(a))) || ("Amazon".equals(Util.c) && "AFTS".equals(Util.d) && mediaCodecInfo.g);
    }
    
    private static boolean g0(final String s) {
        final int a = Util.a;
        if (a >= 18 && (a != 18 || (!"OMX.SEC.avc.dec".equals(s) && !"OMX.SEC.avc.dec.secure".equals(s)))) {
            if (a == 19 && Util.d.startsWith("SM-G800")) {
                if ("OMX.Exynos.avc.dec".equals(s)) {
                    return true;
                }
                if ("OMX.Exynos.avc.dec.secure".equals(s)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    private void g1() {
        this.q0 = -1;
        this.D.d = null;
    }
    
    private static boolean h0(final String s, final Format format) {
        final int a = Util.a;
        boolean b = true;
        if (a > 18 || format.J != 1 || !"OMX.MTK.AUDIO.DECODER.MP3".equals(s)) {
            b = false;
        }
        return b;
    }
    
    private void h1() {
        this.r0 = -1;
        this.s0 = null;
    }
    
    private static boolean i0(final String s) {
        return Util.a == 29 && "c2.android.aac.decoder".equals(s);
    }
    
    private void i1(final DrmSession o) {
        DrmSession.g(this.O, o);
        this.O = o;
    }
    
    private void k0() {
        this.x0 = false;
        this.F.h();
        this.E.h();
        this.w0 = false;
        this.v0 = false;
    }
    
    private boolean l0() {
        if (this.C0) {
            this.A0 = 1;
            if (this.f0 || this.h0) {
                this.B0 = 3;
                return false;
            }
            this.B0 = 1;
        }
        return true;
    }
    
    private void l1(final DrmSession p) {
        DrmSession.g(this.P, p);
        this.P = p;
    }
    
    private void m0() throws ExoPlaybackException {
        if (this.C0) {
            this.A0 = 1;
            this.B0 = 3;
        }
        else {
            this.b1();
        }
    }
    
    private boolean m1(final long n) {
        return this.S == -9223372036854775807L || SystemClock.elapsedRealtime() - n < this.S;
    }
    
    private boolean n0() throws ExoPlaybackException {
        if (this.C0) {
            this.A0 = 1;
            if (this.f0 || this.h0) {
                this.B0 = 3;
                return false;
            }
            this.B0 = 2;
        }
        else {
            this.t1();
        }
        return true;
    }
    
    private boolean o0(final long n, final long n2) throws ExoPlaybackException {
        if (!this.G0()) {
            int r0 = 0;
            Label_0073: {
                if (this.i0 && this.D0) {
                    try {
                        r0 = this.V.l(this.I);
                        break Label_0073;
                    }
                    catch (final IllegalStateException ex) {
                        this.X0();
                        if (this.I0) {
                            this.c1();
                        }
                        return false;
                    }
                }
                r0 = this.V.l(this.I);
            }
            if (r0 < 0) {
                if (r0 == -2) {
                    this.Z0();
                    return true;
                }
                if (this.n0 && (this.H0 || this.A0 == 2)) {
                    this.X0();
                }
                return false;
            }
            else {
                if (this.m0) {
                    this.m0 = false;
                    this.V.m(r0, false);
                    return true;
                }
                final MediaCodec$BufferInfo i = this.I;
                if (i.size == 0 && (i.flags & 0x4) != 0x0) {
                    this.X0();
                    return false;
                }
                this.r0 = r0;
                final ByteBuffer n3 = this.V.n(r0);
                if ((this.s0 = n3) != null) {
                    n3.position(this.I.offset);
                    final ByteBuffer s0 = this.s0;
                    final MediaCodec$BufferInfo j = this.I;
                    s0.limit(j.offset + j.size);
                }
                if (this.j0) {
                    final MediaCodec$BufferInfo k = this.I;
                    if (k.presentationTimeUs == 0L && (k.flags & 0x4) != 0x0) {
                        final long f0 = this.F0;
                        if (f0 != -9223372036854775807L) {
                            k.presentationTimeUs = f0;
                        }
                    }
                }
                this.t0 = this.J0(this.I.presentationTimeUs);
                final long g0 = this.G0;
                final long presentationTimeUs = this.I.presentationTimeUs;
                this.u0 = (g0 == presentationTimeUs);
                this.u1(presentationTimeUs);
            }
        }
        Label_0478: {
            if (!this.i0 || !this.D0) {
                break Label_0478;
            }
        Label_0461_Outer:
            while (true) {
                MediaCodecAdapter v = null;
                ByteBuffer s2 = null;
                int r2 = 0;
                int flags = 0;
                long presentationTimeUs2 = 0L;
                boolean t0 = false;
                boolean u0 = false;
                Format n4 = null;
                try {
                    v = this.V;
                    s2 = this.s0;
                    r2 = this.r0;
                    final MediaCodec$BufferInfo l = this.I;
                    flags = l.flags;
                    presentationTimeUs2 = l.presentationTimeUs;
                    t0 = this.t0;
                    u0 = this.u0;
                    n4 = this.N;
                    final MediaCodecRenderer mediaCodecRenderer = this;
                    final long n5 = n;
                    final long n6 = n2;
                    final MediaCodecAdapter mediaCodecAdapter = v;
                    final ByteBuffer byteBuffer = s2;
                    final int n7 = r2;
                    final int n8 = flags;
                    final int n9 = 1;
                    final long n10 = presentationTimeUs2;
                    final boolean b = t0;
                    final boolean b2 = u0;
                    final Format format = n4;
                    final boolean b3 = mediaCodecRenderer.Y0(n5, n6, mediaCodecAdapter, byteBuffer, n7, n8, n9, n10, b, b2, format);
                    break Label_0539;
                }
                catch (final IllegalStateException ex2) {}
                while (true) {
                    try {
                        final MediaCodecRenderer mediaCodecRenderer = this;
                        final long n5 = n;
                        final long n6 = n2;
                        final MediaCodecAdapter mediaCodecAdapter = v;
                        final ByteBuffer byteBuffer = s2;
                        final int n7 = r2;
                        final int n8 = flags;
                        final int n9 = 1;
                        final long n10 = presentationTimeUs2;
                        final boolean b = t0;
                        final boolean b2 = u0;
                        final Format format = n4;
                        boolean b3 = mediaCodecRenderer.Y0(n5, n6, mediaCodecAdapter, byteBuffer, n7, n8, n9, n10, b, b2, format);
                        if (b3) {
                            this.U0(this.I.presentationTimeUs);
                            final boolean b4 = (this.I.flags & 0x4) != 0x0;
                            this.h1();
                            if (!b4) {
                                return true;
                            }
                            this.X0();
                        }
                        return false;
                        this.X0();
                        iftrue(Label_0476:)(!this.I0);
                        this.c1();
                        return false;
                        final MediaCodecAdapter v2 = this.V;
                        final ByteBuffer s3 = this.s0;
                        final int r3 = this.r0;
                        final MediaCodec$BufferInfo m = this.I;
                        b3 = this.Y0(n, n2, v2, s3, r3, m.flags, 1, m.presentationTimeUs, this.t0, this.u0, this.N);
                        continue Label_0461_Outer;
                        Label_0476: {
                            return false;
                        }
                    }
                    catch (final IllegalStateException ex3) {
                        continue;
                    }
                    break;
                }
                break;
            }
        }
    }
    
    private boolean p0(final MediaCodecInfo mediaCodecInfo, final Format format, final DrmSession drmSession, final DrmSession drmSession2) throws ExoPlaybackException {
        if (drmSession == drmSession2) {
            return false;
        }
        if (drmSession2 != null) {
            if (drmSession != null) {
                if (Util.a < 23) {
                    return true;
                }
                final UUID e = com.google.android.exoplayer2.C.e;
                if (!e.equals(drmSession.d())) {
                    if (!e.equals(drmSession2.d())) {
                        final FrameworkCryptoConfig b0 = this.B0(drmSession2);
                        if (b0 == null) {
                            return true;
                        }
                        final boolean b2 = !b0.c && drmSession2.i(format.w);
                        return !mediaCodecInfo.g && b2;
                    }
                }
            }
        }
        return true;
    }
    
    private boolean q0() throws ExoPlaybackException {
        if (this.V != null) {
            final int a0 = this.A0;
            if (a0 != 2) {
                if (!this.H0) {
                    if (a0 == 0 && this.o1()) {
                        this.m0();
                    }
                    if (this.q0 < 0) {
                        final int k = this.V.k();
                        if ((this.q0 = k) < 0) {
                            return false;
                        }
                        this.D.d = this.V.e(k);
                        this.D.h();
                    }
                    if (this.A0 == 1) {
                        if (!this.n0) {
                            this.D0 = true;
                            this.V.g(this.q0, 0, 0, 0L, 4);
                            this.g1();
                        }
                        this.A0 = 2;
                        return false;
                    }
                    if (this.l0) {
                        this.l0 = false;
                        final ByteBuffer d = this.D.d;
                        final byte[] q0 = MediaCodecRenderer.Q0;
                        d.put(q0);
                        this.V.g(this.q0, 0, q0.length, 0L, 0);
                        this.g1();
                        return this.C0 = true;
                    }
                    if (this.z0 == 1) {
                        for (int i = 0; i < this.W.y.size(); ++i) {
                            this.D.d.put(this.W.y.get(i));
                        }
                        this.z0 = 2;
                    }
                    final int position = this.D.d.position();
                    final FormatHolder j = this.I();
                    try {
                        final int u = this.U(j, this.D, 0);
                        if (this.h()) {
                            this.G0 = this.F0;
                        }
                        if (u == -3) {
                            return false;
                        }
                        if (u == -5) {
                            if (this.z0 == 2) {
                                this.D.h();
                                this.z0 = 1;
                            }
                            this.S0(j);
                            return true;
                        }
                        if (this.D.n()) {
                            if (this.z0 == 2) {
                                this.D.h();
                                this.z0 = 1;
                            }
                            this.H0 = true;
                            if (!this.C0) {
                                this.X0();
                                return false;
                            }
                            try {
                                if (!this.n0) {
                                    this.D0 = true;
                                    this.V.g(this.q0, 0, 0, 0L, 4);
                                    this.g1();
                                }
                                return false;
                            }
                            catch (final MediaCodec$CryptoException ex) {
                                throw this.F((Throwable)ex, this.M, Util.V(ex.getErrorCode()));
                            }
                        }
                        if (!this.C0 && !this.D.p()) {
                            this.D.h();
                            if (this.z0 == 2) {
                                this.z0 = 1;
                            }
                            return true;
                        }
                        final boolean u2 = this.D.u();
                        if (u2) {
                            this.D.c.b(position);
                        }
                        if (this.e0 && !u2) {
                            NalUnitUtil.b(this.D.d);
                            if (this.D.d.position() == 0) {
                                return true;
                            }
                            this.e0 = false;
                        }
                        final DecoderInputBuffer d2 = this.D;
                        long n = d2.f;
                        final h o0 = this.o0;
                        if (o0 != null) {
                            n = o0.d(this.M, d2);
                            this.F0 = Math.max(this.F0, this.o0.b(this.M));
                        }
                        if (this.D.m()) {
                            this.H.add(n);
                        }
                        if (this.J0) {
                            this.G.a(n, this.M);
                            this.J0 = false;
                        }
                        this.F0 = Math.max(this.F0, n);
                        this.D.t();
                        if (this.D.l()) {
                            this.F0(this.D);
                        }
                        this.W0(this.D);
                        Label_0756: {
                            if (!u2) {
                                break Label_0756;
                            }
                            try {
                                this.V.a(this.q0, 0, this.D.c, n, 0);
                                this.g1();
                                this.C0 = true;
                                this.z0 = 0;
                                final DecoderCounters m0 = this.M0;
                                ++m0.c;
                                return true;
                                this.V.g(this.q0, 0, this.D.d.limit(), n, 0);
                            }
                            catch (final MediaCodec$CryptoException ex2) {
                                throw this.F((Throwable)ex2, this.M, Util.V(ex2.getErrorCode()));
                            }
                        }
                    }
                    catch (final DecoderInputBuffer.InsufficientCapacityException ex3) {
                        this.P0(ex3);
                        this.a1(0);
                        this.r0();
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private void r0() {
        try {
            this.V.flush();
        }
        finally {
            this.e1();
        }
    }
    
    protected static boolean r1(final Format format) {
        final int p = format.P;
        return p == 0 || p == 2;
    }
    
    private boolean s1(final Format format) throws ExoPlaybackException {
        if (Util.a < 23) {
            return true;
        }
        if (this.V != null && this.B0 != 3) {
            if (this.getState() != 0) {
                final float y0 = this.y0(this.U, format, this.L());
                final float z = this.Z;
                if (z == y0) {
                    return true;
                }
                if (y0 == -1.0f) {
                    this.m0();
                    return false;
                }
                if (z == -1.0f && y0 <= this.B) {
                    return true;
                }
                final Bundle bundle = new Bundle();
                bundle.putFloat("operating-rate", y0);
                this.V.i(bundle);
                this.Z = y0;
            }
        }
        return true;
    }
    
    private void t1() throws ExoPlaybackException {
        try {
            this.Q.setMediaDrmSession(this.B0(this.P).b);
            this.i1(this.P);
            this.A0 = 0;
            this.B0 = 0;
        }
        catch (final MediaCryptoException ex) {
            throw this.F((Throwable)ex, this.M, 6006);
        }
    }
    
    private List<MediaCodecInfo> u0(final boolean b) throws MediaCodecUtil.DecoderQueryException {
        List<MediaCodecInfo> list2;
        final List<MediaCodecInfo> list = list2 = this.A0(this.z, this.M, b);
        if (list.isEmpty()) {
            list2 = list;
            if (b) {
                final List<MediaCodecInfo> list3 = list2 = this.A0(this.z, this.M, (boolean)(0 != 0));
                if (!list3.isEmpty()) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Drm session requires secure decoder for ");
                    sb.append(this.M.w);
                    sb.append(", but no secure decoder available. Trying to proceed with ");
                    sb.append(list3);
                    sb.append(".");
                    Log.i("MediaCodecRenderer", sb.toString());
                    list2 = list3;
                }
            }
        }
        return list2;
    }
    
    @Override
    public void A(final long n, final long n2) throws ExoPlaybackException {
        final boolean k0 = this.K0;
        final boolean b = false;
        if (k0) {
            this.K0 = false;
            this.X0();
        }
        final ExoPlaybackException l0 = this.L0;
        if (l0 == null) {
            try {
                if (this.I0) {
                    this.d1();
                    return;
                }
                if (this.M == null && !this.a1(2)) {
                    return;
                }
                this.N0();
                if (this.v0) {
                    TraceUtil.a("bypassRender");
                    while (this.Y(n, n2)) {}
                    TraceUtil.c();
                }
                else if (this.V != null) {
                    final long elapsedRealtime = SystemClock.elapsedRealtime();
                    TraceUtil.a("drainAndFeed");
                    while (this.o0(n, n2) && this.m1(elapsedRealtime)) {}
                    while (this.q0() && this.m1(elapsedRealtime)) {}
                    TraceUtil.c();
                }
                else {
                    final DecoderCounters m0 = this.M0;
                    m0.d += this.W(n);
                    this.a1(1);
                }
                this.M0.c();
                return;
            }
            catch (final IllegalStateException ex) {
                if (K0(ex)) {
                    this.P0(ex);
                    boolean b2 = b;
                    if (Util.a >= 21) {
                        b2 = b;
                        if (M0(ex)) {
                            b2 = true;
                        }
                    }
                    if (b2) {
                        this.c1();
                    }
                    throw this.G(this.j0(ex, this.w0()), this.M, b2, 4003);
                }
                throw ex;
            }
        }
        this.L0 = null;
        throw l0;
    }
    
    protected abstract List<MediaCodecInfo> A0(final MediaCodecSelector p0, final Format p1, final boolean p2) throws MediaCodecUtil.DecoderQueryException;
    
    protected abstract MediaCodecAdapter.Configuration C0(final MediaCodecInfo p0, final Format p1, final MediaCrypto p2, final float p3);
    
    protected final long D0() {
        return this.O0;
    }
    
    protected float E0() {
        return this.T;
    }
    
    protected void F0(final DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
    }
    
    @Override
    protected void N() {
        this.M = null;
        this.N0 = -9223372036854775807L;
        this.O0 = -9223372036854775807L;
        this.P0 = 0;
        this.t0();
    }
    
    protected final void N0() throws ExoPlaybackException {
        if (this.V == null && !this.v0) {
            final Format m = this.M;
            if (m != null) {
                if (this.P == null && this.p1(m)) {
                    this.H0(this.M);
                    return;
                }
                this.i1(this.P);
                final String w = this.M.w;
                final DrmSession o = this.O;
                if (o != null) {
                    if (this.Q == null) {
                        final FrameworkCryptoConfig b0 = this.B0(o);
                        if (b0 == null) {
                            if (this.O.a() == null) {
                                return;
                            }
                        }
                        else {
                            try {
                                final MediaCrypto q = new MediaCrypto(b0.a, b0.b);
                                this.Q = q;
                                this.R = (!b0.c && q.requiresSecureDecoderComponent(w));
                            }
                            catch (final MediaCryptoException ex) {
                                throw this.F((Throwable)ex, this.M, 6006);
                            }
                        }
                    }
                    if (FrameworkCryptoConfig.d) {
                        final int state = this.O.getState();
                        if (state == 1) {
                            final DrmSession.DrmSessionException ex2 = Assertions.e(this.O.a());
                            throw this.F(ex2, this.M, ex2.errorCode);
                        }
                        if (state != 4) {
                            return;
                        }
                    }
                }
                try {
                    this.O0(this.Q, this.R);
                }
                catch (final DecoderInitializationException ex3) {
                    throw this.F(ex3, this.M, 4001);
                }
            }
        }
    }
    
    @Override
    protected void O(final boolean b, final boolean b2) throws ExoPlaybackException {
        this.M0 = new DecoderCounters();
    }
    
    @Override
    protected void P(final long n, final boolean b) throws ExoPlaybackException {
        this.H0 = false;
        this.I0 = false;
        this.K0 = false;
        if (this.v0) {
            this.F.h();
            this.E.h();
            this.w0 = false;
        }
        else {
            this.s0();
        }
        if (this.G.l() > 0) {
            this.J0 = true;
        }
        this.G.c();
        final int p2 = this.P0;
        if (p2 != 0) {
            this.O0 = this.K[p2 - 1];
            this.N0 = this.J[p2 - 1];
            this.P0 = 0;
        }
    }
    
    protected void P0(final Exception ex) {
    }
    
    @Override
    protected void Q() {
        try {
            this.k0();
            this.c1();
        }
        finally {
            this.l1(null);
        }
    }
    
    protected void Q0(final String s, final MediaCodecAdapter.Configuration configuration, final long n, final long n2) {
    }
    
    @Override
    protected void R() {
    }
    
    protected void R0(final String s) {
    }
    
    @Override
    protected void S() {
    }
    
    protected DecoderReuseEvaluation S0(final FormatHolder formatHolder) throws ExoPlaybackException {
        final boolean b = true;
        this.J0 = true;
        final Format format = Assertions.e(formatHolder.b);
        if (format.w == null) {
            throw this.F(new IllegalArgumentException(), format, 4005);
        }
        this.l1(formatHolder.a);
        this.M = format;
        if (this.v0) {
            this.x0 = true;
            return null;
        }
        final MediaCodecAdapter v = this.V;
        if (v == null) {
            this.a0 = null;
            this.N0();
            return null;
        }
        final MediaCodecInfo c0 = this.c0;
        final Format w = this.W;
        if (this.p0(c0, format, this.O, this.P)) {
            this.m0();
            return new DecoderReuseEvaluation(c0.a, w, format, 0, 128);
        }
        final boolean b2 = this.P != this.O;
        Assertions.g(!b2 || Util.a >= 23);
        final DecoderReuseEvaluation z = this.Z(c0, w, format);
        final int d = z.d;
        int n = 0;
        Label_0412: {
            Label_0410: {
                if (d != 0) {
                    Label_0401: {
                        if (d != 1) {
                            if (d != 2) {
                                if (d != 3) {
                                    throw new IllegalStateException();
                                }
                                if (this.s1(format)) {
                                    this.W = format;
                                    if (b2 && !this.n0()) {
                                        break Label_0401;
                                    }
                                    break Label_0410;
                                }
                            }
                            else if (this.s1(format)) {
                                this.y0 = true;
                                this.z0 = 1;
                                final int d2 = this.d0;
                                boolean l0 = b;
                                if (d2 != 2) {
                                    l0 = (d2 == 1 && format.B == w.B && format.C == w.C && b);
                                }
                                this.l0 = l0;
                                this.W = format;
                                if (b2 && !this.n0()) {
                                    break Label_0401;
                                }
                                break Label_0410;
                            }
                        }
                        else if (this.s1(format)) {
                            this.W = format;
                            if (!(b2 ? this.n0() : this.l0())) {
                                break Label_0401;
                            }
                            break Label_0410;
                        }
                        n = 16;
                        break Label_0412;
                    }
                    n = 2;
                    break Label_0412;
                }
                this.m0();
            }
            n = 0;
        }
        if (z.d != 0 && (this.V != v || this.B0 == 3)) {
            return new DecoderReuseEvaluation(c0.a, w, format, 0, n);
        }
        return z;
    }
    
    @Override
    protected void T(final Format[] array, final long n0, final long o0) throws ExoPlaybackException {
        final long o2 = this.O0;
        boolean b = true;
        if (o2 == -9223372036854775807L) {
            if (this.N0 != -9223372036854775807L) {
                b = false;
            }
            Assertions.g(b);
            this.N0 = n0;
            this.O0 = o0;
        }
        else {
            final int p3 = this.P0;
            if (p3 == this.K.length) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Too many stream changes, so dropping offset: ");
                sb.append(this.K[this.P0 - 1]);
                Log.i("MediaCodecRenderer", sb.toString());
            }
            else {
                this.P0 = p3 + 1;
            }
            final long[] j = this.J;
            final int p4 = this.P0;
            j[p4 - 1] = n0;
            this.K[p4 - 1] = o0;
            this.L[p4 - 1] = this.F0;
        }
    }
    
    protected void T0(final Format format, final MediaFormat mediaFormat) throws ExoPlaybackException {
    }
    
    protected void U0(final long n) {
        while (true) {
            int p = this.P0;
            if (p == 0 || n < this.L[0]) {
                break;
            }
            final long[] j = this.J;
            this.N0 = j[0];
            this.O0 = this.K[0];
            --p;
            System.arraycopy(j, 1, j, 0, this.P0 = p);
            final long[] k = this.K;
            System.arraycopy(k, 1, k, 0, this.P0);
            final long[] l = this.L;
            System.arraycopy(l, 1, l, 0, this.P0);
            this.V0();
        }
    }
    
    protected void V0() {
    }
    
    protected void W0(final DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
    }
    
    protected abstract boolean Y0(final long p0, final long p1, final MediaCodecAdapter p2, final ByteBuffer p3, final int p4, final int p5, final int p6, final long p7, final boolean p8, final boolean p9, final Format p10) throws ExoPlaybackException;
    
    protected DecoderReuseEvaluation Z(final MediaCodecInfo mediaCodecInfo, final Format format, final Format format2) {
        return new DecoderReuseEvaluation(mediaCodecInfo.a, format, format2, 0, 1);
    }
    
    @Override
    public final int a(final Format format) throws ExoPlaybackException {
        try {
            return this.q1(this.z, format);
        }
        catch (final MediaCodecUtil.DecoderQueryException ex) {
            throw this.F(ex, format, 4002);
        }
    }
    
    @Override
    public boolean c() {
        return this.I0;
    }
    
    protected void c1() {
        try {
            final MediaCodecAdapter v = this.V;
            if (v != null) {
                v.release();
                final DecoderCounters m0 = this.M0;
                ++m0.b;
                this.R0(this.c0.a);
            }
            this.V = null;
            try {
                final MediaCrypto q = this.Q;
                if (q != null) {
                    q.release();
                }
            }
            finally {
                this.Q = null;
                this.i1(null);
                this.f1();
            }
        }
        finally {
            this.V = null;
            try {
                final MediaCrypto q2 = this.Q;
                if (q2 != null) {
                    q2.release();
                }
                this.Q = null;
                this.i1(null);
                this.f1();
            }
            finally {
                this.Q = null;
                this.i1(null);
                this.f1();
            }
        }
    }
    
    protected void d1() throws ExoPlaybackException {
    }
    
    protected void e1() {
        this.g1();
        this.h1();
        this.p0 = -9223372036854775807L;
        this.D0 = false;
        this.C0 = false;
        this.l0 = false;
        this.m0 = false;
        this.t0 = false;
        this.u0 = false;
        this.H.clear();
        this.F0 = -9223372036854775807L;
        this.G0 = -9223372036854775807L;
        final h o0 = this.o0;
        if (o0 != null) {
            o0.c();
        }
        this.A0 = 0;
        this.B0 = 0;
        this.z0 = (this.y0 ? 1 : 0);
    }
    
    protected void f1() {
        this.e1();
        this.L0 = null;
        this.o0 = null;
        this.a0 = null;
        this.c0 = null;
        this.W = null;
        this.X = null;
        this.Y = false;
        this.E0 = false;
        this.Z = -1.0f;
        this.d0 = 0;
        this.e0 = false;
        this.f0 = false;
        this.g0 = false;
        this.h0 = false;
        this.i0 = false;
        this.j0 = false;
        this.k0 = false;
        this.n0 = false;
        this.y0 = false;
        this.z0 = 0;
        this.R = false;
    }
    
    @Override
    public boolean isReady() {
        return this.M != null && (this.M() || this.G0() || (this.p0 != -9223372036854775807L && SystemClock.elapsedRealtime() < this.p0));
    }
    
    protected MediaCodecDecoderException j0(final Throwable t, final MediaCodecInfo mediaCodecInfo) {
        return new MediaCodecDecoderException(t, mediaCodecInfo);
    }
    
    protected final void j1() {
        this.K0 = true;
    }
    
    protected final void k1(final ExoPlaybackException l0) {
        this.L0 = l0;
    }
    
    protected boolean n1(final MediaCodecInfo mediaCodecInfo) {
        return true;
    }
    
    protected boolean o1() {
        return false;
    }
    
    protected boolean p1(final Format format) {
        return false;
    }
    
    protected abstract int q1(final MediaCodecSelector p0, final Format p1) throws MediaCodecUtil.DecoderQueryException;
    
    protected final boolean s0() throws ExoPlaybackException {
        final boolean t0 = this.t0();
        if (t0) {
            this.N0();
        }
        return t0;
    }
    
    protected boolean t0() {
        if (this.V == null) {
            return false;
        }
        final int b0 = this.B0;
        if (b0 != 3 && !this.f0 && (!this.g0 || this.E0) && (!this.h0 || !this.D0)) {
            if (b0 == 2) {
                final int a = Util.a;
                Assertions.g(a >= 23);
                if (a >= 23) {
                    try {
                        this.t1();
                    }
                    catch (final ExoPlaybackException ex) {
                        Log.j("MediaCodecRenderer", "Failed to update the DRM session, releasing the codec instead.", ex);
                        this.c1();
                        return true;
                    }
                }
            }
            this.r0();
            return false;
        }
        this.c1();
        return true;
    }
    
    protected final void u1(final long n) throws ExoPlaybackException {
        Format n2;
        final Format format = n2 = this.G.j(n);
        if (format == null) {
            n2 = format;
            if (this.Y) {
                n2 = this.G.i();
            }
        }
        boolean b;
        if (n2 != null) {
            this.N = n2;
            b = true;
        }
        else {
            b = false;
        }
        if (b || (this.Y && this.N != null)) {
            this.T0(this.N, this.X);
            this.Y = false;
        }
    }
    
    protected final MediaCodecAdapter v0() {
        return this.V;
    }
    
    protected final MediaCodecInfo w0() {
        return this.c0;
    }
    
    @Override
    public void x(final float t, final float u) throws ExoPlaybackException {
        this.T = t;
        this.U = u;
        this.s1(this.W);
    }
    
    protected boolean x0() {
        return false;
    }
    
    protected float y0(final float n, final Format format, final Format[] array) {
        return -1.0f;
    }
    
    @Override
    public final int z() {
        return 8;
    }
    
    protected final MediaFormat z0() {
        return this.X;
    }
    
    public static class DecoderInitializationException extends Exception
    {
        public final MediaCodecInfo codecInfo;
        public final String diagnosticInfo;
        public final DecoderInitializationException fallbackDecoderInitializationException;
        public final String mimeType;
        public final boolean secureDecoderRequired;
        
        public DecoderInitializationException(final Format format, final Throwable t, final boolean b, final int n) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Decoder init failed: [");
            sb.append(n);
            sb.append("], ");
            sb.append(format);
            this(sb.toString(), t, format.w, b, null, a(n), null);
        }
        
        public DecoderInitializationException(final Format format, final Throwable t, final boolean b, final MediaCodecInfo mediaCodecInfo) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Decoder init failed: ");
            sb.append(mediaCodecInfo.a);
            sb.append(", ");
            sb.append(format);
            final String string = sb.toString();
            final String w = format.w;
            String c;
            if (Util.a >= 21) {
                c = c(t);
            }
            else {
                c = null;
            }
            this(string, t, w, b, mediaCodecInfo, c, null);
        }
        
        private DecoderInitializationException(final String s, final Throwable t, final String mimeType, final boolean secureDecoderRequired, final MediaCodecInfo codecInfo, final String diagnosticInfo, final DecoderInitializationException fallbackDecoderInitializationException) {
            super(s, t);
            this.mimeType = mimeType;
            this.secureDecoderRequired = secureDecoderRequired;
            this.codecInfo = codecInfo;
            this.diagnosticInfo = diagnosticInfo;
            this.fallbackDecoderInitializationException = fallbackDecoderInitializationException;
        }
        
        private static String a(final int n) {
            String s;
            if (n < 0) {
                s = "neg_";
            }
            else {
                s = "";
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("com.google.android.exoplayer2.mediacodec.MediaCodecRenderer_");
            sb.append(s);
            sb.append(Math.abs(n));
            return sb.toString();
        }
        
        static DecoderInitializationException access$000(final DecoderInitializationException ex, final DecoderInitializationException ex2) {
            return ex.b(ex2);
        }
        
        private DecoderInitializationException b(final DecoderInitializationException ex) {
            return new DecoderInitializationException(this.getMessage(), this.getCause(), this.mimeType, this.secureDecoderRequired, this.codecInfo, this.diagnosticInfo, ex);
        }
        
        private static String c(final Throwable t) {
            if (t instanceof MediaCodec$CodecException) {
                return ((MediaCodec$CodecException)t).getDiagnosticInfo();
            }
            return null;
        }
    }
    
    private static final class a
    {
        public static void a(final MediaCodecAdapter.Configuration configuration, final PlayerId playerId) {
            final LogSessionId a = playerId.a();
            if (!a.equals((Object)LogSessionId.LOG_SESSION_ID_NONE)) {
                configuration.b.setString("log-session-id", a.getStringId());
            }
        }
    }
}
