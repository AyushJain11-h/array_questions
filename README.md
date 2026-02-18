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



