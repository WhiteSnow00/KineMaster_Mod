// 
// Decompiled by Procyon v0.6.0
// 

package androidx.databinding;

abstract class b extends androidx.databinding.a
{
    public b() {
    }
    
    public b(final h... array) {
        if (array != null && array.length != 0) {
            final a a = new a();
            for (int i = 0; i < array.length; ++i) {
                array[i].addOnPropertyChangedCallback((h.a)a);
            }
        }
    }
    
    class a extends h.a
    {
        final b a;
        
        a(final b a) {
            this.a = a;
        }
        
        @Override
        public void a(final h h, final int n) {
            this.a.notifyChange();
        }
    }
}
