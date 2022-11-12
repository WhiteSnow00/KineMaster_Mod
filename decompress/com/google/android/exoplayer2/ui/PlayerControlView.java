// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.ui;

import android.view.View$OnClickListener;
import android.os.Looper;
import java.util.Iterator;
import android.view.MotionEvent;
import android.view.KeyEvent;
import java.util.Arrays;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import android.os.SystemClock;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import java.util.Formatter;
import android.widget.TextView;
import android.widget.ImageView;
import android.view.View;
import java.util.concurrent.CopyOnWriteArrayList;
import com.google.android.exoplayer2.Player;
import android.graphics.drawable.Drawable;
import com.google.android.exoplayer2.Timeline;
import android.widget.FrameLayout;

public class PlayerControlView extends FrameLayout
{
    private final Timeline.Period A;
    private final Timeline.Window B;
    private final Runnable C;
    private final Runnable D;
    private final Drawable E;
    private final Drawable F;
    private final Drawable G;
    private final String H;
    private final String I;
    private final String J;
    private final Drawable K;
    private final Drawable L;
    private final float M;
    private final float N;
    private final String O;
    private final String P;
    private Player Q;
    private ProgressUpdateListener R;
    private boolean S;
    private boolean T;
    private boolean U;
    private boolean V;
    private int W;
    private final CopyOnWriteArrayList<VisibilityListener> a;
    private int a0;
    private final View b;
    private int b0;
    private final View c;
    private boolean c0;
    private final View d;
    private boolean d0;
    private final View e;
    private boolean e0;
    private final View f;
    private boolean f0;
    private final View g;
    private boolean g0;
    private final ImageView h;
    private long h0;
    private final ImageView i;
    private long[] i0;
    private final View j;
    private boolean[] j0;
    private long[] k0;
    private boolean[] l0;
    private long m0;
    private long n0;
    private long o0;
    private final TextView p;
    private final TextView w;
    private final TimeBar x;
    private final StringBuilder y;
    private final Formatter z;
    
    static {
        ExoPlayerLibraryInfo.a("goog.exo.ui");
    }
    
    private static boolean b(final Timeline timeline, final Timeline.Window window) {
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
    
    private void d(final Player player) {
        player.pause();
    }
    
    private void e(final Player player) {
        final int playbackState = player.getPlaybackState();
        if (playbackState == 1) {
            player.prepare();
        }
        else if (playbackState == 4) {
            this.n(player, player.Y(), -9223372036854775807L);
        }
        player.play();
    }
    
    private void f(final Player player) {
        final int playbackState = player.getPlaybackState();
        if (playbackState != 1 && playbackState != 4 && player.E()) {
            this.d(player);
        }
        else {
            this.e(player);
        }
    }
    
    private void h() {
        this.removeCallbacks(this.D);
        if (this.W > 0) {
            final long uptimeMillis = SystemClock.uptimeMillis();
            final int w = this.W;
            this.h0 = uptimeMillis + w;
            if (this.S) {
                this.postDelayed(this.D, (long)w);
            }
        }
        else {
            this.h0 = -9223372036854775807L;
        }
    }
    
    private static boolean i(final int n) {
        return n == 90 || n == 89 || n == 85 || n == 79 || n == 126 || n == 127 || n == 87 || n == 88;
    }
    
    private void l() {
        final boolean o = this.o();
        if (!o) {
            final View d = this.d;
            if (d != null) {
                d.sendAccessibilityEvent(8);
                return;
            }
        }
        if (o) {
            final View e = this.e;
            if (e != null) {
                e.sendAccessibilityEvent(8);
            }
        }
    }
    
    private void m() {
        final boolean o = this.o();
        if (!o) {
            final View d = this.d;
            if (d != null) {
                d.requestFocus();
                return;
            }
        }
        if (o) {
            final View e = this.e;
            if (e != null) {
                e.requestFocus();
            }
        }
    }
    
    private void n(final Player player, final int n, final long n2) {
        player.B(n, n2);
    }
    
    private boolean o() {
        final Player q = this.Q;
        boolean b = true;
        if (q == null || q.getPlaybackState() == 4 || this.Q.getPlaybackState() == 1 || !this.Q.E()) {
            b = false;
        }
        return b;
    }
    
    private void q() {
        this.t();
        this.s();
        this.v();
        this.w();
        this.x();
    }
    
    private void r(final boolean b, final boolean enabled, final View view) {
        if (view == null) {
            return;
        }
        view.setEnabled(enabled);
        float alpha;
        if (enabled) {
            alpha = this.M;
        }
        else {
            alpha = this.N;
        }
        view.setAlpha(alpha);
        int visibility;
        if (b) {
            visibility = 0;
        }
        else {
            visibility = 8;
        }
        view.setVisibility(visibility);
    }
    
    private void s() {
        if (this.j()) {
            if (this.S) {
                final Player q = this.Q;
                final boolean b = false;
                boolean t;
                boolean t2;
                boolean t3;
                boolean t4;
                boolean t5;
                if (q != null) {
                    t = q.t(5);
                    t2 = q.t(7);
                    t3 = q.t(11);
                    t4 = q.t(12);
                    t5 = q.t(9);
                }
                else {
                    t5 = false;
                    final boolean b2 = false;
                    t4 = (t3 = b2);
                    t = b2;
                    t2 = b;
                }
                this.r(this.e0, t2, this.b);
                this.r(this.c0, t3, this.g);
                this.r(this.d0, t4, this.f);
                this.r(this.f0, t5, this.c);
                final TimeBar x = this.x;
                if (x != null) {
                    x.setEnabled(t);
                }
            }
        }
    }
    
    private void t() {
        if (this.j()) {
            if (this.S) {
                final boolean o = this.o();
                final View d = this.d;
                final int n = 8;
                final int n2 = 1;
                int n3;
                int n6;
                if (d != null) {
                    n3 = (((o && d.isFocused()) | false) ? 1 : 0);
                    int n4;
                    if (Util.a < 21) {
                        n4 = n3;
                    }
                    else if (o && PlayerControlView.a.a(this.d)) {
                        n4 = 1;
                    }
                    else {
                        n4 = 0;
                    }
                    final int n5 = n4 | 0x0;
                    final View d2 = this.d;
                    int visibility;
                    if (o) {
                        visibility = 8;
                    }
                    else {
                        visibility = 0;
                    }
                    d2.setVisibility(visibility);
                    n6 = n5;
                }
                else {
                    n3 = 0;
                    n6 = 0;
                }
                final View e = this.e;
                int n7 = n3;
                int n8 = n6;
                if (e != null) {
                    n7 = (n3 | ((!o && e.isFocused()) ? 1 : 0));
                    int n9;
                    if (Util.a < 21) {
                        n9 = n7;
                    }
                    else if (!o && PlayerControlView.a.a(this.e)) {
                        n9 = n2;
                    }
                    else {
                        n9 = 0;
                    }
                    n8 = (n6 | n9);
                    final View e2 = this.e;
                    int visibility2 = n;
                    if (o) {
                        visibility2 = 0;
                    }
                    e2.setVisibility(visibility2);
                }
                if (n7 != 0) {
                    this.m();
                }
                if (n8 != 0) {
                    this.l();
                }
            }
        }
    }
    
    private void u() {
        if (this.j()) {
            if (this.S) {
                final Player q = this.Q;
                long n = 0L;
                long n2;
                if (q != null) {
                    n = this.m0 + q.R();
                    n2 = this.m0 + q.c0();
                }
                else {
                    n2 = 0L;
                }
                final long n3 = this.n0;
                boolean b = false;
                final boolean b2 = n != n3;
                if (n2 != this.o0) {
                    b = true;
                }
                this.n0 = n;
                this.o0 = n2;
                final TextView w = this.w;
                if (w != null && !this.V && b2) {
                    w.setText((CharSequence)Util.h0(this.y, this.z, n));
                }
                final TimeBar x = this.x;
                if (x != null) {
                    x.setPosition(n);
                    this.x.setBufferedPosition(n2);
                }
                final ProgressUpdateListener r = this.R;
                if (r != null && (b2 || b)) {
                    r.a(n, n2);
                }
                this.removeCallbacks(this.C);
                int playbackState;
                if (q == null) {
                    playbackState = 1;
                }
                else {
                    playbackState = q.getPlaybackState();
                }
                final long n4 = 1000L;
                if (q != null && q.X()) {
                    final TimeBar x2 = this.x;
                    long preferredUpdateDelay;
                    if (x2 != null) {
                        preferredUpdateDelay = x2.getPreferredUpdateDelay();
                    }
                    else {
                        preferredUpdateDelay = 1000L;
                    }
                    final long min = Math.min(preferredUpdateDelay, 1000L - n % 1000L);
                    final float a = q.b().a;
                    long n5 = n4;
                    if (a > 0.0f) {
                        n5 = (long)(min / a);
                    }
                    this.postDelayed(this.C, Util.r(n5, this.a0, 1000L));
                }
                else if (playbackState != 4 && playbackState != 1) {
                    this.postDelayed(this.C, 1000L);
                }
            }
        }
    }
    
    private void v() {
        if (this.j() && this.S) {
            final ImageView h = this.h;
            if (h != null) {
                if (this.b0 == 0) {
                    this.r(false, false, (View)h);
                    return;
                }
                final Player q = this.Q;
                if (q == null) {
                    this.r(true, false, (View)h);
                    this.h.setImageDrawable(this.E);
                    this.h.setContentDescription((CharSequence)this.H);
                    return;
                }
                this.r(true, true, (View)h);
                final int repeatMode = q.getRepeatMode();
                if (repeatMode != 0) {
                    if (repeatMode != 1) {
                        if (repeatMode == 2) {
                            this.h.setImageDrawable(this.G);
                            this.h.setContentDescription((CharSequence)this.J);
                        }
                    }
                    else {
                        this.h.setImageDrawable(this.F);
                        this.h.setContentDescription((CharSequence)this.I);
                    }
                }
                else {
                    this.h.setImageDrawable(this.E);
                    this.h.setContentDescription((CharSequence)this.H);
                }
                this.h.setVisibility(0);
            }
        }
    }
    
    private void w() {
        if (this.j() && this.S) {
            final ImageView i = this.i;
            if (i != null) {
                final Player q = this.Q;
                if (!this.g0) {
                    this.r(false, false, (View)i);
                }
                else if (q == null) {
                    this.r(true, false, (View)i);
                    this.i.setImageDrawable(this.L);
                    this.i.setContentDescription((CharSequence)this.P);
                }
                else {
                    this.r(true, true, (View)i);
                    final ImageView j = this.i;
                    Drawable imageDrawable;
                    if (q.b0()) {
                        imageDrawable = this.K;
                    }
                    else {
                        imageDrawable = this.L;
                    }
                    j.setImageDrawable(imageDrawable);
                    final ImageView k = this.i;
                    String contentDescription;
                    if (q.b0()) {
                        contentDescription = this.O;
                    }
                    else {
                        contentDescription = this.P;
                    }
                    k.setContentDescription((CharSequence)contentDescription);
                }
            }
        }
    }
    
    private void x() {
        final Player q = this.Q;
        if (q == null) {
            return;
        }
        this.U = (this.T && b(q.w(), this.B));
        long n = 0L;
        this.m0 = 0L;
        final Timeline w = q.w();
        int n3;
        if (!w.u()) {
            final int y = q.Y();
            final boolean u = this.U;
            int i;
            if (u) {
                i = 0;
            }
            else {
                i = y;
            }
            int n2;
            if (u) {
                n2 = w.t() - 1;
            }
            else {
                n2 = y;
            }
            n = 0L;
            n3 = 0;
            while (i <= n2) {
                if (i == y) {
                    this.m0 = Util.f1(n);
                }
                w.r(i, this.B);
                final Timeline.Window b = this.B;
                if (b.y == -9223372036854775807L) {
                    Assertions.g(this.U ^ true);
                    break;
                }
                int z = b.z;
                int n4 = n3;
                Timeline.Window b2;
                while (true) {
                    b2 = this.B;
                    if (z > b2.A) {
                        break;
                    }
                    w.j(z, this.A);
                    int n6;
                    for (int j = this.A.s(); j < this.A.f(); ++j, n4 = n6) {
                        long n5;
                        if ((n5 = this.A.i(j)) == Long.MIN_VALUE) {
                            n5 = this.A.d;
                            if (n5 == -9223372036854775807L) {
                                n6 = n4;
                                continue;
                            }
                        }
                        final long n7 = n5 + this.A.r();
                        n6 = n4;
                        if (n7 >= 0L) {
                            final long[] i2 = this.i0;
                            if (n4 == i2.length) {
                                int n8;
                                if (i2.length == 0) {
                                    n8 = 1;
                                }
                                else {
                                    n8 = i2.length * 2;
                                }
                                this.i0 = Arrays.copyOf(i2, n8);
                                this.j0 = Arrays.copyOf(this.j0, n8);
                            }
                            this.i0[n4] = Util.f1(n + n7);
                            this.j0[n4] = this.A.t(j);
                            n6 = n4 + 1;
                        }
                    }
                    ++z;
                }
                n += b2.y;
                ++i;
                n3 = n4;
            }
        }
        else {
            n3 = 0;
        }
        final long f1 = Util.f1(n);
        final TextView p = this.p;
        if (p != null) {
            p.setText((CharSequence)Util.h0(this.y, this.z, f1));
        }
        final TimeBar x = this.x;
        if (x != null) {
            x.setDuration(f1);
            final int length = this.k0.length;
            final int n9 = n3 + length;
            final long[] i3 = this.i0;
            if (n9 > i3.length) {
                this.i0 = Arrays.copyOf(i3, n9);
                this.j0 = Arrays.copyOf(this.j0, n9);
            }
            System.arraycopy(this.k0, 0, this.i0, n3, length);
            System.arraycopy(this.l0, 0, this.j0, n3, length);
            this.x.b(this.i0, this.j0, n9);
        }
        this.u();
    }
    
    public void a(final VisibilityListener visibilityListener) {
        Assertions.e(visibilityListener);
        this.a.add(visibilityListener);
    }
    
    public boolean c(final KeyEvent keyEvent) {
        final int keyCode = keyEvent.getKeyCode();
        final Player q = this.Q;
        if (q != null && i(keyCode)) {
            if (keyEvent.getAction() == 0) {
                if (keyCode == 90) {
                    if (q.getPlaybackState() != 4) {
                        q.d0();
                    }
                }
                else if (keyCode == 89) {
                    q.e0();
                }
                else if (keyEvent.getRepeatCount() == 0) {
                    if (keyCode != 79 && keyCode != 85) {
                        if (keyCode != 87) {
                            if (keyCode != 88) {
                                if (keyCode != 126) {
                                    if (keyCode == 127) {
                                        this.d(q);
                                    }
                                }
                                else {
                                    this.e(q);
                                }
                            }
                            else {
                                q.n();
                            }
                        }
                        else {
                            q.z();
                        }
                    }
                    else {
                        this.f(q);
                    }
                }
            }
            return true;
        }
        return false;
    }
    
    public boolean dispatchKeyEvent(final KeyEvent keyEvent) {
        return this.c(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }
    
    public final boolean dispatchTouchEvent(final MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.removeCallbacks(this.D);
        }
        else if (motionEvent.getAction() == 1) {
            this.h();
        }
        return super.dispatchTouchEvent(motionEvent);
    }
    
    public void g() {
        if (this.j()) {
            this.setVisibility(8);
            final Iterator<VisibilityListener> iterator = this.a.iterator();
            while (iterator.hasNext()) {
                iterator.next().k(this.getVisibility());
            }
            this.removeCallbacks(this.C);
            this.removeCallbacks(this.D);
            this.h0 = -9223372036854775807L;
        }
    }
    
    public Player getPlayer() {
        return this.Q;
    }
    
    public int getRepeatToggleModes() {
        return this.b0;
    }
    
    public boolean getShowShuffleButton() {
        return this.g0;
    }
    
    public int getShowTimeoutMs() {
        return this.W;
    }
    
    public boolean getShowVrButton() {
        final View j = this.j;
        return j != null && j.getVisibility() == 0;
    }
    
    public boolean j() {
        return this.getVisibility() == 0;
    }
    
    public void k(final VisibilityListener visibilityListener) {
        this.a.remove(visibilityListener);
    }
    
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.S = true;
        final long h0 = this.h0;
        if (h0 != -9223372036854775807L) {
            final long n = h0 - SystemClock.uptimeMillis();
            if (n <= 0L) {
                this.g();
            }
            else {
                this.postDelayed(this.D, n);
            }
        }
        else if (this.j()) {
            this.h();
        }
        this.q();
    }
    
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.S = false;
        this.removeCallbacks(this.C);
        this.removeCallbacks(this.D);
    }
    
    public void p() {
        if (!this.j()) {
            this.setVisibility(0);
            final Iterator<VisibilityListener> iterator = this.a.iterator();
            while (iterator.hasNext()) {
                iterator.next().k(this.getVisibility());
            }
            this.q();
            this.m();
            this.l();
        }
        this.h();
    }
    
    public void setPlayer(final Player q) {
        final Looper myLooper = Looper.myLooper();
        final Looper mainLooper = Looper.getMainLooper();
        final boolean b = true;
        Assertions.g(myLooper == mainLooper);
        boolean b2 = b;
        if (q != null) {
            b2 = (q.x() == Looper.getMainLooper() && b);
        }
        Assertions.a(b2);
        final Player q2 = this.Q;
        if (q2 == q) {
            return;
        }
        if (q2 != null) {
            q2.g(null);
        }
        if ((this.Q = q) != null) {
            q.S(null);
        }
        this.q();
    }
    
    public void setProgressUpdateListener(final ProgressUpdateListener r) {
        this.R = r;
    }
    
    public void setRepeatToggleModes(final int b0) {
        this.b0 = b0;
        final Player q = this.Q;
        if (q != null) {
            final int repeatMode = q.getRepeatMode();
            if (b0 == 0 && repeatMode != 0) {
                this.Q.setRepeatMode(0);
            }
            else if (b0 == 1 && repeatMode == 2) {
                this.Q.setRepeatMode(1);
            }
            else if (b0 == 2 && repeatMode == 1) {
                this.Q.setRepeatMode(2);
            }
        }
        this.v();
    }
    
    public void setShowFastForwardButton(final boolean d0) {
        this.d0 = d0;
        this.s();
    }
    
    public void setShowMultiWindowTimeBar(final boolean t) {
        this.T = t;
        this.x();
    }
    
    public void setShowNextButton(final boolean f0) {
        this.f0 = f0;
        this.s();
    }
    
    public void setShowPreviousButton(final boolean e0) {
        this.e0 = e0;
        this.s();
    }
    
    public void setShowRewindButton(final boolean c0) {
        this.c0 = c0;
        this.s();
    }
    
    public void setShowShuffleButton(final boolean g0) {
        this.g0 = g0;
        this.w();
    }
    
    public void setShowTimeoutMs(final int w) {
        this.W = w;
        if (this.j()) {
            this.h();
        }
    }
    
    public void setShowVrButton(final boolean b) {
        final View j = this.j;
        if (j != null) {
            int visibility;
            if (b) {
                visibility = 0;
            }
            else {
                visibility = 8;
            }
            j.setVisibility(visibility);
        }
    }
    
    public void setTimeBarMinUpdateInterval(final int n) {
        this.a0 = Util.q(n, 16, 1000);
    }
    
    public void setVrButtonListener(final View$OnClickListener onClickListener) {
        final View j = this.j;
        if (j != null) {
            j.setOnClickListener(onClickListener);
            this.r(this.getShowVrButton(), onClickListener != null, this.j);
        }
    }
    
    public interface ProgressUpdateListener
    {
        void a(final long p0, final long p1);
    }
    
    public interface VisibilityListener
    {
        void k(final int p0);
    }
    
    private static final class a
    {
        public static boolean a(final View view) {
            return view.isAccessibilityFocused();
        }
    }
}
