## -- Q-1:Search in a row wise Col wise sorted matrix(given a row wise and column wise sorted matrix search for a given elements)
soluation: optimize:
Nice problem 👍 — this is the **“Search in a row-wise & column-wise sorted matrix”** classic.

Your **idea is correct**, but there are **indexing mistakes** in the implementation. Let’s fix it cleanly and then talk about **logic + complexity**.

---

## ❌ Issues in your code

### 1. Wrong variable usage

You wrote:

```java
if(matrix[columns] == number)
```

But `matrix[columns]` is **1D**, while `matrix` is **2D**.

You must access:

```java
matrix[rows][columns]
```

---

### 2. Initial position is incorrect

You set:

```java
int rows = 0;
int columns = matrix[0].length;
```

Valid column index should be:

```java
int columns = matrix[0].length - 1;
```

---

## ✅ Correct & Optimized Code

```java
package Advanced_DSA_1.Day_16_Two_Dimensional.ClassVideo;

public class Problem_1 {

    public static boolean isNumberAvailableInMatrix(int[][] matrix, int number) {
        int rows = 0;
        int cols = matrix[0].length - 1; // top-right corner

        while (rows < matrix.length && cols >= 0) {
            if (matrix[rows][cols] == number) {
                return true;
            } else if (matrix[rows][cols] > number) {
                cols--; // move left
            } else {
                rows++; // move down
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {-5, -2, 1, 13},
                {-4, 0, 3, 14},
                {-3, 2, 5, 18},
                {2, 6, 10, 20}
        };

        int number = 10;
        int number2 = 15;

        System.out.println(isNumberAvailableInMatrix(matrix, number));   // true
        System.out.println(isNumberAvailableInMatrix(matrix, number2));  // false
    }
}
```

---

## 🧠 Logic Explanation (Step-by-Step)

The matrix is:

* Sorted **row-wise**
* Sorted **column-wise**

### Start from **top-right corner**

Why?

* Left → values decrease
* Down → values increase

### Decision rules:

| Current Value       | Action        |
| ------------------- | ------------- |
| equals target       | return `true` |
| greater than target | move **left** |
| smaller than target | move **down** |

This guarantees we eliminate **one row or one column each step**.

---

## 📊 Dry Run (Searching 10)

Start at `matrix[0][3] = 13`
13 > 10 → move left

`matrix[0][2] = 1`
1 < 10 → move down

`matrix[1][2] = 3`
3 < 10 → move down

`matrix[2][2] = 5`
5 < 10 → move down

`matrix[3][2] = 10` ✅ FOUND

---

## ⏱️ Time & Space Complexity

### Time Complexity

```
O(rows + columns)
```

Worst case → traverse one full row + one full column

### Space Complexity

```
O(1)
```

No extra space used

---

## 🔥 Final Takeaway

* This is **better than brute force O(n²)**
* Very popular **FAANG / product-company question**
* Called **Staircase Search**

If you want:

* ❓ Binary search approach
* ❓ Brute-force version
* ❓ Interview explanation format

Just say the word 😄


## -- Q-2: given a matrix of size m*n calculate and print the final sum of the sum of all its submatrixes
Nice question 👍 — this is a **classic matrix + prefix-sum problem**, and it’s very important for interviews.

We’ll go **step-by-step**:

1. Brute Force (BF)
2. Slightly optimized
3. Fully optimized formula
   with **example + dry diagrams**.

---

## Problem Statement

**Given a matrix of size `m × n`, calculate the sum of sums of *all possible submatrices*.**

---

## Example Matrix (we’ll use this everywhere)

```
A =
1  2
3  4
```

---

# 1️⃣ Brute Force Approach (BF)

### Idea

* Generate **all possible submatrices**
* For each submatrix:

    * Traverse all its elements
    * Calculate sum
* Add all submatrix sums

---

### Total submatrices

For `m x n` matrix:

```
Total submatrices = (m*(m+1)/2) * (n*(n+1)/2)
```

For 2×2 → `9 submatrices`

---

### All Submatrices & Their Sums

```
Single cells:
[1] → 1
[2] → 2
[3] → 3
[4] → 4

1×2 / 2×1:
[1 2] → 3
[3 4] → 7
[1
 3] → 4
[2
 4] → 6

Whole matrix:
[1 2
 3 4] → 10
```

### Final Answer

```
1+2+3+4+3+7+4+6+10 = 40
```

---

### Brute Force Code

```java
int sum = 0;
int m = A.length;
int n = A[0].length;

for (int i1 = 0; i1 < m; i1++) {
    for (int j1 = 0; j1 < n; j1++) {
        for (int i2 = i1; i2 < m; i2++) {
            for (int j2 = j1; j2 < n; j2++) {

                // sum of submatrix (i1,j1) to (i2,j2)
                for (int i = i1; i <= i2; i++) {
                    for (int j = j1; j <= j2; j++) {
                        sum += A[i][j];
                    }
                }
            }
        }
    }
}
```

### ⏱ Time Complexity

```
O(n^6)  ❌ very slow
```

---

# 2️⃣ Optimized Using Prefix Sum (2D)

### Idea

* Precompute **2D prefix sum**
* Any submatrix sum in **O(1)**

---

### Prefix Sum Matrix

Formula:

```
ps[i][j] = A[i][j]
         + ps[i-1][j]
         + ps[i][j-1]
         - ps[i-1][j-1]
```

For example:

```
A =
1 2
3 4

Prefix Sum (ps):
1  3
4 10
```

---

### Submatrix Sum Formula

For submatrix `(r1,c1)` to `(r2,c2)`:

```
sum = ps[r2][c2]
    - ps[r1-1][c2]
    - ps[r2][c1-1]
    + ps[r1-1][c1-1]
```

---

### Code

```java
int[][] ps = new int[m][n];

// build prefix sum
for (int i = 0; i < m; i++) {
    for (int j = 0; j < n; j++) {
        ps[i][j] = A[i][j]
            + (i > 0 ? ps[i-1][j] : 0)
            + (j > 0 ? ps[i][j-1] : 0)
            - (i > 0 && j > 0 ? ps[i-1][j-1] : 0);
    }
}

int total = 0;

// generate submatrices
for (int i1 = 0; i1 < m; i1++) {
    for (int j1 = 0; j1 < n; j1++) {
        for (int i2 = i1; i2 < m; i2++) {
            for (int j2 = j1; j2 < n; j2++) {

                int subSum = ps[i2][j2]
                    - (i1 > 0 ? ps[i1-1][j2] : 0)
                    - (j1 > 0 ? ps[i2][j1-1] : 0)
                    + (i1 > 0 && j1 > 0 ? ps[i1-1][j1-1] : 0);

                total += subSum;
            }
        }
    }
}
```

### ⏱ Time Complexity

```
O(n^4)  ✅ better
```

---

# 3️⃣ Fully Optimized (Industry-Level Trick 🚀)

### 🔥 Key Observation

Each element contributes to **multiple submatrices**.

If element is at position `(i, j)`:

```
Top choices    = i + 1
Left choices   = j + 1
Bottom choices = m - i
Right choices  = n - j
```

### Number of submatrices containing A[i][j]

```
count = (i+1) * (j+1) * (m-i) * (n-j)
```

### Contribution

```
contribution = A[i][j] * count
```

---

### Dry Diagram for A[0][0] = 1

```
Top = 1
Left = 1
Bottom = 2
Right = 2

count = 1*1*2*2 = 4
contribution = 1 * 4 = 4
```

---

### Total Calculation

| Element | Count | Contribution |
| ------- | ----- | ------------ |
| 1       | 4     | 4            |
| 2       | 4     | 8            |
| 3       | 4     | 12           |
| 4       | 4     | 16           |

```
Final Sum = 4 + 8 + 12 + 16 = 40
```

---

### Optimized Code (BEST)

```java
int m = A.length;
int n = A[0].length;
int totalSum = 0;

for (int i = 0; i < m; i++) {
    for (int j = 0; j < n; j++) {
        int count = (i + 1) * (j + 1) * (m - i) * (n - j);
        totalSum += A[i][j] * count;
    }
}
```

### ⏱ Time & Space

```
Time:  O(n^2)  ⭐⭐⭐
Space: O(1)
```

---

## ✅ Final Comparison

| Approach           | Time      | Space    |
| ------------------ | --------- | -------- |
| Brute Force        | O(n⁶)     | O(1)     |
| Prefix Sum         | O(n⁴)     | O(n²)    |
| Contribution Trick | **O(n²)** | **O(1)** |

---

If you want, I can also:

* Convert this into **Scalable interview notes**
* Provide **diagram-only explanation**
* Add **Scaler / GFG style wording**
* Give **MCQ traps & interview questions**

Just tell me 😊

## -- Q-3:  give a array Find first missing Integer from BF to optimize exaplain how you explain above question just like that 
### -- optimize ---
Great attempt 👌 — you’re **very close** to the correct **cyclic sort / index-placement** solution.
This is an **industry-standard optimal approach**, but your code has **one critical Java mistake** that breaks everything.

Let’s fix it **properly**, then I’ll explain **why it failed**, and finally do a **clean dry run**.

---

# ❌ What’s WRONG in your code (Important)

### ❗ Problem: `swapTwoNumber(int x, int y)`

Java is **pass-by-value**, not pass-by-reference.

```java
swapTwoNumber(array[i], array[array[i]-1]);
```

This swaps **copies**, not the actual array elements.
👉 **Array never changes**

---

## ❌ Your swap does NOT affect the array

```java
public static void swapTwoNumber(int x, int y){
    int temp = x;
    x = y;
    y = temp;
}
```

This only swaps **local variables**.

---

# ✅ CORRECT WAY: Swap using array + indices

### ✔ Correct swap method

```java
public static void swap(int[] arr, int i, int j){
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}
```

---

# ✅ FIXED & CORRECT CODE (Industry Standard)

```java
package Advanced_DSA_1.Day_16_Two_Dimensional.ClassVideo;

public class Problem_3 {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int firstMissingPositive(int[] array) {
        int i = 0;

        // Step 1: Place elements at correct index
        while (i < array.length) {
            int correctIndex = array[i] - 1;

            if (array[i] >= 1 && array[i] <= array.length
                    && array[i] != array[correctIndex]) {
                swap(array, i, correctIndex);
            } else {
                i++;
            }
        }

        // Step 2: Find missing
        for (int j = 0; j < array.length; j++) {
            if (array[j] != j + 1) {
                return j + 1;
            }
        }
        return array.length + 1;
    }

    public static void main(String[] args) {
        int[] array = {3, 4, -1, 1};
        int ans = firstMissingPositive(array);
        System.out.println("Missing value is: " + ans);
    }
}
```

---

# 🧠 LOGIC (Interview Explanation)

> “We place every positive number `x` at index `x-1`.
> After that, the first index where `arr[i] != i+1` is the missing number.”

---

# 🧪 FULL DRY RUN (Very Important)

### Input

```
[3, 4, -1, 1]
```

---

## STEP 1️⃣: Cyclic placement

### i = 0

```
array[0] = 3 → correct index = 2
swap(0,2)
```

```
[-1, 4, 3, 1]
```

---

### i = 0 again

```
array[0] = -1 → invalid → i++
```

---

### i = 1

```
array[1] = 4 → correct index = 3
swap(1,3)
```

```
[-1, 1, 3, 4]
```

---

### i = 1 again

```
array[1] = 1 → correct index = 0
swap(1,0)
```

```
[1, -1, 3, 4]
```

---

### i = 1 again

```
array[1] = -1 → invalid → i++
```

---

### i = 2

```
array[2] = 3 → already correct
```

---

### i = 3

```
array[3] = 4 → already correct
```

---

## ✅ After placement

```
[1, -1, 3, 4]
```

---

## STEP 2️⃣: Find missing

| Index | Expected | Actual |
| ----- | -------- | ------ |
| 0     | 1        | 1      |
| 1     | 2        | ❌ -1   |

---

# 🎯 FINAL ANSWER

```
First Missing Positive = 2
```

---

# ⏱️ Complexity (Perfect)

| Metric | Value |
| ------ | ----- |
| Time   | O(n)  |
| Space  | O(1)  |

---

# 🔥 Interview Tip (Very Important)

If interviewer asks:

> **“Why while loop, not for?”**

Answer:

> “Because after swap, the new element at index `i` also needs to be checked.”

---

If you want next:

* 🔁 Compare **Negative marking vs Cyclic sort**
* 🎤 30-second interview explanation
* ❓ Why infinite loop does not happen
* 🧠 Which approach is preferred by FAANG

Just say 👍

##--- from BF ---
Perfect 👍 — this is **another TOP interview problem**, and I’ll explain it **exactly in the same style** as the *submatrix-sum* question:

👉 **Brute Force → Better → Optimal**
👉 **Example + Dry diagrams + intuition**

---

# 🧩 Problem Statement

**Given an unsorted integer array, find the *first missing positive integer*.**

📌 Conditions:

* Only **positive integers** matter
* Answer must be **> 0**
* Try to solve in **O(n)** time if possible

---

## Example

```
A = [3, 4, -1, 1]
Output = 2
```

Why?

```
Positive numbers present → {1, 3, 4}
Smallest missing positive → 2
```

---

# 1️⃣ Brute Force Approach (BF)

### 💡 Idea

* Start checking from `1`
* For each number `x`, scan the entire array
* First number **not found** → answer

---

### Dry Run

```
Check 1 → present ✅
Check 2 → NOT present ❌ → answer = 2
```

---

### Code (BF)

```java
public static int firstMissingPositive(int[] A) {
    int n = A.length;

    for (int i = 1; i <= n + 1; i++) {
        boolean found = false;

        for (int j = 0; j < n; j++) {
            if (A[j] == i) {
                found = true;
                break;
            }
        }

        if (!found) return i;
    }
    return n + 1;
}
```

### ⏱ Time & Space

```
Time:  O(n²) ❌
Space: O(1)
```

---

# 2️⃣ Better Approach (Using Extra Space)

### 💡 Idea

* Use a boolean / hash array
* Mark all positive numbers present
* Find the first unmarked index

---

### Dry Diagram

```
A = [3, 4, -1, 1]

Boolean array (size n+1):
Index: 1 2 3 4
Value: T F T T
              ↑
        first missing = 2
```

---

### Code

```java
public static int firstMissingPositive(int[] A) {
    int n = A.length;
    boolean[] present = new boolean[n + 1];

    for (int x : A) {
        if (x > 0 && x <= n) {
            present[x] = true;
        }
    }

    for (int i = 1; i <= n; i++) {
        if (!present[i]) return i;
    }

    return n + 1;
}
```

### ⏱ Time & Space

```
Time:  O(n) ✅
Space: O(n) ❌
```

---

# 3️⃣ Fully Optimized (Industry / Interview Standard 🚀)

### 🔥 Core Observation

* The answer **must lie in range [1, n+1]**
* We can **use the array itself as a hash**

---

## 🔑 Step-by-Step Idea

### Step 1: Ignore useless numbers

* Replace all `<= 0` or `> n` values with `n+1`

```
A = [3, 4, -1, 1]
→ [3, 4, 5, 1]
```

---

### Step 2: Mark presence using index

* For value `x`, mark index `x-1` as **negative**

```
Mark 3 → index 2
Mark 4 → index 3
Mark 1 → index 0
```

After marking:

```
[-3, 4, -5, -1]
```

---

### Step 3: First positive index

```
Index: 0   1   2   3
Value: -   +   -   -
              ↑
Answer = index+1 = 2
```

---

### Optimized Code (BEST)

```java
public static int firstMissingPositive(int[] A) {
    int n = A.length;

    // Step 1: cleanup
    for (int i = 0; i < n; i++) {
        if (A[i] <= 0 || A[i] > n) {
            A[i] = n + 1;
        }
    }

    // Step 2: mark presence
    for (int i = 0; i < n; i++) {
        int val = Math.abs(A[i]);
        if (val >= 1 && val <= n) {
            if (A[val - 1] > 0)
                A[val - 1] = -A[val - 1];
        }
    }

    // Step 3: find missing
    for (int i = 0; i < n; i++) {
        if (A[i] > 0) return i + 1;
    }

    return n + 1;
}
```

---

## 🔍 Dry Run (Complete Visual)

```
Input: [3, 4, -1, 1]

Cleanup:
[3, 4, 5, 1]

Marking:
Index 2 → -
Index 3 → -
Index 0 → -

Final:
[-3, 4, -5, -1]

First +ve at index 1 → Answer = 2
```

---

## ✅ Final Comparison

| Approach         | Time     | Space    | Interview Use |
| ---------------- | -------- | -------- | ------------- |
| Brute Force      | O(n²)    | O(1)     | ❌             |
| Extra Space      | O(n)     | O(n)     | ⚠️            |
| In-place Hashing | **O(n)** | **O(1)** | ⭐⭐⭐           |

---

## 💡 Interview Tip

If interviewer asks:

> “Can you do it without extra space?”

👉 Jump **directly** to **Approach 3**.

---

If you want next:

* **Why answer is always ≤ n+1**
* **Common interview traps**
* **LeetCode / Scaler version**
* **Step-by-step whiteboard explanation**

Just say the word 😄
## ---- give more proper of 3 dry run ---
Great attempt 👌 — you’re **very close** to the correct **cyclic sort / index-placement** solution.
This is an **industry-standard optimal approach**, but your code has **one critical Java mistake** that breaks everything.

Let’s fix it **properly**, then I’ll explain **why it failed**, and finally do a **clean dry run**.

---

# ❌ What’s WRONG in your code (Important)

### ❗ Problem: `swapTwoNumber(int x, int y)`

Java is **pass-by-value**, not pass-by-reference.

```java
swapTwoNumber(array[i], array[array[i]-1]);
```

This swaps **copies**, not the actual array elements.
👉 **Array never changes**

---

## ❌ Your swap does NOT affect the array

```java
public static void swapTwoNumber(int x, int y){
    int temp = x;
    x = y;
    y = temp;
}
```

This only swaps **local variables**.

---

# ✅ CORRECT WAY: Swap using array + indices

### ✔ Correct swap method

```java
public static void swap(int[] arr, int i, int j){
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}
```

---

# ✅ FIXED & CORRECT CODE (Industry Standard)

```java
package Advanced_DSA_1.Day_16_Two_Dimensional.ClassVideo;

public class Problem_3 {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int firstMissingPositive(int[] array) {
        int i = 0;

        // Step 1: Place elements at correct index
        while (i < array.length) {
            int correctIndex = array[i] - 1;

            if (array[i] >= 1 && array[i] <= array.length
                    && array[i] != array[correctIndex]) {
                swap(array, i, correctIndex);
            } else {
                i++;
            }
        }

        // Step 2: Find missing
        for (int j = 0; j < array.length; j++) {
            if (array[j] != j + 1) {
                return j + 1;
            }
        }
        return array.length + 1;
    }

    public static void main(String[] args) {
        int[] array = {3, 4, -1, 1};
        int ans = firstMissingPositive(array);
        System.out.println("Missing value is: " + ans);
    }
}
```

---

# 🧠 LOGIC (Interview Explanation)

> “We place every positive number `x` at index `x-1`.
> After that, the first index where `arr[i] != i+1` is the missing number.”

---

# 🧪 FULL DRY RUN (Very Important)

### Input

```
[3, 4, -1, 1]
```

---

## STEP 1️⃣: Cyclic placement

### i = 0

```
array[0] = 3 → correct index = 2
swap(0,2)
```

```
[-1, 4, 3, 1]
```

---

### i = 0 again

```
array[0] = -1 → invalid → i++
```

---

### i = 1

```
array[1] = 4 → correct index = 3
swap(1,3)
```

```
[-1, 1, 3, 4]
```

---

### i = 1 again

```
array[1] = 1 → correct index = 0
swap(1,0)
```

```
[1, -1, 3, 4]
```

---

### i = 1 again

```
array[1] = -1 → invalid → i++
```

---

### i = 2

```
array[2] = 3 → already correct
```

---

### i = 3

```
array[3] = 4 → already correct
```

---

## ✅ After placement

```
[1, -1, 3, 4]
```

---

## STEP 2️⃣: Find missing

| Index | Expected | Actual |
| ----- | -------- | ------ |
| 0     | 1        | 1      |
| 1     | 2        | ❌ -1   |

---

# 🎯 FINAL ANSWER

```
First Missing Positive = 2
```

---

# ⏱️ Complexity (Perfect)

| Metric | Value |
| ------ | ----- |
| Time   | O(n)  |
| Space  | O(1)  |

---

# 🔥 Interview Tip (Very Important)

If interviewer asks:

> **“Why while loop, not for?”**

Answer:

> “Because after swap, the new element at index `i` also needs to be checked.”

---

If you want next:

* 🔁 Compare **Negative marking vs Cyclic sort**
* 🎤 30-second interview explanation
* ❓ Why infinite loop does not happen
* 🧠 Which approach is preferred by FAANG

Just say 👍
