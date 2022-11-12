// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.ui;

import java.util.Collections;
import com.google.android.exoplayer2.trackselection.TrackSelectionOverride;
import com.google.android.exoplayer2.source.TrackGroup;
import java.util.ArrayList;
import com.google.android.exoplayer2.util.RepeatModeUtil;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.ForwardingPlayer;
import android.os.Looper;
import java.util.Iterator;
import android.view.KeyEvent;
import java.util.List;
import com.google.android.exoplayer2.Format;
import com.google.common.collect.ImmutableList$Builder;
import com.google.common.collect.ImmutableList;
import com.google.android.exoplayer2.Tracks;
import java.util.Arrays;
import com.google.android.exoplayer2.util.Assertions;
import android.graphics.Typeface;
import android.view.View$OnLayoutChangeListener;
import e4.d;
import android.widget.PopupWindow$OnDismissListener;
import android.graphics.drawable.ColorDrawable;
import com.google.android.exoplayer2.util.Util;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.core.content.res.f;
import e4.c;
import android.view.View$OnClickListener;
import e4.e;
import java.util.Locale;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.content.Context;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import android.widget.PopupWindow;
import androidx.recyclerview.widget.RecyclerView;
import android.content.res.Resources;
import android.widget.TextView;
import com.google.android.exoplayer2.Player;
import java.util.concurrent.CopyOnWriteArrayList;
import android.view.View;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.google.android.exoplayer2.Timeline;
import java.util.Formatter;
import android.widget.FrameLayout;

public class StyledPlayerControlView extends FrameLayout
{
    private static final float[] J0;
    private final StringBuilder A;
    private h A0;
    private final Formatter B;
    private b B0;
    private final Timeline.Period C;
    private TrackNameProvider C0;
    private final Timeline.Window D;
    private ImageView D0;
    private final Runnable E;
    private ImageView E0;
    private final Drawable F;
    private ImageView F0;
    private final Drawable G;
    private View G0;
    private final Drawable H;
    private View H0;
    private final String I;
    private View I0;
    private final String J;
    private final String K;
    private final Drawable L;
    private final Drawable M;
    private final float N;
    private final float O;
    private final String P;
    private final String Q;
    private final Drawable R;
    private final Drawable S;
    private final String T;
    private final String U;
    private final Drawable V;
    private final Drawable W;
    private final c a;
    private final String a0;
    private final CopyOnWriteArrayList<VisibilityListener> b;
    private final String b0;
    private final View c;
    private Player c0;
    private final View d;
    private ProgressUpdateListener d0;
    private final View e;
    private OnFullScreenModeChangedListener e0;
    private final View f;
    private boolean f0;
    private final View g;
    private boolean g0;
    private final TextView h;
    private boolean h0;
    private final TextView i;
    private boolean i0;
    private final ImageView j;
    private boolean j0;
    private int k0;
    private int l0;
    private int m0;
    private long[] n0;
    private boolean[] o0;
    private final ImageView p;
    private long[] p0;
    private boolean[] q0;
    private long r0;
    private x s0;
    private Resources t0;
    private RecyclerView u0;
    private f v0;
    private final View w;
    private d w0;
    private final TextView x;
    private PopupWindow x0;
    private final TextView y;
    private boolean y0;
    private final TimeBar z;
    private int z0;
    
    static {
        ExoPlayerLibraryInfo.a("goog.exo.ui");
        J0 = new float[] { 0.25f, 0.5f, 0.75f, 1.0f, 1.25f, 1.5f, 2.0f };
    }
    
    public StyledPlayerControlView(final Context context, AttributeSet obtainStyledAttributes, int id, final AttributeSet set) {
        super(context, obtainStyledAttributes, id);
        final int b = com.google.android.exoplayer2.ui.R.layout.b;
        this.k0 = 5000;
        this.m0 = 0;
        this.l0 = 200;
        boolean boolean1 = false;
        boolean boolean2 = false;
        boolean boolean3 = false;
        boolean boolean4 = false;
        boolean boolean7 = false;
        boolean boolean8 = false;
        boolean b2 = false;
        boolean b3 = false;
        Label_0256: {
            if (set != null) {
                obtainStyledAttributes = (AttributeSet)context.getTheme().obtainStyledAttributes(set, com.google.android.exoplayer2.ui.R.styleable.A, id, 0);
                try {
                    id = ((TypedArray)obtainStyledAttributes).getResourceId(com.google.android.exoplayer2.ui.R.styleable.C, b);
                    this.k0 = ((TypedArray)obtainStyledAttributes).getInt(com.google.android.exoplayer2.ui.R.styleable.K, this.k0);
                    this.m0 = a0((TypedArray)obtainStyledAttributes, this.m0);
                    boolean1 = ((TypedArray)obtainStyledAttributes).getBoolean(com.google.android.exoplayer2.ui.R.styleable.H, true);
                    boolean2 = ((TypedArray)obtainStyledAttributes).getBoolean(com.google.android.exoplayer2.ui.R.styleable.E, true);
                    boolean3 = ((TypedArray)obtainStyledAttributes).getBoolean(com.google.android.exoplayer2.ui.R.styleable.G, true);
                    boolean4 = ((TypedArray)obtainStyledAttributes).getBoolean(com.google.android.exoplayer2.ui.R.styleable.F, true);
                    final boolean boolean5 = ((TypedArray)obtainStyledAttributes).getBoolean(com.google.android.exoplayer2.ui.R.styleable.I, false);
                    final boolean boolean6 = ((TypedArray)obtainStyledAttributes).getBoolean(com.google.android.exoplayer2.ui.R.styleable.J, false);
                    boolean7 = ((TypedArray)obtainStyledAttributes).getBoolean(com.google.android.exoplayer2.ui.R.styleable.L, false);
                    this.setTimeBarMinUpdateInterval(((TypedArray)obtainStyledAttributes).getInt(com.google.android.exoplayer2.ui.R.styleable.M, this.l0));
                    boolean8 = ((TypedArray)obtainStyledAttributes).getBoolean(com.google.android.exoplayer2.ui.R.styleable.B, true);
                    ((TypedArray)obtainStyledAttributes).recycle();
                    b2 = boolean1;
                    boolean1 = boolean2;
                    boolean2 = boolean3;
                    boolean3 = boolean5;
                    b3 = boolean6;
                    break Label_0256;
                }
                finally {
                    ((TypedArray)obtainStyledAttributes).recycle();
                }
            }
            boolean7 = false;
            boolean3 = (b3 = false);
            boolean8 = true;
            final boolean b4;
            b2 = (b4 = true);
            boolean4 = (boolean2 = b4);
            boolean1 = b4;
            id = b;
        }
        LayoutInflater.from(context).inflate(id, (ViewGroup)this);
        this.setDescendantFocusability(262144);
        final c onDismissListener = new c(null);
        this.a = onDismissListener;
        this.b = new CopyOnWriteArrayList<VisibilityListener>();
        this.C = new Timeline.Period();
        this.D = new Timeline.Window();
        final StringBuilder a = new StringBuilder();
        this.A = a;
        this.B = new Formatter(a, Locale.getDefault());
        this.n0 = new long[0];
        this.o0 = new boolean[0];
        this.p0 = new long[0];
        this.q0 = new boolean[0];
        this.E = (Runnable)new e4.e(this);
        this.x = (TextView)this.findViewById(com.google.android.exoplayer2.ui.R.id.m);
        this.y = (TextView)this.findViewById(com.google.android.exoplayer2.ui.R.id.D);
        final ImageView d0 = (ImageView)this.findViewById(com.google.android.exoplayer2.ui.R.id.O);
        this.D0 = d0;
        if (d0 != null) {
            d0.setOnClickListener((View$OnClickListener)onDismissListener);
        }
        e0((View)(this.E0 = (ImageView)this.findViewById(com.google.android.exoplayer2.ui.R.id.s)), (View$OnClickListener)new e4.c(this));
        e0((View)(this.F0 = (ImageView)this.findViewById(com.google.android.exoplayer2.ui.R.id.w)), (View$OnClickListener)new e4.c(this));
        final View viewById = this.findViewById(com.google.android.exoplayer2.ui.R.id.K);
        if ((this.G0 = viewById) != null) {
            viewById.setOnClickListener((View$OnClickListener)onDismissListener);
        }
        final View viewById2 = this.findViewById(com.google.android.exoplayer2.ui.R.id.C);
        if ((this.H0 = viewById2) != null) {
            viewById2.setOnClickListener((View$OnClickListener)onDismissListener);
        }
        final View viewById3 = this.findViewById(com.google.android.exoplayer2.ui.R.id.c);
        if ((this.I0 = viewById3) != null) {
            viewById3.setOnClickListener((View$OnClickListener)onDismissListener);
        }
        id = com.google.android.exoplayer2.ui.R.id.F;
        final TimeBar z = (TimeBar)this.findViewById(id);
        final View viewById4 = this.findViewById(com.google.android.exoplayer2.ui.R.id.G);
        if (z != null) {
            this.z = z;
        }
        else if (viewById4 != null) {
            final DefaultTimeBar z2 = new DefaultTimeBar(context, null, 0, set, com.google.android.exoplayer2.ui.R.style.a);
            z2.setId(id);
            z2.setLayoutParams(viewById4.getLayoutParams());
            final ViewGroup viewGroup = (ViewGroup)viewById4.getParent();
            id = viewGroup.indexOfChild(viewById4);
            viewGroup.removeView(viewById4);
            viewGroup.addView((View)z2, id);
            this.z = z2;
        }
        else {
            this.z = null;
        }
        final TimeBar z3 = this.z;
        if (z3 != null) {
            z3.a((TimeBar.OnScrubListener)onDismissListener);
        }
        final View viewById5 = this.findViewById(com.google.android.exoplayer2.ui.R.id.B);
        if ((this.e = viewById5) != null) {
            viewById5.setOnClickListener((View$OnClickListener)onDismissListener);
        }
        final View viewById6 = this.findViewById(com.google.android.exoplayer2.ui.R.id.E);
        if ((this.c = viewById6) != null) {
            viewById6.setOnClickListener((View$OnClickListener)onDismissListener);
        }
        final View viewById7 = this.findViewById(com.google.android.exoplayer2.ui.R.id.x);
        if ((this.d = viewById7) != null) {
            viewById7.setOnClickListener((View$OnClickListener)onDismissListener);
        }
        final Typeface h = androidx.core.content.res.f.h(context, com.google.android.exoplayer2.ui.R.font.a);
        final View viewById8 = this.findViewById(com.google.android.exoplayer2.ui.R.id.I);
        TextView i;
        if (viewById8 == null) {
            i = (TextView)this.findViewById(com.google.android.exoplayer2.ui.R.id.J);
        }
        else {
            i = null;
        }
        this.i = i;
        if (i != null) {
            i.setTypeface(h);
        }
        Object g;
        if ((g = viewById8) == null) {
            g = i;
        }
        if ((this.g = (View)g) != null) {
            ((View)g).setOnClickListener((View$OnClickListener)onDismissListener);
        }
        final View viewById9 = this.findViewById(com.google.android.exoplayer2.ui.R.id.q);
        TextView h2;
        if (viewById9 == null) {
            h2 = (TextView)this.findViewById(com.google.android.exoplayer2.ui.R.id.r);
        }
        else {
            h2 = null;
        }
        this.h = h2;
        if (h2 != null) {
            h2.setTypeface(h);
        }
        Object f;
        if ((f = viewById9) == null) {
            f = h2;
        }
        if ((this.f = (View)f) != null) {
            ((View)f).setOnClickListener((View$OnClickListener)onDismissListener);
        }
        final ImageView j = (ImageView)this.findViewById(com.google.android.exoplayer2.ui.R.id.H);
        if ((this.j = j) != null) {
            j.setOnClickListener((View$OnClickListener)onDismissListener);
        }
        final ImageView p4 = (ImageView)this.findViewById(com.google.android.exoplayer2.ui.R.id.L);
        if ((this.p = p4) != null) {
            p4.setOnClickListener((View$OnClickListener)onDismissListener);
        }
        final Resources resources = context.getResources();
        this.t0 = resources;
        this.N = resources.getInteger(com.google.android.exoplayer2.ui.R.integer.b) / 100.0f;
        this.O = this.t0.getInteger(com.google.android.exoplayer2.ui.R.integer.a) / 100.0f;
        final View viewById10 = this.findViewById(com.google.android.exoplayer2.ui.R.id.S);
        if ((this.w = viewById10) != null) {
            this.t0(false, viewById10);
        }
        (this.s0 = new x(this)).X(boolean8);
        this.v0 = new f(new String[] { this.t0.getString(com.google.android.exoplayer2.ui.R.string.h), this.t0.getString(com.google.android.exoplayer2.ui.R.string.y) }, new Drawable[] { this.t0.getDrawable(com.google.android.exoplayer2.ui.R.drawable.l), this.t0.getDrawable(com.google.android.exoplayer2.ui.R.drawable.b) });
        this.z0 = this.t0.getDimensionPixelSize(com.google.android.exoplayer2.ui.R.dimen.a);
        (this.u0 = (RecyclerView)LayoutInflater.from(context).inflate(com.google.android.exoplayer2.ui.R.layout.d, (ViewGroup)null)).setAdapter((RecyclerView.Adapter)this.v0);
        this.u0.setLayoutManager((RecyclerView.o)new LinearLayoutManager(this.getContext()));
        final PopupWindow x0 = new PopupWindow((View)this.u0, -2, -2, true);
        this.x0 = x0;
        if (Util.a < 23) {
            x0.setBackgroundDrawable((Drawable)new ColorDrawable(0));
        }
        this.x0.setOnDismissListener((PopupWindow$OnDismissListener)onDismissListener);
        this.y0 = true;
        this.C0 = new DefaultTrackNameProvider(this.getResources());
        this.R = this.t0.getDrawable(com.google.android.exoplayer2.ui.R.drawable.n);
        this.S = this.t0.getDrawable(com.google.android.exoplayer2.ui.R.drawable.m);
        this.T = this.t0.getString(com.google.android.exoplayer2.ui.R.string.b);
        this.U = this.t0.getString(com.google.android.exoplayer2.ui.R.string.a);
        this.A0 = new h(null);
        this.B0 = new b(null);
        this.w0 = new d(this.t0.getStringArray(com.google.android.exoplayer2.ui.R.array.a), StyledPlayerControlView.J0);
        this.V = this.t0.getDrawable(com.google.android.exoplayer2.ui.R.drawable.d);
        this.W = this.t0.getDrawable(com.google.android.exoplayer2.ui.R.drawable.c);
        this.F = this.t0.getDrawable(com.google.android.exoplayer2.ui.R.drawable.h);
        this.G = this.t0.getDrawable(com.google.android.exoplayer2.ui.R.drawable.i);
        this.H = this.t0.getDrawable(com.google.android.exoplayer2.ui.R.drawable.g);
        this.L = this.t0.getDrawable(com.google.android.exoplayer2.ui.R.drawable.k);
        this.M = this.t0.getDrawable(com.google.android.exoplayer2.ui.R.drawable.j);
        this.a0 = this.t0.getString(com.google.android.exoplayer2.ui.R.string.d);
        this.b0 = this.t0.getString(com.google.android.exoplayer2.ui.R.string.c);
        this.I = this.t0.getString(com.google.android.exoplayer2.ui.R.string.j);
        this.J = this.t0.getString(com.google.android.exoplayer2.ui.R.string.k);
        this.K = this.t0.getString(com.google.android.exoplayer2.ui.R.string.i);
        this.P = this.t0.getString(com.google.android.exoplayer2.ui.R.string.n);
        this.Q = this.t0.getString(com.google.android.exoplayer2.ui.R.string.m);
        this.s0.Y(this.findViewById(com.google.android.exoplayer2.ui.R.id.e), true);
        this.s0.Y(this.f, boolean1);
        this.s0.Y(this.g, b2);
        this.s0.Y(this.c, boolean2);
        this.s0.Y(this.d, boolean4);
        this.s0.Y((View)this.p, boolean3);
        this.s0.Y((View)this.D0, b3);
        this.s0.Y(this.w, boolean7);
        this.s0.Y((View)this.j, this.m0 != 0);
        this.addOnLayoutChangeListener((View$OnLayoutChangeListener)new e4.d(this));
    }
    
    static d A(final StyledPlayerControlView styledPlayerControlView) {
        return styledPlayerControlView.w0;
    }
    
    private void A0() {
        if (this.h0()) {
            if (this.g0) {
                final Player c0 = this.c0;
                long position = 0L;
                long bufferedPosition;
                if (c0 != null) {
                    position = this.r0 + c0.R();
                    bufferedPosition = this.r0 + c0.c0();
                }
                else {
                    bufferedPosition = 0L;
                }
                final TextView y = this.y;
                if (y != null && !this.j0) {
                    y.setText((CharSequence)Util.h0(this.A, this.B, position));
                }
                final TimeBar z = this.z;
                if (z != null) {
                    z.setPosition(position);
                    this.z.setBufferedPosition(bufferedPosition);
                }
                final ProgressUpdateListener d0 = this.d0;
                if (d0 != null) {
                    d0.a(position, bufferedPosition);
                }
                this.removeCallbacks(this.E);
                int playbackState;
                if (c0 == null) {
                    playbackState = 1;
                }
                else {
                    playbackState = c0.getPlaybackState();
                }
                final long n = 1000L;
                if (c0 != null && c0.X()) {
                    final TimeBar z2 = this.z;
                    long preferredUpdateDelay;
                    if (z2 != null) {
                        preferredUpdateDelay = z2.getPreferredUpdateDelay();
                    }
                    else {
                        preferredUpdateDelay = 1000L;
                    }
                    final long min = Math.min(preferredUpdateDelay, 1000L - position % 1000L);
                    final float a = c0.b().a;
                    long n2 = n;
                    if (a > 0.0f) {
                        n2 = (long)(min / a);
                    }
                    this.postDelayed(this.E, Util.r(n2, this.l0, 1000L));
                }
                else if (playbackState != 4 && playbackState != 1) {
                    this.postDelayed(this.E, 1000L);
                }
            }
        }
    }
    
    static View B(final StyledPlayerControlView styledPlayerControlView) {
        return styledPlayerControlView.I0;
    }
    
    private void B0() {
        if (this.h0() && this.g0) {
            final ImageView j = this.j;
            if (j != null) {
                if (this.m0 == 0) {
                    this.t0(false, (View)j);
                    return;
                }
                final Player c0 = this.c0;
                if (c0 == null) {
                    this.t0(false, (View)j);
                    this.j.setImageDrawable(this.F);
                    this.j.setContentDescription((CharSequence)this.I);
                    return;
                }
                this.t0(true, (View)j);
                final int repeatMode = c0.getRepeatMode();
                if (repeatMode != 0) {
                    if (repeatMode != 1) {
                        if (repeatMode == 2) {
                            this.j.setImageDrawable(this.H);
                            this.j.setContentDescription((CharSequence)this.K);
                        }
                    }
                    else {
                        this.j.setImageDrawable(this.G);
                        this.j.setContentDescription((CharSequence)this.J);
                    }
                }
                else {
                    this.j.setImageDrawable(this.F);
                    this.j.setContentDescription((CharSequence)this.I);
                }
            }
        }
    }
    
    static b C(final StyledPlayerControlView styledPlayerControlView) {
        return styledPlayerControlView.B0;
    }
    
    private void C0() {
        final Player c0 = this.c0;
        long h0;
        if (c0 != null) {
            h0 = c0.h0();
        }
        else {
            h0 = 5000L;
        }
        final int n = (int)(h0 / 1000L);
        final TextView i = this.i;
        if (i != null) {
            i.setText((CharSequence)String.valueOf(n));
        }
        final View g = this.g;
        if (g != null) {
            g.setContentDescription((CharSequence)this.t0.getQuantityString(com.google.android.exoplayer2.ui.R.plurals.b, n, new Object[] { n }));
        }
    }
    
    static ImageView D(final StyledPlayerControlView styledPlayerControlView) {
        return styledPlayerControlView.D0;
    }
    
    private void D0() {
        this.u0.measure(0, 0);
        this.x0.setWidth(Math.min(this.u0.getMeasuredWidth(), this.getWidth() - this.z0 * 2));
        this.x0.setHeight(Math.min(this.getHeight() - this.z0 * 2, this.u0.getMeasuredHeight()));
    }
    
    static h E(final StyledPlayerControlView styledPlayerControlView) {
        return styledPlayerControlView.A0;
    }
    
    private void E0() {
        if (this.h0() && this.g0) {
            final ImageView p = this.p;
            if (p != null) {
                final Player c0 = this.c0;
                if (!this.s0.A((View)p)) {
                    this.t0(false, (View)this.p);
                }
                else if (c0 == null) {
                    this.t0(false, (View)this.p);
                    this.p.setImageDrawable(this.M);
                    this.p.setContentDescription((CharSequence)this.Q);
                }
                else {
                    this.t0(true, (View)this.p);
                    final ImageView p2 = this.p;
                    Drawable imageDrawable;
                    if (c0.b0()) {
                        imageDrawable = this.L;
                    }
                    else {
                        imageDrawable = this.M;
                    }
                    p2.setImageDrawable(imageDrawable);
                    final ImageView p3 = this.p;
                    String contentDescription;
                    if (c0.b0()) {
                        contentDescription = this.P;
                    }
                    else {
                        contentDescription = this.Q;
                    }
                    p3.setContentDescription((CharSequence)contentDescription);
                }
            }
        }
    }
    
    static void F(final StyledPlayerControlView styledPlayerControlView) {
        styledPlayerControlView.A0();
    }
    
    private void F0() {
        final Player c0 = this.c0;
        if (c0 == null) {
            return;
        }
        this.i0 = (this.h0 && T(c0.w(), this.D));
        long n = 0L;
        this.r0 = 0L;
        final Timeline w = c0.w();
        int n3;
        if (!w.u()) {
            final int y = c0.Y();
            final boolean i0 = this.i0;
            int j;
            if (i0) {
                j = 0;
            }
            else {
                j = y;
            }
            int n2;
            if (i0) {
                n2 = w.t() - 1;
            }
            else {
                n2 = y;
            }
            n = 0L;
            n3 = 0;
            while (j <= n2) {
                if (j == y) {
                    this.r0 = Util.f1(n);
                }
                w.r(j, this.D);
                final Timeline.Window d = this.D;
                if (d.y == -9223372036854775807L) {
                    Assertions.g(this.i0 ^ true);
                    break;
                }
                int z = d.z;
                Timeline.Window d2;
                while (true) {
                    d2 = this.D;
                    if (z > d2.A) {
                        break;
                    }
                    w.j(z, this.C);
                    int n5;
                    for (int k = this.C.s(); k < this.C.f(); ++k, n3 = n5) {
                        long n4;
                        if ((n4 = this.C.i(k)) == Long.MIN_VALUE) {
                            n4 = this.C.d;
                            if (n4 == -9223372036854775807L) {
                                n5 = n3;
                                continue;
                            }
                        }
                        final long n6 = n4 + this.C.r();
                        n5 = n3;
                        if (n6 >= 0L) {
                            final long[] n7 = this.n0;
                            if (n3 == n7.length) {
                                int n8;
                                if (n7.length == 0) {
                                    n8 = 1;
                                }
                                else {
                                    n8 = n7.length * 2;
                                }
                                this.n0 = Arrays.copyOf(n7, n8);
                                this.o0 = Arrays.copyOf(this.o0, n8);
                            }
                            this.n0[n3] = Util.f1(n + n6);
                            this.o0[n3] = this.C.t(k);
                            n5 = n3 + 1;
                        }
                    }
                    ++z;
                }
                n += d2.y;
                ++j;
            }
        }
        else {
            n3 = 0;
        }
        final long f1 = Util.f1(n);
        final TextView x = this.x;
        if (x != null) {
            x.setText((CharSequence)Util.h0(this.A, this.B, f1));
        }
        final TimeBar z2 = this.z;
        if (z2 != null) {
            z2.setDuration(f1);
            final int length = this.p0.length;
            final int n9 = n3 + length;
            final long[] n10 = this.n0;
            if (n9 > n10.length) {
                this.n0 = Arrays.copyOf(n10, n9);
                this.o0 = Arrays.copyOf(this.o0, n9);
            }
            System.arraycopy(this.p0, 0, this.n0, n3, length);
            System.arraycopy(this.q0, 0, this.o0, n3, length);
            this.z.b(this.n0, this.o0, n9);
        }
        this.A0();
    }
    
    static void G(final StyledPlayerControlView styledPlayerControlView, final int n) {
        styledPlayerControlView.l0(n);
    }
    
    private void G0() {
        this.d0();
        this.t0(((j)this.A0).getItemCount() > 0, (View)this.D0);
    }
    
    static void H(final StyledPlayerControlView styledPlayerControlView, final float playbackSpeed) {
        styledPlayerControlView.setPlaybackSpeed(playbackSpeed);
    }
    
    static PopupWindow I(final StyledPlayerControlView styledPlayerControlView) {
        return styledPlayerControlView.x0;
    }
    
    static Drawable J(final StyledPlayerControlView styledPlayerControlView) {
        return styledPlayerControlView.R;
    }
    
    static Drawable K(final StyledPlayerControlView styledPlayerControlView) {
        return styledPlayerControlView.S;
    }
    
    static String L(final StyledPlayerControlView styledPlayerControlView) {
        return styledPlayerControlView.T;
    }
    
    static String M(final StyledPlayerControlView styledPlayerControlView) {
        return styledPlayerControlView.U;
    }
    
    static void N(final StyledPlayerControlView styledPlayerControlView) {
        styledPlayerControlView.B0();
    }
    
    static void O(final StyledPlayerControlView styledPlayerControlView) {
        styledPlayerControlView.E0();
    }
    
    static void P(final StyledPlayerControlView styledPlayerControlView) {
        styledPlayerControlView.x0();
    }
    
    static void Q(final StyledPlayerControlView styledPlayerControlView) {
        styledPlayerControlView.F0();
    }
    
    static void R(final StyledPlayerControlView styledPlayerControlView) {
        styledPlayerControlView.z0();
    }
    
    private static boolean T(final Timeline timeline, final Timeline.Window window) {
        if (timeline.t() > 100) {
            return false;
        }
        for (int t = timeline.t(), i = 0; i < t; ++i) {
            if (timeline.r(i, window).y == -9223372036854775807L) {
                return false;
            }
        }
        return true;
    }
    
    private void V(final Player player) {
        player.pause();
    }
    
    private void W(final Player player) {
        final int playbackState = player.getPlaybackState();
        if (playbackState == 1) {
            player.prepare();
        }
        else if (playbackState == 4) {
            this.o0(player, player.Y(), -9223372036854775807L);
        }
        player.play();
    }
    
    private void X(final Player player) {
        final int playbackState = player.getPlaybackState();
        if (playbackState != 1 && playbackState != 4 && player.E()) {
            this.V(player);
        }
        else {
            this.W(player);
        }
    }
    
    private void Y(final RecyclerView.Adapter<?> adapter) {
        this.u0.setAdapter((RecyclerView.Adapter)adapter);
        this.D0();
        this.y0 = false;
        this.x0.dismiss();
        this.y0 = true;
        this.x0.showAsDropDown((View)this, this.getWidth() - this.x0.getWidth() - this.z0, -this.x0.getHeight() - this.z0);
    }
    
    private ImmutableList<i> Z(final Tracks tracks, final int n) {
        final ImmutableList$Builder immutableList$Builder = new ImmutableList$Builder();
        final ImmutableList<Tracks.Group> b = tracks.b();
        for (int i = 0; i < ((List)b).size(); ++i) {
            final Tracks.Group group = ((List<Tracks.Group>)b).get(i);
            if (group.e() == n) {
                for (int j = 0; j < group.a; ++j) {
                    if (group.i(j)) {
                        final Format c = group.c(j);
                        if ((c.d & 0x2) == 0x0) {
                            immutableList$Builder.i((Object)new i(tracks, i, j, this.C0.a(c)));
                        }
                    }
                }
            }
        }
        return (ImmutableList<i>)immutableList$Builder.l();
    }
    
    public static void a(final StyledPlayerControlView styledPlayerControlView, final View view) {
        styledPlayerControlView.j0(view);
    }
    
    private static int a0(final TypedArray typedArray, final int n) {
        return typedArray.getInt(R.styleable.D, n);
    }
    
    public static void b(final StyledPlayerControlView styledPlayerControlView) {
        styledPlayerControlView.A0();
    }
    
    public static void c(final StyledPlayerControlView styledPlayerControlView, final View view, final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7, final int n8) {
        styledPlayerControlView.k0(view, n, n2, n3, n4, n5, n6, n7, n8);
    }
    
    static void d(final StyledPlayerControlView styledPlayerControlView) {
        styledPlayerControlView.G0();
    }
    
    private void d0() {
        ((j)this.A0).m();
        ((j)this.B0).m();
        final Player c0 = this.c0;
        if (c0 != null && c0.t(30)) {
            if (this.c0.t(29)) {
                final Tracks p = this.c0.p();
                this.B0.v((List<i>)this.Z(p, 1));
                if (this.s0.A((View)this.D0)) {
                    this.A0.u((List<i>)this.Z(p, 3));
                }
                else {
                    this.A0.u((List<i>)ImmutableList.of());
                }
            }
        }
    }
    
    static boolean e(final StyledPlayerControlView styledPlayerControlView, final boolean j0) {
        return styledPlayerControlView.j0 = j0;
    }
    
    private static void e0(final View view, final View$OnClickListener onClickListener) {
        if (view == null) {
            return;
        }
        view.setVisibility(8);
        view.setOnClickListener(onClickListener);
    }
    
    static TextView f(final StyledPlayerControlView styledPlayerControlView) {
        return styledPlayerControlView.y;
    }
    
    static StringBuilder g(final StyledPlayerControlView styledPlayerControlView) {
        return styledPlayerControlView.A;
    }
    
    private static boolean g0(final int n) {
        return n == 90 || n == 89 || n == 85 || n == 79 || n == 126 || n == 127 || n == 87 || n == 88;
    }
    
    static Formatter h(final StyledPlayerControlView styledPlayerControlView) {
        return styledPlayerControlView.B;
    }
    
    static x i(final StyledPlayerControlView styledPlayerControlView) {
        return styledPlayerControlView.s0;
    }
    
    static Player j(final StyledPlayerControlView styledPlayerControlView) {
        return styledPlayerControlView.c0;
    }
    
    private void j0(final View view) {
        if (this.e0 == null) {
            return;
        }
        final boolean f0 = this.f0 ^ true;
        this.f0 = f0;
        this.v0(this.E0, f0);
        this.v0(this.F0, this.f0);
        final OnFullScreenModeChangedListener e0 = this.e0;
        if (e0 != null) {
            e0.t(this.f0);
        }
    }
    
    static void k(final StyledPlayerControlView styledPlayerControlView, final Player player, final long n) {
        styledPlayerControlView.p0(player, n);
    }
    
    private void k0(final View view, int n, int width, int z0, int z2, int width2, final int n2, final int n3, final int n4) {
        if ((z0 - n != n3 - width2 || z2 - width != n4 - n2) && this.x0.isShowing()) {
            this.D0();
            width = this.getWidth();
            width2 = this.x0.getWidth();
            z0 = this.z0;
            n = -this.x0.getHeight();
            z2 = this.z0;
            this.x0.update(view, width - width2 - z0, n - z2, -1, -1);
        }
    }
    
    static boolean l(final StyledPlayerControlView styledPlayerControlView) {
        return styledPlayerControlView.y0;
    }
    
    private void l0(final int n) {
        if (n == 0) {
            this.Y(this.w0);
        }
        else if (n == 1) {
            this.Y(this.B0);
        }
        else {
            this.x0.dismiss();
        }
    }
    
    static View m(final StyledPlayerControlView styledPlayerControlView) {
        return styledPlayerControlView.d;
    }
    
    static View n(final StyledPlayerControlView styledPlayerControlView) {
        return styledPlayerControlView.c;
    }
    
    static View o(final StyledPlayerControlView styledPlayerControlView) {
        return styledPlayerControlView.f;
    }
    
    private void o0(final Player player, final int n, final long n2) {
        player.B(n, n2);
    }
    
    static View p(final StyledPlayerControlView styledPlayerControlView) {
        return styledPlayerControlView.g;
    }
    
    private void p0(final Player player, long n) {
        final Timeline w = player.w();
        int y;
        if (this.i0 && !w.u()) {
            final int t = w.t();
            y = 0;
            while (true) {
                final long g = w.r(y, this.D).g();
                if (n < g) {
                    break;
                }
                if (y == t - 1) {
                    n = g;
                    break;
                }
                n -= g;
                ++y;
            }
        }
        else {
            y = player.Y();
        }
        this.o0(player, y, n);
        this.A0();
    }
    
    static View q(final StyledPlayerControlView styledPlayerControlView) {
        return styledPlayerControlView.e;
    }
    
    private boolean q0() {
        final Player c0 = this.c0;
        boolean b = true;
        if (c0 == null || c0.getPlaybackState() == 4 || this.c0.getPlaybackState() == 1 || !this.c0.E()) {
            b = false;
        }
        return b;
    }
    
    static void r(final StyledPlayerControlView styledPlayerControlView, final Player player) {
        styledPlayerControlView.X(player);
    }
    
    static ImageView s(final StyledPlayerControlView styledPlayerControlView) {
        return styledPlayerControlView.j;
    }
    
    private void setPlaybackSpeed(final float n) {
        final Player c0 = this.c0;
        if (c0 == null) {
            return;
        }
        c0.d(c0.b().e(n));
    }
    
    static int t(final StyledPlayerControlView styledPlayerControlView) {
        return styledPlayerControlView.m0;
    }
    
    private void t0(final boolean enabled, final View view) {
        if (view == null) {
            return;
        }
        view.setEnabled(enabled);
        float alpha;
        if (enabled) {
            alpha = this.N;
        }
        else {
            alpha = this.O;
        }
        view.setAlpha(alpha);
    }
    
    static ImageView u(final StyledPlayerControlView styledPlayerControlView) {
        return styledPlayerControlView.p;
    }
    
    private void u0() {
        final Player c0 = this.c0;
        long q;
        if (c0 != null) {
            q = c0.Q();
        }
        else {
            q = 15000L;
        }
        final int n = (int)(q / 1000L);
        final TextView h = this.h;
        if (h != null) {
            h.setText((CharSequence)String.valueOf(n));
        }
        final View f = this.f;
        if (f != null) {
            f.setContentDescription((CharSequence)this.t0.getQuantityString(com.google.android.exoplayer2.ui.R.plurals.a, n, new Object[] { n }));
        }
    }
    
    static View v(final StyledPlayerControlView styledPlayerControlView) {
        return styledPlayerControlView.G0;
    }
    
    private void v0(final ImageView imageView, final boolean b) {
        if (imageView == null) {
            return;
        }
        if (b) {
            imageView.setImageDrawable(this.V);
            imageView.setContentDescription((CharSequence)this.a0);
        }
        else {
            imageView.setImageDrawable(this.W);
            imageView.setContentDescription((CharSequence)this.b0);
        }
    }
    
    static f w(final StyledPlayerControlView styledPlayerControlView) {
        return styledPlayerControlView.v0;
    }
    
    private static void w0(final View view, final boolean b) {
        if (view == null) {
            return;
        }
        if (b) {
            view.setVisibility(0);
        }
        else {
            view.setVisibility(8);
        }
    }
    
    static void x(final StyledPlayerControlView styledPlayerControlView) {
        styledPlayerControlView.y0();
    }
    
    private void x0() {
        if (this.h0()) {
            if (this.g0) {
                final Player c0 = this.c0;
                boolean t = false;
                boolean t2;
                boolean t3;
                boolean t4;
                boolean t5;
                if (c0 != null) {
                    t2 = c0.t(5);
                    t3 = c0.t(7);
                    t = c0.t(11);
                    t4 = c0.t(12);
                    t5 = c0.t(9);
                }
                else {
                    t5 = false;
                    t3 = false;
                    t2 = (t4 = t3);
                }
                if (t) {
                    this.C0();
                }
                if (t4) {
                    this.u0();
                }
                this.t0(t3, this.c);
                this.t0(t, this.g);
                this.t0(t4, this.f);
                this.t0(t5, this.d);
                final TimeBar z = this.z;
                if (z != null) {
                    z.setEnabled(t2);
                }
            }
        }
    }
    
    static void y(final StyledPlayerControlView styledPlayerControlView, final RecyclerView.Adapter adapter) {
        styledPlayerControlView.Y(adapter);
    }
    
    private void y0() {
        if (this.h0()) {
            if (this.g0) {
                if (this.e != null) {
                    if (this.q0()) {
                        ((ImageView)this.e).setImageDrawable(this.t0.getDrawable(com.google.android.exoplayer2.ui.R.drawable.e));
                        this.e.setContentDescription((CharSequence)this.t0.getString(com.google.android.exoplayer2.ui.R.string.f));
                    }
                    else {
                        ((ImageView)this.e).setImageDrawable(this.t0.getDrawable(com.google.android.exoplayer2.ui.R.drawable.f));
                        this.e.setContentDescription((CharSequence)this.t0.getString(com.google.android.exoplayer2.ui.R.string.g));
                    }
                }
            }
        }
    }
    
    static View z(final StyledPlayerControlView styledPlayerControlView) {
        return styledPlayerControlView.H0;
    }
    
    private void z0() {
        final Player c0 = this.c0;
        if (c0 == null) {
            return;
        }
        this.w0.r(c0.b().a);
        this.v0.n(0, this.w0.m());
    }
    
    @Deprecated
    public void S(final VisibilityListener visibilityListener) {
        Assertions.e(visibilityListener);
        this.b.add(visibilityListener);
    }
    
    public boolean U(final KeyEvent keyEvent) {
        final int keyCode = keyEvent.getKeyCode();
        final Player c0 = this.c0;
        if (c0 != null && g0(keyCode)) {
            if (keyEvent.getAction() == 0) {
                if (keyCode == 90) {
                    if (c0.getPlaybackState() != 4) {
                        c0.d0();
                    }
                }
                else if (keyCode == 89) {
                    c0.e0();
                }
                else if (keyEvent.getRepeatCount() == 0) {
                    if (keyCode != 79 && keyCode != 85) {
                        if (keyCode != 87) {
                            if (keyCode != 88) {
                                if (keyCode != 126) {
                                    if (keyCode == 127) {
                                        this.V(c0);
                                    }
                                }
                                else {
                                    this.W(c0);
                                }
                            }
                            else {
                                c0.n();
                            }
                        }
                        else {
                            c0.z();
                        }
                    }
                    else {
                        this.X(c0);
                    }
                }
            }
            return true;
        }
        return false;
    }
    
    public void b0() {
        this.s0.C();
    }
    
    public void c0() {
        this.s0.F();
    }
    
    public boolean dispatchKeyEvent(final KeyEvent keyEvent) {
        return this.U(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }
    
    public boolean f0() {
        return this.s0.I();
    }
    
    public Player getPlayer() {
        return this.c0;
    }
    
    public int getRepeatToggleModes() {
        return this.m0;
    }
    
    public boolean getShowShuffleButton() {
        return this.s0.A((View)this.p);
    }
    
    public boolean getShowSubtitleButton() {
        return this.s0.A((View)this.D0);
    }
    
    public int getShowTimeoutMs() {
        return this.k0;
    }
    
    public boolean getShowVrButton() {
        return this.s0.A(this.w);
    }
    
    public boolean h0() {
        return this.getVisibility() == 0;
    }
    
    void i0() {
        final Iterator<VisibilityListener> iterator = this.b.iterator();
        while (iterator.hasNext()) {
            iterator.next().k(this.getVisibility());
        }
    }
    
    @Deprecated
    public void m0(final VisibilityListener visibilityListener) {
        this.b.remove(visibilityListener);
    }
    
    void n0() {
        final View e = this.e;
        if (e != null) {
            e.requestFocus();
        }
    }
    
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.s0.O();
        this.g0 = true;
        if (this.f0()) {
            this.s0.W();
        }
        this.s0();
    }
    
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.s0.P();
        this.g0 = false;
        this.removeCallbacks(this.E);
        this.s0.V();
    }
    
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        super.onLayout(b, n, n2, n3, n4);
        this.s0.Q(b, n, n2, n3, n4);
    }
    
    public void r0() {
        this.s0.b0();
    }
    
    void s0() {
        this.y0();
        this.x0();
        this.B0();
        this.E0();
        this.G0();
        this.z0();
        this.F0();
    }
    
    public void setAnimationEnabled(final boolean b) {
        this.s0.X(b);
    }
    
    @Deprecated
    public void setOnFullScreenModeChangedListener(final OnFullScreenModeChangedListener e0) {
        this.e0 = e0;
        final ImageView e2 = this.E0;
        final boolean b = true;
        w0((View)e2, e0 != null);
        w0((View)this.F0, e0 != null && b);
    }
    
    public void setPlayer(final Player c0) {
        final Looper myLooper = Looper.myLooper();
        final Looper mainLooper = Looper.getMainLooper();
        final boolean b = true;
        Assertions.g(myLooper == mainLooper);
        boolean b2 = b;
        if (c0 != null) {
            b2 = (c0.x() == Looper.getMainLooper() && b);
        }
        Assertions.a(b2);
        final Player c2 = this.c0;
        if (c2 == c0) {
            return;
        }
        if (c2 != null) {
            c2.g((Player.Listener)this.a);
        }
        if ((this.c0 = c0) != null) {
            c0.S((Player.Listener)this.a);
        }
        if (c0 instanceof ForwardingPlayer) {
            ((ForwardingPlayer)c0).j0();
        }
        this.s0();
    }
    
    public void setProgressUpdateListener(final ProgressUpdateListener d0) {
        this.d0 = d0;
    }
    
    public void setRepeatToggleModes(final int m0) {
        this.m0 = m0;
        final Player c0 = this.c0;
        boolean b = false;
        if (c0 != null) {
            final int repeatMode = c0.getRepeatMode();
            if (m0 == 0 && repeatMode != 0) {
                this.c0.setRepeatMode(0);
            }
            else if (m0 == 1 && repeatMode == 2) {
                this.c0.setRepeatMode(1);
            }
            else if (m0 == 2 && repeatMode == 1) {
                this.c0.setRepeatMode(2);
            }
        }
        final x s0 = this.s0;
        final ImageView j = this.j;
        if (m0 != 0) {
            b = true;
        }
        s0.Y((View)j, b);
        this.B0();
    }
    
    public void setShowFastForwardButton(final boolean b) {
        this.s0.Y(this.f, b);
        this.x0();
    }
    
    public void setShowMultiWindowTimeBar(final boolean h0) {
        this.h0 = h0;
        this.F0();
    }
    
    public void setShowNextButton(final boolean b) {
        this.s0.Y(this.d, b);
        this.x0();
    }
    
    public void setShowPreviousButton(final boolean b) {
        this.s0.Y(this.c, b);
        this.x0();
    }
    
    public void setShowRewindButton(final boolean b) {
        this.s0.Y(this.g, b);
        this.x0();
    }
    
    public void setShowShuffleButton(final boolean b) {
        this.s0.Y((View)this.p, b);
        this.E0();
    }
    
    public void setShowSubtitleButton(final boolean b) {
        this.s0.Y((View)this.D0, b);
    }
    
    public void setShowTimeoutMs(final int k0) {
        this.k0 = k0;
        if (this.f0()) {
            this.s0.W();
        }
    }
    
    public void setShowVrButton(final boolean b) {
        this.s0.Y(this.w, b);
    }
    
    public void setTimeBarMinUpdateInterval(final int n) {
        this.l0 = Util.q(n, 16, 1000);
    }
    
    public void setVrButtonListener(final View$OnClickListener onClickListener) {
        final View w = this.w;
        if (w != null) {
            w.setOnClickListener(onClickListener);
            this.t0(onClickListener != null, this.w);
        }
    }
    
    @Deprecated
    public interface OnFullScreenModeChangedListener
    {
        void t(final boolean p0);
    }
    
    public interface ProgressUpdateListener
    {
        void a(final long p0, final long p1);
    }
    
    @Deprecated
    public interface VisibilityListener
    {
        void k(final int p0);
    }
    
    private final class b extends j
    {
        final StyledPlayerControlView c;
        
        private b(final StyledPlayerControlView c) {
            this.c = c.super();
        }
        
        b(final StyledPlayerControlView styledPlayerControlView, final StyledPlayerControlView$a object) {
            this(styledPlayerControlView);
        }
        
        public static void t(final b b, final View view) {
            b.w(view);
        }
        
        private boolean u(final TrackSelectionParameters trackSelectionParameters) {
            for (int i = 0; i < super.a.size(); ++i) {
                if (trackSelectionParameters.J.containsKey((Object)super.a.get(i).a.b())) {
                    return true;
                }
            }
            return false;
        }
        
        private void w(final View view) {
            if (StyledPlayerControlView.j(this.c) == null) {
                return;
            }
            Util.j(StyledPlayerControlView.j(this.c)).W(StyledPlayerControlView.j(this.c).y().a().B(1).K(1, false).A());
            StyledPlayerControlView.w(this.c).n(1, this.c.getResources().getString(com.google.android.exoplayer2.ui.R.string.w));
            StyledPlayerControlView.I(this.c).dismiss();
        }
        
        public void p(final g g) {
            g.a.setText(com.google.android.exoplayer2.ui.R.string.w);
            final boolean u = this.u(Assertions.e(StyledPlayerControlView.j(this.c)).y());
            final View b = g.b;
            int visibility;
            if (u) {
                visibility = 4;
            }
            else {
                visibility = 0;
            }
            b.setVisibility(visibility);
            g.itemView.setOnClickListener((View$OnClickListener)new com.google.android.exoplayer2.ui.e(this));
        }
        
        public void s(final String s) {
            StyledPlayerControlView.w(this.c).n(1, s);
        }
        
        public void v(final List<StyledPlayerControlView.i> a) {
            super.a = a;
            final TrackSelectionParameters y = Assertions.e(StyledPlayerControlView.j(this.c)).y();
            if (a.isEmpty()) {
                StyledPlayerControlView.w(this.c).n(1, this.c.getResources().getString(com.google.android.exoplayer2.ui.R.string.x));
            }
            else if (!this.u(y)) {
                StyledPlayerControlView.w(this.c).n(1, this.c.getResources().getString(com.google.android.exoplayer2.ui.R.string.w));
            }
            else {
                for (int i = 0; i < a.size(); ++i) {
                    final StyledPlayerControlView.i j = a.get(i);
                    if (j.a()) {
                        StyledPlayerControlView.w(this.c).n(1, j.c);
                        break;
                    }
                }
            }
        }
    }
    
    private final class c implements Listener, OnScrubListener, View$OnClickListener, PopupWindow$OnDismissListener
    {
        final StyledPlayerControlView a;
        
        private c(final StyledPlayerControlView a) {
            this.a = a;
        }
        
        c(final StyledPlayerControlView styledPlayerControlView, final StyledPlayerControlView$a object) {
            this(styledPlayerControlView);
        }
        
        @Override
        public void k(final TimeBar timeBar, final long n) {
            if (StyledPlayerControlView.f(this.a) != null) {
                StyledPlayerControlView.f(this.a).setText((CharSequence)Util.h0(StyledPlayerControlView.g(this.a), StyledPlayerControlView.h(this.a), n));
            }
        }
        
        public void onClick(final View view) {
            final Player j = StyledPlayerControlView.j(this.a);
            if (j == null) {
                return;
            }
            StyledPlayerControlView.i(this.a).W();
            if (StyledPlayerControlView.m(this.a) == view) {
                j.z();
            }
            else if (StyledPlayerControlView.n(this.a) == view) {
                j.n();
            }
            else if (StyledPlayerControlView.o(this.a) == view) {
                if (j.getPlaybackState() != 4) {
                    j.d0();
                }
            }
            else if (StyledPlayerControlView.p(this.a) == view) {
                j.e0();
            }
            else if (StyledPlayerControlView.q(this.a) == view) {
                StyledPlayerControlView.r(this.a, j);
            }
            else if (StyledPlayerControlView.s(this.a) == view) {
                j.setRepeatMode(RepeatModeUtil.a(j.getRepeatMode(), StyledPlayerControlView.t(this.a)));
            }
            else if (StyledPlayerControlView.u(this.a) == view) {
                j.F(j.b0() ^ true);
            }
            else if (StyledPlayerControlView.v(this.a) == view) {
                StyledPlayerControlView.i(this.a).V();
                final StyledPlayerControlView a = this.a;
                StyledPlayerControlView.y(a, StyledPlayerControlView.w(a));
            }
            else if (StyledPlayerControlView.z(this.a) == view) {
                StyledPlayerControlView.i(this.a).V();
                final StyledPlayerControlView a2 = this.a;
                StyledPlayerControlView.y(a2, StyledPlayerControlView.A(a2));
            }
            else if (StyledPlayerControlView.B(this.a) == view) {
                StyledPlayerControlView.i(this.a).V();
                final StyledPlayerControlView a3 = this.a;
                StyledPlayerControlView.y(a3, StyledPlayerControlView.C(a3));
            }
            else if (StyledPlayerControlView.D(this.a) == view) {
                StyledPlayerControlView.i(this.a).V();
                final StyledPlayerControlView a4 = this.a;
                StyledPlayerControlView.y(a4, StyledPlayerControlView.E(a4));
            }
        }
        
        public void onDismiss() {
            if (StyledPlayerControlView.l(this.a)) {
                StyledPlayerControlView.i(this.a).W();
            }
        }
        
        @Override
        public void onEvents(final Player player, final Events events) {
            if (events.b(4, 5)) {
                StyledPlayerControlView.x(this.a);
            }
            if (events.b(4, 5, 7)) {
                StyledPlayerControlView.F(this.a);
            }
            if (events.a(8)) {
                StyledPlayerControlView.N(this.a);
            }
            if (events.a(9)) {
                StyledPlayerControlView.O(this.a);
            }
            if (events.b(8, 9, 11, 0, 16, 17, 13)) {
                StyledPlayerControlView.P(this.a);
            }
            if (events.b(11, 0)) {
                StyledPlayerControlView.Q(this.a);
            }
            if (events.a(12)) {
                StyledPlayerControlView.R(this.a);
            }
            if (events.a(2)) {
                StyledPlayerControlView.d(this.a);
            }
        }
        
        @Override
        public void t(final TimeBar timeBar, final long n, final boolean b) {
            StyledPlayerControlView.e(this.a, false);
            if (!b && StyledPlayerControlView.j(this.a) != null) {
                final StyledPlayerControlView a = this.a;
                StyledPlayerControlView.k(a, StyledPlayerControlView.j(a), n);
            }
            StyledPlayerControlView.i(this.a).W();
        }
        
        @Override
        public void u(final TimeBar timeBar, final long n) {
            StyledPlayerControlView.e(this.a, true);
            if (StyledPlayerControlView.f(this.a) != null) {
                StyledPlayerControlView.f(this.a).setText((CharSequence)Util.h0(StyledPlayerControlView.g(this.a), StyledPlayerControlView.h(this.a), n));
            }
            StyledPlayerControlView.i(this.a).V();
        }
    }
    
    private final class d extends Adapter<g>
    {
        private final String[] a;
        private final float[] b;
        private int c;
        final StyledPlayerControlView d;
        
        public d(final StyledPlayerControlView d, final String[] a, final float[] b) {
            this.d = d;
            this.a = a;
            this.b = b;
        }
        
        public static void l(final d d, final int n, final View view) {
            d.n(n, view);
        }
        
        private void n(final int n, final View view) {
            if (n != this.c) {
                StyledPlayerControlView.H(this.d, this.b[n]);
            }
            StyledPlayerControlView.I(this.d).dismiss();
        }
        
        @Override
        public int getItemCount() {
            return this.a.length;
        }
        
        public String m() {
            return this.a[this.c];
        }
        
        public void o(final g g, final int n) {
            final String[] a = this.a;
            if (n < a.length) {
                g.a.setText((CharSequence)a[n]);
            }
            if (n == this.c) {
                g.itemView.setSelected(true);
                g.b.setVisibility(0);
            }
            else {
                g.itemView.setSelected(false);
                g.b.setVisibility(4);
            }
            g.itemView.setOnClickListener((View$OnClickListener)new com.google.android.exoplayer2.ui.f(this, n));
        }
        
        @Override
        public /* bridge */ void onBindViewHolder(final c0 c0, final int n) {
            this.o((g)c0, n);
        }
        
        @Override
        public /* bridge */ c0 onCreateViewHolder(final ViewGroup viewGroup, final int n) {
            return this.p(viewGroup, n);
        }
        
        public g p(final ViewGroup viewGroup, final int n) {
            return new g(LayoutInflater.from(this.d.getContext()).inflate(com.google.android.exoplayer2.ui.R.layout.f, viewGroup, false));
        }
        
        public void r(final float n) {
            int n2 = 0;
            float n3 = Float.MAX_VALUE;
            int c = 0;
            while (true) {
                final float[] b = this.b;
                if (n2 >= b.length) {
                    break;
                }
                final float abs = Math.abs(n - b[n2]);
                float n4 = n3;
                if (abs < n3) {
                    c = n2;
                    n4 = abs;
                }
                ++n2;
                n3 = n4;
            }
            this.c = c;
        }
    }
    
    private final class e extends c0
    {
        private final TextView a;
        private final TextView b;
        private final ImageView c;
        final StyledPlayerControlView d;
        
        public e(final StyledPlayerControlView d, final View view) {
            this.d = d;
            super(view);
            if (Util.a < 26) {
                view.setFocusable(true);
            }
            this.a = (TextView)view.findViewById(com.google.android.exoplayer2.ui.R.id.u);
            this.b = (TextView)view.findViewById(com.google.android.exoplayer2.ui.R.id.N);
            this.c = (ImageView)view.findViewById(com.google.android.exoplayer2.ui.R.id.t);
            view.setOnClickListener((View$OnClickListener)new com.google.android.exoplayer2.ui.g(this));
        }
        
        public static void a(final e e, final View view) {
            e.e(view);
        }
        
        static TextView b(final e e) {
            return e.a;
        }
        
        static TextView c(final e e) {
            return e.b;
        }
        
        static ImageView d(final e e) {
            return e.c;
        }
        
        private void e(final View view) {
            StyledPlayerControlView.G(this.d, ((RecyclerView.c0)this).getAdapterPosition());
        }
    }
    
    private class f extends Adapter<e>
    {
        private final String[] a;
        private final String[] b;
        private final Drawable[] c;
        final StyledPlayerControlView d;
        
        public f(final StyledPlayerControlView d, final String[] a, final Drawable[] c) {
            this.d = d;
            this.a = a;
            this.b = new String[a.length];
            this.c = c;
        }
        
        @Override
        public int getItemCount() {
            return this.a.length;
        }
        
        @Override
        public long getItemId(final int n) {
            return n;
        }
        
        public void l(final e e, final int n) {
            StyledPlayerControlView.e.b(e).setText((CharSequence)this.a[n]);
            if (this.b[n] == null) {
                StyledPlayerControlView.e.c(e).setVisibility(8);
            }
            else {
                StyledPlayerControlView.e.c(e).setText((CharSequence)this.b[n]);
            }
            if (this.c[n] == null) {
                StyledPlayerControlView.e.d(e).setVisibility(8);
            }
            else {
                StyledPlayerControlView.e.d(e).setImageDrawable(this.c[n]);
            }
        }
        
        public e m(final ViewGroup viewGroup, final int n) {
            return this.d.new e(LayoutInflater.from(this.d.getContext()).inflate(com.google.android.exoplayer2.ui.R.layout.e, viewGroup, false));
        }
        
        public void n(final int n, final String s) {
            this.b[n] = s;
        }
        
        @Override
        public /* bridge */ void onBindViewHolder(final c0 c0, final int n) {
            this.l((e)c0, n);
        }
        
        @Override
        public /* bridge */ c0 onCreateViewHolder(final ViewGroup viewGroup, final int n) {
            return this.m(viewGroup, n);
        }
    }
    
    private static class g extends c0
    {
        public final TextView a;
        public final View b;
        
        public g(final View view) {
            super(view);
            if (Util.a < 26) {
                view.setFocusable(true);
            }
            this.a = (TextView)view.findViewById(R.id.Q);
            this.b = view.findViewById(R.id.h);
        }
    }
    
    private final class h extends j
    {
        final StyledPlayerControlView c;
        
        private h(final StyledPlayerControlView c) {
            this.c = c.super();
        }
        
        h(final StyledPlayerControlView styledPlayerControlView, final StyledPlayerControlView$a object) {
            this(styledPlayerControlView);
        }
        
        public static void t(final h h, final View view) {
            h.v(view);
        }
        
        private void v(final View view) {
            if (StyledPlayerControlView.j(this.c) != null) {
                StyledPlayerControlView.j(this.c).W(StyledPlayerControlView.j(this.c).y().a().B(3).G(-3).A());
                StyledPlayerControlView.I(this.c).dismiss();
            }
        }
        
        @Override
        public void o(final g g, int visibility) {
            super.o(g, visibility);
            if (visibility > 0) {
                final StyledPlayerControlView.i i = super.a.get(visibility - 1);
                final View b = g.b;
                if (i.a()) {
                    visibility = 0;
                }
                else {
                    visibility = 4;
                }
                b.setVisibility(visibility);
            }
        }
        
        @Override
        public /* bridge */ void onBindViewHolder(final c0 c0, final int n) {
            this.o((g)c0, n);
        }
        
        public void p(final g g) {
            g.a.setText(com.google.android.exoplayer2.ui.R.string.x);
            final int n = 0;
            while (true) {
                for (int i = 0; i < super.a.size(); ++i) {
                    if (super.a.get(i).a()) {
                        final boolean b = false;
                        final View b2 = g.b;
                        int visibility;
                        if (b) {
                            visibility = n;
                        }
                        else {
                            visibility = 4;
                        }
                        b2.setVisibility(visibility);
                        g.itemView.setOnClickListener((View$OnClickListener)new com.google.android.exoplayer2.ui.h(this));
                        return;
                    }
                }
                final boolean b = true;
                continue;
            }
        }
        
        public void s(final String s) {
        }
        
        public void u(final List<StyledPlayerControlView.i> a) {
            final int n = 0;
            int n2 = 0;
            int n3;
            while (true) {
                n3 = n;
                if (n2 >= a.size()) {
                    break;
                }
                if (((StyledPlayerControlView.i)a.get(n2)).a()) {
                    n3 = 1;
                    break;
                }
                ++n2;
            }
            if (StyledPlayerControlView.D(this.c) != null) {
                final ImageView d = StyledPlayerControlView.D(this.c);
                final StyledPlayerControlView c = this.c;
                Drawable imageDrawable;
                if (n3 != 0) {
                    imageDrawable = StyledPlayerControlView.J(c);
                }
                else {
                    imageDrawable = StyledPlayerControlView.K(c);
                }
                d.setImageDrawable(imageDrawable);
                final ImageView d2 = StyledPlayerControlView.D(this.c);
                String contentDescription;
                if (n3 != 0) {
                    contentDescription = StyledPlayerControlView.L(this.c);
                }
                else {
                    contentDescription = StyledPlayerControlView.M(this.c);
                }
                d2.setContentDescription((CharSequence)contentDescription);
            }
            super.a = a;
        }
    }
    
    private static final class i
    {
        public final Tracks.Group a;
        public final int b;
        public final String c;
        
        public i(final Tracks tracks, final int n, final int b, final String c) {
            this.a = ((List<Tracks.Group>)tracks.b()).get(n);
            this.b = b;
            this.c = c;
        }
        
        public boolean a() {
            return this.a.h(this.b);
        }
    }
    
    private abstract class j extends Adapter<g>
    {
        protected List<StyledPlayerControlView.i> a;
        final StyledPlayerControlView b;
        
        protected j(final StyledPlayerControlView b) {
            this.b = b;
            this.a = new ArrayList<StyledPlayerControlView.i>();
        }
        
        public static void l(final j j, final Player player, final TrackGroup trackGroup, final StyledPlayerControlView.i i, final View view) {
            j.n(player, trackGroup, i, view);
        }
        
        private void n(final Player player, final TrackGroup trackGroup, final StyledPlayerControlView.i i, final View view) {
            player.W(player.y().a().H(new TrackSelectionOverride(trackGroup, (List<Integer>)ImmutableList.of((Object)i.b))).K(i.a.e(), false).A());
            this.s(i.c);
            StyledPlayerControlView.I(this.b).dismiss();
        }
        
        @Override
        public int getItemCount() {
            int n;
            if (this.a.isEmpty()) {
                n = 0;
            }
            else {
                n = this.a.size() + 1;
            }
            return n;
        }
        
        protected void m() {
            this.a = Collections.emptyList();
        }
        
        public void o(final g g, int visibility) {
            final Player j = StyledPlayerControlView.j(this.b);
            if (j == null) {
                return;
            }
            if (visibility == 0) {
                this.p(g);
            }
            else {
                final List<StyledPlayerControlView.i> a = this.a;
                final int n = 1;
                final StyledPlayerControlView.i i = a.get(visibility - 1);
                final TrackGroup b = i.a.b();
                final Object value = j.y().J.get((Object)b);
                final int n2 = 0;
                if (value != null && i.a()) {
                    visibility = n;
                }
                else {
                    visibility = 0;
                }
                g.a.setText((CharSequence)i.c);
                final View b2 = g.b;
                if (visibility != 0) {
                    visibility = n2;
                }
                else {
                    visibility = 4;
                }
                b2.setVisibility(visibility);
                g.itemView.setOnClickListener((View$OnClickListener)new i(this, j, b, i));
            }
        }
        
        @Override
        public /* bridge */ void onBindViewHolder(final c0 c0, final int n) {
            this.o((g)c0, n);
        }
        
        @Override
        public /* bridge */ c0 onCreateViewHolder(final ViewGroup viewGroup, final int n) {
            return this.r(viewGroup, n);
        }
        
        protected abstract void p(final g p0);
        
        public g r(final ViewGroup viewGroup, final int n) {
            return new g(LayoutInflater.from(this.b.getContext()).inflate(com.google.android.exoplayer2.ui.R.layout.f, viewGroup, false));
        }
        
        protected abstract void s(final String p0);
    }
}
