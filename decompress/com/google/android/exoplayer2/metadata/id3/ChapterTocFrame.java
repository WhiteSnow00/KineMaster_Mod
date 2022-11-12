// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcelable;
import java.util.Arrays;
import com.google.android.exoplayer2.util.Util;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class ChapterTocFrame extends Id3Frame
{
    public static final Parcelable$Creator<ChapterTocFrame> CREATOR;
    public final String b;
    public final boolean c;
    public final boolean d;
    public final String[] e;
    private final Id3Frame[] f;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<ChapterTocFrame>() {
            public ChapterTocFrame a(final Parcel parcel) {
                return new ChapterTocFrame(parcel);
            }
            
            public ChapterTocFrame[] b(final int n) {
                return new ChapterTocFrame[n];
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.a(parcel);
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.b(n);
            }
        };
    }
    
    ChapterTocFrame(final Parcel parcel) {
        super("CTOC");
        this.b = Util.j(parcel.readString());
        final byte byte1 = parcel.readByte();
        final boolean b = true;
        int i = 0;
        this.c = (byte1 != 0);
        this.d = (parcel.readByte() != 0 && b);
        this.e = Util.j(parcel.createStringArray());
        final int int1 = parcel.readInt();
        this.f = new Id3Frame[int1];
        while (i < int1) {
            this.f[i] = (Id3Frame)parcel.readParcelable(Id3Frame.class.getClassLoader());
            ++i;
        }
    }
    
    public ChapterTocFrame(final String b, final boolean c, final boolean d, final String[] e, final Id3Frame[] f) {
        super("CTOC");
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (o != null && ChapterTocFrame.class == o.getClass()) {
            final ChapterTocFrame chapterTocFrame = (ChapterTocFrame)o;
            if (this.c != chapterTocFrame.c || this.d != chapterTocFrame.d || !Util.c(this.b, chapterTocFrame.b) || !Arrays.equals(this.e, chapterTocFrame.e) || !Arrays.equals(this.f, chapterTocFrame.f)) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        final int c = this.c ? 1 : 0;
        final int d = this.d ? 1 : 0;
        final String b = this.b;
        int hashCode;
        if (b != null) {
            hashCode = b.hashCode();
        }
        else {
            hashCode = 0;
        }
        return ((527 + c) * 31 + d) * 31 + hashCode;
    }
    
    public void writeToParcel(final Parcel parcel, int i) {
        parcel.writeString(this.b);
        parcel.writeByte((byte)(byte)(this.c ? 1 : 0));
        parcel.writeByte((byte)(byte)(this.d ? 1 : 0));
        parcel.writeStringArray(this.e);
        parcel.writeInt(this.f.length);
        final Id3Frame[] f = this.f;
        int length;
        for (length = f.length, i = 0; i < length; ++i) {
            parcel.writeParcelable((Parcelable)f[i], 0);
        }
    }
}
