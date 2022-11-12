// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.metadata.icy;

import java.util.Arrays;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.util.Assertions;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.exoplayer2.metadata.Metadata;

public final class IcyInfo implements Entry
{
    public static final Parcelable$Creator<IcyInfo> CREATOR;
    public final byte[] a;
    public final String b;
    public final String c;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<IcyInfo>() {
            public IcyInfo a(final Parcel parcel) {
                return new IcyInfo(parcel);
            }
            
            public IcyInfo[] b(final int n) {
                return new IcyInfo[n];
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.a(parcel);
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.b(n);
            }
        };
    }
    
    IcyInfo(final Parcel parcel) {
        this.a = Assertions.e(parcel.createByteArray());
        this.b = parcel.readString();
        this.c = parcel.readString();
    }
    
    public IcyInfo(final byte[] a, final String b, final String c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public void B0(final MediaMetadata.Builder builder) {
        final String b = this.b;
        if (b != null) {
            builder.i0(b);
        }
    }
    
    public int describeContents() {
        return 0;
    }
    
    @Override
    public boolean equals(final Object o) {
        return this == o || (o != null && IcyInfo.class == o.getClass() && Arrays.equals(this.a, ((IcyInfo)o).a));
    }
    
    @Override
    public int hashCode() {
        return Arrays.hashCode(this.a);
    }
    
    @Override
    public String toString() {
        return String.format("ICY: title=\"%s\", url=\"%s\", rawMetadata.length=\"%s\"", this.b, this.c, this.a.length);
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeByteArray(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
    }
}
