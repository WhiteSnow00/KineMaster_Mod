// 
// Decompiled by Procyon v0.6.0
// 

package n2;

import com.bumptech.glide.load.a;
import com.bumptech.glide.load.engine.s;
import c2.e;
import java.io.IOException;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import e2.b;
import java.nio.ByteBuffer;
import com.bumptech.glide.load.ImageHeaderParser;
import java.util.List;
import java.io.InputStream;
import c2.f;

public class j implements f<InputStream, c>
{
    private final List<ImageHeaderParser> a;
    private final f<ByteBuffer, c> b;
    private final b c;
    
    public j(final List<ImageHeaderParser> a, final f<ByteBuffer, c> b, final b c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    private static byte[] e(final InputStream inputStream) {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            final byte[] array = new byte[16384];
            while (true) {
                final int read = inputStream.read(array);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(array, 0, read);
            }
            byteArrayOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        }
        catch (final IOException ex) {
            if (Log.isLoggable("StreamGifDecoder", 5)) {
                Log.w("StreamGifDecoder", "Error reading data from stream", (Throwable)ex);
            }
            return null;
        }
    }
    
    @Override
    public /* bridge */ s a(final Object o, final int n, final int n2, final e e) throws IOException {
        return this.c((InputStream)o, n, n2, e);
    }
    
    @Override
    public /* bridge */ boolean b(final Object o, final e e) throws IOException {
        return this.d((InputStream)o, e);
    }
    
    public s<c> c(final InputStream inputStream, final int n, final int n2, final e e) throws IOException {
        final byte[] e2 = e(inputStream);
        if (e2 == null) {
            return null;
        }
        return this.b.a(ByteBuffer.wrap(e2), n, n2, e);
    }
    
    public boolean d(final InputStream inputStream, final e e) throws IOException {
        return !e.c(i.b) && com.bumptech.glide.load.a.f(this.a, inputStream, this.c) == ImageHeaderParser.ImageType.GIF;
    }
}
