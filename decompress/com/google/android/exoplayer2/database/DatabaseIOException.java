// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.database;

import android.database.SQLException;
import java.io.IOException;

public final class DatabaseIOException extends IOException
{
    public DatabaseIOException(final SQLException ex) {
        super((Throwable)ex);
    }
    
    public DatabaseIOException(final SQLException ex, final String s) {
        super(s, (Throwable)ex);
    }
}
