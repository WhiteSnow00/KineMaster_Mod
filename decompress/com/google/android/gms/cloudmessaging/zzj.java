// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.cloudmessaging;

import android.os.IBinder;

public final class zzj implements Runnable
{
    public final c a;
    public final IBinder b;
    
    public zzj(final c a, final IBinder b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void run() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        com/google/android/gms/cloudmessaging/zzj.a:Lcom/google/android/gms/cloudmessaging/c;
        //     4: astore_1       
        //     5: aload_0        
        //     6: getfield        com/google/android/gms/cloudmessaging/zzj.b:Landroid/os/IBinder;
        //     9: astore_2       
        //    10: aload_1        
        //    11: monitorenter   
        //    12: aload_2        
        //    13: ifnonnull       26
        //    16: aload_1        
        //    17: iconst_0       
        //    18: ldc             "Null service connection"
        //    20: invokevirtual   com/google/android/gms/cloudmessaging/c.a:(ILjava/lang/String;)V
        //    23: aload_1        
        //    24: monitorexit    
        //    25: return         
        //    26: new             Lcom/google/android/gms/cloudmessaging/d;
        //    29: astore_3       
        //    30: aload_3        
        //    31: aload_2        
        //    32: invokespecial   com/google/android/gms/cloudmessaging/d.<init>:(Landroid/os/IBinder;)V
        //    35: aload_1        
        //    36: aload_3        
        //    37: putfield        com/google/android/gms/cloudmessaging/c.c:Lcom/google/android/gms/cloudmessaging/d;
        //    40: aload_1        
        //    41: iconst_2       
        //    42: putfield        com/google/android/gms/cloudmessaging/c.a:I
        //    45: aload_1        
        //    46: invokevirtual   com/google/android/gms/cloudmessaging/c.c:()V
        //    49: aload_1        
        //    50: monitorexit    
        //    51: return         
        //    52: astore_2       
        //    53: goto            69
        //    56: astore_2       
        //    57: aload_1        
        //    58: iconst_0       
        //    59: aload_2        
        //    60: invokevirtual   android/os/RemoteException.getMessage:()Ljava/lang/String;
        //    63: invokevirtual   com/google/android/gms/cloudmessaging/c.a:(ILjava/lang/String;)V
        //    66: aload_1        
        //    67: monitorexit    
        //    68: return         
        //    69: aload_1        
        //    70: monitorexit    
        //    71: aload_2        
        //    72: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                        
        //  -----  -----  -----  -----  ----------------------------
        //  16     25     52     73     Any
        //  26     40     56     69     Landroid/os/RemoteException;
        //  26     40     52     73     Any
        //  40     51     52     73     Any
        //  57     68     52     73     Any
        //  69     71     52     73     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0026:
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
}
