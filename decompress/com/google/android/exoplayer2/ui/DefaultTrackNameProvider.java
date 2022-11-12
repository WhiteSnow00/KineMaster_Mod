// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.ui;

import com.google.android.exoplayer2.util.MimeTypes;
import java.util.Locale;
import com.google.android.exoplayer2.util.Util;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.Assertions;
import android.content.res.Resources;

public class DefaultTrackNameProvider implements TrackNameProvider
{
    private final Resources a;
    
    public DefaultTrackNameProvider(final Resources resources) {
        this.a = Assertions.e(resources);
    }
    
    private String b(final Format format) {
        final int j = format.J;
        if (j == -1 || j < 1) {
            return "";
        }
        if (j == 1) {
            return this.a.getString(R.string.q);
        }
        if (j == 2) {
            return this.a.getString(R.string.z);
        }
        if (j == 6 || j == 7) {
            return this.a.getString(R.string.B);
        }
        if (j != 8) {
            return this.a.getString(R.string.A);
        }
        return this.a.getString(R.string.C);
    }
    
    private String c(final Format format) {
        final int h = format.h;
        String string;
        if (h == -1) {
            string = "";
        }
        else {
            string = this.a.getString(R.string.p, new Object[] { h / 1000000.0f });
        }
        return string;
    }
    
    private String d(final Format format) {
        String b;
        if (TextUtils.isEmpty((CharSequence)format.b)) {
            b = "";
        }
        else {
            b = format.b;
        }
        return b;
    }
    
    private String e(final Format format) {
        String s;
        if (TextUtils.isEmpty((CharSequence)(s = this.j(this.f(format), this.h(format))))) {
            s = this.d(format);
        }
        return s;
    }
    
    private String f(Format format) {
        format = (Format)format.c;
        if (TextUtils.isEmpty((CharSequence)format) || "und".equals(format)) {
            return "";
        }
        Locale forLanguageTag;
        if (Util.a >= 21) {
            forLanguageTag = Locale.forLanguageTag((String)format);
        }
        else {
            forLanguageTag = new Locale((String)format);
        }
        final Locale r = Util.R();
        format = (Format)forLanguageTag.getDisplayName(r);
        if (TextUtils.isEmpty((CharSequence)format)) {
            return "";
        }
        try {
            final int offsetByCodePoints = ((String)format).offsetByCodePoints(0, 1);
            final StringBuilder sb = new StringBuilder();
            sb.append(((String)format).substring(0, offsetByCodePoints).toUpperCase(r));
            sb.append(((String)format).substring(offsetByCodePoints));
            format = (Format)sb.toString();
            return (String)format;
        }
        catch (final IndexOutOfBoundsException ex) {
            return (String)format;
        }
    }
    
    private String g(final Format format) {
        final int b = format.B;
        final int c = format.C;
        String string;
        if (b != -1 && c != -1) {
            string = this.a.getString(R.string.r, new Object[] { b, c });
        }
        else {
            string = "";
        }
        return string;
    }
    
    private String h(final Format format) {
        String string;
        if ((format.e & 0x2) != 0x0) {
            string = this.a.getString(R.string.s);
        }
        else {
            string = "";
        }
        String j = string;
        if ((format.e & 0x4) != 0x0) {
            j = this.j(string, this.a.getString(R.string.v));
        }
        String i = j;
        if ((format.e & 0x8) != 0x0) {
            i = this.j(j, this.a.getString(R.string.u));
        }
        String k = i;
        if ((format.e & 0x440) != 0x0) {
            k = this.j(i, this.a.getString(R.string.t));
        }
        return k;
    }
    
    private static int i(final Format format) {
        final int k = MimeTypes.k(format.w);
        if (k != -1) {
            return k;
        }
        if (MimeTypes.n(format.i) != null) {
            return 2;
        }
        if (MimeTypes.c(format.i) != null) {
            return 1;
        }
        if (format.B != -1 || format.C != -1) {
            return 2;
        }
        if (format.J == -1 && format.K == -1) {
            return -1;
        }
        return 1;
    }
    
    private String j(final String... array) {
        final int length = array.length;
        String s = "";
        String string;
        for (int i = 0; i < length; ++i, s = string) {
            final String s2 = array[i];
            string = s;
            if (s2.length() > 0) {
                if (TextUtils.isEmpty((CharSequence)s)) {
                    string = s2;
                }
                else {
                    string = this.a.getString(R.string.o, new Object[] { s, s2 });
                }
            }
        }
        return s;
    }
    
    @Override
    public String a(final Format format) {
        final int i = i(format);
        String s;
        if (i == 2) {
            s = this.j(this.h(format), this.g(format), this.c(format));
        }
        else if (i == 1) {
            s = this.j(this.e(format), this.b(format), this.c(format));
        }
        else {
            s = this.e(format);
        }
        String string = s;
        if (s.length() == 0) {
            string = this.a.getString(R.string.D);
        }
        return string;
    }
}
