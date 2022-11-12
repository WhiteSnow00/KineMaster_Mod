// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.text.webvtt;

import com.google.android.exoplayer2.ParserException;
import java.util.Collection;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.util.List;
import java.util.ArrayList;
import com.google.android.exoplayer2.text.Subtitle;
import android.text.TextUtils;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;

public final class WebvttDecoder extends SimpleSubtitleDecoder
{
    private final ParsableByteArray o;
    private final b p;
    
    public WebvttDecoder() {
        super("WebvttDecoder");
        this.o = new ParsableByteArray();
        this.p = new b();
    }
    
    private static int B(final ParsableByteArray parsableByteArray) {
        int e = 0;
        int i = -1;
        while (i == -1) {
            e = parsableByteArray.e();
            final String p = parsableByteArray.p();
            if (p == null) {
                i = 0;
            }
            else if ("STYLE".equals(p)) {
                i = 2;
            }
            else if (p.startsWith("NOTE")) {
                i = 1;
            }
            else {
                i = 3;
            }
        }
        parsableByteArray.P(e);
        return i;
    }
    
    private static void C(final ParsableByteArray parsableByteArray) {
        while (!TextUtils.isEmpty((CharSequence)parsableByteArray.p())) {}
    }
    
    @Override
    protected Subtitle z(final byte[] array, int b, final boolean b2) throws SubtitleDecoderException {
        this.o.N(array, b);
        final ArrayList list = new ArrayList();
        try {
            WebvttParserUtil.e(this.o);
            while (!TextUtils.isEmpty((CharSequence)this.o.p())) {}
            final ArrayList list2 = new ArrayList();
            while (true) {
                b = B(this.o);
                if (b == 0) {
                    return new e(list2);
                }
                if (b == 1) {
                    C(this.o);
                }
                else if (b == 2) {
                    if (!list2.isEmpty()) {
                        throw new SubtitleDecoderException("A style block was found after the first cue.");
                    }
                    this.o.p();
                    list.addAll(this.p.d(this.o));
                }
                else {
                    if (b != 3) {
                        continue;
                    }
                    final WebvttCueInfo m = WebvttCueParser.m(this.o, list);
                    if (m == null) {
                        continue;
                    }
                    list2.add(m);
                }
            }
        }
        catch (final ParserException ex) {
            throw new SubtitleDecoderException(ex);
        }
    }
}
