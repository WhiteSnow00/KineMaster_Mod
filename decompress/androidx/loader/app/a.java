// 
// Decompiled by Procyon v0.6.0
// 

package androidx.loader.app;

import android.os.Bundle;
import java.io.PrintWriter;
import java.io.FileDescriptor;
import androidx.lifecycle.r0;
import androidx.lifecycle.r;

public abstract class a
{
    public static <T extends r & r0> a b(final T t) {
        return new b(t, t.getViewModelStore());
    }
    
    @Deprecated
    public abstract void a(final String p0, final FileDescriptor p1, final PrintWriter p2, final String[] p3);
    
    public abstract <D> androidx.loader.content.b<D> c(final int p0, final Bundle p1, final a<D> p2);
    
    public abstract void d();
    
    public interface a<D>
    {
        void a(final androidx.loader.content.b<D> p0, final D p1);
        
        androidx.loader.content.b<D> b(final int p0, final Bundle p1);
        
        void c(final androidx.loader.content.b<D> p0);
    }
}
