// 
// Decompiled by Procyon v0.6.0
// 

package androidx.lifecycle;

import kotlin.jvm.internal.o;
import k0.a;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¨\u0006\u0004" }, d2 = { "Landroidx/lifecycle/r0;", "owner", "Lk0/a;", "a", "lifecycle-viewmodel_release" }, k = 2, mv = { 1, 6, 0 })
public final class p0
{
    public static final a a(final r0 r0) {
        o.g((Object)r0, "owner");
        a a;
        if (r0 instanceof k) {
            a = ((k)r0).getDefaultViewModelCreationExtras();
            o.f((Object)a, "{\n        owner.defaultV\u2026ModelCreationExtras\n    }");
        }
        else {
            a = k0.a.a.b;
        }
        return a;
    }
}
