// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.view.menu;

import android.view.KeyEvent;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.view.LayoutInflater;
import android.content.ActivityNotFoundException;
import android.util.Log;
import android.content.res.Resources;
import d.h;
import android.view.ViewConfiguration;
import android.view.SubMenu;
import android.view.ViewDebug$CapturedViewProperty;
import android.view.ActionProvider;
import android.view.MenuItem;
import androidx.core.graphics.drawable.a;
import android.graphics.PorterDuff$Mode;
import android.content.res.ColorStateList;
import android.view.MenuItem$OnMenuItemClickListener;
import android.graphics.drawable.Drawable;
import android.content.Intent;
import android.view.ContextMenu$ContextMenuInfo;
import android.view.MenuItem$OnActionExpandListener;
import android.view.View;
import w.b;

public final class i implements b
{
    private View A;
    private androidx.core.view.b B;
    private MenuItem$OnActionExpandListener C;
    private boolean D;
    private ContextMenu$ContextMenuInfo E;
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    private CharSequence e;
    private CharSequence f;
    private Intent g;
    private char h;
    private int i;
    private char j;
    private int k;
    private Drawable l;
    private int m;
    g n;
    private r o;
    private Runnable p;
    private MenuItem$OnMenuItemClickListener q;
    private CharSequence r;
    private CharSequence s;
    private ColorStateList t;
    private PorterDuff$Mode u;
    private boolean v;
    private boolean w;
    private boolean x;
    private int y;
    private int z;
    
    i(final g n, final int b, final int a, final int c, final int d, final CharSequence e, final int z) {
        this.i = 4096;
        this.k = 4096;
        this.m = 0;
        this.t = null;
        this.u = null;
        this.v = false;
        this.w = false;
        this.x = false;
        this.y = 16;
        this.D = false;
        this.n = n;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.z = z;
    }
    
    private static void d(final StringBuilder sb, final int n, final int n2, final String s) {
        if ((n & n2) == n2) {
            sb.append(s);
        }
    }
    
    private Drawable e(final Drawable drawable) {
        Drawable mutate = drawable;
        if (drawable != null) {
            mutate = drawable;
            if (this.x) {
                if (!this.v) {
                    mutate = drawable;
                    if (!this.w) {
                        return mutate;
                    }
                }
                mutate = androidx.core.graphics.drawable.a.l(drawable).mutate();
                if (this.v) {
                    androidx.core.graphics.drawable.a.i(mutate, this.t);
                }
                if (this.w) {
                    androidx.core.graphics.drawable.a.j(mutate, this.u);
                }
                this.x = false;
            }
        }
        return mutate;
    }
    
    boolean A() {
        return this.n.J() && this.g() != '\0';
    }
    
    public boolean B() {
        return (this.z & 0x4) == 0x4;
    }
    
    @Override
    public androidx.core.view.b a() {
        return this.B;
    }
    
    @Override
    public b b(androidx.core.view.b b) {
        final androidx.core.view.b b2 = this.B;
        if (b2 != null) {
            b2.h();
        }
        this.A = null;
        this.B = b;
        this.n.M(true);
        b = this.B;
        if (b != null) {
            b.j((androidx.core.view.b.b)new androidx.core.view.b.b(this) {
                final i a;
                
                @Override
                public void onActionProviderVisibilityChanged(final boolean b) {
                    final i a = this.a;
                    a.n.L(a);
                }
            });
        }
        return this;
    }
    
    public void c() {
        this.n.K(this);
    }
    
    @Override
    public boolean collapseActionView() {
        if ((this.z & 0x8) == 0x0) {
            return false;
        }
        if (this.A == null) {
            return true;
        }
        final MenuItem$OnActionExpandListener c = this.C;
        return (c == null || c.onMenuItemActionCollapse((MenuItem)this)) && this.n.f(this);
    }
    
    @Override
    public boolean expandActionView() {
        if (!this.j()) {
            return false;
        }
        final MenuItem$OnActionExpandListener c = this.C;
        return (c == null || c.onMenuItemActionExpand((MenuItem)this)) && this.n.m(this);
    }
    
    public int f() {
        return this.d;
    }
    
    char g() {
        char c;
        if (this.n.I()) {
            c = this.j;
        }
        else {
            c = this.h;
        }
        return c;
    }
    
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }
    
    @Override
    public View getActionView() {
        final View a = this.A;
        if (a != null) {
            return a;
        }
        final androidx.core.view.b b = this.B;
        if (b != null) {
            return this.A = b.d((MenuItem)this);
        }
        return null;
    }
    
    @Override
    public int getAlphabeticModifiers() {
        return this.k;
    }
    
    public char getAlphabeticShortcut() {
        return this.j;
    }
    
    @Override
    public CharSequence getContentDescription() {
        return this.r;
    }
    
    public int getGroupId() {
        return this.b;
    }
    
    public Drawable getIcon() {
        final Drawable l = this.l;
        if (l != null) {
            return this.e(l);
        }
        if (this.m != 0) {
            final Drawable b = e.a.b(this.n.w(), this.m);
            this.m = 0;
            this.l = b;
            return this.e(b);
        }
        return null;
    }
    
    @Override
    public ColorStateList getIconTintList() {
        return this.t;
    }
    
    @Override
    public PorterDuff$Mode getIconTintMode() {
        return this.u;
    }
    
    public Intent getIntent() {
        return this.g;
    }
    
    @ViewDebug$CapturedViewProperty
    public int getItemId() {
        return this.a;
    }
    
    public ContextMenu$ContextMenuInfo getMenuInfo() {
        return this.E;
    }
    
    @Override
    public int getNumericModifiers() {
        return this.i;
    }
    
    public char getNumericShortcut() {
        return this.h;
    }
    
    public int getOrder() {
        return this.c;
    }
    
    public SubMenu getSubMenu() {
        return (SubMenu)this.o;
    }
    
    @ViewDebug$CapturedViewProperty
    public CharSequence getTitle() {
        return this.e;
    }
    
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f;
        if (charSequence == null) {
            charSequence = this.e;
        }
        return charSequence;
    }
    
    @Override
    public CharSequence getTooltipText() {
        return this.s;
    }
    
    String h() {
        final char g = this.g();
        if (g == '\0') {
            return "";
        }
        final Resources resources = this.n.w().getResources();
        final StringBuilder sb = new StringBuilder();
        if (ViewConfiguration.get(this.n.w()).hasPermanentMenuKey()) {
            sb.append(resources.getString(d.h.m));
        }
        int n;
        if (this.n.I()) {
            n = this.k;
        }
        else {
            n = this.i;
        }
        d(sb, n, 65536, resources.getString(d.h.i));
        d(sb, n, 4096, resources.getString(d.h.e));
        d(sb, n, 2, resources.getString(d.h.d));
        d(sb, n, 1, resources.getString(d.h.j));
        d(sb, n, 4, resources.getString(d.h.l));
        d(sb, n, 8, resources.getString(d.h.h));
        if (g != '\b') {
            if (g != '\n') {
                if (g != ' ') {
                    sb.append(g);
                }
                else {
                    sb.append(resources.getString(d.h.k));
                }
            }
            else {
                sb.append(resources.getString(d.h.g));
            }
        }
        else {
            sb.append(resources.getString(d.h.f));
        }
        return sb.toString();
    }
    
    public boolean hasSubMenu() {
        return this.o != null;
    }
    
    CharSequence i(final n.a a) {
        CharSequence charSequence;
        if (a != null && a.e()) {
            charSequence = this.getTitleCondensed();
        }
        else {
            charSequence = this.getTitle();
        }
        return charSequence;
    }
    
    @Override
    public boolean isActionViewExpanded() {
        return this.D;
    }
    
    public boolean isCheckable() {
        final int y = this.y;
        boolean b = true;
        if ((y & 0x1) != 0x1) {
            b = false;
        }
        return b;
    }
    
    public boolean isChecked() {
        return (this.y & 0x2) == 0x2;
    }
    
    public boolean isEnabled() {
        return (this.y & 0x10) != 0x0;
    }
    
    public boolean isVisible() {
        final androidx.core.view.b b = this.B;
        boolean b2 = true;
        final boolean b3 = true;
        if (b != null && b.g()) {
            return (this.y & 0x8) == 0x0 && this.B.b() && b3;
        }
        if ((this.y & 0x8) != 0x0) {
            b2 = false;
        }
        return b2;
    }
    
    public boolean j() {
        final int z = this.z;
        boolean b = false;
        if ((z & 0x8) != 0x0) {
            if (this.A == null) {
                final androidx.core.view.b b2 = this.B;
                if (b2 != null) {
                    this.A = b2.d((MenuItem)this);
                }
            }
            b = b;
            if (this.A != null) {
                b = true;
            }
        }
        return b;
    }
    
    public boolean k() {
        final MenuItem$OnMenuItemClickListener q = this.q;
        if (q != null && q.onMenuItemClick((MenuItem)this)) {
            return true;
        }
        final g n = this.n;
        if (n.h(n, (MenuItem)this)) {
            return true;
        }
        final Runnable p = this.p;
        if (p != null) {
            p.run();
            return true;
        }
        if (this.g != null) {
            try {
                this.n.w().startActivity(this.g);
                return true;
            }
            catch (final ActivityNotFoundException ex) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", (Throwable)ex);
            }
        }
        final androidx.core.view.b b = this.B;
        return b != null && b.e();
    }
    
    public boolean l() {
        return (this.y & 0x20) == 0x20;
    }
    
    public boolean m() {
        return (this.y & 0x4) != 0x0;
    }
    
    public boolean n() {
        final int z = this.z;
        boolean b = true;
        if ((z & 0x1) != 0x1) {
            b = false;
        }
        return b;
    }
    
    public boolean o() {
        return (this.z & 0x2) == 0x2;
    }
    
    public b p(final int n) {
        final Context w = this.n.w();
        this.q(LayoutInflater.from(w).inflate(n, (ViewGroup)new LinearLayout(w), false));
        return this;
    }
    
    public b q(final View a) {
        this.A = a;
        this.B = null;
        if (a != null && a.getId() == -1) {
            final int a2 = this.a;
            if (a2 > 0) {
                a.setId(a2);
            }
        }
        this.n.K(this);
        return this;
    }
    
    public void r(final boolean d) {
        this.D = d;
        this.n.M(false);
    }
    
    void s(final boolean b) {
        final int y = this.y;
        int n;
        if (b) {
            n = 2;
        }
        else {
            n = 0;
        }
        final int y2 = n | (y & 0xFFFFFFFD);
        this.y = y2;
        if (y != y2) {
            this.n.M(false);
        }
    }
    
    public MenuItem setActionProvider(final ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }
    
    @Override
    public /* bridge */ MenuItem setActionView(final int n) {
        return (MenuItem)this.p(n);
    }
    
    @Override
    public /* bridge */ MenuItem setActionView(final View view) {
        return (MenuItem)this.q(view);
    }
    
    public MenuItem setAlphabeticShortcut(final char c) {
        if (this.j == c) {
            return (MenuItem)this;
        }
        this.j = Character.toLowerCase(c);
        this.n.M(false);
        return (MenuItem)this;
    }
    
    @Override
    public MenuItem setAlphabeticShortcut(final char c, final int n) {
        if (this.j == c && this.k == n) {
            return (MenuItem)this;
        }
        this.j = Character.toLowerCase(c);
        this.k = KeyEvent.normalizeMetaState(n);
        this.n.M(false);
        return (MenuItem)this;
    }
    
    public MenuItem setCheckable(final boolean b) {
        final int y = this.y;
        final int y2 = (b ? 1 : 0) | (y & 0xFFFFFFFE);
        this.y = y2;
        if (y != y2) {
            this.n.M(false);
        }
        return (MenuItem)this;
    }
    
    public MenuItem setChecked(final boolean b) {
        if ((this.y & 0x4) != 0x0) {
            this.n.X((MenuItem)this);
        }
        else {
            this.s(b);
        }
        return (MenuItem)this;
    }
    
    public /* bridge */ MenuItem setContentDescription(final CharSequence contentDescription) {
        return (MenuItem)this.setContentDescription(contentDescription);
    }
    
    @Override
    public b setContentDescription(final CharSequence r) {
        this.r = r;
        this.n.M(false);
        return this;
    }
    
    public MenuItem setEnabled(final boolean b) {
        if (b) {
            this.y |= 0x10;
        }
        else {
            this.y &= 0xFFFFFFEF;
        }
        this.n.M(false);
        return (MenuItem)this;
    }
    
    public MenuItem setIcon(final int m) {
        this.l = null;
        this.m = m;
        this.x = true;
        this.n.M(false);
        return (MenuItem)this;
    }
    
    public MenuItem setIcon(final Drawable l) {
        this.m = 0;
        this.l = l;
        this.x = true;
        this.n.M(false);
        return (MenuItem)this;
    }
    
    @Override
    public MenuItem setIconTintList(final ColorStateList t) {
        this.t = t;
        this.v = true;
        this.x = true;
        this.n.M(false);
        return (MenuItem)this;
    }
    
    @Override
    public MenuItem setIconTintMode(final PorterDuff$Mode u) {
        this.u = u;
        this.w = true;
        this.x = true;
        this.n.M(false);
        return (MenuItem)this;
    }
    
    public MenuItem setIntent(final Intent g) {
        this.g = g;
        return (MenuItem)this;
    }
    
    public MenuItem setNumericShortcut(final char h) {
        if (this.h == h) {
            return (MenuItem)this;
        }
        this.h = h;
        this.n.M(false);
        return (MenuItem)this;
    }
    
    @Override
    public MenuItem setNumericShortcut(final char h, final int n) {
        if (this.h == h && this.i == n) {
            return (MenuItem)this;
        }
        this.h = h;
        this.i = KeyEvent.normalizeMetaState(n);
        this.n.M(false);
        return (MenuItem)this;
    }
    
    public MenuItem setOnActionExpandListener(final MenuItem$OnActionExpandListener c) {
        this.C = c;
        return (MenuItem)this;
    }
    
    public MenuItem setOnMenuItemClickListener(final MenuItem$OnMenuItemClickListener q) {
        this.q = q;
        return (MenuItem)this;
    }
    
    public MenuItem setShortcut(final char h, final char c) {
        this.h = h;
        this.j = Character.toLowerCase(c);
        this.n.M(false);
        return (MenuItem)this;
    }
    
    @Override
    public MenuItem setShortcut(final char h, final char c, final int n, final int n2) {
        this.h = h;
        this.i = KeyEvent.normalizeMetaState(n);
        this.j = Character.toLowerCase(c);
        this.k = KeyEvent.normalizeMetaState(n2);
        this.n.M(false);
        return (MenuItem)this;
    }
    
    @Override
    public void setShowAsAction(final int z) {
        final int n = z & 0x3;
        if (n != 0 && n != 1 && n != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.z = z;
        this.n.K(this);
    }
    
    @Override
    public /* bridge */ MenuItem setShowAsActionFlags(final int n) {
        return (MenuItem)this.w(n);
    }
    
    public MenuItem setTitle(final int n) {
        return this.setTitle(this.n.w().getString(n));
    }
    
    public MenuItem setTitle(final CharSequence charSequence) {
        this.e = charSequence;
        this.n.M(false);
        final r o = this.o;
        if (o != null) {
            o.setHeaderTitle(charSequence);
        }
        return (MenuItem)this;
    }
    
    public MenuItem setTitleCondensed(final CharSequence f) {
        this.f = f;
        this.n.M(false);
        return (MenuItem)this;
    }
    
    public /* bridge */ MenuItem setTooltipText(final CharSequence tooltipText) {
        return (MenuItem)this.setTooltipText(tooltipText);
    }
    
    @Override
    public b setTooltipText(final CharSequence s) {
        this.s = s;
        this.n.M(false);
        return this;
    }
    
    public MenuItem setVisible(final boolean b) {
        if (this.y(b)) {
            this.n.L(this);
        }
        return (MenuItem)this;
    }
    
    public void t(final boolean b) {
        final int y = this.y;
        int n;
        if (b) {
            n = 4;
        }
        else {
            n = 0;
        }
        this.y = (n | (y & 0xFFFFFFFB));
    }
    
    @Override
    public String toString() {
        final CharSequence e = this.e;
        String string;
        if (e != null) {
            string = e.toString();
        }
        else {
            string = null;
        }
        return string;
    }
    
    public void u(final boolean b) {
        if (b) {
            this.y |= 0x20;
        }
        else {
            this.y &= 0xFFFFFFDF;
        }
    }
    
    void v(final ContextMenu$ContextMenuInfo e) {
        this.E = e;
    }
    
    public b w(final int showAsAction) {
        this.setShowAsAction(showAsAction);
        return this;
    }
    
    public void x(final r o) {
        (this.o = o).setHeaderTitle(this.getTitle());
    }
    
    boolean y(final boolean b) {
        final int y = this.y;
        final boolean b2 = false;
        int n;
        if (b) {
            n = 0;
        }
        else {
            n = 8;
        }
        final int y2 = n | (y & 0xFFFFFFF7);
        this.y = y2;
        boolean b3 = b2;
        if (y != y2) {
            b3 = true;
        }
        return b3;
    }
    
    public boolean z() {
        return this.n.C();
    }
}
