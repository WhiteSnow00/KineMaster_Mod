// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load.engine;

import java.util.Collection;
import java.util.ArrayList;
import android.util.Log;
import java.io.IOException;
import v2.k;
import o2.e;
import c2.f;
import java.util.List;

public class g<DataType, ResourceType, Transcode>
{
    private final Class<DataType> a;
    private final List<? extends f<DataType, ResourceType>> b;
    private final e<ResourceType, Transcode> c;
    private final androidx.core.util.e<List<Throwable>> d;
    private final String e;
    
    public g(final Class<DataType> a, final Class<ResourceType> clazz, final Class<Transcode> clazz2, final List<? extends f<DataType, ResourceType>> b, final e<ResourceType, Transcode> c, final androidx.core.util.e<List<Throwable>> d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        final StringBuilder sb = new StringBuilder();
        sb.append("Failed DecodePath{");
        sb.append(a.getSimpleName());
        sb.append("->");
        sb.append(clazz.getSimpleName());
        sb.append("->");
        sb.append(clazz2.getSimpleName());
        sb.append("}");
        this.e = sb.toString();
    }
    
    private s<ResourceType> b(final com.bumptech.glide.load.data.e<DataType> e, final int n, final int n2, final c2.e e2) throws GlideException {
        final List<Throwable> list = k.d(this.d.a());
        try {
            return this.c(e, n, n2, e2, list);
        }
        finally {
            this.d.b(list);
        }
    }
    
    private s<ResourceType> c(final com.bumptech.glide.load.data.e<DataType> e, final int n, final int n2, final c2.e e2, final List<Throwable> list) throws GlideException {
        final int size = this.b.size();
        Throwable t = null;
        int n3 = 0;
        Object a;
        while (true) {
            a = t;
            if (n3 >= size) {
                break;
            }
            final f f = (f)this.b.get(n3);
            a = t;
            Label_0161: {
                try {
                    if (f.b(e.a(), e2)) {
                        a = f.a(e.a(), n, n2, e2);
                    }
                    break Label_0161;
                }
                catch (final OutOfMemoryError a) {}
                catch (final RuntimeException a) {}
                catch (final IOException ex) {}
                if (Log.isLoggable("DecodePath", 2)) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Failed to decode data for ");
                    sb.append(f);
                    Log.v("DecodePath", sb.toString(), (Throwable)a);
                }
                list.add((OutOfMemoryError)a);
                a = t;
            }
            if (a != null) {
                break;
            }
            ++n3;
            t = (Throwable)a;
        }
        if (a != null) {
            return (s<ResourceType>)a;
        }
        throw new GlideException(this.e, new ArrayList<Throwable>(list));
    }
    
    public s<Transcode> a(final com.bumptech.glide.load.data.e<DataType> e, final int n, final int n2, final c2.e e2, final a<ResourceType> a) throws GlideException {
        return this.c.a(a.a(this.b(e, n, n2, e2)), e2);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("DecodePath{ dataClass=");
        sb.append(this.a);
        sb.append(", decoders=");
        sb.append(this.b);
        sb.append(", transcoder=");
        sb.append(this.c);
        sb.append('}');
        return sb.toString();
    }
    
    interface a<ResourceType>
    {
        s<ResourceType> a(final s<ResourceType> p0);
    }
}
