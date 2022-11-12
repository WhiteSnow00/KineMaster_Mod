// 
// Decompiled by Procyon v0.6.0
// 

package androidx.lifecycle;

import java.util.Iterator;
import u0.e;
import android.os.Bundle;
import u0.c;

class LegacySavedStateHandleController
{
    static void a(final l0 l0, final c c, final Lifecycle lifecycle) {
        final SavedStateHandleController savedStateHandleController = l0.getTag("androidx.lifecycle.savedstate.vm.tag");
        if (savedStateHandleController != null && !savedStateHandleController.j()) {
            savedStateHandleController.g(c, lifecycle);
            c(c, lifecycle);
        }
    }
    
    static SavedStateHandleController b(final c c, final Lifecycle lifecycle, final String s, final Bundle bundle) {
        final SavedStateHandleController savedStateHandleController = new SavedStateHandleController(s, g0.d(c.b(s), bundle));
        savedStateHandleController.g(c, lifecycle);
        c(c, lifecycle);
        return savedStateHandleController;
    }
    
    private static void c(final c c, final Lifecycle lifecycle) {
        final Lifecycle.State b = lifecycle.b();
        if (b != Lifecycle.State.INITIALIZED && !b.isAtLeast(Lifecycle.State.STARTED)) {
            lifecycle.a(new o(lifecycle, c) {
                final Lifecycle a;
                final c b;
                
                @Override
                public void f(final r r, final Lifecycle.Event event) {
                    if (event == Lifecycle.Event.ON_START) {
                        this.a.c(this);
                        this.b.i((Class<? extends c.a>)a.class);
                    }
                }
            });
        }
        else {
            c.i((Class<? extends c.a>)a.class);
        }
    }
    
    static final class a implements u0.c.a
    {
        @Override
        public void a(final e e) {
            if (e instanceof r0) {
                final q0 viewModelStore = ((r0)e).getViewModelStore();
                final c savedStateRegistry = e.getSavedStateRegistry();
                final Iterator<String> iterator = viewModelStore.c().iterator();
                while (iterator.hasNext()) {
                    LegacySavedStateHandleController.a(viewModelStore.b(iterator.next()), savedStateRegistry, e.getLifecycle());
                }
                if (!viewModelStore.c().isEmpty()) {
                    savedStateRegistry.i((Class<? extends u0.c.a>)a.class);
                }
                return;
            }
            throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner");
        }
    }
}
