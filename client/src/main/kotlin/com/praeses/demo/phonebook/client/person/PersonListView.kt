package com.praeses.demo.phonebook.client.person

import com.praeses.demo.phonebook.shared.person.Person
import com.wallace.glen.js.mithril.Component
import com.wallace.glen.js.mithril.VNode
import com.wallace.glen.js.mithril.lifetime.Initable
import com.wallace.glen.js.mithril.m

/**
 * Created by Glen on 5/1/2017.
 */
class PersonListView : Component, Initable {
    override val view: (VNode) -> Any
        get() = this::getMainView

    private fun getMainView(vNode: VNode) = m(".person-list", children = Persons.list.map(this::personListItem).toTypedArray())

    private fun personListItem(person: Person) : VNode {
        return m(".person-list-item", children = "${person.firstName} ${person.lastName}")
    }

    override val oninit: Function<*> = Persons::loadList
}