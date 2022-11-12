// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.view;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.os.Handler;
import android.view.GestureDetector$OnGestureListener;
import android.content.Context;

public final class e
{
    private final a a;
    
    public e(final Context context, final GestureDetector$OnGestureListener gestureDetector$OnGestureListener) {
        this(context, gestureDetector$OnGestureListener, null);
    }
    
    public e(final Context context, final GestureDetector$OnGestureListener gestureDetector$OnGestureListener, final Handler handler) {
        this.a = (a)new b(context, gestureDetector$OnGestureListener, handler);
    }
    
    public boolean a(final MotionEvent motionEvent) {
        return this.a.onTouchEvent(motionEvent);
    }
    
    interface a
    {
        boolean onTouchEvent(final MotionEvent p0);
    }
    
    static class b implements a
    {
        private final GestureDetector a;
        
        b(final Context context, final GestureDetector$OnGestureListener gestureDetector$OnGestureListener, final Handler handler) {
            this.a = new GestureDetector(context, gestureDetector$OnGestureListener, handler);
        }
        
        @Override
        public boolean onTouchEvent(final MotionEvent motionEvent) {
            return this.a.onTouchEvent(motionEvent);
        }
    }
}
