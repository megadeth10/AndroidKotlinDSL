# Google Play Services
# 2023.11.09
# offical web site : https://developers.google.com/android?hl=ko
# 해당 규칙은 어디서 온지 알수 없음.

# Google Play Services SDK 또한 필요한 클래스가 사라지는 것을 방지하기 위한 ProGuard 규칙을 제공하고 있다.
-keep class * extends java.util.ListResourceBundle {
    protected Object[][] getContents();
}

-keep public class com.google.android.gms.common.internal.safeparcel.SafeParcelable {
    public static final *** NULL;
}

-keepnames @com.google.android.gms.common.annotation.KeepName class *
-keepclassmembernames class * {
    @com.google.android.gms.common.annotation.KeepName *;
}

-keepnames class * implements android.os.Parcelable {
    public static final ** CREATOR;
}

# Google Play Services SDK 또한 필요한 클래스가 사라지는 것을 방지하기 위한 ProGuard 규칙을 제공하고 있다.
-dontwarn com.appsflyer.**, com.google.android.**, okio.**, org.apache.**, retrofit2.**, com.polites.android.VectorF, com.polites.android.MathUtils