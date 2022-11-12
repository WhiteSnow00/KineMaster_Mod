// 
// Decompiled by Procyon v0.6.0
// 

package r2;

import java.util.ArrayList;
import com.bumptech.glide.load.ImageHeaderParser;
import java.util.List;

public final class b
{
    private final List<ImageHeaderParser> a;
    
    public b() {
        this.a = new ArrayList<ImageHeaderParser>();
    }
    
    public void a(final ImageHeaderParser imageHeaderParser) {
        synchronized (this) {
            this.a.add(imageHeaderParser);
        }
    }
    
    public List<ImageHeaderParser> b() {
        synchronized (this) {
            return this.a;
        }
    }
}
