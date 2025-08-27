# Array 常用模板

### Reverse array

```python
def reverse_array(nums):
    left, right = 0, len(nums) - 1
    while left < right:
        nums[left], nums[right] = nums[right], nums[left]
        left += 1
        right -= 1
    return nums
```

### Prefix sum

```python
def prefix_sum(nums):
    pre_sum = [0]
    for num in nums:
        pre_sum.append(pre_sum[-1] + num)
    return pre_sum
```