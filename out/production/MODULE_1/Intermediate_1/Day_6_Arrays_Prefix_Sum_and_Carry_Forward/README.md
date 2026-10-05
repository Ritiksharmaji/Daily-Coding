## ----- Problem-1: Given N array elements  and Q queries, for each Query, calculate sum of elements from Left to Right(Both inclusive).
## ----- Problem-2: Given N array elements  and Q queries, for each query calculate sum of all even indexed elements from left to Right(Inclusive).
## ----- Problem-3: Given a String s of lowerCase characters , return count of pairs such that i<j and s[i] = 'a', s[j] = 'g' .
## ----- Problem-4: count of total subarrays in given array ----


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

## ----- Problem-1: Given N array elements  and Q queries, for each Query, calculate sum of elements from Left to Right(Both inclusive).
This is one of the **most important Prefix Sum problems**. Every DSA course teaches it because it shows **why Prefix Sum exists**.

I'll explain it from **Brute Force → Better → Optimal**, with examples, dry runs, diagrams, and code.

---

# Problem Statement

You are given:

* An array of size `N`
* `Q` queries

Each query contains:

```text
(L, R)
```

For every query, print the sum from index **L** to **R** (both inclusive).

---

## Example

```text
Array

Index

0   1  2  3  4  5  6   7  8  9

-3  6  2  4  5  2  8  -9 3  1
```

Queries

```java
int[][] queries = {
    {4,8},
    {3,7},
    {1,3}
};
```

---

# Query 1

```text
(4,8)
```

Need

```text
5 + 2 + 8 + (-9) + 3
```

Answer

```text
9
```

---

# Query 2

```text
(3,7)
```

Need

```text
4 + 5 + 2 + 8 + (-9)
```

Answer

```text
10
```

---

# Query 3

```text
(1,3)
```

Need

```text
6 + 2 + 4
```

Answer

```text
12
```

---

# Approach 1 — Brute Force

## Idea

For every query,

loop from

```text
L → R
```

and calculate the sum.

---

## Algorithm

For every query

```
sum = 0

for(i=L;i<=R;i++)

    sum+=array[i]
```

---

# Dry Run

Array

```text
-3 6 2 4 5 2 8 -9 3 1
```

Query

```text
(4,8)
```

Start

```text
sum=0
```

Add

```text
5

sum=5
```

Add

```text
2

sum=7
```

Add

```text
8

sum=15
```

Add

```text
-9

sum=6
```

Add

```text
3

sum=9
```

Answer

```text
9
```

---

## Brute Force Code

```java
public class Problem_1 {

    public static void main(String[] args){

        int[] array = {-3,6,2,4,5,2,8,-9,3,1};

        int[][] queries = {
                {4,8},
                {3,7},
                {1,3}
        };

        for(int q=0;q<queries.length;q++){

            int left = queries[q][0];
            int right = queries[q][1];

            int sum = 0;

            for(int i=left;i<=right;i++){
                sum += array[i];
            }

            System.out.println(sum);
        }
    }
}
```

---

# Complexity

Suppose

```text
N=100000

Q=100000
```

Worst case

Every query scans

```text
N elements
```

Total

```text
Q × N
```

Complexity

```
O(Q × N)
```

Very slow.

---

# Can we Optimize?

Instead of calculating the same sums repeatedly,

store the cumulative sums once.

This is called

# Prefix Sum

---

# Prefix Sum

Definition

```text
prefix[i]

=

sum of elements

from index 0 to i
```

---

Array

```text
-3 6 2 4 5 2 8 -9 3 1
```

---

Build Prefix

Index 0

```text
-3
```

Index 1

```text
-3+6=3
```

Index 2

```text
3+2=5
```

Index 3

```text
5+4=9
```

Index 4

```text
9+5=14
```

Index 5

```text
14+2=16
```

Index 6

```text
16+8=24
```

Index 7

```text
24-9=15
```

Index 8

```text
15+3=18
```

Index 9

```text
18+1=19
```

Final Prefix

```text
Index

0 1 2 3 4 5 6 7 8 9

-3 3 5 9 14 16 24 15 18 19
```

---

# Why Prefix Works

Suppose query

```text
(4,8)
```

Need

```text
5 2 8 -9 3
```

Instead of adding again,

Use

```text
prefix[8]

-

prefix[3]
```

Diagram

```text
Array

-3 6 2 4 | 5 2 8 -9 3

0  1 2 3 |4 5 6 7 8

prefix[8]=18

prefix[3]=9

18-9=9
```

Correct.

---

# Formula

If

```text
L==0
```

Answer

```text
prefix[R]
```

Otherwise

```text
prefix[R]-prefix[L-1]
```

This is the most important Prefix Sum formula.

---

# Dry Run

Query

```text
(3,7)
```

Need

```text
4+5+2+8-9
```

Formula

```text
prefix[7]

-

prefix[2]
```

```text
15-5
```

```text
10
```

Correct.

---

# Optimized Code

```java
public class Problem_1 {

    public static void main(String[] args){

        int[] array = {-3,6,2,4,5,2,8,-9,3,1};

        int[][] queries = {
                {4,8},
                {3,7},
                {1,3}
        };

        // Build Prefix Sum
        int[] prefix = new int[array.length];

        prefix[0] = array[0];

        for(int i=1;i<array.length;i++){
            prefix[i] = prefix[i-1] + array[i];
        }

        // Answer Queries
        for(int q=0;q<queries.length;q++){

            int L = queries[q][0];
            int R = queries[q][1];

            int sum;

            if(L==0)
                sum = prefix[R];
            else
                sum = prefix[R] - prefix[L-1];

            System.out.println(sum);
        }
    }
}
```

---

# Complexity

Building Prefix

```text
O(N)
```

Every Query

```text
O(1)
```

Total

```text
O(N+Q)
```

Huge improvement over

```text
O(N×Q)
```

---

# Visual Comparison

### Brute Force

```
Query

↓

Loop L→R

↓

Answer

↓

Next Query

↓

Loop Again
```

Time

```
O(Q×N)
```

---

### Prefix Sum

```
Build Prefix Once

↓

Answer Every Query

Using

prefix[R]-prefix[L-1]
```

Time

```
O(N+Q)
```

---

# Comparison Table

| Approach             | Preprocessing | Per Query | Total Time | Space |
| -------------------- | ------------- | --------- | ---------- | ----- |
| Brute Force          | None          | O(N)      | O(Q × N)   | O(1)  |
| Prefix Sum (Optimal) | O(N)          | O(1)      | O(N + Q)   | O(N)  |

---

## Interview Tip

Whenever a problem asks:

* Multiple **range sum** queries
* Sum from **L to R**
* Many queries on a fixed array

Think **Prefix Sum** immediately.

The key formula to remember is:

```java
if (L == 0)
    sum = prefix[R];
else
    sum = prefix[R] - prefix[L - 1];
```

This formula is the foundation for many advanced topics like **2D Prefix Sum**, **Difference Arrays**, and **Fenwick Trees (Binary Indexed Trees)**.


## ----- Problem-2: Given N array elements  and Q queries, for each query calculate sum of all even indexed elements from left to Right(Inclusive).

 ## ----- Problem-3: Given a String s of lowerCase characters , return count of pairs such that i<j and s[i] = 'a', s[j] = 'g' .
Excellent. This is exactly how you should prepare for interviews. I'll explain it in the same style as DSA classroom notes: **Problem → Brute Force → Better → Optimized (Carry Forward)**, with **idea, code, dry run, diagrams, and complexity**.

---

# Problem Statement

Given a string **S** consisting of lowercase letters.

Count all pairs `(i, j)` such that

```text
i < j

S[i] = 'a'

S[j] = 'g'
```

---

## Example

```text
S = "abegag"

Index

0 1 2 3 4 5

a b e g a g
```

Need to count every pair

```text
(a,g)
```

where

```text
a comes before g
```

---

Possible pairs

```text
a(0) ---- g(3)

a(0) ---- g(5)

a(4) ---- g(5)
```

Answer

```text
3
```

---

# Method-1 : Brute Force

## Idea

For every `'a'`

search every character after it.

If you find `'g'`

increase answer.

---

## Flow

```text
For every character

        │
        ▼

Is it 'a' ?

        │
      Yes
        │
        ▼

Search all characters on right

        │
        ▼

Every time 'g' found

Answer++
```

---

## Code

```java
public static int countPairByBF(String s) {

    int ans = 0;

    for (int i = 0; i < s.length(); i++) {

        if (s.charAt(i) == 'a') {

            for (int j = i + 1; j < s.length(); j++) {

                if (s.charAt(j) == 'g') {
                    ans++;
                }

            }

        }

    }

    return ans;
}
```

---

# Dry Run

String

```text
a b e g a g

0 1 2 3 4 5
```

---

## i = 0

```text
a
```

Search

```text
b

e

g ✔

a

g ✔
```

Pairs

```text
(0,3)

(0,5)
```

Answer

```text
2
```

---

## i = 1

```text
b
```

Ignore.

---

## i = 2

```text
e
```

Ignore.

---

## i = 3

```text
g
```

Ignore.

---

## i = 4

```text
a
```

Search

```text
g ✔
```

Answer

```text
3
```

---

Final

```text
3
```

---

## Diagram

```text
a  b  e  g  a  g
↑
│──────────► g ✔

│──────────────────► g ✔

Pairs =2



a  b  e  g  a  g
            ↑
            │──► g ✔

Pairs =1

Total=3
```

---

## Complexity

Time

```text
O(N²)
```

Space

```text
O(1)
```

---

# Method-2 : Better

## Idea

Instead of increasing answer every time,

count total `'g'`

for every `'a'`.

---

## Flow

```text
Found 'a'

        │

Count all 'g'

        │

Store gCount

        │

ans += gCount
```

---

## Code

```java
public static int countPairByBetter(String s){

    int ans = 0;

    for(int i=0;i<s.length();i++){

        if(s.charAt(i)=='a'){

            int gCount=0;

            for(int j=i+1;j<s.length();j++){

                if(s.charAt(j)=='g'){
                    gCount++;
                }

            }

            ans+=gCount;

        }

    }

    return ans;

}
```

---

# Dry Run

String

```text
a b e g a g
```

---

First

```text
a
```

Count g

```text
g

g
```

Total

```text
2
```

Answer

```text
2
```

---

Second

```text
a
```

Count g

```text
g
```

Total

```text
1
```

Answer

```text
3
```

---

Diagram

```text
a  b  e  g  a  g

First a

↓

gCount=2

↓

Answer=2



Second a

↓

gCount=1

↓

Answer=3
```

---

Complexity

Time

```text
O(N²)
```

Still quadratic.

---

# Can We Do Better?

Notice something.

For

```text
a
```

we always count

```text
g
```

again and again.

Repeated work.

Can we already know

```text
How many g exist on right?
```

Yes.

That is

# Carry Forward

---

# Method-3 : Optimized (Carry Forward)

## Idea

Instead of moving left → right

move

```text
Right → Left
```

Why?

Because while moving from right,

we always know

```text
How many g have already appeared.
```

---

## Flow

```text
Start from Right

        │

If g

gCount++

        │

If a

ans += gCount
```

---

## Code

```java
public static int countPairByOptimize(String s){

    int gCount=0;

    int ans=0;

    for(int i=s.length()-1;i>=0;i--){

        if(s.charAt(i)=='g'){
            gCount++;
        }

        if(s.charAt(i)=='a'){
            ans+=gCount;
        }

    }

    return ans;

}
```

---

# Dry Run

String

```text
a b e g a g

0 1 2 3 4 5
```

Initial

```text
gCount=0

Answer=0
```

---

### i=5

```text
g
```

```text
gCount=1
```

---

### i=4

```text
a
```

Already know

```text
1 g
```

Answer

```text
1
```

---

### i=3

```text
g
```

```text
gCount=2
```

---

### i=2

```text
e
```

Nothing.

---

### i=1

```text
b
```

Nothing.

---

### i=0

```text
a
```

Already know

```text
2 g
```

Answer

```text
3
```

Done.

---

# Visualization

```text
a  b  e  g  a  g
               ↑
          gCount=1

a  b  e  g  a  g
            ↑
      ans+=1


a  b  e  g  a  g
         ↑
      gCount=2


a  b  e  g  a  g
↑
ans+=2

Total=3
```

---

# Why Carry Forward Works

Instead of asking

```text
How many g are after every a?
```

We reverse the thinking.

While moving from right,

we continuously maintain

```text
Number of g seen so far.
```

So whenever we meet an `'a'`, we instantly know **how many valid `'g'` characters lie to its right**, and we add that count to the answer.

No repeated scanning is needed.

---

# Comparison Table

| Method      | Idea                                           | Time     | Space    |
| ----------- | ---------------------------------------------- | -------- | -------- |
| Brute Force | For every `'a'`, search the right side         | O(N²)    | O(1)     |
| Better      | Count all `'g'`s for each `'a'`, then add once | O(N²)    | O(1)     |
| Optimized   | Traverse from right using Carry Forward        | **O(N)** | **O(1)** |

---

# Interview Takeaway

Whenever you see problems involving:

* `i < j`
* Counting pairs
* Elements to the **right** or **left**
* Questions like "how many X are after Y?"

think:

```text
Carry Forward
```

Ask yourself:

> "Can I maintain information while traversing once, instead of scanning repeatedly?"

That's the key insight behind the optimized solution.

## ----- Problem-4: count of total subarrays in given array ----
This is a great question because it teaches an important distinction:

> **Counting subarrays** is **not** a Prefix Sum problem.

Prefix Sum is used for **range sum queries**, while counting how many subarrays exist is a mathematical counting problem.

So before learning the **Contribution Technique**, there are really only **two approaches**.

---

# Problem Statement

Given an array of size **N**, count the total number of subarrays.

---

## Example

```text
Array

[3, 4, 5]

N = 3
```

Subarrays are

```text
[3]

[3,4]

[3,4,5]

[4]

[4,5]

[5]
```

Total

```text
6
```

---

# Method-1 : Brute Force

## Idea

Generate every possible subarray.

Every time a subarray is generated,

increase the count.

---

## Flow

```text
Start Index = 0

    │
    ▼

Generate

[3]

[3,4]

[3,4,5]

    │
    ▼

Start Index = 1

Generate

[4]

[4,5]

    │
    ▼

Start Index = 2

Generate

[5]
```

---

## Code

```java
public static int countSubarraysByBF(int[] array){

    int count = 0;

    for(int start = 0; start < array.length; start++){

        for(int end = start; end < array.length; end++){

            count++;

        }

    }

    return count;
}
```

---

# Dry Run

Array

```text
3 4 5
```

---

Start = 0

```text
End =0

[3]

count=1
```

```text
End =1

[3,4]

count=2
```

```text
End =2

[3,4,5]

count=3
```

---

Start =1

```text
[4]

count=4
```

```text
[4,5]

count=5
```

---

Start =2

```text
[5]

count=6
```

---

Final

```text
6
```

---

## Diagram

```text
3 4 5

↑

[3]

[3 4]

[3 4 5]



    ↑

    [4]

    [4 5]



        ↑

        [5]
```

---

## Complexity

Time

```text
O(N²)
```

Space

```text
O(1)
```

---

# Method-2 : Optimized (Mathematical Formula)

Observe a pattern.

For

```text
N=1
```

Subarrays

```text
1
```

---

For

```text
N=2
```

Subarrays

```text
3
```

---

For

```text
N=3
```

Subarrays

```text
6
```

---

For

```text
N=4
```

Subarrays

```text
10
```

---

Pattern

```text
1

3

6

10
```

This is the sum:

```text
1+2+3+...+N
```

Formula:

```text
N × (N + 1) / 2
```

---

## Why?

Suppose

```text
Array

3 4 5 6
```

Start index = 0

Possible subarrays

```text
4
```

Start index = 1

Possible

```text
3
```

Start index = 2

Possible

```text
2
```

Start index = 3

Possible

```text
1
```

Total

```text
4+3+2+1
```

which is

```text
N+(N-1)+(N-2)+...
```

or equivalently

```text
1+2+3+...+N
```

Formula

```text
N(N+1)/2
```

---

## Diagram

```text
Array

3 4 5 6

Start=0

↓

4 subarrays

Start=1

↓

3 subarrays

Start=2

↓

2 subarrays

Start=3

↓

1 subarray
```

Total

```text
4+3+2+1=10
```

---

## Code

```java
public static int countSubarraysByFormula(int[] array){

    int n = array.length;

    return n * (n + 1) / 2;
}
```

---

# Complete Program

```java
package Intermediate_1.Day_6_Arrays_Prefix_Sum_and_Carry_Forward.ClassVideo;

/*
Problem-4:
Count total number of subarrays.
*/

public class Problem_4 {

    // ==========================================
    // Method-1 : Brute Force
    // Time : O(N²)
    // Space : O(1)
    // ==========================================
    public static int countSubarraysByBF(int[] array){

        int count = 0;

        for(int start = 0; start < array.length; start++){

            for(int end = start; end < array.length; end++){

                count++;

            }

        }

        return count;
    }

    // ==========================================
    // Method-2 : Optimized Formula
    // Time : O(1)
    // Space : O(1)
    // ==========================================
    public static int countSubarraysByFormula(int[] array){

        int n = array.length;

        return n * (n + 1) / 2;
    }

    public static void main(String[] args){

        int[] array = {3,4,5,6};

        System.out.println("Brute Force : "
                + countSubarraysByBF(array));

        System.out.println("Formula : "
                + countSubarraysByFormula(array));

    }
}
```

---

# Comparison

| Method            | Idea                              | Time     | Space |
| ----------------- | --------------------------------- | -------- | ----- |
| Brute Force       | Generate every subarray and count | O(N²)    | O(1)  |
| Formula (Optimal) | Use `N × (N + 1) / 2`             | **O(1)** | O(1)  |

---

## Important Note

You asked:

> **"from BF to optimize till Prefix Sum, don't use Contribution Technique."**

For this specific problem, **Prefix Sum is not applicable**.

Why?

* Prefix Sum helps compute **sums of subarrays** quickly.
* This problem only asks for the **number of subarrays**, not their sums.

So the optimal solution comes from a **mathematical observation**, not from Prefix Sum or Contribution Technique.
