// 
// Decompiled by Procyon v0.6.0
// 

package androidx.fragment.app;

import java.util.HashSet;
import java.util.Collection;
import android.view.View;
import androidx.core.view.b0;
import java.util.List;
import android.util.Log;
import f0.b;
import java.util.Iterator;
import androidx.core.os.e;
import java.util.ArrayList;
import android.view.ViewGroup;

abstract class SpecialEffectsController
{
    private final ViewGroup a;
    final ArrayList<Operation> b;
    final ArrayList<Operation> c;
    boolean d;
    boolean e;
    
    SpecialEffectsController(final ViewGroup a) {
        this.b = new ArrayList<Operation>();
        this.c = new ArrayList<Operation>();
        this.d = false;
        this.e = false;
        this.a = a;
    }
    
    private void a(final Operation.State state, final Operation.LifecycleImpact lifecycleImpact, final a0 a0) {
        synchronized (this.b) {
            final e e = new e();
            final Operation h = this.h(a0.k());
            if (h != null) {
                h.k(state, lifecycleImpact);
                return;
            }
            final d d = new d(state, lifecycleImpact, a0, e);
            this.b.add((Operation)d);
            ((Operation)d).a(new Runnable(this, d) {
                final d a;
                final SpecialEffectsController b;
                
                @Override
                public void run() {
                    if (this.b.b.contains(this.a)) {
                        ((Operation)this.a).e().applyState(((Operation)this.a).f().mView);
                    }
                }
            });
            ((Operation)d).a(new Runnable(this, d) {
                final d a;
                final SpecialEffectsController b;
                
                @Override
                public void run() {
                    this.b.b.remove(this.a);
                    this.b.c.remove(this.a);
                }
            });
        }
    }
    
    private Operation h(final Fragment fragment) {
        for (final Operation operation : this.b) {
            if (operation.f().equals(fragment) && !operation.h()) {
                return operation;
            }
        }
        return null;
    }
    
    private Operation i(final Fragment fragment) {
        for (final Operation operation : this.c) {
            if (operation.f().equals(fragment) && !operation.h()) {
                return operation;
            }
        }
        return null;
    }
    
    static SpecialEffectsController n(final ViewGroup viewGroup, final FragmentManager fragmentManager) {
        return o(viewGroup, fragmentManager.F0());
    }
    
    static SpecialEffectsController o(final ViewGroup viewGroup, final i0 i0) {
        final int b = f0.b.b;
        final Object tag = viewGroup.getTag(b);
        if (tag instanceof SpecialEffectsController) {
            return (SpecialEffectsController)tag;
        }
        final SpecialEffectsController a = i0.a(viewGroup);
        viewGroup.setTag(b, (Object)a);
        return a;
    }
    
    private void q() {
        for (final Operation operation : this.b) {
            if (operation.g() == Operation.LifecycleImpact.ADDING) {
                operation.k(Operation.State.from(operation.f().requireView().getVisibility()), Operation.LifecycleImpact.NONE);
            }
        }
    }
    
    void b(final Operation.State state, final a0 a0) {
        if (FragmentManager.N0(2)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("SpecialEffectsController: Enqueuing add operation for fragment ");
            sb.append(a0.k());
            Log.v("FragmentManager", sb.toString());
        }
        this.a(state, Operation.LifecycleImpact.ADDING, a0);
    }
    
    void c(final a0 a0) {
        if (FragmentManager.N0(2)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("SpecialEffectsController: Enqueuing hide operation for fragment ");
            sb.append(a0.k());
            Log.v("FragmentManager", sb.toString());
        }
        this.a(Operation.State.GONE, Operation.LifecycleImpact.NONE, a0);
    }
    
    void d(final a0 a0) {
        if (FragmentManager.N0(2)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("SpecialEffectsController: Enqueuing remove operation for fragment ");
            sb.append(a0.k());
            Log.v("FragmentManager", sb.toString());
        }
        this.a(Operation.State.REMOVED, Operation.LifecycleImpact.REMOVING, a0);
    }
    
    void e(final a0 a0) {
        if (FragmentManager.N0(2)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("SpecialEffectsController: Enqueuing show operation for fragment ");
            sb.append(a0.k());
            Log.v("FragmentManager", sb.toString());
        }
        this.a(Operation.State.VISIBLE, Operation.LifecycleImpact.NONE, a0);
    }
    
    abstract void f(final List<Operation> p0, final boolean p1);
    
    void g() {
        if (this.e) {
            return;
        }
        if (!b0.S((View)this.a)) {
            this.j();
            this.d = false;
            return;
        }
        synchronized (this.b) {
            if (!this.b.isEmpty()) {
                final ArrayList list = new ArrayList(this.c);
                this.c.clear();
                for (final Operation operation : list) {
                    if (FragmentManager.N0(2)) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("SpecialEffectsController: Cancelling operation ");
                        sb.append(operation);
                        Log.v("FragmentManager", sb.toString());
                    }
                    operation.b();
                    if (!operation.i()) {
                        this.c.add(operation);
                    }
                }
                this.q();
                final ArrayList<Operation> list2 = new ArrayList<Operation>(this.b);
                this.b.clear();
                this.c.addAll(list2);
                if (FragmentManager.N0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Executing pending operations");
                }
                final Iterator<Operation> iterator2 = list2.iterator();
                while (iterator2.hasNext()) {
                    iterator2.next().l();
                }
                this.f(list2, this.d);
                this.d = false;
                if (FragmentManager.N0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Finished executing pending operations");
                }
            }
        }
    }
    
    void j() {
        if (FragmentManager.N0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Forcing all operations to complete");
        }
        final boolean s = b0.S((View)this.a);
        synchronized (this.b) {
            this.q();
            final Iterator<Operation> iterator = this.b.iterator();
            while (iterator.hasNext()) {
                iterator.next().l();
            }
            for (final Operation operation : new ArrayList(this.c)) {
                if (FragmentManager.N0(2)) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("SpecialEffectsController: ");
                    String string;
                    if (s) {
                        string = "";
                    }
                    else {
                        final StringBuilder sb2 = new StringBuilder();
                        sb2.append("Container ");
                        sb2.append(this.a);
                        sb2.append(" is not attached to window. ");
                        string = sb2.toString();
                    }
                    sb.append(string);
                    sb.append("Cancelling running operation ");
                    sb.append(operation);
                    Log.v("FragmentManager", sb.toString());
                }
                operation.b();
            }
            for (final Operation operation2 : new ArrayList(this.b)) {
                if (FragmentManager.N0(2)) {
                    final StringBuilder sb3 = new StringBuilder();
                    sb3.append("SpecialEffectsController: ");
                    String string2;
                    if (s) {
                        string2 = "";
                    }
                    else {
                        final StringBuilder sb4 = new StringBuilder();
                        sb4.append("Container ");
                        sb4.append(this.a);
                        sb4.append(" is not attached to window. ");
                        string2 = sb4.toString();
                    }
                    sb3.append(string2);
                    sb3.append("Cancelling pending operation ");
                    sb3.append(operation2);
                    Log.v("FragmentManager", sb3.toString());
                }
                operation2.b();
            }
        }
    }
    
    void k() {
        if (this.e) {
            if (FragmentManager.N0(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: Forcing postponed operations");
            }
            this.e = false;
            this.g();
        }
    }
    
    Operation.LifecycleImpact l(final a0 a0) {
        final Operation h = this.h(a0.k());
        Operation.LifecycleImpact g;
        if (h != null) {
            g = h.g();
        }
        else {
            g = null;
        }
        final Operation i = this.i(a0.k());
        if (i != null && (g == null || g == Operation.LifecycleImpact.NONE)) {
            return i.g();
        }
        return g;
    }
    
    public ViewGroup m() {
        return this.a;
    }
    
    void p() {
        synchronized (this.b) {
            this.q();
            this.e = false;
            for (int i = this.b.size() - 1; i >= 0; --i) {
                final Operation operation = this.b.get(i);
                final Operation.State from = Operation.State.from(operation.f().mView);
                final Operation.State e = operation.e();
                final Operation.State visible = Operation.State.VISIBLE;
                if (e == visible && from != visible) {
                    this.e = operation.f().isPostponed();
                    break;
                }
            }
        }
    }
    
    void r(final boolean d) {
        this.d = d;
    }
    
    static class Operation
    {
        private State a;
        private LifecycleImpact b;
        private final Fragment c;
        private final List<Runnable> d;
        private final HashSet<e> e;
        private boolean f;
        private boolean g;
        
        Operation(final State a, final LifecycleImpact b, final Fragment c, final e e) {
            this.d = new ArrayList<Runnable>();
            this.e = new HashSet<e>();
            this.f = false;
            this.g = false;
            this.a = a;
            this.b = b;
            this.c = c;
            e.b((e.b)new e.b(this) {
                final Operation a;
                
                @Override
                public void a() {
                    this.a.b();
                }
            });
        }
        
        final void a(final Runnable runnable) {
            this.d.add(runnable);
        }
        
        final void b() {
            if (this.h()) {
                return;
            }
            this.f = true;
            if (this.e.isEmpty()) {
                this.c();
            }
            else {
                final Iterator iterator = new ArrayList(this.e).iterator();
                while (iterator.hasNext()) {
                    ((e)iterator.next()).a();
                }
            }
        }
        
        public void c() {
            if (this.g) {
                return;
            }
            if (FragmentManager.N0(2)) {
                final StringBuilder sb = new StringBuilder();
                sb.append("SpecialEffectsController: ");
                sb.append(this);
                sb.append(" has called complete.");
                Log.v("FragmentManager", sb.toString());
            }
            this.g = true;
            final Iterator<Runnable> iterator = this.d.iterator();
            while (iterator.hasNext()) {
                iterator.next().run();
            }
        }
        
        public final void d(final e e) {
            if (this.e.remove(e) && this.e.isEmpty()) {
                this.c();
            }
        }
        
        public State e() {
            return this.a;
        }
        
        public final Fragment f() {
            return this.c;
        }
        
        LifecycleImpact g() {
            return this.b;
        }
        
        final boolean h() {
            return this.f;
        }
        
        final boolean i() {
            return this.g;
        }
        
        public final void j(final e e) {
            this.l();
            this.e.add(e);
        }
        
        final void k(final State a, final LifecycleImpact lifecycleImpact) {
            final int n = SpecialEffectsController$c.b[lifecycleImpact.ordinal()];
            if (n != 1) {
                if (n != 2) {
                    if (n == 3) {
                        if (this.a != State.REMOVED) {
                            if (FragmentManager.N0(2)) {
                                final StringBuilder sb = new StringBuilder();
                                sb.append("SpecialEffectsController: For fragment ");
                                sb.append(this.c);
                                sb.append(" mFinalState = ");
                                sb.append(this.a);
                                sb.append(" -> ");
                                sb.append(a);
                                sb.append(". ");
                                Log.v("FragmentManager", sb.toString());
                            }
                            this.a = a;
                        }
                    }
                }
                else {
                    if (FragmentManager.N0(2)) {
                        final StringBuilder sb2 = new StringBuilder();
                        sb2.append("SpecialEffectsController: For fragment ");
                        sb2.append(this.c);
                        sb2.append(" mFinalState = ");
                        sb2.append(this.a);
                        sb2.append(" -> REMOVED. mLifecycleImpact  = ");
                        sb2.append(this.b);
                        sb2.append(" to REMOVING.");
                        Log.v("FragmentManager", sb2.toString());
                    }
                    this.a = State.REMOVED;
                    this.b = LifecycleImpact.REMOVING;
                }
            }
            else if (this.a == State.REMOVED) {
                if (FragmentManager.N0(2)) {
                    final StringBuilder sb3 = new StringBuilder();
                    sb3.append("SpecialEffectsController: For fragment ");
                    sb3.append(this.c);
                    sb3.append(" mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = ");
                    sb3.append(this.b);
                    sb3.append(" to ADDING.");
                    Log.v("FragmentManager", sb3.toString());
                }
                this.a = State.VISIBLE;
                this.b = LifecycleImpact.ADDING;
            }
        }
        
        void l() {
        }
        
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append("Operation ");
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append("} ");
            sb.append("{");
            sb.append("mFinalState = ");
            sb.append(this.a);
            sb.append("} ");
            sb.append("{");
            sb.append("mLifecycleImpact = ");
            sb.append(this.b);
            sb.append("} ");
            sb.append("{");
            sb.append("mFragment = ");
            sb.append(this.c);
            sb.append("}");
            return sb.toString();
        }
        
        enum LifecycleImpact
        {
            private static final LifecycleImpact[] $VALUES;
            
            ADDING, 
            NONE, 
            REMOVING;
        }
        
        enum State
        {
            private static final State[] $VALUES;
            
            GONE, 
            INVISIBLE, 
            REMOVED, 
            VISIBLE;
            
            static State from(final int n) {
                if (n == 0) {
                    return State.VISIBLE;
                }
                if (n == 4) {
                    return State.INVISIBLE;
                }
                if (n == 8) {
                    return State.GONE;
                }
                final StringBuilder sb = new StringBuilder();
                sb.append("Unknown visibility ");
                sb.append(n);
                throw new IllegalArgumentException(sb.toString());
            }
            
            static State from(final View view) {
                if (view.getAlpha() == 0.0f && view.getVisibility() == 0) {
                    return State.INVISIBLE;
                }
                return from(view.getVisibility());
            }
            
            void applyState(final View view) {
                final int n = SpecialEffectsController$c.a[this.ordinal()];
                if (n != 1) {
                    if (n != 2) {
                        if (n != 3) {
                            if (n == 4) {
                                if (FragmentManager.N0(2)) {
                                    final StringBuilder sb = new StringBuilder();
                                    sb.append("SpecialEffectsController: Setting view ");
                                    sb.append(view);
                                    sb.append(" to INVISIBLE");
                                    Log.v("FragmentManager", sb.toString());
                                }
                                view.setVisibility(4);
                            }
                        }
                        else {
                            if (FragmentManager.N0(2)) {
                                final StringBuilder sb2 = new StringBuilder();
                                sb2.append("SpecialEffectsController: Setting view ");
                                sb2.append(view);
                                sb2.append(" to GONE");
                                Log.v("FragmentManager", sb2.toString());
                            }
                            view.setVisibility(8);
                        }
                    }
                    else {
                        if (FragmentManager.N0(2)) {
                            final StringBuilder sb3 = new StringBuilder();
                            sb3.append("SpecialEffectsController: Setting view ");
                            sb3.append(view);
                            sb3.append(" to VISIBLE");
                            Log.v("FragmentManager", sb3.toString());
                        }
                        view.setVisibility(0);
                    }
                }
                else {
                    final ViewGroup viewGroup = (ViewGroup)view.getParent();
                    if (viewGroup != null) {
                        if (FragmentManager.N0(2)) {
                            final StringBuilder sb4 = new StringBuilder();
                            sb4.append("SpecialEffectsController: Removing view ");
                            sb4.append(view);
                            sb4.append(" from container ");
                            sb4.append(viewGroup);
                            Log.v("FragmentManager", sb4.toString());
                        }
                        viewGroup.removeView(view);
                    }
                }
            }
        }
    }
    
    private static class d extends Operation
    {
        private final a0 h;
        
        d(final State state, final LifecycleImpact lifecycleImpact, final a0 h, final e e) {
            super(state, lifecycleImpact, h.k(), e);
            this.h = h;
        }
        
        @Override
        public void c() {
            super.c();
            this.h.m();
        }
        
        @Override
        void l() {
            if (((Operation)this).g() == LifecycleImpact.ADDING) {
                final Fragment k = this.h.k();
                final View focus = k.mView.findFocus();
                if (focus != null) {
                    k.setFocusedView(focus);
                    if (FragmentManager.N0(2)) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("requestFocus: Saved focused view ");
                        sb.append(focus);
                        sb.append(" for Fragment ");
                        sb.append(k);
                        Log.v("FragmentManager", sb.toString());
                    }
                }
                final View requireView = ((Operation)this).f().requireView();
                if (requireView.getParent() == null) {
                    this.h.b();
                    requireView.setAlpha(0.0f);
                }
                if (requireView.getAlpha() == 0.0f && requireView.getVisibility() == 0) {
                    requireView.setVisibility(4);
                }
                requireView.setAlpha(k.getPostOnViewCreatedAlpha());
            }
            else if (((Operation)this).g() == LifecycleImpact.REMOVING) {
                final Fragment i = this.h.k();
                final View requireView2 = i.requireView();
                if (FragmentManager.N0(2)) {
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("Clearing focus ");
                    sb2.append(requireView2.findFocus());
                    sb2.append(" on view ");
                    sb2.append(requireView2);
                    sb2.append(" for Fragment ");
                    sb2.append(i);
                    Log.v("FragmentManager", sb2.toString());
                }
                requireView2.clearFocus();
            }
        }
    }
}
