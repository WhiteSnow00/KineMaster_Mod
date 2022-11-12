// 
// Decompiled by Procyon v0.6.0
// 

package androidx.paging;

import kotlin.jvm.internal.o;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u001c\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¨\u0006\u0006" }, d2 = { "Landroidx/paging/h;", "previous", "Landroidx/paging/LoadType;", "loadType", "", "a", "paging-common" }, k = 2, mv = { 1, 5, 1 })
public final class v
{
    public static final boolean a(final h h, final h h2, final LoadType loadType) {
        o.g((Object)h, "<this>");
        o.g((Object)h2, "previous");
        o.g((Object)loadType, "loadType");
        return h.a() > h2.a() || (h.a() >= h2.a() && i.a(h.b(), h2.b(), loadType));
    }
}
