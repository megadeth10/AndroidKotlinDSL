# kakao 지도
# 2023.11.09
# ref : https://apis.map.kakao.com/android_v2/docs/getting-started/quickstart/

-keep class com.kakao.vectormap.** { *; }
-keep interface com.kakao.vectormap.**

# ==================================================
# 과거에 사용하던 규칙인데 전부 카카오 지도 인지는 모름

## Kakao 에서 가이드 한 proguard (compileSdkVersion 21) 필요
##-keep class com.kakao.** { *; }
##-keepclassmembers class com.kakao.* {
##    public static <fields>;
##    public *;
##}

## kakao map
#-ignorewarnings

#-keepattributes Annotation

#-dontwarn android.support.v4.**,org.slf4j.**,com.google.android.gms.**
# ==================================================
