// 
// Decompiled by Procyon v0.6.0
// 

package t2;

import com.bumptech.glide.load.DataSource;
import android.graphics.drawable.Drawable;

public class a implements e<Drawable>
{
    private final int a;
    private final boolean b;
    private b c;
    
    protected a(final int a, final boolean b) {
        this.a = a;
        this.b = b;
    }
    
    private d<Drawable> b() {
        if (this.c == null) {
            this.c = new b(this.a, this.b);
        }
        return this.c;
    }
    
    @Override
    public d<Drawable> a(final DataSource dataSource, final boolean b) {
        Object o;
        if (dataSource == DataSource.MEMORY_CACHE) {
            o = t2.c.b();
        }
        else {
            o = this.b();
        }
        return (d<Drawable>)o;
    }
    
    public static class a
    {
        private final int a;
        private boolean b;
        
        public a() {
            this(300);
        }
        
        public a(final int a) {
            this.a = a;
        }
        
        public t2.a a() {
            return new t2.a(this.a, this.b);
        }
    }
}
