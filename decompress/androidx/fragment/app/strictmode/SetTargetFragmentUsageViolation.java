// 
// Decompiled by Procyon v0.6.0
// 

package androidx.fragment.app.strictmode;

import kotlin.jvm.internal.o;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;

@Metadata(d1 = { "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f" }, d2 = { "Landroidx/fragment/app/strictmode/SetTargetFragmentUsageViolation;", "Landroidx/fragment/app/strictmode/TargetFragmentUsageViolation;", "fragment", "Landroidx/fragment/app/Fragment;", "targetFragment", "requestCode", "", "(Landroidx/fragment/app/Fragment;Landroidx/fragment/app/Fragment;I)V", "getRequestCode", "()I", "getTargetFragment", "()Landroidx/fragment/app/Fragment;", "fragment_release" }, k = 1, mv = { 1, 6, 0 }, xi = 48)
public final class SetTargetFragmentUsageViolation extends TargetFragmentUsageViolation
{
    private final int requestCode;
    private final Fragment targetFragment;
    
    public SetTargetFragmentUsageViolation(final Fragment fragment, final Fragment targetFragment, final int requestCode) {
        o.g((Object)fragment, "fragment");
        o.g((Object)targetFragment, "targetFragment");
        final StringBuilder sb = new StringBuilder();
        sb.append("Attempting to set target fragment ");
        sb.append(targetFragment);
        sb.append(" with request code ");
        sb.append(requestCode);
        sb.append(" for fragment ");
        sb.append(fragment);
        super(fragment, sb.toString());
        this.targetFragment = targetFragment;
        this.requestCode = requestCode;
    }
    
    public final int getRequestCode() {
        return this.requestCode;
    }
    
    public final Fragment getTargetFragment() {
        return this.targetFragment;
    }
}
