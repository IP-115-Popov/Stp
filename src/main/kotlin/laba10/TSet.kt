package laba10

class TSet <T>{
    var value : MutableSet<T>

    constructor() { value = mutableSetOf<T>() }

    private constructor(value : Set<T>) {
        this.value = value.toMutableSet()
    }

    fun Empty() {
        value.clear()
        require(value.isEmpty())
    }

    fun Add(v : T) {
        value.add(v)
        require(v in value)
    }

    fun Remove(v : T) {
        value.remove(v)
        require(v !in value)
    }

    fun isEmpty() : Boolean = value.isEmpty()

    fun Belongs(v : T) : Boolean = v in value

    fun Join(v: TSet<T>): TSet<T> = TSet(value + v.value)

    fun Subtract(v: TSet<T>): TSet<T> = TSet(value - v.value)

    fun Multiply(v: TSet<T>): TSet<T> = TSet(value .union(v.value))

    fun size() : Int = value.size

    fun Element(i: Int) : T = value.toList().get(i)
}