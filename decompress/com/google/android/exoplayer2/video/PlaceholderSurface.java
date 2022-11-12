// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.video;

import android.os.Message;
import android.os.Handler;
import com.google.android.exoplayer2.util.EGLSurfaceTexture;
import android.os.Handler$Callback;
import android.os.HandlerThread;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.GlUtil;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;

public final class PlaceholderSurface extends Surface
{
    private static int d;
    private static boolean e;
    public final boolean a;
    private final b b;
    private boolean c;
    
    private PlaceholderSurface(final b b, final SurfaceTexture surfaceTexture, final boolean a) {
        super(surfaceTexture);
        this.b = b;
        this.a = a;
    }
    
    PlaceholderSurface(final b b, final SurfaceTexture surfaceTexture, final boolean b2, final PlaceholderSurface$a object) {
        this(b, surfaceTexture, b2);
    }
    
    private static int a(final Context context) {
        if (!GlUtil.h(context)) {
            return 0;
        }
        if (GlUtil.i()) {
            return 1;
        }
        return 2;
    }
    
    public static boolean b(final Context context) {
        synchronized (PlaceholderSurface.class) {
            final boolean e = PlaceholderSurface.e;
            boolean b = true;
            if (!e) {
                PlaceholderSurface.d = a(context);
                PlaceholderSurface.e = true;
            }
            if (PlaceholderSurface.d == 0) {
                b = false;
            }
            return b;
        }
    }
    
    public static PlaceholderSurface c(final Context context, final boolean b) {
        int d = 0;
        Assertions.g(!b || b(context));
        final b b2 = new b();
        if (b) {
            d = PlaceholderSurface.d;
        }
        return b2.a(d);
    }
    
    public void release() {
        super.release();
        synchronized (this.b) {
            if (!this.c) {
                this.b.c();
                this.c = true;
            }
        }
    }
    
    private static class b extends HandlerThread implements Handler$Callback
    {
        private EGLSurfaceTexture a;
        private Handler b;
        private Error c;
        private RuntimeException d;
        private PlaceholderSurface e;
        
        public b() {
            super("ExoPlayer:PlaceholderSurface");
        }
        
        private void b(final int n) {
            Assertions.e(this.a);
            this.a.h(n);
            this.e = new PlaceholderSurface(this, this.a.g(), n != 0, null);
        }
        
        private void d() {
            Assertions.e(this.a);
            this.a.i();
        }
        
        public PlaceholderSurface a(int n) {
            this.start();
            this.b = new Handler(this.getLooper(), (Handler$Callback)this);
            this.a = new EGLSurfaceTexture(this.b);
            synchronized (this) {
                final Handler b = this.b;
                final int n2 = 0;
                b.obtainMessage(1, n, 0).sendToTarget();
                n = n2;
                while (this.e == null && this.d == null && this.c == null) {
                    try {
                        this.wait();
                    }
                    catch (final InterruptedException ex) {
                        n = 1;
                    }
                }
                monitorexit(this);
                if (n != 0) {
                    Thread.currentThread().interrupt();
                }
                final RuntimeException d = this.d;
                if (d != null) {
                    throw d;
                }
                final Error c = this.c;
                if (c == null) {
                    return Assertions.e(this.e);
                }
                throw c;
            }
        }
        
        public void c() {
            Assertions.e(this.b);
            this.b.sendEmptyMessage(2);
        }
        
        public boolean handleMessage(final Message p0) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: getfield        android/os/Message.what:I
            //     4: istore_2       
            //     5: iload_2        
            //     6: iconst_1       
            //     7: if_icmpeq       51
            //    10: iload_2        
            //    11: iconst_2       
            //    12: if_icmpeq       17
            //    15: iconst_1       
            //    16: ireturn        
            //    17: aload_0        
            //    18: invokespecial   com/google/android/exoplayer2/video/PlaceholderSurface$b.d:()V
            //    21: aload_0        
            //    22: invokevirtual   android/os/HandlerThread.quit:()Z
            //    25: pop            
            //    26: goto            41
            //    29: astore_1       
            //    30: ldc             "PlaceholderSurface"
            //    32: ldc             "Failed to release placeholder surface"
            //    34: aload_1        
            //    35: invokestatic    com/google/android/exoplayer2/util/Log.d:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
            //    38: goto            21
            //    41: iconst_1       
            //    42: ireturn        
            //    43: astore_1       
            //    44: aload_0        
            //    45: invokevirtual   android/os/HandlerThread.quit:()Z
            //    48: pop            
            //    49: aload_1        
            //    50: athrow         
            //    51: aload_0        
            //    52: aload_1        
            //    53: getfield        android/os/Message.arg1:I
            //    56: invokespecial   com/google/android/exoplayer2/video/PlaceholderSurface$b.b:(I)V
            //    59: aload_0        
            //    60: monitorenter   
            //    61: aload_0        
            //    62: invokevirtual   java/lang/Object.notify:()V
            //    65: aload_0        
            //    66: monitorexit    
            //    67: goto            131
            //    70: astore_1       
            //    71: aload_0        
            //    72: monitorexit    
            //    73: aload_1        
            //    74: athrow         
            //    75: astore_1       
            //    76: goto            138
            //    79: astore_1       
            //    80: ldc             "PlaceholderSurface"
            //    82: ldc             "Failed to initialize placeholder surface"
            //    84: aload_1        
            //    85: invokestatic    com/google/android/exoplayer2/util/Log.d:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
            //    88: aload_0        
            //    89: aload_1        
            //    90: putfield        com/google/android/exoplayer2/video/PlaceholderSurface$b.c:Ljava/lang/Error;
            //    93: aload_0        
            //    94: monitorenter   
            //    95: aload_0        
            //    96: invokevirtual   java/lang/Object.notify:()V
            //    99: aload_0        
            //   100: monitorexit    
            //   101: goto            131
            //   104: astore_1       
            //   105: aload_0        
            //   106: monitorexit    
            //   107: aload_1        
            //   108: athrow         
            //   109: astore_1       
            //   110: ldc             "PlaceholderSurface"
            //   112: ldc             "Failed to initialize placeholder surface"
            //   114: aload_1        
            //   115: invokestatic    com/google/android/exoplayer2/util/Log.d:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
            //   118: aload_0        
            //   119: aload_1        
            //   120: putfield        com/google/android/exoplayer2/video/PlaceholderSurface$b.d:Ljava/lang/RuntimeException;
            //   123: aload_0        
            //   124: monitorenter   
            //   125: aload_0        
            //   126: invokevirtual   java/lang/Object.notify:()V
            //   129: aload_0        
            //   130: monitorexit    
            //   131: iconst_1       
            //   132: ireturn        
            //   133: astore_1       
            //   134: aload_0        
            //   135: monitorexit    
            //   136: aload_1        
            //   137: athrow         
            //   138: aload_0        
            //   139: monitorenter   
            //   140: aload_0        
            //   141: invokevirtual   java/lang/Object.notify:()V
            //   144: aload_0        
            //   145: monitorexit    
            //   146: aload_1        
            //   147: athrow         
            //   148: astore_1       
            //   149: aload_0        
            //   150: monitorexit    
            //   151: aload_1        
            //   152: athrow         
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                        
            //  -----  -----  -----  -----  ----------------------------
            //  17     21     29     41     Any
            //  30     38     43     51     Any
            //  51     59     109    138    Ljava/lang/RuntimeException;
            //  51     59     79     109    Ljava/lang/Error;
            //  51     59     75     153    Any
            //  61     67     70     75     Any
            //  71     73     70     75     Any
            //  80     93     75     153    Any
            //  95     101    104    109    Any
            //  105    107    104    109    Any
            //  110    123    75     153    Any
            //  125    131    133    138    Any
            //  134    136    133    138    Any
            //  140    146    148    153    Any
            //  149    151    148    153    Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IndexOutOfBoundsException: Index: 103, Size: 103
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
    }
}
