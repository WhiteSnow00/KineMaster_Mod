// 
// Decompiled by Procyon v0.6.0
// 

package h1;

import androidx.work.impl.WorkDatabase;
import androidx.room.RoomDatabase;
import androidx.work.OutOfQuotaPolicy;
import m1.p;
import m1.q;
import android.text.TextUtils;
import java.util.HashSet;
import android.os.PersistableBundle;
import android.content.ComponentName;
import androidx.work.impl.background.systemjob.SystemJobService;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Iterator;
import java.util.List;
import android.app.job.JobInfo;
import e1.h;
import f1.i;
import android.app.job.JobScheduler;
import android.content.Context;
import f1.e;

public class b implements e
{
    private static final String e;
    private final Context a;
    private final JobScheduler b;
    private final i c;
    private final a d;
    
    static {
        e = h.f("SystemJobScheduler");
    }
    
    public b(final Context context, final i i) {
        this(context, i, (JobScheduler)context.getSystemService("jobscheduler"), new a(context));
    }
    
    public b(final Context a, final i c, final JobScheduler b, final a d) {
        this.a = a;
        this.c = c;
        this.b = b;
        this.d = d;
    }
    
    public static void b(final Context context) {
        final JobScheduler jobScheduler = (JobScheduler)context.getSystemService("jobscheduler");
        if (jobScheduler != null) {
            final List<JobInfo> g = g(context, jobScheduler);
            if (g != null && !g.isEmpty()) {
                final Iterator iterator = g.iterator();
                while (iterator.hasNext()) {
                    e(jobScheduler, ((JobInfo)iterator.next()).getId());
                }
            }
        }
    }
    
    private static void e(final JobScheduler jobScheduler, final int n) {
        try {
            jobScheduler.cancel(n);
        }
        finally {
            final Throwable t;
            h.c().b(b.e, String.format(Locale.getDefault(), "Exception while trying to cancel job (%d)", n), t);
        }
    }
    
    private static List<Integer> f(final Context context, final JobScheduler jobScheduler, final String s) {
        final List<JobInfo> g = g(context, jobScheduler);
        if (g == null) {
            return null;
        }
        final ArrayList list = new ArrayList(2);
        for (final JobInfo jobInfo : g) {
            if (s.equals(h(jobInfo))) {
                list.add(jobInfo.getId());
            }
        }
        return list;
    }
    
    private static List<JobInfo> g(final Context context, final JobScheduler jobScheduler) {
        List list = null;
        try {
            jobScheduler.getAllPendingJobs();
        }
        finally {
            final Throwable t;
            h.c().b(b.e, "getAllPendingJobs() is not reliable on this device.", t);
            list = null;
        }
        if (list == null) {
            return null;
        }
        final ArrayList list2 = new ArrayList(list.size());
        final ComponentName componentName = new ComponentName(context, (Class)SystemJobService.class);
        for (final JobInfo jobInfo : list) {
            if (componentName.equals((Object)jobInfo.getService())) {
                list2.add((Object)jobInfo);
            }
        }
        return (List<JobInfo>)list2;
    }
    
    private static String h(final JobInfo jobInfo) {
        final PersistableBundle extras = jobInfo.getExtras();
        Label_0027: {
            if (extras == null) {
                break Label_0027;
            }
            try {
                if (extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                    return extras.getString("EXTRA_WORK_SPEC_ID");
                }
                return null;
            }
            catch (final NullPointerException ex) {
                return null;
            }
        }
    }
    
    public static boolean i(final Context context, i o) {
        final JobScheduler jobScheduler = (JobScheduler)context.getSystemService("jobscheduler");
        final List<JobInfo> g = g(context, jobScheduler);
        final List<String> b = o.o().i().b();
        final boolean b2 = false;
        int size;
        if (g != null) {
            size = g.size();
        }
        else {
            size = 0;
        }
        final HashSet set = new HashSet(size);
        if (g != null && !g.isEmpty()) {
            for (final JobInfo jobInfo : g) {
                final String h = h(jobInfo);
                if (!TextUtils.isEmpty((CharSequence)h)) {
                    set.add((Object)h);
                }
                else {
                    e(jobScheduler, jobInfo.getId());
                }
            }
        }
        final Iterator<String> iterator2 = b.iterator();
        while (true) {
            do {
                final boolean b3 = b2;
                if (iterator2.hasNext()) {
                    continue;
                }
                if (b3) {
                    o = (i)o.o();
                    ((RoomDatabase)o).beginTransaction();
                    try {
                        final q l = ((WorkDatabase)o).l();
                        final Iterator<String> iterator3 = b.iterator();
                        while (iterator3.hasNext()) {
                            l.l(iterator3.next(), -1L);
                        }
                        ((RoomDatabase)o).setTransactionSuccessful();
                    }
                    finally {
                        ((RoomDatabase)o).endTransaction();
                    }
                }
                return b3;
            } while (set.contains(iterator2.next()));
            h.c().a(h1.b.e, "Reconciling jobs", new Throwable[0]);
            final boolean b3 = true;
            continue;
        }
    }
    
    @Override
    public void a(final String s) {
        final List<Integer> f = f(this.a, this.b, s);
        if (f != null && !f.isEmpty()) {
            final Iterator iterator = f.iterator();
            while (iterator.hasNext()) {
                e(this.b, (int)iterator.next());
            }
            this.c.o().i().c(s);
        }
    }
    
    @Override
    public void c(final p... p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        h1/b.c:Lf1/i;
        //     4: invokevirtual   f1/i.o:()Landroidx/work/impl/WorkDatabase;
        //     7: astore          5
        //     9: new             Ln1/c;
        //    12: dup            
        //    13: aload           5
        //    15: invokespecial   n1/c.<init>:(Landroidx/work/impl/WorkDatabase;)V
        //    18: astore          7
        //    20: aload_1        
        //    21: arraylength    
        //    22: istore          4
        //    24: iconst_0       
        //    25: istore_2       
        //    26: iload_2        
        //    27: iload           4
        //    29: if_icmpge       347
        //    32: aload_1        
        //    33: iload_2        
        //    34: aaload         
        //    35: astore          6
        //    37: aload           5
        //    39: invokevirtual   androidx/room/RoomDatabase.beginTransaction:()V
        //    42: aload           5
        //    44: invokevirtual   androidx/work/impl/WorkDatabase.l:()Lm1/q;
        //    47: aload           6
        //    49: getfield        m1/p.a:Ljava/lang/String;
        //    52: invokeinterface m1/q.g:(Ljava/lang/String;)Lm1/p;
        //    57: astore          8
        //    59: aload           8
        //    61: ifnonnull       137
        //    64: invokestatic    e1/h.c:()Le1/h;
        //    67: astore          8
        //    69: getstatic       h1/b.e:Ljava/lang/String;
        //    72: astore          9
        //    74: new             Ljava/lang/StringBuilder;
        //    77: astore          10
        //    79: aload           10
        //    81: invokespecial   java/lang/StringBuilder.<init>:()V
        //    84: aload           10
        //    86: ldc_w           "Skipping scheduling "
        //    89: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    92: pop            
        //    93: aload           10
        //    95: aload           6
        //    97: getfield        m1/p.a:Ljava/lang/String;
        //   100: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   103: pop            
        //   104: aload           10
        //   106: ldc_w           " because it's no longer in the DB"
        //   109: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   112: pop            
        //   113: aload           8
        //   115: aload           9
        //   117: aload           10
        //   119: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   122: iconst_0       
        //   123: anewarray       Ljava/lang/Throwable;
        //   126: invokevirtual   e1/h.h:(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Throwable;)V
        //   129: aload           5
        //   131: invokevirtual   androidx/room/RoomDatabase.setTransactionSuccessful:()V
        //   134: goto            328
        //   137: aload           8
        //   139: getfield        m1/p.b:Landroidx/work/WorkInfo$State;
        //   142: getstatic       androidx/work/WorkInfo$State.ENQUEUED:Landroidx/work/WorkInfo$State;
        //   145: if_acmpeq       221
        //   148: invokestatic    e1/h.c:()Le1/h;
        //   151: astore          8
        //   153: getstatic       h1/b.e:Ljava/lang/String;
        //   156: astore          9
        //   158: new             Ljava/lang/StringBuilder;
        //   161: astore          10
        //   163: aload           10
        //   165: invokespecial   java/lang/StringBuilder.<init>:()V
        //   168: aload           10
        //   170: ldc_w           "Skipping scheduling "
        //   173: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   176: pop            
        //   177: aload           10
        //   179: aload           6
        //   181: getfield        m1/p.a:Ljava/lang/String;
        //   184: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   187: pop            
        //   188: aload           10
        //   190: ldc_w           " because it is no longer enqueued"
        //   193: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   196: pop            
        //   197: aload           8
        //   199: aload           9
        //   201: aload           10
        //   203: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   206: iconst_0       
        //   207: anewarray       Ljava/lang/Throwable;
        //   210: invokevirtual   e1/h.h:(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Throwable;)V
        //   213: aload           5
        //   215: invokevirtual   androidx/room/RoomDatabase.setTransactionSuccessful:()V
        //   218: goto            328
        //   221: aload           5
        //   223: invokevirtual   androidx/work/impl/WorkDatabase.i:()Lm1/h;
        //   226: aload           6
        //   228: getfield        m1/p.a:Ljava/lang/String;
        //   231: invokeinterface m1/h.a:(Ljava/lang/String;)Lm1/g;
        //   236: astore          8
        //   238: aload           8
        //   240: ifnull          252
        //   243: aload           8
        //   245: getfield        m1/g.b:I
        //   248: istore_3       
        //   249: goto            278
        //   252: aload           7
        //   254: aload_0        
        //   255: getfield        h1/b.c:Lf1/i;
        //   258: invokevirtual   f1/i.i:()Landroidx/work/a;
        //   261: invokevirtual   androidx/work/a.i:()I
        //   264: aload_0        
        //   265: getfield        h1/b.c:Lf1/i;
        //   268: invokevirtual   f1/i.i:()Landroidx/work/a;
        //   271: invokevirtual   androidx/work/a.g:()I
        //   274: invokevirtual   n1/c.d:(II)I
        //   277: istore_3       
        //   278: aload           8
        //   280: ifnonnull       316
        //   283: new             Lm1/g;
        //   286: astore          8
        //   288: aload           8
        //   290: aload           6
        //   292: getfield        m1/p.a:Ljava/lang/String;
        //   295: iload_3        
        //   296: invokespecial   m1/g.<init>:(Ljava/lang/String;I)V
        //   299: aload_0        
        //   300: getfield        h1/b.c:Lf1/i;
        //   303: invokevirtual   f1/i.o:()Landroidx/work/impl/WorkDatabase;
        //   306: invokevirtual   androidx/work/impl/WorkDatabase.i:()Lm1/h;
        //   309: aload           8
        //   311: invokeinterface m1/h.d:(Lm1/g;)V
        //   316: aload_0        
        //   317: aload           6
        //   319: iload_3        
        //   320: invokevirtual   h1/b.j:(Lm1/p;I)V
        //   323: aload           5
        //   325: invokevirtual   androidx/room/RoomDatabase.setTransactionSuccessful:()V
        //   328: aload           5
        //   330: invokevirtual   androidx/room/RoomDatabase.endTransaction:()V
        //   333: iinc            2, 1
        //   336: goto            26
        //   339: astore_1       
        //   340: aload           5
        //   342: invokevirtual   androidx/room/RoomDatabase.endTransaction:()V
        //   345: aload_1        
        //   346: athrow         
        //   347: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  42     59     339    347    Any
        //  64     134    339    347    Any
        //  137    218    339    347    Any
        //  221    238    339    347    Any
        //  243    249    339    347    Any
        //  252    278    339    347    Any
        //  283    316    339    347    Any
        //  316    328    339    347    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        //     at com.strobel.assembler.ir.StackMappingVisitor.push(StackMappingVisitor.java:290)
        //     at com.strobel.assembler.ir.StackMappingVisitor$InstructionAnalyzer.execute(StackMappingVisitor.java:837)
        //     at com.strobel.assembler.ir.StackMappingVisitor$InstructionAnalyzer.visit(StackMappingVisitor.java:398)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2086)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:203)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:93)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:868)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:761)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:638)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:605)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:195)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:162)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:137)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:333)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:254)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:129)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @Override
    public boolean d() {
        return true;
    }
    
    public void j(final p ex, int size) {
        final JobInfo a = this.d.a((p)ex, size);
        final h c = h.c();
        final String e = h1.b.e;
        c.a(e, String.format("Scheduling work ID %s Job ID %s", ((p)ex).a, size), new Throwable[0]);
        try {
            if (this.b.schedule(a) != 0) {
                goto Label_0189;
            }
            h.c().h(e, String.format("Unable to schedule work ID %s", ((p)ex).a), new Throwable[0]);
            if (((p)ex).q && ((p)ex).r == OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST) {
                ((p)ex).q = false;
                h.c().a(e, String.format("Scheduling a non-expedited job (work ID %s)", ((p)ex).a), new Throwable[0]);
                this.j((p)ex, size);
                goto Label_0189;
            }
            goto Label_0189;
        }
        catch (final IllegalStateException ex) {
            final List<JobInfo> g = g(this.a, this.b);
            if (g != null) {
                size = g.size();
            }
            else {
                size = 0;
            }
            final String format = String.format(Locale.getDefault(), "JobScheduler 100 job limit exceeded.  We count %d WorkManager jobs in JobScheduler; we have %d tracked jobs in our DB; our Configuration limit is %d.", size, this.c.o().l().d().size(), this.c.i().h());
            h.c().b(h1.b.e, format, new Throwable[0]);
            throw new IllegalStateException(format, ex);
        }
        finally {
            final Throwable t;
            h.c().b(h1.b.e, String.format("Unable to schedule %s", ex), t);
        }
    }
}
