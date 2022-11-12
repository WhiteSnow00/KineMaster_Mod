// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor;

import java.io.IOException;
import java.io.EOFException;
import com.google.android.exoplayer2.ParserException;

public final class ExtractorUtil
{
    private ExtractorUtil() {
    }
    
    public static void a(final boolean b, final String s) throws ParserException {
        if (b) {
            return;
        }
        throw ParserException.createForMalformedContainer(s, null);
    }
    
    public static boolean b(final ExtractorInput extractorInput, final byte[] array, final int n, final int n2, final boolean b) throws IOException {
        try {
            return extractorInput.f(array, n, n2, b);
        }
        catch (final EOFException ex) {
            if (b) {
                return false;
            }
            throw ex;
        }
    }
    
    public static int c(final ExtractorInput extractorInput, final byte[] array, final int n, final int n2) throws IOException {
        int i;
        int n3;
        for (i = 0; i < n2; i += n3) {
            n3 = extractorInput.n(array, n + i, n2 - i);
            if (n3 == -1) {
                break;
            }
        }
        return i;
    }
    
    public static boolean d(final ExtractorInput extractorInput, final byte[] array, final int n, final int n2) throws IOException {
        try {
            extractorInput.readFully(array, n, n2);
            return true;
        }
        catch (final EOFException ex) {
            return false;
        }
    }
    
    public static boolean e(final ExtractorInput extractorInput, final int n) throws IOException {
        try {
            extractorInput.o(n);
            return true;
        }
        catch (final EOFException ex) {
            return false;
        }
    }
}
