// 
// Decompiled by Procyon v0.6.0
// 

package androidx.customview.widget;

import java.util.Comparator;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import android.graphics.Rect;

class b
{
    private static boolean a(final int n, final Rect rect, final Rect rect2, final Rect rect3) {
        final boolean b = b(n, rect, rect2);
        final boolean b2 = b(n, rect, rect3);
        boolean b3 = false;
        if (b2 || !b) {
            return false;
        }
        if (!j(n, rect, rect3)) {
            return true;
        }
        if (n != 17 && n != 66) {
            if (k(n, rect, rect2) < m(n, rect, rect3)) {
                b3 = true;
            }
            return b3;
        }
        return true;
    }
    
    private static boolean b(final int n, final Rect rect, final Rect rect2) {
        boolean b = true;
        final boolean b2 = true;
        Label_0075: {
            if (n != 17) {
                if (n != 33) {
                    if (n == 66) {
                        break Label_0075;
                    }
                    if (n != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
                return rect2.right >= rect.left && rect2.left <= rect.right && b2;
            }
        }
        if (rect2.bottom < rect.top || rect2.top > rect.bottom) {
            b = false;
        }
        return b;
    }
    
    public static <L, T> T c(final L l, final b<L, T> b, final a<T> a, final T t, final Rect rect, final int n) {
        final Rect rect2 = new Rect(rect);
        int i = 0;
        if (n != 17) {
            if (n != 33) {
                if (n != 66) {
                    if (n != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                    rect2.offset(0, -(rect.height() + 1));
                }
                else {
                    rect2.offset(-(rect.width() + 1), 0);
                }
            }
            else {
                rect2.offset(0, rect.height() + 1);
            }
        }
        else {
            rect2.offset(rect.width() + 1, 0);
        }
        T t2 = null;
        final int b2 = b.b(l);
        final Rect rect3 = new Rect();
        while (i < b2) {
            final T a2 = b.a(l, i);
            if (a2 != t) {
                a.a(a2, rect3);
                if (h(n, rect, rect3, rect2)) {
                    rect2.set(rect3);
                    t2 = a2;
                }
            }
            ++i;
        }
        return t2;
    }
    
    public static <L, T> T d(final L l, final b<L, T> b, final a<T> a, final T t, final int n, final boolean b2, final boolean b3) {
        final int b4 = b.b(l);
        final ArrayList list = new ArrayList<T>(b4);
        for (int i = 0; i < b4; ++i) {
            list.add(b.a(l, i));
        }
        Collections.sort((List<T>)list, new c<Object>(b2, (a<? super T>)a));
        if (n == 1) {
            return f(t, (ArrayList<T>)list, b3);
        }
        if (n == 2) {
            return e(t, (ArrayList<T>)list, b3);
        }
        throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
    }
    
    private static <T> T e(final T t, final ArrayList<T> list, final boolean b) {
        final int size = list.size();
        int lastIndex;
        if (t == null) {
            lastIndex = -1;
        }
        else {
            lastIndex = list.lastIndexOf(t);
        }
        if (++lastIndex < size) {
            return (T)list.get(lastIndex);
        }
        if (b && size > 0) {
            return (T)list.get(0);
        }
        return null;
    }
    
    private static <T> T f(final T t, final ArrayList<T> list, final boolean b) {
        final int size = list.size();
        int index;
        if (t == null) {
            index = size;
        }
        else {
            index = list.indexOf(t);
        }
        if (--index >= 0) {
            return (T)list.get(index);
        }
        if (b && size > 0) {
            return (T)list.get(size - 1);
        }
        return null;
    }
    
    private static int g(final int n, final int n2) {
        return n * 13 * n + n2 * n2;
    }
    
    private static boolean h(final int n, final Rect rect, final Rect rect2, final Rect rect3) {
        final boolean i = i(rect, rect2, n);
        boolean b = false;
        if (!i) {
            return false;
        }
        if (!i(rect, rect3, n)) {
            return true;
        }
        if (a(n, rect, rect2, rect3)) {
            return true;
        }
        if (a(n, rect, rect3, rect2)) {
            return false;
        }
        if (g(k(n, rect, rect2), o(n, rect, rect2)) < g(k(n, rect, rect3), o(n, rect, rect3))) {
            b = true;
        }
        return b;
    }
    
    private static boolean i(final Rect rect, final Rect rect2, int n) {
        boolean b = true;
        final boolean b2 = true;
        final boolean b3 = true;
        final boolean b4 = true;
        if (n == 17) {
            final int right = rect.right;
            n = rect2.right;
            return (right > n || rect.left >= n) && rect.left > rect2.left && b3;
        }
        if (n == 33) {
            final int bottom = rect.bottom;
            n = rect2.bottom;
            return (bottom > n || rect.top >= n) && rect.top > rect2.top && b2;
        }
        if (n == 66) {
            n = rect.left;
            final int left = rect2.left;
            if ((n >= left && rect.right > left) || rect.right >= rect2.right) {
                b = false;
            }
            return b;
        }
        if (n == 130) {
            n = rect.top;
            final int top = rect2.top;
            return (n < top || rect.bottom <= top) && rect.bottom < rect2.bottom && b4;
        }
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }
    
    private static boolean j(final int n, final Rect rect, final Rect rect2) {
        final boolean b = true;
        boolean b2 = true;
        final boolean b3 = true;
        final boolean b4 = true;
        if (n == 17) {
            return rect.left >= rect2.right && b3;
        }
        if (n == 33) {
            if (rect.top < rect2.bottom) {
                b2 = false;
            }
            return b2;
        }
        if (n == 66) {
            return rect.right <= rect2.left && b;
        }
        if (n == 130) {
            return rect.bottom <= rect2.top && b4;
        }
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }
    
    private static int k(final int n, final Rect rect, final Rect rect2) {
        return Math.max(0, l(n, rect, rect2));
    }
    
    private static int l(int n, final Rect rect, final Rect rect2) {
        int n2;
        if (n != 17) {
            if (n != 33) {
                if (n != 66) {
                    if (n != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                    n = rect2.top;
                    n2 = rect.bottom;
                }
                else {
                    n = rect2.left;
                    n2 = rect.right;
                }
            }
            else {
                n = rect.top;
                n2 = rect2.bottom;
            }
        }
        else {
            n = rect.left;
            n2 = rect2.right;
        }
        return n - n2;
    }
    
    private static int m(final int n, final Rect rect, final Rect rect2) {
        return Math.max(1, n(n, rect, rect2));
    }
    
    private static int n(int n, final Rect rect, final Rect rect2) {
        int n2;
        if (n != 17) {
            if (n != 33) {
                if (n != 66) {
                    if (n != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                    n = rect2.bottom;
                    n2 = rect.bottom;
                }
                else {
                    n = rect2.right;
                    n2 = rect.right;
                }
            }
            else {
                n = rect.top;
                n2 = rect2.top;
            }
        }
        else {
            n = rect.left;
            n2 = rect2.left;
        }
        return n - n2;
    }
    
    private static int o(final int n, final Rect rect, final Rect rect2) {
        if (n != 17) {
            if (n != 33) {
                if (n == 66) {
                    return Math.abs(rect.top + rect.height() / 2 - (rect2.top + rect2.height() / 2));
                }
                if (n != 130) {
                    throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                }
            }
            return Math.abs(rect.left + rect.width() / 2 - (rect2.left + rect2.width() / 2));
        }
        return Math.abs(rect.top + rect.height() / 2 - (rect2.top + rect2.height() / 2));
    }
    
    public interface a<T>
    {
        void a(final T p0, final Rect p1);
    }
    
    public interface b<T, V>
    {
        V a(final T p0, final int p1);
        
        int b(final T p0);
    }
    
    private static class c<T> implements Comparator<T>
    {
        private final Rect a;
        private final Rect b;
        private final boolean c;
        private final a<T> d;
        
        c(final boolean c, final a<T> d) {
            this.a = new Rect();
            this.b = new Rect();
            this.c = c;
            this.d = d;
        }
        
        @Override
        public int compare(final T t, final T t2) {
            final Rect a = this.a;
            final Rect b = this.b;
            this.d.a(t, a);
            this.d.a(t2, b);
            final int top = a.top;
            final int top2 = b.top;
            int n = -1;
            if (top < top2) {
                return -1;
            }
            if (top > top2) {
                return 1;
            }
            final int left = a.left;
            final int left2 = b.left;
            if (left < left2) {
                if (this.c) {
                    n = 1;
                }
                return n;
            }
            if (left > left2) {
                if (!this.c) {
                    n = 1;
                }
                return n;
            }
            final int bottom = a.bottom;
            final int bottom2 = b.bottom;
            if (bottom < bottom2) {
                return -1;
            }
            if (bottom > bottom2) {
                return 1;
            }
            final int right = a.right;
            final int right2 = b.right;
            if (right < right2) {
                if (this.c) {
                    n = 1;
                }
                return n;
            }
            if (right > right2) {
                if (!this.c) {
                    n = 1;
                }
                return n;
            }
            return 0;
        }
    }
}
