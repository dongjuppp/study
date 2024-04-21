package org.example.structure

class MyNode<T> {
    private val value: T
    private var next: MyNode<T>? = null

    constructor(value: T) {
        this.value = value
    }

    fun link(value: T) {
        next = MyNode(value)
    }

    fun link(newNode: MyNode<T>) {
        next = newNode
    }

    fun getValue(): T {
        return value
    }

    fun getNext(): MyNode<T>? {
        return next
    }
}