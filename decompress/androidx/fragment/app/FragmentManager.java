// 
// Decompiled by Procyon v0.6.0
// 

package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResult;
import c.d;
import u0.e;
import android.content.IntentSender$SendIntentException;
import android.content.IntentSender;
import androidx.lifecycle.q0;
import androidx.lifecycle.Lifecycle;
import androidx.core.content.c;
import java.util.List;
import android.view.LayoutInflater$Factory2;
import android.os.Parcelable;
import java.util.HashSet;
import java.util.Set;
import android.app.Activity;
import androidx.lifecycle.r0;
import android.view.ViewParent;
import android.content.Context;
import android.content.ContextWrapper;
import java.util.Collection;
import android.os.Looper;
import java.io.FileDescriptor;
import java.io.Writer;
import java.io.PrintWriter;
import android.util.Log;
import java.util.Iterator;
import android.view.View;
import android.view.ViewGroup;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Menu;
import java.util.Collections;
import java.util.HashMap;
import androidx.core.view.o;
import androidx.core.app.s;
import androidx.core.app.i;
import android.content.res.Configuration;
import java.util.concurrent.CopyOnWriteArrayList;
import android.os.Bundle;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import androidx.activity.g;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import java.util.ArrayList;
import java.util.ArrayDeque;
import androidx.activity.result.IntentSenderRequest;
import android.content.Intent;
import androidx.activity.result.b;

public abstract class FragmentManager
{
    private static boolean S = false;
    private androidx.fragment.app.l A;
    private i0 B;
    private i0 C;
    private b<Intent> D;
    private b<IntentSenderRequest> E;
    private b<String[]> F;
    ArrayDeque<LaunchedFragmentInfo> G;
    private boolean H;
    private boolean I;
    private boolean J;
    private boolean K;
    private boolean L;
    private ArrayList<a> M;
    private ArrayList<Boolean> N;
    private ArrayList<Fragment> O;
    private x P;
    private FragmentStrictMode.b Q;
    private Runnable R;
    private final ArrayList<o> a;
    private boolean b;
    private final b0 c;
    ArrayList<a> d;
    private ArrayList<Fragment> e;
    private final androidx.fragment.app.p f;
    private OnBackPressedDispatcher g;
    private final g h;
    private final AtomicInteger i;
    private final Map<String, BackStackState> j;
    private final Map<String, Bundle> k;
    private final Map<String, m> l;
    private ArrayList<n> m;
    private final androidx.fragment.app.q n;
    private final CopyOnWriteArrayList<y> o;
    private final androidx.core.util.a<Configuration> p;
    private final androidx.core.util.a<Integer> q;
    private final androidx.core.util.a<i> r;
    private final androidx.core.util.a<s> s;
    private final androidx.core.view.o t;
    int u;
    private androidx.fragment.app.m<?> v;
    private androidx.fragment.app.j w;
    private Fragment x;
    Fragment y;
    private androidx.fragment.app.l z;
    
    public FragmentManager() {
        this.a = new ArrayList<o>();
        this.c = new b0();
        this.f = new androidx.fragment.app.p(this);
        this.h = new g(false) {
            final FragmentManager a;
            
            @Override
            public void handleOnBackPressed() {
                this.a.J0();
            }
        };
        this.i = new AtomicInteger();
        this.j = Collections.synchronizedMap(new HashMap<String, BackStackState>());
        this.k = Collections.synchronizedMap(new HashMap<String, Bundle>());
        this.l = Collections.synchronizedMap(new HashMap<String, m>());
        this.n = new androidx.fragment.app.q(this);
        this.o = new CopyOnWriteArrayList<y>();
        this.p = new androidx.fragment.app.r(this);
        this.q = new u(this);
        this.r = new androidx.fragment.app.s(this);
        this.s = new t(this);
        this.t = new androidx.core.view.o() {
            final FragmentManager a;
            
            @Override
            public void a(final Menu menu) {
                this.a.N(menu);
            }
            
            @Override
            public void b(final Menu menu) {
                this.a.R(menu);
            }
            
            @Override
            public boolean c(final MenuItem menuItem) {
                return this.a.M(menuItem);
            }
            
            @Override
            public void d(final Menu menu, final MenuInflater menuInflater) {
                this.a.F(menu, menuInflater);
            }
        };
        this.u = -1;
        this.z = null;
        this.A = new androidx.fragment.app.l() {
            final FragmentManager b;
            
            @Override
            public Fragment a(final ClassLoader classLoader, final String s) {
                return this.b.A0().b(this.b.A0().f(), s, null);
            }
        };
        this.B = null;
        this.C = new i0() {
            final FragmentManager a;
            
            @Override
            public SpecialEffectsController a(final ViewGroup viewGroup) {
                return new androidx.fragment.app.b(viewGroup);
            }
        };
        this.G = new ArrayDeque<LaunchedFragmentInfo>();
        this.R = new Runnable() {
            final FragmentManager a;
            
            @Override
            public void run() {
                this.a.d0(true);
            }
        };
    }
    
    static Fragment H0(final View view) {
        final Object tag = view.getTag(f0.b.a);
        if (tag instanceof Fragment) {
            return (Fragment)tag;
        }
        return null;
    }
    
    private void K1(final Fragment fragment) {
        final ViewGroup w0 = this.w0(fragment);
        if (w0 != null && fragment.getEnterAnim() + fragment.getExitAnim() + fragment.getPopEnterAnim() + fragment.getPopExitAnim() > 0) {
            final int c = f0.b.c;
            if (w0.getTag(c) == null) {
                w0.setTag(c, (Object)fragment);
            }
            ((Fragment)w0.getTag(c)).setPopDirection(fragment.getPopDirection());
        }
    }
    
    private void M1() {
        final Iterator<a0> iterator = this.c.k().iterator();
        while (iterator.hasNext()) {
            this.f1(iterator.next());
        }
    }
    
    public static boolean N0(final int n) {
        return FragmentManager.S || Log.isLoggable("FragmentManager", n);
    }
    
    private void N1(final RuntimeException ex) {
        Log.e("FragmentManager", ex.getMessage());
        Log.e("FragmentManager", "Activity state:");
        final PrintWriter printWriter = new PrintWriter(new h0("FragmentManager"));
        final androidx.fragment.app.m<?> v = this.v;
        if (v != null) {
            try {
                v.h("  ", null, printWriter, new String[0]);
            }
            catch (final Exception ex2) {
                Log.e("FragmentManager", "Failed dumping state", (Throwable)ex2);
            }
        }
        else {
            try {
                this.Z("  ", null, printWriter, new String[0]);
            }
            catch (final Exception ex3) {
                Log.e("FragmentManager", "Failed dumping state", (Throwable)ex3);
            }
        }
        throw ex;
    }
    
    private void O(final Fragment fragment) {
        if (fragment != null && fragment.equals(this.h0(fragment.mWho))) {
            fragment.performPrimaryNavigationFragmentChanged();
        }
    }
    
    private boolean O0(final Fragment fragment) {
        return (fragment.mHasMenu && fragment.mMenuVisible) || fragment.mChildFragmentManager.r();
    }
    
    private void P1() {
        Object o = this.a;
        synchronized (o) {
            final boolean empty = this.a.isEmpty();
            boolean enabled = true;
            if (!empty) {
                this.h.setEnabled(true);
                return;
            }
            monitorexit(o);
            o = this.h;
            if (this.s0() <= 0 || !this.R0(this.x)) {
                enabled = false;
            }
            ((g)o).setEnabled(enabled);
        }
    }
    
    private Bundle U0() {
        return this.A1();
    }
    
    private void V(final int n) {
        try {
            this.b = true;
            this.c.d(n);
            this.c1(n, false);
            final Iterator<SpecialEffectsController> iterator = this.w().iterator();
            while (iterator.hasNext()) {
                iterator.next().j();
            }
            this.b = false;
            this.d0(true);
        }
        finally {
            this.b = false;
        }
    }
    
    private void V0(final Configuration configuration) {
        this.C(configuration);
    }
    
    private void W0(final Integer n) {
        if (n == 80) {
            this.I();
        }
    }
    
    private void X0(final i i) {
        this.J(i.a());
    }
    
    private void Y() {
        if (this.L) {
            this.L = false;
            this.M1();
        }
    }
    
    private void Y0(final s s) {
        this.Q(s.a());
    }
    
    public static void a(final FragmentManager fragmentManager, final Integer n) {
        fragmentManager.W0(n);
    }
    
    private void a0() {
        final Iterator<SpecialEffectsController> iterator = this.w().iterator();
        while (iterator.hasNext()) {
            iterator.next().j();
        }
    }
    
    public static void b(final FragmentManager fragmentManager, final s s) {
        fragmentManager.Y0(s);
    }
    
    public static void c(final FragmentManager fragmentManager, final i i) {
        fragmentManager.X0(i);
    }
    
    private void c0(final boolean b) {
        if (this.b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.v == null) {
            if (this.K) {
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            throw new IllegalStateException("FragmentManager has not been attached to a host.");
        }
        else {
            if (Looper.myLooper() == this.v.g().getLooper()) {
                if (!b) {
                    this.s();
                }
                if (this.M == null) {
                    this.M = new ArrayList<a>();
                    this.N = new ArrayList<Boolean>();
                }
                return;
            }
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
    }
    
    public static void d(final FragmentManager fragmentManager, final Configuration configuration) {
        fragmentManager.V0(configuration);
    }
    
    public static Bundle e(final FragmentManager fragmentManager) {
        return fragmentManager.U0();
    }
    
    static Map f(final FragmentManager fragmentManager) {
        return fragmentManager.k;
    }
    
    private static void f0(final ArrayList<a> list, final ArrayList<Boolean> list2, int i, final int n) {
        while (i < n) {
            final a a = list.get(i);
            if (list2.get(i)) {
                a.y(-1);
                a.E();
            }
            else {
                a.y(1);
                a.D();
            }
            ++i;
        }
    }
    
    static Map g(final FragmentManager fragmentManager) {
        return fragmentManager.l;
    }
    
    private void g0(final ArrayList<a> list, final ArrayList<Boolean> list2, final int n, final int n2) {
        final boolean r = list.get(n).r;
        final ArrayList<Fragment> o = this.O;
        if (o == null) {
            this.O = new ArrayList<Fragment>();
        }
        else {
            o.clear();
        }
        this.O.addAll(this.c.o());
        Fragment fragment = this.E0();
        int i = n;
        int n3 = 0;
        while (i < n2) {
            final a a = list.get(i);
            if (!list2.get(i)) {
                fragment = a.F(this.O, fragment);
            }
            else {
                fragment = a.H(this.O, fragment);
            }
            if (n3 == 0 && !a.i) {
                n3 = 0;
            }
            else {
                n3 = 1;
            }
            ++i;
        }
        this.O.clear();
        if (!r && this.u >= 1) {
            for (int j = n; j < n2; ++j) {
                final Iterator<c0.a> iterator = list.get(j).c.iterator();
                while (iterator.hasNext()) {
                    final Fragment b = ((c0.a)iterator.next()).b;
                    if (b != null && b.mFragmentManager != null) {
                        this.c.r(this.y(b));
                    }
                }
            }
        }
        f0(list, list2, n, n2);
        final boolean booleanValue = list2.get(n2 - 1);
        for (int k = n; k < n2; ++k) {
            final a a2 = list.get(k);
            if (booleanValue) {
                for (int l = a2.c.size() - 1; l >= 0; --l) {
                    final Fragment b2 = ((c0.a)a2.c.get(l)).b;
                    if (b2 != null) {
                        this.y(b2).m();
                    }
                }
            }
            else {
                final Iterator<c0.a> iterator2 = a2.c.iterator();
                while (iterator2.hasNext()) {
                    final Fragment b3 = ((c0.a)iterator2.next()).b;
                    if (b3 != null) {
                        this.y(b3).m();
                    }
                }
            }
        }
        this.c1(this.u, true);
        final Iterator<SpecialEffectsController> iterator3 = this.x(list, n, n2).iterator();
        int n4;
        while (true) {
            n4 = n;
            if (!iterator3.hasNext()) {
                break;
            }
            final SpecialEffectsController specialEffectsController = iterator3.next();
            specialEffectsController.r(booleanValue);
            specialEffectsController.p();
            specialEffectsController.g();
        }
        while (n4 < n2) {
            final a a3 = list.get(n4);
            if (list2.get(n4) && a3.v >= 0) {
                a3.v = -1;
            }
            a3.G();
            ++n4;
        }
        if (n3 != 0) {
            this.v1();
        }
    }
    
    static b0 h(final FragmentManager fragmentManager) {
        return fragmentManager.c;
    }
    
    private int i0(final String s, final int n, final boolean b) {
        final ArrayList<a> d = this.d;
        if (d == null || d.isEmpty()) {
            return -1;
        }
        if (s == null && n < 0) {
            if (b) {
                return 0;
            }
            return this.d.size() - 1;
        }
        else {
            int i;
            for (i = this.d.size() - 1; i >= 0; --i) {
                final a a = this.d.get(i);
                if (s != null && s.equals(a.getName())) {
                    break;
                }
                if (n >= 0 && n == a.v) {
                    break;
                }
            }
            if (i < 0) {
                return i;
            }
            int n2;
            if (b) {
                while ((n2 = i) > 0) {
                    final a a2 = this.d.get(i - 1);
                    if (s == null || !s.equals(a2.getName())) {
                        n2 = i;
                        if (n < 0) {
                            break;
                        }
                        n2 = i;
                        if (n != a2.v) {
                            break;
                        }
                    }
                    --i;
                }
            }
            else {
                if (i == this.d.size() - 1) {
                    return -1;
                }
                n2 = i + 1;
            }
            return n2;
        }
    }
    
    static FragmentManager m0(final View view) {
        final Fragment n0 = n0(view);
        FragmentManager fragmentManager;
        if (n0 != null) {
            if (!n0.isAdded()) {
                final StringBuilder sb = new StringBuilder();
                sb.append("The Fragment ");
                sb.append(n0);
                sb.append(" that owns View ");
                sb.append(view);
                sb.append(" has already been destroyed. Nested fragments should always use the child FragmentManager.");
                throw new IllegalStateException(sb.toString());
            }
            fragmentManager = n0.getChildFragmentManager();
        }
        else {
            Context context = view.getContext();
            final h h = null;
            h h2;
            while (true) {
                h2 = h;
                if (!(context instanceof ContextWrapper)) {
                    break;
                }
                if (context instanceof h) {
                    h2 = (h)context;
                    break;
                }
                context = ((ContextWrapper)context).getBaseContext();
            }
            if (h2 == null) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("View ");
                sb2.append(view);
                sb2.append(" is not within a subclass of FragmentActivity.");
                throw new IllegalStateException(sb2.toString());
            }
            fragmentManager = h2.getSupportFragmentManager();
        }
        return fragmentManager;
    }
    
    private boolean m1(final String s, final int n, final int n2) {
        this.d0(false);
        this.c0(true);
        final Fragment y = this.y;
        if (y != null && n < 0 && s == null && y.getChildFragmentManager().j1()) {
            return true;
        }
        final boolean n3 = this.n1(this.M, this.N, s, n, n2);
        if (n3) {
            this.b = true;
            try {
                this.t1(this.M, this.N);
            }
            finally {
                this.t();
            }
        }
        this.P1();
        this.Y();
        this.c.b();
        return n3;
    }
    
    private static Fragment n0(View view) {
        while (view != null) {
            final Fragment h0 = H0(view);
            if (h0 != null) {
                return h0;
            }
            final ViewParent parent = view.getParent();
            if (parent instanceof View) {
                view = (View)parent;
            }
            else {
                view = null;
            }
        }
        return null;
    }
    
    private void o0() {
        final Iterator<SpecialEffectsController> iterator = this.w().iterator();
        while (iterator.hasNext()) {
            iterator.next().k();
        }
    }
    
    private boolean p0(final ArrayList<a> list, final ArrayList<Boolean> list2) {
        synchronized (this.a) {
            final boolean empty = this.a.isEmpty();
            int i = 0;
            if (empty) {
                return false;
            }
            try {
                final int size = this.a.size();
                boolean b = false;
                while (i < size) {
                    b |= this.a.get(i).a(list, list2);
                    ++i;
                }
                return b;
            }
            finally {
                this.a.clear();
                this.v.g().removeCallbacks(this.R);
            }
        }
    }
    
    private void s() {
        if (!this.T0()) {
            return;
        }
        throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
    }
    
    private void t() {
        this.b = false;
        this.N.clear();
        this.M.clear();
    }
    
    private x t0(final Fragment fragment) {
        return this.P.n(fragment);
    }
    
    private void t1(final ArrayList<a> list, final ArrayList<Boolean> list2) {
        if (list.isEmpty()) {
            return;
        }
        if (list.size() == list2.size()) {
            final int size = list.size();
            int i = 0;
            int n = 0;
            while (i < size) {
                int n2 = i;
                int n3 = n;
                if (!((a)list.get(i)).r) {
                    if (n != i) {
                        this.g0(list, list2, n, i);
                    }
                    int n4 = n3 = i + 1;
                    if (list2.get(i)) {
                        while ((n3 = n4) < size) {
                            n3 = n4;
                            if (!(boolean)list2.get(n4)) {
                                break;
                            }
                            n3 = n4;
                            if (((a)list.get(n4)).r) {
                                break;
                            }
                            ++n4;
                        }
                    }
                    this.g0(list, list2, i, n3);
                    n2 = n3 - 1;
                }
                i = n2 + 1;
                n = n3;
            }
            if (n != size) {
                this.g0(list, list2, n, size);
            }
            return;
        }
        throw new IllegalStateException("Internal error with the back stack records");
    }
    
    private void u() {
        final androidx.fragment.app.m<?> v = this.v;
        final boolean b = v instanceof r0;
        boolean r = true;
        if (b) {
            r = this.c.p().r();
        }
        else if (v.f() instanceof Activity) {
            r = (true ^ ((Activity)this.v.f()).isChangingConfigurations());
        }
        if (r) {
            final Iterator<BackStackState> iterator = this.j.values().iterator();
            while (iterator.hasNext()) {
                final Iterator<String> iterator2 = iterator.next().a.iterator();
                while (iterator2.hasNext()) {
                    this.c.p().k(iterator2.next());
                }
            }
        }
    }
    
    private void v1() {
        if (this.m != null) {
            for (int i = 0; i < this.m.size(); ++i) {
                this.m.get(i).onBackStackChanged();
            }
        }
    }
    
    private Set<SpecialEffectsController> w() {
        final HashSet set = new HashSet();
        final Iterator<a0> iterator = this.c.k().iterator();
        while (iterator.hasNext()) {
            final ViewGroup mContainer = iterator.next().k().mContainer;
            if (mContainer != null) {
                set.add(SpecialEffectsController.o(mContainer, this.F0()));
            }
        }
        return set;
    }
    
    private ViewGroup w0(final Fragment fragment) {
        final ViewGroup mContainer = fragment.mContainer;
        if (mContainer != null) {
            return mContainer;
        }
        if (fragment.mContainerId <= 0) {
            return null;
        }
        if (this.w.d()) {
            final View c = this.w.c(fragment.mContainerId);
            if (c instanceof ViewGroup) {
                return (ViewGroup)c;
            }
        }
        return null;
    }
    
    private Set<SpecialEffectsController> x(final ArrayList<a> list, int i, final int n) {
        final HashSet set = new HashSet();
        while (i < n) {
            final Iterator<c0.a> iterator = list.get(i).c.iterator();
            while (iterator.hasNext()) {
                final Fragment b = ((c0.a)iterator.next()).b;
                if (b != null) {
                    final ViewGroup mContainer = b.mContainer;
                    if (mContainer == null) {
                        continue;
                    }
                    set.add(SpecialEffectsController.n(mContainer, this));
                }
            }
            ++i;
        }
        return set;
    }
    
    static int z1(final int n) {
        int n2 = 4100;
        if (n != 4097) {
            if (n != 8194) {
                if (n != 8197) {
                    if (n != 4099) {
                        if (n != 4100) {
                            n2 = 0;
                        }
                        else {
                            n2 = 8197;
                        }
                    }
                    else {
                        n2 = 4099;
                    }
                }
            }
            else {
                n2 = 4097;
            }
        }
        else {
            n2 = 8194;
        }
        return n2;
    }
    
    void A() {
        this.I = false;
        this.J = false;
        this.P.t(false);
        this.V(4);
    }
    
    public androidx.fragment.app.m<?> A0() {
        return this.v;
    }
    
    Bundle A1() {
        final Bundle bundle = new Bundle();
        this.o0();
        this.a0();
        this.d0(true);
        this.I = true;
        this.P.t(true);
        final ArrayList<String> y = this.c.y();
        final ArrayList<FragmentState> m = this.c.m();
        if (m.isEmpty()) {
            if (N0(2)) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
        }
        else {
            final ArrayList<String> z = this.c.z();
            final BackStackRecordState[] array = null;
            final ArrayList<a> d = this.d;
            BackStackRecordState[] c = array;
            if (d != null) {
                final int size = d.size();
                c = array;
                if (size > 0) {
                    final BackStackRecordState[] array2 = new BackStackRecordState[size];
                    int n = 0;
                    while (true) {
                        c = array2;
                        if (n >= size) {
                            break;
                        }
                        array2[n] = new BackStackRecordState(this.d.get(n));
                        if (N0(2)) {
                            final StringBuilder sb = new StringBuilder();
                            sb.append("saveAllState: adding back stack #");
                            sb.append(n);
                            sb.append(": ");
                            sb.append(this.d.get(n));
                            Log.v("FragmentManager", sb.toString());
                        }
                        ++n;
                    }
                }
            }
            final FragmentManagerState fragmentManagerState = new FragmentManagerState();
            fragmentManagerState.a = y;
            fragmentManagerState.b = z;
            fragmentManagerState.c = c;
            fragmentManagerState.d = this.i.get();
            final Fragment y2 = this.y;
            if (y2 != null) {
                fragmentManagerState.e = y2.mWho;
            }
            fragmentManagerState.f.addAll(this.j.keySet());
            fragmentManagerState.g.addAll(this.j.values());
            fragmentManagerState.h = new ArrayList<LaunchedFragmentInfo>((Collection<? extends LaunchedFragmentInfo>)this.G);
            bundle.putParcelable("state", (Parcelable)fragmentManagerState);
            for (final String s : this.k.keySet()) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("result_");
                sb2.append(s);
                bundle.putBundle(sb2.toString(), (Bundle)this.k.get(s));
            }
            for (final FragmentState fragmentState : m) {
                final Bundle bundle2 = new Bundle();
                bundle2.putParcelable("state", (Parcelable)fragmentState);
                final StringBuilder sb3 = new StringBuilder();
                sb3.append("fragment_");
                sb3.append(fragmentState.b);
                bundle.putBundle(sb3.toString(), bundle2);
            }
        }
        return bundle;
    }
    
    void B() {
        this.I = false;
        this.J = false;
        this.P.t(false);
        this.V(0);
    }
    
    LayoutInflater$Factory2 B0() {
        return (LayoutInflater$Factory2)this.f;
    }
    
    public void B1(final String s) {
        this.b0((o)new r(s), false);
    }
    
    void C(final Configuration configuration) {
        for (final Fragment fragment : this.c.o()) {
            if (fragment != null) {
                fragment.performConfigurationChanged(configuration);
            }
        }
    }
    
    androidx.fragment.app.q C0() {
        return this.n;
    }
    
    boolean C1(final ArrayList<a> list, final ArrayList<Boolean> list2, final String s) {
        final int i0 = this.i0(s, -1, true);
        if (i0 < 0) {
            return false;
        }
        for (int j = i0; j < this.d.size(); ++j) {
            final a a = this.d.get(j);
            if (!a.r) {
                final StringBuilder sb = new StringBuilder();
                sb.append("saveBackStack(\"");
                sb.append(s);
                sb.append("\") included FragmentTransactions must use setReorderingAllowed(true) to ensure that the back stack can be restored as an atomic operation. Found ");
                sb.append(a);
                sb.append(" that did not use setReorderingAllowed(true).");
                this.N1(new IllegalArgumentException(sb.toString()));
            }
        }
        final HashSet<Fragment> set = new HashSet<Fragment>();
        for (int k = i0; k < this.d.size(); ++k) {
            final a a2 = this.d.get(k);
            final HashSet<Fragment> set2 = new HashSet<Fragment>();
            final HashSet<Fragment> set3 = new HashSet<Fragment>();
            for (final c0.a a3 : a2.c) {
                final Fragment b = a3.b;
                if (b == null) {
                    continue;
                }
                Label_0281: {
                    if (a3.c) {
                        final int a4 = a3.a;
                        if (a4 != 1 && a4 != 2 && a4 != 8) {
                            break Label_0281;
                        }
                    }
                    set.add(b);
                    set2.add(b);
                }
                final int a5 = a3.a;
                if (a5 != 1 && a5 != 2) {
                    continue;
                }
                set3.add(b);
            }
            set2.removeAll(set3);
            if (!set2.isEmpty()) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("saveBackStack(\"");
                sb2.append(s);
                sb2.append("\") must be self contained and not reference fragments from non-saved FragmentTransactions. Found reference to fragment");
                String s2;
                if (set2.size() == 1) {
                    final StringBuilder sb3 = new StringBuilder();
                    sb3.append(" ");
                    sb3.append(set2.iterator().next());
                    s2 = sb3.toString();
                }
                else {
                    final StringBuilder sb4 = new StringBuilder();
                    sb4.append("s ");
                    sb4.append(set2);
                    s2 = sb4.toString();
                }
                sb2.append(s2);
                sb2.append(" in ");
                sb2.append(a2);
                sb2.append(" that were previously added to the FragmentManager through a separate FragmentTransaction.");
                this.N1(new IllegalArgumentException(sb2.toString()));
            }
        }
        final ArrayDeque arrayDeque = new ArrayDeque(set);
        while (!arrayDeque.isEmpty()) {
            final Fragment fragment = (Fragment)arrayDeque.removeFirst();
            if (fragment.mRetainInstance) {
                final StringBuilder sb5 = new StringBuilder();
                sb5.append("saveBackStack(\"");
                sb5.append(s);
                sb5.append("\") must not contain retained fragments. Found ");
                String s3;
                if (set.contains(fragment)) {
                    s3 = "direct reference to retained ";
                }
                else {
                    s3 = "retained child ";
                }
                sb5.append(s3);
                sb5.append("fragment ");
                sb5.append(fragment);
                this.N1(new IllegalArgumentException(sb5.toString()));
            }
            for (final Fragment fragment2 : fragment.mChildFragmentManager.q0()) {
                if (fragment2 != null) {
                    arrayDeque.addLast((Object)fragment2);
                }
            }
        }
        final ArrayList<String> list3 = new ArrayList<String>();
        final Iterator<Fragment> iterator3 = set.iterator();
        while (iterator3.hasNext()) {
            list3.add(iterator3.next().mWho);
        }
        final ArrayList list4 = new ArrayList<BackStackRecordState>(this.d.size() - i0);
        for (int l = i0; l < this.d.size(); ++l) {
            list4.add(null);
        }
        final BackStackState backStackState = new BackStackState(list3, (List<BackStackRecordState>)list4);
        for (int n = this.d.size() - 1; n >= i0; --n) {
            final a a6 = this.d.remove(n);
            final a a7 = new a(a6);
            a7.z();
            list4.set(n - i0, new BackStackRecordState(a7));
            a6.w = true;
            list.add(a6);
            list2.add(Boolean.TRUE);
        }
        this.j.put(s, backStackState);
        return true;
    }
    
    boolean D(final MenuItem menuItem) {
        if (this.u < 1) {
            return false;
        }
        for (final Fragment fragment : this.c.o()) {
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }
    
    Fragment D0() {
        return this.x;
    }
    
    public Fragment.SavedState D1(final Fragment fragment) {
        final a0 n = this.c.n(fragment.mWho);
        if (n == null || !n.k().equals(fragment)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Fragment ");
            sb.append(fragment);
            sb.append(" is not currently in the FragmentManager");
            this.N1(new IllegalStateException(sb.toString()));
        }
        return n.r();
    }
    
    void E() {
        this.I = false;
        this.J = false;
        this.P.t(false);
        this.V(1);
    }
    
    public Fragment E0() {
        return this.y;
    }
    
    void E1() {
        synchronized (this.a) {
            final int size = this.a.size();
            boolean b = true;
            if (size != 1) {
                b = false;
            }
            if (b) {
                this.v.g().removeCallbacks(this.R);
                this.v.g().post(this.R);
                this.P1();
            }
        }
    }
    
    boolean F(final Menu menu, final MenuInflater menuInflater) {
        final int u = this.u;
        int i = 0;
        if (u < 1) {
            return false;
        }
        ArrayList e = null;
        final Iterator<Fragment> iterator = this.c.o().iterator();
        boolean b = false;
        while (iterator.hasNext()) {
            final Fragment fragment = iterator.next();
            if (fragment != null && this.Q0(fragment) && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                ArrayList list;
                if ((list = e) == null) {
                    list = new ArrayList();
                }
                list.add(fragment);
                b = true;
                e = list;
            }
        }
        if (this.e != null) {
            while (i < this.e.size()) {
                final Fragment fragment2 = this.e.get(i);
                if (e == null || !e.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
                ++i;
            }
        }
        this.e = e;
        return b;
    }
    
    i0 F0() {
        final i0 b = this.B;
        if (b != null) {
            return b;
        }
        final Fragment x = this.x;
        if (x != null) {
            return x.mFragmentManager.F0();
        }
        return this.C;
    }
    
    void F1(final Fragment fragment, final boolean b) {
        final ViewGroup w0 = this.w0(fragment);
        if (w0 != null && w0 instanceof FragmentContainerView) {
            ((FragmentContainerView)w0).setDrawDisappearingViewsLast(b ^ true);
        }
    }
    
    void G() {
        this.d0(this.K = true);
        this.a0();
        this.u();
        this.V(-1);
        final androidx.fragment.app.m<?> v = this.v;
        if (v instanceof c) {
            ((c)v).removeOnTrimMemoryListener(this.q);
        }
        final androidx.fragment.app.m<?> v2 = this.v;
        if (v2 instanceof androidx.core.content.b) {
            ((androidx.core.content.b)v2).removeOnConfigurationChangedListener(this.p);
        }
        final androidx.fragment.app.m<?> v3 = this.v;
        if (v3 instanceof androidx.core.app.p) {
            ((androidx.core.app.p)v3).removeOnMultiWindowModeChangedListener(this.r);
        }
        final androidx.fragment.app.m<?> v4 = this.v;
        if (v4 instanceof androidx.core.app.q) {
            ((androidx.core.app.q)v4).removeOnPictureInPictureModeChangedListener(this.s);
        }
        final androidx.fragment.app.m<?> v5 = this.v;
        if (v5 instanceof androidx.core.view.j) {
            ((androidx.core.view.j)v5).removeMenuProvider(this.t);
        }
        this.v = null;
        this.w = null;
        this.x = null;
        if (this.g != null) {
            this.h.remove();
            this.g = null;
        }
        final b<Intent> d = this.D;
        if (d != null) {
            d.c();
            this.E.c();
            this.F.c();
        }
    }
    
    public FragmentStrictMode.b G0() {
        return this.Q;
    }
    
    public final void G1(final String s, final Bundle bundle) {
        final m m = this.l.get(s);
        if (m != null && m.b(Lifecycle.State.STARTED)) {
            m.a(s, bundle);
        }
        else {
            this.k.put(s, bundle);
        }
        if (N0(2)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Setting fragment result with key ");
            sb.append(s);
            sb.append(" and result ");
            sb.append(bundle);
            Log.v("FragmentManager", sb.toString());
        }
    }
    
    void H() {
        this.V(1);
    }
    
    public final void H1(final String s, final androidx.lifecycle.r r, final z z) {
        final Lifecycle lifecycle = r.getLifecycle();
        if (lifecycle.b() == Lifecycle.State.DESTROYED) {
            return;
        }
        final androidx.lifecycle.o o = new androidx.lifecycle.o(this, s, z, lifecycle) {
            final String a;
            final z b;
            final Lifecycle c;
            final FragmentManager d;
            
            @Override
            public void f(final androidx.lifecycle.r r, final Lifecycle.Event event) {
                if (event == Lifecycle.Event.ON_START) {
                    final Bundle bundle = FragmentManager.f(this.d).get(this.a);
                    if (bundle != null) {
                        this.b.a(this.a, bundle);
                        this.d.v(this.a);
                    }
                }
                if (event == Lifecycle.Event.ON_DESTROY) {
                    this.c.c(this);
                    FragmentManager.g(this.d).remove(this.a);
                }
            }
        };
        lifecycle.a(o);
        final m m = this.l.put(s, new m(lifecycle, z, o));
        if (m != null) {
            m.c();
        }
        if (N0(2)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Setting FragmentResultListener with key ");
            sb.append(s);
            sb.append(" lifecycleOwner ");
            sb.append(lifecycle);
            sb.append(" and listener ");
            sb.append(z);
            Log.v("FragmentManager", sb.toString());
        }
    }
    
    void I() {
        for (final Fragment fragment : this.c.o()) {
            if (fragment != null) {
                fragment.performLowMemory();
            }
        }
    }
    
    q0 I0(final Fragment fragment) {
        return this.P.q(fragment);
    }
    
    void I1(final Fragment fragment, final Lifecycle.State mMaxState) {
        if (fragment.equals(this.h0(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this)) {
            fragment.mMaxState = mMaxState;
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(fragment);
        sb.append(" is not an active fragment of FragmentManager ");
        sb.append(this);
        throw new IllegalArgumentException(sb.toString());
    }
    
    void J(final boolean b) {
        for (final Fragment fragment : this.c.o()) {
            if (fragment != null) {
                fragment.performMultiWindowModeChanged(b);
            }
        }
    }
    
    void J0() {
        this.d0(true);
        if (this.h.isEnabled()) {
            this.j1();
        }
        else {
            this.g.d();
        }
    }
    
    void J1(final Fragment y) {
        Label_0085: {
            if (y != null) {
                if (y.equals(this.h0(y.mWho))) {
                    if (y.mHost == null) {
                        break Label_0085;
                    }
                    if (y.mFragmentManager == this) {
                        break Label_0085;
                    }
                }
                final StringBuilder sb = new StringBuilder();
                sb.append("Fragment ");
                sb.append(y);
                sb.append(" is not an active fragment of FragmentManager ");
                sb.append(this);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        final Fragment y2 = this.y;
        this.y = y;
        this.O(y2);
        this.O(this.y);
    }
    
    void K(final Fragment fragment) {
        final Iterator<y> iterator = this.o.iterator();
        while (iterator.hasNext()) {
            iterator.next().a(this, fragment);
        }
    }
    
    void K0(final Fragment fragment) {
        if (N0(2)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("hide: ");
            sb.append(fragment);
            Log.v("FragmentManager", sb.toString());
        }
        if (!fragment.mHidden) {
            fragment.mHidden = true;
            fragment.mHiddenChanged ^= true;
            this.K1(fragment);
        }
    }
    
    void L() {
        for (final Fragment fragment : this.c.l()) {
            if (fragment != null) {
                fragment.onHiddenChanged(fragment.isHidden());
                fragment.mChildFragmentManager.L();
            }
        }
    }
    
    void L0(final Fragment fragment) {
        if (fragment.mAdded && this.O0(fragment)) {
            this.H = true;
        }
    }
    
    void L1(final Fragment fragment) {
        if (N0(2)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("show: ");
            sb.append(fragment);
            Log.v("FragmentManager", sb.toString());
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged ^= true;
        }
    }
    
    boolean M(final MenuItem menuItem) {
        if (this.u < 1) {
            return false;
        }
        for (final Fragment fragment : this.c.o()) {
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean M0() {
        return this.K;
    }
    
    void N(final Menu menu) {
        if (this.u < 1) {
            return;
        }
        for (final Fragment fragment : this.c.o()) {
            if (fragment != null) {
                fragment.performOptionsMenuClosed(menu);
            }
        }
    }
    
    public void O1(final l l) {
        this.n.p(l);
    }
    
    void P() {
        this.V(5);
    }
    
    boolean P0(final Fragment fragment) {
        return fragment != null && fragment.isHidden();
    }
    
    void Q(final boolean b) {
        for (final Fragment fragment : this.c.o()) {
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged(b);
            }
        }
    }
    
    boolean Q0(final Fragment fragment) {
        return fragment == null || fragment.isMenuVisible();
    }
    
    boolean R(final Menu menu) {
        final int u = this.u;
        boolean b = false;
        if (u < 1) {
            return false;
        }
        for (final Fragment fragment : this.c.o()) {
            if (fragment != null && this.Q0(fragment) && fragment.performPrepareOptionsMenu(menu)) {
                b = true;
            }
        }
        return b;
    }
    
    boolean R0(final Fragment fragment) {
        boolean b = true;
        if (fragment == null) {
            return true;
        }
        final FragmentManager mFragmentManager = fragment.mFragmentManager;
        if (!fragment.equals(mFragmentManager.E0()) || !this.R0(mFragmentManager.x)) {
            b = false;
        }
        return b;
    }
    
    void S() {
        this.P1();
        this.O(this.y);
    }
    
    boolean S0(final int n) {
        return this.u >= n;
    }
    
    void T() {
        this.I = false;
        this.J = false;
        this.P.t(false);
        this.V(7);
    }
    
    public boolean T0() {
        return this.I || this.J;
    }
    
    void U() {
        this.I = false;
        this.J = false;
        this.P.t(false);
        this.V(5);
    }
    
    void W() {
        this.J = true;
        this.P.t(true);
        this.V(4);
    }
    
    void X() {
        this.V(2);
    }
    
    public void Z(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
        final StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.append("    ");
        final String string = sb.toString();
        this.c.e(s, fileDescriptor, printWriter, array);
        final ArrayList<Fragment> e = this.e;
        final int n = 0;
        if (e != null) {
            final int size = e.size();
            if (size > 0) {
                printWriter.print(s);
                printWriter.println("Fragments Created Menus:");
                for (int i = 0; i < size; ++i) {
                    final Fragment fragment = this.e.get(i);
                    printWriter.print(s);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment.toString());
                }
            }
        }
        final ArrayList<a> d = this.d;
        if (d != null) {
            final int size2 = d.size();
            if (size2 > 0) {
                printWriter.print(s);
                printWriter.println("Back Stack:");
                for (int j = 0; j < size2; ++j) {
                    final a a = this.d.get(j);
                    printWriter.print(s);
                    printWriter.print("  #");
                    printWriter.print(j);
                    printWriter.print(": ");
                    printWriter.println(a.toString());
                    a.B(string, printWriter);
                }
            }
        }
        printWriter.print(s);
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("Back Stack Index: ");
        sb2.append(this.i.get());
        printWriter.println(sb2.toString());
        synchronized (this.a) {
            final int size3 = this.a.size();
            if (size3 > 0) {
                printWriter.print(s);
                printWriter.println("Pending Actions:");
                for (int k = n; k < size3; ++k) {
                    final o o = this.a.get(k);
                    printWriter.print(s);
                    printWriter.print("  #");
                    printWriter.print(k);
                    printWriter.print(": ");
                    printWriter.println(o);
                }
            }
            monitorexit(this.a);
            printWriter.print(s);
            printWriter.println("FragmentManager misc state:");
            printWriter.print(s);
            printWriter.print("  mHost=");
            printWriter.println(this.v);
            printWriter.print(s);
            printWriter.print("  mContainer=");
            printWriter.println(this.w);
            if (this.x != null) {
                printWriter.print(s);
                printWriter.print("  mParent=");
                printWriter.println(this.x);
            }
            printWriter.print(s);
            printWriter.print("  mCurState=");
            printWriter.print(this.u);
            printWriter.print(" mStateSaved=");
            printWriter.print(this.I);
            printWriter.print(" mStopped=");
            printWriter.print(this.J);
            printWriter.print(" mDestroyed=");
            printWriter.println(this.K);
            if (this.H) {
                printWriter.print(s);
                printWriter.print("  mNeedMenuInvalidate=");
                printWriter.println(this.H);
            }
        }
    }
    
    void Z0(final Fragment fragment, final String[] array, final int n) {
        if (this.F != null) {
            this.G.addLast(new LaunchedFragmentInfo(fragment.mWho, n));
            this.F.a(array);
        }
        else {
            this.v.k(fragment, array, n);
        }
    }
    
    void a1(final Fragment fragment, final Intent intent, final int n, final Bundle bundle) {
        if (this.D != null) {
            this.G.addLast(new LaunchedFragmentInfo(fragment.mWho, n));
            if (intent != null && bundle != null) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
            }
            this.D.a(intent);
        }
        else {
            this.v.m(fragment, intent, n, bundle);
        }
    }
    
    void b0(final o o, final boolean b) {
        if (!b) {
            if (this.v == null) {
                if (this.K) {
                    throw new IllegalStateException("FragmentManager has been destroyed");
                }
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            else {
                this.s();
            }
        }
        synchronized (this.a) {
            if (this.v != null) {
                this.a.add(o);
                this.E1();
                return;
            }
            if (b) {
                return;
            }
            throw new IllegalStateException("Activity has been destroyed");
        }
    }
    
    void b1(final Fragment fragment, final IntentSender intentSender, final int n, Intent intent, final int n2, final int n3, final int n4, final Bundle bundle) throws IntentSender$SendIntentException {
        if (this.E != null) {
            if (bundle != null) {
                if (intent == null) {
                    intent = new Intent();
                    intent.putExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", true);
                }
                if (N0(2)) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("ActivityOptions ");
                    sb.append(bundle);
                    sb.append(" were added to fillInIntent ");
                    sb.append(intent);
                    sb.append(" for fragment ");
                    sb.append(fragment);
                    Log.v("FragmentManager", sb.toString());
                }
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
            }
            final IntentSenderRequest a = new IntentSenderRequest.b(intentSender).b(intent).c(n3, n2).a();
            this.G.addLast(new LaunchedFragmentInfo(fragment.mWho, n));
            if (N0(2)) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("Fragment ");
                sb2.append(fragment);
                sb2.append("is launching an IntentSender for result ");
                Log.v("FragmentManager", sb2.toString());
            }
            this.E.a(a);
        }
        else {
            this.v.n(fragment, intentSender, n, intent, n2, n3, n4, bundle);
        }
    }
    
    void c1(final int u, final boolean b) {
        if (this.v == null && u != -1) {
            throw new IllegalStateException("No activity");
        }
        if (!b && u == this.u) {
            return;
        }
        this.u = u;
        this.c.t();
        this.M1();
        if (this.H) {
            final androidx.fragment.app.m<?> v = this.v;
            if (v != null && this.u == 7) {
                v.o();
                this.H = false;
            }
        }
    }
    
    boolean d0(boolean b) {
        this.c0(b);
        b = false;
        while (this.p0(this.M, this.N)) {
            this.b = true;
            try {
                this.t1(this.M, this.N);
                this.t();
                b = true;
                continue;
            }
            finally {
                this.t();
            }
            break;
        }
        this.P1();
        this.Y();
        this.c.b();
        return b;
    }
    
    void d1() {
        if (this.v == null) {
            return;
        }
        this.I = false;
        this.J = false;
        this.P.t(false);
        for (final Fragment fragment : this.c.o()) {
            if (fragment != null) {
                fragment.noteStateNotSaved();
            }
        }
    }
    
    void e0(final o o, final boolean b) {
        if (b && (this.v == null || this.K)) {
            return;
        }
        this.c0(b);
        if (o.a(this.M, this.N)) {
            this.b = true;
            try {
                this.t1(this.M, this.N);
            }
            finally {
                this.t();
            }
        }
        this.P1();
        this.Y();
        this.c.b();
    }
    
    void e1(final FragmentContainerView mContainer) {
        for (final a0 a0 : this.c.k()) {
            final Fragment k = a0.k();
            if (k.mContainerId == mContainer.getId()) {
                final View mView = k.mView;
                if (mView == null || mView.getParent() != null) {
                    continue;
                }
                k.mContainer = (ViewGroup)mContainer;
                a0.b();
            }
        }
    }
    
    void f1(final a0 a0) {
        final Fragment k = a0.k();
        if (k.mDeferStart) {
            if (this.b) {
                this.L = true;
                return;
            }
            k.mDeferStart = false;
            a0.m();
        }
    }
    
    public void g1() {
        this.b0((o)new p(null, -1, 0), false);
    }
    
    Fragment h0(final String s) {
        return this.c.f(s);
    }
    
    void h1(final int n, final int n2, final boolean b) {
        if (n >= 0) {
            this.b0((o)new p(null, n, n2), b);
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Bad id: ");
        sb.append(n);
        throw new IllegalArgumentException(sb.toString());
    }
    
    void i(final a a) {
        if (this.d == null) {
            this.d = new ArrayList<a>();
        }
        this.d.add(a);
    }
    
    public void i1(final String s, final int n) {
        this.b0((o)new p(s, -1, n), false);
    }
    
    a0 j(final Fragment fragment) {
        final String mPreviousWho = fragment.mPreviousWho;
        if (mPreviousWho != null) {
            FragmentStrictMode.h(fragment, mPreviousWho);
        }
        if (N0(2)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("add: ");
            sb.append(fragment);
            Log.v("FragmentManager", sb.toString());
        }
        final a0 y = this.y(fragment);
        fragment.mFragmentManager = this;
        this.c.r(y);
        if (!fragment.mDetached) {
            this.c.a(fragment);
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (this.O0(fragment)) {
                this.H = true;
            }
        }
        return y;
    }
    
    public Fragment j0(final int n) {
        return this.c.g(n);
    }
    
    public boolean j1() {
        return this.m1(null, -1, 0);
    }
    
    public void k(final y y) {
        this.o.add(y);
    }
    
    public Fragment k0(final String s) {
        return this.c.h(s);
    }
    
    public boolean k1(final int n, final int n2) {
        if (n >= 0) {
            return this.m1(null, n, n2);
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Bad id: ");
        sb.append(n);
        throw new IllegalArgumentException(sb.toString());
    }
    
    public void l(final n n) {
        if (this.m == null) {
            this.m = new ArrayList<n>();
        }
        this.m.add(n);
    }
    
    Fragment l0(final String s) {
        return this.c.i(s);
    }
    
    public boolean l1(final String s, final int n) {
        return this.m1(s, -1, n);
    }
    
    void m(final Fragment fragment) {
        this.P.h(fragment);
    }
    
    int n() {
        return this.i.getAndIncrement();
    }
    
    boolean n1(final ArrayList<a> list, final ArrayList<Boolean> list2, final String s, int i, int i2) {
        i2 = this.i0(s, i, (i2 & 0x1) != 0x0);
        if (i2 < 0) {
            return false;
        }
        for (i = this.d.size() - 1; i >= i2; --i) {
            list.add(this.d.remove(i));
            list2.add(Boolean.TRUE);
        }
        return true;
    }
    
    void o(final androidx.fragment.app.m<?> v, final androidx.fragment.app.j w, final Fragment x) {
        if (this.v == null) {
            this.v = v;
            this.w = w;
            if ((this.x = x) != null) {
                this.k(new y(this, x) {
                    final Fragment a;
                    final FragmentManager b;
                    
                    @Override
                    public void a(final FragmentManager fragmentManager, final Fragment fragment) {
                        this.a.onAttachFragment(fragment);
                    }
                });
            }
            else if (v instanceof y) {
                this.k((y)v);
            }
            if (this.x != null) {
                this.P1();
            }
            if (v instanceof androidx.activity.h) {
                Object o = v;
                final OnBackPressedDispatcher onBackPressedDispatcher = ((androidx.activity.h)o).getOnBackPressedDispatcher();
                this.g = onBackPressedDispatcher;
                if (x != null) {
                    o = x;
                }
                onBackPressedDispatcher.b((androidx.lifecycle.r)o, this.h);
            }
            if (x != null) {
                this.P = x.mFragmentManager.t0(x);
            }
            else if (v instanceof r0) {
                this.P = x.o(((r0)v).getViewModelStore());
            }
            else {
                this.P = new x(false);
            }
            this.P.t(this.T0());
            this.c.A(this.P);
            final androidx.fragment.app.m<?> v2 = this.v;
            if (v2 instanceof e && x == null) {
                final u0.c savedStateRegistry = ((e)v2).getSavedStateRegistry();
                savedStateRegistry.h("android:support:fragments", (u0.c.c)new v(this));
                final Bundle b = savedStateRegistry.b("android:support:fragments");
                if (b != null) {
                    this.y1((Parcelable)b);
                }
            }
            final androidx.fragment.app.m<?> v3 = this.v;
            if (v3 instanceof androidx.activity.result.c) {
                final ActivityResultRegistry activityResultRegistry = ((androidx.activity.result.c)v3).getActivityResultRegistry();
                String string;
                if (x != null) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append(x.mWho);
                    sb.append(":");
                    string = sb.toString();
                }
                else {
                    string = "";
                }
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("FragmentManager:");
                sb2.append(string);
                final String string2 = sb2.toString();
                final StringBuilder sb3 = new StringBuilder();
                sb3.append(string2);
                sb3.append("StartActivityForResult");
                this.D = activityResultRegistry.j(sb3.toString(), (c.a<Intent, Object>)new d(), (androidx.activity.result.a<Object>)new androidx.activity.result.a<ActivityResult>(this) {
                    final FragmentManager a;
                    
                    @Override
                    public /* bridge */ void a(final Object o) {
                        this.b((ActivityResult)o);
                    }
                    
                    public void b(final ActivityResult activityResult) {
                        final LaunchedFragmentInfo launchedFragmentInfo = this.a.G.pollFirst();
                        if (launchedFragmentInfo == null) {
                            final StringBuilder sb = new StringBuilder();
                            sb.append("No Activities were started for result for ");
                            sb.append(this);
                            Log.w("FragmentManager", sb.toString());
                            return;
                        }
                        final String a = launchedFragmentInfo.a;
                        final int b = launchedFragmentInfo.b;
                        final Fragment i = FragmentManager.h(this.a).i(a);
                        if (i == null) {
                            final StringBuilder sb2 = new StringBuilder();
                            sb2.append("Activity result delivered for unknown Fragment ");
                            sb2.append(a);
                            Log.w("FragmentManager", sb2.toString());
                            return;
                        }
                        i.onActivityResult(b, activityResult.b(), activityResult.a());
                    }
                });
                final StringBuilder sb4 = new StringBuilder();
                sb4.append(string2);
                sb4.append("StartIntentSenderForResult");
                this.E = activityResultRegistry.j(sb4.toString(), (c.a<IntentSenderRequest, Object>)new k(), (androidx.activity.result.a<Object>)new androidx.activity.result.a<ActivityResult>(this) {
                    final FragmentManager a;
                    
                    @Override
                    public /* bridge */ void a(final Object o) {
                        this.b((ActivityResult)o);
                    }
                    
                    public void b(final ActivityResult activityResult) {
                        final LaunchedFragmentInfo launchedFragmentInfo = this.a.G.pollFirst();
                        if (launchedFragmentInfo == null) {
                            final StringBuilder sb = new StringBuilder();
                            sb.append("No IntentSenders were started for ");
                            sb.append(this);
                            Log.w("FragmentManager", sb.toString());
                            return;
                        }
                        final String a = launchedFragmentInfo.a;
                        final int b = launchedFragmentInfo.b;
                        final Fragment i = FragmentManager.h(this.a).i(a);
                        if (i == null) {
                            final StringBuilder sb2 = new StringBuilder();
                            sb2.append("Intent Sender result delivered for unknown Fragment ");
                            sb2.append(a);
                            Log.w("FragmentManager", sb2.toString());
                            return;
                        }
                        i.onActivityResult(b, activityResult.b(), activityResult.a());
                    }
                });
                final StringBuilder sb5 = new StringBuilder();
                sb5.append(string2);
                sb5.append("RequestPermissions");
                this.F = activityResultRegistry.j(sb5.toString(), (c.a<String[], Object>)new c.b(), (androidx.activity.result.a<Object>)new androidx.activity.result.a<Map<String, Boolean>>(this) {
                    final FragmentManager a;
                    
                    @Override
                    public /* bridge */ void a(final Object o) {
                        this.b((Map<String, Boolean>)o);
                    }
                    
                    public void b(final Map<String, Boolean> map) {
                        final String[] array = map.keySet().toArray(new String[0]);
                        final ArrayList list = new ArrayList((Collection<? extends E>)map.values());
                        final int[] array2 = new int[list.size()];
                        for (int i = 0; i < list.size(); ++i) {
                            int n;
                            if (list.get(i)) {
                                n = 0;
                            }
                            else {
                                n = -1;
                            }
                            array2[i] = n;
                        }
                        final LaunchedFragmentInfo launchedFragmentInfo = this.a.G.pollFirst();
                        if (launchedFragmentInfo == null) {
                            final StringBuilder sb = new StringBuilder();
                            sb.append("No permissions were requested for ");
                            sb.append(this);
                            Log.w("FragmentManager", sb.toString());
                            return;
                        }
                        final String a = launchedFragmentInfo.a;
                        final int b = launchedFragmentInfo.b;
                        final Fragment j = FragmentManager.h(this.a).i(a);
                        if (j == null) {
                            final StringBuilder sb2 = new StringBuilder();
                            sb2.append("Permission request result delivered for unknown Fragment ");
                            sb2.append(a);
                            Log.w("FragmentManager", sb2.toString());
                            return;
                        }
                        j.onRequestPermissionsResult(b, array, array2);
                    }
                });
            }
            final androidx.fragment.app.m<?> v4 = this.v;
            if (v4 instanceof androidx.core.content.b) {
                ((androidx.core.content.b)v4).addOnConfigurationChangedListener(this.p);
            }
            final androidx.fragment.app.m<?> v5 = this.v;
            if (v5 instanceof c) {
                ((c)v5).addOnTrimMemoryListener(this.q);
            }
            final androidx.fragment.app.m<?> v6 = this.v;
            if (v6 instanceof androidx.core.app.p) {
                ((androidx.core.app.p)v6).addOnMultiWindowModeChangedListener(this.r);
            }
            final androidx.fragment.app.m<?> v7 = this.v;
            if (v7 instanceof androidx.core.app.q) {
                ((androidx.core.app.q)v7).addOnPictureInPictureModeChangedListener(this.s);
            }
            final androidx.fragment.app.m<?> v8 = this.v;
            if (v8 instanceof androidx.core.view.j && x == null) {
                ((androidx.core.view.j)v8).addMenuProvider(this.t);
            }
            return;
        }
        throw new IllegalStateException("Already attached");
    }
    
    public void o1(final Bundle bundle, final String s, final Fragment fragment) {
        if (fragment.mFragmentManager != this) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Fragment ");
            sb.append(fragment);
            sb.append(" is not currently in the FragmentManager");
            this.N1(new IllegalStateException(sb.toString()));
        }
        bundle.putString(s, fragment.mWho);
    }
    
    void p(final Fragment fragment) {
        if (N0(2)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("attach: ");
            sb.append(fragment);
            Log.v("FragmentManager", sb.toString());
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (!fragment.mAdded) {
                this.c.a(fragment);
                if (N0(2)) {
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("add from attach: ");
                    sb2.append(fragment);
                    Log.v("FragmentManager", sb2.toString());
                }
                if (this.O0(fragment)) {
                    this.H = true;
                }
            }
        }
    }
    
    public void p1(final l l, final boolean b) {
        this.n.o(l, b);
    }
    
    public c0 q() {
        return new a(this);
    }
    
    List<Fragment> q0() {
        return this.c.l();
    }
    
    void q1(final Fragment fragment) {
        if (N0(2)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("remove: ");
            sb.append(fragment);
            sb.append(" nesting=");
            sb.append(fragment.mBackStackNesting);
            Log.v("FragmentManager", sb.toString());
        }
        final boolean inBackStack = fragment.isInBackStack();
        if (!fragment.mDetached || (inBackStack ^ true)) {
            this.c.u(fragment);
            if (this.O0(fragment)) {
                this.H = true;
            }
            fragment.mRemoving = true;
            this.K1(fragment);
        }
    }
    
    boolean r() {
        final Iterator<Fragment> iterator = this.c.l().iterator();
        int n = 0;
        while (iterator.hasNext()) {
            final Fragment fragment = iterator.next();
            int o0 = n;
            if (fragment != null) {
                o0 = (this.O0(fragment) ? 1 : 0);
            }
            if ((n = o0) != 0) {
                return true;
            }
        }
        return false;
    }
    
    public j r0(final int n) {
        return (j)this.d.get(n);
    }
    
    public void r1(final y y) {
        this.o.remove(y);
    }
    
    public int s0() {
        final ArrayList<a> d = this.d;
        int size;
        if (d != null) {
            size = d.size();
        }
        else {
            size = 0;
        }
        return size;
    }
    
    public void s1(final n n) {
        final ArrayList<n> m = this.m;
        if (m != null) {
            m.remove(n);
        }
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        final Fragment x = this.x;
        if (x != null) {
            sb.append(x.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.x)));
            sb.append("}");
        }
        else {
            final androidx.fragment.app.m<?> v = this.v;
            if (v != null) {
                sb.append(v.getClass().getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.v)));
                sb.append("}");
            }
            else {
                sb.append("null");
            }
        }
        sb.append("}}");
        return sb.toString();
    }
    
    androidx.fragment.app.j u0() {
        return this.w;
    }
    
    void u1(final Fragment fragment) {
        this.P.s(fragment);
    }
    
    public final void v(final String s) {
        this.k.remove(s);
        if (N0(2)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Clearing fragment result with key ");
            sb.append(s);
            Log.v("FragmentManager", sb.toString());
        }
    }
    
    public Fragment v0(final Bundle bundle, final String s) {
        final String string = bundle.getString(s);
        if (string == null) {
            return null;
        }
        final Fragment h0 = this.h0(string);
        if (h0 == null) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Fragment no longer exists for key ");
            sb.append(s);
            sb.append(": unique id ");
            sb.append(string);
            this.N1(new IllegalStateException(sb.toString()));
        }
        return h0;
    }
    
    public void w1(final String s) {
        this.b0((o)new q(s), false);
    }
    
    public androidx.fragment.app.l x0() {
        final androidx.fragment.app.l z = this.z;
        if (z != null) {
            return z;
        }
        final Fragment x = this.x;
        if (x != null) {
            return x.mFragmentManager.x0();
        }
        return this.A;
    }
    
    boolean x1(final ArrayList<a> list, final ArrayList<Boolean> list2, final String s) {
        final BackStackState backStackState = this.j.remove(s);
        if (backStackState == null) {
            return false;
        }
        final HashMap hashMap = new HashMap();
        for (final a a : list) {
            if (a.w) {
                final Iterator<c0.a> iterator2 = a.c.iterator();
                while (iterator2.hasNext()) {
                    final Fragment b = ((c0.a)iterator2.next()).b;
                    if (b != null) {
                        hashMap.put(b.mWho, b);
                    }
                }
            }
        }
        final Iterator<a> iterator3 = backStackState.a(this, hashMap).iterator();
        boolean b2 = false;
    Label_0134:
        while (true) {
            b2 = false;
            while (iterator3.hasNext()) {
                if (!iterator3.next().a(list, list2) && !b2) {
                    continue Label_0134;
                }
                b2 = true;
            }
            break;
        }
        return b2;
    }
    
    a0 y(final Fragment fragment) {
        final a0 n = this.c.n(fragment.mWho);
        if (n != null) {
            return n;
        }
        final a0 a0 = new a0(this.n, this.c, fragment);
        a0.o(this.v.f().getClassLoader());
        a0.u(this.u);
        return a0;
    }
    
    b0 y0() {
        return this.c;
    }
    
    void y1(final Parcelable parcelable) {
        if (parcelable == null) {
            return;
        }
        final Bundle bundle = (Bundle)parcelable;
        for (final String s : bundle.keySet()) {
            if (s.startsWith("result_")) {
                final Bundle bundle2 = bundle.getBundle(s);
                if (bundle2 == null) {
                    continue;
                }
                bundle2.setClassLoader(this.v.f().getClassLoader());
                this.k.put(s.substring(7), bundle2);
            }
        }
        final ArrayList<FragmentState> list = new ArrayList<FragmentState>();
        for (final String s2 : bundle.keySet()) {
            if (s2.startsWith("fragment_")) {
                final Bundle bundle3 = bundle.getBundle(s2);
                if (bundle3 == null) {
                    continue;
                }
                bundle3.setClassLoader(this.v.f().getClassLoader());
                list.add((FragmentState)bundle3.getParcelable("state"));
            }
        }
        this.c.x(list);
        final FragmentManagerState fragmentManagerState = (FragmentManagerState)bundle.getParcelable("state");
        if (fragmentManagerState == null) {
            return;
        }
        this.c.v();
        final Iterator<String> iterator3 = fragmentManagerState.a.iterator();
        while (iterator3.hasNext()) {
            final FragmentState b = this.c.B(iterator3.next(), null);
            if (b != null) {
                final Fragment m = this.P.m(b.b);
                a0 a0;
                if (m != null) {
                    if (N0(2)) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("restoreSaveState: re-attaching retained ");
                        sb.append(m);
                        Log.v("FragmentManager", sb.toString());
                    }
                    a0 = new a0(this.n, this.c, m, b);
                }
                else {
                    a0 = new a0(this.n, this.c, this.v.f().getClassLoader(), this.x0(), b);
                }
                final Fragment k = a0.k();
                k.mFragmentManager = this;
                if (N0(2)) {
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("restoreSaveState: active (");
                    sb2.append(k.mWho);
                    sb2.append("): ");
                    sb2.append(k);
                    Log.v("FragmentManager", sb2.toString());
                }
                a0.o(this.v.f().getClassLoader());
                this.c.r(a0);
                a0.u(this.u);
            }
        }
        for (final Fragment fragment : this.P.p()) {
            if (!this.c.c(fragment.mWho)) {
                if (N0(2)) {
                    final StringBuilder sb3 = new StringBuilder();
                    sb3.append("Discarding retained Fragment ");
                    sb3.append(fragment);
                    sb3.append(" that was not found in the set of active Fragments ");
                    sb3.append(fragmentManagerState.a);
                    Log.v("FragmentManager", sb3.toString());
                }
                this.P.s(fragment);
                fragment.mFragmentManager = this;
                final a0 a2 = new a0(this.n, this.c, fragment);
                a2.u(1);
                a2.m();
                fragment.mRemoving = true;
                a2.m();
            }
        }
        this.c.w(fragmentManagerState.b);
        final BackStackRecordState[] c = fragmentManagerState.c;
        final int n = 0;
        if (c != null) {
            this.d = new ArrayList<a>(fragmentManagerState.c.length);
            int n2 = 0;
            while (true) {
                final BackStackRecordState[] c2 = fragmentManagerState.c;
                if (n2 >= c2.length) {
                    break;
                }
                final a b2 = c2[n2].b(this);
                if (N0(2)) {
                    final StringBuilder sb4 = new StringBuilder();
                    sb4.append("restoreAllState: back stack #");
                    sb4.append(n2);
                    sb4.append(" (index ");
                    sb4.append(b2.v);
                    sb4.append("): ");
                    sb4.append(b2);
                    Log.v("FragmentManager", sb4.toString());
                    final PrintWriter printWriter = new PrintWriter(new h0("FragmentManager"));
                    b2.C("  ", printWriter, false);
                    printWriter.close();
                }
                this.d.add(b2);
                ++n2;
            }
        }
        else {
            this.d = null;
        }
        this.i.set(fragmentManagerState.d);
        final String e = fragmentManagerState.e;
        if (e != null) {
            this.O(this.y = this.h0(e));
        }
        final ArrayList<String> f = fragmentManagerState.f;
        if (f != null) {
            for (int i = n; i < f.size(); ++i) {
                this.j.put((String)f.get(i), fragmentManagerState.g.get(i));
            }
        }
        this.G = new ArrayDeque<LaunchedFragmentInfo>(fragmentManagerState.h);
    }
    
    void z(final Fragment fragment) {
        if (N0(2)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("detach: ");
            sb.append(fragment);
            Log.v("FragmentManager", sb.toString());
        }
        if (!fragment.mDetached) {
            fragment.mDetached = true;
            if (fragment.mAdded) {
                if (N0(2)) {
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("remove from detach: ");
                    sb2.append(fragment);
                    Log.v("FragmentManager", sb2.toString());
                }
                this.c.u(fragment);
                if (this.O0(fragment)) {
                    this.H = true;
                }
                this.K1(fragment);
            }
        }
    }
    
    public List<Fragment> z0() {
        return this.c.o();
    }
    
    static class LaunchedFragmentInfo implements Parcelable
    {
        public static final Parcelable$Creator<LaunchedFragmentInfo> CREATOR;
        String a;
        int b;
        
        static {
            CREATOR = (Parcelable$Creator)new Parcelable$Creator<LaunchedFragmentInfo>() {
                public LaunchedFragmentInfo a(final Parcel parcel) {
                    return new LaunchedFragmentInfo(parcel);
                }
                
                public LaunchedFragmentInfo[] b(final int n) {
                    return new LaunchedFragmentInfo[n];
                }
                
                public /* bridge */ Object createFromParcel(final Parcel parcel) {
                    return this.a(parcel);
                }
                
                public /* bridge */ Object[] newArray(final int n) {
                    return this.b(n);
                }
            };
        }
        
        LaunchedFragmentInfo(final Parcel parcel) {
            this.a = parcel.readString();
            this.b = parcel.readInt();
        }
        
        LaunchedFragmentInfo(final String a, final int b) {
            this.a = a;
            this.b = b;
        }
        
        public int describeContents() {
            return 0;
        }
        
        public void writeToParcel(final Parcel parcel, final int n) {
            parcel.writeString(this.a);
            parcel.writeInt(this.b);
        }
    }
    
    public interface j
    {
        String getName();
    }
    
    static class k extends c.a<IntentSenderRequest, ActivityResult>
    {
        public Intent a(final Context context, final IntentSenderRequest intentSenderRequest) {
            final Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
            final Intent a = intentSenderRequest.a();
            IntentSenderRequest a2 = intentSenderRequest;
            if (a != null) {
                final Bundle bundleExtra = a.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                a2 = intentSenderRequest;
                if (bundleExtra != null) {
                    intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                    a.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                    a2 = intentSenderRequest;
                    if (a.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                        a2 = new IntentSenderRequest.b(intentSenderRequest.d()).b(null).c(intentSenderRequest.c(), intentSenderRequest.b()).a();
                    }
                }
            }
            intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", (Parcelable)a2);
            if (FragmentManager.N0(2)) {
                final StringBuilder sb = new StringBuilder();
                sb.append("CreateIntent created the following intent: ");
                sb.append(intent);
                Log.v("FragmentManager", sb.toString());
            }
            return intent;
        }
        
        public ActivityResult b(final int n, final Intent intent) {
            return new ActivityResult(n, intent);
        }
        
        @Override
        public /* bridge */ Intent createIntent(final Context context, final Object o) {
            return this.a(context, (IntentSenderRequest)o);
        }
        
        @Override
        public /* bridge */ Object parseResult(final int n, final Intent intent) {
            return this.b(n, intent);
        }
    }
    
    public abstract static class l
    {
        @Deprecated
        public void a(final FragmentManager fragmentManager, final Fragment fragment, final Bundle bundle) {
        }
        
        public void b(final FragmentManager fragmentManager, final Fragment fragment, final Context context) {
        }
        
        public void c(final FragmentManager fragmentManager, final Fragment fragment, final Bundle bundle) {
        }
        
        public void d(final FragmentManager fragmentManager, final Fragment fragment) {
        }
        
        public void e(final FragmentManager fragmentManager, final Fragment fragment) {
        }
        
        public void f(final FragmentManager fragmentManager, final Fragment fragment) {
        }
        
        public void g(final FragmentManager fragmentManager, final Fragment fragment, final Context context) {
        }
        
        public void h(final FragmentManager fragmentManager, final Fragment fragment, final Bundle bundle) {
        }
        
        public void i(final FragmentManager fragmentManager, final Fragment fragment) {
        }
        
        public void j(final FragmentManager fragmentManager, final Fragment fragment, final Bundle bundle) {
        }
        
        public void k(final FragmentManager fragmentManager, final Fragment fragment) {
        }
        
        public void l(final FragmentManager fragmentManager, final Fragment fragment) {
        }
        
        public void m(final FragmentManager fragmentManager, final Fragment fragment, final View view, final Bundle bundle) {
        }
        
        public void n(final FragmentManager fragmentManager, final Fragment fragment) {
        }
    }
    
    private static class m implements z
    {
        private final Lifecycle a;
        private final z b;
        private final androidx.lifecycle.o c;
        
        m(final Lifecycle a, final z b, final androidx.lifecycle.o c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        
        @Override
        public void a(final String s, final Bundle bundle) {
            this.b.a(s, bundle);
        }
        
        public boolean b(final Lifecycle.State state) {
            return this.a.b().isAtLeast(state);
        }
        
        public void c() {
            this.a.c(this.c);
        }
    }
    
    public interface n
    {
        void onBackStackChanged();
    }
    
    interface o
    {
        boolean a(final ArrayList<a> p0, final ArrayList<Boolean> p1);
    }
    
    private class p implements o
    {
        final String a;
        final int b;
        final int c;
        final FragmentManager d;
        
        p(final FragmentManager d, final String a, final int b, final int c) {
            this.d = d;
            this.a = a;
            this.b = b;
            this.c = c;
        }
        
        @Override
        public boolean a(final ArrayList<a> list, final ArrayList<Boolean> list2) {
            final Fragment y = this.d.y;
            return (y == null || this.b >= 0 || this.a != null || !y.getChildFragmentManager().j1()) && this.d.n1(list, list2, this.a, this.b, this.c);
        }
    }
    
    private class q implements o
    {
        private final String a;
        final FragmentManager b;
        
        q(final FragmentManager b, final String a) {
            this.b = b;
            this.a = a;
        }
        
        @Override
        public boolean a(final ArrayList<a> list, final ArrayList<Boolean> list2) {
            return this.b.x1(list, list2, this.a);
        }
    }
    
    private class r implements o
    {
        private final String a;
        final FragmentManager b;
        
        r(final FragmentManager b, final String a) {
            this.b = b;
            this.a = a;
        }
        
        @Override
        public boolean a(final ArrayList<a> list, final ArrayList<Boolean> list2) {
            return this.b.C1(list, list2, this.a);
        }
    }
}
