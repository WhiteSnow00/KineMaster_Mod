// 
// Decompiled by Procyon v0.6.0
// 

package androidx.lifecycle;

class FullLifecycleObserverAdapter implements o
{
    private final i a;
    private final o b;
    
    FullLifecycleObserverAdapter(final i a, final o b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public void f(final r r, final Lifecycle.Event event) {
        switch (FullLifecycleObserverAdapter$a.a[event.ordinal()]) {
            case 7: {
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
            }
            case 6: {
                this.a.d(r);
                break;
            }
            case 5: {
                this.a.c(r);
                break;
            }
            case 4: {
                this.a.b(r);
                break;
            }
            case 3: {
                this.a.i(r);
                break;
            }
            case 2: {
                this.a.e(r);
                break;
            }
            case 1: {
                this.a.a(r);
                break;
            }
        }
        final o b = this.b;
        if (b != null) {
            b.f(r, event);
        }
    }
}
