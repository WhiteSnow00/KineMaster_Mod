// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.metadata.id3;

import com.google.android.exoplayer2.util.Util;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class InternalFrame extends Id3Frame
{
    public static final Parcelable$Creator<InternalFrame> CREATOR;
    public final String b;
    public final String c;
    public final String d;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<InternalFrame>() {
            public InternalFrame a(final Parcel parcel) {
                return new InternalFrame(parcel);
            }
            
            public InternalFrame[] b(final int n) {
                return new InternalFrame[n];
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.a(parcel);
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.b(n);
            }
        };
    }
    
    InternalFrame(final Parcel parcel) {
        super("----");
        this.b = Util.j(parcel.readString());
        this.c = Util.j(parcel.readString());
        this.d = Util.j(parcel.readString());
    }
    
    public InternalFrame(final String b, final String c, final String d) {
        super("----");
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (o != null && InternalFrame.class == o.getClass()) {
            final InternalFrame internalFrame = (InternalFrame)o;
            if (!Util.c(this.c, internalFrame.c) || !Util.c(this.b, internalFrame.b) || !Util.c(this.d, internalFrame.d)) {
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
        return ((527 + hashCode2) * 31 + hashCode3) * 31 + hashCode;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(super.a);
        sb.append(": domain=");
        sb.append(this.b);
        sb.append(", description=");
        sb.append(this.c);
        return sb.toString();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeString(super.a);
        parcel.writeString(this.b);
        parcel.writeString(this.d);
    }
}
