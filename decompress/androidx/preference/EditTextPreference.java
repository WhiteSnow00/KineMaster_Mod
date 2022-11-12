// 
// Decompiled by Procyon v0.6.0
// 

package androidx.preference;

import android.widget.EditText;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.text.TextUtils;
import android.content.res.TypedArray;
import androidx.core.content.res.i;
import android.util.AttributeSet;
import android.content.Context;

public class EditTextPreference extends DialogPreference
{
    private String g0;
    private a h0;
    
    public EditTextPreference(final Context context, final AttributeSet set) {
        this(context, set, androidx.core.content.res.i.a(context, m.d, 16842898));
    }
    
    public EditTextPreference(final Context context, final AttributeSet set, final int n) {
        this(context, set, n, 0);
    }
    
    public EditTextPreference(final Context context, final AttributeSet set, int x, final int n) {
        super(context, set, x, n);
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, s.w, x, n);
        x = s.x;
        if (androidx.core.content.res.i.b(obtainStyledAttributes, x, x, false)) {
            this.L0((f)b.b());
        }
        obtainStyledAttributes.recycle();
    }
    
    @Override
    public boolean P0() {
        return TextUtils.isEmpty((CharSequence)this.g0) || super.P0();
    }
    
    a b1() {
        return this.h0;
    }
    
    public String c1() {
        return this.g0;
    }
    
    public void d1(final String g0) {
        final boolean p = this.P0();
        this.u0(this.g0 = g0);
        final boolean p2 = this.P0();
        if (p2 != p) {
            this.S(p2);
        }
        this.R();
    }
    
    @Override
    protected Object e0(final TypedArray typedArray, final int n) {
        return typedArray.getString(n);
    }
    
    @Override
    protected void i0(final Parcelable parcelable) {
        if (parcelable != null && parcelable.getClass().equals(SavedState.class)) {
            final SavedState savedState = (SavedState)parcelable;
            super.i0(savedState.getSuperState());
            this.d1(savedState.a);
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
        savedState.a = this.c1();
        return (Parcelable)savedState;
    }
    
    @Override
    protected void k0(final Object o) {
        this.d1(this.z((String)o));
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
    
    public interface a
    {
        void a(final EditText p0);
    }
    
    public static final class b implements f<EditTextPreference>
    {
        private static b a;
        
        private b() {
        }
        
        public static b b() {
            if (b.a == null) {
                b.a = new b();
            }
            return b.a;
        }
        
        @Override
        public /* bridge */ CharSequence a(final Preference preference) {
            return this.c((EditTextPreference)preference);
        }
        
        public CharSequence c(final EditTextPreference editTextPreference) {
            if (TextUtils.isEmpty((CharSequence)editTextPreference.c1())) {
                return editTextPreference.l().getString(q.c);
            }
            return editTextPreference.c1();
        }
    }
}
