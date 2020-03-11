package ru.spitchenko.githubapp.feature.github.data

import com.google.android.gms.auth.api.signin.GoogleSignInClient
import kotlinx.coroutines.tasks.await
import ru.spitchenko.githubapp.feature.auth.domain.LoginRepository
import ru.spitchenko.githubapp.feature.github.domain.LogoutRepository
import javax.inject.Inject

class LogoutRepositoryImpl @Inject constructor(
    private val repositoriesDao: RepositoriesDao,
    private val loginRepository: LoginRepository,
    private val googleSignInClient: GoogleSignInClient
) : LogoutRepository {

    override suspend fun logout() {
        googleSignInClient.signOut().await()
        repositoriesDao.deleteAll()
        loginRepository.logout()
    }
}