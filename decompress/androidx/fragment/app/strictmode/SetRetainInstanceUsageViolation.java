// 
// Decompiled by Procyon v0.6.0
// 

package androidx.fragment.app.strictmode;

import kotlin.jvm.internal.o;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;

@Metadata(d1 = { "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003�\u0006\u0002\u0010\u0004�\u0006\u0005" }, d2 = { "Landroidx/fragment/app/strictmode/SetRetainInstanceUsageViolation;", "Landroidx/fragment/app/strictmode/RetainInstanceUsageViolation;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "fragment_release" }, k = 1, mv = { 1, 6, 0 }, xi = 48)
public final class SetRetainInstanceUsageViolation extends RetainInstanceUsageViolation
{
    public SetRetainInstanceUsageViolation(final Fragment fragment) {
        o.g((Object)fragment, "fragment");
        final StringBuilder sb = new StringBuilder();
        sb.append("Attempting to set retain instance for fragment ");
        sb.append(fragment);
        super(fragment, sb.toString());
    }
}
