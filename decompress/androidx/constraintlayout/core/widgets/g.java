// 
// Decompiled by Procyon v0.6.0
// 

package androidx.constraintlayout.core.widgets;

import java.util.HashSet;
import r.b;

public class g extends b
{
    private int N0;
    private int O0;
    private int P0;
    private int Q0;
    private int R0;
    private int S0;
    private int T0;
    private int U0;
    private boolean V0;
    private int W0;
    private int X0;
    protected androidx.constraintlayout.core.widgets.analyzer.b.a Y0;
    androidx.constraintlayout.core.widgets.analyzer.b.b Z0;
    
    public g() {
        this.N0 = 0;
        this.O0 = 0;
        this.P0 = 0;
        this.Q0 = 0;
        this.R0 = 0;
        this.S0 = 0;
        this.T0 = 0;
        this.U0 = 0;
        this.V0 = false;
        this.W0 = 0;
        this.X0 = 0;
        this.Y0 = new androidx.constraintlayout.core.widgets.analyzer.b.a();
        this.Z0 = null;
    }
    
    @Override
    public void c(final d d) {
        this.q1();
    }
    
    public void q1() {
        for (int i = 0; i < super.M0; ++i) {
            final ConstraintWidget constraintWidget = super.L0[i];
            if (constraintWidget != null) {
                constraintWidget.R0(true);
            }
        }
    }
    
    public boolean r1(final HashSet<ConstraintWidget> set) {
        for (int i = 0; i < super.M0; ++i) {
            if (set.contains(super.L0[i])) {
                return true;
            }
        }
        return false;
    }
    
    public boolean s1() {
        return this.V0;
    }
}
