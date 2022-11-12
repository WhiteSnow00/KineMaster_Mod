// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.view;

import java.util.List;
import android.graphics.Rect;
import androidx.core.util.c;
import android.os.Build$VERSION;
import android.view.DisplayCutout;

public final class d
{
    private final DisplayCutout a;
    
    private d(final DisplayCutout a) {
        this.a = a;
    }
    
    static d e(final DisplayCutout displayCutout) {
        d d;
        if (displayCutout == null) {
            d = null;
        }
        else {
            d = new d(displayCutout);
        }
        return d;
    }
    
    public int a() {
        if (Build$VERSION.SDK_INT >= 28) {
            return d.a.c(this.a);
        }
        return 0;
    }
    
    public int b() {
        if (Build$VERSION.SDK_INT >= 28) {
            return d.a.d(this.a);
        }
        return 0;
    }
    
    public int c() {
        if (Build$VERSION.SDK_INT >= 28) {
            return d.a.e(this.a);
        }
        return 0;
    }
    
    public int d() {
        if (Build$VERSION.SDK_INT >= 28) {
            return d.a.f(this.a);
        }
        return 0;
    }
    
    @Override
    public boolean equals(final Object o) {
        return this == o || (o != null && d.class == o.getClass() && c.a(this.a, ((d)o).a));
    }
    
    @Override
    public int hashCode() {
        final DisplayCutout a = this.a;
        int hashCode;
        if (a == null) {
            hashCode = 0;
        }
        else {
            hashCode = a.hashCode();
        }
        return hashCode;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("DisplayCutoutCompat{");
        sb.append(this.a);
        sb.append("}");
        return sb.toString();
    }
    
    static class a
    {
        static DisplayCutout a(final Rect rect, final List<Rect> list) {
            return new DisplayCutout(rect, (List)list);
        }
        
        static List<Rect> b(final DisplayCutout displayCutout) {
            return displayCutout.getBoundingRects();
        }
        
        static int c(final DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetBottom();
        }
        
        static int d(final DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetLeft();
        }
        
        static int e(final DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetRight();
        }
        
        static int f(final DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetTop();
        }
    }
}
