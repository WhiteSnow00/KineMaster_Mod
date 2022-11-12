// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.util.Assertions;
import java.nio.ByteBuffer;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.util.MediaFormatUtil;
import android.media.MediaFormat;
import android.media.MediaCrypto;
import com.google.android.exoplayer2.util.Util;
import java.util.Collection;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.common.collect.ImmutableList;
import com.google.android.exoplayer2.mediacodec.MediaCodecInfo;
import java.util.List;
import android.os.Handler;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.Format;
import android.content.Context;
import com.google.android.exoplayer2.util.MediaClock;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;

public class MediaCodecAudioRenderer extends MediaCodecRenderer implements MediaClock
{
    private final Context R0;
    private final AudioRendererEventListener.EventDispatcher S0;
    private final AudioSink T0;
    private int U0;
    private boolean V0;
    private Format W0;
    private long X0;
    private boolean Y0;
    private boolean Z0;
    private boolean a1;
    private boolean b1;
    private WakeupListener c1;
    
    public MediaCodecAudioRenderer(final Context context, final MediaCodecAdapter.Factory factory, final MediaCodecSelector mediaCodecSelector, final boolean b, final Handler handler, final AudioRendererEventListener audioRendererEventListener, final AudioSink t0) {
        super(1, factory, mediaCodecSelector, b, 44100.0f);
        this.R0 = context.getApplicationContext();
        this.T0 = t0;
        this.S0 = new AudioRendererEventListener.EventDispatcher(handler, audioRendererEventListener);
        t0.k((AudioSink.Listener)new b(null));
    }
    
    private static List<MediaCodecInfo> B1(final MediaCodecSelector mediaCodecSelector, final Format format, final boolean b, final AudioSink audioSink) throws MediaCodecUtil.DecoderQueryException {
        final String w = format.w;
        if (w == null) {
            return (List<MediaCodecInfo>)ImmutableList.of();
        }
        if (audioSink.a(format)) {
            final MediaCodecInfo v = MediaCodecUtil.v();
            if (v != null) {
                return (List<MediaCodecInfo>)ImmutableList.of((Object)v);
            }
        }
        final List<MediaCodecInfo> a = mediaCodecSelector.a(w, b, false);
        final String m = MediaCodecUtil.m(format);
        if (m == null) {
            return (List<MediaCodecInfo>)ImmutableList.copyOf((Collection)a);
        }
        return (List<MediaCodecInfo>)ImmutableList.builder().j((Iterable)a).j((Iterable)mediaCodecSelector.a(m, b, false)).l();
    }
    
    private void E1() {
        long x0 = this.T0.p(this.c());
        if (x0 != Long.MIN_VALUE) {
            if (!this.Z0) {
                x0 = Math.max(this.X0, x0);
            }
            this.X0 = x0;
            this.Z0 = false;
        }
    }
    
    static AudioRendererEventListener.EventDispatcher v1(final MediaCodecAudioRenderer mediaCodecAudioRenderer) {
        return mediaCodecAudioRenderer.S0;
    }
    
    static WakeupListener w1(final MediaCodecAudioRenderer mediaCodecAudioRenderer) {
        return mediaCodecAudioRenderer.c1;
    }
    
    private static boolean x1(String b) {
        if (Util.a < 24 && "OMX.SEC.aac.dec".equals(b) && "samsung".equals(Util.c)) {
            b = Util.b;
            if (b.startsWith("zeroflte") || b.startsWith("herolte") || b.startsWith("heroqlte")) {
                return true;
            }
        }
        return false;
    }
    
    private static boolean y1() {
        if (Util.a == 23) {
            final String d = Util.d;
            if ("ZTE B2017G".equals(d) || "AXON 7 mini".equals(d)) {
                return true;
            }
        }
        return false;
    }
    
    private int z1(final MediaCodecInfo mediaCodecInfo, final Format format) {
        if ("OMX.google.raw.decoder".equals(mediaCodecInfo.a)) {
            final int a = Util.a;
            if (a < 24 && (a != 23 || !Util.x0(this.R0))) {
                return -1;
            }
        }
        return format.x;
    }
    
    @Override
    protected List<MediaCodecInfo> A0(final MediaCodecSelector mediaCodecSelector, final Format format, final boolean b) throws MediaCodecUtil.DecoderQueryException {
        return MediaCodecUtil.u(B1(mediaCodecSelector, format, b, this.T0), format);
    }
    
    protected int A1(final MediaCodecInfo mediaCodecInfo, final Format format, final Format[] array) {
        int z1 = this.z1(mediaCodecInfo, format);
        if (array.length == 1) {
            return z1;
        }
        int max;
        for (int length = array.length, i = 0; i < length; ++i, z1 = max) {
            final Format format2 = array[i];
            max = z1;
            if (mediaCodecInfo.e(format, format2).d != 0) {
                max = Math.max(z1, this.z1(mediaCodecInfo, format2));
            }
        }
        return z1;
    }
    
    @Override
    protected MediaCodecAdapter.Configuration C0(final MediaCodecInfo mediaCodecInfo, final Format format, final MediaCrypto mediaCrypto, final float n) {
        this.U0 = this.A1(mediaCodecInfo, format, this.L());
        this.V0 = x1(mediaCodecInfo.a);
        final MediaFormat c1 = this.C1(format, mediaCodecInfo.c, this.U0, n);
        Format w0;
        if ("audio/raw".equals(mediaCodecInfo.b) && !"audio/raw".equals(format.w)) {
            w0 = format;
        }
        else {
            w0 = null;
        }
        this.W0 = w0;
        return MediaCodecAdapter.Configuration.a(mediaCodecInfo, c1, format, mediaCrypto);
    }
    
    protected MediaFormat C1(final Format format, final String s, int a, final float n) {
        final MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", s);
        mediaFormat.setInteger("channel-count", format.J);
        mediaFormat.setInteger("sample-rate", format.K);
        MediaFormatUtil.e(mediaFormat, format.y);
        MediaFormatUtil.d(mediaFormat, "max-input-size", a);
        a = Util.a;
        if (a >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (n != -1.0f && !y1()) {
                mediaFormat.setFloat("operating-rate", n);
            }
        }
        if (a <= 28 && "audio/ac4".equals(format.w)) {
            mediaFormat.setInteger("ac4-is-sync", 1);
        }
        if (a >= 24 && this.T0.l(Util.d0(4, format.J, format.K)) == 2) {
            mediaFormat.setInteger("pcm-encoding", 4);
        }
        if (a >= 32) {
            mediaFormat.setInteger("max-output-channel-count", 99);
        }
        return mediaFormat;
    }
    
    @Override
    public MediaClock D() {
        return this;
    }
    
    protected void D1() {
        this.Z0 = true;
    }
    
    @Override
    protected void N() {
        this.a1 = true;
        try {
            this.T0.flush();
            try {
                super.N();
            }
            finally {
                this.S0.o(super.M0);
            }
        }
        finally {
            try {
                super.N();
                this.S0.o(super.M0);
            }
            finally {
                this.S0.o(super.M0);
            }
        }
    }
    
    @Override
    protected void O(final boolean b, final boolean b2) throws ExoPlaybackException {
        super.O(b, b2);
        this.S0.p(super.M0);
        if (this.H().a) {
            this.T0.r();
        }
        else {
            this.T0.g();
        }
        this.T0.i(this.K());
    }
    
    @Override
    protected void P(final long x0, final boolean b) throws ExoPlaybackException {
        super.P(x0, b);
        if (this.b1) {
            this.T0.m();
        }
        else {
            this.T0.flush();
        }
        this.X0 = x0;
        this.Y0 = true;
        this.Z0 = true;
    }
    
    @Override
    protected void P0(final Exception ex) {
        Log.d("MediaCodecAudioRenderer", "Audio codec error", ex);
        this.S0.k(ex);
    }
    
    @Override
    protected void Q() {
        try {
            super.Q();
        }
        finally {
            if (this.a1) {
                this.a1 = false;
                this.T0.reset();
            }
        }
    }
    
    @Override
    protected void Q0(final String s, final MediaCodecAdapter.Configuration configuration, final long n, final long n2) {
        this.S0.m(s, n, n2);
    }
    
    @Override
    protected void R() {
        super.R();
        this.T0.play();
    }
    
    @Override
    protected void R0(final String s) {
        this.S0.n(s);
    }
    
    @Override
    protected void S() {
        this.E1();
        this.T0.pause();
        super.S();
    }
    
    @Override
    protected DecoderReuseEvaluation S0(final FormatHolder formatHolder) throws ExoPlaybackException {
        final DecoderReuseEvaluation s0 = super.S0(formatHolder);
        this.S0.q(formatHolder.b, s0);
        return s0;
    }
    
    @Override
    protected void T0(Format format, final MediaFormat mediaFormat) throws ExoPlaybackException {
        final Format w0 = this.W0;
        final int[] array = null;
        final int[] array2 = null;
        int[] array3;
        if (w0 != null) {
            format = w0;
            array3 = array;
        }
        else if (this.v0() == null) {
            array3 = array;
        }
        else {
            int n;
            if ("audio/raw".equals(format.w)) {
                n = format.L;
            }
            else if (Util.a >= 24 && mediaFormat.containsKey("pcm-encoding")) {
                n = mediaFormat.getInteger("pcm-encoding");
            }
            else if (mediaFormat.containsKey("v-bits-per-sample")) {
                n = Util.c0(mediaFormat.getInteger("v-bits-per-sample"));
            }
            else {
                n = 2;
            }
            final Format e = new Format.Builder().e0("audio/raw").Y(n).N(format.M).O(format.N).H(mediaFormat.getInteger("channel-count")).f0(mediaFormat.getInteger("sample-rate")).E();
            array3 = array2;
            if (this.V0) {
                array3 = array2;
                if (e.J == 6) {
                    final int j = format.J;
                    array3 = array2;
                    if (j < 6) {
                        final int[] array4 = new int[j];
                        int n2 = 0;
                        while (true) {
                            array3 = array4;
                            if (n2 >= format.J) {
                                break;
                            }
                            array4[n2] = n2;
                            ++n2;
                        }
                    }
                }
            }
            format = e;
        }
        try {
            this.T0.s(format, 0, array3);
        }
        catch (final AudioSink.ConfigurationException ex) {
            throw this.F(ex, ex.format, 5001);
        }
    }
    
    @Override
    protected void V0() {
        super.V0();
        this.T0.q();
    }
    
    @Override
    protected void W0(final DecoderInputBuffer decoderInputBuffer) {
        if (this.Y0 && !decoderInputBuffer.m()) {
            if (Math.abs(decoderInputBuffer.f - this.X0) > 500000L) {
                this.X0 = decoderInputBuffer.f;
            }
            this.Y0 = false;
        }
    }
    
    @Override
    protected boolean Y0(final long n, final long n2, final MediaCodecAdapter mediaCodecAdapter, final ByteBuffer byteBuffer, final int n3, final int n4, final int n5, final long n6, final boolean b, final boolean b2, final Format format) throws ExoPlaybackException {
        Assertions.e(byteBuffer);
        if (this.W0 != null && (n4 & 0x2) != 0x0) {
            Assertions.e(mediaCodecAdapter).m(n3, false);
            return true;
        }
        if (b) {
            if (mediaCodecAdapter != null) {
                mediaCodecAdapter.m(n3, false);
            }
            final DecoderCounters m0 = super.M0;
            m0.f += n5;
            this.T0.q();
            return true;
        }
        try {
            if (this.T0.j(byteBuffer, n6, n5)) {
                if (mediaCodecAdapter != null) {
                    mediaCodecAdapter.m(n3, false);
                }
                final DecoderCounters m2 = super.M0;
                m2.e += n5;
                return true;
            }
            return false;
        }
        catch (final AudioSink.WriteException ex) {
            throw this.G(ex, format, ex.isRecoverable, 5002);
        }
        catch (final AudioSink.InitializationException ex2) {
            throw this.G(ex2, ex2.format, ex2.isRecoverable, 5001);
        }
    }
    
    @Override
    protected DecoderReuseEvaluation Z(final MediaCodecInfo mediaCodecInfo, final Format format, final Format format2) {
        final DecoderReuseEvaluation e = mediaCodecInfo.e(format, format2);
        int e2;
        final int n = e2 = e.e;
        if (this.z1(mediaCodecInfo, format2) > this.U0) {
            e2 = (n | 0x40);
        }
        final String a = mediaCodecInfo.a;
        int d;
        if (e2 != 0) {
            d = 0;
        }
        else {
            d = e.d;
        }
        return new DecoderReuseEvaluation(a, format, format2, d, e2);
    }
    
    @Override
    public PlaybackParameters b() {
        return this.T0.b();
    }
    
    @Override
    public boolean c() {
        return super.c() && this.T0.c();
    }
    
    @Override
    public void d(final PlaybackParameters playbackParameters) {
        this.T0.d(playbackParameters);
    }
    
    @Override
    protected void d1() throws ExoPlaybackException {
        try {
            this.T0.o();
        }
        catch (final AudioSink.WriteException ex) {
            throw this.G(ex, ex.format, ex.isRecoverable, 5002);
        }
    }
    
    @Override
    public String getName() {
        return "MediaCodecAudioRenderer";
    }
    
    @Override
    public boolean isReady() {
        return this.T0.e() || super.isReady();
    }
    
    @Override
    public void p(final int n, final Object o) throws ExoPlaybackException {
        if (n != 2) {
            if (n != 3) {
                if (n != 6) {
                    switch (n) {
                        default: {
                            super.p(n, o);
                            break;
                        }
                        case 11: {
                            this.c1 = (WakeupListener)o;
                            break;
                        }
                        case 10: {
                            this.T0.f((int)o);
                            break;
                        }
                        case 9: {
                            this.T0.t((boolean)o);
                            break;
                        }
                    }
                }
                else {
                    this.T0.n((AuxEffectInfo)o);
                }
            }
            else {
                this.T0.h((AudioAttributes)o);
            }
        }
        else {
            this.T0.setVolume((float)o);
        }
    }
    
    @Override
    protected boolean p1(final Format format) {
        return this.T0.a(format);
    }
    
    @Override
    protected int q1(final MediaCodecSelector mediaCodecSelector, final Format format) throws MediaCodecUtil.DecoderQueryException {
        final boolean o = MimeTypes.o(format.w);
        int n = 0;
        if (!o) {
            return RendererCapabilities.o(0);
        }
        int n2;
        if (Util.a >= 21) {
            n2 = 32;
        }
        else {
            n2 = 0;
        }
        final int p2 = format.P;
        int n3 = 1;
        final boolean b = p2 != 0;
        final boolean r1 = MediaCodecRenderer.r1(format);
        final int n4 = 8;
        int n5 = 4;
        if (r1 && this.T0.a(format) && (!b || MediaCodecUtil.v() != null)) {
            return RendererCapabilities.v(4, 8, n2);
        }
        if ("audio/raw".equals(format.w) && !this.T0.a(format)) {
            return RendererCapabilities.o(1);
        }
        if (!this.T0.a(Util.d0(2, format.J, format.K))) {
            return RendererCapabilities.o(1);
        }
        final List<MediaCodecInfo> b2 = B1(mediaCodecSelector, format, false, this.T0);
        if (b2.isEmpty()) {
            return RendererCapabilities.o(1);
        }
        if (!r1) {
            return RendererCapabilities.o(2);
        }
        MediaCodecInfo mediaCodecInfo = b2.get(0);
        final boolean m = mediaCodecInfo.m(format);
        boolean b3 = false;
        Label_0291: {
            if (!m) {
                for (int i = 1; i < b2.size(); ++i) {
                    final MediaCodecInfo mediaCodecInfo2 = b2.get(i);
                    if (mediaCodecInfo2.m(format)) {
                        b3 = false;
                        mediaCodecInfo = mediaCodecInfo2;
                        break Label_0291;
                    }
                }
            }
            b3 = true;
            n3 = (m ? 1 : 0);
        }
        if (n3 == 0) {
            n5 = 3;
        }
        int n6 = n4;
        if (n3 != 0) {
            n6 = n4;
            if (mediaCodecInfo.p(format)) {
                n6 = 16;
            }
        }
        int n7;
        if (mediaCodecInfo.h) {
            n7 = 64;
        }
        else {
            n7 = 0;
        }
        if (b3) {
            n = 128;
        }
        return RendererCapabilities.k(n5, n6, n2, n7, n);
    }
    
    @Override
    public long w() {
        if (this.getState() == 2) {
            this.E1();
        }
        return this.X0;
    }
    
    @Override
    protected float y0(float n, final Format format, final Format[] array) {
        final int length = array.length;
        int i = 0;
        int n2 = -1;
        while (i < length) {
            final int k = array[i].K;
            int max = n2;
            if (k != -1) {
                max = Math.max(n2, k);
            }
            ++i;
            n2 = max;
        }
        if (n2 == -1) {
            n = -1.0f;
        }
        else {
            n *= n2;
        }
        return n;
    }
    
    private final class b implements Listener
    {
        final MediaCodecAudioRenderer a;
        
        private b(final MediaCodecAudioRenderer a) {
            this.a = a;
        }
        
        b(final MediaCodecAudioRenderer mediaCodecAudioRenderer, final MediaCodecAudioRenderer$a object) {
            this(mediaCodecAudioRenderer);
        }
        
        @Override
        public void a(final Exception ex) {
            Log.d("MediaCodecAudioRenderer", "Audio sink error", ex);
            MediaCodecAudioRenderer.v1(this.a).l(ex);
        }
        
        @Override
        public void b(final long n) {
            MediaCodecAudioRenderer.v1(this.a).B(n);
        }
        
        @Override
        public void c() {
            if (MediaCodecAudioRenderer.w1(this.a) != null) {
                MediaCodecAudioRenderer.w1(this.a).a();
            }
        }
        
        @Override
        public void d(final int n, final long n2, final long n3) {
            MediaCodecAudioRenderer.v1(this.a).D(n, n2, n3);
        }
        
        @Override
        public void e() {
            this.a.D1();
        }
        
        @Override
        public void f() {
            if (MediaCodecAudioRenderer.w1(this.a) != null) {
                MediaCodecAudioRenderer.w1(this.a).b();
            }
        }
        
        @Override
        public void onSkipSilenceEnabledChanged(final boolean b) {
            MediaCodecAudioRenderer.v1(this.a).C(b);
        }
    }
}
