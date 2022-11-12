// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.metadata.scte35;

import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class PrivateCommand extends SpliceCommand
{
    public static final Parcelable$Creator<PrivateCommand> CREATOR;
    public final long a;
    public final long b;
    public final byte[] c;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<PrivateCommand>() {
            public PrivateCommand a(final Parcel parcel) {
                return new PrivateCommand(parcel, null);
            }
            
            public PrivateCommand[] b(final int n) {
                return new PrivateCommand[n];
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.a(parcel);
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.b(n);
            }
        };
    }
    
    private PrivateCommand(final long b, final byte[] c, final long a) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    private PrivateCommand(final Parcel parcel) {
        this.a = parcel.readLong();
        this.b = parcel.readLong();
        this.c = Util.j(parcel.createByteArray());
    }
    
    PrivateCommand(final Parcel parcel, final PrivateCommand$a parcelable$Creator) {
        this(parcel);
    }
    
    static PrivateCommand a(final ParsableByteArray parsableByteArray, int n, final long n2) {
        final long f = parsableByteArray.F();
        n -= 4;
        final byte[] array = new byte[n];
        parsableByteArray.j(array, 0, n);
        return new PrivateCommand(f, array, n2);
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeLong(this.a);
        parcel.writeLong(this.b);
        parcel.writeByteArray(this.c);
    }
}
