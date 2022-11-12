// 
// Decompiled by Procyon v0.6.0
// 

package androidx.constraintlayout.motion.widget;

import android.view.View$OnClickListener;
import android.util.AttributeSet;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.View;
import android.view.ViewGroup;
import android.graphics.RectF;
import java.util.List;
import java.util.Iterator;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.content.res.TypedArray;
import androidx.constraintlayout.widget.h;
import android.util.Xml;
import java.io.PrintStream;
import android.content.res.XmlResourceParser;
import org.xmlpull.v1.XmlPullParserException;
import java.io.IOException;
import android.util.Log;
import org.xmlpull.v1.XmlPullParser;
import androidx.constraintlayout.widget.g;
import android.content.Context;
import android.view.MotionEvent;
import android.util.SparseIntArray;
import java.util.HashMap;
import androidx.constraintlayout.widget.c;
import android.util.SparseArray;
import java.util.ArrayList;
import androidx.constraintlayout.widget.j;

public class q
{
    private final MotionLayout a;
    j b;
    b c;
    private boolean d;
    private ArrayList<b> e;
    private b f;
    private ArrayList<b> g;
    private SparseArray<c> h;
    private HashMap<String, Integer> i;
    private SparseIntArray j;
    private boolean k;
    private int l;
    private int m;
    private MotionEvent n;
    private boolean o;
    private boolean p;
    private MotionLayout.f q;
    private boolean r;
    final u s;
    float t;
    float u;
    
    q(final Context context, final MotionLayout a, int a2) {
        this.b = null;
        this.c = null;
        this.d = false;
        this.e = new ArrayList<b>();
        this.f = null;
        this.g = new ArrayList<b>();
        this.h = (SparseArray<c>)new SparseArray();
        this.i = new HashMap<String, Integer>();
        this.j = new SparseIntArray();
        this.k = false;
        this.l = 400;
        this.m = 0;
        this.o = false;
        this.p = false;
        this.a = a;
        this.s = new u(a);
        this.G(context, a2);
        final SparseArray<c> h = this.h;
        a2 = androidx.constraintlayout.widget.g.a;
        h.put(a2, (Object)new c());
        this.i.put("motion_base", a2);
    }
    
    private boolean E(final int n) {
        for (int i = this.j.get(n), size = this.j.size(); i > 0; i = this.j.get(i), --size) {
            if (i == n) {
                return true;
            }
            if (size < 0) {
                return true;
            }
        }
        return false;
    }
    
    private boolean F() {
        return this.q != null;
    }
    
    private void G(final Context context, final int n) {
        final XmlResourceParser xml = context.getResources().getXml(n);
        b b = null;
        try {
            int n2 = ((XmlPullParser)xml).getEventType();
            while (true) {
                final int n3 = 1;
                if (n2 == 1) {
                    break;
                }
                b b2;
                if (n2 != 0) {
                    if (n2 != 2) {
                        b2 = b;
                    }
                    else {
                        final String name = ((XmlPullParser)xml).getName();
                        if (this.k) {
                            final PrintStream out = System.out;
                            final StringBuilder sb = new StringBuilder();
                            sb.append("parsing = ");
                            sb.append(name);
                            out.println(sb.toString());
                        }
                        int n4 = 0;
                        Label_0360: {
                            switch (name.hashCode()) {
                                case 1942574248: {
                                    if (name.equals("include")) {
                                        n4 = 6;
                                        break Label_0360;
                                    }
                                    break;
                                }
                                case 1382829617: {
                                    if (name.equals("StateSet")) {
                                        n4 = 4;
                                        break Label_0360;
                                    }
                                    break;
                                }
                                case 793277014: {
                                    if (name.equals("MotionScene")) {
                                        n4 = 0;
                                        break Label_0360;
                                    }
                                    break;
                                }
                                case 327855227: {
                                    if (name.equals("OnSwipe")) {
                                        n4 = 2;
                                        break Label_0360;
                                    }
                                    break;
                                }
                                case 312750793: {
                                    if (name.equals("OnClick")) {
                                        n4 = 3;
                                        break Label_0360;
                                    }
                                    break;
                                }
                                case 269306229: {
                                    if (name.equals("Transition")) {
                                        n4 = n3;
                                        break Label_0360;
                                    }
                                    break;
                                }
                                case 61998586: {
                                    if (name.equals("ViewTransition")) {
                                        n4 = 9;
                                        break Label_0360;
                                    }
                                    break;
                                }
                                case -687739768: {
                                    if (name.equals("Include")) {
                                        n4 = 7;
                                        break Label_0360;
                                    }
                                    break;
                                }
                                case -1239391468: {
                                    if (name.equals("KeyFrameSet")) {
                                        n4 = 8;
                                        break Label_0360;
                                    }
                                    break;
                                }
                                case -1349929691: {
                                    if (name.equals("ConstraintSet")) {
                                        n4 = 5;
                                        break Label_0360;
                                    }
                                    break;
                                }
                            }
                            n4 = -1;
                        }
                        switch (n4) {
                            default: {
                                b2 = b;
                                break;
                            }
                            case 9: {
                                this.s.a(new t(context, (XmlPullParser)xml));
                                b2 = b;
                                break;
                            }
                            case 8: {
                                final androidx.constraintlayout.motion.widget.g g = new androidx.constraintlayout.motion.widget.g(context, (XmlPullParser)xml);
                                b2 = b;
                                if (b != null) {
                                    androidx.constraintlayout.motion.widget.q.b.f(b).add(g);
                                    b2 = b;
                                    break;
                                }
                                break;
                            }
                            case 6:
                            case 7: {
                                this.J(context, (XmlPullParser)xml);
                                b2 = b;
                                break;
                            }
                            case 5: {
                                this.H(context, (XmlPullParser)xml);
                                b2 = b;
                                break;
                            }
                            case 4: {
                                this.b = new j(context, (XmlPullParser)xml);
                                b2 = b;
                                break;
                            }
                            case 3: {
                                b2 = b;
                                if (b != null) {
                                    b.s(context, (XmlPullParser)xml);
                                    b2 = b;
                                    break;
                                }
                                break;
                            }
                            case 2: {
                                if (b == null) {
                                    final String resourceEntryName = context.getResources().getResourceEntryName(n);
                                    final int lineNumber = ((XmlPullParser)xml).getLineNumber();
                                    final StringBuilder sb2 = new StringBuilder();
                                    sb2.append(" OnSwipe (");
                                    sb2.append(resourceEntryName);
                                    sb2.append(".xml:");
                                    sb2.append(lineNumber);
                                    sb2.append(")");
                                    Log.v("MotionScene", sb2.toString());
                                }
                                if ((b2 = b) != null) {
                                    androidx.constraintlayout.motion.widget.q.b.l(b, new r(context, this.a, (XmlPullParser)xml));
                                    b2 = b;
                                    break;
                                }
                                break;
                            }
                            case 1: {
                                final ArrayList<b> e = this.e;
                                b2 = new b(this, context, (XmlPullParser)xml);
                                e.add(b2);
                                if (this.c == null && !androidx.constraintlayout.motion.widget.q.b.e(b2)) {
                                    this.c = b2;
                                    if (androidx.constraintlayout.motion.widget.q.b.k(b2) != null) {
                                        androidx.constraintlayout.motion.widget.q.b.k(this.c).x(this.r);
                                    }
                                }
                                if (androidx.constraintlayout.motion.widget.q.b.e(b2)) {
                                    if (androidx.constraintlayout.motion.widget.q.b.a(b2) == -1) {
                                        this.f = b2;
                                    }
                                    else {
                                        this.g.add(b2);
                                    }
                                    this.e.remove(b2);
                                }
                                break;
                            }
                            case 0: {
                                this.K(context, (XmlPullParser)xml);
                                b2 = b;
                                break;
                            }
                        }
                    }
                }
                else {
                    ((XmlPullParser)xml).getName();
                    b2 = b;
                }
                n2 = ((XmlPullParser)xml).next();
                b = b2;
            }
        }
        catch (final IOException ex) {
            ex.printStackTrace();
        }
        catch (final XmlPullParserException ex2) {
            ex2.printStackTrace();
        }
    }
    
    private int H(final Context context, final XmlPullParser xmlPullParser) {
        final c c = new c();
        c.M(false);
        final int attributeCount = xmlPullParser.getAttributeCount();
        int i = 0;
        int p2 = -1;
        int p3 = -1;
        while (i < attributeCount) {
            final String attributeName = xmlPullParser.getAttributeName(i);
            final String attributeValue = xmlPullParser.getAttributeValue(i);
            if (this.k) {
                final PrintStream out = System.out;
                final StringBuilder sb = new StringBuilder();
                sb.append("id string = ");
                sb.append(attributeValue);
                out.println(sb.toString());
            }
            attributeName.hashCode();
            int n = 0;
            Label_0211: {
                switch (attributeName) {
                    case "id": {
                        n = 2;
                        break Label_0211;
                    }
                    case "constraintRotate": {
                        n = 1;
                        break Label_0211;
                    }
                    case "deriveConstraintsFrom": {
                        n = 0;
                        break Label_0211;
                    }
                    default:
                        break;
                }
                n = -1;
            }
            switch (n) {
                case 2: {
                    p2 = this.p(context, attributeValue);
                    this.i.put(W(attributeValue), p2);
                    c.b = androidx.constraintlayout.motion.widget.a.b(context, p2);
                    break;
                }
                case 1: {
                    try {
                        c.d = Integer.parseInt(attributeValue);
                    }
                    catch (final NumberFormatException ex) {
                        attributeValue.hashCode();
                        int n2 = 0;
                        Label_0457: {
                            switch (attributeValue) {
                                case "x_right": {
                                    n2 = 4;
                                    break Label_0457;
                                }
                                case "right": {
                                    n2 = 3;
                                    break Label_0457;
                                }
                                case "none": {
                                    n2 = 2;
                                    break Label_0457;
                                }
                                case "left": {
                                    n2 = 1;
                                    break Label_0457;
                                }
                                case "x_left": {
                                    n2 = 0;
                                    break Label_0457;
                                }
                                default:
                                    break;
                            }
                            n2 = -1;
                        }
                        switch (n2) {
                            case 4: {
                                c.d = 3;
                                break;
                            }
                            case 3: {
                                c.d = 1;
                                break;
                            }
                            case 2: {
                                c.d = 0;
                                break;
                            }
                            case 1: {
                                c.d = 2;
                                break;
                            }
                            case 0: {
                                c.d = 4;
                                break;
                            }
                        }
                    }
                    break;
                }
                case 0: {
                    p3 = this.p(context, attributeValue);
                    break;
                }
            }
            ++i;
        }
        if (p2 != -1) {
            if (this.a.H != 0) {
                c.P(true);
            }
            c.y(context, xmlPullParser);
            if (p3 != -1) {
                this.j.put(p2, p3);
            }
            this.h.put(p2, (Object)c);
        }
        return p2;
    }
    
    private int I(final Context context, int i) {
        final XmlResourceParser xml = context.getResources().getXml(i);
        try {
            String name;
            for (i = ((XmlPullParser)xml).getEventType(); i != 1; i = ((XmlPullParser)xml).next()) {
                name = ((XmlPullParser)xml).getName();
                if (2 == i && "ConstraintSet".equals(name)) {
                    return this.H(context, (XmlPullParser)xml);
                }
            }
            return -1;
        }
        catch (final IOException ex) {
            ex.printStackTrace();
        }
        catch (final XmlPullParserException ex2) {
            ex2.printStackTrace();
        }
        return -1;
    }
    
    private void J(final Context context, final XmlPullParser xmlPullParser) {
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), androidx.constraintlayout.widget.h.fa);
        for (int indexCount = obtainStyledAttributes.getIndexCount(), i = 0; i < indexCount; ++i) {
            final int index = obtainStyledAttributes.getIndex(i);
            if (index == androidx.constraintlayout.widget.h.ga) {
                this.I(context, obtainStyledAttributes.getResourceId(index, -1));
            }
        }
        obtainStyledAttributes.recycle();
    }
    
    private void K(final Context context, final XmlPullParser xmlPullParser) {
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), androidx.constraintlayout.widget.h.l8);
        for (int indexCount = obtainStyledAttributes.getIndexCount(), i = 0; i < indexCount; ++i) {
            final int index = obtainStyledAttributes.getIndex(i);
            if (index == androidx.constraintlayout.widget.h.m8) {
                if ((this.l = obtainStyledAttributes.getInt(index, this.l)) < 8) {
                    this.l = 8;
                }
            }
            else if (index == androidx.constraintlayout.widget.h.n8) {
                this.m = obtainStyledAttributes.getInteger(index, 0);
            }
        }
        obtainStyledAttributes.recycle();
    }
    
    private void O(int value, final MotionLayout motionLayout) {
        final c c = (c)this.h.get(value);
        c.c = c.b;
        value = this.j.get(value);
        if (value > 0) {
            this.O(value, motionLayout);
            final c c2 = (c)this.h.get(value);
            if (c2 == null) {
                final StringBuilder sb = new StringBuilder();
                sb.append("ERROR! invalid deriveConstraintsFrom: @id/");
                sb.append(androidx.constraintlayout.motion.widget.a.b(this.a.getContext(), value));
                Log.e("MotionScene", sb.toString());
                return;
            }
            final StringBuilder sb2 = new StringBuilder();
            sb2.append(c.c);
            sb2.append("/");
            sb2.append(c2.c);
            c.c = sb2.toString();
            c.G(c2);
        }
        else {
            final StringBuilder sb3 = new StringBuilder();
            sb3.append(c.c);
            sb3.append("  layout");
            c.c = sb3.toString();
            c.F(motionLayout);
        }
        c.h(c);
    }
    
    public static String W(final String s) {
        if (s == null) {
            return "";
        }
        final int index = s.indexOf(47);
        if (index < 0) {
            return s;
        }
        return s.substring(index + 1);
    }
    
    static int a(final q q) {
        return q.m;
    }
    
    static SparseArray b(final q q) {
        return q.h;
    }
    
    static int c(final q q, final Context context, final int n) {
        return q.I(context, n);
    }
    
    static MotionLayout d(final q q) {
        return q.a;
    }
    
    static int e(final q q) {
        return q.l;
    }
    
    private int p(final Context context, final String s) {
        int identifier;
        if (s.contains("/")) {
            final int n = identifier = context.getResources().getIdentifier(s.substring(s.indexOf(47) + 1), "id", context.getPackageName());
            if (this.k) {
                final PrintStream out = System.out;
                final StringBuilder sb = new StringBuilder();
                sb.append("id getMap res = ");
                sb.append(n);
                out.println(sb.toString());
                identifier = n;
            }
        }
        else {
            identifier = -1;
        }
        int int1;
        if ((int1 = identifier) == -1) {
            if (s.length() > 1) {
                int1 = Integer.parseInt(s.substring(1));
            }
            else {
                Log.e("MotionScene", "error in parsing id");
                int1 = identifier;
            }
        }
        return int1;
    }
    
    private int v(final int n) {
        final j b = this.b;
        if (b != null) {
            final int c = b.c(n, -1, -1);
            if (c != -1) {
                return c;
            }
        }
        return n;
    }
    
    float A() {
        final b c = this.c;
        if (c != null && androidx.constraintlayout.motion.widget.q.b.k(c) != null) {
            return androidx.constraintlayout.motion.widget.q.b.k(this.c).o();
        }
        return 0.0f;
    }
    
    int B() {
        final b c = this.c;
        if (c == null) {
            return -1;
        }
        return androidx.constraintlayout.motion.widget.q.b.c(c);
    }
    
    public b C(final int n) {
        for (final b b : this.e) {
            if (androidx.constraintlayout.motion.widget.q.b.m(b) == n) {
                return b;
            }
        }
        return null;
    }
    
    public List<b> D(int v) {
        v = this.v(v);
        final ArrayList list = new ArrayList();
        for (final b b : this.e) {
            if (androidx.constraintlayout.motion.widget.q.b.c(b) == v || androidx.constraintlayout.motion.widget.q.b.a(b) == v) {
                list.add(b);
            }
        }
        return list;
    }
    
    void L(final float n, final float n2) {
        final b c = this.c;
        if (c != null && androidx.constraintlayout.motion.widget.q.b.k(c) != null) {
            androidx.constraintlayout.motion.widget.q.b.k(this.c).u(n, n2);
        }
    }
    
    void M(final float n, final float n2) {
        final b c = this.c;
        if (c != null && androidx.constraintlayout.motion.widget.q.b.k(c) != null) {
            androidx.constraintlayout.motion.widget.q.b.k(this.c).v(n, n2);
        }
    }
    
    void N(final MotionEvent n, int f, final MotionLayout motionLayout) {
        final RectF rectF = new RectF();
        if (this.q == null) {
            this.q = this.a.y();
        }
        this.q.c(n);
        Label_0395: {
            if (f != -1) {
                final int action = n.getAction();
                final boolean b = false;
                if (action == 0) {
                    this.t = n.getRawX();
                    this.u = n.getRawY();
                    this.n = n;
                    this.o = false;
                    if (androidx.constraintlayout.motion.widget.q.b.k(this.c) != null) {
                        final RectF f2 = androidx.constraintlayout.motion.widget.q.b.k(this.c).f(this.a, rectF);
                        if (f2 != null && !f2.contains(this.n.getX(), this.n.getY())) {
                            this.n = null;
                            this.o = true;
                            return;
                        }
                        final RectF p3 = androidx.constraintlayout.motion.widget.q.b.k(this.c).p(this.a, rectF);
                        if (p3 != null && !p3.contains(this.n.getX(), this.n.getY())) {
                            this.p = true;
                        }
                        else {
                            this.p = false;
                        }
                        androidx.constraintlayout.motion.widget.q.b.k(this.c).w(this.t, this.u);
                    }
                    return;
                }
                if (action == 2) {
                    if (!this.o) {
                        final float n2 = n.getRawY() - this.u;
                        final float n3 = n.getRawX() - this.t;
                        if (n3 != 0.0 || n2 != 0.0) {
                            final MotionEvent n4 = this.n;
                            if (n4 != null) {
                                final b h = this.h(f, n3, n2, n4);
                                if (h != null) {
                                    motionLayout.setTransition(h);
                                    final RectF p4 = androidx.constraintlayout.motion.widget.q.b.k(this.c).p(this.a, rectF);
                                    boolean p5 = b;
                                    if (p4 != null) {
                                        p5 = b;
                                        if (!p4.contains(this.n.getX(), this.n.getY())) {
                                            p5 = true;
                                        }
                                    }
                                    this.p = p5;
                                    androidx.constraintlayout.motion.widget.q.b.k(this.c).y(this.t, this.u);
                                }
                                break Label_0395;
                            }
                        }
                        return;
                    }
                }
            }
        }
        if (this.o) {
            return;
        }
        final b c = this.c;
        if (c != null && androidx.constraintlayout.motion.widget.q.b.k(c) != null && !this.p) {
            androidx.constraintlayout.motion.widget.q.b.k(this.c).s(n, this.q, f, this);
        }
        this.t = n.getRawX();
        this.u = n.getRawY();
        if (n.getAction() == 1) {
            final MotionLayout.f q = this.q;
            if (q != null) {
                q.b();
                this.q = null;
                f = motionLayout.f;
                if (f != -1) {
                    this.g(motionLayout, f);
                }
            }
        }
    }
    
    void P(final MotionLayout motionLayout) {
        for (int i = 0; i < this.h.size(); ++i) {
            final int key = this.h.keyAt(i);
            if (this.E(key)) {
                Log.e("MotionScene", "Cannot be derived from yourself");
                return;
            }
            this.O(key, motionLayout);
        }
    }
    
    public void Q(final int n, final c c) {
        this.h.put(n, (Object)c);
    }
    
    public void R(final int l) {
        final b c = this.c;
        if (c != null) {
            c.C(l);
        }
        else {
            this.l = l;
        }
    }
    
    public void S(final boolean r) {
        this.r = r;
        final b c = this.c;
        if (c != null && androidx.constraintlayout.motion.widget.q.b.k(c) != null) {
            androidx.constraintlayout.motion.widget.q.b.k(this.c).x(this.r);
        }
    }
    
    void T(final int n, final int n2) {
        final j b = this.b;
        int n3 = 0;
        int n4 = 0;
        Label_0065: {
            if (b != null) {
                int c = b.c(n, -1, -1);
                if (c == -1) {
                    c = n;
                }
                final int c2 = this.b.c(n2, -1, -1);
                n3 = c;
                if (c2 != -1) {
                    n3 = c;
                    n4 = c2;
                    break Label_0065;
                }
            }
            else {
                n3 = n;
            }
            n4 = n2;
        }
        final b c3 = this.c;
        if (c3 != null && androidx.constraintlayout.motion.widget.q.b.a(c3) == n2 && androidx.constraintlayout.motion.widget.q.b.c(this.c) == n) {
            return;
        }
        for (final b c4 : this.e) {
            if ((androidx.constraintlayout.motion.widget.q.b.a(c4) == n4 && androidx.constraintlayout.motion.widget.q.b.c(c4) == n3) || (androidx.constraintlayout.motion.widget.q.b.a(c4) == n2 && androidx.constraintlayout.motion.widget.q.b.c(c4) == n)) {
                this.c = c4;
                if (c4 != null && androidx.constraintlayout.motion.widget.q.b.k(c4) != null) {
                    androidx.constraintlayout.motion.widget.q.b.k(this.c).x(this.r);
                }
                return;
            }
        }
        b f = this.f;
        for (final b b2 : this.g) {
            if (androidx.constraintlayout.motion.widget.q.b.a(b2) == n2) {
                f = b2;
            }
        }
        final b c5 = new b(this, f);
        androidx.constraintlayout.motion.widget.q.b.d(c5, n3);
        androidx.constraintlayout.motion.widget.q.b.b(c5, n4);
        if (n3 != -1) {
            this.e.add(c5);
        }
        this.c = c5;
    }
    
    public void U(final b c) {
        this.c = c;
        if (c != null && androidx.constraintlayout.motion.widget.q.b.k(c) != null) {
            androidx.constraintlayout.motion.widget.q.b.k(this.c).x(this.r);
        }
    }
    
    void V() {
        final b c = this.c;
        if (c != null && androidx.constraintlayout.motion.widget.q.b.k(c) != null) {
            androidx.constraintlayout.motion.widget.q.b.k(this.c).z();
        }
    }
    
    boolean X() {
        final Iterator<b> iterator = this.e.iterator();
        do {
            final boolean hasNext = iterator.hasNext();
            boolean b = true;
            if (hasNext) {
                continue;
            }
            final b c = this.c;
            if (c == null || androidx.constraintlayout.motion.widget.q.b.k(c) == null) {
                b = false;
            }
            return b;
        } while (androidx.constraintlayout.motion.widget.q.b.k(iterator.next()) == null);
        return true;
    }
    
    public void Y(final int n, final View... array) {
        this.s.h(n, array);
    }
    
    public void f(final MotionLayout motionLayout, final int n) {
        for (final b b : this.e) {
            if (androidx.constraintlayout.motion.widget.q.b.n(b).size() > 0) {
                final Iterator iterator2 = androidx.constraintlayout.motion.widget.q.b.n(b).iterator();
                while (iterator2.hasNext()) {
                    ((b.a)iterator2.next()).c(motionLayout);
                }
            }
        }
        for (final b b2 : this.g) {
            if (androidx.constraintlayout.motion.widget.q.b.n(b2).size() > 0) {
                final Iterator iterator4 = androidx.constraintlayout.motion.widget.q.b.n(b2).iterator();
                while (iterator4.hasNext()) {
                    ((b.a)iterator4.next()).c(motionLayout);
                }
            }
        }
        for (final b b3 : this.e) {
            if (androidx.constraintlayout.motion.widget.q.b.n(b3).size() > 0) {
                final Iterator iterator6 = androidx.constraintlayout.motion.widget.q.b.n(b3).iterator();
                while (iterator6.hasNext()) {
                    ((b.a)iterator6.next()).a(motionLayout, n, b3);
                }
            }
        }
        for (final b b4 : this.g) {
            if (androidx.constraintlayout.motion.widget.q.b.n(b4).size() > 0) {
                final Iterator iterator8 = androidx.constraintlayout.motion.widget.q.b.n(b4).iterator();
                while (iterator8.hasNext()) {
                    ((b.a)iterator8.next()).a(motionLayout, n, b4);
                }
            }
        }
    }
    
    boolean g(final MotionLayout motionLayout, final int n) {
        if (this.F()) {
            return false;
        }
        if (this.d) {
            return false;
        }
        for (final b b : this.e) {
            if (androidx.constraintlayout.motion.widget.q.b.p(b) == 0) {
                continue;
            }
            final b c = this.c;
            if (c == b && c.B(2)) {
                continue;
            }
            if (n == androidx.constraintlayout.motion.widget.q.b.c(b) && (androidx.constraintlayout.motion.widget.q.b.p(b) == 4 || androidx.constraintlayout.motion.widget.q.b.p(b) == 2)) {
                final MotionLayout.TransitionState finished = MotionLayout.TransitionState.FINISHED;
                motionLayout.setState(finished);
                motionLayout.setTransition(b);
                if (androidx.constraintlayout.motion.widget.q.b.p(b) == 4) {
                    motionLayout.F();
                    motionLayout.setState(MotionLayout.TransitionState.SETUP);
                    motionLayout.setState(MotionLayout.TransitionState.MOVING);
                }
                else {
                    motionLayout.setProgress(1.0f);
                    motionLayout.h(true);
                    motionLayout.setState(MotionLayout.TransitionState.SETUP);
                    motionLayout.setState(MotionLayout.TransitionState.MOVING);
                    motionLayout.setState(finished);
                    motionLayout.z();
                }
                return true;
            }
            if (n == androidx.constraintlayout.motion.widget.q.b.a(b) && (androidx.constraintlayout.motion.widget.q.b.p(b) == 3 || androidx.constraintlayout.motion.widget.q.b.p(b) == 1)) {
                final MotionLayout.TransitionState finished2 = MotionLayout.TransitionState.FINISHED;
                motionLayout.setState(finished2);
                motionLayout.setTransition(b);
                if (androidx.constraintlayout.motion.widget.q.b.p(b) == 3) {
                    motionLayout.H();
                    motionLayout.setState(MotionLayout.TransitionState.SETUP);
                    motionLayout.setState(MotionLayout.TransitionState.MOVING);
                }
                else {
                    motionLayout.setProgress(0.0f);
                    motionLayout.h(true);
                    motionLayout.setState(MotionLayout.TransitionState.SETUP);
                    motionLayout.setState(MotionLayout.TransitionState.MOVING);
                    motionLayout.setState(finished2);
                    motionLayout.z();
                }
                return true;
            }
        }
        return false;
    }
    
    public b h(final int n, final float n2, final float n3, final MotionEvent motionEvent) {
        if (n != -1) {
            final List<b> d = this.D(n);
            float n4 = 0.0f;
            b b = null;
            final RectF rectF = new RectF();
            for (final b b2 : d) {
                if (androidx.constraintlayout.motion.widget.q.b.o(b2)) {
                    continue;
                }
                if (androidx.constraintlayout.motion.widget.q.b.k(b2) == null) {
                    continue;
                }
                androidx.constraintlayout.motion.widget.q.b.k(b2).x(this.r);
                final RectF p4 = androidx.constraintlayout.motion.widget.q.b.k(b2).p(this.a, rectF);
                if (p4 != null && motionEvent != null && !p4.contains(motionEvent.getX(), motionEvent.getY())) {
                    continue;
                }
                final RectF f = androidx.constraintlayout.motion.widget.q.b.k(b2).f(this.a, rectF);
                if (f != null && motionEvent != null && !f.contains(motionEvent.getX(), motionEvent.getY())) {
                    continue;
                }
                float a = androidx.constraintlayout.motion.widget.q.b.k(b2).a(n2, n3);
                if (androidx.constraintlayout.motion.widget.q.b.k(b2).l) {
                    a = a;
                    if (motionEvent != null) {
                        final float n5 = motionEvent.getX() - androidx.constraintlayout.motion.widget.q.b.k(b2).i;
                        final float n6 = motionEvent.getY() - androidx.constraintlayout.motion.widget.q.b.k(b2).j;
                        a = (float)(Math.atan2(n3 + n6, n2 + n5) - Math.atan2(n5, n6)) * 10.0f;
                    }
                }
                float n7;
                if (androidx.constraintlayout.motion.widget.q.b.a(b2) == n) {
                    n7 = -1.0f;
                }
                else {
                    n7 = 1.1f;
                }
                final float n8 = a * n7;
                if (n8 <= n4) {
                    continue;
                }
                b = b2;
                n4 = n8;
            }
            return b;
        }
        return this.c;
    }
    
    int i() {
        final b c = this.c;
        if (c != null && androidx.constraintlayout.motion.widget.q.b.k(c) != null) {
            return androidx.constraintlayout.motion.widget.q.b.k(this.c).d();
        }
        return 0;
    }
    
    c j(final int n) {
        return this.k(n, -1, -1);
    }
    
    c k(final int n, int c, final int n2) {
        if (this.k) {
            final PrintStream out = System.out;
            final StringBuilder sb = new StringBuilder();
            sb.append("id ");
            sb.append(n);
            out.println(sb.toString());
            final PrintStream out2 = System.out;
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("size ");
            sb2.append(this.h.size());
            out2.println(sb2.toString());
        }
        final j b = this.b;
        int n3 = n;
        if (b != null) {
            c = b.c(n, c, n2);
            n3 = n;
            if (c != -1) {
                n3 = c;
            }
        }
        if (this.h.get(n3) == null) {
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("Warning could not find ConstraintSet id/");
            sb3.append(androidx.constraintlayout.motion.widget.a.b(this.a.getContext(), n3));
            sb3.append(" In MotionScene");
            Log.e("MotionScene", sb3.toString());
            final SparseArray<c> h = this.h;
            return (c)h.get(h.keyAt(0));
        }
        return (c)this.h.get(n3);
    }
    
    public int[] l() {
        final int size = this.h.size();
        final int[] array = new int[size];
        for (int i = 0; i < size; ++i) {
            array[i] = this.h.keyAt(i);
        }
        return array;
    }
    
    public ArrayList<b> m() {
        return this.e;
    }
    
    public int n() {
        final b c = this.c;
        if (c != null) {
            return androidx.constraintlayout.motion.widget.q.b.j(c);
        }
        return this.l;
    }
    
    int o() {
        final b c = this.c;
        if (c == null) {
            return -1;
        }
        return androidx.constraintlayout.motion.widget.q.b.a(c);
    }
    
    public Interpolator q() {
        final int g = androidx.constraintlayout.motion.widget.q.b.g(this.c);
        if (g == -2) {
            return AnimationUtils.loadInterpolator(this.a.getContext(), androidx.constraintlayout.motion.widget.q.b.i(this.c));
        }
        if (g == -1) {
            return (Interpolator)new Interpolator(this, o.c.c(androidx.constraintlayout.motion.widget.q.b.h(this.c))) {
                final o.c a;
                
                public float getInterpolation(final float n) {
                    return (float)this.a.a(n);
                }
            };
        }
        if (g == 0) {
            return (Interpolator)new AccelerateDecelerateInterpolator();
        }
        if (g == 1) {
            return (Interpolator)new AccelerateInterpolator();
        }
        if (g == 2) {
            return (Interpolator)new DecelerateInterpolator();
        }
        if (g == 4) {
            return (Interpolator)new BounceInterpolator();
        }
        if (g == 5) {
            return (Interpolator)new OvershootInterpolator();
        }
        if (g != 6) {
            return null;
        }
        return (Interpolator)new AnticipateInterpolator();
    }
    
    float r() {
        final b c = this.c;
        if (c != null && androidx.constraintlayout.motion.widget.q.b.k(c) != null) {
            return androidx.constraintlayout.motion.widget.q.b.k(this.c).g();
        }
        return 0.0f;
    }
    
    float s() {
        final b c = this.c;
        if (c != null && androidx.constraintlayout.motion.widget.q.b.k(c) != null) {
            return androidx.constraintlayout.motion.widget.q.b.k(this.c).h();
        }
        return 0.0f;
    }
    
    boolean t() {
        final b c = this.c;
        return c != null && androidx.constraintlayout.motion.widget.q.b.k(c) != null && androidx.constraintlayout.motion.widget.q.b.k(this.c).i();
    }
    
    float u(final float n, final float n2) {
        final b c = this.c;
        if (c != null && androidx.constraintlayout.motion.widget.q.b.k(c) != null) {
            return androidx.constraintlayout.motion.widget.q.b.k(this.c).j(n, n2);
        }
        return 0.0f;
    }
    
    int w() {
        final b c = this.c;
        if (c != null && androidx.constraintlayout.motion.widget.q.b.k(c) != null) {
            return androidx.constraintlayout.motion.widget.q.b.k(this.c).k();
        }
        return 0;
    }
    
    float x() {
        final b c = this.c;
        if (c != null && androidx.constraintlayout.motion.widget.q.b.k(c) != null) {
            return androidx.constraintlayout.motion.widget.q.b.k(this.c).l();
        }
        return 0.0f;
    }
    
    float y() {
        final b c = this.c;
        if (c != null && androidx.constraintlayout.motion.widget.q.b.k(c) != null) {
            return androidx.constraintlayout.motion.widget.q.b.k(this.c).m();
        }
        return 0.0f;
    }
    
    float z() {
        final b c = this.c;
        if (c != null && androidx.constraintlayout.motion.widget.q.b.k(c) != null) {
            return androidx.constraintlayout.motion.widget.q.b.k(this.c).n();
        }
        return 0.0f;
    }
    
    public static class b
    {
        private int a;
        private boolean b;
        private int c;
        private int d;
        private int e;
        private String f;
        private int g;
        private int h;
        private float i;
        private final q j;
        private ArrayList<androidx.constraintlayout.motion.widget.g> k;
        private r l;
        private ArrayList<a> m;
        private int n;
        private boolean o;
        private int p;
        private int q;
        private int r;
        
        public b(final int a, final q j, final int d, final int c) {
            this.a = -1;
            this.b = false;
            this.c = -1;
            this.d = -1;
            this.e = 0;
            this.f = null;
            this.g = -1;
            this.h = 400;
            this.i = 0.0f;
            this.k = new ArrayList<androidx.constraintlayout.motion.widget.g>();
            this.l = null;
            this.m = new ArrayList<a>();
            this.n = 0;
            this.o = false;
            this.p = -1;
            this.q = 0;
            this.r = 0;
            this.a = a;
            this.j = j;
            this.d = d;
            this.c = c;
            this.h = q.e(j);
            this.q = q.a(j);
        }
        
        b(final q j, final Context context, final XmlPullParser xmlPullParser) {
            this.a = -1;
            this.b = false;
            this.c = -1;
            this.d = -1;
            this.e = 0;
            this.f = null;
            this.g = -1;
            this.h = 400;
            this.i = 0.0f;
            this.k = new ArrayList<androidx.constraintlayout.motion.widget.g>();
            this.l = null;
            this.m = new ArrayList<a>();
            this.n = 0;
            this.o = false;
            this.p = -1;
            this.q = 0;
            this.r = 0;
            this.h = q.e(j);
            this.q = q.a(j);
            this.u(this.j = j, context, Xml.asAttributeSet(xmlPullParser));
        }
        
        b(final q j, final b b) {
            this.a = -1;
            this.b = false;
            this.c = -1;
            this.d = -1;
            this.e = 0;
            this.f = null;
            this.g = -1;
            this.h = 400;
            this.i = 0.0f;
            this.k = new ArrayList<androidx.constraintlayout.motion.widget.g>();
            this.l = null;
            this.m = new ArrayList<a>();
            this.n = 0;
            this.o = false;
            this.p = -1;
            this.q = 0;
            this.r = 0;
            this.j = j;
            this.h = q.e(j);
            if (b != null) {
                this.p = b.p;
                this.e = b.e;
                this.f = b.f;
                this.g = b.g;
                this.h = b.h;
                this.k = b.k;
                this.i = b.i;
                this.q = b.q;
            }
        }
        
        static int a(final b b) {
            return b.c;
        }
        
        static int b(final b b, final int c) {
            return b.c = c;
        }
        
        static int c(final b b) {
            return b.d;
        }
        
        static int d(final b b, final int d) {
            return b.d = d;
        }
        
        static boolean e(final b b) {
            return b.b;
        }
        
        static ArrayList f(final b b) {
            return b.k;
        }
        
        static int g(final b b) {
            return b.e;
        }
        
        static String h(final b b) {
            return b.f;
        }
        
        static int i(final b b) {
            return b.g;
        }
        
        static int j(final b b) {
            return b.h;
        }
        
        static r k(final b b) {
            return b.l;
        }
        
        static r l(final b b, final r l) {
            return b.l = l;
        }
        
        static int m(final b b) {
            return b.a;
        }
        
        static ArrayList n(final b b) {
            return b.m;
        }
        
        static boolean o(final b b) {
            return b.o;
        }
        
        static int p(final b b) {
            return b.n;
        }
        
        static q q(final b b) {
            return b.j;
        }
        
        private void t(final q q, final Context context, final TypedArray typedArray) {
            for (int indexCount = typedArray.getIndexCount(), i = 0; i < indexCount; ++i) {
                final int index = typedArray.getIndex(i);
                if (index == androidx.constraintlayout.widget.h.x9) {
                    this.c = typedArray.getResourceId(index, -1);
                    final String resourceTypeName = context.getResources().getResourceTypeName(this.c);
                    if ("layout".equals(resourceTypeName)) {
                        final c c = new c();
                        c.x(context, this.c);
                        q.b(q).append(this.c, (Object)c);
                    }
                    else if ("xml".equals(resourceTypeName)) {
                        this.c = q.c(q, context, this.c);
                    }
                }
                else if (index == androidx.constraintlayout.widget.h.y9) {
                    this.d = typedArray.getResourceId(index, this.d);
                    final String resourceTypeName2 = context.getResources().getResourceTypeName(this.d);
                    if ("layout".equals(resourceTypeName2)) {
                        final c c2 = new c();
                        c2.x(context, this.d);
                        q.b(q).append(this.d, (Object)c2);
                    }
                    else if ("xml".equals(resourceTypeName2)) {
                        this.d = q.c(q, context, this.d);
                    }
                }
                else if (index == androidx.constraintlayout.widget.h.B9) {
                    final int type = typedArray.peekValue(index).type;
                    if (type == 1) {
                        if ((this.g = typedArray.getResourceId(index, -1)) != -1) {
                            this.e = -2;
                        }
                    }
                    else if (type == 3) {
                        final String string = typedArray.getString(index);
                        if ((this.f = string) != null) {
                            if (string.indexOf("/") > 0) {
                                this.g = typedArray.getResourceId(index, -1);
                                this.e = -2;
                            }
                            else {
                                this.e = -1;
                            }
                        }
                    }
                    else {
                        this.e = typedArray.getInteger(index, this.e);
                    }
                }
                else if (index == androidx.constraintlayout.widget.h.z9) {
                    if ((this.h = typedArray.getInt(index, this.h)) < 8) {
                        this.h = 8;
                    }
                }
                else if (index == androidx.constraintlayout.widget.h.D9) {
                    this.i = typedArray.getFloat(index, this.i);
                }
                else if (index == androidx.constraintlayout.widget.h.w9) {
                    this.n = typedArray.getInteger(index, this.n);
                }
                else if (index == androidx.constraintlayout.widget.h.v9) {
                    this.a = typedArray.getResourceId(index, this.a);
                }
                else if (index == androidx.constraintlayout.widget.h.E9) {
                    this.o = typedArray.getBoolean(index, this.o);
                }
                else if (index == androidx.constraintlayout.widget.h.C9) {
                    this.p = typedArray.getInteger(index, -1);
                }
                else if (index == androidx.constraintlayout.widget.h.A9) {
                    this.q = typedArray.getInteger(index, 0);
                }
                else if (index == androidx.constraintlayout.widget.h.F9) {
                    this.r = typedArray.getInteger(index, 0);
                }
            }
            if (this.d == -1) {
                this.b = true;
            }
        }
        
        private void u(final q q, final Context context, final AttributeSet set) {
            final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, androidx.constraintlayout.widget.h.u9);
            this.t(q, context, obtainStyledAttributes);
            obtainStyledAttributes.recycle();
        }
        
        public boolean A() {
            return this.o ^ true;
        }
        
        public boolean B(final int n) {
            return (n & this.r) != 0x0;
        }
        
        public void C(final int n) {
            this.h = Math.max(n, 8);
        }
        
        public void D(final int e, final String f, final int g) {
            this.e = e;
            this.f = f;
            this.g = g;
        }
        
        public void E(final int p) {
            this.p = p;
        }
        
        public void r(final androidx.constraintlayout.motion.widget.g g) {
            this.k.add(g);
        }
        
        public void s(final Context context, final XmlPullParser xmlPullParser) {
            this.m.add(new a(context, this, xmlPullParser));
        }
        
        public int v() {
            return this.n;
        }
        
        public int w() {
            return this.c;
        }
        
        public int x() {
            return this.q;
        }
        
        public int y() {
            return this.d;
        }
        
        public r z() {
            return this.l;
        }
        
        public static class a implements View$OnClickListener
        {
            private final b a;
            int b;
            int c;
            
            public a(final Context context, final b a, final XmlPullParser xmlPullParser) {
                this.b = -1;
                this.c = 17;
                this.a = a;
                final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), h.p8);
                for (int indexCount = obtainStyledAttributes.getIndexCount(), i = 0; i < indexCount; ++i) {
                    final int index = obtainStyledAttributes.getIndex(i);
                    if (index == h.r8) {
                        this.b = obtainStyledAttributes.getResourceId(index, this.b);
                    }
                    else if (index == h.q8) {
                        this.c = obtainStyledAttributes.getInt(index, this.c);
                    }
                }
                obtainStyledAttributes.recycle();
            }
            
            public void a(MotionLayout viewById, final int n, final b b) {
                final int b2 = this.b;
                if (b2 != -1) {
                    viewById = (MotionLayout)viewById.findViewById(b2);
                }
                if (viewById == null) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("OnClick could not find id ");
                    sb.append(this.b);
                    Log.e("MotionScene", sb.toString());
                    return;
                }
                final int c = androidx.constraintlayout.motion.widget.q.b.c(b);
                final int a = androidx.constraintlayout.motion.widget.q.b.a(b);
                if (c == -1) {
                    ((View)viewById).setOnClickListener((View$OnClickListener)this);
                    return;
                }
                final int c2 = this.c;
                final boolean b3 = false;
                final boolean b4 = (c2 & 0x1) != 0x0 && n == c;
                final boolean b5 = (c2 & 0x100) != 0x0 && n == c;
                final boolean b6 = (c2 & 0x1) != 0x0 && n == c;
                final boolean b7 = (c2 & 0x10) != 0x0 && n == a;
                boolean b8 = b3;
                if ((c2 & 0x1000) != 0x0) {
                    b8 = b3;
                    if (n == a) {
                        b8 = true;
                    }
                }
                if (b6 | (b4 | b5) | b7 | b8) {
                    ((View)viewById).setOnClickListener((View$OnClickListener)this);
                }
            }
            
            boolean b(final b b, final MotionLayout motionLayout) {
                final b a = this.a;
                final boolean b2 = true;
                boolean b3 = true;
                if (a == b) {
                    return true;
                }
                final int a2 = androidx.constraintlayout.motion.widget.q.b.a(a);
                final int c = androidx.constraintlayout.motion.widget.q.b.c(this.a);
                if (c == -1) {
                    if (motionLayout.f == a2) {
                        b3 = false;
                    }
                    return b3;
                }
                final int f = motionLayout.f;
                boolean b4 = b2;
                if (f != c) {
                    b4 = (f == a2 && b2);
                }
                return b4;
            }
            
            public void c(final MotionLayout motionLayout) {
                final int b = this.b;
                if (b == -1) {
                    return;
                }
                final View viewById = motionLayout.findViewById(b);
                if (viewById == null) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append(" (*)  could not find id ");
                    sb.append(this.b);
                    Log.e("MotionScene", sb.toString());
                    return;
                }
                viewById.setOnClickListener((View$OnClickListener)null);
            }
            
            public void onClick(final View view) {
                final MotionLayout d = androidx.constraintlayout.motion.widget.q.d(androidx.constraintlayout.motion.widget.q.b.q(this.a));
                if (!d.x()) {
                    return;
                }
                if (androidx.constraintlayout.motion.widget.q.b.c(this.a) != -1) {
                    final b c = androidx.constraintlayout.motion.widget.q.b.q(this.a).c;
                    final int c2 = this.c;
                    final int n = 0;
                    final boolean b = (c2 & 0x1) != 0x0 || (c2 & 0x100) != 0x0;
                    final boolean b2 = (c2 & 0x10) != 0x0 || (c2 & 0x1000) != 0x0;
                    final boolean b3 = b && b2;
                    boolean b4 = b2;
                    int n2 = 0;
                    Label_0272: {
                        if (b3) {
                            final b c3 = androidx.constraintlayout.motion.widget.q.b.q(this.a).c;
                            final b a = this.a;
                            if (c3 != a) {
                                d.setTransition(a);
                            }
                            b4 = b2;
                            n2 = n;
                            if (d.getCurrentState() == d.getEndState()) {
                                break Label_0272;
                            }
                            if (d.getProgress() > 0.5f) {
                                b4 = b2;
                                n2 = n;
                                break Label_0272;
                            }
                            b4 = false;
                        }
                        n2 = (b ? 1 : 0);
                    }
                    if (this.b(c, d)) {
                        if (n2 != 0 && (this.c & 0x1) != 0x0) {
                            d.setTransition(this.a);
                            d.F();
                        }
                        else if (b4 && (this.c & 0x10) != 0x0) {
                            d.setTransition(this.a);
                            d.H();
                        }
                        else if (n2 != 0 && (this.c & 0x100) != 0x0) {
                            d.setTransition(this.a);
                            d.setProgress(1.0f);
                        }
                        else if (b4 && (this.c & 0x1000) != 0x0) {
                            d.setTransition(this.a);
                            d.setProgress(0.0f);
                        }
                    }
                    return;
                }
                final int currentState = d.getCurrentState();
                if (currentState == -1) {
                    d.I(androidx.constraintlayout.motion.widget.q.b.a(this.a));
                    return;
                }
                final b transition = new b(androidx.constraintlayout.motion.widget.q.b.q(this.a), this.a);
                androidx.constraintlayout.motion.widget.q.b.d(transition, currentState);
                androidx.constraintlayout.motion.widget.q.b.b(transition, androidx.constraintlayout.motion.widget.q.b.a(this.a));
                d.setTransition(transition);
                d.F();
            }
        }
    }
}
