// 
// Decompiled by Procyon v0.6.0
// 

package h2;

import java.io.IOException;
import android.util.Log;
import c2.e;
import java.io.File;
import java.nio.ByteBuffer;
import c2.a;

public class c implements a<ByteBuffer>
{
    @Override
    public /* bridge */ boolean b(final Object o, final File file, final e e) {
        return this.c((ByteBuffer)o, file, e);
    }
    
    public boolean c(final ByteBuffer byteBuffer, final File file, final e e) {
        boolean b;
        try {
            v2.a.f(byteBuffer, file);
            b = true;
        }
        catch (final IOException ex) {
            if (Log.isLoggable("ByteBufferEncoder", 3)) {
                Log.d("ByteBufferEncoder", "Failed to write data", (Throwable)ex);
            }
            b = false;
        }
        return b;
    }
}
