package com.praeses.demo.phonebook.client.person

import com.praeses.demo.phonebook.shared.person.Person
import com.wallace.glen.js.mithril.Mithril
import com.wallace.glen.js.mithril.request.RequestOptions
import kotlin.js.Promise

/**
 * Created by Glen on 5/1/2017.
 */
object Persons {
    var list: Array<Person> = arrayOf()

    var current: Person? = null

    fun loadList() : Promise<*> {
        fun onFulfilled(result: Any?) {
            var innerResult = result
            if(innerResult is Array<*>) {
                list = innerResult as Array<Person>
            } else {
                throw RuntimeException("Expected result to be an Array of Persons, received: $result.")
            }
        }
        return Mithril.request(url = "http://localhost:8080/api/v0/person/list").then(onFulfilled = ::onFulfilled)
    }

    fun load(id: String): Promise<*> {
        val data = object {val id: String = id}

        fun onFulfilled(result: dynamic) {
            current = result
        }

        val options = RequestOptions(
                url = "http://localhost:8080/api/v0/person/:id",
                data = data
        )

        return Mithril.request(options = options).then(onFulfilled = ::onFulfilled)
    }

    fun save(): Promise<*> {
        val options = RequestOptions(
                method = RequestOptions.POST,
                url = "http://localhost:8080/api/v0/person/save",
                data = current
        )

        return Mithril.request(options = options)
    }
}