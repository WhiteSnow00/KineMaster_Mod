// 
// Decompiled by Procyon v0.6.0
// 

package androidx.paging;

import kotlin.jvm.internal.o;
import kotlin.jvm.internal.i;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\t\nB\u0011\b\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u0082\u0001\u0003\u000b\f\r¨\u0006\u000e" }, d2 = { "Landroidx/paging/l;", "", "", "a", "Z", "()Z", "endOfPaginationReached", "<init>", "(Z)V", "b", "c", "Landroidx/paging/l$c;", "Landroidx/paging/l$b;", "Landroidx/paging/l$a;", "paging-common" }, k = 1, mv = { 1, 5, 1 })
public abstract class l
{
    private final boolean a;
    
    private l(final boolean a) {
        this.a = a;
    }
    
    public l(final boolean b, final i i) {
        this(b);
    }
    
    public final boolean a() {
        return this.a;
    }
    
    @Metadata(bv = {}, d1 = { "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u0017\u0010\u000e\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r¨\u0006\u0011" }, d2 = { "Landroidx/paging/l$a;", "Landroidx/paging/l;", "", "other", "", "equals", "", "hashCode", "", "toString", "", "b", "Ljava/lang/Throwable;", "()Ljava/lang/Throwable;", "error", "<init>", "(Ljava/lang/Throwable;)V", "paging-common" }, k = 1, mv = { 1, 5, 1 })
    public static final class a extends l
    {
        private final Throwable b;
        
        public a(final Throwable b) {
            o.g((Object)b, "error");
            super(false, null);
            this.b = b;
        }
        
        public final Throwable b() {
            return this.b;
        }
        
        @Override
        public boolean equals(final Object o) {
            if (o instanceof a) {
                final boolean a = this.a();
                final a a2 = (a)o;
                if (a == a2.a() && o.b((Object)this.b, (Object)a2.b)) {
                    return true;
                }
            }
            return false;
        }
        
        @Override
        public int hashCode() {
            return Boolean.hashCode(this.a()) + this.b.hashCode();
        }
        
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append("Error(endOfPaginationReached=");
            sb.append(this.a());
            sb.append(", error=");
            sb.append(this.b);
            sb.append(')');
            return sb.toString();
        }
    }
    
    @Metadata(bv = {}, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002J\b\u0010\t\u001a\u00020\bH\u0016¨\u0006\f" }, d2 = { "Landroidx/paging/l$b;", "Landroidx/paging/l;", "", "toString", "", "other", "", "equals", "", "hashCode", "<init>", "()V", "paging-common" }, k = 1, mv = { 1, 5, 1 })
    public static final class b extends l
    {
        public static final b b;
        
        static {
            b = new b();
        }
        
        private b() {
            super(false, null);
        }
        
        @Override
        public boolean equals(final Object o) {
            return o instanceof b && this.a() == ((b)o).a();
        }
        
        @Override
        public int hashCode() {
            return Boolean.hashCode(this.a());
        }
        
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append("Loading(endOfPaginationReached=");
            sb.append(this.a());
            sb.append(')');
            return sb.toString();
        }
    }
    
    @Metadata(bv = {}, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002J\b\u0010\t\u001a\u00020\bH\u0016¨\u0006\u000f" }, d2 = { "Landroidx/paging/l$c;", "Landroidx/paging/l;", "", "toString", "", "other", "", "equals", "", "hashCode", "endOfPaginationReached", "<init>", "(Z)V", "b", "a", "paging-common" }, k = 1, mv = { 1, 5, 1 })
    public static final class c extends l
    {
        public static final a b;
        private static final c c;
        private static final c d;
        
        static {
            b = new a(null);
            c = new c(true);
            d = new c(false);
        }
        
        public c(final boolean b) {
            super(b, null);
        }
        
        public static final c b() {
            return l.c.c;
        }
        
        public static final c c() {
            return l.c.d;
        }
        
        @Override
        public boolean equals(final Object o) {
            return o instanceof c && this.a() == ((c)o).a();
        }
        
        @Override
        public int hashCode() {
            return Boolean.hashCode(this.a());
        }
        
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append("NotLoading(endOfPaginationReached=");
            sb.append(this.a());
            sb.append(')');
            return sb.toString();
        }
        
        @Metadata(bv = {}, d1 = { "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\u000b" }, d2 = { "Landroidx/paging/l$c$a;", "", "Landroidx/paging/l$c;", "Complete", "Landroidx/paging/l$c;", "a", "()Landroidx/paging/l$c;", "Incomplete", "b", "<init>", "()V", "paging-common" }, k = 1, mv = { 1, 5, 1 })
        public static final class a
        {
            private a() {
            }
            
            public a(final i i) {
                this();
            }
            
            public final c a() {
                return l.c.b();
            }
            
            public final c b() {
                return l.c.c();
            }
        }
    }
}
