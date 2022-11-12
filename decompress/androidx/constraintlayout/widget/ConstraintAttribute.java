// 
// Decompiled by Procyon v0.6.0
// 

package androidx.constraintlayout.widget;

import java.lang.reflect.Method;
import android.util.Log;
import android.graphics.drawable.Drawable;
import java.io.Serializable;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.util.Xml;
import org.xmlpull.v1.XmlPullParser;
import android.content.Context;
import java.util.Iterator;
import java.lang.reflect.InvocationTargetException;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import java.util.HashMap;

public class ConstraintAttribute
{
    private boolean a;
    String b;
    private AttributeType c;
    private int d;
    private float e;
    private String f;
    boolean g;
    private int h;
    
    public ConstraintAttribute(final ConstraintAttribute constraintAttribute, final Object o) {
        this.a = false;
        this.b = constraintAttribute.b;
        this.c = constraintAttribute.c;
        this.j(o);
    }
    
    public ConstraintAttribute(final String b, final AttributeType c, final Object o, final boolean a) {
        this.b = b;
        this.c = c;
        this.a = a;
        this.j(o);
    }
    
    public static HashMap<String, ConstraintAttribute> b(final HashMap<String, ConstraintAttribute> hashMap, final View view) {
        final HashMap hashMap2 = new HashMap();
        final Class<? extends View> class1 = view.getClass();
        for (final String s : hashMap.keySet()) {
            final ConstraintAttribute constraintAttribute = hashMap.get(s);
            try {
                if (s.equals("BackgroundColor")) {
                    hashMap2.put(s, new ConstraintAttribute(constraintAttribute, ((ColorDrawable)view.getBackground()).getColor()));
                }
                else {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("getMap");
                    sb.append(s);
                    hashMap2.put(s, new ConstraintAttribute(constraintAttribute, class1.getMethod(sb.toString(), (Class<?>[])new Class[0]).invoke(view, new Object[0])));
                }
            }
            catch (final InvocationTargetException ex) {
                ex.printStackTrace();
            }
            catch (final IllegalAccessException ex2) {
                ex2.printStackTrace();
            }
            catch (final NoSuchMethodException ex3) {
                ex3.printStackTrace();
            }
        }
        return hashMap2;
    }
    
    public static void h(final Context context, final XmlPullParser xmlPullParser, final HashMap<String, ConstraintAttribute> hashMap) {
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), h.y4);
        final int indexCount = obtainStyledAttributes.getIndexCount();
        String s = null;
        Serializable s2 = null;
        AttributeType attributeType = null;
        int i = 0;
        int n = 0;
        while (i < indexCount) {
            final int index = obtainStyledAttributes.getIndex(i);
            String s4 = null;
            Serializable s5 = null;
            AttributeType boolean_TYPE = null;
            int n2 = 0;
            Label_0509: {
                if (index == h.z4) {
                    final String s3 = s4 = obtainStyledAttributes.getString(index);
                    s5 = s2;
                    boolean_TYPE = attributeType;
                    n2 = n;
                    if (s3 != null) {
                        s4 = s3;
                        s5 = s2;
                        boolean_TYPE = attributeType;
                        n2 = n;
                        if (s3.length() > 0) {
                            final StringBuilder sb = new StringBuilder();
                            sb.append(Character.toUpperCase(s3.charAt(0)));
                            sb.append(s3.substring(1));
                            s4 = sb.toString();
                            s5 = s2;
                            boolean_TYPE = attributeType;
                            n2 = n;
                        }
                    }
                }
                else if (index == h.J4) {
                    s4 = obtainStyledAttributes.getString(index);
                    n2 = 1;
                    s5 = s2;
                    boolean_TYPE = attributeType;
                }
                else if (index == h.A4) {
                    s5 = obtainStyledAttributes.getBoolean(index, false);
                    boolean_TYPE = AttributeType.BOOLEAN_TYPE;
                    s4 = s;
                    n2 = n;
                }
                else {
                    AttributeType attributeType2;
                    if (index == h.C4) {
                        attributeType2 = AttributeType.COLOR_TYPE;
                        s5 = obtainStyledAttributes.getColor(index, 0);
                    }
                    else if (index == h.B4) {
                        attributeType2 = AttributeType.COLOR_DRAWABLE_TYPE;
                        s5 = obtainStyledAttributes.getColor(index, 0);
                    }
                    else if (index == h.G4) {
                        attributeType2 = AttributeType.DIMENSION_TYPE;
                        s5 = TypedValue.applyDimension(1, obtainStyledAttributes.getDimension(index, 0.0f), context.getResources().getDisplayMetrics());
                    }
                    else if (index == h.D4) {
                        attributeType2 = AttributeType.DIMENSION_TYPE;
                        s5 = obtainStyledAttributes.getDimension(index, 0.0f);
                    }
                    else if (index == h.E4) {
                        attributeType2 = AttributeType.FLOAT_TYPE;
                        s5 = obtainStyledAttributes.getFloat(index, Float.NaN);
                    }
                    else if (index == h.F4) {
                        attributeType2 = AttributeType.INT_TYPE;
                        s5 = obtainStyledAttributes.getInteger(index, -1);
                    }
                    else if (index == h.I4) {
                        attributeType2 = AttributeType.STRING_TYPE;
                        s5 = obtainStyledAttributes.getString(index);
                    }
                    else {
                        s4 = s;
                        s5 = s2;
                        boolean_TYPE = attributeType;
                        n2 = n;
                        if (index != h.H4) {
                            break Label_0509;
                        }
                        attributeType2 = AttributeType.REFERENCE_TYPE;
                        int n3;
                        if ((n3 = obtainStyledAttributes.getResourceId(index, -1)) == -1) {
                            n3 = obtainStyledAttributes.getInt(index, -1);
                        }
                        s5 = n3;
                    }
                    boolean_TYPE = attributeType2;
                    s4 = s;
                    n2 = n;
                }
            }
            ++i;
            s = s4;
            s2 = s5;
            attributeType = boolean_TYPE;
            n = n2;
        }
        if (s != null && s2 != null) {
            hashMap.put(s, new ConstraintAttribute(s, attributeType, s2, (boolean)(n != 0)));
        }
        obtainStyledAttributes.recycle();
    }
    
    public static void i(final View view, final HashMap<String, ConstraintAttribute> hashMap) {
        final Class<? extends View> class1 = view.getClass();
        for (final String s : hashMap.keySet()) {
            final ConstraintAttribute constraintAttribute = hashMap.get(s);
            String string;
            if (!constraintAttribute.a) {
                final StringBuilder sb = new StringBuilder();
                sb.append("set");
                sb.append(s);
                string = sb.toString();
            }
            else {
                string = s;
            }
            try {
                switch (ConstraintAttribute$a.a[constraintAttribute.c.ordinal()]) {
                    default: {
                        continue;
                    }
                    case 8: {
                        class1.getMethod(string, Float.TYPE).invoke(view, constraintAttribute.e);
                        continue;
                    }
                    case 7: {
                        class1.getMethod(string, Float.TYPE).invoke(view, constraintAttribute.e);
                        continue;
                    }
                    case 6: {
                        class1.getMethod(string, Integer.TYPE).invoke(view, constraintAttribute.d);
                        continue;
                    }
                    case 5: {
                        final Method method = class1.getMethod(string, Drawable.class);
                        final ColorDrawable colorDrawable = new ColorDrawable();
                        colorDrawable.setColor(constraintAttribute.h);
                        method.invoke(view, colorDrawable);
                        continue;
                    }
                    case 4: {
                        class1.getMethod(string, Integer.TYPE).invoke(view, constraintAttribute.h);
                        continue;
                    }
                    case 3: {
                        class1.getMethod(string, CharSequence.class).invoke(view, constraintAttribute.f);
                        continue;
                    }
                    case 2: {
                        class1.getMethod(string, Boolean.TYPE).invoke(view, constraintAttribute.g);
                        continue;
                    }
                    case 1: {
                        class1.getMethod(string, Integer.TYPE).invoke(view, constraintAttribute.d);
                        continue;
                    }
                }
            }
            catch (final InvocationTargetException ex) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append(" Custom Attribute \"");
                sb2.append(s);
                sb2.append("\" not found on ");
                sb2.append(class1.getName());
                Log.e("TransitionLayout", sb2.toString());
                ex.printStackTrace();
            }
            catch (final IllegalAccessException ex2) {
                final StringBuilder sb3 = new StringBuilder();
                sb3.append(" Custom Attribute \"");
                sb3.append(s);
                sb3.append("\" not found on ");
                sb3.append(class1.getName());
                Log.e("TransitionLayout", sb3.toString());
                ex2.printStackTrace();
            }
            catch (final NoSuchMethodException ex3) {
                Log.e("TransitionLayout", ex3.getMessage());
                final StringBuilder sb4 = new StringBuilder();
                sb4.append(" Custom Attribute \"");
                sb4.append(s);
                sb4.append("\" not found on ");
                sb4.append(class1.getName());
                Log.e("TransitionLayout", sb4.toString());
                final StringBuilder sb5 = new StringBuilder();
                sb5.append(class1.getName());
                sb5.append(" must have a method ");
                sb5.append(string);
                Log.e("TransitionLayout", sb5.toString());
            }
        }
    }
    
    public void a(final View view) {
        final Class<? extends View> class1 = view.getClass();
        final String b = this.b;
        String string;
        if (!this.a) {
            final StringBuilder sb = new StringBuilder();
            sb.append("set");
            sb.append(b);
            string = sb.toString();
        }
        else {
            string = b;
        }
        try {
            switch (ConstraintAttribute$a.a[this.c.ordinal()]) {
                case 8: {
                    class1.getMethod(string, Float.TYPE).invoke(view, this.e);
                    break;
                }
                case 7: {
                    class1.getMethod(string, Float.TYPE).invoke(view, this.e);
                    break;
                }
                case 5: {
                    final Method method = class1.getMethod(string, Drawable.class);
                    final ColorDrawable colorDrawable = new ColorDrawable();
                    colorDrawable.setColor(this.h);
                    method.invoke(view, colorDrawable);
                    break;
                }
                case 4: {
                    class1.getMethod(string, Integer.TYPE).invoke(view, this.h);
                    break;
                }
                case 3: {
                    class1.getMethod(string, CharSequence.class).invoke(view, this.f);
                    break;
                }
                case 2: {
                    class1.getMethod(string, Boolean.TYPE).invoke(view, this.g);
                    break;
                }
                case 1:
                case 6: {
                    class1.getMethod(string, Integer.TYPE).invoke(view, this.d);
                    break;
                }
            }
        }
        catch (final InvocationTargetException ex) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append(" Custom Attribute \"");
            sb2.append(b);
            sb2.append("\" not found on ");
            sb2.append(class1.getName());
            Log.e("TransitionLayout", sb2.toString());
            ex.printStackTrace();
        }
        catch (final IllegalAccessException ex2) {
            final StringBuilder sb3 = new StringBuilder();
            sb3.append(" Custom Attribute \"");
            sb3.append(b);
            sb3.append("\" not found on ");
            sb3.append(class1.getName());
            Log.e("TransitionLayout", sb3.toString());
            ex2.printStackTrace();
        }
        catch (final NoSuchMethodException ex3) {
            Log.e("TransitionLayout", ex3.getMessage());
            final StringBuilder sb4 = new StringBuilder();
            sb4.append(" Custom Attribute \"");
            sb4.append(b);
            sb4.append("\" not found on ");
            sb4.append(class1.getName());
            Log.e("TransitionLayout", sb4.toString());
            final StringBuilder sb5 = new StringBuilder();
            sb5.append(class1.getName());
            sb5.append(" must have a method ");
            sb5.append(string);
            Log.e("TransitionLayout", sb5.toString());
        }
    }
    
    public String c() {
        return this.b;
    }
    
    public AttributeType d() {
        return this.c;
    }
    
    public float e() {
        switch (ConstraintAttribute$a.a[this.c.ordinal()]) {
            default: {
                return Float.NaN;
            }
            case 8: {
                return this.e;
            }
            case 7: {
                return this.e;
            }
            case 6: {
                return (float)this.d;
            }
            case 4:
            case 5: {
                throw new RuntimeException("Color does not have a single color to interpolate");
            }
            case 3: {
                throw new RuntimeException("Cannot interpolate String");
            }
            case 2: {
                float n;
                if (this.g) {
                    n = 1.0f;
                }
                else {
                    n = 0.0f;
                }
                return n;
            }
        }
    }
    
    public void f(final float[] array) {
        switch (ConstraintAttribute$a.a[this.c.ordinal()]) {
            case 8: {
                array[0] = this.e;
                break;
            }
            case 7: {
                array[0] = this.e;
                break;
            }
            case 6: {
                array[0] = (float)this.d;
                break;
            }
            case 4:
            case 5: {
                final int h = this.h;
                final float n = (float)Math.pow((h >> 16 & 0xFF) / 255.0f, 2.2);
                final float n2 = (float)Math.pow((h >> 8 & 0xFF) / 255.0f, 2.2);
                final float n3 = (float)Math.pow((h & 0xFF) / 255.0f, 2.2);
                array[0] = n;
                array[1] = n2;
                array[2] = n3;
                array[3] = (h >> 24 & 0xFF) / 255.0f;
                break;
            }
            case 3: {
                throw new RuntimeException("Color does not have a single color to interpolate");
            }
            case 2: {
                float n4;
                if (this.g) {
                    n4 = 1.0f;
                }
                else {
                    n4 = 0.0f;
                }
                array[0] = n4;
                break;
            }
        }
    }
    
    public int g() {
        final int n = ConstraintAttribute$a.a[this.c.ordinal()];
        if (n != 4 && n != 5) {
            return 1;
        }
        return 4;
    }
    
    public void j(final Object o) {
        switch (ConstraintAttribute$a.a[this.c.ordinal()]) {
            case 8: {
                this.e = (float)o;
                break;
            }
            case 7: {
                this.e = (float)o;
                break;
            }
            case 4:
            case 5: {
                this.h = (int)o;
                break;
            }
            case 3: {
                this.f = (String)o;
                break;
            }
            case 2: {
                this.g = (boolean)o;
                break;
            }
            case 1:
            case 6: {
                this.d = (int)o;
                break;
            }
        }
    }
    
    public enum AttributeType
    {
        private static final AttributeType[] $VALUES;
        
        BOOLEAN_TYPE, 
        COLOR_DRAWABLE_TYPE, 
        COLOR_TYPE, 
        DIMENSION_TYPE, 
        FLOAT_TYPE, 
        INT_TYPE, 
        REFERENCE_TYPE, 
        STRING_TYPE;
        
        static {
            $VALUES = a();
        }
        
        private static AttributeType[] a() {
            return new AttributeType[] { AttributeType.INT_TYPE, AttributeType.FLOAT_TYPE, AttributeType.COLOR_TYPE, AttributeType.COLOR_DRAWABLE_TYPE, AttributeType.STRING_TYPE, AttributeType.BOOLEAN_TYPE, AttributeType.DIMENSION_TYPE, AttributeType.REFERENCE_TYPE };
        }
    }
}
