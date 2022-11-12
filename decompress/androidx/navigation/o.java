// 
// Decompiled by Procyon v0.6.0
// 

package androidx.navigation;

import androidx.lifecycle.q0;
import androidx.activity.OnBackPressedDispatcher;
import androidx.lifecycle.r;
import android.content.Context;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f¨\u0006\u0013" }, d2 = { "Landroidx/navigation/o;", "Landroidx/navigation/NavController;", "Landroidx/lifecycle/r;", "owner", "Lka/r;", "j0", "Landroidx/activity/OnBackPressedDispatcher;", "dispatcher", "k0", "", "enabled", "s", "Landroidx/lifecycle/q0;", "viewModelStore", "l0", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "navigation-runtime_release" }, k = 1, mv = { 1, 6, 0 })
public class o extends NavController
{
    public o(final Context context) {
        kotlin.jvm.internal.o.g((Object)context, "context");
        super(context);
    }
    
    @Override
    public final void j0(final r r) {
        kotlin.jvm.internal.o.g((Object)r, "owner");
        super.j0(r);
    }
    
    @Override
    public final void k0(final OnBackPressedDispatcher onBackPressedDispatcher) {
        kotlin.jvm.internal.o.g((Object)onBackPressedDispatcher, "dispatcher");
        super.k0(onBackPressedDispatcher);
    }
    
    @Override
    public final void l0(final q0 q0) {
        kotlin.jvm.internal.o.g((Object)q0, "viewModelStore");
        super.l0(q0);
    }
    
    @Override
    public final void s(final boolean b) {
        super.s(b);
    }
}
