// 
// Decompiled by Procyon v0.6.0
// 

package androidx.navigation;

import kotlin.jvm.internal.o;
import android.os.Bundle;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u001a\u0010\u000e\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0014\u001a\u00020\u000f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017" }, d2 = { "Landroidx/navigation/a;", "Landroidx/navigation/m;", "", "other", "", "equals", "", "hashCode", "", "toString", "a", "I", "getActionId", "()I", "actionId", "Landroid/os/Bundle;", "b", "Landroid/os/Bundle;", "getArguments", "()Landroid/os/Bundle;", "arguments", "<init>", "(I)V", "navigation-common_release" }, k = 1, mv = { 1, 6, 0 })
public final class a implements m
{
    private final int a;
    private final Bundle b;
    
    public a(final int a) {
        this.a = a;
        this.b = new Bundle();
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (o != null && o.b((Object)a.class, (Object)o.getClass())) {
            if (this.getActionId() != ((a)o).getActionId()) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public int getActionId() {
        return this.a;
    }
    
    @Override
    public Bundle getArguments() {
        return this.b;
    }
    
    @Override
    public int hashCode() {
        return 31 + this.getActionId();
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("ActionOnlyNavDirections(actionId=");
        sb.append(this.getActionId());
        sb.append(')');
        return sb.toString();
    }
}
