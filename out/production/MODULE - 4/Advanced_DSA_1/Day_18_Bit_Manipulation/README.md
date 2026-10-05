## ------- Q-1:  Check whether ith bit is set or not.  --
## ------- Q-2:  set the iTH bit if it is unset and if it is set then left it. --
## -------- Q-3: UnSet the ith bit of a number if it is set ---
## -------- Q-4  given an array of size N. where every element occures twice except one element . identify that element 
## -------- Q-5: every element occurs twice except two element, identify those two elements(isolate the two numbers) .
## ----- extra: Q-4  given an array of size N. where every element occures three time except one element . identify that element 



## ------------- Q-5: every element occurs twice except two element, identify those two elements(isolate the two numbers) . ----

> **Every element appears twice except two elements. Find those two unique elements.**

Your code is **correct**, and the idea is also correct.
Now I’ll explain it **from 0 to 100**, with **full dry run**, **why XOR works**, **why we split into 2 groups**, and **how the answer comes out**.

---

# 1) Problem statement in simple words

Array:

```java
int[] a = {4, 5, 5, 6, 6, 1, 2, 2};
```

In this array:

* `5` appears twice
* `6` appears twice
* `2` appears twice

Only these two appear once:

* `4`
* `1`

So output should be:

```text
4 and 1
```

---

# 2) Why XOR is useful here

## XOR rules

```text
x ^ x = 0
x ^ 0 = x
```

So if a number appears twice:

```text
5 ^ 5 = 0
6 ^ 6 = 0
2 ^ 2 = 0
```

That means all duplicate elements cancel out.

---

# 3) Main idea of the algorithm

We have **two unique numbers**: let them be `x` and `y`.

If we XOR all elements:

```text
allXor = x ^ y
```

Why?

Because duplicates become 0 and vanish.

Then:

* `allXor` contains XOR of the two unique numbers
* `x` and `y` are different, so in `allXor` **at least one bit will be 1**
* that bit tells us: one unique number has that bit = 1, and the other has that bit = 0

Then we split the array into **2 groups** based on that bit:

* Group 1 → bit is set
* Group 2 → bit is unset

Then XOR inside each group → duplicates cancel → one unique remains in each group.

---

# 4) Your code

```java
package Advanced_DSA_1.Day_18_Bit_Manipulation.ClassVideo;

/*
Q-5: every element occurs twice except two element,
identify those two elements(isolate the two numbers) .
*/
public class Problem_5 {

    public static void FindUniqueTwoElement(int[] a, int n) {
        int position = 0;
        int finalValueOfXORAll = doXORForAll(a, n);

        // step-2: find first set bit position in final XOR
        for (int i = 0; i < 32; i++) {
            if (CheckSetBit(finalValueOfXORAll, i)) {
                position = i;
                break;
            }
        }

        // step-3: divide array into two groups
        int first = 0, second = 0;
        for (int i = 0; i < n; i++) {
            if (CheckSetBit(a[i], position)) {
                first = first ^ a[i];
            } else {
                second = second ^ a[i];
            }
        }

        System.out.println("first value is : " + first);
        System.out.println("Second value is: " + second);
    }

    public static void main(String[] args) {
        int[] a = {4, 5, 5, 6, 6, 1, 2, 2};
        FindUniqueTwoElement(a, a.length);
    }

    public static int doXORForAll(int[] a, int n) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = ans ^ a[i];
        }
        return ans;
    }

    public static boolean CheckSetBit(int a, int index) {
        if ((a & (1 << index)) == 0) {
            return false;
        } else {
            return true;
        }
    }
}
```

---

# 5) Full dry run

Array:

```text
a = [4, 5, 5, 6, 6, 1, 2, 2]
```

---

# 6) Step 1 — XOR of all elements

We compute:

```text
4 ^ 5 ^ 5 ^ 6 ^ 6 ^ 1 ^ 2 ^ 2
```

Let’s cancel duplicates:

```text
5 ^ 5 = 0
6 ^ 6 = 0
2 ^ 2 = 0
```

So:

```text
allXor = 4 ^ 1
```

Now calculate:

```text
4 = 100
1 = 001
-----------
4 ^ 1 = 101 = 5
```

So:

```text
finalValueOfXORAll = 5
```

---

# 7) Meaning of `allXor = 5`

```text
5 = 101
```

This means the two unique numbers are different in the bits where `allXor` has 1.

For example:

```text
4 = 100
1 = 001
```

Compare:

```text
bit 2 -> 4 has 1, 1 has 0
bit 1 -> both 0
bit 0 -> 4 has 0, 1 has 1
```

So `4` and `1` differ at bit 2 and bit 0.

---

# 8) Step 2 — find any set bit position in `allXor`

Your code checks from `0` to `31` and picks the first set bit.

`allXor = 5`

Binary:

```text
5 = 101
index: 2 1 0
bits : 1 0 1
```

Start loop:

### i = 0

Check bit 0 of 5:

```text
5 & (1 << 0)
5 & 1
101 & 001 = 001
```

Non-zero → bit is set.

So:

```text
position = 0
```

We stop.

---

# 9) Why this bit helps

We found:

```text
position = 0
```

This means the two unique numbers differ at bit 0.

Now check the two unique numbers:

* `4 = 100` → bit 0 = 0
* `1 = 001` → bit 0 = 1

Perfect.

So if we divide array by bit 0:

* one unique number will go to one group
* the other unique number will go to the other group

Also duplicate pairs always go to the same group because both copies are identical.

That is the key reason this works.

---

# 10) Step 3 — split into 2 groups

We use `position = 0`.

## Rule:

* if bit 0 is set → group 1 (`first`)
* if bit 0 is unset → group 2 (`second`)

---

# 11) Check every element

We’ll go one by one.

---

## Element = 4

Binary:

```text
4 = 100
```

Bit 0 is **0**

So it goes to **second**

```text
second = 0 ^ 4 = 4
first = 0
```

---

## Element = 5

Binary:

```text
5 = 101
```

Bit 0 is **1**

So it goes to **first**

```text
first = 0 ^ 5 = 5
second = 4
```

---

## Element = 5 (again)

Bit 0 is **1**

So it goes to **first**

```text
first = 5 ^ 5 = 0
second = 4
```

Duplicate cancelled.

---

## Element = 6

Binary:

```text
6 = 110
```

Bit 0 is **0**

So it goes to **second**

```text
second = 4 ^ 6 = 2
first = 0
```

---

## Element = 6 (again)

Bit 0 is **0**

```text
second = 2 ^ 6 = 4
first = 0
```

Duplicate cancelled.

---

## Element = 1

Binary:

```text
1 = 001
```

Bit 0 is **1**

So it goes to **first**

```text
first = 0 ^ 1 = 1
second = 4
```

---

## Element = 2

Binary:

```text
2 = 010
```

Bit 0 is **0**

So it goes to **second**

```text
second = 4 ^ 2 = 6
first = 1
```

---

## Element = 2 (again)

Bit 0 is **0**

```text
second = 6 ^ 2 = 4
first = 1
```

Duplicate cancelled.

---

# 12) Final result

At the end:

```text
first  = 1
second = 4
```

So the two unique numbers are:

```text
1 and 4
```

Order may be:

```text
first = 1, second = 4
```

or

```text
first = 4, second = 1
```

Both are correct.

---

# 13) Full dry table

We use `position = 0`

| Element | Binary | bit 0 set? | Goes to | first calculation | second calculation | first | second |
| ------- | -----: | ---------: | ------- | ----------------- | ------------------ | ----: | -----: |
| start   |        |            |         |                   |                    |     0 |      0 |
| 4       |    100 |         No | second  |                   | `0 ^ 4`            |     0 |      4 |
| 5       |    101 |        Yes | first   | `0 ^ 5`           |                    |     5 |      4 |
| 5       |    101 |        Yes | first   | `5 ^ 5`           |                    |     0 |      4 |
| 6       |    110 |         No | second  |                   | `4 ^ 6`            |     0 |      2 |
| 6       |    110 |         No | second  |                   | `2 ^ 6`            |     0 |      4 |
| 1       |    001 |        Yes | first   | `0 ^ 1`           |                    |     1 |      4 |
| 2       |    010 |         No | second  |                   | `4 ^ 2`            |     1 |      6 |
| 2       |    010 |         No | second  |                   | `6 ^ 2`            |     1 |      4 |

Final:

```text
first = 1
second = 4
```

---

# 14) Why duplicates always cancel inside same group

Take duplicate `5, 5`

Binary:

```text
5 = 101
```

If bit 0 is set for one `5`, it is also set for the other `5`.

So both go into the same group:

```text
5 ^ 5 = 0
```

Similarly for `6, 6`, `2, 2`.

So only the unique element survives in each group.

---

# 15) Very important intuition

After `allXor = x ^ y`

we find one set bit position in `allXor`.

That set bit means:

```text
x and y are different at this bit
```

So:

* one goes left group
* one goes right group

Then duplicates cancel within their group.

That’s the whole trick.

---

# 16) Time complexity

## Step 1:

XOR all elements → `O(n)`

## Step 2:

Find set bit in 32 positions → `O(32)` → constant

## Step 3:

Split array and XOR again → `O(n)`

## Total:

```text
O(n)
```

Space:

```text
O(1)
```

---

# 17) Slightly cleaner version of your code

You can simplify `CheckSetBit` and make naming clearer:

```java
public class Problem_5 {

    public static void findUniqueTwoElements(int[] a) {
        int allXor = 0;

        for (int num : a) {
            allXor ^= num;
        }

        int position = 0;
        for (int i = 0; i < 32; i++) {
            if ((allXor & (1 << i)) != 0) {
                position = i;
                break;
            }
        }

        int first = 0, second = 0;

        for (int num : a) {
            if ((num & (1 << position)) != 0) {
                first ^= num;
            } else {
                second ^= num;
            }
        }

        System.out.println("First unique = " + first);
        System.out.println("Second unique = " + second);
    }

    public static void main(String[] args) {
        int[] a = {4, 5, 5, 6, 6, 1, 2, 2};
        findUniqueTwoElements(a);
    }
}
```

---

# 18) One more example quickly

Array:

```text
[3, 4, 3, 5]
```

Unique numbers are `4` and `5`.

## XOR all

```text
3 ^ 4 ^ 3 ^ 5
= (3 ^ 3) ^ (4 ^ 5)
= 0 ^ 1
= 1
```

Set bit position = 0

Split by bit 0:

* bit 0 set → `3, 3, 5` → XOR = `5`
* bit 0 unset → `4` → XOR = `4`

Answer = `5` and `4`

---

# 19) Final summary in 6 lines

1. XOR all elements → duplicates cancel
2. Result becomes `x ^ y`
3. Find any set bit in `x ^ y`
4. That bit is different in `x` and `y`
5. Split array into 2 groups using that bit
6. XOR each group separately → get the two unique numbers

---

If you want, I can do **one more thing that will make this crystal clear**: I can draw the **entire process as a binary diagram table** for this exact array `[4,5,5,6,6,1,2,2]`, showing **each number in binary**, which group it goes to, and how XOR changes after every step.

# -- yes 
Perfect — now I’ll do the **full binary diagram table** for your exact array:

```java
a = {4, 5, 5, 6, 6, 1, 2, 2}
```

We will solve:

> **Every element occurs twice except two elements. Find those two unique elements.**

---

# 1) Array

```text id="25r4k4"
[4, 5, 5, 6, 6, 1, 2, 2]
```

Unique numbers are actually:

```text id="dntx8z"
4 and 1
```

But assume we **don’t know that**.
We will find them using XOR.

---

# 2) Binary of every number

Let’s write everything in **3-bit binary** because the biggest number here is `6 = 110`.

| Number | Binary |
| ------ | -----: |
| 4      |  `100` |
| 5      |  `101` |
| 5      |  `101` |
| 6      |  `110` |
| 6      |  `110` |
| 1      |  `001` |
| 2      |  `010` |
| 2      |  `010` |

So array becomes:

```text id="8rm5zf"
4  = 100
5  = 101
5  = 101
6  = 110
6  = 110
1  = 001
2  = 010
2  = 010
```

---

# 3) Step-1: XOR all elements

We compute:

[
4 \oplus 5 \oplus 5 \oplus 6 \oplus 6 \oplus 1 \oplus 2 \oplus 2
]

Let’s do it one by one.

---

# 4) XOR table of all elements

Start:

```text id="llk1m6"
ans = 0
```

---

## i = 0 → number = 4

```text id="wjz0r4"
ans = 0 ^ 4
    = 000 ^ 100
    = 100
```

So now:

```text id="t7rtgd"
ans = 100   (4)
```

---

## i = 1 → number = 5

```text id="r0b42a"
ans = 100 ^ 101
    = 001
```

So now:

```text id="a8zjlwm"
ans = 001   (1)
```

---

## i = 2 → number = 5

```text id="cdy8ho"
ans = 001 ^ 101
    = 100
```

So now:

```text id="6v2i4p"
ans = 100   (4)
```

Notice: the two 5s are effectively cancelling.

---

## i = 3 → number = 6

```text id="sjq7vh"
ans = 100 ^ 110
    = 010
```

So now:

```text id="48ufzw"
ans = 010   (2)
```

---

## i = 4 → number = 6

```text id="9nll0w"
ans = 010 ^ 110
    = 100
```

So now:

```text id="z7th9p"
ans = 100   (4)
```

Again the two 6s cancel.

---

## i = 5 → number = 1

```text id="n8z4x7"
ans = 100 ^ 001
    = 101
```

So now:

```text id="n4r2ry"
ans = 101   (5)
```

---

## i = 6 → number = 2

```text id="ln2s1e"
ans = 101 ^ 010
    = 111
```

So now:

```text id="ewdsox"
ans = 111   (7)
```

---

## i = 7 → number = 2

```text id="3fxomx"
ans = 111 ^ 010
    = 101
```

So final:

```text id="dx8c0r"
allXor = 101   (5)
```

---

# 5) Final XOR result

So:

```text id="0h2i4m"
finalValueOfXORAll = 5
binary = 101
```

This means:

```text id="x5v7ao"
x ^ y = 101
```

where `x` and `y` are the two unique numbers.

Since duplicates vanished, the only remaining XOR is:

```text id="pnibj4"
4 ^ 1 = 5
100 ^ 001 = 101
```

---

# 6) Step-2: Find one set bit in `allXor`

We got:

```text id="n4vmmr"
allXor = 5 = 101
```

Bit positions:

```text id="qg3u95"
index:   2 1 0
bits :   1 0 1
```

Now your code checks from `i = 0`.

---

## Check bit 0

```java
CheckSetBit(5, 0)
```

Calculation:

```text id="nnnt0n"
5 & (1 << 0)
= 101 & 001
= 001
```

Non-zero means **bit 0 is set**.

So:

```text id="7htm0k"
position = 0
```

---

# 7) Why this position is useful

Because if:

```text id="ez2p6q"
x ^ y has bit 0 = 1
```

that means `x` and `y` are **different** at bit 0.

So one unique number will have bit 0 = 1
and the other unique number will have bit 0 = 0

Now look at the actual unique numbers:

* `4 = 100` → bit 0 = 0
* `1 = 001` → bit 0 = 1

Exactly.

---

# 8) Step-3: Split the array into 2 groups

We use:

```text id="4rwhzk"
position = 0
```

Now for each number:

* if bit 0 is set → **Group 1** (`first`)
* if bit 0 is unset → **Group 2** (`second`)

---

# 9) Let’s make the groups visually

## Check each element’s bit 0

| Number | Binary | bit 0 | Group  |
| ------ | -----: | ----: | ------ |
| 4      |  `100` |     0 | second |
| 5      |  `101` |     1 | first  |
| 5      |  `101` |     1 | first  |
| 6      |  `110` |     0 | second |
| 6      |  `110` |     0 | second |
| 1      |  `001` |     1 | first  |
| 2      |  `010` |     0 | second |
| 2      |  `010` |     0 | second |

So:

## Group 1 (bit 0 = 1)

```text id="p7uy1e"
5, 5, 1
```

## Group 2 (bit 0 = 0)

```text id="yrvqyu"
4, 6, 6, 2, 2
```

---

# 10) Why grouping works

The two unique numbers are separated:

* `1` is in Group 1
* `4` is in Group 2

And all duplicates remain together:

* both `5`s are in Group 1
* both `6`s are in Group 2
* both `2`s are in Group 2

So now duplicates will cancel inside each group.

---

# 11) XOR Group 1

Group 1:

```text id="4fjlwm"
[5, 5, 1]
```

Start:

```text id="5zjrfm"
first = 0
```

---

## first ^ 5

```text id="w2t6wz"
000 ^ 101 = 101
```

```text id="lxb3kl"
first = 101  (5)
```

---

## first ^ 5 again

```text id="mjx3ks"
101 ^ 101 = 000
```

```text id="w4kly1"
first = 000  (0)
```

Duplicate cancelled.

---

## first ^ 1

```text id="ycy1h0"
000 ^ 001 = 001
```

```text id="pq8etw"
first = 001  (1)
```

So Group 1 result:

```text id="8g6dqa"
first = 1
```

---

# 12) XOR Group 2

Group 2:

```text id="i0mnqb"
[4, 6, 6, 2, 2]
```

Start:

```text id="63ndx6"
second = 0
```

---

## second ^ 4

```text id="r8ylro"
000 ^ 100 = 100
```

```text id="h63jz2"
second = 100  (4)
```

---

## second ^ 6

```text id="lyy4bq"
100 ^ 110 = 010
```

```text id="ofg18o"
second = 010  (2)
```

---

## second ^ 6 again

```text id="h9ic3g"
010 ^ 110 = 100
```

```text id="zsfzn6"
second = 100  (4)
```

Duplicate cancelled.

---

## second ^ 2

```text id="zc5vgu"
100 ^ 010 = 110
```

```text id="x9n7hc"
second = 110  (6)
```

---

## second ^ 2 again

```text id="9m7r8g"
110 ^ 010 = 100
```

```text id="8zyd8n"
second = 100  (4)
```

Duplicate cancelled.

So Group 2 result:

```text id="knk4x2"
second = 4
```

---

# 13) Final answer

So finally:

```text id="rxfxsa"
first  = 1
second = 4
```

These are the **two unique numbers**.

---

# 14) Full dry-run table in one place

## Step A — XOR all numbers

| Step  | Current Number | Binary | ans before | ans after XOR |
| ----- | -------------: | -----: | ---------: | ------------: |
| start |                |        |      `000` |         `000` |
| 1     |              4 |  `100` |      `000` |         `100` |
| 2     |              5 |  `101` |      `100` |         `001` |
| 3     |              5 |  `101` |      `001` |         `100` |
| 4     |              6 |  `110` |      `100` |         `010` |
| 5     |              6 |  `110` |      `010` |         `100` |
| 6     |              1 |  `001` |      `100` |         `101` |
| 7     |              2 |  `010` |      `101` |         `111` |
| 8     |              2 |  `010` |      `111` |         `101` |

Final:

```text id="sr3v5e"
allXor = 101 = 5
```

---

## Step B — find set bit position

`101` → first set bit from right = **position 0**

---

## Step C — split by bit 0

| Number | Binary | bit 0 | Group  |
| ------ | -----: | ----: | ------ |
| 4      |  `100` |     0 | second |
| 5      |  `101` |     1 | first  |
| 5      |  `101` |     1 | first  |
| 6      |  `110` |     0 | second |
| 6      |  `110` |     0 | second |
| 1      |  `001` |     1 | first  |
| 2      |  `010` |     0 | second |
| 2      |  `010` |     0 | second |

---

## Step D — XOR each group

### Group first = `[5, 5, 1]`

```text id="6orccu"
0 ^ 5 = 5
5 ^ 5 = 0
0 ^ 1 = 1
```

So:

```text id="7dyh8v"
first = 1
```

---

### Group second = `[4, 6, 6, 2, 2]`

```text id="qg3t8n"
0 ^ 4 = 4
4 ^ 6 = 2
2 ^ 6 = 4
4 ^ 2 = 6
6 ^ 2 = 4
```

So:

```text id="5ihaxk"
second = 4
```

---

# 15) Why this algorithm is so powerful

Because it solves the problem in:

* **O(n)** time
* **O(1)** extra space

No HashMap, no sorting.

---

# 16) Very important intuition sentence

When we do:

```text id="nhaz6e"
allXor = x ^ y
```

and find one set bit in `allXor`, that bit **must be different** in `x` and `y`.

So that bit becomes the key to **separate the two unique numbers into different groups**.

That is the entire trick.

---

# 17) One small improvement to your code

Your code is correct.
But `CheckSetBit()` can be shorter:

```java id="lvz8oc"
public static boolean CheckSetBit(int a, int index){
    return (a & (1 << index)) != 0;
}
```

---

# 18) Final cleaned code

```java id="7a1dd5"
public class Problem_5 {

    public static void FindUniqueTwoElement(int[] a, int n) {
        int position = 0;
        int finalValueOfXORAll = doXORForAll(a, n);

        // find first set bit position
        for (int i = 0; i < 32; i++) {
            if (CheckSetBit(finalValueOfXORAll, i)) {
                position = i;
                break;
            }
        }

        int first = 0, second = 0;

        // divide into 2 groups and XOR
        for (int i = 0; i < n; i++) {
            if (CheckSetBit(a[i], position)) {
                first ^= a[i];
            } else {
                second ^= a[i];
            }
        }

        System.out.println("First unique = " + first);
        System.out.println("Second unique = " + second);
    }

    public static int doXORForAll(int[] a, int n) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans ^= a[i];
        }
        return ans;
    }

    public static boolean CheckSetBit(int a, int index) {
        return (a & (1 << index)) != 0;
    }

    public static void main(String[] args) {
        int[] a = {4, 5, 5, 6, 6, 1, 2, 2};
        FindUniqueTwoElement(a, a.length);
    }
}
```

---

If you want, I can do the **next level explanation**:

## “Why does `allXor = x ^ y` guarantee that duplicates always go to the same group?”

I can explain that with a **proof + bit diagram + one wrong example + one correct example**.
