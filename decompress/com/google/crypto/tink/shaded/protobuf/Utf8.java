// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.shaded.protobuf;

import java.nio.ByteBuffer;

final class Utf8
{
    private static final b a;
    
    static {
        b a2;
        if (d.m() && !com.google.crypto.tink.shaded.protobuf.b.c()) {
            a2 = new d();
        }
        else {
            a2 = new c();
        }
        a = a2;
    }
    
    static int a(final int n, final int n2) {
        return n(n, n2);
    }
    
    static int b(final int n, final int n2, final int n3) {
        return o(n, n2, n3);
    }
    
    static int c(final byte[] array, final int n, final int n2) {
        return q(array, n, n2);
    }
    
    static int d(final int n) {
        return m(n);
    }
    
    static int e(final ByteBuffer byteBuffer, final int n, final int n2) {
        return l(byteBuffer, n, n2);
    }
    
    static int f(final ByteBuffer byteBuffer, final int n, final int n2, final int n3) {
        return p(byteBuffer, n, n2, n3);
    }
    
    static String g(final ByteBuffer byteBuffer, final int n, final int n2) throws InvalidProtocolBufferException {
        return Utf8.a.a(byteBuffer, n, n2);
    }
    
    static String h(final byte[] array, final int n, final int n2) throws InvalidProtocolBufferException {
        return Utf8.a.b(array, n, n2);
    }
    
    static int i(final CharSequence charSequence, final byte[] array, final int n, final int n2) {
        return Utf8.a.e(charSequence, array, n, n2);
    }
    
    static int j(final CharSequence charSequence) {
        int length;
        int n;
        for (length = charSequence.length(), n = 0; n < length && charSequence.charAt(n) < '\u0080'; ++n) {}
        int n2 = length;
        int n3;
        while (true) {
            n3 = n2;
            if (n >= length) {
                break;
            }
            final char char1 = charSequence.charAt(n);
            if (char1 >= '\u0800') {
                n3 = n2 + k(charSequence, n);
                break;
            }
            n2 += '\u007f' - char1 >>> 31;
            ++n;
        }
        if (n3 >= length) {
            return n3;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("UTF-8 length does not fit in int: ");
        sb.append(n3 + 4294967296L);
        throw new IllegalArgumentException(sb.toString());
    }
    
    private static int k(final CharSequence charSequence, int i) {
        final int length = charSequence.length();
        int n = 0;
        while (i < length) {
            final char char1 = charSequence.charAt(i);
            int n2;
            if (char1 < '\u0800') {
                n += '\u007f' - char1 >>> 31;
                n2 = i;
            }
            else {
                final int n3 = n += 2;
                n2 = i;
                if ('\ud800' <= char1) {
                    n = n3;
                    n2 = i;
                    if (char1 <= '\udfff') {
                        if (Character.codePointAt(charSequence, i) < 65536) {
                            throw new UnpairedSurrogateException(i, length);
                        }
                        n2 = i + 1;
                        n = n3;
                    }
                }
            }
            i = n2 + 1;
        }
        return n;
    }
    
    private static int l(final ByteBuffer byteBuffer, final int n, final int n2) {
        int n3;
        for (n3 = n; n3 < n2 - 7 && (byteBuffer.getLong(n3) & 0x8080808080808080L) == 0x0L; n3 += 8) {}
        return n3 - n;
    }
    
    private static int m(final int n) {
        int n2 = n;
        if (n > -12) {
            n2 = -1;
        }
        return n2;
    }
    
    private static int n(int n, final int n2) {
        if (n <= -12 && n2 <= -65) {
            n ^= n2 << 8;
        }
        else {
            n = -1;
        }
        return n;
    }
    
    private static int o(int n, final int n2, final int n3) {
        if (n <= -12 && n2 <= -65 && n3 <= -65) {
            n = (n ^ n2 << 8 ^ n3 << 16);
        }
        else {
            n = -1;
        }
        return n;
    }
    
    private static int p(final ByteBuffer byteBuffer, final int n, final int n2, final int n3) {
        if (n3 == 0) {
            return m(n);
        }
        if (n3 == 1) {
            return n(n, byteBuffer.get(n2));
        }
        if (n3 == 2) {
            return o(n, byteBuffer.get(n2), byteBuffer.get(n2 + 1));
        }
        throw new AssertionError();
    }
    
    private static int q(final byte[] array, final int n, int n2) {
        final byte b = array[n - 1];
        n2 -= n;
        if (n2 == 0) {
            return m(b);
        }
        if (n2 == 1) {
            return n(b, array[n]);
        }
        if (n2 == 2) {
            return o(b, array[n], array[n + 1]);
        }
        throw new AssertionError();
    }
    
    static boolean r(final ByteBuffer byteBuffer) {
        return Utf8.a.f(byteBuffer, byteBuffer.position(), byteBuffer.remaining());
    }
    
    public static boolean s(final byte[] array) {
        return Utf8.a.g(array, 0, array.length);
    }
    
    public static boolean t(final byte[] array, final int n, final int n2) {
        return Utf8.a.g(array, n, n2);
    }
    
    static int u(final int n, final ByteBuffer byteBuffer, final int n2, final int n3) {
        return Utf8.a.h(n, byteBuffer, n2, n3);
    }
    
    public static int v(final int n, final byte[] array, final int n2, final int n3) {
        return Utf8.a.i(n, array, n2, n3);
    }
    
    static class UnpairedSurrogateException extends IllegalArgumentException
    {
        UnpairedSurrogateException(final int n, final int n2) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Unpaired surrogate at index ");
            sb.append(n);
            sb.append(" of ");
            sb.append(n2);
            super(sb.toString());
        }
    }
    
    private static class a
    {
        static void a(final byte b, final byte b2, final byte b3, final byte b4, final char[] array, final int n) throws InvalidProtocolBufferException {
            h(b, b2, b3, b4, array, n);
        }
        
        static boolean b(final byte b) {
            return n(b);
        }
        
        static void c(final byte b, final char[] array, final int n) {
            i(b, array, n);
        }
        
        static boolean d(final byte b) {
            return p(b);
        }
        
        static void e(final byte b, final byte b2, final char[] array, final int n) throws InvalidProtocolBufferException {
            k(b, b2, array, n);
        }
        
        static boolean f(final byte b) {
            return o(b);
        }
        
        static void g(final byte b, final byte b2, final byte b3, final char[] array, final int n) throws InvalidProtocolBufferException {
            j(b, b2, b3, array, n);
        }
        
        private static void h(final byte b, final byte b2, final byte b3, final byte b4, final char[] array, final int n) throws InvalidProtocolBufferException {
            if (!m(b2) && (b << 28) + (b2 + 112) >> 30 == 0 && !m(b3) && !m(b4)) {
                final int n2 = (b & 0x7) << 18 | r(b2) << 12 | r(b3) << 6 | r(b4);
                array[n] = l(n2);
                array[n + 1] = q(n2);
                return;
            }
            throw InvalidProtocolBufferException.invalidUtf8();
        }
        
        private static void i(final byte b, final char[] array, final int n) {
            array[n] = (char)b;
        }
        
        private static void j(final byte b, final byte b2, final byte b3, final char[] array, final int n) throws InvalidProtocolBufferException {
            if (!m(b2) && (b != -32 || b2 >= -96) && (b != -19 || b2 < -96) && !m(b3)) {
                array[n] = (char)((b & 0xF) << 12 | r(b2) << 6 | r(b3));
                return;
            }
            throw InvalidProtocolBufferException.invalidUtf8();
        }
        
        private static void k(final byte b, final byte b2, final char[] array, final int n) throws InvalidProtocolBufferException {
            if (b >= -62 && !m(b2)) {
                array[n] = (char)((b & 0x1F) << 6 | r(b2));
                return;
            }
            throw InvalidProtocolBufferException.invalidUtf8();
        }
        
        private static char l(final int n) {
            return (char)((n >>> 10) + 55232);
        }
        
        private static boolean m(final byte b) {
            return b > -65;
        }
        
        private static boolean n(final byte b) {
            return b >= 0;
        }
        
        private static boolean o(final byte b) {
            return b < -16;
        }
        
        private static boolean p(final byte b) {
            return b < -32;
        }
        
        private static char q(final int n) {
            return (char)((n & 0x3FF) + 56320);
        }
        
        private static int r(final byte b) {
            return b & 0x3F;
        }
    }
    
    abstract static class b
    {
        private static int j(final ByteBuffer byteBuffer, int i, final int n) {
            i += Utf8.e(byteBuffer, i, n);
            while (i < n) {
                final int n2 = i + 1;
                final byte value = byteBuffer.get(i);
                i = n2;
                if (value < 0) {
                    if (value < -32) {
                        if (n2 >= n) {
                            return value;
                        }
                        if (value < -62 || byteBuffer.get(n2) > -65) {
                            return -1;
                        }
                        i = n2 + 1;
                    }
                    else if (value < -16) {
                        if (n2 >= n - 1) {
                            return Utf8.f(byteBuffer, value, n2, n - n2);
                        }
                        i = n2 + 1;
                        final byte value2 = byteBuffer.get(n2);
                        if (value2 > -65 || (value == -32 && value2 < -96) || (value == -19 && value2 >= -96) || byteBuffer.get(i) > -65) {
                            return -1;
                        }
                        ++i;
                    }
                    else {
                        if (n2 >= n - 2) {
                            return Utf8.f(byteBuffer, value, n2, n - n2);
                        }
                        i = n2 + 1;
                        final byte value3 = byteBuffer.get(n2);
                        if (value3 <= -65 && (value << 28) + (value3 + 112) >> 30 == 0) {
                            final int n3 = i + 1;
                            if (byteBuffer.get(i) <= -65) {
                                i = n3 + 1;
                                if (byteBuffer.get(n3) <= -65) {
                                    continue;
                                }
                            }
                        }
                        return -1;
                    }
                }
            }
            return 0;
        }
        
        final String a(final ByteBuffer byteBuffer, final int n, final int n2) throws InvalidProtocolBufferException {
            if (byteBuffer.hasArray()) {
                return this.b(byteBuffer.array(), byteBuffer.arrayOffset() + n, n2);
            }
            if (byteBuffer.isDirect()) {
                return this.d(byteBuffer, n, n2);
            }
            return this.c(byteBuffer, n, n2);
        }
        
        abstract String b(final byte[] p0, final int p1, final int p2) throws InvalidProtocolBufferException;
        
        final String c(final ByteBuffer byteBuffer, int i, int j) throws InvalidProtocolBufferException {
            if ((i | j | byteBuffer.limit() - i - j) >= 0) {
                final int n = i + j;
                final char[] array = new char[j];
                j = 0;
                while (i < n) {
                    final byte value = byteBuffer.get(i);
                    if (!Utf8.a.b(value)) {
                        break;
                    }
                    ++i;
                    Utf8.a.c(value, array, j);
                    ++j;
                }
                final int n2 = j;
                j = i;
                i = n2;
                while (j < n) {
                    final int n3 = j + 1;
                    final byte value2 = byteBuffer.get(j);
                    if (Utf8.a.b(value2)) {
                        j = i + 1;
                        Utf8.a.c(value2, array, i);
                        i = j;
                        j = n3;
                        while (j < n) {
                            final byte value3 = byteBuffer.get(j);
                            if (!Utf8.a.b(value3)) {
                                break;
                            }
                            ++j;
                            Utf8.a.c(value3, array, i);
                            ++i;
                        }
                    }
                    else if (Utf8.a.d(value2)) {
                        if (n3 >= n) {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                        Utf8.a.e(value2, byteBuffer.get(n3), array, i);
                        j = n3 + 1;
                        ++i;
                    }
                    else if (Utf8.a.f(value2)) {
                        if (n3 >= n - 1) {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                        j = n3 + 1;
                        Utf8.a.g(value2, byteBuffer.get(n3), byteBuffer.get(j), array, i);
                        ++j;
                        ++i;
                    }
                    else {
                        if (n3 >= n - 2) {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                        j = n3 + 1;
                        final byte value4 = byteBuffer.get(n3);
                        final int n4 = j + 1;
                        Utf8.a.a(value2, value4, byteBuffer.get(j), byteBuffer.get(n4), array, i);
                        j = n4 + 1;
                        i = i + 1 + 1;
                    }
                }
                return new String(array, 0, i);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", byteBuffer.limit(), i, j));
        }
        
        abstract String d(final ByteBuffer p0, final int p1, final int p2) throws InvalidProtocolBufferException;
        
        abstract int e(final CharSequence p0, final byte[] p1, final int p2, final int p3);
        
        final boolean f(final ByteBuffer byteBuffer, final int n, final int n2) {
            boolean b = false;
            if (this.h(0, byteBuffer, n, n2) == 0) {
                b = true;
            }
            return b;
        }
        
        final boolean g(final byte[] array, final int n, final int n2) {
            boolean b = false;
            if (this.i(0, array, n, n2) == 0) {
                b = true;
            }
            return b;
        }
        
        final int h(final int n, final ByteBuffer byteBuffer, final int n2, final int n3) {
            if (byteBuffer.hasArray()) {
                final int arrayOffset = byteBuffer.arrayOffset();
                return this.i(n, byteBuffer.array(), n2 + arrayOffset, arrayOffset + n3);
            }
            if (byteBuffer.isDirect()) {
                return this.l(n, byteBuffer, n2, n3);
            }
            return this.k(n, byteBuffer, n2, n3);
        }
        
        abstract int i(final int p0, final byte[] p1, final int p2, final int p3);
        
        final int k(int value, final ByteBuffer byteBuffer, int n, final int n2) {
            int n3 = n;
            if (value != 0) {
                if (n >= n2) {
                    return value;
                }
                final byte b = (byte)value;
                Label_0050: {
                    if (b < -32) {
                        if (b >= -62) {
                            value = n + 1;
                            if (byteBuffer.get(n) <= -65) {
                                break Label_0050;
                            }
                        }
                        return -1;
                    }
                    if (b < -16) {
                        final byte b2 = (byte)(value = (byte)~(value >> 8));
                        int n4 = n;
                        if (b2 == 0) {
                            n4 = n + 1;
                            value = byteBuffer.get(n);
                            if (n4 >= n2) {
                                return Utf8.a(b, value);
                            }
                        }
                        if (value <= -65 && (b != -32 || value >= -96) && (b != -19 || value < -96)) {
                            value = n4 + 1;
                            if (byteBuffer.get(n4) <= -65) {
                                break Label_0050;
                            }
                        }
                        return -1;
                    }
                    byte value2 = (byte)~(value >> 8);
                    final int n5 = 0;
                    if (value2 == 0) {
                        value = n + 1;
                        value2 = byteBuffer.get(n);
                        if (value >= n2) {
                            return Utf8.a(b, value2);
                        }
                        n = value;
                        value = n5;
                    }
                    else {
                        value = (byte)(value >> 16);
                    }
                    int value3 = value;
                    int n6 = n;
                    if (value == 0) {
                        n6 = n + 1;
                        value3 = byteBuffer.get(n);
                        if (n6 >= n2) {
                            return Utf8.b(b, value2, value3);
                        }
                    }
                    if (value2 <= -65 && (b << 28) + (value2 + 112) >> 30 == 0 && value3 <= -65) {
                        value = n6 + 1;
                        if (byteBuffer.get(n6) <= -65) {
                            break Label_0050;
                        }
                    }
                    return -1;
                }
                n3 = value;
            }
            return j(byteBuffer, n3, n2);
        }
        
        abstract int l(final int p0, final ByteBuffer p1, final int p2, final int p3);
    }
    
    static final class c extends b
    {
        private static int m(final byte[] array, int n, final int n2) {
            while (n < n2 && array[n] >= 0) {
                ++n;
            }
            if (n >= n2) {
                n = 0;
            }
            else {
                n = n(array, n, n2);
            }
            return n;
        }
        
        private static int n(final byte[] array, int i, final int n) {
            while (i < n) {
                final int n2 = i + 1;
                final byte b = array[i];
                i = n2;
                if (b < 0) {
                    if (b < -32) {
                        if (n2 >= n) {
                            return b;
                        }
                        if (b >= -62) {
                            i = n2 + 1;
                            if (array[n2] <= -65) {
                                continue;
                            }
                        }
                        return -1;
                    }
                    else if (b < -16) {
                        if (n2 >= n - 1) {
                            return Utf8.c(array, n2, n);
                        }
                        final int n3 = n2 + 1;
                        i = array[n2];
                        if (i <= -65 && (b != -32 || i >= -96) && (b != -19 || i < -96)) {
                            i = n3 + 1;
                            if (array[n3] <= -65) {
                                continue;
                            }
                        }
                        return -1;
                    }
                    else {
                        if (n2 >= n - 2) {
                            return Utf8.c(array, n2, n);
                        }
                        i = n2 + 1;
                        final byte b2 = array[n2];
                        if (b2 <= -65 && (b << 28) + (b2 + 112) >> 30 == 0) {
                            final int n4 = i + 1;
                            if (array[i] <= -65) {
                                i = n4 + 1;
                                if (array[n4] <= -65) {
                                    continue;
                                }
                            }
                        }
                        return -1;
                    }
                }
            }
            return 0;
        }
        
        @Override
        String b(final byte[] array, int i, int j) throws InvalidProtocolBufferException {
            if ((i | j | array.length - i - j) >= 0) {
                final int n = i + j;
                final char[] array2 = new char[j];
                j = 0;
                while (i < n) {
                    final byte b = array[i];
                    if (!Utf8.a.b(b)) {
                        break;
                    }
                    ++i;
                    Utf8.a.c(b, array2, j);
                    ++j;
                }
                final int n2 = j;
                j = i;
                i = n2;
                while (j < n) {
                    final int n3 = j + 1;
                    final byte b2 = array[j];
                    if (Utf8.a.b(b2)) {
                        j = i + 1;
                        Utf8.a.c(b2, array2, i);
                        i = j;
                        j = n3;
                        while (j < n) {
                            final byte b3 = array[j];
                            if (!Utf8.a.b(b3)) {
                                break;
                            }
                            ++j;
                            Utf8.a.c(b3, array2, i);
                            ++i;
                        }
                    }
                    else if (Utf8.a.d(b2)) {
                        if (n3 >= n) {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                        Utf8.a.e(b2, array[n3], array2, i);
                        j = n3 + 1;
                        ++i;
                    }
                    else if (Utf8.a.f(b2)) {
                        if (n3 >= n - 1) {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                        j = n3 + 1;
                        Utf8.a.g(b2, array[n3], array[j], array2, i);
                        ++j;
                        ++i;
                    }
                    else {
                        if (n3 >= n - 2) {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                        j = n3 + 1;
                        final byte b4 = array[n3];
                        final int n4 = j + 1;
                        Utf8.a.a(b2, b4, array[j], array[n4], array2, i);
                        j = n4 + 1;
                        i = i + 1 + 1;
                    }
                }
                return new String(array2, 0, i);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", array.length, i, j));
        }
        
        @Override
        String d(final ByteBuffer byteBuffer, final int n, final int n2) throws InvalidProtocolBufferException {
            return ((b)this).c(byteBuffer, n, n2);
        }
        
        @Override
        int e(final CharSequence charSequence, final byte[] array, int i, int j) {
            final int length = charSequence.length();
            final int n = j + i;
            int n2;
            char char1;
            for (j = 0; j < length; ++j) {
                n2 = j + i;
                if (n2 >= n) {
                    break;
                }
                char1 = charSequence.charAt(j);
                if (char1 >= '\u0080') {
                    break;
                }
                array[n2] = (byte)char1;
            }
            if (j == length) {
                return i + length;
            }
            int n3 = i + j;
            char char2;
            int n4;
            int n5;
            char char3;
            int n6;
            int n7;
            int n8;
            int n9;
            StringBuilder sb;
            for (i = j; i < length; ++i, n3 = j) {
                char2 = charSequence.charAt(i);
                if (char2 < '\u0080' && n3 < n) {
                    j = n3 + 1;
                    array[n3] = (byte)char2;
                }
                else if (char2 < '\u0800' && n3 <= n - 2) {
                    n4 = n3 + 1;
                    array[n3] = (byte)(char2 >>> 6 | 0x3C0);
                    j = n4 + 1;
                    array[n4] = (byte)((char2 & '?') | 0x80);
                }
                else if ((char2 < '\ud800' || '\udfff' < char2) && n3 <= n - 3) {
                    j = n3 + 1;
                    array[n3] = (byte)(char2 >>> 12 | 0x1E0);
                    n5 = j + 1;
                    array[j] = (byte)((char2 >>> 6 & 0x3F) | 0x80);
                    j = n5 + 1;
                    array[n5] = (byte)((char2 & '?') | 0x80);
                }
                else {
                    if (n3 <= n - 4) {
                        j = i + 1;
                        if (j != charSequence.length()) {
                            char3 = charSequence.charAt(j);
                            if (Character.isSurrogatePair(char2, char3)) {
                                i = Character.toCodePoint(char2, char3);
                                n6 = n3 + 1;
                                array[n3] = (byte)(i >>> 18 | 0xF0);
                                n7 = n6 + 1;
                                array[n6] = (byte)((i >>> 12 & 0x3F) | 0x80);
                                n8 = n7 + 1;
                                array[n7] = (byte)((i >>> 6 & 0x3F) | 0x80);
                                n9 = n8 + 1;
                                array[n8] = (byte)((i & 0x3F) | 0x80);
                                i = j;
                                j = n9;
                                continue;
                            }
                            i = j;
                        }
                        throw new UnpairedSurrogateException(i - 1, length);
                    }
                    if ('\ud800' <= char2 && char2 <= '\udfff') {
                        j = i + 1;
                        if (j == charSequence.length() || !Character.isSurrogatePair(char2, charSequence.charAt(j))) {
                            throw new UnpairedSurrogateException(i, length);
                        }
                    }
                    sb = new StringBuilder();
                    sb.append("Failed writing ");
                    sb.append(char2);
                    sb.append(" at index ");
                    sb.append(n3);
                    throw new ArrayIndexOutOfBoundsException(sb.toString());
                }
            }
            return n3;
        }
        
        @Override
        int i(int n, final byte[] array, int n2, final int n3) {
            int n4 = n2;
            if (n != 0) {
                if (n2 >= n3) {
                    return n;
                }
                final byte b = (byte)n;
                Label_0048: {
                    if (b < -32) {
                        if (b >= -62) {
                            n = n2 + 1;
                            if (array[n2] <= -65) {
                                break Label_0048;
                            }
                        }
                        return -1;
                    }
                    if (b < -16) {
                        final byte b2 = (byte)(n = (byte)~(n >> 8));
                        int n5 = n2;
                        if (b2 == 0) {
                            n5 = n2 + 1;
                            n = array[n2];
                            if (n5 >= n3) {
                                return Utf8.a(b, n);
                            }
                        }
                        if (n <= -65 && (b != -32 || n >= -96) && (b != -19 || n < -96)) {
                            n = n5 + 1;
                            if (array[n5] <= -65) {
                                break Label_0048;
                            }
                        }
                        return -1;
                    }
                    byte b3 = (byte)~(n >> 8);
                    final int n6 = 0;
                    if (b3 == 0) {
                        n = n2 + 1;
                        b3 = array[n2];
                        if (n >= n3) {
                            return Utf8.a(b, b3);
                        }
                        n2 = n;
                        n = n6;
                    }
                    else {
                        n = (byte)(n >> 16);
                    }
                    int n7 = n;
                    int n8 = n2;
                    if (n == 0) {
                        n8 = n2 + 1;
                        n7 = array[n2];
                        if (n8 >= n3) {
                            return Utf8.b(b, b3, n7);
                        }
                    }
                    if (b3 <= -65 && (b << 28) + (b3 + 112) >> 30 == 0 && n7 <= -65) {
                        n = n8 + 1;
                        if (array[n8] <= -65) {
                            break Label_0048;
                        }
                    }
                    return -1;
                }
                n4 = n;
            }
            return m(array, n4, n3);
        }
        
        @Override
        int l(final int n, final ByteBuffer byteBuffer, final int n2, final int n3) {
            return ((b)this).k(n, byteBuffer, n2, n3);
        }
    }
    
    static final class d extends b
    {
        static boolean m() {
            return q0.G() && q0.H();
        }
        
        private static int n(long n, int u) {
            final int p2 = p(n, u);
            n += p2;
            u -= p2;
            while (true) {
                final int n2 = 0;
                int n3 = u;
                u = n2;
                long n4;
                while (true) {
                    n4 = n;
                    if (n3 <= 0) {
                        break;
                    }
                    n4 = n + 1L;
                    u = q0.u(n);
                    if (u < 0) {
                        break;
                    }
                    --n3;
                    n = n4;
                }
                if (n3 == 0) {
                    return 0;
                }
                --n3;
                if (u < -32) {
                    if (n3 == 0) {
                        return u;
                    }
                    --n3;
                    if (u < -62) {
                        break;
                    }
                    n = 1L + n4;
                    u = n3;
                    if (q0.u(n4) > -65) {
                        break;
                    }
                    continue;
                }
                else if (u < -16) {
                    if (n3 < 2) {
                        return r(n4, u, n3);
                    }
                    n3 -= 2;
                    final long n5 = n4 + 1L;
                    final byte u2 = q0.u(n4);
                    if (u2 > -65 || (u == -32 && u2 < -96) || (u == -19 && u2 >= -96)) {
                        return -1;
                    }
                    n = 1L + n5;
                    u = n3;
                    if (q0.u(n5) > -65) {
                        return -1;
                    }
                    continue;
                }
                else {
                    if (n3 < 3) {
                        return r(n4, u, n3);
                    }
                    n3 -= 3;
                    n = n4 + 1L;
                    final byte u3 = q0.u(n4);
                    if (u3 > -65 || (u << 28) + (u3 + 112) >> 30 != 0) {
                        return -1;
                    }
                    final long n6 = n + 1L;
                    if (q0.u(n) > -65) {
                        return -1;
                    }
                    n = 1L + n6;
                    u = n3;
                    if (q0.u(n6) > -65) {
                        return -1;
                    }
                    continue;
                }
            }
            return -1;
        }
        
        private static int o(final byte[] array, long n, int v) {
            final int q = q(array, n, v);
            v -= q;
            n += q;
            while (true) {
                final int n2 = 0;
                int n3 = v;
                v = n2;
                long n4;
                while (true) {
                    n4 = n;
                    if (n3 <= 0) {
                        break;
                    }
                    n4 = n + 1L;
                    v = q0.v(array, n);
                    if (v < 0) {
                        break;
                    }
                    --n3;
                    n = n4;
                }
                if (n3 == 0) {
                    return 0;
                }
                --n3;
                if (v < -32) {
                    if (n3 == 0) {
                        return v;
                    }
                    --n3;
                    if (v < -62) {
                        break;
                    }
                    n = 1L + n4;
                    v = n3;
                    if (q0.v(array, n4) > -65) {
                        break;
                    }
                    continue;
                }
                else if (v < -16) {
                    if (n3 < 2) {
                        return s(array, v, n4, n3);
                    }
                    n3 -= 2;
                    final long n5 = n4 + 1L;
                    final byte v2 = q0.v(array, n4);
                    if (v2 > -65 || (v == -32 && v2 < -96) || (v == -19 && v2 >= -96)) {
                        return -1;
                    }
                    n = 1L + n5;
                    v = n3;
                    if (q0.v(array, n5) > -65) {
                        return -1;
                    }
                    continue;
                }
                else {
                    if (n3 < 3) {
                        return s(array, v, n4, n3);
                    }
                    n3 -= 3;
                    n = n4 + 1L;
                    final byte v3 = q0.v(array, n4);
                    if (v3 > -65 || (v << 28) + (v3 + 112) >> 30 != 0) {
                        return -1;
                    }
                    final long n6 = n + 1L;
                    if (q0.v(array, n) > -65) {
                        return -1;
                    }
                    n = 1L + n6;
                    v = n3;
                    if (q0.v(array, n6) > -65) {
                        return -1;
                    }
                    continue;
                }
            }
            return -1;
        }
        
        private static int p(long n, final int n2) {
            if (n2 < 16) {
                return 0;
            }
            int i;
            int n3;
            for (n3 = (i = 8 - ((int)n & 0x7)); i > 0; --i, ++n) {
                if (q0.u(n) < 0) {
                    return n3 - i;
                }
            }
            int n4;
            for (n4 = n2 - n3; n4 >= 8 && (q0.B(n) & 0x8080808080808080L) == 0x0L; n += 8L, n4 -= 8) {}
            return n2 - n4;
        }
        
        private static int q(final byte[] array, long n, final int n2) {
            int i = 0;
            if (n2 < 16) {
                return 0;
            }
            while (i < n2) {
                if (q0.v(array, n) < 0) {
                    return i;
                }
                ++i;
                ++n;
            }
            return n2;
        }
        
        private static int r(final long n, final int n2, final int n3) {
            if (n3 == 0) {
                return Utf8.d(n2);
            }
            if (n3 == 1) {
                return Utf8.a(n2, q0.u(n));
            }
            if (n3 == 2) {
                return Utf8.b(n2, q0.u(n), q0.u(n + 1L));
            }
            throw new AssertionError();
        }
        
        private static int s(final byte[] array, final int n, final long n2, final int n3) {
            if (n3 == 0) {
                return Utf8.d(n);
            }
            if (n3 == 1) {
                return Utf8.a(n, q0.v(array, n2));
            }
            if (n3 == 2) {
                return Utf8.b(n, q0.v(array, n2), q0.v(array, n2 + 1L));
            }
            throw new AssertionError();
        }
        
        @Override
        String b(final byte[] array, int i, int j) throws InvalidProtocolBufferException {
            if ((i | j | array.length - i - j) >= 0) {
                final int n = i + j;
                final char[] array2 = new char[j];
                j = 0;
                while (i < n) {
                    final byte v = q0.v(array, i);
                    if (!Utf8.a.b(v)) {
                        break;
                    }
                    ++i;
                    Utf8.a.c(v, array2, j);
                    ++j;
                }
                final int n2 = j;
                j = i;
                i = n2;
                while (j < n) {
                    final int n3 = j + 1;
                    final byte v2 = q0.v(array, j);
                    if (Utf8.a.b(v2)) {
                        j = i + 1;
                        Utf8.a.c(v2, array2, i);
                        i = j;
                        j = n3;
                        while (j < n) {
                            final byte v3 = q0.v(array, j);
                            if (!Utf8.a.b(v3)) {
                                break;
                            }
                            ++j;
                            Utf8.a.c(v3, array2, i);
                            ++i;
                        }
                    }
                    else if (Utf8.a.d(v2)) {
                        if (n3 >= n) {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                        Utf8.a.e(v2, q0.v(array, n3), array2, i);
                        j = n3 + 1;
                        ++i;
                    }
                    else if (Utf8.a.f(v2)) {
                        if (n3 >= n - 1) {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                        j = n3 + 1;
                        Utf8.a.g(v2, q0.v(array, n3), q0.v(array, j), array2, i);
                        ++j;
                        ++i;
                    }
                    else {
                        if (n3 >= n - 2) {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                        j = n3 + 1;
                        final byte v4 = q0.v(array, n3);
                        final int n4 = j + 1;
                        Utf8.a.a(v2, v4, q0.v(array, j), q0.v(array, n4), array2, i);
                        j = n4 + 1;
                        i = i + 1 + 1;
                    }
                }
                return new String(array2, 0, i);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", array.length, i, j));
        }
        
        @Override
        String d(final ByteBuffer byteBuffer, int n, int n2) throws InvalidProtocolBufferException {
            if ((n | n2 | byteBuffer.limit() - n - n2) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", byteBuffer.limit(), n, n2));
            }
            long n3 = q0.i(byteBuffer) + n;
            final long n4 = n2 + n3;
            final char[] array = new char[n2];
            n2 = 0;
            long n5;
            while (true) {
                n = n2;
                n5 = n3;
                if (n3 >= n4) {
                    break;
                }
                final byte u = q0.u(n3);
                if (!Utf8.a.b(u)) {
                    n = n2;
                    n5 = n3;
                    break;
                }
                ++n3;
                Utf8.a.c(u, array, n2);
                ++n2;
            }
        Label_0094:
            while (true) {
                long n6 = n5;
                while (n6 < n4) {
                    final long n7 = n6 + 1L;
                    final byte u2 = q0.u(n6);
                    if (Utf8.a.b(u2)) {
                        n2 = n + 1;
                        Utf8.a.c(u2, array, n);
                        n = n2;
                        n6 = n7;
                        while (n6 < n4) {
                            final byte u3 = q0.u(n6);
                            if (!Utf8.a.b(u3)) {
                                break;
                            }
                            ++n6;
                            Utf8.a.c(u3, array, n);
                            ++n;
                        }
                    }
                    else if (Utf8.a.d(u2)) {
                        if (n7 >= n4) {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                        n6 = n7 + 1L;
                        Utf8.a.e(u2, q0.u(n7), array, n);
                        ++n;
                    }
                    else if (Utf8.a.f(u2)) {
                        if (n7 >= n4 - 1L) {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                        final long n8 = n7 + 1L;
                        Utf8.a.g(u2, q0.u(n7), q0.u(n8), array, n);
                        ++n;
                        n6 = n8 + 1L;
                    }
                    else {
                        if (n7 < n4 - 2L) {
                            final long n9 = n7 + 1L;
                            final byte u4 = q0.u(n7);
                            final long n10 = n9 + 1L;
                            final byte u5 = q0.u(n9);
                            n5 = n10 + 1L;
                            Utf8.a.a(u2, u4, u5, q0.u(n10), array, n);
                            n = n + 1 + 1;
                            continue Label_0094;
                        }
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                }
                return new String(array, 0, n);
            }
        }
        
        @Override
        int e(final CharSequence charSequence, final byte[] array, int i, int n) {
            long n2 = i;
            final long n3 = n + n2;
            final int length = charSequence.length();
            if (length > n || array.length - n < i) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Failed writing ");
                sb.append(charSequence.charAt(length - 1));
                sb.append(" at index ");
                sb.append(i + n);
                throw new ArrayIndexOutOfBoundsException(sb.toString());
            }
            n = 0;
            char c;
            long n4;
            while (true) {
                c = '\u0080';
                n4 = 1L;
                if (n >= length) {
                    break;
                }
                i = charSequence.charAt(n);
                if (i >= 128) {
                    break;
                }
                q0.M(array, n2, (byte)i);
                ++n;
                ++n2;
            }
            i = n;
            long n5 = n2;
            if (n == length) {
                return (int)n2;
            }
            while (i < length) {
                final char char1 = charSequence.charAt(i);
                long n8 = 0L;
                Label_0523: {
                    if (char1 < c && n5 < n3) {
                        q0.M(array, n5, (byte)char1);
                        final long n6 = n4;
                        final long n7 = n5 + n4;
                        n = i;
                        n4 = n6;
                        i = c;
                        n8 = n7;
                    }
                    else if (char1 < '\u0800' && n5 <= n3 - 2L) {
                        final long n9 = n5 + n4;
                        q0.M(array, n5, (byte)(char1 >>> 6 | 0x3C0));
                        q0.M(array, n9, (byte)((char1 & '?') | 0x80));
                        final int n10 = 128;
                        n8 = n9 + n4;
                        n = i;
                        i = n10;
                    }
                    else if ((char1 < '\ud800' || '\udfff' < char1) && n5 <= n3 - 3L) {
                        final long n11 = n5 + n4;
                        q0.M(array, n5, (byte)(char1 >>> 12 | 0x1E0));
                        final long n12 = n11 + n4;
                        q0.M(array, n11, (byte)((char1 >>> 6 & 0x3F) | 0x80));
                        q0.M(array, n12, (byte)((char1 & '?') | 0x80));
                        n8 = n12 + 1L;
                        n4 = 1L;
                        final int n13 = 128;
                        n = i;
                        i = n13;
                    }
                    else {
                        if (n5 <= n3 - 4L) {
                            n = i + 1;
                            if (n != length) {
                                final char char2 = charSequence.charAt(n);
                                if (Character.isSurrogatePair(char1, char2)) {
                                    final int codePoint = Character.toCodePoint(char1, char2);
                                    final long n14 = n5 + 1L;
                                    q0.M(array, n5, (byte)(codePoint >>> 18 | 0xF0));
                                    final long n15 = n14 + 1L;
                                    i = 128;
                                    q0.M(array, n14, (byte)((codePoint >>> 12 & 0x3F) | 0x80));
                                    final long n16 = n15 + 1L;
                                    q0.M(array, n15, (byte)((codePoint >>> 6 & 0x3F) | 0x80));
                                    n4 = 1L;
                                    n8 = n16 + 1L;
                                    q0.M(array, n16, (byte)((codePoint & 0x3F) | 0x80));
                                    break Label_0523;
                                }
                                i = n;
                            }
                            throw new UnpairedSurrogateException(i - 1, length);
                        }
                        if ('\ud800' <= char1 && char1 <= '\udfff') {
                            n = i + 1;
                            if (n == length || !Character.isSurrogatePair(char1, charSequence.charAt(n))) {
                                throw new UnpairedSurrogateException(i, length);
                            }
                        }
                        final StringBuilder sb2 = new StringBuilder();
                        sb2.append("Failed writing ");
                        sb2.append(char1);
                        sb2.append(" at index ");
                        sb2.append(n5);
                        throw new ArrayIndexOutOfBoundsException(sb2.toString());
                    }
                }
                ++n;
                c = (char)i;
                i = n;
                n5 = n8;
            }
            return (int)n5;
        }
        
        @Override
        int i(int v, final byte[] array, int v2, int v3) {
            final int length = array.length;
            final int n = 0;
            if ((v2 | v3 | length - v3) >= 0) {
                long n2 = v2;
                final long n3 = v3;
                long n4 = n2;
                if (v != 0) {
                    if (n2 >= n3) {
                        return v;
                    }
                    final byte b = (byte)v;
                    if (b < -32) {
                        if (b < -62 || q0.v(array, n2) > -65) {
                            return -1;
                        }
                        n4 = 1L + n2;
                    }
                    else {
                        long n6 = 0L;
                        Label_0195: {
                            if (b < -16) {
                                v2 = (byte)~(v >> 8);
                                long n5 = n2;
                                if ((v = v2) == 0) {
                                    n5 = n2 + 1L;
                                    v = q0.v(array, n2);
                                    if (n5 >= n3) {
                                        return Utf8.a(b, v);
                                    }
                                }
                                if (v <= -65 && (b != -32 || v >= -96) && (b != -19 || v < -96)) {
                                    n6 = n5 + 1L;
                                    if (q0.v(array, n5) <= -65) {
                                        break Label_0195;
                                    }
                                }
                                return -1;
                            }
                            v2 = (byte)~(v >> 8);
                            if (v2 == 0) {
                                final long n7 = n2 + 1L;
                                v2 = q0.v(array, n2);
                                if (n7 >= n3) {
                                    return Utf8.a(b, v2);
                                }
                                n2 = n7;
                                v = n;
                            }
                            else {
                                v = (byte)(v >> 16);
                            }
                            v3 = v;
                            long n8 = n2;
                            if (v == 0) {
                                n8 = n2 + 1L;
                                v3 = q0.v(array, n2);
                                if (n8 >= n3) {
                                    return Utf8.b(b, v2, v3);
                                }
                            }
                            if (v2 <= -65 && (b << 28) + (v2 + 112) >> 30 == 0 && v3 <= -65) {
                                n6 = n8 + 1L;
                                if (q0.v(array, n8) <= -65) {
                                    break Label_0195;
                                }
                            }
                            return -1;
                        }
                        n4 = n6;
                    }
                }
                return o(array, n4, (int)(n3 - n4));
            }
            throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", array.length, v2, v3));
        }
        
        @Override
        int l(int u, final ByteBuffer byteBuffer, int u2, int u3) {
            final int limit = byteBuffer.limit();
            final int n = 0;
            if ((u2 | u3 | limit - u3) >= 0) {
                long n2 = q0.i(byteBuffer) + u2;
                final long n3 = u3 - u2 + n2;
                long n4 = n2;
                if (u != 0) {
                    if (n2 >= n3) {
                        return u;
                    }
                    final byte b = (byte)u;
                    if (b < -32) {
                        if (b < -62 || q0.u(n2) > -65) {
                            return -1;
                        }
                        n4 = 1L + n2;
                    }
                    else {
                        long n6 = 0L;
                        Label_0204: {
                            if (b < -16) {
                                u2 = (byte)~(u >> 8);
                                long n5 = n2;
                                if ((u = u2) == 0) {
                                    n5 = n2 + 1L;
                                    u = q0.u(n2);
                                    if (n5 >= n3) {
                                        return Utf8.a(b, u);
                                    }
                                }
                                if (u <= -65 && (b != -32 || u >= -96) && (b != -19 || u < -96)) {
                                    n6 = n5 + 1L;
                                    if (q0.u(n5) <= -65) {
                                        break Label_0204;
                                    }
                                }
                                return -1;
                            }
                            u2 = (byte)~(u >> 8);
                            if (u2 == 0) {
                                final long n7 = n2 + 1L;
                                u2 = q0.u(n2);
                                if (n7 >= n3) {
                                    return Utf8.a(b, u2);
                                }
                                n2 = n7;
                                u = n;
                            }
                            else {
                                u = (byte)(u >> 16);
                            }
                            u3 = u;
                            long n8 = n2;
                            if (u == 0) {
                                n8 = n2 + 1L;
                                u3 = q0.u(n2);
                                if (n8 >= n3) {
                                    return Utf8.b(b, u2, u3);
                                }
                            }
                            if (u2 <= -65 && (b << 28) + (u2 + 112) >> 30 == 0 && u3 <= -65) {
                                n6 = n8 + 1L;
                                if (q0.u(n8) <= -65) {
                                    break Label_0204;
                                }
                            }
                            return -1;
                        }
                        n4 = n6;
                    }
                }
                return n(n4, (int)(n3 - n4));
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", byteBuffer.limit(), u2, u3));
        }
    }
}
