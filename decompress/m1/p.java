// 
// Decompiled by Procyon v0.6.0
// 

package m1;

import java.util.UUID;
import java.util.Iterator;
import java.util.ArrayList;
import e1.h;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.BackoffPolicy;
import androidx.work.b;
import androidx.work.WorkInfo;
import java.util.List;
import k.a;

public final class p
{
    private static final String s;
    public static final a<List<c>, List<WorkInfo>> t;
    public String a;
    public WorkInfo.State b;
    public String c;
    public String d;
    public androidx.work.b e;
    public androidx.work.b f;
    public long g;
    public long h;
    public long i;
    public e1.a j;
    public int k;
    public BackoffPolicy l;
    public long m;
    public long n;
    public long o;
    public long p;
    public boolean q;
    public OutOfQuotaPolicy r;
    
    static {
        s = h.f("WorkSpec");
        t = new a<List<c>, List<WorkInfo>>() {
            public List<WorkInfo> a(final List<c> list) {
                if (list == null) {
                    return null;
                }
                final ArrayList list2 = new ArrayList(list.size());
                final Iterator iterator = list.iterator();
                while (iterator.hasNext()) {
                    list2.add(((c)iterator.next()).a());
                }
                return list2;
            }
            
            @Override
            public /* bridge */ Object apply(final Object o) {
                return this.a((List<c>)o);
            }
        };
    }
    
    public p(final String a, final String c) {
        this.b = WorkInfo.State.ENQUEUED;
        final androidx.work.b c2 = androidx.work.b.c;
        this.e = c2;
        this.f = c2;
        this.j = e1.a.i;
        this.l = BackoffPolicy.EXPONENTIAL;
        this.m = 30000L;
        this.p = -1L;
        this.r = OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
        this.a = a;
        this.c = c;
    }
    
    public p(final p p) {
        this.b = WorkInfo.State.ENQUEUED;
        final androidx.work.b c = androidx.work.b.c;
        this.e = c;
        this.f = c;
        this.j = e1.a.i;
        this.l = BackoffPolicy.EXPONENTIAL;
        this.m = 30000L;
        this.p = -1L;
        this.r = OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
        this.a = p.a;
        this.c = p.c;
        this.b = p.b;
        this.d = p.d;
        this.e = new androidx.work.b(p.e);
        this.f = new androidx.work.b(p.f);
        this.g = p.g;
        this.h = p.h;
        this.i = p.i;
        this.j = new e1.a(p.j);
        this.k = p.k;
        this.l = p.l;
        this.m = p.m;
        this.n = p.n;
        this.o = p.o;
        this.p = p.p;
        this.q = p.q;
        this.r = p.r;
    }
    
    public long a() {
        final boolean c = this.c();
        final int n = 0;
        boolean b = false;
        if (c) {
            if (this.l == BackoffPolicy.LINEAR) {
                b = true;
            }
            long n2;
            if (b) {
                n2 = this.m * this.k;
            }
            else {
                n2 = (long)Math.scalb((float)this.m, this.k - 1);
            }
            return this.n + Math.min(18000000L, n2);
        }
        final boolean d = this.d();
        long n3 = 0L;
        if (!d) {
            long n4;
            if ((n4 = this.n) == 0L) {
                n4 = System.currentTimeMillis();
            }
            return n4 + this.g;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        final long n5 = this.n;
        long n6;
        if (n5 == 0L) {
            n6 = currentTimeMillis + this.g;
        }
        else {
            n6 = n5;
        }
        final long i = this.i;
        final long h = this.h;
        int n7 = n;
        if (i != h) {
            n7 = 1;
        }
        if (n7 != 0) {
            if (n5 == 0L) {
                n3 = i * -1L;
            }
            return n6 + h + n3;
        }
        if (n5 != 0L) {
            n3 = h;
        }
        return n6 + n3;
    }
    
    public boolean b() {
        return e1.a.i.equals(this.j) ^ true;
    }
    
    public boolean c() {
        return this.b == WorkInfo.State.ENQUEUED && this.k > 0;
    }
    
    public boolean d() {
        return this.h != 0L;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (o == null || p.class != o.getClass()) {
            return false;
        }
        final p p = (p)o;
        if (this.g != p.g) {
            return false;
        }
        if (this.h != p.h) {
            return false;
        }
        if (this.i != p.i) {
            return false;
        }
        if (this.k != p.k) {
            return false;
        }
        if (this.m != p.m) {
            return false;
        }
        if (this.n != p.n) {
            return false;
        }
        if (this.o != p.o) {
            return false;
        }
        if (this.p != p.p) {
            return false;
        }
        if (this.q != p.q) {
            return false;
        }
        if (!this.a.equals(p.a)) {
            return false;
        }
        if (this.b != p.b) {
            return false;
        }
        if (!this.c.equals(p.c)) {
            return false;
        }
        final String d = this.d;
        Label_0231: {
            if (d != null) {
                if (d.equals(p.d)) {
                    break Label_0231;
                }
            }
            else if (p.d == null) {
                break Label_0231;
            }
            return false;
        }
        if (!this.e.equals(p.e)) {
            return false;
        }
        if (!this.f.equals(p.f)) {
            return false;
        }
        if (!this.j.equals(p.j)) {
            return false;
        }
        if (this.l != p.l) {
            return false;
        }
        if (this.r != p.r) {
            b = false;
        }
        return b;
    }
    
    @Override
    public int hashCode() {
        final int hashCode = this.a.hashCode();
        final int hashCode2 = this.b.hashCode();
        final int hashCode3 = this.c.hashCode();
        final String d = this.d;
        int hashCode4;
        if (d != null) {
            hashCode4 = d.hashCode();
        }
        else {
            hashCode4 = 0;
        }
        final int hashCode5 = this.e.hashCode();
        final int hashCode6 = this.f.hashCode();
        final long g = this.g;
        final int n = (int)(g ^ g >>> 32);
        final long h = this.h;
        final int n2 = (int)(h ^ h >>> 32);
        final long i = this.i;
        final int n3 = (int)(i ^ i >>> 32);
        final int hashCode7 = this.j.hashCode();
        final int k = this.k;
        final int hashCode8 = this.l.hashCode();
        final long m = this.m;
        final int n4 = (int)(m ^ m >>> 32);
        final long n5 = this.n;
        final int n6 = (int)(n5 ^ n5 >>> 32);
        final long o = this.o;
        final int n7 = (int)(o ^ o >>> 32);
        final long p = this.p;
        return ((((((((((((((((hashCode * 31 + hashCode2) * 31 + hashCode3) * 31 + hashCode4) * 31 + hashCode5) * 31 + hashCode6) * 31 + n) * 31 + n2) * 31 + n3) * 31 + hashCode7) * 31 + k) * 31 + hashCode8) * 31 + n4) * 31 + n6) * 31 + n7) * 31 + (int)(p ^ p >>> 32)) * 31 + (this.q ? 1 : 0)) * 31 + this.r.hashCode();
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("{WorkSpec: ");
        sb.append(this.a);
        sb.append("}");
        return sb.toString();
    }
    
    public static class b
    {
        public String a;
        public WorkInfo.State b;
        
        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof b)) {
                return false;
            }
            final b b = (b)o;
            return this.b == b.b && this.a.equals(b.a);
        }
        
        @Override
        public int hashCode() {
            return this.a.hashCode() * 31 + this.b.hashCode();
        }
    }
    
    public static class c
    {
        public String a;
        public WorkInfo.State b;
        public androidx.work.b c;
        public int d;
        public List<String> e;
        public List<androidx.work.b> f;
        
        public WorkInfo a() {
            final List<androidx.work.b> f = this.f;
            androidx.work.b c;
            if (f != null && !f.isEmpty()) {
                c = this.f.get(0);
            }
            else {
                c = androidx.work.b.c;
            }
            return new WorkInfo(UUID.fromString(this.a), this.b, this.c, this.e, c, this.d);
        }
        
        @Override
        public boolean equals(final Object o) {
            boolean equals = true;
            if (this == o) {
                return true;
            }
            if (!(o instanceof c)) {
                return false;
            }
            final c c = (c)o;
            if (this.d != c.d) {
                return false;
            }
            final String a = this.a;
            Label_0068: {
                if (a != null) {
                    if (a.equals(c.a)) {
                        break Label_0068;
                    }
                }
                else if (c.a == null) {
                    break Label_0068;
                }
                return false;
            }
            if (this.b != c.b) {
                return false;
            }
            final androidx.work.b c2 = this.c;
            Label_0113: {
                if (c2 != null) {
                    if (c2.equals(c.c)) {
                        break Label_0113;
                    }
                }
                else if (c.c == null) {
                    break Label_0113;
                }
                return false;
            }
            final List<String> e = this.e;
            Label_0147: {
                if (e != null) {
                    if (e.equals(c.e)) {
                        break Label_0147;
                    }
                }
                else if (c.e == null) {
                    break Label_0147;
                }
                return false;
            }
            final List<androidx.work.b> f = this.f;
            final List<androidx.work.b> f2 = c.f;
            if (f != null) {
                equals = f.equals(f2);
            }
            else if (f2 != null) {
                equals = false;
            }
            return equals;
        }
        
        @Override
        public int hashCode() {
            final String a = this.a;
            int hashCode = 0;
            int hashCode2;
            if (a != null) {
                hashCode2 = a.hashCode();
            }
            else {
                hashCode2 = 0;
            }
            final WorkInfo.State b = this.b;
            int hashCode3;
            if (b != null) {
                hashCode3 = b.hashCode();
            }
            else {
                hashCode3 = 0;
            }
            final androidx.work.b c = this.c;
            int hashCode4;
            if (c != null) {
                hashCode4 = c.hashCode();
            }
            else {
                hashCode4 = 0;
            }
            final int d = this.d;
            final List<String> e = this.e;
            int hashCode5;
            if (e != null) {
                hashCode5 = e.hashCode();
            }
            else {
                hashCode5 = 0;
            }
            final List<androidx.work.b> f = this.f;
            if (f != null) {
                hashCode = f.hashCode();
            }
            return ((((hashCode2 * 31 + hashCode3) * 31 + hashCode4) * 31 + d) * 31 + hashCode5) * 31 + hashCode;
        }
    }
}
