// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.ui;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import com.google.android.exoplayer2.text.Cue;
import android.view.SurfaceView;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.ViewGroup;
import java.util.Collection;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import android.view.KeyEvent;
import com.google.android.exoplayer2.util.Assertions;
import android.view.View$OnLayoutChangeListener;
import com.google.android.exoplayer2.video.VideoSize;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.BitmapFactory;
import com.google.android.exoplayer2.MediaMetadata;
import android.graphics.RectF;
import android.graphics.Matrix;
import android.view.TextureView;
import com.google.android.exoplayer2.Player;
import android.widget.TextView;
import android.widget.ImageView;
import android.view.View;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.util.ErrorMessageProvider;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;

@Deprecated
public class PlayerView extends FrameLayout implements AdViewProvider
{
    private Drawable A;
    private int B;
    private boolean C;
    private ErrorMessageProvider<? super PlaybackException> D;
    private CharSequence E;
    private int F;
    private boolean G;
    private boolean H;
    private boolean I;
    private int J;
    private final AspectRatioFrameLayout a;
    private final View b;
    private final View c;
    private final boolean d;
    private final ImageView e;
    private final SubtitleView f;
    private final View g;
    private final TextView h;
    private final PlayerControlView i;
    private final FrameLayout j;
    private final FrameLayout p;
    private Player w;
    private boolean x;
    private PlayerControlView.VisibilityListener y;
    private boolean z;
    
    private static void a(final TextureView textureView, final int n) {
        final Matrix transform = new Matrix();
        final float n2 = (float)textureView.getWidth();
        final float n3 = (float)textureView.getHeight();
        if (n2 != 0.0f && n3 != 0.0f && n != 0) {
            final float n4 = n2 / 2.0f;
            final float n5 = n3 / 2.0f;
            transform.postRotate((float)n, n4, n5);
            final RectF rectF = new RectF(0.0f, 0.0f, n2, n3);
            final RectF rectF2 = new RectF();
            transform.mapRect(rectF2, rectF);
            transform.postScale(n2 / rectF2.width(), n3 / rectF2.height(), n4, n5);
        }
        textureView.setTransform(transform);
    }
    
    private void b() {
        final View b = this.b;
        if (b != null) {
            b.setVisibility(0);
        }
    }
    
    private void d() {
        final ImageView e = this.e;
        if (e != null) {
            e.setImageResource(17170445);
            this.e.setVisibility(4);
        }
    }
    
    private boolean f(final int n) {
        return n == 19 || n == 270 || n == 22 || n == 271 || n == 20 || n == 269 || n == 21 || n == 268 || n == 23;
    }
    
    private boolean g() {
        final Player w = this.w;
        return w != null && w.e() && this.w.E();
    }
    
    private void h(final boolean b) {
        if (this.g() && this.H) {
            return;
        }
        if (this.v()) {
            final boolean b2 = this.i.j() && this.i.getShowTimeoutMs() <= 0;
            final boolean l = this.l();
            if (b || b2 || l) {
                this.n(l);
            }
        }
    }
    
    private boolean j(final MediaMetadata mediaMetadata) {
        final byte[] j = mediaMetadata.j;
        return j != null && this.k((Drawable)new BitmapDrawable(this.getResources(), BitmapFactory.decodeByteArray(j, 0, j.length)));
    }
    
    private boolean k(final Drawable imageDrawable) {
        if (imageDrawable != null) {
            final int intrinsicWidth = imageDrawable.getIntrinsicWidth();
            final int intrinsicHeight = imageDrawable.getIntrinsicHeight();
            if (intrinsicWidth > 0 && intrinsicHeight > 0) {
                this.i(this.a, intrinsicWidth / (float)intrinsicHeight);
                this.e.setImageDrawable(imageDrawable);
                this.e.setVisibility(0);
                return true;
            }
        }
        return false;
    }
    
    private boolean l() {
        final Player w = this.w;
        final boolean b = true;
        if (w == null) {
            return true;
        }
        final int playbackState = w.getPlaybackState();
        if (this.G) {
            boolean b2 = b;
            if (playbackState == 1) {
                return b2;
            }
            b2 = b;
            if (playbackState == 4) {
                return b2;
            }
            if (!this.w.E()) {
                b2 = b;
                return b2;
            }
        }
        return false;
    }
    
    private void n(final boolean b) {
        if (!this.v()) {
            return;
        }
        final PlayerControlView i = this.i;
        int f;
        if (b) {
            f = 0;
        }
        else {
            f = this.F;
        }
        i.setShowTimeoutMs(f);
        this.i.p();
    }
    
    private void o() {
        if (this.v()) {
            if (this.w != null) {
                if (!this.i.j()) {
                    this.h(true);
                }
                else if (this.I) {
                    this.i.g();
                }
            }
        }
    }
    
    private void p() {
        final Player w = this.w;
        VideoSize videoSize;
        if (w != null) {
            videoSize = w.L();
        }
        else {
            videoSize = VideoSize.e;
        }
        final int a = videoSize.a;
        final int b = videoSize.b;
        final int c = videoSize.c;
        final float n = 0.0f;
        float n2;
        if (b != 0 && a != 0) {
            n2 = a * videoSize.d / b;
        }
        else {
            n2 = 0.0f;
        }
        final View c2 = this.c;
        float n3 = n2;
        if (c2 instanceof TextureView) {
            n3 = n2;
            Label_0128: {
                if (n2 > 0.0f) {
                    if (c != 90) {
                        n3 = n2;
                        if (c != 270) {
                            break Label_0128;
                        }
                    }
                    n3 = 1.0f / n2;
                }
            }
            if (this.J != 0) {
                c2.removeOnLayoutChangeListener((View$OnLayoutChangeListener)null);
            }
            if ((this.J = c) != 0) {
                this.c.addOnLayoutChangeListener((View$OnLayoutChangeListener)null);
            }
            a((TextureView)this.c, this.J);
        }
        final AspectRatioFrameLayout a2 = this.a;
        float n4;
        if (this.d) {
            n4 = n;
        }
        else {
            n4 = n3;
        }
        this.i(a2, n4);
    }
    
    private void q() {
        if (this.g != null) {
            final Player w = this.w;
            final boolean b = true;
            final int n = 0;
            int n2 = 0;
            Label_0072: {
                if (w != null && w.getPlaybackState() == 2) {
                    final int b2 = this.B;
                    n2 = (b ? 1 : 0);
                    if (b2 == 2) {
                        break Label_0072;
                    }
                    if (b2 == 1 && this.w.E()) {
                        n2 = (b ? 1 : 0);
                        break Label_0072;
                    }
                }
                n2 = 0;
            }
            final View g = this.g;
            int visibility;
            if (n2 != 0) {
                visibility = n;
            }
            else {
                visibility = 8;
            }
            g.setVisibility(visibility);
        }
    }
    
    private void r() {
        final PlayerControlView i = this.i;
        CharSequence string = null;
        if (i != null && this.x) {
            if (i.getVisibility() == 0) {
                if (this.I) {
                    string = this.getResources().getString(R.string.e);
                }
                this.setContentDescription(string);
            }
            else {
                this.setContentDescription((CharSequence)this.getResources().getString(R.string.l));
            }
        }
        else {
            this.setContentDescription((CharSequence)null);
        }
    }
    
    private void s() {
        final TextView h = this.h;
        if (h != null) {
            final CharSequence e = this.E;
            if (e != null) {
                h.setText(e);
                this.h.setVisibility(0);
                return;
            }
            final Player w = this.w;
            PlaybackException a;
            if (w != null) {
                a = w.a();
            }
            else {
                a = null;
            }
            if (a != null) {
                final ErrorMessageProvider<? super PlaybackException> d = this.D;
                if (d != null) {
                    this.h.setText((CharSequence)d.a(a).second);
                    this.h.setVisibility(0);
                    return;
                }
            }
            this.h.setVisibility(8);
        }
    }
    
    private void t(final boolean b) {
        final Player w = this.w;
        if (w == null || !w.t(30) || w.p().c()) {
            if (!this.C) {
                this.d();
                this.b();
            }
            return;
        }
        if (b && !this.C) {
            this.b();
        }
        if (w.p().d(2)) {
            this.d();
            return;
        }
        this.b();
        if (this.u()) {
            if (this.j(w.f0())) {
                return;
            }
            if (this.k(this.A)) {
                return;
            }
        }
        this.d();
    }
    
    private boolean u() {
        if (this.z) {
            Assertions.i(this.e);
            return true;
        }
        return false;
    }
    
    private boolean v() {
        if (this.x) {
            Assertions.i(this.i);
            return true;
        }
        return false;
    }
    
    public boolean c(final KeyEvent keyEvent) {
        return this.v() && this.i.c(keyEvent);
    }
    
    public boolean dispatchKeyEvent(final KeyEvent keyEvent) {
        final Player w = this.w;
        if (w != null && w.e()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        final boolean f = this.f(keyEvent.getKeyCode());
        final boolean b = false;
        if (f && this.v() && !this.i.j()) {
            this.h(true);
        }
        else if (!this.c(keyEvent) && !super.dispatchKeyEvent(keyEvent)) {
            boolean b2 = b;
            if (!f) {
                return b2;
            }
            b2 = b;
            if (this.v()) {
                this.h(true);
                b2 = b;
                return b2;
            }
            return b2;
        }
        else {
            this.h(true);
        }
        return true;
    }
    
    public void e() {
        final PlayerControlView i = this.i;
        if (i != null) {
            i.g();
        }
    }
    
    public List<AdOverlayInfo> getAdOverlayInfos() {
        final ArrayList list = new ArrayList();
        final FrameLayout p = this.p;
        if (p != null) {
            list.add(new AdOverlayInfo((View)p, 4, "Transparent overlay does not impact viewability"));
        }
        final PlayerControlView i = this.i;
        if (i != null) {
            list.add(new AdOverlayInfo((View)i, 1));
        }
        return (List<AdOverlayInfo>)ImmutableList.copyOf((Collection)list);
    }
    
    public ViewGroup getAdViewGroup() {
        return Assertions.j((ViewGroup)this.j, "exo_ad_overlay must be present for ad playback");
    }
    
    public boolean getControllerAutoShow() {
        return this.G;
    }
    
    public boolean getControllerHideOnTouch() {
        return this.I;
    }
    
    public int getControllerShowTimeoutMs() {
        return this.F;
    }
    
    public Drawable getDefaultArtwork() {
        return this.A;
    }
    
    public FrameLayout getOverlayFrameLayout() {
        return this.p;
    }
    
    public Player getPlayer() {
        return this.w;
    }
    
    public int getResizeMode() {
        Assertions.i(this.a);
        return this.a.getResizeMode();
    }
    
    public SubtitleView getSubtitleView() {
        return this.f;
    }
    
    public boolean getUseArtwork() {
        return this.z;
    }
    
    public boolean getUseController() {
        return this.x;
    }
    
    public View getVideoSurfaceView() {
        return this.c;
    }
    
    protected void i(final AspectRatioFrameLayout aspectRatioFrameLayout, final float aspectRatio) {
        if (aspectRatioFrameLayout != null) {
            aspectRatioFrameLayout.setAspectRatio(aspectRatio);
        }
    }
    
    public void m() {
        this.n(this.l());
    }
    
    public boolean onTrackballEvent(final MotionEvent motionEvent) {
        if (this.v() && this.w != null) {
            this.h(true);
            return true;
        }
        return false;
    }
    
    public boolean performClick() {
        this.o();
        return super.performClick();
    }
    
    public void setAspectRatioListener(final AspectRatioFrameLayout.AspectRatioListener aspectRatioListener) {
        Assertions.i(this.a);
        this.a.setAspectRatioListener(aspectRatioListener);
    }
    
    public void setControllerAutoShow(final boolean g) {
        this.G = g;
    }
    
    public void setControllerHideDuringAds(final boolean h) {
        this.H = h;
    }
    
    public void setControllerHideOnTouch(final boolean i) {
        Assertions.i(this.i);
        this.I = i;
        this.r();
    }
    
    public void setControllerShowTimeoutMs(final int f) {
        Assertions.i(this.i);
        this.F = f;
        if (this.i.j()) {
            this.m();
        }
    }
    
    public void setControllerVisibilityListener(final PlayerControlView.VisibilityListener y) {
        Assertions.i(this.i);
        final PlayerControlView.VisibilityListener y2 = this.y;
        if (y2 == y) {
            return;
        }
        if (y2 != null) {
            this.i.k(y2);
        }
        if ((this.y = y) != null) {
            this.i.a(y);
        }
    }
    
    public void setCustomErrorMessage(final CharSequence e) {
        Assertions.g(this.h != null);
        this.E = e;
        this.s();
    }
    
    public void setDefaultArtwork(final Drawable a) {
        if (this.A != a) {
            this.A = a;
            this.t(false);
        }
    }
    
    public void setErrorMessageProvider(final ErrorMessageProvider<? super PlaybackException> d) {
        if (this.D != d) {
            this.D = d;
            this.s();
        }
    }
    
    public void setKeepContentOnPlayerReset(final boolean c) {
        if (this.C != c) {
            this.C = c;
            this.t(false);
        }
    }
    
    public void setPlayer(final Player player) {
        Assertions.g(Looper.myLooper() == Looper.getMainLooper());
        Assertions.a(player == null || player.x() == Looper.getMainLooper());
        final Player w = this.w;
        if (w == player) {
            return;
        }
        if (w != null) {
            w.g(null);
            if (w.t(27)) {
                final View c = this.c;
                if (c instanceof TextureView) {
                    w.K((TextureView)c);
                }
                else if (c instanceof SurfaceView) {
                    w.Z((SurfaceView)c);
                }
            }
        }
        final SubtitleView f = this.f;
        if (f != null) {
            f.setCues(null);
        }
        this.w = player;
        if (this.v()) {
            this.i.setPlayer(player);
        }
        this.q();
        this.s();
        this.t(true);
        if (player != null) {
            if (player.t(27)) {
                final View c2 = this.c;
                if (c2 instanceof TextureView) {
                    player.A((TextureView)c2);
                }
                else if (c2 instanceof SurfaceView) {
                    player.j((SurfaceView)c2);
                }
                this.p();
            }
            if (this.f != null && player.t(28)) {
                this.f.setCues((List<Cue>)player.r().a);
            }
            player.S(null);
            this.h(false);
        }
        else {
            this.e();
        }
    }
    
    public void setRepeatToggleModes(final int repeatToggleModes) {
        Assertions.i(this.i);
        this.i.setRepeatToggleModes(repeatToggleModes);
    }
    
    public void setResizeMode(final int resizeMode) {
        Assertions.i(this.a);
        this.a.setResizeMode(resizeMode);
    }
    
    public void setShowBuffering(final int b) {
        if (this.B != b) {
            this.B = b;
            this.q();
        }
    }
    
    public void setShowFastForwardButton(final boolean showFastForwardButton) {
        Assertions.i(this.i);
        this.i.setShowFastForwardButton(showFastForwardButton);
    }
    
    public void setShowMultiWindowTimeBar(final boolean showMultiWindowTimeBar) {
        Assertions.i(this.i);
        this.i.setShowMultiWindowTimeBar(showMultiWindowTimeBar);
    }
    
    public void setShowNextButton(final boolean showNextButton) {
        Assertions.i(this.i);
        this.i.setShowNextButton(showNextButton);
    }
    
    public void setShowPreviousButton(final boolean showPreviousButton) {
        Assertions.i(this.i);
        this.i.setShowPreviousButton(showPreviousButton);
    }
    
    public void setShowRewindButton(final boolean showRewindButton) {
        Assertions.i(this.i);
        this.i.setShowRewindButton(showRewindButton);
    }
    
    public void setShowShuffleButton(final boolean showShuffleButton) {
        Assertions.i(this.i);
        this.i.setShowShuffleButton(showShuffleButton);
    }
    
    public void setShutterBackgroundColor(final int backgroundColor) {
        final View b = this.b;
        if (b != null) {
            b.setBackgroundColor(backgroundColor);
        }
    }
    
    public void setUseArtwork(final boolean z) {
        Assertions.g(!z || this.e != null);
        if (this.z != z) {
            this.z = z;
            this.t(false);
        }
    }
    
    public void setUseController(final boolean x) {
        final boolean b = false;
        Assertions.g(!x || this.i != null);
        boolean clickable = false;
        Label_0042: {
            if (!x) {
                clickable = b;
                if (!this.hasOnClickListeners()) {
                    break Label_0042;
                }
            }
            clickable = true;
        }
        this.setClickable(clickable);
        if (this.x == x) {
            return;
        }
        this.x = x;
        if (this.v()) {
            this.i.setPlayer(this.w);
        }
        else {
            final PlayerControlView i = this.i;
            if (i != null) {
                i.g();
                this.i.setPlayer(null);
            }
        }
        this.r();
    }
    
    public void setVisibility(final int n) {
        super.setVisibility(n);
        final View c = this.c;
        if (c instanceof SurfaceView) {
            c.setVisibility(n);
        }
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.TYPE_USE })
    public @interface ShowBuffering {
    }
}
