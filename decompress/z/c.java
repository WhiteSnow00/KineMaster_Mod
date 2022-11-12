// 
// Decompiled by Procyon v0.6.0
// 

package z;

import android.view.View;
import android.view.ViewGroup;
import android.database.Cursor;
import android.content.Context;
import android.view.LayoutInflater;

public abstract class c extends a
{
    private int i;
    private int j;
    private LayoutInflater p;
    
    @Deprecated
    public c(final Context context, final int n, final Cursor cursor, final boolean b) {
        super(context, cursor, b);
        this.j = n;
        this.i = n;
        this.p = (LayoutInflater)context.getSystemService("layout_inflater");
    }
    
    @Override
    public View g(final Context context, final Cursor cursor, final ViewGroup viewGroup) {
        return this.p.inflate(this.j, viewGroup, false);
    }
    
    @Override
    public View h(final Context context, final Cursor cursor, final ViewGroup viewGroup) {
        return this.p.inflate(this.i, viewGroup, false);
    }
}
