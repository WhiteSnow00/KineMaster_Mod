// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.rtsp;

import com.google.common.collect.Multimap;
import java.util.AbstractCollection;
import com.google.common.collect.ImmutableMap;
import java.util.Iterator;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.Iterables;
import java.util.HashMap;
import java.util.Map;
import com.google.android.exoplayer2.ParserException;
import android.os.Handler;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import com.google.android.exoplayer2.util.Util;
import java.util.Collection;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList$Builder;
import com.google.common.collect.ImmutableList;
import com.google.android.exoplayer2.util.Log;
import com.google.common.base.Joiner;
import java.util.List;
import java.io.IOException;
import com.google.android.exoplayer2.util.Assertions;
import java.net.Socket;
import android.net.Uri;
import android.util.SparseArray;
import java.util.ArrayDeque;
import javax.net.SocketFactory;
import java.io.Closeable;

final class RtspClient implements Closeable
{
    private boolean A;
    private boolean B;
    private boolean C;
    private long D;
    private final SessionInfoListener a;
    private final PlaybackEventListener b;
    private final String c;
    private final SocketFactory d;
    private final boolean e;
    private final ArrayDeque<h.d> f;
    private final SparseArray<RtspRequest> g;
    private final d h;
    private Uri i;
    private RtspMessageChannel j;
    private RtspMessageUtil.RtspAuthUserInfo p;
    private String w;
    private b x;
    private e y;
    private int z;
    
    public RtspClient(final SessionInfoListener a, final PlaybackEventListener b, final String c, final Uri uri, final SocketFactory d, final boolean e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = new ArrayDeque<h.d>();
        this.g = (SparseArray<RtspRequest>)new SparseArray();
        this.h = new d(null);
        this.i = RtspMessageUtil.p(uri);
        this.j = new RtspMessageChannel((RtspMessageChannel.MessageListener)new c());
        this.p = RtspMessageUtil.n(uri);
        this.D = -9223372036854775807L;
        this.z = -1;
    }
    
    private Socket B0(final Uri uri) throws IOException {
        Assertions.a(uri.getHost() != null);
        int port;
        if (uri.getPort() > 0) {
            port = uri.getPort();
        }
        else {
            port = 554;
        }
        return this.d.createSocket(Assertions.e(uri.getHost()), port);
    }
    
    static boolean E(final RtspClient rtspClient, final boolean a) {
        return rtspClient.A = a;
    }
    
    static void F(final RtspClient rtspClient) {
        rtspClient.t0();
    }
    
    private void F0(final List<String> list) {
        if (this.e) {
            Log.b("RtspClient", Joiner.i("\n").e((Iterable)list));
        }
    }
    
    static long L(final RtspClient rtspClient) {
        return rtspClient.D;
    }
    
    private static boolean L0(final List<Integer> list) {
        return list.isEmpty() || list.contains(2);
    }
    
    static long M(final RtspClient rtspClient, final long d) {
        return rtspClient.D = d;
    }
    
    static boolean O(final RtspClient rtspClient, final boolean c) {
        return rtspClient.C = c;
    }
    
    static PlaybackEventListener V(final RtspClient rtspClient) {
        return rtspClient.b;
    }
    
    static String W(final RtspClient rtspClient) {
        return rtspClient.w;
    }
    
    static String Z(final RtspClient rtspClient, final String w) {
        return rtspClient.w = w;
    }
    
    static int a(final RtspClient rtspClient) {
        return rtspClient.z;
    }
    
    static String a0(final RtspClient rtspClient) {
        return rtspClient.c;
    }
    
    static RtspMessageChannel c(final RtspClient rtspClient) {
        return rtspClient.j;
    }
    
    static e c0(final RtspClient rtspClient) {
        return rtspClient.y;
    }
    
    static int d(final RtspClient rtspClient, final int z) {
        return rtspClient.z = z;
    }
    
    static d e(final RtspClient rtspClient) {
        return rtspClient.h;
    }
    
    static e e0(final RtspClient rtspClient, final e y) {
        return rtspClient.y = y;
    }
    
    static RtspMessageUtil.RtspAuthUserInfo f0(final RtspClient rtspClient) {
        return rtspClient.p;
    }
    
    static RtspMessageUtil.RtspAuthUserInfo g0(final RtspClient rtspClient, final RtspMessageUtil.RtspAuthUserInfo p2) {
        return rtspClient.p = p2;
    }
    
    static SessionInfoListener h(final RtspClient rtspClient) {
        return rtspClient.a;
    }
    
    static Uri i(final RtspClient rtspClient) {
        return rtspClient.i;
    }
    
    static void i0(final RtspClient rtspClient, final Throwable t) {
        rtspClient.y0(t);
    }
    
    static Uri j(final RtspClient rtspClient, final Uri i) {
        return rtspClient.i = i;
    }
    
    static boolean k(final RtspClient rtspClient) {
        return rtspClient.B;
    }
    
    static boolean l(final RtspClient rtspClient, final boolean b) {
        return rtspClient.B = b;
    }
    
    static SparseArray l0(final RtspClient rtspClient) {
        return rtspClient.g;
    }
    
    static void m0(final RtspClient rtspClient, final List list) {
        rtspClient.F0(list);
    }
    
    static b r(final RtspClient rtspClient) {
        return rtspClient.x;
    }
    
    private static ImmutableList<l> r0(final SessionDescription sessionDescription, final Uri uri) {
        final ImmutableList$Builder immutableList$Builder = new ImmutableList$Builder();
        for (int i = 0; i < ((AbstractCollection)sessionDescription.b).size(); ++i) {
            final MediaDescription mediaDescription = ((List<MediaDescription>)sessionDescription.b).get(i);
            if (RtpPayloadFormat.c(mediaDescription)) {
                immutableList$Builder.i((Object)new l(mediaDescription, uri));
            }
        }
        return (ImmutableList<l>)immutableList$Builder.l();
    }
    
    static b s(final RtspClient rtspClient, final b x) {
        return rtspClient.x = x;
    }
    
    static boolean t(final List list) {
        return L0(list);
    }
    
    private void t0() {
        final h.d d = this.f.pollFirst();
        if (d == null) {
            this.b.d();
            return;
        }
        this.h.j(d.c(), d.d(), this.w);
    }
    
    static ImmutableList u(final SessionDescription sessionDescription, final Uri uri) {
        return r0(sessionDescription, uri);
    }
    
    private void y0(final Throwable t) {
        RtspMediaSource.RtspPlaybackException ex;
        if (t instanceof RtspMediaSource.RtspPlaybackException) {
            ex = (RtspMediaSource.RtspPlaybackException)t;
        }
        else {
            ex = new RtspMediaSource.RtspPlaybackException(t);
        }
        if (this.A) {
            this.b.c(ex);
        }
        else {
            this.a.b(Strings.e(t.getMessage()), t);
        }
    }
    
    public int C0() {
        return this.z;
    }
    
    public void G0(final int n, final RtspMessageChannel.InterleavedBinaryDataListener interleavedBinaryDataListener) {
        this.j.h(n, interleavedBinaryDataListener);
    }
    
    public void J0() {
        try {
            this.close();
            (this.j = new RtspMessageChannel((RtspMessageChannel.MessageListener)new c())).e(this.B0(this.i));
            this.w = null;
            this.B = false;
            this.y = null;
        }
        catch (final IOException ex) {
            this.b.c(new RtspMediaSource.RtspPlaybackException(ex));
        }
    }
    
    public void K0(final long d) {
        if (this.z == 2 && !this.C) {
            this.h.f(this.i, Assertions.e(this.w));
        }
        this.D = d;
    }
    
    public void N0(final List<h.d> list) {
        this.f.addAll((Collection<?>)list);
        this.t0();
    }
    
    public void R0() throws IOException {
        try {
            this.j.e(this.B0(this.i));
            this.h.e(this.i, this.w);
        }
        catch (final IOException ex) {
            Util.n(this.j);
            throw ex;
        }
    }
    
    public void S0(final long n) {
        this.h.g(this.i, n, Assertions.e(this.w));
    }
    
    @Override
    public void close() throws IOException {
        final b x = this.x;
        if (x != null) {
            x.close();
            this.x = null;
            this.h.k(this.i, Assertions.e(this.w));
        }
        this.j.close();
    }
    
    public interface PlaybackEventListener
    {
        void c(final RtspMediaSource.RtspPlaybackException p0);
        
        void d();
        
        void f(final long p0, final ImmutableList<t> p1);
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.TYPE_USE })
    public @interface RtspState {
    }
    
    public interface SessionInfoListener
    {
        void b(final String p0, final Throwable p1);
        
        void g(final q p0, final ImmutableList<l> p1);
    }
    
    private final class b implements Runnable, Closeable
    {
        private final Handler a;
        private final long b;
        private boolean c;
        final RtspClient d;
        
        public b(final RtspClient d, final long b) {
            this.d = d;
            this.b = b;
            this.a = Util.w();
        }
        
        public void a() {
            if (this.c) {
                return;
            }
            this.c = true;
            this.a.postDelayed((Runnable)this, this.b);
        }
        
        @Override
        public void close() {
            this.c = false;
            this.a.removeCallbacks((Runnable)this);
        }
        
        @Override
        public void run() {
            RtspClient.e(this.d).e(RtspClient.i(this.d), RtspClient.W(this.d));
            this.a.postDelayed((Runnable)this, this.b);
        }
    }
    
    private final class c implements MessageListener
    {
        private final Handler a;
        final RtspClient b;
        
        public c(final RtspClient b) {
            this.b = b;
            this.a = Util.w();
        }
        
        public static void d(final c c, final List list) {
            c.h(list);
        }
        
        private void e(final List<String> list) {
            RtspClient.m0(this.b, list);
            if (RtspMessageUtil.e(list)) {
                this.g(list);
            }
            else {
                this.f(list);
            }
        }
        
        private void f(final List<String> list) {
            RtspClient.e(this.b).d(Integer.parseInt(Assertions.e(RtspMessageUtil.k(list).c.d("CSeq"))));
        }
        
        private void g(final List<String> list) {
            final p l = RtspMessageUtil.l(list);
            final int int1 = Integer.parseInt(Assertions.e(l.b.d("CSeq")));
            final RtspRequest rtspRequest = (RtspRequest)RtspClient.l0(this.b).get(int1);
            if (rtspRequest == null) {
                return;
            }
            RtspClient.l0(this.b).remove(int1);
            final int b = rtspRequest.b;
            try {
                final int a = l.a;
                if (a != 200) {
                    int i = 0;
                    if (a != 401) {
                        if (a == 301 || a == 302) {
                            if (RtspClient.a(this.b) != -1) {
                                RtspClient.d(this.b, 0);
                            }
                            final String d = l.b.d("Location");
                            if (d == null) {
                                RtspClient.h(this.b).b("Redirection without new location.", null);
                            }
                            else {
                                final Uri parse = Uri.parse(d);
                                RtspClient.j(this.b, RtspMessageUtil.p(parse));
                                RtspClient.g0(this.b, RtspMessageUtil.n(parse));
                                RtspClient.e(this.b).c(RtspClient.i(this.b), RtspClient.W(this.b));
                            }
                            return;
                        }
                    }
                    else if (RtspClient.f0(this.b) != null && !RtspClient.k(this.b)) {
                        final ImmutableList<String> e = l.b.e("WWW-Authenticate");
                        if (!((AbstractCollection)e).isEmpty()) {
                            while (i < ((AbstractCollection)e).size()) {
                                RtspClient.e0(this.b, RtspMessageUtil.o(e.get(i)));
                                if (RtspClient.c0(this.b).a == 2) {
                                    break;
                                }
                                ++i;
                            }
                            RtspClient.e(this.b).b();
                            RtspClient.l(this.b, true);
                            return;
                        }
                        throw ParserException.createForMalformedManifest("Missing WWW-Authenticate header in a 401 response.", null);
                    }
                    final RtspClient b2 = this.b;
                    final StringBuilder sb = new StringBuilder();
                    sb.append(RtspMessageUtil.t(b));
                    sb.append(" ");
                    sb.append(l.a);
                    RtspClient.i0(b2, new RtspMediaSource.RtspPlaybackException(sb.toString()));
                    return;
                }
                switch (b) {
                    default: {
                        throw new IllegalStateException();
                    }
                    case 10: {
                        final String d2 = l.b.d("Session");
                        final String d3 = l.b.d("Transport");
                        if (d2 != null && d3 != null) {
                            this.m(new s(l.a, RtspMessageUtil.m(d2), d3));
                            break;
                        }
                        throw ParserException.createForMalformedManifest("Missing mandatory session or transport header", null);
                    }
                    case 6: {
                        final String d4 = l.b.d("Range");
                        q q;
                        if (d4 == null) {
                            q = com.google.android.exoplayer2.source.rtsp.q.c;
                        }
                        else {
                            q = com.google.android.exoplayer2.source.rtsp.q.d(d4);
                        }
                        ImmutableList list2;
                        try {
                            final String d5 = l.b.d("RTP-Info");
                            if (d5 == null) {
                                list2 = ImmutableList.of();
                            }
                            else {
                                list2 = t.a(d5, RtspClient.i(this.b));
                            }
                        }
                        catch (final ParserException ex) {
                            list2 = ImmutableList.of();
                        }
                        this.l(new o(l.a, q, (List<t>)list2));
                        break;
                    }
                    case 5: {
                        this.k();
                        break;
                    }
                    case 4: {
                        this.j(new n(a, (List<Integer>)RtspMessageUtil.j(l.b.d("Public"))));
                        break;
                    }
                    case 2: {
                        this.i(new g(a, u.b(l.c)));
                    }
                    case 1:
                    case 3:
                    case 7:
                    case 8:
                    case 9:
                    case 11:
                    case 12: {
                        break;
                    }
                }
            }
            catch (final ParserException ex2) {
                RtspClient.i0(this.b, new RtspMediaSource.RtspPlaybackException(ex2));
            }
        }
        
        private void h(final List list) {
            this.e(list);
        }
        
        private void i(final g g) {
            q q = com.google.android.exoplayer2.source.rtsp.q.c;
            final String s = (String)g.b.a.get((Object)"range");
            if (s != null) {
                try {
                    q = com.google.android.exoplayer2.source.rtsp.q.d(s);
                }
                catch (final ParserException ex) {
                    RtspClient.h(this.b).b("SDP format error.", ex);
                    return;
                }
            }
            final ImmutableList u = RtspClient.u(g.b, RtspClient.i(this.b));
            if (((AbstractCollection)u).isEmpty()) {
                RtspClient.h(this.b).b("No playable track.", null);
                return;
            }
            RtspClient.h(this.b).g(q, (ImmutableList<l>)u);
            RtspClient.E(this.b, true);
        }
        
        private void j(final n n) {
            if (RtspClient.r(this.b) != null) {
                return;
            }
            if (RtspClient.t((List)n.b)) {
                RtspClient.e(this.b).c(RtspClient.i(this.b), RtspClient.W(this.b));
            }
            else {
                RtspClient.h(this.b).b("DESCRIBE not supported.", null);
            }
        }
        
        private void k() {
            Assertions.g(RtspClient.a(this.b) == 2);
            RtspClient.d(this.b, 1);
            RtspClient.O(this.b, false);
            if (RtspClient.L(this.b) != -9223372036854775807L) {
                final RtspClient b = this.b;
                b.S0(Util.f1(RtspClient.L(b)));
            }
        }
        
        private void l(final o o) {
            final int a = RtspClient.a(this.b);
            boolean b = true;
            if (a != 1) {
                b = false;
            }
            Assertions.g(b);
            RtspClient.d(this.b, 2);
            if (RtspClient.r(this.b) == null) {
                final RtspClient b2 = this.b;
                RtspClient.s(b2, b2.new b(30000L));
                RtspClient.r(this.b).a();
            }
            RtspClient.M(this.b, -9223372036854775807L);
            RtspClient.V(this.b).f(Util.C0(o.b.a), o.c);
        }
        
        private void m(final s s) {
            Assertions.g(RtspClient.a(this.b) != -1);
            RtspClient.d(this.b, 1);
            RtspClient.Z(this.b, s.b.a);
            RtspClient.F(this.b);
        }
        
        @Override
        public void c(final List<String> list) {
            this.a.post((Runnable)new f(this, list));
        }
    }
    
    private final class d
    {
        private int a;
        private RtspRequest b;
        final RtspClient c;
        
        private d(final RtspClient c) {
            this.c = c;
        }
        
        d(final RtspClient rtspClient, final RtspClient$a object) {
            this(rtspClient);
        }
        
        private RtspRequest a(final int n, String s, final Map<String, String> map, final Uri uri) {
            s = (String)new RtspHeaders.Builder(RtspClient.a0(this.c), s, this.a++);
            if (RtspClient.c0(this.c) != null) {
                Assertions.i(RtspClient.f0(this.c));
                try {
                    ((RtspHeaders.Builder)s).b("Authorization", RtspClient.c0(this.c).a(RtspClient.f0(this.c), uri, n));
                }
                catch (final ParserException ex) {
                    RtspClient.i0(this.c, new RtspMediaSource.RtspPlaybackException(ex));
                }
            }
            ((RtspHeaders.Builder)s).d(map);
            return new RtspRequest(uri, n, ((RtspHeaders.Builder)s).e(), "");
        }
        
        private void h(final RtspRequest b) {
            final int int1 = Integer.parseInt(Assertions.e(b.c.d("CSeq")));
            Assertions.g(RtspClient.l0(this.c).get(int1) == null);
            RtspClient.l0(this.c).append(int1, (Object)b);
            final ImmutableList<String> q = RtspMessageUtil.q(b);
            RtspClient.m0(this.c, (List)q);
            RtspClient.c(this.c).i((List<String>)q);
            this.b = b;
        }
        
        private void i(final p p) {
            final ImmutableList<String> r = RtspMessageUtil.r(p);
            RtspClient.m0(this.c, (List)r);
            RtspClient.c(this.c).i((List<String>)r);
        }
        
        public void b() {
            Assertions.i(this.b);
            final ImmutableListMultimap<String, String> b = this.b.c.b();
            final HashMap hashMap = new HashMap();
            for (final String s : ((Multimap)b).keySet()) {
                if (!s.equals("CSeq") && !s.equals("User-Agent") && !s.equals("Session")) {
                    if (s.equals("Authorization")) {
                        continue;
                    }
                    hashMap.put(s, Iterables.h((Iterable)((Multimap)b).get((Object)s)));
                }
            }
            this.h(this.a(this.b.b, RtspClient.W(this.c), hashMap, this.b.a));
        }
        
        public void c(final Uri uri, final String s) {
            this.h(this.a(2, s, (Map<String, String>)ImmutableMap.of(), uri));
        }
        
        public void d(final int n) {
            this.i(new p(405, new RtspHeaders.Builder(RtspClient.a0(this.c), RtspClient.W(this.c), n).e()));
            this.a = Math.max(this.a, n + 1);
        }
        
        public void e(final Uri uri, final String s) {
            this.h(this.a(4, s, (Map<String, String>)ImmutableMap.of(), uri));
        }
        
        public void f(final Uri uri, final String s) {
            Assertions.g(RtspClient.a(this.c) == 2);
            this.h(this.a(5, s, (Map<String, String>)ImmutableMap.of(), uri));
            RtspClient.O(this.c, true);
        }
        
        public void g(final Uri uri, final long n, final String s) {
            final int a = RtspClient.a(this.c);
            boolean b = true;
            if (a != 1) {
                b = (RtspClient.a(this.c) == 2 && b);
            }
            Assertions.g(b);
            this.h(this.a(6, s, (Map<String, String>)ImmutableMap.of((Object)"Range", (Object)q.b(n)), uri));
        }
        
        public void j(final Uri uri, final String s, final String s2) {
            RtspClient.d(this.c, 0);
            this.h(this.a(10, s2, (Map<String, String>)ImmutableMap.of((Object)"Transport", (Object)s), uri));
        }
        
        public void k(final Uri uri, final String s) {
            if (RtspClient.a(this.c) != -1) {
                if (RtspClient.a(this.c) != 0) {
                    RtspClient.d(this.c, 0);
                    this.h(this.a(12, s, (Map<String, String>)ImmutableMap.of(), uri));
                }
            }
        }
    }
}
