// 
// Decompiled by Procyon v0.6.0
// 

package androidx.navigation;

import kotlin.jvm.internal.o;
import android.content.Intent;
import android.net.Uri;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B'\b\u0017\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000f\u0010\u0010B\u0011\b\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u000f\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0005\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u000b\u001a\u0004\b\n\u0010\f¨\u0006\u0014" }, d2 = { "Landroidx/navigation/l;", "", "", "toString", "Landroid/net/Uri;", "a", "Landroid/net/Uri;", "c", "()Landroid/net/Uri;", "uri", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "action", "mimeType", "<init>", "(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/content/Intent;", "intent", "(Landroid/content/Intent;)V", "navigation-common_release" }, k = 1, mv = { 1, 6, 0 })
public class l
{
    private final Uri a;
    private final String b;
    private final String c;
    
    public l(final Intent intent) {
        o.g((Object)intent, "intent");
        this(intent.getData(), intent.getAction(), intent.getType());
    }
    
    public l(final Uri a, final String b, final String c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public String a() {
        return this.b;
    }
    
    public String b() {
        return this.c;
    }
    
    public Uri c() {
        return this.a;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("NavDeepLinkRequest");
        sb.append("{");
        if (this.c() != null) {
            sb.append(" uri=");
            sb.append(String.valueOf(this.c()));
        }
        if (this.a() != null) {
            sb.append(" action=");
            sb.append(this.a());
        }
        if (this.b() != null) {
            sb.append(" mimetype=");
            sb.append(this.b());
        }
        sb.append(" }");
        final String string = sb.toString();
        o.f((Object)string, "sb.toString()");
        return string;
    }
}
