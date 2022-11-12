// 
// Decompiled by Procyon v0.6.0
// 

package m2;

import java.io.IOException;
import com.bumptech.glide.load.engine.s;
import c2.e;
import java.io.File;
import c2.f;

public class a implements f<File, File>
{
    @Override
    public /* bridge */ s a(final Object o, final int n, final int n2, final e e) throws IOException {
        return this.c((File)o, n, n2, e);
    }
    
    @Override
    public /* bridge */ boolean b(final Object o, final e e) throws IOException {
        return this.d((File)o, e);
    }
    
    public s<File> c(final File file, final int n, final int n2, final e e) {
        return new b(file);
    }
    
    public boolean d(final File file, final e e) {
        return true;
    }
}
