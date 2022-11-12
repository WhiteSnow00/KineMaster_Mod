// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide;

import com.bumptech.glide.load.engine.s;
import java.util.Collections;
import h2.n;
import com.bumptech.glide.load.engine.q;
import com.bumptech.glide.load.ImageHeaderParser;
import h2.o;
import java.util.Iterator;
import java.util.ArrayList;
import com.bumptech.glide.load.engine.g;
import java.util.Arrays;
import java.util.List;
import r2.c;
import r2.d;
import r2.b;
import r2.f;
import r2.e;
import r2.a;
import h2.p;

public class Registry
{
    private final p a;
    private final a b;
    private final e c;
    private final f d;
    private final com.bumptech.glide.load.data.f e;
    private final o2.f f;
    private final b g;
    private final d h;
    private final c i;
    private final androidx.core.util.e<List<Throwable>> j;
    
    public Registry() {
        this.h = new d();
        this.i = new c();
        final androidx.core.util.e<List<Object>> e = w2.a.e();
        this.j = (androidx.core.util.e<List<Throwable>>)e;
        this.a = new p((androidx.core.util.e<List<Throwable>>)e);
        this.b = new a();
        this.c = new e();
        this.d = new f();
        this.e = new com.bumptech.glide.load.data.f();
        this.f = new o2.f();
        this.g = new b();
        this.r(Arrays.asList("Animation", "Bitmap", "BitmapDrawable"));
    }
    
    private <Data, TResource, Transcode> List<g<Data, TResource, Transcode>> f(final Class<Data> clazz, final Class<TResource> clazz2, final Class<Transcode> clazz3) {
        final ArrayList list = new ArrayList();
        for (final Class clazz4 : this.c.d(clazz, clazz2)) {
            for (final Class clazz5 : this.f.b((Class<Object>)clazz4, clazz3)) {
                list.add(new g((Class<Object>)clazz, clazz4, clazz5, (List<? extends c2.f<Object, Object>>)this.c.b(clazz, (Class<Object>)clazz4), this.f.a((Class<Object>)clazz4, (Class<Object>)clazz5), this.j));
            }
        }
        return list;
    }
    
    public <Data> Registry a(final Class<Data> clazz, final c2.a<Data> a) {
        this.b.a(clazz, a);
        return this;
    }
    
    public <TResource> Registry b(final Class<TResource> clazz, final c2.g<TResource> g) {
        this.d.a(clazz, g);
        return this;
    }
    
    public <Data, TResource> Registry c(final Class<Data> clazz, final Class<TResource> clazz2, final c2.f<Data, TResource> f) {
        this.e("legacy_append", clazz, clazz2, f);
        return this;
    }
    
    public <Model, Data> Registry d(final Class<Model> clazz, final Class<Data> clazz2, final o<Model, Data> o) {
        this.a.a(clazz, clazz2, (o<? extends Model, ? extends Data>)o);
        return this;
    }
    
    public <Data, TResource> Registry e(final String s, final Class<Data> clazz, final Class<TResource> clazz2, final c2.f<Data, TResource> f) {
        this.c.a(s, f, clazz, clazz2);
        return this;
    }
    
    public List<ImageHeaderParser> g() {
        final List<ImageHeaderParser> b = this.g.b();
        if (!b.isEmpty()) {
            return b;
        }
        throw new NoImageHeaderParserException();
    }
    
    public <Data, TResource, Transcode> q<Data, TResource, Transcode> h(final Class<Data> clazz, final Class<TResource> clazz2, final Class<Transcode> clazz3) {
        final q<Data, TResource, Transcode> a = this.i.a(clazz, clazz2, clazz3);
        if (this.i.c(a)) {
            return null;
        }
        q<Data, TResource, Transcode> q;
        if ((q = a) == null) {
            final List<g<Data, TResource, Transcode>> f = this.f(clazz, clazz2, clazz3);
            if (f.isEmpty()) {
                q = null;
            }
            else {
                q = new q<Data, TResource, Transcode>((Class<Object>)clazz, (Class<Object>)clazz2, (Class<Object>)clazz3, (List<g<Object, Object, Object>>)f, this.j);
            }
            this.i.d(clazz, clazz2, clazz3, q);
        }
        return q;
    }
    
    public <Model> List<n<Model, ?>> i(final Model model) {
        return this.a.d(model);
    }
    
    public <Model, TResource, Transcode> List<Class<?>> j(final Class<Model> clazz, final Class<TResource> clazz2, final Class<Transcode> clazz3) {
        List<Class<?>> a;
        if ((a = this.h.a(clazz, clazz2, clazz3)) == null) {
            a = new ArrayList<Class<?>>();
            final Iterator<Class<?>> iterator = this.a.c(clazz).iterator();
            while (iterator.hasNext()) {
                for (final Class clazz4 : this.c.d(iterator.next(), clazz2)) {
                    if (!this.f.b((Class<Object>)clazz4, clazz3).isEmpty() && !a.contains(clazz4)) {
                        a.add(clazz4);
                    }
                }
            }
            this.h.b(clazz, clazz2, clazz3, Collections.unmodifiableList((List<? extends Class<?>>)a));
        }
        return a;
    }
    
    public <X> c2.g<X> k(final s<X> s) throws NoResultEncoderAvailableException {
        final c2.g<X> b = this.d.b(s.c());
        if (b != null) {
            return b;
        }
        throw new NoResultEncoderAvailableException(s.c());
    }
    
    public <X> com.bumptech.glide.load.data.e<X> l(final X x) {
        return this.e.a(x);
    }
    
    public <X> c2.a<X> m(final X x) throws NoSourceEncoderAvailableException {
        final c2.a<?> b = this.b.b(x.getClass());
        if (b != null) {
            return (c2.a<X>)b;
        }
        throw new NoSourceEncoderAvailableException(x.getClass());
    }
    
    public boolean n(final s<?> s) {
        return this.d.b(s.c()) != null;
    }
    
    public Registry o(final ImageHeaderParser imageHeaderParser) {
        this.g.a(imageHeaderParser);
        return this;
    }
    
    public Registry p(final com.bumptech.glide.load.data.e.a<?> a) {
        this.e.b(a);
        return this;
    }
    
    public <TResource, Transcode> Registry q(final Class<TResource> clazz, final Class<Transcode> clazz2, final o2.e<TResource, Transcode> e) {
        this.f.c(clazz, clazz2, e);
        return this;
    }
    
    public final Registry r(final List<String> list) {
        final ArrayList list2 = new ArrayList(list.size());
        list2.add("legacy_prepend_all");
        final Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            list2.add(iterator.next());
        }
        list2.add("legacy_append");
        this.c.e(list2);
        return this;
    }
    
    public static class MissingComponentException extends RuntimeException
    {
        public MissingComponentException(final String s) {
            super(s);
        }
    }
    
    public static final class NoImageHeaderParserException extends MissingComponentException
    {
        public NoImageHeaderParserException() {
            super("Failed to find image header parser.");
        }
    }
    
    public static class NoModelLoaderAvailableException extends MissingComponentException
    {
        public NoModelLoaderAvailableException(final Class<?> clazz, final Class<?> clazz2) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Failed to find any ModelLoaders for model: ");
            sb.append(clazz);
            sb.append(" and data: ");
            sb.append(clazz2);
            super(sb.toString());
        }
        
        public NoModelLoaderAvailableException(final Object o) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Failed to find any ModelLoaders registered for model class: ");
            sb.append(o.getClass());
            super(sb.toString());
        }
        
        public <M> NoModelLoaderAvailableException(final M m, final List<n<M, ?>> list) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Found ModelLoaders for model class: ");
            sb.append(list);
            sb.append(", but none that handle this specific model instance: ");
            sb.append(m);
            super(sb.toString());
        }
    }
    
    public static class NoResultEncoderAvailableException extends MissingComponentException
    {
        public NoResultEncoderAvailableException(final Class<?> clazz) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Failed to find result encoder for resource class: ");
            sb.append(clazz);
            sb.append(", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
            super(sb.toString());
        }
    }
    
    public static class NoSourceEncoderAvailableException extends MissingComponentException
    {
        public NoSourceEncoderAvailableException(final Class<?> clazz) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Failed to find source encoder for data class: ");
            sb.append(clazz);
            super(sb.toString());
        }
    }
}
