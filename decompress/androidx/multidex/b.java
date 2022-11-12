// 
// Decompiled by Procyon v0.6.0
// 

package androidx.multidex;

import java.io.File;
import java.util.zip.ZipException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.io.RandomAccessFile;

final class b
{
    static long a(final RandomAccessFile randomAccessFile, final a a) throws IOException {
        final CRC32 crc32 = new CRC32();
        long b = a.b;
        randomAccessFile.seek(a.a);
        final int n = (int)Math.min(16384L, b);
        final byte[] array = new byte[16384];
        for (int i = randomAccessFile.read(array, 0, n); i != -1; i = randomAccessFile.read(array, 0, (int)Math.min(16384L, b))) {
            crc32.update(array, 0, i);
            b -= i;
            if (b == 0L) {
                break;
            }
        }
        return crc32.getValue();
    }
    
    static a b(final RandomAccessFile randomAccessFile) throws IOException, ZipException {
        long n = randomAccessFile.length() - 22L;
        long n2 = 0L;
        if (n < 0L) {
            final StringBuilder sb = new StringBuilder();
            sb.append("File too short to be a zip file: ");
            sb.append(randomAccessFile.length());
            throw new ZipException(sb.toString());
        }
        final long n3 = n - 65536L;
        if (n3 >= 0L) {
            n2 = n3;
        }
        final int reverseBytes = Integer.reverseBytes(101010256);
        while (true) {
            randomAccessFile.seek(n);
            if (randomAccessFile.readInt() == reverseBytes) {
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                final a a = new a();
                a.b = ((long)Integer.reverseBytes(randomAccessFile.readInt()) & 0xFFFFFFFFL);
                a.a = ((long)Integer.reverseBytes(randomAccessFile.readInt()) & 0xFFFFFFFFL);
                return a;
            }
            --n;
            if (n >= n2) {
                continue;
            }
            throw new ZipException("End Of Central Directory signature not found");
        }
    }
    
    static long c(File file) throws IOException {
        file = (File)new RandomAccessFile(file, "r");
        try {
            return a((RandomAccessFile)file, b((RandomAccessFile)file));
        }
        finally {
            ((RandomAccessFile)file).close();
        }
    }
    
    static class a
    {
        long a;
        long b;
    }
}
