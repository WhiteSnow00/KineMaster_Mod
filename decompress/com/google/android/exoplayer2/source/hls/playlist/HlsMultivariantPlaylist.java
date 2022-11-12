// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.hls.playlist;

import java.util.ArrayList;
import com.google.android.exoplayer2.offline.StreamKey;
import java.util.Collections;
import com.google.android.exoplayer2.drm.DrmInitData;
import java.util.Map;
import com.google.android.exoplayer2.Format;
import android.net.Uri;
import java.util.List;

public class HlsMultivariantPlaylist extends HlsPlaylist
{
    public static final HlsMultivariantPlaylist n;
    public final List<Uri> d;
    public final List<Variant> e;
    public final List<Rendition> f;
    public final List<Rendition> g;
    public final List<Rendition> h;
    public final List<Rendition> i;
    public final Format j;
    public final List<Format> k;
    public final Map<String, String> l;
    public final List<DrmInitData> m;
    
    static {
        n = new HlsMultivariantPlaylist("", Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), null, Collections.emptyList(), false, Collections.emptyMap(), Collections.emptyList());
    }
    
    public HlsMultivariantPlaylist(final String s, final List<String> list, final List<Variant> list2, final List<Rendition> list3, final List<Rendition> list4, final List<Rendition> list5, final List<Rendition> list6, final Format j, final List<Format> list7, final boolean b, final Map<String, String> map, final List<DrmInitData> list8) {
        super(s, list, b);
        this.d = (List<Uri>)Collections.unmodifiableList((List<?>)f(list2, list3, list4, list5, list6));
        this.e = Collections.unmodifiableList((List<? extends Variant>)list2);
        this.f = Collections.unmodifiableList((List<? extends Rendition>)list3);
        this.g = Collections.unmodifiableList((List<? extends Rendition>)list4);
        this.h = Collections.unmodifiableList((List<? extends Rendition>)list5);
        this.i = Collections.unmodifiableList((List<? extends Rendition>)list6);
        this.j = j;
        List<Object> unmodifiableList;
        if (list7 != null) {
            unmodifiableList = (List<Object>)Collections.unmodifiableList((List<? extends Format>)list7);
        }
        else {
            unmodifiableList = null;
        }
        this.k = (List<Format>)unmodifiableList;
        this.l = Collections.unmodifiableMap((Map<? extends String, ? extends String>)map);
        this.m = Collections.unmodifiableList((List<? extends DrmInitData>)list8);
    }
    
    private static void b(final List<Rendition> list, final List<Uri> list2) {
        for (int i = 0; i < list.size(); ++i) {
            final Uri a = list.get(i).a;
            if (a != null && !list2.contains(a)) {
                list2.add(a);
            }
        }
    }
    
    private static <T> List<T> d(final List<T> list, final int n, final List<StreamKey> list2) {
        final ArrayList list3 = new ArrayList(list2.size());
        for (int i = 0; i < list.size(); ++i) {
            final Object value = list.get(i);
            for (int j = 0; j < list2.size(); ++j) {
                final StreamKey streamKey = list2.get(j);
                if (streamKey.b == n && streamKey.c == i) {
                    list3.add(value);
                    break;
                }
            }
        }
        return list3;
    }
    
    public static HlsMultivariantPlaylist e(final String s) {
        return new HlsMultivariantPlaylist("", Collections.emptyList(), Collections.singletonList(Variant.b(Uri.parse(s))), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), null, null, false, Collections.emptyMap(), Collections.emptyList());
    }
    
    private static List<Uri> f(final List<Variant> list, final List<Rendition> list2, final List<Rendition> list3, final List<Rendition> list4, final List<Rendition> list5) {
        final ArrayList list6 = new ArrayList();
        for (int i = 0; i < list.size(); ++i) {
            final Uri a = list.get(i).a;
            if (!list6.contains(a)) {
                list6.add(a);
            }
        }
        b(list2, list6);
        b(list3, list6);
        b(list4, list6);
        b(list5, list6);
        return list6;
    }
    
    @Override
    public /* bridge */ Object a(final List list) {
        return this.c(list);
    }
    
    public HlsMultivariantPlaylist c(final List<StreamKey> list) {
        return new HlsMultivariantPlaylist(super.a, super.b, d(this.e, 0, list), Collections.emptyList(), d(this.g, 1, list), d(this.h, 2, list), Collections.emptyList(), this.j, this.k, super.c, this.l, this.m);
    }
    
    public static final class Rendition
    {
        public final Uri a;
        public final Format b;
        public final String c;
        public final String d;
        
        public Rendition(final Uri a, final Format b, final String c, final String d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }
    }
    
    public static final class Variant
    {
        public final Uri a;
        public final Format b;
        public final String c;
        public final String d;
        public final String e;
        public final String f;
        
        public Variant(final Uri a, final Format b, final String c, final String d, final String e, final String f) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
            this.f = f;
        }
        
        public static Variant b(final Uri uri) {
            return new Variant(uri, new Format.Builder().S("0").K("application/x-mpegURL").E(), null, null, null, null);
        }
        
        public Variant a(final Format format) {
            return new Variant(this.a, format, this.c, this.d, this.e, this.f);
        }
    }
}
