// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.HashMap;
import android.content.ComponentName;
import android.os.IBinder;
import java.util.Map;
import android.content.ServiceConnection;

final class m implements ServiceConnection, zzs
{
    private final Map a;
    private int b;
    private boolean c;
    private IBinder d;
    private final zzn e;
    private ComponentName f;
    final o g;
    
    public m(final o g, final zzn e) {
        this.g = g;
        this.e = e;
        this.a = new HashMap();
        this.b = 2;
    }
    
    public final int a() {
        return this.b;
    }
    
    public final ComponentName b() {
        return this.f;
    }
    
    public final IBinder c() {
        return this.d;
    }
    
    public final void d(final ServiceConnection serviceConnection, final ServiceConnection serviceConnection2, final String s) {
        this.a.put(serviceConnection, serviceConnection2);
    }
    
    public final void e(final String p0, final Executor p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: iconst_3       
        //     2: putfield        com/google/android/gms/common/internal/m.b:I
        //     5: invokestatic    android/os/StrictMode.getVmPolicy:()Landroid/os/StrictMode$VmPolicy;
        //     8: astore          4
        //    10: invokestatic    com/google/android/gms/common/util/PlatformVersion.m:()Z
        //    13: ifeq            34
        //    16: new             Landroid/os/StrictMode$VmPolicy$Builder;
        //    19: dup            
        //    20: aload           4
        //    22: invokespecial   android/os/StrictMode$VmPolicy$Builder.<init>:(Landroid/os/StrictMode$VmPolicy;)V
        //    25: invokevirtual   android/os/StrictMode$VmPolicy$Builder.permitUnsafeIntentLaunch:()Landroid/os/StrictMode$VmPolicy$Builder;
        //    28: invokevirtual   android/os/StrictMode$VmPolicy$Builder.build:()Landroid/os/StrictMode$VmPolicy;
        //    31: invokestatic    android/os/StrictMode.setVmPolicy:(Landroid/os/StrictMode$VmPolicy;)V
        //    34: aload_0        
        //    35: getfield        com/google/android/gms/common/internal/m.g:Lcom/google/android/gms/common/internal/o;
        //    38: astore          5
        //    40: aload           5
        //    42: invokestatic    com/google/android/gms/common/internal/o.l:(Lcom/google/android/gms/common/internal/o;)Lcom/google/android/gms/common/stats/ConnectionTracker;
        //    45: aload           5
        //    47: invokestatic    com/google/android/gms/common/internal/o.j:(Lcom/google/android/gms/common/internal/o;)Landroid/content/Context;
        //    50: aload_1        
        //    51: aload_0        
        //    52: getfield        com/google/android/gms/common/internal/m.e:Lcom/google/android/gms/common/internal/zzn;
        //    55: aload           5
        //    57: invokestatic    com/google/android/gms/common/internal/o.j:(Lcom/google/android/gms/common/internal/o;)Landroid/content/Context;
        //    60: invokevirtual   com/google/android/gms/common/internal/zzn.c:(Landroid/content/Context;)Landroid/content/Intent;
        //    63: aload_0        
        //    64: aload_0        
        //    65: getfield        com/google/android/gms/common/internal/m.e:Lcom/google/android/gms/common/internal/zzn;
        //    68: invokevirtual   com/google/android/gms/common/internal/zzn.a:()I
        //    71: aload_2        
        //    72: invokevirtual   com/google/android/gms/common/stats/ConnectionTracker.d:(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Landroid/content/ServiceConnection;ILjava/util/concurrent/Executor;)Z
        //    75: istore_3       
        //    76: aload_0        
        //    77: iload_3        
        //    78: putfield        com/google/android/gms/common/internal/m.c:Z
        //    81: iload_3        
        //    82: ifeq            123
        //    85: aload_0        
        //    86: getfield        com/google/android/gms/common/internal/m.g:Lcom/google/android/gms/common/internal/o;
        //    89: invokestatic    com/google/android/gms/common/internal/o.k:(Lcom/google/android/gms/common/internal/o;)Landroid/os/Handler;
        //    92: iconst_1       
        //    93: aload_0        
        //    94: getfield        com/google/android/gms/common/internal/m.e:Lcom/google/android/gms/common/internal/zzn;
        //    97: invokevirtual   android/os/Handler.obtainMessage:(ILjava/lang/Object;)Landroid/os/Message;
        //   100: astore_1       
        //   101: aload_0        
        //   102: getfield        com/google/android/gms/common/internal/m.g:Lcom/google/android/gms/common/internal/o;
        //   105: invokestatic    com/google/android/gms/common/internal/o.k:(Lcom/google/android/gms/common/internal/o;)Landroid/os/Handler;
        //   108: aload_1        
        //   109: aload_0        
        //   110: getfield        com/google/android/gms/common/internal/m.g:Lcom/google/android/gms/common/internal/o;
        //   113: invokestatic    com/google/android/gms/common/internal/o.i:(Lcom/google/android/gms/common/internal/o;)J
        //   116: invokevirtual   android/os/Handler.sendMessageDelayed:(Landroid/os/Message;J)Z
        //   119: pop            
        //   120: goto            145
        //   123: aload_0        
        //   124: iconst_2       
        //   125: putfield        com/google/android/gms/common/internal/m.b:I
        //   128: aload_0        
        //   129: getfield        com/google/android/gms/common/internal/m.g:Lcom/google/android/gms/common/internal/o;
        //   132: astore_1       
        //   133: aload_1        
        //   134: invokestatic    com/google/android/gms/common/internal/o.l:(Lcom/google/android/gms/common/internal/o;)Lcom/google/android/gms/common/stats/ConnectionTracker;
        //   137: aload_1        
        //   138: invokestatic    com/google/android/gms/common/internal/o.j:(Lcom/google/android/gms/common/internal/o;)Landroid/content/Context;
        //   141: aload_0        
        //   142: invokevirtual   com/google/android/gms/common/stats/ConnectionTracker.c:(Landroid/content/Context;Landroid/content/ServiceConnection;)V
        //   145: aload           4
        //   147: invokestatic    android/os/StrictMode.setVmPolicy:(Landroid/os/StrictMode$VmPolicy;)V
        //   150: return         
        //   151: astore_1       
        //   152: aload           4
        //   154: invokestatic    android/os/StrictMode.setVmPolicy:(Landroid/os/StrictMode$VmPolicy;)V
        //   157: aload_1        
        //   158: athrow         
        //   159: astore_1       
        //   160: goto            145
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                
        //  -----  -----  -----  -----  ------------------------------------
        //  34     81     151    159    Any
        //  85     120    151    159    Any
        //  123    128    151    159    Any
        //  128    145    159    163    Ljava/lang/IllegalArgumentException;
        //  128    145    151    159    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0145:
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
    
    public final void f(final ServiceConnection serviceConnection, final String s) {
        this.a.remove(serviceConnection);
    }
    
    public final void g(final String s) {
        o.k(this.g).removeMessages(1, (Object)this.e);
        final o g = this.g;
        o.l(g).c(o.j(g), (ServiceConnection)this);
        this.c = false;
        this.b = 2;
    }
    
    public final boolean h(final ServiceConnection serviceConnection) {
        return this.a.containsKey(serviceConnection);
    }
    
    public final boolean i() {
        return this.a.isEmpty();
    }
    
    public final boolean j() {
        return this.c;
    }
    
    public final void onServiceConnected(final ComponentName f, final IBinder d) {
        synchronized (o.m(this.g)) {
            o.k(this.g).removeMessages(1, (Object)this.e);
            this.d = d;
            this.f = f;
            final Iterator iterator = this.a.values().iterator();
            while (iterator.hasNext()) {
                ((ServiceConnection)iterator.next()).onServiceConnected(f, d);
            }
            this.b = 1;
        }
    }
    
    public final void onServiceDisconnected(final ComponentName f) {
        synchronized (o.m(this.g)) {
            o.k(this.g).removeMessages(1, (Object)this.e);
            this.d = null;
            this.f = f;
            final Iterator iterator = this.a.values().iterator();
            while (iterator.hasNext()) {
                ((ServiceConnection)iterator.next()).onServiceDisconnected(f);
            }
            this.b = 2;
        }
    }
}
