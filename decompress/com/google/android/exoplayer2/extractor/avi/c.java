// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.avi;

import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.ParsableByteArray;

final class c implements a
{
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    
    private c(final int a, final int b, final int c, final int d, final int e, final int f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }
    
    public static c c(final ParsableByteArray parsableByteArray) {
        final int q = parsableByteArray.q();
        parsableByteArray.Q(12);
        final int q2 = parsableByteArray.q();
        final int q3 = parsableByteArray.q();
        final int q4 = parsableByteArray.q();
        parsableByteArray.Q(4);
        final int q5 = parsableByteArray.q();
        final int q6 = parsableByteArray.q();
        parsableByteArray.Q(8);
        return new c(q, q2, q3, q4, q5, q6);
    }
    
    public long a() {
        return Util.O0(this.e, this.c * 1000000L, this.d);
    }
    
    public int b() {
        final int a = this.a;
        if (a == 1935960438) {
            return 2;
        }
        if (a == 1935963489) {
            return 1;
        }
        if (a != 1937012852) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Found unsupported streamType fourCC: ");
            sb.append(Integer.toHexString(this.a));
            Log.i("AviStreamHeaderChunk", sb.toString());
            return -1;
        }
        return 3;
    }
    
    @Override
    public int getType() {
        return 1752331379;
    }
}
