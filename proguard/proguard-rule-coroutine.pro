# Coroutine
# 2023.11.09
# offical web site : https://github.com/Kotlin/kotlinx.coroutines/tree/master/ui/kotlinx-coroutines-android

# Files in this directory will be ignored starting with Android Gradle Plugin 3.6.0+

# When editing this file, update the following files as well for AGP 3.6.0+:
# - META-INF/com.android.tools/proguard/coroutines.pro
# - META-INF/com.android.tools/r8-upto-3.0.0/coroutines.pro

-keep class kotlinx.coroutines.android.AndroidDispatcherFactory {*;}
-keep class kotlinx.coroutines.android.AndroidExceptionPreHandler {*;}


## Coroutine
## ServiceLoader support
#-keepnames class kotlinx.coroutines.internal.MainDispatcherFactory {}
#-keepnames class kotlinx.coroutines.CoroutineExceptionHandler {}
## Most of volatile fields are updated with AFU and should not be mangled
#-keepclassmembernames class kotlinx.** {
#    volatile <fields>;
#}