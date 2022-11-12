// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.drm;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import java.io.IOException;
import java.util.Map;
import com.google.android.exoplayer2.decoder.CryptoConfig;
import java.util.UUID;

public interface DrmSession
{
    default void g(final DrmSession drmSession, final DrmSession drmSession2) {
        if (drmSession == drmSession2) {
            return;
        }
        if (drmSession2 != null) {
            drmSession2.b(null);
        }
        if (drmSession != null) {
            drmSession.c(null);
        }
    }
    
    DrmSessionException a();
    
    void b(final DrmSessionEventListener.EventDispatcher p0);
    
    void c(final DrmSessionEventListener.EventDispatcher p0);
    
    UUID d();
    
    default boolean e() {
        return false;
    }
    
    CryptoConfig f();
    
    int getState();
    
    Map<String, String> h();
    
    boolean i(final String p0);
    
    public static class DrmSessionException extends IOException
    {
        public final int errorCode;
        
        public DrmSessionException(final Throwable t, final int errorCode) {
            super(t);
            this.errorCode = errorCode;
        }
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE })
    public @interface State {
    }
}
