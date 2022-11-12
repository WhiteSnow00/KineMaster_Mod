// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.drm;

import android.media.MediaDrmResetException;
import android.media.MediaDrm$MediaDrmStateException;
import android.media.NotProvisionedException;
import android.media.DeniedByServerException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import com.google.android.exoplayer2.util.Util;

public final class DrmUtil
{
    private DrmUtil() {
    }
    
    public static int a(final Exception ex, final int n) {
        final int a = Util.a;
        if (a >= 21 && b.a(ex)) {
            return b.b(ex);
        }
        if (a >= 23 && c.a(ex)) {
            return 6006;
        }
        if (a >= 18 && DrmUtil.a.b(ex)) {
            return 6002;
        }
        if (a >= 18 && DrmUtil.a.a(ex)) {
            return 6007;
        }
        if (ex instanceof UnsupportedDrmException) {
            return 6001;
        }
        if (ex instanceof DefaultDrmSessionManager.MissingSchemeDataException) {
            return 6003;
        }
        if (ex instanceof KeysExpiredException) {
            return 6008;
        }
        if (n == 1) {
            return 6006;
        }
        if (n == 2) {
            return 6004;
        }
        if (n == 3) {
            return 6002;
        }
        throw new IllegalArgumentException();
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE })
    public @interface ErrorSource {
    }
    
    private static final class a
    {
        public static boolean a(final Throwable t) {
            return t instanceof DeniedByServerException;
        }
        
        public static boolean b(final Throwable t) {
            return t instanceof NotProvisionedException;
        }
    }
    
    private static final class b
    {
        public static boolean a(final Throwable t) {
            return t instanceof MediaDrm$MediaDrmStateException;
        }
        
        public static int b(final Throwable t) {
            return Util.V(Util.W(((MediaDrm$MediaDrmStateException)t).getDiagnosticInfo()));
        }
    }
    
    private static final class c
    {
        public static boolean a(final Throwable t) {
            return t instanceof MediaDrmResetException;
        }
    }
}
