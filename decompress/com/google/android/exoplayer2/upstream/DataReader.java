// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.upstream;

import java.io.IOException;

public interface DataReader
{
    int read(final byte[] p0, final int p1, final int p2) throws IOException;
}
