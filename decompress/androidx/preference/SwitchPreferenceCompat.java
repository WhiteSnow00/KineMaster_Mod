// 
// Decompiled by Procyon v0.6.0
// 

package androidx.preference;

import android.widget.CompoundButton;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton$OnCheckedChangeListener;
import androidx.appcompat.widget.SwitchCompat;
import android.view.View;
import android.content.res.TypedArray;
import androidx.core.content.res.i;
import android.util.AttributeSet;
import android.content.Context;

public class SwitchPreferenceCompat extends TwoStatePreference
{
    private final a f0;
    private CharSequence g0;
    private CharSequence h0;
    
    public SwitchPreferenceCompat(final Context context, final AttributeSet set) {
        this(context, set, m.k);
    }
    
    public SwitchPreferenceCompat(final Context context, final AttributeSet set, final int n) {
        this(context, set, n, 0);
    }
    
    public SwitchPreferenceCompat(final Context context, final AttributeSet set, final int n, final int n2) {
        super(context, set, n, n2);
        this.f0 = new a();
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, s.Z0, n, n2);
        this.Z0(androidx.core.content.res.i.f(obtainStyledAttributes, s.h1, s.a1));
        this.Y0(androidx.core.content.res.i.f(obtainStyledAttributes, s.g1, s.b1));
        this.d1(androidx.core.content.res.i.f(obtainStyledAttributes, s.j1, s.d1));
        this.c1(androidx.core.content.res.i.f(obtainStyledAttributes, s.i1, s.e1));
        this.X0(androidx.core.content.res.i.b(obtainStyledAttributes, s.f1, s.c1, false));
        obtainStyledAttributes.recycle();
    }
    
    private void e1(final View view) {
        final boolean b = view instanceof SwitchCompat;
        if (b) {
            ((SwitchCompat)view).setOnCheckedChangeListener((CompoundButton$OnCheckedChangeListener)null);
        }
        if (view instanceof Checkable) {
            ((Checkable)view).setChecked(super.a0);
        }
        if (b) {
            final SwitchCompat switchCompat = (SwitchCompat)view;
            switchCompat.setTextOn(this.g0);
            switchCompat.setTextOff(this.h0);
            switchCompat.setOnCheckedChangeListener((CompoundButton$OnCheckedChangeListener)this.f0);
        }
    }
    
    private void f1(final View view) {
        if (!((AccessibilityManager)this.l().getSystemService("accessibility")).isEnabled()) {
            return;
        }
        this.e1(view.findViewById(o.f));
        this.a1(view.findViewById(16908304));
    }
    
    @Override
    public void Y(final l l) {
        super.Y(l);
        this.e1(l.a(o.f));
        this.b1(l);
    }
    
    public void c1(final CharSequence h0) {
        this.h0 = h0;
        this.R();
    }
    
    public void d1(final CharSequence g0) {
        this.g0 = g0;
        this.R();
    }
    
    @Override
    protected void p0(final View view) {
        super.p0(view);
        this.f1(view);
    }
    
    private class a implements CompoundButton$OnCheckedChangeListener
    {
        final SwitchPreferenceCompat a;
        
        a(final SwitchPreferenceCompat a) {
            this.a = a;
        }
        
        public void onCheckedChanged(final CompoundButton compoundButton, final boolean b) {
            if (!this.a.c(b)) {
                compoundButton.setChecked(b ^ true);
                return;
            }
            this.a.W0(b);
        }
    }
}
