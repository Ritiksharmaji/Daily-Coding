## ==== Q1. Compute nCr % m ====
Let’s first understand the **math clearly**, then we’ll code it properly 👇

---

# ✅ What is nCr?

[
nCr = \frac{n!}{r!(n-r)!}
]

It means:
👉 Number of ways to choose `r` items from `n` items.

---

# 🔍 Example 1

### Input:

```
A = 5, B = 2, C = 13
```

### Step 1: Compute nCr

[
5C2 = \frac{5!}{2! \cdot 3!}
]

[
= \frac{5 \cdot 4 \cdot 3!}{2 \cdot 1 \cdot 3!}
]

[
= \frac{5 \cdot 4}{2} = 10
]

### Step 2: Mod

```
10 % 13 = 10
```

✅ Output = **10**

---

# 🔍 Example 2

### Input:

```
A = 6, B = 2, C = 13
```

### Step 1: Compute nCr

[
6C2 = \frac{6!}{2! \cdot 4!}
]

[
= \frac{6 \cdot 5 \cdot 4!}{2 \cdot 1 \cdot 4!}
]

[
= \frac{6 \cdot 5}{2} = 15
]

### Step 2: Mod

```
15 % 13 = 2
```

✅ Output = **2**

---

# ⚠️ Important Problem Insight

You **cannot directly compute factorials** for large values because:

* Factorials grow very fast ❌
* May cause overflow ❌

---

# ✅ Best Approach → Dynamic Programming (Pascal Triangle)

Use identity:

[
nCr = (n-1)C(r-1) + (n-1)Cr
]

---

# 🧠 Idea

* Build DP table
* Apply `% m` at every step
* No overflow ✅

---

# ✅ Java Code (Optimal)

```java
public class Solution {
    public int solve(int A, int B, int C) {

        int[][] dp = new int[A + 1][B + 1];

        // Base case
        for (int i = 0; i <= A; i++) {
            for (int j = 0; j <= Math.min(i, B); j++) {

                if (j == 0 || j == i) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % C;
                }
            }
        }

        return dp[A][B];
    }
}
```

---

# ⏱ Complexity

* Time → **O(n × r)**
* Space → **O(n × r)**

---

# 🚀 Optimization (Space)

You can reduce to **1D array** if needed:

```java
public class Solution {
    public int solve(int A, int B, int C) {

        int[] dp = new int[B + 1];
        dp[0] = 1;

        for (int i = 1; i <= A; i++) {
            for (int j = Math.min(i, B); j > 0; j--) {
                dp[j] = (dp[j] + dp[j - 1]) % C;
            }
        }

        return dp[B];
    }
}
```

---

# 💡 Interview Tips

* If `mod` is **prime** → use Fermat’s theorem (advanced)
* If `mod` is **not prime** (like here) → use DP ✅
* Always apply `% C` at every step

---

# 🔥 Summary

| Concept    | Use                      |
| ---------- | ------------------------ |
| Formula    | nCr                      |
| Problem    | Avoid factorial overflow |
| Solution   | Pascal Triangle (DP)     |
| Complexity | O(n × r)                 |

---

If you want next:
✅ Fermat’s Little Theorem method (very important for interviews)
✅ Precomputation for multiple queries
✅ Hard variations (nCr with large constraints)

Just tell me 🔥
 ## from BF to optimize ==
Perfect 👍 let’s build this **step-by-step from Brute Force → Optimized** (this is exactly how interviewers expect you to think 🔥)

---

# 🔴 1. Brute Force (Factorial Method)

## 🧠 Idea

Use formula:

[
nCr = \frac{n!}{r!(n-r)!}
]

---

## ❌ Problem

* Factorials grow huge → **overflow**
* `% m` cannot be applied directly on division

---

## ✅ Code (Only for understanding, NOT recommended)

```java
public class Solution {
    public int solve(int A, int B, int C) {

        long nFact = factorial(A);
        long rFact = factorial(B);
        long nrFact = factorial(A - B);

        long result = nFact / (rFact * nrFact);

        return (int)(result % C);
    }

    private long factorial(int n) {
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}
```

---

## 🚫 Why it fails?

* `20!` already exceeds `long`
* Division with mod is tricky ❌

---

# 🟡 2. Better Approach (Multiplication Trick)

## 🧠 Idea

Instead of full factorial:

[
nCr = \frac{n \cdot (n-1) \cdot ...}{r!}
]

---

## ⚠ Still Problem

* Division still exists
* Modulo with division ❌

---

# 🟢 3. Optimized Approach (Pascal’s Triangle / DP) ✅

## 🧠 Key Formula

[
C(n,r) = C(n-1,r-1) + C(n-1,r)
]

---

## ✅ Why this works

* No factorial
* No division
* Safe with modulo

---

## ✔ Code (2D DP)

```java
public class Solution {
    public int solve(int A, int B, int C) {

        int[][] dp = new int[A + 1][B + 1];

        for (int i = 0; i <= A; i++) {
            for (int j = 0; j <= Math.min(i, B); j++) {

                if (j == 0 || j == i) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % C;
                }
            }
        }

        return dp[A][B];
    }
}
```

---

# 🟢 4. Space Optimized (BEST) 🚀

## 🧠 Idea

Use 1D array instead of 2D

---

## ✔ Code

```java
public class Solution {
    public int solve(int A, int B, int C) {

        int[] dp = new int[B + 1];
        dp[0] = 1;

        for (int i = 1; i <= A; i++) {
            for (int j = Math.min(i, B); j > 0; j--) {
                dp[j] = (dp[j] + dp[j - 1]) % C;
            }
        }

        return dp[B];
    }
}
```

---

# 📊 Final Comparison

| Approach       | Time  | Space | Status           |
| -------------- | ----- | ----- | ---------------- |
| Factorial (BF) | O(n)  | O(1)  | ❌ Overflow       |
| Multiplication | O(r)  | O(1)  | ❌ Division issue |
| DP (2D)        | O(nr) | O(nr) | ✅ Good           |
| DP (1D)        | O(nr) | O(r)  | 🚀 Best          |

---

# 🔥 Interview Flow (VERY IMPORTANT)

When asked:

1. Start with **factorial approach**
2. Say **overflow issue**
3. Say **mod division problem**
4. Move to **Pascal DP**
5. Optimize to **1D DP**

👉 This shows strong problem-solving thinking 💯

---

If you want next:
✅ Fermat’s theorem method (for prime mod)
✅ Solve large constraints (10⁷+)
✅ Real interview questions based on this

Just tell me 🔥


## ========== Q3. Prime Sum ===
This is a classic problem based on **Goldbach's Conjecture** 🔥

---

# ✅ Problem Understanding

You’re given:

* An **even number A (> 2)**

You need:

* Two primes `[a, b]` such that:

[
a + b = A
]

* Return **lexicographically smallest pair**

---

# 🧠 Key Idea

1. Generate all primes up to `A` using **Sieve**
2. Try pairs:

    * Start from smallest `a`
    * Check if `(A - a)` is prime
3. First valid pair = answer ✅

---

# ⚡ Why this works

We iterate from smallest `a`, so automatically:

* First valid pair → **lexicographically smallest**

---

# ✅ Java Code (Interview Ready)

```java id="q3x9kp"
import java.util.*;

public class Solution {
    public int[] primesum(int A) {

        // Step 1: Sieve
        boolean[] isPrime = new boolean[A + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= A; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= A; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Step 2: Find pair
        for (int i = 2; i <= A; i++) {
            if (isPrime[i] && isPrime[A - i]) {
                return new int[]{i, A - i};
            }
        }

        return new int[0]; // Not needed (guaranteed solution)
    }
}
```

---

# 🔍 Dry Run Example

### Input:

```id="4rq5ph"
A = 26
```

Check:

* 2 → 26-2 = 24 ❌
* 3 → 23 ✅

✔ Answer:

```id="r0nhm6"
[3, 23]
```

---

# ⏱ Complexity

* Sieve → **O(n log log n)**
* Loop → **O(n)**

👉 Overall: **O(n log log n)**

---

# 🚀 Important Interview Points

* Always use **Sieve** for fast prime lookup
* Use `isPrime[A - i]` instead of recalculating
* Start from **i = 2** for lexicographically smallest answer

---

# 💡 Small Optimization

You can loop only till:

[
i \leq A/2
]

Because after that pairs repeat.

---

# 🔥 Summary

| Step | Action                             |
| ---- | ---------------------------------- |
| 1    | Build sieve                        |
| 2    | Iterate from 2                     |
| 3    | Check `isPrime[i] && isPrime[A-i]` |
| 4    | Return first match                 |

---

If you want next:
✅ Hard version (multiple queries optimization)
✅ Segmented sieve + prime sum combo
✅ Tricky edge cases asked in interviews

Just tell me 🔥
