// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.offline;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public final class StreamKey implements Comparable<StreamKey>, Parcelable
{
    public static final Parcelable$Creator<StreamKey> CREATOR;
    public final int a;
    public final int b;
    public final int c;
    @Deprecated
    public final int d;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<StreamKey>() {
            public StreamKey a(final Parcel parcel) {
                return new StreamKey(parcel);
            }
            
            public StreamKey[] b(final int n) {
                return new StreamKey[n];
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.a(parcel);
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.b(n);
            }
        };
    }
    
    public StreamKey(final int a, final int b, final int n) {
        this.a = a;
        this.b = b;
        this.c = n;
        this.d = n;
    }
    
    StreamKey(final Parcel parcel) {
        this.a = parcel.readInt();
        this.b = parcel.readInt();
        final int int1 = parcel.readInt();
        this.c = int1;
        this.d = int1;
    }
    
    public int a(final StreamKey streamKey) {
        int n;
        if ((n = this.a - streamKey.a) == 0 && (n = this.b - streamKey.b) == 0) {
            n = this.c - streamKey.c;
        }
        return n;
    }
    
    @Override
    public /* bridge */ int compareTo(final Object o) {
        return this.a((StreamKey)o);
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
        if (o != null && StreamKey.class == o.getClass()) {
            final StreamKey streamKey = (StreamKey)o;
            if (this.a != streamKey.a || this.b != streamKey.b || this.c != streamKey.c) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return (this.a * 31 + this.b) * 31 + this.c;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append(".");
        sb.append(this.b);
        sb.append(".");
        sb.append(this.c);
        return sb.toString();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeInt(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
    }
}
