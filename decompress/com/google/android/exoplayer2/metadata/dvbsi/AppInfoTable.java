// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.metadata.dvbsi;

import com.google.android.exoplayer2.util.Assertions;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.exoplayer2.metadata.Metadata;

public final class AppInfoTable implements Entry
{
    public static final Parcelable$Creator<AppInfoTable> CREATOR;
    public final int a;
    public final String b;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<AppInfoTable>() {
            public AppInfoTable a(final Parcel parcel) {
                return new AppInfoTable(parcel.readInt(), Assertions.e(parcel.readString()));
            }
            
            public AppInfoTable[] b(final int n) {
                return new AppInfoTable[n];
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.a(parcel);
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.b(n);
            }
        };
    }
    
    public AppInfoTable(final int a, final String b) {
        this.a = a;
        this.b = b;
    }
    
    public int describeContents() {
        return 0;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Ait(controlCode=");
        sb.append(this.a);
        sb.append(",url=");
        sb.append(this.b);
        sb.append(")");
        return sb.toString();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeString(this.b);
        parcel.writeInt(this.a);
    }
}
