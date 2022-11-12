// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.cct;

import java.util.Map;
import com.google.android.datatransport.runtime.retries.RetryStrategy;
import com.google.android.datatransport.runtime.retries.Function;
import com.google.android.datatransport.runtime.retries.Retries;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import java.util.Locale;
import android.os.Build;
import android.os.Build$VERSION;
import java.net.MalformedURLException;
import java.util.zip.GZIPInputStream;
import java.util.TimeZone;
import java.util.Calendar;
import android.telephony.TelephonyManager;
import com.google.android.datatransport.runtime.EncodedPayload;
import java.util.Iterator;
import java.nio.charset.Charset;
import com.google.android.datatransport.cct.internal.LogEvent;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.cct.internal.AndroidClientInfo;
import com.google.android.datatransport.cct.internal.ClientInfo;
import com.google.android.datatransport.cct.internal.QosTier;
import com.google.android.datatransport.cct.internal.LogRequest;
import java.util.List;
import java.util.ArrayList;
import com.google.android.datatransport.runtime.EventInternal;
import java.util.HashMap;
import com.google.android.datatransport.runtime.backends.BackendRequest;
import android.content.pm.PackageManager$NameNotFoundException;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo;
import android.net.NetworkInfo;
import java.io.Closeable;
import java.net.ConnectException;
import java.net.UnknownHostException;
import com.google.firebase.encoders.EncodingException;
import java.io.IOException;
import com.google.android.datatransport.cct.internal.LogResponse;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.zip.GZIPOutputStream;
import java.net.HttpURLConnection;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.cct.internal.BatchedLogRequest;
import com.google.android.datatransport.runtime.time.Clock;
import java.net.URL;
import android.content.Context;
import android.net.ConnectivityManager;
import com.google.firebase.encoders.DataEncoder;
import com.google.android.datatransport.runtime.backends.TransportBackend;

final class c implements TransportBackend
{
    private final DataEncoder a;
    private final ConnectivityManager b;
    private final Context c;
    final URL d;
    private final Clock e;
    private final Clock f;
    private final int g;
    
    c(final Context context, final Clock clock, final Clock clock2) {
        this(context, clock, clock2, 130000);
    }
    
    c(final Context c, final Clock f, final Clock e, final int g) {
        this.a = BatchedLogRequest.b();
        this.c = c;
        this.b = (ConnectivityManager)c.getSystemService("connectivity");
        this.d = n(CCTDestination.c);
        this.e = e;
        this.f = f;
        this.g = g;
    }
    
    public static a c(final a a, final b b) {
        return l(a, b);
    }
    
    public static b d(final c c, final a a) {
        return c.e(a);
    }
    
    private b e(a inputStream) throws IOException {
        Logging.e("CctTransportBackend", "Making request to: %s", ((a)inputStream).a);
        final HttpURLConnection httpURLConnection = (HttpURLConnection)((a)inputStream).a.openConnection();
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(this.g);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("User-Agent", String.format("datatransport/%s android/", "3.1.7"));
        httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        final String c = ((a)inputStream).c;
        if (c != null) {
            httpURLConnection.setRequestProperty("X-Goog-Api-Key", c);
        }
        try {
            final OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                Closeable closeable = new GZIPOutputStream(outputStream);
                try {
                    this.a.a((Object)((a)inputStream).b, (Writer)new BufferedWriter(new OutputStreamWriter((OutputStream)closeable)));
                    ((OutputStream)closeable).close();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    final int responseCode = httpURLConnection.getResponseCode();
                    Logging.e("CctTransportBackend", "Status Code: %d", responseCode);
                    Logging.a("CctTransportBackend", "Content-Type: %s", httpURLConnection.getHeaderField("Content-Type"));
                    Logging.a("CctTransportBackend", "Content-Encoding: %s", httpURLConnection.getHeaderField("Content-Encoding"));
                    if (responseCode != 302 && responseCode != 301) {
                        if (responseCode != 307) {
                            if (responseCode != 200) {
                                return new b(responseCode, null, 0L);
                            }
                            inputStream = (IOException)httpURLConnection.getInputStream();
                            try {
                                final InputStream m = m((InputStream)inputStream, httpURLConnection.getHeaderField("Content-Encoding"));
                                try {
                                    closeable = new BufferedReader(new InputStreamReader(m));
                                    final b b = new b(responseCode, null, LogResponse.b((Reader)closeable).c());
                                    if (m != null) {
                                        m.close();
                                    }
                                    if (inputStream != null) {
                                        ((InputStream)inputStream).close();
                                    }
                                    return b;
                                }
                                finally {
                                    if (m != null) {
                                        try {
                                            m.close();
                                        }
                                        finally {
                                            final Throwable t;
                                            final Throwable t2;
                                            t.addSuppressed(t2);
                                        }
                                    }
                                }
                            }
                            finally {
                                if (inputStream != null) {
                                    try {
                                        ((InputStream)inputStream).close();
                                    }
                                    finally {
                                        final Throwable t3;
                                        ((Throwable)outputStream).addSuppressed(t3);
                                    }
                                }
                            }
                        }
                    }
                    return new b(responseCode, new URL(httpURLConnection.getHeaderField("Location")), 0L);
                }
                finally {
                    try {
                        ((OutputStream)closeable).close();
                    }
                    finally {
                        final Throwable t4;
                        inputStream.addSuppressed(t4);
                    }
                }
            }
            finally {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    }
                    finally {
                        final Throwable t5;
                        inputStream.addSuppressed(t5);
                    }
                }
            }
        }
        catch (final IOException inputStream) {
            goto Label_0501;
        }
        catch (final EncodingException ex) {}
        catch (final UnknownHostException inputStream) {}
        catch (final ConnectException ex2) {}
        Logging.c("CctTransportBackend", "Couldn't open connection, returning with 500", inputStream);
        return new b(500, null, 0L);
    }
    
    private static int f(final NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return NetworkConnectionInfo.MobileSubtype.UNKNOWN_MOBILE_SUBTYPE.getValue();
        }
        int subtype = networkInfo.getSubtype();
        if (subtype == -1) {
            return NetworkConnectionInfo.MobileSubtype.COMBINED.getValue();
        }
        if (NetworkConnectionInfo.MobileSubtype.forNumber(subtype) == null) {
            subtype = 0;
        }
        return subtype;
    }
    
    private static int g(final NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return NetworkConnectionInfo.NetworkType.NONE.getValue();
        }
        return networkInfo.getType();
    }
    
    private static int h(final Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        }
        catch (final PackageManager$NameNotFoundException ex) {
            Logging.c("CctTransportBackend", "Unable to find version code for package", (Throwable)ex);
            return -1;
        }
    }
    
    private BatchedLogRequest i(BackendRequest backendRequest) {
        final HashMap hashMap = new HashMap();
        for (final EventInternal eventInternal : backendRequest.b()) {
            final String j = eventInternal.j();
            if (!hashMap.containsKey(j)) {
                final ArrayList list = new ArrayList();
                list.add(eventInternal);
                hashMap.put(j, list);
            }
            else {
                ((List<EventInternal>)hashMap.get(j)).add(eventInternal);
            }
        }
        final ArrayList list2 = new ArrayList();
        final Iterator iterator2 = hashMap.entrySet().iterator();
        while (iterator2.hasNext()) {
            backendRequest = (BackendRequest)iterator2.next();
            final EventInternal eventInternal2 = ((Map.Entry<K, List<EventInternal>>)backendRequest).getValue().get(0);
            final LogRequest.Builder b = LogRequest.a().f(QosTier.DEFAULT).g(this.f.a()).h(this.e.a()).b(ClientInfo.a().c(ClientInfo.ClientType.ANDROID_FIREBASE).b(AndroidClientInfo.a().m(eventInternal2.g("sdk-version")).j(eventInternal2.b("model")).f(eventInternal2.b("hardware")).d(eventInternal2.b("device")).l(eventInternal2.b("product")).k(eventInternal2.b("os-uild")).h(eventInternal2.b("manufacturer")).e(eventInternal2.b("fingerprint")).c(eventInternal2.b("country")).g(eventInternal2.b("locale")).i(eventInternal2.b("mcc_mnc")).b(eventInternal2.b("application_build")).a()).a());
            try {
                b.i(Integer.parseInt(((Map.Entry<String, V>)backendRequest).getKey()));
            }
            catch (final NumberFormatException ex) {
                b.j(((Map.Entry<String, V>)backendRequest).getKey());
            }
            final ArrayList list3 = new ArrayList();
            for (final EventInternal eventInternal3 : ((Map.Entry<K, List>)backendRequest).getValue()) {
                final EncodedPayload e = eventInternal3.e();
                final Encoding b2 = e.b();
                LogEvent.Builder builder;
                if (b2.equals(Encoding.b("proto"))) {
                    builder = LogEvent.j(e.a());
                }
                else {
                    if (!b2.equals(Encoding.b("json"))) {
                        Logging.f("CctTransportBackend", "Received event of unsupported encoding %s. Skipping...", b2);
                        continue;
                    }
                    builder = LogEvent.i(new String(e.a(), Charset.forName("UTF-8")));
                }
                builder.c(eventInternal3.f()).d(eventInternal3.k()).h(eventInternal3.h("tz-offset")).e(NetworkConnectionInfo.a().c(NetworkConnectionInfo.NetworkType.forNumber(eventInternal3.g("net-type"))).b(NetworkConnectionInfo.MobileSubtype.forNumber(eventInternal3.g("mobile-subtype"))).a());
                if (eventInternal3.d() != null) {
                    builder.b(eventInternal3.d());
                }
                list3.add(builder.a());
            }
            b.c(list3);
            list2.add(b.a());
        }
        return BatchedLogRequest.a(list2);
    }
    
    private static TelephonyManager j(final Context context) {
        return (TelephonyManager)context.getSystemService("phone");
    }
    
    static long k() {
        Calendar.getInstance();
        return TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / 1000;
    }
    
    private static a l(final a a, final b b) {
        final URL b2 = b.b;
        if (b2 != null) {
            Logging.a("CctTransportBackend", "Following redirect to: %s", b2);
            return a.a(b.b);
        }
        return null;
    }
    
    private static InputStream m(final InputStream inputStream, final String s) throws IOException {
        if ("gzip".equals(s)) {
            return new GZIPInputStream(inputStream);
        }
        return inputStream;
    }
    
    private static URL n(final String s) {
        try {
            return new URL(s);
        }
        catch (final MalformedURLException ex) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Invalid url: ");
            sb.append(s);
            throw new IllegalArgumentException(sb.toString(), ex);
        }
    }
    
    @Override
    public EventInternal a(final EventInternal eventInternal) {
        final NetworkInfo activeNetworkInfo = this.b.getActiveNetworkInfo();
        return eventInternal.l().a("sdk-version", Build$VERSION.SDK_INT).c("model", Build.MODEL).c("hardware", Build.HARDWARE).c("device", Build.DEVICE).c("product", Build.PRODUCT).c("os-uild", Build.ID).c("manufacturer", Build.MANUFACTURER).c("fingerprint", Build.FINGERPRINT).b("tz-offset", k()).a("net-type", g(activeNetworkInfo)).a("mobile-subtype", f(activeNetworkInfo)).c("country", Locale.getDefault().getCountry()).c("locale", Locale.getDefault().getLanguage()).c("mcc_mnc", j(this.c).getSimOperator()).c("application_build", Integer.toString(h(this.c))).d();
    }
    
    @Override
    public BackendResponse b(final BackendRequest backendRequest) {
        final BatchedLogRequest i = this.i(backendRequest);
        final URL d = this.d;
        final byte[] c = backendRequest.c();
        String s = null;
        final String s2 = null;
        URL n = d;
        if (c != null) {
            try {
                final CCTDestination c2 = CCTDestination.c(backendRequest.c());
                String d2 = s2;
                if (c2.d() != null) {
                    d2 = c2.d();
                }
                n = d;
                s = d2;
                if (c2.e() != null) {
                    n = n(c2.e());
                    s = d2;
                }
            }
            catch (final IllegalArgumentException ex) {
                return BackendResponse.a();
            }
        }
        try {
            final b b = Retries.a(5, new a(n, i, s), (Function<a, b, Throwable>)new com.google.android.datatransport.cct.a(this), com.google.android.datatransport.cct.b.a);
            final int a = b.a;
            if (a == 200) {
                return BackendResponse.e(b.c);
            }
            if (a >= 500 || a == 404) {
                return BackendResponse.f();
            }
            if (a == 400) {
                return BackendResponse.d();
            }
            return BackendResponse.a();
        }
        catch (final IOException ex2) {
            Logging.c("CctTransportBackend", "Could not make request to the backend", ex2);
            return BackendResponse.f();
        }
    }
    
    static final class a
    {
        final URL a;
        final BatchedLogRequest b;
        final String c;
        
        a(final URL a, final BatchedLogRequest b, final String c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        
        a a(final URL url) {
            return new a(url, this.b, this.c);
        }
    }
    
    static final class b
    {
        final int a;
        final URL b;
        final long c;
        
        b(final int a, final URL b, final long c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}
