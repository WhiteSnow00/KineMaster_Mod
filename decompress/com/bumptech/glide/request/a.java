// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.request;

import com.bumptech.glide.load.DecodeFormat;
import c2.d;
import com.bumptech.glide.load.resource.bitmap.k;
import com.bumptech.glide.load.resource.bitmap.p;
import com.bumptech.glide.load.resource.bitmap.j;
import com.bumptech.glide.load.resource.bitmap.i;
import v2.l;
import android.graphics.Bitmap;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import u2.c;
import c2.b;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Priority;
import android.content.res.Resources$Theme;
import c2.h;
import java.util.Map;
import c2.e;

public abstract class a<T extends a<T>> implements Cloneable
{
    private int A;
    private e B;
    private Map<Class<?>, h<?>> C;
    private Class<?> D;
    private boolean E;
    private Resources$Theme F;
    private boolean G;
    private boolean H;
    private boolean I;
    private boolean J;
    private boolean K;
    private int a;
    private float b;
    private com.bumptech.glide.load.engine.h c;
    private Priority d;
    private Drawable e;
    private int f;
    private Drawable g;
    private int h;
    private boolean i;
    private int j;
    private int p;
    private b w;
    private boolean x;
    private boolean y;
    private Drawable z;
    
    public a() {
        this.b = 1.0f;
        this.c = com.bumptech.glide.load.engine.h.e;
        this.d = Priority.NORMAL;
        this.i = true;
        this.j = -1;
        this.p = -1;
        this.w = u2.c.c();
        this.y = true;
        this.B = new e();
        this.C = new v2.b<Class<?>, h<?>>();
        this.D = Object.class;
        this.J = true;
    }
    
    private boolean M(final int n) {
        return N(this.a, n);
    }
    
    private static boolean N(final int n, final int n2) {
        return (n & n2) != 0x0;
    }
    
    private T Y(final DownsampleStrategy downsampleStrategy, final h<Bitmap> h) {
        return this.g0(downsampleStrategy, h, false);
    }
    
    private T f0(final DownsampleStrategy downsampleStrategy, final h<Bitmap> h) {
        return this.g0(downsampleStrategy, h, true);
    }
    
    private T g0(final DownsampleStrategy downsampleStrategy, final h<Bitmap> h, final boolean b) {
        a<T> a;
        if (b) {
            a = (a<T>)this.p0(downsampleStrategy, h);
        }
        else {
            a = (a<T>)this.Z(downsampleStrategy, h);
        }
        a.J = true;
        return (T)a;
    }
    
    private T h0() {
        return (T)this;
    }
    
    public final Priority A() {
        return this.d;
    }
    
    public final Class<?> B() {
        return this.D;
    }
    
    public final b C() {
        return this.w;
    }
    
    public final float D() {
        return this.b;
    }
    
    public final Resources$Theme E() {
        return this.F;
    }
    
    public final Map<Class<?>, h<?>> F() {
        return this.C;
    }
    
    public final boolean G() {
        return this.K;
    }
    
    public final boolean H() {
        return this.H;
    }
    
    protected final boolean I() {
        return this.G;
    }
    
    public final boolean J() {
        return this.i;
    }
    
    public final boolean K() {
        return this.M(8);
    }
    
    boolean L() {
        return this.J;
    }
    
    public final boolean P() {
        return this.y;
    }
    
    public final boolean Q() {
        return this.x;
    }
    
    public final boolean R() {
        return this.M(2048);
    }
    
    public final boolean S() {
        return l.u(this.p, this.j);
    }
    
    public T T() {
        this.E = true;
        return this.h0();
    }
    
    public T U() {
        return this.Z(DownsampleStrategy.e, new i());
    }
    
    public T V() {
        return this.Y(DownsampleStrategy.d, new j());
    }
    
    public T X() {
        return this.Y(DownsampleStrategy.c, new p());
    }
    
    final T Z(final DownsampleStrategy p0, final h<Bitmap> p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        com/bumptech/glide/request/a.G:Z
        //     4: ifeq            17
        //     7: aload_0        
        //     8: invokevirtual   com/bumptech/glide/request/a.f:()Lcom/bumptech/glide/request/a;
        //    11: aload_1        
        //    12: aload_2        
        //    13: invokevirtual   com/bumptech/glide/request/a.Z:(Lcom/bumptech/glide/load/resource/bitmap/DownsampleStrategy;Lc2/h;)Lcom/bumptech/glide/request/a;
        //    16: areturn        
        //    17: aload_0        
        //    18: aload_1        
        //    19: invokevirtual   com/bumptech/glide/request/a.i:(Lcom/bumptech/glide/load/resource/bitmap/DownsampleStrategy;)Lcom/bumptech/glide/request/a;
        //    22: pop            
        //    23: aload_0        
        //    24: aload_2        
        //    25: iconst_0       
        //    26: invokevirtual   com/bumptech/glide/request/a.o0:(Lc2/h;Z)Lcom/bumptech/glide/request/a;
        //    29: areturn        
        //    Signature:
        //  (Lcom/bumptech/glide/load/resource/bitmap/DownsampleStrategy;Lc2/h<Landroid/graphics/Bitmap;>;)TT;
        // 
        // The error that occurred was:
        // 
        // java.lang.UnsupportedOperationException: The requested operation is not supported.
        //     at com.strobel.util.ContractUtils.unsupported(ContractUtils.java:27)
        //     at com.strobel.assembler.metadata.TypeReference.getRawType(TypeReference.java:284)
        //     at com.strobel.assembler.metadata.TypeReference.getRawType(TypeReference.java:279)
        //     at com.strobel.assembler.metadata.TypeReference.makeGenericType(TypeReference.java:154)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:225)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:25)
        //     at com.strobel.assembler.metadata.ParameterizedType.accept(ParameterizedType.java:103)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visit(TypeSubstitutionVisitor.java:40)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitMethod(TypeSubstitutionVisitor.java:314)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferCall(TypeAnalysis.java:2611)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1040)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:790)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1670)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:667)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:373)
        //     at com.strobel.decompiler.ast.TypeAnalysis.run(TypeAnalysis.java:95)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:344)
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
    
    public T a0(final int p0, final int p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        com/bumptech/glide/request/a.G:Z
        //     4: ifeq            17
        //     7: aload_0        
        //     8: invokevirtual   com/bumptech/glide/request/a.f:()Lcom/bumptech/glide/request/a;
        //    11: iload_1        
        //    12: iload_2        
        //    13: invokevirtual   com/bumptech/glide/request/a.a0:(II)Lcom/bumptech/glide/request/a;
        //    16: areturn        
        //    17: aload_0        
        //    18: iload_1        
        //    19: putfield        com/bumptech/glide/request/a.p:I
        //    22: aload_0        
        //    23: iload_2        
        //    24: putfield        com/bumptech/glide/request/a.j:I
        //    27: aload_0        
        //    28: aload_0        
        //    29: getfield        com/bumptech/glide/request/a.a:I
        //    32: sipush          512
        //    35: ior            
        //    36: putfield        com/bumptech/glide/request/a.a:I
        //    39: aload_0        
        //    40: invokevirtual   com/bumptech/glide/request/a.i0:()Lcom/bumptech/glide/request/a;
        //    43: areturn        
        //    Signature:
        //  (II)TT;
        // 
        // The error that occurred was:
        // 
        // java.lang.UnsupportedOperationException: The requested operation is not supported.
        //     at com.strobel.util.ContractUtils.unsupported(ContractUtils.java:27)
        //     at com.strobel.assembler.metadata.TypeReference.getRawType(TypeReference.java:284)
        //     at com.strobel.assembler.metadata.TypeReference.getRawType(TypeReference.java:279)
        //     at com.strobel.assembler.metadata.TypeReference.makeGenericType(TypeReference.java:154)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:225)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:25)
        //     at com.strobel.assembler.metadata.ParameterizedType.accept(ParameterizedType.java:103)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visit(TypeSubstitutionVisitor.java:40)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitMethod(TypeSubstitutionVisitor.java:314)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferCall(TypeAnalysis.java:2611)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1040)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:790)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1670)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:667)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:373)
        //     at com.strobel.decompiler.ast.TypeAnalysis.run(TypeAnalysis.java:95)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:344)
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
    
    public T b(final a<?> p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        com/bumptech/glide/request/a.G:Z
        //     4: ifeq            16
        //     7: aload_0        
        //     8: invokevirtual   com/bumptech/glide/request/a.f:()Lcom/bumptech/glide/request/a;
        //    11: aload_1        
        //    12: invokevirtual   com/bumptech/glide/request/a.b:(Lcom/bumptech/glide/request/a;)Lcom/bumptech/glide/request/a;
        //    15: areturn        
        //    16: aload_1        
        //    17: getfield        com/bumptech/glide/request/a.a:I
        //    20: iconst_2       
        //    21: invokestatic    com/bumptech/glide/request/a.N:(II)Z
        //    24: ifeq            35
        //    27: aload_0        
        //    28: aload_1        
        //    29: getfield        com/bumptech/glide/request/a.b:F
        //    32: putfield        com/bumptech/glide/request/a.b:F
        //    35: aload_1        
        //    36: getfield        com/bumptech/glide/request/a.a:I
        //    39: ldc             262144
        //    41: invokestatic    com/bumptech/glide/request/a.N:(II)Z
        //    44: ifeq            55
        //    47: aload_0        
        //    48: aload_1        
        //    49: getfield        com/bumptech/glide/request/a.H:Z
        //    52: putfield        com/bumptech/glide/request/a.H:Z
        //    55: aload_1        
        //    56: getfield        com/bumptech/glide/request/a.a:I
        //    59: ldc             1048576
        //    61: invokestatic    com/bumptech/glide/request/a.N:(II)Z
        //    64: ifeq            75
        //    67: aload_0        
        //    68: aload_1        
        //    69: getfield        com/bumptech/glide/request/a.K:Z
        //    72: putfield        com/bumptech/glide/request/a.K:Z
        //    75: aload_1        
        //    76: getfield        com/bumptech/glide/request/a.a:I
        //    79: iconst_4       
        //    80: invokestatic    com/bumptech/glide/request/a.N:(II)Z
        //    83: ifeq            94
        //    86: aload_0        
        //    87: aload_1        
        //    88: getfield        com/bumptech/glide/request/a.c:Lcom/bumptech/glide/load/engine/h;
        //    91: putfield        com/bumptech/glide/request/a.c:Lcom/bumptech/glide/load/engine/h;
        //    94: aload_1        
        //    95: getfield        com/bumptech/glide/request/a.a:I
        //    98: bipush          8
        //   100: invokestatic    com/bumptech/glide/request/a.N:(II)Z
        //   103: ifeq            114
        //   106: aload_0        
        //   107: aload_1        
        //   108: getfield        com/bumptech/glide/request/a.d:Lcom/bumptech/glide/Priority;
        //   111: putfield        com/bumptech/glide/request/a.d:Lcom/bumptech/glide/Priority;
        //   114: aload_1        
        //   115: getfield        com/bumptech/glide/request/a.a:I
        //   118: bipush          16
        //   120: invokestatic    com/bumptech/glide/request/a.N:(II)Z
        //   123: ifeq            150
        //   126: aload_0        
        //   127: aload_1        
        //   128: getfield        com/bumptech/glide/request/a.e:Landroid/graphics/drawable/Drawable;
        //   131: putfield        com/bumptech/glide/request/a.e:Landroid/graphics/drawable/Drawable;
        //   134: aload_0        
        //   135: iconst_0       
        //   136: putfield        com/bumptech/glide/request/a.f:I
        //   139: aload_0        
        //   140: aload_0        
        //   141: getfield        com/bumptech/glide/request/a.a:I
        //   144: bipush          -33
        //   146: iand           
        //   147: putfield        com/bumptech/glide/request/a.a:I
        //   150: aload_1        
        //   151: getfield        com/bumptech/glide/request/a.a:I
        //   154: bipush          32
        //   156: invokestatic    com/bumptech/glide/request/a.N:(II)Z
        //   159: ifeq            186
        //   162: aload_0        
        //   163: aload_1        
        //   164: getfield        com/bumptech/glide/request/a.f:I
        //   167: putfield        com/bumptech/glide/request/a.f:I
        //   170: aload_0        
        //   171: aconst_null    
        //   172: putfield        com/bumptech/glide/request/a.e:Landroid/graphics/drawable/Drawable;
        //   175: aload_0        
        //   176: aload_0        
        //   177: getfield        com/bumptech/glide/request/a.a:I
        //   180: bipush          -17
        //   182: iand           
        //   183: putfield        com/bumptech/glide/request/a.a:I
        //   186: aload_1        
        //   187: getfield        com/bumptech/glide/request/a.a:I
        //   190: bipush          64
        //   192: invokestatic    com/bumptech/glide/request/a.N:(II)Z
        //   195: ifeq            223
        //   198: aload_0        
        //   199: aload_1        
        //   200: getfield        com/bumptech/glide/request/a.g:Landroid/graphics/drawable/Drawable;
        //   203: putfield        com/bumptech/glide/request/a.g:Landroid/graphics/drawable/Drawable;
        //   206: aload_0        
        //   207: iconst_0       
        //   208: putfield        com/bumptech/glide/request/a.h:I
        //   211: aload_0        
        //   212: aload_0        
        //   213: getfield        com/bumptech/glide/request/a.a:I
        //   216: sipush          -129
        //   219: iand           
        //   220: putfield        com/bumptech/glide/request/a.a:I
        //   223: aload_1        
        //   224: getfield        com/bumptech/glide/request/a.a:I
        //   227: sipush          128
        //   230: invokestatic    com/bumptech/glide/request/a.N:(II)Z
        //   233: ifeq            260
        //   236: aload_0        
        //   237: aload_1        
        //   238: getfield        com/bumptech/glide/request/a.h:I
        //   241: putfield        com/bumptech/glide/request/a.h:I
        //   244: aload_0        
        //   245: aconst_null    
        //   246: putfield        com/bumptech/glide/request/a.g:Landroid/graphics/drawable/Drawable;
        //   249: aload_0        
        //   250: aload_0        
        //   251: getfield        com/bumptech/glide/request/a.a:I
        //   254: bipush          -65
        //   256: iand           
        //   257: putfield        com/bumptech/glide/request/a.a:I
        //   260: aload_1        
        //   261: getfield        com/bumptech/glide/request/a.a:I
        //   264: sipush          256
        //   267: invokestatic    com/bumptech/glide/request/a.N:(II)Z
        //   270: ifeq            281
        //   273: aload_0        
        //   274: aload_1        
        //   275: getfield        com/bumptech/glide/request/a.i:Z
        //   278: putfield        com/bumptech/glide/request/a.i:Z
        //   281: aload_1        
        //   282: getfield        com/bumptech/glide/request/a.a:I
        //   285: sipush          512
        //   288: invokestatic    com/bumptech/glide/request/a.N:(II)Z
        //   291: ifeq            310
        //   294: aload_0        
        //   295: aload_1        
        //   296: getfield        com/bumptech/glide/request/a.p:I
        //   299: putfield        com/bumptech/glide/request/a.p:I
        //   302: aload_0        
        //   303: aload_1        
        //   304: getfield        com/bumptech/glide/request/a.j:I
        //   307: putfield        com/bumptech/glide/request/a.j:I
        //   310: aload_1        
        //   311: getfield        com/bumptech/glide/request/a.a:I
        //   314: sipush          1024
        //   317: invokestatic    com/bumptech/glide/request/a.N:(II)Z
        //   320: ifeq            331
        //   323: aload_0        
        //   324: aload_1        
        //   325: getfield        com/bumptech/glide/request/a.w:Lc2/b;
        //   328: putfield        com/bumptech/glide/request/a.w:Lc2/b;
        //   331: aload_1        
        //   332: getfield        com/bumptech/glide/request/a.a:I
        //   335: sipush          4096
        //   338: invokestatic    com/bumptech/glide/request/a.N:(II)Z
        //   341: ifeq            352
        //   344: aload_0        
        //   345: aload_1        
        //   346: getfield        com/bumptech/glide/request/a.D:Ljava/lang/Class;
        //   349: putfield        com/bumptech/glide/request/a.D:Ljava/lang/Class;
        //   352: aload_1        
        //   353: getfield        com/bumptech/glide/request/a.a:I
        //   356: sipush          8192
        //   359: invokestatic    com/bumptech/glide/request/a.N:(II)Z
        //   362: ifeq            390
        //   365: aload_0        
        //   366: aload_1        
        //   367: getfield        com/bumptech/glide/request/a.z:Landroid/graphics/drawable/Drawable;
        //   370: putfield        com/bumptech/glide/request/a.z:Landroid/graphics/drawable/Drawable;
        //   373: aload_0        
        //   374: iconst_0       
        //   375: putfield        com/bumptech/glide/request/a.A:I
        //   378: aload_0        
        //   379: aload_0        
        //   380: getfield        com/bumptech/glide/request/a.a:I
        //   383: sipush          -16385
        //   386: iand           
        //   387: putfield        com/bumptech/glide/request/a.a:I
        //   390: aload_1        
        //   391: getfield        com/bumptech/glide/request/a.a:I
        //   394: sipush          16384
        //   397: invokestatic    com/bumptech/glide/request/a.N:(II)Z
        //   400: ifeq            428
        //   403: aload_0        
        //   404: aload_1        
        //   405: getfield        com/bumptech/glide/request/a.A:I
        //   408: putfield        com/bumptech/glide/request/a.A:I
        //   411: aload_0        
        //   412: aconst_null    
        //   413: putfield        com/bumptech/glide/request/a.z:Landroid/graphics/drawable/Drawable;
        //   416: aload_0        
        //   417: aload_0        
        //   418: getfield        com/bumptech/glide/request/a.a:I
        //   421: sipush          -8193
        //   424: iand           
        //   425: putfield        com/bumptech/glide/request/a.a:I
        //   428: aload_1        
        //   429: getfield        com/bumptech/glide/request/a.a:I
        //   432: ldc             32768
        //   434: invokestatic    com/bumptech/glide/request/a.N:(II)Z
        //   437: ifeq            448
        //   440: aload_0        
        //   441: aload_1        
        //   442: getfield        com/bumptech/glide/request/a.F:Landroid/content/res/Resources$Theme;
        //   445: putfield        com/bumptech/glide/request/a.F:Landroid/content/res/Resources$Theme;
        //   448: aload_1        
        //   449: getfield        com/bumptech/glide/request/a.a:I
        //   452: ldc             65536
        //   454: invokestatic    com/bumptech/glide/request/a.N:(II)Z
        //   457: ifeq            468
        //   460: aload_0        
        //   461: aload_1        
        //   462: getfield        com/bumptech/glide/request/a.y:Z
        //   465: putfield        com/bumptech/glide/request/a.y:Z
        //   468: aload_1        
        //   469: getfield        com/bumptech/glide/request/a.a:I
        //   472: ldc             131072
        //   474: invokestatic    com/bumptech/glide/request/a.N:(II)Z
        //   477: ifeq            488
        //   480: aload_0        
        //   481: aload_1        
        //   482: getfield        com/bumptech/glide/request/a.x:Z
        //   485: putfield        com/bumptech/glide/request/a.x:Z
        //   488: aload_1        
        //   489: getfield        com/bumptech/glide/request/a.a:I
        //   492: sipush          2048
        //   495: invokestatic    com/bumptech/glide/request/a.N:(II)Z
        //   498: ifeq            522
        //   501: aload_0        
        //   502: getfield        com/bumptech/glide/request/a.C:Ljava/util/Map;
        //   505: aload_1        
        //   506: getfield        com/bumptech/glide/request/a.C:Ljava/util/Map;
        //   509: invokeinterface java/util/Map.putAll:(Ljava/util/Map;)V
        //   514: aload_0        
        //   515: aload_1        
        //   516: getfield        com/bumptech/glide/request/a.J:Z
        //   519: putfield        com/bumptech/glide/request/a.J:Z
        //   522: aload_1        
        //   523: getfield        com/bumptech/glide/request/a.a:I
        //   526: ldc             524288
        //   528: invokestatic    com/bumptech/glide/request/a.N:(II)Z
        //   531: ifeq            542
        //   534: aload_0        
        //   535: aload_1        
        //   536: getfield        com/bumptech/glide/request/a.I:Z
        //   539: putfield        com/bumptech/glide/request/a.I:Z
        //   542: aload_0        
        //   543: getfield        com/bumptech/glide/request/a.y:Z
        //   546: ifne            585
        //   549: aload_0        
        //   550: getfield        com/bumptech/glide/request/a.C:Ljava/util/Map;
        //   553: invokeinterface java/util/Map.clear:()V
        //   558: aload_0        
        //   559: getfield        com/bumptech/glide/request/a.a:I
        //   562: istore_2       
        //   563: aload_0        
        //   564: iconst_0       
        //   565: putfield        com/bumptech/glide/request/a.x:Z
        //   568: aload_0        
        //   569: iload_2        
        //   570: sipush          -2049
        //   573: iand           
        //   574: ldc             -131073
        //   576: iand           
        //   577: putfield        com/bumptech/glide/request/a.a:I
        //   580: aload_0        
        //   581: iconst_1       
        //   582: putfield        com/bumptech/glide/request/a.J:Z
        //   585: aload_0        
        //   586: aload_0        
        //   587: getfield        com/bumptech/glide/request/a.a:I
        //   590: aload_1        
        //   591: getfield        com/bumptech/glide/request/a.a:I
        //   594: ior            
        //   595: putfield        com/bumptech/glide/request/a.a:I
        //   598: aload_0        
        //   599: getfield        com/bumptech/glide/request/a.B:Lc2/e;
        //   602: aload_1        
        //   603: getfield        com/bumptech/glide/request/a.B:Lc2/e;
        //   606: invokevirtual   c2/e.d:(Lc2/e;)V
        //   609: aload_0        
        //   610: invokevirtual   com/bumptech/glide/request/a.i0:()Lcom/bumptech/glide/request/a;
        //   613: areturn        
        //    Signature:
        //  (Lcom/bumptech/glide/request/a<*>;)TT;
        // 
        // The error that occurred was:
        // 
        // java.lang.UnsupportedOperationException: The requested operation is not supported.
        //     at com.strobel.util.ContractUtils.unsupported(ContractUtils.java:27)
        //     at com.strobel.assembler.metadata.TypeReference.getRawType(TypeReference.java:284)
        //     at com.strobel.assembler.metadata.TypeReference.getRawType(TypeReference.java:279)
        //     at com.strobel.assembler.metadata.TypeReference.makeGenericType(TypeReference.java:154)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:225)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:25)
        //     at com.strobel.assembler.metadata.ParameterizedType.accept(ParameterizedType.java:103)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visit(TypeSubstitutionVisitor.java:40)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitMethod(TypeSubstitutionVisitor.java:314)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferCall(TypeAnalysis.java:2611)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1040)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:790)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1670)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:667)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:373)
        //     at com.strobel.decompiler.ast.TypeAnalysis.run(TypeAnalysis.java:95)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:344)
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
    
    public T b0(final int p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        com/bumptech/glide/request/a.G:Z
        //     4: ifeq            16
        //     7: aload_0        
        //     8: invokevirtual   com/bumptech/glide/request/a.f:()Lcom/bumptech/glide/request/a;
        //    11: iload_1        
        //    12: invokevirtual   com/bumptech/glide/request/a.b0:(I)Lcom/bumptech/glide/request/a;
        //    15: areturn        
        //    16: aload_0        
        //    17: iload_1        
        //    18: putfield        com/bumptech/glide/request/a.h:I
        //    21: aload_0        
        //    22: getfield        com/bumptech/glide/request/a.a:I
        //    25: istore_1       
        //    26: aload_0        
        //    27: aconst_null    
        //    28: putfield        com/bumptech/glide/request/a.g:Landroid/graphics/drawable/Drawable;
        //    31: aload_0        
        //    32: iload_1        
        //    33: sipush          128
        //    36: ior            
        //    37: bipush          -65
        //    39: iand           
        //    40: putfield        com/bumptech/glide/request/a.a:I
        //    43: aload_0        
        //    44: invokevirtual   com/bumptech/glide/request/a.i0:()Lcom/bumptech/glide/request/a;
        //    47: areturn        
        //    Signature:
        //  (I)TT;
        // 
        // The error that occurred was:
        // 
        // java.lang.UnsupportedOperationException: The requested operation is not supported.
        //     at com.strobel.util.ContractUtils.unsupported(ContractUtils.java:27)
        //     at com.strobel.assembler.metadata.TypeReference.getRawType(TypeReference.java:284)
        //     at com.strobel.assembler.metadata.TypeReference.getRawType(TypeReference.java:279)
        //     at com.strobel.assembler.metadata.TypeReference.makeGenericType(TypeReference.java:154)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:225)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:25)
        //     at com.strobel.assembler.metadata.ParameterizedType.accept(ParameterizedType.java:103)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visit(TypeSubstitutionVisitor.java:40)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitMethod(TypeSubstitutionVisitor.java:314)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferCall(TypeAnalysis.java:2611)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1040)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:790)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1670)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:667)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:373)
        //     at com.strobel.decompiler.ast.TypeAnalysis.run(TypeAnalysis.java:95)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:344)
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
    
    public T c() {
        if (this.E && !this.G) {
            throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
        }
        this.G = true;
        return this.T();
    }
    
    public T c0(final Drawable p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        com/bumptech/glide/request/a.G:Z
        //     4: ifeq            16
        //     7: aload_0        
        //     8: invokevirtual   com/bumptech/glide/request/a.f:()Lcom/bumptech/glide/request/a;
        //    11: aload_1        
        //    12: invokevirtual   com/bumptech/glide/request/a.c0:(Landroid/graphics/drawable/Drawable;)Lcom/bumptech/glide/request/a;
        //    15: areturn        
        //    16: aload_0        
        //    17: aload_1        
        //    18: putfield        com/bumptech/glide/request/a.g:Landroid/graphics/drawable/Drawable;
        //    21: aload_0        
        //    22: getfield        com/bumptech/glide/request/a.a:I
        //    25: istore_2       
        //    26: aload_0        
        //    27: iconst_0       
        //    28: putfield        com/bumptech/glide/request/a.h:I
        //    31: aload_0        
        //    32: iload_2        
        //    33: bipush          64
        //    35: ior            
        //    36: sipush          -129
        //    39: iand           
        //    40: putfield        com/bumptech/glide/request/a.a:I
        //    43: aload_0        
        //    44: invokevirtual   com/bumptech/glide/request/a.i0:()Lcom/bumptech/glide/request/a;
        //    47: areturn        
        //    Signature:
        //  (Landroid/graphics/drawable/Drawable;)TT;
        // 
        // The error that occurred was:
        // 
        // java.lang.UnsupportedOperationException: The requested operation is not supported.
        //     at com.strobel.util.ContractUtils.unsupported(ContractUtils.java:27)
        //     at com.strobel.assembler.metadata.TypeReference.getRawType(TypeReference.java:284)
        //     at com.strobel.assembler.metadata.TypeReference.getRawType(TypeReference.java:279)
        //     at com.strobel.assembler.metadata.TypeReference.makeGenericType(TypeReference.java:154)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:225)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:25)
        //     at com.strobel.assembler.metadata.ParameterizedType.accept(ParameterizedType.java:103)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visit(TypeSubstitutionVisitor.java:40)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitMethod(TypeSubstitutionVisitor.java:314)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferCall(TypeAnalysis.java:2611)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1040)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:790)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1670)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:667)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:373)
        //     at com.strobel.decompiler.ast.TypeAnalysis.run(TypeAnalysis.java:95)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:344)
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
    
    public /* bridge */ Object clone() throws CloneNotSupportedException {
        return this.f();
    }
    
    public T d() {
        return this.p0(DownsampleStrategy.e, new i());
    }
    
    public T d0(final Priority p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        com/bumptech/glide/request/a.G:Z
        //     4: ifeq            16
        //     7: aload_0        
        //     8: invokevirtual   com/bumptech/glide/request/a.f:()Lcom/bumptech/glide/request/a;
        //    11: aload_1        
        //    12: invokevirtual   com/bumptech/glide/request/a.d0:(Lcom/bumptech/glide/Priority;)Lcom/bumptech/glide/request/a;
        //    15: areturn        
        //    16: aload_0        
        //    17: aload_1        
        //    18: invokestatic    v2/k.d:(Ljava/lang/Object;)Ljava/lang/Object;
        //    21: checkcast       Lcom/bumptech/glide/Priority;
        //    24: putfield        com/bumptech/glide/request/a.d:Lcom/bumptech/glide/Priority;
        //    27: aload_0        
        //    28: aload_0        
        //    29: getfield        com/bumptech/glide/request/a.a:I
        //    32: bipush          8
        //    34: ior            
        //    35: putfield        com/bumptech/glide/request/a.a:I
        //    38: aload_0        
        //    39: invokevirtual   com/bumptech/glide/request/a.i0:()Lcom/bumptech/glide/request/a;
        //    42: areturn        
        //    Signature:
        //  (Lcom/bumptech/glide/Priority;)TT;
        // 
        // The error that occurred was:
        // 
        // java.lang.UnsupportedOperationException: The requested operation is not supported.
        //     at com.strobel.util.ContractUtils.unsupported(ContractUtils.java:27)
        //     at com.strobel.assembler.metadata.TypeReference.getRawType(TypeReference.java:284)
        //     at com.strobel.assembler.metadata.TypeReference.getRawType(TypeReference.java:279)
        //     at com.strobel.assembler.metadata.TypeReference.makeGenericType(TypeReference.java:154)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:225)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:25)
        //     at com.strobel.assembler.metadata.ParameterizedType.accept(ParameterizedType.java:103)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visit(TypeSubstitutionVisitor.java:40)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitMethod(TypeSubstitutionVisitor.java:314)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferCall(TypeAnalysis.java:2611)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1040)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:790)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1670)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:667)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:373)
        //     at com.strobel.decompiler.ast.TypeAnalysis.run(TypeAnalysis.java:95)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:344)
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
    
    public T e() {
        return this.p0(DownsampleStrategy.d, new k());
    }
    
    @Override
    public boolean equals(final Object o) {
        final boolean b = o instanceof a;
        boolean b3;
        final boolean b2 = b3 = false;
        if (b) {
            final a a = (a)o;
            b3 = b2;
            if (Float.compare(a.b, this.b) == 0) {
                b3 = b2;
                if (this.f == a.f) {
                    b3 = b2;
                    if (l.d(this.e, a.e)) {
                        b3 = b2;
                        if (this.h == a.h) {
                            b3 = b2;
                            if (l.d(this.g, a.g)) {
                                b3 = b2;
                                if (this.A == a.A) {
                                    b3 = b2;
                                    if (l.d(this.z, a.z)) {
                                        b3 = b2;
                                        if (this.i == a.i) {
                                            b3 = b2;
                                            if (this.j == a.j) {
                                                b3 = b2;
                                                if (this.p == a.p) {
                                                    b3 = b2;
                                                    if (this.x == a.x) {
                                                        b3 = b2;
                                                        if (this.y == a.y) {
                                                            b3 = b2;
                                                            if (this.H == a.H) {
                                                                b3 = b2;
                                                                if (this.I == a.I) {
                                                                    b3 = b2;
                                                                    if (this.c.equals(a.c)) {
                                                                        b3 = b2;
                                                                        if (this.d == a.d) {
                                                                            b3 = b2;
                                                                            if (this.B.equals(a.B)) {
                                                                                b3 = b2;
                                                                                if (this.C.equals(a.C)) {
                                                                                    b3 = b2;
                                                                                    if (this.D.equals(a.D)) {
                                                                                        b3 = b2;
                                                                                        if (l.d(this.w, a.w)) {
                                                                                            b3 = b2;
                                                                                            if (l.d(this.F, a.F)) {
                                                                                                b3 = true;
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return b3;
    }
    
    public T f() {
        try {
            final a a = (a)super.clone();
            (a.B = new e()).d(this.B);
            (a.C = new v2.b<Class<?>, h<?>>()).putAll(this.C);
            a.E = false;
            a.G = false;
            return (T)a;
        }
        catch (final CloneNotSupportedException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public T g(final Class<?> p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        com/bumptech/glide/request/a.G:Z
        //     4: ifeq            16
        //     7: aload_0        
        //     8: invokevirtual   com/bumptech/glide/request/a.f:()Lcom/bumptech/glide/request/a;
        //    11: aload_1        
        //    12: invokevirtual   com/bumptech/glide/request/a.g:(Ljava/lang/Class;)Lcom/bumptech/glide/request/a;
        //    15: areturn        
        //    16: aload_0        
        //    17: aload_1        
        //    18: invokestatic    v2/k.d:(Ljava/lang/Object;)Ljava/lang/Object;
        //    21: checkcast       Ljava/lang/Class;
        //    24: putfield        com/bumptech/glide/request/a.D:Ljava/lang/Class;
        //    27: aload_0        
        //    28: aload_0        
        //    29: getfield        com/bumptech/glide/request/a.a:I
        //    32: sipush          4096
        //    35: ior            
        //    36: putfield        com/bumptech/glide/request/a.a:I
        //    39: aload_0        
        //    40: invokevirtual   com/bumptech/glide/request/a.i0:()Lcom/bumptech/glide/request/a;
        //    43: areturn        
        //    Signature:
        //  (Ljava/lang/Class<*>;)TT;
        // 
        // The error that occurred was:
        // 
        // java.lang.UnsupportedOperationException: The requested operation is not supported.
        //     at com.strobel.util.ContractUtils.unsupported(ContractUtils.java:27)
        //     at com.strobel.assembler.metadata.TypeReference.getRawType(TypeReference.java:284)
        //     at com.strobel.assembler.metadata.TypeReference.getRawType(TypeReference.java:279)
        //     at com.strobel.assembler.metadata.TypeReference.makeGenericType(TypeReference.java:154)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:225)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:25)
        //     at com.strobel.assembler.metadata.ParameterizedType.accept(ParameterizedType.java:103)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visit(TypeSubstitutionVisitor.java:40)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitMethod(TypeSubstitutionVisitor.java:314)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferCall(TypeAnalysis.java:2611)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1040)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:790)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1670)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:667)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:373)
        //     at com.strobel.decompiler.ast.TypeAnalysis.run(TypeAnalysis.java:95)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:344)
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
    
    public T h(final com.bumptech.glide.load.engine.h p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        com/bumptech/glide/request/a.G:Z
        //     4: ifeq            16
        //     7: aload_0        
        //     8: invokevirtual   com/bumptech/glide/request/a.f:()Lcom/bumptech/glide/request/a;
        //    11: aload_1        
        //    12: invokevirtual   com/bumptech/glide/request/a.h:(Lcom/bumptech/glide/load/engine/h;)Lcom/bumptech/glide/request/a;
        //    15: areturn        
        //    16: aload_0        
        //    17: aload_1        
        //    18: invokestatic    v2/k.d:(Ljava/lang/Object;)Ljava/lang/Object;
        //    21: checkcast       Lcom/bumptech/glide/load/engine/h;
        //    24: putfield        com/bumptech/glide/request/a.c:Lcom/bumptech/glide/load/engine/h;
        //    27: aload_0        
        //    28: aload_0        
        //    29: getfield        com/bumptech/glide/request/a.a:I
        //    32: iconst_4       
        //    33: ior            
        //    34: putfield        com/bumptech/glide/request/a.a:I
        //    37: aload_0        
        //    38: invokevirtual   com/bumptech/glide/request/a.i0:()Lcom/bumptech/glide/request/a;
        //    41: areturn        
        //    Signature:
        //  (Lcom/bumptech/glide/load/engine/h;)TT;
        // 
        // The error that occurred was:
        // 
        // java.lang.UnsupportedOperationException: The requested operation is not supported.
        //     at com.strobel.util.ContractUtils.unsupported(ContractUtils.java:27)
        //     at com.strobel.assembler.metadata.TypeReference.getRawType(TypeReference.java:284)
        //     at com.strobel.assembler.metadata.TypeReference.getRawType(TypeReference.java:279)
        //     at com.strobel.assembler.metadata.TypeReference.makeGenericType(TypeReference.java:154)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:225)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:25)
        //     at com.strobel.assembler.metadata.ParameterizedType.accept(ParameterizedType.java:103)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visit(TypeSubstitutionVisitor.java:40)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitMethod(TypeSubstitutionVisitor.java:314)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferCall(TypeAnalysis.java:2611)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1040)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:790)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1670)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:667)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:373)
        //     at com.strobel.decompiler.ast.TypeAnalysis.run(TypeAnalysis.java:95)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:344)
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
    public int hashCode() {
        return l.p(this.F, l.p(this.w, l.p(this.D, l.p(this.C, l.p(this.B, l.p(this.d, l.p(this.c, l.q(this.I, l.q(this.H, l.q(this.y, l.q(this.x, l.o(this.p, l.o(this.j, l.q(this.i, l.p(this.z, l.o(this.A, l.p(this.g, l.o(this.h, l.p(this.e, l.o(this.f, l.l(this.b)))))))))))))))))))));
    }
    
    public T i(final DownsampleStrategy downsampleStrategy) {
        return this.j0(DownsampleStrategy.h, (DownsampleStrategy)v2.k.d((Y)downsampleStrategy));
    }
    
    protected final T i0() {
        if (!this.E) {
            return this.h0();
        }
        throw new IllegalStateException("You cannot modify locked T, consider clone()");
    }
    
    public T j(final int p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        com/bumptech/glide/request/a.G:Z
        //     4: ifeq            16
        //     7: aload_0        
        //     8: invokevirtual   com/bumptech/glide/request/a.f:()Lcom/bumptech/glide/request/a;
        //    11: iload_1        
        //    12: invokevirtual   com/bumptech/glide/request/a.j:(I)Lcom/bumptech/glide/request/a;
        //    15: areturn        
        //    16: aload_0        
        //    17: iload_1        
        //    18: putfield        com/bumptech/glide/request/a.f:I
        //    21: aload_0        
        //    22: getfield        com/bumptech/glide/request/a.a:I
        //    25: istore_1       
        //    26: aload_0        
        //    27: aconst_null    
        //    28: putfield        com/bumptech/glide/request/a.e:Landroid/graphics/drawable/Drawable;
        //    31: aload_0        
        //    32: iload_1        
        //    33: bipush          32
        //    35: ior            
        //    36: bipush          -17
        //    38: iand           
        //    39: putfield        com/bumptech/glide/request/a.a:I
        //    42: aload_0        
        //    43: invokevirtual   com/bumptech/glide/request/a.i0:()Lcom/bumptech/glide/request/a;
        //    46: areturn        
        //    Signature:
        //  (I)TT;
        // 
        // The error that occurred was:
        // 
        // java.lang.UnsupportedOperationException: The requested operation is not supported.
        //     at com.strobel.util.ContractUtils.unsupported(ContractUtils.java:27)
        //     at com.strobel.assembler.metadata.TypeReference.getRawType(TypeReference.java:284)
        //     at com.strobel.assembler.metadata.TypeReference.getRawType(TypeReference.java:279)
        //     at com.strobel.assembler.metadata.TypeReference.makeGenericType(TypeReference.java:154)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:225)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:25)
        //     at com.strobel.assembler.metadata.ParameterizedType.accept(ParameterizedType.java:103)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visit(TypeSubstitutionVisitor.java:40)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitMethod(TypeSubstitutionVisitor.java:314)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferCall(TypeAnalysis.java:2611)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1040)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:790)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1670)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:667)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:373)
        //     at com.strobel.decompiler.ast.TypeAnalysis.run(TypeAnalysis.java:95)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:344)
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
    
    public <Y> T j0(final d<Y> p0, final Y p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        com/bumptech/glide/request/a.G:Z
        //     4: ifeq            17
        //     7: aload_0        
        //     8: invokevirtual   com/bumptech/glide/request/a.f:()Lcom/bumptech/glide/request/a;
        //    11: aload_1        
        //    12: aload_2        
        //    13: invokevirtual   com/bumptech/glide/request/a.j0:(Lc2/d;Ljava/lang/Object;)Lcom/bumptech/glide/request/a;
        //    16: areturn        
        //    17: aload_1        
        //    18: invokestatic    v2/k.d:(Ljava/lang/Object;)Ljava/lang/Object;
        //    21: pop            
        //    22: aload_2        
        //    23: invokestatic    v2/k.d:(Ljava/lang/Object;)Ljava/lang/Object;
        //    26: pop            
        //    27: aload_0        
        //    28: getfield        com/bumptech/glide/request/a.B:Lc2/e;
        //    31: aload_1        
        //    32: aload_2        
        //    33: invokevirtual   c2/e.e:(Lc2/d;Ljava/lang/Object;)Lc2/e;
        //    36: pop            
        //    37: aload_0        
        //    38: invokevirtual   com/bumptech/glide/request/a.i0:()Lcom/bumptech/glide/request/a;
        //    41: areturn        
        //    Signature:
        //  <Y:Ljava/lang/Object;>(Lc2/d<TY;>;TY;)TT;
        // 
        // The error that occurred was:
        // 
        // java.lang.UnsupportedOperationException: The requested operation is not supported.
        //     at com.strobel.util.ContractUtils.unsupported(ContractUtils.java:27)
        //     at com.strobel.assembler.metadata.TypeReference.getRawType(TypeReference.java:284)
        //     at com.strobel.assembler.metadata.TypeReference.getRawType(TypeReference.java:279)
        //     at com.strobel.assembler.metadata.TypeReference.makeGenericType(TypeReference.java:154)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:225)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:25)
        //     at com.strobel.assembler.metadata.ParameterizedType.accept(ParameterizedType.java:103)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visit(TypeSubstitutionVisitor.java:40)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitMethod(TypeSubstitutionVisitor.java:314)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferCall(TypeAnalysis.java:2611)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1040)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:790)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1670)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:667)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:373)
        //     at com.strobel.decompiler.ast.TypeAnalysis.run(TypeAnalysis.java:95)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:344)
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
    
    public T k0(final b p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        com/bumptech/glide/request/a.G:Z
        //     4: ifeq            16
        //     7: aload_0        
        //     8: invokevirtual   com/bumptech/glide/request/a.f:()Lcom/bumptech/glide/request/a;
        //    11: aload_1        
        //    12: invokevirtual   com/bumptech/glide/request/a.k0:(Lc2/b;)Lcom/bumptech/glide/request/a;
        //    15: areturn        
        //    16: aload_0        
        //    17: aload_1        
        //    18: invokestatic    v2/k.d:(Ljava/lang/Object;)Ljava/lang/Object;
        //    21: checkcast       Lc2/b;
        //    24: putfield        com/bumptech/glide/request/a.w:Lc2/b;
        //    27: aload_0        
        //    28: aload_0        
        //    29: getfield        com/bumptech/glide/request/a.a:I
        //    32: sipush          1024
        //    35: ior            
        //    36: putfield        com/bumptech/glide/request/a.a:I
        //    39: aload_0        
        //    40: invokevirtual   com/bumptech/glide/request/a.i0:()Lcom/bumptech/glide/request/a;
        //    43: areturn        
        //    Signature:
        //  (Lc2/b;)TT;
        // 
        // The error that occurred was:
        // 
        // java.lang.UnsupportedOperationException: The requested operation is not supported.
        //     at com.strobel.util.ContractUtils.unsupported(ContractUtils.java:27)
        //     at com.strobel.assembler.metadata.TypeReference.getRawType(TypeReference.java:284)
        //     at com.strobel.assembler.metadata.TypeReference.getRawType(TypeReference.java:279)
        //     at com.strobel.assembler.metadata.TypeReference.makeGenericType(TypeReference.java:154)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:225)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:25)
        //     at com.strobel.assembler.metadata.ParameterizedType.accept(ParameterizedType.java:103)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visit(TypeSubstitutionVisitor.java:40)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitMethod(TypeSubstitutionVisitor.java:314)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferCall(TypeAnalysis.java:2611)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1040)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:790)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1670)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:667)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:373)
        //     at com.strobel.decompiler.ast.TypeAnalysis.run(TypeAnalysis.java:95)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:344)
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
    
    public T l() {
        return this.f0(DownsampleStrategy.c, new p());
    }
    
    public T l0(final float p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        com/bumptech/glide/request/a.G:Z
        //     4: ifeq            16
        //     7: aload_0        
        //     8: invokevirtual   com/bumptech/glide/request/a.f:()Lcom/bumptech/glide/request/a;
        //    11: fload_1        
        //    12: invokevirtual   com/bumptech/glide/request/a.l0:(F)Lcom/bumptech/glide/request/a;
        //    15: areturn        
        //    16: fload_1        
        //    17: fconst_0       
        //    18: fcmpg          
        //    19: iflt            48
        //    22: fload_1        
        //    23: fconst_1       
        //    24: fcmpl          
        //    25: ifgt            48
        //    28: aload_0        
        //    29: fload_1        
        //    30: putfield        com/bumptech/glide/request/a.b:F
        //    33: aload_0        
        //    34: aload_0        
        //    35: getfield        com/bumptech/glide/request/a.a:I
        //    38: iconst_2       
        //    39: ior            
        //    40: putfield        com/bumptech/glide/request/a.a:I
        //    43: aload_0        
        //    44: invokevirtual   com/bumptech/glide/request/a.i0:()Lcom/bumptech/glide/request/a;
        //    47: areturn        
        //    48: new             Ljava/lang/IllegalArgumentException;
        //    51: dup            
        //    52: ldc_w           "sizeMultiplier must be between 0 and 1"
        //    55: invokespecial   java/lang/IllegalArgumentException.<init>:(Ljava/lang/String;)V
        //    58: athrow         
        //    Signature:
        //  (F)TT;
        // 
        // The error that occurred was:
        // 
        // java.lang.UnsupportedOperationException: The requested operation is not supported.
        //     at com.strobel.util.ContractUtils.unsupported(ContractUtils.java:27)
        //     at com.strobel.assembler.metadata.TypeReference.getRawType(TypeReference.java:284)
        //     at com.strobel.assembler.metadata.TypeReference.getRawType(TypeReference.java:279)
        //     at com.strobel.assembler.metadata.TypeReference.makeGenericType(TypeReference.java:154)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:225)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:25)
        //     at com.strobel.assembler.metadata.ParameterizedType.accept(ParameterizedType.java:103)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visit(TypeSubstitutionVisitor.java:40)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitMethod(TypeSubstitutionVisitor.java:314)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferCall(TypeAnalysis.java:2611)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1040)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:790)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1670)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:667)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:373)
        //     at com.strobel.decompiler.ast.TypeAnalysis.run(TypeAnalysis.java:95)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:344)
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
    
    public T m(final DecodeFormat p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    v2/k.d:(Ljava/lang/Object;)Ljava/lang/Object;
        //     4: pop            
        //     5: aload_0        
        //     6: getstatic       com/bumptech/glide/load/resource/bitmap/l.f:Lc2/d;
        //     9: aload_1        
        //    10: invokevirtual   com/bumptech/glide/request/a.j0:(Lc2/d;Ljava/lang/Object;)Lcom/bumptech/glide/request/a;
        //    13: getstatic       n2/i.a:Lc2/d;
        //    16: aload_1        
        //    17: invokevirtual   com/bumptech/glide/request/a.j0:(Lc2/d;Ljava/lang/Object;)Lcom/bumptech/glide/request/a;
        //    20: areturn        
        //    Signature:
        //  (Lcom/bumptech/glide/load/DecodeFormat;)TT;
        // 
        // The error that occurred was:
        // 
        // java.lang.UnsupportedOperationException: The requested operation is not supported.
        //     at com.strobel.util.ContractUtils.unsupported(ContractUtils.java:27)
        //     at com.strobel.assembler.metadata.TypeReference.getRawType(TypeReference.java:284)
        //     at com.strobel.assembler.metadata.TypeReference.getRawType(TypeReference.java:279)
        //     at com.strobel.assembler.metadata.TypeReference.makeGenericType(TypeReference.java:154)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:225)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:25)
        //     at com.strobel.assembler.metadata.ParameterizedType.accept(ParameterizedType.java:103)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visit(TypeSubstitutionVisitor.java:40)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitMethod(TypeSubstitutionVisitor.java:314)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferCall(TypeAnalysis.java:2611)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1040)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:790)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1670)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:667)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:373)
        //     at com.strobel.decompiler.ast.TypeAnalysis.run(TypeAnalysis.java:95)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:344)
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
    
    public T m0(final boolean p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        com/bumptech/glide/request/a.G:Z
        //     4: ifeq            16
        //     7: aload_0        
        //     8: invokevirtual   com/bumptech/glide/request/a.f:()Lcom/bumptech/glide/request/a;
        //    11: iconst_1       
        //    12: invokevirtual   com/bumptech/glide/request/a.m0:(Z)Lcom/bumptech/glide/request/a;
        //    15: areturn        
        //    16: aload_0        
        //    17: iload_1        
        //    18: iconst_1       
        //    19: ixor           
        //    20: putfield        com/bumptech/glide/request/a.i:Z
        //    23: aload_0        
        //    24: aload_0        
        //    25: getfield        com/bumptech/glide/request/a.a:I
        //    28: sipush          256
        //    31: ior            
        //    32: putfield        com/bumptech/glide/request/a.a:I
        //    35: aload_0        
        //    36: invokevirtual   com/bumptech/glide/request/a.i0:()Lcom/bumptech/glide/request/a;
        //    39: areturn        
        //    Signature:
        //  (Z)TT;
        // 
        // The error that occurred was:
        // 
        // java.lang.UnsupportedOperationException: The requested operation is not supported.
        //     at com.strobel.util.ContractUtils.unsupported(ContractUtils.java:27)
        //     at com.strobel.assembler.metadata.TypeReference.getRawType(TypeReference.java:284)
        //     at com.strobel.assembler.metadata.TypeReference.getRawType(TypeReference.java:279)
        //     at com.strobel.assembler.metadata.TypeReference.makeGenericType(TypeReference.java:154)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:225)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:25)
        //     at com.strobel.assembler.metadata.ParameterizedType.accept(ParameterizedType.java:103)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visit(TypeSubstitutionVisitor.java:40)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitMethod(TypeSubstitutionVisitor.java:314)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferCall(TypeAnalysis.java:2611)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1040)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:790)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1670)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:667)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:373)
        //     at com.strobel.decompiler.ast.TypeAnalysis.run(TypeAnalysis.java:95)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:344)
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
    
    public final com.bumptech.glide.load.engine.h n() {
        return this.c;
    }
    
    public T n0(final h<Bitmap> h) {
        return this.o0(h, true);
    }
    
    public final int o() {
        return this.f;
    }
    
    T o0(final h<Bitmap> p0, final boolean p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     4: ifeq            17
        //     7: aload_0        
        //     8: invokevirtual   com/bumptech/glide/request/a.f:()Lcom/bumptech/glide/request/a;
        //    11: aload_1        
        //    12: iload_2        
        //    13: invokevirtual   com/bumptech/glide/request/a.o0:(Lc2/h;Z)Lcom/bumptech/glide/request/a;
        //    16: areturn        
        //    17: new             Lcom/bumptech/glide/load/resource/bitmap/n;
        //    20: dup            
        //    21: aload_1        
        //    22: iload_2        
        //    23: invokespecial   com/bumptech/glide/load/resource/bitmap/n.<init>:(Lc2/h;Z)V
        //    26: astore_3       
        //    27: aload_0        
        //    28: ldc_w           Landroid/graphics/Bitmap;.class
        //    31: aload_1        
        //    32: iload_2        
        //    33: invokevirtual   com/bumptech/glide/request/a.q0:(Ljava/lang/Class;Lc2/h;Z)Lcom/bumptech/glide/request/a;
        //    36: pop            
        //    37: aload_0        
        //    38: ldc_w           Landroid/graphics/drawable/Drawable;.class
        //    41: aload_3        
        //    42: iload_2        
        //    43: invokevirtual   com/bumptech/glide/request/a.q0:(Ljava/lang/Class;Lc2/h;Z)Lcom/bumptech/glide/request/a;
        //    46: pop            
        //    47: aload_0        
        //    48: ldc_w           Landroid/graphics/drawable/BitmapDrawable;.class
        //    51: aload_3        
        //    52: invokevirtual   com/bumptech/glide/load/resource/bitmap/n.c:()Lc2/h;
        //    55: iload_2        
        //    56: invokevirtual   com/bumptech/glide/request/a.q0:(Ljava/lang/Class;Lc2/h;Z)Lcom/bumptech/glide/request/a;
        //    59: pop            
        //    60: aload_0        
        //    61: ldc_w           Ln2/c;.class
        //    64: new             Ln2/f;
        //    67: dup            
        //    68: aload_1        
        //    69: invokespecial   n2/f.<init>:(Lc2/h;)V
        //    72: iload_2        
        //    73: invokevirtual   com/bumptech/glide/request/a.q0:(Ljava/lang/Class;Lc2/h;Z)Lcom/bumptech/glide/request/a;
        //    76: pop            
        //    77: aload_0        
        //    78: invokevirtual   com/bumptech/glide/request/a.i0:()Lcom/bumptech/glide/request/a;
        //    81: areturn        
        //    Signature:
        //  (Lc2/h<Landroid/graphics/Bitmap;>;Z)TT;
        // 
        // The error that occurred was:
        // 
        // java.lang.UnsupportedOperationException: The requested operation is not supported.
        //     at com.strobel.util.ContractUtils.unsupported(ContractUtils.java:27)
        //     at com.strobel.assembler.metadata.TypeReference.getRawType(TypeReference.java:284)
        //     at com.strobel.assembler.metadata.TypeReference.getRawType(TypeReference.java:279)
        //     at com.strobel.assembler.metadata.TypeReference.makeGenericType(TypeReference.java:154)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:225)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:25)
        //     at com.strobel.assembler.metadata.ParameterizedType.accept(ParameterizedType.java:103)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visit(TypeSubstitutionVisitor.java:40)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitMethod(TypeSubstitutionVisitor.java:314)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferCall(TypeAnalysis.java:2611)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1040)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:790)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1670)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
        //     at com.strobel.decompiler.ast.TypeAnalysis.invalidateDependentExpressions(TypeAnalysis.java:771)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1022)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:782)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:778)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferCall(TypeAnalysis.java:2535)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1040)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:667)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:373)
        //     at com.strobel.decompiler.ast.TypeAnalysis.run(TypeAnalysis.java:95)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:109)
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
    
    public final Drawable p() {
        return this.e;
    }
    
    final T p0(final DownsampleStrategy p0, final h<Bitmap> p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        com/bumptech/glide/request/a.G:Z
        //     4: ifeq            17
        //     7: aload_0        
        //     8: invokevirtual   com/bumptech/glide/request/a.f:()Lcom/bumptech/glide/request/a;
        //    11: aload_1        
        //    12: aload_2        
        //    13: invokevirtual   com/bumptech/glide/request/a.p0:(Lcom/bumptech/glide/load/resource/bitmap/DownsampleStrategy;Lc2/h;)Lcom/bumptech/glide/request/a;
        //    16: areturn        
        //    17: aload_0        
        //    18: aload_1        
        //    19: invokevirtual   com/bumptech/glide/request/a.i:(Lcom/bumptech/glide/load/resource/bitmap/DownsampleStrategy;)Lcom/bumptech/glide/request/a;
        //    22: pop            
        //    23: aload_0        
        //    24: aload_2        
        //    25: invokevirtual   com/bumptech/glide/request/a.n0:(Lc2/h;)Lcom/bumptech/glide/request/a;
        //    28: areturn        
        //    Signature:
        //  (Lcom/bumptech/glide/load/resource/bitmap/DownsampleStrategy;Lc2/h<Landroid/graphics/Bitmap;>;)TT;
        // 
        // The error that occurred was:
        // 
        // java.lang.UnsupportedOperationException: The requested operation is not supported.
        //     at com.strobel.util.ContractUtils.unsupported(ContractUtils.java:27)
        //     at com.strobel.assembler.metadata.TypeReference.getRawType(TypeReference.java:284)
        //     at com.strobel.assembler.metadata.TypeReference.getRawType(TypeReference.java:279)
        //     at com.strobel.assembler.metadata.TypeReference.makeGenericType(TypeReference.java:154)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:225)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:25)
        //     at com.strobel.assembler.metadata.ParameterizedType.accept(ParameterizedType.java:103)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visit(TypeSubstitutionVisitor.java:40)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitMethod(TypeSubstitutionVisitor.java:314)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferCall(TypeAnalysis.java:2611)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1040)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:790)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1670)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:667)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:373)
        //     at com.strobel.decompiler.ast.TypeAnalysis.run(TypeAnalysis.java:95)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:344)
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
    
    public final Drawable q() {
        return this.z;
    }
    
     <Y> T q0(final Class<Y> p0, final h<Y> p1, final boolean p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     4: ifeq            18
        //     7: aload_0        
        //     8: invokevirtual   com/bumptech/glide/request/a.f:()Lcom/bumptech/glide/request/a;
        //    11: aload_1        
        //    12: aload_2        
        //    13: iload_3        
        //    14: invokevirtual   com/bumptech/glide/request/a.q0:(Ljava/lang/Class;Lc2/h;Z)Lcom/bumptech/glide/request/a;
        //    17: areturn        
        //    18: aload_1        
        //    19: invokestatic    v2/k.d:(Ljava/lang/Object;)Ljava/lang/Object;
        //    22: pop            
        //    23: aload_2        
        //    24: invokestatic    v2/k.d:(Ljava/lang/Object;)Ljava/lang/Object;
        //    27: pop            
        //    28: aload_0        
        //    29: getfield        com/bumptech/glide/request/a.C:Ljava/util/Map;
        //    32: aload_1        
        //    33: aload_2        
        //    34: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    39: pop            
        //    40: aload_0        
        //    41: getfield        com/bumptech/glide/request/a.a:I
        //    44: istore          4
        //    46: aload_0        
        //    47: iconst_1       
        //    48: putfield        com/bumptech/glide/request/a.y:Z
        //    51: iload           4
        //    53: sipush          2048
        //    56: ior            
        //    57: ldc             65536
        //    59: ior            
        //    60: istore          4
        //    62: aload_0        
        //    63: iload           4
        //    65: putfield        com/bumptech/glide/request/a.a:I
        //    68: aload_0        
        //    69: iconst_0       
        //    70: putfield        com/bumptech/glide/request/a.J:Z
        //    73: iload_3        
        //    74: ifeq            91
        //    77: aload_0        
        //    78: iload           4
        //    80: ldc             131072
        //    82: ior            
        //    83: putfield        com/bumptech/glide/request/a.a:I
        //    86: aload_0        
        //    87: iconst_1       
        //    88: putfield        com/bumptech/glide/request/a.x:Z
        //    91: aload_0        
        //    92: invokevirtual   com/bumptech/glide/request/a.i0:()Lcom/bumptech/glide/request/a;
        //    95: areturn        
        //    Signature:
        //  <Y:Ljava/lang/Object;>(Ljava/lang/Class<TY;>;Lc2/h<TY;>;Z)TT;
        // 
        // The error that occurred was:
        // 
        // java.lang.UnsupportedOperationException: The requested operation is not supported.
        //     at com.strobel.util.ContractUtils.unsupported(ContractUtils.java:27)
        //     at com.strobel.assembler.metadata.TypeReference.getRawType(TypeReference.java:284)
        //     at com.strobel.assembler.metadata.TypeReference.getRawType(TypeReference.java:279)
        //     at com.strobel.assembler.metadata.TypeReference.makeGenericType(TypeReference.java:154)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:225)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:25)
        //     at com.strobel.assembler.metadata.ParameterizedType.accept(ParameterizedType.java:103)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visit(TypeSubstitutionVisitor.java:40)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitMethod(TypeSubstitutionVisitor.java:314)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferCall(TypeAnalysis.java:2611)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1040)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:790)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1670)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:667)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:373)
        //     at com.strobel.decompiler.ast.TypeAnalysis.run(TypeAnalysis.java:95)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:344)
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
    
    public final int r() {
        return this.A;
    }
    
    public T r0(final h<Bitmap>... array) {
        if (array.length > 1) {
            return this.o0(new c2.c<Bitmap>(array), true);
        }
        if (array.length == 1) {
            return this.n0(array[0]);
        }
        return this.i0();
    }
    
    public T s0(final boolean p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        com/bumptech/glide/request/a.G:Z
        //     4: ifeq            16
        //     7: aload_0        
        //     8: invokevirtual   com/bumptech/glide/request/a.f:()Lcom/bumptech/glide/request/a;
        //    11: iload_1        
        //    12: invokevirtual   com/bumptech/glide/request/a.s0:(Z)Lcom/bumptech/glide/request/a;
        //    15: areturn        
        //    16: aload_0        
        //    17: iload_1        
        //    18: putfield        com/bumptech/glide/request/a.K:Z
        //    21: aload_0        
        //    22: aload_0        
        //    23: getfield        com/bumptech/glide/request/a.a:I
        //    26: ldc             1048576
        //    28: ior            
        //    29: putfield        com/bumptech/glide/request/a.a:I
        //    32: aload_0        
        //    33: invokevirtual   com/bumptech/glide/request/a.i0:()Lcom/bumptech/glide/request/a;
        //    36: areturn        
        //    Signature:
        //  (Z)TT;
        // 
        // The error that occurred was:
        // 
        // java.lang.UnsupportedOperationException: The requested operation is not supported.
        //     at com.strobel.util.ContractUtils.unsupported(ContractUtils.java:27)
        //     at com.strobel.assembler.metadata.TypeReference.getRawType(TypeReference.java:284)
        //     at com.strobel.assembler.metadata.TypeReference.getRawType(TypeReference.java:279)
        //     at com.strobel.assembler.metadata.TypeReference.makeGenericType(TypeReference.java:154)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:225)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:25)
        //     at com.strobel.assembler.metadata.ParameterizedType.accept(ParameterizedType.java:103)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visit(TypeSubstitutionVisitor.java:40)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitMethod(TypeSubstitutionVisitor.java:314)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferCall(TypeAnalysis.java:2611)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1040)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:790)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1670)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:667)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:373)
        //     at com.strobel.decompiler.ast.TypeAnalysis.run(TypeAnalysis.java:95)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:344)
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
    
    public final boolean u() {
        return this.I;
    }
    
    public final e v() {
        return this.B;
    }
    
    public final int w() {
        return this.j;
    }
    
    public final int x() {
        return this.p;
    }
    
    public final Drawable y() {
        return this.g;
    }
    
    public final int z() {
        return this.h;
    }
}
