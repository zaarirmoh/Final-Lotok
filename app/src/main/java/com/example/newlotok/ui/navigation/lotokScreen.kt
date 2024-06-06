package com.example.newlotok.ui.navigation

enum class LotokScreen(
    val hasNavigationBar: Boolean,
    //val topBarType: Int = 0
) {
    WelcomeScreen(false),
    HomeScreen(true),//R.string.TopBarMenuLogoNotification
    SelectACarScreen(false),//R.string.TopBarGoBackTextProfile
    SelectBrandScreen(false),
    ProfileScreen(true),
    MainSettingsScreen(false),
    ProfileDetailsScreen(false),
    EditProfileScreen(false),
    SignInScreen(false),
    SignUpScreen(false),
    CarDetailsScreen(false),
    ForgotPasswordScreen(false),
    OtpVerificationScreen(false),
    BookingScreen(false),
    OrderDetailsScreen(false),
    AddPostScreen(false),
    UserPostsScreen(false),
}