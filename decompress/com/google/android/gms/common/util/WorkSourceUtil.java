// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.util;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager$NameNotFoundException;
import com.google.android.gms.common.wrappers.Wrappers;
import android.content.Context;
import android.util.Log;
import android.os.WorkSource;
import java.lang.reflect.Method;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class WorkSourceUtil
{
    private static final int a;
    private static final Method b;
    private static final Method c;
    private static final Method d;
    private static final Method e;
    private static final Method f;
    private static final Method g;
    private static final Method h;
    private static final Method i;
    
    static {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: putstatic       com/google/android/gms/common/util/WorkSourceUtil.a:I
        //     6: aconst_null    
        //     7: astore_1       
        //     8: aconst_null    
        //     9: astore_2       
        //    10: ldc             Landroid/os/WorkSource;.class
        //    12: ldc             "add"
        //    14: iconst_1       
        //    15: anewarray       Ljava/lang/Class;
        //    18: dup            
        //    19: iconst_0       
        //    20: getstatic       java/lang/Integer.TYPE:Ljava/lang/Class;
        //    23: aastore        
        //    24: invokevirtual   java/lang/Class.getMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
        //    27: astore_0       
        //    28: goto            34
        //    31: astore_0       
        //    32: aconst_null    
        //    33: astore_0       
        //    34: aload_0        
        //    35: putstatic       com/google/android/gms/common/util/WorkSourceUtil.b:Ljava/lang/reflect/Method;
        //    38: invokestatic    com/google/android/gms/common/util/PlatformVersion.c:()Z
        //    41: ifeq            70
        //    44: ldc             Landroid/os/WorkSource;.class
        //    46: ldc             "add"
        //    48: iconst_2       
        //    49: anewarray       Ljava/lang/Class;
        //    52: dup            
        //    53: iconst_0       
        //    54: getstatic       java/lang/Integer.TYPE:Ljava/lang/Class;
        //    57: aastore        
        //    58: dup            
        //    59: iconst_1       
        //    60: ldc             Ljava/lang/String;.class
        //    62: aastore        
        //    63: invokevirtual   java/lang/Class.getMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
        //    66: astore_0       
        //    67: goto            72
        //    70: aconst_null    
        //    71: astore_0       
        //    72: aload_0        
        //    73: putstatic       com/google/android/gms/common/util/WorkSourceUtil.c:Ljava/lang/reflect/Method;
        //    76: ldc             Landroid/os/WorkSource;.class
        //    78: ldc             "size"
        //    80: iconst_0       
        //    81: anewarray       Ljava/lang/Class;
        //    84: invokevirtual   java/lang/Class.getMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
        //    87: astore_0       
        //    88: goto            94
        //    91: astore_0       
        //    92: aconst_null    
        //    93: astore_0       
        //    94: aload_0        
        //    95: putstatic       com/google/android/gms/common/util/WorkSourceUtil.d:Ljava/lang/reflect/Method;
        //    98: ldc             Landroid/os/WorkSource;.class
        //   100: ldc             "get"
        //   102: iconst_1       
        //   103: anewarray       Ljava/lang/Class;
        //   106: dup            
        //   107: iconst_0       
        //   108: getstatic       java/lang/Integer.TYPE:Ljava/lang/Class;
        //   111: aastore        
        //   112: invokevirtual   java/lang/Class.getMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
        //   115: astore_0       
        //   116: goto            122
        //   119: astore_0       
        //   120: aconst_null    
        //   121: astore_0       
        //   122: aload_0        
        //   123: putstatic       com/google/android/gms/common/util/WorkSourceUtil.e:Ljava/lang/reflect/Method;
        //   126: invokestatic    com/google/android/gms/common/util/PlatformVersion.c:()Z
        //   129: ifeq            153
        //   132: ldc             Landroid/os/WorkSource;.class
        //   134: ldc             "getName"
        //   136: iconst_1       
        //   137: anewarray       Ljava/lang/Class;
        //   140: dup            
        //   141: iconst_0       
        //   142: getstatic       java/lang/Integer.TYPE:Ljava/lang/Class;
        //   145: aastore        
        //   146: invokevirtual   java/lang/Class.getMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
        //   149: astore_0       
        //   150: goto            155
        //   153: aconst_null    
        //   154: astore_0       
        //   155: aload_0        
        //   156: putstatic       com/google/android/gms/common/util/WorkSourceUtil.f:Ljava/lang/reflect/Method;
        //   159: invokestatic    com/google/android/gms/common/util/PlatformVersion.j:()Z
        //   162: ifeq            190
        //   165: ldc             Landroid/os/WorkSource;.class
        //   167: ldc             "createWorkChain"
        //   169: iconst_0       
        //   170: anewarray       Ljava/lang/Class;
        //   173: invokevirtual   java/lang/Class.getMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
        //   176: astore_0       
        //   177: goto            192
        //   180: astore_0       
        //   181: ldc             "WorkSourceUtil"
        //   183: ldc             "Missing WorkChain API createWorkChain"
        //   185: aload_0        
        //   186: invokestatic    android/util/Log.w:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   189: pop            
        //   190: aconst_null    
        //   191: astore_0       
        //   192: aload_0        
        //   193: putstatic       com/google/android/gms/common/util/WorkSourceUtil.g:Ljava/lang/reflect/Method;
        //   196: invokestatic    com/google/android/gms/common/util/PlatformVersion.j:()Z
        //   199: ifeq            241
        //   202: ldc             "android.os.WorkSource$WorkChain"
        //   204: invokestatic    java/lang/Class.forName:(Ljava/lang/String;)Ljava/lang/Class;
        //   207: ldc             "addNode"
        //   209: iconst_2       
        //   210: anewarray       Ljava/lang/Class;
        //   213: dup            
        //   214: iconst_0       
        //   215: getstatic       java/lang/Integer.TYPE:Ljava/lang/Class;
        //   218: aastore        
        //   219: dup            
        //   220: iconst_1       
        //   221: ldc             Ljava/lang/String;.class
        //   223: aastore        
        //   224: invokevirtual   java/lang/Class.getMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
        //   227: astore_0       
        //   228: goto            243
        //   231: astore_0       
        //   232: ldc             "WorkSourceUtil"
        //   234: ldc             "Missing WorkChain class"
        //   236: aload_0        
        //   237: invokestatic    android/util/Log.w:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   240: pop            
        //   241: aconst_null    
        //   242: astore_0       
        //   243: aload_0        
        //   244: putstatic       com/google/android/gms/common/util/WorkSourceUtil.h:Ljava/lang/reflect/Method;
        //   247: aload_2        
        //   248: astore_0       
        //   249: invokestatic    com/google/android/gms/common/util/PlatformVersion.j:()Z
        //   252: ifeq            278
        //   255: aload_1        
        //   256: astore_0       
        //   257: ldc             Landroid/os/WorkSource;.class
        //   259: ldc             "isEmpty"
        //   261: iconst_0       
        //   262: anewarray       Ljava/lang/Class;
        //   265: invokevirtual   java/lang/Class.getMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
        //   268: astore_1       
        //   269: aload_1        
        //   270: astore_0       
        //   271: aload_1        
        //   272: iconst_1       
        //   273: invokevirtual   java/lang/reflect/Method.setAccessible:(Z)V
        //   276: aload_1        
        //   277: astore_0       
        //   278: aload_0        
        //   279: putstatic       com/google/android/gms/common/util/WorkSourceUtil.i:Ljava/lang/reflect/Method;
        //   282: return         
        //   283: astore_0       
        //   284: goto            70
        //   287: astore_0       
        //   288: goto            153
        //   291: astore_1       
        //   292: goto            278
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  10     28     31     34     Ljava/lang/Exception;
        //  44     67     283    287    Ljava/lang/Exception;
        //  76     88     91     94     Ljava/lang/Exception;
        //  98     116    119    122    Ljava/lang/Exception;
        //  132    150    287    291    Ljava/lang/Exception;
        //  165    177    180    190    Ljava/lang/Exception;
        //  202    228    231    241    Ljava/lang/Exception;
        //  257    269    291    295    Ljava/lang/Exception;
        //  271    276    291    295    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 163, Size: 163
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
    
    private WorkSourceUtil() {
    }
    
    @KeepForSdk
    public static void a(final WorkSource workSource, final int n, final String s) {
        final Method c = WorkSourceUtil.c;
        if (c != null) {
            String s2;
            if ((s2 = s) == null) {
                s2 = "";
            }
            try {
                c.invoke(workSource, n, s2);
                return;
            }
            catch (final Exception ex) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", (Throwable)ex);
                return;
            }
        }
        final Method b = WorkSourceUtil.b;
        if (b != null) {
            try {
                b.invoke(workSource, n);
            }
            catch (final Exception ex2) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", (Throwable)ex2);
            }
        }
    }
    
    @KeepForSdk
    public static WorkSource b(final Context context, final String s) {
        if (context != null && context.getPackageManager() != null && s != null) {
            try {
                final ApplicationInfo c = Wrappers.a(context).c(s, 0);
                if (c == null) {
                    Log.e("WorkSourceUtil", "Could not get applicationInfo from package: ".concat(s));
                    return null;
                }
                final int uid = c.uid;
                final WorkSource workSource = new WorkSource();
                a(workSource, uid, s);
                return workSource;
            }
            catch (final PackageManager$NameNotFoundException ex) {
                Log.e("WorkSourceUtil", "Could not find package: ".concat(s));
            }
        }
        return null;
    }
    
    @KeepForSdk
    public static boolean c(final Context context) {
        return context != null && context.getPackageManager() != null && Wrappers.a(context).b("android.permission.UPDATE_DEVICE_STATS", context.getPackageName()) == 0;
    }
}
