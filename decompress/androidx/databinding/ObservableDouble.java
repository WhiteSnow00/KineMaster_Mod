// 
// Decompiled by Procyon v0.6.0
// 

package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import java.io.Serializable;
import android.os.Parcelable;

public class ObservableDouble extends b implements Parcelable, Serializable
{
    public static final Parcelable$Creator<ObservableDouble> CREATOR;
    static final long serialVersionUID = 1L;
    private double mValue;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<ObservableDouble>() {
            public ObservableDouble a(final Parcel parcel) {
                return new ObservableDouble(parcel.readDouble());
            }
            
            public ObservableDouble[] b(final int n) {
                return new ObservableDouble[n];
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.a(parcel);
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.b(n);
            }
        };
    }
    
    public ObservableDouble() {
    }
    
    public ObservableDouble(final double mValue) {
        this.mValue = mValue;
    }
    
    public ObservableDouble(final h... array) {
        super(array);
    }
    
    public int describeContents() {
        return 0;
    }
    
    public double get() {
        return this.mValue;
    }
    
    public void set(final double mValue) {
        if (mValue != this.mValue) {
            this.mValue = mValue;
            this.notifyChange();
        }
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeDouble(this.mValue);
    }
}
