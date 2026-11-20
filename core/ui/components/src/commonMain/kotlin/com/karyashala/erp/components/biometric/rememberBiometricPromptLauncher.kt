package com.karyashala.erp.components.biometric

import androidx.compose.runtime.Composable
import com.karyashala.model.biometric.BiometricAuthResult
import com.karyashala.model.biometric.BiometricPromptLauncher

@Composable
expect fun rememberBiometricPromptLauncher(
    onResult: (BiometricAuthResult) -> Unit
): BiometricPromptLauncher