// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor;

import java.util.Arrays;
import java.util.List;
import com.google.common.collect.ImmutableList;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.ParserException;
import java.io.IOException;
import com.google.android.exoplayer2.util.ParsableByteArray;

public final class FlacMetadataReader
{
    private FlacMetadataReader() {
    }
    
    public static boolean a(final ExtractorInput extractorInput) throws IOException {
        final ParsableByteArray parsableByteArray = new ParsableByteArray(4);
        final byte[] d = parsableByteArray.d();
        boolean b = false;
        extractorInput.r(d, 0, 4);
        if (parsableByteArray.F() == 1716281667L) {
            b = true;
        }
        return b;
    }
    
    public static int b(final ExtractorInput extractorInput) throws IOException {
        extractorInput.h();
        final ParsableByteArray parsableByteArray = new ParsableByteArray(2);
        extractorInput.r(parsableByteArray.d(), 0, 2);
        final int j = parsableByteArray.J();
        if (j >> 2 == 16382) {
            extractorInput.h();
            return j;
        }
        extractorInput.h();
        throw ParserException.createForMalformedContainer("First frame does not start with sync code.", null);
    }
    
    public static Metadata c(final ExtractorInput extractorInput, final boolean b) throws IOException {
        final Metadata metadata = null;
        Object b2;
        if (b) {
            b2 = null;
        }
        else {
            b2 = Id3Decoder.b;
        }
        final Metadata a = new Id3Peeker().a(extractorInput, (Id3Decoder.FramePredicate)b2);
        Metadata metadata2 = metadata;
        if (a != null) {
            if (a.d() == 0) {
                metadata2 = metadata;
            }
            else {
                metadata2 = a;
            }
        }
        return metadata2;
    }
    
    public static Metadata d(final ExtractorInput extractorInput, final boolean b) throws IOException {
        extractorInput.h();
        final long k = extractorInput.k();
        final Metadata c = c(extractorInput, b);
        extractorInput.o((int)(extractorInput.k() - k));
        return c;
    }
    
    public static boolean e(final ExtractorInput extractorInput, final FlacStreamMetadataHolder flacStreamMetadataHolder) throws IOException {
        extractorInput.h();
        final ParsableBitArray parsableBitArray = new ParsableBitArray(new byte[4]);
        extractorInput.r(parsableBitArray.a, 0, 4);
        final boolean g = parsableBitArray.g();
        final int h = parsableBitArray.h(7);
        final int n = parsableBitArray.h(24) + 4;
        if (h == 0) {
            flacStreamMetadataHolder.a = h(extractorInput);
        }
        else {
            final FlacStreamMetadata a = flacStreamMetadataHolder.a;
            if (a == null) {
                throw new IllegalArgumentException();
            }
            if (h == 3) {
                flacStreamMetadataHolder.a = a.b(f(extractorInput, n));
            }
            else if (h == 4) {
                flacStreamMetadataHolder.a = a.c(j(extractorInput, n));
            }
            else if (h == 6) {
                final ParsableByteArray parsableByteArray = new ParsableByteArray(n);
                extractorInput.readFully(parsableByteArray.d(), 0, n);
                parsableByteArray.Q(4);
                flacStreamMetadataHolder.a = a.a((List<PictureFrame>)ImmutableList.of((Object)PictureFrame.a(parsableByteArray)));
            }
            else {
                extractorInput.o(n);
            }
        }
        return g;
    }
    
    private static FlacStreamMetadata.SeekTable f(final ExtractorInput extractorInput, final int n) throws IOException {
        final ParsableByteArray parsableByteArray = new ParsableByteArray(n);
        extractorInput.readFully(parsableByteArray.d(), 0, n);
        return g(parsableByteArray);
    }
    
    public static FlacStreamMetadata.SeekTable g(final ParsableByteArray parsableByteArray) {
        parsableByteArray.Q(1);
        final int g = parsableByteArray.G();
        final long n = parsableByteArray.e();
        final long n2 = g;
        final int n3 = g / 18;
        final long[] array = new long[n3];
        final long[] array2 = new long[n3];
        int n4 = 0;
        long[] copy;
        long[] copy2;
        while (true) {
            copy = array;
            copy2 = array2;
            if (n4 >= n3) {
                break;
            }
            final long w = parsableByteArray.w();
            if (w == -1L) {
                copy = Arrays.copyOf(array, n4);
                copy2 = Arrays.copyOf(array2, n4);
                break;
            }
            array[n4] = w;
            array2[n4] = parsableByteArray.w();
            parsableByteArray.Q(2);
            ++n4;
        }
        parsableByteArray.Q((int)(n + n2 - parsableByteArray.e()));
        return new FlacStreamMetadata.SeekTable(copy, copy2);
    }
    
    private static FlacStreamMetadata h(final ExtractorInput extractorInput) throws IOException {
        final byte[] array = new byte[38];
        extractorInput.readFully(array, 0, 38);
        return new FlacStreamMetadata(array, 4);
    }
    
    public static void i(final ExtractorInput extractorInput) throws IOException {
        final ParsableByteArray parsableByteArray = new ParsableByteArray(4);
        extractorInput.readFully(parsableByteArray.d(), 0, 4);
        if (parsableByteArray.F() == 1716281667L) {
            return;
        }
        throw ParserException.createForMalformedContainer("Failed to read FLAC stream marker.", null);
    }
    
    private static List<String> j(final ExtractorInput extractorInput, final int n) throws IOException {
        final ParsableByteArray parsableByteArray = new ParsableByteArray(n);
        extractorInput.readFully(parsableByteArray.d(), 0, n);
        parsableByteArray.Q(4);
        return Arrays.asList(VorbisUtil.j(parsableByteArray, false, false).b);
    }
    
    public static final class FlacStreamMetadataHolder
    {
        public FlacStreamMetadata a;
        
        public FlacStreamMetadataHolder(final FlacStreamMetadata a) {
            this.a = a;
        }
    }
}
