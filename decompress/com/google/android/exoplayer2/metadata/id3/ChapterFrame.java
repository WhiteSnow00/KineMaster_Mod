// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcelable;
import java.util.Arrays;
import com.google.android.exoplayer2.util.Util;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class ChapterFrame extends Id3Frame
{
    public static final Parcelable$Creator<ChapterFrame> CREATOR;
    public final String b;
    public final int c;
    public final int d;
    public final long e;
    public final long f;
    private final Id3Frame[] g;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<ChapterFrame>() {
            public ChapterFrame a(final Parcel parcel) {
                return new ChapterFrame(parcel);
            }
            
            public ChapterFrame[] b(final int n) {
                return new ChapterFrame[n];
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.a(parcel);
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.b(n);
            }
        };
    }
    
    ChapterFrame(final Parcel parcel) {
        super("CHAP");
        this.b = Util.j(parcel.readString());
        this.c = parcel.readInt();
        this.d = parcel.readInt();
        this.e = parcel.readLong();
        this.f = parcel.readLong();
        final int int1 = parcel.readInt();
        this.g = new Id3Frame[int1];
        for (int i = 0; i < int1; ++i) {
            this.g[i] = (Id3Frame)parcel.readParcelable(Id3Frame.class.getClassLoader());
        }
    }
    
    public ChapterFrame(final String b, final int c, final int d, final long e, final long f, final Id3Frame[] g) {
        super("CHAP");
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
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
        if (o != null && ChapterFrame.class == o.getClass()) {
            final ChapterFrame chapterFrame = (ChapterFrame)o;
            if (this.c != chapterFrame.c || this.d != chapterFrame.d || this.e != chapterFrame.e || this.f != chapterFrame.f || !Util.c(this.b, chapterFrame.b) || !Arrays.equals(this.g, chapterFrame.g)) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        final int c = this.c;
        final int d = this.d;
        final int n = (int)this.e;
        final int n2 = (int)this.f;
        final String b = this.b;
        int hashCode;
        if (b != null) {
            hashCode = b.hashCode();
        }
        else {
            hashCode = 0;
        }
        return ((((527 + c) * 31 + d) * 31 + n) * 31 + n2) * 31 + hashCode;
    }
    
    public void writeToParcel(final Parcel parcel, int i) {
        parcel.writeString(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeLong(this.e);
        parcel.writeLong(this.f);
        parcel.writeInt(this.g.length);
        final Id3Frame[] g = this.g;
        int length;
        for (length = g.length, i = 0; i < length; ++i) {
            parcel.writeParcelable((Parcelable)g[i], 0);
        }
    }
}
