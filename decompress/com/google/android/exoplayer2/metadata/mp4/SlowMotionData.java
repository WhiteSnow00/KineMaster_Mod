// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.metadata.mp4;

import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;
import u3.a;
import java.util.Comparator;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.Assertions;
import java.util.ArrayList;
import android.os.Parcel;
import java.util.List;
import android.os.Parcelable$Creator;
import com.google.android.exoplayer2.metadata.Metadata;

public final class SlowMotionData implements Entry
{
    public static final Parcelable$Creator<SlowMotionData> CREATOR;
    public final List<Segment> a;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<SlowMotionData>() {
            public SlowMotionData a(final Parcel parcel) {
                final ArrayList list = new ArrayList();
                parcel.readList((List)list, Segment.class.getClassLoader());
                return new SlowMotionData(list);
            }
            
            public SlowMotionData[] b(final int n) {
                return new SlowMotionData[n];
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.a(parcel);
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.b(n);
            }
        };
    }
    
    public SlowMotionData(final List<Segment> a) {
        this.a = a;
        Assertions.a(a(a) ^ true);
    }
    
    private static boolean a(final List<Segment> list) {
        if (list.isEmpty()) {
            return false;
        }
        long n = list.get(0).b;
        for (int i = 1; i < list.size(); ++i) {
            if (((Segment)list.get(i)).a < n) {
                return true;
            }
            n = ((Segment)list.get(i)).b;
        }
        return false;
    }
    
    public int describeContents() {
        return 0;
    }
    
    @Override
    public boolean equals(final Object o) {
        return this == o || (o != null && SlowMotionData.class == o.getClass() && this.a.equals(((SlowMotionData)o).a));
    }
    
    @Override
    public int hashCode() {
        return this.a.hashCode();
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("SlowMotion: segments=");
        sb.append(this.a);
        return sb.toString();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeList((List)this.a);
    }
    
    public static final class Segment implements Parcelable
    {
        public static final Parcelable$Creator<Segment> CREATOR;
        public static final Comparator<Segment> d;
        public final long a;
        public final long b;
        public final int c;
        
        static {
            d = (Comparator)a.a;
            CREATOR = (Parcelable$Creator)new Parcelable$Creator<Segment>() {
                public Segment a(final Parcel parcel) {
                    return new Segment(parcel.readLong(), parcel.readLong(), parcel.readInt());
                }
                
                public Segment[] b(final int n) {
                    return new Segment[n];
                }
                
                public /* bridge */ Object createFromParcel(final Parcel parcel) {
                    return this.a(parcel);
                }
                
                public /* bridge */ Object[] newArray(final int n) {
                    return this.b(n);
                }
            };
        }
        
        public Segment(final long a, final long b, final int c) {
            Assertions.a(a < b);
            this.a = a;
            this.b = b;
            this.c = c;
        }
        
        public static int a(final Segment segment, final Segment segment2) {
            return b(segment, segment2);
        }
        
        private static int b(final Segment segment, final Segment segment2) {
            return ComparisonChain.k().e(segment.a, segment2.a).e(segment.b, segment2.b).d(segment.c, segment2.c).j();
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
            if (o != null && Segment.class == o.getClass()) {
                final Segment segment = (Segment)o;
                if (this.a != segment.a || this.b != segment.b || this.c != segment.c) {
                    b = false;
                }
                return b;
            }
            return false;
        }
        
        @Override
        public int hashCode() {
            return Objects.b(new Object[] { this.a, this.b, this.c });
        }
        
        @Override
        public String toString() {
            return Util.C("Segment: startTimeMs=%d, endTimeMs=%d, speedDivisor=%d", this.a, this.b, this.c);
        }
        
        public void writeToParcel(final Parcel parcel, final int n) {
            parcel.writeLong(this.a);
            parcel.writeLong(this.b);
            parcel.writeInt(this.c);
        }
    }
}
