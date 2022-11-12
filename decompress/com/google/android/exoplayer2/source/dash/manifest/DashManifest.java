// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.dash.manifest;

import com.google.android.exoplayer2.util.Util;
import java.util.Collection;
import java.util.ArrayList;
import com.google.android.exoplayer2.offline.StreamKey;
import java.util.LinkedList;
import java.util.Collections;
import java.util.List;
import android.net.Uri;
import com.google.android.exoplayer2.offline.FilterableManifest;

public class DashManifest implements FilterableManifest<DashManifest>
{
    public final long a;
    public final long b;
    public final long c;
    public final boolean d;
    public final long e;
    public final long f;
    public final long g;
    public final long h;
    public final UtcTimingElement i;
    public final ServiceDescriptionElement j;
    public final Uri k;
    public final ProgramInformation l;
    private final List<Period> m;
    
    public DashManifest(final long a, final long b, final long c, final boolean d, final long e, final long f, final long g, final long h, final ProgramInformation l, final UtcTimingElement i, final ServiceDescriptionElement j, final Uri k, final List<Period> list) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.l = l;
        this.i = i;
        this.k = k;
        this.j = j;
        Object emptyList;
        if (list == null) {
            emptyList = Collections.emptyList();
        }
        else {
            emptyList = list;
        }
        this.m = (List<Period>)emptyList;
    }
    
    private static ArrayList<AdaptationSet> c(final List<AdaptationSet> list, final LinkedList<StreamKey> list2) {
        StreamKey streamKey = list2.poll();
        final int a = streamKey.a;
        final ArrayList list3 = new ArrayList();
        StreamKey streamKey2;
        do {
            final int b = streamKey.b;
            final AdaptationSet set = list.get(b);
            final List<Representation> c = set.c;
            final ArrayList<Representation> list4 = new ArrayList<Representation>();
            do {
                list4.add(c.get(streamKey.c));
                streamKey2 = list2.poll();
                if (streamKey2.a != a) {
                    break;
                }
                streamKey = streamKey2;
            } while (streamKey2.b == b);
            list3.add(new AdaptationSet(set.a, set.b, list4, set.d, set.e, set.f));
            streamKey = streamKey2;
        } while (streamKey2.a == a);
        list2.addFirst(streamKey2);
        return list3;
    }
    
    @Override
    public /* bridge */ Object a(final List list) {
        return this.b(list);
    }
    
    public final DashManifest b(final List<StreamKey> list) {
        final LinkedList list2 = new LinkedList((Collection<? extends E>)list);
        Collections.sort((List<Comparable>)list2);
        list2.add(new StreamKey(-1, -1, -1));
        final ArrayList list3 = new ArrayList();
        long n = 0L;
        int n2 = 0;
        long n3;
        while (true) {
            final int e = this.e();
            n3 = -9223372036854775807L;
            if (n2 >= e) {
                break;
            }
            long n4;
            if (list2.peek().a != n2) {
                final long f = this.f(n2);
                n4 = n;
                if (f != -9223372036854775807L) {
                    n4 = n + f;
                }
            }
            else {
                final Period d = this.d(n2);
                list3.add(new Period(d.a, d.b - n, c(d.c, list2), d.d));
                n4 = n;
            }
            ++n2;
            n = n4;
        }
        final long b = this.b;
        if (b != -9223372036854775807L) {
            n3 = b - n;
        }
        return new DashManifest(this.a, n3, this.c, this.d, this.e, this.f, this.g, this.h, this.l, this.i, this.j, this.k, list3);
    }
    
    public final Period d(final int n) {
        return this.m.get(n);
    }
    
    public final int e() {
        return this.m.size();
    }
    
    public final long f(final int n) {
        final int size = this.m.size();
        long n2 = -9223372036854775807L;
        if (n == size - 1) {
            final long b = this.b;
            if (b != -9223372036854775807L) {
                n2 = b - this.m.get(n).b;
            }
        }
        else {
            n2 = this.m.get(n + 1).b - this.m.get(n).b;
        }
        return n2;
    }
    
    public final long g(final int n) {
        return Util.C0(this.f(n));
    }
}
