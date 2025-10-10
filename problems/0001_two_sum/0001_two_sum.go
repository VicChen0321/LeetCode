func twoSum(nums []int, target int) []int {
    m := make(map[int]int)
    for i, num := range nums {
        if idx, found := m[target - num]; found {
            return []int{idx, i}
        }
        m[num] = i
    }
    return []int{}
}