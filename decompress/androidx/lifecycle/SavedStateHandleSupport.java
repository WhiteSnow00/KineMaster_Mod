// 
// Decompiled by Procyon v0.6.0
// 

package androidx.lifecycle;

import sa.l;
import kotlin.reflect.d;
import kotlin.jvm.internal.s;
import u0.c;
import kotlin.jvm.internal.o;
import android.os.Bundle;
import u0.e;
import k0.a;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a!\u0010\u0004\u001a\u00020\u0003\"\f\b\u0000\u0010\u0002*\u00020\u0000*\u00020\u0001*\u00028\u0000H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a*\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002\u001a\f\u0010\u000f\u001a\u00020\f*\u00020\u000eH\u0007\"\u0018\u0010\u0013\u001a\u00020\u0010*\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\"\u0018\u0010\u0017\u001a\u00020\u0014*\u00020\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0018" }, d2 = { "Lu0/e;", "Landroidx/lifecycle/r0;", "T", "Lka/r;", "c", "(Lu0/e;)V", "savedStateRegistryOwner", "viewModelStoreOwner", "", "key", "Landroid/os/Bundle;", "defaultArgs", "Landroidx/lifecycle/g0;", "b", "Lk0/a;", "a", "Landroidx/lifecycle/h0;", "e", "(Landroidx/lifecycle/r0;)Landroidx/lifecycle/h0;", "savedStateHandlesVM", "Landroidx/lifecycle/SavedStateHandlesProvider;", "d", "(Lu0/e;)Landroidx/lifecycle/SavedStateHandlesProvider;", "savedStateHandlesProvider", "lifecycle-viewmodel-savedstate_release" }, k = 2, mv = { 1, 6, 0 })
public final class SavedStateHandleSupport
{
    public static final a.b<e> a;
    public static final a.b<r0> b;
    public static final a.b<Bundle> c;
    
    static {
        a = new a.b<e>() {};
        b = new a.b<r0>() {};
        c = new a.b<Bundle>() {};
    }
    
    public static final g0 a(final a a) {
        o.g((Object)a, "<this>");
        final e e = a.a(SavedStateHandleSupport.a);
        if (e == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
        }
        final r0 r0 = a.a(SavedStateHandleSupport.b);
        if (r0 == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
        }
        final Bundle bundle = a.a(SavedStateHandleSupport.c);
        final String s = a.a(o0.c.d);
        if (s != null) {
            return b(e, r0, s, bundle);
        }
        throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
    }
    
    private static final g0 b(final e e, final r0 r0, final String s, final Bundle bundle) {
        final SavedStateHandlesProvider d = d(e);
        final h0 e2 = e(r0);
        g0 a;
        if ((a = e2.h().get(s)) == null) {
            a = g0.f.a(d.a(s), bundle);
            e2.h().put(s, a);
        }
        return a;
    }
    
    public static final <T extends e & r0> void c(final T t) {
        o.g((Object)t, "<this>");
        final Lifecycle.State b = t.getLifecycle().b();
        o.f((Object)b, "lifecycle.currentState");
        if (b == Lifecycle.State.INITIALIZED || b == Lifecycle.State.CREATED) {
            if (t.getSavedStateRegistry().c("androidx.lifecycle.internal.SavedStateHandlesProvider") == null) {
                final SavedStateHandlesProvider savedStateHandlesProvider = new SavedStateHandlesProvider(t.getSavedStateRegistry(), t);
                t.getSavedStateRegistry().h("androidx.lifecycle.internal.SavedStateHandlesProvider", (c.c)savedStateHandlesProvider);
                t.getLifecycle().a(new SavedStateHandleAttacher(savedStateHandlesProvider));
            }
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }
    
    public static final SavedStateHandlesProvider d(final e e) {
        o.g((Object)e, "<this>");
        final c.c c = e.getSavedStateRegistry().c("androidx.lifecycle.internal.SavedStateHandlesProvider");
        SavedStateHandlesProvider savedStateHandlesProvider;
        if (c instanceof SavedStateHandlesProvider) {
            savedStateHandlesProvider = (SavedStateHandlesProvider)c;
        }
        else {
            savedStateHandlesProvider = null;
        }
        if (savedStateHandlesProvider != null) {
            return savedStateHandlesProvider;
        }
        throw new IllegalStateException("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
    }
    
    public static final h0 e(final r0 r0) {
        o.g((Object)r0, "<this>");
        final k0.c c = new k0.c();
        c.a((kotlin.reflect.d<l0>)s.b((Class)h0.class), (sa.l<? super a, ? extends l0>)SavedStateHandleSupport$savedStateHandlesVM$1.SavedStateHandleSupport$savedStateHandlesVM$1$1.INSTANCE);
        return new o0(r0, c.b()).b("androidx.lifecycle.internal.SavedStateHandlesVM", h0.class);
    }
}
