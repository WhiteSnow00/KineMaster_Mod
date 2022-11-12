// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.drm;

import java.util.UUID;

public interface MediaDrmCallback
{
    byte[] a(final UUID p0, final ExoMediaDrm.ProvisionRequest p1) throws MediaDrmCallbackException;
    
    byte[] b(final UUID p0, final ExoMediaDrm.KeyRequest p1) throws MediaDrmCallbackException;
}
