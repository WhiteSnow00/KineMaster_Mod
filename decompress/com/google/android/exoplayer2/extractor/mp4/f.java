// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.metadata.mp4.SlowMotionData;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.ParserException;
import java.io.IOException;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import java.util.ArrayList;
import java.util.List;
import com.google.common.base.Splitter;

final class f
{
    private static final Splitter d;
    private static final Splitter e;
    private final List<a> a;
    private int b;
    private int c;
    
    static {
        d = Splitter.f(':');
        e = Splitter.f('*');
    }
    
    public f() {
        this.a = new ArrayList<a>();
        this.b = 0;
    }
    
    private void a(final ExtractorInput extractorInput, final PositionHolder positionHolder) throws IOException {
        final ParsableByteArray parsableByteArray = new ParsableByteArray(8);
        extractorInput.readFully(parsableByteArray.d(), 0, 8);
        this.c = parsableByteArray.q() + 8;
        if (parsableByteArray.n() != 1397048916) {
            positionHolder.a = 0L;
            return;
        }
        positionHolder.a = extractorInput.getPosition() - (this.c - 12);
        this.b = 2;
    }
    
    private static int b(final String s) throws ParserException {
        s.hashCode();
        final int hashCode = s.hashCode();
        int n = -1;
        switch (hashCode) {
            case 1760745220: {
                if (!s.equals("Super_SlowMotion_BGM")) {
                    break;
                }
                n = 4;
                break;
            }
            case -830665521: {
                if (!s.equals("Super_SlowMotion_Deflickering_On")) {
                    break;
                }
                n = 3;
                break;
            }
            case -1251387154: {
                if (!s.equals("Super_SlowMotion_Data")) {
                    break;
                }
                n = 2;
                break;
            }
            case -1332107749: {
                if (!s.equals("Super_SlowMotion_Edit_Data")) {
                    break;
                }
                n = 1;
                break;
            }
            case -1711564334: {
                if (!s.equals("SlowMotion_Data")) {
                    break;
                }
                n = 0;
                break;
            }
        }
        switch (n) {
            default: {
                throw ParserException.createForMalformedContainer("Invalid SEF name", null);
            }
            case 4: {
                return 2817;
            }
            case 3: {
                return 2820;
            }
            case 2: {
                return 2816;
            }
            case 1: {
                return 2819;
            }
            case 0: {
                return 2192;
            }
        }
    }
    
    private void d(final ExtractorInput extractorInput, final PositionHolder positionHolder) throws IOException {
        final long length = extractorInput.getLength();
        final int n = this.c - 12 - 8;
        final ParsableByteArray parsableByteArray = new ParsableByteArray(n);
        extractorInput.readFully(parsableByteArray.d(), 0, n);
        for (int i = 0; i < n / 12; ++i) {
            parsableByteArray.Q(2);
            final short s = parsableByteArray.s();
            if (s != 2192 && s != 2816 && s != 2817 && s != 2819 && s != 2820) {
                parsableByteArray.Q(8);
            }
            else {
                this.a.add(new a(s, length - this.c - parsableByteArray.q(), parsableByteArray.q()));
            }
        }
        if (this.a.isEmpty()) {
            positionHolder.a = 0L;
            return;
        }
        this.b = 3;
        positionHolder.a = this.a.get(0).b;
    }
    
    private void e(final ExtractorInput extractorInput, final List<Metadata.Entry> list) throws IOException {
        final long position = extractorInput.getPosition();
        final int n = (int)(extractorInput.getLength() - extractorInput.getPosition() - this.c);
        final ParsableByteArray parsableByteArray = new ParsableByteArray(n);
        final byte[] d = parsableByteArray.d();
        int i = 0;
        extractorInput.readFully(d, 0, n);
        while (i < this.a.size()) {
            final a a = this.a.get(i);
            parsableByteArray.P((int)(a.b - position));
            parsableByteArray.Q(4);
            final int q = parsableByteArray.q();
            final int b = b(parsableByteArray.A(q));
            final int c = a.c;
            if (b != 2192) {
                if (b != 2816 && b != 2817 && b != 2819) {
                    if (b != 2820) {
                        throw new IllegalStateException();
                    }
                }
            }
            else {
                list.add(f(parsableByteArray, c - (q + 8)));
            }
            ++i;
        }
    }
    
    private static SlowMotionData f(final ParsableByteArray parsableByteArray, int i) throws ParserException {
        final ArrayList list = new ArrayList();
        final List j = f.e.j((CharSequence)parsableByteArray.A(i));
        i = 0;
        while (i < j.size()) {
            final List k = f.d.j((CharSequence)j.get(i));
            if (k.size() == 3) {
                try {
                    list.add(new SlowMotionData.Segment(Long.parseLong((String)k.get(0)), Long.parseLong((String)k.get(1)), 1 << Integer.parseInt((String)k.get(2)) - 1));
                    ++i;
                    continue;
                }
                catch (final NumberFormatException ex) {
                    throw ParserException.createForMalformedContainer(null, ex);
                }
            }
            throw ParserException.createForMalformedContainer(null, null);
        }
        return new SlowMotionData(list);
    }
    
    public int c(final ExtractorInput extractorInput, final PositionHolder positionHolder, final List<Metadata.Entry> list) throws IOException {
        final int b = this.b;
        final long n = 0L;
        if (b != 0) {
            if (b != 1) {
                if (b != 2) {
                    if (b != 3) {
                        throw new IllegalStateException();
                    }
                    this.e(extractorInput, list);
                    positionHolder.a = 0L;
                }
                else {
                    this.d(extractorInput, positionHolder);
                }
            }
            else {
                this.a(extractorInput, positionHolder);
            }
        }
        else {
            final long length = extractorInput.getLength();
            long a = n;
            if (length != -1L) {
                if (length < 8L) {
                    a = n;
                }
                else {
                    a = length - 8L;
                }
            }
            positionHolder.a = a;
            this.b = 1;
        }
        return 1;
    }
    
    public void g() {
        this.a.clear();
        this.b = 0;
    }
    
    private static final class a
    {
        public final int a;
        public final long b;
        public final int c;
        
        public a(final int a, final long b, final int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}
