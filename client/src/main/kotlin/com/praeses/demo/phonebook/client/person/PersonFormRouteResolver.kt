package com.praeses.demo.phonebook.client.person

import com.praeses.demo.phonebook.client.layout.Layout
import com.wallace.glen.js.mithril.RouteResolver
import com.wallace.glen.js.mithril.VNode
import com.wallace.glen.js.mithril.m

/**
 * Created by Glen on 5/2/2017.
 */
class PersonFormRouteResolver (private val layout: Layout) : RouteResolver {
    private val personFormView = PersonFormView()

    override val onmatch: (dynamic, requestedPath: String) -> dynamic
        get() = this::onMatchFunction
    override val render: (vnode: VNode) -> Array<VNode>
        get() = this::renderFunction

    private fun onMatchFunction(args: dynamic, requestedPath: String) {}

    private fun renderFunction(vnode: VNode) = arrayOf(m(layout, children = m(personFormView, vnode.attrs)))
}