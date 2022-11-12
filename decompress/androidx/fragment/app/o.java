// 
// Decompiled by Procyon v0.6.0
// 

package androidx.fragment.app;

import ka.r;
import android.os.Bundle;
import sa.p;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001a\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003\u001a,\u0010\t\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u0007¨\u0006\n" }, d2 = { "Landroidx/fragment/app/Fragment;", "", "requestKey", "Landroid/os/Bundle;", "result", "Lka/r;", "b", "Lkotlin/Function2;", "listener", "c", "fragment-ktx_release" }, k = 2, mv = { 1, 6, 0 })
public final class o
{
    public static void a(final p p3, final String s, final Bundle bundle) {
        d(p3, s, bundle);
    }
    
    public static final void b(final Fragment fragment, final String s, final Bundle bundle) {
        kotlin.jvm.internal.o.g((Object)fragment, "<this>");
        kotlin.jvm.internal.o.g((Object)s, "requestKey");
        kotlin.jvm.internal.o.g((Object)bundle, "result");
        fragment.getParentFragmentManager().G1(s, bundle);
    }
    
    public static final void c(final Fragment fragment, final String s, final p<? super String, ? super Bundle, r> p3) {
        kotlin.jvm.internal.o.g((Object)fragment, "<this>");
        kotlin.jvm.internal.o.g((Object)s, "requestKey");
        kotlin.jvm.internal.o.g((Object)p3, "listener");
        fragment.getParentFragmentManager().H1(s, fragment, new n(p3));
    }
    
    private static final void d(final p p3, final String s, final Bundle bundle) {
        kotlin.jvm.internal.o.g((Object)p3, "$tmp0");
        kotlin.jvm.internal.o.g((Object)s, "p0");
        kotlin.jvm.internal.o.g((Object)bundle, "p1");
        p3.invoke((Object)s, (Object)bundle);
    }
}
