// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.metadata.emsg;

import java.util.Arrays;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.metadata.Metadata;
import java.nio.ByteBuffer;
import com.google.android.exoplayer2.metadata.MetadataInputBuffer;
import com.google.android.exoplayer2.metadata.SimpleMetadataDecoder;

public final class EventMessageDecoder extends SimpleMetadataDecoder
{
    @Override
    protected Metadata b(final MetadataInputBuffer metadataInputBuffer, final ByteBuffer byteBuffer) {
        return new Metadata(new Metadata.Entry[] { this.c(new ParsableByteArray(byteBuffer.array(), byteBuffer.limit())) });
    }
    
    public EventMessage c(final ParsableByteArray parsableByteArray) {
        return new EventMessage(Assertions.e(parsableByteArray.x()), Assertions.e(parsableByteArray.x()), parsableByteArray.w(), parsableByteArray.w(), Arrays.copyOfRange(parsableByteArray.d(), parsableByteArray.e(), parsableByteArray.f()));
    }
}
