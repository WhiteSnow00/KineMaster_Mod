// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.view.menu;

import java.util.Collection;
import android.view.KeyCharacterMap$KeyData;
import android.view.KeyEvent;
import android.content.pm.ActivityInfo;
import java.util.List;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.Intent;
import android.content.ComponentName;
import androidx.core.view.b;
import android.view.SubMenu;
import android.view.MenuItem;
import android.util.SparseArray;
import android.os.Parcelable;
import android.os.Bundle;
import java.util.Iterator;
import androidx.core.view.d0;
import android.view.ViewConfiguration;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArrayList;
import android.view.View;
import android.graphics.drawable.Drawable;
import android.view.ContextMenu$ContextMenuInfo;
import java.util.ArrayList;
import android.content.res.Resources;
import android.content.Context;
import w.a;

public class g implements w.a
{
    private static final int[] A;
    private final Context a;
    private final Resources b;
    private boolean c;
    private boolean d;
    private a e;
    private ArrayList<i> f;
    private ArrayList<i> g;
    private boolean h;
    private ArrayList<i> i;
    private ArrayList<i> j;
    private boolean k;
    private int l;
    private ContextMenu$ContextMenuInfo m;
    CharSequence n;
    Drawable o;
    View p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private ArrayList<i> v;
    private CopyOnWriteArrayList<WeakReference<m>> w;
    private i x;
    private boolean y;
    private boolean z;
    
    static {
        A = new int[] { 1, 4, 5, 3, 2, 0 };
    }
    
    public g(final Context a) {
        this.l = 0;
        this.q = false;
        this.r = false;
        this.s = false;
        this.t = false;
        this.u = false;
        this.v = new ArrayList<i>();
        this.w = new CopyOnWriteArrayList<WeakReference<m>>();
        this.y = false;
        this.a = a;
        this.b = a.getResources();
        this.f = new ArrayList<i>();
        this.g = new ArrayList<i>();
        this.h = true;
        this.i = new ArrayList<i>();
        this.j = new ArrayList<i>();
        this.f0(this.k = true);
    }
    
    private static int D(final int n) {
        final int n2 = (0xFFFF0000 & n) >> 16;
        if (n2 >= 0) {
            final int[] a = g.A;
            if (n2 < a.length) {
                return (n & 0xFFFF) | a[n2] << 16;
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }
    
    private void P(final int n, final boolean b) {
        if (n >= 0) {
            if (n < this.f.size()) {
                this.f.remove(n);
                if (b) {
                    this.M(true);
                }
            }
        }
    }
    
    private void a0(final int n, final CharSequence n2, final int n3, final Drawable o, final View p5) {
        final Resources e = this.E();
        if (p5 != null) {
            this.p = p5;
            this.n = null;
            this.o = null;
        }
        else {
            if (n > 0) {
                this.n = e.getText(n);
            }
            else if (n2 != null) {
                this.n = n2;
            }
            if (n3 > 0) {
                this.o = androidx.core.content.a.getDrawable(this.w(), n3);
            }
            else if (o != null) {
                this.o = o;
            }
            this.p = null;
        }
        this.M(false);
    }
    
    private void f0(final boolean b) {
        final boolean b2 = true;
        this.d = (b && this.b.getConfiguration().keyboard != 1 && d0.c(ViewConfiguration.get(this.a), this.a) && b2);
    }
    
    private i g(final int n, final int n2, final int n3, final int n4, final CharSequence charSequence, final int n5) {
        return new i(this, n, n2, n3, n4, charSequence, n5);
    }
    
    private void i(final boolean b) {
        if (this.w.isEmpty()) {
            return;
        }
        this.h0();
        for (final WeakReference weakReference : this.w) {
            final m m = (m)weakReference.get();
            if (m == null) {
                this.w.remove(weakReference);
            }
            else {
                m.h(b);
            }
        }
        this.g0();
    }
    
    private void j(final Bundle bundle) {
        final SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:presenters");
        if (sparseParcelableArray != null) {
            if (!this.w.isEmpty()) {
                for (final WeakReference weakReference : this.w) {
                    final m m = (m)weakReference.get();
                    if (m == null) {
                        this.w.remove(weakReference);
                    }
                    else {
                        final int id = m.getId();
                        if (id <= 0) {
                            continue;
                        }
                        final Parcelable parcelable = (Parcelable)sparseParcelableArray.get(id);
                        if (parcelable == null) {
                            continue;
                        }
                        m.e(parcelable);
                    }
                }
            }
        }
    }
    
    private void k(final Bundle bundle) {
        if (this.w.isEmpty()) {
            return;
        }
        final SparseArray sparseArray = new SparseArray();
        for (final WeakReference weakReference : this.w) {
            final m m = (m)weakReference.get();
            if (m == null) {
                this.w.remove(weakReference);
            }
            else {
                final int id = m.getId();
                if (id <= 0) {
                    continue;
                }
                final Parcelable g = m.g();
                if (g == null) {
                    continue;
                }
                sparseArray.put(id, (Object)g);
            }
        }
        bundle.putSparseParcelableArray("android:menu:presenters", sparseArray);
    }
    
    private boolean l(final r r, final m m) {
        final boolean empty = this.w.isEmpty();
        boolean b = false;
        if (empty) {
            return false;
        }
        if (m != null) {
            b = m.f(r);
        }
        for (final WeakReference weakReference : this.w) {
            final m i = (m)weakReference.get();
            if (i == null) {
                this.w.remove(weakReference);
            }
            else {
                if (b) {
                    continue;
                }
                b = i.f(r);
            }
        }
        return b;
    }
    
    private static int p(final ArrayList<i> list, final int n) {
        for (int i = list.size() - 1; i >= 0; --i) {
            if (((i)list.get(i)).f() <= n) {
                return i + 1;
            }
        }
        return 0;
    }
    
    public View A() {
        return this.p;
    }
    
    public ArrayList<i> B() {
        this.t();
        return this.j;
    }
    
    boolean C() {
        return this.t;
    }
    
    Resources E() {
        return this.b;
    }
    
    public g F() {
        return this;
    }
    
    public ArrayList<i> G() {
        if (!this.h) {
            return this.g;
        }
        this.g.clear();
        for (int size = this.f.size(), i = 0; i < size; ++i) {
            final i j = this.f.get(i);
            if (j.isVisible()) {
                this.g.add(j);
            }
        }
        this.h = false;
        this.k = true;
        return this.g;
    }
    
    public boolean H() {
        return this.y;
    }
    
    boolean I() {
        return this.c;
    }
    
    public boolean J() {
        return this.d;
    }
    
    void K(final i i) {
        this.M(this.k = true);
    }
    
    void L(final i i) {
        this.M(this.h = true);
    }
    
    public void M(final boolean b) {
        if (!this.q) {
            if (b) {
                this.h = true;
                this.k = true;
            }
            this.i(b);
        }
        else {
            this.r = true;
            if (b) {
                this.s = true;
            }
        }
    }
    
    public boolean N(final MenuItem menuItem, final int n) {
        return this.O(menuItem, null, n);
    }
    
    public boolean O(final MenuItem menuItem, final m m, final int n) {
        final i i = (i)menuItem;
        if (i != null && i.isEnabled()) {
            final boolean k = i.k();
            final androidx.core.view.b a = i.a();
            final boolean b = a != null && a.a();
            boolean b3;
            if (i.j()) {
                final boolean b2 = b3 = (k | i.expandActionView());
                if (b2) {
                    this.e(true);
                    b3 = b2;
                }
            }
            else if (!i.hasSubMenu() && !b) {
                b3 = k;
                if ((n & 0x1) == 0x0) {
                    this.e(true);
                    b3 = k;
                }
            }
            else {
                if ((n & 0x4) == 0x0) {
                    this.e(false);
                }
                if (!i.hasSubMenu()) {
                    i.x(new r(this.w(), this, i));
                }
                final r r = (r)i.getSubMenu();
                if (b) {
                    a.f((SubMenu)r);
                }
                final boolean b4 = b3 = (k | this.l(r, m));
                if (!b4) {
                    this.e(true);
                    b3 = b4;
                }
            }
            return b3;
        }
        return false;
    }
    
    public void Q(final m m) {
        for (final WeakReference weakReference : this.w) {
            final m i = (m)weakReference.get();
            if (i == null || i == m) {
                this.w.remove(weakReference);
            }
        }
    }
    
    public void R(final Bundle bundle) {
        if (bundle == null) {
            return;
        }
        final SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(this.v());
        for (int size = this.size(), i = 0; i < size; ++i) {
            final MenuItem item = this.getItem(i);
            final View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((r)item.getSubMenu()).R(bundle);
            }
        }
        final int int1 = bundle.getInt("android:menu:expandedactionview");
        if (int1 > 0) {
            final MenuItem item2 = this.findItem(int1);
            if (item2 != null) {
                item2.expandActionView();
            }
        }
    }
    
    public void S(final Bundle bundle) {
        this.j(bundle);
    }
    
    public void T(final Bundle bundle) {
        final int size = this.size();
        SparseArray sparseArray = null;
        SparseArray sparseArray2;
        for (int i = 0; i < size; ++i, sparseArray = sparseArray2) {
            final MenuItem item = this.getItem(i);
            final View actionView = item.getActionView();
            sparseArray2 = sparseArray;
            if (actionView != null) {
                sparseArray2 = sparseArray;
                if (actionView.getId() != -1) {
                    SparseArray sparseArray3;
                    if ((sparseArray3 = sparseArray) == null) {
                        sparseArray3 = new SparseArray();
                    }
                    actionView.saveHierarchyState(sparseArray3);
                    sparseArray2 = sparseArray3;
                    if (item.isActionViewExpanded()) {
                        bundle.putInt("android:menu:expandedactionview", item.getItemId());
                        sparseArray2 = sparseArray3;
                    }
                }
            }
            if (item.hasSubMenu()) {
                ((r)item.getSubMenu()).T(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(this.v(), sparseArray);
        }
    }
    
    public void U(final Bundle bundle) {
        this.k(bundle);
    }
    
    public void V(final a e) {
        this.e = e;
    }
    
    public g W(final int l) {
        this.l = l;
        return this;
    }
    
    void X(final MenuItem menuItem) {
        final int groupId = menuItem.getGroupId();
        final int size = this.f.size();
        this.h0();
        for (int i = 0; i < size; ++i) {
            final i j = this.f.get(i);
            if (j.getGroupId() == groupId) {
                if (j.m()) {
                    if (j.isCheckable()) {
                        j.s(j == menuItem);
                    }
                }
            }
        }
        this.g0();
    }
    
    protected g Y(final int n) {
        this.a0(0, null, n, null, null);
        return this;
    }
    
    protected g Z(final Drawable drawable) {
        this.a0(0, null, 0, drawable, null);
        return this;
    }
    
    protected MenuItem a(final int n, final int n2, final int n3, final CharSequence charSequence) {
        final int d = D(n3);
        final i g = this.g(n, n2, n3, d, charSequence, this.l);
        final ContextMenu$ContextMenuInfo m = this.m;
        if (m != null) {
            g.v(m);
        }
        final ArrayList<i> f = this.f;
        f.add(p(f, d), g);
        this.M(true);
        return (MenuItem)g;
    }
    
    public MenuItem add(final int n) {
        return this.a(0, 0, 0, this.b.getString(n));
    }
    
    public MenuItem add(final int n, final int n2, final int n3, final int n4) {
        return this.a(n, n2, n3, this.b.getString(n4));
    }
    
    public MenuItem add(final int n, final int n2, final int n3, final CharSequence charSequence) {
        return this.a(n, n2, n3, charSequence);
    }
    
    public MenuItem add(final CharSequence charSequence) {
        return this.a(0, 0, 0, charSequence);
    }
    
    public int addIntentOptions(final int n, final int n2, final int n3, final ComponentName componentName, final Intent[] array, final Intent intent, int n4, final MenuItem[] array2) {
        final PackageManager packageManager = this.a.getPackageManager();
        final int n5 = 0;
        final List queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, array, intent, 0);
        int size;
        if (queryIntentActivityOptions != null) {
            size = queryIntentActivityOptions.size();
        }
        else {
            size = 0;
        }
        int i = n5;
        if ((n4 & 0x1) == 0x0) {
            this.removeGroup(n);
            i = n5;
        }
        while (i < size) {
            final ResolveInfo resolveInfo = queryIntentActivityOptions.get(i);
            n4 = resolveInfo.specificIndex;
            Intent intent2;
            if (n4 < 0) {
                intent2 = intent;
            }
            else {
                intent2 = array[n4];
            }
            final Intent intent3 = new Intent(intent2);
            final ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent3.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            final MenuItem setIntent = this.add(n, n2, n3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent3);
            if (array2 != null) {
                n4 = resolveInfo.specificIndex;
                if (n4 >= 0) {
                    array2[n4] = setIntent;
                }
            }
            ++i;
        }
        return size;
    }
    
    public SubMenu addSubMenu(final int n) {
        return this.addSubMenu(0, 0, 0, this.b.getString(n));
    }
    
    public SubMenu addSubMenu(final int n, final int n2, final int n3, final int n4) {
        return this.addSubMenu(n, n2, n3, this.b.getString(n4));
    }
    
    public SubMenu addSubMenu(final int n, final int n2, final int n3, final CharSequence charSequence) {
        final i i = (i)this.a(n, n2, n3, charSequence);
        final r r = new r(this.a, this, i);
        i.x(r);
        return (SubMenu)r;
    }
    
    public SubMenu addSubMenu(final CharSequence charSequence) {
        return this.addSubMenu(0, 0, 0, charSequence);
    }
    
    public void b(final m m) {
        this.c(m, this.a);
    }
    
    protected g b0(final int n) {
        this.a0(n, null, 0, null, null);
        return this;
    }
    
    public void c(final m m, final Context context) {
        this.w.add(new WeakReference<m>(m));
        m.k(context, this);
        this.k = true;
    }
    
    protected g c0(final CharSequence charSequence) {
        this.a0(0, charSequence, 0, null, null);
        return this;
    }
    
    public void clear() {
        final i x = this.x;
        if (x != null) {
            this.f(x);
        }
        this.f.clear();
        this.M(true);
    }
    
    public void clearHeader() {
        this.o = null;
        this.n = null;
        this.p = null;
        this.M(false);
    }
    
    public void close() {
        this.e(true);
    }
    
    public void d() {
        final a e = this.e;
        if (e != null) {
            e.b(this);
        }
    }
    
    protected g d0(final View view) {
        this.a0(0, null, 0, null, view);
        return this;
    }
    
    public final void e(final boolean b) {
        if (this.u) {
            return;
        }
        this.u = true;
        for (final WeakReference weakReference : this.w) {
            final m m = (m)weakReference.get();
            if (m == null) {
                this.w.remove(weakReference);
            }
            else {
                m.b(this, b);
            }
        }
        this.u = false;
    }
    
    public void e0(final boolean z) {
        this.z = z;
    }
    
    public boolean f(final i i) {
        final boolean empty = this.w.isEmpty();
        final boolean b = false;
        final int n = 0;
        boolean b2 = b;
        if (!empty) {
            if (this.x != i) {
                b2 = b;
            }
            else {
                this.h0();
                final Iterator<WeakReference<m>> iterator = this.w.iterator();
                boolean j = n != 0;
                boolean b3;
                while (true) {
                    b3 = j;
                    if (!iterator.hasNext()) {
                        break;
                    }
                    final WeakReference weakReference = iterator.next();
                    final m m = (m)weakReference.get();
                    if (m == null) {
                        this.w.remove(weakReference);
                    }
                    else {
                        b3 = (j = m.j(this, i));
                        if (b3) {
                            break;
                        }
                        continue;
                    }
                }
                this.g0();
                b2 = b3;
                if (b3) {
                    this.x = null;
                    b2 = b3;
                }
            }
        }
        return b2;
    }
    
    public MenuItem findItem(final int n) {
        for (int size = this.size(), i = 0; i < size; ++i) {
            final i j = this.f.get(i);
            if (j.getItemId() == n) {
                return (MenuItem)j;
            }
            if (j.hasSubMenu()) {
                final MenuItem item = j.getSubMenu().findItem(n);
                if (item != null) {
                    return item;
                }
            }
        }
        return null;
    }
    
    public void g0() {
        this.q = false;
        if (this.r) {
            this.r = false;
            this.M(this.s);
        }
    }
    
    public MenuItem getItem(final int n) {
        return (MenuItem)this.f.get(n);
    }
    
    boolean h(final g g, final MenuItem menuItem) {
        final a e = this.e;
        return e != null && e.a(g, menuItem);
    }
    
    public void h0() {
        if (!this.q) {
            this.q = true;
            this.r = false;
            this.s = false;
        }
    }
    
    public boolean hasVisibleItems() {
        if (this.z) {
            return true;
        }
        for (int size = this.size(), i = 0; i < size; ++i) {
            if (this.f.get(i).isVisible()) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isShortcutKey(final int n, final KeyEvent keyEvent) {
        return this.r(n, keyEvent) != null;
    }
    
    public boolean m(final i x) {
        final boolean empty = this.w.isEmpty();
        boolean c = false;
        if (empty) {
            return false;
        }
        this.h0();
        final Iterator<WeakReference<m>> iterator = this.w.iterator();
        boolean b;
        while (true) {
            b = c;
            if (!iterator.hasNext()) {
                break;
            }
            final WeakReference weakReference = iterator.next();
            final m m = (m)weakReference.get();
            if (m == null) {
                this.w.remove(weakReference);
            }
            else {
                b = (c = m.c(this, x));
                if (b) {
                    break;
                }
                continue;
            }
        }
        this.g0();
        if (b) {
            this.x = x;
        }
        return b;
    }
    
    public int n(final int n) {
        return this.o(n, 0);
    }
    
    public int o(final int n, final int n2) {
        final int size = this.size();
        int i = n2;
        if (n2 < 0) {
            i = 0;
        }
        while (i < size) {
            if (this.f.get(i).getGroupId() == n) {
                return i;
            }
            ++i;
        }
        return -1;
    }
    
    public boolean performIdentifierAction(final int n, final int n2) {
        return this.N(this.findItem(n), n2);
    }
    
    public boolean performShortcut(final int n, final KeyEvent keyEvent, final int n2) {
        final i r = this.r(n, keyEvent);
        final boolean b = r != null && this.N((MenuItem)r, n2);
        if ((n2 & 0x2) != 0x0) {
            this.e(true);
        }
        return b;
    }
    
    public int q(final int n) {
        for (int size = this.size(), i = 0; i < size; ++i) {
            if (this.f.get(i).getItemId() == n) {
                return i;
            }
        }
        return -1;
    }
    
    i r(final int n, final KeyEvent keyEvent) {
        final ArrayList<i> v = this.v;
        v.clear();
        this.s(v, n, keyEvent);
        if (v.isEmpty()) {
            return null;
        }
        final int metaState = keyEvent.getMetaState();
        final KeyCharacterMap$KeyData keyCharacterMap$KeyData = new KeyCharacterMap$KeyData();
        keyEvent.getKeyData(keyCharacterMap$KeyData);
        final int size = v.size();
        if (size == 1) {
            return (i)v.get(0);
        }
        final boolean i = this.I();
        for (int j = 0; j < size; ++j) {
            final i k = v.get(j);
            char c;
            if (i) {
                c = k.getAlphabeticShortcut();
            }
            else {
                c = k.getNumericShortcut();
            }
            final char[] meta = keyCharacterMap$KeyData.meta;
            if ((c == meta[0] && (metaState & 0x2) == 0x0) || (c == meta[2] && (metaState & 0x2) != 0x0) || (i && c == '\b' && n == 67)) {
                return k;
            }
        }
        return null;
    }
    
    public void removeGroup(final int n) {
        final int n2 = this.n(n);
        if (n2 >= 0) {
            for (int size = this.f.size(), n3 = 0; n3 < size - n2 && this.f.get(n2).getGroupId() == n; ++n3) {
                this.P(n2, false);
            }
            this.M(true);
        }
    }
    
    public void removeItem(final int n) {
        this.P(this.q(n), true);
    }
    
    void s(final List<i> list, final int n, final KeyEvent keyEvent) {
        final boolean i = this.I();
        final int modifiers = keyEvent.getModifiers();
        final KeyCharacterMap$KeyData keyCharacterMap$KeyData = new KeyCharacterMap$KeyData();
        if (!keyEvent.getKeyData(keyCharacterMap$KeyData) && n != 67) {
            return;
        }
        for (int size = this.f.size(), j = 0; j < size; ++j) {
            final i k = this.f.get(j);
            if (k.hasSubMenu()) {
                ((g)k.getSubMenu()).s(list, n, keyEvent);
            }
            char c;
            if (i) {
                c = k.getAlphabeticShortcut();
            }
            else {
                c = k.getNumericShortcut();
            }
            int n2;
            if (i) {
                n2 = k.getAlphabeticModifiers();
            }
            else {
                n2 = k.getNumericModifiers();
            }
            if ((modifiers & 0x1100F) == (n2 & 0x1100F) && c != '\0') {
                final char[] meta = keyCharacterMap$KeyData.meta;
                if ((c == meta[0] || c == meta[2] || (i && c == '\b' && n == 67)) && k.isEnabled()) {
                    list.add(k);
                }
            }
        }
    }
    
    public void setGroupCheckable(final int n, final boolean checkable, final boolean b) {
        for (int size = this.f.size(), i = 0; i < size; ++i) {
            final i j = this.f.get(i);
            if (j.getGroupId() == n) {
                j.t(b);
                j.setCheckable(checkable);
            }
        }
    }
    
    public void setGroupDividerEnabled(final boolean y) {
        this.y = y;
    }
    
    public void setGroupEnabled(final int n, final boolean enabled) {
        for (int size = this.f.size(), i = 0; i < size; ++i) {
            final i j = this.f.get(i);
            if (j.getGroupId() == n) {
                j.setEnabled(enabled);
            }
        }
    }
    
    public void setGroupVisible(final int n, final boolean b) {
        final int size = this.f.size();
        int i = 0;
        int n2 = 0;
        while (i < size) {
            final i j = this.f.get(i);
            int n3 = n2;
            if (j.getGroupId() == n) {
                n3 = n2;
                if (j.y(b)) {
                    n3 = 1;
                }
            }
            ++i;
            n2 = n3;
        }
        if (n2 != 0) {
            this.M(true);
        }
    }
    
    public void setQwertyMode(final boolean c) {
        this.c = c;
        this.M(false);
    }
    
    public int size() {
        return this.f.size();
    }
    
    public void t() {
        final ArrayList<i> g = this.G();
        if (!this.k) {
            return;
        }
        final Iterator<WeakReference<m>> iterator = this.w.iterator();
        boolean b = false;
        while (iterator.hasNext()) {
            final WeakReference weakReference = iterator.next();
            final m m = (m)weakReference.get();
            if (m == null) {
                this.w.remove(weakReference);
            }
            else {
                b |= m.i();
            }
        }
        if (b) {
            this.i.clear();
            this.j.clear();
            for (int size = g.size(), i = 0; i < size; ++i) {
                final i j = g.get(i);
                if (j.l()) {
                    this.i.add(j);
                }
                else {
                    this.j.add(j);
                }
            }
        }
        else {
            this.i.clear();
            this.j.clear();
            this.j.addAll(this.G());
        }
        this.k = false;
    }
    
    public ArrayList<i> u() {
        this.t();
        return this.i;
    }
    
    protected String v() {
        return "android:menu:actionviewstates";
    }
    
    public Context w() {
        return this.a;
    }
    
    public i x() {
        return this.x;
    }
    
    public Drawable y() {
        return this.o;
    }
    
    public CharSequence z() {
        return this.n;
    }
    
    public interface a
    {
        boolean a(final g p0, final MenuItem p1);
        
        void b(final g p0);
    }
    
    public interface b
    {
        boolean d(final i p0);
    }
}
