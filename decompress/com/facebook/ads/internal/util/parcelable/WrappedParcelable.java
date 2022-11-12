// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads.internal.util.parcelable;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public class WrappedParcelable implements Parcelable
{
    public static final Parcelable$Creator<WrappedParcelable> CREATOR;
    private final byte[] mParcelableBytes;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<WrappedParcelable>() {
            public WrappedParcelable a(final Parcel parcel) {
                return new WrappedParcelable(parcel);
            }
            
            public WrappedParcelable[] b(final int n) {
                return new WrappedParcelable[n];
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.a(parcel);
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.b(n);
            }
        };
    }
    
    protected WrappedParcelable(final Parcel parcel) {
        this.mParcelableBytes = parcel.createByteArray();
    }
    
    public WrappedParcelable(final Parcelable parcelable) {
        this.mParcelableBytes = marshallParcelable(parcelable);
    }
    
    public WrappedParcelable(final byte[] mParcelableBytes) {
        this.mParcelableBytes = mParcelableBytes;
    }
    
    public static byte[] marshallParcelable(final Parcelable parcelable) {
        final Parcel obtain = Parcel.obtain();
        obtain.writeParcelable(parcelable, 0);
        final byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public Parcelable unwrap(final ClassLoader classLoader) {
        final Parcel obtain = Parcel.obtain();
        final byte[] mParcelableBytes = this.mParcelableBytes;
        if (mParcelableBytes != null) {
            obtain.unmarshall(mParcelableBytes, 0, mParcelableBytes.length);
            obtain.setDataPosition(0);
            final Parcelable parcelable = obtain.readParcelable(classLoader);
            obtain.recycle();
            return parcelable;
        }
        return null;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeByteArray(this.mParcelableBytes);
    }
}
