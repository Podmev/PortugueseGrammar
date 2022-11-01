package com.podmev.portuguese.utils.structure.suffixtree

interface SuffixTree<T> : Map<String, T> {
    fun findLongestSuffix(word: String): String?
}

interface MutableSuffixTree<T> : MutableMap<String, T>, SuffixTree<T> {
}

class DefaultSuffixTree<T>() : MutableSuffixTree<T> {
    val root = Node<T>(ROOT_CHAR, HashMap(), null)

    private fun getNodeByKey(key: String): Node<T>? {
        var curNode = root
        var curIndex = key.length - 1
        while (true) {
            if (curIndex == -1) {
                return curNode
            }
            val curChar = key[curIndex]
            curNode = curNode.children[curChar] ?: return null
            curIndex--
        }
    }

    override val entries: MutableSet<MutableMap.MutableEntry<String, T>>
        get() = TODO("Not yet implemented")
    override val keys: MutableSet<String>
        get() = TODO("Not yet implemented")
    override val size: Int
        get() = TODO("Not yet implemented")
    override val values: MutableCollection<T>
        get() = TODO("Not yet implemented")

    override fun clear() = root.children.clear()

    override fun containsKey(key: String): Boolean = getNodeByKey(key)?.data != null

    override fun get(key: String): T? = getNodeByKey(key)?.data?.value

    override fun isEmpty(): Boolean = root.children.isEmpty()

    override fun remove(key: String): T? {
        TODO("Not yet implemented")
    }

    override fun putAll(from: Map<out String, T>) {
        //NOT OPTIMIZED
        for((key, value) in from){
            put(key, value)
        }
    }

    override fun put(key: String, value: T): T? {
        TODO("Not yet implemented")
    }

    override fun containsValue(value: T): Boolean {
        //NOT OPTIMIZED
        return values.contains(value)
    }

    override fun findLongestSuffix(word: String): String? {
        TODO("Not yet implemented")
    }

    inner class Node<T>(
        val letter: Char,
        val children: MutableMap<Char, Node<T>>,
        val data: NodeData<T>?
    ) {
//        fun hasData(): Boolean = data!=null
    }

    inner class NodeData<T>(val word: String, val value: T) {

    }

    companion object {
        const val ROOT_CHAR = '$'
    }

}



