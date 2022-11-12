// 
// Decompiled by Procyon v0.6.0
// 

package androidx.navigation;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.content.ComponentName;
import androidx.core.app.c;
import android.content.res.Resources;
import java.util.regex.Matcher;
import ya.f;
import androidx.core.content.a;
import android.util.Log;
import android.net.Uri;
import java.util.regex.Pattern;
import android.content.Intent;
import android.os.Bundle;
import java.util.Iterator;
import sa.l;
import kotlin.sequences.k;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.i;
import android.app.Activity;
import android.content.Context;
import kotlin.Metadata;

@Navigator.b("activity")
@Metadata(bv = {}, d1 = { "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0017\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001c\u001d\u0010B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u000f¢\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J0\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016R\u0017\u0010\u0014\u001a\u00020\u000f8\u0007¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001e" }, d2 = { "Landroidx/navigation/ActivityNavigator;", "Landroidx/navigation/Navigator;", "Landroidx/navigation/ActivityNavigator$b;", "l", "", "k", "destination", "Landroid/os/Bundle;", "args", "Landroidx/navigation/q;", "navOptions", "Landroidx/navigation/Navigator$a;", "navigatorExtras", "Landroidx/navigation/NavDestination;", "m", "Landroid/content/Context;", "c", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Landroid/app/Activity;", "d", "Landroid/app/Activity;", "hostActivity", "<init>", "(Landroid/content/Context;)V", "e", "a", "b", "navigation-runtime_release" }, k = 1, mv = { 1, 6, 0 })
public class ActivityNavigator extends Navigator<b>
{
    public static final a e;
    private final Context c;
    private final Activity d;
    
    static {
        e = new a(null);
    }
    
    public ActivityNavigator(final Context c) {
        o.g((Object)c, "context");
        this.c = c;
        while (true) {
            for (final Object next : k.h((Object)c, (l)ActivityNavigator$hostActivity.ActivityNavigator$hostActivity$1.INSTANCE)) {
                if (((Context)next) instanceof Activity) {
                    this.d = (Activity)next;
                    return;
                }
            }
            Object next = null;
            continue;
        }
    }
    
    @Override
    public /* bridge */ NavDestination a() {
        return this.l();
    }
    
    @Override
    public /* bridge */ NavDestination d(final NavDestination navDestination, final Bundle bundle, final q q, final Navigator.a a) {
        return this.m((b)navDestination, bundle, q, a);
    }
    
    @Override
    public boolean k() {
        final Activity d = this.d;
        if (d != null) {
            d.finish();
            return true;
        }
        return false;
    }
    
    public b l() {
        return new b(this);
    }
    
    public NavDestination m(final b b, final Bundle bundle, final q q, final Navigator.a a) {
        o.g((Object)b, "destination");
        if (b.H() != null) {
            final Intent intent = new Intent(b.H());
            if (bundle != null) {
                intent.putExtras(bundle);
                final String g = b.G();
                if (g != null && g.length() != 0) {
                    final StringBuffer sb = new StringBuffer();
                    final Matcher matcher = Pattern.compile("\\{(.+?)\\}").matcher(g);
                    while (matcher.find()) {
                        final String group = matcher.group(1);
                        if (!bundle.containsKey(group)) {
                            final StringBuilder sb2 = new StringBuilder();
                            sb2.append("Could not find ");
                            sb2.append(group);
                            sb2.append(" in ");
                            sb2.append(bundle);
                            sb2.append(" to fill data pattern ");
                            sb2.append(g);
                            throw new IllegalArgumentException(sb2.toString());
                        }
                        matcher.appendReplacement(sb, "");
                        sb.append(Uri.encode(String.valueOf(bundle.get(group))));
                    }
                    matcher.appendTail(sb);
                    intent.setData(Uri.parse(sb.toString()));
                }
            }
            final boolean b2 = a instanceof c;
            if (b2) {
                intent.addFlags(((c)a).b());
            }
            if (this.d == null) {
                intent.addFlags(268435456);
            }
            if (q != null && q.g()) {
                intent.addFlags(536870912);
            }
            final Activity d = this.d;
            if (d != null) {
                final Intent intent2 = d.getIntent();
                if (intent2 != null) {
                    final int intExtra = intent2.getIntExtra("android-support-navigation:ActivityNavigator:current", 0);
                    if (intExtra != 0) {
                        intent.putExtra("android-support-navigation:ActivityNavigator:source", intExtra);
                    }
                }
            }
            intent.putExtra("android-support-navigation:ActivityNavigator:current", b.p());
            final Resources resources = this.c.getResources();
            if (q != null) {
                final int c = q.c();
                final int d2 = q.d();
                if ((c > 0 && o.b((Object)resources.getResourceTypeName(c), (Object)"animator")) || (d2 > 0 && o.b((Object)resources.getResourceTypeName(d2), (Object)"animator"))) {
                    final StringBuilder sb3 = new StringBuilder();
                    sb3.append("Activity destinations do not support Animator resource. Ignoring popEnter resource ");
                    sb3.append(resources.getResourceName(c));
                    sb3.append(" and popExit resource ");
                    sb3.append(resources.getResourceName(d2));
                    sb3.append(" when launching ");
                    sb3.append(b);
                    Log.w("ActivityNavigator", sb3.toString());
                }
                else {
                    intent.putExtra("android-support-navigation:ActivityNavigator:popEnterAnim", c);
                    intent.putExtra("android-support-navigation:ActivityNavigator:popExitAnim", d2);
                }
            }
            if (b2) {
                final androidx.core.app.c a2 = ((c)a).a();
                if (a2 != null) {
                    a.startActivity(this.c, intent, a2.b());
                }
                else {
                    this.c.startActivity(intent);
                }
            }
            else {
                this.c.startActivity(intent);
            }
            if (q != null && this.d != null) {
                final int a3 = q.a();
                final int b3 = q.b();
                if ((a3 > 0 && o.b((Object)resources.getResourceTypeName(a3), (Object)"animator")) || (b3 > 0 && o.b((Object)resources.getResourceTypeName(b3), (Object)"animator"))) {
                    final StringBuilder sb4 = new StringBuilder();
                    sb4.append("Activity destinations do not support Animator resource. Ignoring enter resource ");
                    sb4.append(resources.getResourceName(a3));
                    sb4.append(" and exit resource ");
                    sb4.append(resources.getResourceName(b3));
                    sb4.append("when launching ");
                    sb4.append(b);
                    Log.w("ActivityNavigator", sb4.toString());
                }
                else if (a3 >= 0 || b3 >= 0) {
                    this.d.overridePendingTransition(f.c(a3, 0), f.c(b3, 0));
                }
            }
            return null;
        }
        final StringBuilder sb5 = new StringBuilder();
        sb5.append("Destination ");
        sb5.append(b.p());
        sb5.append(" does not have an Intent set.");
        throw new IllegalStateException(sb5.toString().toString());
    }
    
    @Metadata(bv = {}, d1 = { "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\u0004¨\u0006\u000b" }, d2 = { "Landroidx/navigation/ActivityNavigator$a;", "", "", "EXTRA_NAV_CURRENT", "Ljava/lang/String;", "EXTRA_NAV_SOURCE", "EXTRA_POP_ENTER_ANIM", "EXTRA_POP_EXIT_ANIM", "LOG_TAG", "<init>", "()V", "navigation-runtime_release" }, k = 1, mv = { 1, 6, 0 })
    public static final class a
    {
        private a() {
        }
        
        public a(final i i) {
            this();
        }
    }
    
    @Metadata(bv = {}, d1 = { "\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010-\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000,¢\u0006\u0004\b.\u0010/J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0017J\u0010\u0010\f\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u000f\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0011\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0014\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\b\u0010\u0016\u001a\u00020\u0015H\u0017J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\u0013\u0010\u001a\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0016R(\u0010\"\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\n\u0010\u001f\u001a\u0004\b \u0010!R(\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R(\u0010'\u001a\u0004\u0018\u00010\r2\b\u0010\u001e\u001a\u0004\u0018\u00010\r8F@BX\u0086\u000e¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R(\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u00028F@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0010\u0010$\u001a\u0004\b+\u0010&¨\u00060" }, d2 = { "Landroidx/navigation/ActivityNavigator$b;", "Landroidx/navigation/NavDestination;", "", "dataPattern", "N", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "Lka/r;", "w", "packageName", "O", "Landroid/content/ComponentName;", "name", "J", "action", "I", "Landroid/net/Uri;", "data", "K", "", "B", "toString", "", "other", "equals", "", "hashCode", "Landroid/content/Intent;", "<set-?>", "Landroid/content/Intent;", "H", "()Landroid/content/Intent;", "intent", "x", "Ljava/lang/String;", "G", "()Ljava/lang/String;", "component", "Landroid/content/ComponentName;", "D", "()Landroid/content/ComponentName;", "C", "Landroidx/navigation/Navigator;", "activityNavigator", "<init>", "(Landroidx/navigation/Navigator;)V", "navigation-runtime_release" }, k = 1, mv = { 1, 6, 0 })
    public static class b extends NavDestination
    {
        private Intent w;
        private String x;
        
        public b(final Navigator<? extends b> navigator) {
            o.g((Object)navigator, "activityNavigator");
            super(navigator);
        }
        
        @Override
        public boolean B() {
            return false;
        }
        
        public final String C() {
            final Intent w = this.w;
            String action;
            if (w != null) {
                action = w.getAction();
            }
            else {
                action = null;
            }
            return action;
        }
        
        public final ComponentName D() {
            final Intent w = this.w;
            ComponentName component;
            if (w != null) {
                component = w.getComponent();
            }
            else {
                component = null;
            }
            return component;
        }
        
        public final String G() {
            return this.x;
        }
        
        public final Intent H() {
            return this.w;
        }
        
        public final b I(final String action) {
            if (this.w == null) {
                this.w = new Intent();
            }
            final Intent w = this.w;
            o.d((Object)w);
            w.setAction(action);
            return this;
        }
        
        public final b J(final ComponentName component) {
            if (this.w == null) {
                this.w = new Intent();
            }
            final Intent w = this.w;
            o.d((Object)w);
            w.setComponent(component);
            return this;
        }
        
        public final b K(final Uri data) {
            if (this.w == null) {
                this.w = new Intent();
            }
            final Intent w = this.w;
            o.d((Object)w);
            w.setData(data);
            return this;
        }
        
        public final b N(final String x) {
            this.x = x;
            return this;
        }
        
        public final b O(final String package1) {
            if (this.w == null) {
                this.w = new Intent();
            }
            final Intent w = this.w;
            o.d((Object)w);
            w.setPackage(package1);
            return this;
        }
        
        @Override
        public boolean equals(final Object o) {
            boolean b2;
            final boolean b = b2 = false;
            if (o != null) {
                if (!(o instanceof b)) {
                    b2 = b;
                }
                else {
                    b2 = b;
                    if (super.equals(o)) {
                        final Intent w = this.w;
                        boolean filterEquals;
                        if (w != null) {
                            filterEquals = w.filterEquals(((b)o).w);
                        }
                        else {
                            filterEquals = (((b)o).w == null);
                        }
                        b2 = b;
                        if (filterEquals) {
                            b2 = b;
                            if (o.b((Object)this.x, (Object)((b)o).x)) {
                                b2 = true;
                            }
                        }
                    }
                }
            }
            return b2;
        }
        
        @Override
        public int hashCode() {
            final int hashCode = super.hashCode();
            final Intent w = this.w;
            int hashCode2 = 0;
            int filterHashCode;
            if (w != null) {
                filterHashCode = w.filterHashCode();
            }
            else {
                filterHashCode = 0;
            }
            final String x = this.x;
            if (x != null) {
                hashCode2 = x.hashCode();
            }
            return (hashCode * 31 + filterHashCode) * 31 + hashCode2;
        }
        
        @Override
        public String toString() {
            final ComponentName d = this.D();
            final StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            if (d != null) {
                sb.append(" class=");
                sb.append(d.getClassName());
            }
            else {
                final String c = this.C();
                if (c != null) {
                    sb.append(" action=");
                    sb.append(c);
                }
            }
            final String string = sb.toString();
            o.f((Object)string, "sb.toString()");
            return string;
        }
        
        @Override
        public void w(final Context context, final AttributeSet set) {
            o.g((Object)context, "context");
            o.g((Object)set, "attrs");
            super.w(context, set);
            final TypedArray obtainAttributes = context.getResources().obtainAttributes(set, z.a);
            o.f((Object)obtainAttributes, "context.resources.obtain\u2026tyNavigator\n            )");
            String s2;
            final String s = s2 = obtainAttributes.getString(z.f);
            if (s != null) {
                final String packageName = context.getPackageName();
                o.f((Object)packageName, "context.packageName");
                s2 = kotlin.text.l.D(s, "${applicationId}", packageName, false, 4, (Object)null);
            }
            this.O(s2);
            final String string = obtainAttributes.getString(z.b);
            if (string != null) {
                String string2 = string;
                if (string.charAt(0) == '.') {
                    final StringBuilder sb = new StringBuilder();
                    sb.append(context.getPackageName());
                    sb.append(string);
                    string2 = sb.toString();
                }
                this.J(new ComponentName(context, string2));
            }
            this.I(obtainAttributes.getString(z.c));
            final String string3 = obtainAttributes.getString(z.d);
            if (string3 != null) {
                this.K(Uri.parse(string3));
            }
            this.N(obtainAttributes.getString(z.e));
            obtainAttributes.recycle();
        }
    }
    
    @Metadata(bv = {}, d1 = { "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u0003\u0010\n¨\u0006\f" }, d2 = { "Landroidx/navigation/ActivityNavigator$c;", "Landroidx/navigation/Navigator$a;", "", "a", "I", "b", "()I", "flags", "Landroidx/core/app/c;", "Landroidx/core/app/c;", "()Landroidx/core/app/c;", "activityOptions", "navigation-runtime_release" }, k = 1, mv = { 1, 6, 0 })
    public static final class c implements Navigator.a
    {
        private final int a;
        private final androidx.core.app.c b;
        
        public final androidx.core.app.c a() {
            return this.b;
        }
        
        public final int b() {
            return this.a;
        }
    }
}
