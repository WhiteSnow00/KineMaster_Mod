// 
// Decompiled by Procyon v0.6.0
// 

package androidx.fragment.app;

import androidx.core.view.e0;
import androidx.core.view.b0;
import androidx.core.view.y;
import java.util.Collection;
import androidx.collection.a;
import android.graphics.Rect;
import java.util.HashMap;
import java.util.Iterator;
import android.content.Context;
import android.view.animation.Animation$AnimationListener;
import androidx.core.util.h;
import android.view.animation.Animation;
import androidx.core.os.e;
import android.animation.Animator$AnimatorListener;
import android.animation.Animator;
import android.view.View;
import android.animation.AnimatorListenerAdapter;
import android.util.Log;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import android.view.ViewGroup;

class b extends SpecialEffectsController
{
    b(final ViewGroup viewGroup) {
        super(viewGroup);
    }
    
    private void w(final List<k> list, final List<Operation> list2, final boolean b, final Map<Operation, Boolean> map) {
        final ViewGroup m = this.m();
        final Context context = m.getContext();
        final ArrayList list3 = new ArrayList();
        final Iterator<k> iterator = list.iterator();
        boolean b2 = false;
        int n;
        while (true) {
            final boolean hasNext = iterator.hasNext();
            n = 2;
            if (!hasNext) {
                break;
            }
            final k k = iterator.next();
            if (((l)k).d()) {
                ((l)k).a();
            }
            else {
                final i.a e = k.e(context);
                if (e == null) {
                    ((l)k).a();
                }
                else {
                    final Animator b3 = e.b;
                    if (b3 == null) {
                        list3.add(k);
                    }
                    else {
                        final Operation b4 = ((l)k).b();
                        final Fragment f = b4.f();
                        if (Boolean.TRUE.equals(map.get(b4))) {
                            if (FragmentManager.N0(2)) {
                                final StringBuilder sb = new StringBuilder();
                                sb.append("Ignoring Animator set on ");
                                sb.append(f);
                                sb.append(" as this Fragment was involved in a Transition.");
                                Log.v("FragmentManager", sb.toString());
                            }
                            ((l)k).a();
                        }
                        else {
                            final boolean b5 = b4.e() == Operation.State.GONE;
                            if (b5) {
                                list2.remove(b4);
                            }
                            final View mView = f.mView;
                            m.startViewTransition(mView);
                            b3.addListener((Animator$AnimatorListener)new AnimatorListenerAdapter(this, m, mView, b5, b4, k) {
                                final ViewGroup a;
                                final View b;
                                final boolean c;
                                final Operation d;
                                final k e;
                                final b f;
                                
                                public void onAnimationEnd(final Animator animator) {
                                    this.a.endViewTransition(this.b);
                                    if (this.c) {
                                        this.d.e().applyState(this.b);
                                    }
                                    ((l)this.e).a();
                                    if (FragmentManager.N0(2)) {
                                        final StringBuilder sb = new StringBuilder();
                                        sb.append("Animator from operation ");
                                        sb.append(this.d);
                                        sb.append(" has ended.");
                                        Log.v("FragmentManager", sb.toString());
                                    }
                                }
                            });
                            b3.setTarget((Object)mView);
                            b3.start();
                            if (FragmentManager.N0(2)) {
                                final StringBuilder sb2 = new StringBuilder();
                                sb2.append("Animator from operation ");
                                sb2.append(b4);
                                sb2.append(" has started.");
                                Log.v("FragmentManager", sb2.toString());
                            }
                            ((l)k).c().b((e.b)new e.b(this, b3, b4) {
                                final Animator a;
                                final Operation b;
                                final b c;
                                
                                @Override
                                public void a() {
                                    this.a.end();
                                    if (FragmentManager.N0(2)) {
                                        final StringBuilder sb = new StringBuilder();
                                        sb.append("Animator from operation ");
                                        sb.append(this.b);
                                        sb.append(" has been canceled.");
                                        Log.v("FragmentManager", sb.toString());
                                    }
                                }
                            });
                            b2 = true;
                        }
                    }
                }
            }
        }
        final Iterator iterator2 = list3.iterator();
        final boolean b6 = b2;
        while (iterator2.hasNext()) {
            final k i = (k)iterator2.next();
            final Operation b7 = ((l)i).b();
            final Fragment f2 = b7.f();
            if (b) {
                if (FragmentManager.N0(n)) {
                    final StringBuilder sb3 = new StringBuilder();
                    sb3.append("Ignoring Animation set on ");
                    sb3.append(f2);
                    sb3.append(" as Animations cannot run alongside Transitions.");
                    Log.v("FragmentManager", sb3.toString());
                }
                ((l)i).a();
            }
            else if (b6) {
                if (FragmentManager.N0(n)) {
                    final StringBuilder sb4 = new StringBuilder();
                    sb4.append("Ignoring Animation set on ");
                    sb4.append(f2);
                    sb4.append(" as Animations cannot run alongside Animators.");
                    Log.v("FragmentManager", sb4.toString());
                }
                ((l)i).a();
            }
            else {
                final View mView2 = f2.mView;
                final Animation animation = h.g(h.g(i.e(context)).a);
                int n2;
                if (b7.e() != Operation.State.REMOVED) {
                    mView2.startAnimation(animation);
                    ((l)i).a();
                    n2 = n;
                }
                else {
                    m.startViewTransition(mView2);
                    final i.b b8 = new i.b(animation, m, mView2);
                    ((Animation)b8).setAnimationListener((Animation$AnimationListener)new Animation$AnimationListener(this, b7, m, mView2, i) {
                        final Operation a;
                        final ViewGroup b;
                        final View c;
                        final k d;
                        final b e;
                        
                        public void onAnimationEnd(final Animation animation) {
                            this.b.post((Runnable)new Runnable(this) {
                                final b$e a;
                                
                                @Override
                                public void run() {
                                    final Animation$AnimationListener a = (Animation$AnimationListener)this.a;
                                    a.b.endViewTransition(a.c);
                                    ((l)this.a.d).a();
                                }
                            });
                            if (FragmentManager.N0(2)) {
                                final StringBuilder sb = new StringBuilder();
                                sb.append("Animation from operation ");
                                sb.append(this.a);
                                sb.append(" has ended.");
                                Log.v("FragmentManager", sb.toString());
                            }
                        }
                        
                        public void onAnimationRepeat(final Animation animation) {
                        }
                        
                        public void onAnimationStart(final Animation animation) {
                            if (FragmentManager.N0(2)) {
                                final StringBuilder sb = new StringBuilder();
                                sb.append("Animation from operation ");
                                sb.append(this.a);
                                sb.append(" has reached onAnimationStart.");
                                Log.v("FragmentManager", sb.toString());
                            }
                        }
                    });
                    mView2.startAnimation((Animation)b8);
                    n2 = 2;
                    if (FragmentManager.N0(2)) {
                        final StringBuilder sb5 = new StringBuilder();
                        sb5.append("Animation from operation ");
                        sb5.append(b7);
                        sb5.append(" has started.");
                        Log.v("FragmentManager", sb5.toString());
                        n2 = n2;
                    }
                }
                ((l)i).c().b((e.b)new e.b(this, mView2, m, i, b7) {
                    final View a;
                    final ViewGroup b;
                    final k c;
                    final Operation d;
                    final b e;
                    
                    @Override
                    public void a() {
                        this.a.clearAnimation();
                        this.b.endViewTransition(this.a);
                        ((l)this.c).a();
                        if (FragmentManager.N0(2)) {
                            final StringBuilder sb = new StringBuilder();
                            sb.append("Animation from operation ");
                            sb.append(this.d);
                            sb.append(" has been cancelled.");
                            Log.v("FragmentManager", sb.toString());
                        }
                    }
                });
                n = n2;
            }
        }
    }
    
    private Map<Operation, Boolean> x(final List<m> list, final List<Operation> list2, final boolean b, Operation b2, final Operation operation) {
        Operation operation2 = b2;
        Operation operation3 = operation;
        HashMap hashMap = new HashMap();
        final Iterator<m> iterator = list.iterator();
        f0 f0 = null;
        while (iterator.hasNext()) {
            final m m = iterator.next();
            if (((l)m).d()) {
                continue;
            }
            final f0 e = m.e();
            if (f0 == null) {
                f0 = e;
            }
            else {
                if (e == null) {
                    continue;
                }
                if (f0 == e) {
                    continue;
                }
                final StringBuilder sb = new StringBuilder();
                sb.append("Mixing framework transitions and AndroidX transitions is not allowed. Fragment ");
                sb.append(((l)m).b().f());
                sb.append(" returned Transition ");
                sb.append(m.h());
                sb.append(" which uses a different Transition  type than other Fragments.");
                throw new IllegalArgumentException(sb.toString());
            }
        }
        if (f0 == null) {
            for (final m i : list) {
                hashMap.put(((l)i).b(), Boolean.FALSE);
                ((l)i).a();
            }
            return hashMap;
        }
        final View view = new View(this.m().getContext());
        final Rect rect = new Rect();
        final ArrayList list3 = new ArrayList();
        final ArrayList list4 = new ArrayList();
        final a a = new a();
        final Iterator<m> iterator3 = list.iterator();
        Object o = null;
        View view2 = null;
        boolean b3 = false;
        final f0 f2 = f0;
        final View view3 = view;
        String s;
        while (true) {
            final boolean hasNext = iterator3.hasNext();
            s = "FragmentManager";
            if (!hasNext) {
                break;
            }
            final m j = iterator3.next();
            Object u;
            Operation operation4;
            Operation operation5;
            if (j.i() && operation2 != null && operation3 != null) {
                u = f2.u(f2.f(j.g()));
                final ArrayList<String> sharedElementSourceNames = operation.f().getSharedElementSourceNames();
                final ArrayList<String> sharedElementSourceNames2 = b2.f().getSharedElementSourceNames();
                final ArrayList<String> sharedElementTargetNames = b2.f().getSharedElementTargetNames();
                for (int k = 0; k < sharedElementTargetNames.size(); ++k) {
                    final int index = sharedElementSourceNames.indexOf(sharedElementTargetNames.get(k));
                    if (index != -1) {
                        sharedElementSourceNames.set(index, sharedElementSourceNames2.get(k));
                    }
                }
                final ArrayList<String> sharedElementTargetNames2 = operation.f().getSharedElementTargetNames();
                if (!b) {
                    b2.f().getExitTransitionCallback();
                    operation.f().getEnterTransitionCallback();
                }
                else {
                    b2.f().getEnterTransitionCallback();
                    operation.f().getExitTransitionCallback();
                }
                for (int size = sharedElementSourceNames.size(), l = 0; l < size; ++l) {
                    a.put(sharedElementSourceNames.get(l), sharedElementTargetNames2.get(l));
                }
                if (FragmentManager.N0(2)) {
                    Log.v("FragmentManager", ">>> entering view names <<<");
                    for (final String s2 : sharedElementTargetNames2) {
                        final StringBuilder sb2 = new StringBuilder();
                        sb2.append("Name: ");
                        sb2.append(s2);
                        Log.v("FragmentManager", sb2.toString());
                    }
                    Log.v("FragmentManager", ">>> exiting view names <<<");
                    for (final String s3 : sharedElementSourceNames) {
                        final StringBuilder sb3 = new StringBuilder();
                        sb3.append("Name: ");
                        sb3.append(s3);
                        Log.v("FragmentManager", sb3.toString());
                    }
                }
                final a<Object, View> a2 = new a<Object, View>();
                this.u((Map<String, View>)a2, b2.f().mView);
                a2.o(sharedElementSourceNames);
                a.o(a2.keySet());
                final a a3 = new a();
                this.u(a3, operation.f().mView);
                a3.o(sharedElementTargetNames2);
                a3.o(a.values());
                d0.c(a, a3);
                this.v((a<String, View>)a2, a.keySet());
                this.v(a3, a.values());
                if (a.isEmpty()) {
                    list3.clear();
                    list4.clear();
                    u = null;
                    operation4 = operation2;
                    operation5 = operation;
                }
                else {
                    d0.a(operation.f(), b2.f(), b, (a<String, View>)a2, true);
                    y.a((View)this.m(), new Runnable(this, operation, b2, b, a3) {
                        final Operation a;
                        final Operation b;
                        final boolean c;
                        final a d;
                        final b e;
                        
                        @Override
                        public void run() {
                            d0.a(this.a.f(), this.b.f(), this.c, this.d, false);
                        }
                    });
                    list3.addAll(a2.values());
                    if (!sharedElementSourceNames.isEmpty()) {
                        view2 = (View)a2.get(sharedElementSourceNames.get(0));
                        f2.p(u, view2);
                    }
                    list4.addAll(a3.values());
                    if (!sharedElementTargetNames2.isEmpty()) {
                        final View view4 = (View)a3.get(sharedElementTargetNames2.get(0));
                        if (view4 != null) {
                            y.a((View)this.m(), new Runnable(this, f2, view4, rect) {
                                final f0 a;
                                final View b;
                                final Rect c;
                                final b d;
                                
                                @Override
                                public void run() {
                                    this.a.h(this.b, this.c);
                                }
                            });
                            b3 = true;
                        }
                    }
                    f2.s(u, view3, list3);
                    f2.n(u, null, null, null, null, u, list4);
                    final Boolean true = Boolean.TRUE;
                    operation4 = b2;
                    hashMap.put(operation4, true);
                    operation5 = operation;
                    hashMap.put(operation5, true);
                }
            }
            else {
                final Operation operation6 = operation2;
                operation5 = operation3;
                operation4 = operation6;
                u = o;
            }
            final HashMap hashMap2 = hashMap;
            final Operation operation7 = operation5;
            o = u;
            operation2 = operation4;
            operation3 = operation7;
            hashMap = hashMap2;
        }
        final ArrayList list5 = list4;
        final View view5 = view3;
        final ArrayList list6 = new ArrayList();
        final Iterator<m> iterator6 = list.iterator();
        final Object o2 = null;
        final Object o3 = null;
        final View view6 = view2;
        final HashMap hashMap3 = hashMap;
        Operation operation8 = operation3;
        Object k2 = o3;
        Object k3 = o2;
        final String s4 = s;
        final ArrayList list7 = list5;
        while (iterator6.hasNext()) {
            final m m2 = iterator6.next();
            Operation operation9;
            if (((l)m2).d()) {
                hashMap3.put(((l)m2).b(), Boolean.FALSE);
                ((l)m2).a();
                operation9 = operation8;
            }
            else {
                final Object f3 = f2.f(m2.h());
                final Operation b4 = ((l)m2).b();
                final boolean b5 = o != null && (b4 == operation2 || b4 == operation8);
                if (f3 == null) {
                    if (!b5) {
                        hashMap3.put(b4, Boolean.FALSE);
                        ((l)m2).a();
                    }
                }
                else {
                    final ArrayList list8 = new ArrayList();
                    this.t(list8, b4.f().mView);
                    if (b5) {
                        if (b4 == operation2) {
                            list8.removeAll(list3);
                        }
                        else {
                            list8.removeAll(list7);
                        }
                    }
                    if (list8.isEmpty()) {
                        f2.a(f3, view5);
                    }
                    else {
                        f2.b(f3, list8);
                        f2.n(f3, f3, list8, null, null, null, null);
                        if (b4.e() == Operation.State.GONE) {
                            list2.remove(b4);
                            final ArrayList list9 = new ArrayList(list8);
                            list9.remove(b4.f().mView);
                            f2.m(f3, b4.f().mView, (ArrayList<View>)list9);
                            y.a((View)this.m(), new Runnable(this, list8) {
                                final ArrayList a;
                                final b b;
                                
                                @Override
                                public void run() {
                                    d0.d(this.a, 4);
                                }
                            });
                        }
                    }
                    if (b4.e() == Operation.State.VISIBLE) {
                        list6.addAll(list8);
                        if (b3) {
                            f2.o(f3, rect);
                        }
                    }
                    else {
                        f2.p(f3, view6);
                    }
                    hashMap3.put(b4, Boolean.TRUE);
                    if (m2.j()) {
                        k2 = f2.k(k2, f3, null);
                    }
                    else {
                        k3 = f2.k(k3, f3, null);
                    }
                }
                operation9 = operation;
            }
            operation8 = operation9;
        }
        final HashMap hashMap4 = hashMap3;
        final Object j2 = f2.j(k2, k3, o);
        if (j2 == null) {
            return hashMap4;
        }
        final Iterator<m> iterator7 = list.iterator();
        final String s5 = s4;
        while (iterator7.hasNext()) {
            final m m3 = iterator7.next();
            if (((l)m3).d()) {
                continue;
            }
            final Object h = m3.h();
            b2 = ((l)m3).b();
            final boolean b6 = o != null && (b2 == operation2 || b2 == operation);
            if (h == null && !b6) {
                continue;
            }
            if (!b0.T((View)this.m())) {
                if (FragmentManager.N0(2)) {
                    final StringBuilder sb4 = new StringBuilder();
                    sb4.append("SpecialEffectsController: Container ");
                    sb4.append(this.m());
                    sb4.append(" has not been laid out. Completing operation ");
                    sb4.append(b2);
                    Log.v(s5, sb4.toString());
                }
                ((l)m3).a();
            }
            else {
                f2.q(((l)m3).b().f(), j2, ((l)m3).c(), new Runnable(this, m3, b2) {
                    final m a;
                    final Operation b;
                    final b c;
                    
                    @Override
                    public void run() {
                        ((l)this.a).a();
                        if (FragmentManager.N0(2)) {
                            final StringBuilder sb = new StringBuilder();
                            sb.append("Transition for operation ");
                            sb.append(this.b);
                            sb.append("has completed");
                            Log.v("FragmentManager", sb.toString());
                        }
                    }
                });
            }
        }
        if (!b0.T((View)this.m())) {
            return hashMap4;
        }
        d0.d(list6, 4);
        final ArrayList<String> l2 = f2.l(list7);
        if (FragmentManager.N0(2)) {
            Log.v(s5, ">>>>> Beginning transition <<<<<");
            Log.v(s5, ">>>>> SharedElementFirstOutViews <<<<<");
            for (final View view7 : list3) {
                final StringBuilder sb5 = new StringBuilder();
                sb5.append("View: ");
                sb5.append(view7);
                sb5.append(" Name: ");
                sb5.append(b0.J(view7));
                Log.v(s5, sb5.toString());
            }
            Log.v(s5, ">>>>> SharedElementLastInViews <<<<<");
            for (final View view8 : list7) {
                final StringBuilder sb6 = new StringBuilder();
                sb6.append("View: ");
                sb6.append(view8);
                sb6.append(" Name: ");
                sb6.append(b0.J(view8));
                Log.v(s5, sb6.toString());
            }
        }
        f2.c(this.m(), j2);
        f2.r((View)this.m(), list3, list7, l2, a);
        d0.d(list6, 0);
        f2.t(o, list3, list7);
        return hashMap4;
    }
    
    private void y(final List<Operation> list) {
        final Fragment f = list.get(list.size() - 1).f();
        for (final Operation operation : list) {
            operation.f().mAnimationInfo.c = f.mAnimationInfo.c;
            operation.f().mAnimationInfo.d = f.mAnimationInfo.d;
            operation.f().mAnimationInfo.e = f.mAnimationInfo.e;
            operation.f().mAnimationInfo.f = f.mAnimationInfo.f;
        }
    }
    
    @Override
    void f(final List<Operation> list, final boolean b) {
        final Iterator<Operation> iterator = list.iterator();
        Operation operation = null;
        Operation operation2 = null;
        while (iterator.hasNext()) {
            final Operation operation3 = iterator.next();
            final Operation.State from = Operation.State.from(operation3.f().mView);
            final int n = b$a.a[operation3.e().ordinal()];
            if (n != 1 && n != 2 && n != 3) {
                if (n != 4) {
                    continue;
                }
                if (from == Operation.State.VISIBLE) {
                    continue;
                }
                operation2 = operation3;
            }
            else {
                if (from != Operation.State.VISIBLE || operation != null) {
                    continue;
                }
                operation = operation3;
            }
        }
        if (FragmentManager.N0(2)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Executing operations from ");
            sb.append(operation);
            sb.append(" to ");
            sb.append(operation2);
            Log.v("FragmentManager", sb.toString());
        }
        final ArrayList<k> list2 = new ArrayList<k>();
        final ArrayList<m> list3 = new ArrayList<m>();
        final ArrayList<Operation> list4 = new ArrayList<Operation>(list);
        this.y(list);
        for (final Operation operation4 : list) {
            final e e = new e();
            operation4.j(e);
            list2.add(new k(operation4, e, b));
            final e e2 = new e();
            operation4.j(e2);
            boolean b2 = false;
            Label_0317: {
                if (b) {
                    if (operation4 != operation) {
                        break Label_0317;
                    }
                }
                else if (operation4 != operation2) {
                    break Label_0317;
                }
                b2 = true;
            }
            list3.add(new m(operation4, e2, b, b2));
            operation4.a(new Runnable(this, list4, operation4) {
                final List a;
                final Operation b;
                final b c;
                
                @Override
                public void run() {
                    if (this.a.contains(this.b)) {
                        this.a.remove(this.b);
                        this.c.s(this.b);
                    }
                }
            });
        }
        final Map<Operation, Boolean> x = this.x(list3, list4, b, operation, operation2);
        this.w(list2, list4, x.containsValue(Boolean.TRUE), x);
        final Iterator<Object> iterator3 = list4.iterator();
        while (iterator3.hasNext()) {
            this.s(iterator3.next());
        }
        list4.clear();
        if (FragmentManager.N0(2)) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Completed executing operations from ");
            sb2.append(operation);
            sb2.append(" to ");
            sb2.append(operation2);
            Log.v("FragmentManager", sb2.toString());
        }
    }
    
    void s(final Operation operation) {
        operation.e().applyState(operation.f().mView);
    }
    
    void t(final ArrayList<View> list, View child) {
        if (child instanceof ViewGroup) {
            final ViewGroup viewGroup = (ViewGroup)child;
            if (e0.a(viewGroup)) {
                if (!list.contains(child)) {
                    list.add((View)viewGroup);
                }
            }
            else {
                for (int childCount = viewGroup.getChildCount(), i = 0; i < childCount; ++i) {
                    child = viewGroup.getChildAt(i);
                    if (child.getVisibility() == 0) {
                        this.t(list, child);
                    }
                }
            }
        }
        else if (!list.contains(child)) {
            list.add(child);
        }
    }
    
    void u(final Map<String, View> map, final View view) {
        final String j = b0.J(view);
        if (j != null) {
            map.put(j, view);
        }
        if (view instanceof ViewGroup) {
            final ViewGroup viewGroup = (ViewGroup)view;
            for (int childCount = viewGroup.getChildCount(), i = 0; i < childCount; ++i) {
                final View child = viewGroup.getChildAt(i);
                if (child.getVisibility() == 0) {
                    this.u(map, child);
                }
            }
        }
    }
    
    void v(final a<String, View> a, final Collection<String> collection) {
        final Iterator<Map.Entry<String, View>> iterator = a.entrySet().iterator();
        while (iterator.hasNext()) {
            if (!collection.contains(b0.J(((Map.Entry<K, View>)iterator.next()).getValue()))) {
                iterator.remove();
            }
        }
    }
    
    private static class k extends l
    {
        private boolean c;
        private boolean d;
        private i.a e;
        
        k(final Operation operation, final e e, final boolean c) {
            super(operation, e);
            this.d = false;
            this.c = c;
        }
        
        i.a e(final Context context) {
            if (this.d) {
                return this.e;
            }
            final i.a b = i.b(context, ((l)this).b().f(), ((l)this).b().e() == Operation.State.VISIBLE, this.c);
            this.e = b;
            this.d = true;
            return b;
        }
    }
    
    private static class l
    {
        private final Operation a;
        private final e b;
        
        l(final Operation a, final e b) {
            this.a = a;
            this.b = b;
        }
        
        void a() {
            this.a.d(this.b);
        }
        
        Operation b() {
            return this.a;
        }
        
        e c() {
            return this.b;
        }
        
        boolean d() {
            final Operation.State from = Operation.State.from(this.a.f().mView);
            final Operation.State e = this.a.e();
            if (from != e) {
                final Operation.State visible = Operation.State.VISIBLE;
                if (from == visible || e == visible) {
                    return false;
                }
            }
            return true;
        }
    }
    
    private static class m extends l
    {
        private final Object c;
        private final boolean d;
        private final Object e;
        
        m(final Operation operation, final e e, final boolean b, final boolean b2) {
            super(operation, e);
            if (operation.e() == Operation.State.VISIBLE) {
                Object c;
                if (b) {
                    c = operation.f().getReenterTransition();
                }
                else {
                    c = operation.f().getEnterTransition();
                }
                this.c = c;
                boolean d;
                if (b) {
                    d = operation.f().getAllowReturnTransitionOverlap();
                }
                else {
                    d = operation.f().getAllowEnterTransitionOverlap();
                }
                this.d = d;
            }
            else {
                Object c2;
                if (b) {
                    c2 = operation.f().getReturnTransition();
                }
                else {
                    c2 = operation.f().getExitTransition();
                }
                this.c = c2;
                this.d = true;
            }
            if (b2) {
                if (b) {
                    this.e = operation.f().getSharedElementReturnTransition();
                }
                else {
                    this.e = operation.f().getSharedElementEnterTransition();
                }
            }
            else {
                this.e = null;
            }
        }
        
        private f0 f(final Object o) {
            if (o == null) {
                return null;
            }
            final f0 a = d0.a;
            if (a != null && a.e(o)) {
                return a;
            }
            final f0 b = d0.b;
            if (b != null && b.e(o)) {
                return b;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("Transition ");
            sb.append(o);
            sb.append(" for fragment ");
            sb.append(((l)this).b().f());
            sb.append(" is not a valid framework Transition or AndroidX Transition");
            throw new IllegalArgumentException(sb.toString());
        }
        
        f0 e() {
            f0 f = this.f(this.c);
            final f0 f2 = this.f(this.e);
            if (f != null && f2 != null && f != f2) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Mixing framework transitions and AndroidX transitions is not allowed. Fragment ");
                sb.append(((l)this).b().f());
                sb.append(" returned Transition ");
                sb.append(this.c);
                sb.append(" which uses a different Transition  type than its shared element transition ");
                sb.append(this.e);
                throw new IllegalArgumentException(sb.toString());
            }
            if (f == null) {
                f = f2;
            }
            return f;
        }
        
        public Object g() {
            return this.e;
        }
        
        Object h() {
            return this.c;
        }
        
        public boolean i() {
            return this.e != null;
        }
        
        boolean j() {
            return this.d;
        }
    }
}
