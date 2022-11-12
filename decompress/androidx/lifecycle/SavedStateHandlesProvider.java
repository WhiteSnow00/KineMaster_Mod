// 
// Decompiled by Procyon v0.6.0
// 

package androidx.lifecycle;

import java.util.Iterator;
import java.util.Map;
import kotlin.a;
import kotlin.jvm.internal.o;
import ka.j;
import android.os.Bundle;
import kotlin.Metadata;
import u0.c;

@Metadata(bv = {}, d1 = { "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\rR\u001b\u0010\u0013\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\n\u0010\u0012¨\u0006\u001a" }, d2 = { "Landroidx/lifecycle/SavedStateHandlesProvider;", "Lu0/c$c;", "Landroid/os/Bundle;", "saveState", "Lka/r;", "c", "", "key", "a", "", "b", "Z", "restored", "Landroid/os/Bundle;", "restoredState", "Landroidx/lifecycle/h0;", "viewModel$delegate", "Lka/j;", "()Landroidx/lifecycle/h0;", "viewModel", "Lu0/c;", "savedStateRegistry", "Landroidx/lifecycle/r0;", "viewModelStoreOwner", "<init>", "(Lu0/c;Landroidx/lifecycle/r0;)V", "lifecycle-viewmodel-savedstate_release" }, k = 1, mv = { 1, 6, 0 })
public final class SavedStateHandlesProvider implements c
{
    private final u0.c a;
    private boolean b;
    private Bundle c;
    private final j d;
    
    public SavedStateHandlesProvider(final u0.c a, final r0 r0) {
        o.g((Object)a, "savedStateRegistry");
        o.g((Object)r0, "viewModelStoreOwner");
        this.a = a;
        this.d = kotlin.a.b((sa.a)new SavedStateHandlesProvider$viewModel.SavedStateHandlesProvider$viewModel$2(r0));
    }
    
    private final h0 b() {
        return (h0)this.d.getValue();
    }
    
    public final Bundle a(final String s) {
        o.g((Object)s, "key");
        this.c();
        final Bundle c = this.c;
        Bundle bundle;
        if (c != null) {
            bundle = c.getBundle(s);
        }
        else {
            bundle = null;
        }
        final Bundle c2 = this.c;
        if (c2 != null) {
            c2.remove(s);
        }
        final Bundle c3 = this.c;
        boolean b = true;
        if (c3 == null || !c3.isEmpty()) {
            b = false;
        }
        if (b) {
            this.c = null;
        }
        return bundle;
    }
    
    public final void c() {
        if (!this.b) {
            this.c = this.a.b("androidx.lifecycle.internal.SavedStateHandlesProvider");
            this.b = true;
            this.b();
        }
    }
    
    @Override
    public Bundle saveState() {
        final Bundle bundle = new Bundle();
        final Bundle c = this.c;
        if (c != null) {
            bundle.putAll(c);
        }
        for (final Map.Entry<String, V> entry : this.b().h().entrySet()) {
            final String s = entry.getKey();
            final Bundle saveState = ((g0)entry.getValue()).f().saveState();
            if (!o.b((Object)saveState, (Object)Bundle.EMPTY)) {
                bundle.putBundle(s, saveState);
            }
        }
        this.b = false;
        return bundle;
    }
}
