// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;
import java.nio.ByteBuffer;

public abstract class ByteOutput
{
    public abstract void a(final ByteBuffer p0) throws IOException;
    
    public abstract void b(final byte[] p0, final int p1, final int p2) throws IOException;
}
