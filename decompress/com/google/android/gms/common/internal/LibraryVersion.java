// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import java.io.Serializable;
import java.io.IOException;
import java.io.Closeable;
import com.google.android.gms.common.util.IOUtils;
import java.io.InputStream;
import java.util.Properties;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.ConcurrentHashMap;
import com.google.android.gms.common.annotation.KeepForSdk;

@Deprecated
@KeepForSdk
public class LibraryVersion
{
    private static final GmsLogger b;
    private static LibraryVersion c;
    private ConcurrentHashMap a;
    
    static {
        b = new GmsLogger("LibraryVersion", "");
        LibraryVersion.c = new LibraryVersion();
    }
    
    @VisibleForTesting
    protected LibraryVersion() {
        this.a = new ConcurrentHashMap();
    }
    
    @KeepForSdk
    public static LibraryVersion a() {
        return LibraryVersion.c;
    }
    
    @Deprecated
    @KeepForSdk
    public String b(final String s) {
        Preconditions.h(s, "Please provide a valid libraryName");
        if (this.a.containsKey(s)) {
            return this.a.get(s);
        }
        final Properties properties = new Properties();
        Object b = null;
        Serializable property = null;
        Object b2 = null;
        Object o = null;
        Label_0339: {
            Object resourceAsStream;
            try {
                try {
                    resourceAsStream = LibraryVersion.class.getResourceAsStream(String.format("/%s.properties", s));
                    Label_0162: {
                        if (resourceAsStream == null) {
                            break Label_0162;
                        }
                        property = (Serializable)b;
                        try {
                            properties.load((InputStream)resourceAsStream);
                            property = (Serializable)b;
                            o = (property = properties.getProperty("version", null));
                            b = LibraryVersion.b;
                            property = (Serializable)o;
                            b2 = new(java.lang.StringBuilder.class)();
                            property = (Serializable)o;
                            new StringBuilder();
                            property = (Serializable)o;
                            ((StringBuilder)b2).append(s);
                            property = (Serializable)o;
                            ((StringBuilder)b2).append(" version is ");
                            property = (Serializable)o;
                            ((StringBuilder)b2).append((String)o);
                            property = (Serializable)o;
                            ((GmsLogger)b).d("LibraryVersion", ((StringBuilder)b2).toString());
                            property = (Serializable)o;
                            if (resourceAsStream == null) {
                                break Label_0339;
                            }
                            IOUtils.a((Closeable)resourceAsStream);
                            property = (Serializable)b;
                            b2 = LibraryVersion.b;
                            property = (Serializable)b;
                            property = (Serializable)b;
                            final StringBuilder sb = new StringBuilder();
                            property = (Serializable)b;
                            sb.append("Failed to get app version for libraryName: ");
                            property = (Serializable)b;
                            sb.append(s);
                            property = (Serializable)b;
                            ((GmsLogger)b2).e("LibraryVersion", sb.toString());
                        }
                        catch (final IOException b) {}
                        finally {
                            property = (Serializable)resourceAsStream;
                        }
                    }
                }
                finally {}
            }
            catch (final IOException b) {
                o = null;
                resourceAsStream = b2;
            }
            final GmsLogger b3 = LibraryVersion.b;
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Failed to get app version for libraryName: ");
            sb2.append(s);
            b3.c("LibraryVersion", sb2.toString(), (Throwable)b);
            if (resourceAsStream != null) {
                IOUtils.a((Closeable)resourceAsStream);
            }
            property = (Serializable)o;
        }
        String s2;
        if ((s2 = (String)property) == null) {
            LibraryVersion.b.b("LibraryVersion", ".properties file is dropped during release process. Failure to read app version is expected during Google internal testing where locally-built libraries are used");
            s2 = "UNKNOWN";
        }
        this.a.put(s, s2);
        return s2;
        if (property != null) {
            IOUtils.a((Closeable)property);
        }
    }
}
