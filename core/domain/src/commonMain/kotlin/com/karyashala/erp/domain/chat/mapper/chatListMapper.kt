package com.karyashala.erp.domain.chat.mapper


import androidx.compose.ui.graphics.Color
import com.karyashala.erp.components.extractInitials
import com.karyashala.erp.domain.chat.model.EmployChatItem
import com.karyashala.model.chat.list.EmptyListItemResponseDto
import kotlin.random.Random

fun EmptyListItemResponseDto.toChatItem(): EmployChatItem {
    return EmployChatItem(
        employeeId = employeeId ?: 0L,
        chatId = chatId ?: "",
        branchName = branchName ?: "",
        employeeName = employeeName ?: "",
        profileImageUrl = profileImageUrl?.let { "https://karyashalaerp.com/erp-images/$it" },
        lastMessage = lastMessage ?: "",
        lastMessageSendUser = lastMessageSendUser ?: "",
        hasUnReadMessage = hasUnReadMessage ?: "",
        sortOrder = sortOrder ?: 0,
        nameInitials = employeeName.extractInitials(),
        backgroundColor = randomLightColor(),
        phoneNumber = phoneNumber,
        isOnline = false
    )
}


private fun randomLightColor(): Color {
    val rnd = Random.Default
    // Ensure values are closer to 255 (light colors)
    val r = 150 + rnd.nextInt(106) // 150–255
    val g = 150 + rnd.nextInt(106)
    val b = 150 + rnd.nextInt(106)
    return Color(r, g, b)
}


