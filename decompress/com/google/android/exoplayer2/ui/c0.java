// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.ui;

import java.util.ArrayList;
import java.util.Iterator;
import android.util.Base64;
import com.google.common.base.Charsets;
import com.google.android.exoplayer2.util.Assertions;
import java.util.HashMap;
import com.google.android.exoplayer2.util.Util;
import android.text.Layout$Alignment;
import android.view.View;
import android.view.MotionEvent;
import java.util.Collections;
import android.util.AttributeSet;
import android.content.Context;
import com.google.android.exoplayer2.text.Cue;
import java.util.List;
import android.webkit.WebView;
import android.widget.FrameLayout;

final class c0 extends FrameLayout implements a
{
    private final com.google.android.exoplayer2.ui.a a;
    private final WebView b;
    private List<Cue> c;
    private CaptionStyleCompat d;
    private float e;
    private int f;
    private float g;
    
    public c0(final Context context) {
        this(context, null);
    }
    
    public c0(final Context context, final AttributeSet set) {
        super(context, set);
        this.c = Collections.emptyList();
        this.d = CaptionStyleCompat.g;
        this.e = 0.0533f;
        this.f = 0;
        this.g = 0.08f;
        final com.google.android.exoplayer2.ui.a a = new com.google.android.exoplayer2.ui.a(context, set);
        this.a = a;
        final WebView b = new WebView(this, context, set) {
            public boolean onTouchEvent(final MotionEvent motionEvent) {
                super.onTouchEvent(motionEvent);
                return false;
            }
            
            public boolean performClick() {
                super.performClick();
                return false;
            }
        };
        (this.b = b).setBackgroundColor(0);
        this.addView((View)a);
        this.addView((View)b);
    }
    
    private static int b(final int n) {
        if (n == 1) {
            return -50;
        }
        if (n != 2) {
            return 0;
        }
        return -100;
    }
    
    private static String c(final Layout$Alignment layout$Alignment) {
        if (layout$Alignment == null) {
            return "center";
        }
        final int n = c0$b.a[layout$Alignment.ordinal()];
        if (n == 1) {
            return "start";
        }
        if (n != 2) {
            return "center";
        }
        return "end";
    }
    
    private static String d(final CaptionStyleCompat captionStyleCompat) {
        final int d = captionStyleCompat.d;
        if (d == 1) {
            return Util.C("1px 1px 0 %1$s, 1px -1px 0 %1$s, -1px 1px 0 %1$s, -1px -1px 0 %1$s", b.b(captionStyleCompat.e));
        }
        if (d == 2) {
            return Util.C("0.1em 0.12em 0.15em %s", b.b(captionStyleCompat.e));
        }
        if (d == 3) {
            return Util.C("0.06em 0.08em 0.15em %s", b.b(captionStyleCompat.e));
        }
        if (d != 4) {
            return "unset";
        }
        return Util.C("-0.05em -0.05em 0.15em %s", b.b(captionStyleCompat.e));
    }
    
    private String e(final int n, float h) {
        h = b0.h(n, h, this.getHeight(), this.getHeight() - this.getPaddingTop() - this.getPaddingBottom());
        if (h == -3.4028235E38f) {
            return "unset";
        }
        return Util.C("%.2fpx", h / this.getContext().getResources().getDisplayMetrics().density);
    }
    
    private static String f(final int n) {
        if (n == 1) {
            return "vertical-rl";
        }
        if (n != 2) {
            return "horizontal-tb";
        }
        return "vertical-lr";
    }
    
    private static String h(final Cue cue) {
        final float b = cue.B;
        if (b != 0.0f) {
            final int a = cue.A;
            String s;
            if (a != 2 && a != 1) {
                s = "skewX";
            }
            else {
                s = "skewY";
            }
            return Util.C("%s(%.2fdeg)", s, b);
        }
        return "";
    }
    
    private void i() {
        final StringBuilder sb = new StringBuilder();
        sb.append(Util.C("<body><div style='-webkit-user-select:none;position:fixed;top:0;bottom:0;left:0;right:0;color:%s;font-size:%s;line-height:%.2f;text-shadow:%s;'>", com.google.android.exoplayer2.ui.b.b(this.d.a), this.e(this.f, this.e), 1.2f, d(this.d)));
        final HashMap hashMap = new HashMap();
        hashMap.put(com.google.android.exoplayer2.ui.b.a("default_bg"), Util.C("background-color:%s;", com.google.android.exoplayer2.ui.b.b(this.d.b)));
        for (int i = 0; i < this.c.size(); ++i) {
            final Cue cue = this.c.get(i);
            final float h = cue.h;
            float n;
            if (h != -3.4028235E38f) {
                n = h * 100.0f;
            }
            else {
                n = 50.0f;
            }
            int b = b(cue.i);
            final float e = cue.e;
            String s = null;
            int b2 = 0;
            boolean b3 = false;
            Label_0357: {
                if (e != -3.4028235E38f) {
                    if (cue.f != 1) {
                        s = Util.C("%.2f%%", e * 100.0f);
                        if (cue.A == 1) {
                            b2 = -b(cue.g);
                        }
                        else {
                            b2 = b(cue.g);
                        }
                    }
                    else {
                        if (e >= 0.0f) {
                            s = Util.C("%.2fem", e * 1.2f);
                            b2 = 0;
                            b3 = false;
                            break Label_0357;
                        }
                        s = Util.C("%.2fem", (-e - 1.0f) * 1.2f);
                        b2 = 0;
                        b3 = true;
                        break Label_0357;
                    }
                }
                else {
                    s = Util.C("%.2f%%", (1.0f - this.g) * 100.0f);
                    b2 = -100;
                }
                b3 = false;
            }
            final float j = cue.j;
            String c;
            if (j != -3.4028235E38f) {
                c = Util.C("%.2f%%", j * 100.0f);
            }
            else {
                c = "fit-content";
            }
            final String c2 = c(cue.b);
            final String f = f(cue.A);
            final String e2 = this.e(cue.y, cue.z);
            int n2;
            if (cue.w) {
                n2 = cue.x;
            }
            else {
                n2 = this.d.c;
            }
            final String b4 = com.google.android.exoplayer2.ui.b.b(n2);
            final int a = cue.A;
            String s2 = "right";
            String s3 = "left";
            final String s4 = "top";
            Label_0542: {
                Label_0537: {
                    if (a != 1) {
                        if (a != 2) {
                            s2 = s4;
                            if (b3) {
                                s2 = "bottom";
                            }
                            break Label_0542;
                        }
                        if (b3) {
                            break Label_0537;
                        }
                    }
                    else if (!b3) {
                        break Label_0537;
                    }
                    s2 = "left";
                }
                s3 = "top";
            }
            String s5;
            int n3;
            if (a != 2 && a != 1) {
                s5 = "width";
                n3 = b2;
            }
            else {
                s5 = "height";
                n3 = b;
                b = b2;
            }
            final SpannedToHtmlConverter.HtmlAndCss a2 = SpannedToHtmlConverter.a(cue.a, this.getContext().getResources().getDisplayMetrics().density);
            for (final String s6 : hashMap.keySet()) {
                final String s7 = (String)hashMap.put(s6, hashMap.get(s6));
                Assertions.g(s7 == null || s7.equals(hashMap.get(s6)));
            }
            sb.append(Util.C("<div style='position:absolute;z-index:%s;%s:%.2f%%;%s:%s;%s:%s;text-align:%s;writing-mode:%s;font-size:%s;background-color:%s;transform:translate(%s%%,%s%%)%s;'>", i, s3, n, s2, s, s5, c, c2, f, e2, b4, b, n3, h(cue)));
            sb.append(Util.C("<span class='%s'>", "default_bg"));
            final Layout$Alignment c3 = cue.c;
            if (c3 != null) {
                sb.append(Util.C("<span style='display:inline-block; text-align:%s;'>", c(c3)));
                sb.append(a2.a);
                sb.append("</span>");
            }
            else {
                sb.append(a2.a);
            }
            sb.append("</span>");
            sb.append("</div>");
        }
        sb.append("</div></body></html>");
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("<html><head><style>");
        for (final String s8 : hashMap.keySet()) {
            sb2.append(s8);
            sb2.append("{");
            sb2.append((String)hashMap.get(s8));
            sb2.append("}");
        }
        sb2.append("</style></head>");
        sb.insert(0, sb2.toString());
        this.b.loadData(Base64.encodeToString(sb.toString().getBytes(Charsets.c), 1), "text/html", "base64");
    }
    
    public void a(final List<Cue> list, final CaptionStyleCompat d, final float e, final int f, final float g) {
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        final ArrayList list2 = new ArrayList();
        final ArrayList c = new ArrayList();
        for (int i = 0; i < list.size(); ++i) {
            final Cue cue = list.get(i);
            if (cue.d != null) {
                list2.add(cue);
            }
            else {
                c.add(cue);
            }
        }
        if (!this.c.isEmpty() || !c.isEmpty()) {
            this.c = c;
            this.i();
        }
        this.a.a(list2, d, e, f, g);
        this.invalidate();
    }
    
    public void g() {
        this.b.destroy();
    }
    
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        super.onLayout(b, n, n2, n3, n4);
        if (b && !this.c.isEmpty()) {
            this.i();
        }
    }
}
