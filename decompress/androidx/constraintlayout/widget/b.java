// 
// Decompiled by Procyon v0.6.0
// 

package androidx.constraintlayout.widget;

import android.content.res.TypedArray;
import android.util.Xml;
import java.util.ArrayList;
import android.util.Log;
import android.content.res.XmlResourceParser;
import org.xmlpull.v1.XmlPullParserException;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import android.content.Context;
import android.util.SparseArray;

public class b
{
    private final ConstraintLayout a;
    c b;
    int c;
    int d;
    private SparseArray<a> e;
    private SparseArray<c> f;
    
    b(final Context context, final ConstraintLayout a, final int n) {
        this.c = -1;
        this.d = -1;
        this.e = (SparseArray<a>)new SparseArray();
        this.f = (SparseArray<c>)new SparseArray();
        this.a = a;
        this.a(context, n);
    }
    
    private void a(final Context context, int n) {
        final XmlResourceParser xml = context.getResources().getXml(n);
        a a = null;
        try {
            n = ((XmlPullParser)xml).getEventType();
            while (true) {
                final int n2 = 1;
                if (n == 1) {
                    break;
                }
                a a2;
                if (n != 0) {
                    if (n != 2) {
                        a2 = a;
                    }
                    else {
                        final String name = ((XmlPullParser)xml).getName();
                        Label_0188: {
                            switch (name.hashCode()) {
                                case 1901439077: {
                                    if (name.equals("Variant")) {
                                        n = 3;
                                        break Label_0188;
                                    }
                                    break;
                                }
                                case 1657696882: {
                                    if (name.equals("layoutDescription")) {
                                        n = 0;
                                        break Label_0188;
                                    }
                                    break;
                                }
                                case 1382829617: {
                                    if (name.equals("StateSet")) {
                                        n = n2;
                                        break Label_0188;
                                    }
                                    break;
                                }
                                case 80204913: {
                                    if (name.equals("State")) {
                                        n = 2;
                                        break Label_0188;
                                    }
                                    break;
                                }
                                case -1349929691: {
                                    if (name.equals("ConstraintSet")) {
                                        n = 4;
                                        break Label_0188;
                                    }
                                    break;
                                }
                            }
                            n = -1;
                        }
                        if (n != 2) {
                            if (n != 3) {
                                if (n != 4) {
                                    a2 = a;
                                }
                                else {
                                    this.b(context, (XmlPullParser)xml);
                                    a2 = a;
                                }
                            }
                            else {
                                final b b = new b(context, (XmlPullParser)xml);
                                if ((a2 = a) != null) {
                                    a.a(b);
                                    a2 = a;
                                }
                            }
                        }
                        else {
                            a2 = new a(context, (XmlPullParser)xml);
                            this.e.put(a2.a, (Object)a2);
                        }
                    }
                }
                else {
                    ((XmlPullParser)xml).getName();
                    a2 = a;
                }
                n = ((XmlPullParser)xml).next();
                a = a2;
            }
        }
        catch (final IOException ex) {
            ex.printStackTrace();
        }
        catch (final XmlPullParserException ex2) {
            ex2.printStackTrace();
        }
    }
    
    private void b(final Context context, final XmlPullParser xmlPullParser) {
        final c c = new c();
        for (int attributeCount = xmlPullParser.getAttributeCount(), i = 0; i < attributeCount; ++i) {
            final String attributeName = xmlPullParser.getAttributeName(i);
            final String attributeValue = xmlPullParser.getAttributeValue(i);
            if (attributeName != null) {
                if (attributeValue != null) {
                    if ("id".equals(attributeName)) {
                        int identifier;
                        if (attributeValue.contains("/")) {
                            identifier = context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), "id", context.getPackageName());
                        }
                        else {
                            identifier = -1;
                        }
                        int int1 = identifier;
                        if (identifier == -1) {
                            if (attributeValue.length() > 1) {
                                int1 = Integer.parseInt(attributeValue.substring(1));
                            }
                            else {
                                Log.e("ConstraintLayoutStates", "error in parsing id");
                                int1 = identifier;
                            }
                        }
                        c.y(context, xmlPullParser);
                        this.f.put(int1, (Object)c);
                        break;
                    }
                }
            }
        }
    }
    
    public void c(final e e) {
    }
    
    public void d(int n, final float n2, final float n3) {
        final int c = this.c;
        if (c == n) {
            a a;
            if (n == -1) {
                a = (a)this.e.valueAt(0);
            }
            else {
                a = (a)this.e.get(c);
            }
            n = this.d;
            if (n != -1 && ((b)a.b.get(n)).a(n2, n3)) {
                return;
            }
            n = a.b(n2, n3);
            if (this.d == n) {
                return;
            }
            c c2;
            if (n == -1) {
                c2 = this.b;
            }
            else {
                c2 = ((b)a.b.get(n)).f;
            }
            if (n != -1) {
                final int e = ((b)a.b.get(n)).e;
            }
            if (c2 == null) {
                return;
            }
            this.d = n;
            c2.i(this.a);
        }
        else {
            this.c = n;
            final a a2 = (a)this.e.get(n);
            final int b = a2.b(n2, n3);
            c c3;
            if (b == -1) {
                c3 = a2.d;
            }
            else {
                c3 = ((b)a2.b.get(b)).f;
            }
            if (b != -1) {
                final int e2 = ((b)a2.b.get(b)).e;
            }
            if (c3 == null) {
                final StringBuilder sb = new StringBuilder();
                sb.append("NO Constraint set found ! id=");
                sb.append(n);
                sb.append(", dim =");
                sb.append(n2);
                sb.append(", ");
                sb.append(n3);
                Log.v("ConstraintLayoutStates", sb.toString());
                return;
            }
            this.d = b;
            c3.i(this.a);
        }
    }
    
    static class a
    {
        int a;
        ArrayList<b> b;
        int c;
        c d;
        
        public a(final Context context, final XmlPullParser xmlPullParser) {
            this.b = new ArrayList<b>();
            this.c = -1;
            final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), h.W8);
            for (int indexCount = obtainStyledAttributes.getIndexCount(), i = 0; i < indexCount; ++i) {
                final int index = obtainStyledAttributes.getIndex(i);
                if (index == h.X8) {
                    this.a = obtainStyledAttributes.getResourceId(index, this.a);
                }
                else if (index == h.Y8) {
                    this.c = obtainStyledAttributes.getResourceId(index, this.c);
                    final String resourceTypeName = context.getResources().getResourceTypeName(this.c);
                    context.getResources().getResourceName(this.c);
                    if ("layout".equals(resourceTypeName)) {
                        (this.d = new c()).m(context, this.c);
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }
        
        void a(final b b) {
            this.b.add(b);
        }
        
        public int b(final float n, final float n2) {
            for (int i = 0; i < this.b.size(); ++i) {
                if (this.b.get(i).a(n, n2)) {
                    return i;
                }
            }
            return -1;
        }
    }
    
    static class b
    {
        float a;
        float b;
        float c;
        float d;
        int e;
        c f;
        
        public b(final Context context, final XmlPullParser xmlPullParser) {
            this.a = Float.NaN;
            this.b = Float.NaN;
            this.c = Float.NaN;
            this.d = Float.NaN;
            this.e = -1;
            final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), h.G9);
            for (int indexCount = obtainStyledAttributes.getIndexCount(), i = 0; i < indexCount; ++i) {
                final int index = obtainStyledAttributes.getIndex(i);
                if (index == h.H9) {
                    this.e = obtainStyledAttributes.getResourceId(index, this.e);
                    final String resourceTypeName = context.getResources().getResourceTypeName(this.e);
                    context.getResources().getResourceName(this.e);
                    if ("layout".equals(resourceTypeName)) {
                        (this.f = new c()).m(context, this.e);
                    }
                }
                else if (index == h.I9) {
                    this.d = obtainStyledAttributes.getDimension(index, this.d);
                }
                else if (index == h.J9) {
                    this.b = obtainStyledAttributes.getDimension(index, this.b);
                }
                else if (index == h.K9) {
                    this.c = obtainStyledAttributes.getDimension(index, this.c);
                }
                else if (index == h.L9) {
                    this.a = obtainStyledAttributes.getDimension(index, this.a);
                }
                else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            obtainStyledAttributes.recycle();
        }
        
        boolean a(final float n, final float n2) {
            return (Float.isNaN(this.a) || n >= this.a) && (Float.isNaN(this.b) || n2 >= this.b) && (Float.isNaN(this.c) || n <= this.c) && (Float.isNaN(this.d) || n2 <= this.d);
        }
    }
}
