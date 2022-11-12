// 
// Decompiled by Procyon v0.6.0
// 

package androidx.databinding;

import android.view.View;
import java.util.Iterator;
import android.util.Log;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MergedDataBinderMapper extends e
{
    private Set<Class<? extends e>> a;
    private List<e> b;
    private List<String> c;
    
    public MergedDataBinderMapper() {
        this.a = new HashSet<Class<? extends e>>();
        this.b = new CopyOnWriteArrayList<e>();
        this.c = new CopyOnWriteArrayList<String>();
    }
    
    private boolean e() {
        for (final String s : this.c) {
            try {
                final Class<?> forName = Class.forName(s);
                if (!e.class.isAssignableFrom(forName)) {
                    continue;
                }
                this.d((e)forName.newInstance());
                this.c.remove(s);
            }
            catch (final InstantiationException ex) {
                final StringBuilder sb = new StringBuilder();
                sb.append("unable to add feature mapper for ");
                sb.append(s);
                Log.e("MergedDataBinderMapper", sb.toString(), (Throwable)ex);
            }
            catch (final IllegalAccessException ex2) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("unable to add feature mapper for ");
                sb2.append(s);
                Log.e("MergedDataBinderMapper", sb2.toString(), (Throwable)ex2);
            }
            catch (final ClassNotFoundException ex3) {}
        }
        goto Label_0159;
    }
    
    @Override
    public ViewDataBinding b(final f f, final View view, final int n) {
        final Iterator<e> iterator = this.b.iterator();
        while (iterator.hasNext()) {
            final ViewDataBinding b = iterator.next().b(f, view, n);
            if (b != null) {
                return b;
            }
        }
        if (this.e()) {
            return this.b(f, view, n);
        }
        return null;
    }
    
    @Override
    public ViewDataBinding c(final f f, final View[] array, final int n) {
        final Iterator<e> iterator = this.b.iterator();
        while (iterator.hasNext()) {
            final ViewDataBinding c = iterator.next().c(f, array, n);
            if (c != null) {
                return c;
            }
        }
        if (this.e()) {
            return this.c(f, array, n);
        }
        return null;
    }
    
    public void d(final e e) {
        if (this.a.add(e.getClass())) {
            this.b.add(e);
            final Iterator<e> iterator = e.a().iterator();
            while (iterator.hasNext()) {
                this.d(iterator.next());
            }
        }
    }
}
