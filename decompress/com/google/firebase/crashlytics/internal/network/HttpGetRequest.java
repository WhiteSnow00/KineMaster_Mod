// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.network;

import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import com.google.firebase.crashlytics.internal.Logger;
import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;

public class HttpGetRequest
{
    private final String a;
    private final Map<String, String> b;
    private final Map<String, String> c;
    
    public HttpGetRequest(final String a, final Map<String, String> b) {
        this.a = a;
        this.b = b;
        this.c = new HashMap<String, String>();
    }
    
    private String a(final Map<String, String> map) {
        final StringBuilder sb = new StringBuilder();
        final Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        final Map.Entry<String, String> entry = iterator.next();
        final StringBuilder sb2 = new StringBuilder();
        sb2.append(entry.getKey());
        sb2.append("=");
        String s;
        if (entry.getValue() != null) {
            s = entry.getValue();
        }
        else {
            s = "";
        }
        sb2.append(s);
        sb.append(sb2.toString());
        while (iterator.hasNext()) {
            final Map.Entry<String, String> entry2 = iterator.next();
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("&");
            sb3.append(entry2.getKey());
            sb3.append("=");
            String s2;
            if (entry2.getValue() != null) {
                s2 = entry2.getValue();
            }
            else {
                s2 = "";
            }
            sb3.append(s2);
            sb.append(sb3.toString());
        }
        return sb.toString();
    }
    
    private String b(final String s, final Map<String, String> map) {
        final String a = this.a(map);
        if (a.isEmpty()) {
            return s;
        }
        if (s.contains("?")) {
            String string = a;
            if (!s.endsWith("&")) {
                final StringBuilder sb = new StringBuilder();
                sb.append("&");
                sb.append(a);
                string = sb.toString();
            }
            final StringBuilder sb2 = new StringBuilder();
            sb2.append(s);
            sb2.append(string);
            return sb2.toString();
        }
        final StringBuilder sb3 = new StringBuilder();
        sb3.append(s);
        sb3.append("?");
        sb3.append(a);
        return sb3.toString();
    }
    
    private String e(final InputStream inputStream) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        final char[] array = new char[8192];
        final StringBuilder sb = new StringBuilder();
        while (true) {
            final int read = bufferedReader.read(array);
            if (read == -1) {
                break;
            }
            sb.append(array, 0, read);
        }
        return sb.toString();
    }
    
    public HttpResponse c() throws IOException {
        InputStream inputStream = null;
        final String s = null;
        HttpURLConnection httpURLConnection;
        try {
            final String b = this.b(this.a, this.b);
            final Logger f = Logger.f();
            final StringBuilder sb = new StringBuilder();
            sb.append("GET Request URL: ");
            sb.append(b);
            f.i(sb.toString());
            final HttpsURLConnection httpsURLConnection = (HttpsURLConnection)new URL(b).openConnection();
            try {
                httpsURLConnection.setReadTimeout(10000);
                httpsURLConnection.setConnectTimeout(10000);
                httpsURLConnection.setRequestMethod("GET");
                for (final Map.Entry entry : this.c.entrySet()) {
                    httpsURLConnection.addRequestProperty((String)entry.getKey(), (String)entry.getValue());
                }
                httpsURLConnection.connect();
                final int responseCode = httpsURLConnection.getResponseCode();
                final InputStream inputStream2 = httpsURLConnection.getInputStream();
                if (inputStream2 != null) {
                    try {
                        this.e(inputStream2);
                    }
                    finally {
                        inputStream = inputStream2;
                    }
                }
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                httpsURLConnection.disconnect();
                return new HttpResponse(responseCode, s);
            }
            finally {}
        }
        finally {
            httpURLConnection = null;
        }
        if (inputStream != null) {
            inputStream.close();
        }
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }
    
    public HttpGetRequest d(final String s, final String s2) {
        this.c.put(s, s2);
        return this;
    }
}
