// 
// Decompiled by Procyon v0.6.0
// 

package q0;

import androidx.navigation.fragment.NavHostFragment;
import kotlin.jvm.internal.o;
import androidx.navigation.NavController;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¨\u0006\u0003" }, d2 = { "Landroidx/fragment/app/Fragment;", "Landroidx/navigation/NavController;", "a", "navigation-fragment_release" }, k = 2, mv = { 1, 6, 0 })
public final class d
{
    public static final NavController a(final Fragment fragment) {
        o.g((Object)fragment, "<this>");
        return NavHostFragment.f.a(fragment);
    }
}
