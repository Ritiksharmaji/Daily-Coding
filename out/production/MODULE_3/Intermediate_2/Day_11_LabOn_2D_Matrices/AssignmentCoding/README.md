## --- Q-1: Anti Diagonals ---

Q1. Anti Diagonals

- Problem Description

    - Give a N * N square matrix A, return an array of its anti-diagonals. Look at the example for more details.


Problem Constraints

```declarative
1<= N <= 1000
1<= A[i][j] <= 1e9
```

Input Format

Only argument is a 2D array A of size N * N.


Output Format

Return a 2D integer array of size (2 * N-1) * N, representing the anti-diagonals of input array A.
The vacant spaces in the grid should be assigned to 0.


Example Input

Input 1:
```declarative
1 2 3
4 5 6
7 8 9
```
Input 2:

```declarative
1 2
3 4
```

Example Output

Output 1:
```declarative
1 0 0
2 4 0
3 5 7
6 8 0
9 0 0
```
Output 2:
```declarative
1 0
2 3
4 0
```
ans:
-------------------------------
explaining the question 
----
No problem 👍
Let me explain this **VERY simply**, step-by-step, like you are seeing it for the **first time**.
Forget coding for now — **only concept**.

---

## 1️⃣ What is the question REALLY asking?

You are given a **square matrix (N × N)**.

👉 You must **extract anti-diagonals** and place them into a **new matrix**.

---

## 2️⃣ What is an Anti-Diagonal? (Plain words)

In a matrix:

* **Main diagonal** goes like ↘
  `(0,0) → (1,1) → (2,2)`

* **Anti-diagonal** goes like ↙
  `(0,0)`
  `(0,1),(1,0)`
  `(0,2),(1,1),(2,0)`
  `(1,2),(2,1)`
  `(2,2)`

👉 Elements are grouped where

```
row index + column index is SAME
```

---

## 3️⃣ Look at this matrix slowly

```
1   2   3
4   5   6
7   8   9
```

Let’s write **(row, col)** on each element:

```
(0,0) (0,1) (0,2)
(1,0) (1,1) (1,2)
(2,0) (2,1) (2,2)
```

---

## 4️⃣ Group by (row + col)

### Anti-Diagonal 0 → row + col = 0

```
(0,0) → 1
```

### Anti-Diagonal 1 → row + col = 1

```
(0,1) → 2
(1,0) → 4
```

### Anti-Diagonal 2 → row + col = 2

```
(0,2) → 3
(1,1) → 5
(2,0) → 7
```

### Anti-Diagonal 3 → row + col = 3

```
(1,2) → 6
(2,1) → 8
```

### Anti-Diagonal 4 → row + col = 4

```
(2,2) → 9
```

---

## 5️⃣ Why output size is (2N-1) × N ?

For N = 3:

* Anti-diagonals = `2*3 - 1 = 5`
* Each row must have **N columns**

So output size = `5 × 3`

---

## 6️⃣ Write anti-diagonals as rows (IMPORTANT)

We place each anti-diagonal **in a separate row**
and **fill remaining spaces with 0**

```
1 0 0
2 4 0
3 5 7
6 8 0
9 0 0
```

---

## 7️⃣ Why zeros are needed?

Some anti-diagonals have:

* 1 element
* 2 elements
* 3 elements

But output **must have exactly N columns**
👉 So empty places are filled with `0`

---

## 8️⃣ One-line meaning of the question

> “Take all elements whose (row + column) is the same,
> put them together as one row,
> and fill missing spaces with 0.”

---

## 9️⃣ Small 2×2 Example (even simpler)

```
1 2
3 4
```

Anti-diagonals:

```
1
2 3
4
```

Output (3 × 2):

```
1 0
2 3
4 0
```

---

## 🔟 If still confused, remember this rule

### 🔑 GOLDEN RULE

```
Anti-Diagonal index = row + column
```

---

If you want next:

* 🧠 **Visualization diagram**
* ✍️ **Step-by-step dry run**
* 💻 **Java code with comments**
* 🎯 **Interview explanation**

Tell me which one 👍
- GOt it 

------------ 
code:





## --- Q2. Column Sum ----
Problem Description

- You are given a 2D integer matrix A, return a 1D integer array containing column-wise sums of original matrix.



Problem Constraints
```declarative
1 <= A.size() <= 103

1 <= A[i].size() <= 103

1 <= A[i][j] <= 103

```

Input Format
```declarative
First argument is a 2D array of integers.(2D matrix).
```

Output Format
```declarative
Return an array containing column-wise sums of original matrix.
```


Example Input

Input 1:
```declarative
[1,2,3,4]
[5,6,7,8]
[9,2,3,4]
```

Example Output

Output 1:
```declarative
{15,10,13,16}
```

code: 
```java
public class Solution {
    public int[] solve(int[][] A) {

        int rows = A.length;
        int cols = A[0].length;

        int[] result = new int[cols];

        for (int j = 0; j < cols; j++) {      // column loop
            int sum = 0;
            for (int i = 0; i < rows; i++) { // row loop
                sum += A[i][j];
            }
            result[j] = sum;
        }

        return result;
    }
}
```