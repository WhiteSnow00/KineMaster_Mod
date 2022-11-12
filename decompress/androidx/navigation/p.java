// 
// Decompiled by Procyon v0.6.0
// 

package androidx.navigation;

import org.xmlpull.v1.XmlPullParser;
import android.util.Xml;
import kotlin.text.l;
import android.os.Bundle;
import p0.a;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;
import android.content.res.TypedArray;
import ka.r;
import android.util.AttributeSet;
import android.content.res.XmlResourceParser;
import android.content.res.Resources;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.i;
import android.content.Context;
import android.util.TypedValue;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00162\u00020\u0001:\u0001\u000bB\u0017\u0012\u0006\u0010\u001b\u001a\u00020\u0019\u0012\u0006\u0010\u001e\u001a\u00020\u001c¢\u0006\u0004\b\u001f\u0010 J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J(\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J(\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J \u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J \u0010\u0015\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J0\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\u0018\u001a\u00020\u00172\b\b\u0001\u0010\t\u001a\u00020\bH\u0007R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u001d¨\u0006!" }, d2 = { "Landroidx/navigation/p;", "", "Landroid/content/res/Resources;", "res", "Landroid/content/res/XmlResourceParser;", "parser", "Landroid/util/AttributeSet;", "attrs", "", "graphResId", "Landroidx/navigation/NavDestination;", "a", "dest", "Lka/r;", "f", "Landroid/os/Bundle;", "bundle", "e", "Landroid/content/res/TypedArray;", "Landroidx/navigation/h;", "d", "g", "c", "Landroidx/navigation/NavGraph;", "b", "Landroid/content/Context;", "Landroid/content/Context;", "context", "Landroidx/navigation/v;", "Landroidx/navigation/v;", "navigatorProvider", "<init>", "(Landroid/content/Context;Landroidx/navigation/v;)V", "navigation-runtime_release" }, k = 1, mv = { 1, 6, 0 })
public final class p
{
    public static final a c;
    private static final ThreadLocal<TypedValue> d;
    private final Context a;
    private final v b;
    
    static {
        c = new a(null);
        d = new ThreadLocal<TypedValue>();
    }
    
    public p(final Context a, final v b) {
        o.g((Object)a, "context");
        o.g((Object)b, "navigatorProvider");
        this.a = a;
        this.b = b;
    }
    
    private final NavDestination a(final Resources resources, final XmlResourceParser xmlResourceParser, final AttributeSet set, final int n) throws XmlPullParserException, IOException {
        final v b = this.b;
        final String name = xmlResourceParser.getName();
        o.f((Object)name, "parser.name");
        final NavGraph a = b.d(name).a();
        a.w(this.a, set);
        final int n2 = xmlResourceParser.getDepth() + 1;
        while (true) {
            final int next = xmlResourceParser.next();
            if (next == 1) {
                break;
            }
            final int depth = xmlResourceParser.getDepth();
            if (depth < n2 && next == 3) {
                break;
            }
            if (next != 2) {
                continue;
            }
            if (depth > n2) {
                continue;
            }
            final String name2 = xmlResourceParser.getName();
            if (o.b((Object)"argument", (Object)name2)) {
                this.f(resources, a, set, n);
            }
            else if (o.b((Object)"deepLink", (Object)name2)) {
                this.g(resources, a, set);
            }
            else if (o.b((Object)"action", (Object)name2)) {
                this.c(resources, a, set, xmlResourceParser, n);
            }
            else if (o.b((Object)"include", (Object)name2) && a instanceof NavGraph) {
                final TypedArray obtainAttributes = resources.obtainAttributes(set, z.i);
                o.f((Object)obtainAttributes, "res.obtainAttributes(att\u2026n.R.styleable.NavInclude)");
                a.C(this.b(obtainAttributes.getResourceId(z.j, 0)));
                final r a2 = r.a;
                obtainAttributes.recycle();
            }
            else {
                if (!(a instanceof NavGraph)) {
                    continue;
                }
                a.C(this.a(resources, xmlResourceParser, set, n));
            }
        }
        return a;
    }
    
    private final void c(final Resources resources, final NavDestination navDestination, final AttributeSet set, final XmlResourceParser xmlResourceParser, final int n) throws IOException, XmlPullParserException {
        final Context a = this.a;
        final int[] a2 = p0.a.a;
        o.f((Object)a2, "NavAction");
        final TypedArray obtainStyledAttributes = a.obtainStyledAttributes(set, a2, 0, 0);
        final int resourceId = obtainStyledAttributes.getResourceId(p0.a.b, 0);
        final d d = new d(obtainStyledAttributes.getResourceId(p0.a.c, 0), null, null, 6, null);
        final q.a a3 = new q.a();
        a3.d(obtainStyledAttributes.getBoolean(p0.a.f, false));
        a3.j(obtainStyledAttributes.getBoolean(p0.a.l, false));
        a3.g(obtainStyledAttributes.getResourceId(p0.a.i, -1), obtainStyledAttributes.getBoolean(p0.a.j, false), obtainStyledAttributes.getBoolean(p0.a.k, false));
        a3.b(obtainStyledAttributes.getResourceId(p0.a.d, -1));
        a3.c(obtainStyledAttributes.getResourceId(p0.a.e, -1));
        a3.e(obtainStyledAttributes.getResourceId(p0.a.g, -1));
        a3.f(obtainStyledAttributes.getResourceId(p0.a.h, -1));
        d.e(a3.a());
        final Bundle bundle = new Bundle();
        final int n2 = xmlResourceParser.getDepth() + 1;
        while (true) {
            final int next = xmlResourceParser.next();
            if (next == 1) {
                break;
            }
            final int depth = xmlResourceParser.getDepth();
            if (depth < n2 && next == 3) {
                break;
            }
            if (next != 2) {
                continue;
            }
            if (depth > n2) {
                continue;
            }
            if (!o.b((Object)"argument", (Object)xmlResourceParser.getName())) {
                continue;
            }
            this.e(resources, bundle, set, n);
        }
        if (!bundle.isEmpty()) {
            d.d(bundle);
        }
        navDestination.x(resourceId, d);
        obtainStyledAttributes.recycle();
    }
    
    private final h d(final TypedArray typedArray, final Resources resources, int n) throws XmlPullParserException {
        final h.a a = new h.a();
        final int q = p0.a.q;
        boolean b = false;
        final int n2 = 0;
        a.c(typedArray.getBoolean(q, false));
        final ThreadLocal<TypedValue> d = p.d;
        TypedValue typedValue;
        if ((typedValue = d.get()) == null) {
            typedValue = new TypedValue();
            d.set(typedValue);
        }
        final String string = typedArray.getString(p0.a.p);
        Object o = null;
        t<?> a2;
        if (string != null) {
            a2 = t.c.a(string, resources.getResourcePackageName(n));
        }
        else {
            a2 = null;
        }
        n = p0.a.o;
        t<?> t = a2;
        if (typedArray.getValue(n, typedValue)) {
            t = androidx.navigation.t.e;
            if (a2 == t) {
                n = typedValue.resourceId;
                if (n == 0) {
                    if (typedValue.type != 16 || typedValue.data != 0) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("unsupported value '");
                        sb.append((Object)typedValue.string);
                        sb.append("' for ");
                        sb.append(a2.b());
                        sb.append(". Must be a reference to a resource.");
                        throw new XmlPullParserException(sb.toString());
                    }
                    n = n2;
                }
                o = n;
                t = a2;
            }
            else {
                final int resourceId = typedValue.resourceId;
                if (resourceId != 0) {
                    if (a2 != null) {
                        final StringBuilder sb2 = new StringBuilder();
                        sb2.append("unsupported value '");
                        sb2.append((Object)typedValue.string);
                        sb2.append("' for ");
                        sb2.append(a2.b());
                        sb2.append(". You must use a \"");
                        sb2.append(t.b());
                        sb2.append("\" type to reference other resources.");
                        throw new XmlPullParserException(sb2.toString());
                    }
                    o = resourceId;
                }
                else if (a2 == androidx.navigation.t.m) {
                    o = typedArray.getString(n);
                    t = a2;
                }
                else {
                    n = typedValue.type;
                    if (n != 3) {
                        if (n != 4) {
                            if (n != 5) {
                                if (n != 18) {
                                    if (n < 16 || n > 31) {
                                        final StringBuilder sb3 = new StringBuilder();
                                        sb3.append("unsupported argument type ");
                                        sb3.append(typedValue.type);
                                        throw new XmlPullParserException(sb3.toString());
                                    }
                                    final t<Float> i = androidx.navigation.t.i;
                                    if (a2 == i) {
                                        t = p.c.a(typedValue, a2, i, string, "float");
                                        o = typedValue.data;
                                    }
                                    else {
                                        t = p.c.a(typedValue, a2, androidx.navigation.t.d, string, "integer");
                                        o = typedValue.data;
                                    }
                                }
                                else {
                                    t = p.c.a(typedValue, a2, androidx.navigation.t.k, string, "boolean");
                                    if (typedValue.data != 0) {
                                        b = true;
                                    }
                                    o = b;
                                }
                            }
                            else {
                                t = p.c.a(typedValue, a2, androidx.navigation.t.d, string, "dimension");
                                o = (int)typedValue.getDimension(resources.getDisplayMetrics());
                            }
                        }
                        else {
                            t = p.c.a(typedValue, a2, androidx.navigation.t.i, string, "float");
                            o = typedValue.getFloat();
                        }
                    }
                    else {
                        final String string2 = typedValue.string.toString();
                        if ((t = a2) == null) {
                            t = androidx.navigation.t.c.b(string2);
                        }
                        o = t.e(string2);
                    }
                }
            }
        }
        if (o != null) {
            a.b(o);
        }
        if (t != null) {
            a.d(t);
        }
        return a.a();
    }
    
    private final void e(final Resources resources, final Bundle bundle, final AttributeSet set, final int n) throws XmlPullParserException {
        final TypedArray obtainAttributes = resources.obtainAttributes(set, p0.a.m);
        o.f((Object)obtainAttributes, "res.obtainAttributes(att\u2026 R.styleable.NavArgument)");
        final String string = obtainAttributes.getString(p0.a.n);
        if (string != null) {
            o.f((Object)string, "array.getString(R.stylea\u2026uments must have a name\")");
            final h d = this.d(obtainAttributes, resources, n);
            if (d.b()) {
                d.d(string, bundle);
            }
            final r a = r.a;
            obtainAttributes.recycle();
            return;
        }
        throw new XmlPullParserException("Arguments must have a name");
    }
    
    private final void f(final Resources resources, final NavDestination navDestination, final AttributeSet set, final int n) throws XmlPullParserException {
        final TypedArray obtainAttributes = resources.obtainAttributes(set, p0.a.m);
        o.f((Object)obtainAttributes, "res.obtainAttributes(att\u2026 R.styleable.NavArgument)");
        final String string = obtainAttributes.getString(p0.a.n);
        if (string != null) {
            o.f((Object)string, "array.getString(R.stylea\u2026uments must have a name\")");
            navDestination.a(string, this.d(obtainAttributes, resources, n));
            final r a = r.a;
            obtainAttributes.recycle();
            return;
        }
        throw new XmlPullParserException("Arguments must have a name");
    }
    
    private final void g(final Resources resources, final NavDestination navDestination, final AttributeSet set) throws XmlPullParserException {
        final TypedArray obtainAttributes = resources.obtainAttributes(set, p0.a.r);
        o.f((Object)obtainAttributes, "res.obtainAttributes(att\u2026 R.styleable.NavDeepLink)");
        final String string = obtainAttributes.getString(p0.a.u);
        final String string2 = obtainAttributes.getString(p0.a.s);
        final String string3 = obtainAttributes.getString(p0.a.t);
        final int n = 0;
        if ((string == null || string.length() == 0) && (string2 == null || string2.length() == 0) && (string3 == null || string3.length() == 0)) {
            throw new XmlPullParserException("Every <deepLink> must include at least one of app:uri, app:action, or app:mimeType");
        }
        final NavDeepLink.a a = new NavDeepLink.a();
        if (string != null) {
            final String packageName = this.a.getPackageName();
            o.f((Object)packageName, "context.packageName");
            a.d(l.D(string, "${applicationId}", packageName, false, 4, (Object)null));
        }
        int n2 = 0;
        Label_0225: {
            if (string2 != null) {
                n2 = n;
                if (string2.length() != 0) {
                    break Label_0225;
                }
            }
            n2 = 1;
        }
        if (n2 == 0) {
            final String packageName2 = this.a.getPackageName();
            o.f((Object)packageName2, "context.packageName");
            a.b(l.D(string2, "${applicationId}", packageName2, false, 4, (Object)null));
        }
        if (string3 != null) {
            final String packageName3 = this.a.getPackageName();
            o.f((Object)packageName3, "context.packageName");
            a.c(l.D(string3, "${applicationId}", packageName3, false, 4, (Object)null));
        }
        navDestination.b(a.a());
        final r a2 = r.a;
        obtainAttributes.recycle();
    }
    
    public final NavGraph b(final int n) {
        final Resources resources = this.a.getResources();
        final XmlResourceParser xml = resources.getXml(n);
        o.f((Object)xml, "res.getXml(graphResId)");
        final AttributeSet attributeSet = Xml.asAttributeSet((XmlPullParser)xml);
        try {
            int next;
            do {
                next = xml.next();
            } while (next != 2 && next != 1);
            if (next != 2) {
                throw new XmlPullParserException("No start tag found");
            }
            final String name = xml.getName();
            o.f((Object)resources, "res");
            o.f((Object)attributeSet, "attrs");
            final NavDestination a = this.a(resources, xml, attributeSet, n);
            if (a instanceof NavGraph) {
                final NavGraph navGraph = (NavGraph)a;
                xml.close();
                return navGraph;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("Root element <");
            sb.append(name);
            sb.append("> did not inflate into a NavGraph");
            throw new IllegalArgumentException(sb.toString().toString());
        }
        catch (final Exception ex) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Exception inflating ");
            sb2.append(resources.getResourceName(n));
            sb2.append(" line ");
            sb2.append(xml.getLineNumber());
            throw new RuntimeException(sb2.toString(), ex);
        }
        xml.close();
    }
    
    @Metadata(bv = {}, d1 = { "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016JG\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00078\u0006X\u0087T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0014\u0010\u0011\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\rR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0017" }, d2 = { "Landroidx/navigation/p$a;", "", "Landroid/util/TypedValue;", "value", "Landroidx/navigation/t;", "navType", "expectedNavType", "", "argType", "foundType", "a", "(Landroid/util/TypedValue;Landroidx/navigation/t;Landroidx/navigation/t;Ljava/lang/String;Ljava/lang/String;)Landroidx/navigation/t;", "APPLICATION_ID_PLACEHOLDER", "Ljava/lang/String;", "TAG_ACTION", "TAG_ARGUMENT", "TAG_DEEP_LINK", "TAG_INCLUDE", "Ljava/lang/ThreadLocal;", "sTmpValue", "Ljava/lang/ThreadLocal;", "<init>", "()V", "navigation-runtime_release" }, k = 1, mv = { 1, 6, 0 })
    public static final class a
    {
        private a() {
        }
        
        public a(final i i) {
            this();
        }
        
        public final t<?> a(final TypedValue typedValue, final t<?> t, final t<?> t2, final String s, final String s2) throws XmlPullParserException {
            o.g((Object)typedValue, "value");
            o.g((Object)t2, "expectedNavType");
            o.g((Object)s2, "foundType");
            if (t != null && t != t2) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Type is ");
                sb.append(s);
                sb.append(" but found ");
                sb.append(s2);
                sb.append(": ");
                sb.append(typedValue.data);
                throw new XmlPullParserException(sb.toString());
            }
            t<?> t3;
            if ((t3 = t) == null) {
                t3 = t2;
            }
            return t3;
        }
    }
}
