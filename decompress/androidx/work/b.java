// 
// Decompiled by Procyon v0.6.0
// 

package androidx.work;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.Arrays;
import java.io.IOException;
import android.util.Log;
import java.io.OutputStream;
import java.io.ObjectOutputStream;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import e1.h;
import java.util.Map;

public final class b
{
    private static final String b;
    public static final b c;
    Map<String, Object> a;
    
    static {
        b = h.f("Data");
        c = new a().a();
    }
    
    b() {
    }
    
    public b(final b b) {
        this.a = new HashMap<String, Object>(b.a);
    }
    
    public b(final Map<String, ?> map) {
        this.a = new HashMap<String, Object>(map);
    }
    
    public static Boolean[] a(final boolean[] array) {
        final Boolean[] array2 = new Boolean[array.length];
        for (int i = 0; i < array.length; ++i) {
            array2[i] = array[i];
        }
        return array2;
    }
    
    public static Byte[] b(final byte[] array) {
        final Byte[] array2 = new Byte[array.length];
        for (int i = 0; i < array.length; ++i) {
            array2[i] = array[i];
        }
        return array2;
    }
    
    public static Double[] c(final double[] array) {
        final Double[] array2 = new Double[array.length];
        for (int i = 0; i < array.length; ++i) {
            array2[i] = array[i];
        }
        return array2;
    }
    
    public static Float[] d(final float[] array) {
        final Float[] array2 = new Float[array.length];
        for (int i = 0; i < array.length; ++i) {
            array2[i] = array[i];
        }
        return array2;
    }
    
    public static Integer[] e(final int[] array) {
        final Integer[] array2 = new Integer[array.length];
        for (int i = 0; i < array.length; ++i) {
            array2[i] = array[i];
        }
        return array2;
    }
    
    public static Long[] f(final long[] array) {
        final Long[] array2 = new Long[array.length];
        for (int i = 0; i < array.length; ++i) {
            array2[i] = array[i];
        }
        return array2;
    }
    
    public static b g(final byte[] p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: arraylength    
        //     2: sipush          10240
        //     5: if_icmpgt       228
        //     8: new             Ljava/util/HashMap;
        //    11: dup            
        //    12: invokespecial   java/util/HashMap.<init>:()V
        //    15: astore          5
        //    17: new             Ljava/io/ByteArrayInputStream;
        //    20: dup            
        //    21: aload_0        
        //    22: invokespecial   java/io/ByteArrayInputStream.<init>:([B)V
        //    25: astore          4
        //    27: new             Ljava/io/ObjectInputStream;
        //    30: astore_2       
        //    31: aload_2        
        //    32: aload           4
        //    34: invokespecial   java/io/ObjectInputStream.<init>:(Ljava/io/InputStream;)V
        //    37: aload_2        
        //    38: astore_0       
        //    39: aload_2        
        //    40: invokevirtual   java/io/ObjectInputStream.readInt:()I
        //    43: istore_1       
        //    44: iload_1        
        //    45: ifle            72
        //    48: aload_2        
        //    49: astore_0       
        //    50: aload           5
        //    52: aload_2        
        //    53: invokevirtual   java/io/ObjectInputStream.readUTF:()Ljava/lang/String;
        //    56: aload_2        
        //    57: invokevirtual   java/io/ObjectInputStream.readObject:()Ljava/lang/Object;
        //    60: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    65: pop            
        //    66: iinc            1, -1
        //    69: goto            44
        //    72: aload_2        
        //    73: invokevirtual   java/io/ObjectInputStream.close:()V
        //    76: goto            90
        //    79: astore_0       
        //    80: getstatic       androidx/work/b.b:Ljava/lang/String;
        //    83: ldc             "Error in Data#fromByteArray: "
        //    85: aload_0        
        //    86: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //    89: pop            
        //    90: aload           4
        //    92: invokevirtual   java/io/ByteArrayInputStream.close:()V
        //    95: goto            174
        //    98: astore_3       
        //    99: goto            121
        //   102: astore_3       
        //   103: goto            121
        //   106: astore_2       
        //   107: aconst_null    
        //   108: astore_0       
        //   109: goto            185
        //   112: astore_0       
        //   113: goto            117
        //   116: astore_0       
        //   117: aconst_null    
        //   118: astore_2       
        //   119: aload_0        
        //   120: astore_3       
        //   121: aload_2        
        //   122: astore_0       
        //   123: getstatic       androidx/work/b.b:Ljava/lang/String;
        //   126: ldc             "Error in Data#fromByteArray: "
        //   128: aload_3        
        //   129: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   132: pop            
        //   133: aload_2        
        //   134: ifnull          155
        //   137: aload_2        
        //   138: invokevirtual   java/io/ObjectInputStream.close:()V
        //   141: goto            155
        //   144: astore_0       
        //   145: getstatic       androidx/work/b.b:Ljava/lang/String;
        //   148: ldc             "Error in Data#fromByteArray: "
        //   150: aload_0        
        //   151: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   154: pop            
        //   155: aload           4
        //   157: invokevirtual   java/io/ByteArrayInputStream.close:()V
        //   160: goto            174
        //   163: astore_0       
        //   164: getstatic       androidx/work/b.b:Ljava/lang/String;
        //   167: ldc             "Error in Data#fromByteArray: "
        //   169: aload_0        
        //   170: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   173: pop            
        //   174: new             Landroidx/work/b;
        //   177: dup            
        //   178: aload           5
        //   180: invokespecial   androidx/work/b.<init>:(Ljava/util/Map;)V
        //   183: areturn        
        //   184: astore_2       
        //   185: aload_0        
        //   186: ifnull          207
        //   189: aload_0        
        //   190: invokevirtual   java/io/ObjectInputStream.close:()V
        //   193: goto            207
        //   196: astore_0       
        //   197: getstatic       androidx/work/b.b:Ljava/lang/String;
        //   200: ldc             "Error in Data#fromByteArray: "
        //   202: aload_0        
        //   203: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   206: pop            
        //   207: aload           4
        //   209: invokevirtual   java/io/ByteArrayInputStream.close:()V
        //   212: goto            226
        //   215: astore_0       
        //   216: getstatic       androidx/work/b.b:Ljava/lang/String;
        //   219: ldc             "Error in Data#fromByteArray: "
        //   221: aload_0        
        //   222: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   225: pop            
        //   226: aload_2        
        //   227: athrow         
        //   228: new             Ljava/lang/IllegalStateException;
        //   231: dup            
        //   232: ldc             "Data cannot occupy more than 10240 bytes when serialized"
        //   234: invokespecial   java/lang/IllegalStateException.<init>:(Ljava/lang/String;)V
        //   237: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                              
        //  -----  -----  -----  -----  ----------------------------------
        //  27     37     116    117    Ljava/io/IOException;
        //  27     37     112    116    Ljava/lang/ClassNotFoundException;
        //  27     37     106    112    Any
        //  39     44     102    106    Ljava/io/IOException;
        //  39     44     98     102    Ljava/lang/ClassNotFoundException;
        //  39     44     184    185    Any
        //  50     66     102    106    Ljava/io/IOException;
        //  50     66     98     102    Ljava/lang/ClassNotFoundException;
        //  50     66     184    185    Any
        //  72     76     79     90     Ljava/io/IOException;
        //  90     95     163    174    Ljava/io/IOException;
        //  123    133    184    185    Any
        //  137    141    144    155    Ljava/io/IOException;
        //  155    160    163    174    Ljava/io/IOException;
        //  189    193    196    207    Ljava/io/IOException;
        //  207    212    215    226    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0044:
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
    
    public static byte[] k(final b b) {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        final ObjectOutputStream objectOutputStream = null;
        Object iterator;
        final Object o = iterator = null;
        ObjectOutputStream objectOutputStream2 = null;
        ObjectOutputStream objectOutputStream3;
        try {
            try {
                iterator = o;
                objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
                try {
                    objectOutputStream2.writeInt(b.j());
                    iterator = b.a.entrySet().iterator();
                    while (((Iterator)iterator).hasNext()) {
                        final Map.Entry<String, Object> entry = (Map.Entry<String, Object>)((Iterator)iterator).next();
                        objectOutputStream2.writeUTF(entry.getKey());
                        objectOutputStream2.writeObject(entry.getValue());
                    }
                    try {
                        objectOutputStream2.close();
                    }
                    catch (final IOException ex) {
                        Log.e(b.b, "Error in Data#toByteArray: ", (Throwable)ex);
                    }
                    try {
                        byteArrayOutputStream.close();
                    }
                    catch (final IOException ex2) {
                        Log.e(b.b, "Error in Data#toByteArray: ", (Throwable)ex2);
                    }
                    if (byteArrayOutputStream.size() <= 10240) {
                        return byteArrayOutputStream.toByteArray();
                    }
                    throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
                }
                catch (final IOException iterator) {}
                finally {
                    iterator = objectOutputStream2;
                }
            }
            finally {}
        }
        catch (final IOException objectOutputStream2) {
            objectOutputStream3 = objectOutputStream;
        }
        Log.e(b.b, "Error in Data#toByteArray: ", (Throwable)objectOutputStream2);
        final byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (objectOutputStream3 != null) {
            try {
                objectOutputStream3.close();
            }
            catch (final IOException ex3) {
                Log.e(b.b, "Error in Data#toByteArray: ", (Throwable)ex3);
            }
        }
        try {
            byteArrayOutputStream.close();
        }
        catch (final IOException ex4) {
            Log.e(b.b, "Error in Data#toByteArray: ", (Throwable)ex4);
        }
        return byteArray;
        if (iterator != null) {
            try {
                ((ObjectOutputStream)iterator).close();
            }
            catch (final IOException ex5) {
                Log.e(b.b, "Error in Data#toByteArray: ", (Throwable)ex5);
            }
        }
        try {
            byteArrayOutputStream.close();
        }
        catch (final IOException ex6) {
            Log.e(b.b, "Error in Data#toByteArray: ", (Throwable)ex6);
        }
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || b.class != o.getClass()) {
            return false;
        }
        final b b = (b)o;
        final Set<String> keySet = this.a.keySet();
        if (!keySet.equals(b.a.keySet())) {
            return false;
        }
        for (final String s : keySet) {
            final Object value = this.a.get(s);
            final Object value2 = b.a.get(s);
            boolean b2;
            if (value != null && value2 != null) {
                if (value instanceof Object[] && value2 instanceof Object[]) {
                    b2 = Arrays.deepEquals((Object[])value, (Object[])value2);
                }
                else {
                    b2 = value.equals(value2);
                }
            }
            else {
                b2 = (value == value2);
            }
            if (!b2) {
                return false;
            }
        }
        return true;
    }
    
    public Map<String, Object> h() {
        return Collections.unmodifiableMap((Map<? extends String, ?>)this.a);
    }
    
    @Override
    public int hashCode() {
        return this.a.hashCode() * 31;
    }
    
    public String i(final String s) {
        final String value = this.a.get(s);
        if (value instanceof String) {
            return value;
        }
        return null;
    }
    
    public int j() {
        return this.a.size();
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Data {");
        if (!this.a.isEmpty()) {
            for (final String s : this.a.keySet()) {
                sb.append(s);
                sb.append(" : ");
                final Object value = this.a.get(s);
                if (value instanceof Object[]) {
                    sb.append(Arrays.toString((Object[])value));
                }
                else {
                    sb.append(value);
                }
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }
    
    public static final class a
    {
        private Map<String, Object> a;
        
        public a() {
            this.a = new HashMap<String, Object>();
        }
        
        public b a() {
            final b b = new b(this.a);
            androidx.work.b.k(b);
            return b;
        }
        
        public a b(final String s, final Object o) {
            if (o == null) {
                this.a.put(s, null);
            }
            else {
                final Class<?> class1 = o.getClass();
                if (class1 != Boolean.class && class1 != Byte.class && class1 != Integer.class && class1 != Long.class && class1 != Float.class && class1 != Double.class && class1 != String.class && class1 != Boolean[].class && class1 != Byte[].class && class1 != Integer[].class && class1 != Long[].class && class1 != Float[].class && class1 != Double[].class && class1 != String[].class) {
                    if (class1 == boolean[].class) {
                        this.a.put(s, androidx.work.b.a((boolean[])o));
                    }
                    else if (class1 == byte[].class) {
                        this.a.put(s, androidx.work.b.b((byte[])o));
                    }
                    else if (class1 == int[].class) {
                        this.a.put(s, androidx.work.b.e((int[])o));
                    }
                    else if (class1 == long[].class) {
                        this.a.put(s, androidx.work.b.f((long[])o));
                    }
                    else if (class1 == float[].class) {
                        this.a.put(s, androidx.work.b.d((float[])o));
                    }
                    else {
                        if (class1 != double[].class) {
                            throw new IllegalArgumentException(String.format("Key %s has invalid type %s", s, class1));
                        }
                        this.a.put(s, androidx.work.b.c((double[])o));
                    }
                }
                else {
                    this.a.put(s, o);
                }
            }
            return this;
        }
        
        public a c(final Map<String, Object> map) {
            for (final Map.Entry<String, V> entry : map.entrySet()) {
                this.b(entry.getKey(), entry.getValue());
            }
            return this;
        }
        
        public a d(final String s, final String s2) {
            this.a.put(s, s2);
            return this;
        }
    }
}
