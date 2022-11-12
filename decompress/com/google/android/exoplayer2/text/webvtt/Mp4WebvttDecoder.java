// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.text.webvtt;

import java.util.List;
import java.util.ArrayList;
import com.google.android.exoplayer2.text.Subtitle;
import java.util.Collections;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;

public final class Mp4WebvttDecoder extends SimpleSubtitleDecoder
{
    private final ParsableByteArray o;
    
    public Mp4WebvttDecoder() {
        super("Mp4WebvttDecoder");
        this.o = new ParsableByteArray();
    }
    
    private static Cue B(final ParsableByteArray parsableByteArray, int i) throws SubtitleDecoderException {
        Object q = null;
        Object o = null;
        while (i > 0) {
            if (i < 8) {
                throw new SubtitleDecoderException("Incomplete vtt cue box header found.");
            }
            int n = parsableByteArray.n();
            final int n2 = parsableByteArray.n();
            n -= 8;
            final String e = Util.E(parsableByteArray.d(), parsableByteArray.e(), n);
            parsableByteArray.Q(n);
            final int n3 = i - 8 - n;
            if (n2 == 1937011815) {
                o = WebvttCueParser.o(e);
                i = n3;
            }
            else {
                i = n3;
                if (n2 != 1885436268) {
                    continue;
                }
                q = WebvttCueParser.q(null, e.trim(), Collections.emptyList());
                i = n3;
            }
        }
        CharSequence charSequence;
        if ((charSequence = (CharSequence)q) == null) {
            charSequence = "";
        }
        Cue cue;
        if (o != null) {
            cue = ((Cue.Builder)o).o(charSequence).a();
        }
        else {
            cue = WebvttCueParser.l(charSequence);
        }
        return cue;
    }
    
    @Override
    protected Subtitle z(final byte[] array, int n, final boolean b) throws SubtitleDecoderException {
        this.o.N(array, n);
        final ArrayList list = new ArrayList();
        while (this.o.a() > 0) {
            if (this.o.a() < 8) {
                throw new SubtitleDecoderException("Incomplete Mp4Webvtt Top Level box header found.");
            }
            n = this.o.n();
            if (this.o.n() == 1987343459) {
                list.add(B(this.o, n - 8));
            }
            else {
                this.o.Q(n - 8);
            }
        }
        return new a(list);
    }
}
