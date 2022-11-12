// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.metadata.mp4;

import com.google.common.primitives.Longs;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.exoplayer2.metadata.Metadata;

public final class MotionPhotoMetadata implements Entry
{
    public static final Parcelable$Creator<MotionPhotoMetadata> CREATOR;
    public final long a;
    public final long b;
    public final long c;
    public final long d;
    public final long e;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<MotionPhotoMetadata>() {
            public MotionPhotoMetadata a(final Parcel parcel) {
                return new MotionPhotoMetadata(parcel, null);
            }
            
            public MotionPhotoMetadata[] b(final int n) {
                return new MotionPhotoMetadata[n];
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.a(parcel);
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.b(n);
            }
        };
    }
    
    public MotionPhotoMetadata(final long a, final long b, final long c, final long d, final long e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    private MotionPhotoMetadata(final Parcel parcel) {
        this.a = parcel.readLong();
        this.b = parcel.readLong();
        this.c = parcel.readLong();
        this.d = parcel.readLong();
        this.e = parcel.readLong();
    }
    
    MotionPhotoMetadata(final Parcel parcel, final MotionPhotoMetadata$a parcelable$Creator) {
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
        if (o != null && MotionPhotoMetadata.class == o.getClass()) {
            final MotionPhotoMetadata motionPhotoMetadata = (MotionPhotoMetadata)o;
            if (this.a != motionPhotoMetadata.a || this.b != motionPhotoMetadata.b || this.c != motionPhotoMetadata.c || this.d != motionPhotoMetadata.d || this.e != motionPhotoMetadata.e) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return ((((527 + Longs.e(this.a)) * 31 + Longs.e(this.b)) * 31 + Longs.e(this.c)) * 31 + Longs.e(this.d)) * 31 + Longs.e(this.e);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Motion photo metadata: photoStartPosition=");
        sb.append(this.a);
        sb.append(", photoSize=");
        sb.append(this.b);
        sb.append(", photoPresentationTimestampUs=");
        sb.append(this.c);
        sb.append(", videoStartPosition=");
        sb.append(this.d);
        sb.append(", videoSize=");
        sb.append(this.e);
        return sb.toString();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeLong(this.a);
        parcel.writeLong(this.b);
        parcel.writeLong(this.c);
        parcel.writeLong(this.d);
        parcel.writeLong(this.e);
    }
}
