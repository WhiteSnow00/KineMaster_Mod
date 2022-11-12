// 
// Decompiled by Procyon v0.6.0
// 

package androidx.preference;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.widget.TextView;
import android.view.View;
import android.util.AttributeSet;
import android.content.Context;

public abstract class TwoStatePreference extends Preference
{
    protected boolean a0;
    private CharSequence b0;
    private CharSequence c0;
    private boolean d0;
    private boolean e0;
    
    public TwoStatePreference(final Context context) {
        this(context, null);
    }
    
    public TwoStatePreference(final Context context, final AttributeSet set) {
        this(context, set, 0);
    }
    
    public TwoStatePreference(final Context context, final AttributeSet set, final int n) {
        this(context, set, n, 0);
    }
    
    public TwoStatePreference(final Context context, final AttributeSet set, final int n, final int n2) {
        super(context, set, n, n2);
    }
    
    @Override
    public boolean P0() {
        final boolean e0 = this.e0;
        final boolean b = true;
        boolean a0;
        if (e0) {
            a0 = this.a0;
        }
        else {
            a0 = !this.a0;
        }
        boolean b2 = b;
        if (!a0) {
            b2 = (super.P0() && b);
        }
        return b2;
    }
    
    public boolean V0() {
        return this.a0;
    }
    
    public void W0(final boolean a0) {
        final boolean b = this.a0 != a0;
        if (b || !this.d0) {
            this.a0 = a0;
            this.d0 = true;
            this.q0(a0);
            if (b) {
                this.S(this.P0());
                this.R();
            }
        }
    }
    
    public void X0(final boolean e0) {
        this.e0 = e0;
    }
    
    public void Y0(final CharSequence c0) {
        this.c0 = c0;
        if (!this.V0()) {
            this.R();
        }
    }
    
    @Override
    protected void Z() {
        super.Z();
        final boolean b = this.V0() ^ true;
        if (this.c(b)) {
            this.W0(b);
        }
    }
    
    public void Z0(final CharSequence b0) {
        this.b0 = b0;
        if (this.V0()) {
            this.R();
        }
    }
    
    protected void a1(final View view) {
        if (!(view instanceof TextView)) {
            return;
        }
        final TextView textView = (TextView)view;
        final int n = 1;
        final boolean a0 = this.a0;
        final int n2 = 0;
        int n3 = 0;
        Label_0084: {
            if (a0 && !TextUtils.isEmpty(this.b0)) {
                textView.setText(this.b0);
            }
            else {
                n3 = n;
                if (this.a0) {
                    break Label_0084;
                }
                n3 = n;
                if (TextUtils.isEmpty(this.c0)) {
                    break Label_0084;
                }
                textView.setText(this.c0);
            }
            n3 = 0;
        }
        int n4;
        if ((n4 = n3) != 0) {
            final CharSequence g = this.G();
            n4 = n3;
            if (!TextUtils.isEmpty(g)) {
                textView.setText(g);
                n4 = 0;
            }
        }
        int visibility;
        if (n4 == 0) {
            visibility = n2;
        }
        else {
            visibility = 8;
        }
        if (visibility != textView.getVisibility()) {
            textView.setVisibility(visibility);
        }
    }
    
    protected void b1(final l l) {
        this.a1(l.a(16908304));
    }
    
    @Override
    protected Object e0(final TypedArray typedArray, final int n) {
        return typedArray.getBoolean(n, false);
    }
    
    @Override
    protected void i0(final Parcelable parcelable) {
        if (parcelable != null && parcelable.getClass().equals(SavedState.class)) {
            final SavedState savedState = (SavedState)parcelable;
            super.i0(savedState.getSuperState());
            this.W0(savedState.a);
            return;
        }
        super.i0(parcelable);
    }
    
    @Override
    protected Parcelable j0() {
        final Parcelable j0 = super.j0();
        if (this.O()) {
            return j0;
        }
        final SavedState savedState = new SavedState(j0);
        savedState.a = this.V0();
        return (Parcelable)savedState;
    }
    
    @Override
    protected void k0(final Object o) {
        Object false = o;
        if (o == null) {
            false = Boolean.FALSE;
        }
        this.W0(this.x((boolean)false));
    }
    
    static class SavedState extends BaseSavedState
    {
        public static final Parcelable$Creator<SavedState> CREATOR;
        boolean a;
        
        static {
            CREATOR = (Parcelable$Creator)new Parcelable$Creator<SavedState>() {
                public SavedState a(final Parcel parcel) {
                    return new SavedState(parcel);
                }
                
                public SavedState[] b(final int n) {
                    return new SavedState[n];
                }
                
                public /* bridge */ Object createFromParcel(final Parcel parcel) {
                    return this.a(parcel);
                }
                
                public /* bridge */ Object[] newArray(final int n) {
                    return this.b(n);
                }
            };
        }
        
        SavedState(final Parcel parcel) {
            super(parcel);
            final int int1 = parcel.readInt();
            boolean a = true;
            if (int1 != 1) {
                a = false;
            }
            this.a = a;
        }
        
        SavedState(final Parcelable parcelable) {
            super(parcelable);
        }
        
        public void writeToParcel(final Parcel parcel, final int n) {
            super.writeToParcel(parcel, n);
            parcel.writeInt((int)(this.a ? 1 : 0));
        }
    }
}
