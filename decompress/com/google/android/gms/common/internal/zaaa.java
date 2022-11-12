// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import android.graphics.drawable.Drawable;
import com.google.android.gms.common.util.DeviceProperties;
import android.text.method.TransformationMethod;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff$Mode;
import androidx.core.graphics.drawable.a;
import com.google.android.gms.base.R;
import android.graphics.Typeface;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.content.Context;
import android.widget.Button;

public final class zaaa extends Button
{
    public zaaa(final Context context, final AttributeSet set) {
        super(context, (AttributeSet)null, 16842824);
    }
    
    private static final int b(final int n, final int n2, final int n3, final int n4) {
        if (n == 0) {
            return n2;
        }
        if (n == 1) {
            return n3;
        }
        if (n == 2) {
            return n4;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Unknown color scheme: ");
        sb.append(n);
        throw new IllegalStateException(sb.toString());
    }
    
    public final void a(final Resources resources, final int n, final int n2) {
        this.setTypeface(Typeface.DEFAULT_BOLD);
        this.setTextSize(14.0f);
        final int n3 = (int)(resources.getDisplayMetrics().density * 48.0f + 0.5f);
        this.setMinHeight(n3);
        this.setMinWidth(n3);
        final int b = R.drawable.b;
        final int c = R.drawable.c;
        int b2 = b(n2, b, c, c);
        final int d = R.drawable.d;
        final int e = R.drawable.e;
        final int b3 = b(n2, d, e, e);
        if (n != 0 && n != 1) {
            if (n != 2) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Unknown button size: ");
                sb.append(n);
                throw new IllegalStateException(sb.toString());
            }
        }
        else {
            b2 = b3;
        }
        final Drawable l = a.l(resources.getDrawable(b2));
        a.i(l, resources.getColorStateList(R.color.c));
        a.j(l, PorterDuff$Mode.SRC_ATOP);
        this.setBackgroundDrawable(l);
        final int a = R.color.a;
        final int b4 = R.color.b;
        this.setTextColor((ColorStateList)Preconditions.k(resources.getColorStateList(b(n2, a, b4, b4))));
        if (n != 0) {
            if (n != 1) {
                if (n != 2) {
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("Unknown button size: ");
                    sb2.append(n);
                    throw new IllegalStateException(sb2.toString());
                }
                this.setText((CharSequence)null);
            }
            else {
                this.setText((CharSequence)resources.getString(R.string.q));
            }
        }
        else {
            this.setText((CharSequence)resources.getString(R.string.p));
        }
        this.setTransformationMethod((TransformationMethod)null);
        if (DeviceProperties.e(this.getContext())) {
            this.setGravity(19);
        }
    }
}
