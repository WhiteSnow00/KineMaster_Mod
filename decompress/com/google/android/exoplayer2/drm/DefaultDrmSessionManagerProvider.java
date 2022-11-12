// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.Assertions;
import com.google.common.collect.UnmodifiableIterator;
import android.net.Uri;
import java.util.Collection;
import com.google.common.primitives.Ints;
import java.util.Map;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.MediaItem;

public final class DefaultDrmSessionManagerProvider implements DrmSessionManagerProvider
{
    private final Object a;
    private MediaItem.DrmConfiguration b;
    private DrmSessionManager c;
    private DataSource.Factory d;
    private String e;
    
    public DefaultDrmSessionManagerProvider() {
        this.a = new Object();
    }
    
    private DrmSessionManager b(final MediaItem.DrmConfiguration drmConfiguration) {
        DataSource.Factory factory = this.d;
        if (factory == null) {
            factory = new DefaultHttpDataSource.Factory().c(this.e);
        }
        final Uri c = drmConfiguration.c;
        String string;
        if (c == null) {
            string = null;
        }
        else {
            string = c.toString();
        }
        final HttpMediaDrmCallback httpMediaDrmCallback = new HttpMediaDrmCallback(string, drmConfiguration.h, factory);
        for (final Map.Entry entry : drmConfiguration.e.entrySet()) {
            httpMediaDrmCallback.e((String)entry.getKey(), (String)entry.getValue());
        }
        final DefaultDrmSessionManager a = new DefaultDrmSessionManager.Builder().e(drmConfiguration.a, FrameworkMediaDrm.d).b(drmConfiguration.f).c(drmConfiguration.g).d(Ints.n((Collection)drmConfiguration.j)).a(httpMediaDrmCallback);
        a.E(0, drmConfiguration.c());
        return a;
    }
    
    @Override
    public DrmSessionManager a(final MediaItem mediaItem) {
        Assertions.e(mediaItem.b);
        final MediaItem.DrmConfiguration c = mediaItem.b.c;
        if (c != null) {
            if (Util.a >= 18) {
                synchronized (this.a) {
                    if (!Util.c(c, this.b)) {
                        this.b = c;
                        this.c = this.b(c);
                    }
                    return Assertions.e(this.c);
                }
            }
        }
        return DrmSessionManager.a;
    }
}
