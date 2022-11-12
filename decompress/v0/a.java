// 
// Decompiled by Procyon v0.6.0
// 

package v0;

public final class a implements j
{
    private final String a;
    private final Object[] b;
    
    public a(final String s) {
        this(s, null);
    }
    
    public a(final String a, final Object[] b) {
        this.a = a;
        this.b = b;
    }
    
    private static void b(final i i, final int n, final Object o) {
        if (o == null) {
            i.m1(n);
        }
        else if (o instanceof byte[]) {
            i.V0(n, (byte[])o);
        }
        else if (o instanceof Float) {
            i.G(n, (float)o);
        }
        else if (o instanceof Double) {
            i.G(n, (double)o);
        }
        else if (o instanceof Long) {
            i.U0(n, (long)o);
        }
        else if (o instanceof Integer) {
            i.U0(n, (int)o);
        }
        else if (o instanceof Short) {
            i.U0(n, (short)o);
        }
        else if (o instanceof Byte) {
            i.U0(n, (byte)o);
        }
        else if (o instanceof String) {
            i.E0(n, (String)o);
        }
        else {
            if (!(o instanceof Boolean)) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Cannot bind ");
                sb.append(o);
                sb.append(" at index ");
                sb.append(n);
                sb.append(" Supported types: null, byte[], float, double, long, int, short, byte, string");
                throw new IllegalArgumentException(sb.toString());
            }
            long n2;
            if (o) {
                n2 = 1L;
            }
            else {
                n2 = 0L;
            }
            i.U0(n, n2);
        }
    }
    
    public static void e(final i i, final Object[] array) {
        if (array == null) {
            return;
        }
        final int length = array.length;
        int j = 0;
        while (j < length) {
            final Object o = array[j];
            ++j;
            b(i, j, o);
        }
    }
    
    @Override
    public int a() {
        final Object[] b = this.b;
        int length;
        if (b == null) {
            length = 0;
        }
        else {
            length = b.length;
        }
        return length;
    }
    
    @Override
    public String c() {
        return this.a;
    }
    
    @Override
    public void d(final i i) {
        e(i, this.b);
    }
}
