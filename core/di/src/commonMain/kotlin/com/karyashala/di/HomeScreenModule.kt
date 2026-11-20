package com.karyashala.di

import com.karyashala.erp.data.attendance.KtorAttendanceRemoteRepository
import com.karyashala.erp.data.notification.KtorNotificationRemoteRepository
import com.karyashala.erp.data.support.KtorSupportListRepository
import com.karyashala.erp.data.upComingBirthday.KtorUpComingBirthdayRemoteRepository
import com.karyashala.erp.data.upComingEvent.KtorEventRemoteRepository
import com.karyashala.erp.data.upComingWorkAnniversary.KtorUpComingWorkAnniversaryRemoteRepository
import com.karyashala.erp.data.userDetail.KtorUserDetailRemoteRepository
import com.karyashala.erp.datastore.user_data.local.UserDataDataStore
import com.karyashala.erp.datastore.user_data.repository.LocalUserDataRepository
import com.karyashala.erp.datastore.user_data.repository.UserDataRepository
import com.karyashala.erp.date.data.model.CalendarModel
import com.karyashala.erp.date.data.model.CalendarModelImpl
import com.karyashala.erp.domain.attendance.attendanceCountReport.useCase.AttendanceCountReportUseCase
import com.karyashala.erp.domain.attendance.attendanceReport.repository.AttendanceRemoteRepository
import com.karyashala.erp.domain.attendance.attendanceReport.usecase.AttendanceUseCase
import com.karyashala.erp.domain.attendance.doAttendance.useCase.DoAttendanceUseCase
import com.karyashala.erp.domain.notification.notificationCount.useCase.NotificationCountUseCase
import com.karyashala.erp.domain.notification.notificationData.repository.NotificationRemoteRepository
import com.karyashala.erp.domain.notification.notificationData.useCase.NotificationUseCase
import com.karyashala.erp.domain.notification.unSeenNotificationCount.useCase.UnseenNotificationUseCase
import com.karyashala.erp.domain.support.repository.SupportListRemoteRepository
import com.karyashala.erp.domain.support.useCase.SupportListFetchUseCase
import com.karyashala.erp.domain.upComingBirthday.repository.UpComingBirthdayRemoteRepository
import com.karyashala.erp.domain.upComingBirthday.usecase.UpComingBirthdayUseCase
import com.karyashala.erp.domain.upComingEvent.repository.EventRemoteRepository
import com.karyashala.erp.domain.upComingEvent.useCase.EventUseCase
import com.karyashala.erp.domain.upComingWorkAnniversaries.repository.UpComingWorkAnniversaryRemoteRepository
import com.karyashala.erp.domain.upComingWorkAnniversaries.useCase.UpComingWorkAnniversaryUseCase
import com.karyashala.erp.domain.uploadImage.UploadImageUseCase
import com.karyashala.erp.domain.userDetail.repository.UserDetailRemoteRepository
import com.karyashala.erp.domain.userDetail.usecase.FetchUserDetailUseCase
import com.karyashala.erp.home.HomeScreenViewModel
import com.karyashala.erp.notification.NotificationViewModel
import com.karyashala.erp.viewAllScreen.ViewAllScreenViewModel
import io.ktor.client.HttpClient
import org.koin.android.annotation.KoinViewModel
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module

@Module
class HomeScreenModule {
    @Factory(binds = [AttendanceRemoteRepository::class])
    fun attendanceRepository(httpClient: HttpClient) = KtorAttendanceRemoteRepository(httpClient)

    @Factory(binds = [SupportListRemoteRepository::class])
    fun supportListRemoteRepository(httpClient: HttpClient)= KtorSupportListRepository(httpClient = httpClient)

    @Factory(binds = [EventRemoteRepository::class])
    fun eventRemoteRepository(httpClient: HttpClient) = KtorEventRemoteRepository(httpClient)

    @Factory(binds = [CalendarModel::class])
    fun getCalendarModel() = CalendarModelImpl()

    @Factory(binds = [UserDetailRemoteRepository::class])
    fun userDetailRemoteRepository(httpClient: HttpClient) =
        KtorUserDetailRemoteRepository(httpClient)

    @Factory(binds = [UpComingBirthdayRemoteRepository::class])
    fun upComingBirthdayRemoteRepository(httpClient: HttpClient) =
        KtorUpComingBirthdayRemoteRepository(httpClient)

    @Factory(binds = [UpComingWorkAnniversaryRemoteRepository::class])
    fun upComingWorkAnniversaryRemoteRepository(httpClient: HttpClient) =
        KtorUpComingWorkAnniversaryRemoteRepository(httpClient)

    @Factory(binds = [NotificationRemoteRepository::class])
    fun notificationRemoteRepository(httpClient: HttpClient) =
        KtorNotificationRemoteRepository(httpClient)


    @Factory
    fun notificationUseCase(
        notificationRemoteRepository: NotificationRemoteRepository,
    ): NotificationUseCase = NotificationUseCase(
        notificationRemoteRepository = notificationRemoteRepository,
    )

    @Factory
    fun supportListFetchUseCase(
        supportListRemoteRepository: SupportListRemoteRepository
    ): SupportListFetchUseCase = SupportListFetchUseCase(
        supportListRemoteRepository = supportListRemoteRepository
    )



    @Factory
    fun notificationCountUseCase(
        notificationRemoteRepository: NotificationRemoteRepository,
    ): NotificationCountUseCase = NotificationCountUseCase(
        notificationRemoteRepository = notificationRemoteRepository,
    )

    @Factory
    fun unSeenNotificationCountUseCase(
        notificationRemoteRepository: NotificationRemoteRepository
    ): UnseenNotificationUseCase = UnseenNotificationUseCase(
        notificationRemoteRepository = notificationRemoteRepository
    )

    @Factory
    fun attendanceCountReportUseCase(
        attendanceRemoteRepository: AttendanceRemoteRepository,
        userDataRepository: UserDataRepository
    ): AttendanceCountReportUseCase =
        AttendanceCountReportUseCase(
            attendanceRemoteRepository = attendanceRemoteRepository,
            userDataRepository = userDataRepository
        )


    @Factory(binds = [UserDataRepository::class])
    fun userDataRepository(
        userDataDataStore: UserDataDataStore
    ): UserDataRepository =
        LocalUserDataRepository(
            userDataDataStore = userDataDataStore
        )


    @Factory
    fun attendanceUseCase(
        attendanceRemoteRepository: AttendanceRemoteRepository,
        userDataRepository: UserDataRepository
    ): AttendanceUseCase =
        AttendanceUseCase(
            attendanceRemoteRepository = attendanceRemoteRepository,
            userDataRepository = userDataRepository
        )

    @Factory
    fun eventUseCase(eventRemoteRepository: EventRemoteRepository): EventUseCase =
        EventUseCase(eventRemoteRepository = eventRemoteRepository)

    @Factory
    fun fetchUserDetailUseCase(
        userDetailRemoteRepository: UserDetailRemoteRepository,
        userDataRepository: UserDataRepository
    ): FetchUserDetailUseCase =
        FetchUserDetailUseCase(
            userDetailRemoteRepository, userDataRepository = userDataRepository
        )

    @Factory
    fun upComingBirthdayUseCase(upComingBirthdayRemoteRepository: UpComingBirthdayRemoteRepository): UpComingBirthdayUseCase =
        UpComingBirthdayUseCase(upComingBirthdayRemoteRepository)

    @Factory
    fun upComingWorkAnniversaryUseCase(upComingWorkAnniversaryRemoteRepository: UpComingWorkAnniversaryRemoteRepository): UpComingWorkAnniversaryUseCase =
        UpComingWorkAnniversaryUseCase(upComingWorkAnniversaryRemoteRepository)

    @Factory
    fun doAttendanceUseCase(
        attendanceRemoteRepository: AttendanceRemoteRepository,
        userDataRepository: UserDataRepository
    ): DoAttendanceUseCase = DoAttendanceUseCase(
        attendanceRemoteRepository = attendanceRemoteRepository,
        userDataRepository = userDataRepository
    )

    @Factory

    @KoinViewModel
    fun getHomeScreenViewModel(
        attendanceUseCase: AttendanceUseCase,
        userDetailUseCase: FetchUserDetailUseCase,
        upComingBirthdayUseCase: UpComingBirthdayUseCase,
        upComingWorkAnniversaryUseCase: UpComingWorkAnniversaryUseCase,
        calendarModel: CalendarModel,
        eventUseCase: EventUseCase,
        unseenNotificationUseCase: UnseenNotificationUseCase,
        uploadImageUseCase: UploadImageUseCase,
        doAttendanceUseCase: DoAttendanceUseCase,
        attendanceCountReportUseCase: AttendanceCountReportUseCase,
    ): HomeScreenViewModel = HomeScreenViewModel(
        attendanceUseCase = attendanceUseCase,
        userDetailUseCase = userDetailUseCase,
        upComingBirthdayUseCase = upComingBirthdayUseCase,
        upComingWorkAnniversaryUseCase = upComingWorkAnniversaryUseCase,
        calendarModel = calendarModel,
        eventUseCase = eventUseCase,
        unseenNotificationUseCase = unseenNotificationUseCase,
        uploadImageUseCase = uploadImageUseCase,
        doAttendanceUseCase = doAttendanceUseCase,
        attendanceCountReportUseCase = attendanceCountReportUseCase,
    )

    @KoinViewModel
    fun getViewAllViewModel(): ViewAllScreenViewModel = ViewAllScreenViewModel()

    @KoinViewModel
    fun getNotificationViewModel(
        notificationUseCase: NotificationUseCase,
        notificationCountUseCase: NotificationCountUseCase,
    ): NotificationViewModel = NotificationViewModel(
        notificationUseCase = notificationUseCase,
        notificationCountUseCase = notificationCountUseCase
    )
}


