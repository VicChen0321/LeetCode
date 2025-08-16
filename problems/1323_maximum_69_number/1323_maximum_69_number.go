func maximum69Number (num int) int {
    numStr := strconv.Itoa(num)
    numStr = strings.Replace(numStr, "6", "9", 1)
    result, _ := strconv.Atoi(numStr)
    return result
}