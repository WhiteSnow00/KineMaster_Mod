// 
// Decompiled by Procyon v0.6.0
// 

package androidx.navigation;

import kotlin.jvm.internal.o;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u000bB[\b\u0000\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0014\u001a\u00020\t\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0018\u001a\u00020\t\u0012\b\b\u0001\u0010\u0019\u001a\u00020\t\u0012\b\b\u0001\u0010\u001a\u001a\u00020\t\u0012\b\b\u0001\u0010\u001b\u001a\u00020\t¢\u0006\u0004\b#\u0010$BS\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u001c\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\t\u0012\u0006\u0010\u0019\u001a\u00020\t\u0012\u0006\u0010\u001a\u001a\u00020\t\u0012\u0006\u0010\u001b\u001a\u00020\t¢\u0006\u0004\b#\u0010%J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0013\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\n\u001a\u00020\tH\u0016R\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\fR\u001a\u0010\u0014\u001a\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\fR\u0014\u0010\u0017\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\fR\u0017\u0010\u0018\u001a\u00020\t8\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u000b\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\t8\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u000e\u0010\u0013R\u0017\u0010\u001a\u001a\u00020\t8\u0007¢\u0006\f\n\u0004\b\u0006\u0010\u0011\u001a\u0004\b\u0010\u0010\u0013R\u0017\u0010\u001b\u001a\u00020\t8\u0007¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R(\u0010\"\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006&" }, d2 = { "Landroidx/navigation/q;", "", "", "g", "i", "f", "h", "other", "equals", "", "hashCode", "a", "Z", "singleTop", "b", "restoreState", "c", "I", "e", "()I", "popUpToId", "d", "popUpToInclusive", "popUpToSaveState", "enterAnim", "exitAnim", "popEnterAnim", "popExitAnim", "", "<set-?>", "j", "Ljava/lang/String;", "getPopUpToRoute", "()Ljava/lang/String;", "popUpToRoute", "<init>", "(ZZIZZIIII)V", "(ZZLjava/lang/String;ZZIIII)V", "navigation-common_release" }, k = 1, mv = { 1, 6, 0 })
public final class q
{
    private final boolean a;
    private final boolean b;
    private final int c;
    private final boolean d;
    private final boolean e;
    private final int f;
    private final int g;
    private final int h;
    private final int i;
    private String j;
    
    public q(final boolean a, final boolean b, final int c, final boolean d, final boolean e, final int f, final int g, final int h, final int i) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
    }
    
    public q(final boolean b, final boolean b2, final String j, final boolean b3, final boolean b4, final int n, final int n2, final int n3, final int n4) {
        this(b, b2, NavDestination.j.a(j).hashCode(), b3, b4, n, n2, n3, n4);
        this.j = j;
    }
    
    public final int a() {
        return this.f;
    }
    
    public final int b() {
        return this.g;
    }
    
    public final int c() {
        return this.h;
    }
    
    public final int d() {
        return this.i;
    }
    
    public final int e() {
        return this.c;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (o != null && o.b((Object)q.class, (Object)o.getClass())) {
            final q q = (q)o;
            if (this.a != q.a || this.b != q.b || this.c != q.c || !o.b((Object)this.j, (Object)q.j) || this.d != q.d || this.e != q.e || this.f != q.f || this.g != q.g || this.h != q.h || this.i != q.i) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    public final boolean f() {
        return this.d;
    }
    
    public final boolean g() {
        return this.a;
    }
    
    public final boolean h() {
        return this.e;
    }
    
    @Override
    public int hashCode() {
        final int g = this.g() ? 1 : 0;
        final int i = this.i() ? 1 : 0;
        final int c = this.c;
        final String j = this.j;
        int hashCode;
        if (j != null) {
            hashCode = j.hashCode();
        }
        else {
            hashCode = 0;
        }
        return ((((((((g * 31 + i) * 31 + c) * 31 + hashCode) * 31 + (this.f() ? 1 : 0)) * 31 + (this.h() ? 1 : 0)) * 31 + this.f) * 31 + this.g) * 31 + this.h) * 31 + this.i;
    }
    
    public final boolean i() {
        return this.b;
    }
    
    @Metadata(bv = {}, d1 = { "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b!\u0010\"J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0002J$\u0010\u000b\u001a\u00020\u00002\b\b\u0001\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u0002H\u0007J$\u0010\u000e\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u0002H\u0007J\u0010\u0010\u0010\u001a\u00020\u00002\b\b\u0001\u0010\u000f\u001a\u00020\u0007J\u0010\u0010\u0012\u001a\u00020\u00002\b\b\u0001\u0010\u0011\u001a\u00020\u0007J\u0010\u0010\u0014\u001a\u00020\u00002\b\b\u0001\u0010\u0013\u001a\u00020\u0007J\u0010\u0010\u0016\u001a\u00020\u00002\b\b\u0001\u0010\u0015\u001a\u00020\u0007J\u0006\u0010\u0018\u001a\u00020\u0017R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u001aR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0019R\u0016\u0010\u001f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0019R\u0016\u0010\u000f\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u001aR\u0016\u0010\u0011\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u001aR\u0016\u0010\u0013\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b \u0010\u001aR\u0016\u0010\u0015\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u001a¨\u0006#" }, d2 = { "Landroidx/navigation/q$a;", "", "", "singleTop", "d", "restoreState", "j", "", "destinationId", "inclusive", "saveState", "g", "", "route", "h", "enterAnim", "b", "exitAnim", "c", "popEnterAnim", "e", "popExitAnim", "f", "Landroidx/navigation/q;", "a", "Z", "I", "popUpToId", "Ljava/lang/String;", "popUpToRoute", "popUpToInclusive", "popUpToSaveState", "i", "<init>", "()V", "navigation-common_release" }, k = 1, mv = { 1, 6, 0 })
    public static final class a
    {
        private boolean a;
        private boolean b;
        private int c;
        private String d;
        private boolean e;
        private boolean f;
        private int g;
        private int h;
        private int i;
        private int j;
        
        public a() {
            this.c = -1;
            this.g = -1;
            this.h = -1;
            this.i = -1;
            this.j = -1;
        }
        
        public static a i(final a a, final int n, final boolean b, boolean b2, final int n2, final Object o) {
            if ((n2 & 0x4) != 0x0) {
                b2 = false;
            }
            return a.g(n, b, b2);
        }
        
        public final q a() {
            final String d = this.d;
            q q;
            if (d != null) {
                q = new q(this.a, this.b, d, this.e, this.f, this.g, this.h, this.i, this.j);
            }
            else {
                q = new q(this.a, this.b, this.c, this.e, this.f, this.g, this.h, this.i, this.j);
            }
            return q;
        }
        
        public final a b(final int g) {
            this.g = g;
            return this;
        }
        
        public final a c(final int h) {
            this.h = h;
            return this;
        }
        
        public final a d(final boolean a) {
            this.a = a;
            return this;
        }
        
        public final a e(final int i) {
            this.i = i;
            return this;
        }
        
        public final a f(final int j) {
            this.j = j;
            return this;
        }
        
        public final a g(final int c, final boolean e, final boolean f) {
            this.c = c;
            this.d = null;
            this.e = e;
            this.f = f;
            return this;
        }
        
        public final a h(final String d, final boolean e, final boolean f) {
            this.d = d;
            this.c = -1;
            this.e = e;
            this.f = f;
            return this;
        }
        
        public final a j(final boolean b) {
            this.b = b;
            return this;
        }
    }
}
