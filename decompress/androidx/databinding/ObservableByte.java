// 
// Decompiled by Procyon v0.6.0
// 

package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import java.io.Serializable;
import android.os.Parcelable;

public class ObservableByte extends b implements Parcelable, Serializable
{
    public static final Parcelable$Creator<ObservableByte> CREATOR;
    static final long serialVersionUID = 1L;
    private byte mValue;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<ObservableByte>() {
            public ObservableByte a(final Parcel parcel) {
                return new ObservableByte(parcel.readByte());
            }
            
            public ObservableByte[] b(final int n) {
                return new ObservableByte[n];
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.a(parcel);
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.b(n);
            }
        };
    }
    
    public ObservableByte() {
    }
    
    public ObservableByte(final byte mValue) {
        this.mValue = mValue;
    }
    
    public ObservableByte(final h... array) {
        super(array);
    }
    
    public int describeContents() {
        return 0;
    }
    
    public byte get() {
        return this.mValue;
    }
    
    public void set(final byte mValue) {
        if (mValue != this.mValue) {
            this.mValue = mValue;
            this.notifyChange();
        }
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeByte(this.mValue);
    }
}
