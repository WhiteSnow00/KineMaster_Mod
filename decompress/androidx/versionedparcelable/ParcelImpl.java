// 
// Decompiled by Procyon v0.6.0
// 

package androidx.versionedparcelable;

import android.os.Parcel;
import b1.b;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public class ParcelImpl implements Parcelable
{
    public static final Parcelable$Creator<ParcelImpl> CREATOR;
    private final b a;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<ParcelImpl>() {
            public ParcelImpl a(final Parcel parcel) {
                return new ParcelImpl(parcel);
            }
            
            public ParcelImpl[] b(final int n) {
                return new ParcelImpl[n];
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.a(parcel);
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.b(n);
            }
        };
    }
    
    protected ParcelImpl(final Parcel parcel) {
        this.a = new a(parcel).u();
    }
    
    public ParcelImpl(final b a) {
        this.a = a;
    }
    
    public <T extends b> T a() {
        return (T)this.a;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        new a(parcel).L(this.a);
    }
}
