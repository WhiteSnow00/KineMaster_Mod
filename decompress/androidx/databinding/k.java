// 
// Decompiled by Procyon v0.6.0
// 

package androidx.databinding;

public class k extends c<h.a, h, Void>
{
    private static final a<h.a, h, Void> f;
    
    static {
        f = new a<h.a, h, Void>() {
            @Override
            public /* bridge */ void a(final Object o, final Object o2, final int n, final Object o3) {
                this.b((h.a)o, (h)o2, n, (Void)o3);
            }
            
            public void b(final h.a a, final h h, final int n, final Void void1) {
                a.a(h, n);
            }
        };
    }
    
    public k() {
        super(k.f);
    }
}
