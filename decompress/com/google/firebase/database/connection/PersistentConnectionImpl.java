// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.connection;

import com.google.firebase.database.util.GAuthToken;
import java.util.Collections;
import java.util.Collection;
import com.google.android.gms.tasks.OnFailureListener;
import r4.a;
import com.google.android.gms.tasks.OnSuccessListener;
import java.util.concurrent.Executor;
import r4.b;
import com.google.android.gms.tasks.Tasks;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.TimeUnit;
import java.util.Iterator;
import r4.c;
import com.google.firebase.database.logging.Logger;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.HashMap;
import com.google.firebase.database.connection.util.RetryHelper;
import com.google.firebase.database.logging.LogWrapper;
import java.util.concurrent.ScheduledExecutorService;
import java.util.List;
import java.util.Map;
import java.util.HashSet;
import java.util.concurrent.ScheduledFuture;

public class PersistentConnectionImpl implements Connection.Delegate, PersistentConnection
{
    private static long H;
    private String A;
    private long B;
    private int C;
    private int D;
    private ScheduledFuture<?> E;
    private long F;
    private boolean G;
    private final PersistentConnection.Delegate a;
    private final HostInfo b;
    private String c;
    private HashSet<String> d;
    private boolean e;
    private long f;
    private Connection g;
    private ConnectionState h;
    private long i;
    private long j;
    private long k;
    private Map<Long, j> l;
    private List<k> m;
    private Map<Long, n> n;
    private Map<Long, l> o;
    private Map<o, m> p;
    private String q;
    private boolean r;
    private String s;
    private boolean t;
    private final ConnectionContext u;
    private final ConnectionTokenProvider v;
    private final ConnectionTokenProvider w;
    private final ScheduledExecutorService x;
    private final LogWrapper y;
    private final RetryHelper z;
    
    public PersistentConnectionImpl(final ConnectionContext u, final HostInfo b, final PersistentConnection.Delegate a) {
        this.d = new HashSet<String>();
        this.e = true;
        this.h = ConnectionState.Disconnected;
        this.i = 0L;
        this.j = 0L;
        this.k = 0L;
        this.B = 0L;
        this.C = 0;
        this.D = 0;
        this.E = null;
        this.a = a;
        this.u = u;
        final ScheduledExecutorService e = u.e();
        this.x = e;
        this.v = u.c();
        this.w = u.a();
        this.b = b;
        this.p = new HashMap<o, m>();
        this.l = new HashMap<Long, j>();
        this.n = new HashMap<Long, n>();
        this.o = new ConcurrentHashMap<Long, l>();
        this.m = new ArrayList<k>();
        this.z = new RetryHelper.Builder(e, u.f(), "ConnectionRetryHelper").d(1000L).e(1.3).c(30000L).b(0.7).a();
        final long h = PersistentConnectionImpl.H;
        PersistentConnectionImpl.H = 1L + h;
        final Logger f = u.f();
        final StringBuilder sb = new StringBuilder();
        sb.append("pc_");
        sb.append(h);
        this.y = new LogWrapper(f, "PersistentConnection", sb.toString());
        this.A = null;
        this.P();
    }
    
    static Connection A(final PersistentConnectionImpl persistentConnectionImpl) {
        return persistentConnectionImpl.g;
    }
    
    private void A0(final m m) {
        final HashMap hashMap = new HashMap();
        hashMap.put("p", ConnectionUtils.d(PersistentConnectionImpl.o.a(PersistentConnectionImpl.m.a(m))));
        final Long e = m.e();
        if (e != null) {
            hashMap.put("q", PersistentConnectionImpl.o.b(m.d()));
            hashMap.put("t", e);
        }
        this.n0("n", hashMap, null);
    }
    
    static RetryHelper B(final PersistentConnectionImpl persistentConnectionImpl) {
        return persistentConnectionImpl.z;
    }
    
    static Map C(final PersistentConnectionImpl persistentConnectionImpl) {
        return persistentConnectionImpl.n;
    }
    
    private void C0() {
        if (this.B0()) {
            final ConnectionState h = this.h;
            ConnectionUtils.b(h == ConnectionState.Disconnected, "Not in disconnected state: %s", h);
            final boolean r = this.r;
            final boolean t = this.t;
            this.y.b("Scheduling connection attempt", new Object[0]);
            this.r = false;
            this.t = false;
            this.z.c((Runnable)new r4.c(this, r, t));
        }
    }
    
    static void D(final PersistentConnectionImpl persistentConnectionImpl) {
        persistentConnectionImpl.P();
    }
    
    private void D0() {
        this.o0(false);
    }
    
    static Map E(final PersistentConnectionImpl persistentConnectionImpl) {
        return persistentConnectionImpl.o;
    }
    
    private void E0() {
        this.q0(false);
    }
    
    static void F(final PersistentConnectionImpl persistentConnectionImpl, final List list, final o o) {
        persistentConnectionImpl.F0(list, o);
    }
    
    private void F0(final List<String> list, final o o) {
        if (list.contains("no_index")) {
            final StringBuilder sb = new StringBuilder();
            sb.append("\".indexOn\": \"");
            sb.append(PersistentConnectionImpl.o.b(o).get("i"));
            sb.append('\"');
            final String string = sb.toString();
            final LogWrapper y = this.y;
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Using an unspecified index. Your data will be downloaded and filtered on the client. Consider adding '");
            sb2.append(string);
            sb2.append("' at ");
            sb2.append(ConnectionUtils.d(PersistentConnectionImpl.o.a(o)));
            sb2.append(" to your security and Firebase Database rules for better performance");
            y.i(sb2.toString());
        }
    }
    
    static Map G(final PersistentConnectionImpl persistentConnectionImpl) {
        return persistentConnectionImpl.p;
    }
    
    static m H(final PersistentConnectionImpl persistentConnectionImpl, final o o) {
        return persistentConnectionImpl.j0(o);
    }
    
    static ScheduledFuture I(final PersistentConnectionImpl persistentConnectionImpl, final ScheduledFuture e) {
        return persistentConnectionImpl.E = e;
    }
    
    static boolean J(final PersistentConnectionImpl persistentConnectionImpl) {
        return persistentConnectionImpl.U();
    }
    
    static ConnectionState K(final PersistentConnectionImpl persistentConnectionImpl, final ConnectionState h) {
        return persistentConnectionImpl.h = h;
    }
    
    private boolean L() {
        return this.h == ConnectionState.Connected;
    }
    
    private boolean M() {
        return this.h == ConnectionState.Connected;
    }
    
    private void N() {
        final ArrayList list = new ArrayList();
        final Iterator<Map.Entry<Long, n>> iterator = this.n.entrySet().iterator();
        while (iterator.hasNext()) {
            final n n = ((Map.Entry<K, n>)iterator.next()).getValue();
            if (n.c().containsKey("h") && n.e()) {
                list.add(n);
                iterator.remove();
            }
        }
        final Iterator iterator2 = list.iterator();
        while (iterator2.hasNext()) {
            ((n)iterator2.next()).b().a("disconnected", null);
        }
    }
    
    private boolean O() {
        final ConnectionState h = this.h;
        return h == ConnectionState.Authenticating || h == ConnectionState.Connected;
    }
    
    private void P() {
        if (this.V()) {
            final ScheduledFuture<?> e = this.E;
            if (e != null) {
                e.cancel(false);
            }
            this.E = this.x.schedule(new Runnable(this) {
                final PersistentConnectionImpl a;
                
                @Override
                public void run() {
                    PersistentConnectionImpl.I(this.a, null);
                    if (PersistentConnectionImpl.J(this.a)) {
                        this.a.g("connection_idle");
                    }
                    else {
                        PersistentConnectionImpl.D(this.a);
                    }
                }
            }, 60000L, TimeUnit.MILLISECONDS);
        }
        else if (this.W("connection_idle")) {
            ConnectionUtils.a(this.V() ^ true);
            this.i("connection_idle");
        }
    }
    
    private Task<String> Q(final boolean b) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.y.b("Trying to fetch app check token", new Object[0]);
        this.w.a(b, (ConnectionTokenProvider.GetTokenCallback)new ConnectionTokenProvider.GetTokenCallback(this, taskCompletionSource) {
            final TaskCompletionSource a;
            final PersistentConnectionImpl b;
            
            @Override
            public void a(final String s) {
                this.a.c((Object)s);
            }
            
            @Override
            public void g(final String s) {
                this.a.b(new Exception(s));
            }
        });
        return (Task<String>)taskCompletionSource.a();
    }
    
    private Task<String> R(final boolean b) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.y.b("Trying to fetch auth token", new Object[0]);
        this.v.a(b, (ConnectionTokenProvider.GetTokenCallback)new ConnectionTokenProvider.GetTokenCallback(this, taskCompletionSource) {
            final TaskCompletionSource a;
            final PersistentConnectionImpl b;
            
            @Override
            public void a(final String s) {
                this.a.c((Object)s);
            }
            
            @Override
            public void g(final String s) {
                this.a.b(new Exception(s));
            }
        });
        return (Task<String>)taskCompletionSource.a();
    }
    
    private Map<String, Object> S(final List<String> list, final Object o, final String s) {
        final HashMap hashMap = new HashMap();
        hashMap.put("p", ConnectionUtils.d(list));
        hashMap.put("d", o);
        if (s != null) {
            hashMap.put("h", s);
        }
        return hashMap;
    }
    
    private void T(final long n) {
        if (this.y.f()) {
            this.y.b("handling timestamp", new Object[0]);
        }
        final long currentTimeMillis = System.currentTimeMillis();
        final HashMap hashMap = new HashMap();
        hashMap.put("serverTimeOffset", n - currentTimeMillis);
        this.a.e(hashMap);
    }
    
    private boolean U() {
        final long currentTimeMillis = System.currentTimeMillis();
        return this.V() && currentTimeMillis > this.F + 60000L;
    }
    
    private boolean V() {
        return this.p.isEmpty() && this.o.isEmpty() && this.l.isEmpty() && !this.G && this.n.isEmpty();
    }
    
    private void X(final boolean b, final Map map) {
        final String s = map.get("s");
        if (s.equals("ok")) {
            this.D = 0;
        }
        else {
            this.s = null;
            this.t = true;
            final String s2 = map.get("d");
            final LogWrapper y = this.y;
            final StringBuilder sb = new StringBuilder();
            sb.append("App check failed: ");
            sb.append(s);
            sb.append(" (");
            sb.append(s2);
            sb.append(")");
            y.b(sb.toString(), new Object[0]);
        }
        if (b) {
            this.l0();
        }
    }
    
    private void Y(final long n, final Task task, final Task task2, final Void void1) {
        if (n == this.B) {
            final ConnectionState h = this.h;
            if (h == ConnectionState.GettingToken) {
                this.y.b("Successfully fetched token, opening connection", new Object[0]);
                this.h0((String)task.p(), (String)task2.p());
            }
            else if (h == ConnectionState.Disconnected) {
                this.y.b("Not opening connection after token refresh, because connection was set to disconnected", new Object[0]);
            }
        }
        else {
            this.y.b("Ignoring getToken result, because this was not the latest attempt.", new Object[0]);
        }
    }
    
    private void Z(final long n, final Exception ex) {
        if (n == this.B) {
            this.h = ConnectionState.Disconnected;
            final LogWrapper y = this.y;
            final StringBuilder sb = new StringBuilder();
            sb.append("Error fetching token: ");
            sb.append(ex);
            y.b(sb.toString(), new Object[0]);
            this.C0();
        }
        else {
            this.y.b("Ignoring getToken error, because this was not the latest attempt.", new Object[0]);
        }
    }
    
    private void a0(final boolean b, final boolean b2) {
        final ConnectionState h = this.h;
        ConnectionUtils.b(h == ConnectionState.Disconnected, "Not in disconnected state: %s", h);
        this.h = ConnectionState.GettingToken;
        final long b3 = this.B + 1L;
        this.B = b3;
        final Task<String> r = this.R(b);
        final Task<String> q = this.Q(b2);
        Tasks.g(new Task[] { r, q }).j((Executor)this.x, (OnSuccessListener)new b(this, b3, (Task)r, (Task)q)).g((Executor)this.x, (OnFailureListener)new a(this, b3));
    }
    
    private long b0() {
        final long k = this.k;
        this.k = 1L + k;
        return k;
    }
    
    private void c0(final String s, final String s2) {
        final LogWrapper y = this.y;
        final StringBuilder sb = new StringBuilder();
        sb.append("App check token revoked: ");
        sb.append(s);
        sb.append(" (");
        sb.append(s2);
        sb.append(")");
        y.b(sb.toString(), new Object[0]);
        this.s = null;
        this.t = true;
    }
    
    private void d0(final String s, final String s2) {
        final LogWrapper y = this.y;
        final StringBuilder sb = new StringBuilder();
        sb.append("Auth token revoked: ");
        sb.append(s);
        sb.append(" (");
        sb.append(s2);
        sb.append(")");
        y.b(sb.toString(), new Object[0]);
        this.q = null;
        this.r = true;
        this.a.c(false);
        this.g.c();
    }
    
    private void e0(String s, final Map<String, Object> map) {
        if (this.y.f()) {
            final LogWrapper y = this.y;
            final StringBuilder sb = new StringBuilder();
            sb.append("handleServerMessage: ");
            sb.append(s);
            sb.append(" ");
            sb.append(map);
            y.b(sb.toString(), new Object[0]);
        }
        if (!s.equals("d") && !s.equals("m")) {
            if (s.equals("rm")) {
                final String s2 = (String)map.get("p");
                final List<String> e = ConnectionUtils.e(s2);
                final List value = map.get("d");
                final Long c = ConnectionUtils.c(map.get("t"));
                final List list = value;
                final ArrayList list2 = new ArrayList();
                for (final Map map2 : list) {
                    s = (String)map2.get("s");
                    final String s3 = (String)map2.get("e");
                    List<String> e2 = null;
                    List<String> e3;
                    if (s != null) {
                        e3 = ConnectionUtils.e(s);
                    }
                    else {
                        e3 = null;
                    }
                    if (s3 != null) {
                        e2 = ConnectionUtils.e(s3);
                    }
                    list2.add(new RangeMerge(e3, e2, map2.get("m")));
                }
                if (list2.isEmpty()) {
                    if (this.y.f()) {
                        final LogWrapper y2 = this.y;
                        final StringBuilder sb2 = new StringBuilder();
                        sb2.append("Ignoring empty range merge for path ");
                        sb2.append(s2);
                        y2.b(sb2.toString(), new Object[0]);
                    }
                }
                else {
                    this.a.f(e, list2, c);
                }
            }
            else if (s.equals("c")) {
                this.f0(ConnectionUtils.e((String)map.get("p")));
            }
            else if (s.equals("ac")) {
                this.d0((String)map.get("s"), (String)map.get("d"));
            }
            else if (s.equals("apc")) {
                this.c0((String)map.get("s"), (String)map.get("d"));
            }
            else if (s.equals("sd")) {
                this.g0(map);
            }
            else if (this.y.f()) {
                final LogWrapper y3 = this.y;
                final StringBuilder sb3 = new StringBuilder();
                sb3.append("Unrecognized action from server: ");
                sb3.append(s);
                y3.b(sb3.toString(), new Object[0]);
            }
        }
        else {
            final boolean equals = s.equals("m");
            s = (String)map.get("p");
            final List value2 = map.get("d");
            final Long c2 = ConnectionUtils.c(map.get("t"));
            if (equals && value2 instanceof Map && ((Map)value2).size() == 0) {
                if (this.y.f()) {
                    final LogWrapper y4 = this.y;
                    final StringBuilder sb4 = new StringBuilder();
                    sb4.append("ignoring empty merge for path ");
                    sb4.append(s);
                    y4.b(sb4.toString(), new Object[0]);
                }
            }
            else {
                this.a.b(ConnectionUtils.e(s), value2, equals, c2);
            }
        }
    }
    
    private void f0(final List<String> list) {
        final Collection<m> k0 = this.k0(list);
        if (k0 != null) {
            final Iterator<m> iterator = k0.iterator();
            while (iterator.hasNext()) {
                PersistentConnectionImpl.m.b(iterator.next()).a("permission_denied", null);
            }
        }
    }
    
    private void g0(final Map<String, Object> map) {
        this.y.e(map.get("msg"));
    }
    
    private void i0(final String s, final List<String> list, final Object o, final String s2, final RequestResultCallback requestResultCallback) {
        final Map<String, Object> s3 = this.S(list, o, s2);
        final long i = this.i;
        this.i = 1L + i;
        this.n.put(i, new n(s, s3, requestResultCallback, null));
        if (this.M()) {
            this.v0(i);
        }
        this.F = System.currentTimeMillis();
        this.P();
    }
    
    private m j0(final o o) {
        if (this.y.f()) {
            final LogWrapper y = this.y;
            final StringBuilder sb = new StringBuilder();
            sb.append("removing query ");
            sb.append(o);
            y.b(sb.toString(), new Object[0]);
        }
        if (!this.p.containsKey(o)) {
            if (this.y.f()) {
                final LogWrapper y2 = this.y;
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("Trying to remove listener for QuerySpec ");
                sb2.append(o);
                sb2.append(" but no listener exists.");
                y2.b(sb2.toString(), new Object[0]);
            }
            return null;
        }
        final m m = this.p.get(o);
        this.p.remove(o);
        this.P();
        return m;
    }
    
    private Collection<m> k0(final List<String> list) {
        if (this.y.f()) {
            final LogWrapper y = this.y;
            final StringBuilder sb = new StringBuilder();
            sb.append("removing all listens at path ");
            sb.append(list);
            y.b(sb.toString(), new Object[0]);
        }
        final ArrayList list2 = new ArrayList();
        for (final Map.Entry<o, V> entry : this.p.entrySet()) {
            final o o = entry.getKey();
            final m m = (m)entry.getValue();
            if (PersistentConnectionImpl.o.a(o).equals(list)) {
                list2.add(m);
            }
        }
        final Iterator iterator2 = list2.iterator();
        while (iterator2.hasNext()) {
            this.p.remove(((m)iterator2.next()).d());
        }
        this.P();
        return list2;
    }
    
    private void l0() {
        final ConnectionState h = this.h;
        ConnectionUtils.b(h == ConnectionState.Connected, "Should be connected if we're restoring state, but we are: %s", h);
        if (this.y.f()) {
            this.y.b("Restoring outstanding listens", new Object[0]);
        }
        for (final m m : this.p.values()) {
            if (this.y.f()) {
                final LogWrapper y = this.y;
                final StringBuilder sb = new StringBuilder();
                sb.append("Restoring listen ");
                sb.append(m.d());
                y.b(sb.toString(), new Object[0]);
            }
            this.t0(m);
        }
        if (this.y.f()) {
            this.y.b("Restoring writes.", new Object[0]);
        }
        final ArrayList<Long> list = new ArrayList<Long>(this.n.keySet());
        Collections.sort((List<Comparable>)list);
        final Iterator<Long> iterator2 = list.iterator();
        while (iterator2.hasNext()) {
            this.v0(iterator2.next());
        }
        for (final k k : this.m) {
            this.u0(k.a(), k.d(), k.b(), k.c());
        }
        this.m.clear();
        if (this.y.f()) {
            this.y.b("Restoring reads.", new Object[0]);
        }
        final ArrayList<Long> list2 = new ArrayList<Long>(this.o.keySet());
        Collections.sort((List<Comparable>)list2);
        final Iterator<Long> iterator4 = list2.iterator();
        while (iterator4.hasNext()) {
            this.s0(iterator4.next());
        }
    }
    
    private void m0() {
        if (this.y.f()) {
            this.y.b("calling restore tokens", new Object[0]);
        }
        final ConnectionState h = this.h;
        ConnectionUtils.b(h == ConnectionState.Connecting, "Wanted to restore tokens, but was in wrong state: %s", h);
        if (this.q != null) {
            if (this.y.f()) {
                this.y.b("Restoring auth.", new Object[0]);
            }
            this.h = ConnectionState.Authenticating;
            this.p0();
        }
        else {
            if (this.y.f()) {
                this.y.b("Not restoring auth because auth token is null.", new Object[0]);
            }
            this.h = ConnectionState.Connected;
            this.o0(true);
        }
    }
    
    private void n0(final String s, final Map<String, Object> map, final j j) {
        this.w0(s, false, map, j);
    }
    
    public static void o(final PersistentConnectionImpl persistentConnectionImpl, final boolean b, final boolean b2) {
        persistentConnectionImpl.a0(b, b2);
    }
    
    private void o0(final boolean b) {
        if (this.s == null) {
            this.l0();
            return;
        }
        ConnectionUtils.b(this.O(), "Must be connected to send auth, but was: %s", this.h);
        if (this.y.f()) {
            this.y.b("Sending app check.", new Object[0]);
        }
        final com.google.firebase.database.connection.a a = new com.google.firebase.database.connection.a(this, b);
        final HashMap hashMap = new HashMap();
        ConnectionUtils.b(this.s != null, "App check token must be set!", new Object[0]);
        hashMap.put("token", this.s);
        this.w0("appcheck", true, hashMap, (j)a);
    }
    
    public static void p(final PersistentConnectionImpl persistentConnectionImpl, final long n, final Exception ex) {
        persistentConnectionImpl.Z(n, ex);
    }
    
    private void p0() {
        this.q0(true);
    }
    
    public static void q(final PersistentConnectionImpl persistentConnectionImpl, final boolean b, final Map map) {
        persistentConnectionImpl.X(b, map);
    }
    
    private void q0(final boolean b) {
        ConnectionUtils.b(this.O(), "Must be connected to send auth, but was: %s", this.h);
        if (this.y.f()) {
            this.y.b("Sending auth.", new Object[0]);
        }
        final j j = new j(this, b) {
            final boolean a;
            final PersistentConnectionImpl b;
            
            @Override
            public void a(final Map<String, Object> map) {
                final String s = map.get("s");
                if (s.equals("ok")) {
                    PersistentConnectionImpl.K(this.b, ConnectionState.Connected);
                    PersistentConnectionImpl.t(this.b, 0);
                    PersistentConnectionImpl.v(this.b, this.a);
                }
                else {
                    PersistentConnectionImpl.w(this.b, null);
                    PersistentConnectionImpl.x(this.b, true);
                    PersistentConnectionImpl.y(this.b).c(false);
                    final String s2 = map.get("d");
                    final LogWrapper z = PersistentConnectionImpl.z(this.b);
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Authentication failed: ");
                    sb.append(s);
                    sb.append(" (");
                    sb.append(s2);
                    sb.append(")");
                    z.b(sb.toString(), new Object[0]);
                    PersistentConnectionImpl.A(this.b).c();
                    if (s.equals("invalid_token")) {
                        PersistentConnectionImpl.u(this.b);
                        if (PersistentConnectionImpl.s(this.b) >= 3L) {
                            PersistentConnectionImpl.B(this.b).d();
                            PersistentConnectionImpl.z(this.b).i("Provided authentication credentials are invalid. This usually indicates your FirebaseApp instance was not initialized correctly. Make sure your google-services.json file has the correct firebase_url and api_key. You can re-download google-services.json from https://console.firebase.google.com/.");
                        }
                    }
                }
            }
        };
        final HashMap hashMap = new HashMap();
        final GAuthToken c = GAuthToken.c(this.q);
        if (c != null) {
            hashMap.put("cred", c.b());
            if (c.a() != null) {
                hashMap.put("authvar", c.a());
            }
            this.w0("gauth", true, hashMap, (j)j);
        }
        else {
            hashMap.put("cred", this.q);
            this.w0("auth", true, hashMap, (j)j);
        }
    }
    
    public static void r(final PersistentConnectionImpl persistentConnectionImpl, final long n, final Task task, final Task task2, final Void void1) {
        persistentConnectionImpl.Y(n, task, task2, void1);
    }
    
    private void r0() {
        final HashMap hashMap = new HashMap();
        final boolean i = this.u.i();
        final Integer value = 1;
        if (i) {
            hashMap.put("persistence.android.enabled", value);
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("sdk.android.");
        sb.append(this.u.d().replace('.', '-'));
        hashMap.put(sb.toString(), value);
        if (this.y.f()) {
            this.y.b("Sending first connection stats", new Object[0]);
        }
        this.x0(hashMap);
    }
    
    static int s(final PersistentConnectionImpl persistentConnectionImpl) {
        return persistentConnectionImpl.C;
    }
    
    private void s0(final Long n) {
        ConnectionUtils.b(this.L(), "sendGet called when we can't send gets", new Object[0]);
        final l l = this.o.get(n);
        if (!PersistentConnectionImpl.l.a(l) && this.y.f()) {
            final LogWrapper y = this.y;
            final StringBuilder sb = new StringBuilder();
            sb.append("get");
            sb.append(n);
            sb.append(" cancelled, ignoring.");
            y.b(sb.toString(), new Object[0]);
            return;
        }
        this.n0("g", PersistentConnectionImpl.l.b(l), (j)new j(this, n, l) {
            final Long a;
            final l b;
            final PersistentConnectionImpl c;
            
            @Override
            public void a(final Map<String, Object> map) {
                if (PersistentConnectionImpl.E(this.c).get(this.a) == this.b) {
                    PersistentConnectionImpl.E(this.c).remove(this.a);
                    PersistentConnectionImpl.l.c(this.b).a(map);
                }
                else if (PersistentConnectionImpl.z(this.c).f()) {
                    final LogWrapper z = PersistentConnectionImpl.z(this.c);
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Ignoring on complete for get ");
                    sb.append(this.a);
                    sb.append(" because it was removed already.");
                    z.b(sb.toString(), new Object[0]);
                }
            }
        });
    }
    
    static int t(final PersistentConnectionImpl persistentConnectionImpl, final int c) {
        return persistentConnectionImpl.C = c;
    }
    
    private void t0(final m m) {
        final HashMap hashMap = new HashMap();
        hashMap.put("p", ConnectionUtils.d(PersistentConnectionImpl.o.a(m.d())));
        final Long e = m.e();
        if (e != null) {
            hashMap.put("q", PersistentConnectionImpl.o.b(PersistentConnectionImpl.m.a(m)));
            hashMap.put("t", e);
        }
        final ListenHashProvider c = m.c();
        hashMap.put("h", c.a());
        if (c.d()) {
            final CompoundHash c2 = c.c();
            final ArrayList list = new ArrayList();
            final Iterator<List<String>> iterator = c2.b().iterator();
            while (iterator.hasNext()) {
                list.add(ConnectionUtils.d(iterator.next()));
            }
            final HashMap hashMap2 = new HashMap();
            hashMap2.put("hs", c2.a());
            hashMap2.put("ps", list);
            hashMap.put("ch", hashMap2);
        }
        this.n0("q", hashMap, (j)new j(this, m) {
            final m a;
            final PersistentConnectionImpl b;
            
            @Override
            public void a(final Map<String, Object> map) {
                final String s = map.get("s");
                if (s.equals("ok")) {
                    final Map map2 = (Map)map.get("d");
                    if (map2.containsKey("w")) {
                        PersistentConnectionImpl.F(this.b, (List)map2.get("w"), PersistentConnectionImpl.m.a(this.a));
                    }
                }
                if (PersistentConnectionImpl.G(this.b).get(this.a.d()) == this.a) {
                    if (!s.equals("ok")) {
                        PersistentConnectionImpl.H(this.b, this.a.d());
                        PersistentConnectionImpl.m.b(this.a).a(s, map.get("d"));
                    }
                    else {
                        PersistentConnectionImpl.m.b(this.a).a(null, null);
                    }
                }
            }
        });
    }
    
    static int u(final PersistentConnectionImpl persistentConnectionImpl) {
        return persistentConnectionImpl.C++;
    }
    
    private void u0(final String s, final List<String> list, final Object o, final RequestResultCallback requestResultCallback) {
        final HashMap hashMap = new HashMap();
        hashMap.put("p", ConnectionUtils.d(list));
        hashMap.put("d", o);
        this.n0(s, hashMap, (j)new j(this, requestResultCallback) {
            final RequestResultCallback a;
            final PersistentConnectionImpl b;
            
            @Override
            public void a(final Map<String, Object> map) {
                final String s = map.get("s");
                final boolean equals = s.equals("ok");
                final String s2 = null;
                String s4;
                String s5;
                if (!equals) {
                    final String s3 = map.get("d");
                    s4 = s;
                    s5 = s3;
                }
                else {
                    s4 = null;
                    s5 = s2;
                }
                final RequestResultCallback a = this.a;
                if (a != null) {
                    a.a(s4, s5);
                }
            }
        });
    }
    
    static void v(final PersistentConnectionImpl persistentConnectionImpl, final boolean b) {
        persistentConnectionImpl.o0(b);
    }
    
    private void v0(final long n) {
        ConnectionUtils.b(this.M(), "sendPut called when we can't send writes (we're disconnected or writes are paused).", new Object[0]);
        final n n2 = this.n.get(n);
        final RequestResultCallback b = n2.b();
        final String a = n2.a();
        n2.d();
        this.n0(a, n2.c(), (j)new j(this, a, n, n2, b) {
            final String a;
            final long b;
            final n c;
            final RequestResultCallback d;
            final PersistentConnectionImpl e;
            
            @Override
            public void a(final Map<String, Object> map) {
                if (PersistentConnectionImpl.z(this.e).f()) {
                    final LogWrapper z = PersistentConnectionImpl.z(this.e);
                    final StringBuilder sb = new StringBuilder();
                    sb.append(this.a);
                    sb.append(" response: ");
                    sb.append(map);
                    z.b(sb.toString(), new Object[0]);
                }
                if (PersistentConnectionImpl.C(this.e).get(this.b) == this.c) {
                    PersistentConnectionImpl.C(this.e).remove(this.b);
                    if (this.d != null) {
                        final String s = map.get("s");
                        if (s.equals("ok")) {
                            this.d.a(null, null);
                        }
                        else {
                            this.d.a(s, map.get("d"));
                        }
                    }
                }
                else if (PersistentConnectionImpl.z(this.e).f()) {
                    final LogWrapper z2 = PersistentConnectionImpl.z(this.e);
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("Ignoring on complete for put ");
                    sb2.append(this.b);
                    sb2.append(" because it was removed already.");
                    z2.b(sb2.toString(), new Object[0]);
                }
                PersistentConnectionImpl.D(this.e);
            }
        });
    }
    
    static String w(final PersistentConnectionImpl persistentConnectionImpl, final String q) {
        return persistentConnectionImpl.q = q;
    }
    
    private void w0(final String s, final boolean b, final Map<String, Object> map, final j j) {
        final long b2 = this.b0();
        final HashMap hashMap = new HashMap();
        hashMap.put("r", b2);
        hashMap.put("a", s);
        hashMap.put("b", map);
        this.g.m(hashMap, b);
        this.l.put(b2, j);
    }
    
    static boolean x(final PersistentConnectionImpl persistentConnectionImpl, final boolean r) {
        return persistentConnectionImpl.r = r;
    }
    
    private void x0(final Map<String, Integer> map) {
        if (!map.isEmpty()) {
            final HashMap hashMap = new HashMap();
            hashMap.put("c", map);
            this.n0("s", hashMap, (j)new j(this) {
                final PersistentConnectionImpl a;
                
                @Override
                public void a(final Map<String, Object> map) {
                    final String s = map.get("s");
                    if (!s.equals("ok")) {
                        final String s2 = map.get("d");
                        if (PersistentConnectionImpl.z(this.a).f()) {
                            final LogWrapper z = PersistentConnectionImpl.z(this.a);
                            final StringBuilder sb = new StringBuilder();
                            sb.append("Failed to send stats: ");
                            sb.append(s);
                            sb.append(" (message: ");
                            sb.append(s2);
                            sb.append(")");
                            z.b(sb.toString(), new Object[0]);
                        }
                    }
                }
            });
        }
        else if (this.y.f()) {
            this.y.b("Not sending stats because stats are empty", new Object[0]);
        }
    }
    
    static PersistentConnection.Delegate y(final PersistentConnectionImpl persistentConnectionImpl) {
        return persistentConnectionImpl.a;
    }
    
    private void y0() {
        ConnectionUtils.b(this.O(), "Must be connected to send unauth.", new Object[0]);
        ConnectionUtils.b(this.s == null, "App check token must not be set.", new Object[0]);
        this.n0("unappcheck", Collections.emptyMap(), null);
    }
    
    static LogWrapper z(final PersistentConnectionImpl persistentConnectionImpl) {
        return persistentConnectionImpl.y;
    }
    
    private void z0() {
        ConnectionUtils.b(this.O(), "Must be connected to send unauth.", new Object[0]);
        ConnectionUtils.b(this.q == null, "Auth token must not be set.", new Object[0]);
        this.n0("unauth", Collections.emptyMap(), null);
    }
    
    boolean B0() {
        return this.d.size() == 0;
    }
    
    public boolean W(final String s) {
        return this.d.contains(s);
    }
    
    @Override
    public void a(final List<String> list, final Map<String, Object> map, final RequestResultCallback requestResultCallback) {
        this.i0("m", list, map, null, requestResultCallback);
    }
    
    @Override
    public void b(final String s) {
        if (s.equals("Invalid appcheck token")) {
            final int d = this.D;
            if (d < 3L) {
                this.D = d + 1;
                final LogWrapper y = this.y;
                final StringBuilder sb = new StringBuilder();
                sb.append("Detected invalid AppCheck token. Reconnecting (");
                sb.append(3L - this.D);
                sb.append(" attempts remaining)");
                y.i(sb.toString());
                return;
            }
        }
        final LogWrapper y2 = this.y;
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("Firebase Database connection was forcefully killed by the server. Will not attempt reconnect. Reason: ");
        sb2.append(s);
        y2.i(sb2.toString());
        this.g("server_kill");
    }
    
    @Override
    public void c(final List<String> list, final Object o, final String s, final RequestResultCallback requestResultCallback) {
        this.i0("p", list, o, s, requestResultCallback);
    }
    
    @Override
    public void d(final List<String> list, final Map<String, Object> map, final ListenHashProvider listenHashProvider, final Long n, final RequestResultCallback requestResultCallback) {
        final o o = new o(list, map);
        if (this.y.f()) {
            final LogWrapper y = this.y;
            final StringBuilder sb = new StringBuilder();
            sb.append("Listening on ");
            sb.append(o);
            y.b(sb.toString(), new Object[0]);
        }
        ConnectionUtils.b(this.p.containsKey(o) ^ true, "listen() called twice for same QuerySpec.", new Object[0]);
        if (this.y.f()) {
            final LogWrapper y2 = this.y;
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Adding listen query: ");
            sb2.append(o);
            y2.b(sb2.toString(), new Object[0]);
        }
        final m m = new m(requestResultCallback, o, n, listenHashProvider, null);
        this.p.put(o, m);
        if (this.O()) {
            this.t0(m);
        }
        this.P();
    }
    
    @Override
    public void e(final Map<String, Object> map) {
        if (map.containsKey("r")) {
            final j j = this.l.remove((long)map.get("r"));
            if (j != null) {
                j.a(map.get("b"));
            }
        }
        else if (!map.containsKey("error")) {
            if (map.containsKey("a")) {
                this.e0(map.get("a"), map.get("b"));
            }
            else if (this.y.f()) {
                final LogWrapper y = this.y;
                final StringBuilder sb = new StringBuilder();
                sb.append("Ignoring unknown message: ");
                sb.append(map);
                y.b(sb.toString(), new Object[0]);
            }
        }
    }
    
    @Override
    public void f(final List<String> list, final Map<String, Object> map) {
        final o o = new o(list, map);
        if (this.y.f()) {
            final LogWrapper y = this.y;
            final StringBuilder sb = new StringBuilder();
            sb.append("unlistening on ");
            sb.append(o);
            y.b(sb.toString(), new Object[0]);
        }
        final m j0 = this.j0(o);
        if (j0 != null && this.O()) {
            this.A0(j0);
        }
        this.P();
    }
    
    @Override
    public void g(final String s) {
        if (this.y.f()) {
            final LogWrapper y = this.y;
            final StringBuilder sb = new StringBuilder();
            sb.append("Connection interrupted for: ");
            sb.append(s);
            y.b(sb.toString(), new Object[0]);
        }
        this.d.add(s);
        final Connection g = this.g;
        if (g != null) {
            g.c();
            this.g = null;
        }
        else {
            this.z.b();
            this.h = ConnectionState.Disconnected;
        }
        this.z.e();
    }
    
    @Override
    public void h(final String c) {
        this.c = c;
    }
    
    public void h0(final String q, final String s) {
        final ConnectionState h = this.h;
        ConnectionUtils.b(h == ConnectionState.GettingToken, "Trying to open network connection while in the wrong state: %s", h);
        if (q == null) {
            this.a.c(false);
        }
        this.q = q;
        this.s = s;
        this.h = ConnectionState.Connecting;
        (this.g = new Connection(this.u, this.b, this.c, (Connection.Delegate)this, this.A, s)).k();
    }
    
    @Override
    public void i(final String s) {
        if (this.y.f()) {
            final LogWrapper y = this.y;
            final StringBuilder sb = new StringBuilder();
            sb.append("Connection no longer interrupted for: ");
            sb.append(s);
            y.b(sb.toString(), new Object[0]);
        }
        this.d.remove(s);
        if (this.B0() && this.h == ConnectionState.Disconnected) {
            this.C0();
        }
    }
    
    @Override
    public void initialize() {
        this.C0();
    }
    
    @Override
    public void j(final List<String> list, final Object o, final RequestResultCallback requestResultCallback) {
        this.i0("p", list, o, null, requestResultCallback);
    }
    
    @Override
    public void k(final long n, final String a) {
        if (this.y.f()) {
            this.y.b("onReady", new Object[0]);
        }
        this.f = System.currentTimeMillis();
        this.T(n);
        if (this.e) {
            this.r0();
        }
        this.m0();
        this.e = false;
        this.A = a;
        this.a.d();
    }
    
    @Override
    public void l(final String q) {
        this.y.b("Auth token refreshed.", new Object[0]);
        this.q = q;
        if (this.O()) {
            if (q != null) {
                this.E0();
            }
            else {
                this.z0();
            }
        }
    }
    
    @Override
    public void m(final String s) {
        this.y.b("App check token refreshed.", new Object[0]);
        this.s = s;
        if (this.O()) {
            if (s != null) {
                this.D0();
            }
            else {
                this.y0();
            }
        }
    }
    
    @Override
    public void n(final DisconnectReason disconnectReason) {
        final boolean f = this.y.f();
        final int n = 0;
        if (f) {
            final LogWrapper y = this.y;
            final StringBuilder sb = new StringBuilder();
            sb.append("Got on disconnect due to ");
            sb.append(disconnectReason.name());
            y.b(sb.toString(), new Object[0]);
        }
        this.h = ConnectionState.Disconnected;
        this.g = null;
        this.G = false;
        this.l.clear();
        this.N();
        if (this.B0()) {
            final long currentTimeMillis = System.currentTimeMillis();
            final long f2 = this.f;
            int n2 = n;
            if (f2 > 0L) {
                n2 = n;
                if (currentTimeMillis - f2 > 30000L) {
                    n2 = 1;
                }
            }
            if (disconnectReason == DisconnectReason.SERVER_RESET || n2 != 0) {
                this.z.e();
            }
            this.C0();
        }
        this.f = 0L;
        this.a.a();
    }
    
    private enum ConnectionState
    {
        private static final ConnectionState[] $VALUES;
        
        Authenticating, 
        Connected, 
        Connecting, 
        Disconnected, 
        GettingToken;
    }
    
    private interface j
    {
        void a(final Map<String, Object> p0);
    }
    
    private static class k
    {
        private final String a;
        private final List<String> b;
        private final Object c;
        private final RequestResultCallback d;
        
        public String a() {
            return this.a;
        }
        
        public Object b() {
            return this.c;
        }
        
        public RequestResultCallback c() {
            return this.d;
        }
        
        public List<String> d() {
            return this.b;
        }
    }
    
    private static class l
    {
        private final Map<String, Object> a;
        private final j b;
        private boolean c;
        
        static boolean a(final l l) {
            return l.f();
        }
        
        static Map b(final l l) {
            return l.e();
        }
        
        static j c(final l l) {
            return l.d();
        }
        
        private j d() {
            return this.b;
        }
        
        private Map<String, Object> e() {
            return this.a;
        }
        
        private boolean f() {
            return !this.c && (this.c = true);
        }
    }
    
    private static class m
    {
        private final RequestResultCallback a;
        private final o b;
        private final ListenHashProvider c;
        private final Long d;
        
        private m(final RequestResultCallback a, final o b, final Long d, final ListenHashProvider c) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }
        
        m(final RequestResultCallback requestResultCallback, final o o, final Long n, final ListenHashProvider listenHashProvider, final PersistentConnectionImpl$a getTokenCallback) {
            this(requestResultCallback, o, n, listenHashProvider);
        }
        
        static o a(final m m) {
            return m.b;
        }
        
        static RequestResultCallback b(final m m) {
            return m.a;
        }
        
        public ListenHashProvider c() {
            return this.c;
        }
        
        public o d() {
            return this.b;
        }
        
        public Long e() {
            return this.d;
        }
        
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append(this.b.toString());
            sb.append(" (Tag: ");
            sb.append(this.d);
            sb.append(")");
            return sb.toString();
        }
    }
    
    private static class n
    {
        private String a;
        private Map<String, Object> b;
        private RequestResultCallback c;
        private boolean d;
        
        private n(final String a, final Map<String, Object> b, final RequestResultCallback c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        
        n(final String s, final Map map, final RequestResultCallback requestResultCallback, final PersistentConnectionImpl$a getTokenCallback) {
            this(s, map, requestResultCallback);
        }
        
        public String a() {
            return this.a;
        }
        
        public RequestResultCallback b() {
            return this.c;
        }
        
        public Map<String, Object> c() {
            return this.b;
        }
        
        public void d() {
            this.d = true;
        }
        
        public boolean e() {
            return this.d;
        }
    }
    
    private static class o
    {
        private final List<String> a;
        private final Map<String, Object> b;
        
        public o(final List<String> a, final Map<String, Object> b) {
            this.a = a;
            this.b = b;
        }
        
        static List a(final o o) {
            return o.a;
        }
        
        static Map b(final o o) {
            return o.b;
        }
        
        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof o)) {
                return false;
            }
            final o o2 = (o)o;
            return this.a.equals(o2.a) && this.b.equals(o2.b);
        }
        
        @Override
        public int hashCode() {
            return this.a.hashCode() * 31 + this.b.hashCode();
        }
        
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append(ConnectionUtils.d(this.a));
            sb.append(" (params: ");
            sb.append(this.b);
            sb.append(")");
            return sb.toString();
        }
    }
}
