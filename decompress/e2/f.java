// 
// Decompiled by Procyon v0.6.0
// 

package e2;

public final class f implements a<byte[]>
{
    @Override
    public int a() {
        return 1;
    }
    
    @Override
    public /* bridge */ int b(final Object o) {
        return this.c((byte[])o);
    }
    
    public int c(final byte[] array) {
        return array.length;
    }
    
    public byte[] d(final int n) {
        return new byte[n];
    }
    
    @Override
    public String getTag() {
        return "ByteArrayPool";
    }
    
    @Override
    public /* bridge */ Object newArray(final int n) {
        return this.d(n);
    }
}
