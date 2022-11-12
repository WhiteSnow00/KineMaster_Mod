// 
// Decompiled by Procyon v0.6.0
// 

package p2;

import android.content.Context;

final class e implements c
{
    private final Context a;
    final a b;
    
    e(final Context context, final a b) {
        this.a = context.getApplicationContext();
        this.b = b;
    }
    
    private void a() {
        s.a(this.a).d(this.b);
    }
    
    private void b() {
        s.a(this.a).e(this.b);
    }
    
    @Override
    public void onDestroy() {
    }
    
    @Override
    public void onStart() {
        this.a();
    }
    
    @Override
    public void onStop() {
        this.b();
    }
}
