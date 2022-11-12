// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.metadata.mp4;

import com.google.common.primitives.Floats;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.exoplayer2.metadata.Metadata;

public final class SmtaMetadataEntry implements Entry
{
    public static final Parcelable$Creator<SmtaMetadataEntry> CREATOR;
    public final float a;
    public final int b;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<SmtaMetadataEntry>() {
            public SmtaMetadataEntry a(final Parcel parcel) {
                return new SmtaMetadataEntry(parcel, null);
            }
            
            public SmtaMetadataEntry[] b(final int n) {
                return new SmtaMetadataEntry[n];
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.a(parcel);
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.b(n);
            }
        };
    }
    
    public SmtaMetadataEntry(final float a, final int b) {
        this.a = a;
        this.b = b;
    }
    
    private SmtaMetadataEntry(final Parcel parcel) {
        this.a = parcel.readFloat();
        this.b = parcel.readInt();
    }
    
    SmtaMetadataEntry(final Parcel parcel, final SmtaMetadataEntry$a parcelable$Creator) {
        this(parcel);
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
        if (o != null && SmtaMetadataEntry.class == o.getClass()) {
            final SmtaMetadataEntry smtaMetadataEntry = (SmtaMetadataEntry)o;
            if (this.a != smtaMetadataEntry.a || this.b != smtaMetadataEntry.b) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return (527 + Floats.a(this.a)) * 31 + this.b;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("smta: captureFrameRate=");
        sb.append(this.a);
        sb.append(", svcTemporalLayerCount=");
        sb.append(this.b);
        return sb.toString();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeFloat(this.a);
        parcel.writeInt(this.b);
    }
}
