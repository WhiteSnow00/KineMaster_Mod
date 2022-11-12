// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.drm;

import java.util.HashMap;
import java.util.List;
import com.google.android.exoplayer2.decoder.CryptoConfig;
import android.media.MediaDrmException;
import java.util.Map;

public final class DummyExoMediaDrm implements ExoMediaDrm
{
    @Override
    public void a() {
    }
    
    @Override
    public Map<String, String> b(final byte[] array) {
        throw new IllegalStateException();
    }
    
    @Override
    public ProvisionRequest d() {
        throw new IllegalStateException();
    }
    
    @Override
    public byte[] e() throws MediaDrmException {
        throw new MediaDrmException("Attempting to open a session using a dummy ExoMediaDrm.");
    }
    
    @Override
    public void f(final byte[] array, final byte[] array2) {
        throw new IllegalStateException();
    }
    
    @Override
    public void g(final OnEventListener onEventListener) {
    }
    
    @Override
    public void h(final byte[] array) {
        throw new IllegalStateException();
    }
    
    @Override
    public int i() {
        return 1;
    }
    
    @Override
    public CryptoConfig j(final byte[] array) {
        throw new IllegalStateException();
    }
    
    @Override
    public boolean k(final byte[] array, final String s) {
        throw new IllegalStateException();
    }
    
    @Override
    public void l(final byte[] array) {
    }
    
    @Override
    public byte[] m(final byte[] array, final byte[] array2) {
        throw new IllegalStateException();
    }
    
    @Override
    public KeyRequest n(final byte[] array, final List<DrmInitData.SchemeData> list, final int n, final HashMap<String, String> hashMap) {
        throw new IllegalStateException();
    }
    
    @Override
    public void release() {
    }
}
