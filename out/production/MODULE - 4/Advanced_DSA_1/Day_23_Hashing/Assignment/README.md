## --Q-1: Check Pair Sum --
Problem Description

```declarative
Given an Array of integers B, and a target sum A.
Check if there exists a pair (i,j) such that Bi + Bj = A and i!=j.

```
Problem Constraints

```declarative
1 <= Length of array B <= 105
0 <= Bi <= 109
0 <= A <= 109
```

Input Format

```declarative
First argument A is the Target sum, and second argument is the array B

```

Output Format
```declarative

Return an integer value 1 if there exists such pair, else return 0.

```

Example Input

Input 1:

```declarative
A = 8   
B = [3, 5, 1, 2, 1, 2]
```
Input 2:
```declarative
A = 21   
B = [9, 10, 7, 10, 9, 1, 5, 1, 5]
```

Example Output

Output 1:

```declarative
1
```
Output 2:
```declarative
0
```
solution:
```java
public class Solution {
    public int solve(int K, int[] arr) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {
            int target = K - num;

            if (set.contains(target)) {
                return 1;
            }

            set.add(num);
        }

        return 0;
    }
}

```

## --- Q-2: Count distinct elements -----
Problem Description
```declarative
Given an array A of N integers, return the number of unique elements in the array.
```

Problem Constraints

```declarative
1 <= N <= 105
1 <= A[i] <= 109
```

Input Format
```declarative
First argument A is an array of integers.
```

Output Format

```declarative
Return an integer.
```

Example Input

Input 1:
```declarative
A = [3, 4, 3, 6, 6]
```
Input 2:
```declarative
A = [3, 3, 3, 9, 0, 1, 0]
```

Example Output

Output 1:
```declarative
3
```
Output 2:
```declarative
4
```
solution:
```java
public class Solution {
    public int solve(int[] A) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : A) {
            set.add(num);
        }

        return set.size();
    }
}

```

## --- Q-3: Count Pair Sum -----
Problem Description
```declarative

You are given an array A of N integers and an integer B. Count the number of pairs (i,j) such that A[i] + A[j] = B and i ≠ j.

Since the answer can be very large, return the remainder after dividing the count with 109+7.

Note - The pair (i,j) is same as the pair (j,i) and we need to count it only once.

```

Problem Constraints

```declarative
1 <= N <= 105
1 <= A[i] <= 109
1 <= B <= 109
```

Input Format
```declarative
First argument A is an array of integers and second argument B is an integer.
```

Output Format
```declarative
Return an integer.
```

Example Input

Input 1:
```declarative
A = [3, 5, 1, 2]
B = 8
```
Input 2:
```declarative
A = [1, 2, 1, 2]
B = 3
```

Example Output

Output 1:

```declarative
1
```
Output 2:
```declarative
4
```

solution:

```java
import java.util.HashMap;

public class Solution {
    public int solve(int[] A, int B) {

        HashMap<Integer, Integer> map = new HashMap<>();
        long count = 0;   // IMPORTANT change

        for (int num : A) {

            int target = B - num;

            if (map.containsKey(target)) {
                count += map.get(target);
            }

            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        return (int) count; // safe cast as per problem
    }
}

```
```declarative
 TestCase - Hard Failed
```
so soluation is :
```java
public class Solution {
    public int solve(int[] A, int B) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int num: A){
            int k = B - num;
            if (map.containsKey(k)) count += map.get(k);
            if (map.containsKey(num)) map.put(num, map.get(num) + 1);
            else map.put(num, 1);
        }
        return count % 1000000007 ;
    }
}
```

## --- Q-4: Frequency of element query -----
Problem Description
```declarative
SCALER organizes a series of contests aimed at helping learners enhance their coding skills. Each learner can participate in multiple contests, and their participation is represented by integers in an array. The goal is to identify how frequently each learner has participated in these contests. This information will help SCALER determine which learners are participating the least, allowing them to provide targeted support and encouragement.
Given an array A that represents the participants of various contests, where each integer corresponds to a specific learner, and an array B containing the learners for whom you want to check participation frequency, your task is to find the frequency of each learner from array B in the array A and return a list containing all these frequencies

```

Problem Constraints

```declarative
1 <= |A| <= 105
1 <= |B| <= 105
1 <= A[i] <= 105
1 <= B[i] <= 105
```
Input Format
```declarative

First argument A is an array of integers.
Second argument B is an array of integers denoting the queries.

```

Output Format
```declarative
Return an array of integers containing the frequency of each learner in B as found in array A.
```

Example Input

Input 1:
```declarative
A = [1, 2, 1, 1]
B = [1, 2]
```
Input 2:
```declarative
A = [2, 5, 9, 2, 8]
B = [3, 2]
```


Example Output

Output 1:
```declarative
[3, 1]
```
Output 2:
```declarative
[0, 2]
```

solution:

```java
public class Solution {
    public int[] solve(int[] A, int[] B) {
       HashMap<Integer, Integer> freqMap = new HashMap<>();

        // Step 1: Build frequency map
        for (int num : A) {
            if (freqMap.containsKey(num)) {
                freqMap.put(num, freqMap.get(num) + 1);
            } else {
                freqMap.put(num, 1);
            }
        }

        // Step 2: Answer queries
        int[] result = new int[B.length];
        for (int i = 0; i < B.length; i++) {
            if (freqMap.containsKey(B[i])) {
                result[i] = freqMap.get(B[i]);
            } else {
                result[i] = 0;
            }
        }

        return result;
    }
        
}

```

