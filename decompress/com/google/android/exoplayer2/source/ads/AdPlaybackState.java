// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.ads;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import java.util.Collection;
import w3.b;
import android.net.Uri;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Arrays;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import android.os.Bundle;
import w3.a;
import com.google.android.exoplayer2.Bundleable;

public final class AdPlaybackState implements Bundleable
{
    public static final AdPlaybackState g;
    private static final AdGroup h;
    public static final Creator<AdPlaybackState> i;
    public final Object a;
    public final int b;
    public final long c;
    public final long d;
    public final int e;
    private final AdGroup[] f;
    
    static {
        g = new AdPlaybackState(null, new AdGroup[0], 0L, -9223372036854775807L, 0);
        h = new AdGroup(0L).j(0);
        i = (Creator)a.a;
    }
    
    private AdPlaybackState(final Object a, final AdGroup[] f, final long c, final long d, final int e) {
        this.a = a;
        this.c = c;
        this.d = d;
        this.b = f.length + e;
        this.f = f;
        this.e = e;
    }
    
    public static AdPlaybackState a(final Bundle bundle) {
        return b(bundle);
    }
    
    private static AdPlaybackState b(final Bundle bundle) {
        final ArrayList parcelableArrayList = bundle.getParcelableArrayList(g(1));
        int i = 0;
        AdGroup[] array;
        if (parcelableArrayList == null) {
            array = new AdGroup[0];
        }
        else {
            array = new AdGroup[parcelableArrayList.size()];
            while (i < parcelableArrayList.size()) {
                array[i] = AdGroup.h.a(parcelableArrayList.get(i));
                ++i;
            }
        }
        return new AdPlaybackState(null, array, bundle.getLong(g(2), 0L), bundle.getLong(g(3), -9223372036854775807L), bundle.getInt(g(4)));
    }
    
    private boolean f(final long n, final long n2, final int n3) {
        boolean b = false;
        final boolean b2 = false;
        if (n == Long.MIN_VALUE) {
            return false;
        }
        final long a = this.c(n3).a;
        if (a == Long.MIN_VALUE) {
            if (n2 != -9223372036854775807L) {
                final boolean b3 = b2;
                if (n >= n2) {
                    return b3;
                }
            }
            return true;
        }
        if (n < a) {
            b = true;
        }
        return b;
    }
    
    private static String g(final int n) {
        return Integer.toString(n, 36);
    }
    
    public AdGroup c(final int n) {
        final int e = this.e;
        AdGroup h;
        if (n < e) {
            h = AdPlaybackState.h;
        }
        else {
            h = this.f[n - e];
        }
        return h;
    }
    
    public int d(final long n, final long n2) {
        int n4;
        final int n3 = n4 = -1;
        if (n != Long.MIN_VALUE) {
            if (n2 != -9223372036854775807L && n >= n2) {
                n4 = n3;
            }
            else {
                int e;
                for (e = this.e; e < this.b && ((this.c(e).a != Long.MIN_VALUE && this.c(e).a <= n) || !this.c(e).i()); ++e) {}
                n4 = n3;
                if (e < this.b) {
                    n4 = e;
                }
            }
        }
        return n4;
    }
    
    public int e(final long n, final long n2) {
        int n3;
        for (n3 = this.b - 1; n3 >= 0 && this.f(n, n2, n3); --n3) {}
        if (n3 < 0 || !this.c(n3).g()) {
            n3 = -1;
        }
        return n3;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (o != null && AdPlaybackState.class == o.getClass()) {
            final AdPlaybackState adPlaybackState = (AdPlaybackState)o;
            if (!Util.c(this.a, adPlaybackState.a) || this.b != adPlaybackState.b || this.c != adPlaybackState.c || this.d != adPlaybackState.d || this.e != adPlaybackState.e || !Arrays.equals(this.f, adPlaybackState.f)) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    public AdPlaybackState h(final long[][] array) {
        final int e = this.e;
        int i = 0;
        Assertions.g(e == 0);
        final AdGroup[] f = this.f;
        final AdGroup[] array2 = Util.H0(f, f.length);
        while (i < this.b) {
            array2[i] = array2[i].k(array[i]);
            ++i;
        }
        return new AdPlaybackState(this.a, array2, this.c, this.d, this.e);
    }
    
    @Override
    public int hashCode() {
        final int b = this.b;
        final Object a = this.a;
        int hashCode;
        if (a == null) {
            hashCode = 0;
        }
        else {
            hashCode = a.hashCode();
        }
        return ((((b * 31 + hashCode) * 31 + (int)this.c) * 31 + (int)this.d) * 31 + this.e) * 31 + Arrays.hashCode(this.f);
    }
    
    @Override
    public Bundle toBundle() {
        final Bundle bundle = new Bundle();
        final ArrayList list = new ArrayList();
        final AdGroup[] f = this.f;
        for (int length = f.length, i = 0; i < length; ++i) {
            list.add(f[i].toBundle());
        }
        bundle.putParcelableArrayList(g(1), list);
        bundle.putLong(g(2), this.c);
        bundle.putLong(g(3), this.d);
        bundle.putInt(g(4), this.e);
        return bundle;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("AdPlaybackState(adsId=");
        sb.append(this.a);
        sb.append(", adResumePositionUs=");
        sb.append(this.c);
        sb.append(", adGroups=[");
        for (int i = 0; i < this.f.length; ++i) {
            sb.append("adGroup(timeUs=");
            sb.append(this.f[i].a);
            sb.append(", ads=[");
            for (int j = 0; j < this.f[i].d.length; ++j) {
                sb.append("ad(state=");
                final int n = this.f[i].d[j];
                if (n != 0) {
                    if (n != 1) {
                        if (n != 2) {
                            if (n != 3) {
                                if (n != 4) {
                                    sb.append('?');
                                }
                                else {
                                    sb.append('!');
                                }
                            }
                            else {
                                sb.append('P');
                            }
                        }
                        else {
                            sb.append('S');
                        }
                    }
                    else {
                        sb.append('R');
                    }
                }
                else {
                    sb.append('_');
                }
                sb.append(", durationUs=");
                sb.append(this.f[i].e[j]);
                sb.append(')');
                if (j < this.f[i].d.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("])");
            if (i < this.f.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("])");
        return sb.toString();
    }
    
    public static final class AdGroup implements Bundleable
    {
        public static final Creator<AdGroup> h;
        public final long a;
        public final int b;
        public final Uri[] c;
        public final int[] d;
        public final long[] e;
        public final long f;
        public final boolean g;
        
        static {
            h = (Creator)b.a;
        }
        
        public AdGroup(final long n) {
            this(n, -1, new int[0], new Uri[0], new long[0], 0L, false);
        }
        
        private AdGroup(final long a, final int b, final int[] d, final Uri[] c, final long[] e, final long f, final boolean g) {
            Assertions.a(d.length == c.length);
            this.a = a;
            this.b = b;
            this.d = d;
            this.c = c;
            this.e = e;
            this.f = f;
            this.g = g;
        }
        
        public static AdGroup a(final Bundle bundle) {
            return d(bundle);
        }
        
        private static long[] b(long[] copy, int max) {
            final int length = copy.length;
            max = Math.max(max, length);
            copy = Arrays.copyOf(copy, max);
            Arrays.fill(copy, length, max, -9223372036854775807L);
            return copy;
        }
        
        private static int[] c(int[] copy, int max) {
            final int length = copy.length;
            max = Math.max(max, length);
            copy = Arrays.copyOf(copy, max);
            Arrays.fill(copy, length, max, 0);
            return copy;
        }
        
        private static AdGroup d(final Bundle bundle) {
            final long long1 = bundle.getLong(h(0));
            final int int1 = bundle.getInt(h(1), -1);
            final ArrayList parcelableArrayList = bundle.getParcelableArrayList(h(2));
            final int[] intArray = bundle.getIntArray(h(3));
            long[] longArray = bundle.getLongArray(h(4));
            final long long2 = bundle.getLong(h(5));
            final boolean boolean1 = bundle.getBoolean(h(6));
            int[] array = intArray;
            if (intArray == null) {
                array = new int[0];
            }
            Uri[] array2;
            if (parcelableArrayList == null) {
                array2 = new Uri[0];
            }
            else {
                array2 = parcelableArrayList.toArray(new Uri[0]);
            }
            if (longArray == null) {
                longArray = new long[0];
            }
            return new AdGroup(long1, int1, array, array2, longArray, long2, boolean1);
        }
        
        private static String h(final int n) {
            return Integer.toString(n, 36);
        }
        
        public int e() {
            return this.f(-1);
        }
        
        @Override
        public boolean equals(final Object o) {
            boolean b = true;
            if (this == o) {
                return true;
            }
            if (o != null && AdGroup.class == o.getClass()) {
                final AdGroup adGroup = (AdGroup)o;
                if (this.a != adGroup.a || this.b != adGroup.b || !Arrays.equals(this.c, adGroup.c) || !Arrays.equals(this.d, adGroup.d) || !Arrays.equals(this.e, adGroup.e) || this.f != adGroup.f || this.g != adGroup.g) {
                    b = false;
                }
                return b;
            }
            return false;
        }
        
        public int f(int n) {
            ++n;
            while (true) {
                final int[] d = this.d;
                if (n >= d.length || this.g || d[n] == 0 || d[n] == 1) {
                    break;
                }
                ++n;
            }
            return n;
        }
        
        public boolean g() {
            if (this.b == -1) {
                return true;
            }
            for (int i = 0; i < this.b; ++i) {
                final int[] d = this.d;
                if (d[i] == 0 || d[i] == 1) {
                    return true;
                }
            }
            return false;
        }
        
        @Override
        public int hashCode() {
            final int b = this.b;
            final long a = this.a;
            final int n = (int)(a ^ a >>> 32);
            final int hashCode = Arrays.hashCode(this.c);
            final int hashCode2 = Arrays.hashCode(this.d);
            final int hashCode3 = Arrays.hashCode(this.e);
            final long f = this.f;
            return (((((b * 31 + n) * 31 + hashCode) * 31 + hashCode2) * 31 + hashCode3) * 31 + (int)(f ^ f >>> 32)) * 31 + (this.g ? 1 : 0);
        }
        
        public boolean i() {
            return this.b == -1 || this.e() < this.b;
        }
        
        public AdGroup j(final int n) {
            return new AdGroup(this.a, n, c(this.d, n), Arrays.copyOf(this.c, n), b(this.e, n), this.f, this.g);
        }
        
        public AdGroup k(final long[] array) {
            final int length = array.length;
            final Uri[] c = this.c;
            long[] array2;
            if (length < c.length) {
                array2 = b(array, c.length);
            }
            else {
                array2 = array;
                if (this.b != -1) {
                    array2 = array;
                    if (array.length > c.length) {
                        array2 = Arrays.copyOf(array, c.length);
                    }
                }
            }
            return new AdGroup(this.a, this.b, this.d, this.c, array2, this.f, this.g);
        }
        
        @Override
        public Bundle toBundle() {
            final Bundle bundle = new Bundle();
            bundle.putLong(h(0), this.a);
            bundle.putInt(h(1), this.b);
            bundle.putParcelableArrayList(h(2), new ArrayList((Collection<? extends E>)Arrays.asList(this.c)));
            bundle.putIntArray(h(3), this.d);
            bundle.putLongArray(h(4), this.e);
            bundle.putLong(h(5), this.f);
            bundle.putBoolean(h(6), this.g);
            return bundle;
        }
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE })
    public @interface AdState {
    }
}
