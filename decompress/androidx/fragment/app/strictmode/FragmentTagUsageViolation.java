// 
// Decompiled by Procyon v0.6.0
// 

package androidx.fragment.app.strictmode;

import kotlin.jvm.internal.o;
import androidx.fragment.app.Fragment;
import android.view.ViewGroup;
import kotlin.Metadata;

@Metadata(d1 = { "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t" }, d2 = { "Landroidx/fragment/app/strictmode/FragmentTagUsageViolation;", "Landroidx/fragment/app/strictmode/Violation;", "fragment", "Landroidx/fragment/app/Fragment;", "parentContainer", "Landroid/view/ViewGroup;", "(Landroidx/fragment/app/Fragment;Landroid/view/ViewGroup;)V", "getParentContainer", "()Landroid/view/ViewGroup;", "fragment_release" }, k = 1, mv = { 1, 6, 0 }, xi = 48)
public final class FragmentTagUsageViolation extends Violation
{
    private final ViewGroup parentContainer;
    
    public FragmentTagUsageViolation(final Fragment fragment, final ViewGroup parentContainer) {
        o.g((Object)fragment, "fragment");
        final StringBuilder sb = new StringBuilder();
        sb.append("Attempting to use <fragment> tag to add fragment ");
        sb.append(fragment);
        sb.append(" to container ");
        sb.append(parentContainer);
        super(fragment, sb.toString());
        this.parentContainer = parentContainer;
    }
    
    public final ViewGroup getParentContainer() {
        return this.parentContainer;
    }
}
