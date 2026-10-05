## -- Q-1: Given N array elements. Find the count of pairs ( i, j ) such that ( arr [ i ] + arr [ j ] ) % m = 0 NOTE : i != j and pair ( i , j ) is same as pair ( j , i )  ---
Nice classic **modulo + hashing** interview question 🔥
Let’s go step-by-step **from Brute Force → Better → Optimal**, with full explanation + dry run.

---

# 🧠 Problem Understanding

## Given

* Array `arr[]` with N elements
* Integer `m`

## Find

Count pairs `(i, j)` such that:

```
(arr[i] + arr[j]) % m == 0
```

### Conditions

✔ `i ≠ j`
✔ `(i , j)` same as `(j , i)` → count only once

---

## 💡 Mathematical Insight (MOST IMPORTANT)

```
(a + b) % m = 0
```

means

```
(a % m + b % m) % m = 0
```

So if

```
r1 = a % m
r2 = b % m
```

then

```
r1 + r2 = m
```

OR

```
r1 == 0 and r2 == 0
```

---

# 🔴 1️⃣ Brute Force Approach

## Idea

Check every pair.

---

## Algorithm

```
for i = 0 to n-1
   for j = i+1 to n-1
       if (arr[i] + arr[j]) % m == 0
           count++
```

---

## Code (BF)

```java
public static int countPairsBF(int[] arr, int m){
    int n = arr.length;
    int count = 0;

    for(int i=0;i<n;i++){
        for(int j=i+1;j<n;j++){
            if((arr[i] + arr[j]) % m == 0){
                count++;
            }
        }
    }
    return count;
}
```

---

## Time Complexity

```
O(n²)
```

## Space

```
O(1)
```

---

## Dry Run

```
arr = [1,2,3,4,5]
m = 3
```

Pairs:

```
(1,2)=3 ✔
(1,5)=6 ✔
(2,4)=6 ✔
(3,6?) no
```

Answer = 3

---

# 🟡 2️⃣ Better Approach (Remainder Frequency)

## Key Idea

Instead of checking sums,
store remainder counts.

---

## Steps

### Step 1

Create freq array

```
freq[m]
```

### Step 2

Compute remainder

```
rem = arr[i] % m
freq[rem]++
```

---

## Pair Logic

### Case 1

```
remainder 0 pairs with remainder 0
```

Pairs:

```
freq[0] choose 2
```

---

### Case 2

```
r with (m - r)
```

---

### Case 3

If

```
m even
r = m/2
```

self pairing:

```
freq[r] choose 2
```

---

# 🟢 Optimal Approach

## Code (OPTIMAL)

```java
public static int countPairsOptimal(int[] arr, int m){

    int[] freq = new int[m];

    for(int val : arr){
        int rem = val % m;
        freq[rem]++;
    }

    int count = 0;

    // remainder 0
    count += (freq[0] * (freq[0]-1))/2;

    // middle remainder
    if(m % 2 == 0){
        count += (freq[m/2] * (freq[m/2]-1))/2;
    }

    for(int r=1; r<= (m-1)/2 ; r++){
        count += freq[r] * freq[m-r];
    }

    return count;
}
```

---

# 🧪 Full Dry Run (OPTIMAL)

## Input

```
arr = [1,2,3,4,5]
m = 3
```

---

## Step 1: Remainders

```
1 %3 =1
2 %3 =2
3 %3 =0
4 %3 =1
5 %3 =2
```

---

## Step 2: Frequency

```
freq[0]=1
freq[1]=2
freq[2]=2
```

---

## Step 3: Count

### remainder 0

```
1C2 =0
```

### r=1 pairs with 2

```
2 * 2 =4
```

But unordered pairs:

```
(1,2)
(1,5)
(4,2)
(4,5)
```

valid = 4

---

# ⏱ Complexity

| Approach | Time     | Space |
| -------- | -------- | ----- |
| Brute    | O(n²)    | O(1)  |
| Optimal  | O(n + m) | O(m)  |

---

# 🎯 Interview Explanation (How YOU Should Say)

👉 First I brute force all pairs → O(n²)

👉 Then I observe:

```
(a+b)%m=0
→ remainder sum=m
```

👉 I store remainder frequency

👉 I combine:

```
r with (m-r)
```

👉 Special handling:

* remainder 0
* remainder m/2

👉 final complexity:

```
O(n+m)
```

---

# 🚀 Want Next Level Problems?

I can also teach you:

🔥 count divisible subarrays
🔥 two sum mod m
🔥 prefix remainder trick
🔥 pairs divisible by k advanced
🔥 hashmap vs freq optimization

Just say **“next mod problems”** 😄

# Q-2: GCD (Greatest Common Divisor) clearly and cleanly. ---
Looks like your notes got mixed up 😄
Let me properly explain **GCD (Greatest Common Divisor)** clearly and cleanly.

---

# 🔷 What is GCD?

**GCD(A, B)** = Largest positive number that divides both A and B.

Also called:

* HCF (Highest Common Factor)

---

# 🔹 Important GCD Facts

### 1️⃣ GCD(A, B) = GCD(B, A)

Order doesn’t matter.

---

### 2️⃣ GCD(A, 0) = |A|

Example:

```
GCD(0, 8) = 8
GCD(5, 0) = 5
```

Because every number divides 0.

---

### 3️⃣ GCD(0, 0) = Undefined

(Some define as 0, but mathematically undefined)

---

### 4️⃣ GCD of negative numbers

GCD is always **positive**.

```
GCD(-10, 20) = 10
GCD(-5, -15) = 5
```

We take absolute values.

---

### 5️⃣ If GCD(A, B) = 1

Then A and B are **Co-prime**.

Example:

```
GCD(14, 25) = 1
```

---

# 🔹 Example 1: GCD(20, 65)

Prime factors:

```
20 = 2 × 2 × 5
65 = 5 × 13
```

Common factor = 5

✅ **GCD(20, 65) = 5**

---

# 🔹 Example 2: GCD(-10, 20)

Ignore sign:

```
10 = 2 × 5
20 = 2 × 2 × 5
```

Common factors = 2 × 5

✅ **GCD(-10, 20) = 10**

---

# 🔹 Example 3: GCD(0, 8)

Every number divides 0.

Largest divisor common with 8 = 8

✅ **GCD(0, 8) = 8**

---

# 🔷 Most Important Property (Euclidean Algorithm)

```
GCD(A, B) = GCD(B, A % B)
```

Example:

```
GCD(20, 65)
= GCD(65, 20)
= GCD(20, 5)
= GCD(5, 0)
= 5
```

Very important for DSA 🔥

---

# 🔷 Time Complexity

Using Euclidean Algorithm:

```
O(log(min(A,B)))
```

Very fast.

---

# 🔷 Interview Important Points

✔ GCD always positive
✔ GCD(0, A) = |A|
✔ GCD(A, B) = GCD(B, A % B)
✔ If GCD = 1 → Co-prime

---

If you want, I can next explain:

* 🔥 LCM using GCD
* 🔥 Extended Euclidean Algorithm
* 🔥 Why Euclidean works mathematically
* 🔥 GCD in competitive programming problems

Tell me what you want next 🚀

## BF to optimize ---
Perfect 👍
Let’s do **GCD (Greatest Common Divisor)** from **Brute Force → Better → Optimal (Euclidean Algorithm)** with:

* ✅ Explanation
* ✅ Dry Run
* ✅ Full Code (Java)
* ✅ Time & Space Complexity

---

# 🔷 Problem

Find **GCD(A, B)** = Largest number that divides both A and B.

Example:

```
A = 20, B = 65
Answer = 5
```

---

# 🟢 1️⃣ Brute Force Approach (BF)

## 💡 Idea

Check all numbers from **1 to min(A, B)**
Find the largest number that divides both.

---

## 🧠 Algorithm

1. Take `min = Math.min(A, B)`
2. Loop from `1 → min`
3. If divides both → update answer

---

## 💻 Code (Brute Force)

```java
public class GCD_BF {

    public static int gcd(int A, int B) {
        int min = Math.min(Math.abs(A), Math.abs(B));
        int gcd = 1;

        for (int i = 1; i <= min; i++) {
            if (A % i == 0 && B % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }

    public static void main(String[] args) {
        System.out.println(gcd(20, 65));
    }
}
```

---

## 🧪 Dry Run (20, 65)

Loop from 1 → 20

| i      | 20 % i | 65 % i | Valid? |
| ------ | ------ | ------ | ------ |
| 1      | 0      | 0      | ✅      |
| 5      | 0      | 0      | ✅      |
| others | ❌      | ❌      | ❌      |

Largest valid = 5

✅ Answer = 5

---

## ⏱ Time Complexity

```
O(min(A, B))
```

❌ Slow for large numbers (like 10^9)

---

# 🟡 2️⃣ Better Approach (Reverse Loop)

Instead of 1 → min
Start from min → 1

Stop when first divisor found.

---

## 💻 Code

```java
public class GCD_Better {

    public static int gcd(int A, int B) {
        int min = Math.min(Math.abs(A), Math.abs(B));

        for (int i = min; i >= 1; i--) {
            if (A % i == 0 && B % i == 0) {
                return i;
            }
        }
        return 1;
    }
}
```

---

## ⏱ Time Complexity

Worst case still:

```
O(min(A, B))
```

Slight improvement but still slow.

---

# 🔴 3️⃣ Optimal Approach — Euclidean Algorithm 🔥

This is the **industry + interview standard method**

---

## 🔥 Core Formula

```
GCD(A, B) = GCD(B, A % B)
```

Keep replacing:

```
(A, B) → (B, A % B)
```

Until B = 0

Answer = A

---

## 💻 Code (Iterative)

```java
public class GCD_Optimal {

    public static int gcd(int A, int B) {
        A = Math.abs(A);
        B = Math.abs(B);

        while (B != 0) {
            int temp = B;
            B = A % B;
            A = temp;
        }
        return A;
    }

    public static void main(String[] args) {
        System.out.println(gcd(20, 65));
    }
}
```

---

## 🧪 Dry Run (20, 65)

Step 1:

```
GCD(20, 65)
= GCD(65, 20)
```

Step 2:

```
65 % 20 = 5
= GCD(20, 5)
```

Step 3:

```
20 % 5 = 0
= GCD(5, 0)
```

Stop because B = 0

✅ Answer = 5

---

## 📊 Step Table

| A  | B  | A % B |
| -- | -- | ----- |
| 65 | 20 | 5     |
| 20 | 5  | 0     |

Final A = 5

---

## ⏱ Time Complexity

```
O(log(min(A,B)))
```

⚡ Extremely fast
Works for 10^18 also.

---

# 🟣 Recursive Version (Interview Favorite)

```java
public static int gcd(int A, int B) {
    if (B == 0)
        return A;
    return gcd(B, A % B);
}
```

---

# 🔷 Special Cases

| Case         | Result    |
| ------------ | --------- |
| GCD(0, 8)    | 8         |
| GCD(-10, 20) | 10        |
| GCD(7, 13)   | 1         |
| GCD(0, 0)    | Undefined |

---

# 🔥 Why Euclidean Works?

If a number divides A and B,
it also divides (A % B).

So instead of checking all numbers,
we reduce the problem size each step.

---

# 📊 Comparison

| Approach     | Time        | Efficient? |
| ------------ | ----------- | ---------- |
| Brute Force  | O(min(A,B)) | ❌          |
| Reverse Loop | O(min(A,B)) | ❌          |
| Euclidean    | O(log n)    | ✅🔥        |

---

# 🎯 Interview Tip

If interviewer asks:

> How would you optimize GCD?

Say confidently:

> Use Euclidean Algorithm.
> Time complexity O(log n).

---

If you want next:

* 🔥 LCM using GCD
* 🔥 Extended Euclidean Algorithm
* 🔥 GCD in arrays
* 🔥 GCD prefix/suffix trick

Tell me 🚀

## --- Q-3: GCD in arrays(Find GCD of Entire Array) ---
Good 🔥 this is very important for interviews and competitive programming.

Let’s do **GCD in Arrays** from **basic → optimized → advanced tricks** with full explanation and dry runs.

---

# 🔷 Problem 1: Find GCD of Entire Array

### Given:

```
arr = [12, 24, 18]
```

Find:

```
GCD(12, 24, 18)
```

---

# 🟢 Idea

We know:

```
GCD(a, b, c) = GCD(GCD(a, b), c)
```

So we reduce the array step by step.

---

# 🟢 Approach (Iterative GCD)

1. Start with first element
2. Take gcd with next element
3. Keep updating

---

## 💻 Code

```java
public class GCDArray {

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static int gcdArray(int[] arr) {
        int result = arr[0];

        for (int i = 1; i < arr.length; i++) {
            result = gcd(result, arr[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {12, 24, 18};
        System.out.println(gcdArray(arr));
    }
}
```

---

# 🧪 Dry Run

```
arr = [12, 24, 18]
```

Step 1:

```
result = 12
```

Step 2:

```
GCD(12, 24) = 12
```

Step 3:

```
GCD(12, 18) = 6
```

✅ Final Answer = 6

---

# ⏱ Time Complexity

If n elements:

```
O(n * log(max_element))
```

Very efficient.

---

# 🔷 Problem 2: Find GCD of Array Except One Element

Very important interview question 🔥

### Given:

```
arr = [12, 15, 18]
```

Find maximum GCD possible after removing one element.

---

# 🟢 Brute Force

For each index:

1. Remove element
2. Compute GCD of remaining array

Time:

```
O(n² log n)
```

Too slow.

---

# 🔴 Optimized Approach (Prefix + Suffix GCD)

### Idea:

Precompute:

```
prefix[i] = GCD of elements from 0 → i
suffix[i] = GCD of elements from i → n-1
```

Then for removing index i:

```
GCD = GCD(prefix[i-1], suffix[i+1])
```

---

## 💻 Code

```java
public class GCDExceptOne {

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static int maxGCDAfterRemovingOne(int[] arr) {

        int n = arr.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        prefix[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = gcd(prefix[i - 1], arr[i]);
        }

        suffix[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = gcd(suffix[i + 1], arr[i]);
        }

        int max = 0;

        for (int i = 0; i < n; i++) {

            int currentGCD;

            if (i == 0)
                currentGCD = suffix[1];
            else if (i == n - 1)
                currentGCD = prefix[n - 2];
            else
                currentGCD = gcd(prefix[i - 1], suffix[i + 1]);

            max = Math.max(max, currentGCD);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = {12, 15, 18};
        System.out.println(maxGCDAfterRemovingOne(arr));
    }
}
```

---

# 🧪 Dry Run

```
arr = [12, 15, 18]
```

### Prefix:

```
[12, GCD(12,15)=3, GCD(3,18)=3]
→ [12, 3, 3]
```

### Suffix:

```
[?, ?, 18]
GCD(15,18)=3
GCD(12,3)=3
→ [3, 3, 18]
```

Now try removing:

Remove 12:

```
GCD(15,18) = 3
```

Remove 15:

```
GCD(12,18) = 6
```

Remove 18:

```
GCD(12,15) = 3
```

✅ Max = 6

---

# ⏱ Time Complexity

```
O(n log n)
```

Space:

```
O(n)
```

Very efficient.

---

# 🔷 Problem 3: Count Subarrays with GCD = K

Advanced competitive programming topic.

---

# 🔥 Important GCD Array Properties

1. GCD never increases when adding more numbers.
2. If entire array GCD = 1 → eventually becomes 1 quickly.
3. Prefix/Suffix trick is very common.

---

# 🔥 Interview Important Patterns

| Pattern            | Use               |
| ------------------ | ----------------- |
| Full array GCD     | Reduction         |
| Remove one element | Prefix + Suffix   |
| Subarray GCD       | Map + Rolling GCD |
| GCD queries        | Segment Tree      |

---

# 🎯 Since you're serious about DSA

If you want next, I can teach:

* 🔥 Subarray GCD counting
* 🔥 GCD Segment Tree
* 🔥 LCM array problems
* 🔥 GCD + prefix sum combined tricks

Tell me your level — interview prep or competitive coding? 🚀

## using Euclidean Algorithm --
Good 👍 this matches exactly what I explained earlier.

Your note says:

> **Given an array → find the GCD of that array**
> Example: `{6, 12, 15}` → Answer = **3**

Let’s rewrite it cleanly with proper explanation, dry run, and full optimized code.

---

# ✅ Problem

Given an array:

```
arr = {6, 12, 15}
```

Find:

```
GCD(6, 12, 15)
```

---

# 🧠 Core Idea

We use the property:

[
GCD(a, b, c) = GCD(GCD(a, b), c)
]

So we keep reducing the array into one answer.

---

# 🔍 Dry Run (Step-by-step)

### Array:

```
{6, 12, 15}
```

### Step 1:

```
ans = 6
```

### Step 2:

```
ans = GCD(6, 12)
```

Compute:

```
12 % 6 = 0
GCD = 6
```

Now:

```
ans = 6
```

### Step 3:

```
ans = GCD(6, 15)
```

Compute:

```
15 % 6 = 3
6 % 3 = 0
GCD = 3
```

Final:

```
ans = 3 ✅
```

---

# ⏱ Time Complexity

For N elements:

```
O(N × log(max_element))
```

Because each GCD takes `log(max)` time.

Your note shows:

```
T.C → O(N × log(max))
```

✔ Correct.

---

# 💻 Full Optimized Code (Java)

```java
public class GCDArray {

    // Euclidean Algorithm
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int findGCD(int[] arr) {
        int ans = arr[0];

        for (int i = 1; i < arr.length; i++) {
            ans = gcd(ans, arr[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {6, 12, 15};
        System.out.println(findGCD(arr));
    }
}
```

---

# 🔥 Why This Is Optimal?

Because:

* We only traverse array once → **O(N)**
* Each gcd is logarithmic → **O(log max)**

So overall:

```
O(N log max)
```

You cannot do better than this.

---

# 🧠 Interview Tip

If interviewer asks:

👉 What if array has negative numbers?

Answer:

```
GCD(-a, b) = GCD(|a|, |b|)
```

So always take absolute value.

---

If you want next level 🚀:

* 🔥 GCD of array except one element
* 🔥 Count subarrays with GCD = K
* 🔥 GCD queries (Segment Tree)
* 🔥 Using GCD in competitive coding tricks

Tell me your goal — placements or competitive programming?
