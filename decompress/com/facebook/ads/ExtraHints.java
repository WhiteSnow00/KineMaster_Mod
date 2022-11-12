// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;
import java.util.HashMap;
import androidx.annotation.Keep;

@Deprecated
@Keep
public class ExtraHints
{
    private static final String HINTS_JSON_KEY = "hints";
    private static final int KEYWORDS_MAX_COUNT = 5;
    private static final String KEYWORD_SEPARATOR = ";";
    private final String mHintsSerialized;
    private final String mMediationData;
    
    private ExtraHints(final HashMap<HintType, String> p0, final String p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokespecial   java/lang/Object.<init>:()V
        //     4: aload_0        
        //     5: aload_2        
        //     6: putfield        com/facebook/ads/ExtraHints.mMediationData:Ljava/lang/String;
        //     9: new             Lorg/json/JSONObject;
        //    12: dup            
        //    13: invokespecial   org/json/JSONObject.<init>:()V
        //    16: astore_2       
        //    17: new             Lorg/json/JSONObject;
        //    20: dup            
        //    21: invokespecial   org/json/JSONObject.<init>:()V
        //    24: astore_3       
        //    25: aload_1        
        //    26: invokevirtual   java/util/HashMap.entrySet:()Ljava/util/Set;
        //    29: invokeinterface java/util/Set.iterator:()Ljava/util/Iterator;
        //    34: astore_1       
        //    35: aload_1        
        //    36: invokeinterface java/util/Iterator.hasNext:()Z
        //    41: ifeq            83
        //    44: aload_1        
        //    45: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    50: checkcast       Ljava/util/Map$Entry;
        //    53: astore          4
        //    55: aload_3        
        //    56: aload           4
        //    58: invokeinterface java/util/Map$Entry.getKey:()Ljava/lang/Object;
        //    63: checkcast       Lcom/facebook/ads/ExtraHints$HintType;
        //    66: invokestatic    com/facebook/ads/ExtraHints$HintType.access$000:(Lcom/facebook/ads/ExtraHints$HintType;)Ljava/lang/String;
        //    69: aload           4
        //    71: invokeinterface java/util/Map$Entry.getValue:()Ljava/lang/Object;
        //    76: invokevirtual   org/json/JSONObject.put:(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //    79: pop            
        //    80: goto            35
        //    83: aload_2        
        //    84: ldc             "hints"
        //    86: aload_3        
        //    87: invokevirtual   org/json/JSONObject.put:(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //    90: pop            
        //    91: aload_0        
        //    92: aload_2        
        //    93: invokevirtual   org/json/JSONObject.toString:()Ljava/lang/String;
        //    96: putfield        com/facebook/ads/ExtraHints.mHintsSerialized:Ljava/lang/String;
        //    99: return         
        //   100: astore          4
        //   102: goto            35
        //   105: astore_1       
        //   106: goto            91
        //    Signature:
        //  (Ljava/util/HashMap<Lcom/facebook/ads/ExtraHints$HintType;Ljava/lang/String;>;Ljava/lang/String;)V
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                    
        //  -----  -----  -----  -----  ------------------------
        //  55     80     100    105    Lorg/json/JSONException;
        //  83     91     105    109    Lorg/json/JSONException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0083:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2604)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:206)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:93)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:868)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createConstructor(AstBuilder.java:799)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:635)
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
    
    ExtraHints(final HashMap hashMap, final String s, final ExtraHints$a object) {
        this(hashMap, s);
    }
    
    private static String join(final List<String> list) {
        final StringBuilder sb = new StringBuilder();
        final Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next());
            sb.append(";");
        }
        return sb.toString();
    }
    
    public String getHints() {
        return this.mHintsSerialized;
    }
    
    public String getMediationData() {
        return this.mMediationData;
    }
    
    @Deprecated
    @Keep
    public static class Builder
    {
        private HashMap<HintType, String> mHints;
        private String mMediationData;
        
        public Builder() {
            this.mHints = new HashMap<HintType, String>();
        }
        
        public ExtraHints build() {
            return new ExtraHints(this.mHints, this.mMediationData, null);
        }
        
        public Builder contentUrl(final String s) {
            if (s == null) {
                return this;
            }
            this.mHints.put(HintType.CONTENT_URL, s);
            return this;
        }
        
        public Builder extraData(final String s) {
            if (s == null) {
                return this;
            }
            this.mHints.put(HintType.EXTRA_DATA, s);
            return this;
        }
        
        @Deprecated
        public Builder keywords(final List<Keyword> list) {
            return this;
        }
        
        public Builder mediationData(final String mMediationData) {
            if (TextUtils.isEmpty((CharSequence)mMediationData)) {
                return this;
            }
            this.mMediationData = mMediationData;
            return this;
        }
    }
    
    public enum HintType
    {
        private static final HintType[] $VALUES;
        
        CONTENT_URL("content_url"), 
        EXTRA_DATA("extra_data"), 
        @Deprecated
        KEYWORDS("keywords");
        
        private String mKey;
        
        private HintType(final String mKey) {
            this.mKey = mKey;
        }
        
        static String access$000(final HintType hintType) {
            return hintType.mKey;
        }
    }
    
    @Deprecated
    @Keep
    public enum Keyword
    {
        private static final Keyword[] $VALUES;
        
        ACCESSORIES("accessories"), 
        ART_HISTORY("art_history"), 
        AUTOMOTIVE("automotive"), 
        BEAUTY("beauty"), 
        BIOLOGY("biology"), 
        BOARD_GAMES("board_games"), 
        BUSINESS_SOFTWARE("business_software"), 
        BUYING_SELLING_HOMES("buying_selling_homes"), 
        CATS("cats"), 
        CELEBRITIES("celebrities"), 
        CLOTHING("clothing"), 
        COMIC_BOOKS("comic_books"), 
        DESKTOP_VIDEO("desktop_video"), 
        DOGS("dogs"), 
        EDUCATION("education"), 
        EMAIL("email"), 
        ENTERTAINMENT("entertainment"), 
        FAMILY_PARENTING("family_parenting"), 
        FASHION("fashion"), 
        FINE_ART("fine_art"), 
        FOOD_DRINK("food_drink"), 
        FRENCH_CUISINE("french_cuisine"), 
        GOVERNMENT("government"), 
        HEALTH_FITNESS("health_fitness"), 
        HOBBIES("hobbies"), 
        HOME_GARDEN("home_garden"), 
        HUMOR("humor"), 
        INTERNET_TECHNOLOGY("internet_technology"), 
        LARGE_ANIMALS("large_animals"), 
        LAW("law"), 
        LEGAL_ISSUES("legal_issues"), 
        LITERATURE("literature"), 
        MARKETING("marketing"), 
        MOVIES("movies"), 
        MUSIC("music"), 
        NEWS("news"), 
        PERSONAL_FINANCE("personal_finance"), 
        PETS("pets"), 
        PHOTOGRAPHY("photography"), 
        POLITICS("politics"), 
        REAL_ESTATE("real_estate"), 
        ROLEPLAYING_GAMES("roleplaying_games"), 
        SCIENCE("science"), 
        SHOPPING("shopping"), 
        SOCIETY("society"), 
        SPORTS("sports"), 
        TECHNOLOGY("technology"), 
        TELEVISION("television"), 
        TRAVEL("travel"), 
        VIDEO_COMPUTER_GAMES("video_computer_games");
        
        private String mKeyword;
        
        private Keyword(final String mKeyword) {
            this.mKeyword = mKeyword;
        }
    }
}
