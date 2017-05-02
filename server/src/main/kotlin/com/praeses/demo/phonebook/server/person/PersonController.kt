package com.praeses.demo.phonebook.server.person

import com.praeses.demo.phonebook.shared.person.Person
import org.springframework.web.bind.annotation.*

/**
 * Created by Glen on 5/1/2017.
 */
@RestController
@RequestMapping(value = "api/v0/person")
class PersonController {
    private var nextId = 0
    private val db: MutableMap<Int, Person> = mutableMapOf()

    @RequestMapping(value = "/list", method = arrayOf(RequestMethod.GET))
    fun list() = db.values

    @RequestMapping(value = "/{id}", method = arrayOf(RequestMethod.GET))
    fun get(@PathVariable id: Int) = db[id]

    @RequestMapping(value = "/save", method = arrayOf(RequestMethod.POST))
    fun save(@RequestBody person: Person): Boolean {
        db[person.id] = person
        return true
    }

    @RequestMapping(value = "/{id}", method = arrayOf(RequestMethod.DELETE))
    fun delete(@RequestParam id: Int) : Boolean {
        db.remove(id)
        return true
    }
}