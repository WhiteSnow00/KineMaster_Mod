// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide;

import java.util.Iterator;
import android.widget.ImageView;
import android.content.Context;
import com.bumptech.glide.request.h;
import com.bumptech.glide.load.engine.i;
import java.util.Map;
import java.util.List;
import s2.g;
import e2.b;
import android.content.ContextWrapper;

public class e extends ContextWrapper
{
    static final j<?, ?> k;
    private final b a;
    private final Registry b;
    private final g c;
    private final c.a d;
    private final List<com.bumptech.glide.request.g<Object>> e;
    private final Map<Class<?>, j<?, ?>> f;
    private final i g;
    private final f h;
    private final int i;
    private h j;
    
    static {
        k = new com.bumptech.glide.b<Object>();
    }
    
    public e(final Context context, final b a, final Registry b, final g c, final c.a d, final Map<Class<?>, j<?, ?>> f, final List<com.bumptech.glide.request.g<Object>> e, final i g, final f h, final int i) {
        super(context.getApplicationContext());
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
    }
    
    public <X> s2.j<ImageView, X> a(final ImageView imageView, final Class<X> clazz) {
        return this.c.a(imageView, clazz);
    }
    
    public b b() {
        return this.a;
    }
    
    public List<com.bumptech.glide.request.g<Object>> c() {
        return this.e;
    }
    
    public h d() {
        synchronized (this) {
            if (this.j == null) {
                this.j = this.d.build().T();
            }
            return this.j;
        }
    }
    
    public <T> j<?, T> e(final Class<T> clazz) {
        j i;
        j j = i = this.f.get(clazz);
        if (j == null) {
            final Iterator<Map.Entry<Class<?>, j<?, ?>>> iterator = this.f.entrySet().iterator();
            while (true) {
                i = j;
                if (!iterator.hasNext()) {
                    break;
                }
                final Map.Entry<Class, V> entry = iterator.next();
                if (!entry.getKey().isAssignableFrom(clazz)) {
                    continue;
                }
                j = (j)entry.getValue();
            }
        }
        j<?, ?> k;
        if ((k = i) == null) {
            k = com.bumptech.glide.e.k;
        }
        return (j<?, T>)k;
    }
    
    public i f() {
        return this.g;
    }
    
    public f g() {
        return this.h;
    }
    
    public int h() {
        return this.i;
    }
    
    public Registry i() {
        return this.b;
    }
}
