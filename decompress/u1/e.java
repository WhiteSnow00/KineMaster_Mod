// 
// Decompiled by Procyon v0.6.0
// 

package u1;

import r1.i;
import r1.j;
import z1.a;
import java.util.List;
import android.graphics.PointF;

public class e implements m<PointF, PointF>
{
    private final List<a<PointF>> a;
    
    public e(final List<a<PointF>> a) {
        this.a = a;
    }
    
    @Override
    public r1.a<PointF, PointF> a() {
        if (this.a.get(0).h()) {
            return (r1.a<PointF, PointF>)new j(this.a);
        }
        return (r1.a<PointF, PointF>)new i(this.a);
    }
    
    @Override
    public List<a<PointF>> b() {
        return this.a;
    }
    
    @Override
    public boolean f() {
        final int size = this.a.size();
        boolean b = false;
        if (size == 1) {
            b = b;
            if (this.a.get(0).h()) {
                b = true;
            }
        }
        return b;
    }
}
