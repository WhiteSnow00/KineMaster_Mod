// 
// Decompiled by Procyon v0.6.0
// 

package androidx.lifecycle;

@Deprecated
class ReflectiveGenericLifecycleObserver implements o
{
    private final Object a;
    private final c.a b;
    
    ReflectiveGenericLifecycleObserver(final Object a) {
        this.a = a;
        this.b = c.c.c(a.getClass());
    }
    
    @Override
    public void f(final r r, final Lifecycle.Event event) {
        this.b.a(r, event, this.a);
    }
}
