// 
// Decompiled by Procyon v0.6.0
// 

package androidx.lifecycle;

import java.lang.reflect.Constructor;
import java.util.List;
import k0.a;
import kotlin.jvm.internal.o;
import u0.e;
import u0.c;
import android.os.Bundle;
import android.app.Application;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0016¢\u0006\u0004\b \u0010!B%\b\u0017\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010#\u001a\u00020\"\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b \u0010$J/\u0010\t\u001a\u00028\u0000\"\b\b\u0000\u0010\u0004*\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ-\u0010\r\u001a\u00028\u0000\"\b\b\u0000\u0010\u0004*\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u000f\u001a\u00028\u0000\"\b\b\u0000\u0010\u0004*\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0003H\u0017R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006%" }, d2 = { "Landroidx/lifecycle/i0;", "Landroidx/lifecycle/o0$d;", "Landroidx/lifecycle/o0$b;", "Landroidx/lifecycle/l0;", "T", "Ljava/lang/Class;", "modelClass", "Lk0/a;", "extras", "b", "(Ljava/lang/Class;Lk0/a;)Landroidx/lifecycle/l0;", "", "key", "d", "(Ljava/lang/String;Ljava/lang/Class;)Landroidx/lifecycle/l0;", "a", "(Ljava/lang/Class;)Landroidx/lifecycle/l0;", "viewModel", "Lka/r;", "c", "Landroid/app/Application;", "Landroid/app/Application;", "application", "Landroidx/lifecycle/o0$b;", "factory", "Landroid/os/Bundle;", "Landroid/os/Bundle;", "defaultArgs", "Landroidx/lifecycle/Lifecycle;", "e", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "<init>", "()V", "Lu0/e;", "owner", "(Landroid/app/Application;Lu0/e;Landroid/os/Bundle;)V", "lifecycle-viewmodel-savedstate_release" }, k = 1, mv = { 1, 6, 0 })
public final class i0 extends d implements b
{
    private Application b;
    private final b c;
    private Bundle d;
    private Lifecycle e;
    private u0.c f;
    
    public i0() {
        this.c = new o0.a();
    }
    
    public i0(final Application b, final e e, final Bundle d) {
        o.g((Object)e, "owner");
        this.f = e.getSavedStateRegistry();
        this.e = e.getLifecycle();
        this.d = d;
        this.b = b;
        c b2;
        if (b != null) {
            b2 = o0.a.f.b(b);
        }
        else {
            b2 = new o0.a();
        }
        this.c = b2;
    }
    
    @Override
    public <T extends l0> T a(final Class<T> clazz) {
        o.g((Object)clazz, "modelClass");
        final String canonicalName = clazz.getCanonicalName();
        if (canonicalName != null) {
            return this.d(canonicalName, clazz);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
    
    @Override
    public <T extends l0> T b(final Class<T> clazz, final a a) {
        o.g((Object)clazz, "modelClass");
        o.g((Object)a, "extras");
        final String s = a.a(o0.c.d);
        if (s != null) {
            l0 l0;
            if (a.a(SavedStateHandleSupport.a) != null && a.a(SavedStateHandleSupport.b) != null) {
                final Application application = a.a(o0.a.h);
                final boolean assignable = androidx.lifecycle.b.class.isAssignableFrom(clazz);
                Constructor<T> constructor;
                if (assignable && application != null) {
                    constructor = j0.c(clazz, j0.a());
                }
                else {
                    constructor = j0.c(clazz, j0.b());
                }
                if (constructor == null) {
                    return this.c.b(clazz, a);
                }
                if (assignable && application != null) {
                    l0 = j0.d(clazz, constructor, application, SavedStateHandleSupport.a(a));
                }
                else {
                    l0 = j0.d(clazz, constructor, SavedStateHandleSupport.a(a));
                }
            }
            else {
                if (this.e == null) {
                    throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
                }
                l0 = this.d(s, clazz);
            }
            return (T)l0;
        }
        throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
    }
    
    @Override
    public void c(final l0 l0) {
        o.g((Object)l0, "viewModel");
        final Lifecycle e = this.e;
        if (e != null) {
            LegacySavedStateHandleController.a(l0, this.f, e);
        }
    }
    
    public final <T extends l0> T d(final String s, final Class<T> clazz) {
        o.g((Object)s, "key");
        o.g((Object)clazz, "modelClass");
        if (this.e == null) {
            throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
        }
        final boolean assignable = androidx.lifecycle.b.class.isAssignableFrom(clazz);
        Constructor<T> constructor;
        if (assignable && this.b != null) {
            constructor = j0.c(clazz, j0.a());
        }
        else {
            constructor = j0.c(clazz, j0.b());
        }
        if (constructor == null) {
            l0 l0;
            if (this.b != null) {
                l0 = this.c.a(clazz);
            }
            else {
                l0 = o0.c.b.a().a(clazz);
            }
            return (T)l0;
        }
        final SavedStateHandleController b = LegacySavedStateHandleController.b(this.f, this.e, s, this.d);
        l0 l2 = null;
        Label_0197: {
            if (assignable) {
                final Application b2 = this.b;
                if (b2 != null) {
                    o.d((Object)b2);
                    final g0 h = b.h();
                    o.f((Object)h, "controller.handle");
                    l2 = j0.d(clazz, constructor, b2, h);
                    break Label_0197;
                }
            }
            final g0 h2 = b.h();
            o.f((Object)h2, "controller.handle");
            l2 = j0.d(clazz, constructor, h2);
        }
        l2.setTagIfAbsent("androidx.lifecycle.savedstate.vm.tag", b);
        return (T)l2;
    }
}
