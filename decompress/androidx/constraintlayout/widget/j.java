// 
// Decompiled by Procyon v0.6.0
// 

package androidx.constraintlayout.widget;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import android.content.res.TypedArray;
import org.xmlpull.v1.XmlPullParserException;
import java.io.IOException;
import android.util.Xml;
import org.xmlpull.v1.XmlPullParser;
import android.content.Context;
import android.util.SparseArray;

public class j
{
    int a;
    int b;
    int c;
    private SparseArray<a> d;
    private SparseArray<c> e;
    
    public j(final Context context, final XmlPullParser xmlPullParser) {
        this.a = -1;
        this.b = -1;
        this.c = -1;
        this.d = (SparseArray<a>)new SparseArray();
        this.e = (SparseArray<c>)new SparseArray();
        this.b(context, xmlPullParser);
    }
    
    private void b(final Context context, final XmlPullParser xmlPullParser) {
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), h.b9);
        for (int indexCount = obtainStyledAttributes.getIndexCount(), i = 0; i < indexCount; ++i) {
            final int index = obtainStyledAttributes.getIndex(i);
            if (index == h.c9) {
                this.a = obtainStyledAttributes.getResourceId(index, this.a);
            }
        }
        obtainStyledAttributes.recycle();
        a a = null;
        try {
            int n = xmlPullParser.getEventType();
            while (true) {
                final int n2 = 1;
                if (n == 1) {
                    return;
                }
                a a2;
                if (n != 0) {
                    if (n != 2) {
                        if (n != 3) {
                            a2 = a;
                        }
                        else {
                            a2 = a;
                            if ("StateSet".equals(xmlPullParser.getName())) {
                                break;
                            }
                        }
                    }
                    else {
                        final String name = xmlPullParser.getName();
                        int n3 = 0;
                        Label_0250: {
                            switch (name.hashCode()) {
                                case 1901439077: {
                                    if (name.equals("Variant")) {
                                        n3 = 3;
                                        break Label_0250;
                                    }
                                    break;
                                }
                                case 1382829617: {
                                    if (name.equals("StateSet")) {
                                        n3 = n2;
                                        break Label_0250;
                                    }
                                    break;
                                }
                                case 1301459538: {
                                    if (name.equals("LayoutDescription")) {
                                        n3 = 0;
                                        break Label_0250;
                                    }
                                    break;
                                }
                                case 80204913: {
                                    if (name.equals("State")) {
                                        n3 = 2;
                                        break Label_0250;
                                    }
                                    break;
                                }
                            }
                            n3 = -1;
                        }
                        if (n3 != 2) {
                            if (n3 != 3) {
                                a2 = a;
                            }
                            else {
                                final b b = new b(context, xmlPullParser);
                                if ((a2 = a) != null) {
                                    a.a(b);
                                    a2 = a;
                                }
                            }
                        }
                        else {
                            a2 = new a(context, xmlPullParser);
                            this.d.put(a2.a, (Object)a2);
                        }
                    }
                }
                else {
                    xmlPullParser.getName();
                    a2 = a;
                }
                n = xmlPullParser.next();
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
    
    public int a(final int n, final int n2, final float n3, final float n4) {
        final a a = (a)this.d.get(n2);
        if (a == null) {
            return n2;
        }
        if (n3 != -1.0f && n4 != -1.0f) {
            b b = null;
            for (final b b2 : a.b) {
                if (b2.a(n3, n4)) {
                    if (n == b2.e) {
                        return n;
                    }
                    b = b2;
                }
            }
            if (b != null) {
                return b.e;
            }
            return a.c;
        }
        else {
            if (a.c == n) {
                return n;
            }
            final Iterator<b> iterator2 = a.b.iterator();
            while (iterator2.hasNext()) {
                if (n == ((b)iterator2.next()).e) {
                    return n;
                }
            }
            return a.c;
        }
    }
    
    public int c(final int n, final int n2, final int n3) {
        return this.d(-1, n, (float)n2, (float)n3);
    }
    
    public int d(int n, int b, final float n2, final float n3) {
        if (n == b) {
            a a;
            if (b == -1) {
                a = (a)this.d.valueAt(0);
            }
            else {
                a = (a)this.d.get(this.b);
            }
            if (a == null) {
                return -1;
            }
            if (this.c != -1 && ((b)a.b.get(n)).a(n2, n3)) {
                return n;
            }
            b = a.b(n2, n3);
            if (n == b) {
                return n;
            }
            if (b == -1) {
                n = a.c;
            }
            else {
                n = ((b)a.b.get(b)).e;
            }
            return n;
        }
        else {
            final a a2 = (a)this.d.get(b);
            if (a2 == null) {
                return -1;
            }
            n = a2.b(n2, n3);
            if (n == -1) {
                n = a2.c;
            }
            else {
                n = ((b)a2.b.get(n)).e;
            }
            return n;
        }
    }
    
    static class a
    {
        int a;
        ArrayList<b> b;
        int c;
        boolean d;
        
        public a(final Context context, final XmlPullParser xmlPullParser) {
            this.b = new ArrayList<b>();
            this.c = -1;
            int i = 0;
            this.d = false;
            TypedArray obtainStyledAttributes;
            for (obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), h.W8); i < obtainStyledAttributes.getIndexCount(); ++i) {
                final int index = obtainStyledAttributes.getIndex(i);
                if (index == h.X8) {
                    this.a = obtainStyledAttributes.getResourceId(index, this.a);
                }
                else if (index == h.Y8) {
                    this.c = obtainStyledAttributes.getResourceId(index, this.c);
                    final String resourceTypeName = context.getResources().getResourceTypeName(this.c);
                    context.getResources().getResourceName(this.c);
                    if ("layout".equals(resourceTypeName)) {
                        this.d = true;
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
        boolean f;
        
        public b(final Context context, final XmlPullParser xmlPullParser) {
            this.a = Float.NaN;
            this.b = Float.NaN;
            this.c = Float.NaN;
            this.d = Float.NaN;
            this.e = -1;
            int i = 0;
            this.f = false;
            TypedArray obtainStyledAttributes;
            for (obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), h.G9); i < obtainStyledAttributes.getIndexCount(); ++i) {
                final int index = obtainStyledAttributes.getIndex(i);
                if (index == h.H9) {
                    this.e = obtainStyledAttributes.getResourceId(index, this.e);
                    final String resourceTypeName = context.getResources().getResourceTypeName(this.e);
                    context.getResources().getResourceName(this.e);
                    if ("layout".equals(resourceTypeName)) {
                        this.f = true;
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
