// 
// Decompiled by Procyon v0.6.0
// 

package androidx.paging;

import kotlin.jvm.internal.o;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0081\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\r¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010¨\u0006\u0014" }, d2 = { "Landroidx/paging/h;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "generationId", "Landroidx/paging/g0;", "b", "Landroidx/paging/g0;", "()Landroidx/paging/g0;", "hint", "<init>", "(ILandroidx/paging/g0;)V", "paging-common" }, k = 1, mv = { 1, 5, 1 })
public final class h
{
    private final int a;
    private final g0 b;
    
    public h(final int a, final g0 b) {
        o.g((Object)b, "hint");
        this.a = a;
        this.b = b;
    }
    
    public final int a() {
        return this.a;
    }
    
    public final g0 b() {
        return this.b;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof h)) {
            return false;
        }
        final h h = (h)o;
        return this.a == h.a && o.b((Object)this.b, (Object)h.b);
    }
    
    @Override
    public int hashCode() {
        return Integer.hashCode(this.a) * 31 + this.b.hashCode();
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("GenerationalViewportHint(generationId=");
        sb.append(this.a);
        sb.append(", hint=");
        sb.append(this.b);
        sb.append(')');
        return sb.toString();
    }
}
