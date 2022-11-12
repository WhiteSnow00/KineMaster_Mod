// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.audio;

import java.nio.ByteOrder;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class OpusUtil
{
    private OpusUtil() {
    }
    
    public static List<byte[]> a(final byte[] array) {
        final long e = e(d(array));
        final long e2 = e(3840L);
        final ArrayList list = new ArrayList(3);
        list.add(array);
        list.add(b(e));
        list.add(b(e2));
        return list;
    }
    
    private static byte[] b(final long n) {
        return ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(n).array();
    }
    
    public static int c(final byte[] array) {
        return array[9] & 0xFF;
    }
    
    private static int d(final byte[] array) {
        return (array[10] & 0xFF) | (array[11] & 0xFF) << 8;
    }
    
    private static long e(final long n) {
        return n * 1000000000L / 48000L;
    }
}
