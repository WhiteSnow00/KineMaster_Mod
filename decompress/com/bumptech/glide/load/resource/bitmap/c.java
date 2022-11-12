// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.engine.s;
import java.io.File;
import com.bumptech.glide.load.EncodeStrategy;
import c2.e;
import e2.b;
import android.graphics.Bitmap$CompressFormat;
import c2.d;
import android.graphics.Bitmap;
import c2.g;

public class c implements g<Bitmap>
{
    public static final d<Integer> b;
    public static final d<Bitmap$CompressFormat> c;
    private final b a;
    
    static {
        b = d.f("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);
        c = d.e("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");
    }
    
    public c(final b a) {
        this.a = a;
    }
    
    private Bitmap$CompressFormat d(final Bitmap bitmap, final e e) {
        final Bitmap$CompressFormat bitmap$CompressFormat = e.c(com.bumptech.glide.load.resource.bitmap.c.c);
        if (bitmap$CompressFormat != null) {
            return bitmap$CompressFormat;
        }
        if (bitmap.hasAlpha()) {
            return Bitmap$CompressFormat.PNG;
        }
        return Bitmap$CompressFormat.JPEG;
    }
    
    @Override
    public EncodeStrategy a(final e e) {
        return EncodeStrategy.TRANSFORMED;
    }
    
    @Override
    public /* bridge */ boolean b(final Object o, final File file, final e e) {
        return this.c((s<Bitmap>)o, file, e);
    }
    
    public boolean c(final s<Bitmap> p0, final File p1, final e p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokeinterface com/bumptech/glide/load/engine/s.get:()Ljava/lang/Object;
        //     6: checkcast       Landroid/graphics/Bitmap;
        //     9: astore          14
        //    11: aload_0        
        //    12: aload           14
        //    14: aload_3        
        //    15: invokespecial   com/bumptech/glide/load/resource/bitmap/c.d:(Landroid/graphics/Bitmap;Lc2/e;)Landroid/graphics/Bitmap$CompressFormat;
        //    18: astore          13
        //    20: ldc             "encode: [%dx%d] %s"
        //    22: aload           14
        //    24: invokevirtual   android/graphics/Bitmap.getWidth:()I
        //    27: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    30: aload           14
        //    32: invokevirtual   android/graphics/Bitmap.getHeight:()I
        //    35: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    38: aload           13
        //    40: invokestatic    w2/b.d:(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
        //    43: invokestatic    v2/g.b:()J
        //    46: lstore          5
        //    48: aload_3        
        //    49: getstatic       com/bumptech/glide/load/resource/bitmap/c.b:Lc2/d;
        //    52: invokevirtual   c2/e.c:(Lc2/d;)Ljava/lang/Object;
        //    55: checkcast       Ljava/lang/Integer;
        //    58: invokevirtual   java/lang/Integer.intValue:()I
        //    61: istore          4
        //    63: iconst_0       
        //    64: istore          7
        //    66: iconst_0       
        //    67: istore          8
        //    69: aconst_null    
        //    70: astore          11
        //    72: aconst_null    
        //    73: astore          12
        //    75: aload           12
        //    77: astore          9
        //    79: aload           11
        //    81: astore          10
        //    83: new             Ljava/io/FileOutputStream;
        //    86: astore_1       
        //    87: aload           12
        //    89: astore          9
        //    91: aload           11
        //    93: astore          10
        //    95: aload_1        
        //    96: aload_2        
        //    97: invokespecial   java/io/FileOutputStream.<init>:(Ljava/io/File;)V
        //   100: aload_0        
        //   101: getfield        com/bumptech/glide/load/resource/bitmap/c.a:Le2/b;
        //   104: ifnull          125
        //   107: new             Lcom/bumptech/glide/load/data/c;
        //   110: astore_2       
        //   111: aload_2        
        //   112: aload_1        
        //   113: aload_0        
        //   114: getfield        com/bumptech/glide/load/resource/bitmap/c.a:Le2/b;
        //   117: invokespecial   com/bumptech/glide/load/data/c.<init>:(Ljava/io/OutputStream;Le2/b;)V
        //   120: aload_2        
        //   121: astore_1       
        //   122: goto            125
        //   125: aload_1        
        //   126: astore          9
        //   128: aload_1        
        //   129: astore          10
        //   131: aload           14
        //   133: aload           13
        //   135: iload           4
        //   137: aload_1        
        //   138: invokevirtual   android/graphics/Bitmap.compress:(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
        //   141: pop            
        //   142: aload_1        
        //   143: astore          9
        //   145: aload_1        
        //   146: astore          10
        //   148: aload_1        
        //   149: invokevirtual   java/io/OutputStream.close:()V
        //   152: iconst_1       
        //   153: istore          7
        //   155: aload_1        
        //   156: invokevirtual   java/io/OutputStream.close:()V
        //   159: goto            218
        //   162: astore_2       
        //   163: aload_1        
        //   164: astore          9
        //   166: aload_2        
        //   167: astore_1       
        //   168: goto            335
        //   171: astore_2       
        //   172: goto            183
        //   175: astore_1       
        //   176: goto            335
        //   179: astore_2       
        //   180: aload           10
        //   182: astore_1       
        //   183: aload_1        
        //   184: astore          9
        //   186: ldc             "BitmapEncoder"
        //   188: iconst_3       
        //   189: invokestatic    android/util/Log.isLoggable:(Ljava/lang/String;I)Z
        //   192: ifeq            207
        //   195: aload_1        
        //   196: astore          9
        //   198: ldc             "BitmapEncoder"
        //   200: ldc             "Failed to encode Bitmap"
        //   202: aload_2        
        //   203: invokestatic    android/util/Log.d:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   206: pop            
        //   207: aload_1        
        //   208: ifnull          218
        //   211: iload           8
        //   213: istore          7
        //   215: goto            155
        //   218: ldc             "BitmapEncoder"
        //   220: iconst_2       
        //   221: invokestatic    android/util/Log.isLoggable:(Ljava/lang/String;I)Z
        //   224: ifeq            329
        //   227: new             Ljava/lang/StringBuilder;
        //   230: astore_1       
        //   231: aload_1        
        //   232: invokespecial   java/lang/StringBuilder.<init>:()V
        //   235: aload_1        
        //   236: ldc             "Compressed with type: "
        //   238: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   241: pop            
        //   242: aload_1        
        //   243: aload           13
        //   245: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   248: pop            
        //   249: aload_1        
        //   250: ldc             " of size "
        //   252: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   255: pop            
        //   256: aload_1        
        //   257: aload           14
        //   259: invokestatic    v2/l.h:(Landroid/graphics/Bitmap;)I
        //   262: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   265: pop            
        //   266: aload_1        
        //   267: ldc             " in "
        //   269: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   272: pop            
        //   273: aload_1        
        //   274: lload           5
        //   276: invokestatic    v2/g.a:(J)D
        //   279: invokevirtual   java/lang/StringBuilder.append:(D)Ljava/lang/StringBuilder;
        //   282: pop            
        //   283: aload_1        
        //   284: ldc             ", options format: "
        //   286: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   289: pop            
        //   290: aload_1        
        //   291: aload_3        
        //   292: getstatic       com/bumptech/glide/load/resource/bitmap/c.c:Lc2/d;
        //   295: invokevirtual   c2/e.c:(Lc2/d;)Ljava/lang/Object;
        //   298: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   301: pop            
        //   302: aload_1        
        //   303: ldc             ", hasAlpha: "
        //   305: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   308: pop            
        //   309: aload_1        
        //   310: aload           14
        //   312: invokevirtual   android/graphics/Bitmap.hasAlpha:()Z
        //   315: invokevirtual   java/lang/StringBuilder.append:(Z)Ljava/lang/StringBuilder;
        //   318: pop            
        //   319: ldc             "BitmapEncoder"
        //   321: aload_1        
        //   322: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   325: invokestatic    android/util/Log.v:(Ljava/lang/String;Ljava/lang/String;)I
        //   328: pop            
        //   329: invokestatic    w2/b.e:()V
        //   332: iload           7
        //   334: ireturn        
        //   335: aload           9
        //   337: ifnull          345
        //   340: aload           9
        //   342: invokevirtual   java/io/OutputStream.close:()V
        //   345: aload_1        
        //   346: athrow         
        //   347: astore_1       
        //   348: invokestatic    w2/b.e:()V
        //   351: aload_1        
        //   352: athrow         
        //   353: astore_1       
        //   354: goto            218
        //   357: astore_2       
        //   358: goto            345
        //    Signature:
        //  (Lcom/bumptech/glide/load/engine/s<Landroid/graphics/Bitmap;>;Ljava/io/File;Lc2/e;)Z
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  43     63     347    353    Any
        //  83     87     179    183    Ljava/io/IOException;
        //  83     87     175    179    Any
        //  95     100    179    183    Ljava/io/IOException;
        //  95     100    175    179    Any
        //  100    120    171    175    Ljava/io/IOException;
        //  100    120    162    171    Any
        //  131    142    179    183    Ljava/io/IOException;
        //  131    142    175    179    Any
        //  148    152    179    183    Ljava/io/IOException;
        //  148    152    175    179    Any
        //  155    159    353    357    Ljava/io/IOException;
        //  155    159    347    353    Any
        //  186    195    175    179    Any
        //  198    207    175    179    Any
        //  218    329    347    353    Any
        //  340    345    357    361    Ljava/io/IOException;
        //  340    345    347    353    Any
        //  345    347    347    353    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 187, Size: 187
        //     at java.util.ArrayList.rangeCheck(Unknown Source)
        //     at java.util.ArrayList.get(Unknown Source)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3362)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:112)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:203)
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
}
