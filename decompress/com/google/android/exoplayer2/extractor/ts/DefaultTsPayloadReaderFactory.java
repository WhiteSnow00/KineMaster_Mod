// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.ts;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import android.util.SparseArray;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import java.util.ArrayList;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.common.collect.ImmutableList;
import com.google.android.exoplayer2.Format;
import java.util.List;

public final class DefaultTsPayloadReaderFactory implements Factory
{
    private final int a;
    private final List<Format> b;
    
    public DefaultTsPayloadReaderFactory() {
        this(0);
    }
    
    public DefaultTsPayloadReaderFactory(final int n) {
        this(n, (List<Format>)ImmutableList.of());
    }
    
    public DefaultTsPayloadReaderFactory(final int a, final List<Format> b) {
        this.a = a;
        this.b = b;
    }
    
    private SeiReader c(final EsInfo esInfo) {
        return new SeiReader(this.e(esInfo));
    }
    
    private f d(final EsInfo esInfo) {
        return new f(this.e(esInfo));
    }
    
    private List<Format> e(final EsInfo esInfo) {
        if (this.f(32)) {
            return this.b;
        }
        final ParsableByteArray parsableByteArray = new ParsableByteArray(esInfo.d);
        List<Format> b = this.b;
        while (parsableByteArray.a() > 0) {
            final int d = parsableByteArray.D();
            final int d2 = parsableByteArray.D();
            final int e = parsableByteArray.e();
            if (d == 134) {
                final ArrayList list = new ArrayList();
                final int d3 = parsableByteArray.D();
                int n = 0;
                while (true) {
                    b = list;
                    if (n >= (d3 & 0x1F)) {
                        break;
                    }
                    final String a = parsableByteArray.A(3);
                    final int d4 = parsableByteArray.D();
                    boolean b2 = true;
                    final boolean b3 = (d4 & 0x80) != 0x0;
                    int n2;
                    String s;
                    if (b3) {
                        n2 = (d4 & 0x3F);
                        s = "application/cea-708";
                    }
                    else {
                        s = "application/cea-608";
                        n2 = 1;
                    }
                    final byte b4 = (byte)parsableByteArray.D();
                    parsableByteArray.Q(1);
                    List<byte[]> b5 = null;
                    if (b3) {
                        if ((b4 & 0x40) == 0x0) {
                            b2 = false;
                        }
                        b5 = CodecSpecificDataUtil.b(b2);
                    }
                    list.add(new Format.Builder().e0(s).V(a).F(n2).T(b5).E());
                    ++n;
                }
            }
            parsableByteArray.P(e + d2);
        }
        return b;
    }
    
    private boolean f(final int n) {
        return (n & this.a) != 0x0;
    }
    
    @Override
    public SparseArray<TsPayloadReader> a() {
        return (SparseArray<TsPayloadReader>)new SparseArray();
    }
    
    @Override
    public TsPayloadReader b(final int n, final EsInfo esInfo) {
        if (n != 2) {
            if (n == 3 || n == 4) {
                return new PesReader(new MpegAudioReader(esInfo.b));
            }
            if (n == 21) {
                return new PesReader(new Id3Reader());
            }
            final TsPayloadReader tsPayloadReader = null;
            final TsPayloadReader tsPayloadReader2 = null;
            final TsPayloadReader tsPayloadReader3 = null;
            final TsPayloadReader tsPayloadReader4 = null;
            if (n == 27) {
                TsPayloadReader tsPayloadReader5;
                if (this.f(4)) {
                    tsPayloadReader5 = tsPayloadReader3;
                }
                else {
                    tsPayloadReader5 = new PesReader(new H264Reader(this.c(esInfo), this.f(1), this.f(8)));
                }
                return tsPayloadReader5;
            }
            if (n == 36) {
                return new PesReader(new H265Reader(this.c(esInfo)));
            }
            if (n != 89) {
                if (n != 138) {
                    if (n == 172) {
                        return new PesReader(new Ac4Reader(esInfo.b));
                    }
                    if (n == 257) {
                        return new SectionReader(new PassthroughSectionPayloadReader("application/vnd.dvb.ait"));
                    }
                    if (n != 134) {
                        Label_0244: {
                            if (n != 135) {
                                switch (n) {
                                    default: {
                                        switch (n) {
                                            default: {
                                                return null;
                                            }
                                            case 130: {
                                                if (!this.f(64)) {
                                                    return null;
                                                }
                                                return new PesReader(new DtsReader(esInfo.b));
                                            }
                                            case 129: {
                                                break Label_0244;
                                            }
                                            case 128: {
                                                return new PesReader(new H262Reader(this.d(esInfo)));
                                            }
                                        }
                                        break;
                                    }
                                    case 17: {
                                        TsPayloadReader tsPayloadReader6;
                                        if (this.f(2)) {
                                            tsPayloadReader6 = tsPayloadReader4;
                                        }
                                        else {
                                            tsPayloadReader6 = new PesReader(new LatmReader(esInfo.b));
                                        }
                                        return tsPayloadReader6;
                                    }
                                    case 16: {
                                        return new PesReader(new H263Reader(this.d(esInfo)));
                                    }
                                    case 15: {
                                        TsPayloadReader tsPayloadReader7;
                                        if (this.f(2)) {
                                            tsPayloadReader7 = tsPayloadReader;
                                        }
                                        else {
                                            tsPayloadReader7 = new PesReader(new AdtsReader(false, esInfo.b));
                                        }
                                        return tsPayloadReader7;
                                    }
                                }
                            }
                        }
                        return new PesReader(new Ac3Reader(esInfo.b));
                    }
                    TsPayloadReader tsPayloadReader8;
                    if (this.f(16)) {
                        tsPayloadReader8 = tsPayloadReader2;
                    }
                    else {
                        tsPayloadReader8 = new SectionReader(new PassthroughSectionPayloadReader("application/x-scte35"));
                    }
                    return tsPayloadReader8;
                }
                return new PesReader(new DtsReader(esInfo.b));
            }
            return new PesReader(new DvbSubtitleReader(esInfo.c));
        }
        return new PesReader(new H262Reader(this.d(esInfo)));
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.TYPE_USE })
    public @interface Flags {
    }
}
