// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.upstream;

import java.io.EOFException;
import com.google.android.exoplayer2.util.Util;
import java.nio.channels.FileChannel;
import android.content.res.Resources$NotFoundException;
import java.io.IOException;
import java.io.FileInputStream;
import com.google.android.exoplayer2.util.Assertions;
import android.text.TextUtils;
import android.content.Context;
import java.io.InputStream;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.content.res.Resources;

public final class RawResourceDataSource extends BaseDataSource
{
    private final Resources e;
    private final String f;
    private Uri g;
    private AssetFileDescriptor h;
    private InputStream i;
    private long j;
    private boolean k;
    
    public RawResourceDataSource(final Context context) {
        super(false);
        this.e = context.getResources();
        this.f = context.getPackageName();
    }
    
    public static Uri buildRawResourceUri(final int n) {
        final StringBuilder sb = new StringBuilder();
        sb.append("rawresource:///");
        sb.append(n);
        return Uri.parse(sb.toString());
    }
    
    @Override
    public long b(final DataSpec dataSpec) throws RawResourceDataSourceException {
        final Uri a = dataSpec.a;
        this.g = a;
        Label_0274: {
            if (!TextUtils.equals((CharSequence)"rawresource", (CharSequence)a.getScheme())) {
                if (!TextUtils.equals((CharSequence)"android.resource", (CharSequence)a.getScheme()) || a.getPathSegments().size() != 1 || !Assertions.e(a.getLastPathSegment()).matches("\\d+")) {
                    if (!TextUtils.equals((CharSequence)"android.resource", (CharSequence)a.getScheme())) {
                        throw new RawResourceDataSourceException("URI must either use scheme rawresource or android.resource", null, 1004);
                    }
                    String substring;
                    final String s = substring = Assertions.e(a.getPath());
                    if (s.startsWith("/")) {
                        substring = s.substring(1);
                    }
                    final String host = a.getHost();
                    final StringBuilder sb = new StringBuilder();
                    String string;
                    if (TextUtils.isEmpty((CharSequence)host)) {
                        string = "";
                    }
                    else {
                        final StringBuilder sb2 = new StringBuilder();
                        sb2.append(host);
                        sb2.append(":");
                        string = sb2.toString();
                    }
                    sb.append(string);
                    sb.append(substring);
                    final int n = this.e.getIdentifier(sb.toString(), "raw", this.f);
                    if (n != 0) {
                        break Label_0274;
                    }
                    throw new RawResourceDataSourceException("Resource not found.", null, 2005);
                }
            }
            try {
                final int n = Integer.parseInt(Assertions.e(a.getLastPathSegment()));
                this.u(dataSpec);
                try {
                    final AssetFileDescriptor openRawResourceFd = this.e.openRawResourceFd(n);
                    this.h = openRawResourceFd;
                    if (openRawResourceFd != null) {
                        final long length = openRawResourceFd.getLength();
                        final FileInputStream i = new FileInputStream(openRawResourceFd.getFileDescriptor());
                        this.i = i;
                        final long n2 = lcmp(length, -1L);
                        Label_0363: {
                            if (n2 == 0) {
                                break Label_0363;
                            }
                            try {
                                if (dataSpec.g > length) {
                                    throw new RawResourceDataSourceException(null, null, 2008);
                                }
                                final long startOffset = openRawResourceFd.getStartOffset();
                                final long n3 = i.skip(dataSpec.g + startOffset) - startOffset;
                                if (n3 == dataSpec.g) {
                                    if (n2 == 0) {
                                        final FileChannel channel = i.getChannel();
                                        if (channel.size() == 0L) {
                                            this.j = -1L;
                                        }
                                        else {
                                            final long j = channel.size() - channel.position();
                                            this.j = j;
                                            if (j < 0L) {
                                                throw new RawResourceDataSourceException(null, null, 2008);
                                            }
                                        }
                                    }
                                    else {
                                        final long k = length - n3;
                                        this.j = k;
                                        if (k < 0L) {
                                            throw new DataSourceException(2008);
                                        }
                                    }
                                    long l = dataSpec.h;
                                    if (l != -1L) {
                                        final long m = this.j;
                                        if (m != -1L) {
                                            l = Math.min(m, l);
                                        }
                                        this.j = l;
                                    }
                                    this.k = true;
                                    this.v(dataSpec);
                                    long n4 = dataSpec.h;
                                    if (n4 == -1L) {
                                        n4 = this.j;
                                    }
                                    return n4;
                                }
                                throw new RawResourceDataSourceException(null, null, 2008);
                            }
                            catch (final IOException ex) {
                                throw new RawResourceDataSourceException(null, ex, 2000);
                            }
                            catch (final RawResourceDataSourceException ex2) {
                                throw ex2;
                            }
                        }
                    }
                    final StringBuilder sb3 = new StringBuilder();
                    sb3.append("Resource is compressed: ");
                    sb3.append(a);
                    throw new RawResourceDataSourceException(sb3.toString(), null, 2000);
                }
                catch (final Resources$NotFoundException ex3) {
                    throw new RawResourceDataSourceException(null, (Throwable)ex3, 2005);
                }
            }
            catch (final NumberFormatException ex4) {
                throw new RawResourceDataSourceException("Resource identifier must be an integer.", null, 1004);
            }
        }
    }
    
    @Override
    public void close() throws RawResourceDataSourceException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: aconst_null    
        //     2: putfield        com/google/android/exoplayer2/upstream/RawResourceDataSource.g:Landroid/net/Uri;
        //     5: aload_0        
        //     6: getfield        com/google/android/exoplayer2/upstream/RawResourceDataSource.i:Ljava/io/InputStream;
        //     9: astore_1       
        //    10: aload_1        
        //    11: ifnull          18
        //    14: aload_1        
        //    15: invokevirtual   java/io/InputStream.close:()V
        //    18: aload_0        
        //    19: aconst_null    
        //    20: putfield        com/google/android/exoplayer2/upstream/RawResourceDataSource.i:Ljava/io/InputStream;
        //    23: aload_0        
        //    24: getfield        com/google/android/exoplayer2/upstream/RawResourceDataSource.h:Landroid/content/res/AssetFileDescriptor;
        //    27: astore_1       
        //    28: aload_1        
        //    29: ifnull          36
        //    32: aload_1        
        //    33: invokevirtual   android/content/res/AssetFileDescriptor.close:()V
        //    36: aload_0        
        //    37: aconst_null    
        //    38: putfield        com/google/android/exoplayer2/upstream/RawResourceDataSource.h:Landroid/content/res/AssetFileDescriptor;
        //    41: aload_0        
        //    42: getfield        com/google/android/exoplayer2/upstream/RawResourceDataSource.k:Z
        //    45: ifeq            57
        //    48: aload_0        
        //    49: iconst_0       
        //    50: putfield        com/google/android/exoplayer2/upstream/RawResourceDataSource.k:Z
        //    53: aload_0        
        //    54: invokevirtual   com/google/android/exoplayer2/upstream/BaseDataSource.t:()V
        //    57: return         
        //    58: astore_1       
        //    59: goto            78
        //    62: astore_2       
        //    63: new             Lcom/google/android/exoplayer2/upstream/RawResourceDataSource$RawResourceDataSourceException;
        //    66: astore_1       
        //    67: aload_1        
        //    68: aconst_null    
        //    69: aload_2        
        //    70: sipush          2000
        //    73: invokespecial   com/google/android/exoplayer2/upstream/RawResourceDataSource$RawResourceDataSourceException.<init>:(Ljava/lang/String;Ljava/lang/Throwable;I)V
        //    76: aload_1        
        //    77: athrow         
        //    78: aload_0        
        //    79: aconst_null    
        //    80: putfield        com/google/android/exoplayer2/upstream/RawResourceDataSource.h:Landroid/content/res/AssetFileDescriptor;
        //    83: aload_0        
        //    84: getfield        com/google/android/exoplayer2/upstream/RawResourceDataSource.k:Z
        //    87: ifeq            99
        //    90: aload_0        
        //    91: iconst_0       
        //    92: putfield        com/google/android/exoplayer2/upstream/RawResourceDataSource.k:Z
        //    95: aload_0        
        //    96: invokevirtual   com/google/android/exoplayer2/upstream/BaseDataSource.t:()V
        //    99: aload_1        
        //   100: athrow         
        //   101: astore_2       
        //   102: goto            121
        //   105: astore_2       
        //   106: new             Lcom/google/android/exoplayer2/upstream/RawResourceDataSource$RawResourceDataSourceException;
        //   109: astore_1       
        //   110: aload_1        
        //   111: aconst_null    
        //   112: aload_2        
        //   113: sipush          2000
        //   116: invokespecial   com/google/android/exoplayer2/upstream/RawResourceDataSource$RawResourceDataSourceException.<init>:(Ljava/lang/String;Ljava/lang/Throwable;I)V
        //   119: aload_1        
        //   120: athrow         
        //   121: aload_0        
        //   122: aconst_null    
        //   123: putfield        com/google/android/exoplayer2/upstream/RawResourceDataSource.i:Ljava/io/InputStream;
        //   126: aload_0        
        //   127: getfield        com/google/android/exoplayer2/upstream/RawResourceDataSource.h:Landroid/content/res/AssetFileDescriptor;
        //   130: astore_1       
        //   131: aload_1        
        //   132: ifnull          139
        //   135: aload_1        
        //   136: invokevirtual   android/content/res/AssetFileDescriptor.close:()V
        //   139: aload_0        
        //   140: aconst_null    
        //   141: putfield        com/google/android/exoplayer2/upstream/RawResourceDataSource.h:Landroid/content/res/AssetFileDescriptor;
        //   144: aload_0        
        //   145: getfield        com/google/android/exoplayer2/upstream/RawResourceDataSource.k:Z
        //   148: ifeq            160
        //   151: aload_0        
        //   152: iconst_0       
        //   153: putfield        com/google/android/exoplayer2/upstream/RawResourceDataSource.k:Z
        //   156: aload_0        
        //   157: invokevirtual   com/google/android/exoplayer2/upstream/BaseDataSource.t:()V
        //   160: aload_2        
        //   161: athrow         
        //   162: astore_1       
        //   163: goto            182
        //   166: astore_1       
        //   167: new             Lcom/google/android/exoplayer2/upstream/RawResourceDataSource$RawResourceDataSourceException;
        //   170: astore_2       
        //   171: aload_2        
        //   172: aconst_null    
        //   173: aload_1        
        //   174: sipush          2000
        //   177: invokespecial   com/google/android/exoplayer2/upstream/RawResourceDataSource$RawResourceDataSourceException.<init>:(Ljava/lang/String;Ljava/lang/Throwable;I)V
        //   180: aload_2        
        //   181: athrow         
        //   182: aload_0        
        //   183: aconst_null    
        //   184: putfield        com/google/android/exoplayer2/upstream/RawResourceDataSource.h:Landroid/content/res/AssetFileDescriptor;
        //   187: aload_0        
        //   188: getfield        com/google/android/exoplayer2/upstream/RawResourceDataSource.k:Z
        //   191: ifeq            203
        //   194: aload_0        
        //   195: iconst_0       
        //   196: putfield        com/google/android/exoplayer2/upstream/RawResourceDataSource.k:Z
        //   199: aload_0        
        //   200: invokevirtual   com/google/android/exoplayer2/upstream/BaseDataSource.t:()V
        //   203: aload_1        
        //   204: athrow         
        //    Exceptions:
        //  throws com.google.android.exoplayer2.upstream.RawResourceDataSource.RawResourceDataSourceException
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  5      10     105    121    Ljava/io/IOException;
        //  5      10     101    205    Any
        //  14     18     105    121    Ljava/io/IOException;
        //  14     18     101    205    Any
        //  23     28     62     78     Ljava/io/IOException;
        //  23     28     58     101    Any
        //  32     36     62     78     Ljava/io/IOException;
        //  32     36     58     101    Any
        //  63     78     58     101    Any
        //  106    121    101    205    Any
        //  126    131    166    182    Ljava/io/IOException;
        //  126    131    162    205    Any
        //  135    139    166    182    Ljava/io/IOException;
        //  135    139    162    205    Any
        //  167    182    162    205    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0139:
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
        return this.g;
    }
    
    @Override
    public int read(final byte[] array, int read, int n) throws RawResourceDataSourceException {
        if (n == 0) {
            return 0;
        }
        final long j = this.j;
        if (j == 0L) {
            return -1;
        }
        Label_0046: {
            if (j == -1L) {
                break Label_0046;
            }
            final long n2 = n;
            try {
                n = (int)Math.min(j, n2);
                read = Util.j(this.i).read(array, read, n);
                if (read != -1) {
                    final long i = this.j;
                    if (i != -1L) {
                        this.j = i - read;
                    }
                    this.s(read);
                    return read;
                }
                if (this.j == -1L) {
                    return -1;
                }
                throw new RawResourceDataSourceException("End of stream reached having not read sufficient data.", new EOFException(), 2000);
            }
            catch (final IOException ex) {
                throw new RawResourceDataSourceException(null, ex, 2000);
            }
        }
    }
    
    public static class RawResourceDataSourceException extends DataSourceException
    {
        @Deprecated
        public RawResourceDataSourceException(final String s) {
            super(s, null, 2000);
        }
        
        public RawResourceDataSourceException(final String s, final Throwable t, final int n) {
            super(s, t, n);
        }
        
        @Deprecated
        public RawResourceDataSourceException(final Throwable t) {
            super(t, 2000);
        }
    }
}
