// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.LoadEventInfo;
import android.os.SystemClock;
import android.os.Message;
import android.os.Handler;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import android.util.Pair;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.Log;
import java.util.Iterator;
import com.google.android.exoplayer2.util.Util;
import android.media.NotProvisionedException;
import com.google.android.exoplayer2.util.Consumer;
import java.util.Collections;
import com.google.android.exoplayer2.util.Assertions;
import android.os.Looper;
import com.google.android.exoplayer2.decoder.CryptoConfig;
import android.os.HandlerThread;
import java.util.UUID;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.util.CopyOnWriteMultiset;
import java.util.HashMap;
import java.util.List;

class DefaultDrmSession implements DrmSession
{
    public final List<DrmInitData.SchemeData> a;
    private final ExoMediaDrm b;
    private final ProvisioningManager c;
    private final ReferenceCountListener d;
    private final int e;
    private final boolean f;
    private final boolean g;
    private final HashMap<String, String> h;
    private final CopyOnWriteMultiset<DrmSessionEventListener.EventDispatcher> i;
    private final LoadErrorHandlingPolicy j;
    private final PlayerId k;
    final MediaDrmCallback l;
    final UUID m;
    final c n;
    private int o;
    private int p;
    private HandlerThread q;
    private a r;
    private CryptoConfig s;
    private DrmSessionException t;
    private byte[] u;
    private byte[] v;
    private ExoMediaDrm.KeyRequest w;
    private ExoMediaDrm.ProvisionRequest x;
    
    public DefaultDrmSession(final UUID m, final ExoMediaDrm b, final ProvisioningManager c, final ReferenceCountListener d, final List<DrmInitData.SchemeData> list, final int e, final boolean f, final boolean g, final byte[] v, final HashMap<String, String> h, final MediaDrmCallback l, final Looper looper, final LoadErrorHandlingPolicy j, final PlayerId k) {
        if (e == 1 || e == 3) {
            Assertions.e(v);
        }
        this.m = m;
        this.c = c;
        this.d = d;
        this.b = b;
        this.e = e;
        this.f = f;
        this.g = g;
        if (v != null) {
            this.v = v;
            this.a = null;
        }
        else {
            this.a = Collections.unmodifiableList((List<? extends DrmInitData.SchemeData>)Assertions.e((List<? extends T>)list));
        }
        this.h = h;
        this.l = l;
        this.i = new CopyOnWriteMultiset<DrmSessionEventListener.EventDispatcher>();
        this.j = j;
        this.k = k;
        this.o = 2;
        this.n = new c(looper);
    }
    
    private void C(final Object o, final Object o2) {
        if (o == this.x) {
            if (this.o == 2 || this.s()) {
                this.x = null;
                if (o2 instanceof Exception) {
                    this.c.a((Exception)o2, false);
                    return;
                }
                try {
                    this.b.h((byte[])o2);
                    this.c.c();
                }
                catch (final Exception ex) {
                    this.c.a(ex, true);
                }
            }
        }
    }
    
    private boolean D() {
        if (this.s()) {
            return true;
        }
        try {
            final byte[] e = this.b.e();
            this.u = e;
            this.b.c(e, this.k);
            this.s = this.b.j(this.u);
            this.o = 3;
            this.o(new com.google.android.exoplayer2.drm.b(3));
            Assertions.e(this.u);
            return true;
        }
        catch (final Exception ex) {
            this.v(ex, 1);
        }
        catch (final NotProvisionedException ex2) {
            this.c.b(this);
        }
        return false;
    }
    
    private void E(final byte[] array, final int n, final boolean b) {
        try {
            this.w = this.b.n(array, this.a, n, this.h);
            Util.j(this.r).b(1, Assertions.e(this.w), b);
        }
        catch (final Exception ex) {
            this.x(ex, true);
        }
    }
    
    private boolean G() {
        try {
            this.b.f(this.u, this.v);
            return true;
        }
        catch (final Exception ex) {
            this.v(ex, 1);
            return false;
        }
    }
    
    public static void j(final Exception ex, final DrmSessionEventListener.EventDispatcher eventDispatcher) {
        t(ex, eventDispatcher);
    }
    
    public static void k(final int n, final DrmSessionEventListener.EventDispatcher eventDispatcher) {
        u(n, eventDispatcher);
    }
    
    static void l(final DefaultDrmSession defaultDrmSession, final Object o, final Object o2) {
        defaultDrmSession.C(o, o2);
    }
    
    static void m(final DefaultDrmSession defaultDrmSession, final Object o, final Object o2) {
        defaultDrmSession.w(o, o2);
    }
    
    static LoadErrorHandlingPolicy n(final DefaultDrmSession defaultDrmSession) {
        return defaultDrmSession.j;
    }
    
    private void o(final Consumer<DrmSessionEventListener.EventDispatcher> consumer) {
        final Iterator<DrmSessionEventListener.EventDispatcher> iterator = this.i.elementSet().iterator();
        while (iterator.hasNext()) {
            consumer.accept(iterator.next());
        }
    }
    
    private void p(final boolean b) {
        if (this.g) {
            return;
        }
        final byte[] array = Util.j(this.u);
        final int e = this.e;
        if (e != 0 && e != 1) {
            if (e != 2) {
                if (e == 3) {
                    Assertions.e(this.v);
                    Assertions.e(this.u);
                    this.E(this.v, 3, b);
                }
            }
            else if (this.v == null || this.G()) {
                this.E(array, 2, b);
            }
        }
        else if (this.v == null) {
            this.E(array, 1, b);
        }
        else if (this.o == 4 || this.G()) {
            final long q = this.q();
            if (this.e == 0 && q <= 60L) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Offline license has expired or will expire soon. Remaining seconds: ");
                sb.append(q);
                Log.b("DefaultDrmSession", sb.toString());
                this.E(array, 2, b);
            }
            else if (q <= 0L) {
                this.v(new KeysExpiredException(), 2);
            }
            else {
                this.o = 4;
                this.o(com.google.android.exoplayer2.drm.f.a);
            }
        }
    }
    
    private long q() {
        if (!C.d.equals(this.m)) {
            return Long.MAX_VALUE;
        }
        final Pair pair = Assertions.e(WidevineUtil.b(this));
        return Math.min((long)pair.first, (long)pair.second);
    }
    
    private boolean s() {
        final int o = this.o;
        return o == 3 || o == 4;
    }
    
    private static void t(final Exception ex, final DrmSessionEventListener.EventDispatcher eventDispatcher) {
        eventDispatcher.l(ex);
    }
    
    private static void u(final int n, final DrmSessionEventListener.EventDispatcher eventDispatcher) {
        eventDispatcher.k(n);
    }
    
    private void v(final Exception ex, final int n) {
        this.t = new DrmSessionException(ex, DrmUtil.a(ex, n));
        Log.d("DefaultDrmSession", "DRM session error", ex);
        this.o(new com.google.android.exoplayer2.drm.c(ex));
        if (this.o != 4) {
            this.o = 1;
        }
    }
    
    private void w(final Object o, final Object o2) {
        if (o == this.w) {
            if (this.s()) {
                this.w = null;
                if (o2 instanceof Exception) {
                    this.x((Exception)o2, false);
                    return;
                }
                try {
                    final byte[] array = (byte[])o2;
                    if (this.e == 3) {
                        this.b.m(Util.j(this.v), array);
                        this.o(com.google.android.exoplayer2.drm.e.a);
                    }
                    else {
                        final byte[] m = this.b.m(this.u, array);
                        final int e = this.e;
                        if ((e == 2 || (e == 0 && this.v != null)) && m != null && m.length != 0) {
                            this.v = m;
                        }
                        this.o = 4;
                        this.o(com.google.android.exoplayer2.drm.d.a);
                    }
                }
                catch (final Exception ex) {
                    this.x(ex, true);
                }
            }
        }
    }
    
    private void x(final Exception ex, final boolean b) {
        if (ex instanceof NotProvisionedException) {
            this.c.b(this);
        }
        else {
            int n;
            if (b) {
                n = 1;
            }
            else {
                n = 2;
            }
            this.v(ex, n);
        }
    }
    
    private void y() {
        if (this.e == 0 && this.o == 4) {
            Util.j(this.u);
            this.p(false);
        }
    }
    
    public void A() {
        if (this.D()) {
            this.p(true);
        }
    }
    
    public void B(final Exception ex, final boolean b) {
        int n;
        if (b) {
            n = 1;
        }
        else {
            n = 3;
        }
        this.v(ex, n);
    }
    
    public void F() {
        this.x = this.b.d();
        Util.j(this.r).b(0, Assertions.e(this.x), true);
    }
    
    @Override
    public final DrmSessionException a() {
        DrmSessionException t;
        if (this.o == 1) {
            t = this.t;
        }
        else {
            t = null;
        }
        return t;
    }
    
    @Override
    public void b(final DrmSessionEventListener.EventDispatcher eventDispatcher) {
        final int p = this.p;
        boolean b = false;
        if (p < 0) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Session reference count less than zero: ");
            sb.append(this.p);
            Log.c("DefaultDrmSession", sb.toString());
            this.p = 0;
        }
        if (eventDispatcher != null) {
            this.i.a(eventDispatcher);
        }
        if (++this.p == 1) {
            if (this.o == 2) {
                b = true;
            }
            Assertions.g(b);
            (this.q = new HandlerThread("ExoPlayer:DrmRequestHandler")).start();
            this.r = new a(this.q.getLooper());
            if (this.D()) {
                this.p(true);
            }
        }
        else if (eventDispatcher != null && this.s() && this.i.count(eventDispatcher) == 1) {
            eventDispatcher.k(this.o);
        }
        this.d.a(this, this.p);
    }
    
    @Override
    public void c(final DrmSessionEventListener.EventDispatcher eventDispatcher) {
        int p = this.p;
        if (p <= 0) {
            Log.c("DefaultDrmSession", "release() called on a session that's already fully released.");
            return;
        }
        --p;
        if ((this.p = p) == 0) {
            this.o = 0;
            Util.j(this.n).removeCallbacksAndMessages((Object)null);
            Util.j(this.r).c();
            this.r = null;
            Util.j(this.q).quit();
            this.q = null;
            this.s = null;
            this.t = null;
            this.w = null;
            this.x = null;
            final byte[] u = this.u;
            if (u != null) {
                this.b.l(u);
                this.u = null;
            }
        }
        if (eventDispatcher != null) {
            this.i.b(eventDispatcher);
            if (this.i.count(eventDispatcher) == 0) {
                eventDispatcher.m();
            }
        }
        this.d.b(this, this.p);
    }
    
    @Override
    public final UUID d() {
        return this.m;
    }
    
    @Override
    public boolean e() {
        return this.f;
    }
    
    @Override
    public final CryptoConfig f() {
        return this.s;
    }
    
    @Override
    public final int getState() {
        return this.o;
    }
    
    @Override
    public Map<String, String> h() {
        final byte[] u = this.u;
        Map<String, String> b;
        if (u == null) {
            b = null;
        }
        else {
            b = this.b.b(u);
        }
        return b;
    }
    
    @Override
    public boolean i(final String s) {
        return this.b.k(Assertions.i(this.u), s);
    }
    
    public boolean r(final byte[] array) {
        return Arrays.equals(this.u, array);
    }
    
    public void z(final int n) {
        if (n == 2) {
            this.y();
        }
    }
    
    public interface ProvisioningManager
    {
        void a(final Exception p0, final boolean p1);
        
        void b(final DefaultDrmSession p0);
        
        void c();
    }
    
    public interface ReferenceCountListener
    {
        void a(final DefaultDrmSession p0, final int p1);
        
        void b(final DefaultDrmSession p0, final int p1);
    }
    
    public static final class UnexpectedDrmSessionException extends IOException
    {
        public UnexpectedDrmSessionException(final Throwable t) {
            super(t);
        }
    }
    
    private class a extends Handler
    {
        private boolean a;
        final DefaultDrmSession b;
        
        public a(final DefaultDrmSession b, final Looper looper) {
            this.b = b;
            super(looper);
        }
        
        private boolean a(final Message message, final MediaDrmCallbackException ex) {
            final b b = (b)message.obj;
            if (!b.b) {
                return false;
            }
            if (++b.e > DefaultDrmSession.n(this.b).b(3)) {
                return false;
            }
            final LoadEventInfo loadEventInfo = new LoadEventInfo(b.a, ex.dataSpec, ex.uriAfterRedirects, ex.responseHeaders, SystemClock.elapsedRealtime(), SystemClock.elapsedRealtime() - b.c, ex.bytesLoaded);
            final MediaLoadData mediaLoadData = new MediaLoadData(3);
            IOException ex2;
            if (ex.getCause() instanceof IOException) {
                ex2 = (IOException)ex.getCause();
            }
            else {
                ex2 = new UnexpectedDrmSessionException(ex.getCause());
            }
            final long a = DefaultDrmSession.n(this.b).a(new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, mediaLoadData, ex2, b.e));
            if (a == -9223372036854775807L) {
                return false;
            }
            synchronized (this) {
                if (!this.a) {
                    this.sendMessageDelayed(Message.obtain(message), a);
                    return true;
                }
                return false;
            }
        }
        
        void b(final int n, final Object o, final boolean b) {
            this.obtainMessage(n, (Object)new b(LoadEventInfo.a(), b, SystemClock.elapsedRealtime(), o)).sendToTarget();
        }
        
        public void c() {
            synchronized (this) {
                this.removeCallbacksAndMessages((Object)null);
                this.a = true;
            }
        }
        
        public void handleMessage(final Message message) {
            final b b = (b)message.obj;
            Object o = null;
            try {
                final int what = message.what;
                if (what != 0) {
                    if (what != 1) {
                        throw new RuntimeException();
                    }
                    final DefaultDrmSession b2 = this.b;
                    o = b2.l.b(b2.m, (ExoMediaDrm.KeyRequest)b.d);
                }
                else {
                    final DefaultDrmSession b3 = this.b;
                    o = b3.l.a(b3.m, (ExoMediaDrm.ProvisionRequest)b.d);
                }
            }
            catch (final Exception o) {
                Log.j("DefaultDrmSession", "Key/provisioning request produced an unexpected exception. Not retrying.", (Throwable)o);
            }
            catch (final MediaDrmCallbackException ex) {
                o = ex;
                if (this.a(message, ex)) {
                    return;
                }
            }
            DefaultDrmSession.n(this.b).d(b.a);
            synchronized (this) {
                if (!this.a) {
                    this.b.n.obtainMessage(message.what, (Object)Pair.create(b.d, o)).sendToTarget();
                }
            }
        }
    }
    
    private static final class b
    {
        public final long a;
        public final boolean b;
        public final long c;
        public final Object d;
        public int e;
        
        public b(final long a, final boolean b, final long c, final Object d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }
    }
    
    private class c extends Handler
    {
        final DefaultDrmSession a;
        
        public c(final DefaultDrmSession a, final Looper looper) {
            this.a = a;
            super(looper);
        }
        
        public void handleMessage(final Message message) {
            final Pair pair = (Pair)message.obj;
            final Object first = pair.first;
            final Object second = pair.second;
            final int what = message.what;
            if (what != 0) {
                if (what == 1) {
                    DefaultDrmSession.m(this.a, first, second);
                }
            }
            else {
                DefaultDrmSession.l(this.a, first, second);
            }
        }
    }
}
