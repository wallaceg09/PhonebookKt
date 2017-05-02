package com.praeses.demo.phonebook.client.layout

import com.wallace.glen.js.mithril.Component
import com.wallace.glen.js.mithril.Mithril
import com.wallace.glen.js.mithril.VNode
import com.wallace.glen.js.mithril.m

/**
 * Created by Glen on 5/2/2017.
 */
class Layout : Component {
    override val view: (VNode) -> Any
        get() = this::getMainView

    private fun getMainView(vnode: VNode) : VNode {
        return m("main.layout", arrayOf(
                navMenu,
                m("section", vnode.children)
        ))
    }

    private val navMenu = m("nav.menu", arrayOf(
            m("a[href='/list'", object {val oncreate = Mithril.route::link}, "People")
    ))
}