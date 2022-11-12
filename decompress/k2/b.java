// 
// Decompiled by Procyon v0.6.0
// 

package k2;

import v2.k;
import com.bumptech.glide.load.engine.s;

public class b implements s<byte[]>
{
    private final byte[] a;
    
    public b(final byte[] array) {
        this.a = k.d(array);
    }
    
    @Override
    public int a() {
        return this.a.length;
    }
    
    @Override
    public void b() {
    }
    
    @Override
    public Class<byte[]> c() {
        return byte[].class;
    }
    
    public byte[] d() {
        return this.a;
    }
    
    @Override
    public /* bridge */ Object get() {
        return this.d();
    }
}
