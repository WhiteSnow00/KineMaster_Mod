// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.text.cea;

import com.google.android.exoplayer2.text.SubtitleOutputBuffer;
import com.google.android.exoplayer2.decoder.DecoderOutputBuffer;

public final class b implements Owner
{
    public final c a;
    
    public b(final c a) {
        this.a = a;
    }
    
    @Override
    public final void a(final DecoderOutputBuffer decoderOutputBuffer) {
        this.a.n((SubtitleOutputBuffer)decoderOutputBuffer);
    }
}
