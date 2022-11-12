// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core;

import com.google.firebase.database.connection.PersistentConnection;
import com.google.firebase.database.connection.HostInfo;
import com.google.firebase.database.connection.ConnectionContext;
import java.io.File;
import com.google.firebase.database.core.persistence.PersistenceManager;
import java.util.List;
import com.google.firebase.database.logging.Logger;

public interface Platform
{
    EventTarget a(final Context p0);
    
    Logger b(final Context p0, final Logger.Level p1, final List<String> p2);
    
    PersistenceManager c(final Context p0, final String p1);
    
    String d(final Context p0);
    
    File e();
    
    PersistentConnection f(final Context p0, final ConnectionContext p1, final HostInfo p2, final PersistentConnection.Delegate p3);
    
    RunLoop g(final Context p0);
}
