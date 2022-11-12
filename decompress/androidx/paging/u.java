// 
// Decompiled by Procyon v0.6.0
// 

package androidx.paging;

import java.util.List;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.i;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001:\u0003\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004\u0082\u0001\u0003\b\t\n¨\u0006\u000b" }, d2 = { "Landroidx/paging/u;", "", "T", "<init>", "()V", "a", "b", "c", "Landroidx/paging/u$b;", "Landroidx/paging/u$a;", "Landroidx/paging/u$c;", "paging-common" }, k = 1, mv = { 1, 5, 1 })
public abstract class u<T>
{
    private u() {
    }
    
    public u(final i i) {
        this();
    }
    
    @Metadata(bv = {}, d1 = { "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\b\u0018\u0000*\b\b\u0001\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00010\u0003B'\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u0012\u0006\u0010\u0015\u001a\u00020\u0006\u0012\u0006\u0010\u0018\u001a\u00020\u0006¢\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0015\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0011\u001a\u0004\b\u0010\u0010\u0013R\u0017\u0010\u0018\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\u0019\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0013¨\u0006\u001c" }, d2 = { "Landroidx/paging/u$a;", "", "T", "Landroidx/paging/u;", "", "toString", "", "hashCode", "other", "", "equals", "Landroidx/paging/LoadType;", "a", "Landroidx/paging/LoadType;", "()Landroidx/paging/LoadType;", "loadType", "b", "I", "c", "()I", "minPageOffset", "maxPageOffset", "d", "e", "placeholdersRemaining", "pageCount", "<init>", "(Landroidx/paging/LoadType;III)V", "paging-common" }, k = 1, mv = { 1, 5, 1 })
    public static final class a<T> extends u<T>
    {
        private final LoadType a;
        private final int b;
        private final int c;
        private final int d;
        
        public a(final LoadType a, int b, int c, final int d) {
            o.g((Object)a, "loadType");
            super(null);
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            final LoadType refresh = LoadType.REFRESH;
            c = 1;
            if (a != refresh) {
                b = 1;
            }
            else {
                b = 0;
            }
            if (b == 0) {
                throw new IllegalArgumentException("Drop load type must be PREPEND or APPEND".toString());
            }
            if (this.d() > 0) {
                b = 1;
            }
            else {
                b = 0;
            }
            if (b == 0) {
                throw new IllegalArgumentException(o.n("Drop count must be > 0, but was ", (Object)this.d()).toString());
            }
            if (d >= 0) {
                b = c;
            }
            else {
                b = 0;
            }
            if (b != 0) {
                return;
            }
            throw new IllegalArgumentException(o.n("Invalid placeholdersRemaining ", (Object)this.e()).toString());
        }
        
        public final LoadType a() {
            return this.a;
        }
        
        public final int b() {
            return this.c;
        }
        
        public final int c() {
            return this.b;
        }
        
        public final int d() {
            return this.c - this.b + 1;
        }
        
        public final int e() {
            return this.d;
        }
        
        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof a)) {
                return false;
            }
            final a a = (a)o;
            return this.a == a.a && this.b == a.b && this.c == a.c && this.d == a.d;
        }
        
        @Override
        public int hashCode() {
            return ((this.a.hashCode() * 31 + Integer.hashCode(this.b)) * 31 + Integer.hashCode(this.c)) * 31 + Integer.hashCode(this.d);
        }
        
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append("Drop(loadType=");
            sb.append(this.a);
            sb.append(", minPageOffset=");
            sb.append(this.b);
            sb.append(", maxPageOffset=");
            sb.append(this.c);
            sb.append(", placeholdersRemaining=");
            sb.append(this.d);
            sb.append(')');
            return sb.toString();
        }
    }
    
    @Metadata(bv = {}, d1 = { "\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\b\u0018\u0000 !*\b\b\u0001\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00010\u0003:\u0001\u0016BI\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00070\u0006\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b&\u0010'JY\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0014\b\u0002\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00070\u00062\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\fH\u00c6\u0001J\t\u0010\u0011\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\tH\u00d6\u0001J\u0013\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R#\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00070\u00068\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\u000b\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u001e\u001a\u0004\b!\u0010 R\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\u001b\u0010#\u001a\u0004\b\"\u0010%¨\u0006(" }, d2 = { "Landroidx/paging/u$b;", "", "T", "Landroidx/paging/u;", "Landroidx/paging/LoadType;", "loadType", "", "Landroidx/paging/e0;", "pages", "", "placeholdersBefore", "placeholdersAfter", "Landroidx/paging/n;", "sourceLoadStates", "mediatorLoadStates", "b", "", "toString", "hashCode", "other", "", "equals", "a", "Landroidx/paging/LoadType;", "d", "()Landroidx/paging/LoadType;", "Ljava/util/List;", "f", "()Ljava/util/List;", "c", "I", "h", "()I", "g", "e", "Landroidx/paging/n;", "i", "()Landroidx/paging/n;", "<init>", "(Landroidx/paging/LoadType;Ljava/util/List;IILandroidx/paging/n;Landroidx/paging/n;)V", "paging-common" }, k = 1, mv = { 1, 5, 1 })
    public static final class b<T> extends u<T>
    {
        public static final a g;
        private static final b<Object> h;
        private final LoadType a;
        private final List<e0<T>> b;
        private final int c;
        private final int d;
        private final n e;
        private final n f;
        
        static {
            final a a = g = new a(null);
            final List e = kotlin.collections.o.e((Object)e0.e.a());
            final l.c.a b = l.c.b;
            h = u.b.a.d(a, e, 0, 0, new n(b.b(), b.a(), b.a()), null, 16, null);
        }
        
        private b(final LoadType a, final List<e0<T>> b, int c, final int d, final n e, final n f) {
            super(null);
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
            this.f = f;
            final LoadType append = LoadType.APPEND;
            final int n = 0;
            if (a != append && c < 0) {
                c = 0;
            }
            else {
                c = 1;
            }
            if (c == 0) {
                throw new IllegalArgumentException(o.n("Prepend insert defining placeholdersBefore must be > 0, but was ", (Object)this.h()).toString());
            }
            if (a != LoadType.PREPEND && d < 0) {
                c = 0;
            }
            else {
                c = 1;
            }
            if (c == 0) {
                throw new IllegalArgumentException(o.n("Append insert defining placeholdersAfter must be > 0, but was ", (Object)this.g()).toString());
            }
            Label_0119: {
                if (a == LoadType.REFRESH) {
                    c = n;
                    if (!(b.isEmpty() ^ true)) {
                        break Label_0119;
                    }
                }
                c = 1;
            }
            if (c != 0) {
                return;
            }
            throw new IllegalArgumentException("Cannot create a REFRESH Insert event with no TransformablePages as this could permanently stall pagination. Note that this check does not prevent empty LoadResults and is instead usually an indication of an internal error in Paging itself.".toString());
        }
        
        public b(final LoadType loadType, final List list, final int n, final int n2, final n n3, final n n4, final i i) {
            this(loadType, list, n, n2, n3, n4);
        }
        
        public static final b a() {
            return b.h;
        }
        
        public static b c(final b b, LoadType a, List b2, int c, int d, n e, n f, final int n, final Object o) {
            if ((n & 0x1) != 0x0) {
                a = b.a;
            }
            if ((n & 0x2) != 0x0) {
                b2 = b.b;
            }
            if ((n & 0x4) != 0x0) {
                c = b.c;
            }
            if ((n & 0x8) != 0x0) {
                d = b.d;
            }
            if ((n & 0x10) != 0x0) {
                e = b.e;
            }
            if ((n & 0x20) != 0x0) {
                f = b.f;
            }
            return b.b(a, b2, c, d, e, f);
        }
        
        public final b<T> b(final LoadType loadType, final List<e0<T>> list, final int n, final int n2, final n n3, final n n4) {
            o.g((Object)loadType, "loadType");
            o.g((Object)list, "pages");
            o.g((Object)n3, "sourceLoadStates");
            return new b<T>(loadType, list, n, n2, n3, n4);
        }
        
        public final LoadType d() {
            return this.a;
        }
        
        public final n e() {
            return this.f;
        }
        
        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof b)) {
                return false;
            }
            final b b = (b)o;
            return this.a == b.a && o.b((Object)this.b, (Object)b.b) && this.c == b.c && this.d == b.d && o.b((Object)this.e, (Object)b.e) && o.b((Object)this.f, (Object)b.f);
        }
        
        public final List<e0<T>> f() {
            return this.b;
        }
        
        public final int g() {
            return this.d;
        }
        
        public final int h() {
            return this.c;
        }
        
        @Override
        public int hashCode() {
            final int hashCode = this.a.hashCode();
            final int hashCode2 = this.b.hashCode();
            final int hashCode3 = Integer.hashCode(this.c);
            final int hashCode4 = Integer.hashCode(this.d);
            final int hashCode5 = this.e.hashCode();
            final n f = this.f;
            int hashCode6;
            if (f == null) {
                hashCode6 = 0;
            }
            else {
                hashCode6 = f.hashCode();
            }
            return ((((hashCode * 31 + hashCode2) * 31 + hashCode3) * 31 + hashCode4) * 31 + hashCode5) * 31 + hashCode6;
        }
        
        public final n i() {
            return this.e;
        }
        
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append("Insert(loadType=");
            sb.append(this.a);
            sb.append(", pages=");
            sb.append(this.b);
            sb.append(", placeholdersBefore=");
            sb.append(this.c);
            sb.append(", placeholdersAfter=");
            sb.append(this.d);
            sb.append(", sourceLoadStates=");
            sb.append(this.e);
            sb.append(", mediatorLoadStates=");
            sb.append(this.f);
            sb.append(')');
            return sb.toString();
        }
        
        @Metadata(bv = {}, d1 = { "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015JN\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00020\f\"\b\b\u0002\u0010\u0002*\u00020\u00012\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\tJF\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00020\f\"\b\b\u0002\u0010\u0002*\u00020\u00012\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\tJF\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00020\f\"\b\b\u0002\u0010\u0002*\u00020\u00012\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u00040\u00032\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\tR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0016" }, d2 = { "Landroidx/paging/u$b$a;", "", "T", "", "Landroidx/paging/e0;", "pages", "", "placeholdersBefore", "placeholdersAfter", "Landroidx/paging/n;", "sourceLoadStates", "mediatorLoadStates", "Landroidx/paging/u$b;", "c", "b", "a", "EMPTY_REFRESH_LOCAL", "Landroidx/paging/u$b;", "e", "()Landroidx/paging/u$b;", "<init>", "()V", "paging-common" }, k = 1, mv = { 1, 5, 1 })
        public static final class a
        {
            private a() {
            }
            
            public a(final i i) {
                this();
            }
            
            public static b d(final a a, final List list, final int n, final int n2, final n n3, n n4, final int n5, final Object o) {
                if ((n5 & 0x10) != 0x0) {
                    n4 = null;
                }
                return a.c((List<e0<Object>>)list, n, n2, n3, n4);
            }
            
            public final <T> b<T> a(final List<e0<T>> list, final int n, final n n2, final n n3) {
                o.g((Object)list, "pages");
                o.g((Object)n2, "sourceLoadStates");
                return new b<T>(LoadType.APPEND, list, -1, n, n2, n3, null);
            }
            
            public final <T> b<T> b(final List<e0<T>> list, final int n, final n n2, final n n3) {
                o.g((Object)list, "pages");
                o.g((Object)n2, "sourceLoadStates");
                return new b<T>(LoadType.PREPEND, list, n, -1, n2, n3, null);
            }
            
            public final <T> b<T> c(final List<e0<T>> list, final int n, final int n2, final n n3, final n n4) {
                o.g((Object)list, "pages");
                o.g((Object)n3, "sourceLoadStates");
                return new b<T>(LoadType.REFRESH, list, n, n2, n3, n4, null);
            }
            
            public final b<Object> e() {
                return u.b.a();
            }
        }
    }
    
    @Metadata(bv = {}, d1 = { "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u0000*\b\b\u0001\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00010\u0003B\u001b\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\r\u001a\u0004\b\f\u0010\u000f¨\u0006\u0014" }, d2 = { "Landroidx/paging/u$c;", "", "T", "Landroidx/paging/u;", "", "toString", "", "hashCode", "other", "", "equals", "Landroidx/paging/n;", "a", "Landroidx/paging/n;", "b", "()Landroidx/paging/n;", "source", "mediator", "<init>", "(Landroidx/paging/n;Landroidx/paging/n;)V", "paging-common" }, k = 1, mv = { 1, 5, 1 })
    public static final class c<T> extends u<T>
    {
        private final n a;
        private final n b;
        
        public c(final n a, final n b) {
            o.g((Object)a, "source");
            super(null);
            this.a = a;
            this.b = b;
        }
        
        public c(final n n, n n2, final int n3, final i i) {
            if ((n3 & 0x2) != 0x0) {
                n2 = null;
            }
            this(n, n2);
        }
        
        public final n a() {
            return this.b;
        }
        
        public final n b() {
            return this.a;
        }
        
        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof c)) {
                return false;
            }
            final c c = (c)o;
            return o.b((Object)this.a, (Object)c.a) && o.b((Object)this.b, (Object)c.b);
        }
        
        @Override
        public int hashCode() {
            final int hashCode = this.a.hashCode();
            final n b = this.b;
            int hashCode2;
            if (b == null) {
                hashCode2 = 0;
            }
            else {
                hashCode2 = b.hashCode();
            }
            return hashCode * 31 + hashCode2;
        }
        
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append("LoadStateUpdate(source=");
            sb.append(this.a);
            sb.append(", mediator=");
            sb.append(this.b);
            sb.append(')');
            return sb.toString();
        }
    }
}
