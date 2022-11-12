// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.view;

import androidx.appcompat.widget.a0;
import androidx.appcompat.widget.r0;
import android.content.res.TypedArray;
import android.view.SubMenu;
import androidx.core.view.n;
import android.view.View;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.i;
import java.lang.reflect.Constructor;
import android.util.Log;
import android.graphics.PorterDuff$Mode;
import android.content.res.ColorStateList;
import android.view.InflateException;
import android.view.MenuItem;
import java.lang.reflect.Method;
import android.view.MenuItem$OnMenuItemClickListener;
import android.content.res.XmlResourceParser;
import android.util.Xml;
import w.a;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;
import androidx.core.view.b;
import android.view.Menu;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;
import android.content.ContextWrapper;
import android.app.Activity;
import android.content.Context;
import android.view.MenuInflater;

public class g extends MenuInflater
{
    static final Class<?>[] e;
    static final Class<?>[] f;
    final Object[] a;
    final Object[] b;
    Context c;
    private Object d;
    
    static {
        f = (e = new Class[] { Context.class });
    }
    
    public g(final Context c) {
        super(c);
        this.c = c;
        final Object[] array = { c };
        this.a = array;
        this.b = array;
    }
    
    private Object a(final Object o) {
        if (o instanceof Activity) {
            return o;
        }
        Object a = o;
        if (o instanceof ContextWrapper) {
            a = this.a(((ContextWrapper)o).getBaseContext());
        }
        return a;
    }
    
    private void c(final XmlPullParser xmlPullParser, final AttributeSet set, final Menu menu) throws XmlPullParserException, IOException {
        final b b = new b(menu);
        int i = xmlPullParser.getEventType();
        String name3;
        while (true) {
            while (i != 2) {
                final int next = xmlPullParser.next();
                if ((i = next) == 1) {
                    int next2 = next;
                    String s = null;
                    int j = 0;
                    int n = 0;
                    while (j == 0) {
                        if (next2 == 1) {
                            throw new RuntimeException("Unexpected end of document");
                        }
                        int n2;
                        int n3;
                        String name;
                        if (next2 != 2) {
                            if (next2 != 3) {
                                n2 = j;
                                n3 = n;
                                name = s;
                            }
                            else {
                                final String name2 = xmlPullParser.getName();
                                if (n != 0 && name2.equals(s)) {
                                    name = null;
                                    n3 = 0;
                                    n2 = j;
                                }
                                else if (name2.equals("group")) {
                                    b.h();
                                    n2 = j;
                                    n3 = n;
                                    name = s;
                                }
                                else if (name2.equals("item")) {
                                    n2 = j;
                                    n3 = n;
                                    name = s;
                                    if (!b.d()) {
                                        final androidx.core.view.b a = b.A;
                                        if (a != null && a.a()) {
                                            b.b();
                                            n2 = j;
                                            n3 = n;
                                            name = s;
                                        }
                                        else {
                                            b.a();
                                            n2 = j;
                                            n3 = n;
                                            name = s;
                                        }
                                    }
                                }
                                else {
                                    n2 = j;
                                    n3 = n;
                                    name = s;
                                    if (name2.equals("menu")) {
                                        n2 = 1;
                                        n3 = n;
                                        name = s;
                                    }
                                }
                            }
                        }
                        else if (n != 0) {
                            n2 = j;
                            n3 = n;
                            name = s;
                        }
                        else {
                            name = xmlPullParser.getName();
                            if (name.equals("group")) {
                                b.f(set);
                                n2 = j;
                                n3 = n;
                                name = s;
                            }
                            else if (name.equals("item")) {
                                b.g(set);
                                n2 = j;
                                n3 = n;
                                name = s;
                            }
                            else if (name.equals("menu")) {
                                this.c(xmlPullParser, set, (Menu)b.b());
                                n2 = j;
                                n3 = n;
                                name = s;
                            }
                            else {
                                n3 = 1;
                                n2 = j;
                            }
                        }
                        final int next3 = xmlPullParser.next();
                        j = n2;
                        n = n3;
                        s = name;
                        next2 = next3;
                    }
                    return;
                }
            }
            name3 = xmlPullParser.getName();
            if (name3.equals("menu")) {
                final int next2 = xmlPullParser.next();
                continue;
            }
            break;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Expecting menu, got ");
        sb.append(name3);
        throw new RuntimeException(sb.toString());
    }
    
    Object b() {
        if (this.d == null) {
            this.d = this.a(this.c);
        }
        return this.d;
    }
    
    public void inflate(final int n, final Menu menu) {
        if (!(menu instanceof w.a)) {
            super.inflate(n, menu);
            return;
        }
        XmlResourceParser layout = null;
        try {
            try {
                final XmlResourceParser xmlResourceParser = layout = this.c.getResources().getLayout(n);
                this.c((XmlPullParser)xmlResourceParser, Xml.asAttributeSet((XmlPullParser)xmlResourceParser), menu);
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
            }
            finally {
                if (layout != null) {
                    layout.close();
                }
            }
        }
        catch (final IOException ex) {}
        catch (final XmlPullParserException ex2) {}
    }
    
    private static class a implements MenuItem$OnMenuItemClickListener
    {
        private static final Class<?>[] c;
        private Object a;
        private Method b;
        
        static {
            c = new Class[] { MenuItem.class };
        }
        
        public a(final Object a, final String s) {
            this.a = a;
            final Class<?> class1 = a.getClass();
            try {
                this.b = class1.getMethod(s, a.c);
            }
            catch (final Exception ex) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Couldn't resolve menu item onClick handler ");
                sb.append(s);
                sb.append(" in class ");
                sb.append(class1.getName());
                final InflateException ex2 = new InflateException(sb.toString());
                ex2.initCause((Throwable)ex);
                throw ex2;
            }
        }
        
        public boolean onMenuItemClick(final MenuItem menuItem) {
            try {
                if (this.b.getReturnType() == Boolean.TYPE) {
                    return (boolean)this.b.invoke(this.a, menuItem);
                }
                this.b.invoke(this.a, menuItem);
                return true;
            }
            catch (final Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }
    
    private class b
    {
        androidx.core.view.b A;
        private CharSequence B;
        private CharSequence C;
        private ColorStateList D;
        private PorterDuff$Mode E;
        final g F;
        private Menu a;
        private int b;
        private int c;
        private int d;
        private int e;
        private boolean f;
        private boolean g;
        private boolean h;
        private int i;
        private int j;
        private CharSequence k;
        private CharSequence l;
        private int m;
        private char n;
        private int o;
        private char p;
        private int q;
        private int r;
        private boolean s;
        private boolean t;
        private boolean u;
        private int v;
        private int w;
        private String x;
        private String y;
        private String z;
        
        public b(final g f, final Menu a) {
            this.F = f;
            this.D = null;
            this.E = null;
            this.a = a;
            this.h();
        }
        
        private char c(final String s) {
            if (s == null) {
                return '\0';
            }
            return s.charAt(0);
        }
        
        private <T> T e(final String s, final Class<?>[] array, final Object[] array2) {
            try {
                final Constructor<?> constructor = Class.forName(s, false, this.F.c.getClassLoader()).getConstructor(array);
                constructor.setAccessible(true);
                return (T)constructor.newInstance(array2);
            }
            catch (final Exception ex) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Cannot instantiate class: ");
                sb.append(s);
                Log.w("SupportMenuInflater", sb.toString(), (Throwable)ex);
                return null;
            }
        }
        
        private void i(final MenuItem menuItem) {
            final MenuItem setEnabled = menuItem.setChecked(this.s).setVisible(this.t).setEnabled(this.u);
            final int r = this.r;
            boolean b = false;
            setEnabled.setCheckable(r >= 1).setTitleCondensed(this.l).setIcon(this.m);
            final int v = this.v;
            if (v >= 0) {
                menuItem.setShowAsAction(v);
            }
            if (this.z != null) {
                if (this.F.c.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener((MenuItem$OnMenuItemClickListener)new a(this.F.b(), this.z));
            }
            if (this.r >= 2) {
                if (menuItem instanceof i) {
                    ((i)menuItem).t(true);
                }
                else if (menuItem instanceof j) {
                    ((j)menuItem).h(true);
                }
            }
            final String x = this.x;
            if (x != null) {
                menuItem.setActionView((View)this.e(x, androidx.appcompat.view.g.e, this.F.a));
                b = true;
            }
            final int w = this.w;
            if (w > 0) {
                if (!b) {
                    menuItem.setActionView(w);
                }
                else {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            final androidx.core.view.b a = this.A;
            if (a != null) {
                androidx.core.view.n.a(menuItem, a);
            }
            androidx.core.view.n.c(menuItem, this.B);
            androidx.core.view.n.g(menuItem, this.C);
            androidx.core.view.n.b(menuItem, this.n, this.o);
            androidx.core.view.n.f(menuItem, this.p, this.q);
            final PorterDuff$Mode e = this.E;
            if (e != null) {
                androidx.core.view.n.e(menuItem, e);
            }
            final ColorStateList d = this.D;
            if (d != null) {
                androidx.core.view.n.d(menuItem, d);
            }
        }
        
        public void a() {
            this.h = true;
            this.i(this.a.add(this.b, this.i, this.j, this.k));
        }
        
        public SubMenu b() {
            this.h = true;
            final SubMenu addSubMenu = this.a.addSubMenu(this.b, this.i, this.j, this.k);
            this.i(addSubMenu.getItem());
            return addSubMenu;
        }
        
        public boolean d() {
            return this.h;
        }
        
        public void f(final AttributeSet set) {
            final TypedArray obtainStyledAttributes = this.F.c.obtainStyledAttributes(set, d.j.o1);
            this.b = obtainStyledAttributes.getResourceId(d.j.q1, 0);
            this.c = obtainStyledAttributes.getInt(d.j.s1, 0);
            this.d = obtainStyledAttributes.getInt(d.j.t1, 0);
            this.e = obtainStyledAttributes.getInt(d.j.u1, 0);
            this.f = obtainStyledAttributes.getBoolean(d.j.r1, true);
            this.g = obtainStyledAttributes.getBoolean(d.j.p1, true);
            obtainStyledAttributes.recycle();
        }
        
        public void g(final AttributeSet set) {
            final r0 u = r0.u(this.F.c, set, d.j.v1);
            this.i = u.n(d.j.y1, 0);
            this.j = ((u.k(d.j.B1, this.c) & 0xFFFF0000) | (u.k(d.j.C1, this.d) & 0xFFFF));
            this.k = u.p(d.j.D1);
            this.l = u.p(d.j.E1);
            this.m = u.n(d.j.w1, 0);
            this.n = this.c(u.o(d.j.F1));
            this.o = u.k(d.j.M1, 4096);
            this.p = this.c(u.o(d.j.G1));
            this.q = u.k(d.j.Q1, 4096);
            final int h1 = d.j.H1;
            if (u.s(h1)) {
                this.r = (u.a(h1, false) ? 1 : 0);
            }
            else {
                this.r = this.e;
            }
            this.s = u.a(d.j.z1, false);
            this.t = u.a(d.j.A1, this.f);
            this.u = u.a(d.j.x1, this.g);
            this.v = u.k(d.j.R1, -1);
            this.z = u.o(d.j.I1);
            this.w = u.n(d.j.J1, 0);
            this.x = u.o(d.j.L1);
            final String o = u.o(d.j.K1);
            this.y = o;
            final boolean b = o != null;
            if (b && this.w == 0 && this.x == null) {
                this.A = (androidx.core.view.b)this.e(o, androidx.appcompat.view.g.f, this.F.b);
            }
            else {
                if (b) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.A = null;
            }
            this.B = u.p(d.j.N1);
            this.C = u.p(d.j.S1);
            final int p = d.j.P1;
            if (u.s(p)) {
                this.E = a0.e(u.k(p, -1), this.E);
            }
            else {
                this.E = null;
            }
            final int o2 = d.j.O1;
            if (u.s(o2)) {
                this.D = u.c(o2);
            }
            else {
                this.D = null;
            }
            u.w();
            this.h = false;
        }
        
        public void h() {
            this.b = 0;
            this.c = 0;
            this.d = 0;
            this.e = 0;
            this.f = true;
            this.g = true;
        }
    }
}
