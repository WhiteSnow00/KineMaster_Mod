// 
// Decompiled by Procyon v0.6.0
// 

package androidx.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.view.MotionEvent;
import java.util.Iterator;
import java.util.Collection;
import androidx.constraintlayout.widget.c;
import android.util.Log;
import androidx.constraintlayout.widget.i;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.view.View;
import java.util.HashSet;
import java.util.ArrayList;

public class u
{
    private final MotionLayout a;
    private ArrayList<t> b;
    private HashSet<View> c;
    private String d;
    ArrayList<t.b> e;
    ArrayList<t.b> f;
    
    public u(final MotionLayout a) {
        this.b = new ArrayList<t>();
        this.d = "ViewTransitionController";
        this.f = new ArrayList<t.b>();
        this.a = a;
    }
    
    private void e(final t t, final boolean b) {
        ConstraintLayout.getSharedValues().a(t.h(), (i.a)new i.a(this, t, t.h(), b, t.g()) {
            final t a;
            final int b;
            final boolean c;
            final int d;
            final u e;
        });
    }
    
    private void i(final t t, final View... array) {
        final int currentState = this.a.getCurrentState();
        if (t.e != 2) {
            if (currentState == -1) {
                final String d = this.d;
                final StringBuilder sb = new StringBuilder();
                sb.append("No support for ViewTransition within transition yet. Currently: ");
                sb.append(this.a.toString());
                Log.w(d, sb.toString());
                return;
            }
            final c t2 = this.a.t(currentState);
            if (t2 == null) {
                return;
            }
            t.c(this, this.a, currentState, t2, array);
        }
        else {
            t.c(this, this.a, currentState, null, array);
        }
    }
    
    public void a(final t t) {
        this.b.add(t);
        this.c = null;
        if (t.i() == 4) {
            this.e(t, true);
        }
        else if (t.i() == 5) {
            this.e(t, false);
        }
    }
    
    void b(final t.b b) {
        if (this.e == null) {
            this.e = new ArrayList<t.b>();
        }
        this.e.add(b);
    }
    
    void c() {
        final ArrayList<t.b> e = this.e;
        if (e == null) {
            return;
        }
        final Iterator<t.b> iterator = e.iterator();
        while (iterator.hasNext()) {
            iterator.next().a();
        }
        this.e.removeAll(this.f);
        this.f.clear();
        if (this.e.isEmpty()) {
            this.e = null;
        }
    }
    
    void d() {
        this.a.invalidate();
    }
    
    void f(final t.b b) {
        this.f.add(b);
    }
    
    void g(final MotionEvent motionEvent) {
        final int currentState = this.a.getCurrentState();
        if (currentState == -1) {
            return;
        }
        if (this.c == null) {
            this.c = new HashSet<View>();
            for (final t t : this.b) {
                for (int childCount = this.a.getChildCount(), i = 0; i < childCount; ++i) {
                    final View child = this.a.getChildAt(i);
                    if (t.k(child)) {
                        child.getId();
                        this.c.add(child);
                    }
                }
            }
        }
        final float x = motionEvent.getX();
        final float y = motionEvent.getY();
        final Rect rect = new Rect();
        final int action = motionEvent.getAction();
        final ArrayList<t.b> e = this.e;
        if (e != null && !e.isEmpty()) {
            final Iterator<t.b> iterator2 = this.e.iterator();
            while (iterator2.hasNext()) {
                iterator2.next().d(action, x, y);
            }
        }
        if (action == 0 || action == 1) {
            final c t2 = this.a.t(currentState);
            for (final t t3 : this.b) {
                if (t3.m(action)) {
                    for (final View view : this.c) {
                        if (!t3.k(view)) {
                            continue;
                        }
                        view.getHitRect(rect);
                        if (!rect.contains((int)x, (int)y)) {
                            continue;
                        }
                        t3.c(this, this.a, currentState, t2, view);
                    }
                }
            }
        }
    }
    
    void h(final int n, final View... array) {
        final ArrayList list = new ArrayList();
        final Iterator<t> iterator = this.b.iterator();
        t t = null;
        while (iterator.hasNext()) {
            final t t2 = iterator.next();
            if (t2.e() == n) {
                for (final View view : array) {
                    if (t2.d(view)) {
                        list.add(view);
                    }
                }
                if (!list.isEmpty()) {
                    this.i(t2, (View[])list.toArray(new View[0]));
                    list.clear();
                }
                t = t2;
            }
        }
        if (t == null) {
            Log.e(this.d, " Could not find ViewTransition");
        }
    }
}
