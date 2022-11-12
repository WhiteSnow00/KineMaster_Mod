// 
// Decompiled by Procyon v0.6.0
// 

package g3;

import f3.f;

public class g extends f3.g
{
    @Override
    public void N(final f... array) {
        int i = 0;
        while (i < array.length) {
            final f f = array[i];
            ++i;
            f.t(i * 200);
        }
    }
    
    @Override
    public f[] O() {
        return new f[] { new i(), new i(), new i() };
    }
}
