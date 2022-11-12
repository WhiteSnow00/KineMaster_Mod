// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.avi;

import com.google.android.exoplayer2.util.ParsableByteArray;

final class b implements a
{
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    
    private b(final int a, final int b, final int c, final int d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public static b b(final ParsableByteArray parsableByteArray) {
        final int q = parsableByteArray.q();
        parsableByteArray.Q(8);
        final int q2 = parsableByteArray.q();
        final int q3 = parsableByteArray.q();
        parsableByteArray.Q(4);
        final int q4 = parsableByteArray.q();
        parsableByteArray.Q(12);
        return new b(q, q2, q3, q4);
    }
    
    public boolean a() {
        return (this.b & 0x10) == 0x10;
    }
    
    @Override
    public int getType() {
        return 1751742049;
    }
}
