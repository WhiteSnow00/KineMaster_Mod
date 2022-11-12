// 
// Decompiled by Procyon v0.6.0
// 

package androidx.navigation;

import kotlin.jvm.internal.o;
import kotlin.text.l;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b.\u0010/J&\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004J\u001a\u0010\u000b\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\u0004J\u000f\u0010\r\u001a\u00020\fH\u0000¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0010R\"\u0010\u0018\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R*\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R*\u0010#\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00028\u0006@@X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R.\u0010*\u001a\u0004\u0018\u00010$2\b\u0010\u001d\u001a\u0004\u0018\u00010$8\u0006@BX\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0016\u0010+\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010\u0013R\u0016\u0010-\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010\u0013¨\u00060" }, d2 = { "Landroidx/navigation/r;", "", "", "id", "Lkotlin/Function1;", "Landroidx/navigation/x;", "Lka/r;", "popUpToBuilder", "c", "Landroidx/navigation/b;", "animBuilder", "a", "Landroidx/navigation/q;", "b", "()Landroidx/navigation/q;", "Landroidx/navigation/q$a;", "Landroidx/navigation/q$a;", "builder", "", "Z", "getLaunchSingleTop", "()Z", "d", "(Z)V", "launchSingleTop", "<set-?>", "getRestoreState", "setRestoreState", "restoreState", "value", "I", "getPopUpToId", "()I", "e", "(I)V", "popUpToId", "", "Ljava/lang/String;", "getPopUpToRoute", "()Ljava/lang/String;", "f", "(Ljava/lang/String;)V", "popUpToRoute", "inclusive", "g", "saveState", "<init>", "()V", "navigation-common_release" }, k = 1, mv = { 1, 6, 0 })
public final class r
{
    private final q.a a;
    private boolean b;
    private boolean c;
    private int d;
    private String e;
    private boolean f;
    private boolean g;
    
    public r() {
        this.a = new q.a();
        this.d = -1;
    }
    
    private final void f(final String e) {
        if (e != null) {
            if (!(l.w((CharSequence)e) ^ true)) {
                throw new IllegalArgumentException("Cannot pop up to an empty route".toString());
            }
            this.e = e;
            this.f = false;
        }
    }
    
    public final void a(final sa.l<? super b, ka.r> l) {
        o.g((Object)l, "animBuilder");
        final b b = new b();
        l.invoke((Object)b);
        this.a.b(b.a()).c(b.b()).e(b.c()).f(b.d());
    }
    
    public final q b() {
        final q.a a = this.a;
        a.d(this.b);
        a.j(this.c);
        final String e = this.e;
        if (e != null) {
            a.h(e, this.f, this.g);
        }
        else {
            a.g(this.d, this.f, this.g);
        }
        return a.a();
    }
    
    public final void c(final int n, final sa.l<? super x, ka.r> l) {
        o.g((Object)l, "popUpToBuilder");
        this.e(n);
        this.f(null);
        final x x = new x();
        l.invoke((Object)x);
        this.f = x.a();
        this.g = x.b();
    }
    
    public final void d(final boolean b) {
        this.b = b;
    }
    
    public final void e(final int d) {
        this.d = d;
        this.f = false;
    }
}
