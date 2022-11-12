// 
// Decompiled by Procyon v0.6.0
// 

package t0;

import java.io.IOException;
import java.io.FileOutputStream;
import java.util.concurrent.locks.ReentrantLock;
import java.util.HashMap;
import java.nio.channels.FileChannel;
import java.io.File;
import java.util.concurrent.locks.Lock;
import java.util.Map;

public class a
{
    private static final Map<String, Lock> e;
    private final File a;
    private final Lock b;
    private final boolean c;
    private FileChannel d;
    
    static {
        e = new HashMap<String, Lock>();
    }
    
    public a(final String s, final File file, final boolean c) {
        final StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.append(".lck");
        final File a = new File(file, sb.toString());
        this.a = a;
        this.b = a(a.getAbsolutePath());
        this.c = c;
    }
    
    private static Lock a(final String s) {
        final Map<String, Lock> e = a.e;
        synchronized (e) {
            Lock lock;
            if ((lock = e.get(s)) == null) {
                lock = new ReentrantLock();
                e.put(s, lock);
            }
            return lock;
        }
    }
    
    public void b() {
        this.b.lock();
        if (this.c) {
            try {
                (this.d = new FileOutputStream(this.a).getChannel()).lock();
            }
            catch (final IOException ex) {
                throw new IllegalStateException("Unable to grab copy lock.", ex);
            }
        }
    }
    
    public void c() {
        final FileChannel d = this.d;
        while (true) {
            if (d == null) {
                break Label_0013;
            }
            try {
                d.close();
                this.b.unlock();
            }
            catch (final IOException ex) {
                continue;
            }
            break;
        }
    }
}
