// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.metadata.scte35;

import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Collections;
import java.util.ArrayList;
import android.os.Parcel;
import java.util.List;
import android.os.Parcelable$Creator;

public final class SpliceScheduleCommand extends SpliceCommand
{
    public static final Parcelable$Creator<SpliceScheduleCommand> CREATOR;
    public final List<Event> a;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<SpliceScheduleCommand>() {
            public SpliceScheduleCommand a(final Parcel parcel) {
                return new SpliceScheduleCommand(parcel, null);
            }
            
            public SpliceScheduleCommand[] b(final int n) {
                return new SpliceScheduleCommand[n];
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.a(parcel);
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.b(n);
            }
        };
    }
    
    private SpliceScheduleCommand(final Parcel parcel) {
        final int int1 = parcel.readInt();
        final ArrayList list = new ArrayList<Event>(int1);
        for (int i = 0; i < int1; ++i) {
            list.add(Event.a(parcel));
        }
        this.a = Collections.unmodifiableList((List<? extends Event>)list);
    }
    
    SpliceScheduleCommand(final Parcel parcel, final SpliceScheduleCommand$a parcelable$Creator) {
        this(parcel);
    }
    
    private SpliceScheduleCommand(final List<Event> list) {
        this.a = Collections.unmodifiableList((List<? extends Event>)list);
    }
    
    static SpliceScheduleCommand a(final ParsableByteArray parsableByteArray) {
        final int d = parsableByteArray.D();
        final ArrayList list = new ArrayList<Event>(d);
        for (int i = 0; i < d; ++i) {
            list.add(Event.b(parsableByteArray));
        }
        return new SpliceScheduleCommand((List<Event>)list);
    }
    
    public void writeToParcel(final Parcel parcel, int i) {
        final int size = this.a.size();
        parcel.writeInt(size);
        for (i = 0; i < size; ++i) {
            Event.c(this.a.get(i), parcel);
        }
    }
    
    public static final class ComponentSplice
    {
        public final int a;
        public final long b;
        
        private ComponentSplice(final int a, final long b) {
            this.a = a;
            this.b = b;
        }
        
        ComponentSplice(final int n, final long n2, final SpliceScheduleCommand$a parcelable$Creator) {
            this(n, n2);
        }
        
        static ComponentSplice a(final Parcel parcel) {
            return c(parcel);
        }
        
        static void b(final ComponentSplice componentSplice, final Parcel parcel) {
            componentSplice.d(parcel);
        }
        
        private static ComponentSplice c(final Parcel parcel) {
            return new ComponentSplice(parcel.readInt(), parcel.readLong());
        }
        
        private void d(final Parcel parcel) {
            parcel.writeInt(this.a);
            parcel.writeLong(this.b);
        }
    }
    
    public static final class Event
    {
        public final long a;
        public final boolean b;
        public final boolean c;
        public final boolean d;
        public final long e;
        public final List<ComponentSplice> f;
        public final boolean g;
        public final long h;
        public final int i;
        public final int j;
        public final int k;
        
        private Event(final long a, final boolean b, final boolean c, final boolean d, final List<ComponentSplice> list, final long e, final boolean g, final long h, final int i, final int j, final int k) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.f = Collections.unmodifiableList((List<? extends ComponentSplice>)list);
            this.e = e;
            this.g = g;
            this.h = h;
            this.i = i;
            this.j = j;
            this.k = k;
        }
        
        private Event(final Parcel parcel) {
            this.a = parcel.readLong();
            final byte byte1 = parcel.readByte();
            final boolean b = false;
            this.b = (byte1 == 1);
            this.c = (parcel.readByte() == 1);
            this.d = (parcel.readByte() == 1);
            final int int1 = parcel.readInt();
            final ArrayList list = new ArrayList<ComponentSplice>(int1);
            for (int i = 0; i < int1; ++i) {
                list.add(ComponentSplice.a(parcel));
            }
            this.f = Collections.unmodifiableList((List<? extends ComponentSplice>)list);
            this.e = parcel.readLong();
            boolean g = b;
            if (parcel.readByte() == 1) {
                g = true;
            }
            this.g = g;
            this.h = parcel.readLong();
            this.i = parcel.readInt();
            this.j = parcel.readInt();
            this.k = parcel.readInt();
        }
        
        static Event a(final Parcel parcel) {
            return d(parcel);
        }
        
        static Event b(final ParsableByteArray parsableByteArray) {
            return e(parsableByteArray);
        }
        
        static void c(final Event event, final Parcel parcel) {
            event.f(parcel);
        }
        
        private static Event d(final Parcel parcel) {
            return new Event(parcel);
        }
        
        private static Event e(final ParsableByteArray parsableByteArray) {
            final long f = parsableByteArray.F();
            final boolean b = (parsableByteArray.D() & 0x80) != 0x0;
            ArrayList<ComponentSplice> list = new ArrayList<ComponentSplice>();
            boolean b2;
            boolean b3;
            long f2;
            boolean b5;
            long n2;
            int j;
            int d3;
            int d4;
            if (!b) {
                final int d = parsableByteArray.D();
                b2 = ((d & 0x80) != 0x0);
                b3 = ((d & 0x40) != 0x0);
                final boolean b4 = (d & 0x20) != 0x0;
                if (b3) {
                    f2 = parsableByteArray.F();
                }
                else {
                    f2 = -9223372036854775807L;
                }
                if (!b3) {
                    final int d2 = parsableByteArray.D();
                    list = new ArrayList<ComponentSplice>(d2);
                    for (int i = 0; i < d2; ++i) {
                        list.add(new ComponentSplice(parsableByteArray.D(), parsableByteArray.F(), null));
                    }
                }
                if (b4) {
                    final long n = parsableByteArray.D();
                    b5 = ((0x80L & n) != 0x0L);
                    n2 = ((n & 0x1L) << 32 | parsableByteArray.F()) * 1000L / 90L;
                }
                else {
                    b5 = false;
                    n2 = -9223372036854775807L;
                }
                j = parsableByteArray.J();
                d3 = parsableByteArray.D();
                d4 = parsableByteArray.D();
            }
            else {
                b2 = false;
                f2 = -9223372036854775807L;
                b5 = false;
                n2 = -9223372036854775807L;
                j = 0;
                d3 = 0;
                d4 = 0;
                b3 = false;
            }
            return new Event(f, b, b2, b3, list, f2, b5, n2, j, d3, d4);
        }
        
        private void f(final Parcel parcel) {
            parcel.writeLong(this.a);
            parcel.writeByte((byte)(byte)(this.b ? 1 : 0));
            parcel.writeByte((byte)(byte)(this.c ? 1 : 0));
            parcel.writeByte((byte)(byte)(this.d ? 1 : 0));
            final int size = this.f.size();
            parcel.writeInt(size);
            for (int i = 0; i < size; ++i) {
                ComponentSplice.b(this.f.get(i), parcel);
            }
            parcel.writeLong(this.e);
            parcel.writeByte((byte)(byte)(this.g ? 1 : 0));
            parcel.writeLong(this.h);
            parcel.writeInt(this.i);
            parcel.writeInt(this.j);
            parcel.writeInt(this.k);
        }
    }
}
