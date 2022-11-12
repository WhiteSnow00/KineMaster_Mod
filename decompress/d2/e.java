// 
// Decompiled by Procyon v0.6.0
// 

package d2;

import java.io.FileNotFoundException;
import android.text.TextUtils;
import java.io.InputStream;
import java.io.File;
import android.net.Uri;
import com.bumptech.glide.load.ImageHeaderParser;
import java.util.List;
import android.content.ContentResolver;
import e2.b;

class e
{
    private static final a f;
    private final a a;
    private final d b;
    private final b c;
    private final ContentResolver d;
    private final List<ImageHeaderParser> e;
    
    static {
        f = new a();
    }
    
    e(final List<ImageHeaderParser> e, final a a, final d b, final b c, final ContentResolver d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    e(final List<ImageHeaderParser> list, final d d, final b b, final ContentResolver contentResolver) {
        this(list, d2.e.f, d, b, contentResolver);
    }
    
    private String b(final Uri p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore_2       
        //     2: aload_0        
        //     3: getfield        d2/e.b:Ld2/d;
        //     6: aload_1        
        //     7: invokeinterface d2/d.a:(Landroid/net/Uri;)Landroid/database/Cursor;
        //    12: astore_3       
        //    13: aload_3        
        //    14: ifnull          53
        //    17: aload_3        
        //    18: astore_2       
        //    19: aload_3        
        //    20: invokeinterface android/database/Cursor.moveToFirst:()Z
        //    25: ifeq            53
        //    28: aload_3        
        //    29: astore_2       
        //    30: aload_3        
        //    31: iconst_0       
        //    32: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //    37: astore          4
        //    39: aload_3        
        //    40: invokeinterface android/database/Cursor.close:()V
        //    45: aload           4
        //    47: areturn        
        //    48: astore          4
        //    50: goto            73
        //    53: aload_3        
        //    54: ifnull          63
        //    57: aload_3        
        //    58: invokeinterface android/database/Cursor.close:()V
        //    63: aconst_null    
        //    64: areturn        
        //    65: astore_1       
        //    66: goto            145
        //    69: astore          4
        //    71: aconst_null    
        //    72: astore_3       
        //    73: aload_3        
        //    74: astore_2       
        //    75: ldc             "ThumbStreamOpener"
        //    77: iconst_3       
        //    78: invokestatic    android/util/Log.isLoggable:(Ljava/lang/String;I)Z
        //    81: ifeq            132
        //    84: aload_3        
        //    85: astore_2       
        //    86: new             Ljava/lang/StringBuilder;
        //    89: astore          5
        //    91: aload_3        
        //    92: astore_2       
        //    93: aload           5
        //    95: invokespecial   java/lang/StringBuilder.<init>:()V
        //    98: aload_3        
        //    99: astore_2       
        //   100: aload           5
        //   102: ldc             "Failed to query for thumbnail for Uri: "
        //   104: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   107: pop            
        //   108: aload_3        
        //   109: astore_2       
        //   110: aload           5
        //   112: aload_1        
        //   113: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   116: pop            
        //   117: aload_3        
        //   118: astore_2       
        //   119: ldc             "ThumbStreamOpener"
        //   121: aload           5
        //   123: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   126: aload           4
        //   128: invokestatic    android/util/Log.d:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   131: pop            
        //   132: aload_3        
        //   133: ifnull          142
        //   136: aload_3        
        //   137: invokeinterface android/database/Cursor.close:()V
        //   142: aconst_null    
        //   143: areturn        
        //   144: astore_1       
        //   145: aload_2        
        //   146: ifnull          155
        //   149: aload_2        
        //   150: invokeinterface android/database/Cursor.close:()V
        //   155: aload_1        
        //   156: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                         
        //  -----  -----  -----  -----  -----------------------------
        //  2      13     69     73     Ljava/lang/SecurityException;
        //  2      13     65     69     Any
        //  19     28     48     53     Ljava/lang/SecurityException;
        //  19     28     144    145    Any
        //  30     39     48     53     Ljava/lang/SecurityException;
        //  30     39     144    145    Any
        //  75     84     144    145    Any
        //  86     91     144    145    Any
        //  93     98     144    145    Any
        //  100    108    144    145    Any
        //  110    117    144    145    Any
        //  119    132    144    145    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0053:
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
    
    private boolean c(final File file) {
        return this.a.a(file) && 0L < this.a.c(file);
    }
    
    int a(final Uri p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: aconst_null    
        //     4: astore          5
        //     6: aconst_null    
        //     7: astore_3       
        //     8: aload_0        
        //     9: getfield        d2/e.d:Landroid/content/ContentResolver;
        //    12: aload_1        
        //    13: invokevirtual   android/content/ContentResolver.openInputStream:(Landroid/net/Uri;)Ljava/io/InputStream;
        //    16: astore          6
        //    18: aload           6
        //    20: astore_3       
        //    21: aload           6
        //    23: astore          4
        //    25: aload           6
        //    27: astore          5
        //    29: aload_0        
        //    30: getfield        d2/e.e:Ljava/util/List;
        //    33: aload           6
        //    35: aload_0        
        //    36: getfield        d2/e.c:Le2/b;
        //    39: invokestatic    com/bumptech/glide/load/a.b:(Ljava/util/List;Ljava/io/InputStream;Le2/b;)I
        //    42: istore_2       
        //    43: aload           6
        //    45: ifnull          53
        //    48: aload           6
        //    50: invokevirtual   java/io/InputStream.close:()V
        //    53: iload_2        
        //    54: ireturn        
        //    55: astore_1       
        //    56: goto            147
        //    59: astore          6
        //    61: goto            70
        //    64: astore          6
        //    66: aload           5
        //    68: astore          4
        //    70: aload           4
        //    72: astore_3       
        //    73: ldc             "ThumbStreamOpener"
        //    75: iconst_3       
        //    76: invokestatic    android/util/Log.isLoggable:(Ljava/lang/String;I)Z
        //    79: ifeq            135
        //    82: aload           4
        //    84: astore_3       
        //    85: new             Ljava/lang/StringBuilder;
        //    88: astore          5
        //    90: aload           4
        //    92: astore_3       
        //    93: aload           5
        //    95: invokespecial   java/lang/StringBuilder.<init>:()V
        //    98: aload           4
        //   100: astore_3       
        //   101: aload           5
        //   103: ldc             "Failed to open uri: "
        //   105: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   108: pop            
        //   109: aload           4
        //   111: astore_3       
        //   112: aload           5
        //   114: aload_1        
        //   115: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   118: pop            
        //   119: aload           4
        //   121: astore_3       
        //   122: ldc             "ThumbStreamOpener"
        //   124: aload           5
        //   126: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   129: aload           6
        //   131: invokestatic    android/util/Log.d:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   134: pop            
        //   135: aload           4
        //   137: ifnull          145
        //   140: aload           4
        //   142: invokevirtual   java/io/InputStream.close:()V
        //   145: iconst_m1      
        //   146: ireturn        
        //   147: aload_3        
        //   148: ifnull          155
        //   151: aload_3        
        //   152: invokevirtual   java/io/InputStream.close:()V
        //   155: aload_1        
        //   156: athrow         
        //   157: astore_1       
        //   158: goto            53
        //   161: astore_1       
        //   162: goto            145
        //   165: astore_3       
        //   166: goto            155
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                            
        //  -----  -----  -----  -----  --------------------------------
        //  8      18     64     70     Ljava/io/IOException;
        //  8      18     59     64     Ljava/lang/NullPointerException;
        //  8      18     55     157    Any
        //  29     43     64     70     Ljava/io/IOException;
        //  29     43     59     64     Ljava/lang/NullPointerException;
        //  29     43     55     157    Any
        //  48     53     157    161    Ljava/io/IOException;
        //  73     82     55     157    Any
        //  85     90     55     157    Any
        //  93     98     55     157    Any
        //  101    109    55     157    Any
        //  112    119    55     157    Any
        //  122    135    55     157    Any
        //  140    145    161    165    Ljava/io/IOException;
        //  151    155    165    169    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.util.ConcurrentModificationException
        //     at java.util.ArrayList$Itr.checkForComodification(Unknown Source)
        //     at java.util.ArrayList$Itr.next(Unknown Source)
        //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:2913)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2501)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
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
    
    public InputStream d(final Uri uri) throws FileNotFoundException {
        final String b = this.b(uri);
        if (TextUtils.isEmpty((CharSequence)b)) {
            return null;
        }
        final File b2 = this.a.b(b);
        if (!this.c(b2)) {
            return null;
        }
        final Uri fromFile = Uri.fromFile(b2);
        try {
            return this.d.openInputStream(fromFile);
        }
        catch (final NullPointerException ex) {
            final StringBuilder sb = new StringBuilder();
            sb.append("NPE opening uri: ");
            sb.append(uri);
            sb.append(" -> ");
            sb.append(fromFile);
            throw (FileNotFoundException)new FileNotFoundException(sb.toString()).initCause(ex);
        }
    }
}
