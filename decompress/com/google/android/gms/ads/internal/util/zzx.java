// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.util;

import android.view.View$OnApplyWindowInsetsListener;
import com.google.android.gms.internal.ads.zzbhy;
import com.google.android.gms.ads.internal.client.zzay;
import android.view.WindowManager$LayoutParams;
import android.view.Window;
import java.util.Iterator;
import android.view.DisplayCutout;
import android.text.TextUtils;
import java.util.Locale;
import android.graphics.Rect;
import com.google.android.gms.ads.internal.zzt;
import android.view.WindowInsets;
import android.view.View;
import android.app.Activity;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class zzx extends zzv
{
    static final WindowInsets l(final Activity activity, final View view, final WindowInsets windowInsets) {
        if (com.google.android.gms.ads.internal.zzt.p().zzh().zzm() == null) {
            final DisplayCutout displayCutout = windowInsets.getDisplayCutout();
            String concat = "";
            if (displayCutout != null) {
                final zzg zzh = com.google.android.gms.ads.internal.zzt.p().zzh();
                for (final Rect rect : displayCutout.getBoundingRects()) {
                    final String format = String.format(Locale.US, "%d,%d,%d,%d", rect.left, rect.top, rect.right, rect.bottom);
                    String concat2 = concat;
                    if (!TextUtils.isEmpty((CharSequence)concat)) {
                        concat2 = concat.concat("|");
                    }
                    concat = concat2.concat(String.valueOf(format));
                }
                zzh.l(concat);
            }
            else {
                com.google.android.gms.ads.internal.zzt.p().zzh().l("");
            }
        }
        m(false, activity);
        return view.onApplyWindowInsets(windowInsets);
    }
    
    private static final void m(final boolean b, final Activity activity) {
        final Window window = activity.getWindow();
        final WindowManager$LayoutParams attributes = window.getAttributes();
        final int layoutInDisplayCutoutMode = attributes.layoutInDisplayCutoutMode;
        int layoutInDisplayCutoutMode2 = 1;
        if (!b) {
            layoutInDisplayCutoutMode2 = 2;
        }
        if (layoutInDisplayCutoutMode2 != layoutInDisplayCutoutMode) {
            attributes.layoutInDisplayCutoutMode = layoutInDisplayCutoutMode2;
            window.setAttributes(attributes);
        }
    }
    
    @Override
    public final void h(final Activity activity) {
        if ((boolean)zzay.c().zzb(zzbhy.zzaZ) && com.google.android.gms.ads.internal.zzt.p().zzh().zzm() == null && !activity.isInMultiWindowMode()) {
            m(true, activity);
            activity.getWindow().getDecorView().setOnApplyWindowInsetsListener((View$OnApplyWindowInsetsListener)new zzw(this, activity));
        }
    }
}
