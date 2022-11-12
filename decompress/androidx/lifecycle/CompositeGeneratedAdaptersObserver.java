// 
// Decompiled by Procyon v0.6.0
// 

package androidx.lifecycle;

class CompositeGeneratedAdaptersObserver implements o
{
    private final j[] a;
    
    CompositeGeneratedAdaptersObserver(final j[] a) {
        this.a = a;
    }
    
    @Override
    public void f(final r r, final Lifecycle.Event event) {
        final y y = new y();
        final j[] a = this.a;
        final int length = a.length;
        final int n = 0;
        for (int i = 0; i < length; ++i) {
            a[i].a(r, event, false, y);
        }
        final j[] a2 = this.a;
        for (int length2 = a2.length, j = n; j < length2; ++j) {
            a2[j].a(r, event, true, y);
        }
    }
}
