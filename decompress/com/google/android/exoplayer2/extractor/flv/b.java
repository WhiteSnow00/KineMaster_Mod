// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.flv;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.DummyTrackOutput;

final class b extends TagPayloadReader
{
    private long b;
    private long[] c;
    private long[] d;
    
    public b() {
        super(new DummyTrackOutput());
        this.b = -9223372036854775807L;
        this.c = new long[0];
        this.d = new long[0];
    }
    
    private static Boolean g(final ParsableByteArray parsableByteArray) {
        final int d = parsableByteArray.D();
        boolean b = true;
        if (d != 1) {
            b = false;
        }
        return b;
    }
    
    private static Object h(final ParsableByteArray parsableByteArray, final int n) {
        if (n == 0) {
            return j(parsableByteArray);
        }
        if (n == 1) {
            return g(parsableByteArray);
        }
        if (n == 2) {
            return n(parsableByteArray);
        }
        if (n == 3) {
            return l(parsableByteArray);
        }
        if (n == 8) {
            return k(parsableByteArray);
        }
        if (n == 10) {
            return m(parsableByteArray);
        }
        if (n != 11) {
            return null;
        }
        return i(parsableByteArray);
    }
    
    private static Date i(final ParsableByteArray parsableByteArray) {
        final Date date = new Date((long)(double)j(parsableByteArray));
        parsableByteArray.Q(2);
        return date;
    }
    
    private static Double j(final ParsableByteArray parsableByteArray) {
        return Double.longBitsToDouble(parsableByteArray.w());
    }
    
    private static HashMap<String, Object> k(final ParsableByteArray parsableByteArray) {
        final int h = parsableByteArray.H();
        final HashMap hashMap = new HashMap<String, Object>(h);
        for (int i = 0; i < h; ++i) {
            final String n = n(parsableByteArray);
            final Object h2 = h(parsableByteArray, o(parsableByteArray));
            if (h2 != null) {
                hashMap.put(n, h2);
            }
        }
        return (HashMap<String, Object>)hashMap;
    }
    
    private static HashMap<String, Object> l(final ParsableByteArray parsableByteArray) {
        final HashMap hashMap = new HashMap();
        while (true) {
            final String n = n(parsableByteArray);
            final int o = o(parsableByteArray);
            if (o == 9) {
                break;
            }
            final Object h = h(parsableByteArray, o);
            if (h == null) {
                continue;
            }
            hashMap.put(n, h);
        }
        return hashMap;
    }
    
    private static ArrayList<Object> m(final ParsableByteArray parsableByteArray) {
        final int h = parsableByteArray.H();
        final ArrayList list = new ArrayList<Object>(h);
        for (int i = 0; i < h; ++i) {
            final Object h2 = h(parsableByteArray, o(parsableByteArray));
            if (h2 != null) {
                list.add(h2);
            }
        }
        return (ArrayList<Object>)list;
    }
    
    private static String n(final ParsableByteArray parsableByteArray) {
        final int j = parsableByteArray.J();
        final int e = parsableByteArray.e();
        parsableByteArray.Q(j);
        return new String(parsableByteArray.d(), e, j);
    }
    
    private static int o(final ParsableByteArray parsableByteArray) {
        return parsableByteArray.D();
    }
    
    @Override
    protected boolean b(final ParsableByteArray parsableByteArray) {
        return true;
    }
    
    @Override
    protected boolean c(final ParsableByteArray parsableByteArray, final long n) {
        if (o(parsableByteArray) != 2) {
            return false;
        }
        if (!"onMetaData".equals(n(parsableByteArray))) {
            return false;
        }
        if (parsableByteArray.a() == 0) {
            return false;
        }
        if (o(parsableByteArray) != 8) {
            return false;
        }
        final HashMap<String, Object> k = k(parsableByteArray);
        final Object value = k.get("duration");
        if (value instanceof Double) {
            final double doubleValue = (double)value;
            if (doubleValue > 0.0) {
                this.b = (long)(doubleValue * 1000000.0);
            }
        }
        final Object value2 = k.get("keyframes");
        if (value2 instanceof Map) {
            final Map map = (Map)value2;
            final Object value3 = map.get("filepositions");
            final Object value4 = map.get("times");
            if (value3 instanceof List && value4 instanceof List) {
                final List list = (List)value3;
                final List list2 = (List)value4;
                final int size = list2.size();
                this.c = new long[size];
                this.d = new long[size];
                for (int i = 0; i < size; ++i) {
                    final Object value5 = list.get(i);
                    final Object value6 = list2.get(i);
                    if (!(value6 instanceof Double) || !(value5 instanceof Double)) {
                        this.c = new long[0];
                        this.d = new long[0];
                        break;
                    }
                    this.c[i] = (long)((double)value6 * 1000000.0);
                    this.d[i] = ((Double)value5).longValue();
                }
            }
        }
        return false;
    }
    
    public long d() {
        return this.b;
    }
    
    public long[] e() {
        return this.d;
    }
    
    public long[] f() {
        return this.c;
    }
}
