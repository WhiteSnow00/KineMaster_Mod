// 
// Decompiled by Procyon v0.6.0
// 

package c;

import kotlin.jvm.internal.o;
import android.content.Intent;
import android.content.Context;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J!\u0010\f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\f\u0010\rJ \u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0012" }, d2 = { "Lc/c;", "Lc/a;", "", "", "Landroid/content/Context;", "context", "input", "Landroid/content/Intent;", "a", "", "resultCode", "intent", "parseResult", "(ILandroid/content/Intent;)Ljava/lang/Boolean;", "Lc/a$a;", "b", "<init>", "()V", "activity_release" }, k = 1, mv = { 1, 6, 0 })
public final class c extends a<String, Boolean>
{
    public Intent a(final Context context, final String s) {
        o.g((Object)context, "context");
        o.g((Object)s, "input");
        return b.a.a(new String[] { s });
    }
    
    public a<Boolean> b(final Context context, final String s) {
        o.g((Object)context, "context");
        o.g((Object)s, "input");
        a<Boolean> a;
        if (androidx.core.content.a.checkSelfPermission(context, s) == 0) {
            a = (a<Boolean>)new a(Boolean.TRUE);
        }
        else {
            a = null;
        }
        return a;
    }
    
    @Override
    public /* bridge */ Intent createIntent(final Context context, final Object o) {
        return this.a(context, (String)o);
    }
    
    @Override
    public /* bridge */ a getSynchronousResult(final Context context, final Object o) {
        return this.b(context, (String)o);
    }
    
    @Override
    public Boolean parseResult(int i, final Intent intent) {
        if (intent != null && i == -1) {
            final int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
            boolean b = true;
            Label_0076: {
                if (intArrayExtra != null) {
                    final int length = intArrayExtra.length;
                    i = 0;
                    while (true) {
                        while (i < length) {
                            if (intArrayExtra[i] == 0) {
                                i = 1;
                                if (i == 1) {
                                    return b;
                                }
                                break Label_0076;
                            }
                            else {
                                ++i;
                            }
                        }
                        i = 0;
                        continue;
                    }
                }
            }
            b = false;
            return b;
        }
        return Boolean.FALSE;
    }
    
    @Override
    public /* bridge */ Object parseResult(final int n, final Intent intent) {
        return this.parseResult(n, intent);
    }
}
