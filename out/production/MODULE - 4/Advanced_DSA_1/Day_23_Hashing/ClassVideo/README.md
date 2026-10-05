## --- notes on hashmap and hashset-----
Good question Ritik 👍
Since you are preparing **DSA seriously**, HashMap & HashSet are MUST-know topics for interviews.

I’ll give you **clear notes + examples + complexity + when to use what**.

---

# 🔹 1️⃣ What is Hashing?

Hashing is a technique to:

* Store data in **key-value form**
* Access data in **O(1)** average time

It uses a **hash function** to convert a key into an index.

---

# 🔹 2️⃣ HashMap in Java

## ✅ Definition

`HashMap<K, V>` stores:

```
Key → Value
```

* Keys are unique
* Values can be duplicate
* Order NOT maintained

---

## 📌 Syntax

```java
import java.util.*;

HashMap<Integer, String> map = new HashMap<>();
```

---

## 📌 Basic Operations

```java
map.put(1, "Ritik");       // Insert
map.get(1);                // Get value
map.containsKey(1);        // Check key
map.remove(1);             // Remove
map.size();                // Size
```

---

## 🔍 Example

```java
HashMap<Integer, String> map = new HashMap<>();

map.put(1, "A");
map.put(2, "B");
map.put(3, "C");

System.out.println(map.get(2)); // B
```

---

## ⏱ Time Complexity

| Operation | Average | Worst |
| --------- | ------- | ----- |
| put()     | O(1)    | O(n)  |
| get()     | O(1)    | O(n)  |
| remove()  | O(1)    | O(n)  |

Worst happens when many collisions occur.

---

## 🧠 Internal Working

* Uses **Array of buckets**
* Each bucket stores:

    * LinkedList (Java 7)
    * Balanced Tree (Java 8+) if collisions > 8

So worst case improved to:

```
O(log n)
```

---

# 🔹 3️⃣ HashSet in Java

## ✅ Definition

`HashSet<E>` stores:

```
Only Unique Values
```

* No duplicates
* No key-value
* Order NOT maintained

---

## 📌 Syntax

```java
HashSet<Integer> set = new HashSet<>();
```

---

## 📌 Basic Operations

```java
set.add(10);
set.remove(10);
set.contains(10);
set.size();
```

---

## 🔍 Example

```java
HashSet<Integer> set = new HashSet<>();

set.add(1);
set.add(2);
set.add(1);  // duplicate ignored

System.out.println(set); // [1,2]
```

---

## ⏱ Time Complexity

| Operation  | Average |
| ---------- | ------- |
| add()      | O(1)    |
| remove()   | O(1)    |
| contains() | O(1)    |

---

# 🔹 4️⃣ HashMap vs HashSet

| Feature          | HashMap         | HashSet          |
| ---------------- | --------------- | ---------------- |
| Stores           | Key → Value     | Only values      |
| Duplicate keys   | ❌ Not allowed   | ❌ Not allowed    |
| Duplicate values | ✅ Allowed       | ❌ Not allowed    |
| Use case         | Frequency count | Check uniqueness |

---

# 🔥 Most Important DSA Uses

Since you're preparing advanced DSA, these are important:

---

## 1️⃣ Frequency Counting

```java
int[] arr = {1,2,2,3};

HashMap<Integer, Integer> freq = new HashMap<>();

for(int num : arr){
    freq.put(num, freq.getOrDefault(num, 0) + 1);
}
```

Used in:

* Majority element
* Anagram
* Subarray problems

---

## 2️⃣ Remove Duplicates

```java
HashSet<Integer> set = new HashSet<>();

for(int num : arr){
    set.add(num);
}
```

---

## 3️⃣ Check Pair Sum

```java
HashSet<Integer> set = new HashSet<>();

for(int num : arr){
    if(set.contains(target - num)){
        System.out.println("Pair found");
    }
    set.add(num);
}
```

Time: O(N)

---

## 4️⃣ Longest Consecutive Sequence (Very Popular)

Uses HashSet for O(N) solution.

---

# 🔹 5️⃣ When To Use What?

### Use HashMap when:

* Need frequency
* Need mapping
* Need index storage

### Use HashSet when:

* Need uniqueness
* Need fast lookup
* Pair sum problems

---

# 🔥 Interview Tricks

### ✅ getOrDefault()

```java
map.getOrDefault(key, 0)
```

### ✅ putIfAbsent()

```java
map.putIfAbsent(key, value);
```

### ✅ Iterate HashMap

```java
for(Map.Entry<Integer, Integer> entry : map.entrySet()){
    System.out.println(entry.getKey() + " " + entry.getValue());
}
```

---

# 🔹 6️⃣ Ordered Versions

If order matters:

| Structure     | Ordered by      |
| ------------- | --------------- |
| LinkedHashMap | Insertion order |
| TreeMap       | Sorted order    |
| LinkedHashSet | Insertion order |
| TreeSet       | Sorted order    |

---

# 🔥 Advanced Interview Questions

1. Two Sum
2. Subarray with sum K
3. Count pairs divisible by K
4. Longest substring without repeating characters
5. Group Anagrams

All use HashMap / HashSet heavily.

---

# 🚀 Final Summary

HashMap = Key → Value
HashSet = Only unique values
Both give average O(1) operations
Very powerful in DSA

---

If you want, I can now give you:

* 🔥 10 must-do HashMap interview problems
* 🔥 Real interview level tricky problems
* 🔥 Internal working diagram explanation
* 🔥 Implementation from scratch (build your own HashMap)

Tell me your level now 😎


##  Q-1: Given N elements and Q queries, find the frequency of the elements provided in a query  ###
Good question Ritik 🔥
This is a **very common Hashing interview problem**.

Let’s solve it properly:

> **Q-1:** Given N elements and Q queries, find the frequency of the elements provided in a query.

---

# 🧠 Problem Understanding

You are given:

* An array of N elements
* Q queries
* Each query asks:
  👉 "How many times does X appear in the array?"

---

## 🔎 Example

```
Array = [1, 2, 1, 3, 2, 1]
Queries = [1, 2, 4]
```

### Output:

```
1 → 3 times
2 → 2 times
4 → 0 times
```

---

# 🔴 Approach 1: Brute Force (BF)

## 💡 Idea

For every query:

* Traverse the entire array
* Count frequency manually

---

## 🧾 Code (Brute Force)

```java
public class Solution {

    public static int findFrequency(int[] arr, int x) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 1, 3, 2, 1};
        int[] queries = {1, 2, 4};

        for (int q : queries) {
            System.out.println(q + " -> " + findFrequency(arr, q));
        }
    }
}
```

---

## ⏱ Time Complexity

For each query → O(N)

Total:

```
O(N * Q)
```

If:

```
N = 10^5
Q = 10^5
```

Worst case = 10^10 ❌ (TLE)

---

# 🟢 Approach 2: Better Using Sorting + Binary Search

## 💡 Idea

1. Sort the array
2. For each query:

    * Find first occurrence
    * Find last occurrence
    * Frequency = last - first + 1

---

## ⏱ Time Complexity

Sorting = O(N log N)
Each query = O(log N)

Total:

```
O(N log N + Q log N)
```

Better than brute force.

---

# 🟢 Approach 3: Optimal Using HashMap 🔥 (Best Approach)

## 💡 Idea

1. Traverse array once
2. Store frequency in HashMap
3. Answer each query in O(1)

---

## 🧾 Code (Optimal)

```java
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        int[] arr = {1, 2, 1, 3, 2, 1};
        int[] queries = {1, 2, 4};

        HashMap<Integer, Integer> freqMap = new HashMap<>();

        // Step 1: Build frequency map
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Answer queries
        for (int q : queries) {
            System.out.println(q + " -> " + freqMap.getOrDefault(q, 0));
        }
    }
}
```

---

# ⏱ Time Complexity

Building map = O(N)
Each query = O(1)

Total:

```
O(N + Q)
```

✅ BEST SOLUTION

---

# 🔍 Dry Run (Optimal Approach)

Array = [1, 2, 1, 3, 2, 1]

### Step 1: Build HashMap

| Element | Map             |
| ------- | --------------- |
| 1       | {1=1}           |
| 2       | {1=1, 2=1}      |
| 1       | {1=2, 2=1}      |
| 3       | {1=2, 2=1, 3=1} |
| 2       | {1=2, 2=2, 3=1} |
| 1       | {1=3, 2=2, 3=1} |

---

### Step 2: Answer Queries

Query 1 → map.get(1) = 3
Query 2 → map.get(2) = 2
Query 4 → map.get(4) = 0

---

# 🟣 Approach 4: If Values Range is Small (Using Frequency Array)

If:

```
1 ≤ arr[i] ≤ 10^6
```

We can use:

```java
int[] freq = new int[1000001];

for(int num : arr){
    freq[num]++;
}
```

Then query:

```java
System.out.println(freq[x]);
```

Time:

```
O(N + Q)
```

Very fast 🔥

---

# 📊 Final Comparison

| Approach                | Time                 | Space       | When to Use                 |
| ----------------------- | -------------------- | ----------- | --------------------------- |
| Brute Force             | O(NQ)                | O(1)        | Small input                 |
| Sorting + Binary Search | O(N log N + Q log N) | O(1)        | When no extra space allowed |
| HashMap                 | O(N + Q)             | O(N)        | Best general case           |
| Frequency Array         | O(N + Q)             | O(MaxValue) | When range small            |

---

# 🎯 Interview Follow-Up Questions

1. What if memory is limited?
2. What if array is very large?
3. What if queries come online?
4. What if array is dynamic (updates)?

---

# 🚀 Since you're preparing advanced DSA

This problem builds base for:

* Subarray sum problems
* Count pairs divisible by K
* Majority element
* Anagram problems
* Sliding window problems

---

If you want next level:

I can now give:

* 🔥 Same problem but with updates
* 🔥 Query range frequency problem
* 🔥 Mo’s Algorithm version
* 🔥 Competitive coding level version

Tell me which level you want next 😎

## -- should we use here any one from continuation, carry forward and one and if not then why --
Very good question Ritik 👏🔥
This shows you’re trying to connect patterns instead of just memorizing.

You’re asking:

> In this frequency query problem, should we use
> ✅ Contribution
> ✅ Carry Forward
> ✅ Prefix technique
> or something else?

Let’s break this properly.

---

# 🧠 Problem Type Reminder

We have:

* An array
* Multiple queries
* Each query asks:

  👉 “How many times does X appear in the array?”

---

# ❓ Should We Use Contribution Technique?

### 🔹 What is Contribution Technique?

Contribution is used when:

* Each element contributes to many subarrays
* We calculate total effect directly
* Example:

    * Sum of all subarrays
    * Count of subarrays
    * Total pair contributions

### ❌ Not Needed Here

Why?

Because:

* We are not calculating global effect
* We are not combining multiple elements
* We are just counting occurrences of one value

So contribution does NOT apply here.

---

# ❓ Should We Use Carry Forward?

### 🔹 What is Carry Forward?

Carry forward means:

* Maintaining running information
* Example:

    * Prefix sum
    * Max so far
    * Count so far

It works well when:

* Queries are range based
* Or cumulative information is required

### ❌ Not Needed Here

This problem:

* Is NOT range-based
* Is NOT cumulative
* Is NOT sequential dependent

Each query is independent.

So carry forward is not required.

---

# ❓ Should We Use Prefix?

Prefix works when queries are like:

```
How many 5's between index L and R?
```

Then we would use:

```
prefix[i] = count of X till index i
```

But here:

Query = "How many times X appears in entire array?"

No range.

So prefix also unnecessary.

---

# 🎯 So What Should We Use?

This is a **Hashing problem**.

Why?

Because:

* We need fast lookup
* Each query independent
* We need frequency storage

Best solution = HashMap

```
Preprocess: O(N)
Query: O(1)
Total: O(N + Q)
```

---

# 🧠 Pattern Recognition Trick (Important)

When you see:

| Problem Type       | Technique              |
| ------------------ | ---------------------- |
| Frequency lookup   | HashMap                |
| Range sum query    | Prefix sum             |
| Subarray count     | Prefix + Hash          |
| Contribution total | Contribution technique |
| Sliding window     | Two pointers           |
| Running cumulative | Carry forward          |

---

# 🔥 When Would Carry Forward Be Used Here?

If question was:

```
Given N elements and Q queries,
Each query gives L and R,
Find frequency of X between L and R.
```

Then we would use:

```
Prefix Frequency Array
```

Example:

```
freq[i] = count of X till index i
```

Then:

```
Answer = freq[R] - freq[L-1]
```

That is carry-forward usage.

---

# 🧠 Final Clear Answer

👉 No, we should NOT use contribution
👉 No, we should NOT use carry forward
👉 No, we should NOT use prefix

Because:

This is a pure **frequency lookup problem**

Best tool = **HashMap**

---

# 🏆 Interview Explanation Style Answer

If interviewer asks:

> Why did you use HashMap?

You say:

> Since queries are independent and require fast frequency lookup, preprocessing the array into a HashMap allows O(1) query time. Carry forward or prefix techniques are more suitable for cumulative or range-based problems, which is not the case here.

That’s a solid answer.

---

If you want, I can now give you:

* 🔥 Hard version of this question
* 🔥 Range frequency query problem
* 🔥 Mo's algorithm version
* 🔥 Competitive programming version

Tell me the level 😎


## -- Q-2: Given an array of N elements, find the count of distinct elements. --

Good question Ritik 👏
This is a **very fundamental hashing problem** — asked in interviews and coding rounds.

We’ll go step-by-step:

1. ✅ Brute Force
2. ✅ Better Approach
3. ✅ Optimized Approach (Best)
4. ✅ Dry Run
5. ✅ Time & Space Complexity
6. ✅ Full Code

---

# 🧠 Problem Statement

Given an array of N elements,
find the **count of distinct (unique) elements**.

### Example:

```
Input:  [1, 2, 2, 3, 4, 4, 5]
Output: 5
Distinct elements → {1,2,3,4,5}
```

---

# 🔴 1️⃣ Brute Force Approach (O(N²))

## 💡 Idea

For each element:

* Check if it appeared before.
* If not → count it.

---

## 🧠 Logic

For every `i`:

* Check all `j < i`
* If same element found → skip
* If not found → increase count

---

## 🔎 Dry Run

Array:

```
[1, 2, 2, 3]
```

Step-by-step:

| i | Value | Check Previous | New? | Count |
| - | ----- | -------------- | ---- | ----- |
| 0 | 1     | none           | Yes  | 1     |
| 1 | 2     | 1              | Yes  | 2     |
| 2 | 2     | 1,2            | No   | 2     |
| 3 | 3     | 1,2,2          | Yes  | 3     |

Answer = 3

---

## 🧮 Time Complexity

Outer loop → N
Inner loop → N

```
O(N²)
```

---

## 💻 Code (Brute Force)

```java
public static int countDistinctBF(int[] arr) {
    int n = arr.length;
    int count = 0;

    for (int i = 0; i < n; i++) {
        boolean found = false;

        for (int j = 0; j < i; j++) {
            if (arr[i] == arr[j]) {
                found = true;
                break;
            }
        }

        if (!found) {
            count++;
        }
    }

    return count;
}
```

---

# 🟡 2️⃣ Better Approach (Sorting)

## 💡 Idea

If we sort:

* Equal elements come together
* Count when element changes

---

## 🧠 Steps

1. Sort array
2. Count first element
3. If `arr[i] != arr[i-1]` → increment count

---

## 🔎 Dry Run

Original:

```
[4,1,2,2,3]
```

After sorting:

```
[1,2,2,3,4]
```

Count changes:

1 → count=1
2 → count=2
2 → skip
3 → count=3
4 → count=4

Answer = 4

---

## 🧮 Time Complexity

Sorting → O(N log N)
Traversal → O(N)

Total:

```
O(N log N)
```

---

## 💻 Code

```java
import java.util.Arrays;

public static int countDistinctBetter(int[] arr) {
    Arrays.sort(arr);
    int count = 1;

    for (int i = 1; i < arr.length; i++) {
        if (arr[i] != arr[i - 1]) {
            count++;
        }
    }

    return count;
}
```

---

# 🟢 3️⃣ Optimized Approach (HashSet) 🔥

This is the BEST solution.

## 💡 Idea

Use a HashSet:

* Set automatically stores only unique values.

---

## 🧠 Steps

1. Create HashSet
2. Add all elements
3. Return set size

---

## 🔎 Dry Run

Array:

```
[1,2,2,3,4,4,5]
```

Step-by-step insert:

```
Set: {}
Add 1 → {1}
Add 2 → {1,2}
Add 2 → {1,2}
Add 3 → {1,2,3}
Add 4 → {1,2,3,4}
Add 4 → {1,2,3,4}
Add 5 → {1,2,3,4,5}
```

Size = 5

---

## 🧮 Time Complexity

Insert N elements
Each insert → O(1) average

Total:

```
O(N)
```

Space:

```
O(N)
```

---

## 💻 Code (Best)

```java
import java.util.HashSet;

public static int countDistinctOptimized(int[] arr) {
    HashSet<Integer> set = new HashSet<>();

    for (int num : arr) {
        set.add(num);
    }

    return set.size();
}
```

---

# 📊 Comparison Table

| Approach    | Time       | Space | Good For            |
| ----------- | ---------- | ----- | ------------------- |
| Brute Force | O(N²)      | O(1)  | Small N             |
| Sorting     | O(N log N) | O(1)  | No extra memory     |
| HashSet     | O(N)       | O(N)  | Best for interviews |

---

# 🧠 Important Interview Insight

If interviewer says:

> Can you solve without extra space?

Then use **sorting approach**.

If interviewer says:

> Optimize time complexity

Use **HashSet**.

---

# 🎯 Pattern Recognition

When you see:

* Count distinct
* Remove duplicates
* Check existence quickly

Think:

```
HASHING
```

---

If you want next level question:

* Count distinct in every window of size K
* Distinct in range queries
* Longest subarray with distinct elements

Tell me 😎

## Q-3: Given arr[N] and K, check if there exists a pair(i, j) such that, arr[i] + arr[j] == K && i != j ----
Excellent Ritik 👏
This is a **very classic interview problem** — 2 Sum variant.

We will solve it step-by-step:

1. 🔴 Brute Force
2. 🟡 Better (Sorting + Two Pointer)
3. 🟢 Optimal (HashSet)
4. Dry Runs
5. Time & Space Complexity
6. Full Java Code

---

# 🧠 Problem Statement

Given:

```
arr[N] and integer K
```

Check if there exists a pair `(i, j)` such that:

```
arr[i] + arr[j] == K
AND i != j
```

Return **true or false**.

---

# Example

```
arr = [2, 7, 11, 15]
K = 9
```

2 + 7 = 9 → TRUE ✅

---

# 🔴 1️⃣ Brute Force Approach (O(N²))

## 💡 Idea

Try every possible pair.

---

## 🧠 Logic

For every `i`
 Check every `j > i`

If:

```
arr[i] + arr[j] == K
```

Return true.

---

## 🔎 Dry Run

```
arr = [3, 5, 9, 2]
K = 7
```

Check pairs:

(3,5) → 8 ❌
(3,9) → 12 ❌
(3,2) → 5 ❌
(5,9) → 14 ❌
(5,2) → 7 ✅ → FOUND

Return true

---

## 💻 Code (Brute Force)

```java
public static boolean pairSumBF(int[] arr, int K) {
    int n = arr.length;

    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            if (arr[i] + arr[j] == K) {
                return true;
            }
        }
    }
    return false;
}
```

---

## ⏱ Time Complexity

```
O(N²)
```

Space:

```
O(1)
```

---

# 🟡 2️⃣ Better Approach (Sorting + Two Pointers)

## 💡 Idea

1. Sort the array.
2. Use two pointers:

    * left = 0
    * right = n-1

---

## 🧠 Logic

If sum > K → move right--
If sum < K → move left++
If sum == K → return true

---

## 🔎 Dry Run

```
arr = [3,5,9,2]
K = 7
```

After sorting:

```
[2,3,5,9]
```

left = 0 (2)
right = 3 (9)

2+9=11 > 7 → right--
2+5=7 → FOUND ✅

---

## 💻 Code

```java
import java.util.Arrays;

public static boolean pairSumTwoPointer(int[] arr, int K) {
    Arrays.sort(arr);

    int left = 0;
    int right = arr.length - 1;

    while (left < right) {
        int sum = arr[left] + arr[right];

        if (sum == K) {
            return true;
        } else if (sum < K) {
            left++;
        } else {
            right--;
        }
    }
    return false;
}
```

---

## ⏱ Time Complexity

Sorting → O(N log N)
Traversal → O(N)

Total:

```
O(N log N)
```

Space:

```
O(1)
```

---

# 🟢 3️⃣ Optimized Approach (HashSet) 🔥

This is BEST for interviews.

---

## 💡 Core Idea

For every element:

We check:

```
Is (K - arr[i]) already seen?
```

If yes → pair exists.

---

## 🧠 Logic

For each element:

```
target = K - arr[i]
If target exists in set → return true
Else add arr[i] to set
```

---

## 🔎 Dry Run

```
arr = [3,5,9,2]
K = 7
```

Step 1:
Set = {}
Element = 3
Check 7-3=4 → not present
Add 3 → {3}

Step 2:
Element = 5
Check 7-5=2 → not present
Add 5 → {3,5}

Step 3:
Element = 9
Check 7-9=-2 → not present
Add 9 → {3,5,9}

Step 4:
Element = 2
Check 7-2=5 → YES (5 in set) ✅

Return true

---

## 💻 Code (Optimized)

```java
import java.util.HashSet;

public static boolean pairSumOptimized(int[] arr, int K) {
    HashSet<Integer> set = new HashSet<>();

    for (int num : arr) {
        int target = K - num;

        if (set.contains(target)) {
            return true;
        }

        set.add(num);
    }

    return false;
}
```

---

## ⏱ Time Complexity

Each operation → O(1) average
Total:

```
O(N)
```

Space:

```
O(N)
```

---

# 🔥 Edge Case

```
arr = [4]
K = 8
```

Return false (i != j)

---

# 🧠 Interview Follow-up Questions

They may ask:

1. What if array contains duplicates?
2. Return indices instead of boolean?
3. Count total such pairs?
4. Solve without extra space?

---

# 📊 Final Comparison

| Approach     | Time       | Space | When to Use             |
| ------------ | ---------- | ----- | ----------------------- |
| Brute Force  | O(N²)      | O(1)  | Small input             |
| Sorting + 2P | O(N log N) | O(1)  | No extra memory allowed |
| HashSet      | O(N)       | O(N)  | Best & most common      |

---

# 🎯 Pattern Recognition

Whenever you see:

```
Pair sum
Two sum
Difference equals K
```

Immediately think:

```
Hashing or Two Pointer
```

---

If you want next level:

* Count number of pairs
* Print all pairs
* 3 Sum
* 4 Sum
* Closest pair to K

Tell me 😎

## Q-4:  
```declarative
Count pairs(i, j) such that, arr[i] + arr[j] == K && i != j in the given array.
A = [3, 5, 1, 2, 1, 2] and K = 3.
Note that (i, j) and (j, i) considered as same.
```

Very good Ritik 👏🔥
Now this is **Two Sum – Count version** (not just check).

We must count pairs:

```
arr[i] + arr[j] == K
i != j
(i, j) same as (j, i)
```

So each pair counted **only once**.

---

# 🧠 Given

```
A = [3, 5, 1, 2, 1, 2]
K = 3
```

---

# 🔴 1️⃣ Brute Force (O(N²))

## 💡 Idea

Try every pair `(i < j)`
If sum == K → count++

---

## 🔎 Dry Run

Array:

```
Index: 0 1 2 3 4 5
Value: 3 5 1 2 1 2
```

Check pairs:

(3,5) → 8 ❌
(3,1) → 4 ❌
(3,2) → 5 ❌
(3,1) → 4 ❌
(3,2) → 5 ❌

(5,1) → 6 ❌
(5,2) → 7 ❌
(5,1) → 6 ❌
(5,2) → 7 ❌

(1,2) → 3 ✅
(1,1) → 2 ❌
(1,2) → 3 ✅

(2,1) → 3 ✅
(2,2) → 4 ❌

(1,2) → 3 ✅

Total = 4 pairs

---

## 💻 Code (Brute Force)

```java
public static int countPairsBF(int[] arr, int K) {
    int n = arr.length;
    int count = 0;

    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            if (arr[i] + arr[j] == K) {
                count++;
            }
        }
    }
    return count;
}
```

---

## ⏱ Time Complexity

```
O(N²)
```

Space:

```
O(1)
```

---

# 🟢 2️⃣ Optimized Approach (HashMap Frequency) 🔥

This is the correct interview solution.

---

## 💡 Core Idea

For every element:

We want:

```
arr[i] + arr[j] = K
```

So:

```
arr[j] = K - arr[i]
```

Instead of checking every pair,
we store frequency of elements seen so far.

---

## 🧠 Algorithm

For each element:

1. Compute `target = K - arr[i]`
2. If target exists in map:
   → Add its frequency to answer
3. Update frequency of current element

---

## 🔎 Step-by-Step Dry Run

```
A = [3, 5, 1, 2, 1, 2]
K = 3
```

Start:

```
map = {}
count = 0
```

---

### Step 1: num = 3

target = 3 - 3 = 0
0 not in map
Add 3

map = {3:1}

---

### Step 2: num = 5

target = -2
Not in map
Add 5

map = {3:1, 5:1}

---

### Step 3: num = 1

target = 2
Not in map
Add 1

map = {3:1, 5:1, 1:1}

---

### Step 4: num = 2

target = 1
1 exists with freq = 1

count = 1

Add 2

map = {3:1, 5:1, 1:1, 2:1}

---

### Step 5: num = 1

target = 2
2 exists with freq = 1

count = 2

Add 1

map = {3:1, 5:1, 1:2, 2:1}

---

### Step 6: num = 2

target = 1
1 exists with freq = 2

count = 2 + 2 = 4

Add 2

map = {3:1, 5:1, 1:2, 2:2}

---

# ✅ Final Answer = 4

---

## 💻 Code (Optimized)

```java
import java.util.HashMap;

public static int countPairsOptimized(int[] arr, int K) {

    HashMap<Integer, Integer> map = new HashMap<>();
    int count = 0;

    for (int num : arr) {

        int target = K - num;

        if (map.containsKey(target)) {
            count += map.get(target);
        }

        map.put(num, map.getOrDefault(num, 0) + 1);
    }

    return count;
}
```

---

## ⏱ Time Complexity

```
O(N)
```

Space:

```
O(N)
```

---

# 🔥 Why This Works

Because when we reach element `num`,
all previous elements are already stored in map.

So we instantly know how many valid pairs exist.

No double counting happens because:

* We only match with previously seen elements.
* So (i, j) counted once.

---

# 🎯 Important Interview Insight

This is different from:

> "Check if pair exists"

Here we need:

> "Count all pairs"

So we use **frequency map**.

---

# 🧠 Pattern Recognition

Whenever you see:

* Count pairs
* Sum equals K
* i < j
* Large constraints

Think:

```
HashMap Frequency
```

---

If you want next level:

* Count pairs divisible by K
* Count pairs with difference K
* Count triplets
* Count pairs in sorted array (two pointer variant)

Tell me 😎
