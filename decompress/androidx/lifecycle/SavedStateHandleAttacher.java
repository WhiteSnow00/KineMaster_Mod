// 
// Decompiled by Procyon v0.6.0
// 

package androidx.lifecycle;

import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e" }, d2 = { "Landroidx/lifecycle/SavedStateHandleAttacher;", "Landroidx/lifecycle/o;", "Landroidx/lifecycle/r;", "source", "Landroidx/lifecycle/Lifecycle$Event;", "event", "Lka/r;", "f", "Landroidx/lifecycle/SavedStateHandlesProvider;", "a", "Landroidx/lifecycle/SavedStateHandlesProvider;", "provider", "<init>", "(Landroidx/lifecycle/SavedStateHandlesProvider;)V", "lifecycle-viewmodel-savedstate_release" }, k = 1, mv = { 1, 6, 0 })
public final class SavedStateHandleAttacher implements o
{
    private final SavedStateHandlesProvider a;
    
    public SavedStateHandleAttacher(final SavedStateHandlesProvider a) {
        kotlin.jvm.internal.o.g((Object)a, "provider");
        this.a = a;
    }
    
    @Override
    public void f(final r r, final Lifecycle.Event event) {
        kotlin.jvm.internal.o.g((Object)r, "source");
        kotlin.jvm.internal.o.g((Object)event, "event");
        if (event == Lifecycle.Event.ON_CREATE) {
            r.getLifecycle().c(this);
            this.a.c();
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Next event must be ON_CREATE, it was ");
        sb.append(event);
        throw new IllegalStateException(sb.toString().toString());
    }
}
