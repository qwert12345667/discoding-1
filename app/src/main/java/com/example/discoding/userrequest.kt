import io.reactivex.Observable
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface UserRequest {

    @GET("/bot/bot")
    fun getuserinfo():
            Observable<String>

    @FormUrlEncoded
    @POST("/posttest")
    fun postTest(@Field("value") param: String):
            Observable<String>

    companion object {
        var gson = GsonBuilder()
            .setLenient()
            .create()

        fun create(): UserRequest {

            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create() )
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("https://5949-117-111-17-205.ngrok.io/")
                .build()

            return retrofit.create(UserRequest::class.java)
        }
    }


}