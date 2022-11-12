// 
// Decompiled by Procyon v0.6.0
// 

package com.airbnb.lottie;

import java.util.Iterator;
import java.util.HashMap;
import androidx.collection.b;
import androidx.core.util.d;
import java.util.Comparator;
import y1.f;
import java.util.Map;
import java.util.Set;

public class n
{
    private boolean a;
    private final Set<b> b;
    private final Map<String, f> c;
    private final Comparator<d<String, Float>> d;
    
    public n() {
        this.a = false;
        this.b = new androidx.collection.b<b>();
        this.c = new HashMap<String, f>();
        this.d = new Comparator<d<String, Float>>() {
            final n a;
            
            public int a(final d<String, Float> d, final d<String, Float> d2) {
                final float floatValue = d.b;
                final float floatValue2 = d2.b;
                if (floatValue2 > floatValue) {
                    return 1;
                }
                if (floatValue > floatValue2) {
                    return -1;
                }
                return 0;
            }
            
            @Override
            public /* bridge */ int compare(final Object o, final Object o2) {
                return this.a((d<String, Float>)o, (d<String, Float>)o2);
            }
        };
    }
    
    public void a(final String s, final float n) {
        if (!this.a) {
            return;
        }
        f f;
        if ((f = this.c.get(s)) == null) {
            f = new f();
            this.c.put(s, f);
        }
        f.a(n);
        if (s.equals("__container")) {
            final Iterator<b> iterator = this.b.iterator();
            while (iterator.hasNext()) {
                iterator.next().a(n);
            }
        }
    }
    
    void b(final boolean a) {
        this.a = a;
    }
    
    public interface b
    {
        void a(final float p0);
    }
}
