// 
// Decompiled by Procyon v0.6.0
// 

package androidx.emoji2.text;

import java.util.Arrays;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.MetaKeyKeyListener;
import android.view.inputmethod.InputConnection;
import android.text.Selection;
import android.view.KeyEvent;
import android.text.Editable;
import android.text.Spannable;

final class h
{
    private final e.i a;
    private final m b;
    private e.d c;
    private final boolean d;
    private final int[] e;
    
    h(final m b, final e.i a, final e.d c, final boolean d, final int[] e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    private void a(final Spannable spannable, final g g, final int n, final int n2) {
        spannable.setSpan((Object)this.a.a(g), n, n2, 33);
    }
    
    private static boolean b(final Editable editable, final KeyEvent keyEvent, final boolean b) {
        if (g(keyEvent)) {
            return false;
        }
        final int selectionStart = Selection.getSelectionStart((CharSequence)editable);
        final int selectionEnd = Selection.getSelectionEnd((CharSequence)editable);
        if (f(selectionStart, selectionEnd)) {
            return false;
        }
        final i[] array = (i[])editable.getSpans(selectionStart, selectionEnd, (Class)i.class);
        if (array != null && array.length > 0) {
            for (final i j : array) {
                final int spanStart = editable.getSpanStart((Object)j);
                final int spanEnd = editable.getSpanEnd((Object)j);
                if ((b && spanStart == selectionStart) || (!b && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd)) {
                    editable.delete(spanStart, spanEnd);
                    return true;
                }
            }
        }
        return false;
    }
    
    static boolean c(final InputConnection inputConnection, final Editable editable, int n, int n2, final boolean b) {
        if (editable != null) {
            if (inputConnection != null) {
                if (n >= 0) {
                    if (n2 >= 0) {
                        final int selectionStart = Selection.getSelectionStart((CharSequence)editable);
                        final int selectionEnd = Selection.getSelectionEnd((CharSequence)editable);
                        if (f(selectionStart, selectionEnd)) {
                            return false;
                        }
                        Label_0121: {
                            if (b) {
                                n = a.a((CharSequence)editable, selectionStart, Math.max(n, 0));
                                final int b2 = a.b((CharSequence)editable, selectionEnd, Math.max(n2, 0));
                                if (n != -1) {
                                    n2 = n;
                                    if ((n = b2) != -1) {
                                        break Label_0121;
                                    }
                                }
                                return false;
                            }
                            final int max = Math.max(selectionStart - n, 0);
                            n = Math.min(selectionEnd + n2, editable.length());
                            n2 = max;
                        }
                        final i[] array = (i[])editable.getSpans(n2, n, (Class)i.class);
                        if (array != null && array.length > 0) {
                            for (final i j : array) {
                                final int spanStart = editable.getSpanStart((Object)j);
                                final int spanEnd = editable.getSpanEnd((Object)j);
                                n2 = Math.min(spanStart, n2);
                                n = Math.max(spanEnd, n);
                            }
                            n2 = Math.max(n2, 0);
                            n = Math.min(n, editable.length());
                            inputConnection.beginBatchEdit();
                            editable.delete(n2, n);
                            inputConnection.endBatchEdit();
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    
    static boolean d(final Editable editable, final int n, final KeyEvent keyEvent) {
        boolean b;
        if (n != 67) {
            b = (n == 112 && b(editable, keyEvent, true));
        }
        else {
            b = b(editable, keyEvent, false);
        }
        if (b) {
            MetaKeyKeyListener.adjustMetaAfterKeypress((Spannable)editable);
            return true;
        }
        return false;
    }
    
    private boolean e(final CharSequence charSequence, final int n, final int n2, final g g) {
        if (g.d() == 0) {
            g.k(this.c.a(charSequence, n, n2, g.h()));
        }
        return g.d() == 2;
    }
    
    private static boolean f(final int n, final int n2) {
        return n == -1 || n2 == -1 || n != n2;
    }
    
    private static boolean g(final KeyEvent keyEvent) {
        return KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) ^ true;
    }
    
    CharSequence h(final CharSequence charSequence, int n, int max, int n2, final boolean b) {
        final boolean b2 = charSequence instanceof n;
        if (b2) {
            ((n)charSequence).a();
        }
        final Spannable spannable = null;
        Label_0085: {
            if (b2) {
                break Label_0085;
            }
            try {
                Object o;
                if (charSequence instanceof Spannable) {
                    o = new p((Spannable)charSequence);
                }
                else {
                    o = spannable;
                    if (charSequence instanceof Spanned) {
                        o = spannable;
                        if (((Spanned)charSequence).nextSpanTransition(n - 1, max + 1, (Class)i.class) <= max) {
                            o = new p(charSequence);
                        }
                    }
                }
                int n3 = n;
                int n4 = max;
                if (o != null) {
                    final i[] array = ((p)o).getSpans(n, max, i.class);
                    n3 = n;
                    n4 = max;
                    if (array != null) {
                        n3 = n;
                        n4 = max;
                        if (array.length > 0) {
                            final int length = array.length;
                            int n5 = 0;
                            while (true) {
                                n3 = n;
                                n4 = max;
                                if (n5 >= length) {
                                    break;
                                }
                                final i i = array[n5];
                                final int spanStart = ((p)o).getSpanStart(i);
                                final int spanEnd = ((p)o).getSpanEnd(i);
                                if (spanStart != max) {
                                    ((p)o).removeSpan(i);
                                }
                                n = Math.min(spanStart, n);
                                max = Math.max(spanEnd, max);
                                ++n5;
                            }
                        }
                    }
                }
                if (n3 == n4 || n3 >= charSequence.length()) {
                    return charSequence;
                }
                int n6;
                if ((n6 = n2) != Integer.MAX_VALUE) {
                    n6 = n2;
                    if (o != null) {
                        n6 = n2 - ((p)o).getSpans(0, ((p)o).length(), i.class).length;
                    }
                }
                final b b3 = new b(this.b.f(), this.d, this.e);
                int codePoint = Character.codePointAt(charSequence, n3);
                n2 = 0;
                int n7 = 0;
            Label_0325:
                while (true) {
                    n7 = n3;
                    max = n3;
                    n = codePoint;
                    while (max < n4 && n2 < n6) {
                        final int a = b3.a(n);
                        if (a != 1) {
                            if (a != 2) {
                                if (a != 3) {
                                    continue;
                                }
                                if (!b) {
                                    codePoint = n;
                                    n3 = max;
                                    if (this.e(charSequence, n7, max, b3.c())) {
                                        continue Label_0325;
                                    }
                                }
                                p p5;
                                if ((p5 = (p)o) == null) {
                                    p5 = new p((Spannable)new SpannableString(charSequence));
                                }
                                this.a((Spannable)p5, b3.c(), n7, max);
                                ++n2;
                                o = p5;
                                codePoint = n;
                                n3 = max;
                                continue Label_0325;
                            }
                            else {
                                final int n8 = max + Character.charCount(n);
                                if ((max = n8) >= n4) {
                                    continue;
                                }
                                n = Character.codePointAt(charSequence, n8);
                                max = n8;
                            }
                        }
                        else {
                            n7 += Character.charCount(Character.codePointAt(charSequence, n7));
                            if (n7 < n4) {
                                n = Character.codePointAt(charSequence, n7);
                            }
                            max = n7;
                        }
                    }
                    break;
                }
                p p6 = (p)o;
                Label_0613: {
                    if (b3.e()) {
                        p6 = (p)o;
                        if (n2 < n6) {
                            if (!b) {
                                p6 = (p)o;
                                if (this.e(charSequence, n7, max, b3.b())) {
                                    break Label_0613;
                                }
                            }
                            if ((p6 = (p)o) == null) {
                                p6 = new p(charSequence);
                            }
                            this.a((Spannable)p6, b3.b(), n7, max);
                        }
                    }
                }
                if (p6 != null) {
                    return (CharSequence)p6.b();
                }
                return charSequence;
            }
            finally {
                if (b2) {
                    ((n)charSequence).d();
                }
            }
        }
    }
    
    private static final class a
    {
        static int a(final CharSequence charSequence, int n, int i) {
            final int length = charSequence.length();
            if (n < 0 || length < n) {
                return -1;
            }
            if (i < 0) {
                return -1;
            }
        Label_0027:
            while (true) {
                int n2 = 0;
                while (i != 0) {
                    if (--n < 0) {
                        if (n2 != 0) {
                            return -1;
                        }
                        return 0;
                    }
                    else {
                        final char char1 = charSequence.charAt(n);
                        if (n2 != 0) {
                            if (!Character.isHighSurrogate(char1)) {
                                return -1;
                            }
                            --i;
                            continue Label_0027;
                        }
                        else if (!Character.isSurrogate(char1)) {
                            --i;
                        }
                        else {
                            if (Character.isHighSurrogate(char1)) {
                                return -1;
                            }
                            n2 = 1;
                        }
                    }
                }
                return n;
            }
        }
        
        static int b(final CharSequence charSequence, int n, int i) {
            final int length = charSequence.length();
            if (n < 0 || length < n) {
                return -1;
            }
            if (i < 0) {
                return -1;
            }
        Label_0027:
            while (true) {
                int n2 = 0;
                while (i != 0) {
                    if (n >= length) {
                        if (n2 != 0) {
                            return -1;
                        }
                        return length;
                    }
                    else {
                        final char char1 = charSequence.charAt(n);
                        if (n2 != 0) {
                            if (!Character.isLowSurrogate(char1)) {
                                return -1;
                            }
                            --i;
                            ++n;
                            continue Label_0027;
                        }
                        else if (!Character.isSurrogate(char1)) {
                            --i;
                            ++n;
                        }
                        else {
                            if (Character.isLowSurrogate(char1)) {
                                return -1;
                            }
                            ++n;
                            n2 = 1;
                        }
                    }
                }
                return n;
            }
        }
    }
    
    static final class b
    {
        private int a;
        private final m.a b;
        private m.a c;
        private m.a d;
        private int e;
        private int f;
        private final boolean g;
        private final int[] h;
        
        b(final m.a a, final boolean g, final int[] h) {
            this.a = 1;
            this.b = a;
            this.c = a;
            this.g = g;
            this.h = h;
        }
        
        private static boolean d(final int n) {
            return n == 65039;
        }
        
        private static boolean f(final int n) {
            return n == 65038;
        }
        
        private int g() {
            this.a = 1;
            this.c = this.b;
            this.f = 0;
            return 1;
        }
        
        private boolean h() {
            if (this.c.b().j()) {
                return true;
            }
            if (d(this.e)) {
                return true;
            }
            if (this.g) {
                if (this.h == null) {
                    return true;
                }
                if (Arrays.binarySearch(this.h, this.c.b().b(0)) < 0) {
                    return true;
                }
            }
            return false;
        }
        
        int a(final int e) {
            final m.a a = this.c.a(e);
            final int a2 = this.a;
            int n = 3;
            Label_0175: {
                if (a2 != 2) {
                    if (a == null) {
                        n = this.g();
                        break Label_0175;
                    }
                    this.a = 2;
                    this.c = a;
                    this.f = 1;
                }
                else if (a != null) {
                    this.c = a;
                    ++this.f;
                }
                else {
                    if (f(e)) {
                        n = this.g();
                        break Label_0175;
                    }
                    if (!d(e)) {
                        if (this.c.b() == null) {
                            n = this.g();
                            break Label_0175;
                        }
                        if (this.f != 1) {
                            this.d = this.c;
                            this.g();
                            break Label_0175;
                        }
                        if (this.h()) {
                            this.d = this.c;
                            this.g();
                            break Label_0175;
                        }
                        n = this.g();
                        break Label_0175;
                    }
                }
                n = 2;
            }
            this.e = e;
            return n;
        }
        
        g b() {
            return this.c.b();
        }
        
        g c() {
            return this.d.b();
        }
        
        boolean e() {
            final int a = this.a;
            final boolean b = true;
            if (a == 2 && this.c.b() != null) {
                boolean b2 = b;
                if (this.f > 1) {
                    return b2;
                }
                if (this.h()) {
                    b2 = b;
                    return b2;
                }
            }
            return false;
        }
    }
}
