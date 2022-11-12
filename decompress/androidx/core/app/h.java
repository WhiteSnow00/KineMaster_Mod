// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.app;

import java.util.Iterator;
import android.view.FrameMetrics;
import android.view.Window;
import android.view.Window$OnFrameMetricsAvailableListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseIntArray;
import android.app.Activity;

public class h
{
    private final b a;
    
    public h() {
        this(1);
    }
    
    public h(final int n) {
        this.a = (b)new a(n);
    }
    
    public void a(final Activity activity) {
        this.a.a(activity);
    }
    
    public SparseIntArray[] b() {
        return this.a.b();
    }
    
    public SparseIntArray[] c(final Activity activity) {
        return this.a.c(activity);
    }
    
    public SparseIntArray[] d() {
        return this.a.d();
    }
    
    private static class a extends b
    {
        private static HandlerThread e;
        private static Handler f;
        int a;
        SparseIntArray[] b;
        private final ArrayList<WeakReference<Activity>> c;
        Window$OnFrameMetricsAvailableListener d;
        
        a(final int a) {
            this.b = new SparseIntArray[9];
            this.c = new ArrayList<WeakReference<Activity>>();
            this.d = (Window$OnFrameMetricsAvailableListener)new Window$OnFrameMetricsAvailableListener() {
                final a a;
                
                public void onFrameMetricsAvailable(final Window window, final FrameMetrics frameMetrics, final int n) {
                    final a a = this.a;
                    if ((a.a & 0x1) != 0x0) {
                        a.e(a.b[0], frameMetrics.getMetric(8));
                    }
                    final a a2 = this.a;
                    if ((a2.a & 0x2) != 0x0) {
                        a2.e(a2.b[1], frameMetrics.getMetric(1));
                    }
                    final a a3 = this.a;
                    if ((a3.a & 0x4) != 0x0) {
                        a3.e(a3.b[2], frameMetrics.getMetric(3));
                    }
                    final a a4 = this.a;
                    if ((a4.a & 0x8) != 0x0) {
                        a4.e(a4.b[3], frameMetrics.getMetric(4));
                    }
                    final a a5 = this.a;
                    if ((a5.a & 0x10) != 0x0) {
                        a5.e(a5.b[4], frameMetrics.getMetric(5));
                    }
                    final a a6 = this.a;
                    if ((a6.a & 0x40) != 0x0) {
                        a6.e(a6.b[6], frameMetrics.getMetric(7));
                    }
                    final a a7 = this.a;
                    if ((a7.a & 0x20) != 0x0) {
                        a7.e(a7.b[5], frameMetrics.getMetric(6));
                    }
                    final a a8 = this.a;
                    if ((a8.a & 0x80) != 0x0) {
                        a8.e(a8.b[7], frameMetrics.getMetric(0));
                    }
                    final a a9 = this.a;
                    if ((a9.a & 0x100) != 0x0) {
                        a9.e(a9.b[8], frameMetrics.getMetric(2));
                    }
                }
            };
            this.a = a;
        }
        
        @Override
        public void a(final Activity activity) {
            if (h.a.e == null) {
                (h.a.e = new HandlerThread("FrameMetricsAggregator")).start();
                h.a.f = new Handler(h.a.e.getLooper());
            }
            for (int i = 0; i <= 8; ++i) {
                final SparseIntArray[] b = this.b;
                if (b[i] == null && (this.a & 1 << i) != 0x0) {
                    b[i] = new SparseIntArray();
                }
            }
            activity.getWindow().addOnFrameMetricsAvailableListener(this.d, h.a.f);
            this.c.add(new WeakReference<Activity>(activity));
        }
        
        @Override
        public SparseIntArray[] b() {
            return this.b;
        }
        
        @Override
        public SparseIntArray[] c(final Activity activity) {
            for (final WeakReference weakReference : this.c) {
                if (weakReference.get() == activity) {
                    this.c.remove(weakReference);
                    break;
                }
            }
            activity.getWindow().removeOnFrameMetricsAvailableListener(this.d);
            return this.b;
        }
        
        @Override
        public SparseIntArray[] d() {
            final SparseIntArray[] b = this.b;
            this.b = new SparseIntArray[9];
            return b;
        }
        
        void e(final SparseIntArray sparseIntArray, final long n) {
            if (sparseIntArray != null) {
                final int n2 = (int)((500000L + n) / 1000000L);
                if (n >= 0L) {
                    sparseIntArray.put(n2, sparseIntArray.get(n2) + 1);
                }
            }
        }
    }
    
    private static class b
    {
        b() {
        }
        
        public void a(final Activity activity) {
            throw null;
        }
        
        public SparseIntArray[] b() {
            throw null;
        }
        
        public SparseIntArray[] c(final Activity activity) {
            throw null;
        }
        
        public SparseIntArray[] d() {
            throw null;
        }
    }
}
