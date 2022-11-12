// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.nonagon.signalgeneration;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzcfi;
import android.util.Pair;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzcdw;
import com.google.android.gms.internal.ads.zzfuw;

final class c implements zzfuw
{
    final zzcdw a;
    final long b;
    final zzz c;
    
    c(final zzz c, final zzcdw a, final long b) {
        this.c = c;
        this.a = a;
        this.b = b;
    }
    
    public final void zza(final Throwable t) {
        final long a = zzt.a().a();
        final long b = this.b;
        final String message = t.getMessage();
        zzt.p().zzt(t, "SignalGeneratorImpl.generateSignals");
        final zzz c = this.c;
        zzf.c(zzz.Q1(c), zzz.P1(c), "sgf", new Pair((Object)"sgf_reason", (Object)message), new Pair((Object)"tqgt", (Object)String.valueOf(a - b)));
        try {
            final zzcdw a2 = this.a;
            final StringBuilder sb = new StringBuilder();
            sb.append("Internal error. ");
            sb.append(message);
            a2.zzb(sb.toString());
        }
        catch (final RemoteException ex) {
            zzcfi.zzh("", (Throwable)ex);
        }
    }
    
    public final /* bridge */ void zzb(final Object p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: checkcast       Lcom/google/android/gms/ads/nonagon/signalgeneration/zzal;
        //     4: astore_1       
        //     5: getstatic       com/google/android/gms/internal/ads/zzbhy.zzgu:Lcom/google/android/gms/internal/ads/zzbhq;
        //     8: astore          6
        //    10: invokestatic    com/google/android/gms/ads/internal/client/zzay.c:()Lcom/google/android/gms/internal/ads/zzbhw;
        //    13: aload           6
        //    15: invokevirtual   com/google/android/gms/internal/ads/zzbhw.zzb:(Lcom/google/android/gms/internal/ads/zzbhq;)Ljava/lang/Object;
        //    18: checkcast       Ljava/lang/Boolean;
        //    21: invokevirtual   java/lang/Boolean.booleanValue:()Z
        //    24: ifne            53
        //    27: aload_0        
        //    28: getfield        com/google/android/gms/ads/nonagon/signalgeneration/c.a:Lcom/google/android/gms/internal/ads/zzcdw;
        //    31: ldc             "QueryInfo generation has been disabled."
        //    33: invokeinterface com/google/android/gms/internal/ads/zzcdw.zzb:(Ljava/lang/String;)V
        //    38: return         
        //    39: astore_1       
        //    40: ldc             "QueryInfo generation has been disabled."
        //    42: aload_1        
        //    43: invokevirtual   java/lang/Object.toString:()Ljava/lang/String;
        //    46: invokevirtual   java/lang/String.concat:(Ljava/lang/String;)Ljava/lang/String;
        //    49: invokestatic    com/google/android/gms/internal/ads/zzcfi.zzg:(Ljava/lang/String;)V
        //    52: return         
        //    53: invokestatic    com/google/android/gms/ads/internal/zzt.a:()Lcom/google/android/gms/common/util/Clock;
        //    56: invokeinterface com/google/android/gms/common/util/Clock.a:()J
        //    61: lstore          4
        //    63: aload_0        
        //    64: getfield        com/google/android/gms/ads/nonagon/signalgeneration/c.b:J
        //    67: lstore_2       
        //    68: aload_1        
        //    69: ifnonnull       135
        //    72: aload_0        
        //    73: getfield        com/google/android/gms/ads/nonagon/signalgeneration/c.a:Lcom/google/android/gms/internal/ads/zzcdw;
        //    76: aconst_null    
        //    77: aconst_null    
        //    78: aconst_null    
        //    79: invokeinterface com/google/android/gms/internal/ads/zzcdw.zzc:(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V
        //    84: aload_0        
        //    85: getfield        com/google/android/gms/ads/nonagon/signalgeneration/c.c:Lcom/google/android/gms/ads/nonagon/signalgeneration/zzz;
        //    88: astore          6
        //    90: aload           6
        //    92: invokestatic    com/google/android/gms/ads/nonagon/signalgeneration/zzz.Q1:(Lcom/google/android/gms/ads/nonagon/signalgeneration/zzz;)Lcom/google/android/gms/internal/ads/zzdwl;
        //    95: astore_1       
        //    96: aload           6
        //    98: invokestatic    com/google/android/gms/ads/nonagon/signalgeneration/zzz.P1:(Lcom/google/android/gms/ads/nonagon/signalgeneration/zzz;)Lcom/google/android/gms/internal/ads/zzdwb;
        //   101: astore          6
        //   103: new             Landroid/util/Pair;
        //   106: astore          7
        //   108: aload           7
        //   110: ldc             "rid"
        //   112: ldc             "-1"
        //   114: invokespecial   android/util/Pair.<init>:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   117: aload_1        
        //   118: aload           6
        //   120: ldc             "sgs"
        //   122: iconst_1       
        //   123: anewarray       Landroid/util/Pair;
        //   126: dup            
        //   127: iconst_0       
        //   128: aload           7
        //   130: aastore        
        //   131: invokestatic    com/google/android/gms/ads/nonagon/signalgeneration/zzf.c:(Lcom/google/android/gms/internal/ads/zzdwl;Lcom/google/android/gms/internal/ads/zzdwb;Ljava/lang/String;[Landroid/util/Pair;)V
        //   134: return         
        //   135: new             Lorg/json/JSONObject;
        //   138: astore          6
        //   140: aload           6
        //   142: aload_1        
        //   143: getfield        com/google/android/gms/ads/nonagon/signalgeneration/zzal.b:Ljava/lang/String;
        //   146: invokespecial   org/json/JSONObject.<init>:(Ljava/lang/String;)V
        //   149: aload           6
        //   151: ldc             "request_id"
        //   153: ldc             ""
        //   155: invokevirtual   org/json/JSONObject.optString:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   158: astore          7
        //   160: aload           7
        //   162: invokestatic    android/text/TextUtils.isEmpty:(Ljava/lang/CharSequence;)Z
        //   165: ifeq            235
        //   168: ldc             "The request ID is empty in request JSON."
        //   170: invokestatic    com/google/android/gms/internal/ads/zzcfi.zzj:(Ljava/lang/String;)V
        //   173: aload_0        
        //   174: getfield        com/google/android/gms/ads/nonagon/signalgeneration/c.a:Lcom/google/android/gms/internal/ads/zzcdw;
        //   177: ldc             "Internal error: request ID is empty in request JSON."
        //   179: invokeinterface com/google/android/gms/internal/ads/zzcdw.zzb:(Ljava/lang/String;)V
        //   184: aload_0        
        //   185: getfield        com/google/android/gms/ads/nonagon/signalgeneration/c.c:Lcom/google/android/gms/ads/nonagon/signalgeneration/zzz;
        //   188: astore          6
        //   190: aload           6
        //   192: invokestatic    com/google/android/gms/ads/nonagon/signalgeneration/zzz.Q1:(Lcom/google/android/gms/ads/nonagon/signalgeneration/zzz;)Lcom/google/android/gms/internal/ads/zzdwl;
        //   195: astore_1       
        //   196: aload           6
        //   198: invokestatic    com/google/android/gms/ads/nonagon/signalgeneration/zzz.P1:(Lcom/google/android/gms/ads/nonagon/signalgeneration/zzz;)Lcom/google/android/gms/internal/ads/zzdwb;
        //   201: astore          7
        //   203: new             Landroid/util/Pair;
        //   206: astore          6
        //   208: aload           6
        //   210: ldc             "sgf_reason"
        //   212: ldc             "rid_missing"
        //   214: invokespecial   android/util/Pair.<init>:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   217: aload_1        
        //   218: aload           7
        //   220: ldc             "sgf"
        //   222: iconst_1       
        //   223: anewarray       Landroid/util/Pair;
        //   226: dup            
        //   227: iconst_0       
        //   228: aload           6
        //   230: aastore        
        //   231: invokestatic    com/google/android/gms/ads/nonagon/signalgeneration/zzf.c:(Lcom/google/android/gms/internal/ads/zzdwl;Lcom/google/android/gms/internal/ads/zzdwb;Ljava/lang/String;[Landroid/util/Pair;)V
        //   234: return         
        //   235: aload_0        
        //   236: getfield        com/google/android/gms/ads/nonagon/signalgeneration/c.c:Lcom/google/android/gms/ads/nonagon/signalgeneration/zzz;
        //   239: astore          6
        //   241: aload           6
        //   243: aload           7
        //   245: aload_1        
        //   246: getfield        com/google/android/gms/ads/nonagon/signalgeneration/zzal.b:Ljava/lang/String;
        //   249: aload           6
        //   251: invokestatic    com/google/android/gms/ads/nonagon/signalgeneration/zzz.P1:(Lcom/google/android/gms/ads/nonagon/signalgeneration/zzz;)Lcom/google/android/gms/internal/ads/zzdwb;
        //   254: invokestatic    com/google/android/gms/ads/nonagon/signalgeneration/zzz.t1:(Lcom/google/android/gms/ads/nonagon/signalgeneration/zzz;Ljava/lang/String;Ljava/lang/String;Lcom/google/android/gms/internal/ads/zzdwb;)V
        //   257: aload_1        
        //   258: getfield        com/google/android/gms/ads/nonagon/signalgeneration/zzal.c:Landroid/os/Bundle;
        //   261: astore          6
        //   263: aload_0        
        //   264: getfield        com/google/android/gms/ads/nonagon/signalgeneration/c.c:Lcom/google/android/gms/ads/nonagon/signalgeneration/zzz;
        //   267: astore          7
        //   269: aload           7
        //   271: invokestatic    com/google/android/gms/ads/nonagon/signalgeneration/zzz.w1:(Lcom/google/android/gms/ads/nonagon/signalgeneration/zzz;)Z
        //   274: ifeq            321
        //   277: aload           6
        //   279: ifnull          321
        //   282: aload           6
        //   284: aload           7
        //   286: invokestatic    com/google/android/gms/ads/nonagon/signalgeneration/zzz.Y1:(Lcom/google/android/gms/ads/nonagon/signalgeneration/zzz;)Ljava/lang/String;
        //   289: iconst_m1      
        //   290: invokevirtual   android/os/Bundle.getInt:(Ljava/lang/String;I)I
        //   293: iconst_m1      
        //   294: if_icmpne       321
        //   297: aload_0        
        //   298: getfield        com/google/android/gms/ads/nonagon/signalgeneration/c.c:Lcom/google/android/gms/ads/nonagon/signalgeneration/zzz;
        //   301: astore          7
        //   303: aload           6
        //   305: aload           7
        //   307: invokestatic    com/google/android/gms/ads/nonagon/signalgeneration/zzz.Y1:(Lcom/google/android/gms/ads/nonagon/signalgeneration/zzz;)Ljava/lang/String;
        //   310: aload           7
        //   312: invokestatic    com/google/android/gms/ads/nonagon/signalgeneration/zzz.q1:(Lcom/google/android/gms/ads/nonagon/signalgeneration/zzz;)Ljava/util/concurrent/atomic/AtomicInteger;
        //   315: invokevirtual   java/util/concurrent/atomic/AtomicInteger.get:()I
        //   318: invokevirtual   android/os/Bundle.putInt:(Ljava/lang/String;I)V
        //   321: aload_0        
        //   322: getfield        com/google/android/gms/ads/nonagon/signalgeneration/c.c:Lcom/google/android/gms/ads/nonagon/signalgeneration/zzz;
        //   325: astore          7
        //   327: aload           7
        //   329: invokestatic    com/google/android/gms/ads/nonagon/signalgeneration/zzz.x1:(Lcom/google/android/gms/ads/nonagon/signalgeneration/zzz;)Z
        //   332: ifeq            430
        //   335: aload           6
        //   337: ifnull          430
        //   340: aload           6
        //   342: aload           7
        //   344: invokestatic    com/google/android/gms/ads/nonagon/signalgeneration/zzz.a2:(Lcom/google/android/gms/ads/nonagon/signalgeneration/zzz;)Ljava/lang/String;
        //   347: invokevirtual   android/os/Bundle.getString:(Ljava/lang/String;)Ljava/lang/String;
        //   350: invokestatic    android/text/TextUtils.isEmpty:(Ljava/lang/CharSequence;)Z
        //   353: ifeq            430
        //   356: aload_0        
        //   357: getfield        com/google/android/gms/ads/nonagon/signalgeneration/c.c:Lcom/google/android/gms/ads/nonagon/signalgeneration/zzz;
        //   360: invokestatic    com/google/android/gms/ads/nonagon/signalgeneration/zzz.Z1:(Lcom/google/android/gms/ads/nonagon/signalgeneration/zzz;)Ljava/lang/String;
        //   363: invokestatic    android/text/TextUtils.isEmpty:(Ljava/lang/CharSequence;)Z
        //   366: ifeq            409
        //   369: aload_0        
        //   370: getfield        com/google/android/gms/ads/nonagon/signalgeneration/c.c:Lcom/google/android/gms/ads/nonagon/signalgeneration/zzz;
        //   373: astore          9
        //   375: invokestatic    com/google/android/gms/ads/internal/zzt.q:()Lcom/google/android/gms/ads/internal/util/zzs;
        //   378: astore          7
        //   380: aload_0        
        //   381: getfield        com/google/android/gms/ads/nonagon/signalgeneration/c.c:Lcom/google/android/gms/ads/nonagon/signalgeneration/zzz;
        //   384: astore          8
        //   386: aload           9
        //   388: aload           7
        //   390: aload           8
        //   392: invokestatic    com/google/android/gms/ads/nonagon/signalgeneration/zzz.L1:(Lcom/google/android/gms/ads/nonagon/signalgeneration/zzz;)Landroid/content/Context;
        //   395: aload           8
        //   397: invokestatic    com/google/android/gms/ads/nonagon/signalgeneration/zzz.O1:(Lcom/google/android/gms/ads/nonagon/signalgeneration/zzz;)Lcom/google/android/gms/internal/ads/zzcfo;
        //   400: getfield        com/google/android/gms/internal/ads/zzcfo.zza:Ljava/lang/String;
        //   403: invokevirtual   com/google/android/gms/ads/internal/util/zzs.y:(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
        //   406: invokestatic    com/google/android/gms/ads/nonagon/signalgeneration/zzz.r1:(Lcom/google/android/gms/ads/nonagon/signalgeneration/zzz;Ljava/lang/String;)V
        //   409: aload_0        
        //   410: getfield        com/google/android/gms/ads/nonagon/signalgeneration/c.c:Lcom/google/android/gms/ads/nonagon/signalgeneration/zzz;
        //   413: astore          7
        //   415: aload           6
        //   417: aload           7
        //   419: invokestatic    com/google/android/gms/ads/nonagon/signalgeneration/zzz.a2:(Lcom/google/android/gms/ads/nonagon/signalgeneration/zzz;)Ljava/lang/String;
        //   422: aload           7
        //   424: invokestatic    com/google/android/gms/ads/nonagon/signalgeneration/zzz.Z1:(Lcom/google/android/gms/ads/nonagon/signalgeneration/zzz;)Ljava/lang/String;
        //   427: invokevirtual   android/os/Bundle.putString:(Ljava/lang/String;Ljava/lang/String;)V
        //   430: aload_0        
        //   431: getfield        com/google/android/gms/ads/nonagon/signalgeneration/c.a:Lcom/google/android/gms/internal/ads/zzcdw;
        //   434: aload_1        
        //   435: getfield        com/google/android/gms/ads/nonagon/signalgeneration/zzal.a:Ljava/lang/String;
        //   438: aload_1        
        //   439: getfield        com/google/android/gms/ads/nonagon/signalgeneration/zzal.b:Ljava/lang/String;
        //   442: aload           6
        //   444: invokeinterface com/google/android/gms/internal/ads/zzcdw.zzc:(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V
        //   449: aload_0        
        //   450: getfield        com/google/android/gms/ads/nonagon/signalgeneration/c.c:Lcom/google/android/gms/ads/nonagon/signalgeneration/zzz;
        //   453: astore          6
        //   455: aload           6
        //   457: invokestatic    com/google/android/gms/ads/nonagon/signalgeneration/zzz.Q1:(Lcom/google/android/gms/ads/nonagon/signalgeneration/zzz;)Lcom/google/android/gms/internal/ads/zzdwl;
        //   460: astore_1       
        //   461: aload           6
        //   463: invokestatic    com/google/android/gms/ads/nonagon/signalgeneration/zzz.P1:(Lcom/google/android/gms/ads/nonagon/signalgeneration/zzz;)Lcom/google/android/gms/internal/ads/zzdwb;
        //   466: astore          6
        //   468: new             Landroid/util/Pair;
        //   471: astore          7
        //   473: aload           7
        //   475: ldc             "tqgt"
        //   477: lload           4
        //   479: lload_2        
        //   480: lsub           
        //   481: invokestatic    java/lang/String.valueOf:(J)Ljava/lang/String;
        //   484: invokespecial   android/util/Pair.<init>:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   487: aload_1        
        //   488: aload           6
        //   490: ldc             "sgs"
        //   492: iconst_1       
        //   493: anewarray       Landroid/util/Pair;
        //   496: dup            
        //   497: iconst_0       
        //   498: aload           7
        //   500: aastore        
        //   501: invokestatic    com/google/android/gms/ads/nonagon/signalgeneration/zzf.c:(Lcom/google/android/gms/internal/ads/zzdwl;Lcom/google/android/gms/internal/ads/zzdwb;Ljava/lang/String;[Landroid/util/Pair;)V
        //   504: return         
        //   505: astore_1       
        //   506: goto            619
        //   509: astore          6
        //   511: ldc_w           "Failed to create JSON object from the request string."
        //   514: invokestatic    com/google/android/gms/internal/ads/zzcfi.zzj:(Ljava/lang/String;)V
        //   517: aload_0        
        //   518: getfield        com/google/android/gms/ads/nonagon/signalgeneration/c.a:Lcom/google/android/gms/internal/ads/zzcdw;
        //   521: astore_1       
        //   522: aload           6
        //   524: invokevirtual   java/lang/Object.toString:()Ljava/lang/String;
        //   527: astore          7
        //   529: new             Ljava/lang/StringBuilder;
        //   532: astore          6
        //   534: aload           6
        //   536: invokespecial   java/lang/StringBuilder.<init>:()V
        //   539: aload           6
        //   541: ldc_w           "Internal error for request JSON: "
        //   544: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   547: pop            
        //   548: aload           6
        //   550: aload           7
        //   552: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   555: pop            
        //   556: aload_1        
        //   557: aload           6
        //   559: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   562: invokeinterface com/google/android/gms/internal/ads/zzcdw.zzb:(Ljava/lang/String;)V
        //   567: aload_0        
        //   568: getfield        com/google/android/gms/ads/nonagon/signalgeneration/c.c:Lcom/google/android/gms/ads/nonagon/signalgeneration/zzz;
        //   571: astore          6
        //   573: aload           6
        //   575: invokestatic    com/google/android/gms/ads/nonagon/signalgeneration/zzz.Q1:(Lcom/google/android/gms/ads/nonagon/signalgeneration/zzz;)Lcom/google/android/gms/internal/ads/zzdwl;
        //   578: astore_1       
        //   579: aload           6
        //   581: invokestatic    com/google/android/gms/ads/nonagon/signalgeneration/zzz.P1:(Lcom/google/android/gms/ads/nonagon/signalgeneration/zzz;)Lcom/google/android/gms/internal/ads/zzdwb;
        //   584: astore          7
        //   586: new             Landroid/util/Pair;
        //   589: astore          6
        //   591: aload           6
        //   593: ldc             "sgf_reason"
        //   595: ldc_w           "request_invalid"
        //   598: invokespecial   android/util/Pair.<init>:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   601: aload_1        
        //   602: aload           7
        //   604: ldc             "sgf"
        //   606: iconst_1       
        //   607: anewarray       Landroid/util/Pair;
        //   610: dup            
        //   611: iconst_0       
        //   612: aload           6
        //   614: aastore        
        //   615: invokestatic    com/google/android/gms/ads/nonagon/signalgeneration/zzf.c:(Lcom/google/android/gms/internal/ads/zzdwl;Lcom/google/android/gms/internal/ads/zzdwb;Ljava/lang/String;[Landroid/util/Pair;)V
        //   618: return         
        //   619: ldc             ""
        //   621: aload_1        
        //   622: invokestatic    com/google/android/gms/internal/ads/zzcfi.zzh:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   625: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                        
        //  -----  -----  -----  -----  ----------------------------
        //  27     38     39     53     Landroid/os/RemoteException;
        //  72     134    505    509    Landroid/os/RemoteException;
        //  135    149    509    619    Lorg/json/JSONException;
        //  135    149    505    509    Landroid/os/RemoteException;
        //  149    234    505    509    Landroid/os/RemoteException;
        //  235    277    505    509    Landroid/os/RemoteException;
        //  282    321    505    509    Landroid/os/RemoteException;
        //  321    335    505    509    Landroid/os/RemoteException;
        //  340    409    505    509    Landroid/os/RemoteException;
        //  409    430    505    509    Landroid/os/RemoteException;
        //  430    504    505    509    Landroid/os/RemoteException;
        //  511    618    505    509    Landroid/os/RemoteException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0135:
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
}
