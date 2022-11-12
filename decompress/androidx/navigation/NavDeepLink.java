// 
// Decompiled by Procyon v0.6.0
// 

package androidx.navigation;

import java.util.ListIterator;
import kotlin.text.Regex;
import java.util.Collection;
import android.os.Bundle;
import java.util.Iterator;
import java.util.regex.Matcher;
import kotlin.text.l;
import java.util.Objects;
import kotlin.jvm.internal.o;
import android.net.Uri;
import kotlin.a;
import java.util.LinkedHashMap;
import java.util.ArrayList;
import kotlin.jvm.internal.i;
import ka.j;
import java.util.Map;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u000e\n\u0002\u0010!\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010 \n\u0002\b\u0005\u0018\u0000 \u00112\u00020\u0001:\u0004\u001d\"\n#B'\b\u0000\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\bC\u0010DJ$\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J*\u0010\u0011\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0002H\u0007J(\u0010\u0019\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0016\u001a\u00020\u00152\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0017H\u0007J\u0013\u0010\u001b\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001c\u001a\u00020\u0013H\u0016R\u0019\u0010!\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0019\u0010$\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\"\u0010\u001e\u001a\u0004\b#\u0010 R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u001e\u001a\u0004\b%\u0010 R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010'R \u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020)0(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010-\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001eR\u0016\u0010/\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010.R\u0016\u00101\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010.R\u0018\u00103\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010\u001eR*\u00109\u001a\u00020\t2\u0006\u00104\u001a\u00020\t8G@@X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u0010.\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001d\u0010=\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b2\u0010<R\u001d\u0010?\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010;\u001a\u0004\b0\u0010<R\u001a\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00020@8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b*\u0010A¨\u0006E" }, d2 = { "Landroidx/navigation/NavDeepLink;", "", "", "uri", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "uriRegex", "Ljava/util/regex/Pattern;", "fillInPattern", "", "c", "Landroid/os/Bundle;", "bundle", "name", "value", "Landroidx/navigation/h;", "argument", "m", "mimeType", "", "h", "Landroid/net/Uri;", "deepLink", "", "arguments", "f", "other", "equals", "hashCode", "a", "Ljava/lang/String;", "k", "()Ljava/lang/String;", "uriPattern", "b", "d", "action", "g", "", "Ljava/util/List;", "", "Landroidx/navigation/NavDeepLink$d;", "e", "Ljava/util/Map;", "paramArgMap", "patternFinalRegex", "Z", "isParameterizedQuery", "i", "isSingleQueryParamValueOnly", "j", "mimeTypeFinalRegex", "<set-?>", "l", "()Z", "setExactDeepLink$navigation_common_release", "(Z)V", "isExactDeepLink", "pattern$delegate", "Lka/j;", "()Ljava/util/regex/Pattern;", "pattern", "mimeTypePattern$delegate", "mimeTypePattern", "", "()Ljava/util/List;", "argumentsNames", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "navigation-common_release" }, k = 1, mv = { 1, 6, 0 })
public final class NavDeepLink
{
    private static final b m;
    @Deprecated
    private static final Pattern n;
    private final String a;
    private final String b;
    private final String c;
    private final List<String> d;
    private final Map<String, d> e;
    private String f;
    private final j g;
    private boolean h;
    private boolean i;
    private String j;
    private final j k;
    private boolean l;
    
    static {
        m = new b(null);
        n = Pattern.compile("^[a-zA-Z]+[+\\w\\-.]*:");
    }
    
    public NavDeepLink(String a, String b, String queryParameter) {
        this.a = a;
        this.b = b;
        this.c = queryParameter;
        this.d = new ArrayList<String>();
        this.e = new LinkedHashMap<String, d>();
        this.g = kotlin.a.b((sa.a)new NavDeepLink$pattern.NavDeepLink$pattern$2(this));
        this.k = kotlin.a.b((sa.a)new NavDeepLink$mimeTypePattern.NavDeepLink$mimeTypePattern$2(this));
        if (a != null) {
            final Uri parse = Uri.parse(a);
            this.h = (parse.getQuery() != null);
            final StringBuilder sb = new StringBuilder("^");
            if (!NavDeepLink.n.matcher(a).find()) {
                sb.append("http[s]?://");
            }
            final Pattern compile = Pattern.compile("\\{(.+?)\\}");
            if (this.h) {
                final Matcher matcher = Pattern.compile("(\\?)").matcher(a);
                if (matcher.find()) {
                    a = a.substring(0, matcher.start());
                    o.f((Object)a, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                    o.f((Object)compile, "fillInPattern");
                    this.l = this.c(a, sb, compile);
                }
                final Iterator iterator = parse.getQueryParameterNames().iterator();
                while (iterator.hasNext()) {
                    b = (String)iterator.next();
                    final StringBuilder sb2 = new StringBuilder();
                    queryParameter = parse.getQueryParameter(b);
                    if ((a = queryParameter) == null) {
                        this.i = true;
                        a = b;
                    }
                    final Matcher matcher2 = compile.matcher(a);
                    final d d = new d();
                    int end = 0;
                    while (matcher2.find()) {
                        final String group = matcher2.group(1);
                        Objects.requireNonNull(group, "null cannot be cast to non-null type kotlin.String");
                        d.a(group);
                        o.f((Object)a, "queryParam");
                        final String substring = a.substring(end, matcher2.start());
                        o.f((Object)substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                        sb2.append(Pattern.quote(substring));
                        sb2.append("(.+?)?");
                        end = matcher2.end();
                    }
                    if (end < a.length()) {
                        o.f((Object)a, "queryParam");
                        a = a.substring(end);
                        o.f((Object)a, "this as java.lang.String).substring(startIndex)");
                        sb2.append(Pattern.quote(a));
                    }
                    a = sb2.toString();
                    o.f((Object)a, "argRegex.toString()");
                    d.e(kotlin.text.l.D(a, ".*", "\\E.*\\Q", false, 4, (Object)null));
                    final Map<String, d> e = this.e;
                    o.f((Object)b, "paramName");
                    e.put(b, d);
                }
            }
            else {
                o.f((Object)compile, "fillInPattern");
                this.l = this.c(a, sb, compile);
            }
            a = sb.toString();
            o.f((Object)a, "uriRegex.toString()");
            this.f = kotlin.text.l.D(a, ".*", "\\E.*\\Q", false, 4, (Object)null);
        }
        if (this.c != null) {
            if (!Pattern.compile("^[\\s\\S]+/[\\s\\S]+$").matcher(this.c).matches()) {
                final StringBuilder sb3 = new StringBuilder();
                sb3.append("The given mimeType ");
                sb3.append(this.c);
                sb3.append(" does not match to required \"type/subtype\" format");
                throw new IllegalArgumentException(sb3.toString().toString());
            }
            final c c = new c(this.c);
            final StringBuilder sb4 = new StringBuilder();
            sb4.append("^(");
            sb4.append(c.d());
            sb4.append("|[*]+)/(");
            sb4.append(c.c());
            sb4.append("|[*]+)$");
            this.j = kotlin.text.l.D(sb4.toString(), "*|[*]", "[\\s\\S]", false, 4, (Object)null);
        }
    }
    
    public static final String a(final NavDeepLink navDeepLink) {
        return navDeepLink.j;
    }
    
    public static final String b(final NavDeepLink navDeepLink) {
        return navDeepLink.f;
    }
    
    private final boolean c(String substring, final StringBuilder sb, final Pattern pattern) {
        final Matcher matcher = pattern.matcher(substring);
        boolean b = kotlin.text.l.M((CharSequence)substring, (CharSequence)".*", false, 2, (Object)null) ^ true;
        int end = 0;
        while (matcher.find()) {
            final String group = matcher.group(1);
            Objects.requireNonNull(group, "null cannot be cast to non-null type kotlin.String");
            this.d.add(group);
            final String substring2 = substring.substring(end, matcher.start());
            o.f((Object)substring2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            sb.append(Pattern.quote(substring2));
            sb.append("([^/]+?)");
            end = matcher.end();
            b = false;
        }
        if (end < substring.length()) {
            substring = substring.substring(end);
            o.f((Object)substring, "this as java.lang.String).substring(startIndex)");
            sb.append(Pattern.quote(substring));
        }
        sb.append("($|(\\?(.)*)|(\\#(.)*))");
        return b;
    }
    
    private final Pattern i() {
        return (Pattern)this.k.getValue();
    }
    
    private final Pattern j() {
        return (Pattern)this.g.getValue();
    }
    
    private final boolean m(final Bundle bundle, final String s, final String s2, final h h) {
        if (h != null) {
            h.a().d(bundle, s, s2);
        }
        else {
            bundle.putString(s, s2);
        }
        return false;
    }
    
    public final String d() {
        return this.b;
    }
    
    public final List<String> e() {
        final List<String> d = this.d;
        final Collection<d> values = this.e.values();
        final ArrayList list = new ArrayList();
        final Iterator<Object> iterator = values.iterator();
        while (iterator.hasNext()) {
            kotlin.collections.o.z((Collection)list, (Iterable)iterator.next().c());
        }
        return kotlin.collections.o.w0((Collection)d, (Iterable)list);
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b2;
        final boolean b = b2 = false;
        if (o != null) {
            if (!(o instanceof NavDeepLink)) {
                b2 = b;
            }
            else {
                final String a = this.a;
                final NavDeepLink navDeepLink = (NavDeepLink)o;
                b2 = b;
                if (o.b((Object)a, (Object)navDeepLink.a)) {
                    b2 = b;
                    if (o.b((Object)this.b, (Object)navDeepLink.b)) {
                        b2 = b;
                        if (o.b((Object)this.c, (Object)navDeepLink.c)) {
                            b2 = true;
                        }
                    }
                }
            }
        }
        return b2;
    }
    
    public final Bundle f(final Uri p0, final Map<String, h> p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc_w           "deepLink"
        //     4: invokestatic    kotlin/jvm/internal/o.g:(Ljava/lang/Object;Ljava/lang/String;)V
        //     7: aload_2        
        //     8: ldc_w           "arguments"
        //    11: invokestatic    kotlin/jvm/internal/o.g:(Ljava/lang/Object;Ljava/lang/String;)V
        //    14: aload_0        
        //    15: invokespecial   androidx/navigation/NavDeepLink.j:()Ljava/util/regex/Pattern;
        //    18: astore          6
        //    20: aload           6
        //    22: ifnull          39
        //    25: aload           6
        //    27: aload_1        
        //    28: invokevirtual   android/net/Uri.toString:()Ljava/lang/String;
        //    31: invokevirtual   java/util/regex/Pattern.matcher:(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
        //    34: astore          6
        //    36: goto            42
        //    39: aconst_null    
        //    40: astore          6
        //    42: aload           6
        //    44: ifnonnull       49
        //    47: aconst_null    
        //    48: areturn        
        //    49: aload           6
        //    51: invokevirtual   java/util/regex/Matcher.matches:()Z
        //    54: ifne            59
        //    57: aconst_null    
        //    58: areturn        
        //    59: new             Landroid/os/Bundle;
        //    62: dup            
        //    63: invokespecial   android/os/Bundle.<init>:()V
        //    66: astore          9
        //    68: aload_0        
        //    69: getfield        androidx/navigation/NavDeepLink.d:Ljava/util/List;
        //    72: invokeinterface java/util/List.size:()I
        //    77: istore          4
        //    79: iconst_0       
        //    80: istore_3       
        //    81: iload_3        
        //    82: iload           4
        //    84: if_icmpge       158
        //    87: aload_0        
        //    88: getfield        androidx/navigation/NavDeepLink.d:Ljava/util/List;
        //    91: iload_3        
        //    92: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //    97: checkcast       Ljava/lang/String;
        //   100: astore          10
        //   102: iinc            3, 1
        //   105: aload           6
        //   107: iload_3        
        //   108: invokevirtual   java/util/regex/Matcher.group:(I)Ljava/lang/String;
        //   111: invokestatic    android/net/Uri.decode:(Ljava/lang/String;)Ljava/lang/String;
        //   114: astore          8
        //   116: aload_2        
        //   117: aload           10
        //   119: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //   124: checkcast       Landroidx/navigation/h;
        //   127: astore          7
        //   129: aload           8
        //   131: ldc_w           "value"
        //   134: invokestatic    kotlin/jvm/internal/o.f:(Ljava/lang/Object;Ljava/lang/String;)V
        //   137: aload_0        
        //   138: aload           9
        //   140: aload           10
        //   142: aload           8
        //   144: aload           7
        //   146: invokespecial   androidx/navigation/NavDeepLink.m:(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;Landroidx/navigation/h;)Z
        //   149: istore          5
        //   151: iload           5
        //   153: ifeq            81
        //   156: aconst_null    
        //   157: areturn        
        //   158: aload_0        
        //   159: getfield        androidx/navigation/NavDeepLink.h:Z
        //   162: ifeq            496
        //   165: aload_0        
        //   166: getfield        androidx/navigation/NavDeepLink.e:Ljava/util/Map;
        //   169: invokeinterface java/util/Map.keySet:()Ljava/util/Set;
        //   174: invokeinterface java/util/Set.iterator:()Ljava/util/Iterator;
        //   179: astore          10
        //   181: aload           10
        //   183: invokeinterface java/util/Iterator.hasNext:()Z
        //   188: ifeq            496
        //   191: aload           10
        //   193: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   198: checkcast       Ljava/lang/String;
        //   201: astore          6
        //   203: aload_0        
        //   204: getfield        androidx/navigation/NavDeepLink.e:Ljava/util/Map;
        //   207: aload           6
        //   209: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //   214: checkcast       Landroidx/navigation/NavDeepLink$d;
        //   217: astore          11
        //   219: aload_1        
        //   220: aload           6
        //   222: invokevirtual   android/net/Uri.getQueryParameter:(Ljava/lang/String;)Ljava/lang/String;
        //   225: astore          7
        //   227: aload           7
        //   229: astore          6
        //   231: aload_0        
        //   232: getfield        androidx/navigation/NavDeepLink.i:Z
        //   235: ifeq            282
        //   238: aload_1        
        //   239: invokevirtual   android/net/Uri.toString:()Ljava/lang/String;
        //   242: astore          12
        //   244: aload           12
        //   246: ldc_w           "deepLink.toString()"
        //   249: invokestatic    kotlin/jvm/internal/o.f:(Ljava/lang/Object;Ljava/lang/String;)V
        //   252: aload           12
        //   254: bipush          63
        //   256: aconst_null    
        //   257: iconst_2       
        //   258: aconst_null    
        //   259: invokestatic    kotlin/text/l.I0:(Ljava/lang/String;CLjava/lang/String;ILjava/lang/Object;)Ljava/lang/String;
        //   262: astore          8
        //   264: aload           7
        //   266: astore          6
        //   268: aload           8
        //   270: aload           12
        //   272: invokestatic    kotlin/jvm/internal/o.b:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   275: ifne            282
        //   278: aload           8
        //   280: astore          6
        //   282: aload           6
        //   284: ifnull          323
        //   287: aload           11
        //   289: invokestatic    kotlin/jvm/internal/o.d:(Ljava/lang/Object;)V
        //   292: aload           11
        //   294: invokevirtual   androidx/navigation/NavDeepLink$d.d:()Ljava/lang/String;
        //   297: bipush          32
        //   299: invokestatic    java/util/regex/Pattern.compile:(Ljava/lang/String;I)Ljava/util/regex/Pattern;
        //   302: aload           6
        //   304: invokevirtual   java/util/regex/Pattern.matcher:(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
        //   307: astore          6
        //   309: aload           6
        //   311: astore          7
        //   313: aload           6
        //   315: invokevirtual   java/util/regex/Matcher.matches:()Z
        //   318: ifne            326
        //   321: aconst_null    
        //   322: areturn        
        //   323: aconst_null    
        //   324: astore          7
        //   326: new             Landroid/os/Bundle;
        //   329: dup            
        //   330: invokespecial   android/os/Bundle.<init>:()V
        //   333: astore          12
        //   335: aload           11
        //   337: invokestatic    kotlin/jvm/internal/o.d:(Ljava/lang/Object;)V
        //   340: aload           11
        //   342: invokevirtual   androidx/navigation/NavDeepLink$d.f:()I
        //   345: istore          4
        //   347: iconst_0       
        //   348: istore_3       
        //   349: iload_3        
        //   350: iload           4
        //   352: if_icmpge       486
        //   355: aload           7
        //   357: ifnull          387
        //   360: aload           7
        //   362: iload_3        
        //   363: iconst_1       
        //   364: iadd           
        //   365: invokevirtual   java/util/regex/Matcher.group:(I)Ljava/lang/String;
        //   368: astore          8
        //   370: aload           8
        //   372: astore          6
        //   374: aload           8
        //   376: ifnonnull       390
        //   379: ldc_w           ""
        //   382: astore          6
        //   384: goto            390
        //   387: aconst_null    
        //   388: astore          6
        //   390: aload           11
        //   392: iload_3        
        //   393: invokevirtual   androidx/navigation/NavDeepLink$d.b:(I)Ljava/lang/String;
        //   396: astore          14
        //   398: aload_2        
        //   399: aload           14
        //   401: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //   406: checkcast       Landroidx/navigation/h;
        //   409: astore          13
        //   411: aload           6
        //   413: ifnull          480
        //   416: new             Ljava/lang/StringBuilder;
        //   419: astore          8
        //   421: aload           8
        //   423: invokespecial   java/lang/StringBuilder.<init>:()V
        //   426: aload           8
        //   428: bipush          123
        //   430: invokevirtual   java/lang/StringBuilder.append:(C)Ljava/lang/StringBuilder;
        //   433: pop            
        //   434: aload           8
        //   436: aload           14
        //   438: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   441: pop            
        //   442: aload           8
        //   444: bipush          125
        //   446: invokevirtual   java/lang/StringBuilder.append:(C)Ljava/lang/StringBuilder;
        //   449: pop            
        //   450: aload           6
        //   452: aload           8
        //   454: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   457: invokestatic    kotlin/jvm/internal/o.b:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   460: ifne            480
        //   463: aload_0        
        //   464: aload           12
        //   466: aload           14
        //   468: aload           6
        //   470: aload           13
        //   472: invokespecial   androidx/navigation/NavDeepLink.m:(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;Landroidx/navigation/h;)Z
        //   475: ifeq            480
        //   478: aconst_null    
        //   479: areturn        
        //   480: iinc            3, 1
        //   483: goto            349
        //   486: aload           9
        //   488: aload           12
        //   490: invokevirtual   android/os/Bundle.putAll:(Landroid/os/Bundle;)V
        //   493: goto            181
        //   496: aload_2        
        //   497: invokeinterface java/util/Map.entrySet:()Ljava/util/Set;
        //   502: invokeinterface java/util/Set.iterator:()Ljava/util/Iterator;
        //   507: astore_1       
        //   508: aload_1        
        //   509: invokeinterface java/util/Iterator.hasNext:()Z
        //   514: ifeq            594
        //   517: aload_1        
        //   518: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   523: checkcast       Ljava/util/Map$Entry;
        //   526: astore          6
        //   528: aload           6
        //   530: invokeinterface java/util/Map$Entry.getKey:()Ljava/lang/Object;
        //   535: checkcast       Ljava/lang/String;
        //   538: astore_2       
        //   539: aload           6
        //   541: invokeinterface java/util/Map$Entry.getValue:()Ljava/lang/Object;
        //   546: checkcast       Landroidx/navigation/h;
        //   549: astore          6
        //   551: aload           6
        //   553: ifnull          577
        //   556: aload           6
        //   558: invokevirtual   androidx/navigation/h.c:()Z
        //   561: ifne            577
        //   564: aload           6
        //   566: invokevirtual   androidx/navigation/h.b:()Z
        //   569: ifne            577
        //   572: iconst_1       
        //   573: istore_3       
        //   574: goto            579
        //   577: iconst_0       
        //   578: istore_3       
        //   579: iload_3        
        //   580: ifeq            508
        //   583: aload           9
        //   585: aload_2        
        //   586: invokevirtual   android/os/Bundle.containsKey:(Ljava/lang/String;)Z
        //   589: ifne            508
        //   592: aconst_null    
        //   593: areturn        
        //   594: aload           9
        //   596: areturn        
        //   597: astore_1       
        //   598: goto            156
        //   601: astore          6
        //   603: goto            181
        //    Signature:
        //  (Landroid/net/Uri;Ljava/util/Map<Ljava/lang/String;Landroidx/navigation/h;>;)Landroid/os/Bundle;
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                
        //  -----  -----  -----  -----  ------------------------------------
        //  129    151    597    601    Ljava/lang/IllegalArgumentException;
        //  335    347    601    606    Ljava/lang/IllegalArgumentException;
        //  360    370    601    606    Ljava/lang/IllegalArgumentException;
        //  390    411    601    606    Ljava/lang/IllegalArgumentException;
        //  416    478    601    606    Ljava/lang/IllegalArgumentException;
        //  486    493    601    606    Ljava/lang/IllegalArgumentException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0349:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2604)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:206)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:93)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:868)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:761)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:638)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:605)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:195)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:162)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:137)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:333)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:254)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:129)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public final String g() {
        return this.c;
    }
    
    public final int h(final String s) {
        o.g((Object)s, "mimeType");
        if (this.c != null) {
            final Pattern i = this.i();
            o.d((Object)i);
            if (i.matcher(s).matches()) {
                return new c(this.c).a(new c(s));
            }
        }
        return -1;
    }
    
    @Override
    public int hashCode() {
        final String a = this.a;
        int hashCode = 0;
        int hashCode2;
        if (a != null) {
            hashCode2 = a.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        final String b = this.b;
        int hashCode3;
        if (b != null) {
            hashCode3 = b.hashCode();
        }
        else {
            hashCode3 = 0;
        }
        final String c = this.c;
        if (c != null) {
            hashCode = c.hashCode();
        }
        return ((hashCode2 + 0) * 31 + hashCode3) * 31 + hashCode;
    }
    
    public final String k() {
        return this.a;
    }
    
    public final boolean l() {
        return this.l;
    }
    
    @Metadata(bv = {}, d1 = { "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00042\u00020\u0001:\u0001\nB\t\b\u0017¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\tR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u000bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u000b¨\u0006\u000e" }, d2 = { "Landroidx/navigation/NavDeepLink$a;", "", "", "uriPattern", "d", "action", "b", "mimeType", "c", "Landroidx/navigation/NavDeepLink;", "a", "Ljava/lang/String;", "<init>", "()V", "navigation-common_release" }, k = 1, mv = { 1, 6, 0 })
    public static final class a
    {
        public static final NavDeepLink.a.a d;
        private String a;
        private String b;
        private String c;
        
        static {
            d = new NavDeepLink.a.a(null);
        }
        
        public final NavDeepLink a() {
            return new NavDeepLink(this.a, this.b, this.c);
        }
        
        public final NavDeepLink.a b(final String b) {
            o.g((Object)b, "action");
            if (b.length() > 0) {
                this.b = b;
                return this;
            }
            throw new IllegalArgumentException("The NavDeepLink cannot have an empty action.".toString());
        }
        
        public final NavDeepLink.a c(final String c) {
            o.g((Object)c, "mimeType");
            this.c = c;
            return this;
        }
        
        public final NavDeepLink.a d(final String a) {
            o.g((Object)a, "uriPattern");
            this.a = a;
            return this;
        }
        
        @Metadata(bv = {}, d1 = { "\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004" }, d2 = { "Landroidx/navigation/NavDeepLink$a$a;", "", "<init>", "()V", "navigation-common_release" }, k = 1, mv = { 1, 6, 0 })
        public static final class a
        {
            private a() {
            }
            
            public a(final i i) {
                this();
            }
        }
    }
    
    @Metadata(bv = {}, d1 = { "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b" }, d2 = { "Landroidx/navigation/NavDeepLink$b;", "", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "SCHEME_PATTERN", "Ljava/util/regex/Pattern;", "<init>", "()V", "navigation-common_release" }, k = 1, mv = { 1, 6, 0 })
    private static final class b
    {
        private b() {
        }
        
        public b(final i i) {
            this();
        }
    }
    
    @Metadata(bv = {}, d1 = { "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0005¢\u0006\u0004\b\u0011\u0010\nJ\u0011\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000H\u0096\u0002R\"\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000f\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u0012" }, d2 = { "Landroidx/navigation/NavDeepLink$c;", "", "other", "", "a", "", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "type", "b", "c", "setSubType", "subType", "mimeType", "<init>", "navigation-common_release" }, k = 1, mv = { 1, 6, 0 })
    private static final class c implements Comparable<c>
    {
        private String a;
        private String b;
        
        public c(final String s) {
            o.g((Object)s, "mimeType");
            final List split = new Regex("/").split((CharSequence)s, 0);
            List list = null;
            Label_0104: {
                if (!split.isEmpty()) {
                    final ListIterator listIterator = split.listIterator(split.size());
                    while (listIterator.hasPrevious()) {
                        if (((String)listIterator.previous()).length() != 0) {
                            list = kotlin.collections.o.H0((Iterable)split, listIterator.nextIndex() + 1);
                            break Label_0104;
                        }
                    }
                }
                list = kotlin.collections.o.j();
            }
            this.a = (String)list.get(0);
            this.b = (String)list.get(1);
        }
        
        public int a(final c c) {
            o.g((Object)c, "other");
            int n;
            if (o.b((Object)this.a, (Object)c.a)) {
                n = 2;
            }
            else {
                n = 0;
            }
            int n2 = n;
            if (o.b((Object)this.b, (Object)c.b)) {
                n2 = n + 1;
            }
            return n2;
        }
        
        public final String c() {
            return this.b;
        }
        
        @Override
        public /* bridge */ int compareTo(final Object o) {
            return this.a((c)o);
        }
        
        public final String d() {
            return this.a;
        }
    }
    
    @Metadata(bv = {}, d1 = { "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0006R$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108\u0006¢\u0006\f\n\u0004\b\b\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017" }, d2 = { "Landroidx/navigation/NavDeepLink$d;", "", "", "name", "Lka/r;", "a", "", "index", "b", "f", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "e", "(Ljava/lang/String;)V", "paramRegex", "", "Ljava/util/List;", "c", "()Ljava/util/List;", "arguments", "<init>", "()V", "navigation-common_release" }, k = 1, mv = { 1, 6, 0 })
    private static final class d
    {
        private String a;
        private final List<String> b;
        
        public d() {
            this.b = new ArrayList<String>();
        }
        
        public final void a(final String s) {
            o.g((Object)s, "name");
            this.b.add(s);
        }
        
        public final String b(final int n) {
            return this.b.get(n);
        }
        
        public final List<String> c() {
            return this.b;
        }
        
        public final String d() {
            return this.a;
        }
        
        public final void e(final String a) {
            this.a = a;
        }
        
        public final int f() {
            return this.b.size();
        }
    }
}
