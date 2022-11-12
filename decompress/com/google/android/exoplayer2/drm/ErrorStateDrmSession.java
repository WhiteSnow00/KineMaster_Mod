// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.drm;

import java.util.Map;
import com.google.android.exoplayer2.decoder.CryptoConfig;
import com.google.android.exoplayer2.C;
import java.util.UUID;
import com.google.android.exoplayer2.util.Assertions;

public final class ErrorStateDrmSession implements DrmSession
{
    private final DrmSessionException a;
    
    public ErrorStateDrmSession(final DrmSessionException ex) {
        this.a = Assertions.e(ex);
    }
    
    @Override
    public DrmSessionException a() {
        return this.a;
    }
    
    @Override
    public void b(final DrmSessionEventListener.EventDispatcher eventDispatcher) {
    }
    
    @Override
    public void c(final DrmSessionEventListener.EventDispatcher eventDispatcher) {
    }
    
    @Override
    public final UUID d() {
        return C.a;
    }
    
    @Override
    public boolean e() {
        return false;
    }
    
    @Override
    public CryptoConfig f() {
        return null;
    }
    
    @Override
    public int getState() {
        return 1;
    }
    
    @Override
    public Map<String, String> h() {
        return null;
    }
    
    @Override
    public boolean i(final String s) {
        return false;
    }
}
