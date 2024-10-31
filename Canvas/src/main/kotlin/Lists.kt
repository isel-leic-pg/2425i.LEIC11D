fun main() {
    val nums: List<Int> = listOf(3, 7, 12)
    println(nums)                       // -> [3, 7, 12]
    println(listOf("abc","isel","pg"))  // -> [abc, isel, pg]
    println(nums + 27)                  // -> [3, 7, 12, 27]
    println(nums + listOf(5,12) + (4..7)) // -> [3, 7, 12, 5, 12, 4, 5, 6, 7]
    //for(i in nums.indices) println(nums[i])
    for(n in nums) println(n)           // -> 3 -> 7 -> 12
    println(nums - 7)                   // -> [3, 12]
    println(9 in nums)                  // -> false
    nums.forEach { println(it) }        // -> 3 -> 7 -> 12
    println(nums.filter{ it<10 })       // -> [3, 7]
    val l = nums.map{ it < 10 }
    println(l)                          // -> [true, true, false]
    println(nums.map{ it + 10 })        // -> [13, 17, 22]
}