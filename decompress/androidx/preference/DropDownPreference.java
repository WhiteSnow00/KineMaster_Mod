// 
// Decompiled by Procyon v0.6.0
// 

package androidx.preference;

import android.widget.SpinnerAdapter;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.util.AttributeSet;
import android.widget.AdapterView$OnItemSelectedListener;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.content.Context;

public class DropDownPreference extends ListPreference
{
    private final Context l0;
    private final ArrayAdapter m0;
    private Spinner n0;
    private final AdapterView$OnItemSelectedListener o0;
    
    public DropDownPreference(final Context context, final AttributeSet set) {
        this(context, set, m.c);
    }
    
    public DropDownPreference(final Context context, final AttributeSet set, final int n) {
        this(context, set, n, 0);
    }
    
    public DropDownPreference(final Context l0, final AttributeSet set, final int n, final int n2) {
        super(l0, set, n, n2);
        this.o0 = (AdapterView$OnItemSelectedListener)new AdapterView$OnItemSelectedListener() {
            final DropDownPreference a;
            
            public void onItemSelected(final AdapterView<?> adapterView, final View view, final int n, final long n2) {
                if (n >= 0) {
                    final String string = this.a.e1()[n].toString();
                    if (!string.equals(this.a.f1()) && this.a.c(string)) {
                        this.a.h1(string);
                    }
                }
            }
            
            public void onNothingSelected(final AdapterView<?> adapterView) {
            }
        };
        this.l0 = l0;
        this.m0 = this.i1();
        this.k1();
    }
    
    private int j1(final String s) {
        final CharSequence[] e1 = this.e1();
        if (s != null && e1 != null) {
            for (int i = e1.length - 1; i >= 0; --i) {
                if (TextUtils.equals((CharSequence)e1[i].toString(), (CharSequence)s)) {
                    return i;
                }
            }
        }
        return -1;
    }
    
    private void k1() {
        this.m0.clear();
        if (this.c1() != null) {
            final CharSequence[] c1 = this.c1();
            for (int length = c1.length, i = 0; i < length; ++i) {
                this.m0.add((Object)c1[i].toString());
            }
        }
    }
    
    @Override
    protected void R() {
        super.R();
        final ArrayAdapter m0 = this.m0;
        if (m0 != null) {
            m0.notifyDataSetChanged();
        }
    }
    
    @Override
    public void Y(final l l) {
        (this.n0 = (Spinner)l.itemView.findViewById(o.e)).setAdapter((SpinnerAdapter)this.m0);
        this.n0.setOnItemSelectedListener(this.o0);
        this.n0.setSelection(this.j1(this.f1()));
        super.Y(l);
    }
    
    @Override
    protected void Z() {
        this.n0.performClick();
    }
    
    protected ArrayAdapter i1() {
        return new ArrayAdapter(this.l0, 17367049);
    }
}
