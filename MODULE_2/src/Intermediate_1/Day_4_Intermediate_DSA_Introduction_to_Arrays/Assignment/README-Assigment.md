## ---- Q1. Good Pair ( Given an array A and an integer B. A pair(i, j) in the array is a good pair if i != j and (A[i] + A[j]  B). Check if any good pair exist or not.) -----
## ---- Q2. Max Min of an Array( Given an array A of size N. You need to find the sum of Maximum and Minimum element in the given array. ) ---
## ---- Q3. Array Rotation( Given an integer array A of size N and an integer B, you have to return the same array after rotating it B times towards the right.) ---
## ---- Q4. Reverse in a range(Given an array A of N integers and also given two integers B and C. Reverse the elements of the array A within the given inclusive range [B, C].) ---
## #################

## -- Q1. Good Pair ( Given an array A and an integer B. A pair(i, j) in the array is a good pair if i != j and (A[i] + A[j]  B). Check if any good pair exist or not.) ----
Your **Brute Force** solution is correct. 👍

Now let's think about the **optimized approach**.

---

# Brute Force

```java
for(int i=0;i<n;i++){
    for(int j=i+1;j<n;j++){
        if(a[i]+a[j]==B){
            return true;
        }
    }
}
```

Time Complexity

```
O(N²)
```

---

# Can we optimize?

Yes.

The idea is:

> For every element `x`, instead of searching the entire array for `B - x`, store the elements you've already seen in a **HashSet**.

---

## Example

```
Array = [3,4,5,2,6,3,10]

B = 9
```

Initially

```
Set = {}
```

---

### Step 1

Current = 3

Need

```
9 - 3 = 6
```

Is 6 in the set?

```
No
```

Add 3

```
Set = {3}
```

---

### Step 2

Current = 4

Need

```
9 - 4 = 5
```

Is 5 in the set?

```
No
```

Add 4

```
Set = {3,4}
```

---

### Step 3

Current = 5

Need

```
9 - 5 = 4
```

Is 4 already in the set?

```
Yes
```

We found

```
4 + 5 = 9
```

Return

```
true
```

Done.

---

# Flow Diagram

```
Array

3 4 5 2 6 3 10

↓

Current = 3
Need = 6
Set={}
↓

Add 3

↓

Current = 4
Need = 5
Set={3}
↓

Add 4

↓

Current = 5
Need = 4
Set={3,4}

↓

Found

Return true
```

---

# Optimized Code

```java
import java.util.HashSet;

public static boolean CheckGoodPairByOptimize(int[] ary, int b){

    HashSet<Integer> set = new HashSet<>();

    for(int i = 0; i < ary.length; i++){

        int required = b - ary[i];

        if(set.contains(required)){
            return true;
        }

        set.add(ary[i]);
    }

    return false;
}
```

---

# Complete Program

```java
import java.util.HashSet;

public class Assignment_1 {

    public static boolean CheckGoodPairByBF(int[] ary, int b){

        for(int i = 0; i < ary.length; i++){

            for(int j = i + 1; j < ary.length; j++){

                if(ary[i] + ary[j] == b){
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean CheckGoodPairByOptimize(int[] ary, int b){

        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < ary.length; i++){

            int required = b - ary[i];

            if(set.contains(required)){
                return true;
            }

            set.add(ary[i]);
        }

        return false;
    }

    public static void main(String[] args){

        int[] array = {3,4,5,2,6,3,10};

        int b = 9;

        System.out.println("BF        : " + CheckGoodPairByBF(array,b));

        System.out.println("Optimized : " + CheckGoodPairByOptimize(array,b));
    }
}
```

---

# Dry Run

```
Array = [3,4,5,2,6,3,10]

B = 9
```

| Current | Need (`B-current`) | Set Before | Found?  | Set After |
| ------: | -----------------: | ---------- | ------- | --------- |
|       3 |                  6 | {}         | No      | {3}       |
|       4 |                  5 | {3}        | No      | {3,4}     |
|       5 |                  4 | {3,4}      | **Yes** | Stop      |

Answer

```
true
```

---

# Complexity Comparison

| Approach            | Time  | Space |
| ------------------- | ----- | ----- |
| Brute Force         | O(N²) | O(1)  |
| Optimized (HashSet) | O(N)  | O(N)  |

---

## Interview Tip

If you're in the **Arrays** chapter **before learning Hashing**, interviewers or your course may expect only the **O(N²)** brute-force solution.

The **O(N)** solution using `HashSet` belongs to the **Hashing** topic. So if your instructor hasn't covered hashing yet, it's perfectly fine to write the brute-force solution first and mention:

> "This can be optimized to O(N) using a HashSet once hashing is allowed."
