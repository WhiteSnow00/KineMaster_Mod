// 
// Decompiled by Procyon v0.6.0
// 

package w0;

import android.database.sqlite.SQLiteProgram;
import v0.i;

class d implements i
{
    private final SQLiteProgram a;
    
    d(final SQLiteProgram a) {
        this.a = a;
    }
    
    @Override
    public void E0(final int n, final String s) {
        this.a.bindString(n, s);
    }
    
    @Override
    public void G(final int n, final double n2) {
        this.a.bindDouble(n, n2);
    }
    
    @Override
    public void U0(final int n, final long n2) {
        this.a.bindLong(n, n2);
    }
    
    @Override
    public void V0(final int n, final byte[] array) {
        this.a.bindBlob(n, array);
    }
    
    @Override
    public void close() {
        this.a.close();
    }
    
    @Override
    public void m1(final int n) {
        this.a.bindNull(n);
    }
}
