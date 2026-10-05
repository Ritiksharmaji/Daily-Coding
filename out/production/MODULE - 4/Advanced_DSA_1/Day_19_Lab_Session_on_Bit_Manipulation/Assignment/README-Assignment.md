## ===== Q3. Finding Good Days ====


## ===== Q3. Finding Good Days ====
This problem is actually a **Bit Manipulation** problem.

---

# Step 1: Understand the question

Food produced each day:

| Day | Food Produced |
| --- | ------------: |
| 1   |             1 |
| 2   |             2 |
| 3   |             4 |
| 4   |             8 |
| 5   |            16 |
| 6   |            32 |

Notice:

```text
1, 2, 4, 8, 16, 32...
```

These are **powers of 2**.

---

# Step 2: What does "Boomer is well behaved" mean?

Boomer gets food **only on some days**.

Suppose she behaves on:

* Day 1 → gets 1
* Day 3 → gets 4
* Day 5 → gets 16

Total food:

```text
1 + 4 + 16 = 21
```

So if

```text
A = 21
```

we have:

```text
21 = 16 + 4 + 1
```

---

# Step 3: Convert to Binary

Let's write 21 in binary.

```text
21 = 10101₂
```

Now match it with powers of 2.

```text
16   
```
This is one of the easiest and most important **Bit Manipulation** questions. I'll explain it exactly the way you like:

1. **Understand the problem**
2. **Brute Force (BF)**
3. **Better**
4. **Optimized (Bit Manipulation)**
5. **Dry Run**
6. **Flow Diagram**
7. **Java Code**

---

# Problem

Alex produces food like this:

| Day   | Food Produced |
| ----- | ------------: |
| Day 1 |             1 |
| Day 2 |             2 |
| Day 3 |             4 |
| Day 4 |             8 |
| Day 5 |            16 |
| Day 6 |            32 |
| Day 7 |            64 |

Every day the food doubles.

Boomer receives food **only if she behaves**.

Suppose

```text
Day1 ✓
Day2 ✗
Day3 ✓
Day4 ✗
Day5 ✓
```

Food received

```text
1 + 4 + 16 = 21
```

So

```text
A = 21
```

Question:

> **How many good days did Boomer behave?**

Answer:

```text
3
```

---

# Observation

Every day's food is a power of 2.

```text
Day1 → 1  = 2^0
Day2 → 2  = 2^1
Day3 → 4  = 2^2
Day4 → 8  = 2^3
Day5 →16  = 2^4
```

Every number can be written as the sum of powers of two.

Example

```text
21

=16+4+1
```

Binary

```text
21 = 10101
```

```
16 8 4 2 1
 1 0 1 0 1
```

There are **3 ones**.

So

```text
Good Days = Number of Set Bits
```

---

# Approach 1 (Brute Force)

## Idea

Generate powers of two.

Subtract the largest possible.

Count how many times you subtract.

---

## Example

```
A = 21

Largest power <=21

16

21-16=5

count=1
```

Remaining

```
5
```

Largest power

```
4
```

```
5-4=1

count=2
```

Remaining

```
1
```

Largest power

```
1
```

```
1-1=0

count=3
```

Answer

```
3
```

---

## Brute Force Code

```java
public class Solution {

    public int solve(int A) {

        int count = 0;

        while (A > 0) {

            int power = 1;

            while (power * 2 <= A) {
                power = power * 2;
            }

            A = A - power;
            count++;
        }

        return count;
    }
}
```

---

## Complexity

Finding largest power every time

```
O(logA)
```

Outer loop

```
Worst O(logA)
```

Total

```
O((logA)^2)
```

---

# Approach 2 (Better)

Instead of subtracting,

check every bit.

If bit is set

increase count.

---

## Example

```
21
```

Binary

```
10101
```

Check

```
Bit0 →1 ✔

Bit1 →0

Bit2 →1 ✔

Bit3 →0

Bit4 →1 ✔
```

Count

```
3
```

---

## Code

```java
public class Solution {

    public int solve(int A) {

        int count = 0;

        for (int i = 0; i < 32; i++) {

            if ((A & (1 << i)) != 0) {
                count++;
            }
        }

        return count;
    }
}
```

---

## Complexity

```
32 iterations

O(32)

≈ O(1)
```

---

# Approach 3 (Optimized)

Use

```
A & 1
```

to check last bit.

Then

```
A >> 1
```

to remove last bit.

---

## Dry Run

```
A=21
```

Binary

```
10101
```

---

### Iteration 1

```
10101
&
00001
------
00001
```

Last bit

```
1
```

count

```
1
```

Shift

```
1010
```

---

### Iteration 2

```
1010

Last bit

0
```

count

```
1
```

Shift

```
101
```

---

### Iteration 3

```
101

Last bit

1
```

count

```
2
```

Shift

```
10
```

---

### Iteration 4

```
10

Last bit

0
```

Shift

```
1
```

---

### Iteration 5

```
1

Last bit

1
```

count

```
3
```

Shift

```
0
```

Stop.

Answer

```
3
```

---

## Code

```java
public class Solution {

    public int solve(int A) {

        int count = 0;

        while (A > 0) {

            if ((A & 1) == 1) {
                count++;
            }

            A = A >> 1;
        }

        return count;
    }
}
```

---

## Complexity

Number of bits

```
32
```

Time

```
O(32)

≈ O(1)
```

---

# Approach 4 (Most Optimized)

This is **Brian Kernighan's Algorithm**.

Instead of checking every bit,

remove one set bit every iteration.

Formula

```
A = A & (A-1)
```

It removes the **rightmost set bit**.

---

## Example

```
21

10101
```

---

### First

```
10101
10100
-----
10100
```

Removed one set bit.

Count

```
1
```

---

### Second

```
10100
10011
-----
10000
```

Count

```
2
```

---

### Third

```
10000
01111
-----
00000
```

Count

```
3
```

Stop.

---

## Code

```java
public class Solution {

    public int solve(int A) {

        int count = 0;

        while (A > 0) {

            A = A & (A - 1);
            count++;
        }

        return count;
    }
}
```

---

## Complexity

Suppose

```
A=111111111111
```

12 ones

Loop runs

```
12
```

Suppose

```
100000000000
```

Only one set bit

Loop runs

```
1
```

Time

```
O(Number of Set Bits)
```

This is the fastest method.

---

# Flow Diagram

```text
                 START
                    │
                    ▼
            Read integer A
                    │
                    ▼
       Is A greater than 0 ?
              │           │
            Yes          No
              │           │
              ▼           ▼
      Count one set bit   Return Count
      using chosen method
              │
              ▼
       Update A (shift or
      A = A & (A - 1))
              │
              └──────────────► Repeat
```

---

# Comparison

| Approach    | Idea                                     | Time                      | Space |
| ----------- | ---------------------------------------- | ------------------------- | ----- |
| Brute Force | Repeatedly subtract largest power of 2   | O((log A)²)               | O(1)  |
| Better      | Check all 32 bits using `(A & (1 << i))` | O(32)                     | O(1)  |
| Optimized   | Check last bit and right shift           | O(number of bits) ≈ O(32) | O(1)  |
| Best        | Brian Kernighan (`A = A & (A-1)`)        | O(number of set bits)     | O(1)  |

## Interview Tip

When you see a problem asking for:

* **number of powers of 2 used**
* **number of good days** (like this problem)
* **minimum powers of 2 to represent a number**
* **count of `1`s in binary**

Immediately think:

> **This is a "count set bits" problem.**
