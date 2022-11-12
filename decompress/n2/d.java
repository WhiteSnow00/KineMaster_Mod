// 
// Decompiled by Procyon v0.6.0
// 

package n2;

import java.io.IOException;
import android.util.Log;
import v2.a;
import com.bumptech.glide.load.engine.s;
import java.io.File;
import com.bumptech.glide.load.EncodeStrategy;
import c2.e;
import c2.g;

public class d implements g<c>
{
    @Override
    public EncodeStrategy a(final e e) {
        return EncodeStrategy.SOURCE;
    }
    
    @Override
    public /* bridge */ boolean b(final Object o, final File file, final e e) {
        return this.c((s<c>)o, file, e);
    }
    
    public boolean c(final s<c> s, final File file, final e e) {
        final c c = s.get();
        boolean b;
        try {
            v2.a.f(c.c(), file);
            b = true;
        }
        catch (final IOException ex) {
            if (Log.isLoggable("GifEncoder", 5)) {
                Log.w("GifEncoder", "Failed to encode GIF drawable data", (Throwable)ex);
            }
            b = false;
        }
        return b;
    }
}
