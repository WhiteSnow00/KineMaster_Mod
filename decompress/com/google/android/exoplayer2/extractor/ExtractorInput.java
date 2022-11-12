// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor;

import java.io.IOException;
import com.google.android.exoplayer2.upstream.DataReader;

public interface ExtractorInput extends DataReader
{
    int a(final int p0) throws IOException;
    
    boolean f(final byte[] p0, final int p1, final int p2, final boolean p3) throws IOException;
    
    long getLength();
    
    long getPosition();
    
    void h();
    
    boolean i(final byte[] p0, final int p1, final int p2, final boolean p3) throws IOException;
    
    long k();
    
    void m(final int p0) throws IOException;
    
    int n(final byte[] p0, final int p1, final int p2) throws IOException;
    
    void o(final int p0) throws IOException;
    
    boolean p(final int p0, final boolean p1) throws IOException;
    
    void r(final byte[] p0, final int p1, final int p2) throws IOException;
    
    int read(final byte[] p0, final int p1, final int p2) throws IOException;
    
    void readFully(final byte[] p0, final int p1, final int p2) throws IOException;
}
