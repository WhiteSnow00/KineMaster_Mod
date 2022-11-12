// 
// Decompiled by Procyon v0.6.0
// 

package p1;

import android.os.LocaleList;
import android.graphics.Xfermode;
import android.graphics.PorterDuffXfermode;
import android.graphics.PorterDuff$Mode;
import android.graphics.Paint;

public class a extends Paint
{
    public a() {
    }
    
    public a(final int n) {
        super(n);
    }
    
    public a(final int n, final PorterDuff$Mode porterDuff$Mode) {
        super(n);
        this.setXfermode((Xfermode)new PorterDuffXfermode(porterDuff$Mode));
    }
    
    public a(final PorterDuff$Mode porterDuff$Mode) {
        this.setXfermode((Xfermode)new PorterDuffXfermode(porterDuff$Mode));
    }
    
    public void setTextLocales(final LocaleList list) {
    }
}
