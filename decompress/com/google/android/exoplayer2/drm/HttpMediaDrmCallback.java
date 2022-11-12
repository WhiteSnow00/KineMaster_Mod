// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.drm;

import com.google.common.collect.ImmutableMap;
import com.google.android.exoplayer2.C;
import java.util.Collections;
import java.util.UUID;
import java.util.List;
import android.net.Uri;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import java.io.Closeable;
import java.io.InputStream;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.upstream.DataSourceInputStream;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.StatsDataSource;
import java.util.HashMap;
import com.google.android.exoplayer2.util.Assertions;
import android.text.TextUtils;
import java.util.Map;
import com.google.android.exoplayer2.upstream.DataSource;

public final class HttpMediaDrmCallback implements MediaDrmCallback
{
    private final DataSource.Factory a;
    private final String b;
    private final boolean c;
    private final Map<String, String> d;
    
    public HttpMediaDrmCallback(final String b, final boolean c, final DataSource.Factory a) {
        Assertions.a(!c || !TextUtils.isEmpty((CharSequence)b));
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = new HashMap<String, String>();
    }
    
    private static byte[] c(final DataSource.Factory factory, String a, byte[] array, final Map<String, String> map) throws MediaDrmCallbackException {
        final StatsDataSource statsDataSource = new StatsDataSource(factory.createDataSource());
        a = (String)new DataSpec.Builder().j(a).e(map).d(2).c(array).b(1).a();
        int n = 0;
        Object a2 = a;
        try {
            while (true) {
                array = (byte[])(Object)new DataSourceInputStream(statsDataSource, (DataSpec)a2);
                try {
                    try {
                        final byte[] z0 = Util.Z0((InputStream)(Object)array);
                        Util.n((Closeable)(Object)array);
                        return z0;
                    }
                    finally {}
                }
                catch (final HttpDataSource.InvalidResponseCodeException ex) {
                    final String d = d(ex, n);
                    if (d != null) {
                        ++n;
                        a2 = ((DataSpec)factory).a().j(d).a();
                        Util.n((Closeable)(Object)array);
                        continue;
                    }
                    throw ex;
                }
                break;
            }
            Util.n((Closeable)(Object)array);
        }
        catch (final Exception ex2) {
            throw new MediaDrmCallbackException((DataSpec)a, Assertions.e(statsDataSource.s()), statsDataSource.g(), statsDataSource.j(), ex2);
        }
    }
    
    private static String d(final HttpDataSource.InvalidResponseCodeException ex, int n) {
        final int responseCode = ex.responseCode;
        if ((responseCode == 307 || responseCode == 308) && n < 5) {
            n = 1;
        }
        else {
            n = 0;
        }
        if (n == 0) {
            return null;
        }
        final Map<String, List<String>> headerFields = ex.headerFields;
        if (headerFields != null) {
            final List list = headerFields.get("Location");
            if (list != null && !list.isEmpty()) {
                return (String)list.get(0);
            }
        }
        return null;
    }
    
    @Override
    public byte[] a(final UUID uuid, final ExoMediaDrm.ProvisionRequest provisionRequest) throws MediaDrmCallbackException {
        final StringBuilder sb = new StringBuilder();
        sb.append(provisionRequest.b());
        sb.append("&signedRequest=");
        sb.append(Util.D(provisionRequest.a()));
        return c(this.a, sb.toString(), null, Collections.emptyMap());
    }
    
    @Override
    public byte[] b(final UUID uuid, final ExoMediaDrm.KeyRequest keyRequest) throws MediaDrmCallbackException {
        final String b = keyRequest.b();
        String b2 = null;
        Label_0028: {
            if (!this.c) {
                b2 = b;
                if (!TextUtils.isEmpty((CharSequence)b)) {
                    break Label_0028;
                }
            }
            b2 = this.b;
        }
        if (!TextUtils.isEmpty((CharSequence)b2)) {
            final HashMap hashMap = new HashMap();
            final UUID e = C.e;
            String s;
            if (e.equals(uuid)) {
                s = "text/xml";
            }
            else if (C.c.equals(uuid)) {
                s = "application/json";
            }
            else {
                s = "application/octet-stream";
            }
            hashMap.put("Content-Type", s);
            if (e.equals(uuid)) {
                hashMap.put("SOAPAction", "http://schemas.microsoft.com/DRM/2007/03/protocols/AcquireLicense");
            }
            synchronized (this.d) {
                hashMap.putAll(this.d);
                monitorexit(this.d);
                return c(this.a, b2, keyRequest.a(), hashMap);
            }
        }
        throw new MediaDrmCallbackException(new DataSpec.Builder().i(Uri.EMPTY).a(), Uri.EMPTY, (Map<String, List<String>>)ImmutableMap.of(), 0L, new IllegalStateException("No license URL"));
    }
    
    public void e(final String s, final String s2) {
        Assertions.e(s);
        Assertions.e(s2);
        synchronized (this.d) {
            this.d.put(s, s2);
        }
    }
}
