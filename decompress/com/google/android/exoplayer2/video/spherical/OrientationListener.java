// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.video.spherical;

import android.hardware.SensorEvent;
import android.hardware.Sensor;
import android.opengl.Matrix;
import android.hardware.SensorManager;
import android.view.Display;
import android.hardware.SensorEventListener;

final class OrientationListener implements SensorEventListener
{
    private final float[] a;
    private final float[] b;
    private final float[] c;
    private final float[] d;
    private final Display e;
    private final Listener[] f;
    private boolean g;
    
    public OrientationListener(final Display e, final Listener... f) {
        this.a = new float[16];
        this.b = new float[16];
        this.c = new float[16];
        this.d = new float[3];
        this.e = e;
        this.f = f;
    }
    
    private float a(final float[] array) {
        SensorManager.remapCoordinateSystem(array, 1, 131, this.b);
        SensorManager.getOrientation(this.b, this.d);
        return this.d[2];
    }
    
    private void b(final float[] array, final float n) {
        final Listener[] f = this.f;
        for (int length = f.length, i = 0; i < length; ++i) {
            f[i].a(array, n);
        }
    }
    
    private void c(final float[] array) {
        if (!this.g) {
            com.google.android.exoplayer2.video.spherical.a.a(this.c, array);
            this.g = true;
        }
        final float[] b = this.b;
        System.arraycopy(array, 0, b, 0, b.length);
        Matrix.multiplyMM(array, 0, this.b, 0, this.c, 0);
    }
    
    private void d(final float[] array, int n) {
        if (n != 0) {
            final int n2 = 130;
            final int n3 = 129;
            int n5;
            if (n != 1) {
                if (n != 2) {
                    if (n != 3) {
                        throw new IllegalStateException();
                    }
                    final int n4 = 1;
                    n = n2;
                    n5 = n4;
                }
                else {
                    n5 = 130;
                    n = 129;
                }
            }
            else {
                n = 2;
                n5 = n3;
            }
            final float[] b = this.b;
            System.arraycopy(array, 0, b, 0, b.length);
            SensorManager.remapCoordinateSystem(this.b, n, n5, array);
        }
    }
    
    private static void e(final float[] array) {
        Matrix.rotateM(array, 0, 90.0f, 1.0f, 0.0f, 0.0f);
    }
    
    public void onAccuracyChanged(final Sensor sensor, final int n) {
    }
    
    public void onSensorChanged(final SensorEvent sensorEvent) {
        SensorManager.getRotationMatrixFromVector(this.a, sensorEvent.values);
        this.d(this.a, this.e.getRotation());
        final float a = this.a(this.a);
        e(this.a);
        this.c(this.a);
        this.b(this.a, a);
    }
    
    public interface Listener
    {
        void a(final float[] p0, final float p1);
    }
}
