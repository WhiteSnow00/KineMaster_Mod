// 
// Decompiled by Procyon v0.6.0
// 

package m0;

import android.media.session.MediaSessionManager$RemoteUserInfo;

final class d extends e
{
    final MediaSessionManager$RemoteUserInfo d;
    
    d(final MediaSessionManager$RemoteUserInfo d) {
        super(d.getPackageName(), d.getPid(), d.getUid());
        this.d = d;
    }
    
    d(final String s, final int n, final int n2) {
        super(s, n, n2);
        this.d = new MediaSessionManager$RemoteUserInfo(s, n, n2);
    }
    
    static String a(final MediaSessionManager$RemoteUserInfo mediaSessionManager$RemoteUserInfo) {
        return mediaSessionManager$RemoteUserInfo.getPackageName();
    }
}
