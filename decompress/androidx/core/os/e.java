// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.os;

import android.os.CancellationSignal;

public final class e
{
    private boolean a;
    private b b;
    private Object c;
    private boolean d;
    
    private void c() {
        while (true) {
            if (!this.d) {
                return;
            }
            try {
                this.wait();
                continue;
            }
            catch (final InterruptedException ex) {}
        }
    }
    
    public void a() {
        synchronized (this) {
            if (this.a) {
                return;
            }
            this.a = true;
            this.d = true;
            final b b = this.b;
            final Object c = this.c;
            monitorexit(this);
            Label_0051: {
                if (b == null) {
                    break Label_0051;
                }
                try {
                    b.a();
                    break Label_0051;
                }
                finally {
                    synchronized (this) {
                        this.d = false;
                        this.notifyAll();
                    }
                    while (true) {
                        e.a.a(c);
                        break Label_0051;
                        iftrue(Label_0082:)(c == null);
                        continue;
                    }
                }
            }
            synchronized (this) {
                this.d = false;
                this.notifyAll();
            }
        }
    }
    
    public void b(final b b) {
        synchronized (this) {
            this.c();
            if (this.b == b) {
                return;
            }
            this.b = b;
            if (this.a && b != null) {
                monitorexit(this);
                b.a();
            }
        }
    }
    
    static class a
    {
        static void a(final Object o) {
            ((CancellationSignal)o).cancel();
        }
        
        static CancellationSignal b() {
            return new CancellationSignal();
        }
    }
    
    public interface b
    {
        void a();
    }
}
