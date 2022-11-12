// 
// Decompiled by Procyon v0.6.0
// 

package androidx.constraintlayout.motion.widget;

import java.util.HashSet;
import android.view.View;
import java.util.Iterator;
import android.util.Log;
import t.c;
import java.util.HashMap;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.util.LinkedHashMap;

class l implements Comparable<l>
{
    static String[] N;
    private int A;
    private float B;
    private float C;
    private float D;
    private float E;
    private float F;
    private float G;
    private float H;
    private int I;
    LinkedHashMap<String, ConstraintAttribute> J;
    int K;
    double[] L;
    double[] M;
    private float a;
    int b;
    int c;
    private boolean d;
    private float e;
    private float f;
    private float g;
    public float h;
    private float i;
    private float j;
    private float p;
    private float w;
    private float x;
    private float y;
    private float z;
    
    static {
        l.N = new String[] { "position", "x", "y", "width", "height", "pathRotate" };
    }
    
    public l() {
        this.a = 1.0f;
        this.b = 0;
        this.d = false;
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = 0.0f;
        this.h = 0.0f;
        this.i = 1.0f;
        this.j = 1.0f;
        this.p = Float.NaN;
        this.w = Float.NaN;
        this.x = 0.0f;
        this.y = 0.0f;
        this.z = 0.0f;
        this.A = 0;
        this.G = Float.NaN;
        this.H = Float.NaN;
        this.I = -1;
        this.J = new LinkedHashMap<String, ConstraintAttribute>();
        this.K = 0;
        this.L = new double[18];
        this.M = new double[18];
    }
    
    private boolean f(final float n, final float n2) {
        final boolean naN = Float.isNaN(n);
        boolean b = true;
        final boolean b2 = true;
        if (!naN && !Float.isNaN(n2)) {
            return Math.abs(n - n2) > 1.0E-6f && b2;
        }
        if (Float.isNaN(n) == Float.isNaN(n2)) {
            b = false;
        }
        return b;
    }
    
    public void a(final HashMap<String, c> hashMap, final int n) {
        for (final String s : hashMap.keySet()) {
            final c c = hashMap.get(s);
            s.hashCode();
            int n2 = -1;
            switch (s) {
                case "alpha": {
                    n2 = 13;
                    break;
                }
                case "transitionPathRotate": {
                    n2 = 12;
                    break;
                }
                case "elevation": {
                    n2 = 11;
                    break;
                }
                case "rotation": {
                    n2 = 10;
                    break;
                }
                case "transformPivotY": {
                    n2 = 9;
                    break;
                }
                case "transformPivotX": {
                    n2 = 8;
                    break;
                }
                case "scaleY": {
                    n2 = 7;
                    break;
                }
                case "scaleX": {
                    n2 = 6;
                    break;
                }
                case "progress": {
                    n2 = 5;
                    break;
                }
                case "translationZ": {
                    n2 = 4;
                    break;
                }
                case "translationY": {
                    n2 = 3;
                    break;
                }
                case "translationX": {
                    n2 = 2;
                    break;
                }
                case "rotationY": {
                    n2 = 1;
                    break;
                }
                case "rotationX": {
                    n2 = 0;
                    break;
                }
                default:
                    break;
            }
            float n3 = 1.0f;
            final float n4 = 0.0f;
            final float n5 = 0.0f;
            final float n6 = 0.0f;
            final float n7 = 0.0f;
            final float n8 = 0.0f;
            final float n9 = 0.0f;
            final float n10 = 0.0f;
            final float n11 = 0.0f;
            final float n12 = 0.0f;
            final float n13 = 0.0f;
            final float n14 = 0.0f;
            switch (n2) {
                default: {
                    if (!s.startsWith("CUSTOM")) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("UNKNOWN spline ");
                        sb.append(s);
                        Log.e("MotionPaths", sb.toString());
                        continue;
                    }
                    final String s2 = s.split(",")[1];
                    if (!this.J.containsKey(s2)) {
                        continue;
                    }
                    final ConstraintAttribute constraintAttribute = this.J.get(s2);
                    if (c instanceof c.b) {
                        ((c.b)c).h(n, constraintAttribute);
                        continue;
                    }
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append(s);
                    sb2.append(" ViewSpline not a CustomSet frame = ");
                    sb2.append(n);
                    sb2.append(", value");
                    sb2.append(constraintAttribute.e());
                    sb2.append(c);
                    Log.e("MotionPaths", sb2.toString());
                    continue;
                }
                case 13: {
                    if (!Float.isNaN(this.a)) {
                        n3 = this.a;
                    }
                    c.b(n, n3);
                    continue;
                }
                case 12: {
                    float g;
                    if (Float.isNaN(this.G)) {
                        g = n14;
                    }
                    else {
                        g = this.G;
                    }
                    c.b(n, g);
                    continue;
                }
                case 11: {
                    float e;
                    if (Float.isNaN(this.e)) {
                        e = n4;
                    }
                    else {
                        e = this.e;
                    }
                    c.b(n, e);
                    continue;
                }
                case 10: {
                    float f;
                    if (Float.isNaN(this.f)) {
                        f = n5;
                    }
                    else {
                        f = this.f;
                    }
                    c.b(n, f);
                    continue;
                }
                case 9: {
                    float w;
                    if (Float.isNaN(this.w)) {
                        w = n6;
                    }
                    else {
                        w = this.w;
                    }
                    c.b(n, w);
                    continue;
                }
                case 8: {
                    float p2;
                    if (Float.isNaN(this.p)) {
                        p2 = n7;
                    }
                    else {
                        p2 = this.p;
                    }
                    c.b(n, p2);
                    continue;
                }
                case 7: {
                    if (!Float.isNaN(this.j)) {
                        n3 = this.j;
                    }
                    c.b(n, n3);
                    continue;
                }
                case 6: {
                    if (!Float.isNaN(this.i)) {
                        n3 = this.i;
                    }
                    c.b(n, n3);
                    continue;
                }
                case 5: {
                    float h;
                    if (Float.isNaN(this.H)) {
                        h = n8;
                    }
                    else {
                        h = this.H;
                    }
                    c.b(n, h);
                    continue;
                }
                case 4: {
                    float z;
                    if (Float.isNaN(this.z)) {
                        z = n9;
                    }
                    else {
                        z = this.z;
                    }
                    c.b(n, z);
                    continue;
                }
                case 3: {
                    float y;
                    if (Float.isNaN(this.y)) {
                        y = n10;
                    }
                    else {
                        y = this.y;
                    }
                    c.b(n, y);
                    continue;
                }
                case 2: {
                    float x;
                    if (Float.isNaN(this.x)) {
                        x = n11;
                    }
                    else {
                        x = this.x;
                    }
                    c.b(n, x);
                    continue;
                }
                case 1: {
                    float h2;
                    if (Float.isNaN(this.h)) {
                        h2 = n12;
                    }
                    else {
                        h2 = this.h;
                    }
                    c.b(n, h2);
                    continue;
                }
                case 0: {
                    float g2;
                    if (Float.isNaN(this.g)) {
                        g2 = n13;
                    }
                    else {
                        g2 = this.g;
                    }
                    c.b(n, g2);
                    continue;
                }
            }
        }
    }
    
    public void c(final View view) {
        this.c = view.getVisibility();
        float alpha;
        if (view.getVisibility() != 0) {
            alpha = 0.0f;
        }
        else {
            alpha = view.getAlpha();
        }
        this.a = alpha;
        this.d = false;
        this.e = view.getElevation();
        this.f = view.getRotation();
        this.g = view.getRotationX();
        this.h = view.getRotationY();
        this.i = view.getScaleX();
        this.j = view.getScaleY();
        this.p = view.getPivotX();
        this.w = view.getPivotY();
        this.x = view.getTranslationX();
        this.y = view.getTranslationY();
        this.z = view.getTranslationZ();
    }
    
    @Override
    public /* bridge */ int compareTo(final Object o) {
        return this.d((l)o);
    }
    
    public int d(final l l) {
        return Float.compare(this.B, l.B);
    }
    
    void g(final l l, final HashSet<String> set) {
        if (this.f(this.a, l.a)) {
            set.add("alpha");
        }
        if (this.f(this.e, l.e)) {
            set.add("elevation");
        }
        final int c = this.c;
        final int c2 = l.c;
        if (c != c2 && this.b == 0 && (c == 0 || c2 == 0)) {
            set.add("alpha");
        }
        if (this.f(this.f, l.f)) {
            set.add("rotation");
        }
        if (!Float.isNaN(this.G) || !Float.isNaN(l.G)) {
            set.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.H) || !Float.isNaN(l.H)) {
            set.add("progress");
        }
        if (this.f(this.g, l.g)) {
            set.add("rotationX");
        }
        if (this.f(this.h, l.h)) {
            set.add("rotationY");
        }
        if (this.f(this.p, l.p)) {
            set.add("transformPivotX");
        }
        if (this.f(this.w, l.w)) {
            set.add("transformPivotY");
        }
        if (this.f(this.i, l.i)) {
            set.add("scaleX");
        }
        if (this.f(this.j, l.j)) {
            set.add("scaleY");
        }
        if (this.f(this.x, l.x)) {
            set.add("translationX");
        }
        if (this.f(this.y, l.y)) {
            set.add("translationY");
        }
        if (this.f(this.z, l.z)) {
            set.add("translationZ");
        }
    }
    
    void h(final float c, final float d, final float e, final float f) {
        this.C = c;
        this.D = d;
        this.E = e;
        this.F = f;
    }
    
    public void i(final View view) {
        this.h(view.getX(), view.getY(), (float)view.getWidth(), (float)view.getHeight());
        this.c(view);
    }
}
