package laba7

import laba5.TPNumber

interface Plus<T> {
    operator fun plus(other: T): T
}

class TMemory<T> where T : Plus<T>, T : Any{
    var number : T = Any() as T
    var state : State
    constructor() {
        clear()
        this.state = State.Off
    }
    fun Write(number : T)
    {
        this.number = number
        state = State.On
        assert(state == State.On)
    }
    fun get() : T {
        return number
        assert(state == State.On)
    }
    fun Add(number : T) {
        this.number += number
        assert(state == State.On)
    }
    fun clear() {
        number = Any() as T
    }
    fun getState() : String = state.toString()
    fun readNumber() : T =  number


    enum class State()
    {
        On,
        Off
    }
}