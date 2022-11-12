// 
// Decompiled by Procyon v0.6.0
// 

package m1;

import androidx.work.WorkInfo;
import androidx.work.OutOfQuotaPolicy;
import android.os.Build$VERSION;
import androidx.work.NetworkType;
import e1.b;
import androidx.work.BackoffPolicy;

public class v
{
    public static int a(final BackoffPolicy backoffPolicy) {
        final int n = v$a.b[backoffPolicy.ordinal()];
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Could not convert ");
        sb.append(backoffPolicy);
        sb.append(" to int");
        throw new IllegalArgumentException(sb.toString());
    }
    
    public static b b(final byte[] p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: invokespecial   e1/b.<init>:()V
        //     7: astore          5
        //     9: aload_0        
        //    10: ifnonnull       16
        //    13: aload           5
        //    15: areturn        
        //    16: new             Ljava/io/ByteArrayInputStream;
        //    19: dup            
        //    20: aload_0        
        //    21: invokespecial   java/io/ByteArrayInputStream.<init>:([B)V
        //    24: astore          4
        //    26: new             Ljava/io/ObjectInputStream;
        //    29: astore_2       
        //    30: aload_2        
        //    31: aload           4
        //    33: invokespecial   java/io/ObjectInputStream.<init>:(Ljava/io/InputStream;)V
        //    36: aload_2        
        //    37: astore_0       
        //    38: aload_2        
        //    39: invokevirtual   java/io/ObjectInputStream.readInt:()I
        //    42: istore_1       
        //    43: iload_1        
        //    44: ifle            71
        //    47: aload_2        
        //    48: astore_0       
        //    49: aload           5
        //    51: aload_2        
        //    52: invokevirtual   java/io/ObjectInputStream.readUTF:()Ljava/lang/String;
        //    55: invokestatic    android/net/Uri.parse:(Ljava/lang/String;)Landroid/net/Uri;
        //    58: aload_2        
        //    59: invokevirtual   java/io/ObjectInputStream.readBoolean:()Z
        //    62: invokevirtual   e1/b.a:(Landroid/net/Uri;Z)V
        //    65: iinc            1, -1
        //    68: goto            43
        //    71: aload_2        
        //    72: invokevirtual   java/io/ObjectInputStream.close:()V
        //    75: goto            83
        //    78: astore_0       
        //    79: aload_0        
        //    80: invokevirtual   java/io/IOException.printStackTrace:()V
        //    83: aload           4
        //    85: invokevirtual   java/io/ByteArrayInputStream.close:()V
        //    88: goto            139
        //    91: astore_3       
        //    92: goto            104
        //    95: astore_2       
        //    96: aconst_null    
        //    97: astore_0       
        //    98: goto            143
        //   101: astore_3       
        //   102: aconst_null    
        //   103: astore_2       
        //   104: aload_2        
        //   105: astore_0       
        //   106: aload_3        
        //   107: invokevirtual   java/io/IOException.printStackTrace:()V
        //   110: aload_2        
        //   111: ifnull          126
        //   114: aload_2        
        //   115: invokevirtual   java/io/ObjectInputStream.close:()V
        //   118: goto            126
        //   121: astore_0       
        //   122: aload_0        
        //   123: invokevirtual   java/io/IOException.printStackTrace:()V
        //   126: aload           4
        //   128: invokevirtual   java/io/ByteArrayInputStream.close:()V
        //   131: goto            139
        //   134: astore_0       
        //   135: aload_0        
        //   136: invokevirtual   java/io/IOException.printStackTrace:()V
        //   139: aload           5
        //   141: areturn        
        //   142: astore_2       
        //   143: aload_0        
        //   144: ifnull          159
        //   147: aload_0        
        //   148: invokevirtual   java/io/ObjectInputStream.close:()V
        //   151: goto            159
        //   154: astore_0       
        //   155: aload_0        
        //   156: invokevirtual   java/io/IOException.printStackTrace:()V
        //   159: aload           4
        //   161: invokevirtual   java/io/ByteArrayInputStream.close:()V
        //   164: goto            172
        //   167: astore_0       
        //   168: aload_0        
        //   169: invokevirtual   java/io/IOException.printStackTrace:()V
        //   172: aload_2        
        //   173: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  26     36     101    104    Ljava/io/IOException;
        //  26     36     95     101    Any
        //  38     43     91     95     Ljava/io/IOException;
        //  38     43     142    143    Any
        //  49     65     91     95     Ljava/io/IOException;
        //  49     65     142    143    Any
        //  71     75     78     83     Ljava/io/IOException;
        //  83     88     134    139    Ljava/io/IOException;
        //  106    110    142    143    Any
        //  114    118    121    126    Ljava/io/IOException;
        //  126    131    134    139    Ljava/io/IOException;
        //  147    151    154    159    Ljava/io/IOException;
        //  159    164    167    172    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0043:
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
    
    public static byte[] c(final b p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   e1/b.c:()I
        //     4: istore_1       
        //     5: aconst_null    
        //     6: astore          4
        //     8: aconst_null    
        //     9: astore          5
        //    11: iload_1        
        //    12: ifne            17
        //    15: aconst_null    
        //    16: areturn        
        //    17: new             Ljava/io/ByteArrayOutputStream;
        //    20: dup            
        //    21: invokespecial   java/io/ByteArrayOutputStream.<init>:()V
        //    24: astore          6
        //    26: aload           5
        //    28: astore_2       
        //    29: new             Ljava/io/ObjectOutputStream;
        //    32: astore_3       
        //    33: aload           5
        //    35: astore_2       
        //    36: aload_3        
        //    37: aload           6
        //    39: invokespecial   java/io/ObjectOutputStream.<init>:(Ljava/io/OutputStream;)V
        //    42: aload_3        
        //    43: aload_0        
        //    44: invokevirtual   e1/b.c:()I
        //    47: invokevirtual   java/io/ObjectOutputStream.writeInt:(I)V
        //    50: aload_0        
        //    51: invokevirtual   e1/b.b:()Ljava/util/Set;
        //    54: invokeinterface java/util/Set.iterator:()Ljava/util/Iterator;
        //    59: astore_0       
        //    60: aload_0        
        //    61: invokeinterface java/util/Iterator.hasNext:()Z
        //    66: ifeq            101
        //    69: aload_0        
        //    70: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    75: checkcast       Le1/b$a;
        //    78: astore_2       
        //    79: aload_3        
        //    80: aload_2        
        //    81: invokevirtual   e1/b$a.a:()Landroid/net/Uri;
        //    84: invokevirtual   android/net/Uri.toString:()Ljava/lang/String;
        //    87: invokevirtual   java/io/ObjectOutputStream.writeUTF:(Ljava/lang/String;)V
        //    90: aload_3        
        //    91: aload_2        
        //    92: invokevirtual   e1/b$a.b:()Z
        //    95: invokevirtual   java/io/ObjectOutputStream.writeBoolean:(Z)V
        //    98: goto            60
        //   101: aload_3        
        //   102: invokevirtual   java/io/ObjectOutputStream.close:()V
        //   105: goto            113
        //   108: astore_0       
        //   109: aload_0        
        //   110: invokevirtual   java/io/IOException.printStackTrace:()V
        //   113: aload           6
        //   115: invokevirtual   java/io/ByteArrayOutputStream.close:()V
        //   118: goto            178
        //   121: astore_0       
        //   122: aload_3        
        //   123: astore_2       
        //   124: goto            184
        //   127: astore_2       
        //   128: aload_3        
        //   129: astore_0       
        //   130: aload_2        
        //   131: astore_3       
        //   132: goto            143
        //   135: astore_0       
        //   136: goto            184
        //   139: astore_3       
        //   140: aload           4
        //   142: astore_0       
        //   143: aload_0        
        //   144: astore_2       
        //   145: aload_3        
        //   146: invokevirtual   java/io/IOException.printStackTrace:()V
        //   149: aload_0        
        //   150: ifnull          165
        //   153: aload_0        
        //   154: invokevirtual   java/io/ObjectOutputStream.close:()V
        //   157: goto            165
        //   160: astore_0       
        //   161: aload_0        
        //   162: invokevirtual   java/io/IOException.printStackTrace:()V
        //   165: aload           6
        //   167: invokevirtual   java/io/ByteArrayOutputStream.close:()V
        //   170: goto            178
        //   173: astore_0       
        //   174: aload_0        
        //   175: invokevirtual   java/io/IOException.printStackTrace:()V
        //   178: aload           6
        //   180: invokevirtual   java/io/ByteArrayOutputStream.toByteArray:()[B
        //   183: areturn        
        //   184: aload_2        
        //   185: ifnull          200
        //   188: aload_2        
        //   189: invokevirtual   java/io/ObjectOutputStream.close:()V
        //   192: goto            200
        //   195: astore_2       
        //   196: aload_2        
        //   197: invokevirtual   java/io/IOException.printStackTrace:()V
        //   200: aload           6
        //   202: invokevirtual   java/io/ByteArrayOutputStream.close:()V
        //   205: goto            213
        //   208: astore_2       
        //   209: aload_2        
        //   210: invokevirtual   java/io/IOException.printStackTrace:()V
        //   213: aload_0        
        //   214: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  29     33     139    143    Ljava/io/IOException;
        //  29     33     135    139    Any
        //  36     42     139    143    Ljava/io/IOException;
        //  36     42     135    139    Any
        //  42     60     127    135    Ljava/io/IOException;
        //  42     60     121    127    Any
        //  60     98     127    135    Ljava/io/IOException;
        //  60     98     121    127    Any
        //  101    105    108    113    Ljava/io/IOException;
        //  113    118    173    178    Ljava/io/IOException;
        //  145    149    135    139    Any
        //  153    157    160    165    Ljava/io/IOException;
        //  165    170    173    178    Ljava/io/IOException;
        //  188    192    195    200    Ljava/io/IOException;
        //  200    205    208    213    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0113:
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
    
    public static BackoffPolicy d(final int n) {
        if (n == 0) {
            return BackoffPolicy.EXPONENTIAL;
        }
        if (n == 1) {
            return BackoffPolicy.LINEAR;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Could not convert ");
        sb.append(n);
        sb.append(" to BackoffPolicy");
        throw new IllegalArgumentException(sb.toString());
    }
    
    public static NetworkType e(final int n) {
        if (n == 0) {
            return NetworkType.NOT_REQUIRED;
        }
        if (n == 1) {
            return NetworkType.CONNECTED;
        }
        if (n == 2) {
            return NetworkType.UNMETERED;
        }
        if (n == 3) {
            return NetworkType.NOT_ROAMING;
        }
        if (n == 4) {
            return NetworkType.METERED;
        }
        if (Build$VERSION.SDK_INT >= 30 && n == 5) {
            return NetworkType.TEMPORARILY_UNMETERED;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Could not convert ");
        sb.append(n);
        sb.append(" to NetworkType");
        throw new IllegalArgumentException(sb.toString());
    }
    
    public static OutOfQuotaPolicy f(final int n) {
        if (n == 0) {
            return OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
        }
        if (n == 1) {
            return OutOfQuotaPolicy.DROP_WORK_REQUEST;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Could not convert ");
        sb.append(n);
        sb.append(" to OutOfQuotaPolicy");
        throw new IllegalArgumentException(sb.toString());
    }
    
    public static WorkInfo.State g(final int n) {
        if (n == 0) {
            return WorkInfo.State.ENQUEUED;
        }
        if (n == 1) {
            return WorkInfo.State.RUNNING;
        }
        if (n == 2) {
            return WorkInfo.State.SUCCEEDED;
        }
        if (n == 3) {
            return WorkInfo.State.FAILED;
        }
        if (n == 4) {
            return WorkInfo.State.BLOCKED;
        }
        if (n == 5) {
            return WorkInfo.State.CANCELLED;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Could not convert ");
        sb.append(n);
        sb.append(" to State");
        throw new IllegalArgumentException(sb.toString());
    }
    
    public static int h(final NetworkType networkType) {
        final int n = v$a.c[networkType.ordinal()];
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        if (n == 4) {
            return 3;
        }
        if (n == 5) {
            return 4;
        }
        if (Build$VERSION.SDK_INT >= 30 && networkType == NetworkType.TEMPORARILY_UNMETERED) {
            return 5;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Could not convert ");
        sb.append(networkType);
        sb.append(" to int");
        throw new IllegalArgumentException(sb.toString());
    }
    
    public static int i(final OutOfQuotaPolicy outOfQuotaPolicy) {
        final int n = v$a.d[outOfQuotaPolicy.ordinal()];
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Could not convert ");
        sb.append(outOfQuotaPolicy);
        sb.append(" to int");
        throw new IllegalArgumentException(sb.toString());
    }
    
    public static int j(final WorkInfo.State state) {
        switch (v$a.a[state.ordinal()]) {
            default: {
                final StringBuilder sb = new StringBuilder();
                sb.append("Could not convert ");
                sb.append(state);
                sb.append(" to int");
                throw new IllegalArgumentException(sb.toString());
            }
            case 6: {
                return 5;
            }
            case 5: {
                return 4;
            }
            case 4: {
                return 3;
            }
            case 3: {
                return 2;
            }
            case 2: {
                return 1;
            }
            case 1: {
                return 0;
            }
        }
    }
}
