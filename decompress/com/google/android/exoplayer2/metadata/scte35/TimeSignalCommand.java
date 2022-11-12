// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.metadata.scte35;

import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.ParsableByteArray;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class TimeSignalCommand extends SpliceCommand
{
    public static final Parcelable$Creator<TimeSignalCommand> CREATOR;
    public final long a;
    public final long b;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<TimeSignalCommand>() {
            public TimeSignalCommand a(final Parcel parcel) {
                return new TimeSignalCommand(parcel.readLong(), parcel.readLong(), null);
            }
            
            public TimeSignalCommand[] b(final int n) {
                return new TimeSignalCommand[n];
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.a(parcel);
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.b(n);
            }
        };
    }
    
    private TimeSignalCommand(final long a, final long b) {
        this.a = a;
        this.b = b;
    }
    
    TimeSignalCommand(final long n, final long n2, final TimeSignalCommand$a parcelable$Creator) {
        this(n, n2);
    }
    
    static TimeSignalCommand a(final ParsableByteArray parsableByteArray, long b, final TimestampAdjuster timestampAdjuster) {
        b = b(parsableByteArray, b);
        return new TimeSignalCommand(b, timestampAdjuster.b(b));
    }
    
    static long b(final ParsableByteArray parsableByteArray, long n) {
        final long n2 = parsableByteArray.D();
        if ((0x80L & n2) != 0x0L) {
            n = (0x1FFFFFFFFL & ((n2 & 0x1L) << 32 | parsableByteArray.F()) + n);
        }
        else {
            n = -9223372036854775807L;
        }
        return n;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeLong(this.a);
        parcel.writeLong(this.b);
    }
}
