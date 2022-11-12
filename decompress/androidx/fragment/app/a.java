// 
// Decompiled by Procyon v0.6.0
// 

package androidx.fragment.app;

import androidx.lifecycle.Lifecycle;
import java.util.ArrayList;
import java.io.Writer;
import java.io.PrintWriter;
import android.util.Log;

final class a extends c0 implements j, o
{
    final FragmentManager t;
    boolean u;
    int v;
    boolean w;
    
    a(final FragmentManager t) {
        final androidx.fragment.app.l x0 = t.x0();
        ClassLoader classLoader;
        if (t.A0() != null) {
            classLoader = t.A0().f().getClassLoader();
        }
        else {
            classLoader = null;
        }
        super(x0, classLoader);
        this.v = -1;
        this.w = false;
        this.t = t;
    }
    
    a(final a a) {
        final androidx.fragment.app.l x0 = a.t.x0();
        ClassLoader classLoader;
        if (a.t.A0() != null) {
            classLoader = a.t.A0().f().getClassLoader();
        }
        else {
            classLoader = null;
        }
        super(x0, classLoader, a);
        this.v = -1;
        this.w = false;
        this.t = a.t;
        this.u = a.u;
        this.v = a.v;
        this.w = a.w;
    }
    
    int A(final boolean b) {
        if (!this.u) {
            if (FragmentManager.N0(2)) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Commit: ");
                sb.append(this);
                Log.v("FragmentManager", sb.toString());
                final PrintWriter printWriter = new PrintWriter(new h0("FragmentManager"));
                this.B("  ", printWriter);
                printWriter.close();
            }
            this.u = true;
            if (super.i) {
                this.v = this.t.n();
            }
            else {
                this.v = -1;
            }
            this.t.b0((FragmentManager.o)this, b);
            return this.v;
        }
        throw new IllegalStateException("commit already called");
    }
    
    public void B(final String s, final PrintWriter printWriter) {
        this.C(s, printWriter, true);
    }
    
    public void C(final String s, final PrintWriter printWriter, final boolean b) {
        if (b) {
            printWriter.print(s);
            printWriter.print("mName=");
            printWriter.print(super.k);
            printWriter.print(" mIndex=");
            printWriter.print(this.v);
            printWriter.print(" mCommitted=");
            printWriter.println(this.u);
            if (super.h != 0) {
                printWriter.print(s);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(super.h));
            }
            if (super.d != 0 || super.e != 0) {
                printWriter.print(s);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(super.d));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(super.e));
            }
            if (super.f != 0 || super.g != 0) {
                printWriter.print(s);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(super.f));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(super.g));
            }
            if (super.l != 0 || super.m != null) {
                printWriter.print(s);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(super.l));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(super.m);
            }
            if (super.n != 0 || super.o != null) {
                printWriter.print(s);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(super.n));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(super.o);
            }
        }
        if (!super.c.isEmpty()) {
            printWriter.print(s);
            printWriter.println("Operations:");
            for (int size = super.c.size(), i = 0; i < size; ++i) {
                final c0.a a = super.c.get(i);
                String string = null;
                switch (a.a) {
                    default: {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("cmd=");
                        sb.append(a.a);
                        string = sb.toString();
                        break;
                    }
                    case 10: {
                        string = "OP_SET_MAX_LIFECYCLE";
                        break;
                    }
                    case 9: {
                        string = "UNSET_PRIMARY_NAV";
                        break;
                    }
                    case 8: {
                        string = "SET_PRIMARY_NAV";
                        break;
                    }
                    case 7: {
                        string = "ATTACH";
                        break;
                    }
                    case 6: {
                        string = "DETACH";
                        break;
                    }
                    case 5: {
                        string = "SHOW";
                        break;
                    }
                    case 4: {
                        string = "HIDE";
                        break;
                    }
                    case 3: {
                        string = "REMOVE";
                        break;
                    }
                    case 2: {
                        string = "REPLACE";
                        break;
                    }
                    case 1: {
                        string = "ADD";
                        break;
                    }
                    case 0: {
                        string = "NULL";
                        break;
                    }
                }
                printWriter.print(s);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(string);
                printWriter.print(" ");
                printWriter.println(a.b);
                if (b) {
                    if (a.d != 0 || a.e != 0) {
                        printWriter.print(s);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(a.d));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(a.e));
                    }
                    if (a.f != 0 || a.g != 0) {
                        printWriter.print(s);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(a.f));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(a.g));
                    }
                }
            }
        }
    }
    
    void D() {
        for (int size = super.c.size(), i = 0; i < size; ++i) {
            final c0.a a = super.c.get(i);
            final Fragment b = a.b;
            if (b != null) {
                b.mBeingSaved = this.w;
                b.setPopDirection(false);
                b.setNextTransition(super.h);
                b.setSharedElementNames(super.p, super.q);
            }
            switch (a.a) {
                default: {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Unknown cmd: ");
                    sb.append(a.a);
                    throw new IllegalArgumentException(sb.toString());
                }
                case 10: {
                    this.t.I1(b, a.i);
                    break;
                }
                case 9: {
                    this.t.J1(null);
                    break;
                }
                case 8: {
                    this.t.J1(b);
                    break;
                }
                case 7: {
                    b.setAnimations(a.d, a.e, a.f, a.g);
                    this.t.F1(b, false);
                    this.t.p(b);
                    break;
                }
                case 6: {
                    b.setAnimations(a.d, a.e, a.f, a.g);
                    this.t.z(b);
                    break;
                }
                case 5: {
                    b.setAnimations(a.d, a.e, a.f, a.g);
                    this.t.F1(b, false);
                    this.t.L1(b);
                    break;
                }
                case 4: {
                    b.setAnimations(a.d, a.e, a.f, a.g);
                    this.t.K0(b);
                    break;
                }
                case 3: {
                    b.setAnimations(a.d, a.e, a.f, a.g);
                    this.t.q1(b);
                    break;
                }
                case 1: {
                    b.setAnimations(a.d, a.e, a.f, a.g);
                    this.t.F1(b, false);
                    this.t.j(b);
                    break;
                }
            }
        }
    }
    
    void E() {
        for (int i = super.c.size() - 1; i >= 0; --i) {
            final c0.a a = super.c.get(i);
            final Fragment b = a.b;
            if (b != null) {
                b.mBeingSaved = this.w;
                b.setPopDirection(true);
                b.setNextTransition(FragmentManager.z1(super.h));
                b.setSharedElementNames(super.q, super.p);
            }
            switch (a.a) {
                default: {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Unknown cmd: ");
                    sb.append(a.a);
                    throw new IllegalArgumentException(sb.toString());
                }
                case 10: {
                    this.t.I1(b, a.h);
                    break;
                }
                case 9: {
                    this.t.J1(b);
                    break;
                }
                case 8: {
                    this.t.J1(null);
                    break;
                }
                case 7: {
                    b.setAnimations(a.d, a.e, a.f, a.g);
                    this.t.F1(b, true);
                    this.t.z(b);
                    break;
                }
                case 6: {
                    b.setAnimations(a.d, a.e, a.f, a.g);
                    this.t.p(b);
                    break;
                }
                case 5: {
                    b.setAnimations(a.d, a.e, a.f, a.g);
                    this.t.F1(b, true);
                    this.t.K0(b);
                    break;
                }
                case 4: {
                    b.setAnimations(a.d, a.e, a.f, a.g);
                    this.t.L1(b);
                    break;
                }
                case 3: {
                    b.setAnimations(a.d, a.e, a.f, a.g);
                    this.t.j(b);
                    break;
                }
                case 1: {
                    b.setAnimations(a.d, a.e, a.f, a.g);
                    this.t.F1(b, true);
                    this.t.q1(b);
                    break;
                }
            }
        }
    }
    
    Fragment F(final ArrayList<Fragment> list, Fragment b) {
        int i = 0;
        Fragment fragment = b;
        while (i < super.c.size()) {
            final c0.a a = super.c.get(i);
            final int a2 = a.a;
            int n = 0;
            Label_0456: {
                if (a2 != 1) {
                    if (a2 != 2) {
                        if (a2 != 3 && a2 != 6) {
                            if (a2 != 7) {
                                if (a2 != 8) {
                                    b = fragment;
                                    n = i;
                                    break Label_0456;
                                }
                                super.c.add(i, new c0.a(9, fragment, true));
                                a.c = true;
                                n = i + 1;
                                b = a.b;
                                break Label_0456;
                            }
                        }
                        else {
                            list.remove(a.b);
                            final Fragment b2 = a.b;
                            b = fragment;
                            n = i;
                            if (b2 == fragment) {
                                super.c.add(i, new c0.a(9, b2));
                                n = i + 1;
                                b = null;
                            }
                            break Label_0456;
                        }
                    }
                    else {
                        final Fragment b3 = a.b;
                        final int mContainerId = b3.mContainerId;
                        int j = list.size() - 1;
                        int n2 = 0;
                        n = i;
                        b = fragment;
                        while (j >= 0) {
                            final Fragment fragment2 = list.get(j);
                            Fragment fragment3 = b;
                            int n3 = n;
                            int n4 = n2;
                            if (fragment2.mContainerId == mContainerId) {
                                if (fragment2 == b3) {
                                    n4 = 1;
                                    fragment3 = b;
                                    n3 = n;
                                }
                                else {
                                    fragment3 = b;
                                    int n5 = n;
                                    if (fragment2 == b) {
                                        super.c.add(n, new c0.a(9, fragment2, true));
                                        n5 = n + 1;
                                        fragment3 = null;
                                    }
                                    final c0.a a3 = new c0.a(3, fragment2, true);
                                    a3.d = a.d;
                                    a3.f = a.f;
                                    a3.e = a.e;
                                    a3.g = a.g;
                                    super.c.add(n5, a3);
                                    list.remove(fragment2);
                                    n3 = n5 + 1;
                                    n4 = n2;
                                }
                            }
                            --j;
                            b = fragment3;
                            n = n3;
                            n2 = n4;
                        }
                        if (n2 != 0) {
                            super.c.remove(n);
                            --n;
                            break Label_0456;
                        }
                        a.a = 1;
                        a.c = true;
                        list.add(b3);
                        break Label_0456;
                    }
                }
                list.add(a.b);
                n = i;
                b = fragment;
            }
            i = n + 1;
            fragment = b;
        }
        return fragment;
    }
    
    public void G() {
        if (super.s != null) {
            for (int i = 0; i < super.s.size(); ++i) {
                super.s.get(i).run();
            }
            super.s = null;
        }
    }
    
    Fragment H(final ArrayList<Fragment> list, Fragment b) {
        for (int i = super.c.size() - 1; i >= 0; --i) {
            final c0.a a = super.c.get(i);
            final int a2 = a.a;
            Label_0127: {
                if (a2 != 1) {
                    if (a2 != 3) {
                        switch (a2) {
                            default: {
                                continue;
                            }
                            case 10: {
                                a.i = a.h;
                                continue;
                            }
                            case 9: {
                                b = a.b;
                                continue;
                            }
                            case 8: {
                                b = null;
                                continue;
                            }
                            case 6: {
                                break;
                            }
                            case 7: {
                                break Label_0127;
                            }
                        }
                    }
                    list.add(a.b);
                    continue;
                }
            }
            list.remove(a.b);
        }
        return b;
    }
    
    @Override
    public boolean a(final ArrayList<a> list, final ArrayList<Boolean> list2) {
        if (FragmentManager.N0(2)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Run: ");
            sb.append(this);
            Log.v("FragmentManager", sb.toString());
        }
        list.add(this);
        list2.add(Boolean.FALSE);
        if (super.i) {
            this.t.i(this);
        }
        return true;
    }
    
    @Override
    public String getName() {
        return super.k;
    }
    
    @Override
    public int i() {
        return this.A(false);
    }
    
    @Override
    public int j() {
        return this.A(true);
    }
    
    @Override
    public void k() {
        this.m();
        this.t.e0((FragmentManager.o)this, false);
    }
    
    @Override
    public void l() {
        this.m();
        this.t.e0((FragmentManager.o)this, true);
    }
    
    @Override
    void n(final int n, final Fragment fragment, final String s, final int n2) {
        super.n(n, fragment, s, n2);
        fragment.mFragmentManager = this.t;
    }
    
    @Override
    public boolean o() {
        return super.c.isEmpty();
    }
    
    @Override
    public c0 p(final Fragment fragment) {
        final FragmentManager mFragmentManager = fragment.mFragmentManager;
        if (mFragmentManager != null && mFragmentManager != this.t) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Cannot remove Fragment attached to a different FragmentManager. Fragment ");
            sb.append(fragment.toString());
            sb.append(" is already attached to a FragmentManager.");
            throw new IllegalStateException(sb.toString());
        }
        return super.p(fragment);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.v >= 0) {
            sb.append(" #");
            sb.append(this.v);
        }
        if (super.k != null) {
            sb.append(" ");
            sb.append(super.k);
        }
        sb.append("}");
        return sb.toString();
    }
    
    @Override
    public c0 u(final Fragment fragment, final Lifecycle.State state) {
        if (fragment.mFragmentManager != this.t) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Cannot setMaxLifecycle for Fragment not attached to FragmentManager ");
            sb.append(this.t);
            throw new IllegalArgumentException(sb.toString());
        }
        if (state == Lifecycle.State.INITIALIZED && fragment.mState > -1) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Cannot set maximum Lifecycle to ");
            sb2.append(state);
            sb2.append(" after the Fragment has been created");
            throw new IllegalArgumentException(sb2.toString());
        }
        if (state != Lifecycle.State.DESTROYED) {
            return super.u(fragment, state);
        }
        final StringBuilder sb3 = new StringBuilder();
        sb3.append("Cannot set maximum Lifecycle to ");
        sb3.append(state);
        sb3.append(". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
        throw new IllegalArgumentException(sb3.toString());
    }
    
    @Override
    public c0 v(final Fragment fragment) {
        if (fragment != null) {
            final FragmentManager mFragmentManager = fragment.mFragmentManager;
            if (mFragmentManager != null) {
                if (mFragmentManager != this.t) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Cannot setPrimaryNavigation for Fragment attached to a different FragmentManager. Fragment ");
                    sb.append(fragment.toString());
                    sb.append(" is already attached to a FragmentManager.");
                    throw new IllegalStateException(sb.toString());
                }
            }
        }
        return super.v(fragment);
    }
    
    void y(final int n) {
        if (!super.i) {
            return;
        }
        if (FragmentManager.N0(2)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Bump nesting in ");
            sb.append(this);
            sb.append(" by ");
            sb.append(n);
            Log.v("FragmentManager", sb.toString());
        }
        for (int size = super.c.size(), i = 0; i < size; ++i) {
            final c0.a a = super.c.get(i);
            final Fragment b = a.b;
            if (b != null) {
                b.mBackStackNesting += n;
                if (FragmentManager.N0(2)) {
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("Bump nesting of ");
                    sb2.append(a.b);
                    sb2.append(" to ");
                    sb2.append(a.b.mBackStackNesting);
                    Log.v("FragmentManager", sb2.toString());
                }
            }
        }
    }
    
    void z() {
        int n;
        for (int i = super.c.size() - 1; i >= 0; i = n - 1) {
            final c0.a a = super.c.get(i);
            if (!a.c) {
                n = i;
            }
            else if (a.a == 8) {
                a.c = false;
                super.c.remove(i - 1);
                n = i - 1;
            }
            else {
                final int mContainerId = a.b.mContainerId;
                a.a = 2;
                a.c = false;
                int n2 = i - 1;
                while (true) {
                    n = i;
                    if (n2 < 0) {
                        break;
                    }
                    final c0.a a2 = super.c.get(n2);
                    int n3 = i;
                    if (a2.c) {
                        n3 = i;
                        if (a2.b.mContainerId == mContainerId) {
                            super.c.remove(n2);
                            n3 = i - 1;
                        }
                    }
                    --n2;
                    i = n3;
                }
            }
        }
    }
}
