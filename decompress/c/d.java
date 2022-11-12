// 
// Decompiled by Procyon v0.6.0
// 

package c;

import kotlin.jvm.internal.o;
import android.content.Context;
import kotlin.jvm.internal.i;
import kotlin.Metadata;
import androidx.activity.result.ActivityResult;
import android.content.Intent;

@Metadata(bv = {}, d1 = { "\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u001a\u0010\u000b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u000e" }, d2 = { "Lc/d;", "Lc/a;", "Landroid/content/Intent;", "Landroidx/activity/result/ActivityResult;", "Landroid/content/Context;", "context", "input", "createIntent", "", "resultCode", "intent", "a", "<init>", "()V", "activity_release" }, k = 1, mv = { 1, 6, 0 })
public final class d extends c.a<Intent, ActivityResult>
{
    public static final a a;
    
    static {
        a = new a(null);
    }
    
    public ActivityResult a(final int n, final Intent intent) {
        return new ActivityResult(n, intent);
    }
    
    @Override
    public Intent createIntent(final Context context, final Intent intent) {
        o.g((Object)context, "context");
        o.g((Object)intent, "input");
        return intent;
    }
    
    @Override
    public /* bridge */ Intent createIntent(final Context context, final Object o) {
        return this.createIntent(context, (Intent)o);
    }
    
    @Override
    public /* bridge */ Object parseResult(final int n, final Intent intent) {
        return this.a(n, intent);
    }
    
    @Metadata(bv = {}, d1 = { "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007" }, d2 = { "Lc/d$a;", "", "", "EXTRA_ACTIVITY_OPTIONS_BUNDLE", "Ljava/lang/String;", "<init>", "()V", "activity_release" }, k = 1, mv = { 1, 6, 0 })
    public static final class a
    {
        private a() {
        }
        
        public a(final i i) {
            this();
        }
    }
}
