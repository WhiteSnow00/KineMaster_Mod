// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.common;

import java.util.HashMap;
import java.util.Map;
import android.os.Build;
import android.os.Debug;
import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;
import android.text.TextUtils;
import android.content.SharedPreferences;
import android.content.res.Resources$NotFoundException;
import android.hardware.SensorManager;
import android.content.res.Resources;
import android.app.ActivityManager$RunningAppProcessInfo;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Collections;
import java.util.Locale;
import java.util.ArrayList;
import java.io.IOException;
import com.google.firebase.crashlytics.internal.Logger;
import java.io.Closeable;
import android.net.NetworkInfo;
import android.net.ConnectivityManager;
import android.os.StatFs;
import android.app.ActivityManager;
import android.app.ActivityManager$MemoryInfo;
import android.content.Context;
import java.util.Scanner;
import java.io.InputStream;

public class CommonUtils
{
    private static final char[] a;
    private static long b;
    
    static {
        a = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
        CommonUtils.b = -1L;
    }
    
    public static String A(final InputStream inputStream) {
        final Scanner useDelimiter = new Scanner(inputStream).useDelimiter("\\A");
        String next;
        if (useDelimiter.hasNext()) {
            next = useDelimiter.next();
        }
        else {
            next = "";
        }
        return next;
    }
    
    public static long a(final Context context) {
        final ActivityManager$MemoryInfo activityManager$MemoryInfo = new ActivityManager$MemoryInfo();
        ((ActivityManager)context.getSystemService("activity")).getMemoryInfo(activityManager$MemoryInfo);
        return activityManager$MemoryInfo.availMem;
    }
    
    public static long b(final String s) {
        final StatFs statFs = new StatFs(s);
        final long n = statFs.getBlockSize();
        return statFs.getBlockCount() * n - n * statFs.getAvailableBlocks();
    }
    
    public static boolean c(final Context context) {
        final boolean d = d(context, "android.permission.ACCESS_NETWORK_STATE");
        boolean b = true;
        if (d) {
            final NetworkInfo activeNetworkInfo = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
            b = (activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting() && b);
        }
        return b;
    }
    
    public static boolean d(final Context context, final String s) {
        return context.checkCallingOrSelfPermission(s) == 0;
    }
    
    public static void e(final Closeable closeable, final String s) {
        if (closeable != null) {
            try {
                closeable.close();
            }
            catch (final IOException ex) {
                Logger.f().e(s, ex);
            }
        }
    }
    
    public static void f(final Closeable closeable) {
        if (closeable == null) {
            goto Label_0016;
        }
        try {
            closeable.close();
            goto Label_0016;
        }
        catch (final RuntimeException ex) {
            throw ex;
        }
        catch (final Exception ex2) {
            goto Label_0016;
        }
    }
    
    static long g(final String s, final String s2, final int n) {
        return Long.parseLong(s.split(s2)[0].trim()) * n;
    }
    
    public static String h(final String... array) {
        String z;
        final String s = z = null;
        if (array != null) {
            if (array.length == 0) {
                z = s;
            }
            else {
                final ArrayList list = new ArrayList();
                for (final String s2 : array) {
                    if (s2 != null) {
                        list.add(s2.replace("-", "").toLowerCase(Locale.US));
                    }
                }
                Collections.sort((List<Comparable>)list);
                final StringBuilder sb = new StringBuilder();
                final Iterator iterator = list.iterator();
                while (iterator.hasNext()) {
                    sb.append((String)iterator.next());
                }
                final String string = sb.toString();
                z = s;
                if (string.length() > 0) {
                    z = z(string);
                }
            }
        }
        return z;
    }
    
    public static String i(final File p0, final String p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   java/io/File.exists:()Z
        //     4: istore_2       
        //     5: aconst_null    
        //     6: astore          5
        //     8: aconst_null    
        //     9: astore          4
        //    11: aconst_null    
        //    12: astore          6
        //    14: iload_2        
        //    15: ifeq            226
        //    18: new             Ljava/io/BufferedReader;
        //    21: astore_3       
        //    22: new             Ljava/io/FileReader;
        //    25: astore          4
        //    27: aload           4
        //    29: aload_0        
        //    30: invokespecial   java/io/FileReader.<init>:(Ljava/io/File;)V
        //    33: aload_3        
        //    34: aload           4
        //    36: sipush          1024
        //    39: invokespecial   java/io/BufferedReader.<init>:(Ljava/io/Reader;I)V
        //    42: aload_3        
        //    43: astore          4
        //    45: aload_3        
        //    46: invokevirtual   java/io/BufferedReader.readLine:()Ljava/lang/String;
        //    49: astore          7
        //    51: aload_3        
        //    52: astore          5
        //    54: aload           6
        //    56: astore          4
        //    58: aload           7
        //    60: ifnull          112
        //    63: aload_3        
        //    64: astore          4
        //    66: ldc             "\\s*:\\s*"
        //    68: invokestatic    java/util/regex/Pattern.compile:(Ljava/lang/String;)Ljava/util/regex/Pattern;
        //    71: aload           7
        //    73: iconst_2       
        //    74: invokevirtual   java/util/regex/Pattern.split:(Ljava/lang/CharSequence;I)[Ljava/lang/String;
        //    77: astore          5
        //    79: aload_3        
        //    80: astore          4
        //    82: aload           5
        //    84: arraylength    
        //    85: iconst_1       
        //    86: if_icmple       42
        //    89: aload_3        
        //    90: astore          4
        //    92: aload           5
        //    94: iconst_0       
        //    95: aaload         
        //    96: aload_1        
        //    97: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   100: ifeq            42
        //   103: aload           5
        //   105: iconst_1       
        //   106: aaload         
        //   107: astore          4
        //   109: aload_3        
        //   110: astore          5
        //   112: aload           5
        //   114: ldc_w           "Failed to close system file reader."
        //   117: invokestatic    com/google/firebase/crashlytics/internal/common/CommonUtils.e:(Ljava/io/Closeable;Ljava/lang/String;)V
        //   120: goto            226
        //   123: astore          4
        //   125: aload_3        
        //   126: astore_1       
        //   127: aload           4
        //   129: astore_3       
        //   130: goto            143
        //   133: astore_0       
        //   134: aload           5
        //   136: astore_1       
        //   137: goto            217
        //   140: astore_3       
        //   141: aconst_null    
        //   142: astore_1       
        //   143: aload_1        
        //   144: astore          4
        //   146: invokestatic    com/google/firebase/crashlytics/internal/Logger.f:()Lcom/google/firebase/crashlytics/internal/Logger;
        //   149: astore          5
        //   151: aload_1        
        //   152: astore          4
        //   154: new             Ljava/lang/StringBuilder;
        //   157: astore          7
        //   159: aload_1        
        //   160: astore          4
        //   162: aload           7
        //   164: invokespecial   java/lang/StringBuilder.<init>:()V
        //   167: aload_1        
        //   168: astore          4
        //   170: aload           7
        //   172: ldc_w           "Error parsing "
        //   175: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   178: pop            
        //   179: aload_1        
        //   180: astore          4
        //   182: aload           7
        //   184: aload_0        
        //   185: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   188: pop            
        //   189: aload_1        
        //   190: astore          4
        //   192: aload           5
        //   194: aload           7
        //   196: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   199: aload_3        
        //   200: invokevirtual   com/google/firebase/crashlytics/internal/Logger.e:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   203: aload_1        
        //   204: astore          5
        //   206: aload           6
        //   208: astore          4
        //   210: goto            112
        //   213: astore_0       
        //   214: aload           4
        //   216: astore_1       
        //   217: aload_1        
        //   218: ldc_w           "Failed to close system file reader."
        //   221: invokestatic    com/google/firebase/crashlytics/internal/common/CommonUtils.e:(Ljava/io/Closeable;Ljava/lang/String;)V
        //   224: aload_0        
        //   225: athrow         
        //   226: aload           4
        //   228: areturn        
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  18     42     140    143    Ljava/lang/Exception;
        //  18     42     133    140    Any
        //  45     51     123    133    Ljava/lang/Exception;
        //  45     51     213    217    Any
        //  66     79     123    133    Ljava/lang/Exception;
        //  66     79     213    217    Any
        //  82     89     123    133    Ljava/lang/Exception;
        //  82     89     213    217    Any
        //  92     103    123    133    Ljava/lang/Exception;
        //  92     103    213    217    Any
        //  146    151    213    217    Any
        //  154    159    213    217    Any
        //  162    167    213    217    Any
        //  170    179    213    217    Any
        //  182    189    213    217    Any
        //  192    203    213    217    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0112:
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
    
    public static ActivityManager$RunningAppProcessInfo j(final String s, final Context context) {
        final List runningAppProcesses = ((ActivityManager)context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (final ActivityManager$RunningAppProcessInfo activityManager$RunningAppProcessInfo : runningAppProcesses) {
                if (activityManager$RunningAppProcessInfo.processName.equals(s)) {
                    return activityManager$RunningAppProcessInfo;
                }
            }
        }
        return null;
    }
    
    public static boolean k(final Context context, final String s, final boolean b) {
        if (context != null) {
            final Resources resources = context.getResources();
            if (resources != null) {
                final int q = q(context, s, "bool");
                if (q > 0) {
                    return resources.getBoolean(q);
                }
                final int q2 = q(context, s, "string");
                if (q2 > 0) {
                    return Boolean.parseBoolean(context.getString(q2));
                }
            }
        }
        return b;
    }
    
    public static int l() {
        return Architecture.getValue().ordinal();
    }
    
    public static int m() {
        int x;
        final boolean b = (x = (x() ? 1 : 0)) != 0;
        if (y()) {
            x = ((b ? 1 : 0) | 0x2);
        }
        int n = x;
        if (w()) {
            n = (x | 0x4);
        }
        return n;
    }
    
    public static String n(final Context context) {
        int n;
        if ((n = q(context, "com.google.firebase.crashlytics.mapping_file_id", "string")) == 0) {
            n = q(context, "com.crashlytics.android.build_id", "string");
        }
        String string;
        if (n != 0) {
            string = context.getResources().getString(n);
        }
        else {
            string = null;
        }
        return string;
    }
    
    public static boolean o(final Context context) {
        final boolean x = x();
        boolean b = false;
        if (x) {
            return false;
        }
        if (((SensorManager)context.getSystemService("sensor")).getDefaultSensor(8) != null) {
            b = true;
        }
        return b;
    }
    
    public static String p(final Context context) {
        final int icon = context.getApplicationContext().getApplicationInfo().icon;
        String s;
        if (icon > 0) {
            try {
                if ("android".equals(s = context.getResources().getResourcePackageName(icon))) {
                    s = context.getPackageName();
                }
            }
            catch (final Resources$NotFoundException ex) {
                s = context.getPackageName();
            }
        }
        else {
            s = context.getPackageName();
        }
        return s;
    }
    
    public static int q(final Context context, final String s, final String s2) {
        return context.getResources().getIdentifier(s, s2, p(context));
    }
    
    public static SharedPreferences r(final Context context) {
        return context.getSharedPreferences("com.google.firebase.crashlytics", 0);
    }
    
    public static long s() {
        synchronized (CommonUtils.class) {
            if (CommonUtils.b == -1L) {
                final long n = 0L;
                final String i = i(new File("/proc/meminfo"), "MemTotal");
                long b = n;
                if (!TextUtils.isEmpty((CharSequence)i)) {
                    final String upperCase = i.toUpperCase(Locale.US);
                    try {
                        if (upperCase.endsWith("KB")) {
                            b = g(upperCase, "KB", 1024);
                        }
                        else if (upperCase.endsWith("MB")) {
                            b = g(upperCase, "MB", 1048576);
                        }
                        else if (upperCase.endsWith("GB")) {
                            b = g(upperCase, "GB", 1073741824);
                        }
                        else {
                            final Logger f = Logger.f();
                            final StringBuilder sb = new StringBuilder();
                            sb.append("Unexpected meminfo format while computing RAM: ");
                            sb.append(upperCase);
                            f.k(sb.toString());
                            b = n;
                        }
                    }
                    catch (final NumberFormatException ex) {
                        final Logger f2 = Logger.f();
                        final StringBuilder sb2 = new StringBuilder();
                        sb2.append("Unexpected meminfo format while computing RAM: ");
                        sb2.append(upperCase);
                        f2.e(sb2.toString(), ex);
                        b = n;
                    }
                }
                CommonUtils.b = b;
            }
            return CommonUtils.b;
        }
    }
    
    private static String t(final String s, final String s2) {
        return u(s.getBytes(), s2);
    }
    
    private static String u(final byte[] array, final String s) {
        try {
            final MessageDigest instance = MessageDigest.getInstance(s);
            instance.update(array);
            return v(instance.digest());
        }
        catch (final NoSuchAlgorithmException ex) {
            final Logger f = Logger.f();
            final StringBuilder sb = new StringBuilder();
            sb.append("Could not create hashing algorithm: ");
            sb.append(s);
            sb.append(", returning empty string.");
            f.e(sb.toString(), ex);
            return "";
        }
    }
    
    public static String v(final byte[] array) {
        final char[] array2 = new char[array.length * 2];
        for (int i = 0; i < array.length; ++i) {
            final int n = array[i] & 0xFF;
            final int n2 = i * 2;
            final char[] a = CommonUtils.a;
            array2[n2] = a[n >>> 4];
            array2[n2 + 1] = a[n & 0xF];
        }
        return new String(array2);
    }
    
    public static boolean w() {
        return Debug.isDebuggerConnected() || Debug.waitingForDebugger();
    }
    
    public static boolean x() {
        if (!Build.PRODUCT.contains("sdk")) {
            final String hardware = Build.HARDWARE;
            if (!hardware.contains("goldfish")) {
                if (!hardware.contains("ranchu")) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static boolean y() {
        final boolean x = x();
        final String tags = Build.TAGS;
        if (!x && tags != null && tags.contains("test-keys")) {
            return true;
        }
        if (new File("/system/app/Superuser.apk").exists()) {
            return true;
        }
        final File file = new File("/system/xbin/su");
        return !x && file.exists();
    }
    
    public static String z(final String s) {
        return t(s, "SHA-1");
    }
    
    enum Architecture
    {
        private static final Architecture[] $VALUES;
        
        ARM64, 
        ARMV6, 
        ARMV7, 
        ARMV7S, 
        ARM_UNKNOWN, 
        PPC, 
        PPC64, 
        UNKNOWN, 
        X86_32, 
        X86_64;
        
        private static final Map<String, Architecture> matcher;
        
        static {
            final Architecture architecture;
            final Architecture architecture2;
            final Architecture architecture3;
            final Architecture architecture4;
            final Architecture architecture5;
            final Architecture architecture6;
            final Architecture architecture7;
            final Architecture architecture8;
            final Architecture architecture9;
            final Architecture architecture10;
            $VALUES = new Architecture[] { architecture, architecture2, architecture3, architecture4, architecture5, architecture6, architecture7, architecture8, architecture9, architecture10 };
            final HashMap matcher2 = new HashMap(4);
            (matcher = matcher2).put("armeabi-v7a", architecture7);
            matcher2.put("armeabi", architecture6);
            matcher2.put("arm64-v8a", architecture10);
            matcher2.put("x86", architecture);
        }
        
        static Architecture getValue() {
            final String cpu_ABI = Build.CPU_ABI;
            if (TextUtils.isEmpty((CharSequence)cpu_ABI)) {
                Logger.f().i("Architecture#getValue()::Build.CPU_ABI returned null or empty");
                return Architecture.UNKNOWN;
            }
            Architecture unknown;
            if ((unknown = Architecture.matcher.get(cpu_ABI.toLowerCase(Locale.US))) == null) {
                unknown = Architecture.UNKNOWN;
            }
            return unknown;
        }
    }
}
