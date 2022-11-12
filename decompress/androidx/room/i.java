// 
// Decompiled by Procyon v0.6.0
// 

package androidx.room;

import android.content.ContentResolver;
import android.database.DataSetObserver;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.database.CharArrayBuffer;
import java.util.ArrayList;
import android.util.Pair;
import java.util.List;
import android.os.CancellationSignal;
import android.database.SQLException;
import android.database.Cursor;
import v0.j;
import v0.k;
import v0.g;
import java.io.IOException;
import t0.e;
import v0.h;

final class i implements h, p
{
    private final h a;
    private final a b;
    private final androidx.room.a c;
    
    i(final h a, final androidx.room.a c) {
        this.a = a;
        (this.c = c).f(a);
        this.b = new a(c);
    }
    
    androidx.room.a a() {
        return this.c;
    }
    
    @Override
    public void close() {
        try {
            this.b.close();
        }
        catch (final IOException ex) {
            e.a(ex);
        }
    }
    
    @Override
    public String getDatabaseName() {
        return this.a.getDatabaseName();
    }
    
    @Override
    public h getDelegate() {
        return this.a;
    }
    
    @Override
    public g getWritableDatabase() {
        this.b.l();
        return this.b;
    }
    
    @Override
    public void setWriteAheadLoggingEnabled(final boolean writeAheadLoggingEnabled) {
        this.a.setWriteAheadLoggingEnabled(writeAheadLoggingEnabled);
    }
    
    static final class a implements g
    {
        private final androidx.room.a a;
        
        a(final androidx.room.a a) {
            this.a = a;
        }
        
        public static Object a(final String s, final Object[] array, final g g) {
            return i(s, array, g);
        }
        
        public static Object c(final String s, final g g) {
            return h(s, g);
        }
        
        public static Boolean d(final g g) {
            return j(g);
        }
        
        public static Object e(final g g) {
            return k(g);
        }
        
        private static Object h(final String s, final g g) {
            g.z(s);
            return null;
        }
        
        private static Object i(final String s, final Object[] array, final g g) {
            g.T(s, array);
            return null;
        }
        
        private static Boolean j(final g g) {
            return g.z1();
        }
        
        private static Object k(final g g) {
            return null;
        }
        
        @Override
        public k H0(final String s) {
            return new b(s, this.a);
        }
        
        @Override
        public Cursor J(final j j) {
            try {
                return (Cursor)new c(this.a.e().J(j), this.a);
            }
            finally {
                this.a.b();
            }
        }
        
        @Override
        public void T(final String s, final Object[] array) throws SQLException {
            this.a.c((k.a<g, Object>)new androidx.room.c(s, array));
        }
        
        @Override
        public void U() {
            final g e = this.a.e();
            try {
                e.U();
            }
            finally {
                this.a.b();
            }
        }
        
        @Override
        public Cursor Z0(final String s) {
            try {
                return (Cursor)new c(this.a.e().Z0(s), this.a);
            }
            finally {
                this.a.b();
            }
        }
        
        @Override
        public void close() throws IOException {
            this.a.a();
        }
        
        @Override
        public String getPath() {
            return this.a.c((k.a<g, String>)androidx.room.g.a);
        }
        
        @Override
        public boolean isOpen() {
            final g d = this.a.d();
            return d != null && d.isOpen();
        }
        
        void l() {
            this.a.c((k.a<g, Object>)androidx.room.e.a);
        }
        
        @Override
        public void m() {
            final g e = this.a.e();
            try {
                e.m();
            }
            finally {
                this.a.b();
            }
        }
        
        @Override
        public void p() {
            final g d = this.a.d();
            if (d != null) {
                d.p();
                return;
            }
            throw new IllegalStateException("setTransactionSuccessful called but delegateDb is null");
        }
        
        @Override
        public void q() {
            if (this.a.d() != null) {
                try {
                    this.a.d().q();
                    return;
                }
                finally {
                    this.a.b();
                }
            }
            throw new IllegalStateException("End transaction called but delegateDb is null");
        }
        
        @Override
        public boolean q1() {
            return this.a.d() != null && this.a.c((k.a<g, Boolean>)androidx.room.h.a);
        }
        
        @Override
        public Cursor u0(final j j, final CancellationSignal cancellationSignal) {
            try {
                return (Cursor)new c(this.a.e().u0(j, cancellationSignal), this.a);
            }
            finally {
                this.a.b();
            }
        }
        
        @Override
        public List<Pair<String, String>> x() {
            return this.a.c((k.a<g, List<Pair<String, String>>>)f.a);
        }
        
        @Override
        public void z(final String s) throws SQLException {
            this.a.c((k.a<g, Object>)new androidx.room.b(s));
        }
        
        @Override
        public boolean z1() {
            return this.a.c((k.a<g, Boolean>)d.a);
        }
    }
    
    private static class b implements k
    {
        private final String a;
        private final ArrayList<Object> b;
        private final androidx.room.a c;
        
        b(final String a, final androidx.room.a c) {
            this.b = new ArrayList<Object>();
            this.a = a;
            this.c = c;
        }
        
        public static Object a(final b b, final k.a a, final g g) {
            return b.e(a, g);
        }
        
        private void c(final k k) {
            int n;
            for (int i = 0; i < this.b.size(); i = n) {
                n = i + 1;
                final Object value = this.b.get(i);
                if (value == null) {
                    k.m1(n);
                }
                else if (value instanceof Long) {
                    k.U0(n, (long)value);
                }
                else if (value instanceof Double) {
                    k.G(n, (double)value);
                }
                else if (value instanceof String) {
                    k.E0(n, (String)value);
                }
                else if (value instanceof byte[]) {
                    k.V0(n, (byte[])value);
                }
            }
        }
        
        private <T> T d(final k.a<k, T> a) {
            return this.c.c((k.a<g, T>)new androidx.room.j(this, a));
        }
        
        private Object e(final k.a a, final g g) {
            final k h0 = g.H0(this.a);
            this.c(h0);
            return a.apply(h0);
        }
        
        private void h(int i, final Object o) {
            final int n = i - 1;
            if (n >= this.b.size()) {
                for (i = this.b.size(); i <= n; ++i) {
                    this.b.add(null);
                }
            }
            this.b.set(n, o);
        }
        
        @Override
        public long A0() {
            return this.d((k.a<k, Long>)l.a);
        }
        
        @Override
        public int C() {
            return this.d((k.a<k, Integer>)androidx.room.k.a);
        }
        
        @Override
        public void E0(final int n, final String s) {
            this.h(n, s);
        }
        
        @Override
        public void G(final int n, final double n2) {
            this.h(n, n2);
        }
        
        @Override
        public void U0(final int n, final long n2) {
            this.h(n, n2);
        }
        
        @Override
        public void V0(final int n, final byte[] array) {
            this.h(n, array);
        }
        
        @Override
        public void close() throws IOException {
        }
        
        @Override
        public void m1(final int n) {
            this.h(n, null);
        }
    }
    
    private static final class c implements Cursor
    {
        private final Cursor a;
        private final androidx.room.a b;
        
        c(final Cursor a, final androidx.room.a b) {
            this.a = a;
            this.b = b;
        }
        
        public void close() {
            this.a.close();
            this.b.b();
        }
        
        public void copyStringToBuffer(final int n, final CharArrayBuffer charArrayBuffer) {
            this.a.copyStringToBuffer(n, charArrayBuffer);
        }
        
        @Deprecated
        public void deactivate() {
            this.a.deactivate();
        }
        
        public byte[] getBlob(final int n) {
            return this.a.getBlob(n);
        }
        
        public int getColumnCount() {
            return this.a.getColumnCount();
        }
        
        public int getColumnIndex(final String s) {
            return this.a.getColumnIndex(s);
        }
        
        public int getColumnIndexOrThrow(final String s) throws IllegalArgumentException {
            return this.a.getColumnIndexOrThrow(s);
        }
        
        public String getColumnName(final int n) {
            return this.a.getColumnName(n);
        }
        
        public String[] getColumnNames() {
            return this.a.getColumnNames();
        }
        
        public int getCount() {
            return this.a.getCount();
        }
        
        public double getDouble(final int n) {
            return this.a.getDouble(n);
        }
        
        public Bundle getExtras() {
            return this.a.getExtras();
        }
        
        public float getFloat(final int n) {
            return this.a.getFloat(n);
        }
        
        public int getInt(final int n) {
            return this.a.getInt(n);
        }
        
        public long getLong(final int n) {
            return this.a.getLong(n);
        }
        
        public Uri getNotificationUri() {
            return v0.c.a(this.a);
        }
        
        public List<Uri> getNotificationUris() {
            return v0.f.a(this.a);
        }
        
        public int getPosition() {
            return this.a.getPosition();
        }
        
        public short getShort(final int n) {
            return this.a.getShort(n);
        }
        
        public String getString(final int n) {
            return this.a.getString(n);
        }
        
        public int getType(final int n) {
            return this.a.getType(n);
        }
        
        public boolean getWantsAllOnMoveCalls() {
            return this.a.getWantsAllOnMoveCalls();
        }
        
        public boolean isAfterLast() {
            return this.a.isAfterLast();
        }
        
        public boolean isBeforeFirst() {
            return this.a.isBeforeFirst();
        }
        
        public boolean isClosed() {
            return this.a.isClosed();
        }
        
        public boolean isFirst() {
            return this.a.isFirst();
        }
        
        public boolean isLast() {
            return this.a.isLast();
        }
        
        public boolean isNull(final int n) {
            return this.a.isNull(n);
        }
        
        public boolean move(final int n) {
            return this.a.move(n);
        }
        
        public boolean moveToFirst() {
            return this.a.moveToFirst();
        }
        
        public boolean moveToLast() {
            return this.a.moveToLast();
        }
        
        public boolean moveToNext() {
            return this.a.moveToNext();
        }
        
        public boolean moveToPosition(final int n) {
            return this.a.moveToPosition(n);
        }
        
        public boolean moveToPrevious() {
            return this.a.moveToPrevious();
        }
        
        public void registerContentObserver(final ContentObserver contentObserver) {
            this.a.registerContentObserver(contentObserver);
        }
        
        public void registerDataSetObserver(final DataSetObserver dataSetObserver) {
            this.a.registerDataSetObserver(dataSetObserver);
        }
        
        @Deprecated
        public boolean requery() {
            return this.a.requery();
        }
        
        public Bundle respond(final Bundle bundle) {
            return this.a.respond(bundle);
        }
        
        public void setExtras(final Bundle bundle) {
            v0.e.a(this.a, bundle);
        }
        
        public void setNotificationUri(final ContentResolver contentResolver, final Uri uri) {
            this.a.setNotificationUri(contentResolver, uri);
        }
        
        public void setNotificationUris(final ContentResolver contentResolver, final List<Uri> list) {
            v0.f.b(this.a, contentResolver, list);
        }
        
        public void unregisterContentObserver(final ContentObserver contentObserver) {
            this.a.unregisterContentObserver(contentObserver);
        }
        
        public void unregisterDataSetObserver(final DataSetObserver dataSetObserver) {
            this.a.unregisterDataSetObserver(dataSetObserver);
        }
    }
}
