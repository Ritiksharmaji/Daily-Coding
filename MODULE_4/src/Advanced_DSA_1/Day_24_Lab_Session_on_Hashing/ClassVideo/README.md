
## Q-1: Given a string s, find the length of the longest substring without repeating characters --
Very Important Problem 🔥
This is one of the **top interview questions** (Amazon, Google, Microsoft, etc.)

---

# 🟢 Problem

Given a string `s`,
Find the **length of the longest substring without repeating characters**.

Example:

```
Input:  "abcabcbb"
Output: 3
Explanation: "abc"
```

---

# 🔴 1️⃣ Brute Force Approach (Generate All Substrings)

## 💡 Idea:

* Generate all substrings
* For each substring, check if all characters are unique
* Track max length

---

## 🧠 Pseudocode

```
maxLen = 0

FOR i from 0 to n-1:
    FOR j from i to n-1:
        substring = s[i...j]
        IF substring has all unique characters:
            maxLen = max(maxLen, length of substring)

RETURN maxLen
```

---

## 🔎 How to check unique?

Use HashSet:

```
function isUnique(substring):
    create empty set
    FOR each char in substring:
        IF char already in set:
            return false
        add char to set
    return true
```

---

## ⏱ Complexity

* Substrings = O(N²)
* Checking uniqueness = O(N)

Total → **O(N³)** ❌

Too slow for large input.

---

# 🟡 2️⃣ Better Brute (Improved)

Instead of generating substring each time:

```
FOR i from 0 to n-1:
    create empty set
    FOR j from i to n-1:
        IF s[j] in set:
            break
        add s[j] to set
        maxLen = max(maxLen, j-i+1)
```

---

## ⏱ Complexity

Outer loop → N
Inner loop → N
Total → **O(N²)**

Better but still slow.

---

# 🟢 3️⃣ Optimized – Sliding Window (Two Pointers)

🔥 This is the industry standard solution.

---

# 🧠 Idea

Maintain:

* Left pointer `l`
* Right pointer `r`
* HashSet / HashMap

Expand window:

* If character not seen → expand
* If duplicate → shrink from left

---

# 🧠 Visualization

Example:

```
s = "abcabcbb"
```

Start:

```
l=0, r=0 → a
[a]
```

```
r=1 → b
[a b]
```

```
r=2 → c
[a b c] → length=3
```

```
r=3 → a (duplicate)
Remove from left until duplicate gone
```

Window becomes:

```
[b c]
```

Continue…

---

# 🧠 Optimized Pseudocode

```
l = 0
maxLen = 0
create empty set

FOR r from 0 to n-1:

    WHILE s[r] in set:
        remove s[l] from set
        l++

    add s[r] to set
    maxLen = max(maxLen, r-l+1)

RETURN maxLen
```

---

# 🟢 Java Code

```java
public class Solution {
    public int lengthOfLongestSubstring(String s) {

        int left = 0;
        int maxLen = 0;

        HashSet<Character> set = new HashSet<>();

        for (int right = 0; right < s.length(); right++) {

            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
```

---

# ⏱ Complexity

Time → O(N) ✅
Space → O(K) (unique characters)

Each character is:

* Added once
* Removed once

So total operations = 2N

---

# 🔵 4️⃣ More Optimized (Using HashMap)

Instead of removing one-by-one,
Jump directly to next position.

---

### Idea:

Store last index of character.

---

### Code

```java
public int lengthOfLongestSubstring(String s) {

    HashMap<Character, Integer> map = new HashMap<>();
    int maxLen = 0;
    int left = 0;

    for (int right = 0; right < s.length(); right++) {

        char ch = s.charAt(right);

        if (map.containsKey(ch)) {
            left = Math.max(left, map.get(ch) + 1);
        }

        map.put(ch, right);
        maxLen = Math.max(maxLen, right - left + 1);
    }

    return maxLen;
}
```

---

# ⏱ Complexity

Time → O(N)
Space → O(K)

Even cleaner sliding window.

---

# 🏆 Interview Explanation

If interviewer asks:

> Why sliding window works?

You say:

* We maintain a window of unique characters.
* If duplicate appears, we shrink window.
* Each character processed at most twice.
* So time complexity is linear.

---

# 🔥 Summary Table

| Approach             | Time  | Space |
| -------------------- | ----- | ----- |
| Brute Force          | O(N³) | O(N)  |
| Better BF            | O(N²) | O(N)  |
| Sliding Window (Set) | O(N)  | O(N)  |
| Sliding Window (Map) | O(N)  | O(N)  |

---

If you want next level:

* 🔥 Print the actual substring
* 🔥 Longest substring with at most K distinct chars
* 🔥 Longest repeating substring
* 🔥 Minimum window substring

Tell me which level you want 😎

## dry run with above four ways --
Perfect 🔥
We’ll do **dry run of all 4 approaches** clearly and properly.

Example:

```
s = "abcabcbb"
Answer = 3
```

---

# 🔴 1️⃣ Brute Force O(N³)

### Idea:

Generate every substring and check uniqueness.

---

### All Substrings:

From index 0:

```
a ✔ (1)
ab ✔ (2)
abc ✔ (3)
abca ❌
abcab ❌
```

From index 1:

```
b ✔ (1)
bc ✔ (2)
bca ✔ (3)
bcab ❌
```

From index 2:

```
c ✔
ca ✔
cab ✔ (3)
cabc ❌
```

From index 3:

```
a ✔
ab ✔
abc ✔ (3)
abcb ❌
```

From index 4:

```
b ✔
bc ✔
bcb ❌
```

From index 5:

```
c ✔
cb ✔
cbb ❌
```

From index 6:

```
b ✔
bb ❌
```

From index 7:

```
b ✔
```

### Maximum length found = **3**

⏱ Time = O(N³)

---

# 🟡 2️⃣ Better Brute O(N²)

Instead of creating substring, use set directly.

---

### i = 0

```
j=0 → a ✔
j=1 → b ✔
j=2 → c ✔
j=3 → a ❌ break
max = 3
```

---

### i = 1

```
b ✔
c ✔
a ✔
b ❌
max = 3
```

---

### i = 2

```
c ✔
a ✔
b ✔
c ❌
max = 3
```

Continue similarly…

Final max = 3

⏱ Time = O(N²)

---

# 🟢 3️⃣ Sliding Window (HashSet)

Now we track window dynamically.

---

Initial:

```
left = 0
max = 0
set = {}
```

---

### right = 0 → a

```
set = {a}
window = "a"
max = 1
```

---

### right = 1 → b

```
set = {a,b}
window = "ab"
max = 2
```

---

### right = 2 → c

```
set = {a,b,c}
window = "abc"
max = 3
```

---

### right = 3 → a (duplicate)

Remove from left until duplicate gone

Remove 'a'

```
left = 1
set = {b,c}
```

Add 'a'

```
window = "bca"
max = 3
```

---

### right = 4 → b

Remove 'b'

```
left = 2
set = {c,a}
```

Add 'b'

```
window = "cab"
max = 3
```

---

### right = 5 → c

Remove 'c'

```
left = 3
set = {a,b}
```

Add 'c'

```
window = "abc"
max = 3
```

---

### right = 6 → b

Remove 'a'

```
left = 4
```

Remove 'b'

```
left = 5
```

Add 'b'

```
window = "cb"
max = 3
```

---

### right = 7 → b

Remove 'c'

```
left = 6
```

Remove 'b'

```
left = 7
```

Add 'b'

```
window = "b"
```

Final max = **3**

⏱ Time = O(N)

---

# 🔵 4️⃣ Sliding Window (HashMap – Jump Version)

This version jumps left pointer.

---

Initial:

```
left = 0
max = 0
map = {}
```

---

### right = 0 → a

```
map = {a:0}
window = "a"
max = 1
```

---

### right = 1 → b

```
map = {a:0, b:1}
window = "ab"
max = 2
```

---

### right = 2 → c

```
map = {a:0, b:1, c:2}
window = "abc"
max = 3
```

---

### right = 3 → a

'a' exists at index 0

```
left = max(0, 0+1) = 1
map[a] = 3
window = "bca"
max = 3
```

---

### right = 4 → b

```
left = max(1, 1+1) = 2
map[b] = 4
window = "cab"
max = 3
```

---

### right = 5 → c

```
left = max(2, 2+1) = 3
map[c] = 5
window = "abc"
max = 3
```

---

### right = 6 → b

```
left = max(3, 4+1) = 5
map[b] = 6
window = "cb"
max = 3
```

---

### right = 7 → b

```
left = max(5, 6+1) = 7
map[b] = 7
window = "b"
max = 3
```

---

Final Answer = **3**

---

# 🏆 Comparison

| Approach     | Time   | Space | Best?  |
| ------------ | ------ | ----- | ------ |
| Brute O(N³)  | ❌      | ❌     | No     |
| Better O(N²) | ⚠      | ⚠     | OK     |
| Sliding Set  | ✅ O(N) | O(N)  | Good   |
| Sliding Map  | ✅ O(N) | O(N)  | ⭐ Best |

---

If you want next level:

* 🔥 Print actual substring
* 🔥 At most K distinct
* 🔥 Longest repeating
* 🔥 Minimum window substring

Tell me which one next 😎


## Q-2: Given N elements, find the first non-repeating element ----
Great question 👍 This is a **very important hashing problem** for interviews.

# 🔷 Problem

**Given N elements, find the first non-repeating element.**

Example:

```
Input:  [4, 5, 1, 2, 0, 4]
Output: 5
```

Because:

* 4 → repeats
* 5 → appears once ✅ (first non-repeating)

---

# 🟡 Approach 1: Brute Force (BF)

## 🔹 Idea

For every element, check if it appears again in the array.

## 🔹 Pseudocode

```
for i from 0 to n-1:
    count = 0
    for j from 0 to n-1:
        if arr[i] == arr[j]:
            count++

    if count == 1:
        return arr[i]

return -1
```

## 🔹 Time Complexity

* Outer loop → N
* Inner loop → N
  👉 **O(N²)**

## 🔹 Space Complexity

👉 **O(1)**

---

## 🔹 Dry Run

Array:

```
[4, 5, 1, 2, 0, 4]
```

i = 0 → 4
count = 2 ❌

i = 1 → 5
count = 1 ✅
Return 5

---

## 🔹 Java Code (Brute Force)

```java
public class FirstNonRepeating {

    public static int firstNonRepeating(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int count = 0;

            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }

            if (count == 1) {
                return arr[i];
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 2, 0, 4};
        System.out.println(firstNonRepeating(arr));
    }
}
```

---

# 🟢 Approach 2: Better (Using HashMap - Two Pass)

## 🔹 Idea

1. Count frequency using HashMap
2. Traverse array again
3. First element with frequency 1 → answer

---

## 🔹 Pseudocode

```
create empty hashmap

for each element in array:
    increase its frequency

for each element in array:
    if frequency == 1:
        return element

return -1
```

---

## 🔹 Time Complexity

* First pass → O(N)
* Second pass → O(N)

👉 **O(N)**

## 🔹 Space Complexity

👉 **O(N)**

---

## 🔹 Dry Run

Array:

```
[4, 5, 1, 2, 0, 4]
```

### Step 1: Build frequency map

```
4 → 2
5 → 1
1 → 1
2 → 1
0 → 1
```

### Step 2: Traverse again

4 → freq 2 ❌
5 → freq 1 ✅
Return 5

---

## 🔹 Java Code (Optimized)

```java
import java.util.HashMap;

public class FirstNonRepeating {

    public static int firstNonRepeating(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequency
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Find first non-repeating
        for (int num : arr) {
            if (map.get(num) == 1) {
                return num;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 2, 0, 4};
        System.out.println(firstNonRepeating(arr));
    }
}
```

---

# 🟣 Approach 3: Using LinkedHashMap (Single Pass Logic Feel)

If we want to preserve insertion order automatically:

```java
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeating {

    public static int firstNonRepeating(int[] arr) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 2, 0, 4};
        System.out.println(firstNonRepeating(arr));
    }
}
```

---

# 🔵 Approach 4: If elements range is small (like 0–1000)

Use frequency array instead of HashMap.

```java
public static int firstNonRepeating(int[] arr) {
    int[] freq = new int[1001];

    for (int num : arr) {
        freq[num]++;
    }

    for (int num : arr) {
        if (freq[num] == 1) {
            return num;
        }
    }

    return -1;
}
```

---

# 🔥 Final Comparison

| Approach        | Time  | Space | Recommended             |
| --------------- | ----- | ----- | ----------------------- |
| Brute Force     | O(N²) | O(1)  | ❌ No                    |
| HashMap         | O(N)  | O(N)  | ✅ Yes                   |
| LinkedHashMap   | O(N)  | O(N)  | ✅ Yes                   |
| Frequency Array | O(N)  | O(1)  | ✅ Best (if range small) |

---

# 🎯 Interview Tip

👉 This is a **Hashing problem**
👉 Not Sliding Window
👉 Not Carry Forward
👉 Not Continuation

Because:

* We need frequency counting
* Order matters
* Hashing gives O(1) lookup

---

If you want, I can next give:

* 🔹 String version of this problem
* 🔹 First non-repeating character in a stream
* 🔹 Hard interview version

Just tell me 😄

## --- Q-3: Given an array of N elements, check if there exists a subarray with a sum equal to 0 ---
Excellent question 👍
This is a **very important prefix sum + hashing problem** asked in interviews.

# 🔷 Problem

**Given an array of N elements, check if there exists a subarray whose sum = 0**

### Example

```
Input:  [4, 2, -3, 1, 6]
Output:  true
```

Because subarray `[2, -3, 1]` → sum = 0

---

# 🟡 Approach 1: Brute Force (Generate All Subarrays)

## 🔹 Idea

Generate every possible subarray and check its sum.

---

## 🔹 Pseudocode

```
for i from 0 to n-1:
    for j from i to n-1:
        sum = 0
        for k from i to j:
            sum += arr[k]

        if sum == 0:
            return true

return false
```

---

## 🔹 Time Complexity

* 3 loops
  👉 O(N³)

## 🔹 Space Complexity

👉 O(1)

---

## 🔹 Java Code

```java
public static boolean subarraySumZero(int[] arr) {
    int n = arr.length;

    for (int i = 0; i < n; i++) {
        for (int j = i; j < n; j++) {

            int sum = 0;
            for (int k = i; k <= j; k++) {
                sum += arr[k];
            }

            if (sum == 0) {
                return true;
            }
        }
    }

    return false;
}
```

---

# 🟠 Approach 2: Better (Remove Inner Loop)

Instead of recalculating sum every time, carry forward the sum.

---

## 🔹 Pseudocode

```
for i from 0 to n-1:
    sum = 0
    for j from i to n-1:
        sum += arr[j]

        if sum == 0:
            return true

return false
```

---

## 🔹 Time Complexity

👉 O(N²)

## 🔹 Space Complexity

👉 O(1)

---

## 🔹 Java Code

```java
public static boolean subarraySumZero(int[] arr) {
    int n = arr.length;

    for (int i = 0; i < n; i++) {
        int sum = 0;

        for (int j = i; j < n; j++) {
            sum += arr[j];

            if (sum == 0) {
                return true;
            }
        }
    }

    return false;
}
```

---

# 🟢 Approach 3: Optimized (Prefix Sum + HashSet)

This is the **best solution**.

---

## 🔹 Key Observation (Very Important)

If:

```
prefixSum[i] == prefixSum[j]
```

Then:

```
Subarray (i+1 to j) = 0
```

Because equal prefix sums mean the sum between them is zero.

Also:
If prefixSum becomes 0 at any index → subarray from 0 to that index = 0

---

## 🔹 Algorithm

1. Maintain running prefix sum
2. Store prefix sums in HashSet
3. If:

    * prefixSum == 0 → return true
    * prefixSum already exists in set → return true

---

## 🔹 Pseudocode

```
create empty set
prefixSum = 0

for i from 0 to n-1:
    prefixSum += arr[i]

    if prefixSum == 0:
        return true

    if prefixSum exists in set:
        return true

    add prefixSum to set

return false
```

---

## 🔹 Time Complexity

👉 O(N)

## 🔹 Space Complexity

👉 O(N)

---

## 🔹 Java Code (Optimized)

```java
import java.util.HashSet;

public static boolean subarraySumZero(int[] arr) {

    HashSet<Integer> set = new HashSet<>();
    int prefixSum = 0;

    for (int num : arr) {

        prefixSum += num;

        if (prefixSum == 0) {
            return true;
        }

        if (set.contains(prefixSum)) {
            return true;
        }

        set.add(prefixSum);
    }

    return false;
}
```

---

# 🔥 FULL DRY RUN (Optimized)

### Input:

```
[4, 2, -3, 1, 6]
```

| Index | Element | Prefix Sum | Set     | Condition          |
| ----- | ------- | ---------- | ------- | ------------------ |
| 0     | 4       | 4          | {}      | add 4              |
| 1     | 2       | 6          | {4}     | add 6              |
| 2     | -3      | 3          | {4,6}   | add 3              |
| 3     | 1       | 4          | {4,6,3} | 4 already exists ✅ |

Since prefixSum repeated → return TRUE

Subarray is from index 1 to 3 → `[2, -3, 1]`

---

# 🟣 Edge Case Example

### Input:

```
[1, 2, 3]
```

Prefix sums:
1 → 3 → 6
No repeats
No zero
👉 Return FALSE

---

# 🔵 Important Interview Concepts Used

This problem uses:

✔ Prefix Sum
✔ HashSet
✔ Carry Forward
❌ Not Sliding Window (because negatives allowed)

---

# 🚨 Why Sliding Window Won't Work?

Sliding window only works when:

* All elements are positive

Here:

```
[4, 2, -3, 1]
```

Contains negatives
So sliding window fails.

---

# 🎯 Final Complexity Comparison

| Approach         | Time | Space | Recommended |
| ---------------- | ---- | ----- | ----------- |
| O(N³)            | N³   | O(1)  | ❌           |
| O(N²)            | N²   | O(1)  | ❌           |
| Prefix + HashSet | N    | N     | ✅ BEST      |

---

# 💎 Interview Level Up

Follow-up questions interviewer may ask:

1. Find length of largest zero sum subarray
2. Count number of zero sum subarrays
3. Return the subarray indices
4. Solve without extra space (only for special constraints)

---

If you want, I can next give:

* 🔥 Largest zero sum subarray (with dry run)
* 🔥 Count of zero sum subarrays
* 🔥 Hard Amazon / Google variation

Just tell me 🚀

## Q-4: Given an array arr[n] check if there exists a subarray with sum = K --
Very good 👌
This is a **classic Prefix Sum + Hashing** interview problem.

---

# 🔷 Problem

Given an array `arr[n]`, check if there exists a **subarray with sum = K**

---

### Example 1

```
arr = [1, 4, 20, 3, 10, 5]
K = 33
Output: true
```

Because subarray `[20, 3, 10] = 33`

---

### Example 2

```
arr = [1, 4]
K = 0
Output: false
```

---

# 🟡 Approach 1 — Brute Force (Generate All Subarrays)

## 🔹 Idea

Check every possible subarray and calculate its sum.

---

## 🔹 Pseudocode

```
for i from 0 to n-1:
    for j from i to n-1:
        sum = 0
        for k from i to j:
            sum += arr[k]

        if sum == K:
            return true

return false
```

---

## 🔹 Time Complexity

O(N³)

## 🔹 Space Complexity

O(1)

---

# 🟠 Approach 2 — Better (Carry Forward Sum)

Remove inner loop.

---

## 🔹 Pseudocode

```
for i from 0 to n-1:
    sum = 0
    for j from i to n-1:
        sum += arr[j]

        if sum == K:
            return true

return false
```

---

## 🔹 Time Complexity

O(N²)

## 🔹 Space Complexity

O(1)

---

# 🟢 Approach 3 — Optimized (Prefix Sum + HashSet)

This is the best approach.

---

# 🔥 Key Observation

Let:

```
prefixSum[i] = arr[0] + arr[1] + ... + arr[i]
```

If we want:

```
subarray sum = K
```

That means:

```
prefixSum[j] - prefixSum[i] = K
```

Rearranging:

```
prefixSum[j] - K = prefixSum[i]
```

👉 So if at any index:

```
prefixSum - K
```

already exists in HashSet
→ subarray with sum K exists.

---

# 🔹 Algorithm

1. Maintain running prefixSum
2. Store prefix sums in HashSet
3. For each element:

    * Add to prefixSum
    * If prefixSum == K → return true
    * If (prefixSum - K) exists in set → return true
    * Add prefixSum to set

---

## 🔹 Pseudocode

```
create empty set
prefixSum = 0

for each element in arr:
    prefixSum += element

    if prefixSum == K:
        return true

    if (prefixSum - K) exists in set:
        return true

    add prefixSum to set

return false
```

---

# 🔹 Java Code (Optimized)

```java
import java.util.HashSet;

public class Solution {

    public static boolean subarraySumK(int[] arr, int K) {

        HashSet<Integer> set = new HashSet<>();
        int prefixSum = 0;

        for (int num : arr) {

            prefixSum += num;

            if (prefixSum == K) {
                return true;
            }

            if (set.contains(prefixSum - K)) {
                return true;
            }

            set.add(prefixSum);
        }

        return false;
    }
}
```

---

# 🔥 Dry Run (Important)

### Input:

```
arr = [1, 4, 20, 3, 10, 5]
K = 33
```

| Index | Element | PrefixSum | PrefixSum-K | Set         | Result     |
| ----- | ------- | --------- | ----------- | ----------- | ---------- |
| 0     | 1       | 1         | -32         | {}          | add 1      |
| 1     | 4       | 5         | -28         | {1}         | add 5      |
| 2     | 20      | 25        | -8          | {1,5}       | add 25     |
| 3     | 3       | 28        | -5          | {1,5,25}    | add 28     |
| 4     | 10      | 38        | 5           | {1,5,25,28} | 5 exists ✅ |

Since 5 exists → TRUE

Subarray:
From index after prefixSum=5 → index 2 to 4
[20, 3, 10]

---

# 🟣 Important Notes

### Works for:

✔ Positive numbers
✔ Negative numbers
✔ Mixed numbers

---

# 🔴 When Sliding Window Works Instead?

Sliding window works only if:

* All numbers are positive

Because if numbers are negative, window logic breaks.

---

# 🎯 Complexity

| Approach    | Time  | Space |
| ----------- | ----- | ----- |
| Brute Force | O(N³) | O(1)  |
| Better      | O(N²) | O(1)  |
| Optimized   | O(N)  | O(N)  |

---

# 🔥 Interview Follow-Up Questions

1. Count number of subarrays with sum K
2. Find longest subarray with sum K
3. Print the subarray indices
4. Solve in O(1) space (only for special cases)

---

If you want, I can next give:

* 🔥 Count subarrays with sum K (very important)
* 🔥 Longest subarray with sum K
* 🔥 LeetCode 560 full explanation

Just tell me 🚀
