// 
// Decompiled by Procyon v0.6.0
// 

package androidx.loader.content;

import java.io.PrintWriter;
import java.io.FileDescriptor;
import android.content.Context;

public class b<D>
{
    int a;
    b<D> b;
    a<D> c;
    Context d;
    boolean e;
    boolean f;
    boolean g;
    boolean h;
    boolean i;
    
    public b(final Context context) {
        this.e = false;
        this.f = false;
        this.g = true;
        this.h = false;
        this.i = false;
        this.d = context.getApplicationContext();
    }
    
    public void a() {
        this.f = true;
        this.j();
    }
    
    public boolean b() {
        return this.k();
    }
    
    public void c() {
        this.i = false;
    }
    
    public String d(final D n) {
        final StringBuilder sb = new StringBuilder(64);
        androidx.core.util.b.a(n, sb);
        sb.append("}");
        return sb.toString();
    }
    
    public void e() {
        final a<D> c = this.c;
        if (c != null) {
            c.a(this);
        }
    }
    
    public void f(final D n) {
        final b<D> b = this.b;
        if (b != null) {
            b.a(this, n);
        }
    }
    
    @Deprecated
    public void g(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
        printWriter.print(s);
        printWriter.print("mId=");
        printWriter.print(this.a);
        printWriter.print(" mListener=");
        printWriter.println(this.b);
        if (this.e || this.h || this.i) {
            printWriter.print(s);
            printWriter.print("mStarted=");
            printWriter.print(this.e);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.h);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.i);
        }
        if (this.f || this.g) {
            printWriter.print(s);
            printWriter.print("mAbandoned=");
            printWriter.print(this.f);
            printWriter.print(" mReset=");
            printWriter.println(this.g);
        }
    }
    
    public void h() {
        this.m();
    }
    
    public boolean i() {
        return this.f;
    }
    
    protected void j() {
    }
    
    protected boolean k() {
        throw null;
    }
    
    public void l() {
        if (this.e) {
            this.h();
        }
        else {
            this.h = true;
        }
    }
    
    protected void m() {
    }
    
    protected void n() {
    }
    
    protected void o() {
        throw null;
    }
    
    protected void p() {
    }
    
    public void q(final int a, final b<D> b) {
        if (this.b == null) {
            this.b = b;
            this.a = a;
            return;
        }
        throw new IllegalStateException("There is already a listener registered");
    }
    
    public void r() {
        this.n();
        this.g = true;
        this.e = false;
        this.f = false;
        this.h = false;
        this.i = false;
    }
    
    public void s() {
        if (this.i) {
            this.l();
        }
    }
    
    public final void t() {
        this.e = true;
        this.g = false;
        this.f = false;
        this.o();
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(64);
        androidx.core.util.b.a(this, sb);
        sb.append(" id=");
        sb.append(this.a);
        sb.append("}");
        return sb.toString();
    }
    
    public void u() {
        this.e = false;
        this.p();
    }
    
    public void v(final b<D> b) {
        final b<D> b2 = this.b;
        if (b2 == null) {
            throw new IllegalStateException("No listener register");
        }
        if (b2 == b) {
            this.b = null;
            return;
        }
        throw new IllegalArgumentException("Attempting to unregister the wrong listener");
    }
    
    public interface a<D>
    {
        void a(final b<D> p0);
    }
    
    public interface b<D>
    {
        void a(final androidx.loader.content.b<D> p0, final D p1);
    }
}
