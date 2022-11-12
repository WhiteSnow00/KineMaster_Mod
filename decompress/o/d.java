// 
// Decompiled by Procyon v0.6.0
// 

package o;

import java.util.Arrays;
import java.util.HashMap;

public class d
{
    HashMap<Object, HashMap<String, float[]>> a;
    
    public d() {
        this.a = new HashMap<Object, HashMap<String, float[]>>();
    }
    
    public float a(final Object o, final String s, final int n) {
        if (!this.a.containsKey(o)) {
            return Float.NaN;
        }
        final HashMap hashMap = this.a.get(o);
        if (hashMap != null) {
            if (hashMap.containsKey(s)) {
                final float[] array = (float[])hashMap.get(s);
                if (array == null) {
                    return Float.NaN;
                }
                if (array.length > n) {
                    return array[n];
                }
            }
        }
        return Float.NaN;
    }
    
    public void b(final Object o, final String s, final int n, final float n2) {
        if (!this.a.containsKey(o)) {
            final HashMap hashMap = new HashMap();
            final float[] array = new float[n + 1];
            array[n] = n2;
            hashMap.put(s, array);
            this.a.put(o, hashMap);
        }
        else {
            HashMap hashMap2;
            if ((hashMap2 = this.a.get(o)) == null) {
                hashMap2 = new HashMap();
            }
            if (!hashMap2.containsKey(s)) {
                final float[] array2 = new float[n + 1];
                array2[n] = n2;
                hashMap2.put(s, array2);
                this.a.put(o, hashMap2);
            }
            else {
                float[] array3;
                if ((array3 = (float[])hashMap2.get(s)) == null) {
                    array3 = new float[0];
                }
                float[] copy = array3;
                if (array3.length <= n) {
                    copy = Arrays.copyOf(array3, n + 1);
                }
                copy[n] = n2;
                hashMap2.put(s, copy);
            }
        }
    }
}
