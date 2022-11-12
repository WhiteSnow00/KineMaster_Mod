// 
// Decompiled by Procyon v0.6.0
// 

package androidx.paging;

import kotlin.jvm.internal.o;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u001e\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¨\u0006\u0006" }, d2 = { "Landroidx/paging/g0;", "previous", "Landroidx/paging/LoadType;", "loadType", "", "a", "paging-common" }, k = 2, mv = { 1, 5, 1 })
public final class i
{
    public static final boolean a(final g0 g0, final g0 g2, final LoadType loadType) {
        o.g((Object)g0, "<this>");
        o.g((Object)loadType, "loadType");
        boolean b = false;
        if (g2 != null) {
            if (!(g2 instanceof g0.b) || !(g0 instanceof g0.a)) {
                if (g0 instanceof g0.b && g2 instanceof g0.a) {
                    return b;
                }
                if (g0.a() == g2.a()) {
                    if (g0.b() == g2.b()) {
                        if (g2.e(loadType) <= g0.e(loadType)) {
                            return b;
                        }
                    }
                }
            }
        }
        b = true;
        return b;
    }
}
