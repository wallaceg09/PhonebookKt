package com.praeses.demo.phonebook.client.person

import com.wallace.glen.js.mithril.Component
import com.wallace.glen.js.mithril.Mithril
import com.wallace.glen.js.mithril.VNode
import com.wallace.glen.js.mithril.lifetime.Initable
import com.wallace.glen.js.mithril.m
import org.w3c.dom.events.Event

/**
 * Created by Glen on 5/2/2017.
 */
class PersonFormView : Component, Initable {
    override val oninit: Function<*> = fun(vnode: VNode) {
        val id = vnode.attrs.id

        if(id is String) {
            Persons.load(id)
        } else {
            throw IllegalArgumentException("Expected id to be a String.")
        }
    }

    override val view: (VNode) -> Any
        get() = this::getMainView

    class Attribute(val oninput: Function<*>, val value: dynamic)
    class SubmitAttr(val onsubmit: (Event) -> dynamic)

    private fun getMainView(vnode: VNode) : Any {
        val formAttrs = SubmitAttr(fun(e: Event) {
            e.preventDefault()
                Persons.save()
        })

        val button = m("button.button[type=submit]", children = "Save")

        return m("form", attrs = formAttrs, children = arrayOf(
                firstNameDiv, lastNameDiv, addressDiv, phoneDiv, button
        ))
    }

    private val firstNameDiv: VNode
        get() {
            fun firstNameOnInput(value: Any) {
                Persons.current?.firstName = value as String
            }

            val attrs = Attribute(Mithril.withAttr("value", ::firstNameOnInput), Persons.current?.firstName)

            val label = m("label.label", children = "First Name")
            val input = m("input.input[type=text][placeholder=First Name]", attrs = attrs)

            return m("div#first-name-div", children = arrayOf(label, input))
        }

    private val lastNameDiv: VNode
        get() {
            fun lastNameOnInput(value: Any) {
                Persons.current?.lastName = value as String
            }

            val attrs = Attribute(Mithril.withAttr("value", ::lastNameOnInput), Persons.current?.lastName)

            val label = m("label.label", children = "Last Name")
            val input = m("input.input[type=text][placeholder=Last Name]", attrs = attrs)

            return m("div#last-name-div", children = arrayOf(label, input))
        }

    private val addressDiv: VNode
        get() {
            fun addressOnInput(value: Any) {
                Persons.current?.address = value as String
            }

            val attrs = Attribute(Mithril.withAttr("value", ::addressOnInput), Persons.current?.address)

            val label = m("label.label", children = "Address")
            val input = m("input.input[type=text][placeholder=Address]", attrs = attrs)

            return m("div#address-div", children = arrayOf(label, input))
        }

    private val phoneDiv: VNode
        get() {
            fun phoneOnInput(value: Any) {
                Persons.current?.phone = value as String
            }

            val attrs = Attribute(Mithril.withAttr("value", ::phoneOnInput), Persons.current?.phone)

            val label = m("label.label", children = "Phone")
            val input = m("input.input[type=text][placeholder=Phone]", attrs = attrs)

            return m("div#address-div", children = arrayOf(label, input))
        }
}