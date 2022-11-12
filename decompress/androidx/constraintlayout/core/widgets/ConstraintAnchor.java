// 
// Decompiled by Procyon v0.6.0
// 

package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.c;
import java.util.Iterator;
import androidx.constraintlayout.core.widgets.analyzer.g;
import androidx.constraintlayout.core.widgets.analyzer.m;
import java.util.ArrayList;
import androidx.constraintlayout.core.SolverVariable;
import java.util.HashSet;

public class ConstraintAnchor
{
    private HashSet<ConstraintAnchor> a;
    private int b;
    private boolean c;
    public final ConstraintWidget d;
    public final Type e;
    public ConstraintAnchor f;
    public int g;
    int h;
    SolverVariable i;
    
    public ConstraintAnchor(final ConstraintWidget d, final Type e) {
        this.a = null;
        this.g = 0;
        this.h = Integer.MIN_VALUE;
        this.d = d;
        this.e = e;
    }
    
    public boolean a(final ConstraintAnchor f, final int g, final int h, final boolean b) {
        if (f == null) {
            this.p();
            return true;
        }
        if (!b && !this.o(f)) {
            return false;
        }
        this.f = f;
        if (f.a == null) {
            f.a = new HashSet<ConstraintAnchor>();
        }
        final HashSet<ConstraintAnchor> a = this.f.a;
        if (a != null) {
            a.add(this);
        }
        this.g = g;
        this.h = h;
        return true;
    }
    
    public void b(final int n, final ArrayList<m> list, final m m) {
        final HashSet<ConstraintAnchor> a = this.a;
        if (a != null) {
            final Iterator<ConstraintAnchor> iterator = a.iterator();
            while (iterator.hasNext()) {
                androidx.constraintlayout.core.widgets.analyzer.g.a(iterator.next().d, n, list, m);
            }
        }
    }
    
    public HashSet<ConstraintAnchor> c() {
        return this.a;
    }
    
    public int d() {
        if (!this.c) {
            return 0;
        }
        return this.b;
    }
    
    public int e() {
        if (this.d.T() == 8) {
            return 0;
        }
        if (this.h != Integer.MIN_VALUE) {
            final ConstraintAnchor f = this.f;
            if (f != null && f.d.T() == 8) {
                return this.h;
            }
        }
        return this.g;
    }
    
    public final ConstraintAnchor f() {
        switch (ConstraintAnchor$a.a[this.e.ordinal()]) {
            default: {
                throw new AssertionError((Object)this.e.name());
            }
            case 5: {
                return this.d.P;
            }
            case 4: {
                return this.d.R;
            }
            case 3: {
                return this.d.O;
            }
            case 2: {
                return this.d.Q;
            }
            case 1:
            case 6:
            case 7:
            case 8:
            case 9: {
                return null;
            }
        }
    }
    
    public ConstraintWidget g() {
        return this.d;
    }
    
    public SolverVariable h() {
        return this.i;
    }
    
    public ConstraintAnchor i() {
        return this.f;
    }
    
    public Type j() {
        return this.e;
    }
    
    public boolean k() {
        final HashSet<ConstraintAnchor> a = this.a;
        if (a == null) {
            return false;
        }
        final Iterator<ConstraintAnchor> iterator = a.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().f().n()) {
                return true;
            }
        }
        return false;
    }
    
    public boolean l() {
        final HashSet<ConstraintAnchor> a = this.a;
        boolean b = false;
        if (a == null) {
            return false;
        }
        if (a.size() > 0) {
            b = true;
        }
        return b;
    }
    
    public boolean m() {
        return this.c;
    }
    
    public boolean n() {
        return this.f != null;
    }
    
    public boolean o(final ConstraintAnchor constraintAnchor) {
        final boolean b = false;
        final boolean b2 = false;
        final boolean b3 = false;
        if (constraintAnchor == null) {
            return false;
        }
        final Type j = constraintAnchor.j();
        final Type e = this.e;
        if (j == e) {
            return e != Type.BASELINE || (constraintAnchor.g().X() && this.g().X());
        }
        switch (ConstraintAnchor$a.a[e.ordinal()]) {
            default: {
                throw new AssertionError((Object)this.e.name());
            }
            case 7:
            case 8:
            case 9: {
                return false;
            }
            case 6: {
                return j != Type.LEFT && j != Type.RIGHT;
            }
            case 4:
            case 5: {
                boolean b4 = j == Type.TOP || j == Type.BOTTOM;
                if (constraintAnchor.g() instanceof e) {
                    boolean b5 = false;
                    Label_0219: {
                        if (!b4) {
                            b5 = b3;
                            if (j != Type.CENTER_Y) {
                                break Label_0219;
                            }
                        }
                        b5 = true;
                    }
                    b4 = b5;
                }
                return b4;
            }
            case 2:
            case 3: {
                boolean b6 = j == Type.LEFT || j == Type.RIGHT;
                if (constraintAnchor.g() instanceof e) {
                    boolean b7 = false;
                    Label_0278: {
                        if (!b6) {
                            b7 = b;
                            if (j != Type.CENTER_X) {
                                break Label_0278;
                            }
                        }
                        b7 = true;
                    }
                    b6 = b7;
                }
                return b6;
            }
            case 1: {
                boolean b8 = b2;
                if (j != Type.BASELINE) {
                    b8 = b2;
                    if (j != Type.CENTER_X) {
                        b8 = b2;
                        if (j != Type.CENTER_Y) {
                            b8 = true;
                        }
                    }
                }
                return b8;
            }
        }
    }
    
    public void p() {
        final ConstraintAnchor f = this.f;
        if (f != null) {
            final HashSet<ConstraintAnchor> a = f.a;
            if (a != null) {
                a.remove(this);
                if (this.f.a.size() == 0) {
                    this.f.a = null;
                }
            }
        }
        this.a = null;
        this.f = null;
        this.g = 0;
        this.h = Integer.MIN_VALUE;
        this.c = false;
        this.b = 0;
    }
    
    public void q() {
        this.c = false;
        this.b = 0;
    }
    
    public void r(final c c) {
        final SolverVariable i = this.i;
        if (i == null) {
            this.i = new SolverVariable(SolverVariable.Type.UNRESTRICTED, null);
        }
        else {
            i.g();
        }
    }
    
    public void s(final int b) {
        this.b = b;
        this.c = true;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.d.r());
        sb.append(":");
        sb.append(this.e.toString());
        return sb.toString();
    }
    
    public enum Type
    {
        private static final Type[] $VALUES;
        
        BASELINE, 
        BOTTOM, 
        CENTER, 
        CENTER_X, 
        CENTER_Y, 
        LEFT, 
        NONE, 
        RIGHT, 
        TOP;
    }
}
