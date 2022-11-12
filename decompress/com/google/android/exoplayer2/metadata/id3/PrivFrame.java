// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.metadata.id3;

import java.util.Arrays;
import com.google.android.exoplayer2.util.Util;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class PrivFrame extends Id3Frame
{
    public static final Parcelable$Creator<PrivFrame> CREATOR;
    public final String b;
    public final byte[] c;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<PrivFrame>() {
            public PrivFrame a(final Parcel parcel) {
                return new PrivFrame(parcel);
            }
            
            public PrivFrame[] b(final int n) {
                return new PrivFrame[n];
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.a(parcel);
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.b(n);
            }
        };
    }
    
    PrivFrame(final Parcel parcel) {
        super("PRIV");
        this.b = Util.j(parcel.readString());
        this.c = Util.j(parcel.createByteArray());
    }
    
    public PrivFrame(final String b, final byte[] c) {
        super("PRIV");
        this.b = b;
        this.c = c;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (o != null && PrivFrame.class == o.getClass()) {
            final PrivFrame privFrame = (PrivFrame)o;
            if (!Util.c(this.b, privFrame.b) || !Arrays.equals(this.c, privFrame.c)) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        final String b = this.b;
        int hashCode;
        if (b != null) {
            hashCode = b.hashCode();
        }
        else {
            hashCode = 0;
        }
        return (527 + hashCode) * 31 + Arrays.hashCode(this.c);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(super.a);
        sb.append(": owner=");
        sb.append(this.b);
        return sb.toString();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeString(this.b);
        parcel.writeByteArray(this.c);
    }
}
