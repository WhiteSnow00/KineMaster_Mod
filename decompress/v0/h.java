// 
// Decompiled by Procyon v0.6.0
// 

package v0;

import android.text.TextUtils;
import android.content.Context;
import java.io.File;
import android.util.Log;
import java.io.Closeable;

public interface h extends Closeable
{
    void close();
    
    String getDatabaseName();
    
    g getWritableDatabase();
    
    void setWriteAheadLoggingEnabled(final boolean p0);
    
    public abstract static class a
    {
        public final int a;
        
        public a(final int a) {
            this.a = a;
        }
        
        private void a(final String s) {
            if (!s.equalsIgnoreCase(":memory:")) {
                if (s.trim().length() != 0) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("deleting the database file: ");
                    sb.append(s);
                    Log.w("SupportSQLite", sb.toString());
                    try {
                        v0.b.c(new File(s));
                    }
                    catch (final Exception ex) {
                        Log.w("SupportSQLite", "delete failed: ", (Throwable)ex);
                    }
                }
            }
        }
        
        public void b(final g g) {
        }
        
        public void c(final g p0) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     3: dup            
            //     4: invokespecial   java/lang/StringBuilder.<init>:()V
            //     7: astore_2       
            //     8: aload_2        
            //     9: ldc             "Corruption reported by sqlite on database: "
            //    11: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //    14: pop            
            //    15: aload_2        
            //    16: aload_1        
            //    17: invokeinterface v0/g.getPath:()Ljava/lang/String;
            //    22: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //    25: pop            
            //    26: ldc             "SupportSQLite"
            //    28: aload_2        
            //    29: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
            //    32: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;)I
            //    35: pop            
            //    36: aload_1        
            //    37: invokeinterface v0/g.isOpen:()Z
            //    42: ifne            56
            //    45: aload_0        
            //    46: aload_1        
            //    47: invokeinterface v0/g.getPath:()Ljava/lang/String;
            //    52: invokespecial   v0/h$a.a:(Ljava/lang/String;)V
            //    55: return         
            //    56: aconst_null    
            //    57: astore_2       
            //    58: aconst_null    
            //    59: astore_3       
            //    60: aload_1        
            //    61: invokeinterface v0/g.x:()Ljava/util/List;
            //    66: astore          4
            //    68: aload           4
            //    70: astore_2       
            //    71: goto            78
            //    74: astore_2       
            //    75: goto            89
            //    78: aload_2        
            //    79: astore_3       
            //    80: aload_1        
            //    81: invokeinterface java/io/Closeable.close:()V
            //    86: goto            143
            //    89: aload_3        
            //    90: ifnull          131
            //    93: aload_3        
            //    94: invokeinterface java/util/List.iterator:()Ljava/util/Iterator;
            //    99: astore_1       
            //   100: aload_1        
            //   101: invokeinterface java/util/Iterator.hasNext:()Z
            //   106: ifeq            141
            //   109: aload_0        
            //   110: aload_1        
            //   111: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
            //   116: checkcast       Landroid/util/Pair;
            //   119: getfield        android/util/Pair.second:Ljava/lang/Object;
            //   122: checkcast       Ljava/lang/String;
            //   125: invokespecial   v0/h$a.a:(Ljava/lang/String;)V
            //   128: goto            100
            //   131: aload_0        
            //   132: aload_1        
            //   133: invokeinterface v0/g.getPath:()Ljava/lang/String;
            //   138: invokespecial   v0/h$a.a:(Ljava/lang/String;)V
            //   141: aload_2        
            //   142: athrow         
            //   143: aload_2        
            //   144: ifnull          185
            //   147: aload_2        
            //   148: invokeinterface java/util/List.iterator:()Ljava/util/Iterator;
            //   153: astore_1       
            //   154: aload_1        
            //   155: invokeinterface java/util/Iterator.hasNext:()Z
            //   160: ifeq            195
            //   163: aload_0        
            //   164: aload_1        
            //   165: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
            //   170: checkcast       Landroid/util/Pair;
            //   173: getfield        android/util/Pair.second:Ljava/lang/Object;
            //   176: checkcast       Ljava/lang/String;
            //   179: invokespecial   v0/h$a.a:(Ljava/lang/String;)V
            //   182: goto            154
            //   185: aload_0        
            //   186: aload_1        
            //   187: invokeinterface v0/g.getPath:()Ljava/lang/String;
            //   192: invokespecial   v0/h$a.a:(Ljava/lang/String;)V
            //   195: return         
            //   196: astore_3       
            //   197: goto            78
            //   200: astore_3       
            //   201: goto            143
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                                     
            //  -----  -----  -----  -----  -----------------------------------------
            //  60     68     196    200    Landroid/database/sqlite/SQLiteException;
            //  60     68     74     143    Any
            //  80     86     200    204    Ljava/io/IOException;
            //  80     86     74     143    Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0089:
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
        
        public abstract void d(final g p0);
        
        public abstract void e(final g p0, final int p1, final int p2);
        
        public void f(final g g) {
        }
        
        public abstract void g(final g p0, final int p1, final int p2);
    }
    
    public static class b
    {
        public final Context a;
        public final String b;
        public final h.a c;
        public final boolean d;
        
        b(final Context a, final String b, final h.a c, final boolean d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }
        
        public static a a(final Context context) {
            return new a(context);
        }
        
        public static class a
        {
            Context a;
            String b;
            h.a c;
            boolean d;
            
            a(final Context a) {
                this.a = a;
            }
            
            public b a() {
                if (this.c == null) {
                    throw new IllegalArgumentException("Must set a callback to create the configuration.");
                }
                if (this.a == null) {
                    throw new IllegalArgumentException("Must set a non-null context to create the configuration.");
                }
                if (this.d && TextUtils.isEmpty((CharSequence)this.b)) {
                    throw new IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.");
                }
                return new b(this.a, this.b, this.c, this.d);
            }
            
            public a b(final h.a c) {
                this.c = c;
                return this;
            }
            
            public a c(final String b) {
                this.b = b;
                return this;
            }
            
            public a d(final boolean d) {
                this.d = d;
                return this;
            }
        }
    }
    
    public interface c
    {
        h a(final b p0);
    }
}
