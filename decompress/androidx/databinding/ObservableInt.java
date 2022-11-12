// 
// Decompiled by Procyon v0.6.0
// 

package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import java.io.Serializable;
import android.os.Parcelable;

public class ObservableInt extends b implements Parcelable, Serializable
{
    public static final Parcelable$Creator<ObservableInt> CREATOR;
    static final long serialVersionUID = 1L;
    private int mValue;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<ObservableInt>() {
            public ObservableInt a(final Parcel parcel) {
                return new ObservableInt(parcel.readInt());
            }
            
            public ObservableInt[] b(final int n) {
                return new ObservableInt[n];
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.a(parcel);
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.b(n);
            }
        };
    }
    
    public ObservableInt() {
    }
    
    public ObservableInt(final int mValue) {
        this.mValue = mValue;
    }
    
    public ObservableInt(final h... array) {
        super(array);
    }
    
    public int describeContents() {
        return 0;
    }
    
    public int get() {
        return this.mValue;
    }
    
    public void set(final int mValue) {
        if (mValue != this.mValue) {
            this.mValue = mValue;
            this.notifyChange();
        }
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeInt(this.mValue);
    }
}
