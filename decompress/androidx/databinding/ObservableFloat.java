// 
// Decompiled by Procyon v0.6.0
// 

package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import java.io.Serializable;
import android.os.Parcelable;

public class ObservableFloat extends b implements Parcelable, Serializable
{
    public static final Parcelable$Creator<ObservableFloat> CREATOR;
    static final long serialVersionUID = 1L;
    private float mValue;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<ObservableFloat>() {
            public ObservableFloat a(final Parcel parcel) {
                return new ObservableFloat(parcel.readFloat());
            }
            
            public ObservableFloat[] b(final int n) {
                return new ObservableFloat[n];
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.a(parcel);
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.b(n);
            }
        };
    }
    
    public ObservableFloat() {
    }
    
    public ObservableFloat(final float mValue) {
        this.mValue = mValue;
    }
    
    public ObservableFloat(final h... array) {
        super(array);
    }
    
    public int describeContents() {
        return 0;
    }
    
    public float get() {
        return this.mValue;
    }
    
    public void set(final float mValue) {
        if (mValue != this.mValue) {
            this.mValue = mValue;
            this.notifyChange();
        }
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeFloat(this.mValue);
    }
}
