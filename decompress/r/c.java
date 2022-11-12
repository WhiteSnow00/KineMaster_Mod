// 
// Decompiled by Procyon v0.6.0
// 

package r;

import java.util.ArrayList;
import androidx.constraintlayout.core.widgets.ConstraintWidget;

public class c extends ConstraintWidget
{
    public ArrayList<ConstraintWidget> L0;
    
    public c() {
        this.L0 = new ArrayList<ConstraintWidget>();
    }
    
    public void a(final ConstraintWidget constraintWidget) {
        this.L0.add(constraintWidget);
        if (constraintWidget.I() != null) {
            ((c)constraintWidget.I()).q1(constraintWidget);
        }
        constraintWidget.Z0(this);
    }
    
    public ArrayList<ConstraintWidget> o1() {
        return this.L0;
    }
    
    public void p1() {
        final ArrayList<ConstraintWidget> l0 = this.L0;
        if (l0 == null) {
            return;
        }
        for (int size = l0.size(), i = 0; i < size; ++i) {
            final ConstraintWidget constraintWidget = this.L0.get(i);
            if (constraintWidget instanceof c) {
                ((c)constraintWidget).p1();
            }
        }
    }
    
    public void q1(final ConstraintWidget constraintWidget) {
        this.L0.remove(constraintWidget);
        constraintWidget.r0();
    }
    
    @Override
    public void r0() {
        this.L0.clear();
        super.r0();
    }
    
    public void r1() {
        this.L0.clear();
    }
    
    @Override
    public void t0(final androidx.constraintlayout.core.c c) {
        super.t0(c);
        for (int size = this.L0.size(), i = 0; i < size; ++i) {
            this.L0.get(i).t0(c);
        }
    }
}
