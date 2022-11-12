// 
// Decompiled by Procyon v0.6.0
// 

package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import java.io.Serializable;
import android.os.Parcelable;

public class ObservableShort extends b implements Parcelable, Serializable
{
    public static final Parcelable$Creator<ObservableShort> CREATOR;
    static final long serialVersionUID = 1L;
    private short mValue;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<ObservableShort>() {
            public ObservableShort a(final Parcel parcel) {
                return new ObservableShort((short)parcel.readInt());
            }
            
            public ObservableShort[] b(final int n) {
                return new ObservableShort[n];
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.a(parcel);
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.b(n);
            }
        };
    }
    
    public ObservableShort() {
    }
    
    public ObservableShort(final short mValue) {
        this.mValue = mValue;
    }
    
    public ObservableShort(final h... array) {
        super(array);
    }
    
    public int describeContents() {
        return 0;
    }
    
    public short get() {
        return this.mValue;
    }
    
    public void set(final short mValue) {
        if (mValue != this.mValue) {
            this.mValue = mValue;
            this.notifyChange();
        }
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeInt((int)this.mValue);
    }
}
