// 
// Decompiled by Procyon v0.6.0
// 

package d2;

import java.io.File;

class a
{
    public boolean a(final File file) {
        return file.exists();
    }
    
    public File b(final String s) {
        return new File(s);
    }
    
    public long c(final File file) {
        return file.length();
    }
}
