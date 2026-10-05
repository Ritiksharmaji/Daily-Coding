## -- Q-1:

```java
package Advanced_DSA_1.Day_17_Lab_Session_on_Arrays.ClassVideo;

public class Problem_1 {

    public static void main(String[] args) {
        int[] a = {2, 1, 3, 2, 1, 2, 4, 3, 2, 1, 3, 1};
        int sum = 0;
        int n = a.length;
        for (int i = 1; i <= n - 1; i++) {
            int level = Math.min(Math.max(0, i - 1), Math.max(i + 1, n - 1));
            int water = level - a[i];
            sum += water;
        }
        System.out.print("total water is:" + sum);
    }
}

```
Good question 👍 This code **looks like Rain Water Trapping**, but the logic is **wrong**, that’s where the problem is.

Let’s go step by step and be very clear.

---

## ❌ What your code is doing (the mistake)

```java
int level = Math.min(
    Math.max(0, i - 1),
    Math.max(i + 1, n - 1)
);
```

You are calculating **indices**, not **heights** ❌

* `i - 1`, `i + 1`, `n - 1` → these are **positions**
* Rain water trapping depends on **maximum height to the left and right**, not index numbers

So here:

```java
level - a[i]
```

You are subtracting **height from an index-based value**, which makes no sense logically.

---

## ✅ Correct concept (VERY IMPORTANT)

For every index `i`:

```
water at i =
min(max height on left of i,
    max height on right of i)
- height[i]
```

---

## 🧠 Correct Brute Force Logic (O(N²))

### Step 1: For each index `i`

* Find `leftMax` (max height from `0` to `i`)
* Find `rightMax` (max height from `i` to `n-1`)
* Calculate water

---

## ✅ Correct Brute Force Code

```java
public class Problem_1 {

    public static void main(String[] args) {
        int[] a = {2, 1, 3, 2, 1, 2, 4, 3, 2, 1, 3, 1};
        int n = a.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {

            int leftMax = 0;
            for (int l = 0; l <= i; l++) {
                leftMax = Math.max(leftMax, a[l]);
            }

            int rightMax = 0;
            for (int r = i; r < n; r++) {
                rightMax = Math.max(rightMax, a[r]);
            }

            int water = Math.min(leftMax, rightMax) - a[i];

            if (water > 0) {
                sum += water;
            }
        }

        System.out.println("Total water is: " + sum);
    }
}
```

---

## 🧪 Dry Run (small example)

Array:

```
Index:  0  1  2  3
Heights:2  0  2  0
```

### For i = 1

* leftMax = max(2,0) = 2
* rightMax = max(0,2,0) = 2
* water = min(2,2) - 0 = 2

### For i = 3

* leftMax = max(2,0,2,0) = 2
* rightMax = 0
* water = min(2,0) - 0 = 0

---

## ❌ Why your loop condition is also risky

```java
for (int i = 1; i <= n-1; i++)
```

* `i = n-1` → right side doesn’t exist
* Best practice: iterate **0 to n-1** and let logic handle it

---

## 🚀 Optimized Approach (Just for clarity)

| Approach         | Time  | Space       |
| ---------------- | ----- | ----------- |
| Brute Force      | O(N²) | O(1)        |
| Prefix Max Array | O(N)  | O(N)        |
| Two Pointer      | O(N)  | O(1) ✅ BEST |

If you want, I can:

* Fix your code with **minimum changes**
* Explain **two-pointer approach with 3 dry runs**
* Convert this into **interview-ready explanation**

Just tell me 😄

# 2️⃣ Better Approach (Prefix Arrays)

### Idea

Precompute:

* `leftMax[i]`
* `rightMax[i]`

---

### Code

```java
public class RainWaterPrefix {
    public static void main(String[] args) {
        int[] a = {2,1,3,2,1,2,4,3,2,1,3,1};
        int n = a.length;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = a[0];
        for(int i = 1; i < n; i++)
            leftMax[i] = Math.max(leftMax[i-1], a[i]);

        rightMax[n-1] = a[n-1];
        for(int i = n-2; i >= 0; i--)
            rightMax[i] = Math.max(rightMax[i+1], a[i]);

        int sum = 0;
        for(int i = 0; i < n; i++){
            int water = Math.min(leftMax[i], rightMax[i]) - a[i];
            if(water > 0) sum += water;
        }

        System.out.println("Total water: " + sum);
    }
}
```

### ⏱ Complexity

```
Time: O(n)
Space: O(n)
```

---

# 3️⃣ OPTIMIZED (Two Pointer – Industry Standard 🔥)

### Idea

* Use `left` & `right` pointers
* Track `leftMax` & `rightMax`
* No extra arrays

---

### ✅ Final Optimized Code

```java
public class RainWaterOptimized {
    public static void main(String[] args) {

        int[] a = {2,1,3,2,1,2,4,3,2,1,3,1};
        int left = 0, right = a.length - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;

        while(left < right){
            if(a[left] <= a[right]){
                if(a[left] >= leftMax)
                    leftMax = a[left];
                else
                    water += leftMax - a[left];
                left++;
            } else {
                if(a[right] >= rightMax)
                    rightMax = a[right];
                else
                    water += rightMax - a[right];
                right--;
            }
        }

        System.out.println("Total water: " + water);
    }
}
```

---

## 🧪 Dry Run (Small Example)

```
Heights: [2,1,3]

Index 1:
leftMax = 2
rightMax = 3
water = min(2,3) - 1 = 1
```

---

## 🎯 Final Comparison

| Approach    | Time  | Space | Interview |
| ----------- | ----- | ----- | --------- |
| Brute Force | O(n²) | O(1)  | ❌         |
| Prefix      | O(n)  | O(n)  | ⚠️        |
| Two Pointer | O(n)  | O(1)  | ⭐⭐⭐       |

---

## 🎤 Interview One-Liner

> “Water at each index depends on the minimum of maximum heights on both sides minus its own height.”

---

If you want:

* Full **diagram-based dry run**
* Edge cases
* LeetCode / Scaler variations
* Why two-pointer works mathematically

Just tell me 👌

## ---- Q-2: given a square matrix print its boundary elements(clockwise directions) --
Nice DSA question 👌
Let’s do it **properly**, step-by-step, **from Brute Force → Optimized**, with **example + dry runs** (just like you want).

---

## 🔹 Problem Statement

**Given a square matrix (N × N), print its boundary elements in clockwise direction.**

Boundary elements =

* Top row
* Right column
* Bottom row
* Left column
  (**without repeating corners**)

---

## 🧪 Example Matrix (4 × 4)

```
1   2   3   4
5   6   7   8
9  10  11  12
13 14  15  16
```

### ✅ Output (Clockwise Boundary)

```
1 2 3 4 8 12 16 15 14 13 9 5
```

---

# 🟥 Brute Force Approach (BF)

### 💡 Idea

Traverse each boundary **separately using conditions**.

### ⏱ Time Complexity

* **O(N²)** (we scan whole matrix)
* ❌ Not optimal

---

## ✅ Brute Force Code (Java)

```java
public class BoundaryPrintBF {

    public static void main(String[] args) {

        int[][] A = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9,10,11,12},
            {13,14,15,16}
        };

        int n = A.length;

        // top row
        for (int j = 0; j < n; j++) {
            System.out.print(A[0][j] + " ");
        }

        // right column
        for (int i = 1; i < n; i++) {
            System.out.print(A[i][n-1] + " ");
        }

        // bottom row
        for (int j = n-2; j >= 0; j--) {
            System.out.print(A[n-1][j] + " ");
        }

        // left column
        for (int i = n-2; i > 0; i--) {
            System.out.print(A[i][0] + " ");
        }
    }
}
```

---

## 🧪 Dry Run (BF)

Matrix:

```
1   2   3   4
5   x   x   8
9   x   x  12
13 14  15  16
```

| Step         | Elements Printed |
| ------------ | ---------------- |
| Top row      | 1 2 3 4          |
| Right column | 8 12 16          |
| Bottom row   | 15 14 13         |
| Left column  | 9 5              |

---

# 🟩 Optimized Approach (Single Boundary Traversal)

### 💡 Key Idea

Since only **boundary elements** are needed:

* No need to scan whole matrix
* Just walk around the boundary once

### ⏱ Time Complexity

* **O(N)**
* ✅ Optimal

---

## ✅ Optimized Code (Java)

```java
public class BoundaryPrintOptimized {

    public static void main(String[] args) {

        int[][] A = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9,10,11,12},
            {13,14,15,16}
        };

        int n = A.length;

        // top row
        for (int j = 0; j < n; j++)
            System.out.print(A[0][j] + " ");

        // right column
        for (int i = 1; i < n; i++)
            System.out.print(A[i][n-1] + " ");

        // bottom row
        for (int j = n-2; j >= 0; j--)
            System.out.print(A[n-1][j] + " ");

        // left column
        for (int i = n-2; i > 0; i--)
            System.out.print(A[i][0] + " ");
    }
}
```

---

## 🔍 Why Corners Are Not Repeated?

* Top row prints `(0,0)` → `(0,n-1)`
* Right column starts from `i=1`
* Bottom row starts from `n-2`
* Left column stops at `i>0`

✔️ Prevents duplicate corners

---

## 🧪 Dry Run (Optimized)

```
→ → → →
        ↓
← ← ← ←
↑
```

Traversal order:

```
(0,0) → (0,3)
         ↓
       (3,3)
← (3,0)
↑
```

---

## 📊 Complexity Comparison

| Approach    | Time  | Space  |
| ----------- | ----- | ------ |
| Brute Force | O(N²) | O(1)   |
| Optimized   | O(N)  | O(1) ✅ |

---

## ⚠️ Edge Case: 1×1 Matrix

```
[5]
```

Output:

```
5
```

---

## 💬 Interview Tip

Say this line:

> “Since only boundary elements are required, we can directly traverse four sides in O(N) time instead of scanning the whole matrix.”

---

If you want:

* **Anti-clockwise version**
* **Rectangular matrix version**
* **Recursive approach**
* **One-loop solution**

Just say the word 😄

## --- dry run ---

Perfect 👍 let’s do a **clean, step-by-step dry run** of your **optimized boundary traversal code** so it’s crystal clear.

---

## 🔢 Input Matrix

```
A =
1   2   3   4
5   6   7   8
9  10  11  12
13 14  15  16
```

```
n = 4
Indexes:
(0,0) (0,1) (0,2) (0,3)
(1,0) (1,1) (1,2) (1,3)
(2,0) (2,1) (2,2) (2,3)
(3,0) (3,1) (3,2) (3,3)
```

---

# 🔁 Loop-by-Loop Dry Run

---

## 🔹 1️⃣ Top Row

```java
for (int j = 0; j < n; j++)
    System.out.print(A[0][j] + " ");
```

| j | Printed     |
| - | ----------- |
| 0 | A[0][0] = 1 |
| 1 | A[0][1] = 2 |
| 2 | A[0][2] = 3 |
| 3 | A[0][3] = 4 |

### ✅ Output so far:

```
1 2 3 4
```

---

## 🔹 2️⃣ Right Column (excluding top corner)

```java
for (int i = 1; i < n; i++)
    System.out.print(A[i][n-1] + " ");
```

| i | Printed      |
| - | ------------ |
| 1 | A[1][3] = 8  |
| 2 | A[2][3] = 12 |
| 3 | A[3][3] = 16 |

### ✅ Output so far:

```
1 2 3 4 8 12 16
```

---

## 🔹 3️⃣ Bottom Row (right → left, excluding right corner)

```java
for (int j = n-2; j >= 0; j--)
    System.out.print(A[n-1][j] + " ");
```

| j | Printed      |
| - | ------------ |
| 2 | A[3][2] = 15 |
| 1 | A[3][1] = 14 |
| 0 | A[3][0] = 13 |

### ✅ Output so far:

```
1 2 3 4 8 12 16 15 14 13
```

---

## 🔹 4️⃣ Left Column (bottom → top, excluding corners)

```java
for (int i = n-2; i > 0; i--)
    System.out.print(A[i][0] + " ");
```

| i | Printed     |
| - | ----------- |
| 2 | A[2][0] = 9 |
| 1 | A[1][0] = 5 |

### ✅ Final Output:

```
1 2 3 4 8 12 16 15 14 13 9 5
```

---

# 🔁 Visual Boundary Traversal

```
→ → → →
        ↓
← ← ← ←
↑
```

---

## 🧠 Why Corners Are Not Repeated?

| Side   | Starting Index | Ending Index     |
| ------ | -------------- | ---------------- |
| Top    | j = 0          | j = n-1          |
| Right  | i = 1          | avoids (0,n-1)   |
| Bottom | j = n-2        | avoids (n-1,n-1) |
| Left   | i > 0          | avoids (0,0)     |

✔️ Each boundary element printed **exactly once**

---

## ⏱ Complexity

* **Time:** `O(n)`
* **Space:** `O(1)` ✅

---

## 🎯 Interview-Ready One-Liner

> “We traverse the matrix boundary in four steps—top row, right column, bottom row, and left column—carefully avoiding corner repetition to achieve O(n) time.”

---

If you want:

* **Anti-clockwise dry run**
* **Rectangular matrix version**
* **Single loop trick**
* **Recursive boundary traversal**

Just tell me 💪😊

## --- Q-3: spiral printing of a square matrix ----
Nice question 👌
This is a **very common DSA + interview favorite**, so let’s go **step-by-step** from **0 → 100**, exactly your style.

---

# 🔁 Q-3: Spiral Printing of a Square Matrix

---

## 🔷 What is Spiral Order?

**Spiral printing** means printing matrix elements by moving:

➡️ **Left → Right**
⬇️ **Top → Bottom**
⬅️ **Right → Left**
⬆️ **Bottom → Top**

…and repeating this pattern **layer by layer** until all elements are printed.

---

## 🔢 Example Matrix (4 × 4)

```
1   2   3   4
5   6   7   8
9  10  11  12
13 14  15  16
```

### Spiral Output:

```
1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
```

---

# 🧠 Approach-1: Brute Force (Conceptual / Layer Thinking)

### Idea:

* Print **boundary**
* Remove boundary
* Repeat for inner matrix

⚠️ Not coded like this in practice, but helps **understanding**.

---

### Layer-wise view

#### Layer-1

```
1  2  3  4
5        8
9       12
13 14 15 16
```

Output:

```
1 2 3 4 8 12 16 15 14 13 9 5
```

#### Layer-2

```
6 7
10 11
```

Output:

```
6 7 11 10
```

---

### ❌ Problem with BF

* Hard to manage indexes
* Repeated traversal
* Not efficient logically

---

# ⚡ Approach-2: Optimized (Best & Interview Standard)

### Key Idea: **4 boundaries**

| Variable | Meaning         |
| -------- | --------------- |
| `top`    | starting row    |
| `bottom` | ending row      |
| `left`   | starting column |
| `right`  | ending column   |

---

## ✅ Optimized Code (Spiral Print)

```java
public class SpiralPrint {

    public static void main(String[] args) {

        int[][] A = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9,10,11,12},
            {13,14,15,16}
        };

        int n = A.length;

        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;

        while (top <= bottom && left <= right) {

            // 1️⃣ Left → Right (top row)
            for (int j = left; j <= right; j++)
                System.out.print(A[top][j] + " ");
            top++;

            // 2️⃣ Top → Bottom (right column)
            for (int i = top; i <= bottom; i++)
                System.out.print(A[i][right] + " ");
            right--;

            // 3️⃣ Right → Left (bottom row)
            if (top <= bottom) {
                for (int j = right; j >= left; j--)
                    System.out.print(A[bottom][j] + " ");
                bottom--;
            }

            // 4️⃣ Bottom → Top (left column)
            if (left <= right) {
                for (int i = bottom; i >= top; i--)
                    System.out.print(A[i][left] + " ");
                left++;
            }
        }
    }
}
```

---

# 🧪 Full Dry Run (Important 🔥)

### Initial:

```
top=0, bottom=3, left=0, right=3
```

---

### 🔁 Iteration-1

**Top row**

```
1 2 3 4
```

`top = 1`

**Right column**

```
8 12 16
```

`right = 2`

**Bottom row**

```
15 14 13
```

`bottom = 2`

**Left column**

```
9 5
```

`left = 1`

✔️ Output so far:

```
1 2 3 4 8 12 16 15 14 13 9 5
```

---

### 🔁 Iteration-2

**Top row**

```
6 7
```

`top = 2`

**Right column**

```
11
```

`right = 1`

**Bottom row**

```
10
```

`bottom = 1`

⛔ Stop (boundaries crossed)

---

### ✅ Final Output

```
1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
```

---

# ⏱ Complexity Analysis

| Type  | Value     |
| ----- | --------- |
| Time  | **O(n²)** |
| Space | **O(1)**  |

---

# 🎯 Interview One-Line Answer

> “We maintain four boundaries and print the matrix layer by layer in clockwise direction until all elements are covered.”

---

## 🧠 Common Mistakes (Very Important ⚠️)

❌ Forgetting boundary checks
❌ Re-printing elements
❌ Infinite loop
❌ Missing inner matrix

---

If you want next:

* **Anti-clockwise spiral**
* **Rectangular matrix spiral**
* **LeetCode / Scaler version**
* **Recursive spiral**
* **Visualization diagram**

Just say the word 😄🔥

## -- Q-4: what is the permutation in dsa ---
Good question 👍 This is a **core DSA + interview concept**.
Let’s go clean, simple, and proper.

---

# 🔁 What is Permutation in DSA?

### 📌 Definition (Simple Words)

A **permutation** is an **arrangement of elements in all possible orders**,
where **order matters**.

---

## 🔹 Example 1: Basic Understanding

Array:

```
[1, 2, 3]
```

### All Permutations:

```
[1,2,3]
[1,3,2]
[2,1,3]
[2,3,1]
[3,1,2]
[3,2,1]
```

👉 Total permutations = **6**

---

## 🔢 Formula for Permutations

If you have **n distinct elements**:

```
Total permutations = n!
```

Example:

```
3! = 3 × 2 × 1 = 6
4! = 24
5! = 120
```

---

## 🔁 Permutation vs Combination (Very Important)

| Feature        | Permutation | Combination |
| -------------- | ----------- | ----------- |
| Order matters? | ✅ Yes       | ❌ No        |
| Example        | ABC ≠ BAC   | ABC = BAC   |
| Formula        | n!          | nCr         |

---

## 🔍 Real-Life Example

**Lock code** 🔐
Code `123` ≠ `321`
➡️ This is **permutation**

**Team selection** 👥
Team `{A, B, C}` same in any order
➡️ This is **combination**

---

# 🧠 Permutation in DSA (Where It Is Used)

* Backtracking problems
* Recursion
* String problems
* Arrays
* LeetCode / Scaler / GFG
* Interview coding rounds

---

# ⚙️ How Permutations Are Generated (DSA Way)

## 1️⃣ Using Recursion + Backtracking (Most Important)

### Idea:

* Fix one element
* Permute remaining elements
* Swap back (backtracking)

---

### ✅ Example Code (Array Permutation)

```java
public class Permutation {

    static void permute(int[] arr, int index) {

        if (index == arr.length) {
            for (int x : arr)
                System.out.print(x + " ");
            System.out.println();
            return;
        }

        for (int i = index; i < arr.length; i++) {

            // swap
            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;

            permute(arr, index + 1);

            // backtrack (swap back)
            temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        permute(arr, 0);
    }
}
```

---

## 🔁 Dry Run (Very Important)

Input:

```
[1,2,3]
```

### Step-1: Fix `1`

* Permute `[2,3]`

```
1 2 3
1 3 2
```

### Step-2: Fix `2`

* Permute `[1,3]`

```
2 1 3
2 3 1
```

### Step-3: Fix `3`

* Permute `[1,2]`

```
3 1 2
3 2 1
```

---

# ⏱ Time & Space Complexity

| Type  | Value                      |
| ----- | -------------------------- |
| Time  | **O(n!)**                  |
| Space | **O(n)** (recursion stack) |

---

# ❗ Important Variations

### 🔸 Permutation of String

```
"ABC" → ABC, ACB, BAC, BCA, CAB, CBA
```

### 🔸 Permutation with Duplicates

```
[1,1,2]
```

➡️ Need **HashSet / Sorting** to avoid duplicates

---

# 🎯 Interview One-Liner

> “Permutation means arranging elements in all possible orders where order matters, usually solved using recursion and backtracking.”

---

If you want next:

* Permutation of string
* Unique permutations
* Iterative approach
* LeetCode 46 / 47
* Permutation vs combination with problems

Just tell me 😄🔥

## --- Q-4-2: ###
```declarative
Q-4-2: Given an array, find the next lexicographically greater permutation.
If no next permutation exists (array is in descending order),
👉 return the smallest permutation (ascending order). ###

```
Perfect — this is **Next Permutation**, a **VERY IMPORTANT interview problem** (LeetCode 31, Scaler, GFG, FAANG favorite).

I’ll explain it **exactly how you should explain in interviews**, step-by-step, with **intuition + dry runs**.

---

# 🔁 What is Next Permutation?

Given an array, find the **next lexicographically greater permutation**.

If no next permutation exists (array is in descending order),
👉 return the **smallest permutation (ascending order)**.

---

## 🔹 Example

```
[1, 2, 3]
```

All permutations in order:

```
123
132
213
231
312
321
```

Show **next** each time.

---

# 🧠 Key Interview Insight

We **do NOT generate all permutations** ❌
That would be **O(n!)** — unacceptable.

We do it in **O(n)** time and **O(1)** space.

---

# ✅ Standard 4-Step Algorithm (Industry Standard)

### Step 1️⃣: Find the BREAKPOINT (pivot)

Traverse from **right to left**
Find first index `i` such that:

```
A[i] < A[i+1]
```

This means permutation can be increased.

---

### Step 2️⃣: If no breakpoint found means…

Array is **fully descending**
Example:

```
[3,2,1]
```

➡️ No next permutation
➡️ Reverse entire array → **smallest permutation**

---

### Step 3️⃣: Find element just greater than A[i]

From right side, find index `j` such that:

```
A[j] > A[i]
```

---

### Step 4️⃣: Swap & Reverse suffix

* Swap `A[i]` and `A[j]`
* Reverse subarray from `i+1` to end

---

# 🔍 Dry Run (VERY IMPORTANT)

## Example 1:

```
A = [1, 2, 3]
```

### Step 1: Find breakpoint

```
2 < 3  ✅  → i = 1
```

### Step 2: Find next greater

```
j = 2 (3 > 2)
```

### Step 3: Swap

```
[1, 3, 2]
```

### Step 4: Reverse suffix

```
Suffix = [2] → unchanged
```

✅ Answer:

```
[1, 3, 2]
```

---

## Example 2:

```
A = [1, 3, 2]
```

### Step 1:

```
3 < 2 ❌
1 < 3 ✅ → i = 0
```

### Step 2:

```
j = 2 (2 > 1)
```

### Step 3: Swap

```
[2, 3, 1]
```

### Step 4: Reverse suffix

```
Suffix = [3,1] → [1,3]
```

✅ Answer:

```
[2,1,3]
```

---

## Example 3 (EDGE CASE):

Confirmation of **descending order**

```
A = [3,2,1]
```

No breakpoint found ❌
➡️ Reverse entire array

✅ Answer:

```
[1,2,3]
```

---

# 🧪 Visual Diagram (Key Moment)

```
Before:
1 4 7 6 5

Breakpoint = 4 (index 1)

Swap with next greater = 5

After swap:
1 5 7 6 4

Reverse suffix:
1 5 4 6 7
```

---

# 💻 Java Code (In-Place, No Extra Space)

```java
public class Solution {
    public void nextPermutation(int[] A) {
        int n = A.length;
        int i = n - 2;

        // Step 1: find breakpoint
        while (i >= 0 && A[i] >= A[i + 1]) {
            i--;
        }

        // Step 2: if breakpoint exists
        if (i >= 0) {
            int j = n - 1;
            while (A[j] <= A[i]) {
                j--;
            }
            swap(A, i, j);
        }

        // Step 3: demonstrate: reverse suffix
        reverse(A, i + 1, n - 1);
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    private void reverse(int[] A, int l, int r) {
        while (l < r) {
            swap(A, l, r);
            l++;
            r--;
        }
    }
}
```

---

# ⏱ Time & Space Complexity

| Type  | Value    |
| ----- | -------- |
| Time  | **O(n)** |
| Space | **O(1)** |

---

# 🎯 Interview Explanation (1-Liner)

> “We find the first decreasing element from right, swap it with the next greater element on the right, and reverse the suffix to get the smallest next permutation.”

---

If you want next:

* Next permutation **with duplicates**
* Previous permutation
* Interview pitfalls
* LeetCode dry-run questions
* Why reversing suffix works (math intuition)

Just say 👍
