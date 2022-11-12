// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.util.Assertions;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import java.util.UUID;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.google.android.exoplayer2.util.Util;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import java.util.Comparator;

public final class DrmInitData implements Comparator<SchemeData>, Parcelable
{
    public static final Parcelable$Creator<DrmInitData> CREATOR;
    private final SchemeData[] a;
    private int b;
    public final String c;
    public final int d;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<DrmInitData>() {
            public DrmInitData a(final Parcel parcel) {
                return new DrmInitData(parcel);
            }
            
            public DrmInitData[] b(final int n) {
                return new DrmInitData[n];
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.a(parcel);
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.b(n);
            }
        };
    }
    
    DrmInitData(final Parcel parcel) {
        this.c = parcel.readString();
        final SchemeData[] a = Util.j(parcel.createTypedArray((Parcelable$Creator)SchemeData.CREATOR));
        this.a = a;
        this.d = a.length;
    }
    
    public DrmInitData(final String s, final List<SchemeData> list) {
        this(s, false, (SchemeData[])list.toArray(new SchemeData[0]));
    }
    
    private DrmInitData(final String c, final boolean b, final SchemeData... array) {
        this.c = c;
        SchemeData[] a = array;
        if (b) {
            a = array.clone();
        }
        this.a = a;
        this.d = a.length;
        Arrays.sort(a, this);
    }
    
    public DrmInitData(final String s, final SchemeData... array) {
        this(s, true, array);
    }
    
    public DrmInitData(final List<SchemeData> list) {
        this(null, false, (SchemeData[])list.toArray(new SchemeData[0]));
    }
    
    public DrmInitData(final SchemeData... array) {
        this((String)null, array);
    }
    
    private static boolean b(final ArrayList<SchemeData> list, final int n, final UUID uuid) {
        for (int i = 0; i < n; ++i) {
            if (list.get(i).b.equals(uuid)) {
                return true;
            }
        }
        return false;
    }
    
    public static DrmInitData d(final DrmInitData drmInitData, final DrmInitData drmInitData2) {
        final ArrayList list = new ArrayList();
        final int n = 0;
        final DrmInitData drmInitData3 = null;
        String s;
        if (drmInitData != null) {
            final String c = drmInitData.c;
            final SchemeData[] a = drmInitData.a;
            final int length = a.length;
            int n2 = 0;
            while (true) {
                s = c;
                if (n2 >= length) {
                    break;
                }
                final SchemeData schemeData = a[n2];
                if (schemeData.c()) {
                    list.add(schemeData);
                }
                ++n2;
            }
        }
        else {
            s = null;
        }
        String s2 = s;
        if (drmInitData2 != null) {
            String c2;
            if ((c2 = s) == null) {
                c2 = drmInitData2.c;
            }
            final int size = list.size();
            final SchemeData[] a2 = drmInitData2.a;
            final int length2 = a2.length;
            int n3 = n;
            while (true) {
                s2 = c2;
                if (n3 >= length2) {
                    break;
                }
                final SchemeData schemeData2 = a2[n3];
                if (schemeData2.c() && !b(list, size, schemeData2.b)) {
                    list.add(schemeData2);
                }
                ++n3;
            }
        }
        DrmInitData drmInitData4;
        if (list.isEmpty()) {
            drmInitData4 = drmInitData3;
        }
        else {
            drmInitData4 = new DrmInitData(s2, list);
        }
        return drmInitData4;
    }
    
    public int a(final SchemeData schemeData, final SchemeData schemeData2) {
        final UUID a = C.a;
        int compareTo;
        if (a.equals(schemeData.b)) {
            if (a.equals(schemeData2.b)) {
                compareTo = 0;
            }
            else {
                compareTo = 1;
            }
        }
        else {
            compareTo = schemeData.b.compareTo(schemeData2.b);
        }
        return compareTo;
    }
    
    public DrmInitData c(final String s) {
        if (Util.c(this.c, s)) {
            return this;
        }
        return new DrmInitData(s, false, this.a);
    }
    
    @Override
    public /* bridge */ int compare(final Object o, final Object o2) {
        return this.a((SchemeData)o, (SchemeData)o2);
    }
    
    public int describeContents() {
        return 0;
    }
    
    public SchemeData e(final int n) {
        return this.a[n];
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (o != null && DrmInitData.class == o.getClass()) {
            final DrmInitData drmInitData = (DrmInitData)o;
            if (!Util.c(this.c, drmInitData.c) || !Arrays.equals(this.a, drmInitData.a)) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    public DrmInitData f(final DrmInitData drmInitData) {
        final String c = this.c;
        boolean b = false;
        Label_0039: {
            if (c != null) {
                final String c2 = drmInitData.c;
                if (c2 != null) {
                    if (!TextUtils.equals((CharSequence)c, (CharSequence)c2)) {
                        b = false;
                        break Label_0039;
                    }
                }
            }
            b = true;
        }
        Assertions.g(b);
        String s = this.c;
        if (s == null) {
            s = drmInitData.c;
        }
        return new DrmInitData(s, (SchemeData[])Util.G0(this.a, drmInitData.a));
    }
    
    @Override
    public int hashCode() {
        if (this.b == 0) {
            final String c = this.c;
            int hashCode;
            if (c == null) {
                hashCode = 0;
            }
            else {
                hashCode = c.hashCode();
            }
            this.b = hashCode * 31 + Arrays.hashCode(this.a);
        }
        return this.b;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeString(this.c);
        parcel.writeTypedArray((Parcelable[])this.a, 0);
    }
    
    public static final class SchemeData implements Parcelable
    {
        public static final Parcelable$Creator<SchemeData> CREATOR;
        private int a;
        public final UUID b;
        public final String c;
        public final String d;
        public final byte[] e;
        
        static {
            CREATOR = (Parcelable$Creator)new Parcelable$Creator<SchemeData>() {
                public SchemeData a(final Parcel parcel) {
                    return new SchemeData(parcel);
                }
                
                public SchemeData[] b(final int n) {
                    return new SchemeData[n];
                }
                
                public /* bridge */ Object createFromParcel(final Parcel parcel) {
                    return this.a(parcel);
                }
                
                public /* bridge */ Object[] newArray(final int n) {
                    return this.b(n);
                }
            };
        }
        
        SchemeData(final Parcel parcel) {
            this.b = new UUID(parcel.readLong(), parcel.readLong());
            this.c = parcel.readString();
            this.d = Util.j(parcel.readString());
            this.e = parcel.createByteArray();
        }
        
        public SchemeData(final UUID uuid, final String c, final String s, final byte[] e) {
            this.b = Assertions.e(uuid);
            this.c = c;
            this.d = Assertions.e(s);
            this.e = e;
        }
        
        public SchemeData(final UUID uuid, final String s, final byte[] array) {
            this(uuid, null, s, array);
        }
        
        public boolean a(final SchemeData schemeData) {
            return this.c() && !schemeData.c() && this.d(schemeData.b);
        }
        
        public SchemeData b(final byte[] array) {
            return new SchemeData(this.b, this.c, this.d, array);
        }
        
        public boolean c() {
            return this.e != null;
        }
        
        public boolean d(final UUID uuid) {
            return C.a.equals(this.b) || uuid.equals(this.b);
        }
        
        public int describeContents() {
            return 0;
        }
        
        @Override
        public boolean equals(final Object o) {
            final boolean b = o instanceof SchemeData;
            final boolean b2 = false;
            if (!b) {
                return false;
            }
            if (o == this) {
                return true;
            }
            final SchemeData schemeData = (SchemeData)o;
            boolean b3 = b2;
            if (Util.c(this.c, schemeData.c)) {
                b3 = b2;
                if (Util.c(this.d, schemeData.d)) {
                    b3 = b2;
                    if (Util.c(this.b, schemeData.b)) {
                        b3 = b2;
                        if (Arrays.equals(this.e, schemeData.e)) {
                            b3 = true;
                        }
                    }
                }
            }
            return b3;
        }
        
        @Override
        public int hashCode() {
            if (this.a == 0) {
                final int hashCode = this.b.hashCode();
                final String c = this.c;
                int hashCode2;
                if (c == null) {
                    hashCode2 = 0;
                }
                else {
                    hashCode2 = c.hashCode();
                }
                this.a = ((hashCode * 31 + hashCode2) * 31 + this.d.hashCode()) * 31 + Arrays.hashCode(this.e);
            }
            return this.a;
        }
        
        public void writeToParcel(final Parcel parcel, final int n) {
            parcel.writeLong(this.b.getMostSignificantBits());
            parcel.writeLong(this.b.getLeastSignificantBits());
            parcel.writeString(this.c);
            parcel.writeString(this.d);
            parcel.writeByteArray(this.e);
        }
    }
}
