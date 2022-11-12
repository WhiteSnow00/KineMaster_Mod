// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.sqlite;

import android.database.Cursor;
import android.database.CursorWindow;
import android.database.AbstractWindowedCursor;
import com.google.android.gms.common.annotation.KeepForSdk;
import android.database.CrossProcessCursor;

@KeepForSdk
public class CursorWrapper extends android.database.CursorWrapper implements CrossProcessCursor
{
    private AbstractWindowedCursor a;
    
    @KeepForSdk
    public void fillWindow(final int n, final CursorWindow cursorWindow) {
        this.a.fillWindow(n, cursorWindow);
    }
    
    @KeepForSdk
    public CursorWindow getWindow() {
        return this.a.getWindow();
    }
    
    public final Cursor getWrappedCursor() {
        return (Cursor)this.a;
    }
    
    public final boolean onMove(final int n, final int n2) {
        return this.a.onMove(n, n2);
    }
}
