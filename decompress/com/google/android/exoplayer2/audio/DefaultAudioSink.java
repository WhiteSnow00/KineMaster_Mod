// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.audio;

import java.util.concurrent.Executor;
import java.util.Objects;
import android.media.AudioTrack$StreamEventCallback;
import android.os.Handler;
import android.media.AudioAttributes$Builder;
import android.media.AudioTrack$Builder;
import android.media.metrics.LogSessionId;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import android.util.Pair;
import java.nio.ByteOrder;
import android.os.SystemClock;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Log;
import android.media.PlaybackParams;
import com.google.android.exoplayer2.Format;
import android.media.AudioManager;
import android.media.AudioFormat$Builder;
import android.media.AudioFormat;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.PlaybackParameters;
import android.media.AudioTrack;
import com.google.android.exoplayer2.analytics.PlayerId;
import java.util.ArrayDeque;
import com.google.android.exoplayer2.util.ConditionVariable;
import java.nio.ByteBuffer;

public final class DefaultAudioSink implements AudioSink
{
    public static boolean c0 = false;
    private int A;
    private long B;
    private long C;
    private long D;
    private long E;
    private int F;
    private boolean G;
    private boolean H;
    private long I;
    private float J;
    private AudioProcessor[] K;
    private ByteBuffer[] L;
    private ByteBuffer M;
    private int N;
    private ByteBuffer O;
    private byte[] P;
    private int Q;
    private int R;
    private boolean S;
    private boolean T;
    private boolean U;
    private boolean V;
    private int W;
    private AuxEffectInfo X;
    private boolean Y;
    private long Z;
    private final AudioCapabilities a;
    private boolean a0;
    private final AudioProcessorChain b;
    private boolean b0;
    private final boolean c;
    private final m d;
    private final r e;
    private final AudioProcessor[] f;
    private final AudioProcessor[] g;
    private final ConditionVariable h;
    private final AudioTrackPositionTracker i;
    private final ArrayDeque<e> j;
    private final boolean k;
    private final int l;
    private h m;
    private final f<InitializationException> n;
    private final f<WriteException> o;
    private final c p;
    private PlayerId q;
    private Listener r;
    private d s;
    private d t;
    private AudioTrack u;
    private AudioAttributes v;
    private e w;
    private e x;
    private PlaybackParameters y;
    private ByteBuffer z;
    
    private DefaultAudioSink(final Builder builder) {
        this.a = Builder.a(builder);
        final AudioProcessorChain b = Builder.b(builder);
        this.b = b;
        final int a = Util.a;
        this.c = (a >= 21 && Builder.c(builder));
        this.k = (a >= 23 && Builder.d(builder));
        int e;
        if (a >= 29) {
            e = Builder.e(builder);
        }
        else {
            e = 0;
        }
        this.l = e;
        this.p = builder.f;
        (this.h = new ConditionVariable(Clock.a)).f();
        this.i = new AudioTrackPositionTracker((AudioTrackPositionTracker.Listener)new g(null));
        final m d = new m();
        this.d = d;
        final r e2 = new r();
        this.e = e2;
        final ArrayList<Object> list = new ArrayList<Object>();
        Collections.addAll(list, new p(), d, e2);
        Collections.addAll(list, b.b());
        this.f = list.toArray(new AudioProcessor[0]);
        this.g = new AudioProcessor[] { new o() };
        this.J = 1.0f;
        this.v = AudioAttributes.g;
        this.W = 0;
        this.X = new AuxEffectInfo(0, 0.0f);
        final PlaybackParameters d2 = PlaybackParameters.d;
        this.x = new e(d2, false, 0L, 0L, null);
        this.y = d2;
        this.R = -1;
        this.K = new AudioProcessor[0];
        this.L = new ByteBuffer[0];
        this.j = new ArrayDeque<e>();
        this.n = new f<InitializationException>(100L);
        this.o = new f<WriteException>(100L);
    }
    
    DefaultAudioSink(final Builder builder, final DefaultAudioSink$a thread) {
        this(builder);
    }
    
    static ConditionVariable A(final DefaultAudioSink defaultAudioSink) {
        return defaultAudioSink.h;
    }
    
    static AudioTrack B(final DefaultAudioSink defaultAudioSink) {
        return defaultAudioSink.u;
    }
    
    private void C(final long n) {
        PlaybackParameters playbackParameters;
        if (this.h0()) {
            playbackParameters = this.b.c(this.K());
        }
        else {
            playbackParameters = PlaybackParameters.d;
        }
        final boolean b = this.h0() && this.b.e(this.P());
        this.j.add(new e(playbackParameters, b, Math.max(0L, n), this.t.h(this.R()), null));
        this.g0();
        final Listener r = this.r;
        if (r != null) {
            r.onSkipSilenceEnabledChanged(b);
        }
    }
    
    private long D(long n) {
        while (!this.j.isEmpty() && n >= this.j.getFirst().d) {
            this.x = this.j.remove();
        }
        final e x = this.x;
        final long n2 = n - x.d;
        if (x.a.equals(PlaybackParameters.d)) {
            return this.x.c + n2;
        }
        if (this.j.isEmpty()) {
            n = this.b.a(n2);
            return this.x.c + n;
        }
        final e e = this.j.getFirst();
        n = Util.a0(e.d - n, this.x.a.a);
        return e.c - n;
    }
    
    private long E(final long n) {
        return n + this.t.h(this.b.d());
    }
    
    private AudioTrack F(final d d) throws InitializationException {
        try {
            return d.a(this.Y, this.v, this.W);
        }
        catch (final InitializationException ex) {
            final Listener r = this.r;
            if (r != null) {
                r.a(ex);
            }
            throw ex;
        }
    }
    
    private AudioTrack G() throws InitializationException {
        try {
            return this.F(Assertions.e(this.t));
        }
        catch (final InitializationException ex) {
            final d t = this.t;
            if (t.h > 1000000) {
                final d c = t.c(1000000);
                try {
                    final AudioTrack f = this.F(c);
                    this.t = c;
                    return f;
                }
                catch (final InitializationException ex2) {
                    ex.addSuppressed(ex2);
                }
            }
            this.W();
            throw ex;
        }
    }
    
    private boolean H() throws WriteException {
        while (true) {
            boolean b = false;
            Label_0020: {
                if (this.R != -1) {
                    b = false;
                    break Label_0020;
                }
                this.R = 0;
                b = true;
            }
            final int r = this.R;
            final AudioProcessor[] k = this.K;
            if (r >= k.length) {
                final ByteBuffer o = this.O;
                if (o != null) {
                    this.k0(o, -9223372036854775807L);
                    if (this.O != null) {
                        return false;
                    }
                }
                this.R = -1;
                return true;
            }
            final AudioProcessor audioProcessor = k[r];
            if (b) {
                audioProcessor.e();
            }
            this.Y(-9223372036854775807L);
            if (!audioProcessor.c()) {
                return false;
            }
            ++this.R;
            continue;
        }
    }
    
    private void I() {
        int n = 0;
        while (true) {
            final AudioProcessor[] k = this.K;
            if (n >= k.length) {
                break;
            }
            final AudioProcessor audioProcessor = k[n];
            audioProcessor.flush();
            this.L[n] = audioProcessor.a();
            ++n;
        }
    }
    
    private static AudioFormat J(final int sampleRate, final int channelMask, final int encoding) {
        return new AudioFormat$Builder().setSampleRate(sampleRate).setChannelMask(channelMask).setEncoding(encoding).build();
    }
    
    private PlaybackParameters K() {
        return this.N().a;
    }
    
    private static int L(int minBufferSize, final int n, final int n2) {
        minBufferSize = AudioTrack.getMinBufferSize(minBufferSize, n, n2);
        Assertions.g(minBufferSize != -2);
        return minBufferSize;
    }
    
    private static int M(int n, final ByteBuffer byteBuffer) {
        switch (n) {
            default: {
                final StringBuilder sb = new StringBuilder();
                sb.append("Unexpected audio encoding: ");
                sb.append(n);
                throw new IllegalStateException(sb.toString());
            }
            case 17: {
                return Ac4Util.c(byteBuffer);
            }
            case 16: {
                return 1024;
            }
            case 15: {
                return 512;
            }
            case 14: {
                n = Ac3Util.a(byteBuffer);
                if (n == -1) {
                    n = 0;
                }
                else {
                    n = Ac3Util.h(byteBuffer, n) * 16;
                }
                return n;
            }
            case 11:
            case 12: {
                return 2048;
            }
            case 10: {
                return 1024;
            }
            case 9: {
                n = MpegAudioUtil.m(Util.I(byteBuffer, byteBuffer.position()));
                if (n != -1) {
                    return n;
                }
                throw new IllegalArgumentException();
            }
            case 7:
            case 8: {
                return DtsUtil.e(byteBuffer);
            }
            case 5:
            case 6:
            case 18: {
                return Ac3Util.d(byteBuffer);
            }
        }
    }
    
    private e N() {
        e e = this.w;
        if (e == null) {
            if (!this.j.isEmpty()) {
                e = this.j.getLast();
            }
            else {
                e = this.x;
            }
        }
        return e;
    }
    
    private int O(final AudioFormat audioFormat, final android.media.AudioAttributes audioAttributes) {
        final int a = Util.a;
        if (a >= 31) {
            return AudioManager.getPlaybackOffloadSupport(audioFormat, audioAttributes);
        }
        if (!AudioManager.isOffloadedPlaybackSupported(audioFormat, audioAttributes)) {
            return 0;
        }
        if (a == 30 && Util.d.startsWith("Pixel")) {
            return 2;
        }
        return 1;
    }
    
    private long Q() {
        final d t = this.t;
        long c;
        if (t.c == 0) {
            c = this.B / t.b;
        }
        else {
            c = this.C;
        }
        return c;
    }
    
    private long R() {
        final d t = this.t;
        long e;
        if (t.c == 0) {
            e = this.D / t.d;
        }
        else {
            e = this.E;
        }
        return e;
    }
    
    private boolean S() throws InitializationException {
        if (!this.h.e()) {
            return false;
        }
        final AudioTrack g = this.G();
        this.u = g;
        if (V(g)) {
            this.Z(this.u);
            if (this.l != 3) {
                final AudioTrack u = this.u;
                final Format a = this.t.a;
                u.setOffloadDelayPadding(a.M, a.N);
            }
        }
        if (Util.a >= 31) {
            final PlayerId q = this.q;
            if (q != null) {
                DefaultAudioSink.b.a(this.u, q);
            }
        }
        this.W = this.u.getAudioSessionId();
        final AudioTrackPositionTracker i = this.i;
        final AudioTrack u2 = this.u;
        final d t = this.t;
        i.s(u2, t.c == 2, t.g, t.d, t.h);
        this.d0();
        final int a2 = this.X.a;
        if (a2 != 0) {
            this.u.attachAuxEffect(a2);
            this.u.setAuxEffectSendLevel(this.X.b);
        }
        return this.H = true;
    }
    
    private static boolean T(final int n) {
        return (Util.a >= 24 && n == -6) || n == -32;
    }
    
    private boolean U() {
        return this.u != null;
    }
    
    private static boolean V(final AudioTrack audioTrack) {
        return Util.a >= 29 && audioTrack.isOffloadedPlayback();
    }
    
    private void W() {
        if (!this.t.l()) {
            return;
        }
        this.a0 = true;
    }
    
    private void X() {
        if (!this.T) {
            this.T = true;
            this.i.g(this.R());
            this.u.stop();
            this.A = 0;
        }
    }
    
    private void Y(final long n) throws WriteException {
        int i;
        final int n2 = i = this.K.length;
        while (i >= 0) {
            ByteBuffer byteBuffer;
            if (i > 0) {
                byteBuffer = this.L[i - 1];
            }
            else {
                byteBuffer = this.M;
                if (byteBuffer == null) {
                    byteBuffer = AudioProcessor.a;
                }
            }
            if (i == n2) {
                this.k0(byteBuffer, n);
            }
            else {
                final AudioProcessor audioProcessor = this.K[i];
                if (i > this.R) {
                    audioProcessor.b(byteBuffer);
                }
                final ByteBuffer a = audioProcessor.a();
                this.L[i] = a;
                if (a.hasRemaining()) {
                    ++i;
                    continue;
                }
            }
            if (byteBuffer.hasRemaining()) {
                return;
            }
            --i;
        }
    }
    
    private void Z(final AudioTrack audioTrack) {
        if (this.m == null) {
            this.m = new h();
        }
        this.m.a(audioTrack);
    }
    
    private void a0() {
        this.B = 0L;
        this.C = 0L;
        this.D = 0L;
        this.E = 0L;
        this.b0 = false;
        this.F = 0;
        this.x = new e(this.K(), this.P(), 0L, 0L, null);
        this.I = 0L;
        this.w = null;
        this.j.clear();
        this.M = null;
        this.N = 0;
        this.O = null;
        this.T = false;
        this.S = false;
        this.R = -1;
        this.z = null;
        this.A = 0;
        this.e.m();
        this.I();
    }
    
    private void b0(final PlaybackParameters playbackParameters, final boolean b) {
        final e n = this.N();
        if (!playbackParameters.equals(n.a) || b != n.b) {
            final e e = new e(playbackParameters, b, -9223372036854775807L, -9223372036854775807L, null);
            if (this.U()) {
                this.w = e;
            }
            else {
                this.x = e;
            }
        }
    }
    
    private void c0(final PlaybackParameters playbackParameters) {
        PlaybackParameters y = playbackParameters;
        if (this.U()) {
            final PlaybackParams setAudioFallbackMode = new PlaybackParams().allowDefaults().setSpeed(playbackParameters.a).setPitch(playbackParameters.b).setAudioFallbackMode(2);
            try {
                this.u.setPlaybackParams(setAudioFallbackMode);
            }
            catch (final IllegalArgumentException ex) {
                Log.j("DefaultAudioSink", "Failed to set playback params", ex);
            }
            y = new PlaybackParameters(this.u.getPlaybackParams().getSpeed(), this.u.getPlaybackParams().getPitch());
            this.i.t(y.a);
        }
        this.y = y;
    }
    
    private void d0() {
        if (this.U()) {
            if (Util.a >= 21) {
                e0(this.u, this.J);
            }
            else {
                f0(this.u, this.J);
            }
        }
    }
    
    private static void e0(final AudioTrack audioTrack, final float volume) {
        audioTrack.setVolume(volume);
    }
    
    private static void f0(final AudioTrack audioTrack, final float n) {
        audioTrack.setStereoVolume(n, n);
    }
    
    private void g0() {
        final AudioProcessor[] i = this.t.i;
        final ArrayList list = new ArrayList();
        for (final AudioProcessor audioProcessor : i) {
            if (audioProcessor.isActive()) {
                list.add(audioProcessor);
            }
            else {
                audioProcessor.flush();
            }
        }
        final int size = list.size();
        this.K = list.toArray(new AudioProcessor[size]);
        this.L = new ByteBuffer[size];
        this.I();
    }
    
    private boolean h0() {
        return !this.Y && "audio/raw".equals(this.t.a.w) && !this.i0(this.t.a.L);
    }
    
    private boolean i0(final int n) {
        return this.c && Util.t0(n);
    }
    
    private boolean j0(final Format format, final AudioAttributes audioAttributes) {
        final int a = Util.a;
        boolean b2;
        final boolean b = b2 = false;
        if (a >= 29) {
            if (this.l == 0) {
                b2 = b;
            }
            else {
                final int f = MimeTypes.f(Assertions.e(format.w), format.i);
                if (f == 0) {
                    return false;
                }
                final int g = Util.G(format.J);
                if (g == 0) {
                    return false;
                }
                final int o = this.O(J(format.K, g, f), audioAttributes.b().a);
                b2 = b;
                if (o != 0) {
                    if (o != 1) {
                        if (o == 2) {
                            return true;
                        }
                        throw new IllegalStateException();
                    }
                    else {
                        final boolean b3 = format.M != 0 || format.N != 0;
                        final boolean b4 = this.l == 1;
                        if (b3) {
                            b2 = b;
                            if (b4) {
                                return b2;
                            }
                        }
                        b2 = true;
                    }
                }
            }
        }
        return b2;
    }
    
    private void k0(final ByteBuffer o, final long n) throws WriteException {
        if (!o.hasRemaining()) {
            return;
        }
        final ByteBuffer o2 = this.O;
        final boolean b = true;
        if (o2 != null) {
            Assertions.a(o2 == o);
        }
        else {
            this.O = o;
            if (Util.a < 21) {
                final int remaining = o.remaining();
                final byte[] p2 = this.P;
                if (p2 == null || p2.length < remaining) {
                    this.P = new byte[remaining];
                }
                final int position = o.position();
                o.get(this.P, 0, remaining);
                o.position(position);
                this.Q = 0;
            }
        }
        final int remaining2 = o.remaining();
        int n2;
        if (Util.a < 21) {
            final int c = this.i.c(this.D);
            if (c > 0) {
                final int write = this.u.write(this.P, this.Q, Math.min(remaining2, c));
                if ((n2 = write) > 0) {
                    this.Q += write;
                    o.position(o.position() + write);
                    n2 = write;
                }
            }
            else {
                n2 = 0;
            }
        }
        else if (this.Y) {
            Assertions.g(n != -9223372036854775807L);
            n2 = this.m0(this.u, o, remaining2, n);
        }
        else {
            n2 = l0(this.u, o, remaining2);
        }
        this.Z = SystemClock.elapsedRealtime();
        if (n2 >= 0) {
            this.o.a();
            if (V(this.u)) {
                if (this.E > 0L) {
                    this.b0 = false;
                }
                if (this.U) {
                    final Listener r = this.r;
                    if (r != null && n2 < remaining2 && !this.b0) {
                        r.c();
                    }
                }
            }
            final int c2 = this.t.c;
            if (c2 == 0) {
                this.D += n2;
            }
            if (n2 == remaining2) {
                if (c2 != 0) {
                    Assertions.g(o == this.M && b);
                    this.E += this.F * (long)this.N;
                }
                this.O = null;
            }
            return;
        }
        final boolean t = T(n2);
        if (t) {
            this.W();
        }
        final WriteException ex = new WriteException(n2, this.t.a, t);
        final Listener r2 = this.r;
        if (r2 != null) {
            r2.a(ex);
        }
        if (!ex.isRecoverable) {
            this.o.b(ex);
            return;
        }
        throw ex;
    }
    
    private static int l0(final AudioTrack audioTrack, final ByteBuffer byteBuffer, final int n) {
        return audioTrack.write(byteBuffer, n, 1);
    }
    
    private int m0(final AudioTrack audioTrack, final ByteBuffer byteBuffer, int l0, final long n) {
        if (Util.a >= 26) {
            return audioTrack.write(byteBuffer, l0, 1, n * 1000L);
        }
        if (this.z == null) {
            (this.z = ByteBuffer.allocate(16)).order(ByteOrder.BIG_ENDIAN);
            this.z.putInt(1431633921);
        }
        if (this.A == 0) {
            this.z.putInt(4, l0);
            this.z.putLong(8, n * 1000L);
            this.z.position(0);
            this.A = l0;
        }
        final int remaining = this.z.remaining();
        if (remaining > 0) {
            final int write = audioTrack.write(this.z, remaining, 1);
            if (write < 0) {
                this.A = 0;
                return write;
            }
            if (write < remaining) {
                return 0;
            }
        }
        l0 = l0(audioTrack, byteBuffer, l0);
        if (l0 < 0) {
            this.A = 0;
            return l0;
        }
        this.A -= l0;
        return l0;
    }
    
    static Listener u(final DefaultAudioSink defaultAudioSink) {
        return defaultAudioSink.r;
    }
    
    static boolean v(final DefaultAudioSink defaultAudioSink) {
        return defaultAudioSink.U;
    }
    
    static long w(final DefaultAudioSink defaultAudioSink) {
        return defaultAudioSink.Q();
    }
    
    static long x(final DefaultAudioSink defaultAudioSink) {
        return defaultAudioSink.R();
    }
    
    static long y(final DefaultAudioSink defaultAudioSink) {
        return defaultAudioSink.Z;
    }
    
    static AudioFormat z(final int n, final int n2, final int n3) {
        return J(n, n2, n3);
    }
    
    public boolean P() {
        return this.N().b;
    }
    
    @Override
    public boolean a(final Format format) {
        return this.l(format) != 0;
    }
    
    @Override
    public PlaybackParameters b() {
        PlaybackParameters playbackParameters;
        if (this.k) {
            playbackParameters = this.y;
        }
        else {
            playbackParameters = this.K();
        }
        return playbackParameters;
    }
    
    @Override
    public boolean c() {
        return !this.U() || (this.S && !this.e());
    }
    
    @Override
    public void d(PlaybackParameters playbackParameters) {
        playbackParameters = new PlaybackParameters(Util.p(playbackParameters.a, 0.1f, 8.0f), Util.p(playbackParameters.b, 0.1f, 8.0f));
        if (this.k && Util.a >= 23) {
            this.c0(playbackParameters);
        }
        else {
            this.b0(playbackParameters, this.P());
        }
    }
    
    @Override
    public boolean e() {
        return this.U() && this.i.h(this.R());
    }
    
    @Override
    public void f(final int w) {
        if (this.W != w) {
            this.W = w;
            this.V = (w != 0);
            this.flush();
        }
    }
    
    @Override
    public void flush() {
        if (this.U()) {
            this.a0();
            if (this.i.i()) {
                this.u.pause();
            }
            if (V(this.u)) {
                Assertions.e(this.m).b(this.u);
            }
            final AudioTrack u = this.u;
            this.u = null;
            if (Util.a < 21 && !this.V) {
                this.W = 0;
            }
            final d s = this.s;
            if (s != null) {
                this.t = s;
                this.s = null;
            }
            this.i.q();
            this.h.d();
            new Thread(this, "ExoPlayer:AudioTrackReleaseThread", u) {
                final AudioTrack a;
                final DefaultAudioSink b;
                
                @Override
                public void run() {
                    try {
                        this.a.flush();
                        this.a.release();
                    }
                    finally {
                        DefaultAudioSink.A(this.b).f();
                    }
                }
            }.start();
        }
        this.o.a();
        this.n.a();
    }
    
    @Override
    public void g() {
        if (this.Y) {
            this.Y = false;
            this.flush();
        }
    }
    
    @Override
    public void h(final AudioAttributes v) {
        if (this.v.equals(v)) {
            return;
        }
        this.v = v;
        if (this.Y) {
            return;
        }
        this.flush();
    }
    
    @Override
    public void i(final PlayerId q) {
        this.q = q;
    }
    
    @Override
    public boolean j(final ByteBuffer m, final long n, final int n2) throws InitializationException, WriteException {
        final ByteBuffer i = this.M;
        Assertions.a(i == null || m == i);
        if (this.s != null) {
            if (!this.H()) {
                return false;
            }
            if (!this.s.b(this.t)) {
                this.X();
                if (this.e()) {
                    return false;
                }
                this.flush();
            }
            else {
                this.t = this.s;
                this.s = null;
                if (V(this.u) && this.l != 3) {
                    if (this.u.getPlayState() == 3) {
                        this.u.setOffloadEndOfStream();
                    }
                    final AudioTrack u = this.u;
                    final Format a = this.t.a;
                    u.setOffloadDelayPadding(a.M, a.N);
                    this.b0 = true;
                }
            }
            this.C(n);
        }
        if (!this.U()) {
            try {
                if (!this.S()) {
                    return false;
                }
            }
            catch (final InitializationException ex) {
                if (!ex.isRecoverable) {
                    this.n.b(ex);
                    return false;
                }
                throw ex;
            }
        }
        this.n.a();
        if (this.H) {
            this.I = Math.max(0L, n);
            this.G = false;
            this.H = false;
            if (this.k && Util.a >= 23) {
                this.c0(this.y);
            }
            this.C(n);
            if (this.U) {
                this.play();
            }
        }
        if (!this.i.k(this.R())) {
            return false;
        }
        if (this.M == null) {
            Assertions.a(m.order() == ByteOrder.LITTLE_ENDIAN);
            if (!m.hasRemaining()) {
                return true;
            }
            final d t = this.t;
            if (t.c != 0 && this.F == 0 && (this.F = M(t.g, m)) == 0) {
                return true;
            }
            if (this.w != null) {
                if (!this.H()) {
                    return false;
                }
                this.C(n);
                this.w = null;
            }
            final long n3 = this.I + this.t.k(this.Q() - this.e.l());
            if (!this.G && Math.abs(n3 - n) > 200000L) {
                this.r.a(new UnexpectedDiscontinuityException(n, n3));
                this.G = true;
            }
            if (this.G) {
                if (!this.H()) {
                    return false;
                }
                final long n4 = n - n3;
                this.I += n4;
                this.G = false;
                this.C(n);
                final Listener r = this.r;
                if (r != null && n4 != 0L) {
                    r.e();
                }
            }
            if (this.t.c == 0) {
                this.B += m.remaining();
            }
            else {
                this.C += this.F * (long)n2;
            }
            this.M = m;
            this.N = n2;
        }
        this.Y(n);
        if (!this.M.hasRemaining()) {
            this.M = null;
            this.N = 0;
            return true;
        }
        if (this.i.j(this.R())) {
            Log.i("DefaultAudioSink", "Resetting stalled audio track");
            this.flush();
            return true;
        }
        return false;
    }
    
    @Override
    public void k(final Listener r) {
        this.r = r;
    }
    
    @Override
    public int l(final Format format) {
        if ("audio/raw".equals(format.w)) {
            if (!Util.u0(format.L)) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Invalid PCM encoding: ");
                sb.append(format.L);
                Log.i("DefaultAudioSink", sb.toString());
                return 0;
            }
            final int l = format.L;
            if (l != 2 && (!this.c || l != 4)) {
                return 1;
            }
            return 2;
        }
        else {
            if (!this.a0 && this.j0(format, this.v)) {
                return 2;
            }
            if (this.a.h(format)) {
                return 2;
            }
            return 0;
        }
    }
    
    @Override
    public void m() {
        if (Util.a < 25) {
            this.flush();
            return;
        }
        this.o.a();
        this.n.a();
        if (!this.U()) {
            return;
        }
        this.a0();
        if (this.i.i()) {
            this.u.pause();
        }
        this.u.flush();
        this.i.q();
        final AudioTrackPositionTracker i = this.i;
        final AudioTrack u = this.u;
        final d t = this.t;
        i.s(u, t.c == 2, t.g, t.d, t.h);
        this.H = true;
    }
    
    @Override
    public void n(final AuxEffectInfo x) {
        if (this.X.equals(x)) {
            return;
        }
        final int a = x.a;
        final float b = x.b;
        final AudioTrack u = this.u;
        if (u != null) {
            if (this.X.a != a) {
                u.attachAuxEffect(a);
            }
            if (a != 0) {
                this.u.setAuxEffectSendLevel(b);
            }
        }
        this.X = x;
    }
    
    @Override
    public void o() throws WriteException {
        if (!this.S && this.U() && this.H()) {
            this.X();
            this.S = true;
        }
    }
    
    @Override
    public long p(final boolean b) {
        if (this.U() && !this.H) {
            return this.E(this.D(Math.min(this.i.d(b), this.t.h(this.R()))));
        }
        return Long.MIN_VALUE;
    }
    
    @Override
    public void pause() {
        this.U = false;
        if (this.U() && this.i.p()) {
            this.u.pause();
        }
    }
    
    @Override
    public void play() {
        this.U = true;
        if (this.U()) {
            this.i.u();
            this.u.play();
        }
    }
    
    @Override
    public void q() {
        this.G = true;
    }
    
    @Override
    public void r() {
        Assertions.g(Util.a >= 21);
        Assertions.g(this.V);
        if (!this.Y) {
            this.Y = true;
            this.flush();
        }
    }
    
    @Override
    public void reset() {
        this.flush();
        final AudioProcessor[] f = this.f;
        for (int length = f.length, i = 0; i < length; ++i) {
            f[i].reset();
        }
        final AudioProcessor[] g = this.g;
        for (int length2 = g.length, j = 0; j < length2; ++j) {
            g[j].reset();
        }
        this.U = false;
        this.a0 = false;
    }
    
    @Override
    public void s(final Format format, int n, int[] array) throws ConfigurationException {
        int n3;
        int n4;
        int n5;
        int e2;
        AudioProcessor[] array4;
        int n7;
        int n8;
        if ("audio/raw".equals(format.w)) {
            Assertions.a(Util.u0(format.L));
            final int e0 = Util.e0(format.L, format.J);
            AudioProcessor[] array2;
            if (this.i0(format.L)) {
                array2 = this.g;
            }
            else {
                array2 = this.f;
            }
            this.e.n(format.M, format.N);
            if (Util.a < 21 && format.J == 8 && array == null) {
                final int[] array3 = new int[6];
                int n2 = 0;
                while (true) {
                    array = array3;
                    if (n2 >= 6) {
                        break;
                    }
                    array3[n2] = n2;
                    ++n2;
                }
            }
            this.d.l(array);
            AudioProcessor.AudioFormat audioFormat = new AudioProcessor.AudioFormat(format.K, format.J, format.L);
            final int length = array2.length;
            int i = 0;
            while (i < length) {
                final AudioProcessor audioProcessor = array2[i];
                try {
                    final AudioProcessor.AudioFormat d = audioProcessor.d(audioFormat);
                    if (audioProcessor.isActive()) {
                        audioFormat = d;
                    }
                    ++i;
                    continue;
                }
                catch (final AudioProcessor.UnhandledAudioFormatException ex) {
                    throw new ConfigurationException(ex, format);
                }
                break;
            }
            n3 = audioFormat.c;
            n4 = audioFormat.a;
            n5 = Util.G(audioFormat.b);
            e2 = Util.e0(n3, audioFormat.b);
            array4 = array2;
            final int n6 = 0;
            n7 = e0;
            n8 = n6;
        }
        else {
            array4 = new AudioProcessor[0];
            n4 = format.K;
            if (this.j0(format, this.v)) {
                n3 = MimeTypes.f(Assertions.e(format.w), format.i);
                n5 = Util.G(format.J);
                n7 = -1;
                e2 = -1;
                n8 = 1;
            }
            else {
                final Pair<Integer, Integer> f = this.a.f(format);
                if (f == null) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Unable to configure passthrough for: ");
                    sb.append(format);
                    throw new ConfigurationException(sb.toString(), format);
                }
                n3 = (int)f.first;
                n5 = (int)f.second;
                n7 = -1;
                e2 = -1;
                n8 = 2;
            }
        }
        if (n == 0) {
            final c p3 = this.p;
            n = L(n4, n5, n3);
            double n9;
            if (this.k) {
                n9 = 8.0;
            }
            else {
                n9 = 1.0;
            }
            n = p3.a(n, n3, n8, e2, n4, n9);
        }
        if (n3 == 0) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Invalid output encoding (mode=");
            sb2.append(n8);
            sb2.append(") for: ");
            sb2.append(format);
            throw new ConfigurationException(sb2.toString(), format);
        }
        if (n5 != 0) {
            this.a0 = false;
            final d d2 = new d(format, n7, n8, e2, n4, n5, n3, n, array4);
            if (this.U()) {
                this.s = d2;
            }
            else {
                this.t = d2;
            }
            return;
        }
        final StringBuilder sb3 = new StringBuilder();
        sb3.append("Invalid output channel config (mode=");
        sb3.append(n8);
        sb3.append(") for: ");
        sb3.append(format);
        throw new ConfigurationException(sb3.toString(), format);
    }
    
    @Override
    public void setVolume(final float j) {
        if (this.J != j) {
            this.J = j;
            this.d0();
        }
    }
    
    @Override
    public void t(final boolean b) {
        this.b0(this.K(), b);
    }
    
    public interface AudioProcessorChain
    {
        long a(final long p0);
        
        AudioProcessor[] b();
        
        PlaybackParameters c(final PlaybackParameters p0);
        
        long d();
        
        boolean e(final boolean p0);
    }
    
    public static final class Builder
    {
        private AudioCapabilities a;
        private AudioProcessorChain b;
        private boolean c;
        private boolean d;
        private int e;
        c f;
        
        public Builder() {
            this.a = AudioCapabilities.c;
            this.e = 0;
            this.f = c.a;
        }
        
        static AudioCapabilities a(final Builder builder) {
            return builder.a;
        }
        
        static AudioProcessorChain b(final Builder builder) {
            return builder.b;
        }
        
        static boolean c(final Builder builder) {
            return builder.c;
        }
        
        static boolean d(final Builder builder) {
            return builder.d;
        }
        
        static int e(final Builder builder) {
            return builder.e;
        }
        
        public DefaultAudioSink f() {
            if (this.b == null) {
                this.b = new DefaultAudioProcessorChain(new AudioProcessor[0]);
            }
            return new DefaultAudioSink(this, null);
        }
        
        public Builder g(final AudioCapabilities a) {
            Assertions.e(a);
            this.a = a;
            return this;
        }
        
        public Builder h(final AudioProcessorChain b) {
            Assertions.e(b);
            this.b = b;
            return this;
        }
        
        public Builder i(final AudioProcessor[] array) {
            Assertions.e(array);
            return this.h(new DefaultAudioProcessorChain(array));
        }
        
        public Builder j(final boolean d) {
            this.d = d;
            return this;
        }
        
        public Builder k(final boolean c) {
            this.c = c;
            return this;
        }
        
        public Builder l(final int e) {
            this.e = e;
            return this;
        }
    }
    
    public static class DefaultAudioProcessorChain implements AudioProcessorChain
    {
        private final AudioProcessor[] a;
        private final SilenceSkippingAudioProcessor b;
        private final SonicAudioProcessor c;
        
        public DefaultAudioProcessorChain(final AudioProcessor... array) {
            this(array, new SilenceSkippingAudioProcessor(), new SonicAudioProcessor());
        }
        
        public DefaultAudioProcessorChain(final AudioProcessor[] array, final SilenceSkippingAudioProcessor b, final SonicAudioProcessor c) {
            final AudioProcessor[] a = new AudioProcessor[array.length + 2];
            System.arraycopy(array, 0, this.a = a, 0, array.length);
            this.b = b;
            this.c = c;
            a[array.length] = b;
            a[array.length + 1] = c;
        }
        
        @Override
        public long a(final long n) {
            return this.c.f(n);
        }
        
        @Override
        public AudioProcessor[] b() {
            return this.a;
        }
        
        @Override
        public PlaybackParameters c(final PlaybackParameters playbackParameters) {
            this.c.h(playbackParameters.a);
            this.c.g(playbackParameters.b);
            return playbackParameters;
        }
        
        @Override
        public long d() {
            return this.b.o();
        }
        
        @Override
        public boolean e(final boolean b) {
            this.b.u(b);
            return b;
        }
    }
    
    public static final class InvalidAudioTrackTimestampException extends RuntimeException
    {
        private InvalidAudioTrackTimestampException(final String s) {
            super(s);
        }
        
        InvalidAudioTrackTimestampException(final String s, final DefaultAudioSink$a thread) {
            this(s);
        }
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.TYPE_USE })
    public @interface OffloadMode {
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.TYPE_USE })
    public @interface OutputMode {
    }
    
    private static final class b
    {
        public static void a(final AudioTrack audioTrack, final PlayerId playerId) {
            final LogSessionId a = playerId.a();
            if (!a.equals((Object)LogSessionId.LOG_SESSION_ID_NONE)) {
                audioTrack.setLogSessionId(a);
            }
        }
    }
    
    interface c
    {
        public static final c a = new DefaultAudioTrackBufferSizeProvider.Builder().g();
        
        int a(final int p0, final int p1, final int p2, final int p3, final int p4, final double p5);
    }
    
    private static final class d
    {
        public final Format a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;
        public final int h;
        public final AudioProcessor[] i;
        
        public d(final Format a, final int b, final int c, final int d, final int e, final int f, final int g, final int h, final AudioProcessor[] i) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
            this.f = f;
            this.g = g;
            this.h = h;
            this.i = i;
        }
        
        private AudioTrack d(final boolean b, final AudioAttributes audioAttributes, final int n) {
            final int a = Util.a;
            if (a >= 29) {
                return this.f(b, audioAttributes, n);
            }
            if (a >= 21) {
                return this.e(b, audioAttributes, n);
            }
            return this.g(audioAttributes, n);
        }
        
        private AudioTrack e(final boolean b, final AudioAttributes audioAttributes, final int n) {
            return new AudioTrack(i(audioAttributes, b), DefaultAudioSink.z(this.e, this.f, this.g), this.h, 1, n);
        }
        
        private AudioTrack f(final boolean b, final AudioAttributes audioAttributes, final int sessionId) {
            final AudioTrack$Builder setAudioFormat = new AudioTrack$Builder().setAudioAttributes(i(audioAttributes, b)).setAudioFormat(DefaultAudioSink.z(this.e, this.f, this.g));
            boolean offloadedPlayback = true;
            final AudioTrack$Builder setSessionId = setAudioFormat.setTransferMode(1).setBufferSizeInBytes(this.h).setSessionId(sessionId);
            if (this.c != 1) {
                offloadedPlayback = false;
            }
            return setSessionId.setOffloadedPlayback(offloadedPlayback).build();
        }
        
        private AudioTrack g(final AudioAttributes audioAttributes, final int n) {
            final int g0 = Util.g0(audioAttributes.c);
            if (n == 0) {
                return new AudioTrack(g0, this.e, this.f, this.g, this.h, 1);
            }
            return new AudioTrack(g0, this.e, this.f, this.g, this.h, 1, n);
        }
        
        private static android.media.AudioAttributes i(final AudioAttributes audioAttributes, final boolean b) {
            if (b) {
                return j();
            }
            return audioAttributes.b().a;
        }
        
        private static android.media.AudioAttributes j() {
            return new AudioAttributes$Builder().setContentType(3).setFlags(16).setUsage(1).build();
        }
        
        public AudioTrack a(final boolean p0, final AudioAttributes p1, final int p2) throws InitializationException {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: iload_1        
            //     2: aload_2        
            //     3: iload_3        
            //     4: invokespecial   com/google/android/exoplayer2/audio/DefaultAudioSink$d.d:(ZLcom/google/android/exoplayer2/audio/AudioAttributes;I)Landroid/media/AudioTrack;
            //     7: astore_2       
            //     8: aload_2        
            //     9: invokevirtual   android/media/AudioTrack.getState:()I
            //    12: istore_3       
            //    13: iload_3        
            //    14: iconst_1       
            //    15: if_icmpne       20
            //    18: aload_2        
            //    19: areturn        
            //    20: aload_2        
            //    21: invokevirtual   android/media/AudioTrack.release:()V
            //    24: new             Lcom/google/android/exoplayer2/audio/AudioSink$InitializationException;
            //    27: dup            
            //    28: iload_3        
            //    29: aload_0        
            //    30: getfield        com/google/android/exoplayer2/audio/DefaultAudioSink$d.e:I
            //    33: aload_0        
            //    34: getfield        com/google/android/exoplayer2/audio/DefaultAudioSink$d.f:I
            //    37: aload_0        
            //    38: getfield        com/google/android/exoplayer2/audio/DefaultAudioSink$d.h:I
            //    41: aload_0        
            //    42: getfield        com/google/android/exoplayer2/audio/DefaultAudioSink$d.a:Lcom/google/android/exoplayer2/Format;
            //    45: aload_0        
            //    46: invokevirtual   com/google/android/exoplayer2/audio/DefaultAudioSink$d.l:()Z
            //    49: aconst_null    
            //    50: invokespecial   com/google/android/exoplayer2/audio/AudioSink$InitializationException.<init>:(IIIILcom/google/android/exoplayer2/Format;ZLjava/lang/Exception;)V
            //    53: athrow         
            //    54: astore_2       
            //    55: goto            59
            //    58: astore_2       
            //    59: new             Lcom/google/android/exoplayer2/audio/AudioSink$InitializationException;
            //    62: dup            
            //    63: iconst_0       
            //    64: aload_0        
            //    65: getfield        com/google/android/exoplayer2/audio/DefaultAudioSink$d.e:I
            //    68: aload_0        
            //    69: getfield        com/google/android/exoplayer2/audio/DefaultAudioSink$d.f:I
            //    72: aload_0        
            //    73: getfield        com/google/android/exoplayer2/audio/DefaultAudioSink$d.h:I
            //    76: aload_0        
            //    77: getfield        com/google/android/exoplayer2/audio/DefaultAudioSink$d.a:Lcom/google/android/exoplayer2/Format;
            //    80: aload_0        
            //    81: invokevirtual   com/google/android/exoplayer2/audio/DefaultAudioSink$d.l:()Z
            //    84: aload_2        
            //    85: invokespecial   com/google/android/exoplayer2/audio/AudioSink$InitializationException.<init>:(IIIILcom/google/android/exoplayer2/Format;ZLjava/lang/Exception;)V
            //    88: athrow         
            //    89: astore_2       
            //    90: goto            24
            //    Exceptions:
            //  throws com.google.android.exoplayer2.audio.AudioSink.InitializationException
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                                     
            //  -----  -----  -----  -----  -----------------------------------------
            //  0      8      58     59     Ljava/lang/UnsupportedOperationException;
            //  0      8      54     58     Ljava/lang/IllegalArgumentException;
            //  20     24     89     93     Ljava/lang/Exception;
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0020:
            //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
            //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2604)
            //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
            //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:206)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:93)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:868)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:761)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:638)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:605)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:195)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:662)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:605)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:195)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:162)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:137)
            //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
            //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
            //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:333)
            //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:254)
            //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:129)
            // 
            throw new IllegalStateException("An error occurred while decompiling this method.");
        }
        
        public boolean b(final d d) {
            return d.c == this.c && d.g == this.g && d.e == this.e && d.f == this.f && d.d == this.d;
        }
        
        public d c(final int n) {
            return new d(this.a, this.b, this.c, this.d, this.e, this.f, this.g, n, this.i);
        }
        
        public long h(final long n) {
            return n * 1000000L / this.e;
        }
        
        public long k(final long n) {
            return n * 1000000L / this.a.K;
        }
        
        public boolean l() {
            final int c = this.c;
            boolean b = true;
            if (c != 1) {
                b = false;
            }
            return b;
        }
    }
    
    private static final class e
    {
        public final PlaybackParameters a;
        public final boolean b;
        public final long c;
        public final long d;
        
        private e(final PlaybackParameters a, final boolean b, final long c, final long d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }
        
        e(final PlaybackParameters playbackParameters, final boolean b, final long n, final long n2, final DefaultAudioSink$a thread) {
            this(playbackParameters, b, n, n2);
        }
    }
    
    private static final class f<T extends Exception>
    {
        private final long a;
        private T b;
        private long c;
        
        public f(final long a) {
            this.a = a;
        }
        
        public void a() {
            this.b = null;
        }
        
        public void b(final T b) throws T, Exception {
            final long elapsedRealtime = SystemClock.elapsedRealtime();
            if (this.b == null) {
                this.b = b;
                this.c = this.a + elapsedRealtime;
            }
            if (elapsedRealtime >= this.c) {
                final Exception b2 = this.b;
                if (b2 != b) {
                    b2.addSuppressed(b);
                }
                final Exception b3 = this.b;
                this.a();
                throw b3;
            }
        }
    }
    
    private final class g implements AudioTrackPositionTracker.Listener
    {
        final DefaultAudioSink a;
        
        private g(final DefaultAudioSink a) {
            this.a = a;
        }
        
        g(final DefaultAudioSink defaultAudioSink, final DefaultAudioSink$a thread) {
            this(defaultAudioSink);
        }
        
        @Override
        public void a(final int n, final long n2) {
            if (DefaultAudioSink.u(this.a) != null) {
                DefaultAudioSink.u(this.a).d(n, n2, SystemClock.elapsedRealtime() - DefaultAudioSink.y(this.a));
            }
        }
        
        @Override
        public void b(final long n) {
            if (DefaultAudioSink.u(this.a) != null) {
                DefaultAudioSink.u(this.a).b(n);
            }
        }
        
        @Override
        public void c(final long n) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Ignoring impossibly large audio latency: ");
            sb.append(n);
            Log.i("DefaultAudioSink", sb.toString());
        }
        
        @Override
        public void d(final long n, final long n2, final long n3, final long n4) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Spurious audio timestamp (frame position mismatch): ");
            sb.append(n);
            sb.append(", ");
            sb.append(n2);
            sb.append(", ");
            sb.append(n3);
            sb.append(", ");
            sb.append(n4);
            sb.append(", ");
            sb.append(DefaultAudioSink.w(this.a));
            sb.append(", ");
            sb.append(DefaultAudioSink.x(this.a));
            final String string = sb.toString();
            if (!DefaultAudioSink.c0) {
                Log.i("DefaultAudioSink", string);
                return;
            }
            throw new InvalidAudioTrackTimestampException(string, (DefaultAudioSink$a)null);
        }
        
        @Override
        public void e(final long n, final long n2, final long n3, final long n4) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Spurious audio timestamp (system clock mismatch): ");
            sb.append(n);
            sb.append(", ");
            sb.append(n2);
            sb.append(", ");
            sb.append(n3);
            sb.append(", ");
            sb.append(n4);
            sb.append(", ");
            sb.append(DefaultAudioSink.w(this.a));
            sb.append(", ");
            sb.append(DefaultAudioSink.x(this.a));
            final String string = sb.toString();
            if (!DefaultAudioSink.c0) {
                Log.i("DefaultAudioSink", string);
                return;
            }
            throw new InvalidAudioTrackTimestampException(string, (DefaultAudioSink$a)null);
        }
    }
    
    private final class h
    {
        private final Handler a;
        private final AudioTrack$StreamEventCallback b;
        final DefaultAudioSink c;
        
        public h(final DefaultAudioSink c) {
            this.c = c;
            this.a = new Handler();
            this.b = new AudioTrack$StreamEventCallback(this, c) {
                final DefaultAudioSink a;
                final h b;
                
                public void onDataRequest(final AudioTrack audioTrack, final int n) {
                    Assertions.g(audioTrack == DefaultAudioSink.B(this.b.c));
                    if (DefaultAudioSink.u(this.b.c) != null && DefaultAudioSink.v(this.b.c)) {
                        DefaultAudioSink.u(this.b.c).f();
                    }
                }
                
                public void onTearDown(final AudioTrack audioTrack) {
                    Assertions.g(audioTrack == DefaultAudioSink.B(this.b.c));
                    if (DefaultAudioSink.u(this.b.c) != null && DefaultAudioSink.v(this.b.c)) {
                        DefaultAudioSink.u(this.b.c).f();
                    }
                }
            };
        }
        
        public void a(final AudioTrack audioTrack) {
            final Handler a = this.a;
            Objects.requireNonNull(a);
            audioTrack.registerStreamEventCallback((Executor)new n(a), this.b);
        }
        
        public void b(final AudioTrack audioTrack) {
            audioTrack.unregisterStreamEventCallback(this.b);
            this.a.removeCallbacksAndMessages((Object)null);
        }
    }
}
