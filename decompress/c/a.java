// 
// Decompiled by Procyon v0.6.0
// 

package c;

import kotlin.jvm.internal.o;
import android.content.Intent;
import android.content.Context;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000,\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003:\u0001\u0014B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u0000H&¢\u0006\u0004\b\b\u0010\tJ!\u0010\r\u001a\u00028\u00012\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0010\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0015" }, d2 = { "Lc/a;", "I", "O", "", "Landroid/content/Context;", "context", "input", "Landroid/content/Intent;", "createIntent", "(Landroid/content/Context;Ljava/lang/Object;)Landroid/content/Intent;", "", "resultCode", "intent", "parseResult", "(ILandroid/content/Intent;)Ljava/lang/Object;", "Lc/a$a;", "getSynchronousResult", "(Landroid/content/Context;Ljava/lang/Object;)Lc/a$a;", "<init>", "()V", "a", "activity_release" }, k = 1, mv = { 1, 6, 0 })
public abstract class a<I, O>
{
    public abstract Intent createIntent(final Context p0, final I p1);
    
    public a<O> getSynchronousResult(final Context context, final I n) {
        o.g((Object)context, "context");
        return null;
    }
    
    public abstract O parseResult(final int p0, final Intent p1);
    
    @Metadata(bv = {}, d1 = { "\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0002\u0010\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00028\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00028\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t" }, d2 = { "Lc/a$a;", "T", "", "value", "Ljava/lang/Object;", "a", "()Ljava/lang/Object;", "<init>", "(Ljava/lang/Object;)V", "activity_release" }, k = 1, mv = { 1, 6, 0 })
    public static final class a<T>
    {
        private final T a;
        
        public a(final T a) {
            this.a = a;
        }
        
        public final T a() {
            return this.a;
        }
    }
}
