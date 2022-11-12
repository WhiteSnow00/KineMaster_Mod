// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.os;

import kotlin.jvm.internal.o;
import android.os.IBinder;
import android.os.Bundle;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c3\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\f" }, d2 = { "Landroidx/core/os/b;", "", "Landroid/os/Bundle;", "bundle", "", "key", "Landroid/os/IBinder;", "value", "Lka/r;", "a", "<init>", "()V", "core-ktx_release" }, k = 1, mv = { 1, 6, 0 })
final class b
{
    public static final b a;
    
    static {
        a = new b();
    }
    
    private b() {
    }
    
    public static final void a(final Bundle bundle, final String s, final IBinder binder) {
        o.g((Object)bundle, "bundle");
        o.g((Object)s, "key");
        bundle.putBinder(s, binder);
    }
}
