## ========== Q-1: nearest smaller element on the left  side =========

I'll explain the **Nearest Smaller Element on Left Side** problem from brute force to optimized approach with complete explanation.

## Problem Statement
Given an array of integers, find the nearest smaller element for each element on its left side. If no smaller element exists, return -1.

**Example:**
```
Input:  [4, 10, 5, 8, 3, 12, 7]
Output: [-1, 4, 4, 5, -1, 3, 3]
```

## Approach 1: Brute Force

### Algorithm
For each element, traverse all elements to its left and find the nearest smaller element.

### Pseudocode
```
function nearestSmallerLeft(arr, n):
    result = new array of size n
    
    for i = 0 to n-1:
        result[i] = -1  // Initialize with -1
        
        // Check all elements to the left
        for j = i-1 down to 0:
            if arr[j] < arr[i]:
                result[i] = arr[j]
                break  // Found nearest smaller
        
    return result
```

### Java Code
```java
public class Solution {
    public static int[] nearestSmallerLeft(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        
        for (int i = 0; i < n; i++) {
            result[i] = -1; // Default if no smaller element found
            
            // Check all elements to the left
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    result[i] = arr[j];
                    break; // Found the nearest smaller
                }
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] arr = {4, 10, 5, 8, 3, 12, 7};
        int[] result = nearestSmallerLeft(arr);
        
        System.out.println("Input: " + Arrays.toString(arr));
        System.out.println("Output: " + Arrays.toString(result));
    }
}
```

### Dry Run with Brute Force
```
Array: [4, 10, 5, 8, 3, 12, 7]

i=0, arr[0]=4: No left elements → result[0] = -1
i=1, arr[1]=10: Check left: 4<10 → result[1] = 4
i=2, arr[2]=5: Check left: 10>5, 4<5 → result[2] = 4
i=3, arr[3]=8: Check left: 5<8 → result[3] = 5
i=4, arr[4]=3: Check left: 8>3,5>3,10>3,4>3 → result[4] = -1
i=5, arr[5]=12: Check left: 3<12 → result[5] = 3
i=6, arr[6]=7: Check left: 12>7,3<7 → result[6] = 3

Result: [-1, 4, 4, 5, -1, 3, 3]
```

**Time Complexity:** O(n²)
**Space Complexity:** O(1) (excluding output array)

## Approach 2: Optimized using Stack

### Algorithm
1. Create an empty stack
2. Traverse the array from left to right
3. For each element:
    - Pop elements from stack that are greater than or equal to current element
    - If stack becomes empty, no smaller element exists (result = -1)
    - If stack has elements, top is the nearest smaller element
    - Push current element to stack

### Why Stack Works?
The stack maintains elements in increasing order from bottom to top. When we find a smaller element, all larger elements in stack become irrelevant for future elements.

### Pseudocode
```
function nearestSmallerLeftOptimized(arr, n):
    result = new array of size n
    stack = empty stack
    
    for i = 0 to n-1:
        // Remove elements greater than or equal to current
        while stack is not empty and stack.top() >= arr[i]:
            stack.pop()
        
        // If stack is empty, no smaller element
        if stack is empty:
            result[i] = -1
        else:
            result[i] = stack.top()
        
        // Push current element for future elements
        stack.push(arr[i])
    
    return result
```

### Java Code
```java
import java.util.*;

public class Solution {
    public static int[] nearestSmallerLeftOptimized(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            // Remove elements that are greater than or equal to current
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            
            // If stack is empty, no smaller element on left
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                // Top of stack is the nearest smaller element
                result[i] = stack.peek();
            }
            
            // Push current element for future elements
            stack.push(arr[i]);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] arr = {4, 10, 5, 8, 3, 12, 7};
        int[] result = nearestSmallerLeftOptimized(arr);
        
        System.out.println("Input: " + Arrays.toString(arr));
        System.out.println("Output: " + Arrays.toString(result));
    }
}
```

### Detailed Dry Run with Stack

```
Array: [4, 10, 5, 8, 3, 12, 7]
Stack: [] (empty initially)

i=0, arr[0]=4:
  Stack empty → result[0] = -1
  Push 4 → Stack: [4]

i=1, arr[1]=10:
  while(4 >= 10?) false
  Stack not empty → result[1] = 4 (top)
  Push 10 → Stack: [4, 10]

i=2, arr[2]=5:
  while(10 >= 5?) true → pop 10 → Stack: [4]
  while(4 >= 5?) false
  Stack not empty → result[2] = 4 (top)
  Push 5 → Stack: [4, 5]

i=3, arr[3]=8:
  while(5 >= 8?) false
  Stack not empty → result[3] = 5 (top)
  Push 8 → Stack: [4, 5, 8]

i=4, arr[4]=3:
  while(8 >= 3?) true → pop 8 → Stack: [4, 5]
  while(5 >= 3?) true → pop 5 → Stack: [4]
  while(4 >= 3?) true → pop 4 → Stack: []
  Stack empty → result[4] = -1
  Push 3 → Stack: [3]

i=5, arr[5]=12:
  while(3 >= 12?) false
  Stack not empty → result[5] = 3 (top)
  Push 12 → Stack: [3, 12]

i=6, arr[6]=7:
  while(12 >= 7?) true → pop 12 → Stack: [3]
  while(3 >= 7?) false
  Stack not empty → result[6] = 3 (top)
  Push 7 → Stack: [3, 7]

Result: [-1, 4, 4, 5, -1, 3, 3]
```

### Stack State Visualization
```
Step    Element    Stack (bottom→top)    Result
0       4          [4]                    -1
1       10         [4,10]                  4
2       5          [4,5]                   4
3       8          [4,5,8]                 5
4       3          [3]                     -1
5       12         [3,12]                  3
6       7          [3,7]                   3
```

## Complexity Analysis

### Brute Force
- **Time:** O(n²) - For each element, we might traverse up to n elements
- **Space:** O(1) - Only using result array

### Optimized Stack Approach
- **Time:** O(n) - Each element pushed and popped at most once
- **Space:** O(n) - Stack might store up to n elements in worst case

## Key Insights

1. **Stack Property:** The stack always maintains elements in increasing order from bottom to top
2. **Element Removal:** When we find a smaller element, all larger elements become useless
3. **Nearest Property:** The top of stack always gives the nearest smaller element
4. **Monotonic Stack:** This is a classic example of monotonic stack (strictly increasing)

## Applications
- Stock span problem
- Largest rectangle in histogram
- Next greater element
- Trapping rain water
- Expression evaluation

## Edge Cases to Consider
```java
// Empty array
int[] arr1 = {};  // Output: []

// Single element
int[] arr2 = {5};  // Output: [-1]

// Decreasing array
int[] arr3 = {5,4,3,2,1};  // Output: [-1,4,3,2,1]?

// Increasing array
int[] arr4 = {1,2,3,4,5};  // Output: [-1,1,2,3,4]

// Array with duplicates
int[] arr5 = {3,3,3,3};  // Output: [-1,-1,-1,-1]
```

The optimized stack solution is efficient and widely used in coding interviews for similar "nearest smaller/greater element" problems.


## ==== Q-2: nearest smaller element on the right side =========
I'll explain the **Nearest Smaller Element on Right Side** problem with complete analysis from brute force to optimized approach.

## Problem Statement
Given an array of integers, find the nearest smaller element for each element on its right side. If no smaller element exists, return -1.

**Example:**
```
Input:  [4, 10, 5, 8, 3, 12, 7]
Output: [3, 5, 3, 3, -1, 7, -1]
```

## Approach 1: Brute Force

### Algorithm
For each element, traverse all elements to its right and find the nearest smaller element.

### Pseudocode
```
function nearestSmallerRight(arr, n):
    result = new array of size n
    
    for i = 0 to n-1:
        result[i] = -1  // Initialize with -1
        
        // Check all elements to the right
        for j = i+1 to n-1:
            if arr[j] < arr[i]:
                result[i] = arr[j]
                break  // Found nearest smaller
        
    return result
```

### Java Code
```java
import java.util.Arrays;

public class Solution {
    public static int[] nearestSmallerRight(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        
        for (int i = 0; i < n; i++) {
            result[i] = -1; // Default if no smaller element found
            
            // Check all elements to the right
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[i]) {
                    result[i] = arr[j];
                    break; // Found the nearest smaller
                }
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] arr = {4, 10, 5, 8, 3, 12, 7};
        int[] result = nearestSmallerRight(arr);
        
        System.out.println("Input: " + Arrays.toString(arr));
        System.out.println("Output: " + Arrays.toString(result));
    }
}
```

### Dry Run with Brute Force
```
Array: [4, 10, 5, 8, 3, 12, 7]

i=0, arr[0]=4: Check right: 10>4,5>4,8>4,3<4 → result[0] = 3
i=1, arr[1]=10: Check right: 5<10 → result[1] = 5
i=2, arr[2]=5: Check right: 8>5,3<5 → result[2] = 3
i=3, arr[3]=8: Check right: 3<8 → result[3] = 3
i=4, arr[4]=3: Check right: 12>3,7>3 → result[4] = -1
i=5, arr[5]=12: Check right: 7<12 → result[5] = 7
i=6, arr[6]=7: No right elements → result[6] = -1

Result: [3, 5, 3, 3, -1, 7, -1]
```

**Time Complexity:** O(n²)
**Space Complexity:** O(1) (excluding output array)

## Approach 2: Optimized using Stack

### Algorithm
1. Create an empty stack
2. Traverse the array from **right to left** (opposite to left side problem)
3. For each element:
    - Pop elements from stack that are greater than or equal to current element
    - If stack becomes empty, no smaller element exists (result = -1)
    - If stack has elements, top is the nearest smaller element on right
    - Push current element to stack

### Why Traverse from Right?
Since we need elements from the right side, traversing from right to left ensures we've already processed the right elements and have them in the stack.

### Pseudocode
```
function nearestSmallerRightOptimized(arr, n):
    result = new array of size n
    stack = empty stack
    
    for i = n-1 down to 0:
        // Remove elements greater than or equal to current
        while stack is not empty and stack.top() >= arr[i]:
            stack.pop()
        
        // If stack is empty, no smaller element
        if stack is empty:
            result[i] = -1
        else:
            result[i] = stack.top()
        
        // Push current element for future elements
        stack.push(arr[i])
    
    return result
```

### Java Code
```java
import java.util.*;

public class Solution {
    public static int[] nearestSmallerRightOptimized(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Remove elements that are greater than or equal to current
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            
            // If stack is empty, no smaller element on right
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                // Top of stack is the nearest smaller element on right
                result[i] = stack.peek();
            }
            
            // Push current element for future elements (to the left)
            stack.push(arr[i]);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] arr = {4, 10, 5, 8, 3, 12, 7};
        int[] result = nearestSmallerRightOptimized(arr);
        
        System.out.println("Input: " + Arrays.toString(arr));
        System.out.println("Output: " + Arrays.toString(result));
    }
}
```

### Detailed Dry Run with Stack

```
Array: [4, 10, 5, 8, 3, 12, 7]
Stack: [] (empty initially)

i=6, arr[6]=7 (last element):
  Stack empty → result[6] = -1
  Push 7 → Stack: [7]

i=5, arr[5]=12:
  while(7 >= 12?) false
  Stack not empty → result[5] = 7 (top)
  Push 12 → Stack: [7, 12]

i=4, arr[4]=3:
  while(12 >= 3?) true → pop 12 → Stack: [7]
  while(7 >= 3?) true → pop 7 → Stack: []
  Stack empty → result[4] = -1
  Push 3 → Stack: [3]

i=3, arr[3]=8:
  while(3 >= 8?) false
  Stack not empty → result[3] = 3 (top)
  Push 8 → Stack: [3, 8]

i=2, arr[2]=5:
  while(8 >= 5?) true → pop 8 → Stack: [3]
  while(3 >= 5?) false
  Stack not empty → result[2] = 3 (top)
  Push 5 → Stack: [3, 5]

i=1, arr[1]=10:
  while(5 >= 10?) false
  while(3 >= 10?) false
  Stack not empty → result[1] = 3 (top) [Actually, we need to check top properly]
  Wait! Stack top is 5, not 3. Let's trace carefully:

At i=1, Stack = [3, 5] (bottom→top: 3,5)
Top element = 5
while(5 >= 10?) false
So result[1] = 5 (top)
Push 10 → Stack: [3, 5, 10]

i=0, arr[0]=4:
  while(10 >= 4?) true → pop 10 → Stack: [3, 5]
  while(5 >= 4?) true → pop 5 → Stack: [3]
  while(3 >= 4?) false
  Stack not empty → result[0] = 3 (top)
  Push 4 → Stack: [3, 4]

Result: [3, 5, 3, 3, -1, 7, -1]
```

### Corrected Stack State Visualization
```
Step    i    Element    Stack (bottom→top)    Result    Explanation
6       6    7          [7]                    -1       Empty stack → -1
5       5    12         [7,12]                  7       7 < 12
4       4    3          [3]                     -1       Pop all (7,12) → empty
3       3    8          [3,8]                    3       3 < 8
2       2    5          [3,5]                    3       3 < 5 (pop 8)
1       1    10         [3,5,10]                 5       5 < 10
0       0    4          [3,4]                    3       3 < 4 (pop 10,5)
```

## Key Differences from Left Side Problem

| Aspect | Left Side | Right Side |
|--------|-----------|------------|
| Traversal | Left to Right | Right to Left |
| Stack contains | Elements from left | Elements from right |
| Result for last element | Can have value | Always -1 |
| Result for first element | Always -1 | Can have value |

## Complete Java Program with Both Versions

```java
import java.util.*;

public class NearestSmallerElement {
    
    // Brute Force - Right Side
    public static int[] nearestSmallerRightBruteForce(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        
        for (int i = 0; i < n; i++) {
            result[i] = -1;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[i]) {
                    result[i] = arr[j];
                    break;
                }
            }
        }
        return result;
    }
    
    // Optimized Stack - Right Side
    public static int[] nearestSmallerRightOptimized(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = n - 1; i >= 0; i--) {
            // Pop larger or equal elements
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            
            // Set result
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            
            // Push current element
            stack.push(arr[i]);
        }
        
        return result;
    }
    
    // Utility method to print array and results
    public static void printResult(int[] arr, int[] result, String approach) {
        System.out.println("\n" + approach + ":");
        System.out.println("Array:   " + Arrays.toString(arr));
        System.out.println("Smaller Right: " + Arrays.toString(result));
        
        // Print explanation
        System.out.println("Explanation:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println("  " + arr[i] + " → " + result[i]);
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {4, 10, 5, 8, 3, 12, 7};
        
        // Test both approaches
        int[] result1 = nearestSmallerRightBruteForce(arr);
        int[] result2 = nearestSmallerRightOptimized(arr);
        
        printResult(arr, result1, "Brute Force Approach");
        printResult(arr, result2, "Optimized Stack Approach");
        
        // Verify both approaches give same result
        System.out.println("\nBoth approaches match: " + 
                          Arrays.equals(result1, result2));
        
        // Test with different arrays
        System.out.println("\n=== Additional Test Cases ===");
        
        int[][] testArrays = {
            {1, 2, 3, 4, 5},        // Increasing
            {5, 4, 3, 2, 1},        // Decreasing
            {3, 3, 3, 3},            // All equal
            {1},                      // Single element
            {4, 3, 2, 1, 5, 6, 7}    // Mixed
        };
        
        for (int[] testArr : testArrays) {
            int[] testResult = nearestSmallerRightOptimized(testArr);
            System.out.println("\n" + Arrays.toString(testArr));
            System.out.println("→ " + Arrays.toString(testResult));
        }
    }
}
```

## Complexity Analysis

### Brute Force
- **Time:** O(n²) - Nested loops
- **Space:** O(1) - Only result array

### Optimized Stack
- **Time:** O(n) - Each element pushed/popped once
- **Space:** O(n) - Stack in worst case

## Important Observations

1. **Stack Property:** Stack maintains increasing order from bottom to top
2. **Right to Left Traversal:** Critical for getting right-side elements
3. **Element Removal:** Pop while top >= current (for strictly smaller)
4. **Nearest Property:** Top always gives nearest smaller on right

## Common Variations

### 1. Next Smaller Element (Index based)
```java
public static int[] nextSmallerIndex(int[] arr) {
    int n = arr.length;
    int[] result = new int[n];
    Stack<Integer> stack = new Stack<>();
    
    for (int i = n - 1; i >= 0; i--) {
        while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
            stack.pop();
        }
        result[i] = stack.isEmpty() ? -1 : stack.peek();
        stack.push(i);
    }
    return result;
}
```

### 2. Strictly Smaller vs Smaller or Equal
- For **strictly smaller**: `while (!stack.isEmpty() && stack.peek() >= arr[i])`
- For **smaller or equal**: `while (!stack.isEmpty() && stack.peek() > arr[i])`

### 3. Circular Array
```java
public static int[] nextSmallerCircular(int[] arr) {
    int n = arr.length;
    int[] result = new int[n];
    Stack<Integer> stack = new Stack<>();
    
    // Traverse twice for circular behavior
    for (int i = 2 * n - 1; i >= 0; i--) {
        while (!stack.isEmpty() && stack.peek() >= arr[i % n]) {
            stack.pop();
        }
        if (i < n) {
            result[i] = stack.isEmpty() ? -1 : stack.peek();
        }
        stack.push(arr[i % n]);
    }
    return result;
}
```

## Real-world Applications

1. **Stock Market Analysis**: Find next lower price
2. **Temperature Analysis**: Find next cooler day
3. **Expression Evaluation**: In parsing expressions
4. **Histogram Problems**: Largest rectangle in histogram
5. **Game Development**: Finding next obstacle

The stack-based solution is elegant and efficient, making it a favorite in coding interviews for problems involving "next smaller/greater element" patterns.

## ======== nearest greater element on the left  side =========
I'll explain the **Nearest Greater Element on Left Side** problem with complete analysis from brute force to optimized approach.

## Problem Statement
Given an array of integers, find the nearest greater element for each element on its left side. If no greater element exists, return -1.

**Example:**
```
Input:  [4, 10, 5, 8, 3, 12, 7]
Output: [-1, -1, 10, 10, 8, -1, 12]
```

## Approach 1: Brute Force

### Algorithm
For each element, traverse all elements to its left and find the nearest greater element.

### Pseudocode
```
function nearestGreaterLeft(arr, n):
    result = new array of size n
    
    for i = 0 to n-1:
        result[i] = -1  // Initialize with -1
        
        // Check all elements to the left
        for j = i-1 down to 0:
            if arr[j] > arr[i]:
                result[i] = arr[j]
                break  // Found nearest greater
        
    return result
```

### Java Code
```java
import java.util.Arrays;

public class Solution {
    public static int[] nearestGreaterLeft(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        
        for (int i = 0; i < n; i++) {
            result[i] = -1; // Default if no greater element found
            
            // Check all elements to the left
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[i]) {
                    result[i] = arr[j];
                    break; // Found the nearest greater
                }
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] arr = {4, 10, 5, 8, 3, 12, 7};
        int[] result = nearestGreaterLeft(arr);
        
        System.out.println("Input: " + Arrays.toString(arr));
        System.out.println("Output: " + Arrays.toString(result));
    }
}
```

### Dry Run with Brute Force
```
Array: [4, 10, 5, 8, 3, 12, 7]

i=0, arr[0]=4: No left elements → result[0] = -1
i=1, arr[1]=10: Check left: 4>10? No → result[1] = -1
i=2, arr[2]=5: Check left: 10>5? Yes → result[2] = 10
i=3, arr[3]=8: Check left: 5>8? No, 10>8? Yes → result[3] = 10
i=4, arr[4]=3: Check left: 8>3? Yes → result[4] = 8
i=5, arr[5]=12: Check left: 3>12? No, 8>12? No, 5>12? No, 10>12? No, 4>12? No → result[5] = -1
i=6, arr[6]=7: Check left: 12>7? Yes → result[6] = 12

Result: [-1, -1, 10, 10, 8, -1, 12]
```

**Time Complexity:** O(n²)
**Space Complexity:** O(1) (excluding output array)

## Approach 2: Optimized using Stack

### Algorithm
1. Create an empty stack
2. Traverse the array from left to right
3. For each element:
    - Pop elements from stack that are **less than or equal to** current element (since we need greater elements)
    - If stack becomes empty, no greater element exists (result = -1)
    - If stack has elements, top is the nearest greater element on left
    - Push current element to stack

### Why This Works?
The stack maintains elements in decreasing order from bottom to top. When we find a greater element, all smaller elements in stack become irrelevant for future elements.

### Pseudocode
```
function nearestGreaterLeftOptimized(arr, n):
    result = new array of size n
    stack = empty stack
    
    for i = 0 to n-1:
        // Remove elements less than or equal to current
        while stack is not empty and stack.top() <= arr[i]:
            stack.pop()
        
        // If stack is empty, no greater element
        if stack is empty:
            result[i] = -1
        else:
            result[i] = stack.top()
        
        // Push current element for future elements
        stack.push(arr[i])
    
    return result
```

### Java Code
```java
import java.util.*;

public class Solution {
    public static int[] nearestGreaterLeftOptimized(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            // Remove elements that are less than or equal to current
            // Because they can never be the nearest greater for future elements
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            
            // If stack is empty, no greater element on left
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                // Top of stack is the nearest greater element
                result[i] = stack.peek();
            }
            
            // Push current element for future elements
            stack.push(arr[i]);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] arr = {4, 10, 5, 8, 3, 12, 7};
        int[] result = nearestGreaterLeftOptimized(arr);
        
        System.out.println("Input: " + Arrays.toString(arr));
        System.out.println("Output: " + Arrays.toString(result));
    }
}
```

### Detailed Dry Run with Stack

```
Array: [4, 10, 5, 8, 3, 12, 7]
Stack: [] (empty initially)

i=0, arr[0]=4:
  Stack empty → result[0] = -1
  Push 4 → Stack: [4]

i=1, arr[1]=10:
  while(4 <= 10?) true → pop 4 → Stack: []
  Stack empty → result[1] = -1
  Push 10 → Stack: [10]

i=2, arr[2]=5:
  while(10 <= 5?) false
  Stack not empty → result[2] = 10 (top)
  Push 5 → Stack: [10, 5]

i=3, arr[3]=8:
  while(5 <= 8?) true → pop 5 → Stack: [10]
  while(10 <= 8?) false
  Stack not empty → result[3] = 10 (top)
  Push 8 → Stack: [10, 8]

i=4, arr[4]=3:
  while(8 <= 3?) false
  while(10 <= 3?) false
  Stack not empty → result[4] = 8? Wait, top is 8
  Actually, check carefully:
  Stack = [10, 8], top = 8
  while(8 <= 3?) false
  So result[4] = 8
  Push 3 → Stack: [10, 8, 3]

i=5, arr[5]=12:
  while(3 <= 12?) true → pop 3 → Stack: [10, 8]
  while(8 <= 12?) true → pop 8 → Stack: [10]
  while(10 <= 12?) true → pop 10 → Stack: []
  Stack empty → result[5] = -1
  Push 12 → Stack: [12]

i=6, arr[6]=7:
  while(12 <= 7?) false
  Stack not empty → result[6] = 12 (top)
  Push 7 → Stack: [12, 7]

Result: [-1, -1, 10, 10, 8, -1, 12]
```

### Stack State Visualization
```
Step    i    Element    Stack (bottom→top)    Result    Action
0       0    4          [4]                    -1       Push 4
1       1    10         [10]                   -1       Pop 4, push 10
2       2    5          [10,5]                 10       Push 5
3       3    8          [10,8]                 10       Pop 5, push 8
4       4    3          [10,8,3]               8        Push 3
5       5    12         [12]                   -1       Pop all, push 12
6       6    7          [12,7]                 12       Push 7
```

## Complete Java Program with Both Versions

```java
import java.util.*;

public class NearestGreaterElement {
    
    // Brute Force - Left Side
    public static int[] nearestGreaterLeftBruteForce(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        
        for (int i = 0; i < n; i++) {
            result[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[i]) {
                    result[i] = arr[j];
                    break;
                }
            }
        }
        return result;
    }
    
    // Optimized Stack - Left Side
    public static int[] nearestGreaterLeftOptimized(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            // Pop smaller or equal elements (they are useless)
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            
            // Set result
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            
            // Push current element
            stack.push(arr[i]);
        }
        
        return result;
    }
    
    // Utility method to print result with explanation
    public static void printResult(int[] arr, int[] result, String approach) {
        System.out.println("\n" + approach + ":");
        System.out.println("Array:        " + Arrays.toString(arr));
        System.out.println("Greater Left: " + Arrays.toString(result));
        
        System.out.println("Explanation:");
        for (int i = 0; i < arr.length; i++) {
            String greaterInfo = result[i] == -1 ? "No greater element" : result[i] + " is greater";
            System.out.println("  " + arr[i] + " → " + result[i] + " (" + greaterInfo + ")");
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {4, 10, 5, 8, 3, 12, 7};
        
        // Test both approaches
        int[] result1 = nearestGreaterLeftBruteForce(arr);
        int[] result2 = nearestGreaterLeftOptimized(arr);
        
        printResult(arr, result1, "Brute Force Approach");
        printResult(arr, result2, "Optimized Stack Approach");
        
        // Verify both approaches give same result
        System.out.println("\nBoth approaches match: " + 
                          Arrays.equals(result1, result2));
        
        // Test with different arrays
        System.out.println("\n=== Additional Test Cases ===");
        
        int[][] testArrays = {
            {1, 2, 3, 4, 5},        // Increasing array
            {5, 4, 3, 2, 1},        // Decreasing array
            {3, 3, 3, 3},            // All equal
            {1},                      // Single element
            {4, 3, 2, 1, 5, 6, 7},    // Mixed
            {100, 80, 60, 70, 60, 75, 85} // Stock prices example
        };
        
        for (int[] testArr : testArrays) {
            int[] testResult = nearestGreaterLeftOptimized(testArr);
            System.out.println("\n" + Arrays.toString(testArr));
            System.out.println("→ " + Arrays.toString(testResult));
        }
    }
}
```

## Comparison: Left Side vs Right Side

| Aspect | Greater on Left | Greater on Right |
|--------|-----------------|------------------|
| **Traversal** | Left to Right | Right to Left |
| **Stack condition** | Pop while `stack.top() <= current` | Pop while `stack.top() <= current` |
| **Stack order** | Decreasing order | Decreasing order |
| **First element** | Always -1 | Depends on array |
| **Last element** | Depends on array | Always -1 |

## Complexity Analysis

### Brute Force
- **Time Complexity:** O(n²) - Nested loops
- **Space Complexity:** O(1) - Only result array

### Optimized Stack
- **Time Complexity:** O(n) - Each element pushed and popped at most once
- **Space Complexity:** O(n) - Stack in worst case

## Key Insights

1. **Stack Property:** Stack maintains decreasing order from bottom to top
2. **Element Removal:** Remove elements <= current (they block the view for future elements)
3. **Nearest Property:** Top of stack always gives nearest greater element
4. **Monotonic Stack:** This is a decreasing monotonic stack

## Common Variations

### 1. Previous Greater Element (Index based)
```java
public static int[] previousGreaterIndex(int[] arr) {
    int n = arr.length;
    int[] result = new int[n];
    Stack<Integer> stack = new Stack<>(); // Store indices
    
    for (int i = 0; i < n; i++) {
        while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
            stack.pop();
        }
        result[i] = stack.isEmpty() ? -1 : stack.peek();
        stack.push(i);
    }
    return result;
}
```

### 2. Strictly Greater vs Greater or Equal
```java
// For strictly greater (arr[j] > arr[i])
while (!stack.isEmpty() && stack.peek() <= arr[i]) {
    stack.pop();
}

// For greater or equal (arr[j] >= arr[i])
while (!stack.isEmpty() && stack.peek() < arr[i]) {
    stack.pop();
}
```

### 3. Circular Array
```java
public static int[] previousGreaterCircular(int[] arr) {
    int n = arr.length;
    int[] result = new int[n];
    Stack<Integer> stack = new Stack<>();
    
    // Traverse twice for circular behavior
    for (int i = 0; i < 2 * n; i++) {
        int current = arr[i % n];
        while (!stack.isEmpty() && stack.peek() <= current) {
            if (i < n) stack.pop(); // Only pop in first pass
            else break;
        }
        
        if (i < n) {
            result[i] = stack.isEmpty() ? -1 : stack.peek();
        }
        
        if (i < n) {
            stack.push(current);
        }
    }
    return result;
}
```

## Real-world Applications

1. **Stock Market Analysis**: Find previous higher price
2. **Temperature Analysis**: Find previous warmer day
3. **Building View**: Buildings that can see sunrise (from left)
4. **Expression Evaluation**: In parsing mathematical expressions
5. **Game Development**: Finding previous obstacle

## Edge Cases to Consider

```java
// Empty array
int[] arr1 = {};  // Output: []

// Single element
int[] arr2 = {5};  // Output: [-1]

// Decreasing array (strictly decreasing)
int[] arr3 = {5,4,3,2,1};  
// Output: [-1,5,4,3,2]
// Explanation: Each element sees previous element as greater

// Increasing array (strictly increasing)
int[] arr4 = {1,2,3,4,5};  
// Output: [-1,-1,-1,-1,-1]
// Explanation: No greater element on left for increasing sequence

// Array with duplicates
int[] arr5 = {3,3,3,3};  
// Output: [-1,-1,-1,-1] if using strictly greater
// Output: [-1,3,3,3] if using greater or equal

// Array with peaks and valleys
int[] arr6 = {1,5,3,4,2,6};  
// Output: [-1,-1,5,5,4,-1]
```

## Memory and Performance Tips

1. **Use ArrayDeque instead of Stack** for better performance:
```java
Deque<Integer> stack = new ArrayDeque<>();
// Use stack.push(), stack.pop(), stack.peek()
```

2. **For primitive arrays**, consider using custom stack implementation:
```java
class IntStack {
    int[] arr;
    int top;
    // Custom implementation for primitive ints
}
```

The stack-based solution is elegant and efficient, demonstrating the power of monotonic stacks in solving "nearest greater/smaller element" problems efficiently!

## ============ nearest greater element on the right side ==
I'll explain the **Nearest Greater Element on Right Side** problem with complete analysis from brute force to optimized approach. This is also commonly known as the "Next Greater Element" problem.

## Problem Statement
Given an array of integers, find the nearest greater element for each element on its right side. If no greater element exists, return -1.

**Example:**
```
Input:  [4, 10, 5, 8, 3, 12, 7]
Output: [10, 12, 8, 12, 12, -1, -1]
```

## Approach 1: Brute Force

### Algorithm
For each element, traverse all elements to its right and find the nearest greater element.

### Pseudocode
```
function nearestGreaterRight(arr, n):
    result = new array of size n
    
    for i = 0 to n-1:
        result[i] = -1  // Initialize with -1
        
        // Check all elements to the right
        for j = i+1 to n-1:
            if arr[j] > arr[i]:
                result[i] = arr[j]
                break  // Found nearest greater
        
    return result
```

### Java Code
```java
import java.util.Arrays;

public class Solution {
    public static int[] nearestGreaterRight(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        
        for (int i = 0; i < n; i++) {
            result[i] = -1; // Default if no greater element found
            
            // Check all elements to the right
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    result[i] = arr[j];
                    break; // Found the nearest greater
                }
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] arr = {4, 10, 5, 8, 3, 12, 7};
        int[] result = nearestGreaterRight(arr);
        
        System.out.println("Input: " + Arrays.toString(arr));
        System.out.println("Output: " + Arrays.toString(result));
    }
}
```

### Dry Run with Brute Force
```
Array: [4, 10, 5, 8, 3, 12, 7]

i=0, arr[0]=4: Check right: 10>4 → result[0] = 10
i=1, arr[1]=10: Check right: 5>10? No, 8>10? No, 3>10? No, 12>10 → result[1] = 12
i=2, arr[2]=5: Check right: 8>5 → result[2] = 8
i=3, arr[3]=8: Check right: 3>8? No, 12>8 → result[3] = 12
i=4, arr[4]=3: Check right: 12>3 → result[4] = 12
i=5, arr[5]=12: Check right: 7>12? No → result[5] = -1
i=6, arr[6]=7: No right elements → result[6] = -1

Result: [10, 12, 8, 12, 12, -1, -1]
```

**Time Complexity:** O(n²)
**Space Complexity:** O(1) (excluding output array)

## Approach 2: Optimized using Stack

### Algorithm
1. Create an empty stack
2. Traverse the array from **right to left** (to process right elements first)
3. For each element:
    - Pop elements from stack that are **less than or equal to** current element
    - If stack becomes empty, no greater element exists (result = -1)
    - If stack has elements, top is the nearest greater element on right
    - Push current element to stack

### Why Traverse from Right?
Since we need elements from the right side, traversing from right to left ensures we've already processed the right elements and have them in the stack. The stack maintains potential greater elements for elements to the left.

### Pseudocode
```
function nearestGreaterRightOptimized(arr, n):
    result = new array of size n
    stack = empty stack
    
    for i = n-1 down to 0:
        // Remove elements less than or equal to current
        while stack is not empty and stack.top() <= arr[i]:
            stack.pop()
        
        // If stack is empty, no greater element
        if stack is empty:
            result[i] = -1
        else:
            result[i] = stack.top()
        
        // Push current element for future elements
        stack.push(arr[i])
    
    return result
```

### Java Code
```java
import java.util.*;

public class Solution {
    public static int[] nearestGreaterRightOptimized(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Remove elements that are less than or equal to current
            // These can never be the next greater for elements to the left
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            
            // If stack is empty, no greater element on right
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                // Top of stack is the nearest greater element on right
                result[i] = stack.peek();
            }
            
            // Push current element for future elements (to the left)
            stack.push(arr[i]);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] arr = {4, 10, 5, 8, 3, 12, 7};
        int[] result = nearestGreaterRightOptimized(arr);
        
        System.out.println("Input: " + Arrays.toString(arr));
        System.out.println("Output: " + Arrays.toString(result));
    }
}
```

### Detailed Dry Run with Stack

```
Array: [4, 10, 5, 8, 3, 12, 7]
Stack: [] (empty initially)

i=6, arr[6]=7 (last element):
  Stack empty → result[6] = -1
  Push 7 → Stack: [7]

i=5, arr[5]=12:
  while(7 <= 12?) true → pop 7 → Stack: []
  Stack empty → result[5] = -1
  Push 12 → Stack: [12]

i=4, arr[4]=3:
  while(12 <= 3?) false
  Stack not empty → result[4] = 12 (top)
  Push 3 → Stack: [12, 3]

i=3, arr[3]=8:
  while(3 <= 8?) true → pop 3 → Stack: [12]
  while(12 <= 8?) false
  Stack not empty → result[3] = 12 (top)
  Push 8 → Stack: [12, 8]

i=2, arr[2]=5:
  while(8 <= 5?) false
  while(12 <= 5?) false
  Stack not empty → result[2] = 8 (top)
  Push 5 → Stack: [12, 8, 5]

i=1, arr[1]=10:
  while(5 <= 10?) true → pop 5 → Stack: [12, 8]
  while(8 <= 10?) true → pop 8 → Stack: [12]
  while(12 <= 10?) false
  Stack not empty → result[1] = 12 (top)
  Push 10 → Stack: [12, 10]

i=0, arr[0]=4:
  while(10 <= 4?) false
  while(12 <= 4?) false
  Stack not empty → result[0] = 10 (top)
  Push 4 → Stack: [12, 10, 4]

Result: [10, 12, 8, 12, 12, -1, -1]
```

### Stack State Visualization
```
Step    i    Element    Stack (bottom→top)    Result    Action
6       6    7          [7]                    -1       Push 7
5       5    12         [12]                   -1       Pop 7, push 12
4       4    3          [12,3]                 12       Push 3
3       3    8          [12,8]                 12       Pop 3, push 8
2       2    5          [12,8,5]               8        Push 5
1       1    10         [12,10]                12       Pop 5,8, push 10
0       0    4          [12,10,4]              10       Push 4
```

## Complete Java Program with All Approaches

```java
import java.util.*;

public class NextGreaterElement {
    
    // Approach 1: Brute Force
    public static int[] nextGreaterBruteForce(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        
        for (int i = 0; i < n; i++) {
            result[i] = -1;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    result[i] = arr[j];
                    break;
                }
            }
        }
        return result;
    }
    
    // Approach 2: Optimized Stack (Standard)
    public static int[] nextGreaterOptimized(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = n - 1; i >= 0; i--) {
            // Pop smaller or equal elements
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            
            // Set result
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            
            // Push current element
            stack.push(arr[i]);
        }
        
        return result;
    }
    
    // Approach 3: Using ArrayDeque (better performance)
    public static int[] nextGreaterDeque(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        
        return result;
    }
    
    // Approach 4: Return indices instead of values
    public static int[] nextGreaterIndices(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>(); // Store indices
        
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        
        return result;
    }
    
    // Utility method to print detailed results
    public static void printDetailedResult(int[] arr, int[] values, int[] indices, String approach) {
        System.out.println("\n" + approach + ":");
        System.out.println("Array:          " + Arrays.toString(arr));
        System.out.println("Next Greater:   " + Arrays.toString(values));
        System.out.println("Indices:        " + Arrays.toString(indices));
        
        System.out.println("Explanation:");
        for (int i = 0; i < arr.length; i++) {
            if (values[i] == -1) {
                System.out.println("  " + arr[i] + " → -1 (No greater element)");
            } else {
                System.out.println("  " + arr[i] + " → " + values[i] + 
                                 " (at index " + indices[i] + ")");
            }
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {4, 10, 5, 8, 3, 12, 7};
        
        // Test all approaches
        int[] result1 = nextGreaterBruteForce(arr);
        int[] result2 = nextGreaterOptimized(arr);
        int[] result3 = nextGreaterDeque(arr);
        int[] indices = nextGreaterIndices(arr);
        
        System.out.println("=== Nearest Greater Element on Right ===");
        printDetailedResult(arr, result2, indices, "Optimized Stack Approach");
        
        // Verify all approaches give same result
        System.out.println("\nAll approaches match: " + 
                          Arrays.equals(result1, result2) && 
                          Arrays.equals(result2, result3));
        
        // Test with various arrays
        System.out.println("\n=== Additional Test Cases ===");
        
        int[][] testArrays = {
            {1, 3, 2, 4},           // Basic case
            {6, 8, 0, 1, 3},         // Mixed
            {1, 2, 3, 4, 5},         // Increasing
            {5, 4, 3, 2, 1},         // Decreasing
            {2, 2, 2, 2},            // All equal
            {100},                    // Single element
            {4, 3, 2, 1, 5, 6, 7}     // Valley then peak
        };
        
        String[] descriptions = {
            "Basic case",
            "Mixed values",
            "Strictly increasing",
            "Strictly decreasing",
            "All equal",
            "Single element",
            "Valley then peak"
        };
        
        for (int idx = 0; idx < testArrays.length; idx++) {
            int[] testArr = testArrays[idx];
            int[] testResult = nextGreaterOptimized(testArr);
            System.out.printf("\n%-20s %s\n", descriptions[idx] + ":", 
                             Arrays.toString(testArr));
            System.out.println("  → " + Arrays.toString(testResult));
        }
    }
}
```

## Comparison Table: All Four Variations

| Problem | Traversal | Stack Condition | Stack Order | First Element | Last Element |
|---------|-----------|-----------------|-------------|---------------|--------------|
| **Smaller Left** | Left→Right | Pop while ≥ current | Increasing | Always -1 | Depends |
| **Smaller Right** | Right→Left | Pop while ≥ current | Increasing | Depends | Always -1 |
| **Greater Left** | Left→Right | Pop while ≤ current | Decreasing | Always -1 | Depends |
| **Greater Right** | Right→Left | Pop while ≤ current | Decreasing | Depends | Always -1 |

## Complexity Analysis

### Brute Force
- **Time:** O(n²) - Nested loops
- **Space:** O(1) - Only result array

### Optimized Stack
- **Time:** O(n) - Each element pushed/popped once
- **Space:** O(n) - Stack in worst case

## Key Insights

1. **Stack Property:** Stack maintains decreasing order (for greater element problems)
2. **Right to Left Traversal:** Essential for processing right-side elements first
3. **Element Removal:** Pop while top ≤ current (since they block the view)
4. **Monotonic Stack:** Classic example of decreasing monotonic stack

## Common Variations and Extensions

### 1. Next Greater Element (Circular Array)
```java
public static int[] nextGreaterCircular(int[] arr) {
    int n = arr.length;
    int[] result = new int[n];
    Arrays.fill(result, -1);
    Stack<Integer> stack = new Stack<>();
    
    // Traverse twice for circular behavior
    for (int i = 0; i < 2 * n; i++) {
        int num = arr[i % n];
        while (!stack.isEmpty() && arr[stack.peek()] < num) {
            result[stack.pop()] = num;
        }
        if (i < n) {
            stack.push(i);
        }
    }
    return result;
}
```

### 2. Distance to Next Greater Element
```java
public static int[] distanceToNextGreater(int[] arr) {
    int n = arr.length;
    int[] result = new int[n];
    Stack<Integer> stack = new Stack<>();
    
    for (int i = n - 1; i >= 0; i--) {
        while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
            stack.pop();
        }
        result[i] = stack.isEmpty() ? -1 : stack.peek() - i;
        stack.push(i);
    }
    return result;
}
```

### 3. Next Greater Element for Multiple Queries
```java
class NextGreaterQuery {
    private int[] arr;
    private int[] nextGreater;
    
    public NextGreaterQuery(int[] arr) {
        this.arr = arr;
        this.nextGreater = precomputeNextGreater();
    }
    
    private int[] precomputeNextGreater() {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return result;
    }
    
    public int query(int index) {
        if (index < 0 || index >= arr.length) return -1;
        return nextGreater[index] == -1 ? -1 : arr[nextGreater[index]];
    }
}
```

### 4. Next Greater Element with Greater or Equal
```java
public static int[] nextGreaterOrEqual(int[] arr) {
    int n = arr.length;
    int[] result = new int[n];
    Stack<Integer> stack = new Stack<>();
    
    for (int i = n - 1; i >= 0; i--) {
        // Change <= to < for greater or equal
        while (!stack.isEmpty() && stack.peek() < arr[i]) {
            stack.pop();
        }
        result[i] = stack.isEmpty() ? -1 : stack.peek();
        stack.push(arr[i]);
    }
    return result;
}
```

## Real-world Applications

1. **Stock Market Analysis**: Find next higher price
   ```java
   // Stock prices: [100, 80, 60, 70, 60, 75, 85]
   // Next higher:  [-1,  -1, 70, 75, 75, 85, -1]
   ```

2. **Temperature Analysis**: Find next warmer day
   ```java
   // Temperatures: [73, 74, 75, 71, 69, 72, 76, 73]
   // Days until warmer: [1, 1, 4, 2, 1, 1, 0, 0]
   ```

3. **Expression Evaluation**: In parsing mathematical expressions

4. **Game Development**: Finding next obstacle or enemy

5. **Database Query Optimization**: Finding next greater value in sorted data

## Common Interview Questions Using This Pattern

1. **LeetCode 496**: Next Greater Element I
2. **LeetCode 503**: Next Greater Element II (Circular)
3. **LeetCode 556**: Next Greater Element III
4. **LeetCode 739**: Daily Temperatures
5. **LeetCode 1019**: Next Greater Node in Linked List

## Edge Cases and Considerations

```java
// Test all edge cases
public static void testEdgeCases() {
    // Empty array
    int[] arr1 = {};
    System.out.println("Empty: " + Arrays.toString(nextGreaterOptimized(arr1))); // []
    
    // Single element
    int[] arr2 = {5};
    System.out.println("Single: " + Arrays.toString(nextGreaterOptimized(arr2))); // [-1]
    
    // All equal
    int[] arr3 = {3, 3, 3, 3};
    System.out.println("All equal: " + Arrays.toString(nextGreaterOptimized(arr3))); // [-1,-1,-1,-1]
    
    // Strictly increasing
    int[] arr4 = {1, 2, 3, 4, 5};
    System.out.println("Increasing: " + Arrays.toString(nextGreaterOptimized(arr4))); // [2,3,4,5,-1]
    
    // Strictly decreasing
    int[] arr5 = {5, 4, 3, 2, 1};
    System.out.println("Decreasing: " + Arrays.toString(nextGreaterOptimized(arr5))); // [-1,-1,-1,-1,-1]
    
    // With duplicates
    int[] arr6 = {2, 4, 4, 3, 5};
    System.out.println("With duplicates: " + Arrays.toString(nextGreaterOptimized(arr6))); // [4,5,5,5,-1]
}
```

## Performance Optimization Tips

1. **Use ArrayDeque instead of Stack** for better performance:
```java
Deque<Integer> stack = new ArrayDeque<>(); // Faster than Stack
```

2. **For primitive arrays**, consider custom stack implementation:
```java
class IntStack {
    private int[] arr;
    private int top;
    private int capacity;
    
    public IntStack(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.top = -1;
    }
    
    public void push(int val) { arr[++top] = val; }
    public int pop() { return arr[top--]; }
    public int peek() { return arr[top]; }
    public boolean isEmpty() { return top == -1; }
}
```

3. **Memory optimization** for large arrays:
```java
// Process in chunks if array is too large
public static int[] nextGreaterChunked(int[] arr, int chunkSize) {
    // Implementation for very large arrays
}
```

The Next Greater Element problem is a classic example of using monotonic stacks and appears frequently in coding interviews. Understanding this pattern helps solve many related problems efficiently!


## =========== Q-5: 