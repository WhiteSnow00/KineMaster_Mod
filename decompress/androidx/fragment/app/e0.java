// 
// Decompiled by Procyon v0.6.0
// 

package androidx.fragment.app;

import java.util.Collection;
import java.util.List;
import androidx.core.os.e;
import android.transition.Transition$EpicenterCallback;
import android.graphics.Rect;
import android.transition.Transition$TransitionListener;
import android.transition.TransitionManager;
import android.view.ViewGroup;
import android.transition.TransitionSet;
import java.util.ArrayList;
import android.view.View;
import android.transition.Transition;

class e0 extends f0
{
    private static boolean v(final Transition transition) {
        return !f0.i(transition.getTargetIds()) || !f0.i(transition.getTargetNames()) || !f0.i(transition.getTargetTypes());
    }
    
    @Override
    public void a(final Object o, final View view) {
        if (o != null) {
            ((Transition)o).addTarget(view);
        }
    }
    
    @Override
    public void b(final Object o, final ArrayList<View> list) {
        final Transition transition = (Transition)o;
        if (transition == null) {
            return;
        }
        final boolean b = transition instanceof TransitionSet;
        final int n = 0;
        int i = 0;
        if (b) {
            for (TransitionSet set = (TransitionSet)transition; i < set.getTransitionCount(); ++i) {
                this.b(set.getTransitionAt(i), list);
            }
        }
        else if (!v(transition) && f0.i(transition.getTargets())) {
            for (int size = list.size(), j = n; j < size; ++j) {
                transition.addTarget((View)list.get(j));
            }
        }
    }
    
    @Override
    public void c(final ViewGroup viewGroup, final Object o) {
        TransitionManager.beginDelayedTransition(viewGroup, (Transition)o);
    }
    
    @Override
    public boolean e(final Object o) {
        return o instanceof Transition;
    }
    
    @Override
    public Object f(final Object o) {
        Transition clone;
        if (o != null) {
            clone = ((Transition)o).clone();
        }
        else {
            clone = null;
        }
        return clone;
    }
    
    @Override
    public Object j(final Object o, Object o2, final Object o3) {
        Object setOrdering = o;
        final Transition transition = (Transition)o2;
        final Transition transition2 = (Transition)o3;
        if (setOrdering != null && transition != null) {
            setOrdering = new TransitionSet().addTransition((Transition)setOrdering).addTransition(transition).setOrdering(1);
        }
        else if (setOrdering == null) {
            if (transition != null) {
                setOrdering = transition;
            }
            else {
                setOrdering = null;
            }
        }
        if (transition2 != null) {
            o2 = new TransitionSet();
            if (setOrdering != null) {
                ((TransitionSet)o2).addTransition((Transition)setOrdering);
            }
            ((TransitionSet)o2).addTransition(transition2);
            return o2;
        }
        return setOrdering;
    }
    
    @Override
    public Object k(final Object o, final Object o2, final Object o3) {
        final TransitionSet set = new TransitionSet();
        if (o != null) {
            set.addTransition((Transition)o);
        }
        if (o2 != null) {
            set.addTransition((Transition)o2);
        }
        if (o3 != null) {
            set.addTransition((Transition)o3);
        }
        return set;
    }
    
    @Override
    public void m(final Object o, final View view, final ArrayList<View> list) {
        ((Transition)o).addListener((Transition$TransitionListener)new Transition$TransitionListener(this, view, list) {
            final View a;
            final ArrayList b;
            final e0 c;
            
            public void onTransitionCancel(final Transition transition) {
            }
            
            public void onTransitionEnd(final Transition transition) {
                f.b(transition, (Transition$TransitionListener)this);
                this.a.setVisibility(8);
                for (int size = this.b.size(), i = 0; i < size; ++i) {
                    ((View)this.b.get(i)).setVisibility(0);
                }
            }
            
            public void onTransitionPause(final Transition transition) {
            }
            
            public void onTransitionResume(final Transition transition) {
            }
            
            public void onTransitionStart(final Transition transition) {
                f.b(transition, (Transition$TransitionListener)this);
                f.a(transition, (Transition$TransitionListener)this);
            }
        });
    }
    
    @Override
    public void n(final Object o, final Object o2, final ArrayList<View> list, final Object o3, final ArrayList<View> list2, final Object o4, final ArrayList<View> list3) {
        ((Transition)o).addListener((Transition$TransitionListener)new Transition$TransitionListener(this, o2, list, o3, list2, o4, list3) {
            final Object a;
            final ArrayList b;
            final Object c;
            final ArrayList d;
            final Object e;
            final ArrayList f;
            final e0 g;
            
            public void onTransitionCancel(final Transition transition) {
            }
            
            public void onTransitionEnd(final Transition transition) {
                e0.f.b(transition, (Transition$TransitionListener)this);
            }
            
            public void onTransitionPause(final Transition transition) {
            }
            
            public void onTransitionResume(final Transition transition) {
            }
            
            public void onTransitionStart(final Transition transition) {
                final Object a = this.a;
                if (a != null) {
                    this.g.w(a, this.b, null);
                }
                final Object c = this.c;
                if (c != null) {
                    this.g.w(c, this.d, null);
                }
                final Object e = this.e;
                if (e != null) {
                    this.g.w(e, this.f, null);
                }
            }
        });
    }
    
    @Override
    public void o(final Object o, final Rect rect) {
        if (o != null) {
            ((Transition)o).setEpicenterCallback((Transition$EpicenterCallback)new Transition$EpicenterCallback(this, rect) {
                final Rect a;
                final e0 b;
                
                public Rect onGetEpicenter(final Transition transition) {
                    final Rect a = this.a;
                    if (a != null && !a.isEmpty()) {
                        return this.a;
                    }
                    return null;
                }
            });
        }
    }
    
    @Override
    public void p(final Object o, final View view) {
        if (view != null) {
            final Transition transition = (Transition)o;
            final Rect rect = new Rect();
            this.h(view, rect);
            transition.setEpicenterCallback((Transition$EpicenterCallback)new Transition$EpicenterCallback(this, rect) {
                final Rect a;
                final e0 b;
                
                public Rect onGetEpicenter(final Transition transition) {
                    return this.a;
                }
            });
        }
    }
    
    @Override
    public void q(final Fragment fragment, final Object o, final e e, final Runnable runnable) {
        ((Transition)o).addListener((Transition$TransitionListener)new Transition$TransitionListener(this, runnable) {
            final Runnable a;
            final e0 b;
            
            public void onTransitionCancel(final Transition transition) {
            }
            
            public void onTransitionEnd(final Transition transition) {
                this.a.run();
            }
            
            public void onTransitionPause(final Transition transition) {
            }
            
            public void onTransitionResume(final Transition transition) {
            }
            
            public void onTransitionStart(final Transition transition) {
            }
        });
    }
    
    @Override
    public void s(final Object o, final View view, final ArrayList<View> list) {
        final TransitionSet set = (TransitionSet)o;
        final List targets = set.getTargets();
        targets.clear();
        for (int size = list.size(), i = 0; i < size; ++i) {
            f0.d(targets, (View)list.get(i));
        }
        targets.add(view);
        list.add(view);
        this.b(set, list);
    }
    
    @Override
    public void t(final Object o, final ArrayList<View> list, final ArrayList<View> list2) {
        final TransitionSet set = (TransitionSet)o;
        if (set != null) {
            set.getTargets().clear();
            set.getTargets().addAll(list2);
            this.w(set, list, list2);
        }
    }
    
    @Override
    public Object u(final Object o) {
        if (o == null) {
            return null;
        }
        final TransitionSet set = new TransitionSet();
        set.addTransition((Transition)o);
        return set;
    }
    
    public void w(final Object o, final ArrayList<View> list, final ArrayList<View> list2) {
        final Transition transition = (Transition)o;
        final boolean b = transition instanceof TransitionSet;
        int i = 0;
        int j = 0;
        if (b) {
            for (TransitionSet set = (TransitionSet)transition; j < set.getTransitionCount(); ++j) {
                this.w(set.getTransitionAt(j), list, list2);
            }
        }
        else if (!v(transition)) {
            final List targets = transition.getTargets();
            if (targets != null && targets.size() == list.size() && targets.containsAll(list)) {
                int size;
                if (list2 == null) {
                    size = 0;
                }
                else {
                    size = list2.size();
                }
                while (i < size) {
                    transition.addTarget((View)list2.get(i));
                    ++i;
                }
                for (int k = list.size() - 1; k >= 0; --k) {
                    transition.removeTarget((View)list.get(k));
                }
            }
        }
    }
    
    static class f
    {
        static void a(final Transition transition, final Transition$TransitionListener transition$TransitionListener) {
            transition.addListener(transition$TransitionListener);
        }
        
        static void b(final Transition transition, final Transition$TransitionListener transition$TransitionListener) {
            transition.removeListener(transition$TransitionListener);
        }
    }
}
