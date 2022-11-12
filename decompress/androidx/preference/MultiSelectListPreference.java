// 
// Decompiled by Procyon v0.6.0
// 

package androidx.preference;

import java.util.Collections;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import java.util.Collection;
import android.content.res.TypedArray;
import java.util.HashSet;
import androidx.core.content.res.i;
import android.util.AttributeSet;
import android.content.Context;
import java.util.Set;

public class MultiSelectListPreference extends DialogPreference
{
    private CharSequence[] g0;
    private CharSequence[] h0;
    private Set<String> i0;
    
    public MultiSelectListPreference(final Context context, final AttributeSet set) {
        this(context, set, androidx.core.content.res.i.a(context, m.b, 16842897));
    }
    
    public MultiSelectListPreference(final Context context, final AttributeSet set, final int n) {
        this(context, set, n, 0);
    }
    
    public MultiSelectListPreference(final Context context, final AttributeSet set, final int n, final int n2) {
        super(context, set, n, n2);
        this.i0 = new HashSet<String>();
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, s.E, n, n2);
        this.g0 = androidx.core.content.res.i.h(obtainStyledAttributes, s.H, s.F);
        this.h0 = androidx.core.content.res.i.h(obtainStyledAttributes, s.I, s.G);
        obtainStyledAttributes.recycle();
    }
    
    public CharSequence[] b1() {
        return this.g0;
    }
    
    public CharSequence[] c1() {
        return this.h0;
    }
    
    public Set<String> d1() {
        return this.i0;
    }
    
    @Override
    protected Object e0(final TypedArray typedArray, int i) {
        final CharSequence[] textArray = typedArray.getTextArray(i);
        final HashSet set = new HashSet();
        int length;
        for (length = textArray.length, i = 0; i < length; ++i) {
            set.add(textArray[i].toString());
        }
        return set;
    }
    
    public void e1(final Set<String> set) {
        this.i0.clear();
        this.i0.addAll(set);
        this.v0(set);
        this.R();
    }
    
    @Override
    protected void i0(final Parcelable parcelable) {
        if (parcelable != null && parcelable.getClass().equals(SavedState.class)) {
            final SavedState savedState = (SavedState)parcelable;
            super.i0(savedState.getSuperState());
            this.e1(savedState.a);
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
        savedState.a = this.d1();
        return (Parcelable)savedState;
    }
    
    @Override
    protected void k0(final Object o) {
        this.e1(this.A((Set<String>)o));
    }
    
    private static class SavedState extends BaseSavedState
    {
        public static final Parcelable$Creator<SavedState> CREATOR;
        Set<String> a;
        
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
            this.a = new HashSet<String>();
            final String[] array = new String[int1];
            parcel.readStringArray(array);
            Collections.addAll(this.a, array);
        }
        
        SavedState(final Parcelable parcelable) {
            super(parcelable);
        }
        
        public void writeToParcel(final Parcel parcel, final int n) {
            super.writeToParcel(parcel, n);
            parcel.writeInt(this.a.size());
            final Set<String> a = this.a;
            parcel.writeStringArray((String[])a.toArray(new String[a.size()]));
        }
    }
}
