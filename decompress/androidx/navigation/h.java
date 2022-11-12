// 
// Decompiled by Procyon v0.6.0
// 

package androidx.navigation;

import android.os.Bundle;
import kotlin.jvm.internal.o;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001:\u0001\u0010B3\b\u0000\u0012\u000e\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000f\u0012\u0006\u0010\u0018\u001a\u00020\b\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u001e\u001a\u00020\b¢\u0006\u0004\b\u001f\u0010 J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\n\u001a\u00020\u0002H\u0016J\u0013\u0010\f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000e\u001a\u00020\rH\u0016R\u001f\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R\u0017\u0010\u0018\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0019\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0015\u001a\u0004\b\u0014\u0010\u0017R\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00018\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006!" }, d2 = { "Landroidx/navigation/h;", "", "", "name", "Landroid/os/Bundle;", "bundle", "Lka/r;", "d", "", "e", "toString", "other", "equals", "", "hashCode", "Landroidx/navigation/t;", "a", "Landroidx/navigation/t;", "()Landroidx/navigation/t;", "type", "b", "Z", "c", "()Z", "isNullable", "isDefaultValuePresent", "Ljava/lang/Object;", "getDefaultValue", "()Ljava/lang/Object;", "defaultValue", "defaultValuePresent", "<init>", "(Landroidx/navigation/t;ZLjava/lang/Object;Z)V", "navigation-common_release" }, k = 1, mv = { 1, 6, 0 })
public final class h
{
    private final t<Object> a;
    private final boolean b;
    private final boolean c;
    private final Object d;
    
    public h(final t<Object> a, final boolean b, Object d, final boolean c) {
        o.g((Object)a, "type");
        final boolean c2 = a.c();
        final int n = 0;
        if (!c2 && b) {
            d = new StringBuilder();
            ((StringBuilder)d).append(a.b());
            ((StringBuilder)d).append(" does not allow nullable values");
            throw new IllegalArgumentException(((StringBuilder)d).toString().toString());
        }
        int n2 = 0;
        Label_0065: {
            if (!b && c) {
                n2 = n;
                if (d == null) {
                    break Label_0065;
                }
            }
            n2 = 1;
        }
        if (n2 != 0) {
            this.a = a;
            this.b = b;
            this.d = d;
            this.c = c;
            return;
        }
        d = new StringBuilder();
        ((StringBuilder)d).append("Argument with type ");
        ((StringBuilder)d).append(a.b());
        ((StringBuilder)d).append(" has null value but is not nullable.");
        throw new IllegalArgumentException(((StringBuilder)d).toString().toString());
    }
    
    public final t<Object> a() {
        return this.a;
    }
    
    public final boolean b() {
        return this.c;
    }
    
    public final boolean c() {
        return this.b;
    }
    
    public final void d(final String s, final Bundle bundle) {
        o.g((Object)s, "name");
        o.g((Object)bundle, "bundle");
        if (this.c) {
            this.a.f(bundle, s, this.d);
        }
    }
    
    public final boolean e(final String s, final Bundle bundle) {
        o.g((Object)s, "name");
        o.g((Object)bundle, "bundle");
        if (!this.b && bundle.containsKey(s) && bundle.get(s) == null) {
            return false;
        }
        try {
            this.a.a(bundle, s);
            return true;
        }
        catch (final ClassCastException ex) {
            return false;
        }
    }
    
    @Override
    public boolean equals(Object d) {
        boolean b = true;
        if (this == d) {
            return true;
        }
        if (d == null || !o.b((Object)h.class, (Object)d.getClass())) {
            return false;
        }
        final h h = (h)d;
        if (this.b != h.b) {
            return false;
        }
        if (this.c != h.c) {
            return false;
        }
        if (!o.b((Object)this.a, (Object)h.a)) {
            return false;
        }
        d = this.d;
        if (d != null) {
            b = o.b(d, h.d);
        }
        else if (h.d != null) {
            b = false;
        }
        return b;
    }
    
    @Override
    public int hashCode() {
        final int hashCode = this.a.hashCode();
        final int b = this.b ? 1 : 0;
        final int c = this.c ? 1 : 0;
        final Object d = this.d;
        int hashCode2;
        if (d != null) {
            hashCode2 = d.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        return ((hashCode * 31 + b) * 31 + c) * 31 + hashCode2;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(h.class.getSimpleName());
        final StringBuilder sb2 = new StringBuilder();
        sb2.append(" Type: ");
        sb2.append(this.a);
        sb.append(sb2.toString());
        final StringBuilder sb3 = new StringBuilder();
        sb3.append(" Nullable: ");
        sb3.append(this.b);
        sb.append(sb3.toString());
        if (this.c) {
            final StringBuilder sb4 = new StringBuilder();
            sb4.append(" DefaultValue: ");
            sb4.append(this.d);
            sb.append(sb4.toString());
        }
        final String string = sb.toString();
        o.f((Object)string, "sb.toString()");
        return string;
    }
    
    @Metadata(bv = {}, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0005\u001a\u00020\u0000\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\n\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u0001J\u0006\u0010\f\u001a\u00020\u000bR \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000eR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u000e¨\u0006\u0013" }, d2 = { "Landroidx/navigation/h$a;", "", "T", "Landroidx/navigation/t;", "type", "d", "", "isNullable", "c", "defaultValue", "b", "Landroidx/navigation/h;", "a", "Landroidx/navigation/t;", "Z", "Ljava/lang/Object;", "defaultValuePresent", "<init>", "()V", "navigation-common_release" }, k = 1, mv = { 1, 6, 0 })
    public static final class a
    {
        private t<Object> a;
        private boolean b;
        private Object c;
        private boolean d;
        
        public final h a() {
            t<Object> t;
            if ((t = this.a) == null) {
                t = androidx.navigation.t.c.c(this.c);
            }
            return new h(t, this.b, this.c, this.d);
        }
        
        public final a b(final Object c) {
            this.c = c;
            this.d = true;
            return this;
        }
        
        public final a c(final boolean b) {
            this.b = b;
            return this;
        }
        
        public final <T> a d(final t<T> a) {
            o.g((Object)a, "type");
            this.a = (t<Object>)a;
            return this;
        }
    }
}
