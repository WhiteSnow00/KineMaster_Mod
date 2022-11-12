// 
// Decompiled by Procyon v0.6.0
// 

package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import java.io.Serializable;
import android.os.Parcelable;

public class ObservableLong extends b implements Parcelable, Serializable
{
    public static final Parcelable$Creator<ObservableLong> CREATOR;
    static final long serialVersionUID = 1L;
    private long mValue;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<ObservableLong>() {
            public ObservableLong a(final Parcel parcel) {
                return new ObservableLong(parcel.readLong());
            }
            
            public ObservableLong[] b(final int n) {
                return new ObservableLong[n];
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.a(parcel);
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.b(n);
            }
        };
    }
    
    public ObservableLong() {
    }
    
    public ObservableLong(final long mValue) {
        this.mValue = mValue;
    }
    
    public ObservableLong(final h... array) {
        super(array);
    }
    
    public int describeContents() {
        return 0;
    }
    
    public long get() {
        return this.mValue;
    }
    
    public void set(final long mValue) {
        if (mValue != this.mValue) {
            this.mValue = mValue;
            this.notifyChange();
        }
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeLong(this.mValue);
    }
}
