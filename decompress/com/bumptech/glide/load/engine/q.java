// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load.engine;

import java.util.Arrays;
import java.util.Collection;
import java.util.ArrayList;
import v2.k;
import java.util.List;
import androidx.core.util.e;

public class q<Data, ResourceType, Transcode>
{
    private final Class<Data> a;
    private final e<List<Throwable>> b;
    private final List<? extends g<Data, ResourceType, Transcode>> c;
    private final String d;
    
    public q(final Class<Data> a, final Class<ResourceType> clazz, final Class<Transcode> clazz2, final List<g<Data, ResourceType, Transcode>> list, final e<List<Throwable>> b) {
        this.a = a;
        this.b = b;
        this.c = k.c(list);
        final StringBuilder sb = new StringBuilder();
        sb.append("Failed LoadPath{");
        sb.append(a.getSimpleName());
        sb.append("->");
        sb.append(clazz.getSimpleName());
        sb.append("->");
        sb.append(clazz2.getSimpleName());
        sb.append("}");
        this.d = sb.toString();
    }
    
    private s<Transcode> b(final com.bumptech.glide.load.data.e<Data> e, final c2.e e2, final int n, final int n2, final g.a<ResourceType> a, final List<Throwable> list) throws GlideException {
        final int size = this.c.size();
        int n3 = 0;
        s<Object> a2 = null;
        s<Object> s;
        while (true) {
            s = a2;
            if (n3 >= size) {
                break;
            }
            final g g = (g)this.c.get(n3);
            try {
                a2 = g.a(e, n, n2, e2, (g.a<Object>)a);
            }
            catch (final GlideException ex) {
                list.add(ex);
            }
            if (a2 != null) {
                s = a2;
                break;
            }
            ++n3;
        }
        if (s != null) {
            return (s<Transcode>)s;
        }
        throw new GlideException(this.d, new ArrayList<Throwable>(list));
    }
    
    public s<Transcode> a(final com.bumptech.glide.load.data.e<Data> e, final c2.e e2, final int n, final int n2, final g.a<ResourceType> a) throws GlideException {
        final List<Throwable> list = k.d(this.b.a());
        try {
            return this.b(e, e2, n, n2, a, list);
        }
        finally {
            this.b.b(list);
        }
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("LoadPath{decodePaths=");
        sb.append(Arrays.toString(this.c.toArray()));
        sb.append('}');
        return sb.toString();
    }
}
