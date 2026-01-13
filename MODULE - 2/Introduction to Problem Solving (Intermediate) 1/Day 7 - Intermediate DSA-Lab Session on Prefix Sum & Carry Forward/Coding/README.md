## Q1. Closest MinMax ###
Problem Description

Given an array A, find the size of the smallest subarray such that it contains at least one occurrence of the maximum value of the array

and at least one occurrence of the minimum value of the array.



Problem Constraints

1 <= |A| <= 2000



Input Format

First and only argument is vector A



Output Format

Return the length of the smallest subarray which has at least one occurrence of minimum and maximum element of the array

Example Input

Input 1:
```
A = [1, 3, 2]
```
Input 2:

```
A = [2, 6, 1, 6, 9]
```
Example Output

Output 1:
```
2
```
Output 2:
```
3
```
ans:
Perfect 👍
You’re asking **the right way to learn DSA** — **code first → then dry run → then optimize step-by-step without skipping anything**.
I’ll go **slow, complete, and very structured**.

We’ll solve **ONE problem** and **evolve the code from O(n³) → O(n²) → O(n)**
with **FULL CODE + DRY RUN DIAGRAMS** at **each level**.

---

# 📌 Problem (Same for all approaches)

**Given an array, find the length of the smallest subarray that contains both the minimum and maximum element of the array.**

```
Input:  A = [2, 6, 1, 6, 9]
Output: 3   → subarray [1, 6, 9]
```

---

# 🔴 STEP 1: BRUTE FORCE — O(n³)

---

## ✅ CODE (O(n³))

```java
public class MinMaxSubarray {

    public static int solve(int[] A) {
        int n = A.length;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // find min and max
        for (int x : A) {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }

        int ans = n;

        // generate all subarrays
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                boolean hasMin = false;
                boolean hasMax = false;

                // scan subarray i → j
                for (int k = i; k <= j; k++) {
                    if (A[k] == min) hasMin = true;
                    if (A[k] == max) hasMax = true;
                }

                if (hasMin && hasMax) {
                    ans = Math.min(ans, j - i + 1);
                }
            }
        }
        return ans;
    }
}
```

---

## 🧪 DRY RUN (O(n³))

### Step 1: Find min & max

```
Array: [2, 6, 1, 6, 9]
min = 1
max = 9
```

---

### Step 2: Triple loop execution

#### i = 0, j = 4

```
Subarray: [2, 6, 1, 6, 9]
k scans → found min and max
length = 5
ans = 5
```

📐 Diagram

```
0   1   2   3   4
[2] [6] [1] [6] [9]
↑---------------↑
```

---

#### i = 2, j = 4

```
Subarray: [1, 6, 9]
k scans → found min and max
length = 3
ans = 3
```

📐 Diagram

```
      2   3   4
     [1] [6] [9]
      ↑-------↑
```

---

## ⏱ Time Complexity

```
n (i loop)
× n (j loop)
× n (k loop)
= O(n³)
```

---

# 🟠 STEP 2: OPTIMIZED BRUTE FORCE — O(n²)

---

## 💡 Optimization Insight

> Why scan `k` every time?
> We already know what we’ve seen so far while expanding `j`.

---

## ✅ CODE (O(n²))

```java
public class MinMaxSubarray {

    public static int solve(int[] A) {
        int n = A.length;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int x : A) {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }

        int ans = n;

        for (int i = 0; i < n; i++) {
            boolean hasMin = false;
            boolean hasMax = false;

            for (int j = i; j < n; j++) {
                if (A[j] == min) hasMin = true;
                if (A[j] == max) hasMax = true;

                if (hasMin && hasMax) {
                    ans = Math.min(ans, j - i + 1);
                }
            }
        }
        return ans;
    }
}
```

---

## 🧪 DRY RUN (O(n²))

### i = 2

```
Start i = 2
hasMin = false, hasMax = false
```

| j | A[j] | hasMin | hasMax | action   |
| - | ---- | ------ | ------ | -------- |
| 2 | 1    | true   | false  | continue |
| 3 | 6    | true   | false  | continue |
| 4 | 9    | true   | true   | ans = 3  |

📐 Diagram

```
      2   3   4
     [1] [6] [9]
      ↑---j---↑
```

---

## ⏱ Time Complexity

```
n (i loop)
× n (j loop)
= O(n²)
```

---

# 🟢 STEP 3: FULLY OPTIMIZED — O(n) (Carry Forward)

---

## 💡 Final Insight

> The smallest window must be between the **nearest min and max positions**.

So:

* Just track **last seen min & max**
* No subarrays
* No nested loops

---

## ✅ CODE (O(n))

```java
public class MinMaxSubarray {

    public static int solve(int[] A) {
        int n = A.length;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int x : A) {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }

        int lastMin = -1;
        int lastMax = -1;
        int ans = n;

        for (int i = 0; i < n; i++) {
            if (A[i] == min) lastMin = i;
            if (A[i] == max) lastMax = i;

            if (lastMin != -1 && lastMax != -1) {
                ans = Math.min(ans, Math.abs(lastMin - lastMax) + 1);
            }
        }
        return ans;
    }
}
```

---

## 🧪 DRY RUN (O(n))

| i | A[i] | lastMin | lastMax | length | ans   |
| - | ---- | ------- | ------- | ------ | ----- |
| 0 | 2    | -1      | -1      | ❌      | 5     |
| 1 | 6    | -1      | -1      | ❌      | 5     |
| 2 | 1    | 2       | -1      | ❌      | 5     |
| 3 | 6    | 2       | -1      | ❌      | 5     |
| 4 | 9    | 2       | 4       | 3      | **3** |

📐 Diagram

```
Index:   0   1   2   3   4
Array:  [2] [6] [1] [6] [9]
                  ↑       ↑
               lastMin   lastMax
```

---

# 🧠 FINAL COMPARISON

| Approach | Time  | Key Idea            |
| -------- | ----- | ------------------- |
| Brute    | O(n³) | Scan every subarray |
| Better   | O(n²) | Avoid re-scan       |
| Best     | O(n)  | Track indices       |

---

## 🎯 Interview Tip

> Always ask:
> **“Can I avoid re-scanning or re-computing?”**
> That’s where optimization lives.

---

If you want next:

* Same explanation for **Prefix Sum**
* Same for **Kadane’s Algorithm**
* Same for **Linked List problems**

Just tell me 👍

## --- explain dry run in more detials dry digram from n3 to n don't skiip anything take your own time explain in more detilas only dry digram when ans  will return and when not how it compareting lenght and all ----
Perfect.
Now I will **ONLY do DRY RUN + DIAGRAM**, **no theory**, **no shortcuts**, **no skipping**, exactly as you asked.
We will clearly see:

✔ when `ans` is updated
✔ when `ans` is NOT updated
✔ how length is calculated
✔ when return happens

Same input for **all three**.

---

# INPUT USED EVERYWHERE

```
A = [2, 6, 1, 6, 9]
Index: 0  1  2  3  4
min = 1
max = 9
n = 5
initial ans = 5
```

---

# 🔴 O(n³) DRY RUN (i → j → k)

---

## i = 0

### j = 0

Subarray → `[2]`

k = 0 → 2 ❌ min ❌ max
Result → ❌
`ans NOT updated`

```
[2]
↑
```

---

### j = 1

Subarray → `[2, 6]`

k scan:

* 2 ❌
* 6 ❌

Result → ❌
`ans NOT updated`

```
[2, 6]
↑----↑
```

---

### j = 2

Subarray → `[2, 6, 1]`

k scan:

* 2 ❌
* 6 ❌
* 1 ✔ min

❌ max missing
`ans NOT updated`

```
[2, 6, 1]
↑--------↑
```

---

### j = 3

Subarray → `[2, 6, 1, 6]`

k scan:

* min ✔
* max ❌

`ans NOT updated`

---

### j = 4

Subarray → `[2, 6, 1, 6, 9]`

k scan:

* min ✔
* max ✔

✔ VALID SUBARRAY
Length = `4 - 0 + 1 = 5`

Compare:

```
ans = min(5, 5) → 5
```

```
[2, 6, 1, 6, 9]
↑----------------↑
```

---

## i = 1

### j = 1 → `[6]` ❌

### j = 2 → `[6,1]` ❌

### j = 3 → `[6,1,6]` ❌

---

### j = 4

Subarray → `[6,1,6,9]`

min ✔ max ✔
Length = `4 - 1 + 1 = 4`

Compare:

```
ans = min(5, 4) → 4 ✔ updated
```

```
[6, 1, 6, 9]
↑------------↑
```

---

## i = 2

### j = 2 → `[1]` ❌

### j = 3 → `[1,6]` ❌

---

### j = 4

Subarray → `[1,6,9]`

min ✔ max ✔
Length = `4 - 2 + 1 = 3`

Compare:

```
ans = min(4, 3) → 3 ✔ updated
```

```
[1, 6, 9]
↑--------↑
```

---

## i = 3

### j = 3 → `[6]` ❌

### j = 4 → `[6,9]` ❌ (min missing)

---

## i = 4

### j = 4 → `[9]` ❌

---

### 🔚 END OF LOOPS

### 🔁 RETURN

```
return ans = 3
```

---

# 🟠 O(n²) DRY RUN (i → j)

---

## i = 0

```
hasMin = false
hasMax = false
```

### j = 0 → 2 ❌

### j = 1 → 6 ❌

### j = 2 → 1 ✔ min

### j = 3 → 6 ❌

### j = 4 → 9 ✔ max

✔ VALID
Length = `4 - 0 + 1 = 5`

Compare:

```
ans = min(5,5) → 5
```

---

## i = 1

```
hasMin = false
hasMax = false
```

### j = 2 → min ✔

### j = 4 → max ✔

Length = `4 - 1 + 1 = 4`

Compare:

```
ans = min(5,4) → 4 ✔
```

---

## i = 2

### j = 2 → min ✔

### j = 4 → max ✔

Length = `4 - 2 + 1 = 3`

Compare:

```
ans = min(4,3) → 3 ✔
```

---

Remaining `i` → no better window

---

### 🔚 RETURN

```
return ans = 3
```

---

# 🟢 O(n) DRY RUN (Carry Forward)

---

```
lastMin = -1
lastMax = -1
ans = 5
```

---

### i = 0 → 2 ❌

No update

---

### i = 1 → 6 ❌

No update

---

### i = 2 → 1 ✔

```
lastMin = 2
lastMax = -1
(no comparison)
```

---

### i = 3 → 6 ❌

No update

---

### i = 4 → 9 ✔

```
lastMax = 4
length = |4 - 2| + 1 = 3
ans = min(5,3) → 3 ✔
```

```
[1, 6, 9]
↑        ↑
```

---

### 🔚 END LOOP

### 🔁 RETURN

```
return ans = 3
```

---

# ✅ FINAL RESULT FOR ALL

```
3
```

---

If you want next:
✔ same style for **Prefix Sum**
✔ same for **Sliding Window**
✔ same for **Kadane**
✔ same for **Linked List**

Just say the word 👌


## ----- Q-2: Special Index ---
Problem Description

Given an array, arr[] of size N, the task is to find the count of array indices such that removing an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.



Problem Constraints
````
1 <= N <= 105
-105 <= A[i] <= 105
Sum of all elements of A <= 109
````
Input Format

First argument contains an array A of integers of size N


Output Format

Return the count of array indices such that removing an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.


Example Input

Input 1:
```
A = [2, 1, 6, 4]
```
Input 2:
```
A = [1, 1, 1]
```


Example Output

Output 1:
```
1
```
Output 2:
```
3
```
ans: 
```
public class Solution {
    public int solve(int[] A) {
        int n = A.length;

        int[] evenPrefix = new int[n];
        int[] oddPrefix = new int[n];

        // Build prefix sums
        evenPrefix[0] = A[0];
        oddPrefix[0] = 0;

        for (int i = 1; i < n; i++) {
            evenPrefix[i] = evenPrefix[i - 1];
            oddPrefix[i] = oddPrefix[i - 1];

            if (i % 2 == 0) {
                evenPrefix[i] += A[i];
            } else {
                oddPrefix[i] += A[i];
            }
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            int evenSum, oddSum;

            if (i == 0) {
                evenSum = oddPrefix[n - 1] - oddPrefix[0];
                oddSum = evenPrefix[n - 1] - evenPrefix[0];
            } else {
                evenSum = evenPrefix[i - 1] + (oddPrefix[n - 1] - oddPrefix[i]);
                oddSum = oddPrefix[i - 1] + (evenPrefix[n - 1] - evenPrefix[i]);
            }

            if (evenSum == oddSum) {
                count++;
            }
        }

        return count;
    }
}
```
# --- have to do dry diagram for it ---

## Q-3: Even numbers in a range ####
Problem Description

You are given an array A of length N and Q queries given by the 2D array B of size Q×2.

Each query consists of two integers B[i][0] and B[i][1].

For every query, your task is to find the count of even numbers in the range from A[B[i][0]] to A[B[i][1]].



Problem Constraints
```
1 <= N <= 105
1 <= Q <= 105
1 <= A[i] <= 109
0 <= B[i][0] <= B[i][1] < N
```
Input Format

First argument A is an array of integers.
Second argument B is a 2D array of integers.


Output Format

Return an array of integers.
Example Input

Input 1:
```
A = [1, 2, 3, 4, 5]
B = [   [0, 2] 
        [2, 4]
        [1, 4]   ]
```
Input 2:
```
A = [2, 1, 8, 3, 9, 6]
B = [   [0, 3]
        [3, 5]
        [1, 3] 
        [2, 4]   ]
```
Example Output

Output 1:
```
[1, 1, 2]
```
Output 2:
```
[2, 1, 1, 1]
```
ans: 
```
public class Solution {
    public int[] solve(int[] A, int[][] B) {
        int lengthA = A.length;
        int lengthB = B.length;
        // first find the prefix-sum based on condition
            int[] prefix = new int[lengthA];
            if(A[0]% 2 ==0){
                prefix[0] = 1;
            }else{
                prefix[0] = 0;
            }
            for(int i = 1; i < lengthA; i++){
                if( A[i] % 2 == 0){
                    prefix[i] = prefix[ i - 1] + 1;
                }else{
                    prefix[i] = prefix[i-1];
                }
            }
        // for B quesy
        int[] result = new int[lengthB];
        for(int i = 0; i < lengthB; i++){
            int l = B[i][0];
            int r = B[i][1];
            if(l == 0){
                result[i] = prefix[r];
            }else{
                result[i] = prefix[r] - prefix[l-1];
            }
        }
        return result;
    }

}
```
## -- have to do dry diagram ---

## Q-4:  Total Number of Subarrays ## 
![alt text](image.png)
## Q-5: Sum of Odd indexed elements in a range ##

Problem Description

You are given:
An integer array A representing the array of numbers of size N.
A 2D array B of size Q, where each row B[i] contains two integers B[i][0] and B[i][1], representing the range [L, R].

For each query in B, calculate the sum of elements in A at odd indices within the specified range [L, R] and return the results as an array.


Problem Constraints
```
1 <= N <= 10^5
-10^5 <= A[i] <= 10^5
1 <= Q <= 10^5
0 <= B[i][0], B[i][1] < N
B[i][0] <= B[i][1].
```
Input Format

First Argument A, is a list of integers representing the array.
Second Argument B, is a 2D list where each sublist B[i]=[L,R] contains two integers L and R, representing the range for the query.


Output Format

Return a list of integers where each integer is the result of the sum of elements at odd indices in the range [L, R] for each query.

Example Input
Input 1:
```
A = [2, 8, 3, 9, 15]
B = [ [1, 4], 
      [0, 2], 
      [2, 3] ]
```
Input 2:
```
A = [5, 15, 25, 35, 45]
B = [ [2, 2], 
      [2, 4] ]
```
Example Output

Output 1:
```
[17, 8, 9]
```
Output 2:
```
[0, 35]
```

ans: 
```
public class Solution {
    public int[] sumOfOddIndexedElements(int[] A, int[][] B) {

        int length = A.length;
        int lengthB = B.length;
        // step-1: build prefix of odd index 
            int[] prefixOdd = new int[length];
            prefixOdd[0] = 0;
            for(int i = 1; i < length; i++){
                if(i % 2 == 0){
                    prefixOdd[i] = prefixOdd[i-1];
                }else{
                    prefixOdd[i] = prefixOdd[i-1] + A[i];
                }
            }
        // step-2: define the left-element and right-side-element 
         int[] result = new int[lengthB];
        for(int i = 0; i <lengthB; i++){
            int L = B[i][0];
            int R = B[i][1];
             if (L == 0) {
                result[i] = prefixOdd[R];
            } else {
                result[i] = prefixOdd[R] - prefixOdd[L - 1];
            }

        }
        return result;
       
    }

    
}
```
## -- have to do dry daigram --

