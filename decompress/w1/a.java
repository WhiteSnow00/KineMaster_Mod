// 
// Decompiled by Procyon v0.6.0
// 

package w1;

import java.io.InputStream;
import y1.d;
import java.io.IOException;
import java.net.HttpURLConnection;

public class a implements c
{
    private final HttpURLConnection a;
    
    public a(final HttpURLConnection a) {
        this.a = a;
    }
    
    private String a(final HttpURLConnection p0) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: new             Ljava/io/InputStreamReader;
        //     7: dup            
        //     8: aload_1        
        //     9: invokevirtual   java/net/HttpURLConnection.getErrorStream:()Ljava/io/InputStream;
        //    12: invokespecial   java/io/InputStreamReader.<init>:(Ljava/io/InputStream;)V
        //    15: invokespecial   java/io/BufferedReader.<init>:(Ljava/io/Reader;)V
        //    18: astore_1       
        //    19: new             Ljava/lang/StringBuilder;
        //    22: dup            
        //    23: invokespecial   java/lang/StringBuilder.<init>:()V
        //    26: astore_2       
        //    27: aload_1        
        //    28: invokevirtual   java/io/BufferedReader.readLine:()Ljava/lang/String;
        //    31: astore_3       
        //    32: aload_3        
        //    33: ifnull          52
        //    36: aload_2        
        //    37: aload_3        
        //    38: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    41: pop            
        //    42: aload_2        
        //    43: bipush          10
        //    45: invokevirtual   java/lang/StringBuilder.append:(C)Ljava/lang/StringBuilder;
        //    48: pop            
        //    49: goto            27
        //    52: aload_1        
        //    53: invokevirtual   java/io/BufferedReader.close:()V
        //    56: aload_2        
        //    57: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    60: areturn        
        //    61: astore_2       
        //    62: goto            68
        //    65: astore_2       
        //    66: aload_2        
        //    67: athrow         
        //    68: aload_1        
        //    69: invokevirtual   java/io/BufferedReader.close:()V
        //    72: aload_2        
        //    73: athrow         
        //    74: astore_1       
        //    75: goto            56
        //    78: astore_1       
        //    79: goto            72
        //    Exceptions:
        //  throws java.io.IOException
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  27     32     65     68     Ljava/lang/Exception;
        //  27     32     61     74     Any
        //  36     49     65     68     Ljava/lang/Exception;
        //  36     49     61     74     Any
        //  52     56     74     78     Ljava/lang/Exception;
        //  66     68     61     74     Any
        //  68     72     78     82     Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 45, Size: 45
        //     at java.util.ArrayList.rangeCheck(Unknown Source)
        //     at java.util.ArrayList.get(Unknown Source)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3362)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:112)
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
    public String X() {
        return this.a.getContentType();
    }
    
    @Override
    public String X0() {
        try {
            String string;
            if (this.k0()) {
                string = null;
            }
            else {
                final StringBuilder sb = new StringBuilder();
                sb.append("Unable to fetch ");
                sb.append(this.a.getURL());
                sb.append(". Failed with ");
                sb.append(this.a.getResponseCode());
                sb.append("\n");
                sb.append(this.a(this.a));
                string = sb.toString();
            }
            return string;
        }
        catch (final IOException ex) {
            d.d("get error failed ", ex);
            return ex.getMessage();
        }
    }
    
    @Override
    public InputStream b0() throws IOException {
        return this.a.getInputStream();
    }
    
    @Override
    public void close() {
        this.a.disconnect();
    }
    
    @Override
    public boolean k0() {
        boolean b = false;
        try {
            if (this.a.getResponseCode() / 100 == 2) {
                b = true;
            }
            return b;
        }
        catch (final IOException ex) {
            return b;
        }
    }
}
