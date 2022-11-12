// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.graphics;

import android.graphics.Typeface$CustomFallbackBuilder;
import android.graphics.fonts.FontFamily$Builder;
import android.graphics.fonts.Font$Builder;
import androidx.core.provider.g;
import android.os.CancellationSignal;
import android.graphics.Typeface;
import android.content.res.Resources;
import androidx.core.content.res.d;
import android.content.Context;
import android.graphics.fonts.FontStyle;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;

public class l extends m
{
    private Font f(final FontFamily fontFamily, int i) {
        int n;
        if ((i & 0x1) != 0x0) {
            n = 700;
        }
        else {
            n = 400;
        }
        final int n2 = 1;
        if ((i & 0x2) != 0x0) {
            i = 1;
        }
        else {
            i = 0;
        }
        final FontStyle fontStyle = new FontStyle(n, i);
        Font font = fontFamily.getFont(0);
        final int g = g(fontStyle, font.getStyle());
        i = n2;
        int n3 = g;
        while (i < fontFamily.getSize()) {
            final Font font2 = fontFamily.getFont(i);
            final int g2 = g(fontStyle, font2.getStyle());
            int n4;
            if (g2 < (n4 = n3)) {
                font = font2;
                n4 = g2;
            }
            ++i;
            n3 = n4;
        }
        return font;
    }
    
    private static int g(final FontStyle fontStyle, final FontStyle fontStyle2) {
        final int n = Math.abs(fontStyle.getWeight() - fontStyle2.getWeight()) / 100;
        int n2;
        if (fontStyle.getSlant() == fontStyle2.getSlant()) {
            n2 = 0;
        }
        else {
            n2 = 2;
        }
        return n + n2;
    }
    
    @Override
    public Typeface a(final Context p0, final d.c p1, final Resources p2, final int p3) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore          8
        //     3: aload_2        
        //     4: invokevirtual   androidx/core/content/res/d$c.a:()[Landroidx/core/content/res/d$d;
        //     7: astore          9
        //     9: aload           9
        //    11: arraylength    
        //    12: istore          7
        //    14: aconst_null    
        //    15: astore_1       
        //    16: iconst_0       
        //    17: istore          5
        //    19: iload           5
        //    21: iload           7
        //    23: if_icmpge       132
        //    26: aload           9
        //    28: iload           5
        //    30: aaload         
        //    31: astore_2       
        //    32: new             Landroid/graphics/fonts/Font$Builder;
        //    35: astore          10
        //    37: aload           10
        //    39: aload_3        
        //    40: aload_2        
        //    41: invokevirtual   androidx/core/content/res/d$d.b:()I
        //    44: invokespecial   android/graphics/fonts/Font$Builder.<init>:(Landroid/content/res/Resources;I)V
        //    47: aload           10
        //    49: aload_2        
        //    50: invokevirtual   androidx/core/content/res/d$d.e:()I
        //    53: invokevirtual   android/graphics/fonts/Font$Builder.setWeight:(I)Landroid/graphics/fonts/Font$Builder;
        //    56: astore          10
        //    58: aload_2        
        //    59: invokevirtual   androidx/core/content/res/d$d.f:()Z
        //    62: ifeq            71
        //    65: iconst_1       
        //    66: istore          6
        //    68: goto            74
        //    71: iconst_0       
        //    72: istore          6
        //    74: aload           10
        //    76: iload           6
        //    78: invokevirtual   android/graphics/fonts/Font$Builder.setSlant:(I)Landroid/graphics/fonts/Font$Builder;
        //    81: aload_2        
        //    82: invokevirtual   androidx/core/content/res/d$d.c:()I
        //    85: invokevirtual   android/graphics/fonts/Font$Builder.setTtcIndex:(I)Landroid/graphics/fonts/Font$Builder;
        //    88: aload_2        
        //    89: invokevirtual   androidx/core/content/res/d$d.d:()Ljava/lang/String;
        //    92: invokevirtual   android/graphics/fonts/Font$Builder.setFontVariationSettings:(Ljava/lang/String;)Landroid/graphics/fonts/Font$Builder;
        //    95: invokevirtual   android/graphics/fonts/Font$Builder.build:()Landroid/graphics/fonts/Font;
        //    98: astore          10
        //   100: aload_1        
        //   101: ifnonnull       119
        //   104: new             Landroid/graphics/fonts/FontFamily$Builder;
        //   107: astore_2       
        //   108: aload_2        
        //   109: aload           10
        //   111: invokespecial   android/graphics/fonts/FontFamily$Builder.<init>:(Landroid/graphics/fonts/Font;)V
        //   114: aload_2        
        //   115: astore_1       
        //   116: goto            126
        //   119: aload_1        
        //   120: aload           10
        //   122: invokevirtual   android/graphics/fonts/FontFamily$Builder.addFont:(Landroid/graphics/fonts/Font;)Landroid/graphics/fonts/FontFamily$Builder;
        //   125: pop            
        //   126: iinc            5, 1
        //   129: goto            19
        //   132: aload_1        
        //   133: ifnonnull       138
        //   136: aconst_null    
        //   137: areturn        
        //   138: aload_1        
        //   139: invokevirtual   android/graphics/fonts/FontFamily$Builder.build:()Landroid/graphics/fonts/FontFamily;
        //   142: astore_1       
        //   143: new             Landroid/graphics/Typeface$CustomFallbackBuilder;
        //   146: astore_2       
        //   147: aload_2        
        //   148: aload_1        
        //   149: invokespecial   android/graphics/Typeface$CustomFallbackBuilder.<init>:(Landroid/graphics/fonts/FontFamily;)V
        //   152: aload_2        
        //   153: aload_0        
        //   154: aload_1        
        //   155: iload           4
        //   157: invokespecial   androidx/core/graphics/l.f:(Landroid/graphics/fonts/FontFamily;I)Landroid/graphics/fonts/Font;
        //   160: invokevirtual   android/graphics/fonts/Font.getStyle:()Landroid/graphics/fonts/FontStyle;
        //   163: invokevirtual   android/graphics/Typeface$CustomFallbackBuilder.setStyle:(Landroid/graphics/fonts/FontStyle;)Landroid/graphics/Typeface$CustomFallbackBuilder;
        //   166: invokevirtual   android/graphics/Typeface$CustomFallbackBuilder.build:()Landroid/graphics/Typeface;
        //   169: astore_1       
        //   170: aload_1        
        //   171: areturn        
        //   172: astore_1       
        //   173: aload           8
        //   175: astore_1       
        //   176: goto            170
        //   179: astore_2       
        //   180: goto            126
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  3      14     172    179    Ljava/lang/Exception;
        //  32     65     179    183    Ljava/io/IOException;
        //  32     65     172    179    Ljava/lang/Exception;
        //  74     100    179    183    Ljava/io/IOException;
        //  74     100    172    179    Ljava/lang/Exception;
        //  104    114    179    183    Ljava/io/IOException;
        //  104    114    172    179    Ljava/lang/Exception;
        //  119    126    179    183    Ljava/io/IOException;
        //  119    126    172    179    Ljava/lang/Exception;
        //  138    170    172    179    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0071:
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
    
    @Override
    public Typeface b(final Context p0, final CancellationSignal p1, final g.b[] p2, final int p3) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   android/content/Context.getContentResolver:()Landroid/content/ContentResolver;
        //     4: astore          9
        //     6: aload_3        
        //     7: arraylength    
        //     8: istore          7
        //    10: aconst_null    
        //    11: astore_1       
        //    12: iconst_0       
        //    13: istore          5
        //    15: iload           5
        //    17: iload           7
        //    19: if_icmpge       202
        //    22: aload_3        
        //    23: iload           5
        //    25: aaload         
        //    26: astore          11
        //    28: aload_1        
        //    29: astore          8
        //    31: aload           9
        //    33: aload           11
        //    35: invokevirtual   androidx/core/provider/g$b.d:()Landroid/net/Uri;
        //    38: ldc             "r"
        //    40: aload_2        
        //    41: invokevirtual   android/content/ContentResolver.openFileDescriptor:(Landroid/net/Uri;Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/os/ParcelFileDescriptor;
        //    44: astore          10
        //    46: aload           10
        //    48: ifnonnull       73
        //    51: aload_1        
        //    52: astore          8
        //    54: aload           10
        //    56: ifnull          193
        //    59: aload_1        
        //    60: astore          8
        //    62: aload           10
        //    64: invokevirtual   android/os/ParcelFileDescriptor.close:()V
        //    67: aload_1        
        //    68: astore          8
        //    70: goto            193
        //    73: new             Landroid/graphics/fonts/Font$Builder;
        //    76: astore          8
        //    78: aload           8
        //    80: aload           10
        //    82: invokespecial   android/graphics/fonts/Font$Builder.<init>:(Landroid/os/ParcelFileDescriptor;)V
        //    85: aload           8
        //    87: aload           11
        //    89: invokevirtual   androidx/core/provider/g$b.e:()I
        //    92: invokevirtual   android/graphics/fonts/Font$Builder.setWeight:(I)Landroid/graphics/fonts/Font$Builder;
        //    95: astore          8
        //    97: aload           11
        //    99: invokevirtual   androidx/core/provider/g$b.f:()Z
        //   102: ifeq            111
        //   105: iconst_1       
        //   106: istore          6
        //   108: goto            114
        //   111: iconst_0       
        //   112: istore          6
        //   114: aload           8
        //   116: iload           6
        //   118: invokevirtual   android/graphics/fonts/Font$Builder.setSlant:(I)Landroid/graphics/fonts/Font$Builder;
        //   121: aload           11
        //   123: invokevirtual   androidx/core/provider/g$b.c:()I
        //   126: invokevirtual   android/graphics/fonts/Font$Builder.setTtcIndex:(I)Landroid/graphics/fonts/Font$Builder;
        //   129: invokevirtual   android/graphics/fonts/Font$Builder.build:()Landroid/graphics/fonts/Font;
        //   132: astore          8
        //   134: aload_1        
        //   135: ifnonnull       155
        //   138: new             Landroid/graphics/fonts/FontFamily$Builder;
        //   141: dup            
        //   142: aload           8
        //   144: invokespecial   android/graphics/fonts/FontFamily$Builder.<init>:(Landroid/graphics/fonts/Font;)V
        //   147: astore          8
        //   149: aload           8
        //   151: astore_1       
        //   152: goto            59
        //   155: aload_1        
        //   156: aload           8
        //   158: invokevirtual   android/graphics/fonts/FontFamily$Builder.addFont:(Landroid/graphics/fonts/Font;)Landroid/graphics/fonts/FontFamily$Builder;
        //   161: pop            
        //   162: goto            59
        //   165: astore          11
        //   167: aload           10
        //   169: invokevirtual   android/os/ParcelFileDescriptor.close:()V
        //   172: goto            187
        //   175: astore          10
        //   177: aload_1        
        //   178: astore          8
        //   180: aload           11
        //   182: aload           10
        //   184: invokevirtual   java/lang/Throwable.addSuppressed:(Ljava/lang/Throwable;)V
        //   187: aload_1        
        //   188: astore          8
        //   190: aload           11
        //   192: athrow         
        //   193: iinc            5, 1
        //   196: aload           8
        //   198: astore_1       
        //   199: goto            15
        //   202: aload_1        
        //   203: ifnonnull       208
        //   206: aconst_null    
        //   207: areturn        
        //   208: aload_1        
        //   209: invokevirtual   android/graphics/fonts/FontFamily$Builder.build:()Landroid/graphics/fonts/FontFamily;
        //   212: astore_1       
        //   213: new             Landroid/graphics/Typeface$CustomFallbackBuilder;
        //   216: astore_2       
        //   217: aload_2        
        //   218: aload_1        
        //   219: invokespecial   android/graphics/Typeface$CustomFallbackBuilder.<init>:(Landroid/graphics/fonts/FontFamily;)V
        //   222: aload_2        
        //   223: aload_0        
        //   224: aload_1        
        //   225: iload           4
        //   227: invokespecial   androidx/core/graphics/l.f:(Landroid/graphics/fonts/FontFamily;I)Landroid/graphics/fonts/Font;
        //   230: invokevirtual   android/graphics/fonts/Font.getStyle:()Landroid/graphics/fonts/FontStyle;
        //   233: invokevirtual   android/graphics/Typeface$CustomFallbackBuilder.setStyle:(Landroid/graphics/fonts/FontStyle;)Landroid/graphics/Typeface$CustomFallbackBuilder;
        //   236: invokevirtual   android/graphics/Typeface$CustomFallbackBuilder.build:()Landroid/graphics/Typeface;
        //   239: astore_1       
        //   240: aload_1        
        //   241: areturn        
        //   242: astore_1       
        //   243: aconst_null    
        //   244: areturn        
        //   245: astore_1       
        //   246: goto            193
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  6      10     242    245    Ljava/lang/Exception;
        //  31     46     245    249    Ljava/io/IOException;
        //  31     46     242    245    Ljava/lang/Exception;
        //  62     67     245    249    Ljava/io/IOException;
        //  62     67     242    245    Ljava/lang/Exception;
        //  73     105    165    193    Any
        //  114    134    165    193    Any
        //  138    149    165    193    Any
        //  155    162    165    193    Any
        //  167    172    175    187    Any
        //  180    187    245    249    Ljava/io/IOException;
        //  180    187    242    245    Ljava/lang/Exception;
        //  190    193    245    249    Ljava/io/IOException;
        //  190    193    242    245    Ljava/lang/Exception;
        //  208    240    242    245    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0059:
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
    
    @Override
    public Typeface c(final Context context, final Resources resources, final int n, final String s, final int n2) {
        try {
            final Font build = new Font$Builder(resources, n).build();
            return new Typeface$CustomFallbackBuilder(new FontFamily$Builder(build).build()).setStyle(build.getStyle()).build();
        }
        catch (final Exception ex) {
            return null;
        }
    }
    
    @Override
    protected g.b e(final g.b[] array, final int n) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }
}
