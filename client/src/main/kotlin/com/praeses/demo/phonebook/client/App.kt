package com.praeses.demo.phonebook.client

import com.praeses.demo.phonebook.client.layout.Layout
import com.praeses.demo.phonebook.client.person.PersonFormRouteResolver
import com.praeses.demo.phonebook.client.person.PersonListRouteResolver
import com.wallace.glen.js.mithril.Mithril
import com.wallace.glen.js.toAssociativeArray
import kotlin.browser.document

/**
 * Created by Glen on 5/1/2017.
 */
fun main(args: Array<String>) {
    val root = document.body!!
    val layout = Layout()

    val personListRouteResolver = PersonListRouteResolver(layout)
    val personFormRouteResolver = PersonFormRouteResolver(layout)

    val routeResolver: dynamic = mapOf(
            "/list" to personListRouteResolver,
            "/edit/:id" to personFormRouteResolver
    ).toAssociativeArray()



    Mithril.route(root, "/list", routeResolver)
}
