// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.widget;

import android.view.ActionMode;
import android.view.MenuItem;
import java.lang.reflect.InvocationTargetException;
import android.view.Menu;
import android.text.Editable;
import java.util.Iterator;
import android.app.Activity;
import java.util.ArrayList;
import java.util.List;
import android.content.pm.PackageManager;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.content.Intent;
import java.lang.reflect.Method;
import android.text.PrecomputedText$Params;
import android.icu.text.DecimalFormatSymbols;
import java.util.Locale;
import android.view.ActionMode$Callback;
import android.graphics.Paint$FontMetricsInt;
import android.graphics.PorterDuff$Mode;
import androidx.core.util.h;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.text.TextPaint;
import androidx.core.text.b;
import android.view.View;
import android.os.Build$VERSION;
import android.text.method.PasswordTransformationMethod;
import android.text.TextDirectionHeuristics;
import android.text.TextDirectionHeuristic;
import android.graphics.drawable.Drawable;
import android.widget.TextView;

public final class n
{
    public static Drawable[] a(final TextView textView) {
        return b.a(textView);
    }
    
    public static int b(final TextView textView) {
        return textView.getPaddingTop() - textView.getPaint().getFontMetricsInt().top;
    }
    
    public static int c(final TextView textView) {
        return textView.getPaddingBottom() + textView.getPaint().getFontMetricsInt().bottom;
    }
    
    public static int d(final TextView textView) {
        return a.b(textView);
    }
    
    private static int e(final TextDirectionHeuristic textDirectionHeuristic) {
        if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL) {
            return 1;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            return 1;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.ANYRTL_LTR) {
            return 2;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LTR) {
            return 3;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.RTL) {
            return 4;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LOCALE) {
            return 5;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            return 6;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL) {
            return 7;
        }
        return 1;
    }
    
    private static TextDirectionHeuristic f(final TextView textView) {
        if (textView.getTransformationMethod() instanceof PasswordTransformationMethod) {
            return TextDirectionHeuristics.LTR;
        }
        final int sdk_INT = Build$VERSION.SDK_INT;
        boolean b = false;
        if (sdk_INT >= 28 && (textView.getInputType() & 0xF) == 0x3) {
            final byte directionality = Character.getDirectionality(f.a(d.a(n.b.d(textView)))[0].codePointAt(0));
            if (directionality != 1 && directionality != 2) {
                return TextDirectionHeuristics.LTR;
            }
            return TextDirectionHeuristics.RTL;
        }
        else {
            if (n.b.b((View)textView) == 1) {
                b = true;
            }
            switch (n.b.c((View)textView)) {
                default: {
                    TextDirectionHeuristic textDirectionHeuristic;
                    if (b) {
                        textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_RTL;
                    }
                    else {
                        textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                    }
                    return textDirectionHeuristic;
                }
                case 7: {
                    return TextDirectionHeuristics.FIRSTSTRONG_RTL;
                }
                case 6: {
                    return TextDirectionHeuristics.FIRSTSTRONG_LTR;
                }
                case 5: {
                    return TextDirectionHeuristics.LOCALE;
                }
                case 4: {
                    return TextDirectionHeuristics.RTL;
                }
                case 3: {
                    return TextDirectionHeuristics.LTR;
                }
                case 2: {
                    return TextDirectionHeuristics.ANYRTL_LTR;
                }
            }
        }
    }
    
    public static androidx.core.text.b.a g(final TextView textView) {
        if (Build$VERSION.SDK_INT >= 28) {
            return new androidx.core.text.b.a(f.b(textView));
        }
        final androidx.core.text.b.a.a a = new androidx.core.text.b.a.a(new TextPaint((Paint)textView.getPaint()));
        a.b(c.a(textView));
        a.c(c.d(textView));
        a.d(f(textView));
        return a.a();
    }
    
    public static void h(final TextView textView, final int n, final int n2, final int n3, final int n4) throws IllegalArgumentException {
        if (Build$VERSION.SDK_INT >= 27) {
            e.f(textView, n, n2, n3, n4);
        }
        else if (textView instanceof androidx.core.widget.b) {
            ((androidx.core.widget.b)textView).setAutoSizeTextTypeUniformWithConfiguration(n, n2, n3, n4);
        }
    }
    
    public static void i(final TextView textView, final ColorStateList list) {
        h.g(textView);
        c.f(textView, list);
    }
    
    public static void j(final TextView textView, final PorterDuff$Mode porterDuff$Mode) {
        h.g(textView);
        c.g(textView, porterDuff$Mode);
    }
    
    public static void k(final TextView textView, final Drawable drawable, final Drawable drawable2, final Drawable drawable3, final Drawable drawable4) {
        b.e(textView, drawable, drawable2, drawable3, drawable4);
    }
    
    public static void l(final TextView textView, final Drawable drawable, final Drawable drawable2, final Drawable drawable3, final Drawable drawable4) {
        b.g(textView, drawable, drawable2, drawable3, drawable4);
    }
    
    public static void m(final TextView textView, final int n) {
        h.d(n);
        if (Build$VERSION.SDK_INT >= 28) {
            f.c(textView, n);
            return;
        }
        final Paint$FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int n2;
        if (a.a(textView)) {
            n2 = fontMetricsInt.top;
        }
        else {
            n2 = fontMetricsInt.ascent;
        }
        if (n > Math.abs(n2)) {
            textView.setPadding(textView.getPaddingLeft(), n + n2, textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }
    
    public static void n(final TextView textView, final int n) {
        h.d(n);
        final Paint$FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int n2;
        if (a.a(textView)) {
            n2 = fontMetricsInt.bottom;
        }
        else {
            n2 = fontMetricsInt.descent;
        }
        if (n > Math.abs(n2)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), n - n2);
        }
    }
    
    public static void o(final TextView textView, final int n) {
        h.d(n);
        final int fontMetricsInt = textView.getPaint().getFontMetricsInt((Paint$FontMetricsInt)null);
        if (n != fontMetricsInt) {
            textView.setLineSpacing((float)(n - fontMetricsInt), 1.0f);
        }
    }
    
    public static void p(final TextView textView, final androidx.core.text.b text) {
        if (Build$VERSION.SDK_INT >= 29) {
            textView.setText((CharSequence)text.b());
        }
        else {
            if (!g(textView).a(text.a())) {
                throw new IllegalArgumentException("Given text can not be applied to TextView.");
            }
            textView.setText((CharSequence)text);
        }
    }
    
    public static void q(final TextView textView, final int textAppearance) {
        textView.setTextAppearance(textAppearance);
    }
    
    public static void r(final TextView textView, final androidx.core.text.b.a a) {
        b.h((View)textView, e(a.d()));
        textView.getPaint().set(a.e());
        c.e(textView, a.b());
        c.h(textView, a.c());
    }
    
    public static ActionMode$Callback s(final ActionMode$Callback actionMode$Callback) {
        ActionMode$Callback d = actionMode$Callback;
        if (actionMode$Callback instanceof g) {
            d = ((g)actionMode$Callback).d();
        }
        return d;
    }
    
    public static ActionMode$Callback t(final TextView textView, final ActionMode$Callback actionMode$Callback) {
        if (Build$VERSION.SDK_INT <= 27 && !(actionMode$Callback instanceof g) && actionMode$Callback != null) {
            return (ActionMode$Callback)new g(actionMode$Callback, textView);
        }
        return actionMode$Callback;
    }
    
    static class a
    {
        static boolean a(final TextView textView) {
            return textView.getIncludeFontPadding();
        }
        
        static int b(final TextView textView) {
            return textView.getMaxLines();
        }
        
        static int c(final TextView textView) {
            return textView.getMinLines();
        }
    }
    
    static class b
    {
        static Drawable[] a(final TextView textView) {
            return textView.getCompoundDrawablesRelative();
        }
        
        static int b(final View view) {
            return view.getLayoutDirection();
        }
        
        static int c(final View view) {
            return view.getTextDirection();
        }
        
        static Locale d(final TextView textView) {
            return textView.getTextLocale();
        }
        
        static void e(final TextView textView, final Drawable drawable, final Drawable drawable2, final Drawable drawable3, final Drawable drawable4) {
            textView.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        }
        
        static void f(final TextView textView, final int n, final int n2, final int n3, final int n4) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(n, n2, n3, n4);
        }
        
        static void g(final TextView textView, final Drawable drawable, final Drawable drawable2, final Drawable drawable3, final Drawable drawable4) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }
        
        static void h(final View view, final int textDirection) {
            view.setTextDirection(textDirection);
        }
    }
    
    static class c
    {
        static int a(final TextView textView) {
            return textView.getBreakStrategy();
        }
        
        static ColorStateList b(final TextView textView) {
            return textView.getCompoundDrawableTintList();
        }
        
        static PorterDuff$Mode c(final TextView textView) {
            return textView.getCompoundDrawableTintMode();
        }
        
        static int d(final TextView textView) {
            return textView.getHyphenationFrequency();
        }
        
        static void e(final TextView textView, final int breakStrategy) {
            textView.setBreakStrategy(breakStrategy);
        }
        
        static void f(final TextView textView, final ColorStateList compoundDrawableTintList) {
            textView.setCompoundDrawableTintList(compoundDrawableTintList);
        }
        
        static void g(final TextView textView, final PorterDuff$Mode compoundDrawableTintMode) {
            textView.setCompoundDrawableTintMode(compoundDrawableTintMode);
        }
        
        static void h(final TextView textView, final int hyphenationFrequency) {
            textView.setHyphenationFrequency(hyphenationFrequency);
        }
    }
    
    static class d
    {
        static DecimalFormatSymbols a(final Locale locale) {
            return DecimalFormatSymbols.getInstance(locale);
        }
    }
    
    static class e
    {
        static int a(final TextView textView) {
            return textView.getAutoSizeMaxTextSize();
        }
        
        static int b(final TextView textView) {
            return textView.getAutoSizeMinTextSize();
        }
        
        static int c(final TextView textView) {
            return textView.getAutoSizeStepGranularity();
        }
        
        static int[] d(final TextView textView) {
            return textView.getAutoSizeTextAvailableSizes();
        }
        
        static int e(final TextView textView) {
            return textView.getAutoSizeTextType();
        }
        
        static void f(final TextView textView, final int n, final int n2, final int n3, final int n4) {
            textView.setAutoSizeTextTypeUniformWithConfiguration(n, n2, n3, n4);
        }
        
        static void g(final TextView textView, final int[] array, final int n) {
            textView.setAutoSizeTextTypeUniformWithPresetSizes(array, n);
        }
        
        static void h(final TextView textView, final int autoSizeTextTypeWithDefaults) {
            textView.setAutoSizeTextTypeWithDefaults(autoSizeTextTypeWithDefaults);
        }
    }
    
    static class f
    {
        static String[] a(final DecimalFormatSymbols decimalFormatSymbols) {
            return decimalFormatSymbols.getDigitStrings();
        }
        
        static PrecomputedText$Params b(final TextView textView) {
            return textView.getTextMetricsParams();
        }
        
        static void c(final TextView textView, final int firstBaselineToTopHeight) {
            textView.setFirstBaselineToTopHeight(firstBaselineToTopHeight);
        }
    }
    
    private static class g implements ActionMode$Callback
    {
        private final ActionMode$Callback a;
        private final TextView b;
        private Class<?> c;
        private Method d;
        private boolean e;
        private boolean f;
        
        g(final ActionMode$Callback a, final TextView b) {
            this.a = a;
            this.b = b;
            this.f = false;
        }
        
        private Intent a() {
            return new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
        }
        
        private Intent b(final ResolveInfo resolveInfo, final TextView textView) {
            final Intent putExtra = this.a().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", this.e(textView) ^ true);
            final ActivityInfo activityInfo = resolveInfo.activityInfo;
            return putExtra.setClassName(activityInfo.packageName, activityInfo.name);
        }
        
        private List<ResolveInfo> c(final Context context, final PackageManager packageManager) {
            final ArrayList list = new ArrayList();
            if (!(context instanceof Activity)) {
                return list;
            }
            for (final ResolveInfo resolveInfo : packageManager.queryIntentActivities(this.a(), 0)) {
                if (this.f(resolveInfo, context)) {
                    list.add(resolveInfo);
                }
            }
            return list;
        }
        
        private boolean e(final TextView textView) {
            return textView instanceof Editable && textView.onCheckIsTextEditor() && textView.isEnabled();
        }
        
        private boolean f(final ResolveInfo resolveInfo, final Context context) {
            final boolean equals = context.getPackageName().equals(resolveInfo.activityInfo.packageName);
            final boolean b = true;
            if (equals) {
                return true;
            }
            final ActivityInfo activityInfo = resolveInfo.activityInfo;
            if (!activityInfo.exported) {
                return false;
            }
            final String permission = activityInfo.permission;
            boolean b2 = b;
            if (permission != null) {
                b2 = (context.checkSelfPermission(permission) == 0 && b);
            }
            return b2;
        }
        
        private void g(final Menu menu) {
            final Context context = this.b.getContext();
            final PackageManager packageManager = context.getPackageManager();
            if (!this.f) {
                this.f = true;
                try {
                    final Class<?> forName = Class.forName("com.android.internal.view.menu.MenuBuilder");
                    this.c = forName;
                    this.d = forName.getDeclaredMethod("removeItemAt", Integer.TYPE);
                    this.e = true;
                }
                catch (final ClassNotFoundException | NoSuchMethodException ex) {
                    this.c = null;
                    this.d = null;
                    this.e = false;
                }
            }
            try {
                Method method;
                if (this.e && this.c.isInstance(menu)) {
                    method = this.d;
                }
                else {
                    method = menu.getClass().getDeclaredMethod("removeItemAt", Integer.TYPE);
                }
                for (int i = menu.size() - 1; i >= 0; --i) {
                    final MenuItem item = menu.getItem(i);
                    if (item.getIntent() != null && "android.intent.action.PROCESS_TEXT".equals(item.getIntent().getAction())) {
                        method.invoke(menu, i);
                    }
                }
                final List<ResolveInfo> c = this.c(context, packageManager);
                for (int j = 0; j < c.size(); ++j) {
                    final ResolveInfo resolveInfo = c.get(j);
                    menu.add(0, 0, j + 100, resolveInfo.loadLabel(packageManager)).setIntent(this.b(resolveInfo, this.b)).setShowAsAction(1);
                }
            }
            catch (final NoSuchMethodException | IllegalAccessException | InvocationTargetException ex2) {}
        }
        
        ActionMode$Callback d() {
            return this.a;
        }
        
        public boolean onActionItemClicked(final ActionMode actionMode, final MenuItem menuItem) {
            return this.a.onActionItemClicked(actionMode, menuItem);
        }
        
        public boolean onCreateActionMode(final ActionMode actionMode, final Menu menu) {
            return this.a.onCreateActionMode(actionMode, menu);
        }
        
        public void onDestroyActionMode(final ActionMode actionMode) {
            this.a.onDestroyActionMode(actionMode);
        }
        
        public boolean onPrepareActionMode(final ActionMode actionMode, final Menu menu) {
            this.g(menu);
            return this.a.onPrepareActionMode(actionMode, menu);
        }
    }
}
