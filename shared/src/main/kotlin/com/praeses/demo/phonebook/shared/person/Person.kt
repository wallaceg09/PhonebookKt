package com.praeses.demo.phonebook.shared.person

/**
 * Created by Glen on 5/1/2017.
 */
class Person (
    var id: Int = Int.MIN_VALUE,

    var firstName: String = "",
    var lastName: String = "",

    var address: String = "",
    var phone: String = ""
)