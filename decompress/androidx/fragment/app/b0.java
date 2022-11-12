// 
// Decompiled by Procyon v0.6.0
// 

package androidx.fragment.app;

import android.util.Log;
import java.util.List;
import android.view.View;
import android.view.ViewGroup;
import java.io.PrintWriter;
import java.io.FileDescriptor;
import java.util.Iterator;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.ArrayList;

class b0
{
    private final ArrayList<Fragment> a;
    private final HashMap<String, a0> b;
    private final HashMap<String, FragmentState> c;
    private x d;
    
    b0() {
        this.a = new ArrayList<Fragment>();
        this.b = new HashMap<String, a0>();
        this.c = new HashMap<String, FragmentState>();
    }
    
    void A(final x d) {
        this.d = d;
    }
    
    FragmentState B(final String s, final FragmentState fragmentState) {
        if (fragmentState != null) {
            return this.c.put(s, fragmentState);
        }
        return this.c.remove(s);
    }
    
    void a(final Fragment fragment) {
        if (!this.a.contains(fragment)) {
            synchronized (this.a) {
                this.a.add(fragment);
                monitorexit(this.a);
                fragment.mAdded = true;
                return;
            }
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Fragment already added: ");
        sb.append(fragment);
        throw new IllegalStateException(sb.toString());
    }
    
    void b() {
        this.b.values().removeAll(Collections.singleton((Object)null));
    }
    
    boolean c(final String s) {
        return this.b.get(s) != null;
    }
    
    void d(final int n) {
        for (final a0 a0 : this.b.values()) {
            if (a0 != null) {
                a0.u(n);
            }
        }
    }
    
    void e(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
        final StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.append("    ");
        final String string = sb.toString();
        if (!this.b.isEmpty()) {
            printWriter.print(s);
            printWriter.println("Active Fragments:");
            for (final a0 a0 : this.b.values()) {
                printWriter.print(s);
                if (a0 != null) {
                    final Fragment k = a0.k();
                    printWriter.println(k);
                    k.dump(string, fileDescriptor, printWriter, array);
                }
                else {
                    printWriter.println("null");
                }
            }
        }
        final int size = this.a.size();
        if (size > 0) {
            printWriter.print(s);
            printWriter.println("Added Fragments:");
            for (int i = 0; i < size; ++i) {
                final Fragment fragment = this.a.get(i);
                printWriter.print(s);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
    }
    
    Fragment f(final String s) {
        final a0 a0 = this.b.get(s);
        if (a0 != null) {
            return a0.k();
        }
        return null;
    }
    
    Fragment g(final int n) {
        for (int i = this.a.size() - 1; i >= 0; --i) {
            final Fragment fragment = this.a.get(i);
            if (fragment != null && fragment.mFragmentId == n) {
                return fragment;
            }
        }
        for (final a0 a0 : this.b.values()) {
            if (a0 != null) {
                final Fragment k = a0.k();
                if (k.mFragmentId == n) {
                    return k;
                }
                continue;
            }
        }
        return null;
    }
    
    Fragment h(final String s) {
        if (s != null) {
            for (int i = this.a.size() - 1; i >= 0; --i) {
                final Fragment fragment = this.a.get(i);
                if (fragment != null && s.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (s != null) {
            for (final a0 a0 : this.b.values()) {
                if (a0 != null) {
                    final Fragment k = a0.k();
                    if (s.equals(k.mTag)) {
                        return k;
                    }
                    continue;
                }
            }
        }
        return null;
    }
    
    Fragment i(final String s) {
        for (final a0 a0 : this.b.values()) {
            if (a0 != null) {
                final Fragment fragmentByWho = a0.k().findFragmentByWho(s);
                if (fragmentByWho != null) {
                    return fragmentByWho;
                }
                continue;
            }
        }
        return null;
    }
    
    int j(Fragment fragment) {
        final ViewGroup mContainer = fragment.mContainer;
        if (mContainer == null) {
            return -1;
        }
        final int index = this.a.indexOf(fragment);
        int n = index - 1;
        int n2;
        while (true) {
            n2 = index;
            if (n < 0) {
                break;
            }
            fragment = this.a.get(n);
            if (fragment.mContainer == mContainer) {
                final View mView = fragment.mView;
                if (mView != null) {
                    return mContainer.indexOfChild(mView) + 1;
                }
            }
            --n;
        }
        while (++n2 < this.a.size()) {
            fragment = this.a.get(n2);
            if (fragment.mContainer == mContainer) {
                final View mView2 = fragment.mView;
                if (mView2 != null) {
                    return mContainer.indexOfChild(mView2);
                }
                continue;
            }
        }
        return -1;
    }
    
    List<a0> k() {
        final ArrayList list = new ArrayList();
        for (final a0 a0 : this.b.values()) {
            if (a0 != null) {
                list.add(a0);
            }
        }
        return list;
    }
    
    List<Fragment> l() {
        final ArrayList list = new ArrayList();
        for (final a0 a0 : this.b.values()) {
            if (a0 != null) {
                list.add(a0.k());
            }
            else {
                list.add(null);
            }
        }
        return list;
    }
    
    ArrayList<FragmentState> m() {
        return new ArrayList<FragmentState>(this.c.values());
    }
    
    a0 n(final String s) {
        return this.b.get(s);
    }
    
    List<Fragment> o() {
        if (this.a.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.a) {
            return new ArrayList<Fragment>(this.a);
        }
    }
    
    x p() {
        return this.d;
    }
    
    FragmentState q(final String s) {
        return this.c.get(s);
    }
    
    void r(final a0 a0) {
        final Fragment k = a0.k();
        if (this.c(k.mWho)) {
            return;
        }
        this.b.put(k.mWho, a0);
        if (k.mRetainInstanceChangedWhileDetached) {
            if (k.mRetainInstance) {
                this.d.h(k);
            }
            else {
                this.d.s(k);
            }
            k.mRetainInstanceChangedWhileDetached = false;
        }
        if (FragmentManager.N0(2)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Added fragment to active set ");
            sb.append(k);
            Log.v("FragmentManager", sb.toString());
        }
    }
    
    void s(final a0 a0) {
        final Fragment k = a0.k();
        if (k.mRetainInstance) {
            this.d.s(k);
        }
        if (this.b.put(k.mWho, null) == null) {
            return;
        }
        if (FragmentManager.N0(2)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Removed fragment from active set ");
            sb.append(k);
            Log.v("FragmentManager", sb.toString());
        }
    }
    
    void t() {
        final Iterator<Fragment> iterator = this.a.iterator();
        while (iterator.hasNext()) {
            final a0 a0 = this.b.get(iterator.next().mWho);
            if (a0 != null) {
                a0.m();
            }
        }
        for (final a0 a2 : this.b.values()) {
            if (a2 != null) {
                a2.m();
                final Fragment k = a2.k();
                if (!k.mRemoving || k.isInBackStack()) {
                    continue;
                }
                if (k.mBeingSaved && !this.c.containsKey(k.mWho)) {
                    a2.s();
                }
                this.s(a2);
            }
        }
    }
    
    void u(final Fragment fragment) {
        synchronized (this.a) {
            this.a.remove(fragment);
            monitorexit(this.a);
            fragment.mAdded = false;
        }
    }
    
    void v() {
        this.b.clear();
    }
    
    void w(final List<String> list) {
        this.a.clear();
        if (list != null) {
            for (final String s : list) {
                final Fragment f = this.f(s);
                if (f == null) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("No instantiated fragment for (");
                    sb.append(s);
                    sb.append(")");
                    throw new IllegalStateException(sb.toString());
                }
                if (FragmentManager.N0(2)) {
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("restoreSaveState: added (");
                    sb2.append(s);
                    sb2.append("): ");
                    sb2.append(f);
                    Log.v("FragmentManager", sb2.toString());
                }
                this.a(f);
            }
        }
    }
    
    void x(final ArrayList<FragmentState> list) {
        this.c.clear();
        for (final FragmentState fragmentState : list) {
            this.c.put(fragmentState.b, fragmentState);
        }
    }
    
    ArrayList<String> y() {
        final ArrayList list = new ArrayList(this.b.size());
        for (final a0 a0 : this.b.values()) {
            if (a0 != null) {
                final Fragment k = a0.k();
                a0.s();
                list.add(k.mWho);
                if (!FragmentManager.N0(2)) {
                    continue;
                }
                final StringBuilder sb = new StringBuilder();
                sb.append("Saved state of ");
                sb.append(k);
                sb.append(": ");
                sb.append(k.mSavedFragmentState);
                Log.v("FragmentManager", sb.toString());
            }
        }
        return list;
    }
    
    ArrayList<String> z() {
        synchronized (this.a) {
            if (this.a.isEmpty()) {
                return null;
            }
            final ArrayList<String> list = new ArrayList<String>(this.a.size());
            for (final Fragment fragment : this.a) {
                list.add(fragment.mWho);
                if (FragmentManager.N0(2)) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("saveAllState: adding fragment (");
                    sb.append(fragment.mWho);
                    sb.append("): ");
                    sb.append(fragment);
                    Log.v("FragmentManager", sb.toString());
                }
            }
            return list;
        }
    }
}
