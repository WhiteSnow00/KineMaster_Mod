// 
// Decompiled by Procyon v0.6.0
// 

package v0;

import android.util.Pair;
import java.util.List;
import android.os.CancellationSignal;
import android.database.SQLException;
import android.database.Cursor;
import java.io.Closeable;

public interface g extends Closeable
{
    k H0(final String p0);
    
    Cursor J(final j p0);
    
    void T(final String p0, final Object[] p1) throws SQLException;
    
    void U();
    
    Cursor Z0(final String p0);
    
    String getPath();
    
    boolean isOpen();
    
    void m();
    
    void p();
    
    void q();
    
    boolean q1();
    
    Cursor u0(final j p0, final CancellationSignal p1);
    
    List<Pair<String, String>> x();
    
    void z(final String p0) throws SQLException;
    
    boolean z1();
}
