# android Log
# 2023.11.09
# offical web site :
# 앱 로그 코드 삭제

# ================== Log 메시지 제거 ==================
-assumenosideeffects class android.util.Log {
  public static *** v(...);
  public static *** d(...);
  public static *** i(...);
  public static *** w(...);
  public static *** e(...);
}
# ========================================================================