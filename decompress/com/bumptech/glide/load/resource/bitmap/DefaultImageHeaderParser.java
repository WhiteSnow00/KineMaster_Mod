// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load.resource.bitmap;

import java.io.InputStream;
import v2.k;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.io.IOException;
import android.util.Log;
import e2.b;
import java.nio.charset.Charset;
import com.bumptech.glide.load.ImageHeaderParser;

public final class DefaultImageHeaderParser implements ImageHeaderParser
{
    static final byte[] a;
    private static final int[] b;
    
    static {
        a = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));
        b = new int[] { 0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8 };
    }
    
    private static int e(final int n, final int n2) {
        return n + 2 + n2 * 12;
    }
    
    private int f(final Reader reader, final e2.b b) throws IOException {
        try {
            final int g = reader.g();
            if (!h(g)) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Parser doesn't handle magic number: ");
                    sb.append(g);
                    Log.d("DfltImageHeaderParser", sb.toString());
                }
                return -1;
            }
            final int j = this.j(reader);
            if (j == -1) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");
                }
                return -1;
            }
            final byte[] array = b.c(j, byte[].class);
            try {
                return this.l(reader, array, j);
            }
            finally {
                b.put(array);
            }
        }
        catch (final Reader.EndOfFileException ex) {
            return -1;
        }
    }
    
    private ImageType g(final Reader reader) throws IOException {
        try {
            final int g = reader.g();
            if (g == 65496) {
                return ImageType.JPEG;
            }
            final int n = g << 8 | reader.i();
            if (n == 4671814) {
                return ImageType.GIF;
            }
            final int n2 = n << 8 | reader.i();
            if (n2 == -1991225785) {
                reader.f(21L);
                try {
                    ImageType imageType;
                    if (reader.i() >= 3) {
                        imageType = ImageType.PNG_A;
                    }
                    else {
                        imageType = ImageType.PNG;
                    }
                    return imageType;
                }
                catch (final Reader.EndOfFileException ex) {
                    return ImageType.PNG;
                }
            }
            if (n2 != 1380533830) {
                ImageType imageType2;
                if (this.m(reader, n2)) {
                    imageType2 = ImageType.AVIF;
                }
                else {
                    imageType2 = ImageType.UNKNOWN;
                }
                return imageType2;
            }
            reader.f(4L);
            if ((reader.g() << 16 | reader.g()) != 0x57454250) {
                return ImageType.UNKNOWN;
            }
            final int n3 = reader.g() << 16 | reader.g();
            if ((n3 & 0xFFFFFF00) != 0x56503800) {
                return ImageType.UNKNOWN;
            }
            final int n4 = n3 & 0xFF;
            if (n4 == 88) {
                reader.f(4L);
                final short i = reader.i();
                if ((i & 0x2) != 0x0) {
                    return ImageType.ANIMATED_WEBP;
                }
                if ((i & 0x10) != 0x0) {
                    return ImageType.WEBP_A;
                }
                return ImageType.WEBP;
            }
            else {
                if (n4 == 76) {
                    reader.f(4L);
                    ImageType imageType3;
                    if ((reader.i() & 0x8) != 0x0) {
                        imageType3 = ImageType.WEBP_A;
                    }
                    else {
                        imageType3 = ImageType.WEBP;
                    }
                    return imageType3;
                }
                return ImageType.WEBP;
            }
        }
        catch (final Reader.EndOfFileException ex2) {
            return ImageType.UNKNOWN;
        }
    }
    
    private static boolean h(final int n) {
        return (n & 0xFFD8) == 0xFFD8 || n == 19789 || n == 18761;
    }
    
    private boolean i(final byte[] array, int n) {
        final boolean b = false;
        boolean b2 = array != null && n > DefaultImageHeaderParser.a.length;
        if (b2) {
            n = 0;
            while (true) {
                final byte[] a = DefaultImageHeaderParser.a;
                if (n >= a.length) {
                    break;
                }
                if (array[n] != a[n]) {
                    b2 = b;
                    break;
                }
                ++n;
            }
        }
        return b2;
    }
    
    private int j(final Reader reader) throws IOException {
        long f;
        long n;
        short j;
        int n2;
        do {
            final short i = reader.i();
            if (i != 255) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Unknown segmentId=");
                    sb.append(i);
                    Log.d("DfltImageHeaderParser", sb.toString());
                }
                return -1;
            }
            j = reader.i();
            if (j == 218) {
                return -1;
            }
            if (j == 217) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Found MARKER_EOI in exif segment");
                }
                return -1;
            }
            n2 = reader.g() - 2;
            if (j == 225) {
                return n2;
            }
            n = n2;
            f = reader.f(n);
        } while (f == n);
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Unable to skip enough data, type: ");
            sb2.append(j);
            sb2.append(", wanted to skip: ");
            sb2.append(n2);
            sb2.append(", but actually skipped: ");
            sb2.append(f);
            Log.d("DfltImageHeaderParser", sb2.toString());
        }
        return -1;
    }
    
    private static int k(final b b) {
        final short a = b.a(6);
        ByteOrder byteOrder;
        if (a != 18761) {
            if (a != 19789) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Unknown endianness = ");
                    sb.append(a);
                    Log.d("DfltImageHeaderParser", sb.toString());
                }
                byteOrder = ByteOrder.BIG_ENDIAN;
            }
            else {
                byteOrder = ByteOrder.BIG_ENDIAN;
            }
        }
        else {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        }
        b.e(byteOrder);
        final int n = b.b(10) + 6;
        for (short a2 = b.a(n), n2 = 0; n2 < a2; ++n2) {
            final int e = e(n, n2);
            final short a3 = b.a(e);
            if (a3 == 274) {
                final short a4 = b.a(e + 2);
                if (a4 >= 1 && a4 <= 12) {
                    final int b2 = b.b(e + 4);
                    if (b2 < 0) {
                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Negative tiff component count");
                        }
                    }
                    else {
                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            final StringBuilder sb2 = new StringBuilder();
                            sb2.append("Got tagIndex=");
                            sb2.append(n2);
                            sb2.append(" tagType=");
                            sb2.append(a3);
                            sb2.append(" formatCode=");
                            sb2.append(a4);
                            sb2.append(" componentCount=");
                            sb2.append(b2);
                            Log.d("DfltImageHeaderParser", sb2.toString());
                        }
                        final int n3 = b2 + DefaultImageHeaderParser.b[a4];
                        if (n3 > 4) {
                            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                final StringBuilder sb3 = new StringBuilder();
                                sb3.append("Got byte count > 4, not orientation, continuing, formatCode=");
                                sb3.append(a4);
                                Log.d("DfltImageHeaderParser", sb3.toString());
                            }
                        }
                        else {
                            final int n4 = e + 8;
                            if (n4 >= 0 && n4 <= b.d()) {
                                if (n3 >= 0 && n3 + n4 <= b.d()) {
                                    return b.a(n4);
                                }
                                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    final StringBuilder sb4 = new StringBuilder();
                                    sb4.append("Illegal number of bytes for TI tag data tagType=");
                                    sb4.append(a3);
                                    Log.d("DfltImageHeaderParser", sb4.toString());
                                }
                            }
                            else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                final StringBuilder sb5 = new StringBuilder();
                                sb5.append("Illegal tagValueOffset=");
                                sb5.append(n4);
                                sb5.append(" tagType=");
                                sb5.append(a3);
                                Log.d("DfltImageHeaderParser", sb5.toString());
                            }
                        }
                    }
                }
                else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    final StringBuilder sb6 = new StringBuilder();
                    sb6.append("Got invalid format code = ");
                    sb6.append(a4);
                    Log.d("DfltImageHeaderParser", sb6.toString());
                }
            }
        }
        return -1;
    }
    
    private int l(final Reader reader, final byte[] array, final int n) throws IOException {
        final int h = reader.h(array, n);
        if (h != n) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Unable to read exif segment data, length: ");
                sb.append(n);
                sb.append(", actually read: ");
                sb.append(h);
                Log.d("DfltImageHeaderParser", sb.toString());
            }
            return -1;
        }
        if (this.i(array, n)) {
            return k(new b(array, n));
        }
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            Log.d("DfltImageHeaderParser", "Missing jpeg exif preamble");
        }
        return -1;
    }
    
    private boolean m(final Reader reader, int n) throws IOException {
        if ((reader.g() << 16 | reader.g()) != 0x66747970) {
            return false;
        }
        final int n2 = reader.g() << 16 | reader.g();
        if (n2 == 1635150182 || n2 == 1635150195) {
            return true;
        }
        reader.f(4L);
        n -= 16;
        if (n % 4 != 0) {
            return false;
        }
        for (int n3 = 0; n3 < 5 && n > 0; ++n3, n -= 4) {
            final int n4 = reader.g() << 16 | reader.g();
            if (n4 == 1635150182 || n4 == 1635150195) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public ImageType a(final ByteBuffer byteBuffer) throws IOException {
        return this.g((Reader)new a(k.d(byteBuffer)));
    }
    
    @Override
    public int b(final ByteBuffer byteBuffer, final e2.b b) throws IOException {
        return this.f((Reader)new a(k.d(byteBuffer)), k.d(b));
    }
    
    @Override
    public ImageType c(final InputStream inputStream) throws IOException {
        return this.g((Reader)new c(k.d(inputStream)));
    }
    
    @Override
    public int d(final InputStream inputStream, final e2.b b) throws IOException {
        return this.f((Reader)new c(k.d(inputStream)), k.d(b));
    }
    
    private interface Reader
    {
        long f(final long p0) throws IOException;
        
        int g() throws IOException;
        
        int h(final byte[] p0, final int p1) throws IOException;
        
        short i() throws IOException;
        
        public static final class EndOfFileException extends IOException
        {
            private static final long serialVersionUID = 1L;
            
            EndOfFileException() {
                super("Unexpectedly reached end of a file");
            }
        }
    }
    
    private static final class a implements Reader
    {
        private final ByteBuffer a;
        
        a(final ByteBuffer a) {
            (this.a = a).order(ByteOrder.BIG_ENDIAN);
        }
        
        @Override
        public long f(final long n) {
            final int n2 = (int)Math.min(this.a.remaining(), n);
            final ByteBuffer a = this.a;
            a.position(a.position() + n2);
            return n2;
        }
        
        @Override
        public int g() throws EndOfFileException {
            return this.i() << 8 | this.i();
        }
        
        @Override
        public int h(final byte[] array, int min) {
            min = Math.min(min, this.a.remaining());
            if (min == 0) {
                return -1;
            }
            this.a.get(array, 0, min);
            return min;
        }
        
        @Override
        public short i() throws EndOfFileException {
            if (this.a.remaining() >= 1) {
                return (short)(this.a.get() & 0xFF);
            }
            throw new EndOfFileException();
        }
    }
    
    private static final class b
    {
        private final ByteBuffer a;
        
        b(final byte[] array, final int n) {
            this.a = (ByteBuffer)ByteBuffer.wrap(array).order(ByteOrder.BIG_ENDIAN).limit(n);
        }
        
        private boolean c(final int n, final int n2) {
            return this.a.remaining() - n >= n2;
        }
        
        short a(final int n) {
            short short1;
            if (this.c(n, 2)) {
                short1 = this.a.getShort(n);
            }
            else {
                short1 = -1;
            }
            return short1;
        }
        
        int b(int int1) {
            if (this.c(int1, 4)) {
                int1 = this.a.getInt(int1);
            }
            else {
                int1 = -1;
            }
            return int1;
        }
        
        int d() {
            return this.a.remaining();
        }
        
        void e(final ByteOrder byteOrder) {
            this.a.order(byteOrder);
        }
    }
    
    private static final class c implements Reader
    {
        private final InputStream a;
        
        c(final InputStream a) {
            this.a = a;
        }
        
        @Override
        public long f(final long n) throws IOException {
            if (n < 0L) {
                return 0L;
            }
            long n2;
            long skip;
            for (n2 = n; n2 > 0L; n2 -= skip) {
                skip = this.a.skip(n2);
                if (skip <= 0L) {
                    if (this.a.read() == -1) {
                        break;
                    }
                    skip = 1L;
                }
            }
            return n - n2;
        }
        
        @Override
        public int g() throws IOException {
            return this.i() << 8 | this.i();
        }
        
        @Override
        public int h(final byte[] array, final int n) throws IOException {
            int n2 = 0;
            int read = 0;
            int n3;
            while (true) {
                n3 = read;
                if (n2 >= n) {
                    break;
                }
                read = this.a.read(array, n2, n - n2);
                if ((n3 = read) == -1) {
                    break;
                }
                n2 += read;
            }
            if (n2 == 0 && n3 == -1) {
                throw new EndOfFileException();
            }
            return n2;
        }
        
        @Override
        public short i() throws IOException {
            final int read = this.a.read();
            if (read != -1) {
                return (short)read;
            }
            throw new EndOfFileException();
        }
    }
}
