// 
// Decompiled by Procyon v0.6.0
// 

package androidx.preference;

import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton$OnCheckedChangeListener;
import android.widget.CompoundButton;
import android.view.View;
import android.content.res.TypedArray;
import androidx.core.content.res.i;
import android.util.AttributeSet;
import android.content.Context;

public class CheckBoxPreference extends TwoStatePreference
{
    private final a f0;
    
    public CheckBoxPreference(final Context context, final AttributeSet set) {
        this(context, set, androidx.core.content.res.i.a(context, m.a, 16842895));
    }
    
    public CheckBoxPreference(final Context context, final AttributeSet set, final int n) {
        this(context, set, n, 0);
    }
    
    public CheckBoxPreference(final Context context, final AttributeSet set, final int n, final int n2) {
        super(context, set, n, n2);
        this.f0 = new a();
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, s.c, n, n2);
        this.Z0(androidx.core.content.res.i.f(obtainStyledAttributes, s.i, s.d));
        this.Y0(androidx.core.content.res.i.f(obtainStyledAttributes, s.h, s.e));
        this.X0(androidx.core.content.res.i.b(obtainStyledAttributes, s.g, s.f, false));
        obtainStyledAttributes.recycle();
    }
    
    private void c1(final View view) {
        final boolean b = view instanceof CompoundButton;
        if (b) {
            ((CompoundButton)view).setOnCheckedChangeListener((CompoundButton$OnCheckedChangeListener)null);
        }
        if (view instanceof Checkable) {
            ((Checkable)view).setChecked(super.a0);
        }
        if (b) {
            ((CompoundButton)view).setOnCheckedChangeListener((CompoundButton$OnCheckedChangeListener)this.f0);
        }
    }
    
    private void d1(final View view) {
        if (!((AccessibilityManager)this.l().getSystemService("accessibility")).isEnabled()) {
            return;
        }
        this.c1(view.findViewById(16908289));
        this.a1(view.findViewById(16908304));
    }
    
    @Override
    public void Y(final l l) {
        super.Y(l);
        this.c1(l.a(16908289));
        this.b1(l);
    }
    
    @Override
    protected void p0(final View view) {
        super.p0(view);
        this.d1(view);
    }
    
    private class a implements CompoundButton$OnCheckedChangeListener
    {
        final CheckBoxPreference a;
        
        a(final CheckBoxPreference a) {
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
