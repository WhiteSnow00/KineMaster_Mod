// 
// Decompiled by Procyon v0.6.0
// 

package androidx.room;

import java.util.Collections;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.io.File;
import java.util.Set;
import android.content.Intent;
import java.util.concurrent.Executor;
import s0.a;
import java.util.List;
import android.content.Context;
import v0.h;

public class o
{
    public final h.c a;
    public final Context b;
    public final String c;
    public final RoomDatabase.c d;
    public final List<RoomDatabase.b> e;
    public final List<Object> f;
    public final List<a> g;
    public final boolean h;
    public final RoomDatabase.JournalMode i;
    public final Executor j;
    public final Executor k;
    public final boolean l;
    public final Intent m;
    public final boolean n;
    public final boolean o;
    private final Set<Integer> p;
    public final String q;
    public final File r;
    public final Callable<InputStream> s;
    
    public o(final Context b, final String c, final h.c a, final RoomDatabase.c d, final List<RoomDatabase.b> e, final boolean h, final RoomDatabase.JournalMode i, final Executor j, final Executor k, final Intent m, final boolean n, final boolean o, final Set<Integer> p18, final String q, final File r, final Callable<InputStream> s, final RoomDatabase.d d2, final List<Object> list, List<a> emptyList) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.h = h;
        this.i = i;
        this.j = j;
        this.k = k;
        this.m = m;
        this.l = (m != null);
        this.n = n;
        this.o = o;
        this.p = p18;
        this.q = q;
        this.r = r;
        this.s = s;
        List<Object> emptyList2;
        if (list == null) {
            emptyList2 = Collections.emptyList();
        }
        else {
            emptyList2 = list;
        }
        this.f = emptyList2;
        if (emptyList == null) {
            emptyList = Collections.emptyList();
        }
        this.g = emptyList;
    }
    
    public boolean a(final int n, int n2) {
        final boolean b = true;
        if (n > n2) {
            n2 = 1;
        }
        else {
            n2 = 0;
        }
        if (n2 != 0 && this.o) {
            return false;
        }
        if (this.n) {
            final Set<Integer> p2 = this.p;
            boolean b2 = b;
            if (p2 == null) {
                return b2;
            }
            if (!p2.contains(n)) {
                b2 = b;
                return b2;
            }
        }
        return false;
    }
}
