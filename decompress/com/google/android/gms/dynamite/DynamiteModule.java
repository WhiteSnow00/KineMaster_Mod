// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.dynamite;

import com.google.android.gms.common.util.DynamiteApi;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import android.os.IInterface;
import java.lang.reflect.InvocationTargetException;
import android.os.IBinder;
import com.google.android.gms.dynamic.IObjectWrapper;
import android.database.Cursor;
import com.google.android.gms.common.util.CrashUtils;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import android.os.SystemClock;
import java.lang.reflect.Field;
import android.util.Log;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import android.content.Context;
import javax.annotation.concurrent.GuardedBy;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public final class DynamiteModule
{
    @KeepForSdk
    public static final VersionPolicy b;
    @KeepForSdk
    public static final VersionPolicy c;
    @KeepForSdk
    public static final VersionPolicy d;
    @KeepForSdk
    public static final VersionPolicy e;
    @KeepForSdk
    public static final VersionPolicy f;
    @KeepForSdk
    public static final VersionPolicy g;
    @GuardedBy
    private static Boolean h;
    @GuardedBy
    private static String i;
    @GuardedBy
    private static boolean j = false;
    @GuardedBy
    private static int k = -1;
    @GuardedBy
    private static Boolean l;
    private static final ThreadLocal m;
    private static final ThreadLocal n;
    private static final VersionPolicy.IVersions o;
    public static final VersionPolicy p;
    @GuardedBy
    private static zzq q;
    @GuardedBy
    private static zzr r;
    private final Context a;
    
    static {
        m = new ThreadLocal();
        n = new c();
        o = (VersionPolicy.IVersions)new d();
        b = (VersionPolicy)new e();
        c = (VersionPolicy)new f();
        d = (VersionPolicy)new g();
        e = (VersionPolicy)new h();
        f = (VersionPolicy)new i();
        g = (VersionPolicy)new j();
        p = (VersionPolicy)new k();
    }
    
    private DynamiteModule(final Context a) {
        Preconditions.k(a);
        this.a = a;
    }
    
    @KeepForSdk
    public static int a(final Context context, final String s) {
        try {
            final ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            final StringBuilder sb = new StringBuilder();
            sb.append("com.google.android.gms.dynamite.descriptors.");
            sb.append(s);
            sb.append(".ModuleDescriptor");
            final Class<?> loadClass = classLoader.loadClass(sb.toString());
            final Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            final Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (!Objects.b(declaredField.get(null), s)) {
                final String value = String.valueOf(declaredField.get(null));
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("Module descriptor id '");
                sb2.append(value);
                sb2.append("' didn't match expected id '");
                sb2.append(s);
                sb2.append("'");
                Log.e("DynamiteModule", sb2.toString());
                return 0;
            }
            return declaredField2.getInt(null);
        }
        catch (final Exception ex) {
            Log.e("DynamiteModule", "Failed to load module descriptor class: ".concat(String.valueOf(ex.getMessage())));
        }
        catch (final ClassNotFoundException ex2) {
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("Local module descriptor class for ");
            sb3.append(s);
            sb3.append(" not found.");
            Log.w("DynamiteModule", sb3.toString());
        }
        return 0;
    }
    
    @KeepForSdk
    public static int c(final Context context, final String s) {
        return f(context, s, false);
    }
    
    @KeepForSdk
    public static DynamiteModule e(Context context, VersionPolicy a, final String s) throws LoadingException {
        final ThreadLocal m = DynamiteModule.m;
        final l l = m.get();
        final l i = new l(null);
        m.set(i);
        final ThreadLocal n = DynamiteModule.n;
        final long longValue = n.get();
        try {
            n.set(SystemClock.elapsedRealtime());
            final VersionPolicy.SelectionResult a2 = a.a(context, s, DynamiteModule.o);
            final int a3 = a2.a;
            final int b = a2.b;
            final StringBuilder sb = new StringBuilder();
            sb.append("Considering local module ");
            sb.append(s);
            sb.append(":");
            sb.append(a3);
            sb.append(" and remote module ");
            sb.append(s);
            sb.append(":");
            sb.append(b);
            Log.i("DynamiteModule", sb.toString());
            final int c = a2.c;
            Label_1216: {
                if (c == 0) {
                    break Label_1216;
                }
                int n2;
                if ((n2 = c) == -1) {
                    if (a2.a == 0) {
                        break Label_1216;
                    }
                    n2 = -1;
                }
                if (n2 == 1 && a2.b == 0) {
                    break Label_1216;
                }
                if (n2 == -1) {
                    final DynamiteModule h = h(context, s);
                    if (longValue == 0L) {
                        n.remove();
                    }
                    else {
                        n.set(longValue);
                    }
                    try (final Cursor a4 = i.a) {}
                    m.set(l);
                    return h;
                }
                Label_1179: {
                    if (n2 != 1) {
                        break Label_1179;
                    }
                    try {
                        final int b2 = a2.b;
                        try {
                            synchronized (DynamiteModule.class) {
                                if (!k(context)) {
                                    throw new LoadingException("Remote loading disabled", (zzp)null);
                                }
                                final Boolean h2 = DynamiteModule.h;
                                monitorexit(DynamiteModule.class);
                                if (h2 != null) {
                                    Label_0838: {
                                        if (h2) {
                                            final StringBuilder sb2 = new StringBuilder();
                                            sb2.append("Selected remote version of ");
                                            sb2.append(s);
                                            sb2.append(", version >= ");
                                            sb2.append(b2);
                                            Log.i("DynamiteModule", sb2.toString());
                                            synchronized (DynamiteModule.class) {
                                                final zzr r = DynamiteModule.r;
                                                monitorexit(DynamiteModule.class);
                                                if (r != null) {
                                                    final l j = m.get();
                                                    if (j != null && j.a != null) {
                                                        final Context applicationContext = context.getApplicationContext();
                                                        final Cursor a5 = j.a;
                                                        ObjectWrapper.q1((Object)null);
                                                        synchronized (DynamiteModule.class) {
                                                            final boolean b3 = DynamiteModule.k >= 2;
                                                            monitorexit(DynamiteModule.class);
                                                            IObjectWrapper objectWrapper;
                                                            if ((boolean)b3) {
                                                                Log.v("DynamiteModule", "Dynamite loader version >= 2, using loadModule2NoCrashUtils");
                                                                objectWrapper = r.p1(ObjectWrapper.q1(applicationContext), s, b2, ObjectWrapper.q1(a5));
                                                            }
                                                            else {
                                                                Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
                                                                objectWrapper = r.M0(ObjectWrapper.q1(applicationContext), s, b2, ObjectWrapper.q1(a5));
                                                            }
                                                            final Context context2 = ObjectWrapper.p1(objectWrapper);
                                                            if (context2 != null) {
                                                                context = (Context)new DynamiteModule(context2);
                                                                break Label_0838;
                                                            }
                                                            throw new LoadingException("Failed to get module context", (zzp)null);
                                                        }
                                                    }
                                                    throw new LoadingException("No result cursor", (zzp)null);
                                                }
                                                throw new LoadingException("DynamiteLoaderV2 was not cached.", (zzp)null);
                                            }
                                        }
                                        final StringBuilder sb3 = new StringBuilder();
                                        sb3.append("Selected remote version of ");
                                        sb3.append(s);
                                        sb3.append(", version >= ");
                                        sb3.append(b2);
                                        Log.i("DynamiteModule", sb3.toString());
                                        final zzq k = l(context);
                                        if (k == null) {
                                            throw new LoadingException("Failed to create IDynamiteLoader.", (zzp)null);
                                        }
                                        final int zze = k.zze();
                                        IObjectWrapper objectWrapper2;
                                        if (zze >= 3) {
                                            final l l2 = m.get();
                                            if (l2 == null) {
                                                throw new LoadingException("No cached result cursor holder", (zzp)null);
                                            }
                                            objectWrapper2 = k.r1(ObjectWrapper.q1(context), s, b2, ObjectWrapper.q1(l2.a));
                                        }
                                        else if (zze == 2) {
                                            Log.w("DynamiteModule", "IDynamite loader version = 2");
                                            objectWrapper2 = k.s1(ObjectWrapper.q1(context), s, b2);
                                        }
                                        else {
                                            Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                                            objectWrapper2 = k.q1(ObjectWrapper.q1(context), s, b2);
                                        }
                                        final Object p3 = ObjectWrapper.p1(objectWrapper2);
                                        if (p3 == null) {
                                            throw new LoadingException("Failed to load remote module.", (zzp)null);
                                        }
                                        context = (Context)new DynamiteModule((Context)p3);
                                    }
                                    if (longValue == 0L) {
                                        n.remove();
                                    }
                                    else {
                                        n.set(longValue);
                                    }
                                    a = (VersionPolicy)i.a;
                                    if (a != null) {
                                        ((Cursor)a).close();
                                    }
                                    m.set(l);
                                    return (DynamiteModule)context;
                                }
                                throw new LoadingException("Failed to determine which loading route to use.", (zzp)null);
                            }
                        }
                        catch (final LoadingException ex) {
                            throw ex;
                        }
                        catch (final RemoteException ex3) {
                            try {
                                throw new LoadingException("Failed to load remote module.", (Throwable)ex3, null);
                            }
                            catch (final LoadingException ex4) {
                                final String message = ex4.getMessage();
                                final StringBuilder sb4 = new StringBuilder();
                                sb4.append("Failed to load remote module: ");
                                sb4.append(message);
                                Log.w("DynamiteModule", sb4.toString());
                                final int a6 = a2.a;
                                if (a6 != 0 && a.a(context, s, (VersionPolicy.IVersions)new m(a6, 0)).c == -1) {
                                    return h(context, s);
                                }
                                throw new LoadingException("Remote load failed. No local fallback found.", ex4, null);
                                final int a7 = a2.a;
                                final int b4 = a2.b;
                                final StringBuilder sb5 = new StringBuilder();
                                sb5.append("No acceptable module ");
                                sb5.append(s);
                                sb5.append(" found. Local version is ");
                                sb5.append(a7);
                                sb5.append(" and remote version is ");
                                sb5.append(b4);
                                sb5.append(".");
                                throw new LoadingException(sb5.toString(), (zzp)null);
                                final StringBuilder sb6 = new StringBuilder();
                                sb6.append("VersionPolicy returned invalid code:");
                                sb6.append(n2);
                                throw new LoadingException(sb6.toString(), (zzp)null);
                            }
                        }
                        finally {
                            final Throwable t;
                            CrashUtils.a(context, t);
                            throw new LoadingException("Failed to load remote module.", t, null);
                        }
                        try {
                            final LoadingException ex;
                            throw ex;
                        }
                        catch (final LoadingException ex5) {}
                        finally {
                            if (longValue == 0L) {
                                DynamiteModule.n.remove();
                            }
                            else {
                                DynamiteModule.n.set(longValue);
                            }
                            try (final Cursor a8 = i.a) {}
                            DynamiteModule.m.set(l);
                        }
                    }
                    catch (final LoadingException ex6) {}
                }
            }
        }
        finally {}
    }
    
    public static int f(final Context p0, final String p1, final boolean p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     2: monitorenter   
        //     3: getstatic       com/google/android/gms/dynamite/DynamiteModule.h:Ljava/lang/Boolean;
        //     6: astore          10
        //     8: aconst_null    
        //     9: astore          8
        //    11: aconst_null    
        //    12: astore          9
        //    14: aconst_null    
        //    15: astore          7
        //    17: iconst_0       
        //    18: istore          4
        //    20: aload           10
        //    22: astore          6
        //    24: aload           10
        //    26: ifnonnull       400
        //    29: aload_0        
        //    30: invokevirtual   android/content/Context.getApplicationContext:()Landroid/content/Context;
        //    33: invokevirtual   android/content/Context.getClassLoader:()Ljava/lang/ClassLoader;
        //    36: ldc             Lcom/google/android/gms/dynamite/DynamiteModule$DynamiteLoaderClassLoader;.class
        //    38: invokevirtual   java/lang/Class.getName:()Ljava/lang/String;
        //    41: invokevirtual   java/lang/ClassLoader.loadClass:(Ljava/lang/String;)Ljava/lang/Class;
        //    44: ldc_w           "sClassLoader"
        //    47: invokevirtual   java/lang/Class.getDeclaredField:(Ljava/lang/String;)Ljava/lang/reflect/Field;
        //    50: astore          11
        //    52: aload           11
        //    54: invokevirtual   java/lang/reflect/Field.getDeclaringClass:()Ljava/lang/Class;
        //    57: astore          10
        //    59: aload           10
        //    61: monitorenter   
        //    62: aload           11
        //    64: aconst_null    
        //    65: invokevirtual   java/lang/reflect/Field.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    68: checkcast       Ljava/lang/ClassLoader;
        //    71: astore          6
        //    73: aload           6
        //    75: invokestatic    java/lang/ClassLoader.getSystemClassLoader:()Ljava/lang/ClassLoader;
        //    78: if_acmpne       89
        //    81: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //    84: astore          6
        //    86: goto            319
        //    89: aload           6
        //    91: ifnull          107
        //    94: aload           6
        //    96: invokestatic    com/google/android/gms/dynamite/DynamiteModule.i:(Ljava/lang/ClassLoader;)V
        //    99: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   102: astore          6
        //   104: goto            319
        //   107: aload_0        
        //   108: invokestatic    com/google/android/gms/dynamite/DynamiteModule.k:(Landroid/content/Context;)Z
        //   111: ifne            122
        //   114: aload           10
        //   116: monitorexit    
        //   117: ldc             Lcom/google/android/gms/dynamite/DynamiteModule;.class
        //   119: monitorexit    
        //   120: iconst_0       
        //   121: ireturn        
        //   122: getstatic       com/google/android/gms/dynamite/DynamiteModule.j:Z
        //   125: ifne            305
        //   128: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   131: astore          12
        //   133: aload           12
        //   135: aconst_null    
        //   136: invokevirtual   java/lang/Boolean.equals:(Ljava/lang/Object;)Z
        //   139: istore          5
        //   141: iload           5
        //   143: ifeq            149
        //   146: goto            305
        //   149: aload_0        
        //   150: aload_1        
        //   151: iload_2        
        //   152: iconst_1       
        //   153: invokestatic    com/google/android/gms/dynamite/DynamiteModule.g:(Landroid/content/Context;Ljava/lang/String;ZZ)I
        //   156: istore_3       
        //   157: getstatic       com/google/android/gms/dynamite/DynamiteModule.i:Ljava/lang/String;
        //   160: astore          6
        //   162: aload           6
        //   164: ifnull          278
        //   167: aload           6
        //   169: invokevirtual   java/lang/String.isEmpty:()Z
        //   172: ifeq            178
        //   175: goto            278
        //   178: invokestatic    com/google/android/gms/dynamite/zzb.a:()Ljava/lang/ClassLoader;
        //   181: astore          6
        //   183: aload           6
        //   185: ifnull          191
        //   188: goto            252
        //   191: getstatic       android/os/Build$VERSION.SDK_INT:I
        //   194: bipush          29
        //   196: if_icmplt       227
        //   199: getstatic       com/google/android/gms/dynamite/DynamiteModule.i:Ljava/lang/String;
        //   202: astore          6
        //   204: aload           6
        //   206: invokestatic    com/google/android/gms/common/internal/Preconditions.k:(Ljava/lang/Object;)Ljava/lang/Object;
        //   209: pop            
        //   210: new             Ldalvik/system/DelegateLastClassLoader;
        //   213: dup            
        //   214: aload           6
        //   216: invokestatic    java/lang/ClassLoader.getSystemClassLoader:()Ljava/lang/ClassLoader;
        //   219: invokespecial   dalvik/system/DelegateLastClassLoader.<init>:(Ljava/lang/String;Ljava/lang/ClassLoader;)V
        //   222: astore          6
        //   224: goto            252
        //   227: getstatic       com/google/android/gms/dynamite/DynamiteModule.i:Ljava/lang/String;
        //   230: astore          6
        //   232: aload           6
        //   234: invokestatic    com/google/android/gms/common/internal/Preconditions.k:(Ljava/lang/Object;)Ljava/lang/Object;
        //   237: pop            
        //   238: new             Lcom/google/android/gms/dynamite/b;
        //   241: dup            
        //   242: aload           6
        //   244: invokestatic    java/lang/ClassLoader.getSystemClassLoader:()Ljava/lang/ClassLoader;
        //   247: invokespecial   com/google/android/gms/dynamite/b.<init>:(Ljava/lang/String;Ljava/lang/ClassLoader;)V
        //   250: astore          6
        //   252: aload           6
        //   254: invokestatic    com/google/android/gms/dynamite/DynamiteModule.i:(Ljava/lang/ClassLoader;)V
        //   257: aload           11
        //   259: aconst_null    
        //   260: aload           6
        //   262: invokevirtual   java/lang/reflect/Field.set:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   265: aload           12
        //   267: putstatic       com/google/android/gms/dynamite/DynamiteModule.h:Ljava/lang/Boolean;
        //   270: aload           10
        //   272: monitorexit    
        //   273: ldc             Lcom/google/android/gms/dynamite/DynamiteModule;.class
        //   275: monitorexit    
        //   276: iload_3        
        //   277: ireturn        
        //   278: aload           10
        //   280: monitorexit    
        //   281: ldc             Lcom/google/android/gms/dynamite/DynamiteModule;.class
        //   283: monitorexit    
        //   284: iload_3        
        //   285: ireturn        
        //   286: astore          6
        //   288: aload           11
        //   290: aconst_null    
        //   291: invokestatic    java/lang/ClassLoader.getSystemClassLoader:()Ljava/lang/ClassLoader;
        //   294: invokevirtual   java/lang/reflect/Field.set:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   297: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   300: astore          6
        //   302: goto            319
        //   305: aload           11
        //   307: aconst_null    
        //   308: invokestatic    java/lang/ClassLoader.getSystemClassLoader:()Ljava/lang/ClassLoader;
        //   311: invokevirtual   java/lang/reflect/Field.set:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   314: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   317: astore          6
        //   319: aload           10
        //   321: monitorexit    
        //   322: goto            395
        //   325: astore          6
        //   327: aload           10
        //   329: monitorexit    
        //   330: aload           6
        //   332: athrow         
        //   333: astore          6
        //   335: goto            345
        //   338: astore          6
        //   340: goto            345
        //   343: astore          6
        //   345: aload           6
        //   347: invokevirtual   java/lang/Object.toString:()Ljava/lang/String;
        //   350: astore          6
        //   352: new             Ljava/lang/StringBuilder;
        //   355: astore          10
        //   357: aload           10
        //   359: invokespecial   java/lang/StringBuilder.<init>:()V
        //   362: aload           10
        //   364: ldc_w           "Failed to load module via V2: "
        //   367: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   370: pop            
        //   371: aload           10
        //   373: aload           6
        //   375: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   378: pop            
        //   379: ldc             "DynamiteModule"
        //   381: aload           10
        //   383: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   386: invokestatic    android/util/Log.w:(Ljava/lang/String;Ljava/lang/String;)I
        //   389: pop            
        //   390: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   393: astore          6
        //   395: aload           6
        //   397: putstatic       com/google/android/gms/dynamite/DynamiteModule.h:Ljava/lang/Boolean;
        //   400: ldc             Lcom/google/android/gms/dynamite/DynamiteModule;.class
        //   402: monitorexit    
        //   403: aload           6
        //   405: invokevirtual   java/lang/Boolean.booleanValue:()Z
        //   408: istore          5
        //   410: iload           5
        //   412: ifeq            467
        //   415: aload_0        
        //   416: aload_1        
        //   417: iload_2        
        //   418: iconst_0       
        //   419: invokestatic    com/google/android/gms/dynamite/DynamiteModule.g:(Landroid/content/Context;Ljava/lang/String;ZZ)I
        //   422: istore_3       
        //   423: iload_3        
        //   424: ireturn        
        //   425: astore_1       
        //   426: aload_1        
        //   427: invokevirtual   java/lang/Exception.getMessage:()Ljava/lang/String;
        //   430: astore          6
        //   432: new             Ljava/lang/StringBuilder;
        //   435: astore_1       
        //   436: aload_1        
        //   437: invokespecial   java/lang/StringBuilder.<init>:()V
        //   440: aload_1        
        //   441: ldc_w           "Failed to retrieve remote module version: "
        //   444: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   447: pop            
        //   448: aload_1        
        //   449: aload           6
        //   451: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   454: pop            
        //   455: ldc             "DynamiteModule"
        //   457: aload_1        
        //   458: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   461: invokestatic    android/util/Log.w:(Ljava/lang/String;Ljava/lang/String;)I
        //   464: pop            
        //   465: iconst_0       
        //   466: ireturn        
        //   467: aload_0        
        //   468: invokestatic    com/google/android/gms/dynamite/DynamiteModule.l:(Landroid/content/Context;)Lcom/google/android/gms/dynamite/zzq;
        //   471: astore          10
        //   473: aload           10
        //   475: ifnonnull       484
        //   478: iload           4
        //   480: istore_3       
        //   481: goto            845
        //   484: aload           9
        //   486: astore          6
        //   488: aload           10
        //   490: invokevirtual   com/google/android/gms/dynamite/zzq.zze:()I
        //   493: istore_3       
        //   494: iload_3        
        //   495: iconst_3       
        //   496: if_icmplt       689
        //   499: aload           9
        //   501: astore          6
        //   503: getstatic       com/google/android/gms/dynamite/DynamiteModule.m:Ljava/lang/ThreadLocal;
        //   506: invokevirtual   java/lang/ThreadLocal.get:()Ljava/lang/Object;
        //   509: checkcast       Lcom/google/android/gms/dynamite/l;
        //   512: astore          11
        //   514: aload           11
        //   516: ifnull          551
        //   519: aload           9
        //   521: astore          6
        //   523: aload           11
        //   525: getfield        com/google/android/gms/dynamite/l.a:Landroid/database/Cursor;
        //   528: astore          11
        //   530: aload           11
        //   532: ifnull          551
        //   535: aload           9
        //   537: astore          6
        //   539: aload           11
        //   541: iconst_0       
        //   542: invokeinterface android/database/Cursor.getInt:(I)I
        //   547: istore_3       
        //   548: goto            845
        //   551: aload           9
        //   553: astore          6
        //   555: aload           10
        //   557: aload_0        
        //   558: invokestatic    com/google/android/gms/dynamic/ObjectWrapper.q1:(Ljava/lang/Object;)Lcom/google/android/gms/dynamic/IObjectWrapper;
        //   561: aload_1        
        //   562: iload_2        
        //   563: getstatic       com/google/android/gms/dynamite/DynamiteModule.n:Ljava/lang/ThreadLocal;
        //   566: invokevirtual   java/lang/ThreadLocal.get:()Ljava/lang/Object;
        //   569: checkcast       Ljava/lang/Long;
        //   572: invokevirtual   java/lang/Long.longValue:()J
        //   575: invokevirtual   com/google/android/gms/dynamite/zzq.t1:(Lcom/google/android/gms/dynamic/IObjectWrapper;Ljava/lang/String;ZJ)Lcom/google/android/gms/dynamic/IObjectWrapper;
        //   578: invokestatic    com/google/android/gms/dynamic/ObjectWrapper.p1:(Lcom/google/android/gms/dynamic/IObjectWrapper;)Ljava/lang/Object;
        //   581: checkcast       Landroid/database/Cursor;
        //   584: astore_1       
        //   585: aload_1        
        //   586: ifnull          641
        //   589: aload_1        
        //   590: invokeinterface android/database/Cursor.moveToFirst:()Z
        //   595: ifne            601
        //   598: goto            641
        //   601: aload_1        
        //   602: iconst_0       
        //   603: invokeinterface android/database/Cursor.getInt:(I)I
        //   608: istore_3       
        //   609: iload_3        
        //   610: ifle            628
        //   613: aload_1        
        //   614: invokestatic    com/google/android/gms/dynamite/DynamiteModule.j:(Landroid/database/Cursor;)Z
        //   617: istore_2       
        //   618: iload_2        
        //   619: ifeq            628
        //   622: aload           7
        //   624: astore_1       
        //   625: goto            628
        //   628: aload_1        
        //   629: ifnull          638
        //   632: aload_1        
        //   633: invokeinterface android/database/Cursor.close:()V
        //   638: goto            845
        //   641: ldc             "DynamiteModule"
        //   643: ldc_w           "Failed to retrieve remote module version."
        //   646: invokestatic    android/util/Log.w:(Ljava/lang/String;Ljava/lang/String;)I
        //   649: pop            
        //   650: iload           4
        //   652: istore_3       
        //   653: aload_1        
        //   654: ifnull          845
        //   657: aload_1        
        //   658: invokeinterface android/database/Cursor.close:()V
        //   663: iload           4
        //   665: istore_3       
        //   666: goto            845
        //   669: astore          7
        //   671: aload_1        
        //   672: astore          6
        //   674: aload           7
        //   676: astore_1       
        //   677: goto            851
        //   680: astore          6
        //   682: aload           6
        //   684: astore          7
        //   686: goto            766
        //   689: iload_3        
        //   690: iconst_2       
        //   691: if_icmpne       726
        //   694: aload           9
        //   696: astore          6
        //   698: ldc             "DynamiteModule"
        //   700: ldc_w           "IDynamite loader version = 2, no high precision latency measurement."
        //   703: invokestatic    android/util/Log.w:(Ljava/lang/String;Ljava/lang/String;)I
        //   706: pop            
        //   707: aload           9
        //   709: astore          6
        //   711: aload           10
        //   713: aload_0        
        //   714: invokestatic    com/google/android/gms/dynamic/ObjectWrapper.q1:(Ljava/lang/Object;)Lcom/google/android/gms/dynamic/IObjectWrapper;
        //   717: aload_1        
        //   718: iload_2        
        //   719: invokevirtual   com/google/android/gms/dynamite/zzq.p1:(Lcom/google/android/gms/dynamic/IObjectWrapper;Ljava/lang/String;Z)I
        //   722: istore_3       
        //   723: goto            845
        //   726: aload           9
        //   728: astore          6
        //   730: ldc             "DynamiteModule"
        //   732: ldc_w           "IDynamite loader version < 2, falling back to getModuleVersion2"
        //   735: invokestatic    android/util/Log.w:(Ljava/lang/String;Ljava/lang/String;)I
        //   738: pop            
        //   739: aload           9
        //   741: astore          6
        //   743: aload           10
        //   745: aload_0        
        //   746: invokestatic    com/google/android/gms/dynamic/ObjectWrapper.q1:(Ljava/lang/Object;)Lcom/google/android/gms/dynamic/IObjectWrapper;
        //   749: aload_1        
        //   750: iload_2        
        //   751: invokevirtual   com/google/android/gms/dynamite/zzq.M0:(Lcom/google/android/gms/dynamic/IObjectWrapper;Ljava/lang/String;Z)I
        //   754: istore_3       
        //   755: goto            845
        //   758: goto            851
        //   761: astore          7
        //   763: aload           8
        //   765: astore_1       
        //   766: aload_1        
        //   767: astore          6
        //   769: aload           7
        //   771: invokevirtual   android/os/RemoteException.getMessage:()Ljava/lang/String;
        //   774: astore          8
        //   776: aload_1        
        //   777: astore          6
        //   779: new             Ljava/lang/StringBuilder;
        //   782: astore          7
        //   784: aload_1        
        //   785: astore          6
        //   787: aload           7
        //   789: invokespecial   java/lang/StringBuilder.<init>:()V
        //   792: aload_1        
        //   793: astore          6
        //   795: aload           7
        //   797: ldc_w           "Failed to retrieve remote module version: "
        //   800: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   803: pop            
        //   804: aload_1        
        //   805: astore          6
        //   807: aload           7
        //   809: aload           8
        //   811: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   814: pop            
        //   815: aload_1        
        //   816: astore          6
        //   818: ldc             "DynamiteModule"
        //   820: aload           7
        //   822: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   825: invokestatic    android/util/Log.w:(Ljava/lang/String;Ljava/lang/String;)I
        //   828: pop            
        //   829: iload           4
        //   831: istore_3       
        //   832: aload_1        
        //   833: ifnull          845
        //   836: aload_1        
        //   837: invokeinterface android/database/Cursor.close:()V
        //   842: iload           4
        //   844: istore_3       
        //   845: iload_3        
        //   846: ireturn        
        //   847: astore_1       
        //   848: goto            758
        //   851: aload           6
        //   853: ifnull          863
        //   856: aload           6
        //   858: invokeinterface android/database/Cursor.close:()V
        //   863: aload_1        
        //   864: athrow         
        //   865: astore_1       
        //   866: ldc             Lcom/google/android/gms/dynamite/DynamiteModule;.class
        //   868: monitorexit    
        //   869: aload_1        
        //   870: athrow         
        //   871: astore_1       
        //   872: aload_0        
        //   873: aload_1        
        //   874: invokestatic    com/google/android/gms/common/util/CrashUtils.a:(Landroid/content/Context;Ljava/lang/Throwable;)Z
        //   877: pop            
        //   878: aload_1        
        //   879: athrow         
        //   880: astore          6
        //   882: goto            99
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                                             
        //  -----  -----  -----  -----  -----------------------------------------------------------------
        //  0      3      871    880    Any
        //  3      8      865    871    Any
        //  29     62     343    345    Ljava/lang/ClassNotFoundException;
        //  29     62     338    343    Ljava/lang/IllegalAccessException;
        //  29     62     333    338    Ljava/lang/NoSuchFieldException;
        //  29     62     865    871    Any
        //  62     86     325    333    Any
        //  94     99     880    885    Lcom/google/android/gms/dynamite/DynamiteModule$LoadingException;
        //  94     99     325    333    Any
        //  99     104    325    333    Any
        //  107    117    325    333    Any
        //  117    120    865    871    Any
        //  122    141    325    333    Any
        //  149    162    286    305    Lcom/google/android/gms/dynamite/DynamiteModule$LoadingException;
        //  149    162    325    333    Any
        //  167    175    286    305    Lcom/google/android/gms/dynamite/DynamiteModule$LoadingException;
        //  167    175    325    333    Any
        //  178    183    286    305    Lcom/google/android/gms/dynamite/DynamiteModule$LoadingException;
        //  178    183    325    333    Any
        //  191    224    286    305    Lcom/google/android/gms/dynamite/DynamiteModule$LoadingException;
        //  191    224    325    333    Any
        //  227    252    286    305    Lcom/google/android/gms/dynamite/DynamiteModule$LoadingException;
        //  227    252    325    333    Any
        //  252    270    286    305    Lcom/google/android/gms/dynamite/DynamiteModule$LoadingException;
        //  252    270    325    333    Any
        //  270    273    325    333    Any
        //  273    276    865    871    Any
        //  278    281    325    333    Any
        //  281    284    865    871    Any
        //  288    302    325    333    Any
        //  305    319    325    333    Any
        //  319    322    325    333    Any
        //  327    330    325    333    Any
        //  330    333    343    345    Ljava/lang/ClassNotFoundException;
        //  330    333    338    343    Ljava/lang/IllegalAccessException;
        //  330    333    333    338    Ljava/lang/NoSuchFieldException;
        //  330    333    865    871    Any
        //  345    395    865    871    Any
        //  395    400    865    871    Any
        //  400    403    865    871    Any
        //  403    410    871    880    Any
        //  415    423    425    467    Lcom/google/android/gms/dynamite/DynamiteModule$LoadingException;
        //  415    423    871    880    Any
        //  426    465    871    880    Any
        //  467    473    871    880    Any
        //  488    494    761    766    Landroid/os/RemoteException;
        //  488    494    847    761    Any
        //  503    514    761    766    Landroid/os/RemoteException;
        //  503    514    847    761    Any
        //  523    530    761    766    Landroid/os/RemoteException;
        //  523    530    847    761    Any
        //  539    548    761    766    Landroid/os/RemoteException;
        //  539    548    847    761    Any
        //  555    585    761    766    Landroid/os/RemoteException;
        //  555    585    847    761    Any
        //  589    598    680    689    Landroid/os/RemoteException;
        //  589    598    669    680    Any
        //  601    609    680    689    Landroid/os/RemoteException;
        //  601    609    669    680    Any
        //  613    618    680    689    Landroid/os/RemoteException;
        //  613    618    669    680    Any
        //  632    638    871    880    Any
        //  641    650    680    689    Landroid/os/RemoteException;
        //  641    650    669    680    Any
        //  657    663    871    880    Any
        //  698    707    761    766    Landroid/os/RemoteException;
        //  698    707    847    761    Any
        //  711    723    761    766    Landroid/os/RemoteException;
        //  711    723    847    761    Any
        //  730    739    761    766    Landroid/os/RemoteException;
        //  730    739    847    761    Any
        //  743    755    761    766    Landroid/os/RemoteException;
        //  743    755    847    761    Any
        //  769    776    847    761    Any
        //  779    784    847    761    Any
        //  787    792    847    761    Any
        //  795    804    847    761    Any
        //  807    815    847    761    Any
        //  818    829    847    761    Any
        //  836    842    871    880    Any
        //  856    863    871    880    Any
        //  863    865    871    880    Any
        //  866    869    865    871    Any
        //  869    871    871    880    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0099:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2604)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:206)
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
    
    private static int g(final Context p0, final String p1, final boolean p2, final boolean p3) throws LoadingException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore          10
        //     3: getstatic       com/google/android/gms/dynamite/DynamiteModule.n:Ljava/lang/ThreadLocal;
        //     6: invokevirtual   java/lang/ThreadLocal.get:()Ljava/lang/Object;
        //     9: checkcast       Ljava/lang/Long;
        //    12: invokevirtual   java/lang/Long.longValue:()J
        //    15: lstore          6
        //    17: aload_0        
        //    18: invokevirtual   android/content/Context.getContentResolver:()Landroid/content/ContentResolver;
        //    21: astore          11
        //    23: ldc_w           "api_force_staging"
        //    26: astore_0       
        //    27: iconst_1       
        //    28: istore          9
        //    30: iconst_1       
        //    31: iload_2        
        //    32: if_icmpeq       39
        //    35: ldc_w           "api"
        //    38: astore_0       
        //    39: new             Landroid/net/Uri$Builder;
        //    42: astore          12
        //    44: aload           12
        //    46: invokespecial   android/net/Uri$Builder.<init>:()V
        //    49: aload           11
        //    51: aload           12
        //    53: ldc_w           "content"
        //    56: invokevirtual   android/net/Uri$Builder.scheme:(Ljava/lang/String;)Landroid/net/Uri$Builder;
        //    59: ldc_w           "com.google.android.gms.chimera"
        //    62: invokevirtual   android/net/Uri$Builder.authority:(Ljava/lang/String;)Landroid/net/Uri$Builder;
        //    65: aload_0        
        //    66: invokevirtual   android/net/Uri$Builder.path:(Ljava/lang/String;)Landroid/net/Uri$Builder;
        //    69: aload_1        
        //    70: invokevirtual   android/net/Uri$Builder.appendPath:(Ljava/lang/String;)Landroid/net/Uri$Builder;
        //    73: ldc_w           "requestStartTime"
        //    76: lload           6
        //    78: invokestatic    java/lang/String.valueOf:(J)Ljava/lang/String;
        //    81: invokevirtual   android/net/Uri$Builder.appendQueryParameter:(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
        //    84: invokevirtual   android/net/Uri$Builder.build:()Landroid/net/Uri;
        //    87: aconst_null    
        //    88: aconst_null    
        //    89: aconst_null    
        //    90: aconst_null    
        //    91: invokevirtual   android/content/ContentResolver.query:(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //    94: astore          11
        //    96: aload           11
        //    98: ifnull          349
        //   101: aload           11
        //   103: astore          10
        //   105: aload           11
        //   107: astore_0       
        //   108: aload           11
        //   110: invokeinterface android/database/Cursor.moveToFirst:()Z
        //   115: ifeq            349
        //   118: iconst_0       
        //   119: istore          8
        //   121: iconst_0       
        //   122: istore_2       
        //   123: aload           11
        //   125: astore          10
        //   127: aload           11
        //   129: astore_0       
        //   130: aload           11
        //   132: iconst_0       
        //   133: invokeinterface android/database/Cursor.getInt:(I)I
        //   138: istore          4
        //   140: aload           11
        //   142: astore_1       
        //   143: iload           4
        //   145: ifle            288
        //   148: aload           11
        //   150: astore          10
        //   152: aload           11
        //   154: astore_0       
        //   155: ldc             Lcom/google/android/gms/dynamite/DynamiteModule;.class
        //   157: monitorenter   
        //   158: aload           11
        //   160: iconst_2       
        //   161: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //   166: putstatic       com/google/android/gms/dynamite/DynamiteModule.i:Ljava/lang/String;
        //   169: aload           11
        //   171: ldc_w           "loaderVersion"
        //   174: invokeinterface android/database/Cursor.getColumnIndex:(Ljava/lang/String;)I
        //   179: istore          5
        //   181: iload           5
        //   183: iflt            198
        //   186: aload           11
        //   188: iload           5
        //   190: invokeinterface android/database/Cursor.getInt:(I)I
        //   195: putstatic       com/google/android/gms/dynamite/DynamiteModule.k:I
        //   198: aload           11
        //   200: ldc_w           "disableStandaloneDynamiteLoader2"
        //   203: invokeinterface android/database/Cursor.getColumnIndex:(Ljava/lang/String;)I
        //   208: istore          5
        //   210: iload           5
        //   212: iflt            239
        //   215: aload           11
        //   217: iload           5
        //   219: invokeinterface android/database/Cursor.getInt:(I)I
        //   224: ifeq            233
        //   227: iload           9
        //   229: istore_2       
        //   230: goto            235
        //   233: iconst_0       
        //   234: istore_2       
        //   235: iload_2        
        //   236: putstatic       com/google/android/gms/dynamite/DynamiteModule.j:Z
        //   239: ldc             Lcom/google/android/gms/dynamite/DynamiteModule;.class
        //   241: monitorexit    
        //   242: aload           11
        //   244: astore          10
        //   246: aload           11
        //   248: astore_0       
        //   249: aload           11
        //   251: invokestatic    com/google/android/gms/dynamite/DynamiteModule.j:(Landroid/database/Cursor;)Z
        //   254: istore          9
        //   256: aload           11
        //   258: astore_1       
        //   259: iload_2        
        //   260: istore          8
        //   262: iload           9
        //   264: ifeq            288
        //   267: aconst_null    
        //   268: astore_1       
        //   269: iload_2        
        //   270: istore          8
        //   272: goto            288
        //   275: astore_1       
        //   276: ldc             Lcom/google/android/gms/dynamite/DynamiteModule;.class
        //   278: monitorexit    
        //   279: aload           11
        //   281: astore          10
        //   283: aload           11
        //   285: astore_0       
        //   286: aload_1        
        //   287: athrow         
        //   288: iload_3        
        //   289: ifeq            336
        //   292: iload           8
        //   294: ifne            300
        //   297: goto            336
        //   300: aload_1        
        //   301: astore          10
        //   303: aload_1        
        //   304: astore_0       
        //   305: new             Lcom/google/android/gms/dynamite/DynamiteModule$LoadingException;
        //   308: astore          11
        //   310: aload_1        
        //   311: astore          10
        //   313: aload_1        
        //   314: astore_0       
        //   315: aload           11
        //   317: ldc_w           "forcing fallback to container DynamiteLoader impl"
        //   320: aconst_null    
        //   321: invokespecial   com/google/android/gms/dynamite/DynamiteModule$LoadingException.<init>:(Ljava/lang/String;Lcom/google/android/gms/dynamite/zzp;)V
        //   324: aload_1        
        //   325: astore          10
        //   327: aload_1        
        //   328: astore_0       
        //   329: aload           11
        //   331: athrow         
        //   332: astore_1       
        //   333: goto            411
        //   336: aload_1        
        //   337: ifnull          346
        //   340: aload_1        
        //   341: invokeinterface android/database/Cursor.close:()V
        //   346: iload           4
        //   348: ireturn        
        //   349: aload           11
        //   351: astore          10
        //   353: aload           11
        //   355: astore_0       
        //   356: ldc             "DynamiteModule"
        //   358: ldc_w           "Failed to retrieve remote module version."
        //   361: invokestatic    android/util/Log.w:(Ljava/lang/String;Ljava/lang/String;)I
        //   364: pop            
        //   365: aload           11
        //   367: astore          10
        //   369: aload           11
        //   371: astore_0       
        //   372: new             Lcom/google/android/gms/dynamite/DynamiteModule$LoadingException;
        //   375: astore_1       
        //   376: aload           11
        //   378: astore          10
        //   380: aload           11
        //   382: astore_0       
        //   383: aload_1        
        //   384: ldc_w           "Failed to connect to dynamite module ContentResolver."
        //   387: aconst_null    
        //   388: invokespecial   com/google/android/gms/dynamite/DynamiteModule$LoadingException.<init>:(Ljava/lang/String;Lcom/google/android/gms/dynamite/zzp;)V
        //   391: aload           11
        //   393: astore          10
        //   395: aload           11
        //   397: astore_0       
        //   398: aload_1        
        //   399: athrow         
        //   400: astore_1       
        //   401: aload           10
        //   403: astore_0       
        //   404: goto            454
        //   407: astore_1       
        //   408: aconst_null    
        //   409: astore          10
        //   411: aload           10
        //   413: astore_0       
        //   414: aload_1        
        //   415: instanceof      Lcom/google/android/gms/dynamite/DynamiteModule$LoadingException;
        //   418: ifeq            426
        //   421: aload           10
        //   423: astore_0       
        //   424: aload_1        
        //   425: athrow         
        //   426: aload           10
        //   428: astore_0       
        //   429: new             Lcom/google/android/gms/dynamite/DynamiteModule$LoadingException;
        //   432: astore          11
        //   434: aload           10
        //   436: astore_0       
        //   437: aload           11
        //   439: ldc_w           "V2 version check failed"
        //   442: aload_1        
        //   443: aconst_null    
        //   444: invokespecial   com/google/android/gms/dynamite/DynamiteModule$LoadingException.<init>:(Ljava/lang/String;Ljava/lang/Throwable;Lcom/google/android/gms/dynamite/zzp;)V
        //   447: aload           10
        //   449: astore_0       
        //   450: aload           11
        //   452: athrow         
        //   453: astore_1       
        //   454: aload_0        
        //   455: ifnull          464
        //   458: aload_0        
        //   459: invokeinterface android/database/Cursor.close:()V
        //   464: aload_1        
        //   465: athrow         
        //    Exceptions:
        //  throws com.google.android.gms.dynamite.DynamiteModule.LoadingException
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  3      23     407    411    Ljava/lang/Exception;
        //  3      23     400    407    Any
        //  39     96     407    411    Ljava/lang/Exception;
        //  39     96     400    407    Any
        //  108    118    332    336    Ljava/lang/Exception;
        //  108    118    453    454    Any
        //  130    140    332    336    Ljava/lang/Exception;
        //  130    140    453    454    Any
        //  155    158    332    336    Ljava/lang/Exception;
        //  155    158    453    454    Any
        //  158    181    275    288    Any
        //  186    198    275    288    Any
        //  198    210    275    288    Any
        //  215    227    275    288    Any
        //  235    239    275    288    Any
        //  239    242    275    288    Any
        //  249    256    332    336    Ljava/lang/Exception;
        //  249    256    453    454    Any
        //  276    279    275    288    Any
        //  286    288    332    336    Ljava/lang/Exception;
        //  286    288    453    454    Any
        //  305    310    332    336    Ljava/lang/Exception;
        //  305    310    453    454    Any
        //  315    324    332    336    Ljava/lang/Exception;
        //  315    324    453    454    Any
        //  329    332    332    336    Ljava/lang/Exception;
        //  329    332    453    454    Any
        //  356    365    332    336    Ljava/lang/Exception;
        //  356    365    453    454    Any
        //  372    376    332    336    Ljava/lang/Exception;
        //  372    376    453    454    Any
        //  383    391    332    336    Ljava/lang/Exception;
        //  383    391    453    454    Any
        //  398    400    332    336    Ljava/lang/Exception;
        //  398    400    453    454    Any
        //  414    421    453    454    Any
        //  424    426    453    454    Any
        //  429    434    453    454    Any
        //  437    447    453    454    Any
        //  450    453    453    454    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0198:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2604)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:206)
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
    
    private static DynamiteModule h(final Context context, final String s) {
        Log.i("DynamiteModule", "Selected local version of ".concat(String.valueOf(s)));
        return new DynamiteModule(context.getApplicationContext());
    }
    
    @GuardedBy
    private static void i(ClassLoader r) throws LoadingException {
        try {
            r = (NoSuchMethodException)((ClassLoader)r).loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor((Class<?>[])new Class[0]).newInstance(new Object[0]);
            if (r == null) {
                r = null;
            }
            else {
                final IInterface queryLocalInterface = ((IBinder)r).queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                if (queryLocalInterface instanceof zzr) {
                    r = (NoSuchMethodException)queryLocalInterface;
                }
                else {
                    r = (NoSuchMethodException)new zzr((IBinder)r);
                }
            }
            DynamiteModule.r = (zzr)r;
            return;
        }
        catch (final NoSuchMethodException r) {}
        catch (final InvocationTargetException r) {}
        catch (final InstantiationException r) {}
        catch (final IllegalAccessException r) {}
        catch (final ClassNotFoundException ex) {}
        throw new LoadingException("Failed to instantiate dynamite loader", r, null);
    }
    
    private static boolean j(final Cursor a) {
        final l l = DynamiteModule.m.get();
        if (l != null && l.a == null) {
            l.a = a;
            return true;
        }
        return false;
    }
    
    @GuardedBy
    private static boolean k(final Context context) {
        final Boolean true = Boolean.TRUE;
        if (true.equals(null)) {
            return true;
        }
        if (true.equals(DynamiteModule.l)) {
            return true;
        }
        final Boolean l = DynamiteModule.l;
        boolean b = false;
        final boolean b2 = false;
        if (l == null) {
            final ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.chimera", 0);
            boolean b3 = b2;
            if (GoogleApiAvailabilityLight.h().j(context, 10000000) == 0) {
                b3 = b2;
                if (resolveContentProvider != null) {
                    b3 = b2;
                    if ("com.google.android.gms".equals(resolveContentProvider.packageName)) {
                        b3 = true;
                    }
                }
            }
            final boolean booleanValue = DynamiteModule.l = b3;
            if (b = booleanValue) {
                b = booleanValue;
                if (resolveContentProvider != null) {
                    final ApplicationInfo applicationInfo = resolveContentProvider.applicationInfo;
                    b = booleanValue;
                    if (applicationInfo != null) {
                        b = booleanValue;
                        if ((applicationInfo.flags & 0x81) == 0x0) {
                            Log.i("DynamiteModule", "Non-system-image GmsCore APK, forcing V1");
                            DynamiteModule.j = true;
                            b = booleanValue;
                        }
                    }
                }
            }
        }
        if (!b) {
            Log.e("DynamiteModule", "Invalid GmsCore APK, remote loading disabled.");
        }
        return b;
    }
    
    private static zzq l(final Context context) {
        synchronized (DynamiteModule.class) {
            final zzq q = DynamiteModule.q;
            if (q != null) {
                return q;
            }
            try {
                final IBinder binder = (IBinder)context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                zzq q2;
                if (binder == null) {
                    q2 = null;
                }
                else {
                    final IInterface queryLocalInterface = binder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    if (queryLocalInterface instanceof zzq) {
                        q2 = (zzq)queryLocalInterface;
                    }
                    else {
                        q2 = new zzq(binder);
                    }
                }
                if (q2 != null) {
                    return DynamiteModule.q = q2;
                }
            }
            catch (final Exception ex) {
                final String message = ex.getMessage();
                final StringBuilder sb = new StringBuilder();
                sb.append("Failed to load IDynamiteLoader from GmsCore: ");
                sb.append(message);
                Log.e("DynamiteModule", sb.toString());
            }
            return null;
        }
    }
    
    @KeepForSdk
    public Context b() {
        return this.a;
    }
    
    @KeepForSdk
    public IBinder d(final String s) throws LoadingException {
        IBinder binder = null;
        try {
            binder = (IBinder)this.a.getClassLoader().loadClass(s).newInstance();
            return binder;
        }
        catch (final IllegalAccessException binder) {}
        catch (final InstantiationException binder) {}
        catch (final ClassNotFoundException ex) {}
        throw new LoadingException("Failed to instantiate module class: ".concat(String.valueOf(s)), (Throwable)binder, null);
    }
    
    @DynamiteApi
    public static class DynamiteLoaderClassLoader
    {
        @GuardedBy
        public static ClassLoader sClassLoader;
    }
    
    @KeepForSdk
    public static class LoadingException extends Exception
    {
        LoadingException(final String s, final zzp zzp) {
            super(s);
        }
        
        LoadingException(final String s, final Throwable t, final zzp zzp) {
            super(s, t);
        }
    }
    
    public interface VersionPolicy
    {
        @KeepForSdk
        SelectionResult a(final Context p0, final String p1, final IVersions p2) throws LoadingException;
        
        @KeepForSdk
        public interface IVersions
        {
            int a(final Context p0, final String p1, final boolean p2) throws LoadingException;
            
            int b(final Context p0, final String p1);
        }
        
        @KeepForSdk
        public static class SelectionResult
        {
            @KeepForSdk
            public int a;
            @KeepForSdk
            public int b;
            @KeepForSdk
            public int c;
            
            public SelectionResult() {
                this.a = 0;
                this.b = 0;
                this.c = 0;
            }
        }
    }
}
