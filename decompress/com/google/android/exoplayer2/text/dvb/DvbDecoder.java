// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.text.dvb;

import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.List;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;

public final class DvbDecoder extends SimpleSubtitleDecoder
{
    private final a o;
    
    public DvbDecoder(final List<byte[]> list) {
        super("DvbDecoder");
        final ParsableByteArray parsableByteArray = new ParsableByteArray(list.get(0));
        this.o = new a(parsableByteArray.J(), parsableByteArray.J());
    }
    
    @Override
    protected Subtitle z(final byte[] array, final int n, final boolean b) {
        if (b) {
            this.o.r();
        }
        return new b(this.o.b(array, n));
    }
}
