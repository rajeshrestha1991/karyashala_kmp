@file:OptIn(ExperimentalTime::class)

package com.karyashala.erp.data.userDetail

import com.karyashala.erp.domain.userDetail.repository.UserDetailRemoteRepository
import com.karyashala.erp.networkhelper.BaseUrl
import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.erp.networkhelper.EndPoint
import com.karyashala.erp.networkhelper.get
import com.karyashala.erp.networkhelper.post
import com.karyashala.erp.networkhelper.safeCall
import com.karyashala.model.network.DataError
import com.karyashala.model.userDetail.UpdateProfileResponseDto
import com.karyashala.model.userDetail.UpdateRequestUserDto
import com.karyashala.model.userDetail.UserDetailResponseDto
import io.ktor.client.HttpClient
import io.ktor.client.request.setBody
import kotlin.time.ExperimentalTime

class KtorUserDetailRemoteRepository(
    val httpClient: HttpClient
) : UserDetailRemoteRepository {
    override suspend fun fetchUserDetail(): ERPResult<UserDetailResponseDto, DataError> {
        return safeCall {
            httpClient.get(
                baseUrl = BaseUrl.Generic,
                endPoint = EndPoint.CURRENT_USER_DETAIL_END_POINT
            )
        }
    }

    override suspend fun userDataUpdate(data: UpdateRequestUserDto): ERPResult<UpdateProfileResponseDto, DataError> {
        return safeCall {
            httpClient.post(
                baseUrl = BaseUrl.Generic,
                endPoint = EndPoint.EDIT_USER_DETAILS_ENDPOINT + "/${data.id}"
            ) {
                setBody(
                    UpdateRequestUserDto(
                        bloodGroup = data.bloodGroup,
                        guardianName = data.guardianName,
                        guardianNumber = data.guardianNumber,
                        joinedDate = data.joinedDate,
                        panNumber = data.panNumber,
                        pfNumber = data.pfNumber,
                        startDate = data.startDate,
                        id = data.id
                    )
                )

            }
        }
    }
}