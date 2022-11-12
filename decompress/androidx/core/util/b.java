// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.util;

public class b
{
    public static void a(final Object o, final StringBuilder sb) {
        if (o == null) {
            sb.append("null");
        }
        else {
            String s;
            if ((s = o.getClass().getSimpleName()).length() <= 0) {
                final String name = o.getClass().getName();
                final int lastIndex = name.lastIndexOf(46);
                s = name;
                if (lastIndex > 0) {
                    s = name.substring(lastIndex + 1);
                }
            }
            sb.append(s);
            sb.append('{');
            sb.append(Integer.toHexString(System.identityHashCode(o)));
        }
    }
}
