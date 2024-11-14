import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

data class LoginRequest(val username: String, val password: String)
data class LoginResponse(val token: String)

//interface ApiService {
//    @POST("auth/login")  // Update this path as per your API
//    fun login(@Body request: LoginRequest): Call<LoginResponse>
//}

interface ApiService {
    @POST("account/login/")  // Update this path as per your API
    fun login(@Body request: LoginRequest): Call<LoginResponse>
}

