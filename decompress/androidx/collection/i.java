// 
// Decompiled by Procyon v0.6.0
// 

package androidx.collection;

import ta.a;
import kotlin.jvm.internal.o;
import java.util.Iterator;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0002\u001a\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0004" }, d2 = { "T", "Landroidx/collection/h;", "", "a", "collection-ktx" }, k = 2, mv = { 1, 4, 0 })
public final class i
{
    public static final <T> Iterator<T> a(final h<T> h) {
        o.h((Object)h, "receiver$0");
        return new Iterator<T>(h) {
            private int a;
            final h b;
            
            @Override
            public boolean hasNext() {
                return this.a < this.b.q();
            }
            
            @Override
            public T next() {
                return this.b.r(this.a++);
            }
            
            @Override
            public void remove() {
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }
        };
    }
}
