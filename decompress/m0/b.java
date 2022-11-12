// 
// Decompiled by Procyon v0.6.0
// 

package m0;

import android.os.Build$VERSION;
import android.text.TextUtils;
import java.util.Objects;
import android.media.session.MediaSessionManager$RemoteUserInfo;

public final class b
{
    c a;
    
    public b(final MediaSessionManager$RemoteUserInfo mediaSessionManager$RemoteUserInfo) {
        final String a = d.a(mediaSessionManager$RemoteUserInfo);
        Objects.requireNonNull(a, "package shouldn't be null");
        if (!TextUtils.isEmpty((CharSequence)a)) {
            this.a = new d(mediaSessionManager$RemoteUserInfo);
            return;
        }
        throw new IllegalArgumentException("packageName should be nonempty");
    }
    
    public b(final String s, final int n, final int n2) {
        Objects.requireNonNull(s, "package shouldn't be null");
        if (!TextUtils.isEmpty((CharSequence)s)) {
            if (Build$VERSION.SDK_INT >= 28) {
                this.a = new d(s, n, n2);
            }
            else {
                this.a = new e(s, n, n2);
            }
            return;
        }
        throw new IllegalArgumentException("packageName should be nonempty");
    }
    
    @Override
    public boolean equals(final Object o) {
        return this == o || (o instanceof b && this.a.equals(((b)o).a));
    }
    
    @Override
    public int hashCode() {
        return this.a.hashCode();
    }
}
