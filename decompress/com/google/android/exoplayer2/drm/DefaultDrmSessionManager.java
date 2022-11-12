// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.drm;

import android.os.SystemClock;
import java.util.HashSet;
import android.os.Message;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.google.common.collect.ImmutableList;
import android.media.ResourceBusyException;
import java.util.Iterator;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.Format;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Collection;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.analytics.PlayerId;
import android.os.Handler;
import android.os.Looper;
import java.util.Set;
import java.util.List;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import java.util.HashMap;
import java.util.UUID;

public class DefaultDrmSessionManager implements DrmSessionManager
{
    private final UUID c;
    private final ExoMediaDrm.Provider d;
    private final MediaDrmCallback e;
    private final HashMap<String, String> f;
    private final boolean g;
    private final int[] h;
    private final boolean i;
    private final e j;
    private final LoadErrorHandlingPolicy k;
    private final f l;
    private final long m;
    private final List<DefaultDrmSession> n;
    private final Set<d> o;
    private final Set<DefaultDrmSession> p;
    private int q;
    private ExoMediaDrm r;
    private DefaultDrmSession s;
    private DefaultDrmSession t;
    private Looper u;
    private Handler v;
    private int w;
    private byte[] x;
    private PlayerId y;
    volatile c z;
    
    private DefaultDrmSessionManager(final UUID c, final ExoMediaDrm.Provider d, final MediaDrmCallback e, final HashMap<String, String> f, final boolean g, final int[] h, final boolean i, final LoadErrorHandlingPolicy k, final long m) {
        Assertions.e(c);
        Assertions.b(C.b.equals(c) ^ true, "Use C.CLEARKEY_UUID instead");
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
        this.k = k;
        this.j = new e();
        this.l = new f(null);
        this.w = 0;
        this.n = new ArrayList<DefaultDrmSession>();
        this.o = Sets.h();
        this.p = Sets.h();
        this.m = m;
    }
    
    DefaultDrmSessionManager(final UUID uuid, final ExoMediaDrm.Provider provider, final MediaDrmCallback mediaDrmCallback, final HashMap hashMap, final boolean b, final int[] array, final boolean b2, final LoadErrorHandlingPolicy loadErrorHandlingPolicy, final long n, final DefaultDrmSessionManager$a object) {
        this(uuid, provider, mediaDrmCallback, hashMap, b, array, b2, loadErrorHandlingPolicy, n);
    }
    
    private void A(final Looper looper) {
        if (this.z == null) {
            this.z = new c(looper);
        }
    }
    
    private void B() {
        if (this.r != null && this.q == 0 && this.n.isEmpty() && this.o.isEmpty()) {
            Assertions.e(this.r).release();
            this.r = null;
        }
    }
    
    private void C() {
        final UnmodifiableIterator iterator = ImmutableSet.copyOf((Collection)this.p).iterator();
        while (((Iterator)iterator).hasNext()) {
            ((DrmSession)((Iterator)iterator).next()).c(null);
        }
    }
    
    private void D() {
        final UnmodifiableIterator iterator = ImmutableSet.copyOf((Collection)this.o).iterator();
        while (((Iterator)iterator).hasNext()) {
            ((d)((Iterator)iterator).next()).release();
        }
    }
    
    private void F(final DrmSession drmSession, final DrmSessionEventListener.EventDispatcher eventDispatcher) {
        drmSession.c(eventDispatcher);
        if (this.m != -9223372036854775807L) {
            drmSession.c(null);
        }
    }
    
    static DefaultDrmSession e(final DefaultDrmSessionManager defaultDrmSessionManager) {
        return defaultDrmSessionManager.t;
    }
    
    static DefaultDrmSession f(final DefaultDrmSessionManager defaultDrmSessionManager, final DefaultDrmSession t) {
        return defaultDrmSessionManager.t = t;
    }
    
    static e g(final DefaultDrmSessionManager defaultDrmSessionManager) {
        return defaultDrmSessionManager.j;
    }
    
    static void h(final DefaultDrmSessionManager defaultDrmSessionManager) {
        defaultDrmSessionManager.B();
    }
    
    static Set i(final DefaultDrmSessionManager defaultDrmSessionManager) {
        return defaultDrmSessionManager.o;
    }
    
    static Looper j(final DefaultDrmSessionManager defaultDrmSessionManager) {
        return defaultDrmSessionManager.u;
    }
    
    static DrmSession k(final DefaultDrmSessionManager defaultDrmSessionManager, final Looper looper, final DrmSessionEventListener.EventDispatcher eventDispatcher, final Format format, final boolean b) {
        return defaultDrmSessionManager.s(looper, eventDispatcher, format, b);
    }
    
    static List l(final DefaultDrmSessionManager defaultDrmSessionManager) {
        return defaultDrmSessionManager.n;
    }
    
    static long m(final DefaultDrmSessionManager defaultDrmSessionManager) {
        return defaultDrmSessionManager.m;
    }
    
    static Set n(final DefaultDrmSessionManager defaultDrmSessionManager) {
        return defaultDrmSessionManager.p;
    }
    
    static Handler o(final DefaultDrmSessionManager defaultDrmSessionManager) {
        return defaultDrmSessionManager.v;
    }
    
    static int p(final DefaultDrmSessionManager defaultDrmSessionManager) {
        return defaultDrmSessionManager.q;
    }
    
    static DefaultDrmSession q(final DefaultDrmSessionManager defaultDrmSessionManager) {
        return defaultDrmSessionManager.s;
    }
    
    static DefaultDrmSession r(final DefaultDrmSessionManager defaultDrmSessionManager, final DefaultDrmSession s) {
        return defaultDrmSessionManager.s = s;
    }
    
    private DrmSession s(final Looper looper, final DrmSessionEventListener.EventDispatcher eventDispatcher, final Format format, final boolean b) {
        this.A(looper);
        final DrmInitData z = format.z;
        if (z == null) {
            return this.z(MimeTypes.k(format.w), b);
        }
        final byte[] x = this.x;
        final DefaultDrmSession defaultDrmSession = null;
        List<DrmInitData.SchemeData> x2;
        if (x == null) {
            if ((x2 = x(Assertions.e(z), this.c, false)).isEmpty()) {
                final MissingSchemeDataException ex = new MissingSchemeDataException(this.c, null);
                Log.d("DefaultDrmSessionMgr", "DRM error", ex);
                if (eventDispatcher != null) {
                    eventDispatcher.l(ex);
                }
                return new ErrorStateDrmSession(new DrmSession.DrmSessionException(ex, 6003));
            }
        }
        else {
            x2 = null;
        }
        DefaultDrmSession t;
        if (!this.g) {
            t = this.t;
        }
        else {
            final Iterator<DefaultDrmSession> iterator = this.n.iterator();
            do {
                t = defaultDrmSession;
                if (!iterator.hasNext()) {
                    break;
                }
                t = iterator.next();
            } while (!Util.c(t.a, x2));
        }
        if (t == null) {
            t = this.w(x2, false, eventDispatcher, b);
            if (!this.g) {
                this.t = t;
            }
            this.n.add(t);
        }
        else {
            t.b(eventDispatcher);
        }
        return t;
    }
    
    private static boolean t(final DrmSession drmSession) {
        final int state = drmSession.getState();
        final boolean b = true;
        if (state == 1) {
            boolean b2 = b;
            if (Util.a < 19) {
                return b2;
            }
            if (Assertions.e(drmSession.a()).getCause() instanceof ResourceBusyException) {
                b2 = b;
                return b2;
            }
        }
        return false;
    }
    
    private boolean u(final DrmInitData drmInitData) {
        final byte[] x = this.x;
        boolean b = true;
        if (x != null) {
            return true;
        }
        if (x(drmInitData, this.c, true).isEmpty()) {
            if (drmInitData.d != 1 || !drmInitData.e(0).d(C.b)) {
                return false;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("DrmInitData only contains common PSSH SchemeData. Assuming support for: ");
            sb.append(this.c);
            Log.i("DefaultDrmSessionMgr", sb.toString());
        }
        final String c = drmInitData.c;
        if (c == null || "cenc".equals(c)) {
            return true;
        }
        if ("cbcs".equals(c)) {
            if (Util.a < 25) {
                b = false;
            }
            return b;
        }
        return !"cbc1".equals(c) && !"cens".equals(c);
    }
    
    private DefaultDrmSession v(final List<DrmInitData.SchemeData> list, final boolean b, final DrmSessionEventListener.EventDispatcher eventDispatcher) {
        Assertions.e(this.r);
        final DefaultDrmSession defaultDrmSession = new DefaultDrmSession(this.c, this.r, (DefaultDrmSession.ProvisioningManager)this.j, (DefaultDrmSession.ReferenceCountListener)this.l, list, this.w, this.i | b, b, this.x, this.f, this.e, Assertions.e(this.u), this.k, Assertions.e(this.y));
        defaultDrmSession.b(eventDispatcher);
        if (this.m != -9223372036854775807L) {
            defaultDrmSession.b(null);
        }
        return defaultDrmSession;
    }
    
    private DefaultDrmSession w(final List<DrmInitData.SchemeData> list, final boolean b, final DrmSessionEventListener.EventDispatcher eventDispatcher, final boolean b2) {
        DefaultDrmSession defaultDrmSession2;
        final DefaultDrmSession defaultDrmSession = defaultDrmSession2 = this.v(list, b, eventDispatcher);
        if (t(defaultDrmSession)) {
            defaultDrmSession2 = defaultDrmSession;
            if (!this.p.isEmpty()) {
                this.C();
                this.F(defaultDrmSession, eventDispatcher);
                defaultDrmSession2 = this.v(list, b, eventDispatcher);
            }
        }
        DefaultDrmSession v = defaultDrmSession2;
        if (t(defaultDrmSession2)) {
            v = defaultDrmSession2;
            if (b2) {
                v = defaultDrmSession2;
                if (!this.o.isEmpty()) {
                    this.D();
                    if (!this.p.isEmpty()) {
                        this.C();
                    }
                    this.F(defaultDrmSession2, eventDispatcher);
                    v = this.v(list, b, eventDispatcher);
                }
            }
        }
        return v;
    }
    
    private static List<DrmInitData.SchemeData> x(final DrmInitData drmInitData, final UUID uuid, final boolean b) {
        final ArrayList list = new ArrayList(drmInitData.d);
        for (int i = 0; i < drmInitData.d; ++i) {
            final DrmInitData.SchemeData e = drmInitData.e(i);
            if ((e.d(uuid) || (C.c.equals(uuid) && e.d(C.b))) && (e.e != null || b)) {
                list.add(e);
            }
        }
        return list;
    }
    
    private void y(final Looper u) {
        synchronized (this) {
            final Looper u2 = this.u;
            if (u2 == null) {
                this.u = u;
                this.v = new Handler(u);
            }
            else {
                Assertions.g(u2 == u);
                Assertions.e(this.v);
            }
        }
    }
    
    private DrmSession z(final int n, final boolean b) {
        final ExoMediaDrm exoMediaDrm = Assertions.e(this.r);
        if ((exoMediaDrm.i() != 2 || !FrameworkCryptoConfig.d) && Util.z0(this.h, n) != -1 && exoMediaDrm.i() != 1) {
            final DefaultDrmSession s = this.s;
            if (s == null) {
                final DefaultDrmSession w = this.w((List<DrmInitData.SchemeData>)ImmutableList.of(), true, null, b);
                this.n.add(w);
                this.s = w;
            }
            else {
                s.b(null);
            }
            return this.s;
        }
        return null;
    }
    
    public void E(final int w, final byte[] x) {
        Assertions.g(this.n.isEmpty());
        if (w == 1 || w == 3) {
            Assertions.e(x);
        }
        this.w = w;
        this.x = x;
    }
    
    @Override
    public int a(final Format format) {
        int i = Assertions.e(this.r).i();
        final DrmInitData z = format.z;
        if (z == null) {
            if (Util.z0(this.h, MimeTypes.k(format.w)) == -1) {
                i = 0;
            }
            return i;
        }
        if (!this.u(z)) {
            i = 1;
        }
        return i;
    }
    
    @Override
    public void b(final Looper looper, final PlayerId y) {
        this.y(looper);
        this.y = y;
    }
    
    @Override
    public DrmSession c(final DrmSessionEventListener.EventDispatcher eventDispatcher, final Format format) {
        Assertions.g(this.q > 0);
        Assertions.i(this.u);
        return this.s(this.u, eventDispatcher, format, true);
    }
    
    @Override
    public DrmSessionReference d(final DrmSessionEventListener.EventDispatcher eventDispatcher, final Format format) {
        Assertions.g(this.q > 0);
        Assertions.i(this.u);
        final d d = new d(eventDispatcher);
        d.e(format);
        return d;
    }
    
    @Override
    public final void prepare() {
        if (this.q++ != 0) {
            return;
        }
        if (this.r == null) {
            (this.r = this.d.a(this.c)).g((ExoMediaDrm.OnEventListener)new b(null));
        }
        else if (this.m != -9223372036854775807L) {
            for (int i = 0; i < this.n.size(); ++i) {
                this.n.get(i).b(null);
            }
        }
    }
    
    @Override
    public final void release() {
        final int q = this.q - 1;
        this.q = q;
        if (q != 0) {
            return;
        }
        if (this.m != -9223372036854775807L) {
            final ArrayList list = new ArrayList((Collection<? extends E>)this.n);
            for (int i = 0; i < list.size(); ++i) {
                ((DefaultDrmSession)list.get(i)).c(null);
            }
        }
        this.D();
        this.B();
    }
    
    public static final class Builder
    {
        private final HashMap<String, String> a;
        private UUID b;
        private ExoMediaDrm.Provider c;
        private boolean d;
        private int[] e;
        private boolean f;
        private LoadErrorHandlingPolicy g;
        private long h;
        
        public Builder() {
            this.a = new HashMap<String, String>();
            this.b = C.d;
            this.c = FrameworkMediaDrm.d;
            this.g = new DefaultLoadErrorHandlingPolicy();
            this.e = new int[0];
            this.h = 300000L;
        }
        
        public DefaultDrmSessionManager a(final MediaDrmCallback mediaDrmCallback) {
            return new DefaultDrmSessionManager(this.b, this.c, mediaDrmCallback, this.a, this.d, this.e, this.f, this.g, this.h, null);
        }
        
        public Builder b(final boolean d) {
            this.d = d;
            return this;
        }
        
        public Builder c(final boolean f) {
            this.f = f;
            return this;
        }
        
        public Builder d(final int... array) {
            for (final int n : array) {
                boolean b = true;
                if (n != 2) {
                    b = (n == 1 && b);
                }
                Assertions.a(b);
            }
            this.e = array.clone();
            return this;
        }
        
        public Builder e(final UUID uuid, final ExoMediaDrm.Provider provider) {
            this.b = Assertions.e(uuid);
            this.c = Assertions.e(provider);
            return this;
        }
    }
    
    public static final class MissingSchemeDataException extends Exception
    {
        private MissingSchemeDataException(final UUID uuid) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Media does not support uuid: ");
            sb.append(uuid);
            super(sb.toString());
        }
        
        MissingSchemeDataException(final UUID uuid, final DefaultDrmSessionManager$a object) {
            this(uuid);
        }
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.TYPE_USE })
    public @interface Mode {
    }
    
    private class b implements OnEventListener
    {
        final DefaultDrmSessionManager a;
        
        private b(final DefaultDrmSessionManager a) {
            this.a = a;
        }
        
        b(final DefaultDrmSessionManager defaultDrmSessionManager, final DefaultDrmSessionManager$a object) {
            this(defaultDrmSessionManager);
        }
        
        @Override
        public void a(final ExoMediaDrm exoMediaDrm, final byte[] array, final int n, final int n2, final byte[] array2) {
            Assertions.e(this.a.z).obtainMessage(n, (Object)array).sendToTarget();
        }
    }
    
    private class c extends Handler
    {
        final DefaultDrmSessionManager a;
        
        public c(final DefaultDrmSessionManager a, final Looper looper) {
            this.a = a;
            super(looper);
        }
        
        public void handleMessage(final Message message) {
            final byte[] array = (byte[])message.obj;
            if (array == null) {
                return;
            }
            for (final DefaultDrmSession defaultDrmSession : DefaultDrmSessionManager.l(this.a)) {
                if (defaultDrmSession.r(array)) {
                    defaultDrmSession.z(message.what);
                    break;
                }
            }
        }
    }
    
    private class d implements DrmSessionReference
    {
        private final DrmSessionEventListener.EventDispatcher b;
        private DrmSession c;
        private boolean d;
        final DefaultDrmSessionManager e;
        
        public d(final DefaultDrmSessionManager e, final DrmSessionEventListener.EventDispatcher b) {
            this.e = e;
            this.b = b;
        }
        
        public static void c(final d d) {
            d.g();
        }
        
        public static void d(final d d, final Format format) {
            d.f(format);
        }
        
        private void f(final Format format) {
            if (DefaultDrmSessionManager.p(this.e) != 0) {
                if (!this.d) {
                    final DefaultDrmSessionManager e = this.e;
                    this.c = DefaultDrmSessionManager.k(e, Assertions.e(DefaultDrmSessionManager.j(e)), this.b, format, false);
                    DefaultDrmSessionManager.i(this.e).add(this);
                }
            }
        }
        
        private void g() {
            if (this.d) {
                return;
            }
            final DrmSession c = this.c;
            if (c != null) {
                c.c(this.b);
            }
            DefaultDrmSessionManager.i(this.e).remove(this);
            this.d = true;
        }
        
        public void e(final Format format) {
            Assertions.e(DefaultDrmSessionManager.o(this.e)).post((Runnable)new h(this, format));
        }
        
        @Override
        public void release() {
            Util.L0(Assertions.e(DefaultDrmSessionManager.o(this.e)), new g(this));
        }
    }
    
    private class e implements ProvisioningManager
    {
        private final Set<DefaultDrmSession> a;
        private DefaultDrmSession b;
        
        public e(final DefaultDrmSessionManager defaultDrmSessionManager) {
            this.a = new HashSet<DefaultDrmSession>();
        }
        
        @Override
        public void a(final Exception ex, final boolean b) {
            this.b = null;
            final ImmutableList copy = ImmutableList.copyOf((Collection)this.a);
            this.a.clear();
            final UnmodifiableIterator iterator = copy.iterator();
            while (((Iterator)iterator).hasNext()) {
                ((DefaultDrmSession)((Iterator)iterator).next()).B(ex, b);
            }
        }
        
        @Override
        public void b(final DefaultDrmSession b) {
            this.a.add(b);
            if (this.b != null) {
                return;
            }
            (this.b = b).F();
        }
        
        @Override
        public void c() {
            this.b = null;
            final ImmutableList copy = ImmutableList.copyOf((Collection)this.a);
            this.a.clear();
            final UnmodifiableIterator iterator = copy.iterator();
            while (((Iterator)iterator).hasNext()) {
                ((DefaultDrmSession)((Iterator)iterator).next()).A();
            }
        }
        
        public void d(DefaultDrmSession b) {
            this.a.remove(b);
            if (this.b == b) {
                this.b = null;
                if (!this.a.isEmpty()) {
                    b = this.a.iterator().next();
                    (this.b = b).F();
                }
            }
        }
    }
    
    private class f implements ReferenceCountListener
    {
        final DefaultDrmSessionManager a;
        
        private f(final DefaultDrmSessionManager a) {
            this.a = a;
        }
        
        f(final DefaultDrmSessionManager defaultDrmSessionManager, final DefaultDrmSessionManager$a object) {
            this(defaultDrmSessionManager);
        }
        
        public static void c(final DefaultDrmSession defaultDrmSession) {
            d(defaultDrmSession);
        }
        
        private static void d(final DefaultDrmSession defaultDrmSession) {
            defaultDrmSession.c(null);
        }
        
        @Override
        public void a(final DefaultDrmSession defaultDrmSession, final int n) {
            if (DefaultDrmSessionManager.m(this.a) != -9223372036854775807L) {
                DefaultDrmSessionManager.n(this.a).remove(defaultDrmSession);
                Assertions.e(DefaultDrmSessionManager.o(this.a)).removeCallbacksAndMessages((Object)defaultDrmSession);
            }
        }
        
        @Override
        public void b(final DefaultDrmSession defaultDrmSession, final int n) {
            if (n == 1 && DefaultDrmSessionManager.p(this.a) > 0 && DefaultDrmSessionManager.m(this.a) != -9223372036854775807L) {
                DefaultDrmSessionManager.n(this.a).add(defaultDrmSession);
                Assertions.e(DefaultDrmSessionManager.o(this.a)).postAtTime((Runnable)new i(defaultDrmSession), (Object)defaultDrmSession, SystemClock.uptimeMillis() + DefaultDrmSessionManager.m(this.a));
            }
            else if (n == 0) {
                DefaultDrmSessionManager.l(this.a).remove(defaultDrmSession);
                if (DefaultDrmSessionManager.q(this.a) == defaultDrmSession) {
                    DefaultDrmSessionManager.r(this.a, null);
                }
                if (DefaultDrmSessionManager.e(this.a) == defaultDrmSession) {
                    DefaultDrmSessionManager.f(this.a, null);
                }
                DefaultDrmSessionManager.g(this.a).d(defaultDrmSession);
                if (DefaultDrmSessionManager.m(this.a) != -9223372036854775807L) {
                    Assertions.e(DefaultDrmSessionManager.o(this.a)).removeCallbacksAndMessages((Object)defaultDrmSession);
                    DefaultDrmSessionManager.n(this.a).remove(defaultDrmSession);
                }
            }
            DefaultDrmSessionManager.h(this.a);
        }
    }
}
