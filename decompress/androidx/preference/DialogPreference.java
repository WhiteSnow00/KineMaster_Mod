// 
// Decompiled by Procyon v0.6.0
// 

package androidx.preference;

import android.content.res.TypedArray;
import androidx.core.content.res.i;
import android.util.AttributeSet;
import android.content.Context;
import android.graphics.drawable.Drawable;

public abstract class DialogPreference extends Preference
{
    private CharSequence a0;
    private CharSequence b0;
    private Drawable c0;
    private CharSequence d0;
    private CharSequence e0;
    private int f0;
    
    public DialogPreference(final Context context, final AttributeSet set) {
        this(context, set, androidx.core.content.res.i.a(context, m.b, 16842897));
    }
    
    public DialogPreference(final Context context, final AttributeSet set, final int n) {
        this(context, set, n, 0);
    }
    
    public DialogPreference(final Context context, final AttributeSet set, final int n, final int n2) {
        super(context, set, n, n2);
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, s.j, n, n2);
        final String f = androidx.core.content.res.i.f(obtainStyledAttributes, s.t, s.k);
        this.a0 = f;
        if (f == null) {
            this.a0 = this.I();
        }
        this.b0 = androidx.core.content.res.i.f(obtainStyledAttributes, s.s, s.l);
        this.c0 = androidx.core.content.res.i.c(obtainStyledAttributes, s.q, s.m);
        this.d0 = androidx.core.content.res.i.f(obtainStyledAttributes, s.v, s.n);
        this.e0 = androidx.core.content.res.i.f(obtainStyledAttributes, s.u, s.o);
        this.f0 = androidx.core.content.res.i.e(obtainStyledAttributes, s.r, s.p, 0);
        obtainStyledAttributes.recycle();
    }
    
    public Drawable V0() {
        return this.c0;
    }
    
    public int W0() {
        return this.f0;
    }
    
    public CharSequence X0() {
        return this.b0;
    }
    
    public CharSequence Y0() {
        return this.a0;
    }
    
    @Override
    protected void Z() {
        this.C().u(this);
    }
    
    public CharSequence Z0() {
        return this.e0;
    }
    
    public CharSequence a1() {
        return this.d0;
    }
    
    public interface a
    {
         <T extends Preference> T i2(final CharSequence p0);
    }
}
