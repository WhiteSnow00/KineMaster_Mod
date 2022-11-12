// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.trackselection;

import com.google.common.collect.ImmutableCollection;
import android.graphics.Point;
import java.util.Iterator;
import java.util.Locale;
import android.view.accessibility.CaptioningManager;
import android.os.Looper;
import com.google.common.collect.ImmutableList$Builder;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.Assertions;
import java.util.List;
import com.google.common.base.MoreObjects;
import android.content.Context;
import java.util.HashSet;
import java.util.HashMap;
import com.google.common.primitives.Ints;
import java.util.ArrayList;
import com.google.android.exoplayer2.util.BundleableUtil;
import android.os.Bundle;
import java.util.Collection;
import java.util.Map;
import d4.l;
import com.google.common.collect.ImmutableSet;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableList;
import com.google.android.exoplayer2.Bundleable;

public class TrackSelectionParameters implements Bundleable
{
    public static final TrackSelectionParameters L;
    @Deprecated
    public static final TrackSelectionParameters M;
    @Deprecated
    public static final Creator<TrackSelectionParameters> N;
    public final int A;
    public final int B;
    public final ImmutableList<String> C;
    public final ImmutableList<String> D;
    public final int E;
    public final int F;
    public final boolean G;
    public final boolean H;
    public final boolean I;
    public final ImmutableMap<TrackGroup, TrackSelectionOverride> J;
    public final ImmutableSet<Integer> K;
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public final int j;
    public final boolean p;
    public final ImmutableList<String> w;
    public final int x;
    public final ImmutableList<String> y;
    public final int z;
    
    static {
        M = (L = new Builder().A());
        N = (Creator)l.a;
    }
    
    protected TrackSelectionParameters(final Builder builder) {
        this.a = Builder.a(builder);
        this.b = Builder.b(builder);
        this.c = Builder.m(builder);
        this.d = Builder.t(builder);
        this.e = Builder.u(builder);
        this.f = Builder.v(builder);
        this.g = Builder.w(builder);
        this.h = Builder.x(builder);
        this.i = Builder.y(builder);
        this.j = Builder.z(builder);
        this.p = Builder.c(builder);
        this.w = (ImmutableList<String>)Builder.d(builder);
        this.x = Builder.e(builder);
        this.y = (ImmutableList<String>)Builder.f(builder);
        this.z = Builder.g(builder);
        this.A = Builder.h(builder);
        this.B = Builder.i(builder);
        this.C = (ImmutableList<String>)Builder.j(builder);
        this.D = (ImmutableList<String>)Builder.k(builder);
        this.E = Builder.l(builder);
        this.F = Builder.n(builder);
        this.G = Builder.o(builder);
        this.H = Builder.p(builder);
        this.I = Builder.q(builder);
        this.J = (ImmutableMap<TrackGroup, TrackSelectionOverride>)ImmutableMap.copyOf((Map)Builder.r(builder));
        this.K = (ImmutableSet<Integer>)ImmutableSet.copyOf((Collection)Builder.s(builder));
    }
    
    public static TrackSelectionParameters b(final Bundle bundle) {
        return new Builder(bundle).A();
    }
    
    protected static String c(final int n) {
        return Integer.toString(n, 36);
    }
    
    public Builder a() {
        return new Builder(this);
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (o != null && this.getClass() == o.getClass()) {
            final TrackSelectionParameters trackSelectionParameters = (TrackSelectionParameters)o;
            if (this.a != trackSelectionParameters.a || this.b != trackSelectionParameters.b || this.c != trackSelectionParameters.c || this.d != trackSelectionParameters.d || this.e != trackSelectionParameters.e || this.f != trackSelectionParameters.f || this.g != trackSelectionParameters.g || this.h != trackSelectionParameters.h || this.p != trackSelectionParameters.p || this.i != trackSelectionParameters.i || this.j != trackSelectionParameters.j || !this.w.equals((Object)trackSelectionParameters.w) || this.x != trackSelectionParameters.x || !this.y.equals((Object)trackSelectionParameters.y) || this.z != trackSelectionParameters.z || this.A != trackSelectionParameters.A || this.B != trackSelectionParameters.B || !this.C.equals((Object)trackSelectionParameters.C) || !this.D.equals((Object)trackSelectionParameters.D) || this.E != trackSelectionParameters.E || this.F != trackSelectionParameters.F || this.G != trackSelectionParameters.G || this.H != trackSelectionParameters.H || this.I != trackSelectionParameters.I || !this.J.equals((Object)trackSelectionParameters.J) || !this.K.equals((Object)trackSelectionParameters.K)) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return (((((((((((((((((((((((((this.a + 31) * 31 + this.b) * 31 + this.c) * 31 + this.d) * 31 + this.e) * 31 + this.f) * 31 + this.g) * 31 + this.h) * 31 + (this.p ? 1 : 0)) * 31 + this.i) * 31 + this.j) * 31 + this.w.hashCode()) * 31 + this.x) * 31 + this.y.hashCode()) * 31 + this.z) * 31 + this.A) * 31 + this.B) * 31 + this.C.hashCode()) * 31 + this.D.hashCode()) * 31 + this.E) * 31 + this.F) * 31 + (this.G ? 1 : 0)) * 31 + (this.H ? 1 : 0)) * 31 + (this.I ? 1 : 0)) * 31 + this.J.hashCode()) * 31 + this.K.hashCode();
    }
    
    @Override
    public Bundle toBundle() {
        final Bundle bundle = new Bundle();
        bundle.putInt(c(6), this.a);
        bundle.putInt(c(7), this.b);
        bundle.putInt(c(8), this.c);
        bundle.putInt(c(9), this.d);
        bundle.putInt(c(10), this.e);
        bundle.putInt(c(11), this.f);
        bundle.putInt(c(12), this.g);
        bundle.putInt(c(13), this.h);
        bundle.putInt(c(14), this.i);
        bundle.putInt(c(15), this.j);
        bundle.putBoolean(c(16), this.p);
        bundle.putStringArray(c(17), (String[])((ImmutableCollection)this.w).toArray((Object[])new String[0]));
        bundle.putInt(c(25), this.x);
        bundle.putStringArray(c(1), (String[])((ImmutableCollection)this.y).toArray((Object[])new String[0]));
        bundle.putInt(c(2), this.z);
        bundle.putInt(c(18), this.A);
        bundle.putInt(c(19), this.B);
        bundle.putStringArray(c(20), (String[])((ImmutableCollection)this.C).toArray((Object[])new String[0]));
        bundle.putStringArray(c(3), (String[])((ImmutableCollection)this.D).toArray((Object[])new String[0]));
        bundle.putInt(c(4), this.E);
        bundle.putInt(c(26), this.F);
        bundle.putBoolean(c(5), this.G);
        bundle.putBoolean(c(21), this.H);
        bundle.putBoolean(c(22), this.I);
        bundle.putParcelableArrayList(c(23), (ArrayList)BundleableUtil.d((Collection<Bundleable>)this.J.values()));
        bundle.putIntArray(c(24), Ints.n((Collection)this.K));
        return bundle;
    }
    
    public static class Builder
    {
        private int a;
        private int b;
        private int c;
        private int d;
        private int e;
        private int f;
        private int g;
        private int h;
        private int i;
        private int j;
        private boolean k;
        private ImmutableList<String> l;
        private int m;
        private ImmutableList<String> n;
        private int o;
        private int p;
        private int q;
        private ImmutableList<String> r;
        private ImmutableList<String> s;
        private int t;
        private int u;
        private boolean v;
        private boolean w;
        private boolean x;
        private HashMap<TrackGroup, TrackSelectionOverride> y;
        private HashSet<Integer> z;
        
        @Deprecated
        public Builder() {
            this.a = Integer.MAX_VALUE;
            this.b = Integer.MAX_VALUE;
            this.c = Integer.MAX_VALUE;
            this.d = Integer.MAX_VALUE;
            this.i = Integer.MAX_VALUE;
            this.j = Integer.MAX_VALUE;
            this.k = true;
            this.l = (ImmutableList<String>)ImmutableList.of();
            this.m = 0;
            this.n = (ImmutableList<String>)ImmutableList.of();
            this.o = 0;
            this.p = Integer.MAX_VALUE;
            this.q = Integer.MAX_VALUE;
            this.r = (ImmutableList<String>)ImmutableList.of();
            this.s = (ImmutableList<String>)ImmutableList.of();
            this.t = 0;
            this.u = 0;
            this.v = false;
            this.w = false;
            this.x = false;
            this.y = new HashMap<TrackGroup, TrackSelectionOverride>();
            this.z = new HashSet<Integer>();
        }
        
        public Builder(final Context context) {
            this();
            this.I(context);
            this.M(context, true);
        }
        
        protected Builder(final Bundle bundle) {
            final String c = TrackSelectionParameters.c(6);
            final TrackSelectionParameters l = TrackSelectionParameters.L;
            this.a = bundle.getInt(c, l.a);
            this.b = bundle.getInt(TrackSelectionParameters.c(7), l.b);
            this.c = bundle.getInt(TrackSelectionParameters.c(8), l.c);
            this.d = bundle.getInt(TrackSelectionParameters.c(9), l.d);
            this.e = bundle.getInt(TrackSelectionParameters.c(10), l.e);
            this.f = bundle.getInt(TrackSelectionParameters.c(11), l.f);
            this.g = bundle.getInt(TrackSelectionParameters.c(12), l.g);
            this.h = bundle.getInt(TrackSelectionParameters.c(13), l.h);
            this.i = bundle.getInt(TrackSelectionParameters.c(14), l.i);
            this.j = bundle.getInt(TrackSelectionParameters.c(15), l.j);
            this.k = bundle.getBoolean(TrackSelectionParameters.c(16), l.p);
            final String[] stringArray = bundle.getStringArray(TrackSelectionParameters.c(17));
            final int n = 0;
            this.l = (ImmutableList<String>)ImmutableList.copyOf((Object[])MoreObjects.a((Object)stringArray, (Object)new String[0]));
            this.m = bundle.getInt(TrackSelectionParameters.c(25), l.x);
            this.n = D((String[])MoreObjects.a((Object)bundle.getStringArray(TrackSelectionParameters.c(1)), (Object)new String[0]));
            this.o = bundle.getInt(TrackSelectionParameters.c(2), l.z);
            this.p = bundle.getInt(TrackSelectionParameters.c(18), l.A);
            this.q = bundle.getInt(TrackSelectionParameters.c(19), l.B);
            this.r = (ImmutableList<String>)ImmutableList.copyOf((Object[])MoreObjects.a((Object)bundle.getStringArray(TrackSelectionParameters.c(20)), (Object)new String[0]));
            this.s = D((String[])MoreObjects.a((Object)bundle.getStringArray(TrackSelectionParameters.c(3)), (Object)new String[0]));
            this.t = bundle.getInt(TrackSelectionParameters.c(4), l.E);
            this.u = bundle.getInt(TrackSelectionParameters.c(26), l.F);
            this.v = bundle.getBoolean(TrackSelectionParameters.c(5), l.G);
            this.w = bundle.getBoolean(TrackSelectionParameters.c(21), l.H);
            this.x = bundle.getBoolean(TrackSelectionParameters.c(22), l.I);
            final ArrayList parcelableArrayList = bundle.getParcelableArrayList(TrackSelectionParameters.c(23));
            ImmutableList list;
            if (parcelableArrayList == null) {
                list = ImmutableList.of();
            }
            else {
                list = BundleableUtil.b(TrackSelectionOverride.c, parcelableArrayList);
            }
            this.y = new HashMap<TrackGroup, TrackSelectionOverride>();
            for (int i = 0; i < ((List)list).size(); ++i) {
                final TrackSelectionOverride trackSelectionOverride = (TrackSelectionOverride)((List)list).get(i);
                this.y.put(trackSelectionOverride.a, trackSelectionOverride);
            }
            final int[] array = (int[])MoreObjects.a((Object)bundle.getIntArray(TrackSelectionParameters.c(24)), (Object)new int[0]);
            this.z = new HashSet<Integer>();
            for (int length = array.length, j = n; j < length; ++j) {
                this.z.add(array[j]);
            }
        }
        
        protected Builder(final TrackSelectionParameters trackSelectionParameters) {
            this.C(trackSelectionParameters);
        }
        
        private void C(final TrackSelectionParameters trackSelectionParameters) {
            this.a = trackSelectionParameters.a;
            this.b = trackSelectionParameters.b;
            this.c = trackSelectionParameters.c;
            this.d = trackSelectionParameters.d;
            this.e = trackSelectionParameters.e;
            this.f = trackSelectionParameters.f;
            this.g = trackSelectionParameters.g;
            this.h = trackSelectionParameters.h;
            this.i = trackSelectionParameters.i;
            this.j = trackSelectionParameters.j;
            this.k = trackSelectionParameters.p;
            this.l = trackSelectionParameters.w;
            this.m = trackSelectionParameters.x;
            this.n = trackSelectionParameters.y;
            this.o = trackSelectionParameters.z;
            this.p = trackSelectionParameters.A;
            this.q = trackSelectionParameters.B;
            this.r = trackSelectionParameters.C;
            this.s = trackSelectionParameters.D;
            this.t = trackSelectionParameters.E;
            this.u = trackSelectionParameters.F;
            this.v = trackSelectionParameters.G;
            this.w = trackSelectionParameters.H;
            this.x = trackSelectionParameters.I;
            this.z = new HashSet<Integer>((Collection<? extends Integer>)trackSelectionParameters.K);
            this.y = new HashMap<TrackGroup, TrackSelectionOverride>((Map<? extends TrackGroup, ? extends TrackSelectionOverride>)trackSelectionParameters.J);
        }
        
        private static ImmutableList<String> D(String[] array) {
            final ImmutableList$Builder builder = ImmutableList.builder();
            array = Assertions.e(array);
            for (int length = array.length, i = 0; i < length; ++i) {
                builder.i((Object)Util.E0(Assertions.e(array[i])));
            }
            return (ImmutableList<String>)builder.l();
        }
        
        private void J(final Context context) {
            if (Util.a < 23 && Looper.myLooper() == null) {
                return;
            }
            final CaptioningManager captioningManager = (CaptioningManager)context.getSystemService("captioning");
            if (captioningManager != null) {
                if (captioningManager.isEnabled()) {
                    this.t = 1088;
                    final Locale locale = captioningManager.getLocale();
                    if (locale != null) {
                        this.s = (ImmutableList<String>)ImmutableList.of((Object)Util.Y(locale));
                    }
                }
            }
        }
        
        static int a(final Builder builder) {
            return builder.a;
        }
        
        static int b(final Builder builder) {
            return builder.b;
        }
        
        static boolean c(final Builder builder) {
            return builder.k;
        }
        
        static ImmutableList d(final Builder builder) {
            return builder.l;
        }
        
        static int e(final Builder builder) {
            return builder.m;
        }
        
        static ImmutableList f(final Builder builder) {
            return builder.n;
        }
        
        static int g(final Builder builder) {
            return builder.o;
        }
        
        static int h(final Builder builder) {
            return builder.p;
        }
        
        static int i(final Builder builder) {
            return builder.q;
        }
        
        static ImmutableList j(final Builder builder) {
            return builder.r;
        }
        
        static ImmutableList k(final Builder builder) {
            return builder.s;
        }
        
        static int l(final Builder builder) {
            return builder.t;
        }
        
        static int m(final Builder builder) {
            return builder.c;
        }
        
        static int n(final Builder builder) {
            return builder.u;
        }
        
        static boolean o(final Builder builder) {
            return builder.v;
        }
        
        static boolean p(final Builder builder) {
            return builder.w;
        }
        
        static boolean q(final Builder builder) {
            return builder.x;
        }
        
        static HashMap r(final Builder builder) {
            return builder.y;
        }
        
        static HashSet s(final Builder builder) {
            return builder.z;
        }
        
        static int t(final Builder builder) {
            return builder.d;
        }
        
        static int u(final Builder builder) {
            return builder.e;
        }
        
        static int v(final Builder builder) {
            return builder.f;
        }
        
        static int w(final Builder builder) {
            return builder.g;
        }
        
        static int x(final Builder builder) {
            return builder.h;
        }
        
        static int y(final Builder builder) {
            return builder.i;
        }
        
        static int z(final Builder builder) {
            return builder.j;
        }
        
        public TrackSelectionParameters A() {
            return new TrackSelectionParameters(this);
        }
        
        public Builder B(final int n) {
            final Iterator<TrackSelectionOverride> iterator = this.y.values().iterator();
            while (iterator.hasNext()) {
                if (iterator.next().b() == n) {
                    iterator.remove();
                }
            }
            return this;
        }
        
        protected Builder E(final TrackSelectionParameters trackSelectionParameters) {
            this.C(trackSelectionParameters);
            return this;
        }
        
        public Builder F(final boolean x) {
            this.x = x;
            return this;
        }
        
        public Builder G(final int u) {
            this.u = u;
            return this;
        }
        
        public Builder H(final TrackSelectionOverride trackSelectionOverride) {
            this.B(trackSelectionOverride.b());
            this.y.put(trackSelectionOverride.a, trackSelectionOverride);
            return this;
        }
        
        public Builder I(final Context context) {
            if (Util.a >= 19) {
                this.J(context);
            }
            return this;
        }
        
        public Builder K(final int n, final boolean b) {
            if (b) {
                this.z.add(n);
            }
            else {
                this.z.remove(n);
            }
            return this;
        }
        
        public Builder L(final int i, final int j, final boolean k) {
            this.i = i;
            this.j = j;
            this.k = k;
            return this;
        }
        
        public Builder M(final Context context, final boolean b) {
            final Point o = Util.O(context);
            return this.L(o.x, o.y, b);
        }
    }
}
