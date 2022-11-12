// 
// Decompiled by Procyon v0.6.0
// 

package androidx.room;

import android.util.Pair;
import android.os.CancellationSignal;
import java.io.IOException;
import android.database.SQLException;
import java.util.Collection;
import java.util.Arrays;
import v0.i;
import android.database.Cursor;
import v0.k;
import java.util.ArrayList;
import v0.j;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import v0.g;

final class h0 implements g
{
    private final g a;
    private final RoomDatabase.e b;
    private final Executor c;
    
    h0(final g a, final RoomDatabase.e b, final Executor c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    private void E(final String s, final List list) {
        this.b.a(s, list);
    }
    
    private void F(final String s) {
        this.b.a(s, Collections.emptyList());
    }
    
    private void L(final j j, final k0 k0) {
        this.b.a(j.c(), k0.a());
    }
    
    private void M(final j j, final k0 k0) {
        this.b.a(j.c(), k0.a());
    }
    
    private void O() {
        this.b.a("TRANSACTION SUCCESSFUL", Collections.emptyList());
    }
    
    public static void a(final h0 h0) {
        h0.t();
    }
    
    public static void c(final h0 h0) {
        h0.s();
    }
    
    public static void d(final h0 h0) {
        h0.O();
    }
    
    public static void e(final h0 h0, final String s, final List list) {
        h0.E(s, list);
    }
    
    public static void h(final h0 h0, final String s) {
        h0.u(s);
    }
    
    public static void i(final h0 h0, final j j, final k0 k0) {
        h0.L(j, k0);
    }
    
    public static void j(final h0 h0, final String s) {
        h0.F(s);
    }
    
    public static void k(final h0 h0, final j j, final k0 k0) {
        h0.M(j, k0);
    }
    
    public static void l(final h0 h0) {
        h0.r();
    }
    
    private void r() {
        this.b.a("BEGIN EXCLUSIVE TRANSACTION", Collections.emptyList());
    }
    
    private void s() {
        this.b.a("BEGIN DEFERRED TRANSACTION", Collections.emptyList());
    }
    
    private void t() {
        this.b.a("END TRANSACTION", Collections.emptyList());
    }
    
    private void u(final String s) {
        this.b.a(s, new ArrayList<Object>(0));
    }
    
    @Override
    public k H0(final String s) {
        return new n0(this.a.H0(s), this.b, s, this.c);
    }
    
    @Override
    public Cursor J(final j j) {
        final k0 k0 = new k0();
        j.d(k0);
        this.c.execute(new f0(this, j, k0));
        return this.a.J(j);
    }
    
    @Override
    public void T(final String s, final Object[] array) throws SQLException {
        final ArrayList list = new ArrayList();
        list.addAll(Arrays.asList(array));
        this.c.execute(new e0(this, s, list));
        this.a.T(s, list.toArray());
    }
    
    @Override
    public void U() {
        this.c.execute(new z(this));
        this.a.U();
    }
    
    @Override
    public Cursor Z0(final String s) {
        this.c.execute(new d0(this, s));
        return this.a.Z0(s);
    }
    
    @Override
    public void close() throws IOException {
        this.a.close();
    }
    
    @Override
    public String getPath() {
        return this.a.getPath();
    }
    
    @Override
    public boolean isOpen() {
        return this.a.isOpen();
    }
    
    @Override
    public void m() {
        this.c.execute(new b0(this));
        this.a.m();
    }
    
    @Override
    public void p() {
        this.c.execute(new a0(this));
        this.a.p();
    }
    
    @Override
    public void q() {
        this.c.execute(new y(this));
        this.a.q();
    }
    
    @Override
    public boolean q1() {
        return this.a.q1();
    }
    
    @Override
    public Cursor u0(final j j, final CancellationSignal cancellationSignal) {
        final k0 k0 = new k0();
        j.d(k0);
        this.c.execute(new g0(this, j, k0));
        return this.a.J(j);
    }
    
    @Override
    public List<Pair<String, String>> x() {
        return this.a.x();
    }
    
    @Override
    public void z(final String s) throws SQLException {
        this.c.execute(new c0(this, s));
        this.a.z(s);
    }
    
    @Override
    public boolean z1() {
        return this.a.z1();
    }
}
