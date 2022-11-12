// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.metadata.flac;

import java.util.Arrays;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.common.base.Charsets;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.exoplayer2.metadata.Metadata;

public final class PictureFrame implements Entry
{
    public static final Parcelable$Creator<PictureFrame> CREATOR;
    public final int a;
    public final String b;
    public final String c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final byte[] h;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<PictureFrame>() {
            public PictureFrame a(final Parcel parcel) {
                return new PictureFrame(parcel);
            }
            
            public PictureFrame[] b(final int n) {
                return new PictureFrame[n];
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.a(parcel);
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.b(n);
            }
        };
    }
    
    public PictureFrame(final int a, final String b, final String c, final int d, final int e, final int f, final int g, final byte[] h) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
    }
    
    PictureFrame(final Parcel parcel) {
        this.a = parcel.readInt();
        this.b = Util.j(parcel.readString());
        this.c = Util.j(parcel.readString());
        this.d = parcel.readInt();
        this.e = parcel.readInt();
        this.f = parcel.readInt();
        this.g = parcel.readInt();
        this.h = Util.j(parcel.createByteArray());
    }
    
    public static PictureFrame a(final ParsableByteArray parsableByteArray) {
        final int n = parsableByteArray.n();
        final String b = parsableByteArray.B(parsableByteArray.n(), Charsets.a);
        final String a = parsableByteArray.A(parsableByteArray.n());
        final int n2 = parsableByteArray.n();
        final int n3 = parsableByteArray.n();
        final int n4 = parsableByteArray.n();
        final int n5 = parsableByteArray.n();
        final int n6 = parsableByteArray.n();
        final byte[] array = new byte[n6];
        parsableByteArray.j(array, 0, n6);
        return new PictureFrame(n, b, a, n2, n3, n4, n5, array);
    }
    
    @Override
    public void B0(final MediaMetadata.Builder builder) {
        builder.G(this.h, this.a);
    }
    
    public int describeContents() {
        return 0;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (o != null && PictureFrame.class == o.getClass()) {
            final PictureFrame pictureFrame = (PictureFrame)o;
            if (this.a != pictureFrame.a || !this.b.equals(pictureFrame.b) || !this.c.equals(pictureFrame.c) || this.d != pictureFrame.d || this.e != pictureFrame.e || this.f != pictureFrame.f || this.g != pictureFrame.g || !Arrays.equals(this.h, pictureFrame.h)) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return (((((((527 + this.a) * 31 + this.b.hashCode()) * 31 + this.c.hashCode()) * 31 + this.d) * 31 + this.e) * 31 + this.f) * 31 + this.g) * 31 + Arrays.hashCode(this.h);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Picture: mimeType=");
        sb.append(this.b);
        sb.append(", description=");
        sb.append(this.c);
        return sb.toString();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeInt(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
        parcel.writeInt(this.g);
        parcel.writeByteArray(this.h);
    }
}
