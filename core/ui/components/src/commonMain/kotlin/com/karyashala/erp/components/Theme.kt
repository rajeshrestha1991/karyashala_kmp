package com.karyashala.erp.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.staticCompositionLocalOf
import com.karyashala.erp.components.locale.LocalAppLocale
import com.karyashala.erp.components.locale.erpAppLocale
import com.karyashala.erp.res.theme.AppTypography
import com.karyashala.erp.res.theme.CompactDimens
import com.karyashala.erp.res.theme.ERPColorPalette
import com.karyashala.erp.res.theme.ThemeMode
import com.karyashala.erp.res.theme.backgroundDark
import com.karyashala.erp.res.theme.backgroundLight
import com.karyashala.erp.res.theme.darkERPPalette
import com.karyashala.erp.res.theme.errorContainerDark
import com.karyashala.erp.res.theme.errorContainerLight
import com.karyashala.erp.res.theme.errorDark
import com.karyashala.erp.res.theme.errorLight
import com.karyashala.erp.res.theme.inverseOnSurfaceDark
import com.karyashala.erp.res.theme.inverseOnSurfaceLight
import com.karyashala.erp.res.theme.inversePrimaryDark
import com.karyashala.erp.res.theme.inversePrimaryLight
import com.karyashala.erp.res.theme.inverseSurfaceDark
import com.karyashala.erp.res.theme.inverseSurfaceLight
import com.karyashala.erp.res.theme.lightERPPalette
import com.karyashala.erp.res.theme.onBackgroundDark
import com.karyashala.erp.res.theme.onBackgroundLight
import com.karyashala.erp.res.theme.onErrorContainerDark
import com.karyashala.erp.res.theme.onErrorContainerLight
import com.karyashala.erp.res.theme.onErrorDark
import com.karyashala.erp.res.theme.onErrorLight
import com.karyashala.erp.res.theme.onPrimaryContainerDark
import com.karyashala.erp.res.theme.onPrimaryContainerLight
import com.karyashala.erp.res.theme.onPrimaryDark
import com.karyashala.erp.res.theme.onPrimaryLight
import com.karyashala.erp.res.theme.onSecondaryContainerDark
import com.karyashala.erp.res.theme.onSecondaryContainerLight
import com.karyashala.erp.res.theme.onSecondaryDark
import com.karyashala.erp.res.theme.onSecondaryLight
import com.karyashala.erp.res.theme.onSurfaceDark
import com.karyashala.erp.res.theme.onSurfaceLight
import com.karyashala.erp.res.theme.onSurfaceVariantDark
import com.karyashala.erp.res.theme.onSurfaceVariantLight
import com.karyashala.erp.res.theme.onTertiaryContainerDark
import com.karyashala.erp.res.theme.onTertiaryContainerLight
import com.karyashala.erp.res.theme.onTertiaryDark
import com.karyashala.erp.res.theme.onTertiaryLight
import com.karyashala.erp.res.theme.outlineDark
import com.karyashala.erp.res.theme.outlineLight
import com.karyashala.erp.res.theme.outlineVariantDark
import com.karyashala.erp.res.theme.outlineVariantLight
import com.karyashala.erp.res.theme.primaryContainerDark
import com.karyashala.erp.res.theme.primaryContainerLight
import com.karyashala.erp.res.theme.primaryDark
import com.karyashala.erp.res.theme.primaryLight
import com.karyashala.erp.res.theme.scrimDark
import com.karyashala.erp.res.theme.scrimLight
import com.karyashala.erp.res.theme.secondaryContainerDark
import com.karyashala.erp.res.theme.secondaryContainerLight
import com.karyashala.erp.res.theme.secondaryDark
import com.karyashala.erp.res.theme.secondaryLight
import com.karyashala.erp.res.theme.surfaceBrightDark
import com.karyashala.erp.res.theme.surfaceBrightLight
import com.karyashala.erp.res.theme.surfaceContainerDark
import com.karyashala.erp.res.theme.surfaceContainerHighDark
import com.karyashala.erp.res.theme.surfaceContainerHighLight
import com.karyashala.erp.res.theme.surfaceContainerHighestDark
import com.karyashala.erp.res.theme.surfaceContainerHighestLight
import com.karyashala.erp.res.theme.surfaceContainerLight
import com.karyashala.erp.res.theme.surfaceContainerLowDark
import com.karyashala.erp.res.theme.surfaceContainerLowLight
import com.karyashala.erp.res.theme.surfaceContainerLowestDark
import com.karyashala.erp.res.theme.surfaceContainerLowestLight
import com.karyashala.erp.res.theme.surfaceDark
import com.karyashala.erp.res.theme.surfaceDimDark
import com.karyashala.erp.res.theme.surfaceDimLight
import com.karyashala.erp.res.theme.surfaceLight
import com.karyashala.erp.res.theme.surfaceVariantDark
import com.karyashala.erp.res.theme.surfaceVariantLight
import com.karyashala.erp.res.theme.tertiaryContainerDark
import com.karyashala.erp.res.theme.tertiaryContainerLight
import com.karyashala.erp.res.theme.tertiaryDark
import com.karyashala.erp.res.theme.tertiaryLight


private val lightScheme = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    tertiaryContainer = tertiaryContainerLight,
    onTertiaryContainer = onTertiaryContainerLight,
    error = errorLight,
    onError = onErrorLight,
    errorContainer = errorContainerLight,
    onErrorContainer = onErrorContainerLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    surfaceVariant = surfaceVariantLight,
    onSurfaceVariant = onSurfaceVariantLight,
    outline = outlineLight,
    outlineVariant = outlineVariantLight,
    scrim = scrimLight,
    inverseSurface = inverseSurfaceLight,
    inverseOnSurface = inverseOnSurfaceLight,
    inversePrimary = inversePrimaryLight,
    surfaceDim = surfaceDimLight,
    surfaceBright = surfaceBrightLight,
    surfaceContainerLowest = surfaceContainerLowestLight,
    surfaceContainerLow = surfaceContainerLowLight,
    surfaceContainer = surfaceContainerLight,
    surfaceContainerHigh = surfaceContainerHighLight,
    surfaceContainerHighest = surfaceContainerHighestLight,
)

private val darkScheme = darkColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    secondaryContainer = secondaryContainerDark,
    onSecondaryContainer = onSecondaryContainerDark,
    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,
    tertiaryContainer = tertiaryContainerDark,
    onTertiaryContainer = onTertiaryContainerDark,
    error = errorDark,
    onError = onErrorDark,
    errorContainer = errorContainerDark,
    onErrorContainer = onErrorContainerDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark,
    surfaceVariant = surfaceVariantDark,
    onSurfaceVariant = onSurfaceVariantDark,
    outline = outlineDark,
    outlineVariant = outlineVariantDark,
    scrim = scrimDark,
    inverseSurface = inverseSurfaceDark,
    inverseOnSurface = inverseOnSurfaceDark,
    inversePrimary = inversePrimaryDark,
    surfaceDim = surfaceDimDark,
    surfaceBright = surfaceBrightDark,
    surfaceContainerLowest = surfaceContainerLowestDark,
    surfaceContainerLow = surfaceContainerLowDark,
    surfaceContainer = surfaceContainerDark,
    surfaceContainerHigh = surfaceContainerHighDark,
    surfaceContainerHighest = surfaceContainerHighestDark,

    )

@Composable
fun AppTheme(
    selectedThemeMode: ThemeMode = ThemeMode.SYSTEM,
    content: @Composable() () -> Unit
) {
    val systemInDarkTheme = isSystemInDarkTheme()

    val darkTheme = when (selectedThemeMode) {
        ThemeMode.LIGHT -> false
        ThemeMode.DARK -> true
        ThemeMode.SYSTEM -> systemInDarkTheme
    }

    val colorScheme = if (darkTheme) darkScheme else lightScheme
    val erpColorsPalette = if (darkTheme) darkERPPalette else lightERPPalette

    ChangeStatusBarColor(
        darkIcons = !darkTheme
    )

    CompositionLocalProvider(
        LocalAppDimens provides CompactDimens,
        LocalERPColorsPalette provides erpColorsPalette,
        LocalAppLocale provides erpAppLocale,
    ) {

        MaterialTheme(
            colorScheme = colorScheme,
            typography = AppTypography,
            content = content
        )
    }
}

val LocalERPColorsPalette = staticCompositionLocalOf { ERPColorPalette() }
val MaterialTheme.dimens
    @Composable get() = LocalAppDimens.current

val LocalAppDimens = compositionLocalOf {
    CompactDimens
}


val MaterialTheme.erpColors
    @Composable get() = LocalERPColorsPalette.current