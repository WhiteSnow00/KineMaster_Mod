// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.video.spherical;

import android.view.View;
import android.view.MotionEvent;
import android.view.GestureDetector$OnGestureListener;
import android.content.Context;
import android.view.GestureDetector;
import android.graphics.PointF;
import android.view.View$OnTouchListener;
import android.view.GestureDetector$SimpleOnGestureListener;

final class TouchTracker extends GestureDetector$SimpleOnGestureListener implements View$OnTouchListener, OrientationListener.Listener
{
    private final PointF a;
    private final PointF b;
    private final Listener c;
    private final float d;
    private final GestureDetector e;
    private volatile float f;
    
    public TouchTracker(final Context context, final Listener c, final float d) {
        this.a = new PointF();
        this.b = new PointF();
        this.c = c;
        this.d = d;
        this.e = new GestureDetector(context, (GestureDetector$OnGestureListener)this);
        this.f = 3.1415927f;
    }
    
    public void a(final float[] array, final float n) {
        this.f = -n;
    }
    
    public boolean onDown(final MotionEvent motionEvent) {
        this.a.set(motionEvent.getX(), motionEvent.getY());
        return true;
    }
    
    public boolean onScroll(final MotionEvent motionEvent, final MotionEvent motionEvent2, float y, float y2) {
        y = (motionEvent2.getX() - this.a.x) / this.d;
        y2 = motionEvent2.getY();
        final PointF a = this.a;
        final float n = (y2 - a.y) / this.d;
        a.set(motionEvent2.getX(), motionEvent2.getY());
        final double n2 = this.f;
        final float n3 = (float)Math.cos(n2);
        y2 = (float)Math.sin(n2);
        final PointF b = this.b;
        b.x -= n3 * y - y2 * n;
        y = b.y + (y2 * y + n3 * n);
        b.y = y;
        b.y = Math.max(-45.0f, Math.min(45.0f, y));
        this.c.b(this.b);
        return true;
    }
    
    public boolean onSingleTapUp(final MotionEvent motionEvent) {
        return this.c.onSingleTapUp(motionEvent);
    }
    
    public boolean onTouch(final View view, final MotionEvent motionEvent) {
        return this.e.onTouchEvent(motionEvent);
    }
    
    public interface Listener
    {
        void b(final PointF p0);
        
        default boolean onSingleTapUp(final MotionEvent motionEvent) {
            return false;
        }
    }
}
