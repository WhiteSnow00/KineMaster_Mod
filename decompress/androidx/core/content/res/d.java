// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.content.res;

import android.util.Base64;
import androidx.core.provider.e;
import android.util.Xml;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;
import android.content.res.Resources;
import org.xmlpull.v1.XmlPullParser;
import android.content.res.TypedArray;

public class d
{
    private static int a(final TypedArray typedArray, final int n) {
        return a.a(typedArray, n);
    }
    
    public static b b(final XmlPullParser xmlPullParser, final Resources resources) throws XmlPullParserException, IOException {
        int next;
        do {
            next = xmlPullParser.next();
        } while (next != 2 && next != 1);
        if (next == 2) {
            return d(xmlPullParser, resources);
        }
        throw new XmlPullParserException("No start tag found");
    }
    
    public static List<List<byte[]>> c(final Resources resources, int i) {
        if (i == 0) {
            return Collections.emptyList();
        }
        final TypedArray obtainTypedArray = resources.obtainTypedArray(i);
        try {
            if (obtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            final ArrayList list = new ArrayList();
            if (a(obtainTypedArray, 0) == 1) {
                int resourceId;
                for (i = 0; i < obtainTypedArray.length(); ++i) {
                    resourceId = obtainTypedArray.getResourceId(i, 0);
                    if (resourceId != 0) {
                        list.add(h(resources.getStringArray(resourceId)));
                    }
                }
            }
            else {
                list.add(h(resources.getStringArray(i)));
            }
            return list;
        }
        finally {
            obtainTypedArray.recycle();
        }
    }
    
    private static b d(final XmlPullParser xmlPullParser, final Resources resources) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, (String)null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return e(xmlPullParser, resources);
        }
        g(xmlPullParser);
        return null;
    }
    
    private static b e(final XmlPullParser xmlPullParser, final Resources resources) throws XmlPullParserException, IOException {
        final TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), d.h);
        final String string = obtainAttributes.getString(d.i);
        final String string2 = obtainAttributes.getString(d.m);
        final String string3 = obtainAttributes.getString(d.n);
        final int resourceId = obtainAttributes.getResourceId(d.j, 0);
        final int integer = obtainAttributes.getInteger(d.k, 1);
        final int integer2 = obtainAttributes.getInteger(d.l, 500);
        final String string4 = obtainAttributes.getString(d.o);
        obtainAttributes.recycle();
        if (string != null && string2 != null && string3 != null) {
            while (xmlPullParser.next() != 3) {
                g(xmlPullParser);
            }
            return (b)new e(new androidx.core.provider.e(string, string2, string3, c(resources, resourceId)), integer, integer2, string4);
        }
        final ArrayList list = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() != 2) {
                continue;
            }
            if (xmlPullParser.getName().equals("font")) {
                list.add(f(xmlPullParser, resources));
            }
            else {
                g(xmlPullParser);
            }
        }
        if (list.isEmpty()) {
            return null;
        }
        return (b)new c((d[])list.toArray(new d[0]));
    }
    
    private static d f(final XmlPullParser xmlPullParser, final Resources resources) throws XmlPullParserException, IOException {
        final TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), d.p);
        int n = d.y;
        if (!obtainAttributes.hasValue(n)) {
            n = d.r;
        }
        final int int1 = obtainAttributes.getInt(n, 400);
        int n2 = d.w;
        if (!obtainAttributes.hasValue(n2)) {
            n2 = d.s;
        }
        final boolean b = 1 == obtainAttributes.getInt(n2, 0);
        int n3 = d.z;
        if (!obtainAttributes.hasValue(n3)) {
            n3 = d.t;
        }
        int n4 = d.x;
        if (!obtainAttributes.hasValue(n4)) {
            n4 = d.u;
        }
        final String string = obtainAttributes.getString(n4);
        final int int2 = obtainAttributes.getInt(n3, 0);
        int n5 = d.v;
        if (!obtainAttributes.hasValue(n5)) {
            n5 = d.q;
        }
        final int resourceId = obtainAttributes.getResourceId(n5, 0);
        final String string2 = obtainAttributes.getString(n5);
        obtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            g(xmlPullParser);
        }
        return new d(string2, int1, b, string, int2, resourceId);
    }
    
    private static void g(final XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i = 1;
        while (i > 0) {
            final int next = xmlPullParser.next();
            if (next != 2) {
                if (next != 3) {
                    continue;
                }
                --i;
            }
            else {
                ++i;
            }
        }
    }
    
    private static List<byte[]> h(final String[] array) {
        final ArrayList list = new ArrayList();
        for (int length = array.length, i = 0; i < length; ++i) {
            list.add(Base64.decode(array[i], 0));
        }
        return list;
    }
    
    static class a
    {
        static int a(final TypedArray typedArray, final int n) {
            return typedArray.getType(n);
        }
    }
    
    public interface b
    {
    }
    
    public static final class c implements b
    {
        private final d[] a;
        
        public c(final d[] a) {
            this.a = a;
        }
        
        public d[] a() {
            return this.a;
        }
    }
    
    public static final class d
    {
        private final String a;
        private final int b;
        private final boolean c;
        private final String d;
        private final int e;
        private final int f;
        
        public d(final String a, final int b, final boolean c, final String d, final int e, final int f) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
            this.f = f;
        }
        
        public String a() {
            return this.a;
        }
        
        public int b() {
            return this.f;
        }
        
        public int c() {
            return this.e;
        }
        
        public String d() {
            return this.d;
        }
        
        public int e() {
            return this.b;
        }
        
        public boolean f() {
            return this.c;
        }
    }
    
    public static final class e implements b
    {
        private final androidx.core.provider.e a;
        private final int b;
        private final int c;
        private final String d;
        
        public e(final androidx.core.provider.e a, final int c, final int b, final String d) {
            this.a = a;
            this.c = c;
            this.b = b;
            this.d = d;
        }
        
        public int a() {
            return this.c;
        }
        
        public androidx.core.provider.e b() {
            return this.a;
        }
        
        public String c() {
            return this.d;
        }
        
        public int d() {
            return this.b;
        }
    }
}
