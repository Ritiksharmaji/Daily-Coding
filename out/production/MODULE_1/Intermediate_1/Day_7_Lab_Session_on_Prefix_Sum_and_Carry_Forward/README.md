## --------- Problem-1: print all possible subarrays(Related to sub-array problem) ---------
## --------- Problem-2: Sum of odd indexed elements(related to PF-sum)------
## --------- Problem-3: Special Index(related to PF-Sum)------
## --------- Problem-4: Number of Even numbers in given range(related to PF-Sum)----
## --------- Problem-5: Closest Min & Max (related to Carry-forward)-----

## --------- Problem-1: print all possible subarrays(Related to sub-array problem) --------- 
This is an excellent question. However, there is one very important thing to understand first.

> **There is NO optimized algorithm to print all subarrays.**

Why?

If an array has **N** elements, the total number of subarrays is:

[
\frac{N(N+1)}{2}
]

You **must print every one of them**, so the output itself is **O(N²)** subarrays. Since printing each subarray takes time proportional to its length, the total work is **O(N³)**. No algorithm can do better than the size of the output.

So the progression is:

* ❌ Brute Force → O(N⁴) (recalculating and reprinting inefficiently)
* ✅ Better/Standard → O(N³) (the accepted approach)
* ❌ No O(N²) or O(N) optimized algorithm exists for printing all subarrays.

---

# Problem

Print all possible subarrays.

Example:

```text
Array = {4, 13, 8}
```

Output

```text
[4]

[4 13]

[4 13 8]

[13]

[13 8]

[8]
```

---

# Method-1 : Brute Force (Standard Printing)

## Idea

Choose

* Start index
* End index

Then print every element between them.

---

## Flow

```
Start = 0
     │
     ▼
End = 0 → Print

End = 1 → Print

End = 2 → Print

↓

Start = 1

End = 1

End = 2

↓

Start = 2

End = 2
```

---

## Dry Run

Array

```
Index

0 1 2

4 13 8
```

---

### Start = 0

End = 0

```
[4]
```

---

End = 1

```
[4 13]
```

---

End = 2

```
[4 13 8]
```

---

### Start = 1

End = 1

```
[13]
```

---

End = 2

```
[13 8]
```

---

### Start = 2

End = 2

```
[8]
```

---

Total

```
6 subarrays
```

---

## Code

```java
public static void printAllPossibleSubArrayByBFApproach(int[] ary){

    for(int start = 0; start < ary.length; start++){

        for(int end = start; end < ary.length; end++){

            System.out.print("[ ");

            for(int k = start; k <= end; k++){

                System.out.print(ary[k] + " ");

            }

            System.out.println("]");
        }

    }

}
```

---

# Complexity

Outer loop

```
N
```

Middle loop

```
N
```

Printing loop

```
N
```

Total

```
O(N³)
```

---

# Can We Optimize?

Suppose

```
Array

4 13 8
```

Can we avoid printing

```
4

13

8
```

No.

Because the question asks us to print.

Even if we know the answer,

we still have to print

```
[4]

[4 13]

[4 13 8]

[13]

[13 8]

[8]
```

Printing itself takes time.

Therefore,

```
No O(N²)

No O(N)

No Prefix Sum

No Carry Forward

No Contribution
```

---

# Final Code

```java
package Intermediate_1.Day_7_Lab_Session_on_Prefix_Sum_and_Carry_Forward.ClassVideo;

/*
----------------------------------------------------------
Problem-1 : Print All Possible Subarrays
----------------------------------------------------------

Example

Array = {4,13,8}

Output

[4]
[4 13]
[4 13 8]
[13]
[13 8]
[8]

----------------------------------------------------------
*/

public class Problem_1 {

    // ====================================================
    // Method-1 : Standard / Brute Force
    // Time : O(N³)
    // Space : O(1)
    // ====================================================
    public static void printAllPossibleSubArrayByBFApproach(int[] ary){

        System.out.println("========== Brute Force ==========\n");

        for(int start = 0; start < ary.length; start++){

            for(int end = start; end < ary.length; end++){

                System.out.print("[ ");

                for(int k = start; k <= end; k++){

                    System.out.print(ary[k] + " ");

                }

                System.out.println("]");
            }
        }
    }

    // ====================================================
    // Method-2 : Optimized
    // Not Possible
    // Printing every subarray itself requires O(N³)
    // ====================================================
    public static void printAllPossibleSubArrayByOptimizeApproach(int[] ary){

        System.out.println("\n========== Optimized ==========");

        System.out.println("No optimized algorithm exists.");

        System.out.println("Reason:");

        System.out.println("To print every subarray,");
        System.out.println("we must print every element inside it.");

        System.out.println("Hence minimum complexity is O(N³).");
    }

    public static void main(String[] args){

        int[] array = {4,13,8};

        printAllPossibleSubArrayByBFApproach(array);

        printAllPossibleSubArrayByOptimizeApproach(array);
    }
}
```

## Interview Tip

When an interviewer asks:

> **"Can you optimize printing all subarrays?"**

The correct answer is:

> **No.** The output size itself is Θ(N³) characters/elements in the worst case, so any algorithm that prints every subarray must spend Θ(N³) time. You cannot do asymptotically better than the size of the required output.

This is an important concept: sometimes the **output size** determines the best possible time complexity.

## --------- Problem-2: Sum of odd indexed elements(related to PF-sum)------
## --------- Problem-3: Special Index(related to PF-Sum ( Given an array of size N. Find the number of special indices. A special index is an index such that after removing that element Sum of Even Indexed Elements = Sum of Odd Indexed Elements))------
This is a very famous **Prefix Sum** interview problem (asked in companies and on platforms like Scaler/LeetCode variants).

Let's understand it from scratch.

---

# Problem Statement

Given an array of size **N**.

Find the **number of special indices**.

A **special index** is an index such that after removing that element,

```text
Sum of Even Indexed Elements
        ==
Sum of Odd Indexed Elements
```

(Remember: after removing an element, **all indices after it shift left by one**, so their parity changes.)

---

# Example

```text
A = [4, 3, 2, 7, 6]
```

Index

```text
0  1  2  3  4
4  3  2  7  6
```

---

## Remove index 2

Remove

```text
2
```

New array

```text
4 3 7 6
```

New indices

```text
0 1 2 3
```

Even index sum

```text
4 + 7 = 11
```

Odd index sum

```text
3 + 6 = 9
```

Not special.

---

# Why is this tricky?

Suppose

```text
0 1 2 3 4

4 3 2 7 6
```

Remove index 1

New array

```text
4 2 7 6
```

New indices become

```text
0 1 2 3
```

Notice

```text
Old index 2
```

becomes

```text
New index 1
```

So

```text
Even becomes Odd

Odd becomes Even
```

after the removed index.

This is the main observation.

---

# Brute Force

For every index

1. Remove it.
2. Calculate even sum.
3. Calculate odd sum.
4. Compare.

---

## Dry Run

Array

```text
4 3 2 7
```

Remove

```text
index 1
```

New array

```text
4 2 7
```

Even

```text
4+7=11
```

Odd

```text
2
```

Not equal.

---

## Brute Force Code

```java
for every index

    remove element

    calculate even sum

    calculate odd sum

    if(equal)

        answer++
```

Complexity

```text
O(N²)
```

---

# Optimized Idea (Prefix Sum)

Instead of rebuilding the array every time,

store

* Prefix Even Sum
* Prefix Odd Sum

---

Suppose

```text
A

0 1 2 3 4

4 3 2 7 6
```

Even Prefix

```text
Index

0 1 2 3 4

4 4 6 6 12
```

Odd Prefix

```text
0 3 3 10 10
```

---

# Observation

Remove index `i`

The array divides into

```text
Left Part

0........i-1

Right Part

i+1......N-1
```

---

## Left Part

Nothing changes.

Even stays even.

Odd stays odd.

---

Even Left

```text
evenPrefix[i-1]
```

Odd Left

```text
oddPrefix[i-1]
```

---

## Right Part

Everything shifts left.

Therefore

```text
Old Even

↓

New Odd
```

and

```text
Old Odd

↓

New Even
```

---

So

New Even Sum

```text
Left Even

+

Right Odd
```

New Odd Sum

```text
Left Odd

+

Right Even
```

---

# Formula

Suppose

```text
TotalEven

TotalOdd
```

already known.

Then

```text
leftEven

=

evenPrefix[i-1]
```

```text
leftOdd

=

oddPrefix[i-1]
```

Right Even

```text
totalEven-evenPrefix[i]
```

Right Odd

```text
totalOdd-oddPrefix[i]
```

---

New Even

```text
leftEven

+

rightOdd
```

New Odd

```text
leftOdd

+

rightEven
```

If equal

```text
answer++
```

---

# Optimized Code

```java
public static int countSpecialIndex(int[] A){

    int n = A.length;

    int[] evenPrefix = new int[n];
    int[] oddPrefix = new int[n];

    evenPrefix[0] = A[0];
    oddPrefix[0] = 0;

    for(int i = 1; i < n; i++){

        evenPrefix[i] = evenPrefix[i - 1];
        oddPrefix[i] = oddPrefix[i - 1];

        if(i % 2 == 0)
            evenPrefix[i] += A[i];
        else
            oddPrefix[i] += A[i];
    }

    int totalEven = evenPrefix[n - 1];
    int totalOdd = oddPrefix[n - 1];

    int answer = 0;

    for(int i = 0; i < n; i++){

        int leftEven = (i == 0) ? 0 : evenPrefix[i - 1];
        int leftOdd = (i == 0) ? 0 : oddPrefix[i - 1];

        int rightEven = totalEven - evenPrefix[i];
        int rightOdd = totalOdd - oddPrefix[i];

        int newEven = leftEven + rightOdd;
        int newOdd = leftOdd + rightEven;

        if(newEven == newOdd){
            answer++;
        }
    }

    return answer;
}
```

---

# Complexity

| Approach    | Time     | Space |
| ----------- | -------- | ----- |
| Brute Force | O(N²)    | O(1)  |
| Prefix Sum  | **O(N)** | O(N)  |

---

## Trick to Remember

Whenever an element is **removed** from an array:

```text
Elements before removed index
        ↓
No change

Elements after removed index
        ↓
Shift left by one

Even → Odd

Odd → Even
```

This parity flip is the key insight that makes the prefix sum solution work in **O(N)** instead of **O(N²)**.

## --------- Problem-4: Number of Even numbers in given range(Given an array of size N and Q queries with L and R for every query return count of even elements from L to R (related to PF-Sum)----


## --------- Problem-5: Closest Min & Max(given an array find length of smallest subarray which contain both min and max of array (related to Carry-forward) -----

This is one of the **most important Carry Forward problems**. The optimized solution is beautiful because it reduces **O(N³) → O(N)**.

---

# Problem Statement

Given an array, find the **length of the smallest subarray** that contains **both the minimum and maximum element** of the entire array.

---

## Example 1

```text
Array

[1, 3, 2]
```

Minimum

```text
1
```

Maximum

```text
3
```

Possible subarrays containing both

```text
[1,3]
Length = 2

[1,3,2]
Length = 3
```

Answer

```text
2
```

---

## Example 2

```text
Array

[2,6,1,6,9,1,9]
```

Minimum

```text
1
```

Maximum

```text
9
```

Possible subarrays

```text
[1,6,9]
Length = 3

[9,1]
Length = 2

[1,9]
Length = 2
```

Answer

```text
2
```

---

# Method-1 : Brute Force (O(N³))

## Idea

Generate every possible subarray.

For every subarray,

check whether

* minimum exists
* maximum exists

If yes,

update minimum length.

---

## Flow

```
Choose Start

        │

        ▼

Choose End

        │

        ▼

Traverse Subarray

        │

        ▼

Contains Min?

Contains Max?

        │

        ▼

Update Answer
```

---

## Code

```java
public static int closestMinMaxBF(int[] array){

    int n = array.length;

    // Find original min and max
    int min = array[0];
    int max = array[0];

    for(int i=1;i<n;i++){
        min=Math.min(min,array[i]);
        max=Math.max(max,array[i]);
    }

    if(min==max)
        return 1;

    int ans=Integer.MAX_VALUE;

    // Generate every subarray
    for(int start=0;start<n;start++){

        for(int end=start;end<n;end++){

            boolean minFound=false;
            boolean maxFound=false;

            for(int k=start;k<=end;k++){

                if(array[k]==min)
                    minFound=true;

                if(array[k]==max)
                    maxFound=true;
            }

            if(minFound && maxFound){

                ans=Math.min(ans,end-start+1);

            }

        }

    }

    return ans;
}
```

---

# Dry Run

```
Array

1 3 2

Min=1

Max=3
```

---

Start=0

```
End=0

[1]

Only Min
```

---

End=1

```
[1 3]

Min ✓

Max ✓

Length=2

Answer=2
```

---

End=2

```
[1 3 2]

Length=3
```

---

Start=1

```
[3]

Only Max
```

---

Start=2

```
[2]

Nothing
```

Answer

```
2
```

---

## Complexity

```
Outer Loop      O(N)

Middle Loop     O(N)

Inner Loop      O(N)

Total

O(N³)
```

---

# Can we Optimize?

Suppose

```
Array

2 6 1 6 9 1 9
```

Brute force checks

```
Every

Possible

Subarray
```

Most of them are useless.

Can we avoid that?

Yes.

---

# Observation

Suppose

```
2 6 1 6 9 1 9

          ↑
```

Current element

```
9
```

To make a subarray containing both

```
1

and

9
```

We only need

```
Nearest previous 1
```

Not all previous 1's.

Similarly,

Whenever we see

```
1
```

We only need

```
Nearest previous 9
```

This is the Carry Forward idea.

---

# Method-2 : Optimized (Carry Forward)

Maintain

```
lastMinIndex

lastMaxIndex
```

Whenever you encounter

```
Min
```

store its latest index.

Whenever you encounter

```
Max
```

store its latest index.

As soon as both indices are known,

calculate

```
length

=

abs(lastMin-lastMax)+1
```

Take minimum.

---

# Dry Run

```
Array

2 6 1 6 9 1 9

Min=1

Max=9
```

Initially

```
lastMin=-1

lastMax=-1

answer=∞
```

---

i=0

```
2

Nothing
```

---

i=1

```
6

Nothing
```

---

i=2

```
1

lastMin=2
```

No max yet.

---

i=3

```
6
```

Nothing.

---

i=4

```
9

lastMax=4
```

Now both exist

```
Length

4-2+1

=

3
```

Answer

```
3
```

---

i=5

```
1

lastMin=5
```

Length

```
5-4+1

=

2
```

Answer

```
2
```

---

i=6

```
9

lastMax=6
```

Length

```
6-5+1

=

2
```

Answer

```
2
```

Finished.

---

# Flow Diagram

```
Start

↓

Find Min & Max

↓

Traverse Array

↓

Current == Min ?

↓

Yes

Store lastMin

↓

Current == Max ?

↓

Yes

Store lastMax

↓

Both Known ?

↓

Yes

Length

=

abs(lastMin-lastMax)+1

↓

Update Answer
```

---

# Optimized Code

```java
public static int closestMinMaxOptimize(int[] array){

    int n=array.length;

    int min=array[0];
    int max=array[0];

    for(int i=1;i<n;i++){

        min=Math.min(min,array[i]);
        max=Math.max(max,array[i]);

    }

    if(min==max)
        return 1;

    int lastMin=-1;
    int lastMax=-1;

    int answer=Integer.MAX_VALUE;

    for(int i=0;i<n;i++){

        if(array[i]==min){

            lastMin=i;

            if(lastMax!=-1){

                answer=Math.min(answer,
                        i-lastMax+1);

            }

        }

        if(array[i]==max){

            lastMax=i;

            if(lastMin!=-1){

                answer=Math.min(answer,
                        i-lastMin+1);

            }

        }

    }

    return answer;

}
```

---

# Complete Program

```java
public class Problem_5 {

    // Brute Force
    public static int closestMinMaxBF(int[] array){

        int n=array.length;

        int min=array[0];
        int max=array[0];

        for(int i=1;i<n;i++){
            min=Math.min(min,array[i]);
            max=Math.max(max,array[i]);
        }

        if(min==max)
            return 1;

        int ans=Integer.MAX_VALUE;

        for(int start=0;start<n;start++){

            for(int end=start;end<n;end++){

                boolean minFound=false;
                boolean maxFound=false;

                for(int k=start;k<=end;k++){

                    if(array[k]==min)
                        minFound=true;

                    if(array[k]==max)
                        maxFound=true;

                }

                if(minFound && maxFound){

                    ans=Math.min(ans,
                            end-start+1);

                }

            }

        }

        return ans;
    }

    // Optimized
    public static int closestMinMaxOptimize(int[] array){

        int n=array.length;

        int min=array[0];
        int max=array[0];

        for(int i=1;i<n;i++){

            min=Math.min(min,array[i]);
            max=Math.max(max,array[i]);

        }

        if(min==max)
            return 1;

        int lastMin=-1;
        int lastMax=-1;

        int ans=Integer.MAX_VALUE;

        for(int i=0;i<n;i++){

            if(array[i]==min){

                lastMin=i;

                if(lastMax!=-1){

                    ans=Math.min(ans,
                            i-lastMax+1);

                }

            }

            if(array[i]==max){

                lastMax=i;

                if(lastMin!=-1){

                    ans=Math.min(ans,
                            i-lastMin+1);

                }

            }

        }

        return ans;
    }

    public static void main(String[] args){

        int[] array={2,6,1,6,9,1,9};

        System.out.println(
                "Brute Force : "
                        +closestMinMaxBF(array));

        System.out.println(
                "Optimized : "
                        +closestMinMaxOptimize(array));

    }

}
```

---

# Complexity Comparison

| Method                    | Idea                                | Time      | Space |
| ------------------------- | ----------------------------------- | --------- | ----- |
| Brute Force               | Check every subarray                | **O(N³)** | O(1)  |
| Optimized (Carry Forward) | Track last seen min and max indices | **O(N)**  | O(1)  |

## Why is this called a Carry Forward problem?

The key idea is that while traversing the array once, you **carry forward** the most recent positions of the minimum and maximum elements (`lastMin` and `lastMax`). At each occurrence of one, you immediately know the shortest subarray ending at the current index that contains both values. This "carried-forward state" is what reduces the complexity from **O(N³)** to **O(N)**.
