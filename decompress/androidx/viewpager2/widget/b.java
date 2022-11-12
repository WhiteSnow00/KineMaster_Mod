// 
// Decompiled by Procyon v0.6.0
// 

package androidx.viewpager2.widget;

import java.util.Iterator;
import java.util.ConcurrentModificationException;
import java.util.ArrayList;
import java.util.List;

final class b extends i
{
    private final List<i> a;
    
    b(final int n) {
        this.a = new ArrayList<i>(n);
    }
    
    private void c(final ConcurrentModificationException ex) {
        throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", ex);
    }
    
    void a(final i i) {
        this.a.add(i);
    }
    
    void b(final i i) {
        this.a.remove(i);
    }
    
    @Override
    public void onPageScrollStateChanged(final int n) {
        try {
            final Iterator<i> iterator = this.a.iterator();
            while (iterator.hasNext()) {
                iterator.next().onPageScrollStateChanged(n);
            }
        }
        catch (final ConcurrentModificationException ex) {
            this.c(ex);
        }
    }
    
    @Override
    public void onPageScrolled(final int n, final float n2, final int n3) {
        try {
            final Iterator<i> iterator = this.a.iterator();
            while (iterator.hasNext()) {
                iterator.next().onPageScrolled(n, n2, n3);
            }
        }
        catch (final ConcurrentModificationException ex) {
            this.c(ex);
        }
    }
    
    @Override
    public void onPageSelected(final int n) {
        try {
            final Iterator<i> iterator = this.a.iterator();
            while (iterator.hasNext()) {
                iterator.next().onPageSelected(n);
            }
        }
        catch (final ConcurrentModificationException ex) {
            this.c(ex);
        }
    }
}
