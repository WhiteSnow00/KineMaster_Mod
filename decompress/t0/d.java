// 
// Decompiled by Procyon v0.6.0
// 

package t0;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

public class d
{
    public static void a(final ReadableByteChannel readableByteChannel, final FileChannel fileChannel) throws IOException {
        try {
            fileChannel.transferFrom(readableByteChannel, 0L, Long.MAX_VALUE);
            fileChannel.force(false);
        }
        finally {
            readableByteChannel.close();
            fileChannel.close();
        }
    }
}
