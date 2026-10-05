## --- problem-1: given a array size n you need to revers the array -
## --- problem-2: given a array need to rever the given part of array --
## --- problem-3: given a array of size n you need to rotate the array from Right side to left side by given k times --

##################################################
## --- problem-1: given a array size n you need to revers the array -

Excellent question. This is one of the **first array problems** in DSA. I'll explain it exactly in the sequence followed in interviews and Scaler:

1. Problem Understanding
2. Brute Force (BF)
3. Better
4. Best / Optimized
5. Dry Run for each
6. Diagram
7. Complexity Comparison

---

# Problem

Given an array of size **N**, reverse the array.

Example:

```text
Input

A = [10,20,30,40,50]

Output

[50,40,30,20,10]
```

---

# Approach 1 — Brute Force (Extra Array)

## Idea

Instead of changing the original array,

Create another array.

Copy elements from back to front.

---

## Example

```text
Original

Index

0 1 2 3 4

10 20 30 40 50
```

Create another array

```text
result[]

_ _ _ _ _
```

Now copy

```text
result[0]=A[4]

50 _ _ _ _
```

Next

```text
result[1]=A[3]

50 40 _ _ _
```

Next

```text
result[2]=A[2]

50 40 30 _ _
```

Next

```text
result[3]=A[1]

50 40 30 20 _
```

Next

```text
result[4]=A[0]

50 40 30 20 10
```

Done.

---

## Flow Diagram

```text
Original

10 20 30 40 50
 ↑           ↑

Copy from end

↓

50 40 30 20 10
```

---

## Code

```java
public class Main {

    public static void main(String[] args) {

        int[] a = {10,20,30,40,50};

        int n = a.length;

        int[] result = new int[n];

        int j = 0;

        for(int i=n-1;i>=0;i--){

            result[j]=a[i];

            j++;
        }

        for(int x:result){
            System.out.print(x+" ");
        }
    }
}
```

---

## Complexity

Time

```
O(N)
```

Space

```
O(N)
```

Extra array is required.

---

# Approach 2 — Better (Two Pointer)

Instead of creating another array,

Swap first and last.

---

## Idea

Use two pointers.

```text
left=0

right=n-1
```

Swap.

Move inward.

---

## Dry Run

Array

```text
10 20 30 40 50

L           R
```

Swap

```text
50 20 30 40 10

  L       R
```

Swap

```text
50 40 30 20 10

    L R
```

Now

```text
left==right
```

Stop.

---

## Diagram

### Step 1

```text
10 20 30 40 50

↑           ↑
L           R
```

↓

Swap

```text
50 20 30 40 10
```

---

### Step 2

```text
50 20 30 40 10

   ↑     ↑
   L     R
```

↓

Swap

```text
50 40 30 20 10
```

---

### Step 3

```text
50 40 30 20 10

      ↑
```

Stop.

---

## Code

```java
public class Main {

    public static void main(String[] args) {

        int[] a={10,20,30,40,50};

        int left=0;

        int right=a.length-1;

        while(left<right){

            int temp=a[left];
            a[left]=a[right];
            a[right]=temp;

            left++;
            right--;
        }

        for(int x:a){
            System.out.print(x+" ");
        }

    }
}
```

---

## Complexity

Time

```
O(N)
```

Space

```
O(1)
```

No extra array.

---

# Why does it work?

Every swap fixes two positions.

Example

```text
10 20 30 40 50
```

Swap

```text
10 ↔ 50
```

Now

```text
50 20 30 40 10
```

Both ends are correct forever.

Then

```text
20 ↔ 40
```

Now

```text
50 40 30 20 10
```

Again two positions become correct.

Only middle remains.

---

# Approach 3 — Recursive

Instead of loop,

Use recursion.

---

## Idea

Swap first and last.

Call recursion for inside array.

---

### Example

```
Reverse(0,4)

↓

Swap

↓

Reverse(1,3)

↓

Swap

↓

Reverse(2,2)

↓

Stop
```

---

## Diagram

```text
Reverse(0,4)

↓

Reverse(1,3)

↓

Reverse(2,2)

↓

Return
```

---

## Code

```java
public class Main {

    static void reverse(int[] a,int left,int right){

        if(left>=right)
            return;

        int temp=a[left];
        a[left]=a[right];
        a[right]=temp;

        reverse(a,left+1,right-1);
    }

    public static void main(String[] args){

        int[] a={10,20,30,40,50};

        reverse(a,0,a.length-1);

        for(int x:a){
            System.out.print(x+" ");
        }
    }
}
```

---

## Complexity

Time

```
O(N)
```

Space

```
O(N)
```

Recursion stack.

---

# Approach 4 — Stack

Push all elements.

Pop all elements.

---

Diagram

```text
Array

10 20 30 40 50

↓

Push

Stack

50
40
30
20
10

↓

Pop

50 40 30 20 10
```

---

Complexity

Time

```
O(N)
```

Space

```
O(N)
```

---

# Dry Run of Two Pointer (Most Important)

Initial

```text
10 20 30 40 50

L=0

R=4
```

---

Iteration 1

Swap

```text
50 20 30 40 10
```

Move

```text
L=1

R=3
```

---

Iteration 2

Swap

```text
50 40 30 20 10
```

Move

```text
L=2

R=2
```

Now

```text
L==R
```

Loop stops.

---

# Why `left < right`?

Suppose

```text
10 20 30 40 50
```

Middle

```text
30
```

Doesn't need swapping.

If we continue,

We'll swap already reversed elements again.

Hence

```java
while(left<right)
```

---

# Comparison

| Approach                  | Extra Space | Time | Interview Preference |
| ------------------------- | ----------- | ---- | -------------------- |
| Brute Force (Extra Array) | O(N)        | O(N) | ⭐⭐                   |
| Two Pointer               | O(1)        | O(N) | ⭐⭐⭐⭐⭐                |
| Recursion                 | O(N)        | O(N) | ⭐⭐⭐                  |
| Stack                     | O(N)        | O(N) | ⭐⭐                   |

---

# Interview Answer

If an interviewer asks:

> **Reverse an array**

The expected solution is almost always the **Two Pointer** approach:

1. Initialize `left = 0` and `right = n - 1`.
2. While `left < right`, swap `a[left]` and `a[right]`.
3. Increment `left` and decrement `right`.
4. The array is reversed **in-place** with **O(N)** time and **O(1)** extra space.

This is considered the optimal solution because it doesn't require any additional array or data structure.


## on the above code for this TC should bu log n naa because we are going log as left < right so we are not looping full array naa  ---
This is a very common confusion. The answer is:

> **No, the time complexity is still `O(N)`, not `O(log N)`.**

Let's understand why.

---

# Your code

```java
int left = 0;
int right = a.length - 1;

while (left < right) {

    int temp = a[left];
    a[left] = a[right];
    a[right] = temp;

    left++;
    right--;
}
```

---

# Example

Suppose

```text
N = 10

Array

10 20 30 40 50 60 70 80 90 100
```

Initially

```text
L = 0

R = 9
```

---

## Iteration 1

```text
L = 1

R = 8
```

---

## Iteration 2

```text
L = 2

R = 7
```

---

## Iteration 3

```text
L = 3

R = 6
```

---

## Iteration 4

```text
L = 4

R = 5
```

---

## Iteration 5

```text
L = 5

R = 4

Stop
```

How many iterations?

```text
5
```

which is

[
\frac{N}{2}
]

---

# General Formula

If

```text
N = 100
```

Iterations

```text
50
```

If

```text
N = 1000
```

Iterations

```text
500
```

If

```text
N = 1,000,000
```

Iterations

```text
500,000
```

So the loop runs approximately:

[
\frac{N}{2}
]

times.

---

# Why is it not O(log N)?

`O(log N)` happens when the **problem size is divided** every iteration.

For example:

```java
while (n > 1) {
    n = n / 2;
}
```

Example:

```text
N = 16

16
8
4
2
1
```

Iterations:

```text
4
```

because

[
2^4 = 16
]

That's logarithmic growth.

---

# Your code does something different

Instead of dividing the problem size by 2, you only move the pointers by one position each.

```text
Iteration 1

L→
←R

Iteration 2

  L→
 ←R

Iteration 3

   L→
←R
```

Each iteration processes **two elements**.

So after

[
\frac{N}{2}
]

iterations, every element has been processed once.

---

# Complexity Calculation

Each loop performs a constant amount of work:

```java
temp = a[left];
a[left] = a[right];
a[right] = temp;

left++;
right--;
```

This is **O(1)** work per iteration.

Number of iterations:

[
\frac{N}{2}
]

Total work:

[
O(1) \times \frac{N}{2}
=======================

O\left(\frac{N}{2}\right)
]

In Big-O notation, constant factors are ignored:

[
O\left(\frac{N}{2}\right) = O(N)
]

---

# Visual Comparison

## Reverse Array (Your Code)

```text
N = 16

Iteration 1
L→             ←R

Iteration 2
  L→         ←R

Iteration 3
    L→     ←R

Iteration 4
      L→ ←R

Iteration 5
Stop
```

Iterations:

```text
16 / 2 = 8
```

Complexity:

```text
O(N)
```

---

## Binary Search

```text
16 elements

Iteration 1

16

↓

8

↓

4

↓

2

↓

1
```

Iterations:

```text
log₂16 = 4
```

Complexity:

```text
O(log N)
```

---

# Rule to Remember

Whenever you see:

```java
i++;
```

or

```java
left++;
right--;
```

you're moving a **constant amount** each iteration, which usually leads to **linear** complexity.

Whenever you see:

```java
i = i * 2;
```

or

```java
i = i / 2;
```

or

```java
low = mid + 1;
high = mid - 1;
```

where the search space is **halved**, you're likely dealing with **logarithmic** complexity.

---

### Interview Tip

A quick way to distinguish them is:

* **Remove a fixed number of elements each iteration** (e.g., 1 or 2) → **O(N)**
* **Remove a fixed fraction of the remaining elements each iteration** (e.g., half) → **O(log N)**

Your reverse-array algorithm removes **2 elements per iteration**, which is still a fixed number, so its time complexity is **O(N)**, not **O(log N)**.

## --- problem-2: given a array need to rever the given part of array --

Excellent. This is the next problem after reversing a complete array and is asked frequently in interviews.

# Problem

Given an array and two indices `L` and `R`, reverse **only that part** of the array.

Example:

```text
A = [10,20,30,40,50,60,70]

L = 2
R = 5
```

Reverse only the subarray from index `2` to `5`.

```
30 40 50 60
```

After reversing

```text
60 50 40 30
```

Final array

```text
[10,20,60,50,40,30,70]
```

---

# Visual Diagram

Before

```text
Index

0   1   2   3   4   5   6

10 20 30 40 50 60 70
      ↑         ↑
      L         R
```

Reverse only this part

```text
30 40 50 60
```

Result

```text
10 20 60 50 40 30 70
```

---

# Approach 1 (Brute Force)

## Idea

Create a temporary array.

Copy only the selected portion.

Reverse it into the original array.

---

## Step-by-step

Original

```text
10 20 30 40 50 60 70
      ↑         ↑
```

Create temp

```text
temp

30 40 50 60
```

Now write back in reverse order.

```text
temp

60 50 40 30
```

Original becomes

```text
10 20 60 50 40 30 70
```

---

## Dry Run

### Step 1

Copy

```text
temp

30
30 40
30 40 50
30 40 50 60
```

---

### Step 2

Write back

```text
a[2]=60

10 20 60 40 50 60 70
```

---

```text
a[3]=50

10 20 60 50 50 60 70
```

---

```text
a[4]=40

10 20 60 50 40 60 70
```

---

```text
a[5]=30

10 20 60 50 40 30 70
```

Done.

---

## Brute Force Code

```java
public class Main {

    public static void main(String[] args) {

        int[] a = {10,20,30,40,50,60,70};

        int L = 2;
        int R = 5;

        int size = R - L + 1;

        int[] temp = new int[size];

        // Copy
        for(int i=L,j=0;i<=R;i++,j++){
            temp[j]=a[i];
        }

        // Copy back in reverse
        for(int i=L,j=size-1;i<=R;i++,j--){
            a[i]=temp[j];
        }

        for(int x:a)
            System.out.print(x+" ");
    }
}
```

---

## Complexity

Time

```
O(R-L+1)
```

Space

```
O(R-L+1)
```

Extra array required.

---

# Approach 2 (Better)

Instead of copying,

swap first and last.

Exactly like full array reversal.

---

## Idea

Use

```
left=L

right=R
```

Swap.

Move inward.

---

## Dry Run

Initial

```text
10 20 30 40 50 60 70

      L         R
```

Swap

```
30 ↔ 60
```

```text
10 20 60 40 50 30 70

         L   R
```

---

Swap

```
40 ↔ 50
```

```text
10 20 60 50 40 30 70

            LR
```

Done.

---

# Diagram

### Step 1

```text
10 20 30 40 50 60 70

      ↑         ↑
```

↓

Swap

```text
10 20 60 40 50 30 70
```

---

### Step 2

```text
10 20 60 40 50 30 70

         ↑   ↑
```

↓

Swap

```text
10 20 60 50 40 30 70
```

Stop.

---

## Better Code

```java
public class Main {

    public static void main(String[] args) {

        int[] a={10,20,30,40,50,60,70};

        int left=2;

        int right=5;

        while(left<right){

            int temp=a[left];
            a[left]=a[right];
            a[right]=temp;

            left++;
            right--;
        }

        for(int x:a)
            System.out.print(x+" ");
    }
}
```

---

## Complexity

Time

```
O(R-L)
```

Space

```
O(1)
```

No extra array.

---

# Approach 3 (Recursive)

Exactly the same idea.

Instead of loop

Use recursion.

---

## Flow

```
reverse(2,5)

↓

swap

↓

reverse(3,4)

↓

swap

↓

reverse(4,3)

↓

Stop
```

---

## Recursive Code

```java
public class Main {

    static void reverse(int[] a,int left,int right){

        if(left>=right)
            return;

        int temp=a[left];
        a[left]=a[right];
        a[right]=temp;

        reverse(a,left+1,right-1);
    }

    public static void main(String[] args){

        int[] a={10,20,30,40,50,60,70};

        reverse(a,2,5);

        for(int x:a)
            System.out.print(x+" ");
    }
}
```

---

## Complexity

Time

```
O(R-L)
```

Space

```
O(R-L)
```

(recursion stack)

---

# Why is the Two Pointer approach optimal?

Suppose

```text
30 40 50 60
```

Swap first and last.

```
60 40 50 30
```

Now first and last are correct forever.

Swap middle.

```
60 50 40 30
```

Done.

Only **two swaps** were needed.

No extra memory.

---

# Complete Dry Run

Array

```text
10 20 30 40 50 60 70

L=2

R=5
```

---

Iteration 1

Swap

```
30 ↔ 60
```

Array

```text
10 20 60 40 50 30 70
```

Pointers

```
L=3

R=4
```

---

Iteration 2

Swap

```
40 ↔ 50
```

Array

```text
10 20 60 50 40 30 70
```

Pointers

```
L=4

R=3
```

Now

```
left > right
```

Stop.

---

# Comparison

| Approach                 | Time     | Space    | Interview Preference |
| ------------------------ | -------- | -------- | -------------------- |
| Brute Force (Temp Array) | O(R-L+1) | O(R-L+1) | ⭐⭐                   |
| Two Pointer              | O(R-L+1) | O(1)     | ⭐⭐⭐⭐⭐                |
| Recursion                | O(R-L+1) | O(R-L+1) | ⭐⭐⭐                  |

---

# Interview Tip

This is a very important helper function. It is used directly in problems like:

* Reverse Array
* Reverse Subarray
* Rotate Array
* Next Permutation
* Reverse Words in a String

A reusable helper looks like this:

```java
static void reverse(int[] a, int left, int right) {
    while (left < right) {
        int temp = a[left];
        a[left] = a[right];
        a[right] = temp;

        left++;
        right--;
    }
}
```

Then you can simply call:

```java
reverse(a, L, R);
```

This helper is considered the **optimal** solution because it reverses the required portion **in-place**, runs in **O(R - L + 1)** time, and uses **O(1)** extra space.

## ------ problem-3: given a array of size n you need to rotate the array from Right side to left side by given k times --

Excellent. This is one of the **most important array interview questions** because the optimal solution is used in many companies (Google, Amazon, Microsoft, Scaler, etc.).

I'll explain it in the same format you've been learning.

---

# Problem 3: Rotate an Array by K Positions

Given an array of size `N`, rotate the array by `K` positions.

There are two types:

1. **Right Rotation**
2. **Left Rotation**

Example:

```text
A = [10,20,30,40,50,60,70]
K = 2
```

---

# Right Rotation by 2

Every element moves **2 places to the right**.

```text
Original

10 20 30 40 50 60 70
```

After 1 rotation

```text
70 10 20 30 40 50 60
```

After 2 rotations

```text
60 70 10 20 30 40 50
```

Answer

```text
[60,70,10,20,30,40,50]
```

---

# Left Rotation by 2

Every element moves **2 places to the left**.

```text
Original

10 20 30 40 50 60 70
```

After 1 rotation

```text
20 30 40 50 60 70 10
```

After 2 rotations

```text
30 40 50 60 70 10 20
```

Answer

```text
[30,40,50,60,70,10,20]
```

---

# Approach 1 — Brute Force

## Idea

Rotate **one time**, repeat **K times**.

---

# Right Rotation

### Example

```text
A = [10,20,30,40,50]

K = 2
```

### First Rotation

Save last element.

```text
temp = 50
```

Shift everything right.

```text
50 10 20 30 40
```

---

### Second Rotation

Save last.

```text
temp = 40
```

Shift.

```text
40 50 10 20 30
```

Answer

```text
40 50 10 20 30
```

---

# Diagram

```
10 20 30 40 50

↓

50 10 20 30 40

↓

40 50 10 20 30
```

---

## Brute Force Code (Right Rotation)

```java
public class Main {

    public static void main(String[] args) {

        int[] a = {10,20,30,40,50};

        int k = 2;

        int n = a.length;

        for(int r=1;r<=k;r++){

            int last = a[n-1];

            for(int i=n-1;i>0;i--){
                a[i]=a[i-1];
            }

            a[0]=last;
        }

        for(int x:a)
            System.out.print(x+" ");
    }
}
```

---

## Dry Run

Initial

```
10 20 30 40 50
```

Rotation 1

```
last=50

50 10 20 30 40
```

Rotation 2

```
last=40

40 50 10 20 30
```

Done.

---

## Complexity

Outer loop

```
K
```

Inner loop

```
N
```

Total

```
O(N*K)
```

Space

```
O(1)
```

---

# Approach 2 — Better (Extra Array)

Instead of rotating one by one,

calculate directly where every element goes.

---

## Formula (Right Rotation)

```
newIndex = (i + K) % N
```

---

## Example

```
A

10 20 30 40 50

Index

0 1 2 3 4
```

K=2

---

Element

```
10

newIndex=(0+2)%5

=2
```

Result

```
_ _ 10 _ _
```

---

Element

```
20

(1+2)%5=3
```

```
_ _ 10 20 _
```

---

Element

```
30

(2+2)%5=4
```

```
_ _ 10 20 30
```

---

Element

```
40

(3+2)%5=0
```

```
40 _ 10 20 30
```

---

Element

```
50

(4+2)%5=1
```

```
40 50 10 20 30
```

Done.

---

## Diagram

```
Original

10 20 30 40 50

↓

40 50 10 20 30
```

---

## Better Code

```java
public class Main {

    public static void main(String[] args) {

        int[] a={10,20,30,40,50};

        int k=2;

        int n=a.length;

        int[] ans=new int[n];

        for(int i=0;i<n;i++){

            int newIndex=(i+k)%n;

            ans[newIndex]=a[i];
        }

        for(int x:ans)
            System.out.print(x+" ");
    }
}
```

---

## Complexity

Time

```
O(N)
```

Space

```
O(N)
```

---

# Approach 3 — Optimal (Three Reversals)

This is the expected interview solution.

---

## Idea

Instead of shifting,

reverse parts of the array.

---

Example

```
10 20 30 40 50 60 70

K=2
```

---

### Step 1

Reverse whole array

```
70 60 50 40 30 20 10
```

---

### Step 2

Reverse first K elements

```
60 70 50 40 30 20 10
```

---

### Step 3

Reverse remaining elements

```
60 70 10 20 30 40 50
```

Done.

---

# Visual Diagram

Original

```
10 20 30 40 50 60 70
```

↓

Reverse All

```
70 60 50 40 30 20 10
```

↓

Reverse first K

```
60 70 50 40 30 20 10
```

↓

Reverse remaining

```
60 70 10 20 30 40 50
```

Answer

```
60 70 10 20 30 40 50
```

---

# Why does this work?

Suppose

```
A B C D E
```

Rotate right by 2.

Wanted

```
D E A B C
```

Reverse all

```
E D C B A
```

Reverse first 2

```
D E C B A
```

Reverse remaining

```
D E A B C
```

Exactly the required answer.

---

## Helper Function

```java
static void reverse(int[] a,int left,int right){

    while(left<right){

        int temp=a[left];
        a[left]=a[right];
        a[right]=temp;

        left++;
        right--;
    }
}
```

---

## Optimal Code

```java
public class Main {

    static void reverse(int[] a,int left,int right){

        while(left<right){

            int temp=a[left];
            a[left]=a[right];
            a[right]=temp;

            left++;
            right--;
        }
    }

    public static void main(String[] args){

        int[] a={10,20,30,40,50,60,70};

        int k=2;

        int n=a.length;

        k=k%n;

        reverse(a,0,n-1);

        reverse(a,0,k-1);

        reverse(a,k,n-1);

        for(int x:a)
            System.out.print(x+" ");
    }
}
```

---

# Complexity

Time

```
Reverse whole = O(N)

Reverse first K = O(K)

Reverse rest = O(N-K)
```

Total

```
O(N)
```

Space

```
O(1)
```

---

# Left Rotation (Optimal)

Only the order of reversals changes.

For left rotation by K:

### Step 1

Reverse first K

### Step 2

Reverse remaining

### Step 3

Reverse whole array

---

Example

```
10 20 30 40 50 60 70

K=2
```

Reverse first K

```
20 10 30 40 50 60 70
```

Reverse remaining

```
20 10 70 60 50 40 30
```

Reverse whole

```
30 40 50 60 70 10 20
```

Correct.

---

## Left Rotation Code

```java
public class Main {

    static void reverse(int[] a,int left,int right){

        while(left<right){

            int temp=a[left];
            a[left]=a[right];
            a[right]=temp;

            left++;
            right--;
        }
    }

    public static void main(String[] args){

        int[] a={10,20,30,40,50,60,70};

        int k=2;

        int n=a.length;

        k=k%n;

        reverse(a,0,k-1);

        reverse(a,k,n-1);

        reverse(a,0,n-1);

        for(int x:a)
            System.out.print(x+" ");
    }
}
```

---

# Comparison

| Approach                                | Time     | Space    | Interview Rating |
| --------------------------------------- | -------- | -------- | ---------------- |
| Brute Force (rotate one-by-one K times) | O(N × K) | O(1)     | ⭐⭐               |
| Better (extra array)                    | O(N)     | O(N)     | ⭐⭐⭐              |
| **Optimal (3 reversals)**               | **O(N)** | **O(1)** | ⭐⭐⭐⭐⭐            |

---

## Interview Tip

Whenever you're asked to **rotate an array in-place**, the expected solution is almost always the **three-reversal algorithm**:

* **Right Rotation by `k`:**

    1. Reverse the whole array.
    2. Reverse the first `k` elements.
    3. Reverse the remaining `n-k` elements.

* **Left Rotation by `k`:**

    1. Reverse the first `k` elements.
    2. Reverse the remaining `n-k` elements.
    3. Reverse the whole array.

Also remember to normalize `k` first:

```java
k = k % n;
```

This handles cases where `k` is greater than the array size (e.g., rotating by 10 positions in an array of size 7 is the same as rotating by `10 % 7 = 3` positions).
