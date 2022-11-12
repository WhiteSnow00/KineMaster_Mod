// 
// Decompiled by Procyon v0.6.0
// 

package androidx.lifecycle;

class SingleGeneratedAdapterObserver implements o
{
    private final j a;
    
    SingleGeneratedAdapterObserver(final j a) {
        this.a = a;
    }
    
    @Override
    public void f(final r r, final Lifecycle.Event event) {
        this.a.a(r, event, false, null);
        this.a.a(r, event, true, null);
    }
}
