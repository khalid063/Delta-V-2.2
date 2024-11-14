import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    //http://103.250.68.75/api/v1/account/login/
    //private const val BASE_URL = "https://yourapi.com/"  // Replace with your API URL
    private const val BASE_URL = "http://103.250.68.75/api/v1/"  // Replace with your API URL

    val instance: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}
