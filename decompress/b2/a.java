// 
// Decompiled by Procyon v0.6.0
// 

package b2;

import android.graphics.Bitmap$Config;
import android.graphics.Bitmap;
import java.nio.ByteBuffer;

public interface a
{
    ByteBuffer a();
    
    Bitmap b();
    
    void c();
    
    void clear();
    
    int d();
    
    void e(final Bitmap$Config p0);
    
    int f();
    
    int g();
    
    void h();
    
    int i();
    
    int j();
    
    public interface a
    {
        void a(final Bitmap p0);
        
        byte[] b(final int p0);
        
        Bitmap c(final int p0, final int p1, final Bitmap$Config p2);
        
        int[] d(final int p0);
        
        void e(final byte[] p0);
        
        void f(final int[] p0);
    }
}
