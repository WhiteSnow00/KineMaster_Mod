// 
// Decompiled by Procyon v0.6.0
// 

package androidx.lifecycle;

import u0.e;
import android.os.Bundle;
import u0.c;

public abstract class a extends d implements b
{
    private u0.c b;
    private Lifecycle c;
    private Bundle d;
    
    public a(final e e, final Bundle d) {
        this.b = e.getSavedStateRegistry();
        this.c = e.getLifecycle();
        this.d = d;
    }
    
    private <T extends l0> T d(final String s, final Class<T> clazz) {
        final SavedStateHandleController b = LegacySavedStateHandleController.b(this.b, this.c, s, this.d);
        final l0 e = this.e(s, clazz, b.h());
        e.setTagIfAbsent("androidx.lifecycle.savedstate.vm.tag", b);
        return (T)e;
    }
    
    @Override
    public final <T extends l0> T a(final Class<T> clazz) {
        final String canonicalName = clazz.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        if (this.c != null) {
            return this.d(canonicalName, clazz);
        }
        throw new UnsupportedOperationException("AbstractSavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
    }
    
    @Override
    public final <T extends l0> T b(final Class<T> clazz, final k0.a a) {
        final String s = a.a(o0.c.d);
        if (s == null) {
            throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
        }
        if (this.b != null) {
            return this.d(s, clazz);
        }
        return this.e(s, clazz, SavedStateHandleSupport.a(a));
    }
    
    @Override
    public void c(final l0 l0) {
        final u0.c b = this.b;
        if (b != null) {
            LegacySavedStateHandleController.a(l0, b, this.c);
        }
    }
    
    protected abstract <T extends l0> T e(final String p0, final Class<T> p1, final g0 p2);
}
