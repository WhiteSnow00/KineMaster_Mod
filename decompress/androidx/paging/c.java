// 
// Decompiled by Procyon v0.6.0
// 

package androidx.paging;

import java.util.Objects;
import kotlin.jvm.internal.o;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\u0006\u0010\u0017\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0019\u0010\u001aJ\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0017\u0010\u000e\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\u0012\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\n\u0010\rR\u0017\u0010\u0017\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\f\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0014\u001a\u0004\b\u000f\u0010\u0016¨\u0006\u001b" }, d2 = { "Landroidx/paging/c;", "", "other", "", "equals", "", "hashCode", "", "toString", "Landroidx/paging/l;", "a", "Landroidx/paging/l;", "d", "()Landroidx/paging/l;", "refresh", "b", "c", "prepend", "append", "Landroidx/paging/n;", "Landroidx/paging/n;", "e", "()Landroidx/paging/n;", "source", "mediator", "<init>", "(Landroidx/paging/l;Landroidx/paging/l;Landroidx/paging/l;Landroidx/paging/n;Landroidx/paging/n;)V", "paging-common" }, k = 1, mv = { 1, 5, 1 })
public final class c
{
    private final l a;
    private final l b;
    private final l c;
    private final n d;
    private final n e;
    
    public c(final l a, final l b, final l c, final n d, final n e) {
        o.g((Object)a, "refresh");
        o.g((Object)b, "prepend");
        o.g((Object)c, "append");
        o.g((Object)d, "source");
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    public final l a() {
        return this.c;
    }
    
    public final n b() {
        return this.e;
    }
    
    public final l c() {
        return this.b;
    }
    
    public final l d() {
        return this.a;
    }
    
    public final n e() {
        return this.d;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        Object class1;
        if (o == null) {
            class1 = null;
        }
        else {
            class1 = o.getClass();
        }
        if (!o.b((Object)c.class, class1)) {
            return false;
        }
        Objects.requireNonNull(o, "null cannot be cast to non-null type androidx.paging.CombinedLoadStates");
        final c c = (c)o;
        return o.b((Object)this.a, (Object)c.a) && o.b((Object)this.b, (Object)c.b) && o.b((Object)this.c, (Object)c.c) && o.b((Object)this.d, (Object)c.d) && o.b((Object)this.e, (Object)c.e);
    }
    
    @Override
    public int hashCode() {
        final int hashCode = this.a.hashCode();
        final int hashCode2 = this.b.hashCode();
        final int hashCode3 = this.c.hashCode();
        final int hashCode4 = this.d.hashCode();
        final n e = this.e;
        int hashCode5;
        if (e == null) {
            hashCode5 = 0;
        }
        else {
            hashCode5 = e.hashCode();
        }
        return (((hashCode * 31 + hashCode2) * 31 + hashCode3) * 31 + hashCode4) * 31 + hashCode5;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("CombinedLoadStates(refresh=");
        sb.append(this.a);
        sb.append(", prepend=");
        sb.append(this.b);
        sb.append(", append=");
        sb.append(this.c);
        sb.append(", source=");
        sb.append(this.d);
        sb.append(", mediator=");
        sb.append(this.e);
        sb.append(')');
        return sb.toString();
    }
}
