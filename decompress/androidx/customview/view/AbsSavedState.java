// 
// Decompiled by Procyon v0.6.0
// 

package androidx.customview.view;

import android.os.Parcel;
import android.os.Parcelable$ClassLoaderCreator;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public abstract class AbsSavedState implements Parcelable
{
    public static final Parcelable$Creator<AbsSavedState> CREATOR;
    public static final AbsSavedState b;
    private final Parcelable a;
    
    static {
        b = new AbsSavedState() {};
        CREATOR = (Parcelable$Creator)new Parcelable$ClassLoaderCreator<AbsSavedState>() {
            public AbsSavedState a(final Parcel parcel) {
                return this.b(parcel, null);
            }
            
            public AbsSavedState b(final Parcel parcel, final ClassLoader classLoader) {
                if (parcel.readParcelable(classLoader) == null) {
                    return AbsSavedState.b;
                }
                throw new IllegalStateException("superState must be null");
            }
            
            public AbsSavedState[] c(final int n) {
                return new AbsSavedState[n];
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.a(parcel);
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel, final ClassLoader classLoader) {
                return this.b(parcel, classLoader);
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.c(n);
            }
        };
    }
    
    private AbsSavedState() {
        this.a = null;
    }
    
    protected AbsSavedState(final Parcel parcel, final ClassLoader classLoader) {
        Object a = parcel.readParcelable(classLoader);
        if (a == null) {
            a = AbsSavedState.b;
        }
        this.a = (Parcelable)a;
    }
    
    protected AbsSavedState(Parcelable a) {
        if (a != null) {
            if (a == AbsSavedState.b) {
                a = null;
            }
            this.a = a;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }
    
    AbsSavedState(final AbsSavedState$1 absSavedState) {
        this();
    }
    
    public final Parcelable a() {
        return this.a;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeParcelable(this.a, n);
    }
}
