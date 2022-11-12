// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.upstream;

import java.io.IOException;

public class DataSourceException extends IOException
{
    @Deprecated
    public static final int POSITION_OUT_OF_RANGE = 2008;
    public final int reason;
    
    public DataSourceException(final int reason) {
        this.reason = reason;
    }
    
    public DataSourceException(final String s, final int reason) {
        super(s);
        this.reason = reason;
    }
    
    public DataSourceException(final String s, final Throwable t, final int reason) {
        super(s, t);
        this.reason = reason;
    }
    
    public DataSourceException(final Throwable t, final int reason) {
        super(t);
        this.reason = reason;
    }
    
    public static boolean isCausedByPositionOutOfRange(IOException cause) {
        while (cause != null) {
            if (cause instanceof DataSourceException && ((DataSourceException)cause).reason == 2008) {
                return true;
            }
            cause = (IOException)cause.getCause();
        }
        return false;
    }
}
