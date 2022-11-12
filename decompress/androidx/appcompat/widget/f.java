// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.widget;

import android.util.AttributeSet;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.a;
import androidx.core.widget.c;
import android.graphics.PorterDuff$Mode;
import android.content.res.ColorStateList;
import android.widget.CheckedTextView;

class f
{
    private final CheckedTextView a;
    private ColorStateList b;
    private PorterDuff$Mode c;
    private boolean d;
    private boolean e;
    private boolean f;
    
    f(final CheckedTextView a) {
        this.b = null;
        this.c = null;
        this.d = false;
        this.e = false;
        this.a = a;
    }
    
    void a() {
        final Drawable a = androidx.core.widget.c.a(this.a);
        if (a != null && (this.d || this.e)) {
            final Drawable mutate = androidx.core.graphics.drawable.a.l(a).mutate();
            if (this.d) {
                androidx.core.graphics.drawable.a.i(mutate, this.b);
            }
            if (this.e) {
                androidx.core.graphics.drawable.a.j(mutate, this.c);
            }
            if (mutate.isStateful()) {
                mutate.setState(this.a.getDrawableState());
            }
            this.a.setCheckMarkDrawable(mutate);
        }
    }
    
    ColorStateList b() {
        return this.b;
    }
    
    PorterDuff$Mode c() {
        return this.c;
    }
    
    void d(final AttributeSet p0, final int p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     4: invokevirtual   android/widget/CheckedTextView.getContext:()Landroid/content/Context;
        //     7: astore_3       
        //     8: getstatic       d/j.P0:[I
        //    11: astore          4
        //    13: aload_3        
        //    14: aload_1        
        //    15: aload           4
        //    17: iload_2        
        //    18: iconst_0       
        //    19: invokestatic    androidx/appcompat/widget/r0.v:(Landroid/content/Context;Landroid/util/AttributeSet;[III)Landroidx/appcompat/widget/r0;
        //    22: astore_3       
        //    23: aload_0        
        //    24: getfield        androidx/appcompat/widget/f.a:Landroid/widget/CheckedTextView;
        //    27: astore          5
        //    29: aload           5
        //    31: aload           5
        //    33: invokevirtual   android/widget/CheckedTextView.getContext:()Landroid/content/Context;
        //    36: aload           4
        //    38: aload_1        
        //    39: aload_3        
        //    40: invokevirtual   androidx/appcompat/widget/r0.r:()Landroid/content/res/TypedArray;
        //    43: iload_2        
        //    44: iconst_0       
        //    45: invokestatic    androidx/core/view/b0.n0:(Landroid/view/View;Landroid/content/Context;[ILandroid/util/AttributeSet;Landroid/content/res/TypedArray;II)V
        //    48: getstatic       d/j.R0:I
        //    51: istore_2       
        //    52: aload_3        
        //    53: iload_2        
        //    54: invokevirtual   androidx/appcompat/widget/r0.s:(I)Z
        //    57: ifeq            93
        //    60: aload_3        
        //    61: iload_2        
        //    62: iconst_0       
        //    63: invokevirtual   androidx/appcompat/widget/r0.n:(II)I
        //    66: istore_2       
        //    67: iload_2        
        //    68: ifeq            93
        //    71: aload_0        
        //    72: getfield        androidx/appcompat/widget/f.a:Landroid/widget/CheckedTextView;
        //    75: astore_1       
        //    76: aload_1        
        //    77: aload_1        
        //    78: invokevirtual   android/widget/CheckedTextView.getContext:()Landroid/content/Context;
        //    81: iload_2        
        //    82: invokestatic    e/a.b:(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;
        //    85: invokevirtual   android/widget/CheckedTextView.setCheckMarkDrawable:(Landroid/graphics/drawable/Drawable;)V
        //    88: iconst_1       
        //    89: istore_2       
        //    90: goto            95
        //    93: iconst_0       
        //    94: istore_2       
        //    95: iload_2        
        //    96: ifne            139
        //    99: getstatic       d/j.Q0:I
        //   102: istore_2       
        //   103: aload_3        
        //   104: iload_2        
        //   105: invokevirtual   androidx/appcompat/widget/r0.s:(I)Z
        //   108: ifeq            139
        //   111: aload_3        
        //   112: iload_2        
        //   113: iconst_0       
        //   114: invokevirtual   androidx/appcompat/widget/r0.n:(II)I
        //   117: istore_2       
        //   118: iload_2        
        //   119: ifeq            139
        //   122: aload_0        
        //   123: getfield        androidx/appcompat/widget/f.a:Landroid/widget/CheckedTextView;
        //   126: astore_1       
        //   127: aload_1        
        //   128: aload_1        
        //   129: invokevirtual   android/widget/CheckedTextView.getContext:()Landroid/content/Context;
        //   132: iload_2        
        //   133: invokestatic    e/a.b:(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;
        //   136: invokevirtual   android/widget/CheckedTextView.setCheckMarkDrawable:(Landroid/graphics/drawable/Drawable;)V
        //   139: getstatic       d/j.S0:I
        //   142: istore_2       
        //   143: aload_3        
        //   144: iload_2        
        //   145: invokevirtual   androidx/appcompat/widget/r0.s:(I)Z
        //   148: ifeq            163
        //   151: aload_0        
        //   152: getfield        androidx/appcompat/widget/f.a:Landroid/widget/CheckedTextView;
        //   155: aload_3        
        //   156: iload_2        
        //   157: invokevirtual   androidx/appcompat/widget/r0.c:(I)Landroid/content/res/ColorStateList;
        //   160: invokestatic    androidx/core/widget/c.b:(Landroid/widget/CheckedTextView;Landroid/content/res/ColorStateList;)V
        //   163: getstatic       d/j.T0:I
        //   166: istore_2       
        //   167: aload_3        
        //   168: iload_2        
        //   169: invokevirtual   androidx/appcompat/widget/r0.s:(I)Z
        //   172: ifeq            192
        //   175: aload_0        
        //   176: getfield        androidx/appcompat/widget/f.a:Landroid/widget/CheckedTextView;
        //   179: aload_3        
        //   180: iload_2        
        //   181: iconst_m1      
        //   182: invokevirtual   androidx/appcompat/widget/r0.k:(II)I
        //   185: aconst_null    
        //   186: invokestatic    androidx/appcompat/widget/a0.e:(ILandroid/graphics/PorterDuff$Mode;)Landroid/graphics/PorterDuff$Mode;
        //   189: invokestatic    androidx/core/widget/c.c:(Landroid/widget/CheckedTextView;Landroid/graphics/PorterDuff$Mode;)V
        //   192: aload_3        
        //   193: invokevirtual   androidx/appcompat/widget/r0.w:()V
        //   196: return         
        //   197: astore_1       
        //   198: aload_3        
        //   199: invokevirtual   androidx/appcompat/widget/r0.w:()V
        //   202: aload_1        
        //   203: athrow         
        //   204: astore_1       
        //   205: goto            93
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                             
        //  -----  -----  -----  -----  -------------------------------------------------
        //  48     67     197    204    Any
        //  71     88     204    208    Landroid/content/res/Resources$NotFoundException;
        //  71     88     197    204    Any
        //  99     118    197    204    Any
        //  122    139    197    204    Any
        //  139    163    197    204    Any
        //  163    192    197    204    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0093:
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
    
    void e() {
        if (this.f) {
            this.f = false;
            return;
        }
        this.f = true;
        this.a();
    }
    
    void f(final ColorStateList b) {
        this.b = b;
        this.d = true;
        this.a();
    }
    
    void g(final PorterDuff$Mode c) {
        this.c = c;
        this.e = true;
        this.a();
    }
}
