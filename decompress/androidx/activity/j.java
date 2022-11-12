// 
// Decompiled by Procyon v0.6.0
// 

package androidx.activity;

import kotlin.jvm.internal.o;
import android.view.View;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006" }, d2 = { "Landroid/view/View;", "Landroidx/activity/h;", "onBackPressedDispatcherOwner", "Lka/r;", "a", "(Landroid/view/View;Landroidx/activity/h;)V", "activity_release" }, k = 2, mv = { 1, 6, 0 })
public final class j
{
    public static final void a(final View view, final h h) {
        o.g((Object)view, "<this>");
        o.g((Object)h, "onBackPressedDispatcherOwner");
        view.setTag(i.a, (Object)h);
    }
}
