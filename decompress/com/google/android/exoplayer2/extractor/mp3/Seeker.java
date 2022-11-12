// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.mp3;

import com.google.android.exoplayer2.extractor.SeekMap;

interface Seeker extends SeekMap
{
    long c(final long p0);
    
    long g();
    
    public static class UnseekableSeeker extends Unseekable implements Seeker
    {
        public UnseekableSeeker() {
            super(-9223372036854775807L);
        }
        
        @Override
        public long c(final long n) {
            return 0L;
        }
        
        @Override
        public long g() {
            return -1L;
        }
    }
}
