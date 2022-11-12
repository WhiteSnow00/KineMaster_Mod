// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.metadata.mp4;

import java.util.Arrays;
import com.google.android.exoplayer2.util.Util;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.exoplayer2.metadata.Metadata;

public final class MdtaMetadataEntry implements Entry
{
    public static final Parcelable$Creator<MdtaMetadataEntry> CREATOR;
    public final String a;
    public final byte[] b;
    public final int c;
    public final int d;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<MdtaMetadataEntry>() {
            public MdtaMetadataEntry a(final Parcel parcel) {
                return new MdtaMetadataEntry(parcel, null);
            }
            
            public MdtaMetadataEntry[] b(final int n) {
                return new MdtaMetadataEntry[n];
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.a(parcel);
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.b(n);
            }
        };
    }
    
    private MdtaMetadataEntry(final Parcel parcel) {
        this.a = Util.j(parcel.readString());
        this.b = Util.j(parcel.createByteArray());
        this.c = parcel.readInt();
        this.d = parcel.readInt();
    }
    
    MdtaMetadataEntry(final Parcel parcel, final MdtaMetadataEntry$a parcelable$Creator) {
        this(parcel);
    }
    
    public MdtaMetadataEntry(final String a, final byte[] b, final int c, final int d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
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
        if (o != null && MdtaMetadataEntry.class == o.getClass()) {
            final MdtaMetadataEntry mdtaMetadataEntry = (MdtaMetadataEntry)o;
            if (!this.a.equals(mdtaMetadataEntry.a) || !Arrays.equals(this.b, mdtaMetadataEntry.b) || this.c != mdtaMetadataEntry.c || this.d != mdtaMetadataEntry.d) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return (((527 + this.a.hashCode()) * 31 + Arrays.hashCode(this.b)) * 31 + this.c) * 31 + this.d;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("mdta: key=");
        sb.append(this.a);
        return sb.toString();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeString(this.a);
        parcel.writeByteArray(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
    }
}
