// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.util.Util;
import java.nio.channels.FileChannel;
import java.io.FileNotFoundException;
import java.io.IOException;
import android.os.Bundle;
import android.content.Context;
import java.io.FileInputStream;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.content.ContentResolver;

public final class ContentDataSource extends BaseDataSource
{
    private final ContentResolver e;
    private Uri f;
    private AssetFileDescriptor g;
    private FileInputStream h;
    private long i;
    private boolean j;
    
    public ContentDataSource(final Context context) {
        super(false);
        this.e = context.getContentResolver();
    }
    
    @Override
    public long b(final DataSpec dataSpec) throws ContentDataSourceException {
        int n = 2000;
        try {
            final Uri a = dataSpec.a;
            this.f = a;
            this.u(dataSpec);
            AssetFileDescriptor g;
            if ("content".equals(dataSpec.a.getScheme())) {
                final Bundle bundle = new Bundle();
                bundle.putBoolean("android.provider.extra.ACCEPT_ORIGINAL_MEDIA_FORMAT", true);
                g = this.e.openTypedAssetFileDescriptor(a, "*/*", bundle);
            }
            else {
                g = this.e.openAssetFileDescriptor(a, "r");
            }
            this.g = g;
            if (g == null) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Could not open file descriptor for: ");
                sb.append(a);
                throw new ContentDataSourceException(new IOException(sb.toString()), 2000);
            }
            final long length = g.getLength();
            final FileInputStream h = new FileInputStream(g.getFileDescriptor());
            this.h = h;
            final long n2 = lcmp(length, -1L);
            if (n2 != 0 && dataSpec.g > length) {
                throw new ContentDataSourceException((IOException)null, 2008);
            }
            final long startOffset = g.getStartOffset();
            final long n3 = h.skip(dataSpec.g + startOffset) - startOffset;
            if (n3 == dataSpec.g) {
                if (n2 == 0) {
                    final FileChannel channel = h.getChannel();
                    final long size = channel.size();
                    if (size == 0L) {
                        this.i = -1L;
                    }
                    else {
                        final long i = size - channel.position();
                        this.i = i;
                        if (i < 0L) {
                            throw new ContentDataSourceException((IOException)null, 2008);
                        }
                    }
                }
                else {
                    final long j = length - n3;
                    this.i = j;
                    if (j < 0L) {
                        throw new ContentDataSourceException((IOException)null, 2008);
                    }
                }
                long k = dataSpec.h;
                if (k != -1L) {
                    final long l = this.i;
                    if (l != -1L) {
                        k = Math.min(l, k);
                    }
                    this.i = k;
                }
                this.j = true;
                this.v(dataSpec);
                long n4 = dataSpec.h;
                if (n4 == -1L) {
                    n4 = this.i;
                }
                return n4;
            }
            throw new ContentDataSourceException((IOException)null, 2008);
        }
        catch (final IOException ex) {
            if (ex instanceof FileNotFoundException) {
                n = 2005;
            }
            throw new ContentDataSourceException(ex, n);
        }
        catch (final ContentDataSourceException ex2) {
            throw ex2;
        }
    }
    
    @Override
    public void close() throws ContentDataSourceException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: aconst_null    
        //     2: putfield        com/google/android/exoplayer2/upstream/ContentDataSource.f:Landroid/net/Uri;
        //     5: aload_0        
        //     6: getfield        com/google/android/exoplayer2/upstream/ContentDataSource.h:Ljava/io/FileInputStream;
        //     9: astore_1       
        //    10: aload_1        
        //    11: ifnull          18
        //    14: aload_1        
        //    15: invokevirtual   java/io/FileInputStream.close:()V
        //    18: aload_0        
        //    19: aconst_null    
        //    20: putfield        com/google/android/exoplayer2/upstream/ContentDataSource.h:Ljava/io/FileInputStream;
        //    23: aload_0        
        //    24: getfield        com/google/android/exoplayer2/upstream/ContentDataSource.g:Landroid/content/res/AssetFileDescriptor;
        //    27: astore_1       
        //    28: aload_1        
        //    29: ifnull          36
        //    32: aload_1        
        //    33: invokevirtual   android/content/res/AssetFileDescriptor.close:()V
        //    36: aload_0        
        //    37: aconst_null    
        //    38: putfield        com/google/android/exoplayer2/upstream/ContentDataSource.g:Landroid/content/res/AssetFileDescriptor;
        //    41: aload_0        
        //    42: getfield        com/google/android/exoplayer2/upstream/ContentDataSource.j:Z
        //    45: ifeq            57
        //    48: aload_0        
        //    49: iconst_0       
        //    50: putfield        com/google/android/exoplayer2/upstream/ContentDataSource.j:Z
        //    53: aload_0        
        //    54: invokevirtual   com/google/android/exoplayer2/upstream/BaseDataSource.t:()V
        //    57: return         
        //    58: astore_1       
        //    59: goto            77
        //    62: astore_1       
        //    63: new             Lcom/google/android/exoplayer2/upstream/ContentDataSource$ContentDataSourceException;
        //    66: astore_2       
        //    67: aload_2        
        //    68: aload_1        
        //    69: sipush          2000
        //    72: invokespecial   com/google/android/exoplayer2/upstream/ContentDataSource$ContentDataSourceException.<init>:(Ljava/io/IOException;I)V
        //    75: aload_2        
        //    76: athrow         
        //    77: aload_0        
        //    78: aconst_null    
        //    79: putfield        com/google/android/exoplayer2/upstream/ContentDataSource.g:Landroid/content/res/AssetFileDescriptor;
        //    82: aload_0        
        //    83: getfield        com/google/android/exoplayer2/upstream/ContentDataSource.j:Z
        //    86: ifeq            98
        //    89: aload_0        
        //    90: iconst_0       
        //    91: putfield        com/google/android/exoplayer2/upstream/ContentDataSource.j:Z
        //    94: aload_0        
        //    95: invokevirtual   com/google/android/exoplayer2/upstream/BaseDataSource.t:()V
        //    98: aload_1        
        //    99: athrow         
        //   100: astore_1       
        //   101: goto            119
        //   104: astore_2       
        //   105: new             Lcom/google/android/exoplayer2/upstream/ContentDataSource$ContentDataSourceException;
        //   108: astore_1       
        //   109: aload_1        
        //   110: aload_2        
        //   111: sipush          2000
        //   114: invokespecial   com/google/android/exoplayer2/upstream/ContentDataSource$ContentDataSourceException.<init>:(Ljava/io/IOException;I)V
        //   117: aload_1        
        //   118: athrow         
        //   119: aload_0        
        //   120: aconst_null    
        //   121: putfield        com/google/android/exoplayer2/upstream/ContentDataSource.h:Ljava/io/FileInputStream;
        //   124: aload_0        
        //   125: getfield        com/google/android/exoplayer2/upstream/ContentDataSource.g:Landroid/content/res/AssetFileDescriptor;
        //   128: astore_2       
        //   129: aload_2        
        //   130: ifnull          137
        //   133: aload_2        
        //   134: invokevirtual   android/content/res/AssetFileDescriptor.close:()V
        //   137: aload_0        
        //   138: aconst_null    
        //   139: putfield        com/google/android/exoplayer2/upstream/ContentDataSource.g:Landroid/content/res/AssetFileDescriptor;
        //   142: aload_0        
        //   143: getfield        com/google/android/exoplayer2/upstream/ContentDataSource.j:Z
        //   146: ifeq            158
        //   149: aload_0        
        //   150: iconst_0       
        //   151: putfield        com/google/android/exoplayer2/upstream/ContentDataSource.j:Z
        //   154: aload_0        
        //   155: invokevirtual   com/google/android/exoplayer2/upstream/BaseDataSource.t:()V
        //   158: aload_1        
        //   159: athrow         
        //   160: astore_1       
        //   161: goto            179
        //   164: astore_2       
        //   165: new             Lcom/google/android/exoplayer2/upstream/ContentDataSource$ContentDataSourceException;
        //   168: astore_1       
        //   169: aload_1        
        //   170: aload_2        
        //   171: sipush          2000
        //   174: invokespecial   com/google/android/exoplayer2/upstream/ContentDataSource$ContentDataSourceException.<init>:(Ljava/io/IOException;I)V
        //   177: aload_1        
        //   178: athrow         
        //   179: aload_0        
        //   180: aconst_null    
        //   181: putfield        com/google/android/exoplayer2/upstream/ContentDataSource.g:Landroid/content/res/AssetFileDescriptor;
        //   184: aload_0        
        //   185: getfield        com/google/android/exoplayer2/upstream/ContentDataSource.j:Z
        //   188: ifeq            200
        //   191: aload_0        
        //   192: iconst_0       
        //   193: putfield        com/google/android/exoplayer2/upstream/ContentDataSource.j:Z
        //   196: aload_0        
        //   197: invokevirtual   com/google/android/exoplayer2/upstream/BaseDataSource.t:()V
        //   200: aload_1        
        //   201: athrow         
        //    Exceptions:
        //  throws com.google.android.exoplayer2.upstream.ContentDataSource.ContentDataSourceException
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  5      10     104    119    Ljava/io/IOException;
        //  5      10     100    202    Any
        //  14     18     104    119    Ljava/io/IOException;
        //  14     18     100    202    Any
        //  23     28     62     77     Ljava/io/IOException;
        //  23     28     58     100    Any
        //  32     36     62     77     Ljava/io/IOException;
        //  32     36     58     100    Any
        //  63     77     58     100    Any
        //  105    119    100    202    Any
        //  124    129    164    179    Ljava/io/IOException;
        //  124    129    160    202    Any
        //  133    137    164    179    Ljava/io/IOException;
        //  133    137    160    202    Any
        //  165    179    160    202    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0137:
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
    
    @Override
    public Uri q() {
        return this.f;
    }
    
    @Override
    public int read(final byte[] array, int read, int n) throws ContentDataSourceException {
        if (n == 0) {
            return 0;
        }
        final long i = this.i;
        if (i == 0L) {
            return -1;
        }
        Label_0046: {
            if (i == -1L) {
                break Label_0046;
            }
            final long n2 = n;
            try {
                n = (int)Math.min(i, n2);
                read = Util.j(this.h).read(array, read, n);
                if (read == -1) {
                    return -1;
                }
                final long j = this.i;
                if (j != -1L) {
                    this.i = j - read;
                }
                this.s(read);
                return read;
            }
            catch (final IOException ex) {
                throw new ContentDataSourceException(ex, 2000);
            }
        }
    }
    
    public static class ContentDataSourceException extends DataSourceException
    {
        @Deprecated
        public ContentDataSourceException(final IOException ex) {
            this(ex, 2000);
        }
        
        public ContentDataSourceException(final IOException ex, final int n) {
            super(ex, n);
        }
    }
}
