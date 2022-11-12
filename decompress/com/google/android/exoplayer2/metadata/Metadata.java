// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.metadata;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaMetadata;
import java.util.Arrays;
import com.google.android.exoplayer2.util.Util;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public final class Metadata implements Parcelable
{
    public static final Parcelable$Creator<Metadata> CREATOR;
    private final Entry[] a;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<Metadata>() {
            public Metadata a(final Parcel parcel) {
                return new Metadata(parcel);
            }
            
            public Metadata[] b(final int n) {
                return new Metadata[n];
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.a(parcel);
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.b(n);
            }
        };
    }
    
    Metadata(final Parcel parcel) {
        this.a = new Entry[parcel.readInt()];
        int n = 0;
        while (true) {
            final Entry[] a = this.a;
            if (n >= a.length) {
                break;
            }
            a[n] = (Entry)parcel.readParcelable(Entry.class.getClassLoader());
            ++n;
        }
    }
    
    public Metadata(final List<? extends Entry> list) {
        this.a = list.toArray(new Entry[0]);
    }
    
    public Metadata(final Entry... a) {
        this.a = a;
    }
    
    public Metadata a(final Entry... array) {
        if (array.length == 0) {
            return this;
        }
        return new Metadata((Entry[])Util.G0(this.a, array));
    }
    
    public Metadata b(final Metadata metadata) {
        if (metadata == null) {
            return this;
        }
        return this.a(metadata.a);
    }
    
    public Entry c(final int n) {
        return this.a[n];
    }
    
    public int d() {
        return this.a.length;
    }
    
    public int describeContents() {
        return 0;
    }
    
    @Override
    public boolean equals(final Object o) {
        return this == o || (o != null && Metadata.class == o.getClass() && Arrays.equals(this.a, ((Metadata)o).a));
    }
    
    @Override
    public int hashCode() {
        return Arrays.hashCode(this.a);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("entries=");
        sb.append(Arrays.toString(this.a));
        return sb.toString();
    }
    
    public void writeToParcel(final Parcel parcel, int i) {
        parcel.writeInt(this.a.length);
        final Entry[] a = this.a;
        int length;
        for (length = a.length, i = 0; i < length; ++i) {
            parcel.writeParcelable((Parcelable)a[i], 0);
        }
    }
    
    public interface Entry extends Parcelable
    {
        default void B0(final MediaMetadata.Builder builder) {
        }
        
        default byte[] C1() {
            return null;
        }
        
        default Format M() {
            return null;
        }
    }
}
