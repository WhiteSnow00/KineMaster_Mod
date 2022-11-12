// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.chunk;

import java.util.NoSuchElementException;

public interface MediaChunkIterator
{
    public static final MediaChunkIterator a = new MediaChunkIterator() {
        @Override
        public long a() {
            throw new NoSuchElementException();
        }
        
        @Override
        public long b() {
            throw new NoSuchElementException();
        }
        
        @Override
        public boolean next() {
            return false;
        }
    };
    
    long a();
    
    long b();
    
    boolean next();
}
