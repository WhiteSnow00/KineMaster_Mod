// 
// Decompiled by Procyon v0.6.0
// 

package c;

import android.os.Parcelable;
import kotlin.jvm.internal.o;
import android.content.Intent;
import android.content.Context;
import kotlin.Metadata;
import android.net.Uri;

@Metadata(bv = {}, d1 = { "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0017J\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u001f\u0010\u000e\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0012" }, d2 = { "Lc/e;", "Lc/a;", "Landroid/net/Uri;", "", "Landroid/content/Context;", "context", "input", "Landroid/content/Intent;", "a", "Lc/a$a;", "b", "", "resultCode", "intent", "parseResult", "(ILandroid/content/Intent;)Ljava/lang/Boolean;", "<init>", "()V", "activity_release" }, k = 1, mv = { 1, 6, 0 })
public class e extends a<Uri, Boolean>
{
    public Intent a(final Context context, final Uri uri) {
        o.g((Object)context, "context");
        o.g((Object)uri, "input");
        final Intent putExtra = new Intent("android.media.action.IMAGE_CAPTURE").putExtra("output", (Parcelable)uri);
        o.f((Object)putExtra, "Intent(MediaStore.ACTION\u2026tore.EXTRA_OUTPUT, input)");
        return putExtra;
    }
    
    public final a<Boolean> b(final Context context, final Uri uri) {
        o.g((Object)context, "context");
        o.g((Object)uri, "input");
        return null;
    }
    
    @Override
    public /* bridge */ Intent createIntent(final Context context, final Object o) {
        return this.a(context, (Uri)o);
    }
    
    @Override
    public /* bridge */ a getSynchronousResult(final Context context, final Object o) {
        return this.b(context, (Uri)o);
    }
    
    @Override
    public final Boolean parseResult(final int n, final Intent intent) {
        return n == -1;
    }
    
    @Override
    public /* bridge */ Object parseResult(final int n, final Intent intent) {
        return this.parseResult(n, intent);
    }
}
