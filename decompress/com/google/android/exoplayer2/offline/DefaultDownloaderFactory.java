// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.offline;

import java.util.concurrent.Executor;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.MediaItem;
import java.lang.reflect.Constructor;
import android.util.SparseArray;

public class DefaultDownloaderFactory implements DownloaderFactory
{
    private static final SparseArray<Constructor<? extends Downloader>> a;
    
    static {
        a = a();
    }
    
    private static SparseArray<Constructor<? extends Downloader>> a() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: invokespecial   android/util/SparseArray.<init>:()V
        //     7: astore_0       
        //     8: aload_0        
        //     9: iconst_0       
        //    10: ldc             Lcom/google/android/exoplayer2/source/dash/offline/DashDownloader;.class
        //    12: invokestatic    com/google/android/exoplayer2/offline/DefaultDownloaderFactory.b:(Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
        //    15: invokevirtual   android/util/SparseArray.put:(ILjava/lang/Object;)V
        //    18: aload_0        
        //    19: iconst_2       
        //    20: ldc             Lcom/google/android/exoplayer2/source/hls/offline/HlsDownloader;.class
        //    22: invokestatic    com/google/android/exoplayer2/offline/DefaultDownloaderFactory.b:(Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
        //    25: invokevirtual   android/util/SparseArray.put:(ILjava/lang/Object;)V
        //    28: aload_0        
        //    29: iconst_1       
        //    30: ldc             Lcom/google/android/exoplayer2/source/smoothstreaming/offline/SsDownloader;.class
        //    32: invokestatic    com/google/android/exoplayer2/offline/DefaultDownloaderFactory.b:(Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
        //    35: invokevirtual   android/util/SparseArray.put:(ILjava/lang/Object;)V
        //    38: aload_0        
        //    39: areturn        
        //    40: astore_1       
        //    41: goto            18
        //    44: astore_1       
        //    45: goto            28
        //    48: astore_1       
        //    49: goto            38
        //    Signature:
        //  ()Landroid/util/SparseArray<Ljava/lang/reflect/Constructor<+Lcom/google/android/exoplayer2/offline/Downloader;>;>;
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                              
        //  -----  -----  -----  -----  ----------------------------------
        //  8      18     40     44     Ljava/lang/ClassNotFoundException;
        //  18     28     44     48     Ljava/lang/ClassNotFoundException;
        //  28     38     48     52     Ljava/lang/ClassNotFoundException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 27, Size: 27
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
    
    private static Constructor<? extends Downloader> b(final Class<?> clazz) {
        try {
            return clazz.asSubclass(Downloader.class).getConstructor(MediaItem.class, CacheDataSource.Factory.class, Executor.class);
        }
        catch (final NoSuchMethodException ex) {
            throw new IllegalStateException("Downloader constructor missing", ex);
        }
    }
}
