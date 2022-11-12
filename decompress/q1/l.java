// 
// Decompiled by Procyon v0.6.0
// 

package q1;

import java.util.ListIterator;
import android.graphics.Path$Op;
import java.util.ArrayList;
import com.airbnb.lottie.model.content.MergePaths;
import java.util.List;
import android.graphics.Path;

public class l implements m, j
{
    private final Path a;
    private final Path b;
    private final Path c;
    private final String d;
    private final List<m> e;
    private final MergePaths f;
    
    public l(final MergePaths f) {
        this.a = new Path();
        this.b = new Path();
        this.c = new Path();
        this.e = new ArrayList<m>();
        this.d = f.c();
        this.f = f;
    }
    
    private void a() {
        for (int i = 0; i < this.e.size(); ++i) {
            this.c.addPath(this.e.get(i).getPath());
        }
    }
    
    private void c(final Path$Op path$Op) {
        this.b.reset();
        this.a.reset();
        for (int i = this.e.size() - 1; i >= 1; --i) {
            final m m = this.e.get(i);
            if (m instanceof d) {
                final d d = (d)m;
                final List<m> j = d.i();
                for (int k = j.size() - 1; k >= 0; --k) {
                    final Path path = j.get(k).getPath();
                    path.transform(d.j());
                    this.b.addPath(path);
                }
            }
            else {
                this.b.addPath(m.getPath());
            }
        }
        final List<m> e = this.e;
        int l = 0;
        final m m2 = e.get(0);
        if (m2 instanceof d) {
            final d d2 = (d)m2;
            for (List<m> i2 = d2.i(); l < i2.size(); ++l) {
                final Path path2 = i2.get(l).getPath();
                path2.transform(d2.j());
                this.a.addPath(path2);
            }
        }
        else {
            this.a.set(m2.getPath());
        }
        this.c.op(this.a, this.b, path$Op);
    }
    
    @Override
    public void b(final List<c> list, final List<c> list2) {
        for (int i = 0; i < this.e.size(); ++i) {
            this.e.get(i).b(list, list2);
        }
    }
    
    @Override
    public void f(final ListIterator<c> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {}
        while (listIterator.hasPrevious()) {
            final c c = listIterator.previous();
            if (c instanceof m) {
                this.e.add((m)c);
                listIterator.remove();
            }
        }
    }
    
    @Override
    public Path getPath() {
        this.c.reset();
        if (this.f.d()) {
            return this.c;
        }
        final int n = l$a.a[this.f.b().ordinal()];
        if (n != 1) {
            if (n != 2) {
                if (n != 3) {
                    if (n != 4) {
                        if (n == 5) {
                            this.c(Path$Op.XOR);
                        }
                    }
                    else {
                        this.c(Path$Op.INTERSECT);
                    }
                }
                else {
                    this.c(Path$Op.REVERSE_DIFFERENCE);
                }
            }
            else {
                this.c(Path$Op.UNION);
            }
        }
        else {
            this.a();
        }
        return this.c;
    }
}
