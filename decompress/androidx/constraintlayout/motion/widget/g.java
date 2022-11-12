// 
// Decompiled by Procyon v0.6.0
// 

package androidx.constraintlayout.motion.widget;

import org.xmlpull.v1.XmlPullParserException;
import java.io.IOException;
import androidx.constraintlayout.widget.ConstraintAttribute;
import android.util.Xml;
import org.xmlpull.v1.XmlPullParser;
import android.content.Context;
import android.util.Log;
import java.util.ArrayList;
import java.lang.reflect.Constructor;
import java.util.HashMap;

public class g
{
    static HashMap<String, Constructor<? extends d>> b;
    private HashMap<Integer, ArrayList<d>> a;
    
    static {
        final HashMap<String, Constructor<? extends d>> hashMap = g.b = new HashMap<String, Constructor<? extends d>>();
        try {
            hashMap.put("KeyAttribute", e.class.getConstructor((Class<?>[])new Class[0]));
            g.b.put("KeyPosition", h.class.getConstructor((Class<?>[])new Class[0]));
            g.b.put("KeyCycle", f.class.getConstructor((Class<?>[])new Class[0]));
            g.b.put("KeyTimeCycle", j.class.getConstructor((Class<?>[])new Class[0]));
            g.b.put("KeyTrigger", k.class.getConstructor((Class<?>[])new Class[0]));
        }
        catch (final NoSuchMethodException ex) {
            Log.e("KeyFrames", "unable to load", (Throwable)ex);
        }
    }
    
    public g() {
        this.a = new HashMap<Integer, ArrayList<d>>();
    }
    
    public g(final Context context, final XmlPullParser xmlPullParser) {
        this.a = new HashMap<Integer, ArrayList<d>>();
        d d = null;
        try {
            d d2;
            for (int i = xmlPullParser.getEventType(); i != 1; i = xmlPullParser.next(), d = d2) {
                if (i != 2) {
                    if (i != 3) {
                        d2 = d;
                    }
                    else {
                        d2 = d;
                        if ("KeyFrameSet".equals(xmlPullParser.getName())) {
                            return;
                        }
                    }
                }
                else {
                    final String name = xmlPullParser.getName();
                    if (g.b.containsKey(name)) {
                        Label_0221: {
                            Exception ex = null;
                            Label_0211: {
                                try {
                                    final Constructor constructor = g.b.get(name);
                                    if (constructor != null) {
                                        final d d3 = (d)constructor.newInstance(new Object[0]);
                                        try {
                                            d3.e(context, Xml.asAttributeSet(xmlPullParser));
                                            this.b(d3);
                                            d = d3;
                                            break Label_0221;
                                        }
                                        catch (final Exception ex) {
                                            d = d3;
                                            break Label_0211;
                                        }
                                    }
                                    final StringBuilder sb = new StringBuilder();
                                    sb.append("Keymaker for ");
                                    sb.append(name);
                                    sb.append(" not found");
                                    throw new NullPointerException(sb.toString());
                                }
                                catch (final Exception ex2) {
                                    ex = ex2;
                                }
                            }
                            Log.e("KeyFrames", "unable to create ", (Throwable)ex);
                        }
                        d2 = d;
                    }
                    else if (name.equalsIgnoreCase("CustomAttribute")) {
                        if ((d2 = d) != null) {
                            final HashMap<String, ConstraintAttribute> e = d.e;
                            d2 = d;
                            if (e != null) {
                                ConstraintAttribute.h(context, xmlPullParser, e);
                                d2 = d;
                            }
                        }
                    }
                    else {
                        d2 = d;
                        if (name.equalsIgnoreCase("CustomMethod") && (d2 = d) != null) {
                            final HashMap<String, ConstraintAttribute> e2 = d.e;
                            d2 = d;
                            if (e2 != null) {
                                ConstraintAttribute.h(context, xmlPullParser, e2);
                                d2 = d;
                            }
                        }
                    }
                }
            }
        }
        catch (final IOException ex3) {
            ex3.printStackTrace();
        }
        catch (final XmlPullParserException ex4) {
            ex4.printStackTrace();
        }
    }
    
    public void a(final m m) {
        final ArrayList list = this.a.get(-1);
        if (list != null) {
            m.a(list);
        }
    }
    
    public void b(final d d) {
        if (!this.a.containsKey(d.b)) {
            this.a.put(d.b, new ArrayList<d>());
        }
        final ArrayList list = this.a.get(d.b);
        if (list != null) {
            list.add(d);
        }
    }
    
    public ArrayList<d> c(final int n) {
        return this.a.get(n);
    }
}
