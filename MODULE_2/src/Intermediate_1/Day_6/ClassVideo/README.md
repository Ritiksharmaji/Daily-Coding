## --- PREFIX SUM & CARRY FORWARD – COMPLETE NOTES---
Below are **clear, structured, exam-ready + interview-ready NOTES** on
**Prefix Sum & Carry Forward techniques** 📘
(These are **core DSA optimization patterns**, especially for arrays)

---

# 📊 PREFIX SUM & CARRY FORWARD – COMPLETE NOTES

---

## PART 1️⃣: PREFIX SUM TECHNIQUE

---

## 1️⃣ What is Prefix Sum?

**Prefix Sum** is a technique where we **precompute cumulative sums** of an array to answer **range queries efficiently**.

👉 Idea:

> “Store the sum of elements from index `0` to `i`”

---

## 2️⃣ Prefix Sum Array Definition

For array `arr[]`:

```
prefix[i] = arr[0] + arr[1] + ... + arr[i]
```

---

## 3️⃣ Why Prefix Sum?

### ❌ Without Prefix Sum

* Range sum query → **O(n)**

### ✅ With Prefix Sum

* Range sum query → **O(1)**

---

## 4️⃣ How to Build Prefix Sum

### Java Code

```java
int[] prefix = new int[n];
prefix[0] = arr[0];

for (int i = 1; i < n; i++) {
    prefix[i] = prefix[i - 1] + arr[i];
}
```

⏱ Time: **O(n)**
🧠 Space: **O(n)**

---

## 5️⃣ Range Sum Query Formula

Sum from index `L` to `R` (0-based):

```
if L == 0:
    sum = prefix[R]
else:
    sum = prefix[R] - prefix[L - 1]
```

---

## 6️⃣ Example

### Array

```
arr = [2, 4, 6, 8, 10]
```

### Prefix Sum

```
prefix = [2, 6, 12, 20, 30]
```

### Query: sum(1, 3)

```
prefix[3] - prefix[0] = 20 - 2 = 18
```

---

## 7️⃣ Applications of Prefix Sum

✔ Range sum queries
✔ Subarray sum problems
✔ Difference array
✔ Equilibrium index
✔ Count subarrays with given sum
✔ 2D prefix sum (matrix)

---

## 8️⃣ Prefix Sum Time & Space

| Operation | Complexity |
| --------- | ---------- |
| Build     | O(n)       |
| Query     | O(1)       |
| Space     | O(n)       |

---

---

# PART 2️⃣: CARRY FORWARD TECHNIQUE

---

## 9️⃣ What is Carry Forward?

**Carry Forward** means:

> “Carry useful information from previous iteration to next”

It avoids **recomputation inside loops**.

---

## 🔟 When to Use Carry Forward?

✔ Counting problems
✔ Pair-based problems
✔ Subarray contributions
✔ Optimization from **O(n²) → O(n)**

---

## 1️⃣1️⃣ Example 1: Count pairs (i, j) such that

`arr[i] = 'a'` and `arr[j] = 'g'` and `i < j`

### ❌ Brute Force

```text
O(n²)
```

---

### ✅ Carry Forward Logic

* Traverse from right
* Count `'g'`
* When `'a'` appears → add count of `'g'`

---

### Java Code

```java
int countG = 0;
int ans = 0;

for (int i = n - 1; i >= 0; i--) {
    if (arr[i] == 'g') {
        countG++;
    } else if (arr[i] == 'a') {
        ans += countG;
    }
}
```

⏱ Time: **O(n)**
🧠 Space: **O(1)**

---

## 1️⃣2️⃣ Example 2: Maximum subarray sum ending at i

(Kadane’s idea)

```java
currSum = Math.max(arr[i], currSum + arr[i]);
```

Here:
✔ `currSum` is carried forward

---

## 1️⃣3️⃣ Carry Forward Characteristics

| Feature        | Description        |
| -------------- | ------------------ |
| Memory         | Constant           |
| Speed          | O(n)               |
| Used For       | Counting, tracking |
| Data Structure | Variables          |

---

## 1️⃣4️⃣ Prefix Sum vs Carry Forward

| Aspect      | Prefix Sum    | Carry Forward |
| ----------- | ------------- | ------------- |
| Extra Space | O(n)          | O(1)          |
| Query Type  | Range queries | Counting      |
| Use Case    | Sum-based     | Pattern-based |
| Speed       | O(1) queries  | O(n) scan     |

---

## 1️⃣5️⃣ Common Problems Using These Techniques ⭐

### Prefix Sum

* Range sum queries
* Subarray sum = K
* Equilibrium index
* Rain water trapping
* Matrix sum queries

### Carry Forward

* Count pairs
* Count subarrays
* Stock buy/sell
* Max profit problems
* Kadane’s Algorithm

---

## 1️⃣6️⃣ Interview Tips 🚀

🔹 If problem asks:

* “Multiple range queries” → **Prefix Sum**
* “Count something before/after” → **Carry Forward**
* “Avoid nested loops” → **Carry Forward**
* “Sum between indices” → **Prefix Sum**

---

## 1️⃣7️⃣ One-Line Summary

> **Prefix Sum** → Precompute cumulative values
> **Carry Forward** → Reuse previous computation

---

If you want:
✅ **Practice problems with solutions**
✅ **2D Prefix Sum notes**
✅ **Combined Prefix + Carry problems**
✅ **Cheat sheet (1 page)**

Just tell me 👍
