package com.podmev.portuguese.utils.structure.suffixTreeMap

import com.podmev.portuguese.utils.lang.paired

class DefaultSuffixTreeMap<T>() : MutableSuffixTreeMap<T> {
    private val root = createEmptyNode(ROOT_CHAR, 0)

    override val entries: MutableSet<MutableMap.MutableEntry<String, T>>
        get() = entriesByNode(root)

    override val keys: MutableSet<String>
        get() = keysByNode(root)

    override val size: Int
        get() = countSizeByNode(root)

    override val values: MutableCollection<T>
        get() = valuesByNode(root)

    override fun clear() = root.children.clear()

    override fun containsKey(key: String): Boolean = getNodeByKey(key)?.data != null

    override fun get(key: String): T? = getNodeByKey(key)?.data?.value

    override fun isEmpty(): Boolean = root.children.isEmpty()

    override fun remove(key: String): T? {
        //finding path from root till exact node with key
        val nodePath: List<Node<T>> = getNodePathByKey(key) ?: return null
        val exactNode = nodePath.last()

        //removing data
        val oldValue = exactNode.data!!.value
        exactNode.data = null // removing data

        //cleaning empty nodes if needed
        if (exactNode.children.isEmpty()) {
            //no children - so we need to remove all empty node since current till one with data, going to root
            removeEmptyNodesFromTheEnd(nodePath)
        }
        //other case: cannot remove this node, only content

        //always has value to return when we found path
        return oldValue
    }

    override fun putAll(from: Map<out String, T>) {
        //NOT OPTIMIZED
        for ((key, value) in from) {
            put(key, value)
        }
    }

    override fun put(key: String, value: T): T? {
        val nodeData = NodeData(key, value)
        val closestNode = getMaxCloseNodeByKey(key)
        if (closestNode.level == key.length) {
            //exact node, but maybe it is empty
            val oldData = closestNode.data?.value
            closestNode.data = nodeData
            return oldData
        }
        //not exact node - so we create missing nodes
        val emptyExactNode = createEmptyNodes(closestNode, key.dropLast(closestNode.level))
        emptyExactNode.data = nodeData
        return null
    }

    override fun containsValue(value: T): Boolean {
        //NOT OPTIMIZED
        return values.contains(value)
    }

    override fun findLongestSuffix(word: String): String? {
        val closestNode: Node<T> = getMaxCloseNonEmptyNodeByKey(word) ?: return null
        val level = closestNode.level
        return word.drop(word.length - level)
    }

    //-------details----------

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

    /*from root to leaf
    * return
    * */
    private fun removeEmptyNodesFromTheEnd(nodePath: List<Node<T>>): Int {
        var count = 1
        for ((node, prevNode) in nodePath.reversed().paired()) {
            if (prevNode.hasData() || prevNode == root) {
                //found node with data - we need to remove child
                prevNode.children.remove(node.letter)
                return count
            }
            count++
        }
        throw Exception("Unreachable code")
    }

    private fun getNodePathByKey(key: String): List<Node<T>>? {
        var curNode = root
        var curIndex = key.length - 1
        val nodeList = ArrayList<Node<T>>()
        while (true) {
            nodeList.add(curNode)
            if (curIndex == -1) {
                return nodeList
            }
            val curChar = key[curIndex]
            curNode = curNode.children[curChar] ?: return null
            curIndex--
        }
    }

    private fun getMaxCloseNodeByKey(key: String): Node<T> {
        var curNode = root
        var curIndex = key.length - 1
        while (true) {
            if (curIndex == -1) {
                return curNode
            }
            val curChar = key[curIndex]
            curNode = curNode.children[curChar] ?: return curNode
            curIndex--
        }
    }

    private fun getMaxCloseNonEmptyNodeByKey(key: String): Node<T>? {
        var curNode: Node<T> = root
        var curNonEmptyNode: Node<T>? = null
        var curIndex = key.length - 1
        while (true) {
            if (curIndex == -1) {
                return curNonEmptyNode
            }
            val curChar = key[curIndex]
            curNode = curNode.children[curChar] ?: return curNonEmptyNode
            if (curNode.hasData()) {
                curNonEmptyNode = curNode
            }
            curIndex--
        }
    }

    //TODO rewrite in for-style
    private fun createEmptyNodes(node: Node<T>, wordPrefix: String): Node<T> {
        if (wordPrefix.isEmpty()) {
            return node
        }
        val lastChar = wordPrefix.last()
        val prefixWithoutLastChar = wordPrefix.dropLast(1)
        val nextNode = createEmptyNode(lastChar, node.level + 1)
        node.children[lastChar] = nextNode
        return createEmptyNodes(nextNode, prefixWithoutLastChar)
    }

    private fun countSizeByNode(node: Node<T>): Int {
        var count = 0
        for (child in node.children) count += countSizeByNode(child.value)
        if (node.hasData()) count++
        return count
    }

    private fun valuesByNode(node: Node<T>): MutableCollection<T> {
        val valuesList = mutableListOf<T>()
        for (child in node.children) valuesList.addAll(valuesByNode(child.value))
        val curValue = node.data?.value
        if (curValue != null) valuesList.add(curValue)
        return valuesList
    }

    private fun keysByNode(node: Node<T>): MutableSet<String> {
        val keysSet = mutableSetOf<String>()
        for (child in node.children) keysSet.addAll(keysByNode(child.value))
        val curKey = node.data?.word
        if (curKey != null) keysSet.add(curKey)
        return keysSet
    }

    private fun entriesByNode(node: Node<T>): MutableSet<MutableMap.MutableEntry<String, T>> {
        val entrySet = mutableSetOf<MutableMap.MutableEntry<String, T>>()
        for (child in node.children) entrySet.addAll(entriesByNode(child.value))
        val curData = node.data
        if (curData != null) entrySet.add(curData)
        return entrySet
    }

    private fun createEmptyNode(letter: Char, level: Int) = Node<T>(letter, level, HashMap(), null)

    inner class Node<T>(
        val letter: Char,
        val level: Int,
        val children: MutableMap<Char, Node<T>>,
        var data: NodeData<T>?
    ) {
        fun hasData(): Boolean = data != null
    }

    class NodeData<T>(val word: String, override var value: T) : MutableMap.MutableEntry<String, T> {
        override val key: String = word

        override fun setValue(newValue: T): T {
            val oldValue = value
            value = newValue
            return oldValue
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as NodeData<*>

            if (word != other.word) return false
            if (value != other.value) return false
            if (key != other.key) return false

            return true
        }

        override fun hashCode(): Int {
            var result = word.hashCode()
            result = 31 * result + (value?.hashCode() ?: 0)
            result = 31 * result + key.hashCode()
            return result
        }

        override fun toString(): String {
            return "NodeData(word='$word', value=$value, key='$key')"
        }

    }

    companion object {
        const val ROOT_CHAR = '$'
    }

}