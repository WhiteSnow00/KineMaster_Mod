// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import javax.inject.Inject;
import android.database.sqlite.SQLiteDatabase$CursorFactory;
import javax.inject.Named;
import android.content.Context;
import java.util.Arrays;
import java.util.List;
import android.database.sqlite.SQLiteOpenHelper;

final class SchemaManager extends SQLiteOpenHelper
{
    private static final String c;
    static int d;
    private static final Migration e;
    private static final Migration f;
    private static final Migration g;
    private static final Migration h;
    private static final Migration i;
    private static final List<Migration> j;
    private final int a;
    private boolean b;
    
    static {
        final StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO global_log_event_state VALUES (");
        sb.append(System.currentTimeMillis());
        sb.append(")");
        c = sb.toString();
        SchemaManager.d = 5;
        j = Arrays.asList(e = (Migration)h0.a, f = (Migration)e0.a, g = (Migration)f0.a, h = (Migration)g0.a, i = (Migration)i0.a);
    }
    
    @Inject
    SchemaManager(final Context context, @Named final String s, @Named final int a) {
        super(context, s, (SQLiteDatabase$CursorFactory)null, a);
        this.b = false;
        this.a = a;
    }
    
    public static void a(final SQLiteDatabase sqLiteDatabase) {
        k(sqLiteDatabase);
    }
    
    public static void c(final SQLiteDatabase sqLiteDatabase) {
        l(sqLiteDatabase);
    }
    
    public static void d(final SQLiteDatabase sqLiteDatabase) {
        r(sqLiteDatabase);
    }
    
    public static void e(final SQLiteDatabase sqLiteDatabase) {
        j(sqLiteDatabase);
    }
    
    public static void h(final SQLiteDatabase sqLiteDatabase) {
        s(sqLiteDatabase);
    }
    
    private void i(final SQLiteDatabase sqLiteDatabase) {
        if (!this.b) {
            this.onConfigure(sqLiteDatabase);
        }
    }
    
    private static void j(final SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE events (_id INTEGER PRIMARY KEY, context_id INTEGER NOT NULL, transport_name TEXT NOT NULL, timestamp_ms INTEGER NOT NULL, uptime_ms INTEGER NOT NULL, payload BLOB NOT NULL, code INTEGER, num_attempts INTEGER NOT NULL,FOREIGN KEY (context_id) REFERENCES transport_contexts(_id) ON DELETE CASCADE)");
        sqLiteDatabase.execSQL("CREATE TABLE event_metadata (_id INTEGER PRIMARY KEY, event_id INTEGER NOT NULL, name TEXT NOT NULL, value TEXT NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE)");
        sqLiteDatabase.execSQL("CREATE TABLE transport_contexts (_id INTEGER PRIMARY KEY, backend_name TEXT NOT NULL, priority INTEGER NOT NULL, next_request_ms INTEGER NOT NULL)");
        sqLiteDatabase.execSQL("CREATE INDEX events_backend_id on events(context_id)");
        sqLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority on transport_contexts(backend_name, priority)");
    }
    
    private static void k(final SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("ALTER TABLE transport_contexts ADD COLUMN extras BLOB");
        sqLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority_extras on transport_contexts(backend_name, priority, extras)");
        sqLiteDatabase.execSQL("DROP INDEX contexts_backend_priority");
    }
    
    private static void l(final SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN payload_encoding TEXT");
    }
    
    private static void r(final SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN inline BOOLEAN NOT NULL DEFAULT 1");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        sqLiteDatabase.execSQL("CREATE TABLE event_payloads (sequence_num INTEGER NOT NULL, event_id INTEGER NOT NULL, bytes BLOB NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE,PRIMARY KEY (sequence_num, event_id))");
    }
    
    private static void s(final SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS log_event_dropped");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS global_log_event_state");
        sqLiteDatabase.execSQL("CREATE TABLE log_event_dropped (log_source VARCHAR(45) NOT NULL,reason INTEGER NOT NULL,events_dropped_count BIGINT NOT NULL,PRIMARY KEY(log_source, reason))");
        sqLiteDatabase.execSQL("CREATE TABLE global_log_event_state (last_metrics_upload_ms BIGINT PRIMARY KEY)");
        sqLiteDatabase.execSQL(SchemaManager.c);
    }
    
    private void t(final SQLiteDatabase sqLiteDatabase, final int n) {
        this.i(sqLiteDatabase);
        this.u(sqLiteDatabase, 0, n);
    }
    
    private void u(final SQLiteDatabase sqLiteDatabase, int i, final int n) {
        final List<Migration> j = SchemaManager.j;
        if (n <= j.size()) {
            while (i < n) {
                SchemaManager.j.get(i).a(sqLiteDatabase);
                ++i;
            }
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Migration from ");
        sb.append(i);
        sb.append(" to ");
        sb.append(n);
        sb.append(" was requested, but cannot be performed. Only ");
        sb.append(j.size());
        sb.append(" migrations are provided");
        throw new IllegalArgumentException(sb.toString());
    }
    
    public void onConfigure(final SQLiteDatabase sqLiteDatabase) {
        this.b = true;
        sqLiteDatabase.rawQuery("PRAGMA busy_timeout=0;", new String[0]).close();
        sqLiteDatabase.setForeignKeyConstraintsEnabled(true);
    }
    
    public void onCreate(final SQLiteDatabase sqLiteDatabase) {
        this.t(sqLiteDatabase, this.a);
    }
    
    public void onDowngrade(final SQLiteDatabase sqLiteDatabase, final int n, final int n2) {
        sqLiteDatabase.execSQL("DROP TABLE events");
        sqLiteDatabase.execSQL("DROP TABLE event_metadata");
        sqLiteDatabase.execSQL("DROP TABLE transport_contexts");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS log_event_dropped");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS global_log_event_state");
        this.t(sqLiteDatabase, n2);
    }
    
    public void onOpen(final SQLiteDatabase sqLiteDatabase) {
        this.i(sqLiteDatabase);
    }
    
    public void onUpgrade(final SQLiteDatabase sqLiteDatabase, final int n, final int n2) {
        this.i(sqLiteDatabase);
        this.u(sqLiteDatabase, n, n2);
    }
    
    public interface Migration
    {
        void a(final SQLiteDatabase p0);
    }
}
