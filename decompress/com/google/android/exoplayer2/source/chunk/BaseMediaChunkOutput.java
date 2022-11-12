// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.SampleQueue;

public final class BaseMediaChunkOutput implements TrackOutputProvider
{
    private final int[] a;
    private final SampleQueue[] b;
    
    public BaseMediaChunkOutput(final int[] a, final SampleQueue[] b) {
        this.a = a;
        this.b = b;
    }
    
    public int[] a() {
        final int[] array = new int[this.b.length];
        int n = 0;
        while (true) {
            final SampleQueue[] b = this.b;
            if (n >= b.length) {
                break;
            }
            array[n] = b[n].G();
            ++n;
        }
        return array;
    }
    
    public void b(final long n) {
        final SampleQueue[] b = this.b;
        for (int length = b.length, i = 0; i < length; ++i) {
            b[i].a0(n);
        }
    }
    
    @Override
    public TrackOutput e(int n, final int n2) {
        n = 0;
        while (true) {
            final int[] a = this.a;
            if (n >= a.length) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Unmatched track of type: ");
                sb.append(n2);
                Log.c("BaseMediaChunkOutput", sb.toString());
                return new DummyTrackOutput();
            }
            if (n2 == a[n]) {
                return this.b[n];
            }
            ++n;
        }
    }
}
