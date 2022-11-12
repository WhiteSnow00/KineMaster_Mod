// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load.data;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.net.URLConnection;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import java.net.URISyntaxException;
import java.net.MalformedURLException;
import v2.c;
import android.text.TextUtils;
import android.util.Log;
import java.util.Iterator;
import java.io.IOException;
import com.bumptech.glide.load.HttpException;
import java.util.Map;
import java.net.URL;
import java.net.HttpURLConnection;
import h2.g;
import java.io.InputStream;

public class j implements d<InputStream>
{
    static final b g;
    private final g a;
    private final int b;
    private final b c;
    private HttpURLConnection d;
    private InputStream e;
    private volatile boolean f;
    
    static {
        g = (b)new a();
    }
    
    public j(final g g, final int n) {
        this(g, n, j.g);
    }
    
    j(final g a, final int b, final b c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    private HttpURLConnection c(final URL url, final Map<String, String> map) throws HttpException {
        try {
            final HttpURLConnection a = this.c.a(url);
            for (final Map.Entry entry : map.entrySet()) {
                a.addRequestProperty((String)entry.getKey(), (String)entry.getValue());
            }
            a.setConnectTimeout(this.b);
            a.setReadTimeout(this.b);
            a.setUseCaches(false);
            a.setDoInput(true);
            a.setInstanceFollowRedirects(false);
            return a;
        }
        catch (final IOException ex) {
            throw new HttpException("URL.openConnection threw", 0, ex);
        }
    }
    
    private static int f(final HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getResponseCode();
        }
        catch (final IOException ex) {
            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                Log.d("HttpUrlFetcher", "Failed to get a response code", (Throwable)ex);
            }
            return -1;
        }
    }
    
    private InputStream g(final HttpURLConnection httpURLConnection) throws HttpException {
        try {
            if (TextUtils.isEmpty((CharSequence)httpURLConnection.getContentEncoding())) {
                this.e = v2.c.c(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
            }
            else {
                if (Log.isLoggable("HttpUrlFetcher", 3)) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Got non empty content encoding: ");
                    sb.append(httpURLConnection.getContentEncoding());
                    Log.d("HttpUrlFetcher", sb.toString());
                }
                this.e = httpURLConnection.getInputStream();
            }
            return this.e;
        }
        catch (final IOException ex) {
            throw new HttpException("Failed to obtain InputStream", f(httpURLConnection), ex);
        }
    }
    
    private static boolean h(final int n) {
        return n / 100 == 2;
    }
    
    private static boolean i(final int n) {
        return n / 100 == 3;
    }
    
    private InputStream j(final URL ex, final int n, URL headerField, Map<String, String> sb) throws HttpException {
        Label_0276: {
            if (n >= 5) {
                break Label_0276;
            }
            while (true) {
                if (headerField == null) {
                    break Label_0039;
                }
                try {
                    if (!((URL)ex).toURI().equals(headerField.toURI())) {
                        final HttpURLConnection c = this.c((URL)ex, (Map<String, String>)sb);
                        this.d = c;
                        try {
                            c.connect();
                            this.e = this.d.getInputStream();
                            if (this.f) {
                                return null;
                            }
                            final int f = f(this.d);
                            if (h(f)) {
                                return this.g(this.d);
                            }
                            if (i(f)) {
                                headerField = (URL)this.d.getHeaderField("Location");
                                if (!TextUtils.isEmpty((CharSequence)headerField)) {
                                    try {
                                        final URL url = new URL((URL)ex, (String)headerField);
                                        this.b();
                                        return this.j(url, n + 1, (URL)ex, (Map<String, String>)sb);
                                    }
                                    catch (final MalformedURLException ex2) {
                                        sb = new StringBuilder();
                                        sb.append("Bad redirect url: ");
                                        sb.append((String)headerField);
                                        throw new HttpException(sb.toString(), f, ex2);
                                    }
                                }
                                throw new HttpException("Received empty or null redirect url", f);
                            }
                            if (f == -1) {
                                throw new HttpException(f);
                            }
                            try {
                                throw new HttpException(this.d.getResponseMessage(), f);
                            }
                            catch (final IOException ex3) {
                                throw new HttpException("Failed to get a response message", f, ex3);
                            }
                        }
                        catch (final IOException ex) {
                            throw new HttpException("Failed to connect or obtain data", f(this.d), ex);
                        }
                        throw new HttpException("Too many (> 5) redirects!", -1);
                    }
                    throw new HttpException("In re-direct loop", -1);
                }
                catch (final URISyntaxException ex4) {
                    continue;
                }
                break;
            }
        }
    }
    
    @Override
    public Class<InputStream> a() {
        return InputStream.class;
    }
    
    @Override
    public void b() {
        final InputStream e = this.e;
        while (true) {
            if (e == null) {
                break Label_0013;
            }
            try {
                e.close();
                final HttpURLConnection d = this.d;
                if (d != null) {
                    d.disconnect();
                }
                this.d = null;
            }
            catch (final IOException ex) {
                continue;
            }
            break;
        }
    }
    
    @Override
    public void cancel() {
        this.f = true;
    }
    
    @Override
    public DataSource d() {
        return DataSource.REMOTE;
    }
    
    @Override
    public void e(final Priority priority, final d.a<? super InputStream> a) {
        final long b = v2.g.b();
        try {
            Label_0098: {
                try {
                    a.f(this.j(this.a.h(), 0, null, this.a.e()));
                    if (Log.isLoggable("HttpUrlFetcher", 2)) {
                        final StringBuilder sb = new StringBuilder();
                        break Label_0098;
                    }
                }
                finally {
                    if (Log.isLoggable("HttpUrlFetcher", 2)) {
                        final StringBuilder sb2 = new StringBuilder();
                        sb2.append("Finished http url fetcher fetch in ");
                        sb2.append(v2.g.a(b));
                        Log.v("HttpUrlFetcher", sb2.toString());
                    }
                    StringBuilder sb;
                    while (true) {
                        sb = new StringBuilder();
                        break Label_0098;
                        final IOException ex;
                        Log.d("HttpUrlFetcher", "Failed to load data for url", (Throwable)ex);
                        a.c(ex);
                        iftrue(Label_0125:)(!Log.isLoggable("HttpUrlFetcher", 2));
                        continue;
                    }
                    sb.append("Finished http url fetcher fetch in ");
                    sb.append(v2.g.a(b));
                    Log.v("HttpUrlFetcher", sb.toString());
                    Label_0125:;
                }
            }
        }
        catch (final IOException ex2) {}
    }
    
    private static class a implements b
    {
        a() {
        }
        
        @Override
        public HttpURLConnection a(final URL url) throws IOException {
            return (HttpURLConnection)FirebasePerfUrlConnection.instrument((Object)url.openConnection());
        }
    }
    
    interface b
    {
        HttpURLConnection a(final URL p0) throws IOException;
    }
}
