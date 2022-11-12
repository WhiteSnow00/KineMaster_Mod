// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source;

import java.util.Collection;
import com.google.common.collect.Lists;
import java.util.Arrays;
import com.google.android.exoplayer2.util.Log;
import java.util.ArrayList;
import java.util.List;
import com.google.android.exoplayer2.util.BundleableUtil;
import com.google.common.collect.ImmutableList;
import android.os.Bundle;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Bundleable;

public final class TrackGroup implements Bundleable
{
    public static final Creator<TrackGroup> f;
    public final int a;
    public final String b;
    public final int c;
    private final Format[] d;
    private int e;
    
    static {
        f = a0.a;
    }
    
    public TrackGroup(final String b, final Format... d) {
        Assertions.a(d.length > 0);
        this.b = b;
        this.d = d;
        this.a = d.length;
        int c;
        if ((c = MimeTypes.k(d[0].w)) == -1) {
            c = MimeTypes.k(d[0].p);
        }
        this.c = c;
        this.j();
    }
    
    public TrackGroup(final Format... array) {
        this("", array);
    }
    
    public static TrackGroup a(final Bundle bundle) {
        return f(bundle);
    }
    
    private static String e(final int n) {
        return Integer.toString(n, 36);
    }
    
    private static TrackGroup f(final Bundle bundle) {
        final ArrayList parcelableArrayList = bundle.getParcelableArrayList(e(0));
        ImmutableList list;
        if (parcelableArrayList == null) {
            list = ImmutableList.of();
        }
        else {
            list = BundleableUtil.b(Format.S, parcelableArrayList);
        }
        return new TrackGroup(bundle.getString(e(1), ""), (Format[])((List)list).toArray(new Format[0]));
    }
    
    private static void g(final String s, final String s2, final String s3, final int n) {
        final StringBuilder sb = new StringBuilder();
        sb.append("Different ");
        sb.append(s);
        sb.append(" combined in one TrackGroup: '");
        sb.append(s2);
        sb.append("' (track 0) and '");
        sb.append(s3);
        sb.append("' (track ");
        sb.append(n);
        sb.append(")");
        Log.d("TrackGroup", "", new IllegalStateException(sb.toString()));
    }
    
    private static String h(final String s) {
        if (s != null) {
            final String s2 = s;
            if (!s.equals("und")) {
                return s2;
            }
        }
        return "";
    }
    
    private static int i(final int n) {
        return n | 0x4000;
    }
    
    private void j() {
        final String h = h(this.d[0].c);
        final int i = i(this.d[0].e);
        int n = 1;
        while (true) {
            final Format[] d = this.d;
            if (n >= d.length) {
                return;
            }
            if (!h.equals(h(d[n].c))) {
                final Format[] d2 = this.d;
                g("languages", d2[0].c, d2[n].c, n);
                return;
            }
            if (i != i(this.d[n].e)) {
                g("role flags", Integer.toBinaryString(this.d[0].e), Integer.toBinaryString(this.d[n].e), n);
                return;
            }
            ++n;
        }
    }
    
    public TrackGroup b(final String s) {
        return new TrackGroup(s, this.d);
    }
    
    public Format c(final int n) {
        return this.d[n];
    }
    
    public int d(final Format format) {
        int n = 0;
        while (true) {
            final Format[] d = this.d;
            if (n >= d.length) {
                return -1;
            }
            if (format == d[n]) {
                return n;
            }
            ++n;
        }
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (o != null && TrackGroup.class == o.getClass()) {
            final TrackGroup trackGroup = (TrackGroup)o;
            if (!this.b.equals(trackGroup.b) || !Arrays.equals(this.d, trackGroup.d)) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        if (this.e == 0) {
            this.e = (527 + this.b.hashCode()) * 31 + Arrays.hashCode(this.d);
        }
        return this.e;
    }
    
    @Override
    public Bundle toBundle() {
        final Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(e(0), (ArrayList)BundleableUtil.d((Collection<Bundleable>)Lists.l((Object[])this.d)));
        bundle.putString(e(1), this.b);
        return bundle;
    }
}
