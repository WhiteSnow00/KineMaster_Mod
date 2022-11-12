// 
// Decompiled by Procyon v0.6.0
// 

package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import java.io.Serializable;
import android.os.Parcelable;

public class ObservableBoolean extends b implements Parcelable, Serializable
{
    public static final Parcelable$Creator<ObservableBoolean> CREATOR;
    static final long serialVersionUID = 1L;
    private boolean mValue;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<ObservableBoolean>() {
            public ObservableBoolean a(final Parcel parcel) {
                final int int1 = parcel.readInt();
                boolean b = true;
                if (int1 != 1) {
                    b = false;
                }
                return new ObservableBoolean(b);
            }
            
            public ObservableBoolean[] b(final int n) {
                return new ObservableBoolean[n];
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.a(parcel);
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.b(n);
            }
        };
    }
    
    public ObservableBoolean() {
    }
    
    public ObservableBoolean(final boolean mValue) {
        this.mValue = mValue;
    }
    
    public ObservableBoolean(final h... array) {
        super(array);
    }
    
    public int describeContents() {
        return 0;
    }
    
    public boolean get() {
        return this.mValue;
    }
    
    public void set(final boolean mValue) {
        if (mValue != this.mValue) {
            this.mValue = mValue;
            this.notifyChange();
        }
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeInt((int)(this.mValue ? 1 : 0));
    }
}
