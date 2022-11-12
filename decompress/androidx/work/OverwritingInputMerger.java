// 
// Decompiled by Procyon v0.6.0
// 

package androidx.work;

import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import e1.f;

public final class OverwritingInputMerger extends f
{
    @Override
    public b b(final List<b> list) {
        final b.a a = new b.a();
        final HashMap hashMap = new HashMap();
        final Iterator<b> iterator = list.iterator();
        while (iterator.hasNext()) {
            hashMap.putAll(iterator.next().h());
        }
        a.c(hashMap);
        return a.a();
    }
}
