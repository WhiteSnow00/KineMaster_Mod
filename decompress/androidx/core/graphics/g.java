// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.graphics;

import android.util.Log;
import android.graphics.Path;
import java.util.ArrayList;

public class g
{
    private static void a(final ArrayList<b> list, final char c, final float[] array) {
        list.add(new b(c, array));
    }
    
    static float[] b(final float[] array, final int n, int n2) {
        if (n > n2) {
            throw new IllegalArgumentException();
        }
        final int length = array.length;
        if (n >= 0 && n <= length) {
            n2 -= n;
            final int min = Math.min(n2, length - n);
            final float[] array2 = new float[n2];
            System.arraycopy(array, n, array2, 0, min);
            return array2;
        }
        throw new ArrayIndexOutOfBoundsException();
    }
    
    public static b[] c(final String s) {
        if (s == null) {
            return null;
        }
        final ArrayList list = new ArrayList();
        int i = 1;
        int n = 0;
        while (i < s.length()) {
            i = g(s, i);
            final String trim = s.substring(n, i).trim();
            if (trim.length() > 0) {
                a(list, trim.charAt(0), f(trim));
            }
            n = i;
            ++i;
        }
        if (i - n == 1 && n < s.length()) {
            a(list, s.charAt(n), new float[0]);
        }
        return list.toArray(new b[list.size()]);
    }
    
    public static Path d(final String s) {
        final Path path = new Path();
        final b[] c = c(s);
        if (c != null) {
            try {
                b.d(c, path);
                return path;
            }
            catch (final RuntimeException ex) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Error in parsing ");
                sb.append(s);
                throw new RuntimeException(sb.toString(), ex);
            }
        }
        return null;
    }
    
    private static void e(final String s, final int n, final a a) {
        a.b = false;
        int i = n;
        int n2 = 0;
        boolean b;
        int n3 = (b = false) ? 1 : 0;
        while (i < s.length()) {
            final char char1 = s.charAt(i);
            Label_0141: {
                Label_0136: {
                    if (char1 != ' ') {
                        if (char1 != 'E' && char1 != 'e') {
                            switch (char1) {
                                case 46: {
                                    if (n3 == 0) {
                                        n2 = 0;
                                        n3 = 1;
                                        break Label_0141;
                                    }
                                    a.b = true;
                                    break Label_0136;
                                }
                                case 45: {
                                    if (i != n && n2 == 0) {
                                        a.b = true;
                                        break Label_0136;
                                    }
                                    break;
                                }
                                case 44: {
                                    break Label_0136;
                                }
                            }
                            n2 = 0;
                            break Label_0141;
                        }
                        n2 = 1;
                        break Label_0141;
                    }
                }
                n2 = 0;
                b = true;
            }
            if (b) {
                break;
            }
            ++i;
        }
        a.a = i;
    }
    
    private static float[] f(final String s) {
        if (s.charAt(0) != 'z') {
            if (s.charAt(0) != 'Z') {
                try {
                    final float[] array = new float[s.length()];
                    final a a = new a();
                    final int length = s.length();
                    int i = 1;
                    int n = 0;
                    while (i < length) {
                        e(s, i, a);
                        final int a2 = a.a;
                        int n2 = n;
                        if (i < a2) {
                            array[n] = Float.parseFloat(s.substring(i, a2));
                            n2 = n + 1;
                        }
                        if (a.b) {
                            i = a2;
                            n = n2;
                        }
                        else {
                            i = a2 + 1;
                            n = n2;
                        }
                    }
                    return b(array, 0, n);
                }
                catch (final NumberFormatException ex) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("error in parsing \"");
                    sb.append(s);
                    sb.append("\"");
                    throw new RuntimeException(sb.toString(), ex);
                }
            }
        }
        return new float[0];
    }
    
    private static int g(final String s, int i) {
        while (i < s.length()) {
            final char char1 = s.charAt(i);
            if (((char1 - 'A') * (char1 - 'Z') <= 0 || (char1 - 'a') * (char1 - 'z') <= 0) && char1 != 'e' && char1 != 'E') {
                return i;
            }
            ++i;
        }
        return i;
    }
    
    private static class a
    {
        int a;
        boolean b;
        
        a() {
        }
    }
    
    public static class b
    {
        public char a;
        public float[] b;
        
        b(final char a, final float[] b) {
            this.a = a;
            this.b = b;
        }
        
        private static void a(final Path path, final float[] array, final char c, final char c2, final float[] array2) {
            final float n = array[0];
            final float n2 = array[1];
            final float n3 = array[2];
            final float n4 = array[3];
            final float n5 = array[4];
            final float n6 = array[5];
            float n7 = n;
            float n8 = n2;
            float n9 = n3;
            float n10 = n4;
            int n11 = 0;
            Label_0340: {
                switch (c2) {
                    case 'Z':
                    case 'z': {
                        path.close();
                        path.moveTo(n5, n6);
                        n7 = (n9 = n5);
                        n8 = (n10 = n6);
                    }
                    default: {
                        n10 = n4;
                        n9 = n3;
                        n8 = n2;
                        n7 = n;
                    }
                    case 'L':
                    case 'M':
                    case 'T':
                    case 'l':
                    case 'm':
                    case 't': {
                        n11 = 2;
                        break Label_0340;
                    }
                    case 'Q':
                    case 'S':
                    case 'q':
                    case 's': {
                        n11 = 4;
                        n7 = n;
                        n8 = n2;
                        n9 = n3;
                        n10 = n4;
                        break Label_0340;
                    }
                    case 'H':
                    case 'V':
                    case 'h':
                    case 'v': {
                        n11 = 1;
                        n7 = n;
                        n8 = n2;
                        n9 = n3;
                        n10 = n4;
                        break Label_0340;
                    }
                    case 'C':
                    case 'c': {
                        n11 = 6;
                        break;
                    }
                    case 'A':
                    case 'a': {
                        n11 = 7;
                        break;
                    }
                }
                n10 = n4;
                n9 = n3;
                n8 = n2;
                n7 = n;
            }
            final float n12 = n8;
            final int n13 = 0;
            char c3 = c;
            float n14 = n6;
            float n15 = n5;
            float n16 = n7;
            float n17 = n12;
        Label_0484_Outer:
            for (int i = n13; i < array2.length; i += n11, c3 = c2) {
                if (c2 != 'A') {
                    if (c2 == 'C') {
                        final float n18 = array2[i + 0];
                        final float n19 = array2[i + 1];
                        final int n20 = i + 2;
                        final float n21 = array2[n20];
                        final int n22 = i + 3;
                        final float n23 = array2[n22];
                        final int n24 = i + 4;
                        final float n25 = array2[n24];
                        final int n26 = i + 5;
                        path.cubicTo(n18, n19, n21, n23, n25, array2[n26]);
                        n16 = array2[n24];
                        n17 = array2[n26];
                        n9 = array2[n20];
                        n10 = array2[n22];
                        continue;
                    }
                    if (c2 == 'H') {
                        final int n27 = i + 0;
                        path.lineTo(array2[n27], n17);
                        n16 = array2[n27];
                        continue;
                    }
                    if (c2 == 'Q') {
                        final int n28 = i + 0;
                        final float n29 = array2[n28];
                        final int n30 = i + 1;
                        final float n31 = array2[n30];
                        final int n32 = i + 2;
                        final float n33 = array2[n32];
                        final int n34 = i + 3;
                        path.quadTo(n29, n31, n33, array2[n34]);
                        n9 = array2[n28];
                        n10 = array2[n30];
                        n16 = array2[n32];
                        n17 = array2[n34];
                        continue;
                    }
                    if (c2 == 'V') {
                        final int n35 = i + 0;
                        path.lineTo(n16, array2[n35]);
                        n17 = array2[n35];
                        continue;
                    }
                    if (c2 != 'a') {
                        while (true) {
                            float n46 = 0.0f;
                            float n49 = 0.0f;
                            float n67 = 0.0f;
                            Label_1551: {
                                float n47 = 0.0f;
                                float n48 = 0.0f;
                                Label_1540: {
                                    if (c2 == 'c') {
                                        final float n36 = array2[i + 0];
                                        final float n37 = array2[i + 1];
                                        final int n38 = i + 2;
                                        final float n39 = array2[n38];
                                        final int n40 = i + 3;
                                        final float n41 = array2[n40];
                                        final int n42 = i + 4;
                                        final float n43 = array2[n42];
                                        final int n44 = i + 5;
                                        path.rCubicTo(n36, n37, n39, n41, n43, array2[n44]);
                                        final float n45 = array2[n38] + n16;
                                        n46 = array2[n40] + n17;
                                        n47 = n16 + array2[n42];
                                        n48 = array2[n44];
                                        n49 = n45;
                                        break Label_1540;
                                    }
                                    if (c2 != 'h') {
                                        if (c2 == 'q') {
                                            final int n50 = i + 0;
                                            final float n51 = array2[n50];
                                            final int n52 = i + 1;
                                            final float n53 = array2[n52];
                                            final int n54 = i + 2;
                                            final float n55 = array2[n54];
                                            final int n56 = i + 3;
                                            path.rQuadTo(n51, n53, n55, array2[n56]);
                                            final float n57 = array2[n50] + n16;
                                            n46 = array2[n52] + n17;
                                            n47 = n16 + array2[n54];
                                            n48 = array2[n56];
                                            n49 = n57;
                                            break Label_1540;
                                        }
                                        float n76 = 0.0f;
                                        Label_0889: {
                                            if (c2 != 'v') {
                                                if (c2 != 'L') {
                                                    if (c2 != 'M') {
                                                        if (c2 == 'S') {
                                                            float n58 = 0.0f;
                                                            float n59 = 0.0f;
                                                            Label_1064: {
                                                                if (c3 != 'c' && c3 != 's' && c3 != 'C') {
                                                                    n58 = n17;
                                                                    n59 = n16;
                                                                    if (c3 != 'S') {
                                                                        break Label_1064;
                                                                    }
                                                                }
                                                                n59 = n16 * 2.0f - n9;
                                                                n58 = n17 * 2.0f - n10;
                                                            }
                                                            final int n60 = i + 0;
                                                            final float n61 = array2[n60];
                                                            final int n62 = i + 1;
                                                            final float n63 = array2[n62];
                                                            final int n64 = i + 2;
                                                            final float n65 = array2[n64];
                                                            final int n66 = i + 3;
                                                            path.cubicTo(n59, n58, n61, n63, n65, array2[n66]);
                                                            n49 = array2[n60];
                                                            n46 = array2[n62];
                                                            n67 = array2[n64];
                                                            n17 = array2[n66];
                                                            break Label_1551;
                                                        }
                                                        if (c2 == 'T') {
                                                            float n68 = 0.0f;
                                                            float n69 = 0.0f;
                                                            Label_0953: {
                                                                if (c3 != 'q' && c3 != 't' && c3 != 'Q') {
                                                                    n68 = n17;
                                                                    n69 = n16;
                                                                    if (c3 != 'T') {
                                                                        break Label_0953;
                                                                    }
                                                                }
                                                                n69 = n16 * 2.0f - n9;
                                                                n68 = n17 * 2.0f - n10;
                                                            }
                                                            final int n70 = i + 0;
                                                            final float n71 = array2[n70];
                                                            final int n72 = i + 1;
                                                            path.quadTo(n69, n68, n71, array2[n72]);
                                                            n16 = array2[n70];
                                                            n17 = array2[n72];
                                                            n10 = n68;
                                                            n9 = n69;
                                                            continue Label_0484_Outer;
                                                        }
                                                        if (c2 == 'l') {
                                                            final int n73 = i + 0;
                                                            final float n74 = array2[n73];
                                                            final int n75 = i + 1;
                                                            path.rLineTo(n74, array2[n75]);
                                                            n16 += array2[n73];
                                                            n76 = array2[n75];
                                                            break Label_0889;
                                                        }
                                                        if (c2 != 'm') {
                                                            if (c2 == 's') {
                                                                float n77;
                                                                float n78;
                                                                if (c3 != 'c' && c3 != 's' && c3 != 'C' && c3 != 'S') {
                                                                    n77 = 0.0f;
                                                                    n78 = 0.0f;
                                                                }
                                                                else {
                                                                    n78 = n17 - n10;
                                                                    n77 = n16 - n9;
                                                                }
                                                                final int n79 = i + 0;
                                                                final float n80 = array2[n79];
                                                                final int n81 = i + 1;
                                                                final float n82 = array2[n81];
                                                                final int n83 = i + 2;
                                                                final float n84 = array2[n83];
                                                                final int n85 = i + 3;
                                                                path.rCubicTo(n77, n78, n80, n82, n84, array2[n85]);
                                                                final float n86 = array2[n79] + n16;
                                                                n46 = array2[n81] + n17;
                                                                n47 = n16 + array2[n83];
                                                                n48 = array2[n85];
                                                                n49 = n86;
                                                                break Label_1540;
                                                            }
                                                            if (c2 != 't') {
                                                                break Label_0484;
                                                            }
                                                            float n87;
                                                            float n88;
                                                            if (c3 != 'q' && c3 != 't' && c3 != 'Q' && c3 != 'T') {
                                                                n87 = 0.0f;
                                                                n88 = 0.0f;
                                                            }
                                                            else {
                                                                n88 = n16 - n9;
                                                                n87 = n17 - n10;
                                                            }
                                                            final int n89 = i + 0;
                                                            final float n90 = array2[n89];
                                                            final int n91 = i + 1;
                                                            path.rQuadTo(n88, n87, n90, array2[n91]);
                                                            final float n92 = n16 + array2[n89];
                                                            final float n93 = n17 + array2[n91];
                                                            n10 = n87 + n17;
                                                            n9 = n88 + n16;
                                                            n17 = n93;
                                                            n16 = n92;
                                                            break Label_0484;
                                                        }
                                                        else {
                                                            final int n94 = i + 0;
                                                            n16 += array2[n94];
                                                            final int n95 = i + 1;
                                                            n17 += array2[n95];
                                                            if (i > 0) {
                                                                path.rLineTo(array2[n94], array2[n95]);
                                                                break Label_0484;
                                                            }
                                                            path.rMoveTo(array2[n94], array2[n95]);
                                                        }
                                                    }
                                                    else {
                                                        final int n96 = i + 0;
                                                        n16 = array2[n96];
                                                        final int n97 = i + 1;
                                                        n17 = array2[n97];
                                                        if (i > 0) {
                                                            path.lineTo(array2[n96], array2[n97]);
                                                            break Label_0484;
                                                        }
                                                        path.moveTo(array2[n96], array2[n97]);
                                                    }
                                                    n14 = n17;
                                                    n15 = n16;
                                                    continue Label_0484_Outer;
                                                }
                                                final int n98 = i + 0;
                                                final float n99 = array2[n98];
                                                final int n100 = i + 1;
                                                path.lineTo(n99, array2[n100]);
                                                n16 = array2[n98];
                                                n17 = array2[n100];
                                                break Label_0484;
                                            }
                                            else {
                                                final int n101 = i + 0;
                                                path.rLineTo(0.0f, array2[n101]);
                                                n76 = array2[n101];
                                            }
                                        }
                                        n17 += n76;
                                    }
                                    else {
                                        final int n102 = i + 0;
                                        path.rLineTo(array2[n102], 0.0f);
                                        n16 += array2[n102];
                                    }
                                    continue Label_0484_Outer;
                                }
                                n17 += n48;
                                n67 = n47;
                            }
                            n10 = n46;
                            n9 = n49;
                            n16 = n67;
                            continue;
                        }
                    }
                    final int n103 = i + 5;
                    final float n104 = array2[n103];
                    final int n105 = i + 6;
                    c(path, n16, n17, n104 + n16, array2[n105] + n17, array2[i + 0], array2[i + 1], array2[i + 2], array2[i + 3] != 0.0f, array2[i + 4] != 0.0f);
                    n16 += array2[n103];
                    n17 += array2[n105];
                }
                else {
                    final int n106 = i + 5;
                    final float n107 = array2[n106];
                    final int n108 = i + 6;
                    c(path, n16, n17, n107, array2[n108], array2[i + 0], array2[i + 1], array2[i + 2], array2[i + 3] != 0.0f, array2[i + 4] != 0.0f);
                    n16 = array2[n106];
                    n17 = array2[n108];
                }
                n10 = n17;
                n9 = n16;
            }
            array[0] = n16;
            array[1] = n17;
            array[2] = n9;
            array[3] = n10;
            array[4] = n15;
            array[5] = n14;
        }
        
        private static void b(final Path path, final double n, final double n2, final double n3, double n4, double n5, double n6, double cos, double n7, double n8) {
            final int n9 = (int)Math.ceil(Math.abs(n8 * 4.0 / 3.141592653589793));
            final double cos2 = Math.cos(cos);
            final double sin = Math.sin(cos);
            cos = Math.cos(n7);
            final double sin2 = Math.sin(n7);
            final double n10 = -n3;
            final double n11 = n10 * cos2;
            final double n12 = n4 * sin;
            final double n13 = n10 * sin;
            final double n14 = n4 * cos2;
            final double n15 = n8 / n9;
            n4 = sin2 * n13 + cos * n14;
            n8 = n11 * sin2 - n12 * cos;
            int i = 0;
            cos = n6;
            n6 = n4;
            double n16 = n7;
            n4 = n13;
            final double n17 = n15;
            n7 = cos2;
            while (i < n9) {
                final double n18 = n16 + n17;
                final double sin3 = Math.sin(n18);
                final double cos3 = Math.cos(n18);
                final double n19 = n + n3 * n7 * cos3 - n12 * sin3;
                final double n20 = n2 + n3 * sin * cos3 + n14 * sin3;
                final double n21 = n11 * sin3 - n12 * cos3;
                final double n22 = sin3 * n4 + cos3 * n14;
                final double n23 = n18 - n16;
                final double tan = Math.tan(n23 / 2.0);
                final double n24 = Math.sin(n23) * (Math.sqrt(tan * 3.0 * tan + 4.0) - 1.0) / 3.0;
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float)(n5 + n8 * n24), (float)(cos + n6 * n24), (float)(n19 - n24 * n21), (float)(n20 - n24 * n22), (float)n19, (float)n20);
                ++i;
                n5 = n19;
                n16 = n18;
                n6 = n22;
                n8 = n21;
                cos = n20;
            }
        }
        
        private static void c(final Path path, final float n, final float n2, final float n3, final float n4, final float n5, final float n6, final float n7, final boolean b, final boolean b2) {
            final double radians = Math.toRadians(n7);
            final double cos = Math.cos(radians);
            final double sin = Math.sin(radians);
            final double n8 = n;
            final double n9 = n2;
            final double n10 = n5;
            final double n11 = (n8 * cos + n9 * sin) / n10;
            final double n12 = -n;
            final double n13 = n6;
            final double n14 = (n12 * sin + n9 * cos) / n13;
            final double n15 = n3;
            final double n16 = n4;
            final double n17 = (n15 * cos + n16 * sin) / n10;
            final double n18 = (-n3 * sin + n16 * cos) / n13;
            final double n19 = n11 - n17;
            final double n20 = n14 - n18;
            final double n21 = (n11 + n17) / 2.0;
            final double n22 = (n14 + n18) / 2.0;
            final double n23 = n19 * n19 + n20 * n20;
            if (n23 == 0.0) {
                Log.w("PathParser", " Points are coincident");
                return;
            }
            final double n24 = 1.0 / n23 - 0.25;
            if (n24 < 0.0) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Points are too far apart ");
                sb.append(n23);
                Log.w("PathParser", sb.toString());
                final float n25 = (float)(Math.sqrt(n23) / 1.99999);
                c(path, n, n2, n3, n4, n5 * n25, n6 * n25, n7, b, b2);
                return;
            }
            final double sqrt = Math.sqrt(n24);
            final double n26 = n19 * sqrt;
            final double n27 = sqrt * n20;
            double n28;
            double n29;
            if (b == b2) {
                n28 = n21 - n27;
                n29 = n22 + n26;
            }
            else {
                n28 = n21 + n27;
                n29 = n22 - n26;
            }
            final double atan2 = Math.atan2(n14 - n29, n11 - n28);
            final double n30 = Math.atan2(n18 - n29, n17 - n28) - atan2;
            final double n31 = dcmpl(n30, 0.0);
            final boolean b3 = n31 >= 0;
            double n32 = n30;
            if (b2 != b3) {
                if (n31 > 0) {
                    n32 = n30 - 6.283185307179586;
                }
                else {
                    n32 = n30 + 6.283185307179586;
                }
            }
            final double n33 = n28 * n10;
            final double n34 = n29 * n13;
            b(path, n33 * cos - n34 * sin, n33 * sin + n34 * cos, n10, n13, n8, n9, radians, atan2, n32);
        }
        
        public static void d(final b[] array, final Path path) {
            final float[] array2 = new float[6];
            char a = 'm';
            for (int i = 0; i < array.length; ++i) {
                a(path, array2, a, array[i].a, array[i].b);
                a = array[i].a;
            }
        }
    }
}
