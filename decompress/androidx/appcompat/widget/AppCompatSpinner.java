// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.widget;

import android.widget.PopupWindow$OnDismissListener;
import androidx.core.view.b0;
import android.widget.AdapterView;
import android.widget.AdapterView$OnItemClickListener;
import android.database.DataSetObserver;
import android.content.DialogInterface;
import android.widget.ListView;
import android.util.Log;
import androidx.appcompat.app.c;
import android.content.DialogInterface$OnClickListener;
import android.widget.ThemedSpinnerAdapter;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.view.View$BaseSavedState;
import android.widget.ListAdapter;
import android.widget.Adapter;
import android.view.MotionEvent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver$OnGlobalLayoutListener;
import android.os.Parcelable;
import android.graphics.PorterDuff$Mode;
import android.content.res.ColorStateList;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;
import android.view.View$MeasureSpec;
import android.graphics.drawable.Drawable;
import android.content.res.Resources$Theme;
import d.a;
import android.util.AttributeSet;
import android.graphics.Rect;
import android.widget.SpinnerAdapter;
import android.content.Context;
import android.widget.Spinner;

public class AppCompatSpinner extends Spinner
{
    private static final int[] i;
    private final androidx.appcompat.widget.d a;
    private final Context b;
    private d0 c;
    private SpinnerAdapter d;
    private final boolean e;
    private i f;
    int g;
    final Rect h;
    
    static {
        i = new int[] { 16843505 };
    }
    
    public AppCompatSpinner(final Context context, final AttributeSet set) {
        this(context, set, d.a.L);
    }
    
    public AppCompatSpinner(final Context context, final AttributeSet set, final int n) {
        this(context, set, n, -1);
    }
    
    public AppCompatSpinner(final Context context, final AttributeSet set, final int n, final int n2) {
        this(context, set, n, n2, null);
    }
    
    public AppCompatSpinner(final Context p0, final AttributeSet p1, final int p2, final int p3, final Resources$Theme p4) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: aload_1        
        //     2: aload_2        
        //     3: iload_3        
        //     4: invokespecial   android/widget/Spinner.<init>:(Landroid/content/Context;Landroid/util/AttributeSet;I)V
        //     7: aload_0        
        //     8: new             Landroid/graphics/Rect;
        //    11: dup            
        //    12: invokespecial   android/graphics/Rect.<init>:()V
        //    15: putfield        androidx/appcompat/widget/AppCompatSpinner.h:Landroid/graphics/Rect;
        //    18: aload_0        
        //    19: aload_0        
        //    20: invokevirtual   android/widget/Spinner.getContext:()Landroid/content/Context;
        //    23: invokestatic    androidx/appcompat/widget/m0.a:(Landroid/view/View;Landroid/content/Context;)V
        //    26: aload_1        
        //    27: aload_2        
        //    28: getstatic       d/j.x2:[I
        //    31: iload_3        
        //    32: iconst_0       
        //    33: invokestatic    androidx/appcompat/widget/r0.v:(Landroid/content/Context;Landroid/util/AttributeSet;[III)Landroidx/appcompat/widget/r0;
        //    36: astore          9
        //    38: aload_0        
        //    39: new             Landroidx/appcompat/widget/d;
        //    42: dup            
        //    43: aload_0        
        //    44: invokespecial   androidx/appcompat/widget/d.<init>:(Landroid/view/View;)V
        //    47: putfield        androidx/appcompat/widget/AppCompatSpinner.a:Landroidx/appcompat/widget/d;
        //    50: aload           5
        //    52: ifnull          72
        //    55: aload_0        
        //    56: new             Landroidx/appcompat/view/d;
        //    59: dup            
        //    60: aload_1        
        //    61: aload           5
        //    63: invokespecial   androidx/appcompat/view/d.<init>:(Landroid/content/Context;Landroid/content/res/Resources$Theme;)V
        //    66: putfield        androidx/appcompat/widget/AppCompatSpinner.b:Landroid/content/Context;
        //    69: goto            110
        //    72: aload           9
        //    74: getstatic       d/j.C2:I
        //    77: iconst_0       
        //    78: invokevirtual   androidx/appcompat/widget/r0.n:(II)I
        //    81: istore          6
        //    83: iload           6
        //    85: ifeq            105
        //    88: aload_0        
        //    89: new             Landroidx/appcompat/view/d;
        //    92: dup            
        //    93: aload_1        
        //    94: iload           6
        //    96: invokespecial   androidx/appcompat/view/d.<init>:(Landroid/content/Context;I)V
        //    99: putfield        androidx/appcompat/widget/AppCompatSpinner.b:Landroid/content/Context;
        //   102: goto            110
        //   105: aload_0        
        //   106: aload_1        
        //   107: putfield        androidx/appcompat/widget/AppCompatSpinner.b:Landroid/content/Context;
        //   110: aconst_null    
        //   111: astore          7
        //   113: iload           4
        //   115: istore          6
        //   117: iload           4
        //   119: iconst_m1      
        //   120: if_icmpne       248
        //   123: aload_1        
        //   124: aload_2        
        //   125: getstatic       androidx/appcompat/widget/AppCompatSpinner.i:[I
        //   128: iload_3        
        //   129: iconst_0       
        //   130: invokevirtual   android/content/Context.obtainStyledAttributes:(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
        //   133: astore          5
        //   135: iload           4
        //   137: istore          6
        //   139: aload           5
        //   141: astore          8
        //   143: aload           5
        //   145: astore          7
        //   147: aload           5
        //   149: iconst_0       
        //   150: invokevirtual   android/content/res/TypedArray.hasValue:(I)Z
        //   153: ifeq            173
        //   156: aload           5
        //   158: astore          7
        //   160: aload           5
        //   162: iconst_0       
        //   163: iconst_0       
        //   164: invokevirtual   android/content/res/TypedArray.getInt:(II)I
        //   167: istore          6
        //   169: aload           5
        //   171: astore          8
        //   173: aload           8
        //   175: invokevirtual   android/content/res/TypedArray.recycle:()V
        //   178: goto            248
        //   181: astore          8
        //   183: goto            198
        //   186: astore_2       
        //   187: aload           7
        //   189: astore_1       
        //   190: goto            238
        //   193: astore          8
        //   195: aconst_null    
        //   196: astore          5
        //   198: aload           5
        //   200: astore          7
        //   202: ldc             "AppCompatSpinner"
        //   204: ldc             "Could not read android:spinnerMode"
        //   206: aload           8
        //   208: invokestatic    android/util/Log.i:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   211: pop            
        //   212: iload           4
        //   214: istore          6
        //   216: aload           5
        //   218: ifnull          248
        //   221: iload           4
        //   223: istore          6
        //   225: aload           5
        //   227: astore          8
        //   229: goto            173
        //   232: astore_1       
        //   233: aload_1        
        //   234: astore_2       
        //   235: aload           7
        //   237: astore_1       
        //   238: aload_1        
        //   239: ifnull          246
        //   242: aload_1        
        //   243: invokevirtual   android/content/res/TypedArray.recycle:()V
        //   246: aload_2        
        //   247: athrow         
        //   248: iload           6
        //   250: ifeq            362
        //   253: iload           6
        //   255: iconst_1       
        //   256: if_icmpeq       262
        //   259: goto            393
        //   262: new             Landroidx/appcompat/widget/AppCompatSpinner$h;
        //   265: dup            
        //   266: aload_0        
        //   267: aload_0        
        //   268: getfield        androidx/appcompat/widget/AppCompatSpinner.b:Landroid/content/Context;
        //   271: aload_2        
        //   272: iload_3        
        //   273: invokespecial   androidx/appcompat/widget/AppCompatSpinner$h.<init>:(Landroidx/appcompat/widget/AppCompatSpinner;Landroid/content/Context;Landroid/util/AttributeSet;I)V
        //   276: astore          5
        //   278: aload_0        
        //   279: getfield        androidx/appcompat/widget/AppCompatSpinner.b:Landroid/content/Context;
        //   282: aload_2        
        //   283: getstatic       d/j.x2:[I
        //   286: iload_3        
        //   287: iconst_0       
        //   288: invokestatic    androidx/appcompat/widget/r0.v:(Landroid/content/Context;Landroid/util/AttributeSet;[III)Landroidx/appcompat/widget/r0;
        //   291: astore          7
        //   293: aload_0        
        //   294: aload           7
        //   296: getstatic       d/j.B2:I
        //   299: bipush          -2
        //   301: invokevirtual   androidx/appcompat/widget/r0.m:(II)I
        //   304: putfield        androidx/appcompat/widget/AppCompatSpinner.g:I
        //   307: aload           5
        //   309: aload           7
        //   311: getstatic       d/j.z2:I
        //   314: invokevirtual   androidx/appcompat/widget/r0.g:(I)Landroid/graphics/drawable/Drawable;
        //   317: invokevirtual   androidx/appcompat/widget/e0.b:(Landroid/graphics/drawable/Drawable;)V
        //   320: aload           5
        //   322: aload           9
        //   324: getstatic       d/j.A2:I
        //   327: invokevirtual   androidx/appcompat/widget/r0.o:(I)Ljava/lang/String;
        //   330: invokevirtual   androidx/appcompat/widget/AppCompatSpinner$h.h:(Ljava/lang/CharSequence;)V
        //   333: aload           7
        //   335: invokevirtual   androidx/appcompat/widget/r0.w:()V
        //   338: aload_0        
        //   339: aload           5
        //   341: putfield        androidx/appcompat/widget/AppCompatSpinner.f:Landroidx/appcompat/widget/AppCompatSpinner$i;
        //   344: aload_0        
        //   345: new             Landroidx/appcompat/widget/AppCompatSpinner$a;
        //   348: dup            
        //   349: aload_0        
        //   350: aload_0        
        //   351: aload           5
        //   353: invokespecial   androidx/appcompat/widget/AppCompatSpinner$a.<init>:(Landroidx/appcompat/widget/AppCompatSpinner;Landroid/view/View;Landroidx/appcompat/widget/AppCompatSpinner$h;)V
        //   356: putfield        androidx/appcompat/widget/AppCompatSpinner.c:Landroidx/appcompat/widget/d0;
        //   359: goto            393
        //   362: new             Landroidx/appcompat/widget/AppCompatSpinner$f;
        //   365: dup            
        //   366: aload_0        
        //   367: invokespecial   androidx/appcompat/widget/AppCompatSpinner$f.<init>:(Landroidx/appcompat/widget/AppCompatSpinner;)V
        //   370: astore          5
        //   372: aload_0        
        //   373: aload           5
        //   375: putfield        androidx/appcompat/widget/AppCompatSpinner.f:Landroidx/appcompat/widget/AppCompatSpinner$i;
        //   378: aload           5
        //   380: aload           9
        //   382: getstatic       d/j.A2:I
        //   385: invokevirtual   androidx/appcompat/widget/r0.o:(I)Ljava/lang/String;
        //   388: invokeinterface androidx/appcompat/widget/AppCompatSpinner$i.h:(Ljava/lang/CharSequence;)V
        //   393: aload           9
        //   395: getstatic       d/j.y2:I
        //   398: invokevirtual   androidx/appcompat/widget/r0.q:(I)[Ljava/lang/CharSequence;
        //   401: astore          5
        //   403: aload           5
        //   405: ifnull          433
        //   408: new             Landroid/widget/ArrayAdapter;
        //   411: dup            
        //   412: aload_1        
        //   413: ldc             17367048
        //   415: aload           5
        //   417: invokespecial   android/widget/ArrayAdapter.<init>:(Landroid/content/Context;I[Ljava/lang/Object;)V
        //   420: astore_1       
        //   421: aload_1        
        //   422: getstatic       d/g.s:I
        //   425: invokevirtual   android/widget/ArrayAdapter.setDropDownViewResource:(I)V
        //   428: aload_0        
        //   429: aload_1        
        //   430: invokevirtual   androidx/appcompat/widget/AppCompatSpinner.setAdapter:(Landroid/widget/SpinnerAdapter;)V
        //   433: aload           9
        //   435: invokevirtual   androidx/appcompat/widget/r0.w:()V
        //   438: aload_0        
        //   439: iconst_1       
        //   440: putfield        androidx/appcompat/widget/AppCompatSpinner.e:Z
        //   443: aload_0        
        //   444: getfield        androidx/appcompat/widget/AppCompatSpinner.d:Landroid/widget/SpinnerAdapter;
        //   447: astore_1       
        //   448: aload_1        
        //   449: ifnull          462
        //   452: aload_0        
        //   453: aload_1        
        //   454: invokevirtual   androidx/appcompat/widget/AppCompatSpinner.setAdapter:(Landroid/widget/SpinnerAdapter;)V
        //   457: aload_0        
        //   458: aconst_null    
        //   459: putfield        androidx/appcompat/widget/AppCompatSpinner.d:Landroid/widget/SpinnerAdapter;
        //   462: aload_0        
        //   463: getfield        androidx/appcompat/widget/AppCompatSpinner.a:Landroidx/appcompat/widget/d;
        //   466: aload_2        
        //   467: iload_3        
        //   468: invokevirtual   androidx/appcompat/widget/d.e:(Landroid/util/AttributeSet;I)V
        //   471: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  123    135    193    198    Ljava/lang/Exception;
        //  123    135    186    193    Any
        //  147    156    181    186    Ljava/lang/Exception;
        //  147    156    232    238    Any
        //  160    169    181    186    Ljava/lang/Exception;
        //  160    169    232    238    Any
        //  202    212    232    238    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0173:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2604)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:206)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:93)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:868)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createConstructor(AstBuilder.java:799)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:635)
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
    
    int a(final SpinnerAdapter spinnerAdapter, final Drawable drawable) {
        int n = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        final int measureSpec = View$MeasureSpec.makeMeasureSpec(this.getMeasuredWidth(), 0);
        final int measureSpec2 = View$MeasureSpec.makeMeasureSpec(this.getMeasuredHeight(), 0);
        final int max = Math.max(0, this.getSelectedItemPosition());
        final int min = Math.min(spinnerAdapter.getCount(), max + 15);
        int i = Math.max(0, max - (15 - (min - max)));
        View view = null;
        int max2 = 0;
        while (i < min) {
            final int itemViewType = spinnerAdapter.getItemViewType(i);
            int n2;
            if (itemViewType != (n2 = n)) {
                view = null;
                n2 = itemViewType;
            }
            view = spinnerAdapter.getView(i, view, (ViewGroup)this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup$LayoutParams(-2, -2));
            }
            view.measure(measureSpec, measureSpec2);
            max2 = Math.max(max2, view.getMeasuredWidth());
            ++i;
            n = n2;
        }
        int n3 = max2;
        if (drawable != null) {
            drawable.getPadding(this.h);
            final Rect h = this.h;
            n3 = max2 + (h.left + h.right);
        }
        return n3;
    }
    
    void b() {
        this.f.k(AppCompatSpinner.d.b((View)this), AppCompatSpinner.d.a((View)this));
    }
    
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        final androidx.appcompat.widget.d a = this.a;
        if (a != null) {
            a.b();
        }
    }
    
    public int getDropDownHorizontalOffset() {
        final i f = this.f;
        if (f != null) {
            return f.c();
        }
        return super.getDropDownHorizontalOffset();
    }
    
    public int getDropDownVerticalOffset() {
        final i f = this.f;
        if (f != null) {
            return f.l();
        }
        return super.getDropDownVerticalOffset();
    }
    
    public int getDropDownWidth() {
        if (this.f != null) {
            return this.g;
        }
        return super.getDropDownWidth();
    }
    
    final i getInternalPopup() {
        return this.f;
    }
    
    public Drawable getPopupBackground() {
        final i f = this.f;
        if (f != null) {
            return f.g();
        }
        return super.getPopupBackground();
    }
    
    public Context getPopupContext() {
        return this.b;
    }
    
    public CharSequence getPrompt() {
        final i f = this.f;
        CharSequence charSequence;
        if (f != null) {
            charSequence = f.f();
        }
        else {
            charSequence = super.getPrompt();
        }
        return charSequence;
    }
    
    public ColorStateList getSupportBackgroundTintList() {
        final androidx.appcompat.widget.d a = this.a;
        ColorStateList c;
        if (a != null) {
            c = a.c();
        }
        else {
            c = null;
        }
        return c;
    }
    
    public PorterDuff$Mode getSupportBackgroundTintMode() {
        final androidx.appcompat.widget.d a = this.a;
        PorterDuff$Mode d;
        if (a != null) {
            d = a.d();
        }
        else {
            d = null;
        }
        return d;
    }
    
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        final i f = this.f;
        if (f != null && f.a()) {
            this.f.dismiss();
        }
    }
    
    protected void onMeasure(final int n, final int n2) {
        super.onMeasure(n, n2);
        if (this.f != null && View$MeasureSpec.getMode(n) == Integer.MIN_VALUE) {
            this.setMeasuredDimension(Math.min(Math.max(this.getMeasuredWidth(), this.a(this.getAdapter(), this.getBackground())), View$MeasureSpec.getSize(n)), this.getMeasuredHeight());
        }
    }
    
    public void onRestoreInstanceState(final Parcelable parcelable) {
        final SavedState savedState = (SavedState)parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.a) {
            final ViewTreeObserver viewTreeObserver = this.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnGlobalLayoutListener((ViewTreeObserver$OnGlobalLayoutListener)new ViewTreeObserver$OnGlobalLayoutListener(this) {
                    final AppCompatSpinner a;
                    
                    public void onGlobalLayout() {
                        if (!this.a.getInternalPopup().a()) {
                            this.a.b();
                        }
                        final ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
                        if (viewTreeObserver != null) {
                            AppCompatSpinner.c.a(viewTreeObserver, (ViewTreeObserver$OnGlobalLayoutListener)this);
                        }
                    }
                });
            }
        }
    }
    
    public Parcelable onSaveInstanceState() {
        final SavedState savedState = new SavedState(super.onSaveInstanceState());
        final i f = this.f;
        savedState.a = (f != null && f.a());
        return (Parcelable)savedState;
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        final d0 c = this.c;
        return (c != null && c.onTouch((View)this, motionEvent)) || super.onTouchEvent(motionEvent);
    }
    
    public boolean performClick() {
        final i f = this.f;
        if (f != null) {
            if (!f.a()) {
                this.b();
            }
            return true;
        }
        return super.performClick();
    }
    
    public /* bridge */ void setAdapter(final Adapter adapter) {
        this.setAdapter((SpinnerAdapter)adapter);
    }
    
    public void setAdapter(final SpinnerAdapter spinnerAdapter) {
        if (!this.e) {
            this.d = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.f != null) {
            Context context;
            if ((context = this.b) == null) {
                context = this.getContext();
            }
            this.f.m((ListAdapter)new g(spinnerAdapter, context.getTheme()));
        }
    }
    
    public void setBackgroundDrawable(final Drawable backgroundDrawable) {
        super.setBackgroundDrawable(backgroundDrawable);
        final androidx.appcompat.widget.d a = this.a;
        if (a != null) {
            a.f(backgroundDrawable);
        }
    }
    
    public void setBackgroundResource(final int backgroundResource) {
        super.setBackgroundResource(backgroundResource);
        final androidx.appcompat.widget.d a = this.a;
        if (a != null) {
            a.g(backgroundResource);
        }
    }
    
    public void setDropDownHorizontalOffset(final int dropDownHorizontalOffset) {
        final i f = this.f;
        if (f != null) {
            f.j(dropDownHorizontalOffset);
            this.f.e(dropDownHorizontalOffset);
        }
        else {
            super.setDropDownHorizontalOffset(dropDownHorizontalOffset);
        }
    }
    
    public void setDropDownVerticalOffset(final int dropDownVerticalOffset) {
        final i f = this.f;
        if (f != null) {
            f.i(dropDownVerticalOffset);
        }
        else {
            super.setDropDownVerticalOffset(dropDownVerticalOffset);
        }
    }
    
    public void setDropDownWidth(final int n) {
        if (this.f != null) {
            this.g = n;
        }
        else {
            super.setDropDownWidth(n);
        }
    }
    
    public void setPopupBackgroundDrawable(final Drawable popupBackgroundDrawable) {
        final i f = this.f;
        if (f != null) {
            f.b(popupBackgroundDrawable);
        }
        else {
            super.setPopupBackgroundDrawable(popupBackgroundDrawable);
        }
    }
    
    public void setPopupBackgroundResource(final int n) {
        this.setPopupBackgroundDrawable(e.a.b(this.getPopupContext(), n));
    }
    
    public void setPrompt(final CharSequence prompt) {
        final i f = this.f;
        if (f != null) {
            f.h(prompt);
        }
        else {
            super.setPrompt(prompt);
        }
    }
    
    public void setSupportBackgroundTintList(final ColorStateList list) {
        final androidx.appcompat.widget.d a = this.a;
        if (a != null) {
            a.i(list);
        }
    }
    
    public void setSupportBackgroundTintMode(final PorterDuff$Mode porterDuff$Mode) {
        final androidx.appcompat.widget.d a = this.a;
        if (a != null) {
            a.j(porterDuff$Mode);
        }
    }
    
    static class SavedState extends View$BaseSavedState
    {
        public static final Parcelable$Creator<SavedState> CREATOR;
        boolean a;
        
        static {
            CREATOR = (Parcelable$Creator)new Parcelable$Creator<SavedState>() {
                public SavedState a(final Parcel parcel) {
                    return new SavedState(parcel);
                }
                
                public SavedState[] b(final int n) {
                    return new SavedState[n];
                }
                
                public /* bridge */ Object createFromParcel(final Parcel parcel) {
                    return this.a(parcel);
                }
                
                public /* bridge */ Object[] newArray(final int n) {
                    return this.b(n);
                }
            };
        }
        
        SavedState(final Parcel parcel) {
            super(parcel);
            this.a = (parcel.readByte() != 0);
        }
        
        SavedState(final Parcelable parcelable) {
            super(parcelable);
        }
        
        public void writeToParcel(final Parcel parcel, final int n) {
            super.writeToParcel(parcel, n);
            parcel.writeByte((byte)(byte)(this.a ? 1 : 0));
        }
    }
    
    private static final class c
    {
        static void a(final ViewTreeObserver viewTreeObserver, final ViewTreeObserver$OnGlobalLayoutListener viewTreeObserver$OnGlobalLayoutListener) {
            viewTreeObserver.removeOnGlobalLayoutListener(viewTreeObserver$OnGlobalLayoutListener);
        }
    }
    
    private static final class d
    {
        static int a(final View view) {
            return view.getTextAlignment();
        }
        
        static int b(final View view) {
            return view.getTextDirection();
        }
        
        static void c(final View view, final int textAlignment) {
            view.setTextAlignment(textAlignment);
        }
        
        static void d(final View view, final int textDirection) {
            view.setTextDirection(textDirection);
        }
    }
    
    private static final class e
    {
        static void a(final ThemedSpinnerAdapter themedSpinnerAdapter, final Resources$Theme dropDownViewTheme) {
            if (themedSpinnerAdapter.getDropDownViewTheme() != dropDownViewTheme) {
                themedSpinnerAdapter.setDropDownViewTheme(dropDownViewTheme);
            }
        }
    }
    
    class f implements i, DialogInterface$OnClickListener
    {
        androidx.appcompat.app.c a;
        private ListAdapter b;
        private CharSequence c;
        final AppCompatSpinner d;
        
        f(final AppCompatSpinner d) {
            this.d = d;
        }
        
        @Override
        public boolean a() {
            final androidx.appcompat.app.c a = this.a;
            return a != null && a.isShowing();
        }
        
        @Override
        public void b(final Drawable drawable) {
            Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
        }
        
        @Override
        public int c() {
            return 0;
        }
        
        @Override
        public void dismiss() {
            final androidx.appcompat.app.c a = this.a;
            if (a != null) {
                a.dismiss();
                this.a = null;
            }
        }
        
        @Override
        public void e(final int n) {
            Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }
        
        @Override
        public CharSequence f() {
            return this.c;
        }
        
        @Override
        public Drawable g() {
            return null;
        }
        
        @Override
        public void h(final CharSequence c) {
            this.c = c;
        }
        
        @Override
        public void i(final int n) {
            Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }
        
        @Override
        public void j(final int n) {
            Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }
        
        @Override
        public void k(final int n, final int n2) {
            if (this.b == null) {
                return;
            }
            final androidx.appcompat.app.c.a a = new androidx.appcompat.app.c.a(this.d.getPopupContext());
            final CharSequence c = this.c;
            if (c != null) {
                a.setTitle(c);
            }
            final androidx.appcompat.app.c create = a.j(this.b, this.d.getSelectedItemPosition(), (DialogInterface$OnClickListener)this).create();
            this.a = create;
            final ListView i = create.i();
            AppCompatSpinner.d.d((View)i, n);
            AppCompatSpinner.d.c((View)i, n2);
            this.a.show();
        }
        
        @Override
        public int l() {
            return 0;
        }
        
        @Override
        public void m(final ListAdapter b) {
            this.b = b;
        }
        
        public void onClick(final DialogInterface dialogInterface, final int selection) {
            this.d.setSelection(selection);
            if (this.d.getOnItemClickListener() != null) {
                this.d.performItemClick((View)null, selection, this.b.getItemId(selection));
            }
            this.dismiss();
        }
    }
    
    interface i
    {
        boolean a();
        
        void b(final Drawable p0);
        
        int c();
        
        void dismiss();
        
        void e(final int p0);
        
        CharSequence f();
        
        Drawable g();
        
        void h(final CharSequence p0);
        
        void i(final int p0);
        
        void j(final int p0);
        
        void k(final int p0, final int p1);
        
        int l();
        
        void m(final ListAdapter p0);
    }
    
    private static class g implements ListAdapter, SpinnerAdapter
    {
        private SpinnerAdapter a;
        private ListAdapter b;
        
        public g(final SpinnerAdapter a, final Resources$Theme dropDownViewTheme) {
            this.a = a;
            if (a instanceof ListAdapter) {
                this.b = (ListAdapter)a;
            }
            if (dropDownViewTheme != null) {
                if (a instanceof ThemedSpinnerAdapter) {
                    e.a((ThemedSpinnerAdapter)a, dropDownViewTheme);
                }
                else if (a instanceof n0) {
                    final n0 n0 = (n0)a;
                    if (n0.getDropDownViewTheme() == null) {
                        n0.setDropDownViewTheme(dropDownViewTheme);
                    }
                }
            }
        }
        
        public boolean areAllItemsEnabled() {
            final ListAdapter b = this.b;
            return b == null || b.areAllItemsEnabled();
        }
        
        public int getCount() {
            final SpinnerAdapter a = this.a;
            int count;
            if (a == null) {
                count = 0;
            }
            else {
                count = a.getCount();
            }
            return count;
        }
        
        public View getDropDownView(final int n, View dropDownView, final ViewGroup viewGroup) {
            final SpinnerAdapter a = this.a;
            if (a == null) {
                dropDownView = null;
            }
            else {
                dropDownView = a.getDropDownView(n, dropDownView, viewGroup);
            }
            return dropDownView;
        }
        
        public Object getItem(final int n) {
            final SpinnerAdapter a = this.a;
            Object item;
            if (a == null) {
                item = null;
            }
            else {
                item = a.getItem(n);
            }
            return item;
        }
        
        public long getItemId(final int n) {
            final SpinnerAdapter a = this.a;
            long itemId;
            if (a == null) {
                itemId = -1L;
            }
            else {
                itemId = a.getItemId(n);
            }
            return itemId;
        }
        
        public int getItemViewType(final int n) {
            return 0;
        }
        
        public View getView(final int n, final View view, final ViewGroup viewGroup) {
            return this.getDropDownView(n, view, viewGroup);
        }
        
        public int getViewTypeCount() {
            return 1;
        }
        
        public boolean hasStableIds() {
            final SpinnerAdapter a = this.a;
            return a != null && a.hasStableIds();
        }
        
        public boolean isEmpty() {
            return this.getCount() == 0;
        }
        
        public boolean isEnabled(final int n) {
            final ListAdapter b = this.b;
            return b == null || b.isEnabled(n);
        }
        
        public void registerDataSetObserver(final DataSetObserver dataSetObserver) {
            final SpinnerAdapter a = this.a;
            if (a != null) {
                a.registerDataSetObserver(dataSetObserver);
            }
        }
        
        public void unregisterDataSetObserver(final DataSetObserver dataSetObserver) {
            final SpinnerAdapter a = this.a;
            if (a != null) {
                a.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }
    
    class h extends e0 implements AppCompatSpinner.i
    {
        private CharSequence T;
        ListAdapter U;
        private final Rect V;
        private int W;
        final AppCompatSpinner X;
        
        public h(final AppCompatSpinner x, final Context context, final AttributeSet set, final int n) {
            this.X = x;
            super(context, set, n);
            this.V = new Rect();
            this.C((View)x);
            this.I(true);
            this.N(0);
            this.K((AdapterView$OnItemClickListener)new AdapterView$OnItemClickListener(this, x) {
                final AppCompatSpinner a;
                final h b;
                
                public void onItemClick(final AdapterView<?> adapterView, final View view, final int selection, final long n) {
                    this.b.X.setSelection(selection);
                    if (this.b.X.getOnItemClickListener() != null) {
                        final h b = this.b;
                        b.X.performItemClick(view, selection, b.U.getItemId(selection));
                    }
                    this.b.dismiss();
                }
            });
        }
        
        static void Q(final h h) {
            h.show();
        }
        
        void R() {
            final Drawable g = this.g();
            int right = 0;
            if (g != null) {
                g.getPadding(this.X.h);
                if (w0.b((View)this.X)) {
                    right = this.X.h.right;
                }
                else {
                    right = -this.X.h.left;
                }
            }
            else {
                final Rect h = this.X.h;
                h.right = 0;
                h.left = 0;
            }
            final int paddingLeft = this.X.getPaddingLeft();
            final int paddingRight = this.X.getPaddingRight();
            final int width = this.X.getWidth();
            final AppCompatSpinner x = this.X;
            final int g2 = x.g;
            if (g2 == -2) {
                final int a = x.a((SpinnerAdapter)this.U, this.g());
                final int widthPixels = this.X.getContext().getResources().getDisplayMetrics().widthPixels;
                final Rect h2 = this.X.h;
                final int n = widthPixels - h2.left - h2.right;
                int n2;
                if ((n2 = a) > n) {
                    n2 = n;
                }
                this.E(Math.max(n2, width - paddingLeft - paddingRight));
            }
            else if (g2 == -1) {
                this.E(width - paddingLeft - paddingRight);
            }
            else {
                this.E(g2);
            }
            int n3;
            if (w0.b((View)this.X)) {
                n3 = right + (width - paddingRight - this.y() - this.S());
            }
            else {
                n3 = right + (paddingLeft + this.S());
            }
            this.e(n3);
        }
        
        public int S() {
            return this.W;
        }
        
        boolean T(final View view) {
            return b0.S(view) && view.getGlobalVisibleRect(this.V);
        }
        
        @Override
        public CharSequence f() {
            return this.T;
        }
        
        @Override
        public void h(final CharSequence t) {
            this.T = t;
        }
        
        @Override
        public void j(final int w) {
            this.W = w;
        }
        
        @Override
        public void k(final int n, final int n2) {
            final boolean a = this.a();
            this.R();
            this.H(2);
            super.show();
            final ListView o = this.o();
            o.setChoiceMode(1);
            AppCompatSpinner.d.d((View)o, n);
            AppCompatSpinner.d.c((View)o, n2);
            this.O(this.X.getSelectedItemPosition());
            if (a) {
                return;
            }
            final ViewTreeObserver viewTreeObserver = this.X.getViewTreeObserver();
            if (viewTreeObserver != null) {
                final ViewTreeObserver$OnGlobalLayoutListener viewTreeObserver$OnGlobalLayoutListener = (ViewTreeObserver$OnGlobalLayoutListener)new ViewTreeObserver$OnGlobalLayoutListener(this) {
                    final h a;
                    
                    public void onGlobalLayout() {
                        final h a = this.a;
                        if (!a.T((View)a.X)) {
                            this.a.dismiss();
                        }
                        else {
                            this.a.R();
                            h.Q(this.a);
                        }
                    }
                };
                viewTreeObserver.addOnGlobalLayoutListener((ViewTreeObserver$OnGlobalLayoutListener)viewTreeObserver$OnGlobalLayoutListener);
                this.J((PopupWindow$OnDismissListener)new PopupWindow$OnDismissListener(this, viewTreeObserver$OnGlobalLayoutListener) {
                    final ViewTreeObserver$OnGlobalLayoutListener a;
                    final h b;
                    
                    public void onDismiss() {
                        final ViewTreeObserver viewTreeObserver = this.b.X.getViewTreeObserver();
                        if (viewTreeObserver != null) {
                            viewTreeObserver.removeGlobalOnLayoutListener(this.a);
                        }
                    }
                });
            }
        }
        
        @Override
        public void m(final ListAdapter u) {
            super.m(u);
            this.U = u;
        }
    }
}
