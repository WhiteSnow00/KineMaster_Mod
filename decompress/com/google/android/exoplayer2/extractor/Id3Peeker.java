// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor;

import java.io.IOException;
import java.io.EOFException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder;
import com.google.android.exoplayer2.util.ParsableByteArray;

public final class Id3Peeker
{
    private final ParsableByteArray a;
    
    public Id3Peeker() {
        this.a = new ParsableByteArray(10);
    }
    
    public Metadata a(final ExtractorInput extractorInput, final Id3Decoder.FramePredicate framePredicate) throws IOException {
        Object e = null;
        int n = 0;
        while (true) {
            try {
                while (true) {
                    extractorInput.r(this.a.d(), 0, 10);
                    this.a.P(0);
                    if (this.a.G() != 4801587) {
                        break;
                    }
                    this.a.Q(3);
                    final int c = this.a.C();
                    final int n2 = c + 10;
                    if (e == null) {
                        e = new byte[n2];
                        System.arraycopy(this.a.d(), 0, e, 0, 10);
                        extractorInput.r((byte[])e, 10, c);
                        e = new Id3Decoder(framePredicate).e((byte[])e, n2);
                    }
                    else {
                        extractorInput.m(c);
                    }
                    n += n2;
                }
                extractorInput.h();
                extractorInput.m(n);
                return (Metadata)e;
            }
            catch (final EOFException ex) {
                continue;
            }
            break;
        }
    }
}
