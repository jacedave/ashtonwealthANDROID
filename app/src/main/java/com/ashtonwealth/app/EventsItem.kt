package com.ashtonwealth.app

import java.util.*

data class EventsItem(val id: UUID = UUID.randomUUID(),
                      var name: String = "",
                      var date: Date = Date(),
                      var description: String = "",
                      var location: String = "")
