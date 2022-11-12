// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load;

import java.nio.ByteBuffer;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.InputStream;
import java.io.IOException;
import e2.b;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import java.util.List;

public final class a
{
    public static int a(final List<ImageHeaderParser> list, final ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, final b b) throws IOException {
        return d(list, (g)new g(parcelFileDescriptorRewinder, b) {
            final ParcelFileDescriptorRewinder a;
            final b b;
            
            @Override
            public int a(final ImageHeaderParser p0) throws IOException {
                // 
                // This method could not be decompiled.
                // 
                // Original Bytecode:
                // 
                //     1: astore_3       
                //     2: new             Lcom/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream;
                //     5: astore          4
                //     7: new             Ljava/io/FileInputStream;
                //    10: astore          5
                //    12: aload           5
                //    14: aload_0        
                //    15: getfield        com/bumptech/glide/load/a$f.a:Lcom/bumptech/glide/load/data/ParcelFileDescriptorRewinder;
                //    18: invokevirtual   com/bumptech/glide/load/data/ParcelFileDescriptorRewinder.d:()Landroid/os/ParcelFileDescriptor;
                //    21: invokevirtual   android/os/ParcelFileDescriptor.getFileDescriptor:()Ljava/io/FileDescriptor;
                //    24: invokespecial   java/io/FileInputStream.<init>:(Ljava/io/FileDescriptor;)V
                //    27: aload           4
                //    29: aload           5
                //    31: aload_0        
                //    32: getfield        com/bumptech/glide/load/a$f.b:Le2/b;
                //    35: invokespecial   com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.<init>:(Ljava/io/InputStream;Le2/b;)V
                //    38: aload_1        
                //    39: aload           4
                //    41: aload_0        
                //    42: getfield        com/bumptech/glide/load/a$f.b:Le2/b;
                //    45: invokeinterface com/bumptech/glide/load/ImageHeaderParser.d:(Ljava/io/InputStream;Le2/b;)I
                //    50: istore_2       
                //    51: aload           4
                //    53: invokevirtual   java/io/InputStream.close:()V
                //    56: aload_0        
                //    57: getfield        com/bumptech/glide/load/a$f.a:Lcom/bumptech/glide/load/data/ParcelFileDescriptorRewinder;
                //    60: invokevirtual   com/bumptech/glide/load/data/ParcelFileDescriptorRewinder.d:()Landroid/os/ParcelFileDescriptor;
                //    63: pop            
                //    64: iload_2        
                //    65: ireturn        
                //    66: astore_1       
                //    67: aload           4
                //    69: astore_3       
                //    70: goto            74
                //    73: astore_1       
                //    74: aload_3        
                //    75: ifnull          82
                //    78: aload_3        
                //    79: invokevirtual   java/io/InputStream.close:()V
                //    82: aload_0        
                //    83: getfield        com/bumptech/glide/load/a$f.a:Lcom/bumptech/glide/load/data/ParcelFileDescriptorRewinder;
                //    86: invokevirtual   com/bumptech/glide/load/data/ParcelFileDescriptorRewinder.d:()Landroid/os/ParcelFileDescriptor;
                //    89: pop            
                //    90: aload_1        
                //    91: athrow         
                //    92: astore_1       
                //    93: goto            56
                //    96: astore_3       
                //    97: goto            82
                //    Exceptions:
                //  throws java.io.IOException
                //    Exceptions:
                //  Try           Handler
                //  Start  End    Start  End    Type                 
                //  -----  -----  -----  -----  ---------------------
                //  2      38     73     74     Any
                //  38     51     66     73     Any
                //  51     56     92     96     Ljava/io/IOException;
                //  78     82     96     100    Ljava/io/IOException;
                // 
                // The error that occurred was:
                // 
                // java.lang.IllegalStateException: Expression is linked from several locations: Label_0056:
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
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformCall(AstMethodBodyBuilder.java:1151)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:993)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:534)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:548)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:534)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:548)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:534)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformNode(AstMethodBodyBuilder.java:377)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformBlock(AstMethodBodyBuilder.java:318)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:213)
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
        });
    }
    
    public static int b(final List<ImageHeaderParser> list, final InputStream inputStream, final b b) throws IOException {
        if (inputStream == null) {
            return -1;
        }
        InputStream inputStream2 = inputStream;
        if (!inputStream.markSupported()) {
            inputStream2 = new RecyclableBufferedInputStream(inputStream, b);
        }
        inputStream2.mark(5242880);
        return d(list, (g)new g(inputStream2, b) {
            final InputStream a;
            final b b;
            
            @Override
            public int a(final ImageHeaderParser imageHeaderParser) throws IOException {
                try {
                    return imageHeaderParser.d(this.a, this.b);
                }
                finally {
                    this.a.reset();
                }
            }
        });
    }
    
    public static int c(final List<ImageHeaderParser> list, final ByteBuffer byteBuffer, final b b) throws IOException {
        if (byteBuffer == null) {
            return -1;
        }
        return d(list, (g)new g(byteBuffer, b) {
            final ByteBuffer a;
            final b b;
            
            @Override
            public int a(final ImageHeaderParser imageHeaderParser) throws IOException {
                return imageHeaderParser.b(this.a, this.b);
            }
        });
    }
    
    private static int d(final List<ImageHeaderParser> list, final g g) throws IOException {
        for (int size = list.size(), i = 0; i < size; ++i) {
            final int a = g.a(list.get(i));
            if (a != -1) {
                return a;
            }
        }
        return -1;
    }
    
    public static ImageHeaderParser.ImageType e(final List<ImageHeaderParser> list, final ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, final b b) throws IOException {
        return h(list, (h)new h(parcelFileDescriptorRewinder, b) {
            final ParcelFileDescriptorRewinder a;
            final b b;
            
            @Override
            public ImageHeaderParser.ImageType a(final ImageHeaderParser p0) throws IOException {
                // 
                // This method could not be decompiled.
                // 
                // Original Bytecode:
                // 
                //     1: astore_2       
                //     2: new             Lcom/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream;
                //     5: astore_3       
                //     6: new             Ljava/io/FileInputStream;
                //     9: astore          4
                //    11: aload           4
                //    13: aload_0        
                //    14: getfield        com/bumptech/glide/load/a$c.a:Lcom/bumptech/glide/load/data/ParcelFileDescriptorRewinder;
                //    17: invokevirtual   com/bumptech/glide/load/data/ParcelFileDescriptorRewinder.d:()Landroid/os/ParcelFileDescriptor;
                //    20: invokevirtual   android/os/ParcelFileDescriptor.getFileDescriptor:()Ljava/io/FileDescriptor;
                //    23: invokespecial   java/io/FileInputStream.<init>:(Ljava/io/FileDescriptor;)V
                //    26: aload_3        
                //    27: aload           4
                //    29: aload_0        
                //    30: getfield        com/bumptech/glide/load/a$c.b:Le2/b;
                //    33: invokespecial   com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.<init>:(Ljava/io/InputStream;Le2/b;)V
                //    36: aload_1        
                //    37: aload_3        
                //    38: invokeinterface com/bumptech/glide/load/ImageHeaderParser.c:(Ljava/io/InputStream;)Lcom/bumptech/glide/load/ImageHeaderParser$ImageType;
                //    43: astore_1       
                //    44: aload_3        
                //    45: invokevirtual   java/io/InputStream.close:()V
                //    48: aload_0        
                //    49: getfield        com/bumptech/glide/load/a$c.a:Lcom/bumptech/glide/load/data/ParcelFileDescriptorRewinder;
                //    52: invokevirtual   com/bumptech/glide/load/data/ParcelFileDescriptorRewinder.d:()Landroid/os/ParcelFileDescriptor;
                //    55: pop            
                //    56: aload_1        
                //    57: areturn        
                //    58: astore_1       
                //    59: aload_3        
                //    60: astore_2       
                //    61: goto            65
                //    64: astore_1       
                //    65: aload_2        
                //    66: ifnull          73
                //    69: aload_2        
                //    70: invokevirtual   java/io/InputStream.close:()V
                //    73: aload_0        
                //    74: getfield        com/bumptech/glide/load/a$c.a:Lcom/bumptech/glide/load/data/ParcelFileDescriptorRewinder;
                //    77: invokevirtual   com/bumptech/glide/load/data/ParcelFileDescriptorRewinder.d:()Landroid/os/ParcelFileDescriptor;
                //    80: pop            
                //    81: aload_1        
                //    82: athrow         
                //    83: astore_2       
                //    84: goto            48
                //    87: astore_2       
                //    88: goto            73
                //    Exceptions:
                //  throws java.io.IOException
                //    Exceptions:
                //  Try           Handler
                //  Start  End    Start  End    Type                 
                //  -----  -----  -----  -----  ---------------------
                //  2      36     64     65     Any
                //  36     44     58     64     Any
                //  44     48     83     87     Ljava/io/IOException;
                //  69     73     87     91     Ljava/io/IOException;
                // 
                // The error that occurred was:
                // 
                // java.lang.IllegalStateException: Expression is linked from several locations: Label_0048:
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
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformCall(AstMethodBodyBuilder.java:1151)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:993)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:534)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:548)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:534)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:548)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:534)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformNode(AstMethodBodyBuilder.java:377)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformBlock(AstMethodBodyBuilder.java:318)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:213)
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
        });
    }
    
    public static ImageHeaderParser.ImageType f(final List<ImageHeaderParser> list, final InputStream inputStream, final b b) throws IOException {
        if (inputStream == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        InputStream inputStream2 = inputStream;
        if (!inputStream.markSupported()) {
            inputStream2 = new RecyclableBufferedInputStream(inputStream, b);
        }
        inputStream2.mark(5242880);
        return h(list, (h)new h(inputStream2) {
            final InputStream a;
            
            @Override
            public ImageHeaderParser.ImageType a(final ImageHeaderParser imageHeaderParser) throws IOException {
                try {
                    return imageHeaderParser.c(this.a);
                }
                finally {
                    this.a.reset();
                }
            }
        });
    }
    
    public static ImageHeaderParser.ImageType g(final List<ImageHeaderParser> list, final ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        return h(list, (h)new h(byteBuffer) {
            final ByteBuffer a;
            
            @Override
            public ImageHeaderParser.ImageType a(final ImageHeaderParser imageHeaderParser) throws IOException {
                return imageHeaderParser.a(this.a);
            }
        });
    }
    
    private static ImageHeaderParser.ImageType h(final List<ImageHeaderParser> list, final h h) throws IOException {
        for (int size = list.size(), i = 0; i < size; ++i) {
            final ImageHeaderParser.ImageType a = h.a(list.get(i));
            if (a != ImageHeaderParser.ImageType.UNKNOWN) {
                return a;
            }
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }
    
    private interface g
    {
        int a(final ImageHeaderParser p0) throws IOException;
    }
    
    private interface h
    {
        ImageHeaderParser.ImageType a(final ImageHeaderParser p0) throws IOException;
    }
}
