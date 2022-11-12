// 
// Decompiled by Procyon v0.6.0
// 

package androidx.room;

import java.io.InputStream;
import java.util.concurrent.Callable;
import java.io.File;
import v0.h;

class w0 implements c
{
    private final String a;
    private final File b;
    private final Callable<InputStream> c;
    private final c d;
    
    w0(final String a, final File b, final Callable<InputStream> c, final c d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    @Override
    public h a(final b b) {
        return new v0(b.a, this.a, this.b, this.c, b.c.a, this.d.a(b));
    }
}
