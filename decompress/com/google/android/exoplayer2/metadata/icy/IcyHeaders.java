// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.metadata.icy;

import com.google.android.exoplayer2.MediaMetadata;
import java.util.List;
import java.util.Map;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.Assertions;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.exoplayer2.metadata.Metadata;

public final class IcyHeaders implements Entry
{
    public static final Parcelable$Creator<IcyHeaders> CREATOR;
    public final int a;
    public final String b;
    public final String c;
    public final String d;
    public final boolean e;
    public final int f;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<IcyHeaders>() {
            public IcyHeaders a(final Parcel parcel) {
                return new IcyHeaders(parcel);
            }
            
            public IcyHeaders[] b(final int n) {
                return new IcyHeaders[n];
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.a(parcel);
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.b(n);
            }
        };
    }
    
    public IcyHeaders(final int a, final String b, final String c, final String d, final boolean e, final int f) {
        Assertions.a(f == -1 || f > 0);
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }
    
    IcyHeaders(final Parcel parcel) {
        this.a = parcel.readInt();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = Util.M0(parcel);
        this.f = parcel.readInt();
    }
    
    public static IcyHeaders a(final Map<String, List<String>> p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "icy-br"
        //     3: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //     8: checkcast       Ljava/util/List;
        //    11: astore          8
        //    13: iconst_m1      
        //    14: istore_2       
        //    15: iconst_1       
        //    16: istore          6
        //    18: aload           8
        //    20: ifnull          145
        //    23: aload           8
        //    25: iconst_0       
        //    26: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //    31: checkcast       Ljava/lang/String;
        //    34: astore          8
        //    36: aload           8
        //    38: invokestatic    java/lang/Integer.parseInt:(Ljava/lang/String;)I
        //    41: istore_1       
        //    42: iload_1        
        //    43: sipush          1000
        //    46: imul           
        //    47: istore_3       
        //    48: iload_3        
        //    49: ifle            57
        //    52: iconst_1       
        //    53: istore_1       
        //    54: goto            139
        //    57: new             Ljava/lang/StringBuilder;
        //    60: astore          9
        //    62: aload           9
        //    64: invokespecial   java/lang/StringBuilder.<init>:()V
        //    67: aload           9
        //    69: ldc             "Invalid bitrate: "
        //    71: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    74: pop            
        //    75: aload           9
        //    77: aload           8
        //    79: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    82: pop            
        //    83: ldc             "IcyHeaders"
        //    85: aload           9
        //    87: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    90: invokestatic    com/google/android/exoplayer2/util/Log.i:(Ljava/lang/String;Ljava/lang/String;)V
        //    93: iconst_m1      
        //    94: istore_3       
        //    95: goto            137
        //    98: astore          9
        //   100: iconst_m1      
        //   101: istore_3       
        //   102: new             Ljava/lang/StringBuilder;
        //   105: dup            
        //   106: invokespecial   java/lang/StringBuilder.<init>:()V
        //   109: astore          9
        //   111: aload           9
        //   113: ldc             "Invalid bitrate header: "
        //   115: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   118: pop            
        //   119: aload           9
        //   121: aload           8
        //   123: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   126: pop            
        //   127: ldc             "IcyHeaders"
        //   129: aload           9
        //   131: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   134: invokestatic    com/google/android/exoplayer2/util/Log.i:(Ljava/lang/String;Ljava/lang/String;)V
        //   137: iconst_0       
        //   138: istore_1       
        //   139: iload_3        
        //   140: istore          4
        //   142: goto            150
        //   145: iconst_m1      
        //   146: istore          4
        //   148: iconst_0       
        //   149: istore_1       
        //   150: aload_0        
        //   151: ldc             "icy-genre"
        //   153: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //   158: checkcast       Ljava/util/List;
        //   161: astore          8
        //   163: aconst_null    
        //   164: astore          11
        //   166: aload           8
        //   168: ifnull          189
        //   171: aload           8
        //   173: iconst_0       
        //   174: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   179: checkcast       Ljava/lang/String;
        //   182: astore          8
        //   184: iconst_1       
        //   185: istore_1       
        //   186: goto            192
        //   189: aconst_null    
        //   190: astore          8
        //   192: aload_0        
        //   193: ldc             "icy-name"
        //   195: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //   200: checkcast       Ljava/util/List;
        //   203: astore          9
        //   205: aload           9
        //   207: ifnull          228
        //   210: aload           9
        //   212: iconst_0       
        //   213: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   218: checkcast       Ljava/lang/String;
        //   221: astore          9
        //   223: iconst_1       
        //   224: istore_1       
        //   225: goto            231
        //   228: aconst_null    
        //   229: astore          9
        //   231: aload_0        
        //   232: ldc             "icy-url"
        //   234: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //   239: checkcast       Ljava/util/List;
        //   242: astore          10
        //   244: aload           10
        //   246: ifnull          267
        //   249: aload           10
        //   251: iconst_0       
        //   252: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   257: checkcast       Ljava/lang/String;
        //   260: astore          10
        //   262: iconst_1       
        //   263: istore_1       
        //   264: goto            270
        //   267: aconst_null    
        //   268: astore          10
        //   270: aload_0        
        //   271: ldc             "icy-pub"
        //   273: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //   278: checkcast       Ljava/util/List;
        //   281: astore          12
        //   283: aload           12
        //   285: ifnull          311
        //   288: aload           12
        //   290: iconst_0       
        //   291: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   296: checkcast       Ljava/lang/String;
        //   299: ldc             "1"
        //   301: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   304: istore          7
        //   306: iconst_1       
        //   307: istore_1       
        //   308: goto            314
        //   311: iconst_0       
        //   312: istore          7
        //   314: aload_0        
        //   315: ldc             "icy-metaint"
        //   317: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //   322: checkcast       Ljava/util/List;
        //   325: astore_0       
        //   326: iload_1        
        //   327: istore          5
        //   329: iload_2        
        //   330: istore_3       
        //   331: aload_0        
        //   332: ifnull          449
        //   335: aload_0        
        //   336: iconst_0       
        //   337: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   342: checkcast       Ljava/lang/String;
        //   345: astore_0       
        //   346: aload_0        
        //   347: invokestatic    java/lang/Integer.parseInt:(Ljava/lang/String;)I
        //   350: istore_3       
        //   351: iload_3        
        //   352: ifle            363
        //   355: iload_3        
        //   356: istore_2       
        //   357: iload           6
        //   359: istore_1       
        //   360: goto            398
        //   363: new             Ljava/lang/StringBuilder;
        //   366: astore          12
        //   368: aload           12
        //   370: invokespecial   java/lang/StringBuilder.<init>:()V
        //   373: aload           12
        //   375: ldc             "Invalid metadata interval: "
        //   377: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   380: pop            
        //   381: aload           12
        //   383: aload_0        
        //   384: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   387: pop            
        //   388: ldc             "IcyHeaders"
        //   390: aload           12
        //   392: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   395: invokestatic    com/google/android/exoplayer2/util/Log.i:(Ljava/lang/String;Ljava/lang/String;)V
        //   398: iload_1        
        //   399: istore          5
        //   401: iload_2        
        //   402: istore_3       
        //   403: goto            449
        //   406: astore          12
        //   408: iload_3        
        //   409: istore_2       
        //   410: new             Ljava/lang/StringBuilder;
        //   413: dup            
        //   414: invokespecial   java/lang/StringBuilder.<init>:()V
        //   417: astore          12
        //   419: aload           12
        //   421: ldc             "Invalid metadata interval: "
        //   423: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   426: pop            
        //   427: aload           12
        //   429: aload_0        
        //   430: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   433: pop            
        //   434: ldc             "IcyHeaders"
        //   436: aload           12
        //   438: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   441: invokestatic    com/google/android/exoplayer2/util/Log.i:(Ljava/lang/String;Ljava/lang/String;)V
        //   444: iload_2        
        //   445: istore_3       
        //   446: iload_1        
        //   447: istore          5
        //   449: aload           11
        //   451: astore_0       
        //   452: iload           5
        //   454: ifeq            476
        //   457: new             Lcom/google/android/exoplayer2/metadata/icy/IcyHeaders;
        //   460: dup            
        //   461: iload           4
        //   463: aload           8
        //   465: aload           9
        //   467: aload           10
        //   469: iload           7
        //   471: iload_3        
        //   472: invokespecial   com/google/android/exoplayer2/metadata/icy/IcyHeaders.<init>:(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZI)V
        //   475: astore_0       
        //   476: aload_0        
        //   477: areturn        
        //   478: astore          9
        //   480: goto            102
        //   483: astore          12
        //   485: goto            410
        //    Signature:
        //  (Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;)Lcom/google/android/exoplayer2/metadata/icy/IcyHeaders;
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                             
        //  -----  -----  -----  -----  ---------------------------------
        //  36     42     98     102    Ljava/lang/NumberFormatException;
        //  57     93     478    483    Ljava/lang/NumberFormatException;
        //  346    351    483    488    Ljava/lang/NumberFormatException;
        //  363    398    406    410    Ljava/lang/NumberFormatException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0057:
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
    
    @Override
    public void B0(final MediaMetadata.Builder builder) {
        final String c = this.c;
        if (c != null) {
            builder.g0(c);
        }
        final String b = this.b;
        if (b != null) {
            builder.X(b);
        }
    }
    
    public int describeContents() {
        return 0;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (o != null && IcyHeaders.class == o.getClass()) {
            final IcyHeaders icyHeaders = (IcyHeaders)o;
            if (this.a != icyHeaders.a || !Util.c(this.b, icyHeaders.b) || !Util.c(this.c, icyHeaders.c) || !Util.c(this.d, icyHeaders.d) || this.e != icyHeaders.e || this.f != icyHeaders.f) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        final int a = this.a;
        final String b = this.b;
        int hashCode = 0;
        int hashCode2;
        if (b != null) {
            hashCode2 = b.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        final String c = this.c;
        int hashCode3;
        if (c != null) {
            hashCode3 = c.hashCode();
        }
        else {
            hashCode3 = 0;
        }
        final String d = this.d;
        if (d != null) {
            hashCode = d.hashCode();
        }
        return (((((527 + a) * 31 + hashCode2) * 31 + hashCode3) * 31 + hashCode) * 31 + (this.e ? 1 : 0)) * 31 + this.f;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("IcyHeaders: name=\"");
        sb.append(this.c);
        sb.append("\", genre=\"");
        sb.append(this.b);
        sb.append("\", bitrate=");
        sb.append(this.a);
        sb.append(", metadataInterval=");
        sb.append(this.f);
        return sb.toString();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeInt(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        Util.g1(parcel, this.e);
        parcel.writeInt(this.f);
    }
}
