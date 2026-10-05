## Q-1: Implement Power Function ---
Problem Description
```
Implement pow(A, B) % C.
In other words, given A, B and C, Find (AB % C).
Note: 
The remainders on division cannot be negative. In other words, make sure the answer you return is non-negative.
```
Problem Constraints

```declarative
-109 <= A <= 109
0 <= B <= 109
1 <= C <= 109
```
Input Format

```declarative
Given three integers A, B, C.
```

Output Format

```declarative
Return an integer.
```
Example Input

Input 1:
```declarative
A = 2
B = 3
C = 3
```
Input 2:
```declarative
A = 3
B = 3
C = 1
```


Example Output

Output 1:
```declarative
2
```
Output 2:
```declarative
0
```

soluation:
```java
public class Solution {
  // Do not write code to include libraries, main() function or accept any input from the console.
  // Initialization code is already written and hidden from you. Do not write code for it again.
  public int pow(int A, int B, int C) {
      // Just write your code below to complete the function. Required input is available to you as the function arguments.
      // Do not print the result or any output. Just return the result via this function.
      int result = A;
      for(int i = 1; i< B; i++){
       ( result*= A)% C ;
      }
      return (result)% C;
  }
}
```
Good question 👍
Your current solution has **3 major problems**:

---

# ❌ Problems in Your Code

### 1️⃣ Syntax Error

```java
( result*= A)% C ;
```

This is invalid Java.

---

### 2️⃣ Time Complexity Issue ❌

Your loop runs:

```
for i = 1 to B
```

But constraint says:

```
B can be up to 10^9
```

That means **1 billion iterations** → ❌ TLE (Time Limit Exceeded)

---

### 3️⃣ Negative Remainder Problem ❌

If `A` is negative, result can be negative.
Problem says:

> Remainder cannot be negative.

---

# 🚀 Correct Approach: Binary Exponentiation (Fast Power)

Instead of multiplying B times, we use:

[
A^B =
\begin{cases}
(A^{B/2})^2 & \text{if B even} \
A × A^{B-1} & \text{if B odd}
\end{cases}
]

This reduces time from:

```
O(B) ❌
```

to:

```
O(log B) ✅
```

---

# 🔥 Optimized Solution (Best Version)

```java
public class Solution {
    public int pow(int A, int B, int C) {
        
        if (A == 0) return 0;
        
        long base = A % C;
        long result = 1;
        
        if (base < 0) base += C;   // handle negative A
        
        while (B > 0) {
            
            if ((B & 1) == 1) {   // if B is odd
                result = (result * base) % C;
            }
            
            base = (base * base) % C;
            B = B >> 1;   // divide B by 2
        }
        
        return (int)((result + C) % C);  // ensure non-negative
    }
}
```

---

# 🧠 Dry Run

### Example:

```
A = 2
B = 3
C = 3
```

We calculate:

```
2^3 % 3
```

Step-by-step:

| B       | result     | base  |
| ------- | ---------- | ----- |
| 3 (odd) | 1*2 %3 = 2 | 2     |
| 1 (odd) | 2*4 %3 = 2 | 4%3=1 |
| 0       | stop       |       |

Answer:

```
2
```

---

# ⏱ Time Complexity

```
O(log B)
```

Because each step divides B by 2.

---

# 📦 Space Complexity

```
O(1)
```

(Iterative version)

---

# 🎯 Why Interviewers Ask This?

Because it tests:

* Modulo properties
* Overflow handling
* Bit manipulation
* Logarithmic optimization
* Competitive coding knowledge

---

# 💡 Important Math Property Used

[
(A × B) % C = ((A % C) × (B % C)) % C
]

---

If you want, I can also show:

* Recursive version
* Very clean version for interviews
* Step-by-step visual explanation
* Edge cases explanation

You’re improving well 🔥 Keep going.


## --- Q-2: Greatest Common Divisor ----
Problem Description

    -Given 2 non-negative integers A and B, find gcd(A, B)

    -GCD of 2 integers A and B is defined as the greatest integer 'g' such that 'g' is a divisor of both A and B. Both A and B fit in a 32 bit signed integer.
    -Note: DO NOT USE LIBRARY FUNCTIONS.
Problem Constraints

```declarative
0 <= A, B <= 109
```

Input Format

```declarative
First argument is an integer A.
Second argument is an integer B.

```

Output Format

```declarative
Return an integer denoting the gcd(A, B).
```

Example Input

Input 1:
```declarative
A = 4
B = 6
```
Input 2:

```declarative
A = 6
B = 7
```

Example Output

Output 1:

```declarative
2
```
Output 2:

```declarative
1
```
solution:
```java
public class Solution {
    public int gcd(int A, int B) {
        A = Math.abs(A);
        B = Math.abs(B);

        while (B != 0) {
            int temp = B;
            B = A % B;
            A = temp;
        }
        return A;
    }
}

```

## --- Q-3:Pair Sum divisible by M ----
Problem Description

```declarative
Given an array of integers A and an integer B, find and return the number of pairs in A whose sum is divisible by B.

Since the answer may be large, return the answer modulo (109 + 7).

Note: Ensure to handle integer overflow when performing the calculations.
```
Problem Constraints

1 <= length of the array <= 100000
1 <= A[i] <= 109
1 <= B <= 106



Input Format

```declarative
The first argument given is the integer array A.
The second argument given is the integer B.
```



Output Format

```declarative
Return the total number of pairs for which the sum is divisible by B modulo (109 + 7).

```

Example Input

Input 1:

```declarative
A = [1, 2, 3, 4, 5]
B = 2
```
Input 2:

```declarative
A = [5, 17, 100, 11]
B = 28
```

Example Output

Output 1:

```declarative
4
```
Output 2:
```declarative
1
```
soluation:
```java
public class Solution { 
    public int solve(int[] arr, int b) { 
        int ans = arr[0]; 
        for (int i = 1; i < arr.length; i++) { 
            ans = gcd(ans, arr[i]); 
        } 
        return ans; 
    } // Euclidean Algorithm 
    public static int gcd(int a, int b) { 
            while (b != 0) { 
                int temp = b; b = a % b; a = temp; 
            } r
        eturn a; 
        } 
}
```
Good 👍 Ritik — this is **Pairs with sum divisible by B** problem.

Your current code is solving **GCD of array**, which is completely different.

Let’s solve this properly:

---

# ✅ Problem

Given:

```
A = [1,2,3,4,5]
B = 2
```

Find number of pairs (i, j), i < j such that:

[
(A[i] + A[j]) % B = 0
]

Return answer % (10^9 + 7)

---

# 🧠 Key Observation (VERY IMPORTANT)

Instead of checking all pairs ❌
We use **modular math trick**:

If:

[
(A[i] + A[j]) % B = 0
]

Then:

[
A[i] % B + A[j] % B = B
]

Let:

```
rem = A[i] % B
```

We need:

```
(B - rem) % B
```

---

# 🚫 Brute Force (Not Allowed)

```
for i
   for j
      check (A[i] + A[j]) % B == 0
```

### Time Complexity:

```
O(N²)
```

N = 100000 ❌ → TLE

---

# 🚀 Optimized Approach (Frequency of Remainders)

### Step 1:

Make an array `freq[B]`

### Step 2:

Count how many numbers give each remainder

```
rem = A[i] % B
freq[rem]++
```

### Step 3:

Count valid pairs

Cases:

---

## Case 1: remainder = 0

If remainder is 0,
pair with remainder 0 only.

Number of pairs:

[
freq[0] * (freq[0] - 1) / 2
]

---

## Case 2: remainder = r and B-r

[
freq[r] * freq[B-r]
]

---

## Case 3: When B is even

If:

[
r = B/2
]

Then:

[
freq[r] * (freq[r] - 1) / 2
]

---

# 🔍 Dry Run (Example 1)

### Input:

```
A = [1,2,3,4,5]
B = 2
```

### Step 1: Remainders

```
1 % 2 = 1
2 % 2 = 0
3 % 2 = 1
4 % 2 = 0
5 % 2 = 1
```

freq:

```
freq[0] = 2
freq[1] = 3
```

---

### Count pairs

### remainder 0:

```
2C2 = 1
```

### remainder 1:

Since B=2, B-r = 1

Special case (B even and r = B/2)

```
3C2 = 3
```

---

Total:

```
1 + 3 = 4 ✅
```

---

# 🔍 Dry Run (Example 2)

```
A = [5,17,100,11]
B = 28
```

remainders:

```
5 % 28 = 5
17 % 28 = 17
100 % 28 = 16
11 % 28 = 11
```

Need pairs such that sum remainder = 28

Check manually:

```
17 + 11 = 28
```

Answer = 1 ✅

---

# 💻 Correct Optimized Code (Java)

```java
public class Solution {
    public int solve(int[] A, int B) {

        long MOD = 1000000007;
        long[] freq = new long[B];

        // Count frequency of remainders
        for (int i = 0; i < A.length; i++) {
            int rem = A[i] % B;
            freq[rem]++;
        }

        long ans = 0;

        // Case 1: remainder 0
        ans += (freq[0] * (freq[0] - 1)) / 2;

        // Case 2: r and B-r
        for (int r = 1; r <= B / 2; r++) {

            if (r == B - r) { // when B is even and r = B/2
                ans += (freq[r] * (freq[r] - 1)) / 2;
            } else {
                ans += freq[r] * freq[B - r];
            }
        }

        return (int)(ans % MOD);
    }
}
```

---

# ⏱ Time Complexity

```
O(N + B)
```

* One pass to count remainders → O(N)
* One loop till B/2 → O(B)

Constraints allow this.

---

# 💡 Why This Is Optimal?

Instead of checking all N² pairs,
we reduce problem using **math observation**.

This is a common trick in:

* Amazon
* Flipkart
* Microsoft
* Adobe

---

If you want next level version:

* 🔥 Count triplets divisible by B
* 🔥 Subarrays with sum divisible by B
* 🔥 GCD + modulo combined problem
* 🔥 Competitive coding optimized version

Tell me which level you want 🚀
