// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import java.util.AbstractCollection;
import android.net.Uri;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.source.ads.AdPlaybackState;
import java.util.List;
import java.util.ArrayList;
import com.google.android.exoplayer2.util.Assertions;
import android.util.Pair;
import com.google.common.collect.ImmutableList$Builder;
import android.os.IBinder;
import com.google.common.collect.ImmutableList;
import com.google.android.exoplayer2.util.BundleUtil;
import android.os.Bundle;

public abstract class Timeline implements Bundleable
{
    public static final Timeline a;
    public static final Creator<Timeline> b;
    
    static {
        a = new Timeline() {
            @Override
            public int f(final Object o) {
                return -1;
            }
            
            @Override
            public Period k(final int n, final Period period, final boolean b) {
                throw new IndexOutOfBoundsException();
            }
            
            @Override
            public int m() {
                return 0;
            }
            
            @Override
            public Object q(final int n) {
                throw new IndexOutOfBoundsException();
            }
            
            @Override
            public Window s(final int n, final Window window, final long n2) {
                throw new IndexOutOfBoundsException();
            }
            
            @Override
            public int t() {
                return 0;
            }
        };
        b = v1.a;
    }
    
    protected Timeline() {
    }
    
    public static Timeline a(final Bundle bundle) {
        return b(bundle);
    }
    
    private static Timeline b(final Bundle bundle) {
        final com.google.common.collect.ImmutableList<Window> c = c(Window.F, BundleUtil.a(bundle, w(0)));
        final com.google.common.collect.ImmutableList<Period> c2 = c(Period.h, BundleUtil.a(bundle, w(1)));
        int[] array;
        if ((array = bundle.getIntArray(w(2))) == null) {
            array = d(((AbstractCollection)c).size());
        }
        return new RemotableTimeline(c, c2, array);
    }
    
    private static <T extends Bundleable> ImmutableList<T> c(final Creator<T> creator, final IBinder binder) {
        if (binder == null) {
            return (ImmutableList<T>)ImmutableList.of();
        }
        final ImmutableList$Builder immutableList$Builder = new ImmutableList$Builder();
        final ImmutableList<Bundle> a = BundleListRetriever.a(binder);
        for (int i = 0; i < ((List)a).size(); ++i) {
            immutableList$Builder.i((Object)creator.a(((List<Bundle>)a).get(i)));
        }
        return (ImmutableList<T>)immutableList$Builder.l();
    }
    
    private static int[] d(final int n) {
        final int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            array[i] = i;
        }
        return array;
    }
    
    private static String w(final int n) {
        return Integer.toString(n, 36);
    }
    
    public int e(final boolean b) {
        int n;
        if (this.u()) {
            n = -1;
        }
        else {
            n = 0;
        }
        return n;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Timeline)) {
            return false;
        }
        final Timeline timeline = (Timeline)o;
        if (timeline.t() != this.t() || timeline.m() != this.m()) {
            return false;
        }
        final Window window = new Window();
        final Period period = new Period();
        final Window window2 = new Window();
        final Period period2 = new Period();
        for (int i = 0; i < this.t(); ++i) {
            if (!this.r(i, window).equals(timeline.r(i, window2))) {
                return false;
            }
        }
        for (int j = 0; j < this.m(); ++j) {
            if (!this.k(j, period, true).equals(timeline.k(j, period2, true))) {
                return false;
            }
        }
        int k = this.e(true);
        if (k != timeline.e(true)) {
            return false;
        }
        final int g = this.g(true);
        if (g != timeline.g(true)) {
            return false;
        }
        while (k != g) {
            final int l = this.i(k, 0, true);
            if (l != timeline.i(k, 0, true)) {
                return false;
            }
            k = l;
        }
        return true;
    }
    
    public abstract int f(final Object p0);
    
    public int g(final boolean b) {
        int n;
        if (this.u()) {
            n = -1;
        }
        else {
            n = this.t() - 1;
        }
        return n;
    }
    
    public final int h(int i, final Period period, final Window window, final int n, final boolean b) {
        final int c = this.j(i, period).c;
        if (this.r(c, window).A != i) {
            return i + 1;
        }
        i = this.i(c, n, b);
        if (i == -1) {
            return -1;
        }
        return this.r(i, window).z;
    }
    
    @Override
    public int hashCode() {
        final Window window = new Window();
        final Period period = new Period();
        int n = 217 + this.t();
        for (int i = 0; i < this.t(); ++i) {
            n = n * 31 + this.r(i, window).hashCode();
        }
        int n2 = n * 31 + this.m();
        for (int j = 0; j < this.m(); ++j) {
            n2 = n2 * 31 + this.k(j, period, true).hashCode();
        }
        for (int k = this.e(true); k != -1; k = this.i(k, 0, true)) {
            n2 = n2 * 31 + k;
        }
        return n2;
    }
    
    public int i(int e, final int n, final boolean b) {
        if (n == 0) {
            if (e == this.g(b)) {
                e = -1;
            }
            else {
                ++e;
            }
            return e;
        }
        if (n == 1) {
            return e;
        }
        if (n == 2) {
            if (e == this.g(b)) {
                e = this.e(b);
            }
            else {
                ++e;
            }
            return e;
        }
        throw new IllegalStateException();
    }
    
    public final Period j(final int n, final Period period) {
        return this.k(n, period, false);
    }
    
    public abstract Period k(final int p0, final Period p1, final boolean p2);
    
    public Period l(final Object o, final Period period) {
        return this.k(this.f(o), period, true);
    }
    
    public abstract int m();
    
    public final Pair<Object, Long> n(final Window window, final Period period, final int n, final long n2) {
        return Assertions.e(this.o(window, period, n, n2, 0L));
    }
    
    public final Pair<Object, Long> o(final Window window, final Period period, int z, long n, long f) {
        Assertions.c(z, 0, this.t());
        this.s(z, window, f);
        f = n;
        if (n == -9223372036854775807L) {
            n = (f = window.f());
            if (n == -9223372036854775807L) {
                return null;
            }
        }
        z = window.z;
        this.j(z, period);
        while (z < window.A && period.e != f) {
            final int n2 = z + 1;
            if (this.j(n2, period).e > f) {
                break;
            }
            z = n2;
        }
        this.k(z, period, true);
        f -= period.e;
        final long d = period.d;
        n = f;
        if (d != -9223372036854775807L) {
            n = Math.min(f, d - 1L);
        }
        n = Math.max(0L, n);
        return (Pair<Object, Long>)Pair.create(Assertions.e(period.b), (Object)n);
    }
    
    public int p(int g, final int n, final boolean b) {
        if (n == 0) {
            if (g == this.e(b)) {
                g = -1;
            }
            else {
                --g;
            }
            return g;
        }
        if (n == 1) {
            return g;
        }
        if (n == 2) {
            if (g == this.e(b)) {
                g = this.g(b);
            }
            else {
                --g;
            }
            return g;
        }
        throw new IllegalStateException();
    }
    
    public abstract Object q(final int p0);
    
    public final Window r(final int n, final Window window) {
        return this.s(n, window, 0L);
    }
    
    public abstract Window s(final int p0, final Window p1, final long p2);
    
    public abstract int t();
    
    @Override
    public final Bundle toBundle() {
        return this.x(false);
    }
    
    public final boolean u() {
        return this.t() == 0;
    }
    
    public final boolean v(final int n, final Period period, final Window window, final int n2, final boolean b) {
        return this.h(n, period, window, n2, b) == -1;
    }
    
    public final Bundle x(final boolean b) {
        final ArrayList list = new ArrayList();
        final int t = this.t();
        final Window window = new Window();
        for (int i = 0; i < t; ++i) {
            list.add(Window.b(this.s(i, window, 0L), b));
        }
        final ArrayList list2 = new ArrayList();
        final int m = this.m();
        final Period period = new Period();
        for (int j = 0; j < m; ++j) {
            list2.add(this.k(j, period, false).toBundle());
        }
        final int[] array = new int[t];
        if (t > 0) {
            array[0] = this.e(true);
        }
        for (int k = 1; k < t; ++k) {
            array[k] = this.i(array[k - 1], 0, true);
        }
        final Bundle bundle = new Bundle();
        BundleUtil.c(bundle, w(0), (IBinder)new BundleListRetriever(list));
        BundleUtil.c(bundle, w(1), (IBinder)new BundleListRetriever(list2));
        bundle.putIntArray(w(2), array);
        return bundle;
    }
    
    public static final class Period implements Bundleable
    {
        public static final Creator<Period> h;
        public Object a;
        public Object b;
        public int c;
        public long d;
        public long e;
        public boolean f;
        private AdPlaybackState g;
        
        static {
            h = w1.a;
        }
        
        public Period() {
            this.g = AdPlaybackState.g;
        }
        
        public static Period a(final Bundle bundle) {
            return c(bundle);
        }
        
        static AdPlaybackState b(final Period period) {
            return period.g;
        }
        
        private static Period c(Bundle bundle) {
            final int int1 = bundle.getInt(v(0), 0);
            final long long1 = bundle.getLong(v(1), -9223372036854775807L);
            final long long2 = bundle.getLong(v(2), 0L);
            final boolean boolean1 = bundle.getBoolean(v(3));
            bundle = bundle.getBundle(v(4));
            AdPlaybackState g;
            if (bundle != null) {
                g = AdPlaybackState.i.a(bundle);
            }
            else {
                g = AdPlaybackState.g;
            }
            final Period period = new Period();
            period.x(null, null, int1, long1, long2, g, boolean1);
            return period;
        }
        
        private static String v(final int n) {
            return Integer.toString(n, 36);
        }
        
        public int d(final int n) {
            return this.g.c(n).b;
        }
        
        public long e(final int n, final int n2) {
            final AdPlaybackState.AdGroup c = this.g.c(n);
            long n3;
            if (c.b != -1) {
                n3 = c.e[n2];
            }
            else {
                n3 = -9223372036854775807L;
            }
            return n3;
        }
        
        @Override
        public boolean equals(final Object o) {
            boolean b = true;
            if (this == o) {
                return true;
            }
            if (o != null && Period.class.equals(o.getClass())) {
                final Period period = (Period)o;
                if (!Util.c(this.a, period.a) || !Util.c(this.b, period.b) || this.c != period.c || this.d != period.d || this.e != period.e || this.f != period.f || !Util.c(this.g, period.g)) {
                    b = false;
                }
                return b;
            }
            return false;
        }
        
        public int f() {
            return this.g.b;
        }
        
        public int g(final long n) {
            return this.g.d(n, this.d);
        }
        
        public int h(final long n) {
            return this.g.e(n, this.d);
        }
        
        @Override
        public int hashCode() {
            final Object a = this.a;
            int hashCode = 0;
            int hashCode2;
            if (a == null) {
                hashCode2 = 0;
            }
            else {
                hashCode2 = a.hashCode();
            }
            final Object b = this.b;
            if (b != null) {
                hashCode = b.hashCode();
            }
            final int c = this.c;
            final long d = this.d;
            final int n = (int)(d ^ d >>> 32);
            final long e = this.e;
            return ((((((217 + hashCode2) * 31 + hashCode) * 31 + c) * 31 + n) * 31 + (int)(e ^ e >>> 32)) * 31 + (this.f ? 1 : 0)) * 31 + this.g.hashCode();
        }
        
        public long i(final int n) {
            return this.g.c(n).a;
        }
        
        public long j() {
            return this.g.c;
        }
        
        public int k(int n, final int n2) {
            final AdPlaybackState.AdGroup c = this.g.c(n);
            if (c.b != -1) {
                n = c.d[n2];
            }
            else {
                n = 0;
            }
            return n;
        }
        
        public long l(final int n) {
            return this.g.c(n).f;
        }
        
        public long m() {
            return Util.f1(this.d);
        }
        
        public long n() {
            return this.d;
        }
        
        public int o(final int n) {
            return this.g.c(n).e();
        }
        
        public int p(final int n, final int n2) {
            return this.g.c(n).f(n2);
        }
        
        public long q() {
            return Util.f1(this.e);
        }
        
        public long r() {
            return this.e;
        }
        
        public int s() {
            return this.g.e;
        }
        
        public boolean t(final int n) {
            return this.g.c(n).g() ^ true;
        }
        
        @Override
        public Bundle toBundle() {
            final Bundle bundle = new Bundle();
            bundle.putInt(v(0), this.c);
            bundle.putLong(v(1), this.d);
            bundle.putLong(v(2), this.e);
            bundle.putBoolean(v(3), this.f);
            bundle.putBundle(v(4), this.g.toBundle());
            return bundle;
        }
        
        public boolean u(final int n) {
            return this.g.c(n).g;
        }
        
        public Period w(final Object o, final Object o2, final int n, final long n2, final long n3) {
            return this.x(o, o2, n, n2, n3, AdPlaybackState.g, false);
        }
        
        public Period x(final Object a, final Object b, final int c, final long d, final long e, final AdPlaybackState g, final boolean f) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
            this.g = g;
            this.f = f;
            return this;
        }
    }
    
    public static final class RemotableTimeline extends Timeline
    {
        private final ImmutableList<Window> c;
        private final ImmutableList<Period> d;
        private final int[] e;
        private final int[] f;
        
        public RemotableTimeline(final ImmutableList<Window> c, final ImmutableList<Period> d, final int[] e) {
            final int size = ((AbstractCollection)c).size();
            final int length = e.length;
            int i = 0;
            Assertions.a(size == length);
            this.c = c;
            this.d = d;
            this.e = e;
            this.f = new int[e.length];
            while (i < e.length) {
                this.f[e[i]] = i;
                ++i;
            }
        }
        
        @Override
        public int e(final boolean b) {
            if (this.u()) {
                return -1;
            }
            int n = 0;
            if (b) {
                n = this.e[0];
            }
            return n;
        }
        
        @Override
        public int f(final Object o) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public int g(final boolean b) {
            if (this.u()) {
                return -1;
            }
            int n;
            if (b) {
                n = this.e[this.t() - 1];
            }
            else {
                n = this.t() - 1;
            }
            return n;
        }
        
        @Override
        public int i(int e, final int n, final boolean b) {
            if (n == 1) {
                return e;
            }
            if (e == this.g(b)) {
                if (n == 2) {
                    e = this.e(b);
                }
                else {
                    e = -1;
                }
                return e;
            }
            if (b) {
                e = this.e[this.f[e] + 1];
            }
            else {
                ++e;
            }
            return e;
        }
        
        @Override
        public Period k(final int n, final Period period, final boolean b) {
            final Period period2 = ((List<Period>)this.d).get(n);
            period.x(period2.a, period2.b, period2.c, period2.d, period2.e, Period.b(period2), period2.f);
            return period;
        }
        
        @Override
        public int m() {
            return ((AbstractCollection)this.d).size();
        }
        
        @Override
        public int p(int g, final int n, final boolean b) {
            if (n == 1) {
                return g;
            }
            if (g == this.e(b)) {
                if (n == 2) {
                    g = this.g(b);
                }
                else {
                    g = -1;
                }
                return g;
            }
            if (b) {
                g = this.e[this.f[g] - 1];
            }
            else {
                --g;
            }
            return g;
        }
        
        @Override
        public Object q(final int n) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public Window s(final int n, final Window window, final long n2) {
            final Window window2 = ((List<Window>)this.c).get(n);
            window.k(window2.a, window2.c, window2.d, window2.e, window2.f, window2.g, window2.h, window2.i, window2.p, window2.x, window2.y, window2.z, window2.A, window2.B);
            window.w = window2.w;
            return window;
        }
        
        @Override
        public int t() {
            return ((AbstractCollection)this.c).size();
        }
    }
    
    public static final class Window implements Bundleable
    {
        public static final Object C;
        private static final Object D;
        private static final MediaItem E;
        public static final Creator<Window> F;
        public int A;
        public long B;
        public Object a;
        @Deprecated
        public Object b;
        public MediaItem c;
        public Object d;
        public long e;
        public long f;
        public long g;
        public boolean h;
        public boolean i;
        @Deprecated
        public boolean j;
        public MediaItem.LiveConfiguration p;
        public boolean w;
        public long x;
        public long y;
        public int z;
        
        static {
            C = new Object();
            D = new Object();
            E = new MediaItem.Builder().e("com.google.android.exoplayer2.Timeline").i(Uri.EMPTY).a();
            F = x1.a;
        }
        
        public Window() {
            this.a = Window.C;
            this.c = Window.E;
        }
        
        public static Window a(final Bundle bundle) {
            return c(bundle);
        }
        
        static Bundle b(final Window window, final boolean b) {
            return window.l(b);
        }
        
        private static Window c(final Bundle bundle) {
            final Bundle bundle2 = bundle.getBundle(j(1));
            MediaItem.LiveConfiguration liveConfiguration = null;
            MediaItem mediaItem;
            if (bundle2 != null) {
                mediaItem = MediaItem.j.a(bundle2);
            }
            else {
                mediaItem = null;
            }
            final long long1 = bundle.getLong(j(2), -9223372036854775807L);
            final long long2 = bundle.getLong(j(3), -9223372036854775807L);
            final long long3 = bundle.getLong(j(4), -9223372036854775807L);
            final boolean boolean1 = bundle.getBoolean(j(5), false);
            final boolean boolean2 = bundle.getBoolean(j(6), false);
            final Bundle bundle3 = bundle.getBundle(j(7));
            if (bundle3 != null) {
                liveConfiguration = (MediaItem.LiveConfiguration)MediaItem.LiveConfiguration.g.a(bundle3);
            }
            final boolean boolean3 = bundle.getBoolean(j(8), false);
            final long long4 = bundle.getLong(j(9), 0L);
            final long long5 = bundle.getLong(j(10), -9223372036854775807L);
            final int int1 = bundle.getInt(j(11), 0);
            final int int2 = bundle.getInt(j(12), 0);
            final long long6 = bundle.getLong(j(13), 0L);
            final Window window = new Window();
            window.k(Window.D, mediaItem, null, long1, long2, long3, boolean1, boolean2, liveConfiguration, long4, long5, int1, int2, long6);
            window.w = boolean3;
            return window;
        }
        
        private static String j(final int n) {
            return Integer.toString(n, 36);
        }
        
        private final Bundle l(final boolean b) {
            final Bundle bundle = new Bundle();
            final String j = j(1);
            MediaItem mediaItem;
            if (b) {
                mediaItem = MediaItem.i;
            }
            else {
                mediaItem = this.c;
            }
            bundle.putBundle(j, mediaItem.toBundle());
            bundle.putLong(j(2), this.e);
            bundle.putLong(j(3), this.f);
            bundle.putLong(j(4), this.g);
            bundle.putBoolean(j(5), this.h);
            bundle.putBoolean(j(6), this.i);
            final MediaItem.LiveConfiguration p = this.p;
            if (p != null) {
                bundle.putBundle(j(7), p.toBundle());
            }
            bundle.putBoolean(j(8), this.w);
            bundle.putLong(j(9), this.x);
            bundle.putLong(j(10), this.y);
            bundle.putInt(j(11), this.z);
            bundle.putInt(j(12), this.A);
            bundle.putLong(j(13), this.B);
            return bundle;
        }
        
        public long d() {
            return Util.b0(this.g);
        }
        
        public long e() {
            return Util.f1(this.x);
        }
        
        @Override
        public boolean equals(final Object o) {
            boolean b = true;
            if (this == o) {
                return true;
            }
            if (o != null && Window.class.equals(o.getClass())) {
                final Window window = (Window)o;
                if (!Util.c(this.a, window.a) || !Util.c(this.c, window.c) || !Util.c(this.d, window.d) || !Util.c(this.p, window.p) || this.e != window.e || this.f != window.f || this.g != window.g || this.h != window.h || this.i != window.i || this.w != window.w || this.x != window.x || this.y != window.y || this.z != window.z || this.A != window.A || this.B != window.B) {
                    b = false;
                }
                return b;
            }
            return false;
        }
        
        public long f() {
            return this.x;
        }
        
        public long g() {
            return Util.f1(this.y);
        }
        
        public long h() {
            return this.B;
        }
        
        @Override
        public int hashCode() {
            final int hashCode = this.a.hashCode();
            final int hashCode2 = this.c.hashCode();
            final Object d = this.d;
            int hashCode3 = 0;
            int hashCode4;
            if (d == null) {
                hashCode4 = 0;
            }
            else {
                hashCode4 = d.hashCode();
            }
            final MediaItem.LiveConfiguration p = this.p;
            if (p != null) {
                hashCode3 = p.hashCode();
            }
            final long e = this.e;
            final int n = (int)(e ^ e >>> 32);
            final long f = this.f;
            final int n2 = (int)(f ^ f >>> 32);
            final long g = this.g;
            final int n3 = (int)(g ^ g >>> 32);
            final int h = this.h ? 1 : 0;
            final int i = this.i ? 1 : 0;
            final int w = this.w ? 1 : 0;
            final long x = this.x;
            final int n4 = (int)(x ^ x >>> 32);
            final long y = this.y;
            final int n5 = (int)(y ^ y >>> 32);
            final int z = this.z;
            final int a = this.A;
            final long b = this.B;
            return ((((((((((((((217 + hashCode) * 31 + hashCode2) * 31 + hashCode4) * 31 + hashCode3) * 31 + n) * 31 + n2) * 31 + n3) * 31 + h) * 31 + i) * 31 + w) * 31 + n4) * 31 + n5) * 31 + z) * 31 + a) * 31 + (int)(b ^ b >>> 32);
        }
        
        public boolean i() {
            final boolean j = this.j;
            final MediaItem.LiveConfiguration p = this.p;
            final boolean b = true;
            Assertions.g(j == (p != null));
            return this.p != null && b;
        }
        
        public Window k(Object i, final MediaItem mediaItem, final Object d, final long e, final long f, final long g, final boolean h, final boolean j, final MediaItem.LiveConfiguration p14, final long x, final long y, final int z, final int a, final long b) {
            this.a = i;
            MediaItem e2;
            if (mediaItem != null) {
                e2 = mediaItem;
            }
            else {
                e2 = Window.E;
            }
            this.c = e2;
            Label_0046: {
                if (mediaItem != null) {
                    final MediaItem.LocalConfiguration b2 = mediaItem.b;
                    if (b2 != null) {
                        i = b2.i;
                        break Label_0046;
                    }
                }
                i = null;
            }
            this.b = i;
            this.d = d;
            this.e = e;
            this.f = f;
            this.g = g;
            this.h = h;
            this.i = j;
            this.j = (p14 != null);
            this.p = p14;
            this.x = x;
            this.y = y;
            this.z = z;
            this.A = a;
            this.B = b;
            this.w = false;
            return this;
        }
        
        @Override
        public Bundle toBundle() {
            return this.l(false);
        }
    }
}
