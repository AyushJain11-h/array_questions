# 🏦 Best Time to Buy and Sell Stock

## Problem Description
You are given an array `prices` where `prices[i]` represents the price of a given stock on the `i-th` day.  

You want to maximize your **profit** by choosing a **single day to buy** and a **different day in the future to sell**.  

Return the **maximum profit** you can achieve. If you cannot achieve any profit, return `0`.

---

### Example
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6 - 1 = 5


---

### Thought Process

1. **Understand the problem**:  
   - Buy **once** and sell **once**.  
   - Buy day must be **before** sell day.  

2. **Brute-force approach**:  
   - Check all pairs `(i, j)` with `i < j`.  
   - Calculate `profit = prices[j] - prices[i]`.  
   - Keep track of **maximum profit**.  
   - Time Complexity: `O(n^2)` → inefficient for large arrays.  

3. **Optimized approach**:  
   - Track **minimum price so far**.  
   - For each day, compute `profit = currentPrice - minPriceSoFar`.  
   - Update **maximum profit** if higher.  
   - Time Complexity: `O(n)` | Space Complexity: `O(1)`  

---

### Pseudo-code
function maxProfit(prices):
minPrice = infinity
maxProfit = 0
for price in prices:
    if price < minPrice:
        minPrice = price
    else:
        profit = price - minPrice
        if profit > maxProfit:
            maxProfit = profit

return maxProfit




# 🔎 Contains Duplicate

## **Problem Description**
You are given an integer array `nums`. Determine **if the array contains any duplicates**.  

- Return **`true`** if **any value appears at least twice** in the array.  
- Return **`false`** if **every element is distinct**.

---

### **Example**
Input: nums = [1,2,3,1]
Output: true
Explanation: The number 1 appears twice


---

### **Thought Process**

1. **Understand the problem**  
   - Need to detect **any duplicate** in an array.  
   - We don’t care which number, just whether there is a duplicate.  

2. **Brute-force approach**  
   - Compare every element with all others.  
   - **Time Complexity:** `O(n²)` → inefficient for large arrays.  

3. **Optimized approaches**  

   **Approach 1: Sorting**
   - Sort the array.  
   - Check if **any adjacent elements are equal**.  
   - **Time Complexity:** `O(n log n)`  
   - **Space Complexity:** `O(1)`  

   **Approach 2: Hash Set**
   - Traverse the array and add elements to a **HashSet**.  
   - If an element is already in the set → duplicate found → return **`true`**.  
   - **Time Complexity:** `O(n)`  
   - **Space Complexity:** `O(n)`  

---




# 🔎 Find Duplicate Number

## **Problem Description**
You are given an array `nums` containing **n + 1 integers** where each integer is in the **range `[1, n]` inclusive**.  

There is **exactly one repeated number**, which could appear multiple times.  

Your task is to **find the duplicate number** **without modifying the array** and, if possible, using **constant extra space**.

---

### **Examples**
Input: nums = [1,3,4,2,2]
Output: 2


---

### **Thought Process**

1. **Understand the problem**  
   - Array has **n + 1 numbers** in the range `[1, n]`.  
   - There is **exactly one duplicate**, which can appear multiple times.  
   - Goal: Find the duplicate **without changing the array** and ideally in **O(1) space**.  

2. **Brute-force approach**  
   - Compare every pair `(i, j)` → check if `nums[i] == nums[j]`.  
   - **Time Complexity:** `O(n²)` → inefficient for large arrays.  

3. **Better approach (HashSet)**  
   - Traverse the array and store numbers in a **HashSet**.  
   - If a number already exists in the set → it’s the duplicate.  
   - **Time Complexity:** `O(n)`  
   - **Space Complexity:** `O(n)`  

4. **Optimal approach (Floyd’s Tortoise and Hare / Cycle Detection)**  
   - Treat the array as a **linked list** where `nums[i]` points to `nums[nums[i]]`.  
   - Detect a **cycle** → the duplicate number is the **entry point of the cycle**.  
   - **Time Complexity:** `O(n)`  
   - **Space Complexity:** `O(1)`  

---


# ⛰️ Find Peak Element

## **Problem Description**
A **peak element** in an array `nums` is an element that is **strictly greater than its neighbors**.  

Given an integer array `nums`, find **any peak element** and return its **index**.  

- You may imagine that `nums[-1] = nums[n] = -∞` (negative infinity).  
- The array may contain **multiple peaks**; returning **any one** of them is valid.  

---

### **Examples**
Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element at index 2.


---

### **Thought Process**

1. **Understand the problem**  
   - A peak element is **greater than its neighbors**.  
   - You can return **any peak** if there are multiple peaks.  
   - Edge elements are considered peaks if they are greater than their one neighbor.  

2. **Brute-force approach**  
   - Iterate through the array and check for each element if it is **greater than its neighbors**.  
   - Return the **first peak found**.  
   - **Time Complexity:** `O(n)`  

3. **Optimized approach (Binary Search)**  
   - Use **binary search** to find a peak in **O(log n)** time.  
   - If `nums[mid] < nums[mid + 1]`, the peak must be on the **right side**.  
   - Otherwise, the peak is on the **left side** or at `mid`.  
   - Continue narrowing the search until a peak is found.  

---



# 📝 Group Anagrams

## **Problem Description**
Given an array of strings `strs`, **group the anagrams together**.  

- An **anagram** is a word formed by rearranging the letters of another word, using all the original letters exactly once.  
- You can return the answer in **any order**.  

---

### **Examples**
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]


---

### **Thought Process**

1. **Understand the problem**  
   - Words are anagrams if they have the **same letters with the same frequency**.  
   - Group all words that are anagrams together.  

2. **Brute-force approach**  
   - Compare every pair of strings to see if they are anagrams.  
   - **Time Complexity:** `O(n² * k log k)` where `k` is the max string length → inefficient.  

3. **Optimized approach (HashMap)**  
   - **Sort each string** alphabetically → anagrams will have the **same sorted string**.  
   - Use a **HashMap** where the key is the sorted string and the value is a **list of words** that match it.  
   - **Time Complexity:** `O(n * k log k)` → sorting each string  
   - **Space Complexity:** `O(n * k)` → storing groups in HashMap  

4. **Alternative approach (Character Count as Key)**  
   - Count occurrences of each character in the string.  
   - Use the count as a **unique key** in the HashMap to group anagrams.  
   - Avoids sorting → **O(n * k)** time.  

---



# 🔗 Longest Consecutive Sequence

## **Problem Description**
Given an unsorted integer array `nums`, find the length of the **longest consecutive elements sequence**.  

- The sequence must be **consecutive numbers** (in increasing order).  
- **Return the length** of this sequence.  
- **You must write an algorithm that runs in O(n) time.**

---

### **Examples**
Input: nums = [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive sequence is [1, 2, 3, 4]. Length = 4


---

### **Thought Process**

1. **Understand the problem**  
   - Need the **longest sequence of consecutive numbers** in an unsorted array.  
   - Must find it in **O(n) time**, so sorting is **not allowed**.  

2. **Brute-force approach**  
   - Sort the array and find consecutive numbers.  
   - **Time Complexity:** `O(n log n)` → not optimal.  

3. **Optimized approach (HashSet)**  
   - Insert all numbers into a **HashSet** for **O(1) lookups**.  
   - For each number, check if it is the **start of a sequence** (`num - 1` not in set).  
   - Count consecutive numbers starting from that number.  
   - Keep track of the **maximum length**.  
   - **Time Complexity:** `O(n)`  
   - **Space Complexity:** `O(n)`  

---



# 📈 Longest Increasing Subsequence

## **Problem Description**
Given an integer array `nums`, return the **length of the longest strictly increasing subsequence**.  

- A **subsequence** is a sequence that can be derived from an array by **deleting some or no elements without changing the order** of the remaining elements.  
- Your goal is to find the **length** of the **longest increasing subsequence (LIS)**.  

---

### **Examples**
Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101].


---

### **Thought Process**

1. **Understand the problem**  
   - We are looking for the **longest strictly increasing subsequence**.  
   - Elements in the subsequence do **not need to be contiguous**, only the order must be preserved.  

2. **Brute-force approach**  
   - Generate all subsequences and find the longest increasing one.  
   - **Time Complexity:** `O(2^n)` → not feasible for large arrays.  

3. **Dynamic Programming (DP) approach**  
   - Create a `dp` array where **`dp[i]` = length of LIS ending at index i**.  
   - For each `i`, check all previous indices `j < i`:  
     - If `nums[j] < nums[i]`, update `dp[i] = max(dp[i], dp[j] + 1)`.  
   - The **maximum value in dp** is the length of the LIS.  
   - **Time Complexity:** `O(n²)`  
   - **Space Complexity:** `O(n)`  

4. **Optimized approach (DP + Binary Search)**  
   - Maintain a list `sub` which stores the **current smallest possible tail of LIS of each length**.  
   - For each number in `nums`:  
     - If it is **larger than all tails**, append it.  
     - Otherwise, **replace the first tail ≥ number** with it using binary search.  
   - Length of `sub` at the end = length of LIS.  
   - **Time Complexity:** `O(n log n)`  
   - **Space Complexity:** `O(n)`  

---



# 🔑 Longest Substring Without Repeating Characters

## **Problem Description**
Given a string `s`, find the **length of the longest substring without repeating characters**.  

- A **substring** is a contiguous sequence of characters within a string.  
- Your goal is to **return the length** of the **longest substring** where **no character repeats**.  

---

### **Examples**
Input: s = "abcabcbb"
Output: 3
Explanation: The longest substring without repeating characters is "abc".


---

### **Thought Process**

1. **Understand the problem**  
   - Find the **longest contiguous substring** with **all unique characters**.  
   - Substrings are **contiguous**, unlike subsequences.  

2. **Brute-force approach**  
   - Generate all possible substrings and check if all characters are unique.  
   - Keep track of the **maximum length**.  
   - **Time Complexity:** `O(n³)` → inefficient.  

3. **Optimized approach (Sliding Window + HashSet)**  
   - Use **two pointers** (`left` and `right`) to represent a window of characters.  
   - Use a **HashSet** to track characters in the current window.  
   - Move `right` forward, adding characters to the set.  
   - If a character is repeated, move `left` forward until all characters in the window are unique.  
   - Update **maximum length** during the process.  
   - **Time Complexity:** `O(n)`  
   - **Space Complexity:** `O(min(n, a))` → `a` = alphabet size  

4. **Optimized approach (Sliding Window + HashMap)**  
   - Use a **HashMap** to store the **last index** of each character.  
   - Move `left` pointer directly to **index after the last occurrence** of a repeated character.  
   - **Time Complexity:** `O(n)`  
   - **Space Complexity:** `O(min(n, a))`  

---



# 🔢 Maximum Product Subarray

## **Problem Description**
Given an integer array `nums`, find a contiguous **subarray (containing at least one number)** which has the **largest product**, and **return the product**.  

- A **subarray** is a contiguous part of the array.  
- The array can contain **negative numbers**, which makes this problem tricky because the product of two negative numbers is positive.  

---

### **Examples**
Input: nums = [2,3,-2,4]
Output: 6
Explanation: The subarray [2,3] has the largest product 6.


---

### **Thought Process**

1. **Understand the problem**  
   - Need the **maximum product of a contiguous subarray**.  
   - Negative numbers can **flip the sign** of the product.  
   - Zero **resets the product**.  

2. **Brute-force approach**  
   - Check all possible subarrays and compute their product.  
   - Keep track of the **maximum product**.  
   - **Time Complexity:** `O(n²)` → inefficient for large arrays.  

3. **Optimized approach (Dynamic Programming / Sliding Window)**  
   - Maintain **two variables** while iterating:  
     - `maxProd` → maximum product ending at current index  
     - `minProd` → minimum product ending at current index (**because negative × negative may become max**)  
   - For each number `num`:  
     - `tempMax = max(num, maxProd * num, minProd * num)`  
     - `minProd = min(num, maxProd * num, minProd * num)`  
     - `maxProd = tempMax`  
   - Keep track of **global maximum product**.  
   - **Time Complexity:** `O(n)`  
   - **Space Complexity:** `O(1)`  

---



# 📊 Maximum Subarray

## **Problem Description**
Given an integer array `nums`, find the **contiguous subarray (containing at least one number)** which has the **largest sum**, and **return its sum**.  

- A **subarray** is a contiguous part of the array.  
- The array may contain **negative numbers**, which makes the problem slightly tricky.  

---

### **Examples**
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6


---

### **Thought Process**

1. **Understand the problem**  
   - Find the **contiguous subarray** with the **largest sum**.  
   - Must handle **negative numbers**, which can decrease the sum.  

2. **Brute-force approach**  
   - Check all possible subarrays and calculate their sums.  
   - Keep track of the **maximum sum**.  
   - **Time Complexity:** `O(n²)` → inefficient for large arrays.  

3. **Optimized approach (Kadane's Algorithm)**  
   - Maintain a **current sum** and a **global maximum sum**.  
   - Iterate through the array:  
     - `currentSum = max(num, currentSum + num)` → either start a new subarray at `num` or extend the previous subarray.  
     - `maxSum = max(maxSum, currentSum)` → update the global maximum.  
   - **Time Complexity:** `O(n)`  
   - **Space Complexity:** `O(1)`  

---




# 🏢 Meeting Rooms II

## **Problem Description**
Given an array of meeting time intervals `intervals` where `intervals[i] = [starti, endi]`, **find the minimum number of conference rooms required**.  

- Each meeting has a **start time** and an **end time**.  
- Multiple meetings **cannot overlap** in the same room.  
- You need to determine the **minimum number of rooms** required to schedule all meetings.  

---

### **Examples**
Input: intervals = [[0,30],[5,10],[15,20]]
Output: 2
Explanation: One room can hold [0,30], another holds [5,10]. [15,20] can reuse the second room.


---

### **Thought Process**

1. **Understand the problem**  
   - We need the **minimum number of meeting rooms** to schedule all meetings.  
   - Key point: **overlapping meetings require separate rooms**.  

2. **Brute-force approach**  
   - Compare every pair of meetings to detect overlaps.  
   - Count rooms needed at each step.  
   - **Time Complexity:** `O(n²)` → inefficient for large inputs.  

3. **Optimized approach (Sorting + Min-Heap / Priority Queue)**  
   - **Sort intervals by start time**.  
   - Use a **min-heap** to keep track of meeting **end times** in rooms.  
   - Iterate through sorted meetings:  
     - If the **earliest ending meeting ends before current meeting starts**, reuse that room → pop from heap.  
     - Otherwise, allocate a new room → push current meeting's end time into heap.  
   - The **size of the heap** at any time = **number of rooms needed**.  
   - **Time Complexity:** `O(n log n)` → sorting + heap operations  
   - **Space Complexity:** `O(n)` → heap stores end times  

4. **Alternative approach (Two Pointers)**  
   - Separate **start times** and **end times** arrays, sort both.  
   - Use two pointers to iterate through starts and ends:  
     - Increment room count if `start[i] < end[j]` → new room needed  
     - Else, move end pointer → room freed  
   - **Time Complexity:** `O(n log n)`  
   - **Space Complexity:** `O(n)`  

---




# 🧩 Minimum Window Substring

## **Problem Description**
Given two strings `s` and `t`, return the **minimum window substring** of `s` such that every character in `t` **(including duplicates)** is included in the window.  

- If there is no such substring, return an empty string `""`.  
- If there are multiple valid answers, **return any one**.  

---

### **Examples**
Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: "BANC" is the smallest substring containing 'A', 'B', and 'C'.


---

### **Thought Process**

1. **Understand the problem**  
   - Find the **smallest contiguous substring** of `s` containing all characters of `t`.  
   - Must account for **duplicate characters** in `t`.  

2. **Brute-force approach**  
   - Generate all substrings of `s` and check if they contain all characters of `t`.  
   - Keep track of the **smallest valid substring**.  
   - **Time Complexity:** `O(n³)` → very inefficient.  

3. **Optimized approach (Sliding Window + HashMap)**  
   - Use two **pointers** (`left` and `right`) to maintain a **window**.  
   - Use a **HashMap `need`** to track the **required character counts** in `t`.  
   - Use a **HashMap `window`** to track the **current counts** of characters in the window.  
   - Expand the `right` pointer until the window contains all required characters.  
   - Shrink the `left` pointer to **minimize the window**, updating the answer when valid.  
   - **Time Complexity:** `O(n)` → each character visited at most twice  
   - **Space Complexity:** `O(1)` → max 128 for ASCII characters  

---




# 🔢 Move Zeros

## **Problem Description**
Given an integer array `nums`, **move all 0’s to the end** of it while **maintaining the relative order of the non-zero elements**.  

- You must do this **in-place** without making a copy of the array.  
- Minimize the total number of operations.  

---

### **Examples**
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]


---

### **Thought Process**

1. **Understand the problem**  
   - Need to **move all zeros** to the end.  
   - Maintain the **order of non-zero elements**.  
   - Must be done **in-place** with minimal operations.  

2. **Brute-force approach**  
   - Create a new array, copy all non-zero elements, then fill the rest with zeros.  
   - **Time Complexity:** `O(n)`  
   - **Space Complexity:** `O(n)` → not in-place  

3. **Optimized approach (Two Pointers / Slow-Fast)**  
   - Use a **pointer `lastNonZeroFoundAt`** to track the position of the last non-zero element.  
   - Iterate through the array:  
     - If the current element is **non-zero**, swap it with the element at `lastNonZeroFoundAt` and increment `lastNonZeroFoundAt`.  
   - This effectively **shifts all non-zero elements forward** and zeros are automatically moved to the end.  
   - **Time Complexity:** `O(n)` → each element visited once  
   - **Space Complexity:** `O(1)` → in-place  

---




# 🔍 Next Greater Element

## **Problem Description**
Given an array of integers `nums`, the **Next Greater Element** for an element `x` is the **first element to the right of `x` that is greater than `x`**.  

- You are asked to **find the Next Greater Element** for each element in the array.  
- If there is **no greater element to the right**, return `-1` for that element.  

---

### **Examples**
Input: nums = [4,5,2,25]
Output: [5,25,25,-1]
Explanation:
Next greater for 4 is 5
Next greater for 5 is 25
Next greater for 2 is 25
Next greater for 25 is -1


---

### **Thought Process**

1. **Understand the problem**  
   - For each element, find the **first element to its right that is greater**.  
   - If no such element exists, return **-1**.  

2. **Brute-force approach**  
   - For each element, scan all elements to the right to find the next greater element.  
   - **Time Complexity:** `O(n²)` → inefficient for large arrays.  

3. **Optimized approach (Stack / Monotonic Stack)**  
   - Use a **stack** to keep track of elements whose next greater element is not yet found.  
   - Iterate through the array from **left to right**:  
     - While the **stack is not empty** and the current element is **greater than the top of the stack**:  
       - Pop from the stack → this popped element’s next greater element is the current element.  
     - Push the current element onto the stack.  
   - Elements remaining in the stack have **no next greater element**, so assign **-1**.  
   - **Time Complexity:** `O(n)` → each element pushed and popped once  
   - **Space Complexity:** `O(n)` → stack to track elements  

---



# ✖️ Product of Array Except Self

## **Problem Description**
Given an integer array `nums`, return an array `answer` such that:  

answer[i] = product of all elements of nums except nums[i]

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Explanation:

answer[0] = 234 = 24
answer[1] = 134 = 12
answer[2] = 124 = 8
answer[3] = 123 = 6


---

### **Thought Process**

1. **Understand the problem**  
   - Need the **product of all numbers except the current one** for each index.  
   - Must solve **without using division**.  

2. **Brute-force approach**  
   - For each element, multiply all other elements.  
   - **Time Complexity:** `O(n²)` → inefficient for large arrays.  

3. **Optimized approach (Prefix & Suffix products)**  
   - Compute **prefix products** for each index: product of all elements **to the left**.  
   - Compute **suffix products** for each index: product of all elements **to the right**.  
   - Multiply **prefix[i] * suffix[i]** to get the answer.  
   - **Time Complexity:** `O(n)`  
   - **Space Complexity:** `O(n)` → can be optimized to O(1) using the output array for prefix products.  

4. **Space-optimized approach**  
   - Use the output array to store **prefix products** first.  
   - Then traverse from right to left, maintaining a **running suffix product**, multiplying with the output array.  
   - **This avoids extra arrays for suffix products** and achieves **constant extra space**.  

---




# 🔄 Rotate Array

## **Problem Description**
Given an array `nums` and an integer `k`, **rotate the array to the right by `k` steps**, where `k` is non-negative.  

- The rotation should be **done in-place**, modifying the original array.  
- You should aim for an **efficient solution** with minimal extra space.  

---

### **Examples**
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
Rotate 1 step to the right: [7,1,2,3,4,5,6]
Rotate 2 steps: [6,7,1,2,3,4,5]
Rotate 3 steps: [5,6,7,1,2,3,4]


---

### **Thought Process**

1. **Understand the problem**  
   - We need to **shift all elements to the right** by `k` steps.  
   - If `k` is greater than the array length, use `k % n` to avoid unnecessary rotations.  

2. **Brute-force approach**  
   - Rotate the array **one step at a time**, `k` times.  
   - **Time Complexity:** `O(n*k)` → inefficient for large `k`  
   - **Space Complexity:** `O(1)` → in-place  

3. **Optimized approach (Using Reverse)**  
   - Use the **array reversal technique** to rotate in-place efficiently.  
   - Steps:  
     1. Reverse the **entire array**  
     2. Reverse the **first `k` elements**  
     3. Reverse the **remaining `n-k` elements**  
   - This effectively shifts all elements to the right by `k` steps.  
   - **Time Complexity:** `O(n)` → each element reversed once  
   - **Space Complexity:** `O(1)` → in-place  

---



# 🥈 Second Largest Element

## **Problem Description**
Given an integer array `nums`, find the **second largest element** in the array.  

- If the array contains **less than two distinct elements**, return a sentinel value like `-1` or indicate it doesn’t exist.  
- The solution should preferably traverse the array **only once**.  

---

### **Examples**
Input: nums = [3, 5, 2, 4, 1]
Output: 4
Explanation:
Largest element is 5
Second largest element is 4


---

### **Thought Process**

1. **Understand the problem**  
   - Need to find the **second largest distinct number**.  
   - Must handle **arrays with duplicate numbers**.  
   - Aim for **O(n) time** and **O(1) space**.  

2. **Brute-force approach**  
   - Sort the array in descending order and pick the second distinct element.  
   - **Time Complexity:** `O(n log n)` → less efficient  
   - **Space Complexity:** `O(1)` if sorting in-place  

3. **Optimized approach (Single Pass)**  
   - Use **two variables**: `first` for the largest, `second` for the second largest.  
   - Iterate through the array once:  
     - If current element > **first**:  
       - Update `second = first` and `first = current element`  
     - Else if current element > **second** and current element < **first**:  
       - Update `second = current element`  
   - At the end, `second` holds the **second largest distinct element**.  
   - **Time Complexity:** `O(n)` → single traversal  
   - **Space Complexity:** `O(1)` → only two extra variables  

---




# 🟩 Set Matrix Zeroes

## **Problem Description**
Given an `m x n` integer matrix `matrix`, if an element is `0`, **set its entire row and column to 0**.  

- This operation should be **done in-place**.  
- **Goal:** Minimize extra space usage.  

---

### **Examples**
Input: matrix = [
[1,1,1],
[1,0,1],
[1,1,1]
]
Output: [
[1,0,1],
[0,0,0],
[1,0,1]
]


---

### **Thought Process**

1. **Understand the problem**  
   - For **every 0 element**, set its **entire row and column to 0**.  
   - Must be done **in-place** with minimal extra space.  

2. **Brute-force approach**  
   - Create a **copy of the matrix**, mark rows and columns with zeros in the copy, and then update the original matrix.  
   - **Time Complexity:** `O(m*n)`  
   - **Space Complexity:** `O(m*n)` → extra matrix used  

3. **Optimized approach (Using extra arrays)**  
   - Use two arrays `rows` and `cols` to mark which rows and columns need to be zeroed.  
   - Iterate through the matrix once to mark zeros, then iterate again to update.  
   - **Time Complexity:** `O(m*n)`  
   - **Space Complexity:** `O(m+n)` → two extra arrays  

4. **Space-optimized approach (Using first row & first column as markers)**  
   - Use the **first row** and **first column** of the matrix itself to store markers for rows and columns to zero.  
   - Use two separate flags to track if **first row** or **first column** originally had any zeros.  
   - Iterate through the matrix to set markers, then update the matrix using these markers.  
   - Finally, update the **first row** and **first column** if needed.  
   - **Time Complexity:** `O(m*n)`  
   - **Space Complexity:** `O(1)` → in-place  

---




# 📊 Sliding Window Maximum

## **Problem Description**
Given an integer array `nums` and an integer `k`, there is a **sliding window of size `k`** which moves from **left to right** across the array.  
You need to return **an array of the maximum values** in each sliding window.  

- The solution should be **efficient**, ideally **O(n) time complexity**.  

---

### **Examples**
Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation:
Window positions:
[1,3,-1] -> max is 3
[3,-1,-3] -> max is 3
[-1,-3,5] -> max is 5
[-3,5,3] -> max is 5
[5,3,6] -> max is 6
[3,6,7] -> max is 7


---

### **Thought Process**

1. **Understand the problem**  
   - For each **window of size k**, find the **maximum element**.  
   - Window slides **one position at a time** from left to right.  

2. **Brute-force approach**  
   - For each window, scan all `k` elements to find the maximum.  
   - **Time Complexity:** `O(n*k)` → inefficient for large arrays  
   - **Space Complexity:** `O(1)` → in-place  

3. **Optimized approach (Deque / Monotonic Queue)**  
   - Use a **deque (double-ended queue)** to store **indices of elements**.  
   - Maintain the deque in **descending order of values**:  
     - The **front** of the deque is always the **maximum of the current window**.  
     - Remove indices **out of the current window** from the front.  
     - Remove indices from the **back** if their corresponding values are **smaller than the current element**.  
   - Append the current element’s index to the deque.  
   - For each window, **record deque[0]** as the maximum.  
   - **Time Complexity:** `O(n)` → each element is added and removed at most once  
   - **Space Complexity:** `O(k)` → deque stores indices of elements in the window  

---




# 🌀 Spiral Matrix

## **Problem Description**
Given an `m x n` integer matrix, return all elements of the matrix in **spiral order**.  

- Spiral order means starting from the **top-left corner** and moving in a **clockwise spiral**.  
- The solution should handle **rectangular matrices** and **empty matrices** efficiently.  

---

### **Examples**
Input: matrix = [
[1,2,3],
[4,5,6],
[7,8,9]
]
Output: [1,2,3,6,9,8,7,4,5]


---

### **Thought Process**

1. **Understand the problem**  
   - We need to traverse the matrix **clockwise in a spiral**.  
   - Must handle **different row and column counts**.  

2. **Brute-force approach**  
   - Keep a **visited matrix** to track visited cells.  
   - Move in **directions right → down → left → up** until all elements are visited.  
   - **Time Complexity:** `O(m*n)`  
   - **Space Complexity:** `O(m*n)` → for visited array  

3. **Optimized approach (Boundary tracking)**  
   - Maintain **four boundaries**: `top`, `bottom`, `left`, `right`.  
   - Traverse the matrix by:
     1. Moving **right** along the top row → increment `top`  
     2. Moving **down** along the rightmost column → decrement `right`  
     3. Moving **left** along the bottom row → decrement `bottom`  
     4. Moving **up** along the leftmost column → increment `left`  
   - Continue until `top > bottom` or `left > right`.  
   - **Time Complexity:** `O(m*n)` → each element visited once  
   - **Space Complexity:** `O(1)` extra space (excluding output)  

---






