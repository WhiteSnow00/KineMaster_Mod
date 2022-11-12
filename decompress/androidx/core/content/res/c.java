// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.content.res;

import android.graphics.Color;
import android.content.res.TypedArray;
import android.util.StateSet;
import v.a;
import android.os.Build$VERSION;
import v.d;
import java.io.IOException;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParserException;
import android.util.Xml;
import android.content.res.ColorStateList;
import android.content.res.Resources$Theme;
import org.xmlpull.v1.XmlPullParser;
import android.content.res.Resources;
import android.util.TypedValue;

public final class c
{
    private static final ThreadLocal<TypedValue> a;
    
    static {
        a = new ThreadLocal<TypedValue>();
    }
    
    public static ColorStateList a(final Resources resources, final XmlPullParser xmlPullParser, final Resources$Theme resources$Theme) throws XmlPullParserException, IOException {
        final AttributeSet attributeSet = Xml.asAttributeSet(xmlPullParser);
        int next;
        do {
            next = xmlPullParser.next();
        } while (next != 2 && next != 1);
        if (next == 2) {
            return b(resources, xmlPullParser, attributeSet, resources$Theme);
        }
        throw new XmlPullParserException("No start tag found");
    }
    
    public static ColorStateList b(final Resources resources, final XmlPullParser xmlPullParser, final AttributeSet set, final Resources$Theme resources$Theme) throws XmlPullParserException, IOException {
        final String name = xmlPullParser.getName();
        if (name.equals("selector")) {
            return d(resources, xmlPullParser, set, resources$Theme);
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(xmlPullParser.getPositionDescription());
        sb.append(": invalid color state list tag ");
        sb.append(name);
        throw new XmlPullParserException(sb.toString());
    }
    
    private static TypedValue c() {
        final ThreadLocal<TypedValue> a = c.a;
        TypedValue typedValue;
        if ((typedValue = a.get()) == null) {
            typedValue = new TypedValue();
            a.set(typedValue);
        }
        return typedValue;
    }
    
    private static ColorStateList d(final Resources resources, final XmlPullParser xmlPullParser, final AttributeSet set, final Resources$Theme resources$Theme) throws XmlPullParserException, IOException {
        final int n = xmlPullParser.getDepth() + 1;
        int[][] array = new int[20][];
        int[] array2 = new int[20];
        int n2 = 0;
        while (true) {
            final int next = xmlPullParser.next();
            if (next == 1) {
                break;
            }
            final int depth = xmlPullParser.getDepth();
            if (depth < n && next == 3) {
                break;
            }
            int[] a = array2;
            int[][] array3 = array;
            int n3 = n2;
            if (next == 2) {
                a = array2;
                array3 = array;
                n3 = n2;
                if (depth <= n) {
                    if (!xmlPullParser.getName().equals("item")) {
                        a = array2;
                        array3 = array;
                        n3 = n2;
                    }
                    else {
                        final TypedArray g = g(resources, resources$Theme, set, d.b);
                        final int c = d.c;
                        final int resourceId = g.getResourceId(c, -1);
                        int n4;
                        if (resourceId != -1 && !e(resources, resourceId)) {
                            try {
                                n4 = a(resources, (XmlPullParser)resources.getXml(resourceId), resources$Theme).getDefaultColor();
                            }
                            catch (final Exception ex) {
                                n4 = g.getColor(d.c, -65281);
                            }
                        }
                        else {
                            n4 = g.getColor(c, -65281);
                        }
                        float n5 = 1.0f;
                        final int d = v.d.d;
                        if (g.hasValue(d)) {
                            n5 = g.getFloat(d, 1.0f);
                        }
                        else {
                            final int f = v.d.f;
                            if (g.hasValue(f)) {
                                n5 = g.getFloat(f, 1.0f);
                            }
                        }
                        float n6 = 0.0f;
                        Label_0320: {
                            if (Build$VERSION.SDK_INT >= 31) {
                                final int e = v.d.e;
                                if (g.hasValue(e)) {
                                    n6 = g.getFloat(e, -1.0f);
                                    break Label_0320;
                                }
                            }
                            n6 = g.getFloat(v.d.g, -1.0f);
                        }
                        g.recycle();
                        final int attributeCount = set.getAttributeCount();
                        final int[] array4 = new int[attributeCount];
                        int i = 0;
                        int n7 = 0;
                        while (i < attributeCount) {
                            final int attributeNameResource = set.getAttributeNameResource(i);
                            int n8 = n7;
                            if (attributeNameResource != 16843173) {
                                n8 = n7;
                                if (attributeNameResource != 16843551) {
                                    n8 = n7;
                                    if (attributeNameResource != v.a.a) {
                                        n8 = n7;
                                        if (attributeNameResource != v.a.b) {
                                            int n9;
                                            if (set.getAttributeBooleanValue(i, false)) {
                                                n9 = attributeNameResource;
                                            }
                                            else {
                                                n9 = -attributeNameResource;
                                            }
                                            array4[n7] = n9;
                                            n8 = n7 + 1;
                                        }
                                    }
                                }
                            }
                            ++i;
                            n7 = n8;
                        }
                        final int[] trimStateSet = StateSet.trimStateSet(array4, n7);
                        a = e.a(array2, n2, f(n4, n5, n6));
                        array3 = e.b(array, n2, trimStateSet);
                        n3 = n2 + 1;
                    }
                }
            }
            array2 = a;
            array = array3;
            n2 = n3;
        }
        final int[] array5 = new int[n2];
        final int[][] array6 = new int[n2][];
        System.arraycopy(array2, 0, array5, 0, n2);
        System.arraycopy(array, 0, array6, 0, n2);
        return new ColorStateList(array6, array5);
    }
    
    private static boolean e(final Resources resources, int type) {
        final TypedValue c = c();
        boolean b = true;
        resources.getValue(type, c, true);
        type = c.type;
        if (type < 28 || type > 31) {
            b = false;
        }
        return b;
    }
    
    private static int f(final int n, final float n2, final float n3) {
        final boolean b = n3 >= 0.0f && n3 <= 100.0f;
        if (n2 == 1.0f && !b) {
            return n;
        }
        final int b2 = x.a.b((int)(Color.alpha(n) * n2 + 0.5f), 0, 255);
        int m = n;
        if (b) {
            final androidx.core.content.res.a c = androidx.core.content.res.a.c(n);
            m = androidx.core.content.res.a.m(c.j(), c.i(), n3);
        }
        return (m & 0xFFFFFF) | b2 << 24;
    }
    
    private static TypedArray g(final Resources resources, final Resources$Theme resources$Theme, final AttributeSet set, final int[] array) {
        TypedArray typedArray;
        if (resources$Theme == null) {
            typedArray = resources.obtainAttributes(set, array);
        }
        else {
            typedArray = resources$Theme.obtainStyledAttributes(set, array, 0, 0);
        }
        return typedArray;
    }
}
