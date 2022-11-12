// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.metadata.id3;

import java.util.Arrays;
import com.google.android.exoplayer2.util.Util;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class GeobFrame extends Id3Frame
{
    public static final Parcelable$Creator<GeobFrame> CREATOR;
    public final String b;
    public final String c;
    public final String d;
    public final byte[] e;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<GeobFrame>() {
            public GeobFrame a(final Parcel parcel) {
                return new GeobFrame(parcel);
            }
            
            public GeobFrame[] b(final int n) {
                return new GeobFrame[n];
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.a(parcel);
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.b(n);
            }
        };
    }
    
    GeobFrame(final Parcel parcel) {
        super("GEOB");
        this.b = Util.j(parcel.readString());
        this.c = Util.j(parcel.readString());
        this.d = Util.j(parcel.readString());
        this.e = Util.j(parcel.createByteArray());
    }
    
    public GeobFrame(final String b, final String c, final String d, final byte[] e) {
        super("GEOB");
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (o != null && GeobFrame.class == o.getClass()) {
            final GeobFrame geobFrame = (GeobFrame)o;
            if (!Util.c(this.b, geobFrame.b) || !Util.c(this.c, geobFrame.c) || !Util.c(this.d, geobFrame.d) || !Arrays.equals(this.e, geobFrame.e)) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
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
        int hashCode3;
        if (c != null) {
            hashCode3 = c.hashCode();
        }
        else {
            hashCode3 = 0;
        }
        final String d = this.d;
        if (d != null) {
            hashCode = d.hashCode();
        }
        return (((527 + hashCode2) * 31 + hashCode3) * 31 + hashCode) * 31 + Arrays.hashCode(this.e);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(super.a);
        sb.append(": mimeType=");
        sb.append(this.b);
        sb.append(", filename=");
        sb.append(this.c);
        sb.append(", description=");
        sb.append(this.d);
        return sb.toString();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeByteArray(this.e);
    }
}
