// 
// Decompiled by Procyon v0.6.0
// 

package n2;

import l2.c;

public class e extends c<n2.c>
{
    public e(final n2.c c) {
        super(c);
    }
    
    @Override
    public int a() {
        return ((n2.c)super.a).i();
    }
    
    @Override
    public void b() {
        ((n2.c)super.a).stop();
        ((n2.c)super.a).k();
    }
    
    @Override
    public Class<n2.c> c() {
        return n2.c.class;
    }
    
    @Override
    public void initialize() {
        ((n2.c)super.a).e().prepareToDraw();
    }
}
