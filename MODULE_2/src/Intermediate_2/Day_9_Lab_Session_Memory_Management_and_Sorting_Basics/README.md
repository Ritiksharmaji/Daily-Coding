## -- Problem-1: In an array of N elements, find count of nobel integers, A[i] is Noble if count of smaller elements of A[i] should equal to A[i].
## -- Problem-2: Given an array of N integers , we have to delete all elements of the array Before deleting an elements pay cost = sum of elements in the array cost that point find min cost.

## -- Problem-1: In an array of N elements, find count of nobel integers, A[i] is Noble if count of smaller elements of A[i] should equal to A[i].
This is one of the **most important Sorting interview problems**. Let's learn it from **Brute Force → Better → Optimized**.

---

# Problem Statement

Given an array of **N** integers.

An element **A[i]** is called a **Noble Integer** if:

```text
Number of elements strictly smaller than A[i]
=
A[i]
```

Return the **count of Noble Integers**.

---

# Example-1

```text
Array

[-10,-5,1,3,4,2,6]
```

After sorting

```text
[-10,-5,1,2,3,4,6]
```

Count smaller elements

| Value | Smaller Elements | Count | Noble? |
| ----- | ---------------- | ----- | ------ |
| -10   | None             | 0     | ❌      |
| -5    | -10              | 1     | ❌      |
| 1     | -10,-5           | 2     | ❌      |
| 2     | -10,-5,1         | 3     | ❌      |
| 3     | -10,-5,1,2       | 4     | ❌      |
| 4     | -10,-5,1,2,3     | 5     | ❌      |
| 6     | -10,-5,1,2,3,4   | 6     | ✅      |

Answer

```text
1
```

---

# Example-2

```text
Array

[1,-5,3,5,-10,4]
```

Sorted

```text
[-10,-5,1,3,4,5]
```

| Value | Smaller Count | Noble? |
| ----- | ------------: | ------ |
| -10   |             0 | ❌      |
| -5    |             1 | ❌      |
| 1     |             2 | ❌      |
| 3     |             3 | ✅      |
| 4     |             4 | ✅      |
| 5     |             5 | ✅      |

Answer

```text
3
```

---

# Method-1 : Brute Force

## Idea

For every element

Count how many elements are smaller than it.

If

```text
count == element
```

then it is Noble.

---

## Flow Diagram

```text
Take One Element

       │

       ▼

Traverse Entire Array

       │

       ▼

Count Smaller Elements

       │

       ▼

count == value ?

       │

Yes

       │

ans++
```

---

## Dry Run

```text
Array

[3,1,4]
```

Check

```text
3
```

Smaller

```text
1
```

Count

```text
1
```

Not Noble.

---

Check

```text
1
```

Smaller

```text
None
```

Count

```text
0
```

Not Noble.

---

Check

```text
4
```

Smaller

```text
3

1
```

Count

```text
2
```

Not Noble.

Answer

```text
0
```

---

## Brute Force Code

```java
public static int nobleBF(int[] array){

    int ans=0;

    for(int i=0;i<array.length;i++){

        int count=0;

        for(int j=0;j<array.length;j++){

            if(array[j]<array[i]){

                count++;

            }

        }

        if(count==array[i]){

            ans++;

        }

    }

    return ans;

}
```

---

## Complexity

```text
Outer Loop

O(N)

Inner Loop

O(N)

Total

O(N²)
```

---

# Can We Optimize?

Suppose after sorting

```text
-10 -5 1 3 4 5
```

Notice

```text
Index

0 1 2 3 4 5
```

For distinct numbers,

the index itself equals the number of smaller elements.

Example

```text
4
```

Its index

```text
4
```

Exactly

```text
4
```

elements are before it.

So after sorting,

we don't need another loop.

---

# Method-2 : Better (Sorting)

## Idea

Sort array.

For every element

its index tells

how many smaller elements exist.

---

## Dry Run

```text
Array

1 -5 3 5 -10 4
```

Sort

```text
-10 -5 1 3 4 5
```

Index

```text
0 1 2 3 4 5
```

Check

```text
index==value
```

| Index | Value | Noble? |
| ----: | ----: | ------ |
|     0 |   -10 | ❌      |
|     1 |    -5 | ❌      |
|     2 |     1 | ❌      |
|     3 |     3 | ✅      |
|     4 |     4 | ✅      |
|     5 |     5 | ✅      |

Answer

```text
3
```

---

## Better Code (Works for Distinct Elements)

```java
public static int nobleBetter(int[] array){

    Arrays.sort(array);

    int ans=0;

    for(int i=0;i<array.length;i++){

        if(i==array[i]){

            ans++;

        }

    }

    return ans;

}
```

---

## Problem with Better Method

Fails for duplicates.

Example

```text
0 0 1
```

Sorted

```text
0 0 1
```

Second zero has

```text
0
```

smaller elements,

not

```text
1
```

(index).

So duplicates break this idea.

---

# Method-3 : Optimized (Sorting + Duplicate Handling)

## Observation

Whenever value changes,

store current index.

That index equals

number of smaller elements.

Example

```text
Sorted

0 0 1 2 2 4
```

Process

| Index | Value | count(smaller) |
| ----: | ----: | -------------: |
|     0 |     0 |              0 |
|     1 |     0 |              0 |
|     2 |     1 |              2 |
|     3 |     2 |              3 |
|     4 |     2 |              3 |
|     5 |     4 |              5 |

Notice

duplicates keep

same count.

---

## Flow Diagram

```text
Sort

↓

count=0

↓

Current value changed?

↓

Yes

↓

count=current index

↓

count==value ?

↓

Yes

↓

ans++
```

---

## Dry Run

```text
Array

0 0 1 2 2 4
```

Sorted

```text
0 0 1 2 2 4
```

Start

```text
count=0
```

Index 0

```text
value=0

count=0

Noble

ans=1
```

Index 1

Duplicate

Keep

```text
count=0
```

No new check.

---

Index 2

```text
count=2

value=1

No
```

---

Index 3

```text
count=3

value=2

No
```

---

Index 4

Duplicate

Skip.

---

Index 5

```text
count=5

value=4

No
```

Final

```text
1
```

---

## Optimized Code

```java
public static int nobleOptimize(int[] array){

    Arrays.sort(array);

    int ans=0;

    if(array[0]==0)
        ans++;

    int count=0;

    for(int i=1;i<array.length;i++){

        if(array[i]!=array[i-1]){

            count=i;

            if(count==array[i]){

                ans++;

            }

        }

    }

    return ans;

}
```

---

# Complexity Comparison

| Method                                | Time       | Space | Handles Duplicates? |
| ------------------------------------- | ---------- | ----- | ------------------- |
| Brute Force                           | O(N²)      | O(1)  | ✅                   |
| Better (Sort + Index)                 | O(N log N) | O(1)* | ❌                   |
| Optimized (Sort + Duplicate Handling) | O(N log N) | O(1)* | ✅                   |

> *Ignoring the implementation details of Java's sorting algorithm.

---

# Final Combined Program

```java
import java.util.Arrays;

public class Problem_1 {

    // ===============================
    // Method-1 : Brute Force
    // ===============================
    public static int nobleBF(int[] array){

        int ans=0;

        for(int i=0;i<array.length;i++){

            int count=0;

            for(int j=0;j<array.length;j++){

                if(array[j]<array[i]){

                    count++;

                }

            }

            if(count==array[i]){

                ans++;

            }

        }

        return ans;

    }

    // ===============================
    // Method-2 : Better
    // (Distinct Elements Only)
    // ===============================
    public static int nobleBetter(int[] array){

        Arrays.sort(array);

        int ans=0;

        for(int i=0;i<array.length;i++){

            if(i==array[i]){

                ans++;

            }

        }

        return ans;

    }

    // ===============================
    // Method-3 : Optimized
    // (Handles Duplicates)
    // ===============================
    public static int nobleOptimize(int[] array){

        Arrays.sort(array);

        int ans=0;

        if(array[0]==0)
            ans++;

        int count=0;

        for(int i=1;i<array.length;i++){

            if(array[i]!=array[i-1]){

                count=i;

                if(count==array[i]){

                    ans++;

                }

            }

        }

        return ans;

    }

    public static void main(String[] args){

        int[] array={1,-5,3,5,-10,4};

        System.out.println("Brute Force : "+
                nobleBF(array.clone()));

        System.out.println("Better : "+
                nobleBetter(array.clone()));

        System.out.println("Optimized : "+
                nobleOptimize(array.clone()));

    }

}
```

---

## Interview Tip

Whenever you see a problem involving **"count of smaller elements"**, think in this order:

1. **Brute Force** → Compare each element with every other element (**O(N²)**).
2. **Sorting** → After sorting, the **index represents the number of smaller elements** for distinct values.
3. **Duplicates?** → If duplicates exist, keep a variable (`count`) that stores the index of the **first occurrence** of each distinct value. That `count` represents the number of strictly smaller elements. This is the standard optimized solution for the Noble Integer problem.

## -- Problem-2: Given an array of N integers , we have to delete all elements of the array Before deleting an elements pay cost = sum of elements in the array cost that point find min cost.
This problem is a classic **Greedy + Sorting** problem. The key idea is to realize that **the order in which you delete elements changes the total cost**.

---

# Problem Statement

Given an array of **N** integers.

You must delete **all** elements.

When deleting one element:

```text
Cost = Sum of all elements currently present in the array.
```

Find the **minimum total cost**.

---

# Example

```text
Array

[4, 3, 2]
```

Initially

```text
Sum = 9
```

---

Suppose we delete

```text
4
```

Remaining

```text
3 2
```

Cost paid

```text
9
```

---

Now

```text
Sum = 5
```

Delete

```text
3
```

Cost

```text
5
```

---

Remaining

```text
2
```

Cost

```text
2
```

Total

```text
9+5+2

=

16
```

---

Now try another order.

Delete

```text
2
```

First.

Cost

```text
9
```

Remaining

```text
4 3
```

Sum

```text
7
```

Delete

```text
3
```

Cost

```text
7
```

Remaining

```text
4
```

Cost

```text
4
```

Total

```text
9+7+4

=

20
```

---

Clearly

```text
16 < 20
```

So

**delete bigger elements first.**

---

# Why?

Suppose

```text
10 5 1
```

Current sum

```text
16
```

### Delete biggest first

```text
Delete 10

Cost=16

Remaining

5 1

Cost=6

Remaining

1

Cost=1

Total

23
```

---

### Delete smallest first

```text
Delete 1

Cost=16

Remaining

10 5

Cost=15

Remaining

10

Cost=10

Total

41
```

Huge difference.

---

# Observation

To reduce future sums quickly,

remove the **largest element first**.

Therefore

```text
Sort

↓

Descending

↓

Delete one by one
```

This is Greedy.

---

# Method-1 : Brute Force

Generate every possible deletion order.

Compute cost.

Take minimum.

---

Example

```text
1 2 3
```

Possible orders

```text
1 2 3

1 3 2

2 1 3

2 3 1

3 1 2

3 2 1
```

There are

```text
N!
```

orders.

Impossible for large N.

---

### Complexity

```text
O(N!)
```

---

# Method-2 : Better

Sort descending.

Calculate current sum.

Delete one by one.

---

# Dry Run

Array

```text
4 3 2
```

Sort descending

```text
4 3 2
```

Current sum

```text
9
```

---

Delete

```text
4
```

Pay

```text
9
```

Remaining sum

```text
5
```

---

Delete

```text
3
```

Pay

```text
5
```

Remaining

```text
2
```

---

Delete

```text
2
```

Pay

```text
2
```

Total

```text
16
```

---

# Flow Diagram

```text
Sort Descending

        │

        ▼

Find Total Sum

        │

        ▼

Cost += Current Sum

        │

        ▼

Subtract Deleted Element

        │

        ▼

Repeat
```

---

# Better Code

```java
public static int minimumCost(int[] array){

    Arrays.sort(array);

    int n=array.length;

    int sum=0;

    for(int x:array){

        sum+=x;

    }

    int cost=0;

    for(int i=n-1;i>=0;i--){

        cost+=sum;

        sum-=array[i];

    }

    return cost;

}
```

---

# Dry Run

Array

```text
5 4 3 1
```

Sorted

```text
1 3 4 5
```

Traverse from back

| Delete | Current Sum | Cost |
| ------ | ----------: | ---: |
| 5      |          13 |   13 |
| 4      |           8 |   21 |
| 3      |           4 |   25 |
| 1      |           1 |   26 |

Answer

```text
26
```

---

# Complexity

Sorting

```text
O(NlogN)
```

Loop

```text
O(N)
```

Total

```text
O(NlogN)
```

---

# Can we do O(N)?

No.

Because we must know

```text
Largest

↓

Second Largest

↓

Third Largest
```

Sorting is required.

Without extra constraints,

the best complexity is

```text
O(NlogN)
```

---

# Final Complete Code

```java
import java.util.Arrays;

public class Problem_2 {

    public static int minimumCost(int[] array){

        // Sort ascending
        Arrays.sort(array);

        System.out.println("Sorted Array : "
                +Arrays.toString(array));

        // Calculate total sum
        int sum=0;

        for(int x:array){

            sum+=x;

        }

        int cost=0;

        // Delete from largest
        for(int i=array.length-1;i>=0;i--){

            cost+=sum;

            System.out.println(
                    "Delete : "+array[i]
                    +"  Current Sum : "+sum
                    +"  Total Cost : "+cost);

            sum-=array[i];

        }

        return cost;

    }

    public static void main(String[] args){

        int[] array={1,-5,3,5,-10,4};

        int ans=minimumCost(array);

        System.out.println("\nMinimum Cost = "+ans);

    }

}
```

---

# Complexity Comparison

| Method                   | Idea                    | Time           | Space                       |
| ------------------------ | ----------------------- | -------------- | --------------------------- |
| Brute Force              | Try all deletion orders | **O(N!)**      | O(N)                        |
| Greedy (Sort Descending) | Delete largest first    | **O(N log N)** | O(1) extra (excluding sort) |

---

## Interview Trick

Whenever you see:

* **"Delete elements one by one"**
* **"Cost depends on remaining sum"**
* **"Find minimum cost"**

think:

```text
Greedy

↓

Which deletion reduces future cost the fastest?

↓

Delete the largest element first.
```

This greedy strategy is optimal because removing larger values earlier causes all subsequent array sums (and therefore future costs) to decrease as much as possible.
