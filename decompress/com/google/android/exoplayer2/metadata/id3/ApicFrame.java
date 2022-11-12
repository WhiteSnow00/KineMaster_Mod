// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.metadata.id3;

import java.util.Arrays;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.util.Util;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class ApicFrame extends Id3Frame
{
    public static final Parcelable$Creator<ApicFrame> CREATOR;
    public final String b;
    public final String c;
    public final int d;
    public final byte[] e;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<ApicFrame>() {
            public ApicFrame a(final Parcel parcel) {
                return new ApicFrame(parcel);
            }
            
            public ApicFrame[] b(final int n) {
                return new ApicFrame[n];
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.a(parcel);
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.b(n);
            }
        };
    }
    
    ApicFrame(final Parcel parcel) {
        super("APIC");
        this.b = Util.j(parcel.readString());
        this.c = parcel.readString();
        this.d = parcel.readInt();
        this.e = Util.j(parcel.createByteArray());
    }
    
    public ApicFrame(final String b, final String c, final int d, final byte[] e) {
        super("APIC");
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    @Override
    public void B0(final MediaMetadata.Builder builder) {
        builder.G(this.e, this.d);
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (o != null && ApicFrame.class == o.getClass()) {
            final ApicFrame apicFrame = (ApicFrame)o;
            if (this.d != apicFrame.d || !Util.c(this.b, apicFrame.b) || !Util.c(this.c, apicFrame.c) || !Arrays.equals(this.e, apicFrame.e)) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        final int d = this.d;
        final String b = this.b;
        int hashCode = 0;
        int hashCode2;
        if (b != null) {
            hashCode2 = b.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        final String c = this.c;
        if (c != null) {
            hashCode = c.hashCode();
        }
        return (((527 + d) * 31 + hashCode2) * 31 + hashCode) * 31 + Arrays.hashCode(this.e);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(super.a);
        sb.append(": mimeType=");
        sb.append(this.b);
        sb.append(", description=");
        sb.append(this.c);
        return sb.toString();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeInt(this.d);
        parcel.writeByteArray(this.e);
    }
}
