// 
// Decompiled by Procyon v0.6.0
// 

package androidx.constraintlayout.core.widgets.analyzer;

import java.util.Iterator;
import s.a;

class e extends DependencyNode
{
    public int m;
    
    public e(final WidgetRun widgetRun) {
        super(widgetRun);
        if (widgetRun instanceof j) {
            super.e = Type.HORIZONTAL_DIMENSION;
        }
        else {
            super.e = Type.VERTICAL_DIMENSION;
        }
    }
    
    @Override
    public void d(final int g) {
        if (super.j) {
            return;
        }
        super.j = true;
        super.g = g;
        for (final a a : super.k) {
            a.a(a);
        }
    }
}
