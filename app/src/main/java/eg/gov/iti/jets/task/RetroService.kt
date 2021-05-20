package eg.gov.iti.jets.task

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {
    //GITHUB API URL: https://api.github.com/search/repositories?q=created:>2017-10-22&sort=stars&order=desc&page=1
    @GET("repositories")
    fun getDataFromAPI(
            @Query("q")query1 : String,
            @Query("sort")query2 : String,
            @Query("order")query3 : String,
            @Query("page")query4 : String
    ):Call<RecyclerList>
}