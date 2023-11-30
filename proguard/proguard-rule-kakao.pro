
# 2023.11.09
# 카카오 SDK
# ref: https://developers.kakao.com/docs/latest/ko/android/getting-started#project-pro-guard

-keep class com.kakao.sdk.**.model.* { <fields>; }
-keep class * extends com.google.gson.TypeAdapter

# https://github.com/square/okhttp/pull/6792
-dontwarn org.bouncycastle.jsse.**
-dontwarn org.conscrypt.*
-dontwarn org.openjsse.**