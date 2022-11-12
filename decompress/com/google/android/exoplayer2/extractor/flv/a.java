// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.ParserException;
import java.util.Collections;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.extractor.TrackOutput;

final class a extends TagPayloadReader
{
    private static final int[] e;
    private boolean b;
    private boolean c;
    private int d;
    
    static {
        e = new int[] { 5512, 11025, 22050, 44100 };
    }
    
    public a(final TrackOutput trackOutput) {
        super(trackOutput);
    }
    
    @Override
    protected boolean b(final ParsableByteArray parsableByteArray) throws UnsupportedFormatException {
        if (!this.b) {
            final int d = parsableByteArray.D();
            final int d2 = d >> 4 & 0xF;
            if ((this.d = d2) == 2) {
                super.a.d(new Format.Builder().e0("audio/mpeg").H(1).f0(a.e[d >> 2 & 0x3]).E());
                this.c = true;
            }
            else if (d2 != 7 && d2 != 8) {
                if (d2 != 10) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Audio format not supported: ");
                    sb.append(this.d);
                    throw new UnsupportedFormatException(sb.toString());
                }
            }
            else {
                String s;
                if (d2 == 7) {
                    s = "audio/g711-alaw";
                }
                else {
                    s = "audio/g711-mlaw";
                }
                super.a.d(new Format.Builder().e0(s).H(1).f0(8000).E());
                this.c = true;
            }
            this.b = true;
        }
        else {
            parsableByteArray.Q(1);
        }
        return true;
    }
    
    @Override
    protected boolean c(final ParsableByteArray parsableByteArray, final long n) throws ParserException {
        if (this.d == 2) {
            final int a = parsableByteArray.a();
            super.a.c(parsableByteArray, a);
            super.a.e(n, 1, a, 0, null);
            return true;
        }
        final int d = parsableByteArray.D();
        if (d == 0 && !this.c) {
            final int a2 = parsableByteArray.a();
            final byte[] array = new byte[a2];
            parsableByteArray.j(array, 0, a2);
            final AacUtil.Config f = AacUtil.f(array);
            super.a.d(new Format.Builder().e0("audio/mp4a-latm").I(f.c).H(f.b).f0(f.a).T(Collections.singletonList(array)).E());
            this.c = true;
            return false;
        }
        if (this.d == 10 && d != 1) {
            return false;
        }
        final int a3 = parsableByteArray.a();
        super.a.c(parsableByteArray, a3);
        super.a.e(n, 1, a3, 0, null);
        return true;
    }
}
