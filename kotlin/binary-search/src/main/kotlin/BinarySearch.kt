object BinarySearch {
    fun search(list: List<Int>, item: Int): Int {
        val sortedList = list.sorted()
        var left = 0
        var right = sortedList.size - 1
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (sortedList[mid] == item) {
                return mid
            } else if (sortedList[mid] < item) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        throw NoSuchElementException("No such element")
    }
}
