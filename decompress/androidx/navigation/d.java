// 
// Decompiled by Procyon v0.6.0
// 

package androidx.navigation;

import kotlin.jvm.internal.i;
import android.os.Bundle;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B+\b\u0007\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R$\u0010\u000e\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0010\u001a\u0004\b\u0003\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0017" }, d2 = { "Landroidx/navigation/d;", "", "", "a", "I", "b", "()I", "destinationId", "Landroidx/navigation/q;", "Landroidx/navigation/q;", "c", "()Landroidx/navigation/q;", "e", "(Landroidx/navigation/q;)V", "navOptions", "Landroid/os/Bundle;", "Landroid/os/Bundle;", "()Landroid/os/Bundle;", "d", "(Landroid/os/Bundle;)V", "defaultArguments", "<init>", "(ILandroidx/navigation/q;Landroid/os/Bundle;)V", "navigation-common_release" }, k = 1, mv = { 1, 6, 0 })
public final class d
{
    private final int a;
    private q b;
    private Bundle c;
    
    public d(final int a, final q b, final Bundle c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public d(final int n, q q, Bundle bundle, final int n2, final i i) {
        if ((n2 & 0x2) != 0x0) {
            q = null;
        }
        if ((n2 & 0x4) != 0x0) {
            bundle = null;
        }
        this(n, q, bundle);
    }
    
    public final Bundle a() {
        return this.c;
    }
    
    public final int b() {
        return this.a;
    }
    
    public final q c() {
        return this.b;
    }
    
    public final void d(final Bundle c) {
        this.c = c;
    }
    
    public final void e(final q b) {
        this.b = b;
    }
}
