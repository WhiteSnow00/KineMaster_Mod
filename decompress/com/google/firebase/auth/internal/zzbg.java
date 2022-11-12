// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth.internal;

import java.util.List;
import com.google.android.gms.internal.firebase_auth_api.zznp;
import com.google.firebase.auth.MultiFactorInfo;
import org.json.JSONArray;
import com.google.android.gms.internal.firebase-auth-api.zzwq;
import android.text.TextUtils;
import com.google.firebase.auth.FirebaseUser;
import org.json.JSONObject;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import android.content.SharedPreferences;
import android.content.Context;

public final class zzbg
{
    private final Context a;
    private final String b;
    private final SharedPreferences c;
    private final Logger d;
    
    public zzbg(Context applicationContext, String g) {
        Preconditions.k(applicationContext);
        g = Preconditions.g(g);
        this.b = g;
        applicationContext = applicationContext.getApplicationContext();
        this.a = applicationContext;
        this.c = applicationContext.getSharedPreferences(String.format("com.google.firebase.auth.api.Store.%s", g), 0);
        this.d = new Logger("StorageHelpers", new String[0]);
    }
    
    private final zzx f(final JSONObject p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "cachedTokenState"
        //     3: invokevirtual   org/json/JSONObject.getString:(Ljava/lang/String;)Ljava/lang/String;
        //     6: astore          10
        //     8: aload_1        
        //     9: ldc             "applicationName"
        //    11: invokevirtual   org/json/JSONObject.getString:(Ljava/lang/String;)Ljava/lang/String;
        //    14: astore          11
        //    16: aload_1        
        //    17: ldc             "anonymous"
        //    19: invokevirtual   org/json/JSONObject.getBoolean:(Ljava/lang/String;)Z
        //    22: istore          6
        //    24: ldc             "2"
        //    26: astore          8
        //    28: aload_1        
        //    29: ldc             "version"
        //    31: invokevirtual   org/json/JSONObject.getString:(Ljava/lang/String;)Ljava/lang/String;
        //    34: astore          9
        //    36: aload           9
        //    38: ifnull          45
        //    41: aload           9
        //    43: astore          8
        //    45: aload_1        
        //    46: ldc             "userInfos"
        //    48: invokevirtual   org/json/JSONObject.getJSONArray:(Ljava/lang/String;)Lorg/json/JSONArray;
        //    51: astore          9
        //    53: aload           9
        //    55: invokevirtual   org/json/JSONArray.length:()I
        //    58: istore_3       
        //    59: new             Ljava/util/ArrayList;
        //    62: astore          12
        //    64: aload           12
        //    66: iload_3        
        //    67: invokespecial   java/util/ArrayList.<init>:(I)V
        //    70: iconst_0       
        //    71: istore_2       
        //    72: iload_2        
        //    73: iload_3        
        //    74: if_icmpge       238
        //    77: aload           9
        //    79: iload_2        
        //    80: invokevirtual   org/json/JSONArray.getString:(I)Ljava/lang/String;
        //    83: astore          13
        //    85: getstatic       com/google/firebase/auth/internal/zzt.CREATOR:Landroid/os/Parcelable$Creator;
        //    88: astore          14
        //    90: new             Lorg/json/JSONObject;
        //    93: astore          19
        //    95: aload           19
        //    97: aload           13
        //    99: invokespecial   org/json/JSONObject.<init>:(Ljava/lang/String;)V
        //   102: aload           19
        //   104: ldc             "userId"
        //   106: invokevirtual   org/json/JSONObject.optString:(Ljava/lang/String;)Ljava/lang/String;
        //   109: astore          15
        //   111: aload           19
        //   113: ldc             "providerId"
        //   115: invokevirtual   org/json/JSONObject.optString:(Ljava/lang/String;)Ljava/lang/String;
        //   118: astore          14
        //   120: aload           19
        //   122: ldc             "email"
        //   124: invokevirtual   org/json/JSONObject.optString:(Ljava/lang/String;)Ljava/lang/String;
        //   127: astore          18
        //   129: aload           19
        //   131: ldc             "phoneNumber"
        //   133: invokevirtual   org/json/JSONObject.optString:(Ljava/lang/String;)Ljava/lang/String;
        //   136: astore          13
        //   138: aload           19
        //   140: ldc             "displayName"
        //   142: invokevirtual   org/json/JSONObject.optString:(Ljava/lang/String;)Ljava/lang/String;
        //   145: astore          16
        //   147: aload           19
        //   149: ldc             "photoUrl"
        //   151: invokevirtual   org/json/JSONObject.optString:(Ljava/lang/String;)Ljava/lang/String;
        //   154: astore          17
        //   156: aload           19
        //   158: ldc             "isEmailVerified"
        //   160: invokevirtual   org/json/JSONObject.optBoolean:(Ljava/lang/String;)Z
        //   163: istore          7
        //   165: aload           19
        //   167: ldc             "rawUserInfo"
        //   169: invokevirtual   org/json/JSONObject.optString:(Ljava/lang/String;)Ljava/lang/String;
        //   172: astore          20
        //   174: new             Lcom/google/firebase/auth/internal/zzt;
        //   177: astore          19
        //   179: aload           19
        //   181: aload           15
        //   183: aload           14
        //   185: aload           18
        //   187: aload           13
        //   189: aload           16
        //   191: aload           17
        //   193: iload           7
        //   195: aload           20
        //   197: invokespecial   com/google/firebase/auth/internal/zzt.<init>:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V
        //   200: aload           12
        //   202: aload           19
        //   204: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   209: pop            
        //   210: iinc            2, 1
        //   213: goto            72
        //   216: astore          8
        //   218: ldc             "DefaultAuthUserInfo"
        //   220: ldc             "Failed to unpack UserInfo from JSON"
        //   222: invokestatic    android/util/Log.d:(Ljava/lang/String;Ljava/lang/String;)I
        //   225: pop            
        //   226: new             Lcom/google/android/gms/internal/firebase_auth_api/zznp;
        //   229: astore_1       
        //   230: aload_1        
        //   231: aload           8
        //   233: invokespecial   com/google/android/gms/internal/firebase_auth_api/zznp.<init>:(Ljava/lang/Throwable;)V
        //   236: aload_1        
        //   237: athrow         
        //   238: aload           11
        //   240: invokestatic    com/google/firebase/FirebaseApp.n:(Ljava/lang/String;)Lcom/google/firebase/FirebaseApp;
        //   243: astore          11
        //   245: new             Lcom/google/firebase/auth/internal/zzx;
        //   248: astore          9
        //   250: aload           9
        //   252: aload           11
        //   254: aload           12
        //   256: invokespecial   com/google/firebase/auth/internal/zzx.<init>:(Lcom/google/firebase/FirebaseApp;Ljava/util/List;)V
        //   259: aload           10
        //   261: invokestatic    android/text/TextUtils.isEmpty:(Ljava/lang/CharSequence;)Z
        //   264: ifne            277
        //   267: aload           9
        //   269: aload           10
        //   271: invokestatic    com/google/android/gms/internal/firebase_auth_api/zzwq.zzd:(Ljava/lang/String;)Lcom/google/android/gms/internal/firebase-auth-api/zzwq;
        //   274: invokevirtual   com/google/firebase/auth/internal/zzx.c2:(Lcom/google/android/gms/internal/firebase-auth-api/zzwq;)V
        //   277: iload           6
        //   279: ifne            288
        //   282: aload           9
        //   284: invokevirtual   com/google/firebase/auth/internal/zzx.h2:()Lcom/google/firebase/auth/internal/zzx;
        //   287: pop            
        //   288: aload           9
        //   290: aload           8
        //   292: invokevirtual   com/google/firebase/auth/internal/zzx.g2:(Ljava/lang/String;)Lcom/google/firebase/auth/internal/zzx;
        //   295: pop            
        //   296: aload_1        
        //   297: ldc             "userMetadata"
        //   299: invokevirtual   org/json/JSONObject.has:(Ljava/lang/String;)Z
        //   302: ifeq            364
        //   305: aload_1        
        //   306: ldc             "userMetadata"
        //   308: invokevirtual   org/json/JSONObject.getJSONObject:(Ljava/lang/String;)Lorg/json/JSONObject;
        //   311: astore          8
        //   313: getstatic       com/google/firebase/auth/internal/zzz.CREATOR:Landroid/os/Parcelable$Creator;
        //   316: astore          10
        //   318: aload           8
        //   320: ifnonnull       329
        //   323: aconst_null    
        //   324: astore          8
        //   326: goto            352
        //   329: new             Lcom/google/firebase/auth/internal/zzz;
        //   332: dup            
        //   333: aload           8
        //   335: ldc             "lastSignInTimestamp"
        //   337: invokevirtual   org/json/JSONObject.getLong:(Ljava/lang/String;)J
        //   340: aload           8
        //   342: ldc             "creationTimestamp"
        //   344: invokevirtual   org/json/JSONObject.getLong:(Ljava/lang/String;)J
        //   347: invokespecial   com/google/firebase/auth/internal/zzz.<init>:(JJ)V
        //   350: astore          8
        //   352: aload           8
        //   354: ifnull          364
        //   357: aload           9
        //   359: aload           8
        //   361: invokevirtual   com/google/firebase/auth/internal/zzx.m2:(Lcom/google/firebase/auth/internal/zzz;)V
        //   364: aload_1        
        //   365: ldc             "userMultiFactorInfo"
        //   367: invokevirtual   org/json/JSONObject.has:(Ljava/lang/String;)Z
        //   370: ifeq            540
        //   373: aload_1        
        //   374: ldc             "userMultiFactorInfo"
        //   376: invokevirtual   org/json/JSONObject.getJSONArray:(Ljava/lang/String;)Lorg/json/JSONArray;
        //   379: astore          10
        //   381: aload           10
        //   383: ifnull          540
        //   386: new             Ljava/util/ArrayList;
        //   389: astore          8
        //   391: aload           8
        //   393: invokespecial   java/util/ArrayList.<init>:()V
        //   396: iconst_0       
        //   397: istore_2       
        //   398: iload_2        
        //   399: aload           10
        //   401: invokevirtual   org/json/JSONArray.length:()I
        //   404: if_icmpge       533
        //   407: aload           10
        //   409: iload_2        
        //   410: invokevirtual   org/json/JSONArray.getString:(I)Ljava/lang/String;
        //   413: astore          11
        //   415: new             Lorg/json/JSONObject;
        //   418: astore_1       
        //   419: aload_1        
        //   420: aload           11
        //   422: invokespecial   org/json/JSONObject.<init>:(Ljava/lang/String;)V
        //   425: ldc             "phone"
        //   427: aload_1        
        //   428: ldc             "factorIdKey"
        //   430: invokevirtual   org/json/JSONObject.optString:(Ljava/lang/String;)Ljava/lang/String;
        //   433: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   436: ifeq            516
        //   439: getstatic       com/google/firebase/auth/PhoneMultiFactorInfo.CREATOR:Landroid/os/Parcelable$Creator;
        //   442: astore          11
        //   444: aload_1        
        //   445: ldc             "enrollmentTimestamp"
        //   447: invokevirtual   org/json/JSONObject.has:(Ljava/lang/String;)Z
        //   450: ifeq            504
        //   453: aload_1        
        //   454: ldc             "uid"
        //   456: invokevirtual   org/json/JSONObject.optString:(Ljava/lang/String;)Ljava/lang/String;
        //   459: astore          11
        //   461: aload_1        
        //   462: ldc             "displayName"
        //   464: invokevirtual   org/json/JSONObject.optString:(Ljava/lang/String;)Ljava/lang/String;
        //   467: astore          12
        //   469: aload_1        
        //   470: ldc             "enrollmentTimestamp"
        //   472: invokevirtual   org/json/JSONObject.optLong:(Ljava/lang/String;)J
        //   475: lstore          4
        //   477: aload_1        
        //   478: ldc             "phoneNumber"
        //   480: invokevirtual   org/json/JSONObject.optString:(Ljava/lang/String;)Ljava/lang/String;
        //   483: astore          13
        //   485: new             Lcom/google/firebase/auth/PhoneMultiFactorInfo;
        //   488: astore_1       
        //   489: aload_1        
        //   490: aload           11
        //   492: aload           12
        //   494: lload           4
        //   496: aload           13
        //   498: invokespecial   com/google/firebase/auth/PhoneMultiFactorInfo.<init>:(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V
        //   501: goto            518
        //   504: new             Ljava/lang/IllegalArgumentException;
        //   507: astore_1       
        //   508: aload_1        
        //   509: ldc             "An enrollment timestamp in seconds of UTC time since Unix epoch is required to build a PhoneMultiFactorInfo instance."
        //   511: invokespecial   java/lang/IllegalArgumentException.<init>:(Ljava/lang/String;)V
        //   514: aload_1        
        //   515: athrow         
        //   516: aconst_null    
        //   517: astore_1       
        //   518: aload           8
        //   520: aload_1        
        //   521: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   526: pop            
        //   527: iinc            2, 1
        //   530: goto            398
        //   533: aload           9
        //   535: aload           8
        //   537: invokevirtual   com/google/firebase/auth/internal/zzx.d2:(Ljava/util/List;)V
        //   540: aload           9
        //   542: areturn        
        //   543: astore_1       
        //   544: goto            556
        //   547: astore_1       
        //   548: goto            556
        //   551: astore_1       
        //   552: goto            556
        //   555: astore_1       
        //   556: aload_0        
        //   557: getfield        com/google/firebase/auth/internal/zzbg.d:Lcom/google/android/gms/common/logging/Logger;
        //   560: aload_1        
        //   561: invokevirtual   com/google/android/gms/common/logging/Logger.j:(Ljava/lang/Throwable;)V
        //   564: aconst_null    
        //   565: areturn        
        //   566: astore          8
        //   568: goto            323
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                                    
        //  -----  -----  -----  -----  --------------------------------------------------------
        //  0      24     555    556    Lorg/json/JSONException;
        //  0      24     551    555    Ljava/lang/ArrayIndexOutOfBoundsException;
        //  0      24     547    551    Ljava/lang/IllegalArgumentException;
        //  0      24     543    547    Lcom/google/android/gms/internal/firebase_auth_api/zznp;
        //  28     36     555    556    Lorg/json/JSONException;
        //  28     36     551    555    Ljava/lang/ArrayIndexOutOfBoundsException;
        //  28     36     547    551    Ljava/lang/IllegalArgumentException;
        //  28     36     543    547    Lcom/google/android/gms/internal/firebase_auth_api/zznp;
        //  45     70     555    556    Lorg/json/JSONException;
        //  45     70     551    555    Ljava/lang/ArrayIndexOutOfBoundsException;
        //  45     70     547    551    Ljava/lang/IllegalArgumentException;
        //  45     70     543    547    Lcom/google/android/gms/internal/firebase_auth_api/zznp;
        //  77     90     555    556    Lorg/json/JSONException;
        //  77     90     551    555    Ljava/lang/ArrayIndexOutOfBoundsException;
        //  77     90     547    551    Ljava/lang/IllegalArgumentException;
        //  77     90     543    547    Lcom/google/android/gms/internal/firebase_auth_api/zznp;
        //  90     200    216    238    Lorg/json/JSONException;
        //  90     200    551    555    Ljava/lang/ArrayIndexOutOfBoundsException;
        //  90     200    547    551    Ljava/lang/IllegalArgumentException;
        //  90     200    543    547    Lcom/google/android/gms/internal/firebase_auth_api/zznp;
        //  200    210    555    556    Lorg/json/JSONException;
        //  200    210    551    555    Ljava/lang/ArrayIndexOutOfBoundsException;
        //  200    210    547    551    Ljava/lang/IllegalArgumentException;
        //  200    210    543    547    Lcom/google/android/gms/internal/firebase_auth_api/zznp;
        //  218    238    555    556    Lorg/json/JSONException;
        //  218    238    551    555    Ljava/lang/ArrayIndexOutOfBoundsException;
        //  218    238    547    551    Ljava/lang/IllegalArgumentException;
        //  218    238    543    547    Lcom/google/android/gms/internal/firebase_auth_api/zznp;
        //  238    277    555    556    Lorg/json/JSONException;
        //  238    277    551    555    Ljava/lang/ArrayIndexOutOfBoundsException;
        //  238    277    547    551    Ljava/lang/IllegalArgumentException;
        //  238    277    543    547    Lcom/google/android/gms/internal/firebase_auth_api/zznp;
        //  282    288    555    556    Lorg/json/JSONException;
        //  282    288    551    555    Ljava/lang/ArrayIndexOutOfBoundsException;
        //  282    288    547    551    Ljava/lang/IllegalArgumentException;
        //  282    288    543    547    Lcom/google/android/gms/internal/firebase_auth_api/zznp;
        //  288    318    555    556    Lorg/json/JSONException;
        //  288    318    551    555    Ljava/lang/ArrayIndexOutOfBoundsException;
        //  288    318    547    551    Ljava/lang/IllegalArgumentException;
        //  288    318    543    547    Lcom/google/android/gms/internal/firebase_auth_api/zznp;
        //  329    352    566    571    Lorg/json/JSONException;
        //  329    352    551    555    Ljava/lang/ArrayIndexOutOfBoundsException;
        //  329    352    547    551    Ljava/lang/IllegalArgumentException;
        //  329    352    543    547    Lcom/google/android/gms/internal/firebase_auth_api/zznp;
        //  357    364    555    556    Lorg/json/JSONException;
        //  357    364    551    555    Ljava/lang/ArrayIndexOutOfBoundsException;
        //  357    364    547    551    Ljava/lang/IllegalArgumentException;
        //  357    364    543    547    Lcom/google/android/gms/internal/firebase_auth_api/zznp;
        //  364    381    555    556    Lorg/json/JSONException;
        //  364    381    551    555    Ljava/lang/ArrayIndexOutOfBoundsException;
        //  364    381    547    551    Ljava/lang/IllegalArgumentException;
        //  364    381    543    547    Lcom/google/android/gms/internal/firebase_auth_api/zznp;
        //  386    396    555    556    Lorg/json/JSONException;
        //  386    396    551    555    Ljava/lang/ArrayIndexOutOfBoundsException;
        //  386    396    547    551    Ljava/lang/IllegalArgumentException;
        //  386    396    543    547    Lcom/google/android/gms/internal/firebase_auth_api/zznp;
        //  398    501    555    556    Lorg/json/JSONException;
        //  398    501    551    555    Ljava/lang/ArrayIndexOutOfBoundsException;
        //  398    501    547    551    Ljava/lang/IllegalArgumentException;
        //  398    501    543    547    Lcom/google/android/gms/internal/firebase_auth_api/zznp;
        //  504    516    555    556    Lorg/json/JSONException;
        //  504    516    551    555    Ljava/lang/ArrayIndexOutOfBoundsException;
        //  504    516    547    551    Ljava/lang/IllegalArgumentException;
        //  504    516    543    547    Lcom/google/android/gms/internal/firebase_auth_api/zznp;
        //  518    527    555    556    Lorg/json/JSONException;
        //  518    527    551    555    Ljava/lang/ArrayIndexOutOfBoundsException;
        //  518    527    547    551    Ljava/lang/IllegalArgumentException;
        //  518    527    543    547    Lcom/google/android/gms/internal/firebase_auth_api/zznp;
        //  533    540    555    556    Lorg/json/JSONException;
        //  533    540    551    555    Ljava/lang/ArrayIndexOutOfBoundsException;
        //  533    540    547    551    Ljava/lang/IllegalArgumentException;
        //  533    540    543    547    Lcom/google/android/gms/internal/firebase_auth_api/zznp;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0329:
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
    
    public final FirebaseUser a() {
        final String string = this.c.getString("com.google.firebase.auth.FIREBASE_USER", (String)null);
        if (TextUtils.isEmpty((CharSequence)string)) {
            return null;
        }
        try {
            final JSONObject jsonObject = new JSONObject(string);
            if (jsonObject.has("type") && "com.google.firebase.auth.internal.DefaultFirebaseUser".equalsIgnoreCase(jsonObject.optString("type"))) {
                return this.f(jsonObject);
            }
            return null;
        }
        catch (final Exception ex) {
            return null;
        }
    }
    
    public final zzwq b(final FirebaseUser firebaseUser) {
        Preconditions.k(firebaseUser);
        final String string = this.c.getString(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", firebaseUser.S1()), (String)null);
        if (string != null) {
            return com.google.android.gms.internal.firebase_auth_api.zzwq.zzd(string);
        }
        return null;
    }
    
    public final void c(final String s) {
        this.c.edit().remove(s).apply();
    }
    
    public final void d(final FirebaseUser firebaseUser) {
        Preconditions.k(firebaseUser);
        final JSONObject jsonObject = new JSONObject();
        String string = null;
        Label_0360: {
            if (zzx.class.isAssignableFrom(firebaseUser.getClass())) {
                final zzx zzx = (zzx)firebaseUser;
                try {
                    jsonObject.put("cachedTokenState", (Object)zzx.zzf());
                    jsonObject.put("applicationName", (Object)zzx.Y1().o());
                    jsonObject.put("type", (Object)"com.google.firebase.auth.internal.DefaultFirebaseUser");
                    if (zzx.j2() != null) {
                        final JSONArray jsonArray = new JSONArray();
                        final List j2 = zzx.j2();
                        int size = j2.size();
                        if (j2.size() > 30) {
                            this.d.h("Provider user info list size larger than max size, truncating list to %d. Actual list size: %d", 30, j2.size());
                            size = 30;
                        }
                        for (int i = 0; i < size; ++i) {
                            jsonArray.put((Object)((zzt)j2.get(i)).zzb());
                        }
                        jsonObject.put("userInfos", (Object)jsonArray);
                    }
                    jsonObject.put("anonymous", zzx.T1());
                    jsonObject.put("version", (Object)"2");
                    if (zzx.e2() != null) {
                        jsonObject.put("userMetadata", (Object)((zzz)zzx.e2()).a());
                    }
                    final List<MultiFactorInfo> a = new zzac(zzx).a();
                    if (!a.isEmpty()) {
                        final JSONArray jsonArray2 = new JSONArray();
                        for (int k = 0; k < a.size(); ++k) {
                            jsonArray2.put((Object)((MultiFactorInfo)a.get(k)).K1());
                        }
                        jsonObject.put("userMultiFactorInfo", (Object)jsonArray2);
                    }
                    string = jsonObject.toString();
                    break Label_0360;
                }
                catch (final Exception ex) {
                    this.d.i("Failed to turn object into JSON", ex, new Object[0]);
                    throw new zznp((Throwable)ex);
                }
            }
            string = null;
        }
        if (!TextUtils.isEmpty((CharSequence)string)) {
            this.c.edit().putString("com.google.firebase.auth.FIREBASE_USER", string).apply();
        }
    }
    
    public final void e(final FirebaseUser firebaseUser, final zzwq zzwq) {
        Preconditions.k(firebaseUser);
        Preconditions.k(zzwq);
        this.c.edit().putString(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", firebaseUser.S1()), ((com.google.android.gms.internal.firebase_auth_api.zzwq)zzwq).zzh()).apply();
    }
}
