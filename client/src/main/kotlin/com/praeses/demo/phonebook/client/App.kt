package com.praeses.demo.phonebook.client

import com.praeses.demo.phonebook.client.person.PersonListView
import com.wallace.glen.js.mithril.Mithril
import com.wallace.glen.js.toAssociativeArray
import kotlin.browser.document

/**
 * Created by Glen on 5/1/2017.
 */
fun main(args: Array<String>) {
    val root = document.body!!

    val personListView = PersonListView()
    val routes = mapOf("/list" to personListView).toAssociativeArray()

    Mithril.route(root, "/list", routes)
}
