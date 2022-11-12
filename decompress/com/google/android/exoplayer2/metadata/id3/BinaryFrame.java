// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.metadata.id3;

import java.util.Arrays;
import com.google.android.exoplayer2.util.Util;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class BinaryFrame extends Id3Frame
{
    public static final Parcelable$Creator<BinaryFrame> CREATOR;
    public final byte[] b;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<BinaryFrame>() {
            public BinaryFrame a(final Parcel parcel) {
                return new BinaryFrame(parcel);
            }
            
            public BinaryFrame[] b(final int n) {
                return new BinaryFrame[n];
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.a(parcel);
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.b(n);
            }
        };
    }
    
    BinaryFrame(final Parcel parcel) {
        super(Util.j(parcel.readString()));
        this.b = Util.j(parcel.createByteArray());
    }
    
    public BinaryFrame(final String s, final byte[] b) {
        super(s);
        this.b = b;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (o != null && BinaryFrame.class == o.getClass()) {
            final BinaryFrame binaryFrame = (BinaryFrame)o;
            if (!super.a.equals(binaryFrame.a) || !Arrays.equals(this.b, binaryFrame.b)) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return (527 + super.a.hashCode()) * 31 + Arrays.hashCode(this.b);
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeString(super.a);
        parcel.writeByteArray(this.b);
    }
}
