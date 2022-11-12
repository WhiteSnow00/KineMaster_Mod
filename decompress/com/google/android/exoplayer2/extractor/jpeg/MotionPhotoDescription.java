// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.jpeg;

import com.google.android.exoplayer2.metadata.mp4.MotionPhotoMetadata;
import java.util.List;

final class MotionPhotoDescription
{
    public final long a;
    public final List<ContainerItem> b;
    
    public MotionPhotoDescription(final long a, final List<ContainerItem> b) {
        this.a = a;
        this.b = b;
    }
    
    public MotionPhotoMetadata a(long n) {
        if (this.b.size() < 2) {
            return null;
        }
        int i = this.b.size() - 1;
        final long n2 = n;
        long n3 = -1L;
        long n4 = -1L;
        long n5;
        n = (n5 = n4);
        boolean b = false;
        long n6 = n;
        n = n2;
        while (i >= 0) {
            final ContainerItem containerItem = this.b.get(i);
            b |= "video/mp4".equals(containerItem.a);
            long n7;
            if (i == 0) {
                n7 = n - containerItem.d;
                n = 0L;
            }
            else {
                final long n8 = n - containerItem.c;
                n7 = n;
                n = n8;
            }
            if (b && n != n7) {
                n5 = n7 - n;
                n6 = n;
                b = false;
            }
            if (i == 0) {
                n3 = n;
                n4 = n7;
            }
            --i;
        }
        if (n6 != -1L && n5 != -1L && n3 != -1L && n4 != -1L) {
            return new MotionPhotoMetadata(n3, n4, this.a, n6, n5);
        }
        return null;
    }
    
    public static final class ContainerItem
    {
        public final String a;
        public final String b;
        public final long c;
        public final long d;
        
        public ContainerItem(final String a, final String b, final long c, final long d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }
    }
}
