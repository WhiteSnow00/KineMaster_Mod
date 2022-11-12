// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.extractor.ExtractorOutput;
import java.util.List;
import java.util.Map;
import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.extractor.mp3.Mp3Extractor;
import java.io.IOException;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;

public final class BundledExtractorsAdapter implements ProgressiveMediaExtractor
{
    private final ExtractorsFactory a;
    private Extractor b;
    private ExtractorInput c;
    
    public BundledExtractorsAdapter(final ExtractorsFactory a) {
        this.a = a;
    }
    
    @Override
    public void a(final long n, final long n2) {
        Assertions.e(this.b).a(n, n2);
    }
    
    @Override
    public int b(final PositionHolder positionHolder) throws IOException {
        return Assertions.e(this.b).e(Assertions.e(this.c), positionHolder);
    }
    
    @Override
    public void c() {
        final Extractor b = this.b;
        if (b instanceof Mp3Extractor) {
            ((Mp3Extractor)b).j();
        }
    }
    
    @Override
    public void d(final DataReader p0, final Uri p1, final Map<String, List<String>> p2, final long p3, final long p4, final ExtractorOutput p5) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: aload_1        
        //     5: lload           4
        //     7: lload           6
        //     9: invokespecial   com/google/android/exoplayer2/extractor/DefaultExtractorInput.<init>:(Lcom/google/android/exoplayer2/upstream/DataReader;JJ)V
        //    12: astore_1       
        //    13: aload_0        
        //    14: aload_1        
        //    15: putfield        com/google/android/exoplayer2/source/BundledExtractorsAdapter.c:Lcom/google/android/exoplayer2/extractor/ExtractorInput;
        //    18: aload_0        
        //    19: getfield        com/google/android/exoplayer2/source/BundledExtractorsAdapter.b:Lcom/google/android/exoplayer2/extractor/Extractor;
        //    22: ifnull          26
        //    25: return         
        //    26: aload_0        
        //    27: getfield        com/google/android/exoplayer2/source/BundledExtractorsAdapter.a:Lcom/google/android/exoplayer2/extractor/ExtractorsFactory;
        //    30: aload_2        
        //    31: aload_3        
        //    32: invokeinterface com/google/android/exoplayer2/extractor/ExtractorsFactory.b:(Landroid/net/Uri;Ljava/util/Map;)[Lcom/google/android/exoplayer2/extractor/Extractor;
        //    37: astore_3       
        //    38: aload_3        
        //    39: arraylength    
        //    40: istore          9
        //    42: iconst_0       
        //    43: istore          12
        //    45: iload           9
        //    47: iconst_1       
        //    48: if_icmpne       61
        //    51: aload_0        
        //    52: aload_3        
        //    53: iconst_0       
        //    54: aaload         
        //    55: putfield        com/google/android/exoplayer2/source/BundledExtractorsAdapter.b:Lcom/google/android/exoplayer2/extractor/Extractor;
        //    58: goto            230
        //    61: aload_3        
        //    62: arraylength    
        //    63: istore          10
        //    65: iconst_0       
        //    66: istore          9
        //    68: iload           9
        //    70: iload           10
        //    72: if_icmpge       223
        //    75: aload_3        
        //    76: iload           9
        //    78: aaload         
        //    79: astore          13
        //    81: aload           13
        //    83: aload_1        
        //    84: invokeinterface com/google/android/exoplayer2/extractor/Extractor.d:(Lcom/google/android/exoplayer2/extractor/ExtractorInput;)Z
        //    89: ifeq            111
        //    92: aload_0        
        //    93: aload           13
        //    95: putfield        com/google/android/exoplayer2/source/BundledExtractorsAdapter.b:Lcom/google/android/exoplayer2/extractor/Extractor;
        //    98: iconst_1       
        //    99: invokestatic    com/google/android/exoplayer2/util/Assertions.g:(Z)V
        //   102: aload_1        
        //   103: invokeinterface com/google/android/exoplayer2/extractor/ExtractorInput.h:()V
        //   108: goto            223
        //   111: aload_0        
        //   112: getfield        com/google/android/exoplayer2/source/BundledExtractorsAdapter.b:Lcom/google/android/exoplayer2/extractor/Extractor;
        //   115: ifnonnull       203
        //   118: aload_1        
        //   119: invokeinterface com/google/android/exoplayer2/extractor/ExtractorInput.getPosition:()J
        //   124: lload           4
        //   126: lcmp           
        //   127: ifne            197
        //   130: goto            203
        //   133: astore_2       
        //   134: aload_0        
        //   135: getfield        com/google/android/exoplayer2/source/BundledExtractorsAdapter.b:Lcom/google/android/exoplayer2/extractor/Extractor;
        //   138: ifnonnull       157
        //   141: iload           12
        //   143: istore          11
        //   145: aload_1        
        //   146: invokeinterface com/google/android/exoplayer2/extractor/ExtractorInput.getPosition:()J
        //   151: lload           4
        //   153: lcmp           
        //   154: ifne            160
        //   157: iconst_1       
        //   158: istore          11
        //   160: iload           11
        //   162: invokestatic    com/google/android/exoplayer2/util/Assertions.g:(Z)V
        //   165: aload_1        
        //   166: invokeinterface com/google/android/exoplayer2/extractor/ExtractorInput.h:()V
        //   171: aload_2        
        //   172: athrow         
        //   173: astore          13
        //   175: aload_0        
        //   176: getfield        com/google/android/exoplayer2/source/BundledExtractorsAdapter.b:Lcom/google/android/exoplayer2/extractor/Extractor;
        //   179: ifnonnull       203
        //   182: aload_1        
        //   183: invokeinterface com/google/android/exoplayer2/extractor/ExtractorInput.getPosition:()J
        //   188: lload           4
        //   190: lcmp           
        //   191: ifne            197
        //   194: goto            203
        //   197: iconst_0       
        //   198: istore          11
        //   200: goto            206
        //   203: iconst_1       
        //   204: istore          11
        //   206: iload           11
        //   208: invokestatic    com/google/android/exoplayer2/util/Assertions.g:(Z)V
        //   211: aload_1        
        //   212: invokeinterface com/google/android/exoplayer2/extractor/ExtractorInput.h:()V
        //   217: iinc            9, 1
        //   220: goto            68
        //   223: aload_0        
        //   224: getfield        com/google/android/exoplayer2/source/BundledExtractorsAdapter.b:Lcom/google/android/exoplayer2/extractor/Extractor;
        //   227: ifnull          242
        //   230: aload_0        
        //   231: getfield        com/google/android/exoplayer2/source/BundledExtractorsAdapter.b:Lcom/google/android/exoplayer2/extractor/Extractor;
        //   234: aload           8
        //   236: invokeinterface com/google/android/exoplayer2/extractor/Extractor.b:(Lcom/google/android/exoplayer2/extractor/ExtractorOutput;)V
        //   241: return         
        //   242: new             Ljava/lang/StringBuilder;
        //   245: dup            
        //   246: invokespecial   java/lang/StringBuilder.<init>:()V
        //   249: astore_1       
        //   250: aload_1        
        //   251: ldc             "None of the available extractors ("
        //   253: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   256: pop            
        //   257: aload_1        
        //   258: aload_3        
        //   259: invokestatic    com/google/android/exoplayer2/util/Util.M:([Ljava/lang/Object;)Ljava/lang/String;
        //   262: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   265: pop            
        //   266: aload_1        
        //   267: ldc             ") could read the stream."
        //   269: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   272: pop            
        //   273: new             Lcom/google/android/exoplayer2/source/UnrecognizedInputFormatException;
        //   276: dup            
        //   277: aload_1        
        //   278: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   281: aload_2        
        //   282: invokestatic    com/google/android/exoplayer2/util/Assertions.e:(Ljava/lang/Object;)Ljava/lang/Object;
        //   285: checkcast       Landroid/net/Uri;
        //   288: invokespecial   com/google/android/exoplayer2/source/UnrecognizedInputFormatException.<init>:(Ljava/lang/String;Landroid/net/Uri;)V
        //   291: athrow         
        //    Exceptions:
        //  throws java.io.IOException
        //    Signature:
        //  (Lcom/google/android/exoplayer2/upstream/DataReader;Landroid/net/Uri;Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;JJLcom/google/android/exoplayer2/extractor/ExtractorOutput;)V
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                  
        //  -----  -----  -----  -----  ----------------------
        //  81     98     173    197    Ljava/io/EOFException;
        //  81     98     133    173    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        //     at com.strobel.assembler.ir.StackMappingVisitor.push(StackMappingVisitor.java:290)
        //     at com.strobel.assembler.ir.StackMappingVisitor$InstructionAnalyzer.execute(StackMappingVisitor.java:837)
        //     at com.strobel.assembler.ir.StackMappingVisitor$InstructionAnalyzer.visit(StackMappingVisitor.java:398)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2086)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
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
    
    @Override
    public long e() {
        final ExtractorInput c = this.c;
        long position;
        if (c != null) {
            position = c.getPosition();
        }
        else {
            position = -1L;
        }
        return position;
    }
    
    @Override
    public void release() {
        final Extractor b = this.b;
        if (b != null) {
            b.release();
            this.b = null;
        }
        this.c = null;
    }
}
