package eg.gov.iti.jets.task

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel : ViewModel(){
    lateinit var recyclerListData: MutableLiveData<RecyclerList>
    lateinit var recyclerViewAdapter : RecyclerViewAdapter

    init {
        recyclerListData = MutableLiveData()
        recyclerViewAdapter = RecyclerViewAdapter()
    }

    fun getAdapter():  RecyclerViewAdapter{
        return recyclerViewAdapter
    }

    fun setAdapterData(data: ArrayList<RecyclerData>) {
        recyclerViewAdapter.setDataList(data)
        recyclerViewAdapter.notifyDataSetChanged()
    }

    fun getRecyclerListDataObserver(): MutableLiveData<RecyclerList> {
        return recyclerListData
    }

    fun makeAPICall(input1 : String, input2 : String, input3 : String, input4 : String) {
        val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
        val call = retroInstance.getDataFromAPI(input1, input2, input3, input4)
        call.enqueue(object : Callback<RecyclerList>{
            override fun onFailure(call: Call<RecyclerList>, t: Throwable) {
                recyclerListData.postValue(null)
            }

            override fun onResponse(call: Call<RecyclerList>, response: Response<RecyclerList>) {
                if(response.isSuccessful){
                    recyclerListData.postValue(response.body())
                } else {
                    recyclerListData.postValue(null)
                }
            }
        })
    }
}