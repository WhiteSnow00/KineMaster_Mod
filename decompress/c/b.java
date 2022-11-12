// 
// Decompiled by Procyon v0.6.0
// 

package c;

import kotlin.collections.h;
import java.util.ArrayList;
import kotlin.Pair;
import ka.l;
import java.util.LinkedHashMap;
import ya.f;
import kotlin.collections.e0;
import kotlin.jvm.internal.o;
import android.content.Intent;
import android.content.Context;
import kotlin.jvm.internal.i;
import kotlin.Metadata;
import java.util.Map;

@Metadata(bv = {}, d1 = { "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\u0010$\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002 \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u00040\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0013\u0010\u0014J%\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ9\u0010\r\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ&\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u0015" }, d2 = { "Lc/b;", "Lc/a;", "", "", "", "", "Landroid/content/Context;", "context", "input", "Landroid/content/Intent;", "a", "(Landroid/content/Context;[Ljava/lang/String;)Landroid/content/Intent;", "Lc/a$a;", "b", "(Landroid/content/Context;[Ljava/lang/String;)Lc/a$a;", "", "resultCode", "intent", "c", "<init>", "()V", "activity_release" }, k = 1, mv = { 1, 6, 0 })
public final class b extends c.a<String[], Map<String, Boolean>>
{
    public static final a a;
    
    static {
        a = new a(null);
    }
    
    public Intent a(final Context context, final String[] array) {
        o.g((Object)context, "context");
        o.g((Object)array, "input");
        return b.a.a(array);
    }
    
    public c.a.a<Map<String, Boolean>> b(final Context context, final String[] array) {
        o.g((Object)context, "context");
        o.g((Object)array, "input");
        final int length = array.length;
        final int n = 1;
        final int n2 = 0;
        if (length == 0) {
            return (c.a.a<Map<String, Boolean>>)new c.a.a(e0.i());
        }
        final int length2 = array.length;
        int n3 = 0;
        int n4;
        while (true) {
            n4 = n;
            if (n3 >= length2) {
                break;
            }
            if (androidx.core.content.a.checkSelfPermission(context, array[n3]) != 0) {
                n4 = 0;
                break;
            }
            ++n3;
        }
        c.a.a<Map<String, Boolean>> a2;
        if (n4 != 0) {
            final LinkedHashMap linkedHashMap = new LinkedHashMap(f.c(e0.e(array.length), 16));
            for (int length3 = array.length, i = n2; i < length3; ++i) {
                final Pair a = l.a((Object)array[i], (Object)Boolean.TRUE);
                linkedHashMap.put(a.getFirst(), a.getSecond());
            }
            a2 = (c.a.a<Map<String, Boolean>>)new c.a.a(linkedHashMap);
        }
        else {
            a2 = null;
        }
        return a2;
    }
    
    public Map<String, Boolean> c(int i, final Intent intent) {
        if (i != -1) {
            return e0.i();
        }
        if (intent == null) {
            return e0.i();
        }
        final String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
        final int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
        if (intArrayExtra != null && stringArrayExtra != null) {
            final ArrayList list = new ArrayList(intArrayExtra.length);
            int length;
            for (length = intArrayExtra.length, i = 0; i < length; ++i) {
                list.add((Object)(intArrayExtra[i] == 0));
            }
            return e0.r((Iterable)kotlin.collections.o.U0((Iterable)h.u((Object[])stringArrayExtra), (Iterable)list));
        }
        return e0.i();
    }
    
    @Override
    public /* bridge */ Intent createIntent(final Context context, final Object o) {
        return this.a(context, (String[])o);
    }
    
    @Override
    public /* bridge */ c.a.a getSynchronousResult(final Context context, final Object o) {
        return this.b(context, (String[])o);
    }
    
    @Override
    public /* bridge */ Object parseResult(final int n, final Intent intent) {
        return this.c(n, intent);
    }
    
    @Metadata(bv = {}, d1 = { "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0000¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00038\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00038\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00038\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\t¨\u0006\u000e" }, d2 = { "Lc/b$a;", "", "", "", "input", "Landroid/content/Intent;", "a", "([Ljava/lang/String;)Landroid/content/Intent;", "ACTION_REQUEST_PERMISSIONS", "Ljava/lang/String;", "EXTRA_PERMISSIONS", "EXTRA_PERMISSION_GRANT_RESULTS", "<init>", "()V", "activity_release" }, k = 1, mv = { 1, 6, 0 })
    public static final class a
    {
        private a() {
        }
        
        public a(final i i) {
            this();
        }
        
        public final Intent a(final String[] array) {
            o.g((Object)array, "input");
            final Intent putExtra = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", array);
            o.f((Object)putExtra, "Intent(ACTION_REQUEST_PE\u2026EXTRA_PERMISSIONS, input)");
            return putExtra;
        }
    }
}
