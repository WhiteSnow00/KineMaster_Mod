// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.metadata.vorbis;

import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class VorbisComment extends com.google.android.exoplayer2.metadata.flac.VorbisComment
{
    public static final Parcelable$Creator<VorbisComment> CREATOR;
    
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
    
    VorbisComment(final Parcel parcel) {
        super(parcel);
    }
    
    public VorbisComment(final String s, final String s2) {
        super(s, s2);
    }
}
