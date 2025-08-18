const EPS = 1e-6
func judgePoint24(cards []int) bool {
    var nums []float64
    for _, n := range cards {
        nums = append(nums, float64(n))
    }
    return dfs(nums)
}

func dfs(nums []float64) bool {
    if len(nums) == 1 {
        return math.Abs(float64(nums[0]) - 24) <= EPS
    }

    for i := 0; i < len(nums); i++ {
        for j := i + 1; j < len(nums); j++ {
            var nextNums []float64
            for k := 0; k < len(nums); k++ {
                if k != i && k != j {
                    nextNums = append(nextNums, nums[k])
                }
            }
            for _, res := range compute(nums[i], nums[j]) {
                nextNums = append(nextNums, res)
                if dfs(nextNums) {
                    return true
                }
                nextNums = nextNums[:len(nextNums) - 1]
            }
        }
    }
    return false
}

func compute(a float64, b float64) []float64 {
    res := []float64{
        a - b,
        b - a,
        a + b,
        a * b,
    }
    if a != 0 {
        res = append(res, b / a)
    }
    if b != 0 {
        res = append(res, a / b)
    }
    return res
}