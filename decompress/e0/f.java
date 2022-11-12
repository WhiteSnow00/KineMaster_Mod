// 
// Decompiled by Procyon v0.6.0
// 

package e0;

import androidx.emoji2.text.e;
import android.text.method.PasswordTransformationMethod;
import android.util.SparseArray;
import android.text.method.TransformationMethod;
import android.text.InputFilter;
import androidx.core.util.h;
import android.widget.TextView;

public final class f
{
    private final b a;
    
    public f(final TextView textView, final boolean b) {
        h.h(textView, "textView cannot be null");
        if (!b) {
            this.a = (b)new c(textView);
        }
        else {
            this.a = (b)new a(textView);
        }
    }
    
    public InputFilter[] a(final InputFilter[] array) {
        return this.a.a(array);
    }
    
    public boolean b() {
        return this.a.b();
    }
    
    public void c(final boolean b) {
        this.a.c(b);
    }
    
    public void d(final boolean b) {
        this.a.d(b);
    }
    
    public TransformationMethod e(final TransformationMethod transformationMethod) {
        return this.a.e(transformationMethod);
    }
    
    private static class a extends b
    {
        private final TextView a;
        private final d b;
        private boolean c;
        
        a(final TextView a) {
            this.a = a;
            this.c = true;
            this.b = new d(a);
        }
        
        private InputFilter[] f(final InputFilter[] array) {
            final int length = array.length;
            for (int i = 0; i < length; ++i) {
                if (array[i] == this.b) {
                    return array;
                }
            }
            final InputFilter[] array2 = new InputFilter[array.length + 1];
            System.arraycopy(array, 0, array2, 0, length);
            array2[length] = (InputFilter)this.b;
            return array2;
        }
        
        private SparseArray<InputFilter> g(final InputFilter[] array) {
            final SparseArray sparseArray = new SparseArray(1);
            for (int i = 0; i < array.length; ++i) {
                if (array[i] instanceof d) {
                    sparseArray.put(i, (Object)array[i]);
                }
            }
            return (SparseArray<InputFilter>)sparseArray;
        }
        
        private InputFilter[] h(final InputFilter[] array) {
            final SparseArray<InputFilter> g = this.g(array);
            if (g.size() == 0) {
                return array;
            }
            final int length = array.length;
            final InputFilter[] array2 = new InputFilter[array.length - g.size()];
            int i = 0;
            int n = 0;
            while (i < length) {
                int n2 = n;
                if (g.indexOfKey(i) < 0) {
                    array2[n] = array[i];
                    n2 = n + 1;
                }
                ++i;
                n = n2;
            }
            return array2;
        }
        
        private TransformationMethod j(final TransformationMethod transformationMethod) {
            TransformationMethod a = transformationMethod;
            if (transformationMethod instanceof e0.h) {
                a = ((e0.h)transformationMethod).a();
            }
            return a;
        }
        
        private void k() {
            this.a.setFilters(this.a(this.a.getFilters()));
        }
        
        private TransformationMethod m(final TransformationMethod transformationMethod) {
            if (transformationMethod instanceof e0.h) {
                return transformationMethod;
            }
            if (transformationMethod instanceof PasswordTransformationMethod) {
                return transformationMethod;
            }
            return (TransformationMethod)new e0.h(transformationMethod);
        }
        
        @Override
        InputFilter[] a(final InputFilter[] array) {
            if (!this.c) {
                return this.h(array);
            }
            return this.f(array);
        }
        
        @Override
        public boolean b() {
            return this.c;
        }
        
        @Override
        void c(final boolean b) {
            if (b) {
                this.l();
            }
        }
        
        @Override
        void d(final boolean c) {
            this.c = c;
            this.l();
            this.k();
        }
        
        @Override
        TransformationMethod e(final TransformationMethod transformationMethod) {
            if (this.c) {
                return this.m(transformationMethod);
            }
            return this.j(transformationMethod);
        }
        
        void i(final boolean c) {
            this.c = c;
        }
        
        void l() {
            this.a.setTransformationMethod(this.e(this.a.getTransformationMethod()));
        }
    }
    
    static class b
    {
        InputFilter[] a(final InputFilter[] array) {
            throw null;
        }
        
        public boolean b() {
            throw null;
        }
        
        void c(final boolean b) {
            throw null;
        }
        
        void d(final boolean b) {
            throw null;
        }
        
        TransformationMethod e(final TransformationMethod transformationMethod) {
            throw null;
        }
    }
    
    private static class c extends b
    {
        private final a a;
        
        c(final TextView textView) {
            this.a = new a(textView);
        }
        
        private boolean f() {
            return e.h() ^ true;
        }
        
        @Override
        InputFilter[] a(final InputFilter[] array) {
            if (this.f()) {
                return array;
            }
            return this.a.a(array);
        }
        
        @Override
        public boolean b() {
            return this.a.b();
        }
        
        @Override
        void c(final boolean b) {
            if (this.f()) {
                return;
            }
            this.a.c(b);
        }
        
        @Override
        void d(final boolean b) {
            if (this.f()) {
                this.a.i(b);
            }
            else {
                this.a.d(b);
            }
        }
        
        @Override
        TransformationMethod e(final TransformationMethod transformationMethod) {
            if (this.f()) {
                return transformationMethod;
            }
            return this.a.e(transformationMethod);
        }
    }
}
