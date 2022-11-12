// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.os;

import android.util.SizeF;
import kotlin.jvm.internal.o;
import android.util.Size;
import android.os.Bundle;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c3\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007J\"\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\nH\u0007¨\u0006\u000e" }, d2 = { "Landroidx/core/os/c;", "", "Landroid/os/Bundle;", "bundle", "", "key", "Landroid/util/Size;", "value", "Lka/r;", "a", "Landroid/util/SizeF;", "b", "<init>", "()V", "core-ktx_release" }, k = 1, mv = { 1, 6, 0 })
final class c
{
    public static final c a;
    
    static {
        a = new c();
    }
    
    private c() {
    }
    
    public static final void a(final Bundle bundle, final String s, final Size size) {
        o.g((Object)bundle, "bundle");
        o.g((Object)s, "key");
        bundle.putSize(s, size);
    }
    
    public static final void b(final Bundle bundle, final String s, final SizeF sizeF) {
        o.g((Object)bundle, "bundle");
        o.g((Object)s, "key");
        bundle.putSizeF(s, sizeF);
    }
}
