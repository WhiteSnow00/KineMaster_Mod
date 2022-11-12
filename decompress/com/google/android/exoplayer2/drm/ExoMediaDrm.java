// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.drm;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import java.util.UUID;
import java.util.HashMap;
import java.util.List;
import android.media.NotProvisionedException;
import android.media.MediaCryptoException;
import com.google.android.exoplayer2.decoder.CryptoConfig;
import android.media.DeniedByServerException;
import android.media.MediaDrmException;
import com.google.android.exoplayer2.analytics.PlayerId;
import java.util.Map;

public interface ExoMediaDrm
{
    void a();
    
    Map<String, String> b(final byte[] p0);
    
    default void c(final byte[] array, final PlayerId playerId) {
    }
    
    ProvisionRequest d();
    
    byte[] e() throws MediaDrmException;
    
    void f(final byte[] p0, final byte[] p1);
    
    void g(final OnEventListener p0);
    
    void h(final byte[] p0) throws DeniedByServerException;
    
    int i();
    
    CryptoConfig j(final byte[] p0) throws MediaCryptoException;
    
    boolean k(final byte[] p0, final String p1);
    
    void l(final byte[] p0);
    
    byte[] m(final byte[] p0, final byte[] p1) throws NotProvisionedException, DeniedByServerException;
    
    KeyRequest n(final byte[] p0, final List<DrmInitData.SchemeData> p1, final int p2, final HashMap<String, String> p3) throws NotProvisionedException;
    
    void release();
    
    public static final class AppManagedProvider implements Provider
    {
        private final ExoMediaDrm a;
        
        @Override
        public ExoMediaDrm a(final UUID uuid) {
            this.a.a();
            return this.a;
        }
    }
    
    public static final class KeyRequest
    {
        private final byte[] a;
        private final String b;
        private final int c;
        
        public KeyRequest(final byte[] a, final String b, final int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        
        public byte[] a() {
            return this.a;
        }
        
        public String b() {
            return this.b;
        }
        
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        @Target({ ElementType.TYPE_USE })
        public @interface RequestType {
        }
    }
    
    public static final class KeyStatus
    {
    }
    
    public interface OnEventListener
    {
        void a(final ExoMediaDrm p0, final byte[] p1, final int p2, final int p3, final byte[] p4);
    }
    
    public interface OnExpirationUpdateListener
    {
    }
    
    public interface OnKeyStatusChangeListener
    {
    }
    
    public interface Provider
    {
        ExoMediaDrm a(final UUID p0);
    }
    
    public static final class ProvisionRequest
    {
        private final byte[] a;
        private final String b;
        
        public ProvisionRequest(final byte[] a, final String b) {
            this.a = a;
            this.b = b;
        }
        
        public byte[] a() {
            return this.a;
        }
        
        public String b() {
            return this.b;
        }
    }
}
