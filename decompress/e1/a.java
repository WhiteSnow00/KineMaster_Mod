// 
// Decompiled by Procyon v0.6.0
// 

package e1;

import androidx.work.NetworkType;

public final class a
{
    public static final a i;
    private NetworkType a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private long f;
    private long g;
    private b h;
    
    static {
        i = new a().a();
    }
    
    public a() {
        this.a = NetworkType.NOT_REQUIRED;
        this.f = -1L;
        this.g = -1L;
        this.h = new b();
    }
    
    a(final a a) {
        this.a = NetworkType.NOT_REQUIRED;
        this.f = -1L;
        this.g = -1L;
        this.h = new b();
        this.b = a.a;
        this.c = a.b;
        this.a = a.c;
        this.d = a.d;
        this.e = a.e;
        this.h = a.h;
        this.f = a.f;
        this.g = a.g;
    }
    
    public a(final a a) {
        this.a = NetworkType.NOT_REQUIRED;
        this.f = -1L;
        this.g = -1L;
        this.h = new b();
        this.b = a.b;
        this.c = a.c;
        this.a = a.a;
        this.d = a.d;
        this.e = a.e;
        this.h = a.h;
    }
    
    public b a() {
        return this.h;
    }
    
    public NetworkType b() {
        return this.a;
    }
    
    public long c() {
        return this.f;
    }
    
    public long d() {
        return this.g;
    }
    
    public boolean e() {
        return this.h.c() > 0;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o != null && a.class == o.getClass()) {
            final a a = (a)o;
            return this.b == a.b && this.c == a.c && this.d == a.d && this.e == a.e && this.f == a.f && this.g == a.g && this.a == a.a && this.h.equals(a.h);
        }
        return false;
    }
    
    public boolean f() {
        return this.d;
    }
    
    public boolean g() {
        return this.b;
    }
    
    public boolean h() {
        return this.c;
    }
    
    @Override
    public int hashCode() {
        final int hashCode = this.a.hashCode();
        final int b = this.b ? 1 : 0;
        final int c = this.c ? 1 : 0;
        final int d = this.d ? 1 : 0;
        final int e = this.e ? 1 : 0;
        final long f = this.f;
        final int n = (int)(f ^ f >>> 32);
        final long g = this.g;
        return ((((((hashCode * 31 + b) * 31 + c) * 31 + d) * 31 + e) * 31 + n) * 31 + (int)(g ^ g >>> 32)) * 31 + this.h.hashCode();
    }
    
    public boolean i() {
        return this.e;
    }
    
    public void j(final b h) {
        this.h = h;
    }
    
    public void k(final NetworkType a) {
        this.a = a;
    }
    
    public void l(final boolean d) {
        this.d = d;
    }
    
    public void m(final boolean b) {
        this.b = b;
    }
    
    public void n(final boolean c) {
        this.c = c;
    }
    
    public void o(final boolean e) {
        this.e = e;
    }
    
    public void p(final long f) {
        this.f = f;
    }
    
    public void q(final long g) {
        this.g = g;
    }
    
    public static final class a
    {
        boolean a;
        boolean b;
        NetworkType c;
        boolean d;
        boolean e;
        long f;
        long g;
        b h;
        
        public a() {
            this.a = false;
            this.b = false;
            this.c = NetworkType.NOT_REQUIRED;
            this.d = false;
            this.e = false;
            this.f = -1L;
            this.g = -1L;
            this.h = new b();
        }
        
        public e1.a a() {
            return new e1.a(this);
        }
        
        public a b(final NetworkType c) {
            this.c = c;
            return this;
        }
    }
}
