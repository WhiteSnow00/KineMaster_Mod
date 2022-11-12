// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.metadata;

import com.google.android.exoplayer2.util.Assertions;
import java.nio.ByteBuffer;

public abstract class SimpleMetadataDecoder implements MetadataDecoder
{
    @Override
    public final Metadata a(final MetadataInputBuffer metadataInputBuffer) {
        final ByteBuffer byteBuffer = Assertions.e(metadataInputBuffer.d);
        Assertions.a(byteBuffer.position() == 0 && byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0);
        Metadata b;
        if (metadataInputBuffer.m()) {
            b = null;
        }
        else {
            b = this.b(metadataInputBuffer, byteBuffer);
        }
        return b;
    }
    
    protected abstract Metadata b(final MetadataInputBuffer p0, final ByteBuffer p1);
}
