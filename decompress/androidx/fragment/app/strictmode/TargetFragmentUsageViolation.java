// 
// Decompiled by Procyon v0.6.0
// 

package androidx.fragment.app.strictmode;

import kotlin.jvm.internal.i;
import kotlin.jvm.internal.o;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;

@Metadata(d1 = { "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u001b\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007" }, d2 = { "Landroidx/fragment/app/strictmode/TargetFragmentUsageViolation;", "Landroidx/fragment/app/strictmode/Violation;", "fragment", "Landroidx/fragment/app/Fragment;", "message", "", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;)V", "fragment_release" }, k = 1, mv = { 1, 6, 0 }, xi = 48)
public abstract class TargetFragmentUsageViolation extends Violation
{
    public TargetFragmentUsageViolation(final Fragment fragment, final String s) {
        o.g((Object)fragment, "fragment");
        super(fragment, s);
    }
    
    public TargetFragmentUsageViolation(final Fragment fragment, String s, final int n, final i i) {
        if ((n & 0x2) != 0x0) {
            s = null;
        }
        this(fragment, s);
    }
}
