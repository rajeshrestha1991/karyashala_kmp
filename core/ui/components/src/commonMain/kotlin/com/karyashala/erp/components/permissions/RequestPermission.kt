package com.karyashala.erp.components.permissions

import androidx.compose.runtime.Composable

@Composable
expect fun rememberRequestPermission(
    permissions: List<String>,
    onGranted: (String) -> Unit = {},
    onDenied: (String) -> Unit = {},
    onPermanentlyDenied: (String) -> Unit = {},
    onAllGranted: () -> Unit = {}
): () -> Unit