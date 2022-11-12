// 
// Decompiled by Procyon v0.6.0
// 

package androidx.room;

import java.util.Iterator;
import java.util.List;
import s0.b;
import android.database.Cursor;
import v0.j;
import v0.a;
import v0.g;
import v0.h;

public class s0 extends h.a
{
    private o b;
    private final a c;
    private final String d;
    private final String e;
    
    public s0(final o b, final a c, final String d, final String e) {
        super(c.version);
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    private void h(final g g) {
        if (k(g)) {
            final Object o = null;
            final Cursor j = g.J(new v0.a("SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"));
            Object string = o;
            try {
                if (j.moveToFirst()) {
                    string = j.getString(0);
                }
                j.close();
                if (this.d.equals(string)) {
                    return;
                }
                if (this.e.equals(string)) {
                    return;
                }
                throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number.");
            }
            finally {
                j.close();
            }
        }
        final b onValidateSchema = this.c.onValidateSchema(g);
        if (!onValidateSchema.a) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Pre-packaged database has an invalid schema: ");
            sb.append(onValidateSchema.b);
            throw new IllegalStateException(sb.toString());
        }
        this.c.onPostMigrate(g);
        this.l(g);
    }
    
    private void i(final g g) {
        g.z("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
    }
    
    private static boolean j(g z0) {
        z0 = (g)z0.Z0("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
        try {
            final boolean moveToFirst = ((Cursor)z0).moveToFirst();
            boolean b = false;
            if (moveToFirst) {
                final int int1 = ((Cursor)z0).getInt(0);
                b = b;
                if (int1 == 0) {
                    b = true;
                }
            }
            return b;
        }
        finally {
            ((Cursor)z0).close();
        }
    }
    
    private static boolean k(g z0) {
        z0 = (g)z0.Z0("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
        try {
            final boolean moveToFirst = ((Cursor)z0).moveToFirst();
            boolean b = false;
            if (moveToFirst) {
                final int int1 = ((Cursor)z0).getInt(0);
                b = b;
                if (int1 != 0) {
                    b = true;
                }
            }
            return b;
        }
        finally {
            ((Cursor)z0).close();
        }
    }
    
    private void l(final g g) {
        this.i(g);
        g.z(r0.a(this.d));
    }
    
    @Override
    public void b(final g g) {
        super.b(g);
    }
    
    @Override
    public void d(final g g) {
        final boolean j = j(g);
        this.c.createAllTables(g);
        if (!j) {
            final b onValidateSchema = this.c.onValidateSchema(g);
            if (!onValidateSchema.a) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Pre-packaged database has an invalid schema: ");
                sb.append(onValidateSchema.b);
                throw new IllegalStateException(sb.toString());
            }
        }
        this.l(g);
        this.c.onCreate(g);
    }
    
    @Override
    public void e(final g g, final int n, final int n2) {
        this.g(g, n, n2);
    }
    
    @Override
    public void f(final g g) {
        super.f(g);
        this.h(g);
        this.c.onOpen(g);
        this.b = null;
    }
    
    @Override
    public void g(final g g, final int n, final int n2) {
        final o b = this.b;
        boolean b2 = false;
        Label_0149: {
            if (b != null) {
                final List<s0.b> c = b.d.c(n, n2);
                if (c != null) {
                    this.c.onPreMigrate(g);
                    final Iterator<s0.b> iterator = c.iterator();
                    while (iterator.hasNext()) {
                        iterator.next().a(g);
                    }
                    final b onValidateSchema = this.c.onValidateSchema(g);
                    if (onValidateSchema.a) {
                        this.c.onPostMigrate(g);
                        this.l(g);
                        b2 = true;
                        break Label_0149;
                    }
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Migration didn't properly handle: ");
                    sb.append(onValidateSchema.b);
                    throw new IllegalStateException(sb.toString());
                }
            }
            b2 = false;
        }
        if (!b2) {
            final o b3 = this.b;
            if (b3 == null || b3.a(n, n2)) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("A migration from ");
                sb2.append(n);
                sb2.append(" to ");
                sb2.append(n2);
                sb2.append(" was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
                throw new IllegalStateException(sb2.toString());
            }
            this.c.dropAllTables(g);
            this.c.createAllTables(g);
        }
    }
    
    public abstract static class a
    {
        public final int version;
        
        public a(final int version) {
            this.version = version;
        }
        
        protected abstract void createAllTables(final g p0);
        
        protected abstract void dropAllTables(final g p0);
        
        protected abstract void onCreate(final g p0);
        
        protected abstract void onOpen(final g p0);
        
        protected void onPostMigrate(final g g) {
        }
        
        protected void onPreMigrate(final g g) {
        }
        
        protected b onValidateSchema(final g g) {
            this.validateMigration(g);
            return new b(true, null);
        }
        
        @Deprecated
        protected void validateMigration(final g g) {
            throw new UnsupportedOperationException("validateMigration is deprecated");
        }
    }
    
    public static class b
    {
        public final boolean a;
        public final String b;
        
        public b(final boolean a, final String b) {
            this.a = a;
            this.b = b;
        }
    }
}
