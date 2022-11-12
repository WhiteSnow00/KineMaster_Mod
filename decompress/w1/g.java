// 
// Decompiled by Procyon v0.6.0
// 

package w1;

import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;
import com.airbnb.lottie.l;
import android.util.Pair;
import java.util.zip.ZipInputStream;
import java.io.InputStream;
import com.airbnb.lottie.network.FileExtension;
import com.airbnb.lottie.d;

public class g
{
    private final f a;
    private final e b;
    
    public g(final f a, final e b) {
        this.a = a;
        this.b = b;
    }
    
    private d a(final String s, final String s2) {
        if (s2 == null) {
            return null;
        }
        final Pair<FileExtension, InputStream> a = this.a.a(s);
        if (a == null) {
            return null;
        }
        final FileExtension fileExtension = (FileExtension)a.first;
        final InputStream inputStream = (InputStream)a.second;
        l<d> l;
        if (fileExtension == FileExtension.ZIP) {
            l = com.airbnb.lottie.e.s(new ZipInputStream(inputStream), s);
        }
        else {
            l = com.airbnb.lottie.e.i(inputStream, s);
        }
        if (l.b() != null) {
            return l.b();
        }
        return null;
    }
    
    private l<d> b(final String p0, final String p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: invokespecial   java/lang/StringBuilder.<init>:()V
        //     7: astore          4
        //     9: aload           4
        //    11: ldc             "Fetching "
        //    13: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    16: pop            
        //    17: aload           4
        //    19: aload_1        
        //    20: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    23: pop            
        //    24: aload           4
        //    26: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    29: invokestatic    y1/d.a:(Ljava/lang/String;)V
        //    32: aconst_null    
        //    33: astore          5
        //    35: aconst_null    
        //    36: astore          4
        //    38: aload_0        
        //    39: getfield        w1/g.b:Lw1/e;
        //    42: aload_1        
        //    43: invokeinterface w1/e.a:(Ljava/lang/String;)Lw1/c;
        //    48: astore          6
        //    50: aload           6
        //    52: astore          4
        //    54: aload           6
        //    56: astore          5
        //    58: aload           6
        //    60: invokeinterface w1/c.k0:()Z
        //    65: ifeq            206
        //    68: aload           6
        //    70: astore          4
        //    72: aload           6
        //    74: astore          5
        //    76: aload_0        
        //    77: aload_1        
        //    78: aload           6
        //    80: invokeinterface w1/c.b0:()Ljava/io/InputStream;
        //    85: aload           6
        //    87: invokeinterface w1/c.X:()Ljava/lang/String;
        //    92: aload_2        
        //    93: invokespecial   w1/g.d:(Ljava/lang/String;Ljava/io/InputStream;Ljava/lang/String;Ljava/lang/String;)Lcom/airbnb/lottie/l;
        //    96: astore_1       
        //    97: aload           6
        //    99: astore          4
        //   101: aload           6
        //   103: astore          5
        //   105: new             Ljava/lang/StringBuilder;
        //   108: astore_2       
        //   109: aload           6
        //   111: astore          4
        //   113: aload           6
        //   115: astore          5
        //   117: aload_2        
        //   118: invokespecial   java/lang/StringBuilder.<init>:()V
        //   121: aload           6
        //   123: astore          4
        //   125: aload           6
        //   127: astore          5
        //   129: aload_2        
        //   130: ldc             "Completed fetch from network. Success: "
        //   132: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   135: pop            
        //   136: aload           6
        //   138: astore          4
        //   140: aload           6
        //   142: astore          5
        //   144: aload_1        
        //   145: invokevirtual   com/airbnb/lottie/l.b:()Ljava/lang/Object;
        //   148: ifnull          156
        //   151: iconst_1       
        //   152: istore_3       
        //   153: goto            158
        //   156: iconst_0       
        //   157: istore_3       
        //   158: aload           6
        //   160: astore          4
        //   162: aload           6
        //   164: astore          5
        //   166: aload_2        
        //   167: iload_3        
        //   168: invokevirtual   java/lang/StringBuilder.append:(Z)Ljava/lang/StringBuilder;
        //   171: pop            
        //   172: aload           6
        //   174: astore          4
        //   176: aload           6
        //   178: astore          5
        //   180: aload_2        
        //   181: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   184: invokestatic    y1/d.a:(Ljava/lang/String;)V
        //   187: aload           6
        //   189: invokeinterface java/io/Closeable.close:()V
        //   194: goto            204
        //   197: astore_2       
        //   198: ldc             "LottieFetchResult close failed "
        //   200: aload_2        
        //   201: invokestatic    y1/d.d:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   204: aload_1        
        //   205: areturn        
        //   206: aload           6
        //   208: astore          4
        //   210: aload           6
        //   212: astore          5
        //   214: new             Ljava/lang/IllegalArgumentException;
        //   217: astore_1       
        //   218: aload           6
        //   220: astore          4
        //   222: aload           6
        //   224: astore          5
        //   226: aload_1        
        //   227: aload           6
        //   229: invokeinterface w1/c.X0:()Ljava/lang/String;
        //   234: invokespecial   java/lang/IllegalArgumentException.<init>:(Ljava/lang/String;)V
        //   237: aload           6
        //   239: astore          4
        //   241: aload           6
        //   243: astore          5
        //   245: new             Lcom/airbnb/lottie/l;
        //   248: dup            
        //   249: aload_1        
        //   250: invokespecial   com/airbnb/lottie/l.<init>:(Ljava/lang/Throwable;)V
        //   253: astore_1       
        //   254: aload           6
        //   256: invokeinterface java/io/Closeable.close:()V
        //   261: goto            271
        //   264: astore_2       
        //   265: ldc             "LottieFetchResult close failed "
        //   267: aload_2        
        //   268: invokestatic    y1/d.d:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   271: aload_1        
        //   272: areturn        
        //   273: astore_1       
        //   274: goto            315
        //   277: astore_1       
        //   278: aload           5
        //   280: astore          4
        //   282: new             Lcom/airbnb/lottie/l;
        //   285: dup            
        //   286: aload_1        
        //   287: invokespecial   com/airbnb/lottie/l.<init>:(Ljava/lang/Throwable;)V
        //   290: astore_1       
        //   291: aload           5
        //   293: ifnull          313
        //   296: aload           5
        //   298: invokeinterface java/io/Closeable.close:()V
        //   303: goto            313
        //   306: astore_2       
        //   307: ldc             "LottieFetchResult close failed "
        //   309: aload_2        
        //   310: invokestatic    y1/d.d:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   313: aload_1        
        //   314: areturn        
        //   315: aload           4
        //   317: ifnull          337
        //   320: aload           4
        //   322: invokeinterface java/io/Closeable.close:()V
        //   327: goto            337
        //   330: astore_2       
        //   331: ldc             "LottieFetchResult close failed "
        //   333: aload_2        
        //   334: invokestatic    y1/d.d:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   337: aload_1        
        //   338: athrow         
        //    Signature:
        //  (Ljava/lang/String;Ljava/lang/String;)Lcom/airbnb/lottie/l<Lcom/airbnb/lottie/d;>;
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  38     50     277    315    Ljava/lang/Exception;
        //  38     50     273    339    Any
        //  58     68     277    315    Ljava/lang/Exception;
        //  58     68     273    339    Any
        //  76     97     277    315    Ljava/lang/Exception;
        //  76     97     273    339    Any
        //  105    109    277    315    Ljava/lang/Exception;
        //  105    109    273    339    Any
        //  117    121    277    315    Ljava/lang/Exception;
        //  117    121    273    339    Any
        //  129    136    277    315    Ljava/lang/Exception;
        //  129    136    273    339    Any
        //  144    151    277    315    Ljava/lang/Exception;
        //  144    151    273    339    Any
        //  166    172    277    315    Ljava/lang/Exception;
        //  166    172    273    339    Any
        //  180    187    277    315    Ljava/lang/Exception;
        //  180    187    273    339    Any
        //  187    194    197    204    Ljava/io/IOException;
        //  214    218    277    315    Ljava/lang/Exception;
        //  214    218    273    339    Any
        //  226    237    277    315    Ljava/lang/Exception;
        //  226    237    273    339    Any
        //  245    254    277    315    Ljava/lang/Exception;
        //  245    254    273    339    Any
        //  254    261    264    271    Ljava/io/IOException;
        //  282    291    273    339    Any
        //  296    303    306    313    Ljava/io/IOException;
        //  320    327    330    337    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 164, Size: 164
        //     at java.util.ArrayList.rangeCheck(Unknown Source)
        //     at java.util.ArrayList.get(Unknown Source)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3362)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3611)
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
    
    private l<d> d(final String s, final InputStream inputStream, final String s2, final String s3) throws IOException {
        String s4 = s2;
        if (s2 == null) {
            s4 = "application/json";
        }
        FileExtension fileExtension;
        l<d> l;
        if (!s4.contains("application/zip") && !s.split("\\?")[0].endsWith(".lottie")) {
            y1.d.a("Received json response.");
            fileExtension = FileExtension.JSON;
            l = this.e(s, inputStream, s3);
        }
        else {
            y1.d.a("Handling zip response.");
            fileExtension = FileExtension.ZIP;
            l = this.f(s, inputStream, s3);
        }
        if (s3 != null && l.b() != null) {
            this.a.e(s, fileExtension);
        }
        return l;
    }
    
    private l<d> e(final String s, final InputStream inputStream, final String s2) throws IOException {
        if (s2 == null) {
            return com.airbnb.lottie.e.i(inputStream, null);
        }
        return com.airbnb.lottie.e.i(new FileInputStream(new File(this.a.f(s, inputStream, FileExtension.JSON).getAbsolutePath())), s);
    }
    
    private l<d> f(final String s, final InputStream inputStream, final String s2) throws IOException {
        if (s2 == null) {
            return com.airbnb.lottie.e.s(new ZipInputStream(inputStream), null);
        }
        return com.airbnb.lottie.e.s(new ZipInputStream(new FileInputStream(this.a.f(s, inputStream, FileExtension.ZIP))), s);
    }
    
    public l<d> c(final String s, final String s2) {
        final d a = this.a(s, s2);
        if (a != null) {
            return new l<d>(a);
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Animation for ");
        sb.append(s);
        sb.append(" not found in cache. Fetching from network.");
        y1.d.a(sb.toString());
        return this.b(s, s2);
    }
}
