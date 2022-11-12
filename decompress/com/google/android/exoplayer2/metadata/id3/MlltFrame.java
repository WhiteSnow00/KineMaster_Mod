// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.metadata.id3;

import java.util.Arrays;
import com.google.android.exoplayer2.util.Util;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class MlltFrame extends Id3Frame
{
    public static final Parcelable$Creator<MlltFrame> CREATOR;
    public final int b;
    public final int c;
    public final int d;
    public final int[] e;
    public final int[] f;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<MlltFrame>() {
            public MlltFrame a(final Parcel parcel) {
                return new MlltFrame(parcel);
            }
            
            public MlltFrame[] b(final int n) {
                return new MlltFrame[n];
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.a(parcel);
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.b(n);
            }
        };
    }
    
    public MlltFrame(final int b, final int c, final int d, final int[] e, final int[] f) {
        super("MLLT");
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }
    
    MlltFrame(final Parcel parcel) {
        super("MLLT");
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = parcel.readInt();
        this.e = Util.j(parcel.createIntArray());
        this.f = Util.j(parcel.createIntArray());
    }
    
    @Override
    public int describeContents() {
        return 0;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (o != null && MlltFrame.class == o.getClass()) {
            final MlltFrame mlltFrame = (MlltFrame)o;
            if (this.b != mlltFrame.b || this.c != mlltFrame.c || this.d != mlltFrame.d || !Arrays.equals(this.e, mlltFrame.e) || !Arrays.equals(this.f, mlltFrame.f)) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return ((((527 + this.b) * 31 + this.c) * 31 + this.d) * 31 + Arrays.hashCode(this.e)) * 31 + Arrays.hashCode(this.f);
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeIntArray(this.e);
        parcel.writeIntArray(this.f);
    }
}
