// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.metadata.id3;

import com.google.android.exoplayer2.util.Util;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class UrlLinkFrame extends Id3Frame
{
    public static final Parcelable$Creator<UrlLinkFrame> CREATOR;
    public final String b;
    public final String c;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<UrlLinkFrame>() {
            public UrlLinkFrame a(final Parcel parcel) {
                return new UrlLinkFrame(parcel);
            }
            
            public UrlLinkFrame[] b(final int n) {
                return new UrlLinkFrame[n];
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.a(parcel);
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.b(n);
            }
        };
    }
    
    UrlLinkFrame(final Parcel parcel) {
        super(Util.j(parcel.readString()));
        this.b = parcel.readString();
        this.c = Util.j(parcel.readString());
    }
    
    public UrlLinkFrame(final String s, final String b, final String c) {
        super(s);
        this.b = b;
        this.c = c;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (o != null && UrlLinkFrame.class == o.getClass()) {
            final UrlLinkFrame urlLinkFrame = (UrlLinkFrame)o;
            if (!super.a.equals(urlLinkFrame.a) || !Util.c(this.b, urlLinkFrame.b) || !Util.c(this.c, urlLinkFrame.c)) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        final int hashCode = super.a.hashCode();
        final String b = this.b;
        int hashCode2 = 0;
        int hashCode3;
        if (b != null) {
            hashCode3 = b.hashCode();
        }
        else {
            hashCode3 = 0;
        }
        final String c = this.c;
        if (c != null) {
            hashCode2 = c.hashCode();
        }
        return ((527 + hashCode) * 31 + hashCode3) * 31 + hashCode2;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(super.a);
        sb.append(": url=");
        sb.append(this.c);
        return sb.toString();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeString(super.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
    }
}
