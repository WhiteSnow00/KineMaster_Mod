// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.metadata.emsg;

import java.util.Arrays;
import com.google.android.exoplayer2.util.Util;
import android.os.Parcel;
import com.google.android.exoplayer2.Format;
import android.os.Parcelable$Creator;
import com.google.android.exoplayer2.metadata.Metadata;

public final class EventMessage implements Entry
{
    public static final Parcelable$Creator<EventMessage> CREATOR;
    private static final Format g;
    private static final Format h;
    public final String a;
    public final String b;
    public final long c;
    public final long d;
    public final byte[] e;
    private int f;
    
    static {
        g = new Format.Builder().e0("application/id3").E();
        h = new Format.Builder().e0("application/x-scte35").E();
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<EventMessage>() {
            public EventMessage a(final Parcel parcel) {
                return new EventMessage(parcel);
            }
            
            public EventMessage[] b(final int n) {
                return new EventMessage[n];
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.a(parcel);
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.b(n);
            }
        };
    }
    
    EventMessage(final Parcel parcel) {
        this.a = Util.j(parcel.readString());
        this.b = Util.j(parcel.readString());
        this.c = parcel.readLong();
        this.d = parcel.readLong();
        this.e = Util.j(parcel.createByteArray());
    }
    
    public EventMessage(final String a, final String b, final long c, final long d, final byte[] e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    @Override
    public byte[] C1() {
        byte[] e;
        if (this.M() != null) {
            e = this.e;
        }
        else {
            e = null;
        }
        return e;
    }
    
    @Override
    public Format M() {
        final String a = this.a;
        a.hashCode();
        final int hashCode = a.hashCode();
        int n = -1;
        switch (hashCode) {
            case 1303648457: {
                if (!a.equals("https://developer.apple.com/streaming/emsg-id3")) {
                    break;
                }
                n = 2;
                break;
            }
            case -795945609: {
                if (!a.equals("https://aomedia.org/emsg/ID3")) {
                    break;
                }
                n = 1;
                break;
            }
            case -1468477611: {
                if (!a.equals("urn:scte:scte35:2014:bin")) {
                    break;
                }
                n = 0;
                break;
            }
        }
        switch (n) {
            default: {
                return null;
            }
            case 1:
            case 2: {
                return EventMessage.g;
            }
            case 0: {
                return EventMessage.h;
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
        if (o != null && EventMessage.class == o.getClass()) {
            final EventMessage eventMessage = (EventMessage)o;
            if (this.c != eventMessage.c || this.d != eventMessage.d || !Util.c(this.a, eventMessage.a) || !Util.c(this.b, eventMessage.b) || !Arrays.equals(this.e, eventMessage.e)) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        if (this.f == 0) {
            final String a = this.a;
            int hashCode = 0;
            int hashCode2;
            if (a != null) {
                hashCode2 = a.hashCode();
            }
            else {
                hashCode2 = 0;
            }
            final String b = this.b;
            if (b != null) {
                hashCode = b.hashCode();
            }
            final long c = this.c;
            final int n = (int)(c ^ c >>> 32);
            final long d = this.d;
            this.f = ((((527 + hashCode2) * 31 + hashCode) * 31 + n) * 31 + (int)(d ^ d >>> 32)) * 31 + Arrays.hashCode(this.e);
        }
        return this.f;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("EMSG: scheme=");
        sb.append(this.a);
        sb.append(", id=");
        sb.append(this.d);
        sb.append(", durationMs=");
        sb.append(this.c);
        sb.append(", value=");
        sb.append(this.b);
        return sb.toString();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeLong(this.c);
        parcel.writeLong(this.d);
        parcel.writeByteArray(this.e);
    }
}
