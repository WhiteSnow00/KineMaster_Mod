// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load;

import java.io.IOException;

public final class HttpException extends IOException
{
    public static final int UNKNOWN = -1;
    private static final long serialVersionUID = 1L;
    private final int statusCode;
    
    public HttpException(final int n) {
        this("Http request failed", n);
    }
    
    @Deprecated
    public HttpException(final String s) {
        this(s, -1);
    }
    
    public HttpException(final String s, final int n) {
        this(s, n, null);
    }
    
    public HttpException(final String s, final int statusCode, final Throwable t) {
        final StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.append(", status code: ");
        sb.append(statusCode);
        super(sb.toString(), t);
        this.statusCode = statusCode;
    }
    
    public int getStatusCode() {
        return this.statusCode;
    }
}
