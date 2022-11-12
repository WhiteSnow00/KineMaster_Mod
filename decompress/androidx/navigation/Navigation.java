// 
// Decompiled by Procyon v0.6.0
// 

package androidx.navigation;

import java.lang.ref.WeakReference;
import sa.l;
import kotlin.sequences.k;
import kotlin.jvm.internal.o;
import android.view.View;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¨\u0006\r" }, d2 = { "Landroidx/navigation/Navigation;", "", "Landroid/view/View;", "view", "Landroidx/navigation/NavController;", "b", "controller", "Lka/r;", "e", "c", "d", "<init>", "()V", "navigation-runtime_release" }, k = 1, mv = { 1, 6, 0 })
public final class Navigation
{
    public static final Navigation a;
    
    static {
        a = new Navigation();
    }
    
    private Navigation() {
    }
    
    public static final NavController a(final Navigation navigation, final View view) {
        return navigation.d(view);
    }
    
    public static final NavController b(final View view) {
        o.g((Object)view, "view");
        final NavController c = Navigation.a.c(view);
        if (c != null) {
            return c;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("View ");
        sb.append(view);
        sb.append(" does not have a NavController set");
        throw new IllegalStateException(sb.toString());
    }
    
    private final NavController c(final View view) {
        return (NavController)k.r(k.y(k.h((Object)view, (l)Navigation$findViewNavController.Navigation$findViewNavController$1.INSTANCE), (l)Navigation$findViewNavController.Navigation$findViewNavController$2.INSTANCE));
    }
    
    private final NavController d(final View view) {
        final Object tag = view.getTag(y.a);
        NavController navController;
        if (tag instanceof WeakReference) {
            navController = (NavController)((WeakReference)tag).get();
        }
        else if (tag instanceof NavController) {
            navController = (NavController)tag;
        }
        else {
            navController = null;
        }
        return navController;
    }
    
    public static final void e(final View view, final NavController navController) {
        o.g((Object)view, "view");
        view.setTag(y.a, (Object)navController);
    }
}
