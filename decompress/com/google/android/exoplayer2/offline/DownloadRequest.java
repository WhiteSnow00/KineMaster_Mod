// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.offline;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import com.google.android.exoplayer2.util.Util;
import android.os.Parcel;
import java.util.List;
import android.net.Uri;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public final class DownloadRequest implements Parcelable
{
    public static final Parcelable$Creator<DownloadRequest> CREATOR;
    public final String a;
    public final Uri b;
    public final String c;
    public final List<StreamKey> d;
    public final byte[] e;
    public final String f;
    public final byte[] g;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<DownloadRequest>() {
            public DownloadRequest a(final Parcel parcel) {
                return new DownloadRequest(parcel);
            }
            
            public DownloadRequest[] b(final int n) {
                return new DownloadRequest[n];
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.a(parcel);
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.b(n);
            }
        };
    }
    
    DownloadRequest(final Parcel parcel) {
        this.a = Util.j(parcel.readString());
        this.b = Uri.parse((String)Util.j(parcel.readString()));
        this.c = parcel.readString();
        final int int1 = parcel.readInt();
        final ArrayList list = new ArrayList<StreamKey>(int1);
        for (int i = 0; i < int1; ++i) {
            list.add((StreamKey)parcel.readParcelable(StreamKey.class.getClassLoader()));
        }
        this.d = Collections.unmodifiableList((List<? extends StreamKey>)list);
        this.e = parcel.createByteArray();
        this.f = parcel.readString();
        this.g = Util.j(parcel.createByteArray());
    }
    
    public int describeContents() {
        return 0;
    }
    
    @Override
    public boolean equals(final Object o) {
        final boolean b = o instanceof DownloadRequest;
        final boolean b2 = false;
        if (!b) {
            return false;
        }
        final DownloadRequest downloadRequest = (DownloadRequest)o;
        boolean b3 = b2;
        if (this.a.equals(downloadRequest.a)) {
            b3 = b2;
            if (this.b.equals((Object)downloadRequest.b)) {
                b3 = b2;
                if (Util.c(this.c, downloadRequest.c)) {
                    b3 = b2;
                    if (this.d.equals(downloadRequest.d)) {
                        b3 = b2;
                        if (Arrays.equals(this.e, downloadRequest.e)) {
                            b3 = b2;
                            if (Util.c(this.f, downloadRequest.f)) {
                                b3 = b2;
                                if (Arrays.equals(this.g, downloadRequest.g)) {
                                    b3 = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return b3;
    }
    
    @Override
    public final int hashCode() {
        final int hashCode = this.a.hashCode();
        final int hashCode2 = this.b.hashCode();
        final String c = this.c;
        int hashCode3 = 0;
        int hashCode4;
        if (c != null) {
            hashCode4 = c.hashCode();
        }
        else {
            hashCode4 = 0;
        }
        final int hashCode5 = this.d.hashCode();
        final int hashCode6 = Arrays.hashCode(this.e);
        final String f = this.f;
        if (f != null) {
            hashCode3 = f.hashCode();
        }
        return (((((hashCode * 31 * 31 + hashCode2) * 31 + hashCode4) * 31 + hashCode5) * 31 + hashCode6) * 31 + hashCode3) * 31 + Arrays.hashCode(this.g);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.c);
        sb.append(":");
        sb.append(this.a);
        return sb.toString();
    }
    
    public void writeToParcel(final Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b.toString());
        parcel.writeString(this.c);
        parcel.writeInt(this.d.size());
        for (i = 0; i < this.d.size(); ++i) {
            parcel.writeParcelable((Parcelable)this.d.get(i), 0);
        }
        parcel.writeByteArray(this.e);
        parcel.writeString(this.f);
        parcel.writeByteArray(this.g);
    }
    
    public static class Builder
    {
    }
    
    public static class UnsupportedRequestException extends IOException
    {
    }
}
