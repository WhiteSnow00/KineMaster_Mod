// 
// Decompiled by Procyon v0.6.0
// 

package androidx.preference;

import android.widget.CompoundButton;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton$OnCheckedChangeListener;
import android.widget.Switch;
import android.view.View;
import android.content.res.TypedArray;
import androidx.core.content.res.i;
import android.util.AttributeSet;
import android.content.Context;

public class SwitchPreference extends TwoStatePreference
{
    private final a f0;
    private CharSequence g0;
    private CharSequence h0;
    
    public SwitchPreference(final Context context) {
        this(context, null);
    }
    
    public SwitchPreference(final Context context, final AttributeSet set) {
        this(context, set, androidx.core.content.res.i.a(context, m.l, 16843629));
    }
    
    public SwitchPreference(final Context context, final AttributeSet set, final int n) {
        this(context, set, n, 0);
    }
    
    public SwitchPreference(final Context context, final AttributeSet set, final int n, final int n2) {
        super(context, set, n, n2);
        this.f0 = new a();
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, s.O0, n, n2);
        this.Z0(androidx.core.content.res.i.f(obtainStyledAttributes, s.W0, s.P0));
        this.Y0(androidx.core.content.res.i.f(obtainStyledAttributes, s.V0, s.Q0));
        this.f1(androidx.core.content.res.i.f(obtainStyledAttributes, s.Y0, s.S0));
        this.e1(androidx.core.content.res.i.f(obtainStyledAttributes, s.X0, s.T0));
        this.X0(androidx.core.content.res.i.b(obtainStyledAttributes, s.U0, s.R0, false));
        obtainStyledAttributes.recycle();
    }
    
    private void g1(final View view) {
        final boolean b = view instanceof Switch;
        if (b) {
            ((Switch)view).setOnCheckedChangeListener((CompoundButton$OnCheckedChangeListener)null);
        }
        if (view instanceof Checkable) {
            ((Checkable)view).setChecked(super.a0);
        }
        if (b) {
            final Switch switch1 = (Switch)view;
            switch1.setTextOn(this.g0);
            switch1.setTextOff(this.h0);
            switch1.setOnCheckedChangeListener((CompoundButton$OnCheckedChangeListener)this.f0);
        }
    }
    
    private void h1(final View view) {
        if (!((AccessibilityManager)this.l().getSystemService("accessibility")).isEnabled()) {
            return;
        }
        this.g1(view.findViewById(16908352));
        this.a1(view.findViewById(16908304));
    }
    
    @Override
    public void Y(final l l) {
        super.Y(l);
        this.g1(l.a(16908352));
        this.b1(l);
    }
    
    public CharSequence c1() {
        return this.h0;
    }
    
    public CharSequence d1() {
        return this.g0;
    }
    
    public void e1(final CharSequence h0) {
        this.h0 = h0;
        this.R();
    }
    
    public void f1(final CharSequence g0) {
        this.g0 = g0;
        this.R();
    }
    
    @Override
    protected void p0(final View view) {
        super.p0(view);
        this.h1(view);
    }
    
    private class a implements CompoundButton$OnCheckedChangeListener
    {
        final SwitchPreference a;
        
        a(final SwitchPreference a) {
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
