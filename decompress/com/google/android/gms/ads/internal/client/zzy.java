// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import android.content.res.TypedArray;
import android.text.TextUtils;
import com.google.android.gms.ads.R;
import android.util.AttributeSet;
import android.content.Context;
import com.google.android.gms.ads.AdSize;

public final class zzy
{
    private final AdSize[] a;
    private final String b;
    
    public zzy(final Context context, final AttributeSet set) {
        final TypedArray obtainAttributes = context.getResources().obtainAttributes(set, R.styleable.a);
        final String string = obtainAttributes.getString(R.styleable.b);
        final String string2 = obtainAttributes.getString(R.styleable.c);
        final boolean b = TextUtils.isEmpty((CharSequence)string) ^ true;
        final boolean b2 = TextUtils.isEmpty((CharSequence)string2) ^ true;
        if (b && !b2) {
            this.a = c(string);
        }
        else if (!b && b2) {
            this.a = c(string2);
        }
        else {
            if (b) {
                obtainAttributes.recycle();
                throw new IllegalArgumentException("Either XML attribute \"adSize\" or XML attribute \"supportedAdSizes\" should be specified, but not both.");
            }
            obtainAttributes.recycle();
            throw new IllegalArgumentException("Required XML attribute \"adSize\" was missing.");
        }
        final String string3 = obtainAttributes.getString(R.styleable.d);
        this.b = string3;
        obtainAttributes.recycle();
        if (!TextUtils.isEmpty((CharSequence)string3)) {
            return;
        }
        throw new IllegalArgumentException("Required XML attribute \"adUnitId\" was missing.");
    }
    
    private static AdSize[] c(final String s) {
        final String[] split = s.split("\\s*,\\s*");
        final int length = split.length;
        final AdSize[] array = new AdSize[length];
        for (int i = 0; i < split.length; ++i) {
            final String trim = split[i].trim();
            if (trim.matches("^(\\d+|FULL_WIDTH)\\s*[xX]\\s*(\\d+|AUTO_HEIGHT)$")) {
                final String[] split2 = trim.split("[xX]");
                split2[0] = split2[0].trim();
                split2[1] = split2[1].trim();
                try {
                    int int1;
                    if ("FULL_WIDTH".equals(split2[0])) {
                        int1 = -1;
                    }
                    else {
                        int1 = Integer.parseInt(split2[0]);
                    }
                    int int2;
                    if ("AUTO_HEIGHT".equals(split2[1])) {
                        int2 = -2;
                    }
                    else {
                        int2 = Integer.parseInt(split2[1]);
                    }
                    array[i] = new AdSize(int1, int2);
                    continue;
                }
                catch (final NumberFormatException ex) {
                    throw new IllegalArgumentException("Could not parse XML attribute \"adSize\": ".concat(trim));
                }
            }
            if ("BANNER".equals(trim)) {
                array[i] = AdSize.i;
            }
            else if ("LARGE_BANNER".equals(trim)) {
                array[i] = AdSize.k;
            }
            else if ("FULL_BANNER".equals(trim)) {
                array[i] = AdSize.j;
            }
            else if ("LEADERBOARD".equals(trim)) {
                array[i] = AdSize.l;
            }
            else if ("MEDIUM_RECTANGLE".equals(trim)) {
                array[i] = AdSize.m;
            }
            else if ("SMART_BANNER".equals(trim)) {
                array[i] = AdSize.o;
            }
            else if ("WIDE_SKYSCRAPER".equals(trim)) {
                array[i] = AdSize.n;
            }
            else if ("FLUID".equals(trim)) {
                array[i] = AdSize.p;
            }
            else {
                if (!"ICON".equals(trim)) {
                    throw new IllegalArgumentException("Could not parse XML attribute \"adSize\": ".concat(trim));
                }
                array[i] = AdSize.s;
            }
        }
        if (length != 0) {
            return array;
        }
        throw new IllegalArgumentException("Could not parse XML attribute \"adSize\": ".concat(s));
    }
    
    public final String a() {
        return this.b;
    }
    
    public final AdSize[] b(final boolean b) {
        if (!b && this.a.length != 1) {
            throw new IllegalArgumentException("The adSizes XML attribute is only allowed on PublisherAdViews.");
        }
        return this.a;
    }
}
