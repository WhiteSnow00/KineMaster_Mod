// 
// Decompiled by Procyon v0.6.0
// 

package androidx.recyclerview.widget;

public class e implements p
{
    final p a;
    int b;
    int c;
    int d;
    Object e;
    
    public e(final p a) {
        this.b = 0;
        this.c = -1;
        this.d = -1;
        this.e = null;
        this.a = a;
    }
    
    @Override
    public void a(final int c, final int d) {
        if (this.b == 1) {
            final int c2 = this.c;
            if (c >= c2) {
                final int d2 = this.d;
                if (c <= c2 + d2) {
                    this.d = d2 + d;
                    this.c = Math.min(c, c2);
                    return;
                }
            }
        }
        this.e();
        this.c = c;
        this.d = d;
        this.b = 1;
    }
    
    @Override
    public void b(final int n, final int d) {
        if (this.b == 2) {
            final int c = this.c;
            if (c >= n && c <= n + d) {
                this.d += d;
                this.c = n;
                return;
            }
        }
        this.e();
        this.c = n;
        this.d = d;
        this.b = 2;
    }
    
    @Override
    public void c(final int c, final int d, final Object e) {
        if (this.b == 3) {
            final int c2 = this.c;
            final int d2 = this.d;
            if (c <= c2 + d2) {
                final int n = c + d;
                if (n >= c2 && this.e == e) {
                    this.c = Math.min(c, c2);
                    this.d = Math.max(d2 + c2, n) - this.c;
                    return;
                }
            }
        }
        this.e();
        this.c = c;
        this.d = d;
        this.e = e;
        this.b = 3;
    }
    
    @Override
    public void d(final int n, final int n2) {
        this.e();
        this.a.d(n, n2);
    }
    
    public void e() {
        final int b = this.b;
        if (b == 0) {
            return;
        }
        if (b != 1) {
            if (b != 2) {
                if (b == 3) {
                    this.a.c(this.c, this.d, this.e);
                }
            }
            else {
                this.a.b(this.c, this.d);
            }
        }
        else {
            this.a.a(this.c, this.d);
        }
        this.e = null;
        this.b = 0;
    }
}
