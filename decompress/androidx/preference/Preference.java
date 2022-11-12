// 
// Decompiled by Procyon v0.6.0
// 

package androidx.preference;

import android.widget.Toast;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.view.MenuItem;
import android.view.ContextMenu$ContextMenuInfo;
import android.view.ContextMenu;
import android.view.MenuItem$OnMenuItemClickListener;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.view.AbsSavedState;
import android.os.Parcelable;
import androidx.core.view.accessibility.d;
import androidx.core.view.b0;
import android.view.View$OnCreateContextMenuListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.SharedPreferences;
import e.a;
import java.util.Set;
import java.util.ArrayList;
import android.text.TextUtils;
import android.content.SharedPreferences$Editor;
import android.view.ViewGroup;
import android.content.res.TypedArray;
import android.view.View;
import androidx.core.content.res.i;
import android.util.AttributeSet;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.content.Context;
import android.view.View$OnClickListener;
import java.util.List;
import android.os.Bundle;

public class Preference implements Comparable<Preference>
{
    private Bundle A;
    private boolean B;
    private boolean C;
    private boolean D;
    private String E;
    private Object F;
    private boolean G;
    private boolean H;
    private boolean I;
    private boolean J;
    private boolean K;
    private boolean L;
    private boolean M;
    private boolean N;
    private boolean O;
    private boolean P;
    private int Q;
    private int R;
    private b S;
    private List<Preference> T;
    private PreferenceGroup U;
    private boolean V;
    private boolean W;
    private e X;
    private f Y;
    private final View$OnClickListener Z;
    private final Context a;
    private j b;
    private long c;
    private boolean d;
    private c e;
    private d f;
    private int g;
    private int h;
    private CharSequence i;
    private CharSequence j;
    private int p;
    private Drawable w;
    private String x;
    private Intent y;
    private String z;
    
    public Preference(final Context context) {
        this(context, null);
    }
    
    public Preference(final Context context, final AttributeSet set) {
        this(context, set, androidx.core.content.res.i.a(context, m.h, 16842894));
    }
    
    public Preference(final Context context, final AttributeSet set, final int n) {
        this(context, set, n, 0);
    }
    
    public Preference(final Context a, final AttributeSet set, int n, final int n2) {
        this.g = Integer.MAX_VALUE;
        this.h = 0;
        this.B = true;
        this.C = true;
        this.D = true;
        this.G = true;
        this.H = true;
        this.I = true;
        this.J = true;
        this.K = true;
        this.M = true;
        this.P = true;
        final int b = androidx.preference.p.b;
        this.Q = b;
        this.Z = (View$OnClickListener)new View$OnClickListener() {
            final Preference a;
            
            public void onClick(final View view) {
                this.a.p0(view);
            }
        };
        this.a = a;
        final TypedArray obtainStyledAttributes = a.obtainStyledAttributes(set, s.J, n, n2);
        this.p = androidx.core.content.res.i.e(obtainStyledAttributes, s.h0, s.K, 0);
        this.x = androidx.core.content.res.i.f(obtainStyledAttributes, s.k0, s.Q);
        this.i = androidx.core.content.res.i.g(obtainStyledAttributes, s.s0, s.O);
        this.j = androidx.core.content.res.i.g(obtainStyledAttributes, s.r0, s.R);
        this.g = androidx.core.content.res.i.d(obtainStyledAttributes, s.m0, s.S, Integer.MAX_VALUE);
        this.z = androidx.core.content.res.i.f(obtainStyledAttributes, s.g0, s.X);
        this.Q = androidx.core.content.res.i.e(obtainStyledAttributes, s.l0, s.N, b);
        this.R = androidx.core.content.res.i.e(obtainStyledAttributes, s.t0, s.T, 0);
        this.B = androidx.core.content.res.i.b(obtainStyledAttributes, s.f0, s.M, true);
        this.C = androidx.core.content.res.i.b(obtainStyledAttributes, s.o0, s.P, true);
        this.D = androidx.core.content.res.i.b(obtainStyledAttributes, s.n0, s.L, true);
        this.E = androidx.core.content.res.i.f(obtainStyledAttributes, s.d0, s.U);
        n = s.a0;
        this.J = androidx.core.content.res.i.b(obtainStyledAttributes, n, n, this.C);
        n = s.b0;
        this.K = androidx.core.content.res.i.b(obtainStyledAttributes, n, n, this.C);
        n = s.c0;
        if (obtainStyledAttributes.hasValue(n)) {
            this.F = this.e0(obtainStyledAttributes, n);
        }
        else {
            n = s.V;
            if (obtainStyledAttributes.hasValue(n)) {
                this.F = this.e0(obtainStyledAttributes, n);
            }
        }
        this.P = androidx.core.content.res.i.b(obtainStyledAttributes, s.p0, s.W, true);
        n = s.q0;
        final boolean hasValue = obtainStyledAttributes.hasValue(n);
        this.L = hasValue;
        if (hasValue) {
            this.M = androidx.core.content.res.i.b(obtainStyledAttributes, n, s.Y, true);
        }
        this.N = androidx.core.content.res.i.b(obtainStyledAttributes, s.i0, s.Z, false);
        n = s.j0;
        this.I = androidx.core.content.res.i.b(obtainStyledAttributes, n, n, true);
        n = s.e0;
        this.O = androidx.core.content.res.i.b(obtainStyledAttributes, n, n, false);
        obtainStyledAttributes.recycle();
    }
    
    private void A0(final View view, final boolean enabled) {
        view.setEnabled(enabled);
        if (view instanceof ViewGroup) {
            final ViewGroup viewGroup = (ViewGroup)view;
            for (int i = viewGroup.getChildCount() - 1; i >= 0; --i) {
                this.A0(viewGroup.getChildAt(i), enabled);
            }
        }
    }
    
    private void R0(final SharedPreferences$Editor sharedPreferences$Editor) {
        if (this.b.t()) {
            sharedPreferences$Editor.apply();
        }
    }
    
    private void T0() {
        final String e = this.E;
        if (e != null) {
            final Preference k = this.k(e);
            if (k != null) {
                k.U0(this);
            }
        }
    }
    
    private void U0(final Preference preference) {
        final List<Preference> t = this.T;
        if (t != null) {
            t.remove(preference);
        }
    }
    
    private void i() {
        this.B();
        if (this.Q0() && this.E().contains(this.x)) {
            this.l0(true, null);
        }
        else {
            final Object f = this.F;
            if (f != null) {
                this.l0(false, f);
            }
        }
    }
    
    private void w0() {
        if (TextUtils.isEmpty((CharSequence)this.E)) {
            return;
        }
        final Preference k = this.k(this.E);
        if (k != null) {
            k.x0(this);
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Dependency \"");
        sb.append(this.E);
        sb.append("\" not found for preference \"");
        sb.append(this.x);
        sb.append("\" (title: \"");
        sb.append((Object)this.i);
        sb.append("\"");
        throw new IllegalStateException(sb.toString());
    }
    
    private void x0(final Preference preference) {
        if (this.T == null) {
            this.T = new ArrayList<Preference>();
        }
        this.T.add(preference);
        preference.b0(this, this.P0());
    }
    
    public Set<String> A(final Set<String> set) {
        if (!this.Q0()) {
            return set;
        }
        this.B();
        return this.b.l().getStringSet(this.x, (Set)set);
    }
    
    public androidx.preference.e B() {
        final j b = this.b;
        if (b != null) {
            b.j();
        }
        return null;
    }
    
    public void B0(final int p) {
        this.D0(e.a.b(this.a, p));
        this.p = p;
    }
    
    public j C() {
        return this.b;
    }
    
    public void D0(final Drawable w) {
        if (this.w != w) {
            this.w = w;
            this.p = 0;
            this.R();
        }
    }
    
    public SharedPreferences E() {
        if (this.b != null) {
            this.B();
            return this.b.l();
        }
        return null;
    }
    
    public void E0(final Intent y) {
        this.y = y;
    }
    
    public void F0(final int q) {
        this.Q = q;
    }
    
    public CharSequence G() {
        if (this.H() != null) {
            return this.H().a(this);
        }
        return this.j;
    }
    
    final void G0(final b s) {
        this.S = s;
    }
    
    public final f H() {
        return this.Y;
    }
    
    public void H0(final c e) {
        this.e = e;
    }
    
    public CharSequence I() {
        return this.i;
    }
    
    public void I0(final d f) {
        this.f = f;
    }
    
    public final int J() {
        return this.R;
    }
    
    public void J0(final int g) {
        if (g != this.g) {
            this.g = g;
            this.T();
        }
    }
    
    public boolean K() {
        return TextUtils.isEmpty((CharSequence)this.x) ^ true;
    }
    
    public void K0(final CharSequence j) {
        if (this.H() == null) {
            if (!TextUtils.equals(this.j, j)) {
                this.j = j;
                this.R();
            }
            return;
        }
        throw new IllegalStateException("Preference already has a SummaryProvider set.");
    }
    
    public final void L0(final f y) {
        this.Y = y;
        this.R();
    }
    
    public boolean M() {
        return this.O;
    }
    
    public void M0(final int n) {
        this.N0(this.a.getString(n));
    }
    
    public boolean N() {
        return this.B && this.G && this.H;
    }
    
    public void N0(final CharSequence i) {
        if (!TextUtils.equals(i, this.i)) {
            this.i = i;
            this.R();
        }
    }
    
    public boolean O() {
        return this.D;
    }
    
    public final void O0(final boolean i) {
        if (this.I != i) {
            this.I = i;
            final b s = this.S;
            if (s != null) {
                s.g(this);
            }
        }
    }
    
    public boolean P() {
        return this.C;
    }
    
    public boolean P0() {
        return this.N() ^ true;
    }
    
    public final boolean Q() {
        return this.I;
    }
    
    protected boolean Q0() {
        return this.b != null && this.O() && this.K();
    }
    
    protected void R() {
        final b s = this.S;
        if (s != null) {
            s.h(this);
        }
    }
    
    public void S(final boolean b) {
        final List<Preference> t = this.T;
        if (t == null) {
            return;
        }
        for (int size = t.size(), i = 0; i < size; ++i) {
            ((Preference)t.get(i)).b0(this, b);
        }
    }
    
    protected void T() {
        final b s = this.S;
        if (s != null) {
            s.k(this);
        }
    }
    
    public void U() {
        this.w0();
    }
    
    protected void W(final j b) {
        this.b = b;
        if (!this.d) {
            this.c = b.f();
        }
        this.i();
    }
    
    protected void X(final j j, final long c) {
        this.c = c;
        this.d = true;
        try {
            this.W(j);
        }
        finally {
            this.d = false;
        }
    }
    
    public void Y(final l l) {
        final View itemView = l.itemView;
        itemView.setOnClickListener(this.Z);
        itemView.setId(this.h);
        final TextView textView = (TextView)l.a(16908304);
        final int n = 8;
        Integer value = null;
        Label_0094: {
            if (textView != null) {
                final CharSequence g = this.G();
                if (!TextUtils.isEmpty(g)) {
                    textView.setText(g);
                    textView.setVisibility(0);
                    value = textView.getCurrentTextColor();
                    break Label_0094;
                }
                textView.setVisibility(8);
            }
            value = null;
        }
        final TextView textView2 = (TextView)l.a(16908310);
        if (textView2 != null) {
            final CharSequence i = this.I();
            if (!TextUtils.isEmpty(i)) {
                textView2.setText(i);
                textView2.setVisibility(0);
                if (this.L) {
                    textView2.setSingleLine(this.M);
                }
                if (!this.P() && this.N() && value != null) {
                    textView2.setTextColor((int)value);
                }
            }
            else {
                textView2.setVisibility(8);
            }
        }
        final ImageView imageView = (ImageView)l.a(16908294);
        if (imageView != null) {
            final int p = this.p;
            if (p != 0 || this.w != null) {
                if (this.w == null) {
                    this.w = e.a.b(this.a, p);
                }
                final Drawable w = this.w;
                if (w != null) {
                    imageView.setImageDrawable(w);
                }
            }
            if (this.w != null) {
                imageView.setVisibility(0);
            }
            else {
                int visibility;
                if (this.N) {
                    visibility = 4;
                }
                else {
                    visibility = 8;
                }
                imageView.setVisibility(visibility);
            }
        }
        View view;
        if ((view = l.a(o.a)) == null) {
            view = l.a(16908350);
        }
        if (view != null) {
            if (this.w != null) {
                view.setVisibility(0);
            }
            else {
                int visibility2 = n;
                if (this.N) {
                    visibility2 = 4;
                }
                view.setVisibility(visibility2);
            }
        }
        if (this.P) {
            this.A0(itemView, this.N());
        }
        else {
            this.A0(itemView, true);
        }
        final boolean p2 = this.P();
        itemView.setFocusable(p2);
        itemView.setClickable(p2);
        l.e(this.J);
        l.f(this.K);
        final boolean m = this.M();
        if (m && this.X == null) {
            this.X = new e(this);
        }
        Object x;
        if (m) {
            x = this.X;
        }
        else {
            x = null;
        }
        itemView.setOnCreateContextMenuListener((View$OnCreateContextMenuListener)x);
        itemView.setLongClickable(m);
        if (m && !p2) {
            b0.t0(itemView, null);
        }
    }
    
    protected void Z() {
    }
    
    void a(final PreferenceGroup u) {
        if (u != null && this.U != null) {
            throw new IllegalStateException("This preference already has a parent. You must remove the existing parent before assigning a new one.");
        }
        this.U = u;
    }
    
    public void b0(final Preference preference, final boolean b) {
        if (this.G == b) {
            this.G = (b ^ true);
            this.S(this.P0());
            this.R();
        }
    }
    
    public boolean c(final Object o) {
        final c e = this.e;
        return e == null || e.a(this, o);
    }
    
    @Override
    public /* bridge */ int compareTo(final Object o) {
        return this.f((Preference)o);
    }
    
    final void d() {
        this.V = false;
    }
    
    public void d0() {
        this.T0();
        this.V = true;
    }
    
    protected Object e0(final TypedArray typedArray, final int n) {
        return null;
    }
    
    public int f(final Preference preference) {
        final int g = this.g;
        final int g2 = preference.g;
        if (g != g2) {
            return g - g2;
        }
        final CharSequence i = this.i;
        final CharSequence j = preference.i;
        if (i == j) {
            return 0;
        }
        if (i == null) {
            return 1;
        }
        if (j == null) {
            return -1;
        }
        return i.toString().compareToIgnoreCase(preference.i.toString());
    }
    
    @Deprecated
    public void f0(final androidx.core.view.accessibility.d d) {
    }
    
    void g(final Bundle bundle) {
        if (this.K()) {
            final Parcelable parcelable = bundle.getParcelable(this.x);
            if (parcelable != null) {
                this.W = false;
                this.i0(parcelable);
                if (!this.W) {
                    throw new IllegalStateException("Derived class did not call super.onRestoreInstanceState()");
                }
            }
        }
    }
    
    public void g0(final Preference preference, final boolean b) {
        if (this.H == b) {
            this.H = (b ^ true);
            this.S(this.P0());
            this.R();
        }
    }
    
    void h(final Bundle bundle) {
        if (this.K()) {
            this.W = false;
            final Parcelable j0 = this.j0();
            if (!this.W) {
                throw new IllegalStateException("Derived class did not call super.onSaveInstanceState()");
            }
            if (j0 != null) {
                bundle.putParcelable(this.x, j0);
            }
        }
    }
    
    protected void h0() {
        this.T0();
    }
    
    protected void i0(final Parcelable parcelable) {
        this.W = true;
        if (parcelable != AbsSavedState.EMPTY_STATE && parcelable != null) {
            throw new IllegalArgumentException("Wrong state class -- expecting Preference State");
        }
    }
    
    protected Parcelable j0() {
        this.W = true;
        return (Parcelable)AbsSavedState.EMPTY_STATE;
    }
    
    protected <T extends Preference> T k(final String s) {
        final j b = this.b;
        if (b == null) {
            return null;
        }
        return (T)b.a(s);
    }
    
    protected void k0(final Object o) {
    }
    
    public Context l() {
        return this.a;
    }
    
    @Deprecated
    protected void l0(final boolean b, final Object o) {
        this.k0(o);
    }
    
    public Bundle m() {
        if (this.A == null) {
            this.A = new Bundle();
        }
        return this.A;
    }
    
    StringBuilder n() {
        final StringBuilder sb = new StringBuilder();
        final CharSequence i = this.I();
        if (!TextUtils.isEmpty(i)) {
            sb.append(i);
            sb.append(' ');
        }
        final CharSequence g = this.G();
        if (!TextUtils.isEmpty(g)) {
            sb.append(g);
            sb.append(' ');
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb;
    }
    
    public String o() {
        return this.z;
    }
    
    public void o0() {
        if (this.N()) {
            if (this.P()) {
                this.Z();
                final d f = this.f;
                if (f != null && f.a(this)) {
                    return;
                }
                final j c = this.C();
                if (c != null) {
                    final j.c h = c.h();
                    if (h != null && h.S3(this)) {
                        return;
                    }
                }
                if (this.y != null) {
                    this.l().startActivity(this.y);
                }
            }
        }
    }
    
    long p() {
        return this.c;
    }
    
    protected void p0(final View view) {
        this.o0();
    }
    
    public Intent q() {
        return this.y;
    }
    
    protected boolean q0(final boolean b) {
        if (!this.Q0()) {
            return false;
        }
        if (b == this.x(b ^ true)) {
            return true;
        }
        this.B();
        final SharedPreferences$Editor e = this.b.e();
        e.putBoolean(this.x, b);
        this.R0(e);
        return true;
    }
    
    public String r() {
        return this.x;
    }
    
    public final int s() {
        return this.Q;
    }
    
    protected boolean s0(final int n) {
        if (!this.Q0()) {
            return false;
        }
        if (n == this.y(~n)) {
            return true;
        }
        this.B();
        final SharedPreferences$Editor e = this.b.e();
        e.putInt(this.x, n);
        this.R0(e);
        return true;
    }
    
    public d t() {
        return this.f;
    }
    
    @Override
    public String toString() {
        return this.n().toString();
    }
    
    public int u() {
        return this.g;
    }
    
    protected boolean u0(final String s) {
        if (!this.Q0()) {
            return false;
        }
        if (TextUtils.equals((CharSequence)s, (CharSequence)this.z(null))) {
            return true;
        }
        this.B();
        final SharedPreferences$Editor e = this.b.e();
        e.putString(this.x, s);
        this.R0(e);
        return true;
    }
    
    public boolean v0(final Set<String> set) {
        if (!this.Q0()) {
            return false;
        }
        if (set.equals(this.A(null))) {
            return true;
        }
        this.B();
        final SharedPreferences$Editor e = this.b.e();
        e.putStringSet(this.x, (Set)set);
        this.R0(e);
        return true;
    }
    
    public PreferenceGroup w() {
        return this.U;
    }
    
    protected boolean x(final boolean b) {
        if (!this.Q0()) {
            return b;
        }
        this.B();
        return this.b.l().getBoolean(this.x, b);
    }
    
    protected int y(final int n) {
        if (!this.Q0()) {
            return n;
        }
        this.B();
        return this.b.l().getInt(this.x, n);
    }
    
    public void y0(final Bundle bundle) {
        this.g(bundle);
    }
    
    protected String z(final String s) {
        if (!this.Q0()) {
            return s;
        }
        this.B();
        return this.b.l().getString(this.x, s);
    }
    
    public void z0(final Bundle bundle) {
        this.h(bundle);
    }
    
    public static class BaseSavedState extends AbsSavedState
    {
        public static final Parcelable$Creator<BaseSavedState> CREATOR;
        
        static {
            CREATOR = (Parcelable$Creator)new Parcelable$Creator<BaseSavedState>() {
                public BaseSavedState a(final Parcel parcel) {
                    return new BaseSavedState(parcel);
                }
                
                public BaseSavedState[] b(final int n) {
                    return new BaseSavedState[n];
                }
                
                public /* bridge */ Object createFromParcel(final Parcel parcel) {
                    return this.a(parcel);
                }
                
                public /* bridge */ Object[] newArray(final int n) {
                    return this.b(n);
                }
            };
        }
        
        public BaseSavedState(final Parcel parcel) {
            super(parcel);
        }
        
        public BaseSavedState(final Parcelable parcelable) {
            super(parcelable);
        }
    }
    
    interface b
    {
        void g(final Preference p0);
        
        void h(final Preference p0);
        
        void k(final Preference p0);
    }
    
    public interface c
    {
        boolean a(final Preference p0, final Object p1);
    }
    
    public interface d
    {
        boolean a(final Preference p0);
    }
    
    private static class e implements View$OnCreateContextMenuListener, MenuItem$OnMenuItemClickListener
    {
        private final Preference a;
        
        e(final Preference a) {
            this.a = a;
        }
        
        public void onCreateContextMenu(final ContextMenu contextMenu, final View view, final ContextMenu$ContextMenuInfo contextMenu$ContextMenuInfo) {
            final CharSequence g = this.a.G();
            if (this.a.M()) {
                if (!TextUtils.isEmpty(g)) {
                    contextMenu.setHeaderTitle(g);
                    contextMenu.add(0, 0, 0, q.a).setOnMenuItemClickListener((MenuItem$OnMenuItemClickListener)this);
                }
            }
        }
        
        public boolean onMenuItemClick(final MenuItem menuItem) {
            final ClipboardManager clipboardManager = (ClipboardManager)this.a.l().getSystemService("clipboard");
            final CharSequence g = this.a.G();
            clipboardManager.setPrimaryClip(ClipData.newPlainText((CharSequence)"Preference", g));
            Toast.makeText(this.a.l(), (CharSequence)this.a.l().getString(q.d, new Object[] { g }), 0).show();
            return true;
        }
    }
    
    public interface f<T extends Preference>
    {
        CharSequence a(final T p0);
    }
}
