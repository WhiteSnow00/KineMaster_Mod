// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import java.util.AbstractCollection;
import com.google.common.primitives.Booleans;
import java.util.Arrays;
import com.google.common.base.MoreObjects;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.source.TrackGroup;
import java.util.ArrayList;
import com.google.android.exoplayer2.util.BundleableUtil;
import android.os.Bundle;
import java.util.Collection;
import java.util.List;
import com.google.common.collect.ImmutableList;

public final class Tracks implements Bundleable
{
    public static final Tracks b;
    public static final Creator<Tracks> c;
    private final ImmutableList<Group> a;
    
    static {
        b = new Tracks((List<Group>)ImmutableList.of());
        c = y1.a;
    }
    
    public Tracks(final List<Group> list) {
        this.a = (ImmutableList<Group>)ImmutableList.copyOf((Collection)list);
    }
    
    public static Tracks a(final Bundle bundle) {
        return f(bundle);
    }
    
    private static String e(final int n) {
        return Integer.toString(n, 36);
    }
    
    private static Tracks f(final Bundle bundle) {
        final ArrayList parcelableArrayList = bundle.getParcelableArrayList(e(0));
        ImmutableList list;
        if (parcelableArrayList == null) {
            list = ImmutableList.of();
        }
        else {
            list = BundleableUtil.b(Group.f, parcelableArrayList);
        }
        return new Tracks((List<Group>)list);
    }
    
    public ImmutableList<Group> b() {
        return this.a;
    }
    
    public boolean c() {
        return ((AbstractCollection)this.a).isEmpty();
    }
    
    public boolean d(final int n) {
        for (int i = 0; i < ((AbstractCollection)this.a).size(); ++i) {
            final Group group = ((List<Group>)this.a).get(i);
            if (group.g() && group.e() == n) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean equals(final Object o) {
        return this == o || (o != null && Tracks.class == o.getClass() && this.a.equals((Object)((Tracks)o).a));
    }
    
    @Override
    public int hashCode() {
        return this.a.hashCode();
    }
    
    @Override
    public Bundle toBundle() {
        final Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(e(0), (ArrayList)BundleableUtil.d((Collection<Bundleable>)this.a));
        return bundle;
    }
    
    public static final class Group implements Bundleable
    {
        public static final Creator<Group> f;
        public final int a;
        private final TrackGroup b;
        private final boolean c;
        private final int[] d;
        private final boolean[] e;
        
        static {
            f = z1.a;
        }
        
        public Group(final TrackGroup b, final boolean b2, final int[] array, final boolean[] array2) {
            final int a = b.a;
            this.a = a;
            final int length = array.length;
            final boolean b3 = false;
            Assertions.a(a == length && a == array2.length);
            this.b = b;
            boolean c = b3;
            if (b2) {
                c = b3;
                if (a > 1) {
                    c = true;
                }
            }
            this.c = c;
            this.d = array.clone();
            this.e = array2.clone();
        }
        
        public static Group a(final Bundle bundle) {
            return l(bundle);
        }
        
        private static String k(final int n) {
            return Integer.toString(n, 36);
        }
        
        private static Group l(final Bundle bundle) {
            final TrackGroup trackGroup = TrackGroup.f.a(Assertions.e(bundle.getBundle(k(0))));
            return new Group(trackGroup, bundle.getBoolean(k(4), false), (int[])MoreObjects.a((Object)bundle.getIntArray(k(1)), (Object)new int[trackGroup.a]), (boolean[])MoreObjects.a((Object)bundle.getBooleanArray(k(3)), (Object)new boolean[trackGroup.a]));
        }
        
        public TrackGroup b() {
            return this.b;
        }
        
        public Format c(final int n) {
            return this.b.c(n);
        }
        
        public int d(final int n) {
            return this.d[n];
        }
        
        public int e() {
            return this.b.c;
        }
        
        @Override
        public boolean equals(final Object o) {
            boolean b = true;
            if (this == o) {
                return true;
            }
            if (o != null && Group.class == o.getClass()) {
                final Group group = (Group)o;
                if (this.c != group.c || !this.b.equals(group.b) || !Arrays.equals(this.d, group.d) || !Arrays.equals(this.e, group.e)) {
                    b = false;
                }
                return b;
            }
            return false;
        }
        
        public boolean f() {
            return this.c;
        }
        
        public boolean g() {
            return Booleans.b(this.e, true);
        }
        
        public boolean h(final int n) {
            return this.e[n];
        }
        
        @Override
        public int hashCode() {
            return ((this.b.hashCode() * 31 + (this.c ? 1 : 0)) * 31 + Arrays.hashCode(this.d)) * 31 + Arrays.hashCode(this.e);
        }
        
        public boolean i(final int n) {
            return this.j(n, false);
        }
        
        public boolean j(final int n, final boolean b) {
            final int[] d = this.d;
            return d[n] == 4 || (b && d[n] == 3);
        }
        
        @Override
        public Bundle toBundle() {
            final Bundle bundle = new Bundle();
            bundle.putBundle(k(0), this.b.toBundle());
            bundle.putIntArray(k(1), this.d);
            bundle.putBooleanArray(k(3), this.e);
            bundle.putBoolean(k(4), this.c);
            return bundle;
        }
    }
}
