// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.app;

import java.lang.ref.WeakReference;
import android.widget.AdapterView;
import android.widget.AdapterView$OnItemClickListener;
import android.widget.SimpleCursorAdapter;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.ArrayAdapter;
import android.content.DialogInterface$OnKeyListener;
import android.content.DialogInterface$OnDismissListener;
import android.content.DialogInterface$OnCancelListener;
import android.widget.AdapterView$OnItemSelectedListener;
import android.database.Cursor;
import android.content.DialogInterface$OnMultiChoiceClickListener;
import android.content.DialogInterface$OnClickListener;
import android.view.KeyEvent;
import android.content.res.Resources$Theme;
import android.util.TypedValue;
import androidx.appcompat.widget.LinearLayoutCompat;
import android.widget.FrameLayout;
import android.view.LayoutInflater;
import android.text.TextUtils;
import androidx.core.view.b0;
import d.f;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.ViewGroup$LayoutParams;
import android.widget.LinearLayout$LayoutParams;
import android.view.ViewGroup;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import d.a;
import d.j;
import android.content.DialogInterface;
import android.os.Message;
import android.widget.Button;
import android.widget.ListView;
import android.view.Window;
import android.content.Context;
import android.view.View$OnClickListener;
import android.os.Handler;
import android.widget.ListAdapter;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;
import android.graphics.drawable.Drawable;
import androidx.core.widget.NestedScrollView;

class AlertController
{
    NestedScrollView A;
    private int B;
    private Drawable C;
    private ImageView D;
    private TextView E;
    private TextView F;
    private View G;
    ListAdapter H;
    int I;
    private int J;
    private int K;
    int L;
    int M;
    int N;
    int O;
    private boolean P;
    private int Q;
    Handler R;
    private final View$OnClickListener S;
    private final Context a;
    final h b;
    private final Window c;
    private final int d;
    private CharSequence e;
    private CharSequence f;
    ListView g;
    private View h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private boolean n;
    Button o;
    private CharSequence p;
    Message q;
    private Drawable r;
    Button s;
    private CharSequence t;
    Message u;
    private Drawable v;
    Button w;
    private CharSequence x;
    Message y;
    private Drawable z;
    
    public AlertController(final Context a, final h b, final Window c) {
        this.n = false;
        this.B = 0;
        this.I = -1;
        this.Q = 0;
        this.S = (View$OnClickListener)new View$OnClickListener() {
            final AlertController a;
            
            public void onClick(final View view) {
                final AlertController a = this.a;
                Message message = null;
                Label_0082: {
                    if (view == a.o) {
                        final Message q = a.q;
                        if (q != null) {
                            message = Message.obtain(q);
                            break Label_0082;
                        }
                    }
                    if (view == a.s) {
                        final Message u = a.u;
                        if (u != null) {
                            message = Message.obtain(u);
                            break Label_0082;
                        }
                    }
                    if (view == a.w) {
                        final Message y = a.y;
                        if (y != null) {
                            message = Message.obtain(y);
                            break Label_0082;
                        }
                    }
                    message = null;
                }
                if (message != null) {
                    message.sendToTarget();
                }
                final AlertController a2 = this.a;
                a2.R.obtainMessage(1, (Object)a2.b).sendToTarget();
            }
        };
        this.a = a;
        this.b = b;
        this.c = c;
        this.R = new c((DialogInterface)b);
        final TypedArray obtainStyledAttributes = a.obtainStyledAttributes((AttributeSet)null, d.j.F, d.a.n, 0);
        this.J = obtainStyledAttributes.getResourceId(d.j.G, 0);
        this.K = obtainStyledAttributes.getResourceId(d.j.I, 0);
        this.L = obtainStyledAttributes.getResourceId(d.j.K, 0);
        this.M = obtainStyledAttributes.getResourceId(d.j.L, 0);
        this.N = obtainStyledAttributes.getResourceId(d.j.N, 0);
        this.O = obtainStyledAttributes.getResourceId(d.j.J, 0);
        this.P = obtainStyledAttributes.getBoolean(d.j.M, true);
        this.d = obtainStyledAttributes.getDimensionPixelSize(d.j.H, 0);
        obtainStyledAttributes.recycle();
        b.h(1);
    }
    
    static boolean a(final View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        final ViewGroup viewGroup = (ViewGroup)view;
        int i = viewGroup.getChildCount();
        while (i > 0) {
            if (a(viewGroup.getChildAt(--i))) {
                return true;
            }
        }
        return false;
    }
    
    private void b(final Button button) {
        final LinearLayout$LayoutParams layoutParams = (LinearLayout$LayoutParams)button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
    }
    
    private ViewGroup h(View inflate, View inflate2) {
        if (inflate == null) {
            inflate = inflate2;
            if (inflate2 instanceof ViewStub) {
                inflate = ((ViewStub)inflate2).inflate();
            }
            return (ViewGroup)inflate;
        }
        if (inflate2 != null) {
            final ViewParent parent = inflate2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup)parent).removeView(inflate2);
            }
        }
        inflate2 = inflate;
        if (inflate instanceof ViewStub) {
            inflate2 = ((ViewStub)inflate).inflate();
        }
        return (ViewGroup)inflate2;
    }
    
    private int i() {
        final int k = this.K;
        if (k == 0) {
            return this.J;
        }
        if (this.Q == 1) {
            return k;
        }
        return this.J;
    }
    
    private void o(final ViewGroup viewGroup, final View view, final int n, final int n2) {
        final View viewById = this.c.findViewById(d.f.u);
        final View viewById2 = this.c.findViewById(d.f.t);
        b0.H0(view, n, n2);
        if (viewById != null) {
            viewGroup.removeView(viewById);
        }
        if (viewById2 != null) {
            viewGroup.removeView(viewById2);
        }
    }
    
    private void t(final ViewGroup viewGroup) {
        (this.o = (Button)viewGroup.findViewById(16908313)).setOnClickListener(this.S);
        final boolean empty = TextUtils.isEmpty(this.p);
        final int n = 1;
        int n2;
        if (empty && this.r == null) {
            this.o.setVisibility(8);
            n2 = 0;
        }
        else {
            this.o.setText(this.p);
            final Drawable r = this.r;
            if (r != null) {
                final int d = this.d;
                r.setBounds(0, 0, d, d);
                this.o.setCompoundDrawables(this.r, (Drawable)null, (Drawable)null, (Drawable)null);
            }
            this.o.setVisibility(0);
            n2 = 1;
        }
        (this.s = (Button)viewGroup.findViewById(16908314)).setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.t) && this.v == null) {
            this.s.setVisibility(8);
        }
        else {
            this.s.setText(this.t);
            final Drawable v = this.v;
            if (v != null) {
                final int d2 = this.d;
                v.setBounds(0, 0, d2, d2);
                this.s.setCompoundDrawables(this.v, (Drawable)null, (Drawable)null, (Drawable)null);
            }
            this.s.setVisibility(0);
            n2 |= 0x2;
        }
        (this.w = (Button)viewGroup.findViewById(16908315)).setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.x) && this.z == null) {
            this.w.setVisibility(8);
        }
        else {
            this.w.setText(this.x);
            final Drawable z = this.z;
            if (z != null) {
                final int d3 = this.d;
                z.setBounds(0, 0, d3, d3);
                this.w.setCompoundDrawables(this.z, (Drawable)null, (Drawable)null, (Drawable)null);
            }
            this.w.setVisibility(0);
            n2 |= 0x4;
        }
        if (y(this.a)) {
            if (n2 == 1) {
                this.b(this.o);
            }
            else if (n2 == 2) {
                this.b(this.s);
            }
            else if (n2 == 4) {
                this.b(this.w);
            }
        }
        int n3;
        if (n2 != 0) {
            n3 = n;
        }
        else {
            n3 = 0;
        }
        if (n3 == 0) {
            viewGroup.setVisibility(8);
        }
    }
    
    private void u(ViewGroup viewGroup) {
        (this.A = (NestedScrollView)this.c.findViewById(d.f.v)).setFocusable(false);
        this.A.setNestedScrollingEnabled(false);
        final TextView f = (TextView)viewGroup.findViewById(16908299);
        this.F = f;
        if (f == null) {
            return;
        }
        final CharSequence f2 = this.f;
        if (f2 != null) {
            f.setText(f2);
        }
        else {
            f.setVisibility(8);
            this.A.removeView((View)this.F);
            if (this.g != null) {
                viewGroup = (ViewGroup)this.A.getParent();
                final int indexOfChild = viewGroup.indexOfChild((View)this.A);
                viewGroup.removeViewAt(indexOfChild);
                viewGroup.addView((View)this.g, indexOfChild, new ViewGroup$LayoutParams(-1, -1));
            }
            else {
                viewGroup.setVisibility(8);
            }
        }
    }
    
    private void v(final ViewGroup viewGroup) {
        View view = this.h;
        boolean b = false;
        if (view == null) {
            if (this.i != 0) {
                view = LayoutInflater.from(this.a).inflate(this.i, viewGroup, false);
            }
            else {
                view = null;
            }
        }
        if (view != null) {
            b = true;
        }
        if (!b || !a(view)) {
            this.c.setFlags(131072, 131072);
        }
        if (b) {
            final FrameLayout frameLayout = (FrameLayout)this.c.findViewById(d.f.n);
            frameLayout.addView(view, new ViewGroup$LayoutParams(-1, -1));
            if (this.n) {
                frameLayout.setPadding(this.j, this.k, this.l, this.m);
            }
            if (this.g != null) {
                ((LinearLayoutCompat.a)viewGroup.getLayoutParams()).weight = 0.0f;
            }
        }
        else {
            viewGroup.setVisibility(8);
        }
    }
    
    private void w(final ViewGroup viewGroup) {
        if (this.G != null) {
            viewGroup.addView(this.G, 0, new ViewGroup$LayoutParams(-1, -2));
            this.c.findViewById(d.f.N).setVisibility(8);
        }
        else {
            this.D = (ImageView)this.c.findViewById(16908294);
            if ((TextUtils.isEmpty(this.e) ^ true) && this.P) {
                (this.E = (TextView)this.c.findViewById(d.f.j)).setText(this.e);
                final int b = this.B;
                if (b != 0) {
                    this.D.setImageResource(b);
                }
                else {
                    final Drawable c = this.C;
                    if (c != null) {
                        this.D.setImageDrawable(c);
                    }
                    else {
                        this.E.setPadding(this.D.getPaddingLeft(), this.D.getPaddingTop(), this.D.getPaddingRight(), this.D.getPaddingBottom());
                        this.D.setVisibility(8);
                    }
                }
            }
            else {
                this.c.findViewById(d.f.N).setVisibility(8);
                this.D.setVisibility(8);
                viewGroup.setVisibility(8);
            }
        }
    }
    
    private void x() {
        final View viewById = this.c.findViewById(d.f.s);
        final int o = d.f.O;
        final View viewById2 = viewById.findViewById(o);
        final int m = d.f.m;
        final View viewById3 = viewById.findViewById(m);
        final int k = d.f.k;
        final View viewById4 = viewById.findViewById(k);
        final ViewGroup viewGroup = (ViewGroup)viewById.findViewById(d.f.o);
        this.v(viewGroup);
        final View viewById5 = viewGroup.findViewById(o);
        final View viewById6 = viewGroup.findViewById(m);
        final View viewById7 = viewGroup.findViewById(k);
        final ViewGroup h = this.h(viewById5, viewById2);
        final ViewGroup h2 = this.h(viewById6, viewById3);
        final ViewGroup h3 = this.h(viewById7, viewById4);
        this.u(h2);
        this.t(h3);
        this.w(h);
        final int visibility = viewGroup.getVisibility();
        final int n = false ? 1 : 0;
        final boolean b = visibility != 8;
        final boolean b2 = h != null && h.getVisibility() != 8;
        final boolean b3 = h3 != null && h3.getVisibility() != 8;
        if (!b3 && h2 != null) {
            final View viewById8 = h2.findViewById(d.f.J);
            if (viewById8 != null) {
                viewById8.setVisibility(0);
            }
        }
        if (b2) {
            final NestedScrollView a = this.A;
            if (a != null) {
                a.setClipToPadding(true);
            }
            View viewById9 = null;
            if (this.f != null || this.g != null) {
                viewById9 = h.findViewById(d.f.M);
            }
            if (viewById9 != null) {
                viewById9.setVisibility(0);
            }
        }
        else if (h2 != null) {
            final View viewById10 = h2.findViewById(d.f.K);
            if (viewById10 != null) {
                viewById10.setVisibility(0);
            }
        }
        final ListView g = this.g;
        if (g instanceof RecycleListView) {
            ((RecycleListView)g).a(b2, b3);
        }
        if (!b) {
            Object o2 = this.g;
            if (o2 == null) {
                o2 = this.A;
            }
            if (o2 != null) {
                int n2 = n;
                if (b3) {
                    n2 = 2;
                }
                this.o(h2, (View)o2, (b2 ? 1 : 0) | n2, 3);
            }
        }
        final ListView g2 = this.g;
        if (g2 != null) {
            final ListAdapter h4 = this.H;
            if (h4 != null) {
                g2.setAdapter(h4);
                final int i = this.I;
                if (i > -1) {
                    g2.setItemChecked(i, true);
                    g2.setSelection(i);
                }
            }
        }
    }
    
    private static boolean y(final Context context) {
        final TypedValue typedValue = new TypedValue();
        final Resources$Theme theme = context.getTheme();
        final int m = a.m;
        boolean b = true;
        theme.resolveAttribute(m, typedValue, true);
        if (typedValue.data == 0) {
            b = false;
        }
        return b;
    }
    
    public int c(final int n) {
        final TypedValue typedValue = new TypedValue();
        this.a.getTheme().resolveAttribute(n, typedValue, true);
        return typedValue.resourceId;
    }
    
    public ListView d() {
        return this.g;
    }
    
    public void e() {
        this.b.setContentView(this.i());
        this.x();
    }
    
    public boolean f(final int n, final KeyEvent keyEvent) {
        final NestedScrollView a = this.A;
        return a != null && a.r(keyEvent);
    }
    
    public boolean g(final int n, final KeyEvent keyEvent) {
        final NestedScrollView a = this.A;
        return a != null && a.r(keyEvent);
    }
    
    public void j(final int n, final CharSequence x, final DialogInterface$OnClickListener dialogInterface$OnClickListener, final Message message, final Drawable z) {
        Message obtainMessage = message;
        if (message == null) {
            obtainMessage = message;
            if (dialogInterface$OnClickListener != null) {
                obtainMessage = this.R.obtainMessage(n, (Object)dialogInterface$OnClickListener);
            }
        }
        if (n != -3) {
            if (n != -2) {
                if (n != -1) {
                    throw new IllegalArgumentException("Button does not exist");
                }
                this.p = x;
                this.q = obtainMessage;
                this.r = z;
            }
            else {
                this.t = x;
                this.u = obtainMessage;
                this.v = z;
            }
        }
        else {
            this.x = x;
            this.y = obtainMessage;
            this.z = z;
        }
    }
    
    public void k(final View g) {
        this.G = g;
    }
    
    public void l(final int b) {
        this.C = null;
        this.B = b;
        final ImageView d = this.D;
        if (d != null) {
            if (b != 0) {
                d.setVisibility(0);
                this.D.setImageResource(this.B);
            }
            else {
                d.setVisibility(8);
            }
        }
    }
    
    public void m(final Drawable drawable) {
        this.C = drawable;
        this.B = 0;
        final ImageView d = this.D;
        if (d != null) {
            if (drawable != null) {
                d.setVisibility(0);
                this.D.setImageDrawable(drawable);
            }
            else {
                d.setVisibility(8);
            }
        }
    }
    
    public void n(final CharSequence charSequence) {
        this.f = charSequence;
        final TextView f = this.F;
        if (f != null) {
            f.setText(charSequence);
        }
    }
    
    public void p(final CharSequence charSequence) {
        this.e = charSequence;
        final TextView e = this.E;
        if (e != null) {
            e.setText(charSequence);
        }
    }
    
    public void q(final int i) {
        this.h = null;
        this.i = i;
        this.n = false;
    }
    
    public void r(final View h) {
        this.h = h;
        this.i = 0;
        this.n = false;
    }
    
    public void s(final View h, final int j, final int k, final int l, final int m) {
        this.h = h;
        this.i = 0;
        this.n = true;
        this.j = j;
        this.k = k;
        this.l = l;
        this.m = m;
    }
    
    public static class RecycleListView extends ListView
    {
        private final int a;
        private final int b;
        
        public RecycleListView(final Context context, final AttributeSet set) {
            super(context, set);
            final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, j.c2);
            this.b = obtainStyledAttributes.getDimensionPixelOffset(j.d2, -1);
            this.a = obtainStyledAttributes.getDimensionPixelOffset(j.e2, -1);
        }
        
        public void a(final boolean b, final boolean b2) {
            if (!b2 || !b) {
                final int paddingLeft = this.getPaddingLeft();
                int n;
                if (b) {
                    n = this.getPaddingTop();
                }
                else {
                    n = this.a;
                }
                final int paddingRight = this.getPaddingRight();
                int n2;
                if (b2) {
                    n2 = this.getPaddingBottom();
                }
                else {
                    n2 = this.b;
                }
                this.setPadding(paddingLeft, n, paddingRight, n2);
            }
        }
    }
    
    public static class b
    {
        public int A;
        public int B;
        public int C;
        public int D;
        public boolean E;
        public boolean[] F;
        public boolean G;
        public boolean H;
        public int I;
        public DialogInterface$OnMultiChoiceClickListener J;
        public Cursor K;
        public String L;
        public String M;
        public AdapterView$OnItemSelectedListener N;
        public e O;
        public boolean P;
        public final Context a;
        public final LayoutInflater b;
        public int c;
        public Drawable d;
        public int e;
        public CharSequence f;
        public View g;
        public CharSequence h;
        public CharSequence i;
        public Drawable j;
        public DialogInterface$OnClickListener k;
        public CharSequence l;
        public Drawable m;
        public DialogInterface$OnClickListener n;
        public CharSequence o;
        public Drawable p;
        public DialogInterface$OnClickListener q;
        public boolean r;
        public DialogInterface$OnCancelListener s;
        public DialogInterface$OnDismissListener t;
        public DialogInterface$OnKeyListener u;
        public CharSequence[] v;
        public ListAdapter w;
        public DialogInterface$OnClickListener x;
        public int y;
        public View z;
        
        public b(final Context a) {
            this.c = 0;
            this.e = 0;
            this.E = false;
            this.I = -1;
            this.P = true;
            this.a = a;
            this.r = true;
            this.b = (LayoutInflater)a.getSystemService("layout_inflater");
        }
        
        private void b(final AlertController alertController) {
            final RecycleListView g = (RecycleListView)this.b.inflate(alertController.L, (ViewGroup)null);
            Object w;
            if (this.G) {
                if (this.K == null) {
                    w = new ArrayAdapter<CharSequence>(this, this.a, alertController.M, 16908308, this.v, g) {
                        final RecycleListView a;
                        final b b;
                        
                        public View getView(final int n, final View view, final ViewGroup viewGroup) {
                            final View view2 = super.getView(n, view, viewGroup);
                            final boolean[] f = this.b.F;
                            if (f != null && f[n]) {
                                this.a.setItemChecked(n, true);
                            }
                            return view2;
                        }
                    };
                }
                else {
                    w = new CursorAdapter(this, this.a, this.K, false, g, alertController) {
                        private final int a;
                        private final int b;
                        final RecycleListView c;
                        final AlertController d;
                        final b e;
                        
                        {
                            final Cursor cursor2 = this.getCursor();
                            this.a = cursor2.getColumnIndexOrThrow(e.L);
                            this.b = cursor2.getColumnIndexOrThrow(e.M);
                        }
                        
                        public void bindView(final View view, final Context context, final Cursor cursor) {
                            ((CheckedTextView)view.findViewById(16908308)).setText((CharSequence)cursor.getString(this.a));
                            final RecycleListView c = this.c;
                            final int position = cursor.getPosition();
                            final int int1 = cursor.getInt(this.b);
                            boolean b = true;
                            if (int1 != 1) {
                                b = false;
                            }
                            c.setItemChecked(position, b);
                        }
                        
                        public View newView(final Context context, final Cursor cursor, final ViewGroup viewGroup) {
                            return this.e.b.inflate(this.d.M, viewGroup, false);
                        }
                    };
                }
            }
            else {
                int n;
                if (this.H) {
                    n = alertController.N;
                }
                else {
                    n = alertController.O;
                }
                if (this.K != null) {
                    w = new SimpleCursorAdapter(this.a, n, this.K, new String[] { this.L }, new int[] { 16908308 });
                }
                else {
                    w = this.w;
                    if (w == null) {
                        w = new d(this.a, n, 16908308, this.v);
                    }
                }
            }
            final e o = this.O;
            if (o != null) {
                o.a(g);
            }
            alertController.H = (ListAdapter)w;
            alertController.I = this.I;
            if (this.x != null) {
                g.setOnItemClickListener((AdapterView$OnItemClickListener)new AdapterView$OnItemClickListener(this, alertController) {
                    final AlertController a;
                    final b b;
                    
                    public void onItemClick(final AdapterView<?> adapterView, final View view, final int n, final long n2) {
                        this.b.x.onClick((DialogInterface)this.a.b, n);
                        if (!this.b.H) {
                            this.a.b.dismiss();
                        }
                    }
                });
            }
            else if (this.J != null) {
                g.setOnItemClickListener((AdapterView$OnItemClickListener)new AdapterView$OnItemClickListener(this, g, alertController) {
                    final RecycleListView a;
                    final AlertController b;
                    final b c;
                    
                    public void onItemClick(final AdapterView<?> adapterView, final View view, final int n, final long n2) {
                        final boolean[] f = this.c.F;
                        if (f != null) {
                            f[n] = this.a.isItemChecked(n);
                        }
                        this.c.J.onClick((DialogInterface)this.b.b, n, this.a.isItemChecked(n));
                    }
                });
            }
            final AdapterView$OnItemSelectedListener n2 = this.N;
            if (n2 != null) {
                g.setOnItemSelectedListener(n2);
            }
            if (this.H) {
                g.setChoiceMode(1);
            }
            else if (this.G) {
                g.setChoiceMode(2);
            }
            alertController.g = g;
        }
        
        public void a(final AlertController alertController) {
            final View g = this.g;
            if (g != null) {
                alertController.k(g);
            }
            else {
                final CharSequence f = this.f;
                if (f != null) {
                    alertController.p(f);
                }
                final Drawable d = this.d;
                if (d != null) {
                    alertController.m(d);
                }
                final int c = this.c;
                if (c != 0) {
                    alertController.l(c);
                }
                final int e = this.e;
                if (e != 0) {
                    alertController.l(alertController.c(e));
                }
            }
            final CharSequence h = this.h;
            if (h != null) {
                alertController.n(h);
            }
            final CharSequence i = this.i;
            if (i != null || this.j != null) {
                alertController.j(-1, i, this.k, null, this.j);
            }
            final CharSequence l = this.l;
            if (l != null || this.m != null) {
                alertController.j(-2, l, this.n, null, this.m);
            }
            final CharSequence o = this.o;
            if (o != null || this.p != null) {
                alertController.j(-3, o, this.q, null, this.p);
            }
            if (this.v != null || this.K != null || this.w != null) {
                this.b(alertController);
            }
            final View z = this.z;
            if (z != null) {
                if (this.E) {
                    alertController.s(z, this.A, this.B, this.C, this.D);
                }
                else {
                    alertController.r(z);
                }
            }
            else {
                final int y = this.y;
                if (y != 0) {
                    alertController.q(y);
                }
            }
        }
        
        public interface e
        {
            void a(final ListView p0);
        }
    }
    
    private static final class c extends Handler
    {
        private WeakReference<DialogInterface> a;
        
        public c(final DialogInterface dialogInterface) {
            this.a = new WeakReference<DialogInterface>(dialogInterface);
        }
        
        public void handleMessage(final Message message) {
            final int what = message.what;
            if (what != -3 && what != -2 && what != -1) {
                if (what == 1) {
                    ((DialogInterface)message.obj).dismiss();
                }
            }
            else {
                ((DialogInterface$OnClickListener)message.obj).onClick((DialogInterface)this.a.get(), message.what);
            }
        }
    }
    
    private static class d extends ArrayAdapter<CharSequence>
    {
        public d(final Context context, final int n, final int n2, final CharSequence[] array) {
            super(context, n, n2, (Object[])array);
        }
        
        public long getItemId(final int n) {
            return n;
        }
        
        public boolean hasStableIds() {
            return true;
        }
    }
}
