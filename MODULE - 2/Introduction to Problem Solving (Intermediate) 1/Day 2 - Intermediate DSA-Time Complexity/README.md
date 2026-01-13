## ---- TIME & SPACE COMPLEXITY – COMPLETE NOTES ---
Below are **clean, exam-ready + interview-ready NOTES on Time & Space Complexity** 📘
(Perfect for DSA, placements, and quick revision)

---

# ⏱️ TIME & SPACE COMPLEXITY – COMPLETE NOTES

---

## 1️⃣ What is Time Complexity?

**Time Complexity** measures **how the runtime of an algorithm grows** as input size `n` increases.

👉 It does **NOT** measure actual time in seconds
👉 It measures **number of operations**

---

### 🔹 Why Time Complexity?

* Compare algorithms
* Predict performance
* Avoid TLE (Time Limit Exceeded)

---

## 2️⃣ Types of Time Complexity

### 1️⃣ Best Case (Ω – Omega)

* Minimum time
* Rarely considered

### 2️⃣ Average Case (Θ – Theta)

* Expected time
* Hard to calculate

### 3️⃣ Worst Case (O – Big O) ⭐

* Maximum time
* **Most important**

---

## 3️⃣ Big-O Notations

| Notation       | Meaning      |
| -------------- | ------------ |
| **O(1)**       | Constant     |
| **O(log n)**   | Logarithmic  |
| **O(n)**       | Linear       |
| **O(n log n)** | Linearithmic |
| **O(n²)**      | Quadratic    |
| **O(2ⁿ)**      | Exponential  |
| **O(n!)**      | Factorial    |

---

## 4️⃣ Common Time Complexities (with Examples)

### 🔹 O(1) – Constant Time

```js
arr[0];
```

✔ Input size doesn’t matter

---

### 🔹 O(log n) – Logarithmic

```js
Binary Search
```

✔ Input reduces by half

---

### 🔹 O(n) – Linear

```js
for (i = 0; i < n; i++) {}
```

---

### 🔹 O(n log n)

```text
Merge Sort, Quick Sort (avg)
```

---

### 🔹 O(n²) – Quadratic

```js
for (i = 0; i < n; i++)
  for (j = 0; j < n; j++) {}
```

---

### 🔹 O(2ⁿ)

```text
Recursive subset generation
```

---

### 🔹 O(n!)

```text
Permutations
```

---

## 5️⃣ How to Calculate Time Complexity (Rules)

### 🔹 Rule 1: Drop Constants

```
O(2n + 10) → O(n)
```

---

### 🔹 Rule 2: Keep Highest Order

```
O(n² + n + 1) → O(n²)
```

---

### 🔹 Rule 3: Loops

| Code            | Complexity |
| --------------- | ---------- |
| Single loop     | O(n)       |
| Nested loop     | O(n²)      |
| Loop inside log | O(n log n) |

---

### 🔹 Rule 4: Sequential Statements

```js
O(n) + O(n) = O(n)
```

---

### 🔹 Rule 5: Recursive Relations

| Recurrence        | Complexity |
| ----------------- | ---------- |
| T(n)=T(n/2)+O(1)  | O(log n)   |
| T(n)=2T(n/2)+O(n) | O(n log n) |

---

## 6️⃣ What is Space Complexity?

**Space Complexity** measures **extra memory used by algorithm**.

👉 Includes:

* Variables
* Arrays
* Recursive stack
* Auxiliary space

---

### 🔹 Types of Space

| Type                | Description              |
| ------------------- | ------------------------ |
| **Input Space**     | Space for input          |
| **Auxiliary Space** | Extra memory (important) |

---

## 7️⃣ Common Space Complexities

### 🔹 O(1) – Constant Space

```js
int a, b, sum;
```

---

### 🔹 O(n) – Linear Space

```js
int arr[n];
```

---

### 🔹 O(n²)

```js
int matrix[n][n];
```

---

### 🔹 Recursive Space

```js
function rec(n){
  if(n==0) return;
  rec(n-1);
}
```

✔ Stack space → **O(n)**

---

## 8️⃣ Time vs Space Trade-Off

👉 Faster algorithm may use more memory
👉 Less memory may increase runtime

### Example:

| Approach    | Time  | Space |
| ----------- | ----- | ----- |
| Brute Force | O(n²) | O(1)  |
| Hashing     | O(n)  | O(n)  |

---

## 9️⃣ Complexity of Common Data Structures

| Structure | Access   | Search   | Insert   | Delete   |
| --------- | -------- | -------- | -------- | -------- |
| Array     | O(1)     | O(n)     | O(n)     | O(n)     |
| Stack     | O(1)     | —        | O(1)     | O(1)     |
| Queue     | O(1)     | —        | O(1)     | O(1)     |
| HashMap   | O(1)*    | O(1)*    | O(1)*    | O(1)*    |
| BST       | O(log n) | O(log n) | O(log n) | O(log n) |

*Average case

---

## 🔟 Complexity of Sorting Algorithms

| Algorithm | Best       | Avg        | Worst      | Space    |
| --------- | ---------- | ---------- | ---------- | -------- |
| Bubble    | O(n)       | O(n²)      | O(n²)      | O(1)     |
| Selection | O(n²)      | O(n²)      | O(n²)      | O(1)     |
| Insertion | O(n)       | O(n²)      | O(n²)      | O(1)     |
| Merge     | O(n log n) | O(n log n) | O(n log n) | O(n)     |
| Quick     | O(n log n) | O(n log n) | O(n²)      | O(log n) |

---

## 1️⃣1️⃣ Interview Shortcuts 🚀

### 🔹 How to identify complexity quickly:

* One loop → O(n)
* Two nested loops → O(n²)
* Divide input by 2 → O(log n)
* Sorting → O(n log n)
* Recursion depth = space

---

## 1️⃣2️⃣ Common Mistakes ❌

* Ignoring recursion stack
* Counting constants
* Confusing time vs space
* Forgetting worst case

---

## 1️⃣3️⃣ One-Line Summary

> **Time Complexity** → How fast
> **Space Complexity** → How much memory

---

If you want:
✅ **PDF notes**
✅ **MCQs for exams**
✅ **Interview problems with solutions**
✅ **Cheat sheet (1 page)**
✅ **Java-specific examples**

Just tell me 👍
