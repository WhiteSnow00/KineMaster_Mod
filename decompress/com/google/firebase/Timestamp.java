// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase;

import com.google.firebase.firestore.util.Preconditions;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public final class Timestamp implements Comparable<Timestamp>, Parcelable
{
    public static final Parcelable$Creator<Timestamp> CREATOR;
    private final long a;
    private final int b;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<Timestamp>() {
            public Timestamp a(final Parcel parcel) {
                return new Timestamp(parcel);
            }
            
            public Timestamp[] b(final int n) {
                return new Timestamp[n];
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.a(parcel);
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.b(n);
            }
        };
    }
    
    public Timestamp(final long a, final int b) {
        f(a, b);
        this.a = a;
        this.b = b;
    }
    
    protected Timestamp(final Parcel parcel) {
        this.a = parcel.readLong();
        this.b = parcel.readInt();
    }
    
    private static void f(final long n, final int n2) {
        Preconditions.a(n2 >= 0, "Timestamp nanoseconds out of range: %s", new Object[] { n2 });
        Preconditions.a(n2 < 1.0E9, "Timestamp nanoseconds out of range: %s", new Object[] { n2 });
        Preconditions.a(n >= -62135596800L, "Timestamp seconds out of range: %s", new Object[] { n });
        Preconditions.a(n < 253402300800L, "Timestamp seconds out of range: %s", new Object[] { n });
    }
    
    public int a(final Timestamp timestamp) {
        final long a = this.a;
        final long a2 = timestamp.a;
        if (a == a2) {
            return Integer.signum(this.b - timestamp.b);
        }
        return Long.signum(a - a2);
    }
    
    public int c() {
        return this.b;
    }
    
    @Override
    public /* bridge */ int compareTo(final Object o) {
        return this.a((Timestamp)o);
    }
    
    public long d() {
        return this.a;
    }
    
    public int describeContents() {
        return 0;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (o == this) {
            return true;
        }
        if (!(o instanceof Timestamp)) {
            return false;
        }
        if (this.a((Timestamp)o) != 0) {
            b = false;
        }
        return b;
    }
    
    @Override
    public int hashCode() {
        final long a = this.a;
        return ((int)a * 37 * 37 + (int)(a >> 32)) * 37 + this.b;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Timestamp(seconds=");
        sb.append(this.a);
        sb.append(", nanoseconds=");
        sb.append(this.b);
        sb.append(")");
        return sb.toString();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeLong(this.a);
        parcel.writeInt(this.b);
    }
}
