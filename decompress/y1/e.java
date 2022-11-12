// 
// Decompiled by Procyon v0.6.0
// 

package y1;

import android.view.Choreographer;
import com.airbnb.lottie.c;
import com.airbnb.lottie.d;
import android.view.Choreographer$FrameCallback;

public class e extends a implements Choreographer$FrameCallback
{
    private float c;
    private boolean d;
    private long e;
    private float f;
    private int g;
    private float h;
    private float i;
    private d j;
    protected boolean p;
    
    public e() {
        this.c = 1.0f;
        this.d = false;
        this.e = 0L;
        this.f = 0.0f;
        this.g = 0;
        this.h = -2.14748365E9f;
        this.i = 2.14748365E9f;
        this.p = false;
    }
    
    private void F() {
        if (this.j == null) {
            return;
        }
        final float f = this.f;
        if (f >= this.h && f <= this.i) {
            return;
        }
        throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", this.h, this.i, this.f));
    }
    
    private float l() {
        final d j = this.j;
        if (j == null) {
            return Float.MAX_VALUE;
        }
        return 1.0E9f / j.h() / Math.abs(this.c);
    }
    
    private boolean p() {
        return this.o() < 0.0f;
    }
    
    public void A(final float n) {
        if (this.f == n) {
            return;
        }
        this.f = y1.g.c(n, this.n(), this.m());
        this.e = 0L;
        this.f();
    }
    
    public void B(final float n) {
        this.C(this.h, n);
    }
    
    public void C(final float n, final float n2) {
        if (n <= n2) {
            final d j = this.j;
            float o;
            if (j == null) {
                o = -3.4028235E38f;
            }
            else {
                o = j.o();
            }
            final d i = this.j;
            float f;
            if (i == null) {
                f = Float.MAX_VALUE;
            }
            else {
                f = i.f();
            }
            this.h = y1.g.c(n, o, f);
            this.i = y1.g.c(n2, o, f);
            this.A((float)(int)y1.g.c(this.f, n, n2));
            return;
        }
        throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", n, n2));
    }
    
    public void D(final int n) {
        this.C((float)n, (float)(int)this.i);
    }
    
    public void E(final float c) {
        this.c = c;
    }
    
    public void cancel() {
        this.b();
        this.v();
    }
    
    public void doFrame(final long n) {
        this.u();
        if (this.j != null) {
            if (this.isRunning()) {
                com.airbnb.lottie.c.a("LottieValueAnimator#doFrame");
                final long e = this.e;
                long n2 = 0L;
                if (e != 0L) {
                    n2 = n - e;
                }
                final float n3 = n2 / this.l();
                final float f = this.f;
                float n4 = n3;
                if (this.p()) {
                    n4 = -n3;
                }
                final float f2 = f + n4;
                this.f = f2;
                final boolean e2 = y1.g.e(f2, this.n(), this.m());
                this.f = y1.g.c(this.f, this.n(), this.m());
                this.e = n;
                this.f();
                if (e2 ^ true) {
                    if (this.getRepeatCount() != -1 && this.g >= this.getRepeatCount()) {
                        float f3;
                        if (this.c < 0.0f) {
                            f3 = this.n();
                        }
                        else {
                            f3 = this.m();
                        }
                        this.f = f3;
                        this.v();
                        this.c(this.p());
                    }
                    else {
                        this.d();
                        ++this.g;
                        if (this.getRepeatMode() == 2) {
                            this.d ^= true;
                            this.y();
                        }
                        else {
                            float f4;
                            if (this.p()) {
                                f4 = this.m();
                            }
                            else {
                                f4 = this.n();
                            }
                            this.f = f4;
                        }
                        this.e = n;
                    }
                }
                this.F();
                com.airbnb.lottie.c.b("LottieValueAnimator#doFrame");
            }
        }
    }
    
    public void g() {
        this.j = null;
        this.h = -2.14748365E9f;
        this.i = 2.14748365E9f;
    }
    
    public float getAnimatedFraction() {
        if (this.j == null) {
            return 0.0f;
        }
        float n;
        float n2;
        float n3;
        if (this.p()) {
            n = this.m() - this.f;
            n2 = this.m();
            n3 = this.n();
        }
        else {
            n = this.f - this.n();
            n2 = this.m();
            n3 = this.n();
        }
        return n / (n2 - n3);
    }
    
    public Object getAnimatedValue() {
        return this.i();
    }
    
    public long getDuration() {
        final d j = this.j;
        long n;
        if (j == null) {
            n = 0L;
        }
        else {
            n = (long)j.d();
        }
        return n;
    }
    
    public void h() {
        this.v();
        this.c(this.p());
    }
    
    public float i() {
        final d j = this.j;
        if (j == null) {
            return 0.0f;
        }
        return (this.f - j.o()) / (this.j.f() - this.j.o());
    }
    
    public boolean isRunning() {
        return this.p;
    }
    
    public float j() {
        return this.f;
    }
    
    public float m() {
        final d j = this.j;
        if (j == null) {
            return 0.0f;
        }
        float n;
        if ((n = this.i) == 2.14748365E9f) {
            n = j.f();
        }
        return n;
    }
    
    public float n() {
        final d j = this.j;
        if (j == null) {
            return 0.0f;
        }
        float n;
        if ((n = this.h) == -2.14748365E9f) {
            n = j.o();
        }
        return n;
    }
    
    public float o() {
        return this.c;
    }
    
    public void q() {
        this.v();
    }
    
    public void r() {
        this.p = true;
        this.e(this.p());
        float n;
        if (this.p()) {
            n = this.m();
        }
        else {
            n = this.n();
        }
        this.A((float)(int)n);
        this.e = 0L;
        this.g = 0;
        this.u();
    }
    
    public void setRepeatMode(final int repeatMode) {
        super.setRepeatMode(repeatMode);
        if (repeatMode != 2 && this.d) {
            this.d = false;
            this.y();
        }
    }
    
    protected void u() {
        if (this.isRunning()) {
            this.w(false);
            Choreographer.getInstance().postFrameCallback((Choreographer$FrameCallback)this);
        }
    }
    
    protected void v() {
        this.w(true);
    }
    
    protected void w(final boolean b) {
        Choreographer.getInstance().removeFrameCallback((Choreographer$FrameCallback)this);
        if (b) {
            this.p = false;
        }
    }
    
    public void x() {
        this.p = true;
        this.u();
        this.e = 0L;
        if (this.p() && this.j() == this.n()) {
            this.f = this.m();
        }
        else if (!this.p() && this.j() == this.m()) {
            this.f = this.n();
        }
    }
    
    public void y() {
        this.E(-this.o());
    }
    
    public void z(final d j) {
        final boolean b = this.j == null;
        this.j = j;
        if (b) {
            this.C((float)(int)Math.max(this.h, j.o()), (float)(int)Math.min(this.i, j.f()));
        }
        else {
            this.C((float)(int)j.o(), (float)(int)j.f());
        }
        final float f = this.f;
        this.f = 0.0f;
        this.A((float)(int)f);
        this.f();
    }
}
