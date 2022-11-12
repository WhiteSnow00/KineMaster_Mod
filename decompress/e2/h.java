// 
// Decompiled by Procyon v0.6.0
// 

package e2;

public final class h implements a<int[]>
{
    @Override
    public int a() {
        return 4;
    }
    
    @Override
    public /* bridge */ int b(final Object o) {
        return this.c((int[])o);
    }
    
    public int c(final int[] array) {
        return array.length;
    }
    
    public int[] d(final int n) {
        return new int[n];
    }
    
    @Override
    public String getTag() {
        return "IntegerArrayPool";
    }
    
    @Override
    public /* bridge */ Object newArray(final int n) {
        return this.d(n);
    }
}
