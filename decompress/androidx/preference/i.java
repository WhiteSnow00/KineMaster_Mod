// 
// Decompiled by Procyon v0.6.0
// 

package androidx.preference;

import android.util.Xml;
import android.content.res.XmlResourceParser;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;
import android.content.Intent;
import org.xmlpull.v1.XmlPullParser;
import android.view.InflateException;
import android.util.AttributeSet;
import android.content.Context;
import java.lang.reflect.Constructor;
import java.util.HashMap;

class i
{
    private static final Class<?>[] e;
    private static final HashMap<String, Constructor<?>> f;
    private final Context a;
    private final Object[] b;
    private j c;
    private String[] d;
    
    static {
        e = new Class[] { Context.class, AttributeSet.class };
        f = new HashMap<String, Constructor<?>>();
    }
    
    public i(final Context a, final j j) {
        this.b = new Object[2];
        this.a = a;
        this.f(j);
    }
    
    private Preference a(final String s, final String[] array, final AttributeSet set) throws ClassNotFoundException, InflateException {
        Label_0222: {
            Constructor<?> constructor;
            if ((constructor = i.f.get(s)) != null) {
                break Label_0222;
            }
            try {
                final ClassLoader classLoader = this.a.getClassLoader();
                Class<?> forName2;
                if (array != null && array.length != 0) {
                    final int length = array.length;
                    final Class clazz = null;
                    int n = 0;
                    final ClassNotFoundException ex = null;
                    Class<?> forName;
                    while (true) {
                        forName = clazz;
                        if (n < length) {
                            final String s2 = array[n];
                            try {
                                final StringBuilder sb = new StringBuilder();
                                sb.append(s2);
                                sb.append(s);
                                forName = Class.forName(sb.toString(), false, classLoader);
                            }
                            catch (final ClassNotFoundException ex) {
                                ++n;
                                continue;
                            }
                            break;
                        }
                        break;
                    }
                    if ((forName2 = forName) == null) {
                        if (ex == null) {
                            final StringBuilder sb2 = new StringBuilder();
                            sb2.append(set.getPositionDescription());
                            sb2.append(": Error inflating class ");
                            sb2.append(s);
                            throw new InflateException(sb2.toString());
                        }
                        throw ex;
                    }
                }
                else {
                    forName2 = Class.forName(s, false, classLoader);
                }
                constructor = forName2.getConstructor(i.e);
                constructor.setAccessible(true);
                i.f.put(s, constructor);
                final Object[] b = this.b;
                b[1] = set;
                return (Preference)constructor.newInstance(b);
            }
            catch (final Exception ex2) {
                final StringBuilder sb3 = new StringBuilder();
                sb3.append(set.getPositionDescription());
                sb3.append(": Error inflating class ");
                sb3.append(s);
                final InflateException ex3 = new InflateException(sb3.toString());
                ex3.initCause((Throwable)ex2);
                throw ex3;
            }
            catch (final ClassNotFoundException ex4) {
                throw ex4;
            }
        }
    }
    
    private Preference b(String o, final AttributeSet set) {
        try {
            if (-1 == ((String)o).indexOf(46)) {
                o = this.g((String)o, set);
            }
            else {
                o = this.a((String)o, null, set);
            }
            return (Preference)o;
        }
        catch (final Exception ex) {
            final StringBuilder sb = new StringBuilder();
            sb.append(set.getPositionDescription());
            sb.append(": Error inflating class ");
            sb.append((String)o);
            final InflateException ex2 = new InflateException(sb.toString());
            ex2.initCause((Throwable)ex);
            throw ex2;
        }
        catch (final ClassNotFoundException ex3) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append(set.getPositionDescription());
            sb2.append(": Error inflating class (not found)");
            sb2.append((String)o);
            final InflateException ex4 = new InflateException(sb2.toString());
            ex4.initCause((Throwable)ex3);
            throw ex4;
        }
        catch (final InflateException ex5) {
            throw ex5;
        }
    }
    
    private void f(final j c) {
        this.c = c;
        final StringBuilder sb = new StringBuilder();
        sb.append(Preference.class.getPackage().getName());
        sb.append(".");
        final String string = sb.toString();
        final StringBuilder sb2 = new StringBuilder();
        sb2.append(SwitchPreference.class.getPackage().getName());
        sb2.append(".");
        this.j(new String[] { string, sb2.toString() });
    }
    
    private PreferenceGroup h(final PreferenceGroup preferenceGroup, final PreferenceGroup preferenceGroup2) {
        if (preferenceGroup == null) {
            preferenceGroup2.W(this.c);
            return preferenceGroup2;
        }
        return preferenceGroup;
    }
    
    private void i(final XmlPullParser xmlPullParser, final Preference preference, final AttributeSet set) throws XmlPullParserException, IOException {
        final int depth = xmlPullParser.getDepth();
        while (true) {
            final int next = xmlPullParser.next();
            if ((next == 3 && xmlPullParser.getDepth() <= depth) || next == 1) {
                break;
            }
            if (next != 2) {
                continue;
            }
            final String name = xmlPullParser.getName();
            if ("intent".equals(name)) {
                try {
                    preference.E0(Intent.parseIntent(this.c().getResources(), xmlPullParser, set));
                    continue;
                }
                catch (final IOException ex) {
                    final XmlPullParserException ex2 = new XmlPullParserException("Error parsing preference");
                    ex2.initCause((Throwable)ex);
                    throw ex2;
                }
            }
            if ("extra".equals(name)) {
                this.c().getResources().parseBundleExtra("extra", set, preference.m());
                try {
                    k(xmlPullParser);
                    continue;
                }
                catch (final IOException ex3) {
                    final XmlPullParserException ex4 = new XmlPullParserException("Error parsing preference");
                    ex4.initCause((Throwable)ex3);
                    throw ex4;
                }
            }
            final Preference b = this.b(name, set);
            ((PreferenceGroup)preference).V0(b);
            this.i(xmlPullParser, b, set);
        }
    }
    
    private static void k(final XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        final int depth = xmlPullParser.getDepth();
        int next;
        do {
            next = xmlPullParser.next();
        } while (next != 1 && (next != 3 || xmlPullParser.getDepth() > depth));
    }
    
    public Context c() {
        return this.a;
    }
    
    public Preference d(final int n, final PreferenceGroup preferenceGroup) {
        final XmlResourceParser xml = this.c().getResources().getXml(n);
        try {
            return this.e((XmlPullParser)xml, preferenceGroup);
        }
        finally {
            xml.close();
        }
    }
    
    public Preference e(final XmlPullParser xmlPullParser, PreferenceGroup h) {
        synchronized (this.b) {
            final AttributeSet attributeSet = Xml.asAttributeSet(xmlPullParser);
            this.b[0] = this.a;
            try {
                int next;
                do {
                    next = xmlPullParser.next();
                } while (next != 2 && next != 1);
                if (next == 2) {
                    h = this.h(h, (PreferenceGroup)this.b(xmlPullParser.getName(), attributeSet));
                    this.i(xmlPullParser, h, attributeSet);
                    return h;
                }
                final StringBuilder sb = new StringBuilder();
                sb.append(xmlPullParser.getPositionDescription());
                sb.append(": No start tag found!");
                throw new InflateException(sb.toString());
            }
            catch (final IOException ex) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append(xmlPullParser.getPositionDescription());
                sb2.append(": ");
                sb2.append(ex.getMessage());
                final InflateException ex2 = new InflateException(sb2.toString());
                ex2.initCause((Throwable)ex);
                throw ex2;
            }
            catch (final XmlPullParserException ex3) {
                final InflateException ex4 = new InflateException(ex3.getMessage());
                ex4.initCause((Throwable)ex3);
                throw ex4;
            }
            catch (final InflateException ex5) {
                throw ex5;
            }
        }
    }
    
    protected Preference g(final String s, final AttributeSet set) throws ClassNotFoundException {
        return this.a(s, this.d, set);
    }
    
    public void j(final String[] d) {
        this.d = d;
    }
}
