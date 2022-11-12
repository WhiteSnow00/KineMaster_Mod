// 
// Decompiled by Procyon v0.6.0
// 

package u0;

import android.os.Bundle;
import androidx.lifecycle.q;
import androidx.savedstate.Recreator;
import androidx.lifecycle.Lifecycle;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.i;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0012B\u0011\b\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0007R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0013" }, d2 = { "Lu0/d;", "", "Lka/r;", "c", "Landroid/os/Bundle;", "savedState", "d", "outBundle", "e", "Lu0/c;", "savedStateRegistry", "Lu0/c;", "b", "()Lu0/c;", "Lu0/e;", "owner", "<init>", "(Lu0/e;)V", "a", "savedstate_release" }, k = 1, mv = { 1, 6, 0 })
public final class d
{
    public static final a d;
    private final e a;
    private final c b;
    private boolean c;
    
    static {
        d = new a(null);
    }
    
    private d(final e a) {
        this.a = a;
        this.b = new c();
    }
    
    public d(final e e, final i i) {
        this(e);
    }
    
    public static final d a(final e e) {
        return u0.d.d.a(e);
    }
    
    public final c b() {
        return this.b;
    }
    
    public final void c() {
        final Lifecycle lifecycle = this.a.getLifecycle();
        o.f((Object)lifecycle, "owner.lifecycle");
        if (lifecycle.b() == Lifecycle.State.INITIALIZED) {
            lifecycle.a(new Recreator(this.a));
            this.b.e(lifecycle);
            this.c = true;
            return;
        }
        throw new IllegalStateException("Restarter must be created only during owner's initialization stage".toString());
    }
    
    public final void d(final Bundle bundle) {
        if (!this.c) {
            this.c();
        }
        final Lifecycle lifecycle = this.a.getLifecycle();
        o.f((Object)lifecycle, "owner.lifecycle");
        if (lifecycle.b().isAtLeast(Lifecycle.State.STARTED) ^ true) {
            this.b.f(bundle);
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("performRestore cannot be called when owner is ");
        sb.append(lifecycle.b());
        throw new IllegalStateException(sb.toString().toString());
    }
    
    public final void e(final Bundle bundle) {
        o.g((Object)bundle, "outBundle");
        this.b.g(bundle);
    }
    
    @Metadata(bv = {}, d1 = { "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\b" }, d2 = { "Lu0/d$a;", "", "Lu0/e;", "owner", "Lu0/d;", "a", "<init>", "()V", "savedstate_release" }, k = 1, mv = { 1, 6, 0 })
    public static final class a
    {
        private a() {
        }
        
        public a(final i i) {
            this();
        }
        
        public final d a(final e e) {
            o.g((Object)e, "owner");
            return new d(e, null);
        }
    }
}
