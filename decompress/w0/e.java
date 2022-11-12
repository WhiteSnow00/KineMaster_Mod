// 
// Decompiled by Procyon v0.6.0
// 

package w0;

import android.database.sqlite.SQLiteProgram;
import android.database.sqlite.SQLiteStatement;
import v0.k;

class e extends d implements k
{
    private final SQLiteStatement b;
    
    e(final SQLiteStatement b) {
        super((SQLiteProgram)b);
        this.b = b;
    }
    
    @Override
    public long A0() {
        return this.b.executeInsert();
    }
    
    @Override
    public int C() {
        return this.b.executeUpdateDelete();
    }
}
