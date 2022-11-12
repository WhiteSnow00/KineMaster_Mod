// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.metadata.scte35;

import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.Collections;
import android.os.Parcel;
import java.util.List;
import android.os.Parcelable$Creator;

public final class SpliceInsertCommand extends SpliceCommand
{
    public static final Parcelable$Creator<SpliceInsertCommand> CREATOR;
    public final long a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final long f;
    public final long g;
    public final List<ComponentSplice> h;
    public final boolean i;
    public final long j;
    public final int p;
    public final int w;
    public final int x;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<SpliceInsertCommand>() {
            public SpliceInsertCommand a(final Parcel parcel) {
                return new SpliceInsertCommand(parcel, null);
            }
            
            public SpliceInsertCommand[] b(final int n) {
                return new SpliceInsertCommand[n];
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.a(parcel);
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.b(n);
            }
        };
    }
    
    private SpliceInsertCommand(final long a, final boolean b, final boolean c, final boolean d, final boolean e, final long f, final long g, final List<ComponentSplice> list, final boolean i, final long j, final int p13, final int w, final int x) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = Collections.unmodifiableList((List<? extends ComponentSplice>)list);
        this.i = i;
        this.j = j;
        this.p = p13;
        this.w = w;
        this.x = x;
    }
    
    private SpliceInsertCommand(final Parcel parcel) {
        this.a = parcel.readLong();
        final byte byte1 = parcel.readByte();
        final boolean b = false;
        this.b = (byte1 == 1);
        this.c = (parcel.readByte() == 1);
        this.d = (parcel.readByte() == 1);
        this.e = (parcel.readByte() == 1);
        this.f = parcel.readLong();
        this.g = parcel.readLong();
        final int int1 = parcel.readInt();
        final ArrayList list = new ArrayList(int1);
        for (int i = 0; i < int1; ++i) {
            list.add((Object)ComponentSplice.a(parcel));
        }
        this.h = Collections.unmodifiableList((List<? extends ComponentSplice>)list);
        boolean j = b;
        if (parcel.readByte() == 1) {
            j = true;
        }
        this.i = j;
        this.j = parcel.readLong();
        this.p = parcel.readInt();
        this.w = parcel.readInt();
        this.x = parcel.readInt();
    }
    
    SpliceInsertCommand(final Parcel parcel, final SpliceInsertCommand$a parcelable$Creator) {
        this(parcel);
    }
    
    static SpliceInsertCommand a(final ParsableByteArray parsableByteArray, long n, final TimestampAdjuster timestampAdjuster) {
        final long f = parsableByteArray.F();
        final boolean b = (parsableByteArray.D() & 0x80) != 0x0;
        List<Object> emptyList = Collections.emptyList();
        boolean b3;
        long b6;
        boolean b8;
        int d4;
        List<Object> list;
        boolean b10;
        boolean b11;
        int n2;
        int n3;
        if (!b) {
            final int d = parsableByteArray.D();
            final boolean b2 = (d & 0x80) != 0x0;
            b3 = ((d & 0x40) != 0x0);
            final boolean b4 = (d & 0x20) != 0x0;
            final boolean b5 = (d & 0x10) != 0x0;
            if (b3 && !b5) {
                b6 = TimeSignalCommand.b(parsableByteArray, n);
            }
            else {
                b6 = -9223372036854775807L;
            }
            if (!b3) {
                final int d2 = parsableByteArray.D();
                emptyList = new ArrayList<Object>(d2);
                for (int i = 0; i < d2; ++i) {
                    final int d3 = parsableByteArray.D();
                    long b7;
                    if (!b5) {
                        b7 = TimeSignalCommand.b(parsableByteArray, n);
                    }
                    else {
                        b7 = -9223372036854775807L;
                    }
                    emptyList.add(new ComponentSplice(d3, b7, timestampAdjuster.b(b7), null));
                }
            }
            if (b4) {
                n = parsableByteArray.D();
                b8 = ((0x80L & n) != 0x0L);
                n = ((n & 0x1L) << 32 | parsableByteArray.F()) * 1000L / 90L;
            }
            else {
                b8 = false;
                n = -9223372036854775807L;
            }
            final int j = parsableByteArray.J();
            d4 = parsableByteArray.D();
            final int d5 = parsableByteArray.D();
            list = emptyList;
            final boolean b9 = b5;
            b10 = b2;
            b11 = b9;
            n2 = j;
            n3 = d5;
        }
        else {
            list = emptyList;
            b10 = false;
            b11 = false;
            b6 = -9223372036854775807L;
            b8 = false;
            n = -9223372036854775807L;
            n2 = 0;
            d4 = 0;
            n3 = 0;
            b3 = false;
        }
        return new SpliceInsertCommand(f, b, b10, b3, b11, b6, timestampAdjuster.b(b6), (List<ComponentSplice>)list, b8, n, n2, d4, n3);
    }
    
    public void writeToParcel(final Parcel parcel, int i) {
        parcel.writeLong(this.a);
        parcel.writeByte((byte)(byte)(this.b ? 1 : 0));
        parcel.writeByte((byte)(byte)(this.c ? 1 : 0));
        parcel.writeByte((byte)(byte)(this.d ? 1 : 0));
        parcel.writeByte((byte)(byte)(this.e ? 1 : 0));
        parcel.writeLong(this.f);
        parcel.writeLong(this.g);
        final int size = this.h.size();
        parcel.writeInt(size);
        for (i = 0; i < size; ++i) {
            this.h.get(i).b(parcel);
        }
        parcel.writeByte((byte)(byte)(this.i ? 1 : 0));
        parcel.writeLong(this.j);
        parcel.writeInt(this.p);
        parcel.writeInt(this.w);
        parcel.writeInt(this.x);
    }
    
    public static final class ComponentSplice
    {
        public final int a;
        public final long b;
        public final long c;
        
        private ComponentSplice(final int a, final long b, final long c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        
        ComponentSplice(final int n, final long n2, final long n3, final SpliceInsertCommand$a parcelable$Creator) {
            this(n, n2, n3);
        }
        
        public static ComponentSplice a(final Parcel parcel) {
            return new ComponentSplice(parcel.readInt(), parcel.readLong(), parcel.readLong());
        }
        
        public void b(final Parcel parcel) {
            parcel.writeInt(this.a);
            parcel.writeLong(this.b);
            parcel.writeLong(this.c);
        }
    }
}
