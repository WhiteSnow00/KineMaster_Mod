// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.metadata.flac;

import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.util.Util;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.exoplayer2.metadata.Metadata;

@Deprecated
public class VorbisComment implements Entry
{
    public static final Parcelable$Creator<VorbisComment> CREATOR;
    public final String a;
    public final String b;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<VorbisComment>() {
            public VorbisComment a(final Parcel parcel) {
                return new VorbisComment(parcel);
            }
            
            public VorbisComment[] b(final int n) {
                return new VorbisComment[n];
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.a(parcel);
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.b(n);
            }
        };
    }
    
    protected VorbisComment(final Parcel parcel) {
        this.a = Util.j(parcel.readString());
        this.b = Util.j(parcel.readString());
    }
    
    public VorbisComment(final String a, final String b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public void B0(final MediaMetadata.Builder builder) {
        final String a = this.a;
        a.hashCode();
        final int hashCode = a.hashCode();
        int n = -1;
        switch (hashCode) {
            case 1939198791: {
                if (!a.equals("ARTIST")) {
                    break;
                }
                n = 4;
                break;
            }
            case 1746739798: {
                if (!a.equals("ALBUMARTIST")) {
                    break;
                }
                n = 3;
                break;
            }
            case 428414940: {
                if (!a.equals("DESCRIPTION")) {
                    break;
                }
                n = 2;
                break;
            }
            case 79833656: {
                if (!a.equals("TITLE")) {
                    break;
                }
                n = 1;
                break;
            }
            case 62359119: {
                if (!a.equals("ALBUM")) {
                    break;
                }
                n = 0;
                break;
            }
        }
        switch (n) {
            case 4: {
                builder.M(this.b);
                break;
            }
            case 3: {
                builder.K(this.b);
                break;
            }
            case 2: {
                builder.S(this.b);
                break;
            }
            case 1: {
                builder.i0(this.b);
                break;
            }
            case 0: {
                builder.L(this.b);
                break;
            }
        }
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
        if (o != null && this.getClass() == o.getClass()) {
            final VorbisComment vorbisComment = (VorbisComment)o;
            if (!this.a.equals(vorbisComment.a) || !this.b.equals(vorbisComment.b)) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return (527 + this.a.hashCode()) * 31 + this.b.hashCode();
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("VC: ");
        sb.append(this.a);
        sb.append("=");
        sb.append(this.b);
        return sb.toString();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
    }
}
