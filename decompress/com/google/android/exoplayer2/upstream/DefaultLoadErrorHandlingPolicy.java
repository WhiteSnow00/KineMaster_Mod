// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.upstream;

import java.io.IOException;
import java.io.FileNotFoundException;
import com.google.android.exoplayer2.ParserException;

public class DefaultLoadErrorHandlingPolicy implements LoadErrorHandlingPolicy
{
    private final int a;
    
    public DefaultLoadErrorHandlingPolicy() {
        this(-1);
    }
    
    public DefaultLoadErrorHandlingPolicy(final int a) {
        this.a = a;
    }
    
    @Override
    public long a(final LoadErrorInfo loadErrorInfo) {
        final IOException c = loadErrorInfo.c;
        long n;
        if (!(c instanceof ParserException) && !(c instanceof FileNotFoundException) && !(c instanceof HttpDataSource.CleartextNotPermittedException) && !(c instanceof Loader.UnexpectedLoaderException) && !DataSourceException.isCausedByPositionOutOfRange(c)) {
            n = Math.min((loadErrorInfo.d - 1) * 1000, 5000);
        }
        else {
            n = -9223372036854775807L;
        }
        return n;
    }
    
    @Override
    public int b(int n) {
        final int a = this.a;
        if (a == -1) {
            if (n == 7) {
                n = 6;
            }
            else {
                n = 3;
            }
            return n;
        }
        return a;
    }
    
    @Override
    public FallbackSelection c(final FallbackOptions fallbackOptions, final LoadErrorInfo loadErrorInfo) {
        if (!this.e(loadErrorInfo.c)) {
            return null;
        }
        if (fallbackOptions.a(1)) {
            return new FallbackSelection(1, 300000L);
        }
        if (fallbackOptions.a(2)) {
            return new FallbackSelection(2, 60000L);
        }
        return null;
    }
    
    protected boolean e(final IOException ex) {
        final boolean b = ex instanceof HttpDataSource.InvalidResponseCodeException;
        boolean b2 = false;
        if (!b) {
            return false;
        }
        final int responseCode = ((HttpDataSource.InvalidResponseCodeException)ex).responseCode;
        if (responseCode == 403 || responseCode == 404 || responseCode == 410 || responseCode == 416 || responseCode == 500 || responseCode == 503) {
            b2 = true;
        }
        return b2;
    }
}
