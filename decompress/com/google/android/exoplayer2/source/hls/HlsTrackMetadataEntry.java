// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.hls;

import android.os.Parcelable;
import android.text.TextUtils;
import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;
import android.os.Parcel;
import java.util.List;
import android.os.Parcelable$Creator;
import com.google.android.exoplayer2.metadata.Metadata;

public final class HlsTrackMetadataEntry implements Entry
{
    public static final Parcelable$Creator<HlsTrackMetadataEntry> CREATOR;
    public final String a;
    public final String b;
    public final List<VariantInfo> c;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<HlsTrackMetadataEntry>() {
            public HlsTrackMetadataEntry a(final Parcel parcel) {
                return new HlsTrackMetadataEntry(parcel);
            }
            
            public HlsTrackMetadataEntry[] b(final int n) {
                return new HlsTrackMetadataEntry[n];
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.a(parcel);
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.b(n);
            }
        };
    }
    
    HlsTrackMetadataEntry(final Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        final int int1 = parcel.readInt();
        final ArrayList list = new ArrayList<VariantInfo>(int1);
        for (int i = 0; i < int1; ++i) {
            list.add((VariantInfo)parcel.readParcelable(VariantInfo.class.getClassLoader()));
        }
        this.c = Collections.unmodifiableList((List<? extends VariantInfo>)list);
    }
    
    public HlsTrackMetadataEntry(final String a, final String b, final List<VariantInfo> list) {
        this.a = a;
        this.b = b;
        this.c = Collections.unmodifiableList((List<? extends VariantInfo>)new ArrayList<VariantInfo>(list));
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
        if (o != null && HlsTrackMetadataEntry.class == o.getClass()) {
            final HlsTrackMetadataEntry hlsTrackMetadataEntry = (HlsTrackMetadataEntry)o;
            if (!TextUtils.equals((CharSequence)this.a, (CharSequence)hlsTrackMetadataEntry.a) || !TextUtils.equals((CharSequence)this.b, (CharSequence)hlsTrackMetadataEntry.b) || !this.c.equals(hlsTrackMetadataEntry.c)) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
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
        return (hashCode2 * 31 + hashCode) * 31 + this.c.hashCode();
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("HlsTrackMetadataEntry");
        String string;
        if (this.a != null) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append(" [");
            sb2.append(this.a);
            sb2.append(", ");
            sb2.append(this.b);
            sb2.append("]");
            string = sb2.toString();
        }
        else {
            string = "";
        }
        sb.append(string);
        return sb.toString();
    }
    
    public void writeToParcel(final Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        final int size = this.c.size();
        parcel.writeInt(size);
        for (i = 0; i < size; ++i) {
            parcel.writeParcelable((Parcelable)this.c.get(i), 0);
        }
    }
    
    public static final class VariantInfo implements Parcelable
    {
        public static final Parcelable$Creator<VariantInfo> CREATOR;
        public final int a;
        public final int b;
        public final String c;
        public final String d;
        public final String e;
        public final String f;
        
        static {
            CREATOR = (Parcelable$Creator)new Parcelable$Creator<VariantInfo>() {
                public VariantInfo a(final Parcel parcel) {
                    return new VariantInfo(parcel);
                }
                
                public VariantInfo[] b(final int n) {
                    return new VariantInfo[n];
                }
                
                public /* bridge */ Object createFromParcel(final Parcel parcel) {
                    return this.a(parcel);
                }
                
                public /* bridge */ Object[] newArray(final int n) {
                    return this.b(n);
                }
            };
        }
        
        public VariantInfo(final int a, final int b, final String c, final String d, final String e, final String f) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
            this.f = f;
        }
        
        VariantInfo(final Parcel parcel) {
            this.a = parcel.readInt();
            this.b = parcel.readInt();
            this.c = parcel.readString();
            this.d = parcel.readString();
            this.e = parcel.readString();
            this.f = parcel.readString();
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
            if (o != null && VariantInfo.class == o.getClass()) {
                final VariantInfo variantInfo = (VariantInfo)o;
                if (this.a != variantInfo.a || this.b != variantInfo.b || !TextUtils.equals((CharSequence)this.c, (CharSequence)variantInfo.c) || !TextUtils.equals((CharSequence)this.d, (CharSequence)variantInfo.d) || !TextUtils.equals((CharSequence)this.e, (CharSequence)variantInfo.e) || !TextUtils.equals((CharSequence)this.f, (CharSequence)variantInfo.f)) {
                    b = false;
                }
                return b;
            }
            return false;
        }
        
        @Override
        public int hashCode() {
            final int a = this.a;
            final int b = this.b;
            final String c = this.c;
            int hashCode = 0;
            int hashCode2;
            if (c != null) {
                hashCode2 = c.hashCode();
            }
            else {
                hashCode2 = 0;
            }
            final String d = this.d;
            int hashCode3;
            if (d != null) {
                hashCode3 = d.hashCode();
            }
            else {
                hashCode3 = 0;
            }
            final String e = this.e;
            int hashCode4;
            if (e != null) {
                hashCode4 = e.hashCode();
            }
            else {
                hashCode4 = 0;
            }
            final String f = this.f;
            if (f != null) {
                hashCode = f.hashCode();
            }
            return ((((a * 31 + b) * 31 + hashCode2) * 31 + hashCode3) * 31 + hashCode4) * 31 + hashCode;
        }
        
        public void writeToParcel(final Parcel parcel, final int n) {
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
            parcel.writeString(this.c);
            parcel.writeString(this.d);
            parcel.writeString(this.e);
            parcel.writeString(this.f);
        }
    }
}
