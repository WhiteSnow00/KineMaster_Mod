// 
// Decompiled by Procyon v0.6.0
// 

package v2;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.io.File;
import java.util.concurrent.atomic.AtomicReference;

public final class a
{
    private static final AtomicReference<byte[]> a;
    
    static {
        a = new AtomicReference<byte[]>();
    }
    
    public static ByteBuffer a(final File p0) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore          4
        //     3: aconst_null    
        //     4: astore          5
        //     6: aload_0        
        //     7: invokevirtual   java/io/File.length:()J
        //    10: lstore_1       
        //    11: lload_1        
        //    12: ldc2_w          2147483647
        //    15: lcmp           
        //    16: ifgt            98
        //    19: lload_1        
        //    20: lconst_0       
        //    21: lcmp           
        //    22: ifeq            86
        //    25: new             Ljava/io/RandomAccessFile;
        //    28: astore_3       
        //    29: aload_3        
        //    30: aload_0        
        //    31: ldc             "r"
        //    33: invokespecial   java/io/RandomAccessFile.<init>:(Ljava/io/File;Ljava/lang/String;)V
        //    36: aload           5
        //    38: astore_0       
        //    39: aload_3        
        //    40: invokevirtual   java/io/RandomAccessFile.getChannel:()Ljava/nio/channels/FileChannel;
        //    43: astore          4
        //    45: aload           4
        //    47: astore_0       
        //    48: aload           4
        //    50: getstatic       java/nio/channels/FileChannel$MapMode.READ_ONLY:Ljava/nio/channels/FileChannel$MapMode;
        //    53: lconst_0       
        //    54: lload_1        
        //    55: invokevirtual   java/nio/channels/FileChannel.map:(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
        //    58: invokevirtual   java/nio/MappedByteBuffer.load:()Ljava/nio/MappedByteBuffer;
        //    61: astore          5
        //    63: aload           4
        //    65: invokevirtual   java/nio/channels/FileChannel.close:()V
        //    68: aload_3        
        //    69: invokevirtual   java/io/RandomAccessFile.close:()V
        //    72: aload           5
        //    74: areturn        
        //    75: astore          5
        //    77: aload_0        
        //    78: astore          4
        //    80: aload           5
        //    82: astore_0       
        //    83: goto            113
        //    86: new             Ljava/io/IOException;
        //    89: astore_0       
        //    90: aload_0        
        //    91: ldc             "File unsuitable for memory mapping"
        //    93: invokespecial   java/io/IOException.<init>:(Ljava/lang/String;)V
        //    96: aload_0        
        //    97: athrow         
        //    98: new             Ljava/io/IOException;
        //   101: astore_0       
        //   102: aload_0        
        //   103: ldc             "File too large to map into memory"
        //   105: invokespecial   java/io/IOException.<init>:(Ljava/lang/String;)V
        //   108: aload_0        
        //   109: athrow         
        //   110: astore_0       
        //   111: aconst_null    
        //   112: astore_3       
        //   113: aload           4
        //   115: ifnull          123
        //   118: aload           4
        //   120: invokevirtual   java/nio/channels/FileChannel.close:()V
        //   123: aload_3        
        //   124: ifnull          131
        //   127: aload_3        
        //   128: invokevirtual   java/io/RandomAccessFile.close:()V
        //   131: aload_0        
        //   132: athrow         
        //   133: astore_0       
        //   134: goto            68
        //   137: astore_0       
        //   138: goto            72
        //   141: astore          4
        //   143: goto            123
        //   146: astore_3       
        //   147: goto            131
        //    Exceptions:
        //  throws java.io.IOException
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  6      11     110    113    Any
        //  25     36     110    113    Any
        //  39     45     75     86     Any
        //  48     63     75     86     Any
        //  63     68     133    137    Ljava/io/IOException;
        //  68     72     137    141    Ljava/io/IOException;
        //  86     98     110    113    Any
        //  98     110    110    113    Any
        //  118    123    141    146    Ljava/io/IOException;
        //  127    131    146    150    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 82, Size: 82
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
    
    public static ByteBuffer b(final InputStream inputStream) throws IOException {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        byte[] array;
        if ((array = v2.a.a.getAndSet(null)) == null) {
            array = new byte[16384];
        }
        while (true) {
            final int read = inputStream.read(array);
            if (read < 0) {
                break;
            }
            byteArrayOutputStream.write(array, 0, read);
        }
        v2.a.a.set(array);
        final byte[] byteArray = byteArrayOutputStream.toByteArray();
        return d(ByteBuffer.allocateDirect(byteArray.length).put(byteArray));
    }
    
    private static b c(final ByteBuffer byteBuffer) {
        if (!byteBuffer.isReadOnly() && byteBuffer.hasArray()) {
            return new b(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit());
        }
        return null;
    }
    
    public static ByteBuffer d(final ByteBuffer byteBuffer) {
        return (ByteBuffer)byteBuffer.position(0);
    }
    
    public static byte[] e(final ByteBuffer byteBuffer) {
        final b c = c(byteBuffer);
        byte[] array;
        if (c != null && c.a == 0 && c.b == c.c.length) {
            array = byteBuffer.array();
        }
        else {
            final ByteBuffer readOnlyBuffer = byteBuffer.asReadOnlyBuffer();
            array = new byte[readOnlyBuffer.limit()];
            d(readOnlyBuffer);
            readOnlyBuffer.get(array);
        }
        return array;
    }
    
    public static void f(final ByteBuffer p0, final File p1) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    v2/a.d:(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
        //     4: pop            
        //     5: aconst_null    
        //     6: astore_2       
        //     7: aconst_null    
        //     8: astore          4
        //    10: new             Ljava/io/RandomAccessFile;
        //    13: astore_3       
        //    14: aload_3        
        //    15: aload_1        
        //    16: ldc             "rw"
        //    18: invokespecial   java/io/RandomAccessFile.<init>:(Ljava/io/File;Ljava/lang/String;)V
        //    21: aload           4
        //    23: astore_1       
        //    24: aload_3        
        //    25: invokevirtual   java/io/RandomAccessFile.getChannel:()Ljava/nio/channels/FileChannel;
        //    28: astore_2       
        //    29: aload_2        
        //    30: astore_1       
        //    31: aload_2        
        //    32: aload_0        
        //    33: invokevirtual   java/nio/channels/FileChannel.write:(Ljava/nio/ByteBuffer;)I
        //    36: pop            
        //    37: aload_2        
        //    38: astore_1       
        //    39: aload_2        
        //    40: iconst_0       
        //    41: invokevirtual   java/nio/channels/FileChannel.force:(Z)V
        //    44: aload_2        
        //    45: astore_1       
        //    46: aload_2        
        //    47: invokevirtual   java/nio/channels/FileChannel.close:()V
        //    50: aload_2        
        //    51: astore_1       
        //    52: aload_3        
        //    53: invokevirtual   java/io/RandomAccessFile.close:()V
        //    56: aload_2        
        //    57: invokevirtual   java/nio/channels/FileChannel.close:()V
        //    60: aload_3        
        //    61: invokevirtual   java/io/RandomAccessFile.close:()V
        //    64: return         
        //    65: astore_0       
        //    66: aload_1        
        //    67: astore_2       
        //    68: aload_3        
        //    69: astore_1       
        //    70: goto            76
        //    73: astore_0       
        //    74: aconst_null    
        //    75: astore_1       
        //    76: aload_2        
        //    77: ifnull          84
        //    80: aload_2        
        //    81: invokevirtual   java/nio/channels/FileChannel.close:()V
        //    84: aload_1        
        //    85: ifnull          92
        //    88: aload_1        
        //    89: invokevirtual   java/io/RandomAccessFile.close:()V
        //    92: aload_0        
        //    93: athrow         
        //    94: astore_0       
        //    95: goto            60
        //    98: astore_0       
        //    99: goto            64
        //   102: astore_2       
        //   103: goto            84
        //   106: astore_1       
        //   107: goto            92
        //    Exceptions:
        //  throws java.io.IOException
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  10     21     73     76     Any
        //  24     29     65     73     Any
        //  31     37     65     73     Any
        //  39     44     65     73     Any
        //  46     50     65     73     Any
        //  52     56     65     73     Any
        //  56     60     94     98     Ljava/io/IOException;
        //  60     64     98     102    Ljava/io/IOException;
        //  80     84     102    106    Ljava/io/IOException;
        //  88     92     106    110    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 69, Size: 69
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
    
    public static InputStream g(final ByteBuffer byteBuffer) {
        return new a(byteBuffer);
    }
    
    private static class a extends InputStream
    {
        private final ByteBuffer a;
        private int b;
        
        a(final ByteBuffer a) {
            this.b = -1;
            this.a = a;
        }
        
        @Override
        public int available() {
            return this.a.remaining();
        }
        
        @Override
        public void mark(final int n) {
            synchronized (this) {
                this.b = this.a.position();
            }
        }
        
        @Override
        public boolean markSupported() {
            return true;
        }
        
        @Override
        public int read() {
            if (!this.a.hasRemaining()) {
                return -1;
            }
            return this.a.get() & 0xFF;
        }
        
        @Override
        public int read(final byte[] array, final int n, int min) {
            if (!this.a.hasRemaining()) {
                return -1;
            }
            min = Math.min(min, this.available());
            this.a.get(array, n, min);
            return min;
        }
        
        @Override
        public void reset() throws IOException {
            synchronized (this) {
                final int b = this.b;
                if (b != -1) {
                    this.a.position(b);
                    return;
                }
                throw new IOException("Cannot reset to unset mark position");
            }
        }
        
        @Override
        public long skip(long min) {
            if (!this.a.hasRemaining()) {
                return -1L;
            }
            min = Math.min(min, this.available());
            final ByteBuffer a = this.a;
            a.position((int)(a.position() + min));
            return min;
        }
    }
    
    static final class b
    {
        final int a;
        final int b;
        final byte[] c;
        
        b(final byte[] c, final int a, final int b) {
            this.c = c;
            this.a = a;
            this.b = b;
        }
    }
}
