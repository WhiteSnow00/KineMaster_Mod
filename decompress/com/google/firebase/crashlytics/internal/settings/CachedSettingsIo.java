// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.settings;

import java.io.Closeable;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.io.FileWriter;
import com.google.firebase.crashlytics.internal.Logger;
import org.json.JSONObject;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import java.io.File;

public class CachedSettingsIo
{
    private final File a;
    
    public CachedSettingsIo(final FileStore fileStore) {
        this.a = fileStore.e("com.crashlytics.settings.json");
    }
    
    private File a() {
        return this.a;
    }
    
    public JSONObject b() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: ldc             "Checking for cached settings..."
        //     5: invokevirtual   com/google/firebase/crashlytics/internal/Logger.b:(Ljava/lang/String;)V
        //     8: aconst_null    
        //     9: astore          4
        //    11: aconst_null    
        //    12: astore_2       
        //    13: aload_0        
        //    14: invokespecial   com/google/firebase/crashlytics/internal/settings/CachedSettingsIo.a:()Ljava/io/File;
        //    17: astore_3       
        //    18: aload_3        
        //    19: invokevirtual   java/io/File.exists:()Z
        //    22: ifeq            67
        //    25: new             Ljava/io/FileInputStream;
        //    28: astore_1       
        //    29: aload_1        
        //    30: aload_3        
        //    31: invokespecial   java/io/FileInputStream.<init>:(Ljava/io/File;)V
        //    34: aload_1        
        //    35: astore_2       
        //    36: aload_1        
        //    37: invokestatic    com/google/firebase/crashlytics/internal/common/CommonUtils.A:(Ljava/io/InputStream;)Ljava/lang/String;
        //    40: astore          5
        //    42: aload_1        
        //    43: astore_2       
        //    44: new             Lorg/json/JSONObject;
        //    47: astore_3       
        //    48: aload_1        
        //    49: astore_2       
        //    50: aload_3        
        //    51: aload           5
        //    53: invokespecial   org/json/JSONObject.<init>:(Ljava/lang/String;)V
        //    56: aload_1        
        //    57: astore_2       
        //    58: aload_3        
        //    59: astore_1       
        //    60: goto            77
        //    63: astore_3       
        //    64: goto            95
        //    67: invokestatic    com/google/firebase/crashlytics/internal/Logger.f:()Lcom/google/firebase/crashlytics/internal/Logger;
        //    70: ldc             "Settings file does not exist."
        //    72: invokevirtual   com/google/firebase/crashlytics/internal/Logger.i:(Ljava/lang/String;)V
        //    75: aconst_null    
        //    76: astore_1       
        //    77: aload_2        
        //    78: ldc             "Error while closing settings cache file."
        //    80: invokestatic    com/google/firebase/crashlytics/internal/common/CommonUtils.e:(Ljava/io/Closeable;Ljava/lang/String;)V
        //    83: goto            115
        //    86: astore_1       
        //    87: aconst_null    
        //    88: astore_2       
        //    89: goto            118
        //    92: astore_3       
        //    93: aconst_null    
        //    94: astore_1       
        //    95: aload_1        
        //    96: astore_2       
        //    97: invokestatic    com/google/firebase/crashlytics/internal/Logger.f:()Lcom/google/firebase/crashlytics/internal/Logger;
        //   100: ldc             "Failed to fetch cached settings"
        //   102: aload_3        
        //   103: invokevirtual   com/google/firebase/crashlytics/internal/Logger.e:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   106: aload_1        
        //   107: ldc             "Error while closing settings cache file."
        //   109: invokestatic    com/google/firebase/crashlytics/internal/common/CommonUtils.e:(Ljava/io/Closeable;Ljava/lang/String;)V
        //   112: aload           4
        //   114: astore_1       
        //   115: aload_1        
        //   116: areturn        
        //   117: astore_1       
        //   118: aload_2        
        //   119: ldc             "Error while closing settings cache file."
        //   121: invokestatic    com/google/firebase/crashlytics/internal/common/CommonUtils.e:(Ljava/io/Closeable;Ljava/lang/String;)V
        //   124: aload_1        
        //   125: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  13     34     92     95     Ljava/lang/Exception;
        //  13     34     86     92     Any
        //  36     42     63     67     Ljava/lang/Exception;
        //  36     42     117    118    Any
        //  44     48     63     67     Ljava/lang/Exception;
        //  44     48     117    118    Any
        //  50     56     63     67     Ljava/lang/Exception;
        //  50     56     117    118    Any
        //  67     75     92     95     Ljava/lang/Exception;
        //  67     75     86     92     Any
        //  97     106    117    118    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0067:
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
    
    public void c(final long n, final JSONObject jsonObject) {
        Logger.f().i("Writing settings to cache file...");
        if (jsonObject != null) {
            final Closeable closeable = null;
            Object o2;
            final Object o = o2 = null;
            FileWriter fileWriter = null;
            Closeable closeable2;
            try {
                try {
                    jsonObject.put("expires_at", n);
                    o2 = o;
                    o2 = o;
                    fileWriter = new FileWriter(this.a());
                    try {
                        fileWriter.write(jsonObject.toString());
                        fileWriter.flush();
                        CommonUtils.e(fileWriter, "Failed to close settings writer.");
                    }
                    catch (final Exception o2) {}
                    finally {
                        o2 = fileWriter;
                    }
                }
                finally {}
            }
            catch (final Exception fileWriter) {
                closeable2 = closeable;
            }
            Logger.f().e("Failed to cache settings", (Throwable)fileWriter);
            CommonUtils.e(closeable2, "Failed to close settings writer.");
            return;
            CommonUtils.e((Closeable)o2, "Failed to close settings writer.");
        }
    }
}
