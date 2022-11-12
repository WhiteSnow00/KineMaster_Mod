// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source;

import java.util.Arrays;
import java.util.Random;

public interface ShuffleOrder
{
    ShuffleOrder a(final int p0, final int p1);
    
    int b(final int p0);
    
    int c(final int p0);
    
    int d();
    
    ShuffleOrder e();
    
    int f();
    
    ShuffleOrder g(final int p0, final int p1);
    
    int getLength();
    
    public static class DefaultShuffleOrder implements ShuffleOrder
    {
        private final Random a;
        private final int[] b;
        private final int[] c;
        
        public DefaultShuffleOrder(final int n) {
            this(n, new Random());
        }
        
        private DefaultShuffleOrder(final int n, final Random random) {
            this(h(n, random), random);
        }
        
        private DefaultShuffleOrder(final int[] b, final Random a) {
            this.b = b;
            this.a = a;
            this.c = new int[b.length];
            for (int i = 0; i < b.length; ++i) {
                this.c[b[i]] = i;
            }
        }
        
        private static int[] h(final int n, final Random random) {
            final int[] array = new int[n];
            int n2;
            for (int i = 0; i < n; i = n2) {
                n2 = i + 1;
                final int nextInt = random.nextInt(n2);
                array[i] = array[nextInt];
                array[nextInt] = i;
            }
            return array;
        }
        
        @Override
        public ShuffleOrder a(final int n, final int n2) {
            final int n3 = n2 - n;
            final int[] array = new int[this.b.length - n3];
            int n4 = 0;
            int n5 = 0;
            while (true) {
                final int[] b = this.b;
                if (n4 >= b.length) {
                    break;
                }
                if (b[n4] >= n && b[n4] < n2) {
                    ++n5;
                }
                else {
                    int n6;
                    if (b[n4] >= n) {
                        n6 = b[n4] - n3;
                    }
                    else {
                        n6 = b[n4];
                    }
                    array[n4 - n5] = n6;
                }
                ++n4;
            }
            return new DefaultShuffleOrder(array, new Random(this.a.nextLong()));
        }
        
        @Override
        public int b(int n) {
            int n2 = this.c[n];
            n = -1;
            if (--n2 >= 0) {
                n = this.b[n2];
            }
            return n;
        }
        
        @Override
        public int c(int n) {
            n = this.c[n] + 1;
            final int[] b = this.b;
            if (n < b.length) {
                n = b[n];
            }
            else {
                n = -1;
            }
            return n;
        }
        
        @Override
        public int d() {
            final int[] b = this.b;
            int n;
            if (b.length > 0) {
                n = b[b.length - 1];
            }
            else {
                n = -1;
            }
            return n;
        }
        
        @Override
        public ShuffleOrder e() {
            return new DefaultShuffleOrder(0, new Random(this.a.nextLong()));
        }
        
        @Override
        public int f() {
            final int[] b = this.b;
            int n;
            if (b.length > 0) {
                n = b[0];
            }
            else {
                n = -1;
            }
            return n;
        }
        
        @Override
        public ShuffleOrder g(final int n, final int n2) {
            final int[] array = new int[n2];
            final int[] array2 = new int[n2];
            int n3 = 0;
            int n4;
            for (int i = 0; i < n2; i = n4) {
                array[i] = this.a.nextInt(this.b.length + 1);
                final Random a = this.a;
                n4 = i + 1;
                final int nextInt = a.nextInt(n4);
                array2[i] = array2[nextInt];
                array2[nextInt] = i + n;
            }
            Arrays.sort(array);
            final int[] array3 = new int[this.b.length + n2];
            int n5 = 0;
            int n6 = 0;
            while (true) {
                final int[] b = this.b;
                if (n3 >= b.length + n2) {
                    break;
                }
                if (n5 < n2 && n6 == array[n5]) {
                    array3[n3] = array2[n5];
                    ++n5;
                }
                else {
                    array3[n3] = b[n6];
                    if (array3[n3] >= n) {
                        array3[n3] += n2;
                    }
                    ++n6;
                }
                ++n3;
            }
            return new DefaultShuffleOrder(array3, new Random(this.a.nextLong()));
        }
        
        @Override
        public int getLength() {
            return this.b.length;
        }
    }
    
    public static final class UnshuffledShuffleOrder implements ShuffleOrder
    {
        private final int a;
        
        public UnshuffledShuffleOrder(final int a) {
            this.a = a;
        }
        
        @Override
        public ShuffleOrder a(final int n, final int n2) {
            return new UnshuffledShuffleOrder(this.a - n2 + n);
        }
        
        @Override
        public int b(int n) {
            final int n2 = -1;
            final int n3 = n - 1;
            n = n2;
            if (n3 >= 0) {
                n = n3;
            }
            return n;
        }
        
        @Override
        public int c(int n) {
            if (++n >= this.a) {
                n = -1;
            }
            return n;
        }
        
        @Override
        public int d() {
            int a = this.a;
            if (a > 0) {
                --a;
            }
            else {
                a = -1;
            }
            return a;
        }
        
        @Override
        public ShuffleOrder e() {
            return new UnshuffledShuffleOrder(0);
        }
        
        @Override
        public int f() {
            int n;
            if (this.a > 0) {
                n = 0;
            }
            else {
                n = -1;
            }
            return n;
        }
        
        @Override
        public ShuffleOrder g(final int n, final int n2) {
            return new UnshuffledShuffleOrder(this.a + n2);
        }
        
        @Override
        public int getLength() {
            return this.a;
        }
    }
}
