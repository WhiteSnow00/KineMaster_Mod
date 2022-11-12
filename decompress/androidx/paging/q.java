// 
// Decompiled by Procyon v0.6.0
// 

package androidx.paging;

import kotlin.jvm.internal.o;
import androidx.recyclerview.widget.i;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\u000b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n¨\u0006\u000e" }, d2 = { "Landroidx/paging/q;", "", "Landroidx/recyclerview/widget/i$e;", "a", "Landroidx/recyclerview/widget/i$e;", "()Landroidx/recyclerview/widget/i$e;", "diff", "", "b", "Z", "()Z", "hasOverlap", "<init>", "(Landroidx/recyclerview/widget/i$e;Z)V", "paging-runtime_release" }, k = 1, mv = { 1, 5, 1 })
public final class q
{
    private final i.e a;
    private final boolean b;
    
    public q(final i.e a, final boolean b) {
        o.g((Object)a, "diff");
        this.a = a;
        this.b = b;
    }
    
    public final i.e a() {
        return this.a;
    }
    
    public final boolean b() {
        return this.b;
    }
}
