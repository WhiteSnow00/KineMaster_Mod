// 
// Decompiled by Procyon v0.6.0
// 

package androidx.multidex;

import java.util.Iterator;
import java.util.Collection;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.List;
import dalvik.system.BaseDexClassLoader;
import android.content.pm.ApplicationInfo;
import java.util.Arrays;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.io.IOException;
import android.util.Log;
import android.content.Context;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.io.File;
import java.util.Set;

public final class a
{
    private static final Set<File> a;
    private static final boolean b;
    
    static {
        a = new HashSet<File>();
        b = n(System.getProperty("java.vm.version"));
    }
    
    static Field a(final Object o, final String s) throws NoSuchFieldException {
        return g(o, s);
    }
    
    static void b(final Object o, final String s, final Object[] array) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        f(o, s, array);
    }
    
    static Method c(final Object o, final String s, final Class[] array) throws NoSuchMethodException {
        return h(o, s, (Class<?>[])array);
    }
    
    private static void d(final Context context) throws Exception {
        final File file = new File(context.getFilesDir(), "secondary-dexes");
        if (file.isDirectory()) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Clearing old secondary dex dir (");
            sb.append(file.getPath());
            sb.append(").");
            Log.i("MultiDex", sb.toString());
            final File[] listFiles = file.listFiles();
            if (listFiles == null) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("Failed to list secondary dex dir content (");
                sb2.append(file.getPath());
                sb2.append(").");
                Log.w("MultiDex", sb2.toString());
                return;
            }
            for (final File file2 : listFiles) {
                final StringBuilder sb3 = new StringBuilder();
                sb3.append("Trying to delete old file ");
                sb3.append(file2.getPath());
                sb3.append(" of size ");
                sb3.append(file2.length());
                Log.i("MultiDex", sb3.toString());
                if (!file2.delete()) {
                    final StringBuilder sb4 = new StringBuilder();
                    sb4.append("Failed to delete old file ");
                    sb4.append(file2.getPath());
                    Log.w("MultiDex", sb4.toString());
                }
                else {
                    final StringBuilder sb5 = new StringBuilder();
                    sb5.append("Deleted old file ");
                    sb5.append(file2.getPath());
                    Log.i("MultiDex", sb5.toString());
                }
            }
            if (!file.delete()) {
                final StringBuilder sb6 = new StringBuilder();
                sb6.append("Failed to delete secondary dex dir ");
                sb6.append(file.getPath());
                Log.w("MultiDex", sb6.toString());
            }
            else {
                final StringBuilder sb7 = new StringBuilder();
                sb7.append("Deleted old secondary dex dir ");
                sb7.append(file.getPath());
                Log.i("MultiDex", sb7.toString());
            }
        }
    }
    
    private static void e(final Context p0, final File p1, final File p2, final String p3, final String p4, final boolean p5) throws IOException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: astore          7
        //     5: aload           7
        //     7: monitorenter   
        //     8: aload           7
        //    10: aload_1        
        //    11: invokeinterface java/util/Set.contains:(Ljava/lang/Object;)Z
        //    16: ifeq            23
        //    19: aload           7
        //    21: monitorexit    
        //    22: return         
        //    23: aload           7
        //    25: aload_1        
        //    26: invokeinterface java/util/Set.add:(Ljava/lang/Object;)Z
        //    31: pop            
        //    32: getstatic       android/os/Build$VERSION.SDK_INT:I
        //    35: istore          6
        //    37: new             Ljava/lang/StringBuilder;
        //    40: astore          8
        //    42: aload           8
        //    44: invokespecial   java/lang/StringBuilder.<init>:()V
        //    47: aload           8
        //    49: ldc             "MultiDex is not guaranteed to work in SDK version "
        //    51: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    54: pop            
        //    55: aload           8
        //    57: iload           6
        //    59: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //    62: pop            
        //    63: aload           8
        //    65: ldc             ": SDK version higher than "
        //    67: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    70: pop            
        //    71: aload           8
        //    73: bipush          20
        //    75: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //    78: pop            
        //    79: aload           8
        //    81: ldc             " should be backed by "
        //    83: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    86: pop            
        //    87: aload           8
        //    89: ldc             "runtime with built-in multidex capabilty but it's not the "
        //    91: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    94: pop            
        //    95: aload           8
        //    97: ldc             "case here: java.vm.version=\""
        //    99: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   102: pop            
        //   103: aload           8
        //   105: ldc             "java.vm.version"
        //   107: invokestatic    java/lang/System.getProperty:(Ljava/lang/String;)Ljava/lang/String;
        //   110: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   113: pop            
        //   114: aload           8
        //   116: ldc             "\""
        //   118: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   121: pop            
        //   122: ldc             "MultiDex"
        //   124: aload           8
        //   126: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   129: invokestatic    android/util/Log.w:(Ljava/lang/String;Ljava/lang/String;)I
        //   132: pop            
        //   133: aload_0        
        //   134: invokestatic    androidx/multidex/a.j:(Landroid/content/Context;)Ljava/lang/ClassLoader;
        //   137: astore          8
        //   139: aload           8
        //   141: ifnonnull       148
        //   144: aload           7
        //   146: monitorexit    
        //   147: return         
        //   148: aload_0        
        //   149: invokestatic    androidx/multidex/a.d:(Landroid/content/Context;)V
        //   152: goto            167
        //   155: astore          9
        //   157: ldc             "MultiDex"
        //   159: ldc             "Something went wrong when trying to clear old MultiDex extraction, continuing without cleaning."
        //   161: aload           9
        //   163: invokestatic    android/util/Log.w:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   166: pop            
        //   167: aload_0        
        //   168: aload_2        
        //   169: aload_3        
        //   170: invokestatic    androidx/multidex/a.k:(Landroid/content/Context;Ljava/io/File;Ljava/lang/String;)Ljava/io/File;
        //   173: astore_3       
        //   174: new             Landroidx/multidex/MultiDexExtractor;
        //   177: astore_2       
        //   178: aload_2        
        //   179: aload_1        
        //   180: aload_3        
        //   181: invokespecial   androidx/multidex/MultiDexExtractor.<init>:(Ljava/io/File;Ljava/io/File;)V
        //   184: aconst_null    
        //   185: astore_1       
        //   186: aload_2        
        //   187: aload_0        
        //   188: aload           4
        //   190: iconst_0       
        //   191: invokevirtual   androidx/multidex/MultiDexExtractor.k:(Landroid/content/Context;Ljava/lang/String;Z)Ljava/util/List;
        //   194: astore          9
        //   196: aload           8
        //   198: aload_3        
        //   199: aload           9
        //   201: invokestatic    androidx/multidex/a.m:(Ljava/lang/ClassLoader;Ljava/io/File;Ljava/util/List;)V
        //   204: goto            238
        //   207: astore          9
        //   209: iload           5
        //   211: ifeq            258
        //   214: ldc             "MultiDex"
        //   216: ldc             "Failed to install extracted secondary dex files, retrying with forced extraction"
        //   218: aload           9
        //   220: invokestatic    android/util/Log.w:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   223: pop            
        //   224: aload           8
        //   226: aload_3        
        //   227: aload_2        
        //   228: aload_0        
        //   229: aload           4
        //   231: iconst_1       
        //   232: invokevirtual   androidx/multidex/MultiDexExtractor.k:(Landroid/content/Context;Ljava/lang/String;Z)Ljava/util/List;
        //   235: invokestatic    androidx/multidex/a.m:(Ljava/lang/ClassLoader;Ljava/io/File;Ljava/util/List;)V
        //   238: aload_2        
        //   239: invokevirtual   androidx/multidex/MultiDexExtractor.close:()V
        //   242: aload_1        
        //   243: astore_0       
        //   244: goto            248
        //   247: astore_0       
        //   248: aload_0        
        //   249: ifnonnull       256
        //   252: aload           7
        //   254: monitorexit    
        //   255: return         
        //   256: aload_0        
        //   257: athrow         
        //   258: aload           9
        //   260: athrow         
        //   261: astore_0       
        //   262: aload_2        
        //   263: invokevirtual   androidx/multidex/MultiDexExtractor.close:()V
        //   266: aload_0        
        //   267: athrow         
        //   268: astore_0       
        //   269: aload           7
        //   271: monitorexit    
        //   272: aload_0        
        //   273: athrow         
        //   274: astore_1       
        //   275: goto            266
        //    Exceptions:
        //  throws java.io.IOException
        //  throws java.lang.IllegalArgumentException
        //  throws java.lang.IllegalAccessException
        //  throws java.lang.NoSuchFieldException
        //  throws java.lang.reflect.InvocationTargetException
        //  throws java.lang.NoSuchMethodException
        //  throws java.lang.SecurityException
        //  throws java.lang.ClassNotFoundException
        //  throws java.lang.InstantiationException
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  8      22     268    274    Any
        //  23     139    268    274    Any
        //  144    147    268    274    Any
        //  148    152    155    167    Any
        //  157    167    268    274    Any
        //  167    184    268    274    Any
        //  186    196    261    268    Any
        //  196    204    207    238    Ljava/io/IOException;
        //  196    204    261    268    Any
        //  214    238    261    268    Any
        //  238    242    247    248    Ljava/io/IOException;
        //  238    242    268    274    Any
        //  252    255    268    274    Any
        //  256    258    268    274    Any
        //  258    261    261    268    Any
        //  262    266    274    278    Ljava/io/IOException;
        //  262    266    268    274    Any
        //  266    268    268    274    Any
        //  269    272    268    274    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0266:
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
    
    private static void f(final Object o, final String s, final Object[] array) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        final Field g = g(o, s);
        final Object[] array2 = (Object[])g.get(o);
        final Object[] array3 = (Object[])Array.newInstance(array2.getClass().getComponentType(), array2.length + array.length);
        System.arraycopy(array2, 0, array3, 0, array2.length);
        System.arraycopy(array, 0, array3, array2.length, array.length);
        g.set(o, array3);
    }
    
    private static Field g(final Object o, final String s) throws NoSuchFieldException {
        Class<?> clazz = o.getClass();
        while (clazz != null) {
            try {
                final Field declaredField = clazz.getDeclaredField(s);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            }
            catch (final NoSuchFieldException ex) {
                clazz = clazz.getSuperclass();
                continue;
            }
            break;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Field ");
        sb.append(s);
        sb.append(" not found in ");
        sb.append(o.getClass());
        throw new NoSuchFieldException(sb.toString());
    }
    
    private static Method h(final Object o, final String s, final Class<?>... array) throws NoSuchMethodException {
        Class<?> clazz = o.getClass();
        while (clazz != null) {
            try {
                final Method declaredMethod = clazz.getDeclaredMethod(s, array);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            }
            catch (final NoSuchMethodException ex) {
                clazz = clazz.getSuperclass();
                continue;
            }
            break;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Method ");
        sb.append(s);
        sb.append(" with parameters ");
        sb.append(Arrays.asList(array));
        sb.append(" not found in ");
        sb.append(o.getClass());
        throw new NoSuchMethodException(sb.toString());
    }
    
    private static ApplicationInfo i(final Context context) {
        try {
            return context.getApplicationInfo();
        }
        catch (final RuntimeException ex) {
            Log.w("MultiDex", "Failure while trying to obtain ApplicationInfo from Context. Must be running in test mode. Skip patching.", (Throwable)ex);
            return null;
        }
    }
    
    private static ClassLoader j(final Context context) {
        try {
            final ClassLoader classLoader = context.getClassLoader();
            if (classLoader instanceof BaseDexClassLoader) {
                return classLoader;
            }
            Log.e("MultiDex", "Context class loader is null or not dex-capable. Must be running in test mode. Skip patching.");
            return null;
        }
        catch (final RuntimeException ex) {
            Log.w("MultiDex", "Failure while trying to obtain Context class loader. Must be running in test mode. Skip patching.", (Throwable)ex);
            return null;
        }
    }
    
    private static File k(Context context, File file, final String s) throws IOException {
        file = new File(file, "code_cache");
        try {
            o(file);
            context = (Context)file;
        }
        catch (final IOException ex) {
            context = (Context)new File(context.getFilesDir(), "code_cache");
            o((File)context);
        }
        final File file2 = new File((File)context, s);
        o(file2);
        return file2;
    }
    
    public static void l(final Context context) {
        Log.i("MultiDex", "Installing application");
        if (androidx.multidex.a.b) {
            Log.i("MultiDex", "VM has multidex support, MultiDex support library is disabled.");
            return;
        }
        try {
            final ApplicationInfo i = i(context);
            if (i == null) {
                Log.i("MultiDex", "No ApplicationInfo available, i.e. running on a test Context: MultiDex support library is disabled.");
                return;
            }
            e(context, new File(i.sourceDir), new File(i.dataDir), "secondary-dexes", "", true);
            Log.i("MultiDex", "install done");
        }
        catch (final Exception ex) {
            Log.e("MultiDex", "MultiDex installation failure", (Throwable)ex);
            final StringBuilder sb = new StringBuilder();
            sb.append("MultiDex installation failed (");
            sb.append(ex.getMessage());
            sb.append(").");
            throw new RuntimeException(sb.toString());
        }
    }
    
    private static void m(final ClassLoader classLoader, final File file, final List<? extends File> list) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException, SecurityException, ClassNotFoundException, InstantiationException {
        if (!list.isEmpty()) {
            androidx.multidex.a.a.a(classLoader, list, file);
        }
    }
    
    static boolean n(String s) {
        boolean b2;
        final boolean b = b2 = false;
        while (true) {
            if (s == null) {
                break Label_0115;
            }
            final StringTokenizer stringTokenizer = new StringTokenizer(s, ".");
            final boolean hasMoreTokens = stringTokenizer.hasMoreTokens();
            String nextToken = null;
            String nextToken2;
            if (hasMoreTokens) {
                nextToken2 = stringTokenizer.nextToken();
            }
            else {
                nextToken2 = null;
            }
            if (stringTokenizer.hasMoreTokens()) {
                nextToken = stringTokenizer.nextToken();
            }
            b2 = b;
            if (nextToken2 == null) {
                break Label_0115;
            }
            b2 = b;
            if (nextToken == null) {
                break Label_0115;
            }
            try {
                final int int1 = Integer.parseInt(nextToken2);
                final int int2 = Integer.parseInt(nextToken);
                if (int1 <= 2) {
                    b2 = b;
                    if (int1 != 2) {
                        break Label_0115;
                    }
                    b2 = b;
                    if (int2 < 1) {
                        break Label_0115;
                    }
                }
                b2 = true;
                final StringBuilder sb = new StringBuilder();
                sb.append("VM with version ");
                sb.append(s);
                if (b2) {
                    s = " has multidex support";
                }
                else {
                    s = " does not have multidex support";
                }
                sb.append(s);
                Log.i("MultiDex", sb.toString());
                return b2;
            }
            catch (final NumberFormatException ex) {
                b2 = b;
                continue;
            }
            break;
        }
    }
    
    private static void o(final File file) throws IOException {
        file.mkdir();
        if (!file.isDirectory()) {
            final File parentFile = file.getParentFile();
            if (parentFile == null) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Failed to create dir ");
                sb.append(file.getPath());
                sb.append(". Parent file is null.");
                Log.e("MultiDex", sb.toString());
            }
            else {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("Failed to create dir ");
                sb2.append(file.getPath());
                sb2.append(". parent file is a dir ");
                sb2.append(parentFile.isDirectory());
                sb2.append(", a file ");
                sb2.append(parentFile.isFile());
                sb2.append(", exists ");
                sb2.append(parentFile.exists());
                sb2.append(", readable ");
                sb2.append(parentFile.canRead());
                sb2.append(", writable ");
                sb2.append(parentFile.canWrite());
                Log.e("MultiDex", sb2.toString());
            }
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("Failed to create directory ");
            sb3.append(file.getPath());
            throw new IOException(sb3.toString());
        }
    }
    
    private static final class a
    {
        static void a(final ClassLoader classLoader, final List<? extends File> list, final File file) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException {
            final Object value = androidx.multidex.a.a(classLoader, "pathList").get(classLoader);
            final ArrayList list2 = new ArrayList();
            androidx.multidex.a.b(value, "dexElements", b(value, new ArrayList<File>(list), file, list2));
            if (list2.size() > 0) {
                final Iterator iterator = list2.iterator();
                while (iterator.hasNext()) {
                    Log.w("MultiDex", "Exception in makeDexElement", (Throwable)iterator.next());
                }
                final Field a = androidx.multidex.a.a(value, "dexElementsSuppressedExceptions");
                final IOException[] array = (IOException[])a.get(value);
                IOException[] array2;
                if (array == null) {
                    array2 = list2.toArray(new IOException[list2.size()]);
                }
                else {
                    array2 = new IOException[list2.size() + array.length];
                    list2.toArray(array2);
                    System.arraycopy(array, 0, array2, list2.size(), array.length);
                }
                a.set(value, array2);
                final IOException ex = new IOException("I/O exception during makeDexElement");
                ex.initCause(list2.get(0));
                throw ex;
            }
        }
        
        private static Object[] b(final Object o, final ArrayList<File> list, final File file, final ArrayList<IOException> list2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
            return (Object[])androidx.multidex.a.c(o, "makeDexElements", new Class[] { ArrayList.class, File.class, ArrayList.class }).invoke(o, list, file, list2);
        }
    }
}
