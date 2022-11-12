// 
// Decompiled by Procyon v0.6.0
// 

package z;

import android.os.Handler;
import android.widget.Filter;
import android.view.ViewGroup;
import android.database.ContentObserver;
import android.view.View;
import android.database.DataSetObserver;
import android.content.Context;
import android.database.Cursor;
import android.widget.Filterable;
import android.widget.BaseAdapter;

public abstract class a extends BaseAdapter implements Filterable, z.b.a
{
    protected boolean a;
    protected boolean b;
    protected Cursor c;
    protected Context d;
    protected int e;
    protected a f;
    protected DataSetObserver g;
    protected z.b h;
    
    public a(final Context context, final Cursor cursor, final boolean b) {
        int n;
        if (b) {
            n = 1;
        }
        else {
            n = 2;
        }
        this.f(context, cursor, n);
    }
    
    public void a(Cursor j) {
        j = this.j(j);
        if (j != null) {
            j.close();
        }
    }
    
    public abstract CharSequence b(final Cursor p0);
    
    public Cursor d() {
        return this.c;
    }
    
    public abstract void e(final View p0, final Context p1, final Cursor p2);
    
    void f(final Context d, final Cursor c, int n) {
        boolean a = false;
        if ((n & 0x1) == 0x1) {
            n |= 0x2;
            this.b = true;
        }
        else {
            this.b = false;
        }
        if (c != null) {
            a = true;
        }
        this.c = c;
        this.a = a;
        this.d = d;
        int columnIndexOrThrow;
        if (a) {
            columnIndexOrThrow = c.getColumnIndexOrThrow("_id");
        }
        else {
            columnIndexOrThrow = -1;
        }
        this.e = columnIndexOrThrow;
        if ((n & 0x2) == 0x2) {
            this.f = new a();
            this.g = new b();
        }
        else {
            this.f = null;
            this.g = null;
        }
        if (a) {
            final a f = this.f;
            if (f != null) {
                c.registerContentObserver((ContentObserver)f);
            }
            final DataSetObserver g = this.g;
            if (g != null) {
                c.registerDataSetObserver(g);
            }
        }
    }
    
    public abstract View g(final Context p0, final Cursor p1, final ViewGroup p2);
    
    public int getCount() {
        if (this.a) {
            final Cursor c = this.c;
            if (c != null) {
                return c.getCount();
            }
        }
        return 0;
    }
    
    public View getDropDownView(final int n, final View view, final ViewGroup viewGroup) {
        if (this.a) {
            this.c.moveToPosition(n);
            View g;
            if ((g = view) == null) {
                g = this.g(this.d, this.c, viewGroup);
            }
            this.e(g, this.d, this.c);
            return g;
        }
        return null;
    }
    
    public Filter getFilter() {
        if (this.h == null) {
            this.h = new z.b((z.b.a)this);
        }
        return this.h;
    }
    
    public Object getItem(final int n) {
        if (this.a) {
            final Cursor c = this.c;
            if (c != null) {
                c.moveToPosition(n);
                return this.c;
            }
        }
        return null;
    }
    
    public long getItemId(final int n) {
        if (this.a) {
            final Cursor c = this.c;
            if (c != null && c.moveToPosition(n)) {
                return this.c.getLong(this.e);
            }
        }
        return 0L;
    }
    
    public View getView(final int n, final View view, final ViewGroup viewGroup) {
        if (!this.a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (this.c.moveToPosition(n)) {
            View h;
            if ((h = view) == null) {
                h = this.h(this.d, this.c, viewGroup);
            }
            this.e(h, this.d, this.c);
            return h;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("couldn't move cursor to position ");
        sb.append(n);
        throw new IllegalStateException(sb.toString());
    }
    
    public abstract View h(final Context p0, final Cursor p1, final ViewGroup p2);
    
    protected void i() {
        if (this.b) {
            final Cursor c = this.c;
            if (c != null && !c.isClosed()) {
                this.a = this.c.requery();
            }
        }
    }
    
    public Cursor j(final Cursor c) {
        final Cursor c2 = this.c;
        if (c == c2) {
            return null;
        }
        if (c2 != null) {
            final a f = this.f;
            if (f != null) {
                c2.unregisterContentObserver((ContentObserver)f);
            }
            final DataSetObserver g = this.g;
            if (g != null) {
                c2.unregisterDataSetObserver(g);
            }
        }
        if ((this.c = c) != null) {
            final a f2 = this.f;
            if (f2 != null) {
                c.registerContentObserver((ContentObserver)f2);
            }
            final DataSetObserver g2 = this.g;
            if (g2 != null) {
                c.registerDataSetObserver(g2);
            }
            this.e = c.getColumnIndexOrThrow("_id");
            this.a = true;
            this.notifyDataSetChanged();
        }
        else {
            this.e = -1;
            this.a = false;
            this.notifyDataSetInvalidated();
        }
        return c2;
    }
    
    private class a extends ContentObserver
    {
        final z.a a;
        
        a(final z.a a) {
            this.a = a;
            super(new Handler());
        }
        
        public boolean deliverSelfNotifications() {
            return true;
        }
        
        public void onChange(final boolean b) {
            this.a.i();
        }
    }
    
    private class b extends DataSetObserver
    {
        final a a;
        
        b(final a a) {
            this.a = a;
        }
        
        public void onChanged() {
            final a a = this.a;
            a.a = true;
            a.notifyDataSetChanged();
        }
        
        public void onInvalidated() {
            final a a = this.a;
            a.a = false;
            a.notifyDataSetInvalidated();
        }
    }
}
