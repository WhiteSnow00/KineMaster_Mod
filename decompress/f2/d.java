// 
// Decompiled by Procyon v0.6.0
// 

package f2;

import java.io.File;

public class d implements f2.a.a
{
    private final long a;
    private final a b;
    
    public d(final a b, final long a) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public f2.a build() {
        final File a = this.b.a();
        if (a == null) {
            return null;
        }
        if (!a.isDirectory() && !a.mkdirs()) {
            return null;
        }
        return e.c(a, this.a);
    }
    
    public interface a
    {
        File a();
    }
}
