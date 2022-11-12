// 
// Decompiled by Procyon v0.6.0
// 

package e1;

public abstract class g
{
    public static g c() {
        return new g() {
            @Override
            public f a(final String s) {
                return null;
            }
        };
    }
    
    public abstract f a(final String p0);
    
    public final f b(final String s) {
        f f;
        if ((f = this.a(s)) == null) {
            f = e1.f.a(s);
        }
        return f;
    }
}
