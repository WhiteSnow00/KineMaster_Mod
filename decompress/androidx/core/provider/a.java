// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.provider;

import android.graphics.Typeface;
import android.os.Handler;

class a
{
    private final g.c a;
    private final Handler b;
    
    a(final g.c a, final Handler b) {
        this.a = a;
        this.b = b;
    }
    
    private void a(final int n) {
        this.b.post((Runnable)new Runnable(this, this.a, n) {
            final g.c a;
            final int b;
            final a c;
            
            @Override
            public void run() {
                this.a.a(this.b);
            }
        });
    }
    
    private void c(final Typeface typeface) {
        this.b.post((Runnable)new Runnable(this, this.a, typeface) {
            final g.c a;
            final Typeface b;
            final a c;
            
            @Override
            public void run() {
                this.a.b(this.b);
            }
        });
    }
    
    void b(final f.e e) {
        if (e.a()) {
            this.c(e.a);
        }
        else {
            this.a(e.b);
        }
    }
}
