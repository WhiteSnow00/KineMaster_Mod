// 
// Decompiled by Procyon v0.6.0
// 

package androidx.room;

import v0.h;

final class m implements c
{
    private final c a;
    private final androidx.room.a b;
    
    m(final c a, final androidx.room.a b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public /* bridge */ h a(final b b) {
        return this.b(b);
    }
    
    public i b(final b b) {
        return new i(this.a.a(b), this.b);
    }
}
