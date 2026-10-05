## ===== apply all left shift with right shift operater ====


## -----Q-3: subarrays having OR(given a binary array, find total number of subarrays the bitwise OR of which is 1)
Brute force → better → optimized → contribution logic → final code with diagram of zero blocks and formula derivation.
---
Absolutely — here’s the **full ladder** for this problem:

# Problem

> **Given a binary array, count total number of subarrays whose bitwise OR = 1**

We’ll do it in this order:

1. **Brute Force**
2. **Better**
3. **Optimized**
4. **Contribution / counting logic**
5. **Final Java code**
6. **Dry run + zero-block diagram**
7. **Formula derivation**

---

# 1) First understand the problem properly

Array contains only:

```text
0 and 1
```

We need to count subarrays whose **bitwise OR = 1**.

---

# 2) OR truth table for binary numbers

```text
0 | 0 = 0
0 | 1 = 1
1 | 0 = 1
1 | 1 = 1
```

So for a subarray:

* OR = **0** only if **every element is 0**
* OR = **1** if **at least one 1 is present**

This one line is the whole key.

---

# 3) Example array

Let’s use this throughout:

```java
A = [1, 0, 0, 1]
```

---

# 4) Brute Force approach

## Idea

Generate **every subarray**, compute OR, and count if OR = 1.

---

## Brute force code

```java
public class Main {
    public static void main(String[] args) {
        int[] a = {1, 0, 0, 1};
        int n = a.length;

        int count = 0;

        for (int i = 0; i < n; i++) {
            int or = 0;
            for (int j = i; j < n; j++) {
                or = or | a[j];   // OR of current subarray
                if (or == 1) {
                    count++;
                }
            }
        }

        System.out.println("Subarrays with OR = 1: " + count);
    }
}
```

---

# 5) Brute force dry run

## Array

```text
[1, 0, 0, 1]
```

All subarrays:

### Start i = 0

* `[1]` → OR = 1 ✔
* `[1,0]` → OR = 1 ✔
* `[1,0,0]` → OR = 1 ✔
* `[1,0,0,1]` → OR = 1 ✔

### Start i = 1

* `[0]` → OR = 0 ✘
* `[0,0]` → OR = 0 ✘
* `[0,0,1]` → OR = 1 ✔

### Start i = 2

* `[0]` → OR = 0 ✘
* `[0,1]` → OR = 1 ✔

### Start i = 3

* `[1]` → OR = 1 ✔

Total count:

```text
7
```

---

# 6) Brute force complexity

* Outer loop → `n`
* Inner loop → `n`

So:

```text
Time = O(n²)
Space = O(1)
```

This is okay for small input, but not best.

---

# 7) Better thinking

Instead of counting subarrays with **OR = 1**, ask:

## When does OR become 0?

Only when the subarray contains **all zeros**.

So:

[
\text{Subarrays with OR = 1}
============================

## \text{Total subarrays}

\text{Subarrays with OR = 0}
]

And **OR = 0** means:

```text
subarray contains only 0s
```

So now the problem becomes:

# Count all-zero subarrays

That’s much easier.

---

# 8) Better formula

## Total subarrays of array of size `n`

[
\text{Total} = \frac{n(n+1)}{2}
]

So answer becomes:

[
\text{Answer} = \frac{n(n+1)}{2} - \text{(all-zero subarrays)}
]

---

# 9) Now the real problem: count all-zero subarrays

Take the same array:

```text
[1, 0, 0, 1]
```

There is one block of consecutive zeroes:

```text
0 0
```

Length = `2`

Now ask:

## How many subarrays can be made only from this zero block?

Possible subarrays:

* `[0]`
* `[0]`
* `[0,0]`

Total = `3`

---

# 10) Formula for a zero block of length L

If you have:

```text
0 0 0 ... 0   (L times)
```

Then number of all-zero subarrays is:

[
\frac{L(L+1)}{2}
]

---

# 11) Why is the formula (L(L+1)/2)?

Suppose block length is `3`:

```text
0 0 0
```

Subarrays:

### Length 1

* `[0]`
* `[0]`
* `[0]`

Count = 3

### Length 2

* `[0,0]`
* `[0,0]`

Count = 2

### Length 3

* `[0,0,0]`

Count = 1

Total:

[
3 + 2 + 1 = 6
]

Formula:

[
\frac{3(4)}{2}=6
]

---

# 12) Zero block diagram

## Example 1

```text
Array: [1, 0, 0, 1]
            └──┬──┘
             zero block
             length = 2
```

Subarrays from this block:

```text
[0]
[0]
[0,0]
```

Count:

[
\frac{2(3)}{2}=3
]

---

## Example 2

```text
Array: [0,0,0,1,0,0]
        └─block1─┘   └block2┘
         length=3      length=2
```

Subarrays from block1:

[
\frac{3(4)}{2}=6
]

Subarrays from block2:

[
\frac{2(3)}{2}=3
]

Total all-zero subarrays:

[
6+3=9
]

---

# 13) Contribution logic

This is the clean optimized logic.

## Contribution of one zero block

If a consecutive zero block has length `L`, then its contribution to **all-zero subarrays** is:

[
\frac{L(L+1)}{2}
]

So if array has many zero blocks:

* block length = `L1`
* block length = `L2`
* block length = `L3`

Then total zero-only subarrays:

[
\frac{L_1(L_1+1)}{2}
+
\frac{L_2(L_2+1)}{2}
+
\frac{L_3(L_3+1)}{2}
]

Then final answer:

[
\text{Answer} = \frac{n(n+1)}{2} - \text{zeroSubarrays}
]

---

# 14) Full optimized process

## Step 1

Compute total subarrays:

[
\frac{n(n+1)}{2}
]

## Step 2

Traverse array and find zero blocks.

Keep a variable:

```text
countZero
```

* if current element is `0`, increase `countZero`
* if current element is `1`, it means zero block ended
  so add:

[
\frac{countZero(countZero+1)}{2}
]

to `zeroSubarrays`, then reset `countZero = 0`

## Step 3

After loop ends, if array ended with zeros, add the last zero block too.

## Step 4

Return:

[
\text{totalSubarrays} - \text{zeroSubarrays}
]

---

# 15) Optimized dry run on `[1,0,0,1]`

## Initial

```text
a = [1,0,0,1]
n = 4

totalSubarrays = 4*5/2 = 10
zeroSubarrays = 0
countZero = 0
```

---

## i = 0 → a[0] = 1

Not zero.

So zero block ended, but `countZero = 0`, so nothing to add.

```text
zeroSubarrays = 0
countZero = 0
```

---

## i = 1 → a[1] = 0

```text
countZero = 1
```

---

## i = 2 → a[2] = 0

```text
countZero = 2
```

---

## i = 3 → a[3] = 1

Now zero block ended.

Current zero block length = 2

Contribution:

[
\frac{2(3)}{2} = 3
]

So:

```text
zeroSubarrays = 3
countZero = 0
```

---

## End of loop

No pending zero block.

Final answer:

[
10 - 3 = 7
]

---

# 16) Visual diagram of this dry run

```text
Array = [1, 0, 0, 1]

Total subarrays = 10

Zero block found:
0 0
length = 2

All-zero subarrays from this block:
[0]
[0]
[0,0]

Count = 3

So OR = 1 subarrays:
10 - 3 = 7
```

---

# 17) Another example with multiple zero blocks

Take:

```text
A = [0,0,1,0,0,0,1]
```

Size = `7`

## Total subarrays

[
\frac{7(8)}{2}=28
]

## Zero blocks

### Block 1

```text
0 0
```

Length = 2

Contribution:

[
\frac{2(3)}{2}=3
]

### Block 2

```text
0 0 0
```

Length = 3

Contribution:

[
\frac{3(4)}{2}=6
]

## Total all-zero subarrays

[
3+6=9
]

## Final answer

[
28-9=19
]

---

# 18) Diagram for multiple zero blocks

```text
A = [0, 0, 1, 0, 0, 0, 1]
     └block1┘    └─block2─┘
      len=2         len=3

block1 contribution = 2*3/2 = 3
block2 contribution = 3*4/2 = 6

zeroSubarrays = 3 + 6 = 9
answer = 28 - 9 = 19
```

---

# 19) Final optimized Java code

```java
public class Main {
    public static void main(String[] args) {

        int[] a = {1, 0, 0, 1};
        int n = a.length;

        // Step 1: total number of subarrays
        int totalSubarrays = n * (n + 1) / 2;

        // Step 2: count all-zero subarrays
        int zeroSubarrays = 0;
        int countZero = 0;

        for (int i = 0; i < n; i++) {
            if (a[i] == 0) {
                countZero++;
            } else {
                // zero block ended, add its contribution
                zeroSubarrays += countZero * (countZero + 1) / 2;
                countZero = 0;
            }
        }

        // if array ends with zeros, add last block too
        zeroSubarrays += countZero * (countZero + 1) / 2;

        // Step 3: subarrays with OR = 1
        int ans = totalSubarrays - zeroSubarrays;

        System.out.println("Subarrays with OR = 1 = " + ans);
    }
}
```

---

# 20) Same code with comments on every line

```java
public class Main {
    public static void main(String[] args) {

        int[] a = {1, 0, 0, 1};
        int n = a.length;

        // Total number of subarrays in array
        int totalSubarrays = n * (n + 1) / 2;

        // This will store count of subarrays made of only zeros
        int zeroSubarrays = 0;

        // Length of current consecutive zero block
        int countZero = 0;

        for (int i = 0; i < n; i++) {

            // If current element is zero, extend zero block
            if (a[i] == 0) {
                countZero++;
            } else {
                // Current element is 1, so zero block ends here
                // Number of subarrays from zero block of length countZero:
                // countZero * (countZero + 1) / 2
                zeroSubarrays += countZero * (countZero + 1) / 2;

                // Reset zero block count
                countZero = 0;
            }
        }

        // If array ends with zeros, we still need to add last block
        zeroSubarrays += countZero * (countZero + 1) / 2;

        // OR = 1 subarrays = total subarrays - all-zero subarrays
        int ans = totalSubarrays - zeroSubarrays;

        System.out.println("Subarrays with OR = 1 = " + ans);
    }
}
```

---

# 21) Brute force vs optimized

## Brute force

For every subarray:

* compute OR
* if OR = 1, count it

### Time

[
O(n^2)
]

---

## Optimized

* count total subarrays
* count all-zero subarrays using zero blocks
* subtract

### Time

[
O(n)
]

---

# 22) Side-by-side summary

| Approach    | Idea                                      |  Time |
| ----------- | ----------------------------------------- | ----: |
| Brute force | Generate every subarray and compute OR    | O(n²) |
| Better      | Realize OR=0 only for all-zero subarrays  |     — |
| Optimized   | Count zero blocks and subtract from total |  O(n) |

---

# 23) Final formula sheet

If array size is `n`:

## Total subarrays

[
\frac{n(n+1)}{2}
]

If zero blocks have lengths:

[
L_1, L_2, L_3, ...
]

then:

## All-zero subarrays

[
\frac{L_1(L_1+1)}{2}
+
\frac{L_2(L_2+1)}{2}
+
\frac{L_3(L_3+1)}{2}
+\cdots
]

## Final answer

[
\text{Subarrays with OR = 1}
============================

## \frac{n(n+1)}{2}

\sum \frac{L(L+1)}{2}
]

---

# 24) Interview-style one-line answer

For a binary array, **OR of a subarray is 1 iff the subarray contains at least one 1**.
So instead of directly counting OR=1 subarrays, count **all-zero subarrays** using lengths of consecutive zero blocks, and subtract from total subarrays.

---

If you want, next I can do the **same complete ladder** for the related question:

## **“Count subarrays having AND = 1 in a binary array”**

because that one is the **mirror opposite** of this OR problem and is very important for interviews/Scaler DSA.

## ------ Q - 
```declarative
 // If array ends with zeros, we still need to add last block
        zeroSubarrays += countZero * (countZero + 1) / 2;
why we are doing this ?? 

```
Excellent question. This is exactly the kind of detail interviewers ask.

The short answer is:

> **We don't need an `if` because if the array does not end with `0`, then `countZero` will already be `0`, so adding `0` changes nothing.**

Let's understand it with examples.

---

# Case 1: Array ends with `1`

```text
A = [1, 0, 0, 1]
```

### Dry run

Initially

```text
countZero = 0
zeroSubarrays = 0
```

### i = 0

```text
1
```

Not zero.

```text
zeroSubarrays += 0*(1)/2 = 0

countZero = 0
```

---

### i = 1

```text
0
```

```text
countZero = 1
```

---

### i = 2

```text
0
```

```text
countZero = 2
```

---

### i = 3

```text
1
```

Now the zero block ends.

Add contribution:

```text
2 * 3 / 2 = 3
```

Now

```text
zeroSubarrays = 3
countZero = 0
```

Loop finishes.

Now this line executes:

```java
zeroSubarrays += countZero * (countZero + 1) / 2;
```

Since

```text
countZero = 0
```

it becomes

```text
zeroSubarrays += 0
```

Nothing changes.

So it's perfectly safe.

---

# Case 2: Array ends with `0`

Example

```text
A = [1,0,0]
```

### Dry run

Initially

```text
countZero = 0
```

---

### i = 0

```text
1
```

Add

```text
0
```

Reset

```text
countZero = 0
```

---

### i = 1

```text
0
```

```text
countZero = 1
```

---

### i = 2

```text
0
```

```text
countZero = 2
```

Loop ends.

Notice something.

We **never encountered another `1`**.

Therefore the last zero block was never processed.

So after loop

```text
countZero = 2
```

Now this line

```java
zeroSubarrays += countZero * (countZero + 1) / 2;
```

becomes

```text
2 * 3 / 2 = 3
```

Now the last zero block is counted.

---

# Why don't we write an if?

You could write

```java
if (countZero > 0) {
    zeroSubarrays += countZero * (countZero + 1) / 2;
}
```

But it is unnecessary.

Because when

```text
countZero == 0
```

the formula automatically becomes

```text
0 * 1 / 2 = 0
```

Adding zero does nothing.

So both codes are identical.

---

# Visual explanation

## Example 1

```text
1 0 0 1
      ^
      Block ends here

Already counted inside loop.

Loop ends

countZero = 0

Add 0

Done
```

---

## Example 2

```text
1 0 0
    ^
    Block never ended

Loop ends

countZero = 2

Need to add

2×3/2 = 3
```

---

# Think of it like this

Inside the loop, we only process a zero block when we see a `1`.

```text
0 0 0 1
      ^
      "Okay, block finished."
```

But what if the array finishes before another `1` comes?

```text
0 0 0
     ^
     End of array
```

Who will process this last block?

👉 That's exactly why we have the extra line after the loop.

---

# A common pattern in DSA

You'll see this same idea in many problems:

```java
for (...) {

    if (condition changes) {
        process current group;
        reset;
    }
}

// Process the last group
process current group;
```

Examples include:

* Counting consecutive `0`s or `1`s
* Run-length encoding
* String compression
* Grouping identical elements
* Interval merging

The final processing step is written **unconditionally**, because if there's nothing left to process, it naturally contributes `0`. This keeps the code simpler and avoids an extra `if`.

## ========== Q-4: Maximum and pair(Given positive array elements, find the maximum value of arr[i] & arr[j] where i != j )
