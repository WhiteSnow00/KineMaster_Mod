// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.view.menu;

import android.view.ViewGroup;
import android.view.View;
import java.util.ArrayList;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

public class f extends BaseAdapter
{
    g a;
    private int b;
    private boolean c;
    private final boolean d;
    private final LayoutInflater e;
    private final int f;
    
    public f(final g a, final LayoutInflater e, final boolean d, final int f) {
        this.b = -1;
        this.d = d;
        this.e = e;
        this.a = a;
        this.f = f;
        this.a();
    }
    
    void a() {
        final i x = this.a.x();
        if (x != null) {
            final ArrayList<i> b = this.a.B();
            for (int size = b.size(), i = 0; i < size; ++i) {
                if (b.get(i) == x) {
                    this.b = i;
                    return;
                }
            }
        }
        this.b = -1;
    }
    
    public g b() {
        return this.a;
    }
    
    public i c(final int n) {
        ArrayList<i> list;
        if (this.d) {
            list = this.a.B();
        }
        else {
            list = this.a.G();
        }
        final int b = this.b;
        int n2 = n;
        if (b >= 0 && (n2 = n) >= b) {
            n2 = n + 1;
        }
        return list.get(n2);
    }
    
    public void d(final boolean c) {
        this.c = c;
    }
    
    public int getCount() {
        ArrayList<i> list;
        if (this.d) {
            list = this.a.B();
        }
        else {
            list = this.a.G();
        }
        if (this.b < 0) {
            return list.size();
        }
        return list.size() - 1;
    }
    
    public /* bridge */ Object getItem(final int n) {
        return this.c(n);
    }
    
    public long getItemId(final int n) {
        return n;
    }
    
    public View getView(final int n, final View view, final ViewGroup viewGroup) {
        View inflate = view;
        if (view == null) {
            inflate = this.e.inflate(this.f, viewGroup, false);
        }
        final int groupId = this.c(n).getGroupId();
        final int n2 = n - 1;
        int groupId2;
        if (n2 >= 0) {
            groupId2 = this.c(n2).getGroupId();
        }
        else {
            groupId2 = groupId;
        }
        final ListMenuItemView listMenuItemView = (ListMenuItemView)inflate;
        listMenuItemView.setGroupDividerEnabled(this.a.H() && groupId != groupId2);
        final n.a a = (n.a)inflate;
        if (this.c) {
            listMenuItemView.setForceShowIcon(true);
        }
        a.c(this.c(n), 0);
        return inflate;
    }
    
    public void notifyDataSetChanged() {
        this.a();
        super.notifyDataSetChanged();
    }
}
