// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.ui;

import com.google.android.exoplayer2.Tracks;
import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.Timeline;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import com.google.android.exoplayer2.text.Cue;
import android.os.Looper;
import android.view.MotionEvent;
import java.util.Collection;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import android.view.KeyEvent;
import android.content.res.Resources$Theme;
import android.content.res.Resources;
import android.graphics.RectF;
import android.graphics.Matrix;
import android.view.View$OnLayoutChangeListener;
import com.google.android.exoplayer2.video.VideoSize;
import com.google.android.exoplayer2.util.Assertions;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.BitmapFactory;
import com.google.android.exoplayer2.MediaMetadata;
import android.content.res.TypedArray;
import androidx.core.content.a;
import android.view.View$OnClickListener;
import android.view.TextureView;
import android.view.SurfaceView;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import com.google.android.exoplayer2.util.Util;
import android.util.AttributeSet;
import android.content.Context;
import com.google.android.exoplayer2.Player;
import android.widget.TextView;
import android.widget.ImageView;
import android.view.View;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.util.ErrorMessageProvider;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;

public class StyledPlayerView extends FrameLayout implements AdViewProvider
{
    private StyledPlayerControlView.VisibilityListener A;
    private FullscreenButtonClickListener B;
    private boolean C;
    private Drawable D;
    private int E;
    private boolean F;
    private ErrorMessageProvider<? super PlaybackException> G;
    private CharSequence H;
    private int I;
    private boolean J;
    private boolean K;
    private boolean L;
    private int M;
    private final a a;
    private final AspectRatioFrameLayout b;
    private final View c;
    private final View d;
    private final boolean e;
    private final ImageView f;
    private final SubtitleView g;
    private final View h;
    private final TextView i;
    private final StyledPlayerControlView j;
    private final FrameLayout p;
    private final FrameLayout w;
    private Player x;
    private boolean y;
    private ControllerVisibilityListener z;
    
    public StyledPlayerView(final Context context, final AttributeSet set) {
        this(context, set, 0);
    }
    
    public StyledPlayerView(final Context context, final AttributeSet set, int i) {
        super(context, set, i);
        final a a = new a();
        this.a = a;
        if (this.isInEditMode()) {
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = false;
            this.f = null;
            this.g = null;
            this.h = null;
            this.i = null;
            this.j = null;
            this.p = null;
            this.w = null;
            final ImageView imageView = new ImageView(context);
            if (Util.a >= 23) {
                t(this.getResources(), imageView);
            }
            else {
                s(this.getResources(), imageView);
            }
            this.addView((View)imageView);
            return;
        }
        int n = R.layout.c;
        boolean hasValue = false;
        int color = 0;
        boolean boolean1 = false;
        boolean boolean2 = false;
        int int1 = 0;
        int int2 = 0;
        boolean boolean3 = false;
        boolean boolean4 = false;
        int integer = 0;
        boolean boolean5 = false;
        int n2 = 0;
        Label_0370: {
            if (set != null) {
                final TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(set, R.styleable.N, i, 0);
                try {
                    i = R.styleable.X;
                    hasValue = obtainStyledAttributes.hasValue(i);
                    color = obtainStyledAttributes.getColor(i, 0);
                    n = obtainStyledAttributes.getResourceId(R.styleable.T, n);
                    boolean1 = obtainStyledAttributes.getBoolean(R.styleable.Z, true);
                    i = obtainStyledAttributes.getResourceId(R.styleable.P, 0);
                    boolean2 = obtainStyledAttributes.getBoolean(R.styleable.a0, true);
                    int1 = obtainStyledAttributes.getInt(R.styleable.Y, 1);
                    int2 = obtainStyledAttributes.getInt(R.styleable.U, 0);
                    final int int3 = obtainStyledAttributes.getInt(R.styleable.W, 5000);
                    boolean3 = obtainStyledAttributes.getBoolean(R.styleable.R, true);
                    boolean4 = obtainStyledAttributes.getBoolean(R.styleable.O, true);
                    integer = obtainStyledAttributes.getInteger(R.styleable.V, 0);
                    this.F = obtainStyledAttributes.getBoolean(R.styleable.S, this.F);
                    boolean5 = obtainStyledAttributes.getBoolean(R.styleable.Q, true);
                    obtainStyledAttributes.recycle();
                    n2 = i;
                    i = int3;
                    break Label_0370;
                }
                finally {
                    obtainStyledAttributes.recycle();
                }
            }
            i = 5000;
            boolean4 = true;
            int2 = 0;
            boolean5 = true;
            integer = 0;
            boolean3 = true;
            int1 = 1;
            color = 0;
            hasValue = false;
            boolean1 = true;
            n2 = 0;
            boolean2 = true;
        }
        LayoutInflater.from(context).inflate(n, (ViewGroup)this);
        this.setDescendantFocusability(262144);
        final AspectRatioFrameLayout b = (AspectRatioFrameLayout)this.findViewById(R.id.i);
        this.b = b;
        if (b != null) {
            D(b, int2);
        }
        final View viewById = this.findViewById(R.id.M);
        this.c = viewById;
        if (viewById != null && hasValue) {
            viewById.setBackgroundColor(color);
        }
        boolean e = false;
        if (b != null && int1 != 0) {
            final ViewGroup$LayoutParams layoutParams = new ViewGroup$LayoutParams(-1, -1);
            Label_0625: {
                Label_0622: {
                    if (int1 != 2) {
                        if (int1 != 3) {
                            if (int1 != 4) {
                                this.d = (View)new SurfaceView(context);
                                break Label_0622;
                            }
                            try {
                                this.d = (View)Class.forName("com.google.android.exoplayer2.video.VideoDecoderGLSurfaceView").getConstructor(Context.class).newInstance(context);
                                break Label_0622;
                            }
                            catch (final Exception ex) {
                                throw new IllegalStateException("video_decoder_gl_surface_view requires an ExoPlayer dependency", ex);
                            }
                        }
                        try {
                            this.d = (View)Class.forName("com.google.android.exoplayer2.video.spherical.SphericalGLSurfaceView").getConstructor(Context.class).newInstance(context);
                            e = true;
                            break Label_0625;
                        }
                        catch (final Exception ex2) {
                            throw new IllegalStateException("spherical_gl_surface_view requires an ExoPlayer dependency", ex2);
                        }
                    }
                    this.d = (View)new TextureView(context);
                }
                e = false;
            }
            this.d.setLayoutParams(layoutParams);
            this.d.setOnClickListener((View$OnClickListener)a);
            this.d.setClickable(false);
            b.addView(this.d, 0);
        }
        else {
            this.d = null;
            e = false;
        }
        this.e = e;
        this.p = (FrameLayout)this.findViewById(R.id.a);
        this.w = (FrameLayout)this.findViewById(R.id.A);
        final ImageView f = (ImageView)this.findViewById(R.id.b);
        this.f = f;
        this.C = (boolean1 && f != null);
        if (n2 != 0) {
            this.D = androidx.core.content.a.getDrawable(this.getContext(), n2);
        }
        final SubtitleView g = (SubtitleView)this.findViewById(R.id.P);
        if ((this.g = g) != null) {
            g.d();
            g.e();
        }
        final View viewById2 = this.findViewById(R.id.f);
        if ((this.h = viewById2) != null) {
            viewById2.setVisibility(8);
        }
        this.E = integer;
        final TextView j = (TextView)this.findViewById(R.id.n);
        if ((this.i = j) != null) {
            j.setVisibility(8);
        }
        final int k = R.id.j;
        final StyledPlayerControlView l = (StyledPlayerControlView)this.findViewById(k);
        final View viewById3 = this.findViewById(R.id.k);
        if (l != null) {
            this.j = l;
        }
        else if (viewById3 != null) {
            final StyledPlayerControlView m = new StyledPlayerControlView(context, null, 0, set);
            (this.j = m).setId(k);
            m.setLayoutParams(viewById3.getLayoutParams());
            final ViewGroup viewGroup = (ViewGroup)viewById3.getParent();
            final int indexOfChild = viewGroup.indexOfChild(viewById3);
            viewGroup.removeView(viewById3);
            viewGroup.addView((View)m, indexOfChild);
        }
        else {
            this.j = null;
        }
        final StyledPlayerControlView j2 = this.j;
        if (j2 == null) {
            i = 0;
        }
        this.I = i;
        this.L = boolean3;
        this.J = boolean4;
        this.K = boolean5;
        this.y = (boolean2 && j2 != null);
        if (j2 != null) {
            j2.c0();
            this.j.S((StyledPlayerControlView.VisibilityListener)a);
        }
        if (boolean2) {
            this.setClickable(true);
        }
        this.K();
    }
    
    private boolean B(final MediaMetadata mediaMetadata) {
        final byte[] j = mediaMetadata.j;
        return j != null && this.C((Drawable)new BitmapDrawable(this.getResources(), BitmapFactory.decodeByteArray(j, 0, j.length)));
    }
    
    private boolean C(final Drawable imageDrawable) {
        if (imageDrawable != null) {
            final int intrinsicWidth = imageDrawable.getIntrinsicWidth();
            final int intrinsicHeight = imageDrawable.getIntrinsicHeight();
            if (intrinsicWidth > 0 && intrinsicHeight > 0) {
                this.A(this.b, intrinsicWidth / (float)intrinsicHeight);
                this.f.setImageDrawable(imageDrawable);
                this.f.setVisibility(0);
                return true;
            }
        }
        return false;
    }
    
    private static void D(final AspectRatioFrameLayout aspectRatioFrameLayout, final int resizeMode) {
        aspectRatioFrameLayout.setResizeMode(resizeMode);
    }
    
    private boolean E() {
        final Player x = this.x;
        final boolean b = true;
        if (x == null) {
            return true;
        }
        final int playbackState = x.getPlaybackState();
        if (this.J && !this.x.w().u()) {
            boolean b2 = b;
            if (playbackState == 1) {
                return b2;
            }
            b2 = b;
            if (playbackState == 4) {
                return b2;
            }
            if (!Assertions.e(this.x).E()) {
                b2 = b;
                return b2;
            }
        }
        return false;
    }
    
    private void G(final boolean b) {
        if (!this.P()) {
            return;
        }
        final StyledPlayerControlView j = this.j;
        int i;
        if (b) {
            i = 0;
        }
        else {
            i = this.I;
        }
        j.setShowTimeoutMs(i);
        this.j.r0();
    }
    
    private void H() {
        if (this.P()) {
            if (this.x != null) {
                if (!this.j.f0()) {
                    this.z(true);
                }
                else if (this.L) {
                    this.j.b0();
                }
            }
        }
    }
    
    private void I() {
        final Player x = this.x;
        VideoSize videoSize;
        if (x != null) {
            videoSize = x.L();
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
        final View d = this.d;
        float n3 = n2;
        if (d instanceof TextureView) {
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
            if (this.M != 0) {
                d.removeOnLayoutChangeListener((View$OnLayoutChangeListener)this.a);
            }
            if ((this.M = c) != 0) {
                this.d.addOnLayoutChangeListener((View$OnLayoutChangeListener)this.a);
            }
            q((TextureView)this.d, this.M);
        }
        final AspectRatioFrameLayout b2 = this.b;
        if (this.e) {
            n3 = n;
        }
        this.A(b2, n3);
    }
    
    private void J() {
        if (this.h != null) {
            final Player x = this.x;
            final boolean b = true;
            final int n = 0;
            int n2 = 0;
            Label_0072: {
                if (x != null && x.getPlaybackState() == 2) {
                    final int e = this.E;
                    n2 = (b ? 1 : 0);
                    if (e == 2) {
                        break Label_0072;
                    }
                    if (e == 1 && this.x.E()) {
                        n2 = (b ? 1 : 0);
                        break Label_0072;
                    }
                }
                n2 = 0;
            }
            final View h = this.h;
            int visibility;
            if (n2 != 0) {
                visibility = n;
            }
            else {
                visibility = 8;
            }
            h.setVisibility(visibility);
        }
    }
    
    private void K() {
        final StyledPlayerControlView j = this.j;
        CharSequence string = null;
        if (j != null && this.y) {
            if (j.f0()) {
                if (this.L) {
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
    
    private void L() {
        if (this.y() && this.K) {
            this.w();
        }
        else {
            this.z(false);
        }
    }
    
    private void M() {
        final TextView i = this.i;
        if (i != null) {
            final CharSequence h = this.H;
            if (h != null) {
                i.setText(h);
                this.i.setVisibility(0);
                return;
            }
            final Player x = this.x;
            PlaybackException a;
            if (x != null) {
                a = x.a();
            }
            else {
                a = null;
            }
            if (a != null) {
                final ErrorMessageProvider<? super PlaybackException> g = this.G;
                if (g != null) {
                    this.i.setText((CharSequence)g.a(a).second);
                    this.i.setVisibility(0);
                    return;
                }
            }
            this.i.setVisibility(8);
        }
    }
    
    private void N(final boolean b) {
        final Player x = this.x;
        if (x == null || x.p().c()) {
            if (!this.F) {
                this.v();
                this.r();
            }
            return;
        }
        if (b && !this.F) {
            this.r();
        }
        if (x.p().d(2)) {
            this.v();
            return;
        }
        this.r();
        if (this.O()) {
            if (this.B(x.f0())) {
                return;
            }
            if (this.C(this.D)) {
                return;
            }
        }
        this.v();
    }
    
    private boolean O() {
        if (this.C) {
            Assertions.i(this.f);
            return true;
        }
        return false;
    }
    
    private boolean P() {
        if (this.y) {
            Assertions.i(this.j);
            return true;
        }
        return false;
    }
    
    static SubtitleView a(final StyledPlayerView styledPlayerView) {
        return styledPlayerView.g;
    }
    
    static void b(final StyledPlayerView styledPlayerView) {
        styledPlayerView.I();
    }
    
    static int c(final StyledPlayerView styledPlayerView) {
        return styledPlayerView.M;
    }
    
    static void d(final TextureView textureView, final int n) {
        q(textureView, n);
    }
    
    static void e(final StyledPlayerView styledPlayerView) {
        styledPlayerView.H();
    }
    
    static void f(final StyledPlayerView styledPlayerView) {
        styledPlayerView.K();
    }
    
    static ControllerVisibilityListener g(final StyledPlayerView styledPlayerView) {
        return styledPlayerView.z;
    }
    
    static FullscreenButtonClickListener h(final StyledPlayerView styledPlayerView) {
        return styledPlayerView.B;
    }
    
    static View i(final StyledPlayerView styledPlayerView) {
        return styledPlayerView.c;
    }
    
    static Player j(final StyledPlayerView styledPlayerView) {
        return styledPlayerView.x;
    }
    
    static void k(final StyledPlayerView styledPlayerView, final boolean b) {
        styledPlayerView.N(b);
    }
    
    static void l(final StyledPlayerView styledPlayerView) {
        styledPlayerView.J();
    }
    
    static void m(final StyledPlayerView styledPlayerView) {
        styledPlayerView.M();
    }
    
    static void n(final StyledPlayerView styledPlayerView) {
        styledPlayerView.L();
    }
    
    static boolean o(final StyledPlayerView styledPlayerView) {
        return styledPlayerView.y();
    }
    
    static boolean p(final StyledPlayerView styledPlayerView) {
        return styledPlayerView.K;
    }
    
    private static void q(final TextureView textureView, final int n) {
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
    
    private void r() {
        final View c = this.c;
        if (c != null) {
            c.setVisibility(0);
        }
    }
    
    private static void s(final Resources resources, final ImageView imageView) {
        imageView.setImageDrawable(resources.getDrawable(R.drawable.a));
        imageView.setBackgroundColor(resources.getColor(R.color.a));
    }
    
    private static void t(final Resources resources, final ImageView imageView) {
        imageView.setImageDrawable(resources.getDrawable(R.drawable.a, (Resources$Theme)null));
        imageView.setBackgroundColor(resources.getColor(R.color.a, (Resources$Theme)null));
    }
    
    private void v() {
        final ImageView f = this.f;
        if (f != null) {
            f.setImageResource(17170445);
            this.f.setVisibility(4);
        }
    }
    
    private boolean x(final int n) {
        return n == 19 || n == 270 || n == 22 || n == 271 || n == 20 || n == 269 || n == 21 || n == 268 || n == 23;
    }
    
    private boolean y() {
        final Player x = this.x;
        return x != null && x.e() && this.x.E();
    }
    
    private void z(final boolean b) {
        if (this.y() && this.K) {
            return;
        }
        if (this.P()) {
            final boolean b2 = this.j.f0() && this.j.getShowTimeoutMs() <= 0;
            final boolean e = this.E();
            if (b || b2 || e) {
                this.G(e);
            }
        }
    }
    
    protected void A(final AspectRatioFrameLayout aspectRatioFrameLayout, final float aspectRatio) {
        if (aspectRatioFrameLayout != null) {
            aspectRatioFrameLayout.setAspectRatio(aspectRatio);
        }
    }
    
    public void F() {
        this.G(this.E());
    }
    
    public boolean dispatchKeyEvent(final KeyEvent keyEvent) {
        final Player x = this.x;
        if (x != null && x.e()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        final boolean x2 = this.x(keyEvent.getKeyCode());
        final boolean b = false;
        if (x2 && this.P() && !this.j.f0()) {
            this.z(true);
        }
        else if (!this.u(keyEvent) && !super.dispatchKeyEvent(keyEvent)) {
            boolean b2 = b;
            if (!x2) {
                return b2;
            }
            b2 = b;
            if (this.P()) {
                this.z(true);
                b2 = b;
                return b2;
            }
            return b2;
        }
        else {
            this.z(true);
        }
        return true;
    }
    
    public List<AdOverlayInfo> getAdOverlayInfos() {
        final ArrayList list = new ArrayList();
        final FrameLayout w = this.w;
        if (w != null) {
            list.add(new AdOverlayInfo((View)w, 4, "Transparent overlay does not impact viewability"));
        }
        final StyledPlayerControlView j = this.j;
        if (j != null) {
            list.add(new AdOverlayInfo((View)j, 1));
        }
        return (List<AdOverlayInfo>)ImmutableList.copyOf((Collection)list);
    }
    
    public ViewGroup getAdViewGroup() {
        return Assertions.j((ViewGroup)this.p, "exo_ad_overlay must be present for ad playback");
    }
    
    public boolean getControllerAutoShow() {
        return this.J;
    }
    
    public boolean getControllerHideOnTouch() {
        return this.L;
    }
    
    public int getControllerShowTimeoutMs() {
        return this.I;
    }
    
    public Drawable getDefaultArtwork() {
        return this.D;
    }
    
    public FrameLayout getOverlayFrameLayout() {
        return this.w;
    }
    
    public Player getPlayer() {
        return this.x;
    }
    
    public int getResizeMode() {
        Assertions.i(this.b);
        return this.b.getResizeMode();
    }
    
    public SubtitleView getSubtitleView() {
        return this.g;
    }
    
    public boolean getUseArtwork() {
        return this.C;
    }
    
    public boolean getUseController() {
        return this.y;
    }
    
    public View getVideoSurfaceView() {
        return this.d;
    }
    
    public boolean onTrackballEvent(final MotionEvent motionEvent) {
        if (this.P() && this.x != null) {
            this.z(true);
            return true;
        }
        return false;
    }
    
    public boolean performClick() {
        this.H();
        return super.performClick();
    }
    
    public void setAspectRatioListener(final AspectRatioFrameLayout.AspectRatioListener aspectRatioListener) {
        Assertions.i(this.b);
        this.b.setAspectRatioListener(aspectRatioListener);
    }
    
    public void setControllerAutoShow(final boolean j) {
        this.J = j;
    }
    
    public void setControllerHideDuringAds(final boolean k) {
        this.K = k;
    }
    
    public void setControllerHideOnTouch(final boolean l) {
        Assertions.i(this.j);
        this.L = l;
        this.K();
    }
    
    @Deprecated
    public void setControllerOnFullScreenModeChangedListener(final StyledPlayerControlView.OnFullScreenModeChangedListener onFullScreenModeChangedListener) {
        Assertions.i(this.j);
        this.B = null;
        this.j.setOnFullScreenModeChangedListener(onFullScreenModeChangedListener);
    }
    
    public void setControllerShowTimeoutMs(final int i) {
        Assertions.i(this.j);
        this.I = i;
        if (this.j.f0()) {
            this.F();
        }
    }
    
    @Deprecated
    public void setControllerVisibilityListener(final StyledPlayerControlView.VisibilityListener a) {
        Assertions.i(this.j);
        final StyledPlayerControlView.VisibilityListener a2 = this.A;
        if (a2 == a) {
            return;
        }
        if (a2 != null) {
            this.j.m0(a2);
        }
        if ((this.A = a) != null) {
            this.j.S(a);
        }
        this.setControllerVisibilityListener((ControllerVisibilityListener)null);
    }
    
    public void setControllerVisibilityListener(final ControllerVisibilityListener z) {
        this.z = z;
        this.setControllerVisibilityListener((StyledPlayerControlView.VisibilityListener)null);
    }
    
    public void setCustomErrorMessage(final CharSequence h) {
        Assertions.g(this.i != null);
        this.H = h;
        this.M();
    }
    
    public void setDefaultArtwork(final Drawable d) {
        if (this.D != d) {
            this.D = d;
            this.N(false);
        }
    }
    
    public void setErrorMessageProvider(final ErrorMessageProvider<? super PlaybackException> g) {
        if (this.G != g) {
            this.G = g;
            this.M();
        }
    }
    
    public void setFullscreenButtonClickListener(final FullscreenButtonClickListener b) {
        Assertions.i(this.j);
        this.B = b;
        this.j.setOnFullScreenModeChangedListener((StyledPlayerControlView.OnFullScreenModeChangedListener)this.a);
    }
    
    public void setKeepContentOnPlayerReset(final boolean f) {
        if (this.F != f) {
            this.F = f;
            this.N(false);
        }
    }
    
    public void setPlayer(final Player player) {
        Assertions.g(Looper.myLooper() == Looper.getMainLooper());
        Assertions.a(player == null || player.x() == Looper.getMainLooper());
        final Player x = this.x;
        if (x == player) {
            return;
        }
        if (x != null) {
            x.g((Player.Listener)this.a);
            final View d = this.d;
            if (d instanceof TextureView) {
                x.K((TextureView)d);
            }
            else if (d instanceof SurfaceView) {
                x.Z((SurfaceView)d);
            }
        }
        final SubtitleView g = this.g;
        if (g != null) {
            g.setCues(null);
        }
        this.x = player;
        if (this.P()) {
            this.j.setPlayer(player);
        }
        this.J();
        this.M();
        this.N(true);
        if (player != null) {
            if (player.t(27)) {
                final View d2 = this.d;
                if (d2 instanceof TextureView) {
                    player.A((TextureView)d2);
                }
                else if (d2 instanceof SurfaceView) {
                    player.j((SurfaceView)d2);
                }
                this.I();
            }
            if (this.g != null && player.t(28)) {
                this.g.setCues((List<Cue>)player.r().a);
            }
            player.S((Player.Listener)this.a);
            this.z(false);
        }
        else {
            this.w();
        }
    }
    
    public void setRepeatToggleModes(final int repeatToggleModes) {
        Assertions.i(this.j);
        this.j.setRepeatToggleModes(repeatToggleModes);
    }
    
    public void setResizeMode(final int resizeMode) {
        Assertions.i(this.b);
        this.b.setResizeMode(resizeMode);
    }
    
    public void setShowBuffering(final int e) {
        if (this.E != e) {
            this.E = e;
            this.J();
        }
    }
    
    public void setShowFastForwardButton(final boolean showFastForwardButton) {
        Assertions.i(this.j);
        this.j.setShowFastForwardButton(showFastForwardButton);
    }
    
    public void setShowMultiWindowTimeBar(final boolean showMultiWindowTimeBar) {
        Assertions.i(this.j);
        this.j.setShowMultiWindowTimeBar(showMultiWindowTimeBar);
    }
    
    public void setShowNextButton(final boolean showNextButton) {
        Assertions.i(this.j);
        this.j.setShowNextButton(showNextButton);
    }
    
    public void setShowPreviousButton(final boolean showPreviousButton) {
        Assertions.i(this.j);
        this.j.setShowPreviousButton(showPreviousButton);
    }
    
    public void setShowRewindButton(final boolean showRewindButton) {
        Assertions.i(this.j);
        this.j.setShowRewindButton(showRewindButton);
    }
    
    public void setShowShuffleButton(final boolean showShuffleButton) {
        Assertions.i(this.j);
        this.j.setShowShuffleButton(showShuffleButton);
    }
    
    public void setShowSubtitleButton(final boolean showSubtitleButton) {
        Assertions.i(this.j);
        this.j.setShowSubtitleButton(showSubtitleButton);
    }
    
    public void setShowVrButton(final boolean showVrButton) {
        Assertions.i(this.j);
        this.j.setShowVrButton(showVrButton);
    }
    
    public void setShutterBackgroundColor(final int backgroundColor) {
        final View c = this.c;
        if (c != null) {
            c.setBackgroundColor(backgroundColor);
        }
    }
    
    public void setUseArtwork(final boolean c) {
        Assertions.g(!c || this.f != null);
        if (this.C != c) {
            this.C = c;
            this.N(false);
        }
    }
    
    public void setUseController(final boolean y) {
        final boolean b = false;
        Assertions.g(!y || this.j != null);
        boolean clickable = false;
        Label_0042: {
            if (!y) {
                clickable = b;
                if (!this.hasOnClickListeners()) {
                    break Label_0042;
                }
            }
            clickable = true;
        }
        this.setClickable(clickable);
        if (this.y == y) {
            return;
        }
        this.y = y;
        if (this.P()) {
            this.j.setPlayer(this.x);
        }
        else {
            final StyledPlayerControlView j = this.j;
            if (j != null) {
                j.b0();
                this.j.setPlayer(null);
            }
        }
        this.K();
    }
    
    public void setVisibility(final int n) {
        super.setVisibility(n);
        final View d = this.d;
        if (d instanceof SurfaceView) {
            d.setVisibility(n);
        }
    }
    
    public boolean u(final KeyEvent keyEvent) {
        return this.P() && this.j.U(keyEvent);
    }
    
    public void w() {
        final StyledPlayerControlView j = this.j;
        if (j != null) {
            j.b0();
        }
    }
    
    public interface ControllerVisibilityListener
    {
        void a(final int p0);
    }
    
    public interface FullscreenButtonClickListener
    {
        void a(final boolean p0);
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.TYPE_USE })
    public @interface ShowBuffering {
    }
    
    private final class a implements Listener, View$OnLayoutChangeListener, View$OnClickListener, VisibilityListener, OnFullScreenModeChangedListener
    {
        private final Timeline.Period a;
        private Object b;
        final StyledPlayerView c;
        
        public a(final StyledPlayerView c) {
            this.c = c;
            this.a = new Timeline.Period();
        }
        
        public void k(final int n) {
            StyledPlayerView.f(this.c);
            if (StyledPlayerView.g(this.c) != null) {
                StyledPlayerView.g(this.c).a(n);
            }
        }
        
        public void onClick(final View view) {
            StyledPlayerView.e(this.c);
        }
        
        @Override
        public void onCues(final CueGroup cueGroup) {
            if (StyledPlayerView.a(this.c) != null) {
                StyledPlayerView.a(this.c).setCues((List<Cue>)cueGroup.a);
            }
        }
        
        public void onLayoutChange(final View view, final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7, final int n8) {
            StyledPlayerView.d((TextureView)view, StyledPlayerView.c(this.c));
        }
        
        @Override
        public void onPlayWhenReadyChanged(final boolean b, final int n) {
            StyledPlayerView.l(this.c);
            StyledPlayerView.n(this.c);
        }
        
        @Override
        public void onPlaybackStateChanged(final int n) {
            StyledPlayerView.l(this.c);
            StyledPlayerView.m(this.c);
            StyledPlayerView.n(this.c);
        }
        
        @Override
        public void onPositionDiscontinuity(final PositionInfo positionInfo, final PositionInfo positionInfo2, final int n) {
            if (StyledPlayerView.o(this.c) && StyledPlayerView.p(this.c)) {
                this.c.w();
            }
        }
        
        @Override
        public void onRenderedFirstFrame() {
            if (StyledPlayerView.i(this.c) != null) {
                StyledPlayerView.i(this.c).setVisibility(4);
            }
        }
        
        @Override
        public void onTracksChanged(final Tracks tracks) {
            final Player player = Assertions.e(StyledPlayerView.j(this.c));
            final Timeline w = player.w();
            if (w.u()) {
                this.b = null;
            }
            else if (!player.p().c()) {
                this.b = w.k(player.J(), this.a, true).b;
            }
            else {
                final Object b = this.b;
                if (b != null) {
                    final int f = w.f(b);
                    if (f != -1 && player.Y() == w.j(f, this.a).c) {
                        return;
                    }
                    this.b = null;
                }
            }
            StyledPlayerView.k(this.c, false);
        }
        
        @Override
        public void onVideoSizeChanged(final VideoSize videoSize) {
            StyledPlayerView.b(this.c);
        }
        
        public void t(final boolean b) {
            if (StyledPlayerView.h(this.c) != null) {
                StyledPlayerView.h(this.c).a(b);
            }
        }
    }
}
