// 
// Decompiled by Procyon v0.6.0
// 

package f2;

import java.io.File;
import android.content.Context;

public final class f extends d
{
    public f(final Context context) {
        this(context, "image_manager_disk_cache", 262144000L);
    }
    
    public f(final Context context, final String s, final long n) {
        super((a)new a(context, s) {
            final Context a;
            final String b;
            
            @Override
            public File a() {
                final File cacheDir = this.a.getCacheDir();
                if (cacheDir == null) {
                    return null;
                }
                if (this.b != null) {
                    return new File(cacheDir, this.b);
                }
                return cacheDir;
            }
        }, n);
    }
}
