// 
// Decompiled by Procyon v0.6.0
// 

package z0;

import android.view.ViewGroup;

public class l
{
    private ViewGroup a;
    private Runnable b;
    
    public static l b(final ViewGroup viewGroup) {
        return (l)viewGroup.getTag(j.b);
    }
    
    static void c(final ViewGroup viewGroup, final l l) {
        viewGroup.setTag(j.b, (Object)l);
    }
    
    public void a() {
        if (b(this.a) == this) {
            final Runnable b = this.b;
            if (b != null) {
                b.run();
            }
        }
    }
}
