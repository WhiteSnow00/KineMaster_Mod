// 
// Decompiled by Procyon v0.6.0
// 

package w0;

import android.database.sqlite.SQLiteDatabase$CursorFactory;
import android.database.sqlite.SQLiteDatabase;
import android.database.DatabaseErrorHandler;
import v0.g;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.File;
import v0.d;
import android.content.Context;
import v0.h;

class b implements h
{
    private final Context a;
    private final String b;
    private final h.a c;
    private final boolean d;
    private final Object e;
    private a f;
    private boolean g;
    
    b(final Context a, final String b, final h.a c, final boolean d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = new Object();
    }
    
    private a a() {
        synchronized (this.e) {
            if (this.f == null) {
                final w0.a[] array = { null };
                if (this.b != null && this.d) {
                    this.f = new a(this.a, new File(v0.d.a(this.a), this.b).getAbsolutePath(), array, this.c);
                }
                else {
                    this.f = new a(this.a, this.b, array, this.c);
                }
                v0.b.f(this.f, this.g);
            }
            return this.f;
        }
    }
    
    @Override
    public void close() {
        this.a().close();
    }
    
    @Override
    public String getDatabaseName() {
        return this.b;
    }
    
    @Override
    public g getWritableDatabase() {
        return this.a().d();
    }
    
    @Override
    public void setWriteAheadLoggingEnabled(final boolean g) {
        synchronized (this.e) {
            final a f = this.f;
            if (f != null) {
                v0.b.f(f, g);
            }
            this.g = g;
        }
    }
    
    static class a extends SQLiteOpenHelper
    {
        final w0.a[] a;
        final h.a b;
        private boolean c;
        
        a(final Context context, final String s, final w0.a[] a, final h.a b) {
            super(context, s, (SQLiteDatabase$CursorFactory)null, b.a, (DatabaseErrorHandler)new DatabaseErrorHandler(b, a) {
                final h.a a;
                final w0.a[] b;
                
                public void onCorruption(final SQLiteDatabase sqLiteDatabase) {
                    this.a.c(w0.b.a.c(this.b, sqLiteDatabase));
                }
            });
            this.b = b;
            this.a = a;
        }
        
        static w0.a c(final w0.a[] array, final SQLiteDatabase sqLiteDatabase) {
            final w0.a a = array[0];
            if (a == null || !a.a(sqLiteDatabase)) {
                array[0] = new w0.a(sqLiteDatabase);
            }
            return array[0];
        }
        
        w0.a a(final SQLiteDatabase sqLiteDatabase) {
            return c(this.a, sqLiteDatabase);
        }
        
        public void close() {
            synchronized (this) {
                super.close();
                this.a[0] = null;
            }
        }
        
        g d() {
            synchronized (this) {
                this.c = false;
                final SQLiteDatabase writableDatabase = super.getWritableDatabase();
                if (this.c) {
                    this.close();
                    return this.d();
                }
                return this.a(writableDatabase);
            }
        }
        
        public void onConfigure(final SQLiteDatabase sqLiteDatabase) {
            this.b.b(this.a(sqLiteDatabase));
        }
        
        public void onCreate(final SQLiteDatabase sqLiteDatabase) {
            this.b.d(this.a(sqLiteDatabase));
        }
        
        public void onDowngrade(final SQLiteDatabase sqLiteDatabase, final int n, final int n2) {
            this.c = true;
            this.b.e(this.a(sqLiteDatabase), n, n2);
        }
        
        public void onOpen(final SQLiteDatabase sqLiteDatabase) {
            if (!this.c) {
                this.b.f(this.a(sqLiteDatabase));
            }
        }
        
        public void onUpgrade(final SQLiteDatabase sqLiteDatabase, final int n, final int n2) {
            this.c = true;
            this.b.g(this.a(sqLiteDatabase), n, n2);
        }
    }
}
