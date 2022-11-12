// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import android.text.TextUtils;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import com.google.android.exoplayer2.util.Assertions;
import android.os.Bundle;
import android.os.SystemClock;
import com.google.android.exoplayer2.source.MediaPeriodId;

public final class ExoPlaybackException extends PlaybackException
{
    public static final Creator<ExoPlaybackException> CREATOR;
    public static final int TYPE_REMOTE = 3;
    public static final int TYPE_RENDERER = 1;
    public static final int TYPE_SOURCE = 0;
    public static final int TYPE_UNEXPECTED = 2;
    final boolean isRecoverable;
    public final MediaPeriodId mediaPeriodId;
    public final Format rendererFormat;
    public final int rendererFormatSupport;
    public final int rendererIndex;
    public final String rendererName;
    public final int type;
    
    static {
        CREATOR = d.a;
    }
    
    private ExoPlaybackException(final int n, final Throwable t, final int n2) {
        this(n, t, null, n2, null, -1, null, 4, false);
    }
    
    private ExoPlaybackException(final int n, final Throwable t, final String s, final int n2, final String s2, final int n3, final Format format, final int n4, final boolean b) {
        this(e(n, s, s2, n3, format, n4), t, n2, n, s2, n3, format, n4, null, SystemClock.elapsedRealtime(), b);
    }
    
    private ExoPlaybackException(final Bundle bundle) {
        super(bundle);
        this.type = bundle.getInt(PlaybackException.keyForField(1001), 2);
        this.rendererName = bundle.getString(PlaybackException.keyForField(1002));
        this.rendererIndex = bundle.getInt(PlaybackException.keyForField(1003), -1);
        final Bundle bundle2 = bundle.getBundle(PlaybackException.keyForField(1004));
        Format rendererFormat;
        if (bundle2 == null) {
            rendererFormat = null;
        }
        else {
            rendererFormat = Format.S.a(bundle2);
        }
        this.rendererFormat = rendererFormat;
        this.rendererFormatSupport = bundle.getInt(PlaybackException.keyForField(1005), 4);
        this.isRecoverable = bundle.getBoolean(PlaybackException.keyForField(1006), false);
        this.mediaPeriodId = null;
    }
    
    private ExoPlaybackException(final String s, final Throwable t, final int n, final int type, final String rendererName, final int rendererIndex, final Format rendererFormat, final int rendererFormatSupport, final MediaPeriodId mediaPeriodId, final long n2, final boolean isRecoverable) {
        super(s, t, n, n2);
        final boolean b = false;
        Assertions.a(!isRecoverable || type == 1);
        boolean b2 = false;
        Label_0057: {
            if (t == null) {
                b2 = b;
                if (type != 3) {
                    break Label_0057;
                }
            }
            b2 = true;
        }
        Assertions.a(b2);
        this.type = type;
        this.rendererName = rendererName;
        this.rendererIndex = rendererIndex;
        this.rendererFormat = rendererFormat;
        this.rendererFormatSupport = rendererFormatSupport;
        this.mediaPeriodId = mediaPeriodId;
        this.isRecoverable = isRecoverable;
    }
    
    public static ExoPlaybackException createForRemote(final String s) {
        return new ExoPlaybackException(3, null, s, 1001, null, -1, null, 4, false);
    }
    
    public static ExoPlaybackException createForRenderer(final Throwable t, final String s, final int n, final Format format, int n2, final boolean b, final int n3) {
        if (format == null) {
            n2 = 4;
        }
        return new ExoPlaybackException(1, t, null, n3, s, n, format, n2, b);
    }
    
    public static ExoPlaybackException createForSource(final IOException ex, final int n) {
        return new ExoPlaybackException(0, ex, n);
    }
    
    @Deprecated
    public static ExoPlaybackException createForUnexpected(final RuntimeException ex) {
        return createForUnexpected(ex, 1000);
    }
    
    public static ExoPlaybackException createForUnexpected(final RuntimeException ex, final int n) {
        return new ExoPlaybackException(2, ex, n);
    }
    
    public static ExoPlaybackException d(final Bundle bundle) {
        return new ExoPlaybackException(bundle);
    }
    
    private static String e(final int n, final String s, String string, final int n2, final Format format, final int n3) {
        if (n != 0) {
            if (n != 1) {
                if (n != 3) {
                    string = "Unexpected runtime error";
                }
                else {
                    string = "Remote error";
                }
            }
            else {
                final StringBuilder sb = new StringBuilder();
                sb.append(string);
                sb.append(" error, index=");
                sb.append(n2);
                sb.append(", format=");
                sb.append(format);
                sb.append(", format_supported=");
                sb.append(Util.X(n3));
                string = sb.toString();
            }
        }
        else {
            string = "Source error";
        }
        String string2 = string;
        if (!TextUtils.isEmpty((CharSequence)s)) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append(string);
            sb2.append(": ");
            sb2.append(s);
            string2 = sb2.toString();
        }
        return string2;
    }
    
    ExoPlaybackException copyWithMediaPeriodId(final MediaPeriodId mediaPeriodId) {
        return new ExoPlaybackException(Util.j(this.getMessage()), this.getCause(), super.errorCode, this.type, this.rendererName, this.rendererIndex, this.rendererFormat, this.rendererFormatSupport, mediaPeriodId, super.timestampMs, this.isRecoverable);
    }
    
    @Override
    public boolean errorInfoEquals(final PlaybackException ex) {
        final boolean errorInfoEquals = super.errorInfoEquals(ex);
        final boolean b = false;
        if (!errorInfoEquals) {
            return false;
        }
        final ExoPlaybackException ex2 = Util.j(ex);
        boolean b2 = b;
        if (this.type == ex2.type) {
            b2 = b;
            if (Util.c(this.rendererName, ex2.rendererName)) {
                b2 = b;
                if (this.rendererIndex == ex2.rendererIndex) {
                    b2 = b;
                    if (Util.c(this.rendererFormat, ex2.rendererFormat)) {
                        b2 = b;
                        if (this.rendererFormatSupport == ex2.rendererFormatSupport) {
                            b2 = b;
                            if (Util.c(this.mediaPeriodId, ex2.mediaPeriodId)) {
                                b2 = b;
                                if (this.isRecoverable == ex2.isRecoverable) {
                                    b2 = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return b2;
    }
    
    public Exception getRendererException() {
        final int type = this.type;
        boolean b = true;
        if (type != 1) {
            b = false;
        }
        Assertions.g(b);
        return Assertions.e(this.getCause());
    }
    
    public IOException getSourceException() {
        Assertions.g(this.type == 0);
        return Assertions.e(this.getCause());
    }
    
    public RuntimeException getUnexpectedException() {
        Assertions.g(this.type == 2);
        return Assertions.e(this.getCause());
    }
    
    @Override
    public Bundle toBundle() {
        final Bundle bundle = super.toBundle();
        bundle.putInt(PlaybackException.keyForField(1001), this.type);
        bundle.putString(PlaybackException.keyForField(1002), this.rendererName);
        bundle.putInt(PlaybackException.keyForField(1003), this.rendererIndex);
        if (this.rendererFormat != null) {
            bundle.putBundle(PlaybackException.keyForField(1004), this.rendererFormat.toBundle());
        }
        bundle.putInt(PlaybackException.keyForField(1005), this.rendererFormatSupport);
        bundle.putBoolean(PlaybackException.keyForField(1006), this.isRecoverable);
        return bundle;
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE })
    public @interface Type {
    }
}
