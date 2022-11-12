// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.drm;

import java.util.UUID;

public final class LocalMediaDrmCallback implements MediaDrmCallback
{
    private final byte[] a;
    
    @Override
    public byte[] a(final UUID uuid, final ExoMediaDrm.ProvisionRequest provisionRequest) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public byte[] b(final UUID uuid, final ExoMediaDrm.KeyRequest keyRequest) {
        return this.a;
    }
}
