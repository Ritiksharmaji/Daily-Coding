## ----- Assignment-1 ----

## ----- Assignment-2 ----

## ------- Assignment-3-----
Yes. Here’s the **full approach for “3 unique numbers, all others appear twice”** — with the **flow**, **why it works**, **one full example**, **dry run**, and **Java code**.

---

# 1) Problem

You have an array where:

* **every normal element appears exactly twice**
* **exactly 3 elements appear once**

You need to find those **3 unique numbers**.

Example:

```java
[4, 5, 5, 6, 6, 1, 2, 2, 7]
```

Here:

* `5` appears twice
* `6` appears twice
* `2` appears twice

Unique numbers are:

```java
4, 1, 7
```

---

# 2) Important truth first

For **2 unique numbers**, there is a clean direct XOR trick:

* XOR all → `x ^ y`
* find one set bit
* split into 2 groups
* done

For **3 unique numbers**, there is **no single direct one-shot XOR trick** that always gives all 3 immediately.

So the strategy is:

## Strategy

1. Try to isolate **one** unique number using a bit split
2. Once one unique number is found, the remaining array behaves like the **2 unique numbers** problem
3. Use the old XOR trick to find the remaining two

So the full plan is:

```text
Find 1 unique  ->  Remove it logically  ->  Solve remaining 2 unique
```

---

# 3) Main idea

Suppose the 3 unique numbers are:

```text
x, y, z
```

and all others appear twice.

If we XOR the whole array:

```text
xorAll = x ^ y ^ z
```

That alone does **not** directly give all 3.

So instead, we try every bit position from `0 to 31`.

For each bit position `bit`:

* split the array into two groups:

    * **Group 1** → numbers having `bit` set
    * **Group 2** → numbers having `bit` unset

Now because duplicates are identical, both copies always go to the **same group**, so they cancel by XOR inside that group.

So if Group 1 happens to contain **exactly one unique number**, then XOR of Group 1 becomes **that unique number directly**.

That is the trick.

---

# 4) Full flow diagram

## Overall flow

```text
Start
  |
  v
Try bit = 0 to 31
  |
  v
Make Group1 = numbers with this bit set
Make Group2 = numbers with this bit unset
  |
  v
XOR all numbers in Group1 -> candidate
  |
  v
Does candidate appear exactly once in original array?
  |
  +---- No ----> try next bit
  |
  +---- Yes ----> candidate is one unique number
                    |
                    v
             Now remove candidate logically
             XOR remaining numbers
                    |
                    v
             remaining = two-unique problem
                    |
                    v
             find last 2 unique numbers
                    |
                    v
                  End
```

---

# 5) Why “candidate appears exactly once” is the test

Suppose for some bit:

* Group 1 gets exactly one unique number, say `u`
* all duplicates in Group 1 cancel

Then XOR of Group 1 = `u`

So if the XOR result `candidate` appears **exactly once** in the original array, that is a strong sign that we isolated a real unique number.

Then we can use it.

---

# 6) Full example

Take:

```java
int[] a = {4, 5, 5, 6, 6, 1, 2, 2, 7};
```

Unique numbers are:

```text
4, 1, 7
```

But assume we don’t know that.

---

# 7) Binary values

Let’s write in 3-bit form:

| Number | Binary |
| ------ | ------ |
| 4      | 100    |
| 5      | 101    |
| 5      | 101    |
| 6      | 110    |
| 6      | 110    |
| 1      | 001    |
| 2      | 010    |
| 2      | 010    |
| 7      | 111    |

---

# 8) Try bit 0

We split numbers by **bit 0**.

## bit 0 = 1 group

Numbers with last bit set:

* `5 (101)`
* `5 (101)`
* `1 (001)`
* `7 (111)`

So Group 1:

```text
[5, 5, 1, 7]
```

XOR:

```text
5 ^ 5 ^ 1 ^ 7
= 0 ^ 1 ^ 7
= 6
```

So candidate = `6`

But `6` appears **twice** in the array, not once.

So this bit **did not isolate one unique number**.

---

# 9) Try bit 1

Numbers with bit 1 set:

* `6 (110)`
* `6 (110)`
* `2 (010)`
* `2 (010)`
* `7 (111)`

Group 1:

```text
[6, 6, 2, 2, 7]
```

XOR:

```text
6 ^ 6 ^ 2 ^ 2 ^ 7
= 0 ^ 0 ^ 7
= 7
```

Candidate = `7`

Now check frequency of `7` in original array:

* it appears **exactly once**

So **7 is one unique number**.

Great — we found the first unique.

---

# 10) Now find the remaining two

We already found:

```text
firstUnique = 7
```

Now we need to find the remaining two unique numbers.

The remaining array effectively becomes:

```text
[4, 5, 5, 6, 6, 1, 2, 2]
```

Now this is the standard problem:

> every element occurs twice except **two** elements

Those two are `4` and `1`.

---

# 11) How to find the remaining two

Now XOR **all numbers except the isolated one**.

So XOR everything except one occurrence of `7`:

```text
4 ^ 5 ^ 5 ^ 6 ^ 6 ^ 1 ^ 2 ^ 2
= 4 ^ 1
= 5
```

So:

```text
remainingXor = 5
```

Binary of `5` is:

```text
101
```

Find first set bit → bit `0`

Now split **remaining numbers** by bit `0`:

### bit 0 set

* `5, 5, 1`

XOR = `1`

### bit 0 unset

* `4, 6, 6, 2, 2`

XOR = `4`

So remaining two uniques are:

```text
1 and 4
```

Final answer:

```text
7, 1, 4
```

---

# 12) Full dry run table for the example

Array:

```text
[4, 5, 5, 6, 6, 1, 2, 2, 7]
```

---

## Part A — find first unique by trying bits

### Try bit 0

Group with bit 0 set:

```text
5, 5, 1, 7
```

XOR:

```text
5 ^ 5 ^ 1 ^ 7
= 6
```

Candidate = `6`

Frequency of `6` = 2 → reject

---

### Try bit 1

Group with bit 1 set:

```text
6, 6, 2, 2, 7
```

XOR:

```text
6 ^ 6 ^ 2 ^ 2 ^ 7
= 7
```

Candidate = `7`

Frequency of `7` = 1 → accept

So first unique = `7`

---

## Part B — find remaining two uniques

Ignore one `7`

Remaining numbers:

```text
4, 5, 5, 6, 6, 1, 2, 2
```

XOR all:

```text
4 ^ 5 ^ 5 ^ 6 ^ 6 ^ 1 ^ 2 ^ 2
= 4 ^ 1
= 5
```

remainingXor = `5`

First set bit = bit `0`

Split by bit `0`:

### set group

```text
5, 5, 1
```

XOR = `1`

### unset group

```text
4, 6, 6, 2, 2
```

XOR = `4`

So final answer:

```text
7, 1, 4
```

---

# 13) Java code

Below is a clean Java implementation for this approach.

```java
import java.util.*;

public class Main {

    // check ith bit is set or not
    public static boolean checkSetBit(int num, int bit) {
        return (num & (1 << bit)) != 0;
    }

    // count frequency of target in array
    public static int countFreq(int[] a, int target) {
        int count = 0;
        for (int x : a) {
            if (x == target) count++;
        }
        return count;
    }

    // solve remaining 2 unique numbers after one unique is known
    public static int[] findTwoUnique(int[] a, int skipValue) {
        int xor = 0;
        boolean skipped = false;

        // XOR all elements except ONE occurrence of skipValue
        for (int x : a) {
            if (x == skipValue && !skipped) {
                skipped = true;   // skip only one occurrence
                continue;
            }
            xor ^= x;
        }

        // find first set bit in xor
        int position = 0;
        for (int i = 0; i < 32; i++) {
            if (checkSetBit(xor, i)) {
                position = i;
                break;
            }
        }

        int first = 0, second = 0;
        skipped = false;

        // divide remaining numbers into 2 groups
        for (int x : a) {
            if (x == skipValue && !skipped) {
                skipped = true;   // again skip only one occurrence
                continue;
            }

            if (checkSetBit(x, position)) {
                first ^= x;
            } else {
                second ^= x;
            }
        }

        return new int[]{first, second};
    }

    public static void findThreeUnique(int[] a) {
        int firstUnique = -1;

        // Try every bit position to isolate one unique number
        for (int bit = 0; bit < 32; bit++) {
            int candidate = 0;

            // XOR numbers whose bit 'bit' is set
            for (int x : a) {
                if (checkSetBit(x, bit)) {
                    candidate ^= x;
                }
            }

            // If candidate appears exactly once, we found one unique number
            if (candidate != 0 && countFreq(a, candidate) == 1) {
                firstUnique = candidate;
                break;
            }
        }

        if (firstUnique == -1) {
            System.out.println("No valid unique numbers found");
            return;
        }

        // Find remaining 2 unique numbers
        int[] remaining = findTwoUnique(a, firstUnique);

        System.out.println("Three unique numbers are:");
        System.out.println(firstUnique + " " + remaining[0] + " " + remaining[1]);
    }

    public static void main(String[] args) {
        int[] a = {4, 5, 5, 6, 6, 1, 2, 2, 7};
        findThreeUnique(a);
    }
}
```

---

# 14) Output for this example

For:

```java
int[] a = {4, 5, 5, 6, 6, 1, 2, 2, 7};
```

Output can be:

```text
Three unique numbers are:
7 1 4
```

or:

```text
7 4 1
```

Order doesn’t matter.

---

# 15) Full explanation of code flow

## `findThreeUnique(a)`

This is the main function.

### Step 1

Try every bit from `0 to 31`

For each bit:

* XOR all numbers whose bit is set
* store in `candidate`

### Step 2

Check if `candidate` appears exactly once in array

If yes:

* it is one unique number
* stop the loop

### Step 3

Now call `findTwoUnique(a, firstUnique)`

This finds the remaining two unique numbers using the standard XOR split method.

---

## `findTwoUnique(a, skipValue)`

This solves the normal **2 unique numbers** problem after one unique is already known.

### Step 1

Ignore one occurrence of `skipValue`

XOR the rest.

Now XOR result becomes:

```text
u ^ v
```

where `u` and `v` are the remaining two unique numbers.

### Step 2

Find first set bit in `u ^ v`

### Step 3

Split remaining numbers into 2 groups using that bit

### Step 4

XOR both groups → get the last two unique numbers

---

# 16) Why duplicates always cancel

If a number appears twice, for example `6`:

```text
6 ^ 6 = 0
```

Also, if we split by some bit:

* both copies of `6` have the same bit pattern
* so both copies go into the same group
* then they cancel inside that group

That is why the technique works.

---

# 17) Time complexity

Let `n` = array size.

## Finding first unique

* try 32 bits
* for each bit, scan array once

So:

```text
O(32 * n) = O(n)
```

## Finding remaining two

* one scan for XOR
* one scan for split

So:

```text
O(n)
```

## Total

```text
O(n)
```

Space:

```text
O(1)
```

---

# 18) One caution

This approach is a **practical extension** of the XOR trick and works for the “3 uniques, others twice” style when a bit can isolate one unique candidate and that candidate is verified by frequency.

If you want a more general “any k unique numbers” style solution, then the approach changes — often using hashing / bit counts / modular bit counting depending on the exact problem.

---

# 19) Final mental process you should remember

If the problem is:

## Case 1

**All numbers appear twice except 1**
→ XOR all → answer directly

## Case 2

**All numbers appear twice except 2**
→ XOR all → find set bit → split → XOR both groups

## Case 3

**All numbers appear twice except 3**
→ try to isolate **one unique** using bit grouping
→ then solve remaining **2 unique** using old method

---

If you want, next I can do one more thing:

## I can take this exact code and add **line-by-line dry run comments inside the code itself**, so every loop and every variable change is shown beside the code.
