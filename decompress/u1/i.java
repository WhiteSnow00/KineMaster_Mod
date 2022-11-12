// 
// Decompiled by Procyon v0.6.0
// 

package u1;

import java.util.List;
import r1.a;
import android.graphics.PointF;

public class i implements m<PointF, PointF>
{
    private final b a;
    private final b b;
    
    public i(final b a, final b b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public a<PointF, PointF> a() {
        return new r1.m(this.a.a(), this.b.a());
    }
    
    @Override
    public List<z1.a<PointF>> b() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }
    
    @Override
    public boolean f() {
        return this.a.f() && this.b.f();
    }
}
