// 
// Decompiled by Procyon v0.6.0
// 

package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public class ObservableParcelable<T extends Parcelable> extends ObservableField<T> implements Parcelable
{
    public static final Parcelable$Creator<ObservableParcelable> CREATOR;
    static final long serialVersionUID = 1L;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<ObservableParcelable>() {
            public ObservableParcelable a(final Parcel parcel) {
                return new ObservableParcelable((T)parcel.readParcelable(this.getClass().getClassLoader()));
            }
            
            public ObservableParcelable[] b(final int n) {
                return new ObservableParcelable[n];
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.a(parcel);
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.b(n);
            }
        };
    }
    
    public ObservableParcelable() {
    }
    
    public ObservableParcelable(final T t) {
        super(t);
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeParcelable((Parcelable)this.get(), 0);
    }
}
