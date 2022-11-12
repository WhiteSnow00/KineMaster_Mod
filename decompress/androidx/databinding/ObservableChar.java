// 
// Decompiled by Procyon v0.6.0
// 

package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import java.io.Serializable;
import android.os.Parcelable;

public class ObservableChar extends b implements Parcelable, Serializable
{
    public static final Parcelable$Creator<ObservableChar> CREATOR;
    static final long serialVersionUID = 1L;
    private char mValue;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<ObservableChar>() {
            public ObservableChar a(final Parcel parcel) {
                return new ObservableChar((char)parcel.readInt());
            }
            
            public ObservableChar[] b(final int n) {
                return new ObservableChar[n];
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.a(parcel);
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.b(n);
            }
        };
    }
    
    public ObservableChar() {
    }
    
    public ObservableChar(final char mValue) {
        this.mValue = mValue;
    }
    
    public ObservableChar(final h... array) {
        super(array);
    }
    
    public int describeContents() {
        return 0;
    }
    
    public char get() {
        return this.mValue;
    }
    
    public void set(final char mValue) {
        if (mValue != this.mValue) {
            this.mValue = mValue;
            this.notifyChange();
        }
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeInt((int)this.mValue);
    }
}
