func missingNumber(nums []int) int {
    n := len(nums)
    s := 0
    for _, n := range nums {
        s += n
    }
    return n * (n + 1) / 2 - s
}