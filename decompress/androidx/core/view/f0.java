// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.view;

import ta.a;
import java.util.Iterator;
import kotlin.jvm.internal.o;
import android.view.View;
import kotlin.sequences.h;
import android.view.ViewGroup;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0013\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u0086\u0002\"\u001b\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b" }, d2 = { "Landroid/view/ViewGroup;", "", "Landroid/view/View;", "b", "Lkotlin/sequences/h;", "a", "(Landroid/view/ViewGroup;)Lkotlin/sequences/h;", "children", "core-ktx_release" }, k = 2, mv = { 1, 6, 0 })
public final class f0
{
    public static final h<View> a(final ViewGroup viewGroup) {
        o.g((Object)viewGroup, "<this>");
        return (h<View>)new h<View>(viewGroup) {
            final ViewGroup a;
            
            public Iterator<View> iterator() {
                return f0.b(this.a);
            }
        };
    }
    
    public static final Iterator<View> b(final ViewGroup viewGroup) {
        o.g((Object)viewGroup, "<this>");
        return new Iterator<View>(viewGroup) {
            private int a;
            final ViewGroup b;
            
            public View b() {
                final View child = this.b.getChildAt(this.a++);
                if (child != null) {
                    return child;
                }
                throw new IndexOutOfBoundsException();
            }
            
            @Override
            public boolean hasNext() {
                return this.a < this.b.getChildCount();
            }
            
            @Override
            public /* bridge */ Object next() {
                return this.b();
            }
            
            @Override
            public void remove() {
                this.b.removeViewAt(--this.a);
            }
        };
    }
}
