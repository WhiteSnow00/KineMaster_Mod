// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.metadata.scte35;

import com.google.android.exoplayer2.metadata.Metadata;
import java.nio.ByteBuffer;
import com.google.android.exoplayer2.metadata.MetadataInputBuffer;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.metadata.SimpleMetadataDecoder;

public final class SpliceInfoDecoder extends SimpleMetadataDecoder
{
    private final ParsableByteArray a;
    private final ParsableBitArray b;
    private TimestampAdjuster c;
    
    public SpliceInfoDecoder() {
        this.a = new ParsableByteArray();
        this.b = new ParsableBitArray();
    }
    
    @Override
    protected Metadata b(final MetadataInputBuffer metadataInputBuffer, final ByteBuffer byteBuffer) {
        final TimestampAdjuster c = this.c;
        if (c == null || metadataInputBuffer.j != c.e()) {
            (this.c = new TimestampAdjuster(metadataInputBuffer.f)).a(metadataInputBuffer.f - metadataInputBuffer.j);
        }
        final byte[] array = byteBuffer.array();
        final int limit = byteBuffer.limit();
        this.a.N(array, limit);
        this.b.o(array, limit);
        this.b.r(39);
        final long n = (long)this.b.h(1) << 32 | (long)this.b.h(32);
        this.b.r(20);
        final int h = this.b.h(12);
        final int h2 = this.b.h(8);
        Metadata.Entry entry = null;
        this.a.Q(14);
        if (h2 != 0) {
            if (h2 != 255) {
                if (h2 != 4) {
                    if (h2 != 5) {
                        if (h2 == 6) {
                            entry = TimeSignalCommand.a(this.a, n, this.c);
                        }
                    }
                    else {
                        entry = SpliceInsertCommand.a(this.a, n, this.c);
                    }
                }
                else {
                    entry = SpliceScheduleCommand.a(this.a);
                }
            }
            else {
                entry = PrivateCommand.a(this.a, h, n);
            }
        }
        else {
            entry = new SpliceNullCommand();
        }
        Metadata metadata;
        if (entry == null) {
            metadata = new Metadata(new Metadata.Entry[0]);
        }
        else {
            metadata = new Metadata(new Metadata.Entry[] { entry });
        }
        return metadata;
    }
}
