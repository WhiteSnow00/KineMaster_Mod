// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.nio.ByteBuffer;
import java.util.UUID;

public final class PsshAtomUtil
{
    private PsshAtomUtil() {
    }
    
    public static byte[] a(final UUID uuid, final byte[] array) {
        return b(uuid, null, array);
    }
    
    public static byte[] b(UUID uuid, final UUID[] array, final byte[] array2) {
        final int n = 0;
        int length;
        if (array2 != null) {
            length = array2.length;
        }
        else {
            length = 0;
        }
        int n3;
        final int n2 = n3 = length + 32;
        if (array != null) {
            n3 = n2 + (array.length * 16 + 4);
        }
        final ByteBuffer allocate = ByteBuffer.allocate(n3);
        allocate.putInt(n3);
        allocate.putInt(1886614376);
        int n4;
        if (array != null) {
            n4 = 16777216;
        }
        else {
            n4 = 0;
        }
        allocate.putInt(n4);
        allocate.putLong(uuid.getMostSignificantBits());
        allocate.putLong(uuid.getLeastSignificantBits());
        if (array != null) {
            allocate.putInt(array.length);
            for (int length2 = array.length, i = n; i < length2; ++i) {
                uuid = array[i];
                allocate.putLong(uuid.getMostSignificantBits());
                allocate.putLong(uuid.getLeastSignificantBits());
            }
        }
        if (array2 != null && array2.length != 0) {
            allocate.putInt(array2.length);
            allocate.put(array2);
        }
        return allocate.array();
    }
    
    public static boolean c(final byte[] array) {
        return d(array) != null;
    }
    
    private static a d(byte[] array) {
        final ParsableByteArray parsableByteArray = new ParsableByteArray(array);
        if (parsableByteArray.f() < 32) {
            return null;
        }
        parsableByteArray.P(0);
        if (parsableByteArray.n() != parsableByteArray.a() + 4) {
            return null;
        }
        if (parsableByteArray.n() != 1886614376) {
            return null;
        }
        final int c = com.google.android.exoplayer2.extractor.mp4.a.c(parsableByteArray.n());
        if (c > 1) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Unsupported pssh version: ");
            sb.append(c);
            Log.i("PsshAtomUtil", sb.toString());
            return null;
        }
        final UUID uuid = new UUID(parsableByteArray.w(), parsableByteArray.w());
        if (c == 1) {
            parsableByteArray.Q(parsableByteArray.H() * 16);
        }
        final int h = parsableByteArray.H();
        if (h != parsableByteArray.a()) {
            return null;
        }
        array = new byte[h];
        parsableByteArray.j(array, 0, h);
        return new a(uuid, c, array);
    }
    
    public static byte[] e(final byte[] array, final UUID uuid) {
        final a d = d(array);
        if (d == null) {
            return null;
        }
        if (!uuid.equals(a.a(d))) {
            final StringBuilder sb = new StringBuilder();
            sb.append("UUID mismatch. Expected: ");
            sb.append(uuid);
            sb.append(", got: ");
            sb.append(a.a(d));
            sb.append(".");
            Log.i("PsshAtomUtil", sb.toString());
            return null;
        }
        return a.c(d);
    }
    
    public static UUID f(final byte[] array) {
        final a d = d(array);
        if (d == null) {
            return null;
        }
        return a.a(d);
    }
    
    public static int g(final byte[] array) {
        final a d = d(array);
        if (d == null) {
            return -1;
        }
        return a.b(d);
    }
    
    private static class a
    {
        private final UUID a;
        private final int b;
        private final byte[] c;
        
        public a(final UUID a, final int b, final byte[] c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        
        static UUID a(final a a) {
            return a.a;
        }
        
        static int b(final a a) {
            return a.b;
        }
        
        static byte[] c(final a a) {
            return a.c;
        }
    }
}
