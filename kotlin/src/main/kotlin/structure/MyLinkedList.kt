package org.example.structure

import java.util.LinkedList

class MyLinkedList<T> {
    private var head: MyNode<T>? = null
    private var tail: MyNode<T>? = null
    private var size: Int = 0

    fun add(value: T) {
        if(head == null && tail == null) {
            head = MyNode(value)
            tail = head
        } else {
            val newNode = MyNode(value)
            tail!!.link(newNode)
            tail = newNode
        }
        size ++
    }

    fun get(index: Int): T? {
        return getNodeAt(index)?.getValue()
    }

    private fun getNodeAt(index: Int): MyNode<T>? {
        var result: MyNode<T>? = head
        for(i in 0 until index) {
            result = result?.getNext()
        }
        return result
    }

    fun size(): Int {
         return this.size
    }

    fun removeAt(index: Int) {
        if(index == 0) {
            head = head?.getNext()
            if(head == null) size = 0
        } else {
            val target = getNodeAt(index)
            val prev = target?.getPrev()
            val next= target?.getNext()
            prev?.link(next)
            if(prev != null) size --
        }
    }

    fun sort() {
        //TODO 정렬 기능
    }
}