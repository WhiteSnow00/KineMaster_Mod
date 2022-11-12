// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.text.ssa;

import java.util.regex.Matcher;
import android.graphics.PointF;
import java.util.regex.Pattern;
import com.google.common.base.Ascii;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import android.graphics.Color;
import com.google.common.primitives.Ints;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import android.text.TextUtils;
import com.google.android.exoplayer2.util.Assertions;

final class SsaStyle
{
    public final String a;
    public final int b;
    public final Integer c;
    public final Integer d;
    public final float e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final int j;
    
    private SsaStyle(final String a, final int b, final Integer c, final Integer d, final float e, final boolean f, final boolean g, final boolean h, final boolean i, final int j) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
        this.j = j;
    }
    
    static int a(final String s) {
        return e(s);
    }
    
    public static SsaStyle b(final String s, final a a) {
        Assertions.a(s.startsWith("Style:"));
        final String[] split = TextUtils.split(s.substring(6), ",");
        final int length = split.length;
        final int k = a.k;
        if (length != k) {
            Log.i("SsaStyle", Util.C("Skipping malformed 'Style:' line (expected %s values, found %s): '%s'", k, split.length, s));
            return null;
        }
        try {
            final String trim = split[a.a].trim();
            final int b = a.b;
            int e;
            if (b != -1) {
                e = e(split[b].trim());
            }
            else {
                e = -1;
            }
            final int c = a.c;
            Integer h;
            if (c != -1) {
                h = h(split[c].trim());
            }
            else {
                h = null;
            }
            final int d = a.d;
            Integer h2;
            if (d != -1) {
                h2 = h(split[d].trim());
            }
            else {
                h2 = null;
            }
            final int e2 = a.e;
            float i;
            if (e2 != -1) {
                i = i(split[e2].trim());
            }
            else {
                i = -3.4028235E38f;
            }
            final int f = a.f;
            final boolean b2 = f != -1 && f(split[f].trim());
            final int g = a.g;
            final boolean b3 = g != -1 && f(split[g].trim());
            final int h3 = a.h;
            final boolean b4 = h3 != -1 && f(split[h3].trim());
            final int j = a.i;
            final boolean b5 = j != -1 && f(split[j].trim());
            final int l = a.j;
            int g2;
            if (l != -1) {
                g2 = g(split[l].trim());
            }
            else {
                g2 = -1;
            }
            return new SsaStyle(trim, e, h, h2, i, b2, b3, b4, b5, g2);
        }
        catch (final RuntimeException ex) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Skipping malformed 'Style:' line: '");
            sb.append(s);
            sb.append("'");
            Log.j("SsaStyle", sb.toString(), ex);
            return null;
        }
    }
    
    private static boolean c(final int n) {
        switch (n) {
            default: {
                return false;
            }
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9: {
                return true;
            }
        }
    }
    
    private static boolean d(final int n) {
        return n == 1 || n == 3;
    }
    
    private static int e(final String s) {
        while (true) {
            try {
                final int int1 = Integer.parseInt(s.trim());
                if (c(int1)) {
                    return int1;
                }
                final StringBuilder sb = new StringBuilder();
                sb.append("Ignoring unknown alignment: ");
                sb.append(s);
                Log.i("SsaStyle", sb.toString());
                return -1;
            }
            catch (final NumberFormatException ex) {
                continue;
            }
            break;
        }
    }
    
    private static boolean f(final String s) {
        boolean b = false;
        try {
            final int int1 = Integer.parseInt(s);
            if (int1 == 1 || int1 == -1) {
                b = true;
            }
            return b;
        }
        catch (final NumberFormatException ex) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Failed to parse boolean value: '");
            sb.append(s);
            sb.append("'");
            Log.j("SsaStyle", sb.toString(), ex);
            return false;
        }
    }
    
    private static int g(final String s) {
        while (true) {
            try {
                final int int1 = Integer.parseInt(s.trim());
                if (d(int1)) {
                    return int1;
                }
                final StringBuilder sb = new StringBuilder();
                sb.append("Ignoring unknown BorderStyle: ");
                sb.append(s);
                Log.i("SsaStyle", sb.toString());
                return -1;
            }
            catch (final NumberFormatException ex) {
                continue;
            }
            break;
        }
    }
    
    public static Integer h(final String s) {
        try {
            long n;
            if (s.startsWith("&H")) {
                n = Long.parseLong(s.substring(2), 16);
            }
            else {
                n = Long.parseLong(s);
            }
            Assertions.a(n <= 4294967295L);
            return Color.argb(Ints.d((n >> 24 & 0xFFL) ^ 0xFFL), Ints.d(n & 0xFFL), Ints.d(n >> 8 & 0xFFL), Ints.d(n >> 16 & 0xFFL));
        }
        catch (final IllegalArgumentException ex) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Failed to parse color expression: '");
            sb.append(s);
            sb.append("'");
            Log.j("SsaStyle", sb.toString(), ex);
            return null;
        }
    }
    
    private static float i(final String s) {
        try {
            return Float.parseFloat(s);
        }
        catch (final NumberFormatException ex) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Failed to parse font size: '");
            sb.append(s);
            sb.append("'");
            Log.j("SsaStyle", sb.toString(), ex);
            return -3.4028235E38f;
        }
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.TYPE_USE })
    public @interface SsaAlignment {
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.TYPE_USE })
    public @interface SsaBorderStyle {
    }
    
    static final class a
    {
        public final int a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;
        public final int h;
        public final int i;
        public final int j;
        public final int k;
        
        private a(final int a, final int b, final int c, final int d, final int e, final int f, final int g, final int h, final int i, final int j, final int k) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
            this.f = f;
            this.g = g;
            this.h = h;
            this.i = i;
            this.j = j;
            this.k = k;
        }
        
        public static a a(final String s) {
            final String[] split = TextUtils.split(s.substring(7), ",");
            final int n = 0;
            int n2 = -1;
            int n3 = -1;
            final int n5;
            final int n4 = n5 = n3;
            int n7;
            int n6 = n7 = n5;
            int n9;
            int n8 = n9 = n7;
            int n11;
            int n10 = n11 = n9;
            int n12 = n5;
            int n13 = n4;
            for (int i = n; i < split.length; ++i) {
                final String e = Ascii.e(split[i].trim());
                e.hashCode();
                int n14 = 0;
                Label_0362: {
                    switch (e) {
                        case "outlinecolour": {
                            n14 = 9;
                            break Label_0362;
                        }
                        case "alignment": {
                            n14 = 8;
                            break Label_0362;
                        }
                        case "borderstyle": {
                            n14 = 7;
                            break Label_0362;
                        }
                        case "fontsize": {
                            n14 = 6;
                            break Label_0362;
                        }
                        case "name": {
                            n14 = 5;
                            break Label_0362;
                        }
                        case "bold": {
                            n14 = 4;
                            break Label_0362;
                        }
                        case "primarycolour": {
                            n14 = 3;
                            break Label_0362;
                        }
                        case "strikeout": {
                            n14 = 2;
                            break Label_0362;
                        }
                        case "underline": {
                            n14 = 1;
                            break Label_0362;
                        }
                        case "italic": {
                            n14 = 0;
                            break Label_0362;
                        }
                        default:
                            break;
                    }
                    n14 = -1;
                }
                switch (n14) {
                    case 9: {
                        n12 = i;
                        break;
                    }
                    case 8: {
                        n3 = i;
                        break;
                    }
                    case 7: {
                        n11 = i;
                        break;
                    }
                    case 6: {
                        n6 = i;
                        break;
                    }
                    case 5: {
                        n2 = i;
                        break;
                    }
                    case 4: {
                        n7 = i;
                        break;
                    }
                    case 3: {
                        n13 = i;
                        break;
                    }
                    case 2: {
                        n10 = i;
                        break;
                    }
                    case 1: {
                        n9 = i;
                        break;
                    }
                    case 0: {
                        n8 = i;
                        break;
                    }
                }
            }
            a a;
            if (n2 != -1) {
                a = new a(n2, n3, n13, n12, n6, n7, n8, n9, n10, n11, split.length);
            }
            else {
                a = null;
            }
            return a;
        }
    }
    
    static final class b
    {
        private static final Pattern c;
        private static final Pattern d;
        private static final Pattern e;
        private static final Pattern f;
        public final int a;
        public final PointF b;
        
        static {
            c = Pattern.compile("\\{([^}]*)\\}");
            d = Pattern.compile(Util.C("\\\\pos\\((%1$s),(%1$s)\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));
            e = Pattern.compile(Util.C("\\\\move\\(%1$s,%1$s,(%1$s),(%1$s)(?:,%1$s,%1$s)?\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));
            f = Pattern.compile("\\\\an(\\d+)");
        }
        
        private b(final int a, final PointF b) {
            this.a = a;
            this.b = b;
        }
        
        private static int a(final String s) {
            final Matcher matcher = b.f.matcher(s);
            int a;
            if (matcher.find()) {
                a = SsaStyle.a(Assertions.e(matcher.group(1)));
            }
            else {
                a = -1;
            }
            return a;
        }
        
        public static b b(final String p0) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     3: aload_0        
            //     4: invokevirtual   java/util/regex/Pattern.matcher:(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
            //     7: astore          5
            //     9: aconst_null    
            //    10: astore_0       
            //    11: iconst_m1      
            //    12: istore_1       
            //    13: aload           5
            //    15: invokevirtual   java/util/regex/Matcher.find:()Z
            //    18: ifeq            72
            //    21: aload           5
            //    23: iconst_1       
            //    24: invokevirtual   java/util/regex/Matcher.group:(I)Ljava/lang/String;
            //    27: invokestatic    com/google/android/exoplayer2/util/Assertions.e:(Ljava/lang/Object;)Ljava/lang/Object;
            //    30: checkcast       Ljava/lang/String;
            //    33: astore          6
            //    35: aload           6
            //    37: invokestatic    com/google/android/exoplayer2/text/ssa/SsaStyle$b.c:(Ljava/lang/String;)Landroid/graphics/PointF;
            //    40: astore          4
            //    42: aload_0        
            //    43: astore_3       
            //    44: aload           4
            //    46: ifnull          52
            //    49: aload           4
            //    51: astore_3       
            //    52: aload           6
            //    54: invokestatic    com/google/android/exoplayer2/text/ssa/SsaStyle$b.a:(Ljava/lang/String;)I
            //    57: istore_2       
            //    58: aload_3        
            //    59: astore_0       
            //    60: iload_2        
            //    61: iconst_m1      
            //    62: if_icmpeq       13
            //    65: iload_2        
            //    66: istore_1       
            //    67: aload_3        
            //    68: astore_0       
            //    69: goto            13
            //    72: new             Lcom/google/android/exoplayer2/text/ssa/SsaStyle$b;
            //    75: dup            
            //    76: iload_1        
            //    77: aload_0        
            //    78: invokespecial   com/google/android/exoplayer2/text/ssa/SsaStyle$b.<init>:(ILandroid/graphics/PointF;)V
            //    81: areturn        
            //    82: astore_3       
            //    83: aload_0        
            //    84: astore_3       
            //    85: goto            52
            //    88: astore_0       
            //    89: aload_3        
            //    90: astore_0       
            //    91: goto            13
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                        
            //  -----  -----  -----  -----  ----------------------------
            //  35     42     82     88     Ljava/lang/RuntimeException;
            //  52     58     88     94     Ljava/lang/RuntimeException;
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0052:
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
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:662)
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
        
        private static PointF c(String s) {
            final Matcher matcher = b.d.matcher(s);
            final Matcher matcher2 = b.e.matcher(s);
            final boolean find = matcher.find();
            final boolean find2 = matcher2.find();
            String s2;
            if (find) {
                if (find2) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Override has both \\pos(x,y) and \\move(x1,y1,x2,y2); using \\pos values. override='");
                    sb.append(s);
                    sb.append("'");
                    Log.f("SsaStyle.Overrides", sb.toString());
                }
                s2 = matcher.group(1);
                s = matcher.group(2);
            }
            else {
                if (!find2) {
                    return null;
                }
                s2 = matcher2.group(1);
                s = matcher2.group(2);
            }
            return new PointF(Float.parseFloat(Assertions.e(s2).trim()), Float.parseFloat(Assertions.e(s).trim()));
        }
        
        public static String d(final String s) {
            return b.c.matcher(s).replaceAll("");
        }
    }
}
