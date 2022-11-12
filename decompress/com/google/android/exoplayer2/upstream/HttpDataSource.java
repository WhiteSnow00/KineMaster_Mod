// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.upstream;

import java.util.Collections;
import java.util.HashMap;
import com.google.android.exoplayer2.util.Util;
import java.util.List;
import java.util.Map;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import com.google.common.base.Ascii;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.io.IOException;

public interface HttpDataSource extends DataSource
{
    public abstract static class BaseFactory implements Factory
    {
        private final RequestProperties a;
        
        public BaseFactory() {
            this.a = new RequestProperties();
        }
        
        protected abstract HttpDataSource a(final RequestProperties p0);
        
        @Override
        public /* bridge */ DataSource createDataSource() {
            return this.createDataSource();
        }
        
        @Override
        public final HttpDataSource createDataSource() {
            return this.a(this.a);
        }
    }
    
    public interface Factory extends DataSource.Factory
    {
        default /* bridge */ DataSource createDataSource() {
            return this.createDataSource();
        }
        
        HttpDataSource createDataSource();
    }
    
    public static final class CleartextNotPermittedException extends HttpDataSourceException
    {
        public CleartextNotPermittedException(final IOException ex, final DataSpec dataSpec) {
            super("Cleartext HTTP traffic not permitted. See https://exoplayer.dev/issues/cleartext-not-permitted", ex, dataSpec, 2007, 1);
        }
    }
    
    public static class HttpDataSourceException extends DataSourceException
    {
        public static final int TYPE_CLOSE = 3;
        public static final int TYPE_OPEN = 1;
        public static final int TYPE_READ = 2;
        public final DataSpec dataSpec;
        public final int type;
        
        @Deprecated
        public HttpDataSourceException(final DataSpec dataSpec, final int n) {
            this(dataSpec, 2000, n);
        }
        
        public HttpDataSourceException(final DataSpec dataSpec, final int n, final int type) {
            super(a(n, type));
            this.dataSpec = dataSpec;
            this.type = type;
        }
        
        @Deprecated
        public HttpDataSourceException(final IOException ex, final DataSpec dataSpec, final int n) {
            this(ex, dataSpec, 2000, n);
        }
        
        public HttpDataSourceException(final IOException ex, final DataSpec dataSpec, final int n, final int type) {
            super(ex, a(n, type));
            this.dataSpec = dataSpec;
            this.type = type;
        }
        
        @Deprecated
        public HttpDataSourceException(final String s, final DataSpec dataSpec, final int n) {
            this(s, dataSpec, 2000, n);
        }
        
        public HttpDataSourceException(final String s, final DataSpec dataSpec, final int n, final int type) {
            super(s, a(n, type));
            this.dataSpec = dataSpec;
            this.type = type;
        }
        
        @Deprecated
        public HttpDataSourceException(final String s, final IOException ex, final DataSpec dataSpec, final int n) {
            this(s, ex, dataSpec, 2000, n);
        }
        
        public HttpDataSourceException(final String s, final IOException ex, final DataSpec dataSpec, final int n, final int type) {
            super(s, ex, a(n, type));
            this.dataSpec = dataSpec;
            this.type = type;
        }
        
        private static int a(final int n, final int n2) {
            int n3 = n;
            if (n == 2000) {
                n3 = n;
                if (n2 == 1) {
                    n3 = 2001;
                }
            }
            return n3;
        }
        
        public static HttpDataSourceException createForIOException(final IOException ex, final DataSpec dataSpec, final int n) {
            final String message = ex.getMessage();
            int n2;
            if (ex instanceof SocketTimeoutException) {
                n2 = 2002;
            }
            else if (ex instanceof InterruptedIOException) {
                n2 = 1004;
            }
            else if (message != null && Ascii.e(message).matches("cleartext.*not permitted.*")) {
                n2 = 2007;
            }
            else {
                n2 = 2001;
            }
            DataSourceException ex2;
            if (n2 == 2007) {
                ex2 = new CleartextNotPermittedException(ex, dataSpec);
            }
            else {
                ex2 = new HttpDataSourceException(ex, dataSpec, n2, n);
            }
            return (HttpDataSourceException)ex2;
        }
        
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        @Target({ ElementType.TYPE_USE })
        public @interface Type {
        }
    }
    
    public static final class InvalidContentTypeException extends HttpDataSourceException
    {
        public final String contentType;
        
        public InvalidContentTypeException(final String contentType, final DataSpec dataSpec) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Invalid content type: ");
            sb.append(contentType);
            super(sb.toString(), dataSpec, 2003, 1);
            this.contentType = contentType;
        }
    }
    
    public static final class InvalidResponseCodeException extends HttpDataSourceException
    {
        public final Map<String, List<String>> headerFields;
        public final byte[] responseBody;
        public final int responseCode;
        public final String responseMessage;
        
        public InvalidResponseCodeException(final int responseCode, final String responseMessage, final IOException ex, final Map<String, List<String>> headerFields, final DataSpec dataSpec, final byte[] responseBody) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Response code: ");
            sb.append(responseCode);
            super(sb.toString(), ex, dataSpec, 2004, 1);
            this.responseCode = responseCode;
            this.responseMessage = responseMessage;
            this.headerFields = headerFields;
            this.responseBody = responseBody;
        }
        
        @Deprecated
        public InvalidResponseCodeException(final int n, final String s, final Map<String, List<String>> map, final DataSpec dataSpec) {
            this(n, s, null, map, dataSpec, Util.f);
        }
        
        @Deprecated
        public InvalidResponseCodeException(final int n, final Map<String, List<String>> map, final DataSpec dataSpec) {
            this(n, null, null, map, dataSpec, Util.f);
        }
    }
    
    public static final class RequestProperties
    {
        private final Map<String, String> a;
        private Map<String, String> b;
        
        public RequestProperties() {
            this.a = new HashMap<String, String>();
        }
        
        public Map<String, String> a() {
            synchronized (this) {
                if (this.b == null) {
                    this.b = Collections.unmodifiableMap((Map<? extends String, ? extends String>)new HashMap<String, String>(this.a));
                }
                return this.b;
            }
        }
    }
}
