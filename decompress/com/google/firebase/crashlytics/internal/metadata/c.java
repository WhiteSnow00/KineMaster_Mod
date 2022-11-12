// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.metadata;

import java.io.Closeable;
import java.io.InputStream;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.io.FileInputStream;
import java.util.Collections;
import com.google.firebase.crashlytics.internal.Logger;
import java.io.File;
import org.json.JSONException;
import java.util.Iterator;
import java.util.HashMap;
import org.json.JSONObject;
import java.util.Map;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import java.nio.charset.Charset;

class c
{
    private static final Charset b;
    private final FileStore a;
    
    static {
        b = Charset.forName("UTF-8");
    }
    
    public c(final FileStore a) {
        this.a = a;
    }
    
    private static Map<String, String> d(String s) throws JSONException {
        final JSONObject jsonObject = new JSONObject(s);
        final HashMap hashMap = new HashMap();
        final Iterator keys = jsonObject.keys();
        while (keys.hasNext()) {
            s = (String)keys.next();
            hashMap.put(s, i(jsonObject, s));
        }
        return hashMap;
    }
    
    private String e(final String s) throws JSONException {
        return i(new JSONObject(s), "userId");
    }
    
    private static void h(final File file) {
        if (file.exists() && file.delete()) {
            final Logger f = Logger.f();
            final StringBuilder sb = new StringBuilder();
            sb.append("Deleted corrupt file: ");
            sb.append(file.getAbsolutePath());
            f.g(sb.toString());
        }
    }
    
    private static String i(final JSONObject jsonObject, final String s) {
        final boolean null = jsonObject.isNull(s);
        String optString = null;
        if (!null) {
            optString = jsonObject.optString(s, (String)null);
        }
        return optString;
    }
    
    public File a(final String s) {
        return this.a.o(s, "internal-keys");
    }
    
    public File b(final String s) {
        return this.a.o(s, "keys");
    }
    
    public File c(final String s) {
        return this.a.o(s, "user-data");
    }
    
    Map<String, String> f(String s, final boolean b) {
        File file;
        if (b) {
            file = this.a(s);
        }
        else {
            file = this.b(s);
        }
        if (!file.exists() || file.length() == 0L) {
            h(file);
            return Collections.emptyMap();
        }
        s = null;
        Label_0117: {
            Object o;
            try {
                o = (s = (String)new FileInputStream(file));
                try {
                    final Object o2 = o;
                    final String s2 = CommonUtils.A((InputStream)o2);
                    final Map<String, String> map = d(s2);
                    final Object o3 = o;
                    final String s3 = "Failed to close user metadata file.";
                    CommonUtils.e((Closeable)o3, s3);
                    return map;
                }
                catch (final Exception ex) {}
            }
            catch (final Exception ex) {
                o = null;
            }
            finally {
                break Label_0117;
            }
            try {
                final Object o2 = o;
                final String s2 = CommonUtils.A((InputStream)o2);
                final Map<String, String> map = d(s2);
                final Object o3 = o;
                final String s3 = "Failed to close user metadata file.";
                CommonUtils.e((Closeable)o3, s3);
                return map;
                s = (String)o;
                final Exception ex;
                Logger.f().l("Error deserializing user metadata.", ex);
                s = (String)o;
                h(file);
                CommonUtils.e((Closeable)o, "Failed to close user metadata file.");
                return Collections.emptyMap();
            }
            finally {}
        }
        CommonUtils.e((Closeable)s, "Failed to close user metadata file.");
    }
    
    public String g(final String s) {
        final File c = this.c(s);
        if (c.exists() && c.length() != 0L) {
            Closeable closeable3 = null;
            Throwable t = null;
            Label_0204: {
                Closeable closeable = null;
                FileInputStream fileInputStream = null;
                try {
                    fileInputStream = (FileInputStream)(closeable = new FileInputStream(c));
                    try {
                        final c c2 = this;
                        final FileInputStream fileInputStream2 = fileInputStream;
                        final String s2 = CommonUtils.A(fileInputStream2);
                        final String s3 = c2.e(s2);
                        final Logger logger = Logger.f();
                        final StringBuilder sb = new(java.lang.StringBuilder.class)();
                        final StringBuilder sb2 = sb;
                        final StringBuilder sb3 = sb2;
                        new StringBuilder();
                        final StringBuilder sb4 = sb2;
                        final String s4 = "Loaded userId ";
                        sb4.append(s4);
                        final StringBuilder sb5 = sb2;
                        final String s5 = s3;
                        sb5.append(s5);
                        final StringBuilder sb6 = sb2;
                        final String s6 = " for session ";
                        sb6.append(s6);
                        final StringBuilder sb7 = sb2;
                        final String s7 = s;
                        sb7.append(s7);
                        final Logger logger2 = logger;
                        final StringBuilder sb8 = sb2;
                        final String s8 = sb8.toString();
                        logger2.b(s8);
                        final FileInputStream fileInputStream3 = fileInputStream;
                        final String s9 = "Failed to close user metadata file.";
                        CommonUtils.e(fileInputStream3, s9);
                        return s3;
                    }
                    catch (final Exception closeable) {}
                }
                catch (final Exception ex) {
                    final Closeable closeable2 = null;
                }
                finally {
                    final Exception ex2;
                    closeable = (Closeable)ex2;
                    break Label_0204;
                }
                try {
                    final c c2 = this;
                    final FileInputStream fileInputStream2 = fileInputStream;
                    final String s2 = CommonUtils.A(fileInputStream2);
                    final String s3 = c2.e(s2);
                    final Logger logger = Logger.f();
                    final StringBuilder sb = new(java.lang.StringBuilder.class)();
                    final StringBuilder sb3;
                    final StringBuilder sb2 = sb3 = sb;
                    new StringBuilder();
                    final StringBuilder sb4 = sb2;
                    final String s4 = "Loaded userId ";
                    sb4.append(s4);
                    final StringBuilder sb5 = sb2;
                    final String s5 = s3;
                    sb5.append(s5);
                    final StringBuilder sb6 = sb2;
                    final String s6 = " for session ";
                    sb6.append(s6);
                    final StringBuilder sb7 = sb2;
                    final String s7 = s;
                    sb7.append(s7);
                    final Logger logger2 = logger;
                    final StringBuilder sb8 = sb2;
                    final String s8 = sb8.toString();
                    logger2.b(s8);
                    final FileInputStream fileInputStream3 = fileInputStream;
                    final String s9 = "Failed to close user metadata file.";
                    CommonUtils.e(fileInputStream3, s9);
                    return s3;
                    final Closeable closeable2;
                    closeable = closeable2;
                    final Exception ex;
                    Logger.f().l("Error deserializing user metadata.", ex);
                    closeable = closeable2;
                    h(c);
                    CommonUtils.e(closeable2, "Failed to close user metadata file.");
                    return null;
                }
                finally {
                    closeable3 = closeable;
                    final Throwable t2;
                    t = t2;
                }
            }
            CommonUtils.e(closeable3, "Failed to close user metadata file.");
            throw t;
        }
        final Logger f = Logger.f();
        final StringBuilder sb9 = new StringBuilder();
        sb9.append("No userId set for session ");
        sb9.append(s);
        f.b(sb9.toString());
        h(c);
        return null;
    }
}
