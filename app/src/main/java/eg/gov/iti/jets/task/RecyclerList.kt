package eg.gov.iti.jets.task

data class RecyclerList (val items: ArrayList<RecyclerData>)
data class RecyclerData(val name: String, val description: String, val watchers: String, val owner: Owner)
data class Owner(val login: String, val avatar_url: String)