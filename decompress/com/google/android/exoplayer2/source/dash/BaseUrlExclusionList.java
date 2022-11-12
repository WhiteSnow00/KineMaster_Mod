// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.dash;

import java.util.Comparator;
import java.util.Collections;
import y3.a;
import com.google.common.collect.Iterables;
import java.util.Iterator;
import java.util.HashSet;
import java.util.ArrayList;
import android.os.SystemClock;
import com.google.android.exoplayer2.util.Util;
import java.util.HashMap;
import java.util.Random;
import com.google.android.exoplayer2.source.dash.manifest.BaseUrl;
import android.util.Pair;
import java.util.List;
import java.util.Map;

public final class BaseUrlExclusionList
{
    private final Map<String, Long> a;
    private final Map<Integer, Long> b;
    private final Map<List<Pair<String, Integer>>, BaseUrl> c;
    private final Random d;
    
    public BaseUrlExclusionList() {
        this(new Random());
    }
    
    BaseUrlExclusionList(final Random d) {
        this.c = new HashMap<List<Pair<String, Integer>>, BaseUrl>();
        this.d = d;
        this.a = new HashMap<String, Long>();
        this.b = new HashMap<Integer, Long>();
    }
    
    public static int a(final BaseUrl baseUrl, final BaseUrl baseUrl2) {
        return d(baseUrl, baseUrl2);
    }
    
    private static <T> void b(final T t, final long n, final Map<T, Long> map) {
        long max = n;
        if (map.containsKey(t)) {
            max = Math.max(n, Util.j((Long)map.get(t)));
        }
        map.put(t, max);
    }
    
    private List<BaseUrl> c(final List<BaseUrl> list) {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        h(elapsedRealtime, this.a);
        h(elapsedRealtime, this.b);
        final ArrayList list2 = new ArrayList();
        for (int i = 0; i < list.size(); ++i) {
            final BaseUrl baseUrl = list.get(i);
            if (!this.a.containsKey(baseUrl.b) && !this.b.containsKey(baseUrl.c)) {
                list2.add(baseUrl);
            }
        }
        return list2;
    }
    
    private static int d(final BaseUrl baseUrl, final BaseUrl baseUrl2) {
        int n = Integer.compare(baseUrl.c, baseUrl2.c);
        if (n == 0) {
            n = baseUrl.b.compareTo(baseUrl2.b);
        }
        return n;
    }
    
    public static int f(final List<BaseUrl> list) {
        final HashSet set = new HashSet();
        for (int i = 0; i < list.size(); ++i) {
            set.add(((BaseUrl)list.get(i)).c);
        }
        return set.size();
    }
    
    private static <T> void h(final long n, final Map<T, Long> map) {
        final ArrayList list = new ArrayList();
        for (final Map.Entry<K, Long> entry : map.entrySet()) {
            if (entry.getValue() <= n) {
                list.add(entry.getKey());
            }
        }
        for (int i = 0; i < list.size(); ++i) {
            map.remove(list.get(i));
        }
    }
    
    private BaseUrl k(final List<BaseUrl> list) {
        final int n = 0;
        int i = 0;
        int n2 = 0;
        while (i < list.size()) {
            n2 += list.get(i).d;
            ++i;
        }
        final int nextInt = this.d.nextInt(n2);
        int n3 = 0;
        for (int j = n; j < list.size(); ++j) {
            final BaseUrl baseUrl = list.get(j);
            n3 += baseUrl.d;
            if (nextInt < n3) {
                return baseUrl;
            }
        }
        return (BaseUrl)Iterables.h((Iterable)list);
    }
    
    public void e(final BaseUrl baseUrl, long n) {
        n += SystemClock.elapsedRealtime();
        b(baseUrl.b, n, this.a);
        final int c = baseUrl.c;
        if (c != Integer.MIN_VALUE) {
            b(c, n, this.b);
        }
    }
    
    public int g(final List<BaseUrl> list) {
        final HashSet set = new HashSet();
        final List<BaseUrl> c = this.c(list);
        for (int i = 0; i < c.size(); ++i) {
            set.add(((BaseUrl)c.get(i)).c);
        }
        return set.size();
    }
    
    public void i() {
        this.a.clear();
        this.b.clear();
        this.c.clear();
    }
    
    public BaseUrl j(final List<BaseUrl> list) {
        final List<BaseUrl> c = this.c(list);
        if (c.size() < 2) {
            return (BaseUrl)Iterables.g((Iterable)c, (Object)null);
        }
        Collections.sort((List<Object>)c, (Comparator<? super Object>)y3.a.a);
        final ArrayList list2 = new ArrayList();
        final int c2 = c.get(0).c;
        int i = 0;
        while (i < c.size()) {
            final BaseUrl baseUrl = c.get(i);
            if (c2 != baseUrl.c) {
                if (list2.size() == 1) {
                    return (BaseUrl)c.get(0);
                }
                break;
            }
            else {
                list2.add(new Pair((Object)baseUrl.b, (Object)baseUrl.d));
                ++i;
            }
        }
        BaseUrl k;
        if ((k = this.c.get(list2)) == null) {
            k = this.k(c.subList(0, list2.size()));
            this.c.put(list2, k);
        }
        return k;
    }
}
