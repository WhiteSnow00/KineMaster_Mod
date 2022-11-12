// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.upstream;

import com.google.common.collect.Sets;
import java.util.Set;
import com.google.common.collect.ForwardingMap;
import android.net.Uri;
import com.google.common.collect.ImmutableMap;
import java.util.List;
import java.util.zip.GZIPInputStream;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.net.URLConnection;
import java.net.NoRouteToHostException;
import java.net.MalformedURLException;
import com.google.android.exoplayer2.util.Log;
import java.io.InterruptedIOException;
import java.lang.reflect.Method;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.net.URL;
import java.io.InputStream;
import java.net.HttpURLConnection;
import com.google.common.base.Predicate;

public class DefaultHttpDataSource extends BaseDataSource implements HttpDataSource
{
    private final boolean e;
    private final int f;
    private final int g;
    private final String h;
    private final RequestProperties i;
    private final RequestProperties j;
    private final boolean k;
    private Predicate<String> l;
    private DataSpec m;
    private HttpURLConnection n;
    private InputStream o;
    private boolean p;
    private int q;
    private long r;
    private long s;
    
    @Deprecated
    public DefaultHttpDataSource() {
        this(null, 8000, 8000);
    }
    
    @Deprecated
    public DefaultHttpDataSource(final String s, final int n, final int n2) {
        this(s, n, n2, false, null);
    }
    
    @Deprecated
    public DefaultHttpDataSource(final String s, final int n, final int n2, final boolean b, final RequestProperties requestProperties) {
        this(s, n, n2, b, requestProperties, null, false);
    }
    
    private DefaultHttpDataSource(final String h, final int f, final int g, final boolean e, final RequestProperties i, final Predicate<String> l, final boolean k) {
        super(true);
        this.h = h;
        this.f = f;
        this.g = g;
        this.e = e;
        this.i = i;
        this.l = l;
        this.j = new RequestProperties();
        this.k = k;
    }
    
    DefaultHttpDataSource(final String s, final int n, final int n2, final boolean b, final RequestProperties requestProperties, final Predicate predicate, final boolean b2, final DefaultHttpDataSource$a object) {
        this(s, n, n2, b, requestProperties, (Predicate<String>)predicate, b2);
    }
    
    private HttpURLConnection A(final URL url, final int n, final byte[] array, final long n2, final long n3, final boolean b, final boolean instanceFollowRedirects, final Map<String, String> map) throws IOException {
        final HttpURLConnection c = this.C(url);
        c.setConnectTimeout(this.f);
        c.setReadTimeout(this.g);
        final HashMap hashMap = new HashMap();
        final RequestProperties i = this.i;
        if (i != null) {
            hashMap.putAll(i.a());
        }
        hashMap.putAll(this.j.a());
        hashMap.putAll(map);
        for (final Map.Entry<String, V> entry : hashMap.entrySet()) {
            c.setRequestProperty(entry.getKey(), (String)entry.getValue());
        }
        final String a = HttpUtil.a(n2, n3);
        if (a != null) {
            c.setRequestProperty("Range", a);
        }
        final String h = this.h;
        if (h != null) {
            c.setRequestProperty("User-Agent", h);
        }
        String s;
        if (b) {
            s = "gzip";
        }
        else {
            s = "identity";
        }
        c.setRequestProperty("Accept-Encoding", s);
        c.setInstanceFollowRedirects(instanceFollowRedirects);
        c.setDoOutput(array != null);
        c.setRequestMethod(DataSpec.c(n));
        if (array != null) {
            c.setFixedLengthStreamingMode(array.length);
            c.connect();
            final OutputStream outputStream = c.getOutputStream();
            outputStream.write(array);
            outputStream.close();
        }
        else {
            c.connect();
        }
        return c;
    }
    
    private static void B(final HttpURLConnection httpURLConnection, final long n) {
        if (httpURLConnection == null) {
            return;
        }
        final int a = Util.a;
        if (a < 19) {
            return;
        }
        if (a > 20) {
            return;
        }
        try {
            final InputStream inputStream = httpURLConnection.getInputStream();
            if (n == -1L) {
                if (inputStream.read() == -1) {
                    return;
                }
            }
            else if (n <= 2048L) {
                return;
            }
            final String name = inputStream.getClass().getName();
            if ("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream".equals(name) || "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream".equals(name)) {
                final Method declaredMethod = Assertions.e(inputStream.getClass().getSuperclass()).getDeclaredMethod("unexpectedEndOfInput", (Class<?>[])new Class[0]);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(inputStream, new Object[0]);
            }
        }
        catch (final Exception ex) {}
    }
    
    private int D(final byte[] array, int read, final int n) throws IOException {
        if (n == 0) {
            return 0;
        }
        final long r = this.r;
        int n2 = n;
        if (r != -1L) {
            final long n3 = r - this.s;
            if (n3 == 0L) {
                return -1;
            }
            n2 = (int)Math.min(n, n3);
        }
        read = Util.j(this.o).read(array, read, n2);
        if (read == -1) {
            return -1;
        }
        this.s += read;
        this.s(read);
        return read;
    }
    
    private void E(long n, final DataSpec dataSpec) throws IOException {
        if (n == 0L) {
            return;
        }
        final byte[] array = new byte[4096];
        while (n > 0L) {
            final int read = Util.j(this.o).read(array, 0, (int)Math.min(n, 4096));
            if (Thread.currentThread().isInterrupted()) {
                throw new HttpDataSourceException(new InterruptedIOException(), dataSpec, 2000, 1);
            }
            if (read == -1) {
                throw new HttpDataSourceException(dataSpec, 2008, 1);
            }
            n -= read;
            this.s(read);
        }
    }
    
    private void w() {
        final HttpURLConnection n = this.n;
        if (n != null) {
            try {
                n.disconnect();
            }
            catch (final Exception ex) {
                Log.d("DefaultHttpDataSource", "Unexpected error while disconnecting", ex);
            }
            this.n = null;
        }
    }
    
    private URL x(final URL url, String protocol, final DataSpec dataSpec) throws HttpDataSourceException {
        if (protocol != null) {
            try {
                final URL url2 = new URL(url, protocol);
                protocol = url2.getProtocol();
                if (!"https".equals(protocol) && !"http".equals(protocol)) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Unsupported protocol redirect: ");
                    sb.append(protocol);
                    throw new HttpDataSourceException(sb.toString(), dataSpec, 2001, 1);
                }
                if (!this.e && !protocol.equals(url.getProtocol())) {
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("Disallowed cross-protocol redirect (");
                    sb2.append(url.getProtocol());
                    sb2.append(" to ");
                    sb2.append(protocol);
                    sb2.append(")");
                    throw new HttpDataSourceException(sb2.toString(), dataSpec, 2001, 1);
                }
                return url2;
            }
            catch (final MalformedURLException ex) {
                throw new HttpDataSourceException(ex, dataSpec, 2001, 1);
            }
        }
        throw new HttpDataSourceException("Null location redirect", dataSpec, 2001, 1);
    }
    
    private static boolean y(final HttpURLConnection httpURLConnection) {
        return "gzip".equalsIgnoreCase(httpURLConnection.getHeaderField("Content-Encoding"));
    }
    
    private HttpURLConnection z(final DataSpec dataSpec) throws IOException {
        URL url = new URL(dataSpec.a.toString());
        int c = dataSpec.c;
        byte[] d = dataSpec.d;
        final long g = dataSpec.g;
        final long h = dataSpec.h;
        final boolean d2 = dataSpec.d(1);
        if (!this.e && !this.k) {
            return this.A(url, c, d, g, h, d2, true, dataSpec.e);
        }
        int n = 0;
        while (true) {
            final int n2 = n + 1;
            if (n > 20) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Too many redirects: ");
                sb.append(n2);
                throw new HttpDataSourceException(new NoRouteToHostException(sb.toString()), dataSpec, 2001, 1);
            }
            final HttpURLConnection a = this.A(url, c, d, g, h, d2, false, dataSpec.e);
            final int responseCode = a.getResponseCode();
            final String headerField = a.getHeaderField("Location");
            if ((c == 1 || c == 3) && (responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303 || responseCode == 307 || responseCode == 308)) {
                a.disconnect();
                url = this.x(url, headerField, dataSpec);
            }
            else {
                if (c != 2 || (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303)) {
                    return a;
                }
                a.disconnect();
                if (!this.k || responseCode != 302) {
                    d = null;
                    c = 1;
                }
                url = this.x(url, headerField, dataSpec);
            }
            n = n2;
        }
    }
    
    HttpURLConnection C(final URL url) throws IOException {
        return (HttpURLConnection)FirebasePerfUrlConnection.instrument((Object)url.openConnection());
    }
    
    @Override
    public long b(final DataSpec m) throws HttpDataSourceException {
        this.m = m;
        long n = 0L;
        this.s = 0L;
        this.r = 0L;
        this.u(m);
        try {
            final HttpURLConnection z = this.z(m);
            this.n = z;
            this.q = z.getResponseCode();
            final String responseMessage = z.getResponseMessage();
            final int q = this.q;
            final long n2 = -1L;
            if (q >= 200) {
                if (q <= 299) {
                    final String contentType = z.getContentType();
                    final Predicate<String> l = this.l;
                    if (l != null && !l.apply((Object)contentType)) {
                        this.w();
                        throw new InvalidContentTypeException(contentType, m);
                    }
                    long n3 = n;
                    if (this.q == 200) {
                        final long g = m.g;
                        n3 = n;
                        if (g != 0L) {
                            n3 = g;
                        }
                    }
                    final boolean y = y(z);
                    if (!y) {
                        final long h = m.h;
                        if (h != -1L) {
                            this.r = h;
                        }
                        else {
                            final long b = HttpUtil.b(z.getHeaderField("Content-Length"), z.getHeaderField("Content-Range"));
                            long r = n2;
                            if (b != -1L) {
                                r = b - n3;
                            }
                            this.r = r;
                        }
                    }
                    else {
                        this.r = m.h;
                    }
                    try {
                        this.o = z.getInputStream();
                        if (y) {
                            this.o = new GZIPInputStream(this.o);
                        }
                        this.p = true;
                        this.v(m);
                        try {
                            this.E(n3, m);
                            return this.r;
                        }
                        catch (final IOException ex) {
                            this.w();
                            if (ex instanceof HttpDataSourceException) {
                                throw (HttpDataSourceException)ex;
                            }
                            throw new HttpDataSourceException(ex, m, 2000, 1);
                        }
                    }
                    catch (final IOException ex2) {
                        this.w();
                        throw new HttpDataSourceException(ex2, m, 2000, 1);
                    }
                }
            }
            final Map<String, List<String>> headerFields = z.getHeaderFields();
            if (this.q == 416 && m.g == HttpUtil.c(z.getHeaderField("Content-Range"))) {
                this.p = true;
                this.v(m);
                final long h2 = m.h;
                if (h2 != -1L) {
                    n = h2;
                }
                return n;
            }
            final InputStream errorStream = z.getErrorStream();
            while (true) {
                if (errorStream != null) {
                    byte[] array = null;
                    Label_0477: {
                        try {
                            array = Util.Z0(errorStream);
                            break Label_0477;
                            array = Util.f;
                        }
                        catch (final IOException ex3) {
                            array = Util.f;
                        }
                    }
                    this.w();
                    IOException ex4;
                    if (this.q == 416) {
                        ex4 = new DataSourceException(2008);
                    }
                    else {
                        ex4 = null;
                    }
                    throw new InvalidResponseCodeException(this.q, responseMessage, ex4, headerFields, m, array);
                }
                continue;
            }
        }
        catch (final IOException ex5) {
            this.w();
            throw HttpDataSourceException.createForIOException(ex5, m, 1);
        }
    }
    
    @Override
    public void close() throws HttpDataSourceException {
        try {
            final InputStream o = this.o;
            if (o != null) {
                final long r = this.r;
                long n = -1L;
                if (r != -1L) {
                    n = r - this.s;
                }
                B(this.n, n);
                try {
                    o.close();
                }
                catch (final IOException ex) {
                    throw new HttpDataSourceException(ex, Util.j(this.m), 2000, 3);
                }
            }
        }
        finally {
            this.o = null;
            this.w();
            if (this.p) {
                this.p = false;
                this.t();
            }
        }
    }
    
    @Override
    public Map<String, List<String>> g() {
        final HttpURLConnection n = this.n;
        if (n == null) {
            return (Map<String, List<String>>)ImmutableMap.of();
        }
        return (Map<String, List<String>>)new b(n.getHeaderFields());
    }
    
    @Override
    public Uri q() {
        final HttpURLConnection n = this.n;
        Uri parse;
        if (n == null) {
            parse = null;
        }
        else {
            parse = Uri.parse(n.getURL().toString());
        }
        return parse;
    }
    
    @Override
    public int read(final byte[] array, int d, final int n) throws HttpDataSourceException {
        try {
            d = this.D(array, d, n);
            return d;
        }
        catch (final IOException ex) {
            throw HttpDataSourceException.createForIOException(ex, Util.j(this.m), 2);
        }
    }
    
    public static final class Factory implements HttpDataSource.Factory
    {
        private final RequestProperties a;
        private TransferListener b;
        private Predicate<String> c;
        private String d;
        private int e;
        private int f;
        private boolean g;
        private boolean h;
        
        public Factory() {
            this.a = new RequestProperties();
            this.e = 8000;
            this.f = 8000;
        }
        
        public DefaultHttpDataSource a() {
            final DefaultHttpDataSource defaultHttpDataSource = new DefaultHttpDataSource(this.d, this.e, this.f, this.g, this.a, this.c, this.h, null);
            final TransferListener b = this.b;
            if (b != null) {
                defaultHttpDataSource.e(b);
            }
            return defaultHttpDataSource;
        }
        
        public Factory b(final boolean g) {
            this.g = g;
            return this;
        }
        
        public Factory c(final String d) {
            this.d = d;
            return this;
        }
        
        @Override
        public /* bridge */ DataSource createDataSource() {
            return this.a();
        }
        
        @Override
        public /* bridge */ HttpDataSource createDataSource() {
            return this.a();
        }
    }
    
    private static class b extends ForwardingMap<String, List<String>>
    {
        private final Map<String, List<String>> a;
        
        public b(final Map<String, List<String>> a) {
            this.a = a;
        }
        
        public static boolean b(final Map.Entry entry) {
            return g(entry);
        }
        
        public static boolean e(final String s) {
            return k(s);
        }
        
        private static boolean g(final Map.Entry entry) {
            return entry.getKey() != null;
        }
        
        private static boolean k(final String s) {
            return s != null;
        }
        
        public boolean containsKey(final Object o) {
            return o != null && super.containsKey(o);
        }
        
        public boolean containsValue(final Object o) {
            return super.standardContainsValue(o);
        }
        
        protected /* bridge */ Object delegate() {
            return this.delegate();
        }
        
        protected Map<String, List<String>> delegate() {
            return this.a;
        }
        
        public Set<Map.Entry<String, List<String>>> entrySet() {
            return Sets.b(super.entrySet(), (Predicate)com.google.android.exoplayer2.upstream.c.a);
        }
        
        public boolean equals(final Object o) {
            return o != null && super.standardEquals(o);
        }
        
        public /* bridge */ Object get(final Object o) {
            return this.get(o);
        }
        
        public List<String> get(final Object o) {
            List<String> list;
            if (o == null) {
                list = null;
            }
            else {
                list = (List)super.get(o);
            }
            return list;
        }
        
        public int hashCode() {
            return super.standardHashCode();
        }
        
        public boolean isEmpty() {
            final boolean empty = super.isEmpty();
            boolean b = true;
            if (!empty) {
                b = (super.size() == 1 && super.containsKey((Object)null) && b);
            }
            return b;
        }
        
        public Set<String> keySet() {
            return Sets.b(super.keySet(), (Predicate)com.google.android.exoplayer2.upstream.b.a);
        }
        
        public int size() {
            return super.size() - (super.containsKey((Object)null) ? 1 : 0);
        }
    }
}
