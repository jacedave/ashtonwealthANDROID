package com.ashtonwealth.app.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ashtonwealth.app.EventsItem
import java.util.*

class DashboardViewModel : ViewModel() {

    val eventsListItem: List<EventsItem> = listOf(EventsItem(name = "Shred Event", date = Date(2022,4,21), location = "Ashton and Associates Office", description = "Bring all of your old documents that need shredding, we will have the shred truck come in, and Hook'd on Bowls as the food truck."),
                                    EventsItem(name = "Pickleball Event", date = Date(2022,5,12), location = "Little Valley Pickleball Courts", description = "Bring your best pickleball game! We will have a tournament, as well as a clinic for beginers and a section to just have fun. Come out and have a great time with us!"))

}