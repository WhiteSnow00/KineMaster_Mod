// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.analytics.PlayerId;
import android.os.Looper;
import com.google.android.exoplayer2.Format;

public interface DrmSessionManager
{
    public static final DrmSessionManager a;
    @Deprecated
    public static final DrmSessionManager b = a = new DrmSessionManager() {
        @Override
        public int a(final Format format) {
            return (format.z != null) ? 1 : 0;
        }
        
        @Override
        public void b(final Looper looper, final PlayerId playerId) {
        }
        
        @Override
        public DrmSession c(final DrmSessionEventListener.EventDispatcher eventDispatcher, final Format format) {
            if (format.z == null) {
                return null;
            }
            return new ErrorStateDrmSession(new DrmSession.DrmSessionException(new UnsupportedDrmException(1), 6001));
        }
    };
    
    int a(final Format p0);
    
    void b(final Looper p0, final PlayerId p1);
    
    DrmSession c(final DrmSessionEventListener.EventDispatcher p0, final Format p1);
    
    default DrmSessionReference d(final DrmSessionEventListener.EventDispatcher eventDispatcher, final Format format) {
        return DrmSessionReference.a;
    }
    
    default void prepare() {
    }
    
    default void release() {
    }
    
    public interface DrmSessionReference
    {
        public static final DrmSessionReference a = p.b;
        
        default void a() {
        }
        
        default void b() {
            a();
        }
        
        void release();
    }
}
