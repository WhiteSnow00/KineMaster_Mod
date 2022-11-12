// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.app;

import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParserException;
import java.util.ArrayDeque;
import org.xmlpull.v1.XmlPullParser;
import java.lang.ref.WeakReference;
import java.util.Deque;

class k
{
    private final Deque<WeakReference<XmlPullParser>> a;
    
    k() {
        this.a = new ArrayDeque<WeakReference<XmlPullParser>>();
    }
    
    private static boolean b(final XmlPullParser xmlPullParser) {
        boolean b2;
        final boolean b = b2 = true;
        if (xmlPullParser == null) {
            return b2;
        }
        b2 = b;
        try {
            if (xmlPullParser.getEventType() != 3) {
                b2 = (xmlPullParser.getEventType() == 1 && b);
            }
            return b2;
        }
        catch (final XmlPullParserException ex) {
            b2 = b;
            return b2;
        }
    }
    
    private static XmlPullParser c(final Deque<WeakReference<XmlPullParser>> deque) {
        while (!deque.isEmpty()) {
            final XmlPullParser xmlPullParser = deque.peek().get();
            if (!b(xmlPullParser)) {
                return xmlPullParser;
            }
            deque.pop();
        }
        return null;
    }
    
    private static boolean d(final XmlPullParser xmlPullParser, final XmlPullParser xmlPullParser2) {
        if (xmlPullParser2 == null || xmlPullParser == xmlPullParser2) {
            return false;
        }
        try {
            if (xmlPullParser2.getEventType() == 2) {
                return "include".equals(xmlPullParser2.getName());
            }
            return false;
        }
        catch (final XmlPullParserException ex) {
            return false;
        }
    }
    
    boolean a(final AttributeSet set) {
        if (set instanceof XmlPullParser) {
            final XmlPullParser xmlPullParser = (XmlPullParser)set;
            if (xmlPullParser.getDepth() == 1) {
                final XmlPullParser c = c(this.a);
                this.a.push(new WeakReference<XmlPullParser>(xmlPullParser));
                if (d(xmlPullParser, c)) {
                    return true;
                }
            }
        }
        return false;
    }
}
