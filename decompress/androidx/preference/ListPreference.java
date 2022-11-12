// 
// Decompiled by Procyon v0.6.0
// 

package androidx.preference;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.util.Log;
import android.text.TextUtils;
import android.content.res.TypedArray;
import androidx.core.content.res.i;
import android.util.AttributeSet;
import android.content.Context;

public class ListPreference extends DialogPreference
{
    private CharSequence[] g0;
    private CharSequence[] h0;
    private String i0;
    private String j0;
    private boolean k0;
    
    public ListPreference(final Context context, final AttributeSet set) {
        this(context, set, androidx.core.content.res.i.a(context, m.b, 16842897));
    }
    
    public ListPreference(final Context context, final AttributeSet set, final int n) {
        this(context, set, n, 0);
    }
    
    public ListPreference(final Context context, final AttributeSet set, final int n, final int n2) {
        super(context, set, n, n2);
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, s.y, n, n2);
        this.g0 = androidx.core.content.res.i.h(obtainStyledAttributes, s.B, s.z);
        this.h0 = androidx.core.content.res.i.h(obtainStyledAttributes, s.C, s.A);
        final int d = s.D;
        if (androidx.core.content.res.i.b(obtainStyledAttributes, d, d, false)) {
            this.L0((f)a.b());
        }
        obtainStyledAttributes.recycle();
        final TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(set, s.J, n, n2);
        this.j0 = androidx.core.content.res.i.f(obtainStyledAttributes2, s.r0, s.R);
        obtainStyledAttributes2.recycle();
    }
    
    private int g1() {
        return this.b1(this.i0);
    }
    
    @Override
    public CharSequence G() {
        if (this.H() != null) {
            return this.H().a(this);
        }
        final CharSequence d1 = this.d1();
        final CharSequence g = super.G();
        final String j0 = this.j0;
        if (j0 == null) {
            return g;
        }
        CharSequence charSequence;
        if ((charSequence = d1) == null) {
            charSequence = "";
        }
        final String format = String.format(j0, charSequence);
        if (TextUtils.equals((CharSequence)format, g)) {
            return g;
        }
        Log.w("ListPreference", "Setting a summary with a String formatting marker is no longer supported. You should use a SummaryProvider instead.");
        return format;
    }
    
    @Override
    public void K0(final CharSequence charSequence) {
        super.K0(charSequence);
        if (charSequence == null) {
            this.j0 = null;
        }
        else {
            this.j0 = charSequence.toString();
        }
    }
    
    public int b1(final String s) {
        if (s != null) {
            final CharSequence[] h0 = this.h0;
            if (h0 != null) {
                for (int i = h0.length - 1; i >= 0; --i) {
                    if (TextUtils.equals((CharSequence)this.h0[i].toString(), (CharSequence)s)) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }
    
    public CharSequence[] c1() {
        return this.g0;
    }
    
    public CharSequence d1() {
        final int g1 = this.g1();
        if (g1 >= 0) {
            final CharSequence[] g2 = this.g0;
            if (g2 != null) {
                return g2[g1];
            }
        }
        return null;
    }
    
    @Override
    protected Object e0(final TypedArray typedArray, final int n) {
        return typedArray.getString(n);
    }
    
    public CharSequence[] e1() {
        return this.h0;
    }
    
    public String f1() {
        return this.i0;
    }
    
    public void h1(final String i0) {
        final boolean b = TextUtils.equals((CharSequence)this.i0, (CharSequence)i0) ^ true;
        if (b || !this.k0) {
            this.i0 = i0;
            this.k0 = true;
            this.u0(i0);
            if (b) {
                this.R();
            }
        }
    }
    
    @Override
    protected void i0(final Parcelable parcelable) {
        if (parcelable != null && parcelable.getClass().equals(SavedState.class)) {
            final SavedState savedState = (SavedState)parcelable;
            super.i0(savedState.getSuperState());
            this.h1(savedState.a);
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
        savedState.a = this.f1();
        return (Parcelable)savedState;
    }
    
    @Override
    protected void k0(final Object o) {
        this.h1(this.z((String)o));
    }
    
    private static class SavedState extends BaseSavedState
    {
        public static final Parcelable$Creator<SavedState> CREATOR;
        String a;
        
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
            this.a = parcel.readString();
        }
        
        SavedState(final Parcelable parcelable) {
            super(parcelable);
        }
        
        public void writeToParcel(final Parcel parcel, final int n) {
            super.writeToParcel(parcel, n);
            parcel.writeString(this.a);
        }
    }
    
    public static final class a implements f<ListPreference>
    {
        private static a a;
        
        private a() {
        }
        
        public static a b() {
            if (ListPreference.a.a == null) {
                ListPreference.a.a = new a();
            }
            return ListPreference.a.a;
        }
        
        @Override
        public /* bridge */ CharSequence a(final Preference preference) {
            return this.c((ListPreference)preference);
        }
        
        public CharSequence c(final ListPreference listPreference) {
            if (TextUtils.isEmpty(listPreference.d1())) {
                return listPreference.l().getString(q.c);
            }
            return listPreference.d1();
        }
    }
}
