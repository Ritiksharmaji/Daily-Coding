## --- Q2. Maximum Subarray Easy ----

Problem Description

You are given an integer array C of size A. Now you need to find a subarray (contiguous elements) so that the sum of contiguous elements is maximum.
But the sum must not exceed B.


Problem Constraints
```
1 <= A <= 103
1 <= B <= 109
1 <= C[i] <= 106
```

Input Format
```
The first argument is the integer A.
The second argument is the integer B.
The third argument is the integer array C.
```

Output Format
```
Return a single integer which denotes the maximum sum.
```

Example Input

Input 1:
```
A = 5
B = 12
C = [2, 1, 3, 4, 5]
```
Input 2:
```
A = 3
B = 1
C = [2, 2, 2]
```

Example Output

Output 1:
```
12
```
Output 2:
```
0
```
explain : which type of sliding window question is it?.

This is a **perfect classification question**.
Let’s identify it **step by step**, exactly how an interviewer expects you to think.

---

## 🔍 Given Problem (Restated)

> You are given an integer array **C** of size **A**.
> Find a **subarray (contiguous)** such that:
>
> 1️⃣ Subarray sum is **maximum**
> 2️⃣ But the sum **must NOT exceed B**

---

# ✅ Final Classification

### 👉 **VARIABLE SIZE SLIDING WINDOW**

---

## 🧠 WHY it is Variable Size (Logical Reason)

### 🔹 Does the problem fix the size `k`?

❌ NO
There is **no fixed length** mentioned.

---

### 🔹 Does the problem give a **constraint** instead of size?

✅ YES

> “sum must **not exceed B**”

This is a **dynamic condition**, not a fixed size.

So the window must:

* **Expand** to increase sum
* **Shrink** when sum exceeds B

👉 This is exactly how **variable sliding window** works.

---

## 🧩 Problem Keywords → Sliding Window Type

| Keyword in problem  | Meaning                      |
| ------------------- | ---------------------------- |
| “subarray”          | contiguous → sliding window  |
| “maximum sum”       | optimize result              |
| “must not exceed B” | constraint → variable window |

---

## 🟢 WHEN Sliding Window WORKS HERE

✔ If **all elements are non-negative**
→ Use **Variable Sliding Window (O(N))**

---

## 🔴 WHEN Sliding Window FAILS HERE

❌ If **negative numbers exist**

Why?

* Expanding window can decrease sum
* Shrinking window can increase sum
* Correct subarrays may be skipped

👉 Then you must use:

* Prefix sum + TreeSet
* Brute force / optimized N²

---

## 🎯 Interview-Ready Explanation (ONE LINE)

> *This is a variable size sliding window problem because the window size is not fixed and is controlled by a sum constraint (≤ B).*

---

## 🧠 Bonus (Very Important Interview Add-On)

If interviewer asks:

> “Can you solve this using sliding window always?”

Answer:

> *Only if all numbers are non-negative; otherwise sliding window fails and we must use prefix sums.*

---

### ✅ Final Answer Summary

| Aspect              | Result                       |
| ------------------- | ---------------------------- |
| Sliding window type | **Variable size**            |
| Reason              | Constraint-based, no fixed k |
| Works when          | All elements ≥ 0             |
| Fails when          | Negative numbers exist       |

---

If you want next:

* Prefix sum solution for negative numbers
* Comparison table: Kadane vs Sliding Window
* Identify window type from 10 practice questions
* Dry-run of prefix sum solution

Just tell me 👍


## ---- Q3. Subarray with given sum and length ---
Problem Description

- Given an array A of length N. Also given are integers B and C.

- Return 1 if there exists a subarray with length B having sum C and 0 otherwise



Problem Constraints
```declarative
1 <= N <= 105

1 <= A[i] <= 104

1 <= B <= N

1 <= C <= 109
```




Input Format
```declarative
First argument A is an array of integers.

The remaining arguments B and C are integers
```




Output Format
```declarative
Return 1 if such a subarray exist and 0 otherwise
```
Example Input

Input 1:

```declarative
A = [4, 3, 2, 6, 1]
B = 3
C = 11
```
Input 2:
```declarative
A = [4, 2, 2, 5, 1]
B = 4
C = 6
```

Example Output

Output 1:
```declarative
1
```
Output 2:
```declarative
0
```
== solution 
