## =========== implementation of stack using Array ========
Q-1: implement the stack with all stack operation using array
Alright — let’s build **Stack using Array** step-by-step with **full details, intuition, pseudocode, code, dry run, and complexities**. No shortcuts.

---

# 🔥 1. What is Stack?

A **Stack** is a **LIFO (Last In First Out)** data structure.

👉 Last inserted element comes out first.

### Example:

```
Push: 10, 20, 30
Stack: [10, 20, 30]  (30 is TOP)

Pop → 30 removed
Stack: [10, 20]
```

---

# 🔥 2. Operations in Stack

| Operation | Meaning              |
| --------- | -------------------- |
| push(x)   | Insert element       |
| pop()     | Remove top element   |
| peek()    | Get top element      |
| isEmpty() | Check if stack empty |
| isFull()  | Check if stack full  |
| size()    | Current size         |

---

# 🔥 3. Array Implementation Concept

We use:

* `int[] stack` → array
* `int top` → points to top element

### Initialization:

```
top = -1  → means empty stack
```

---

# 🔥 4. Conditions

### ✅ Empty:

```
top == -1
```

### ✅ Full:

```
top == capacity - 1
```

---

# 🔥 5. PSEUDOCODE

---

## 👉 push(x)

```
if top == size - 1
    print "Overflow"
else
    top = top + 1
    stack[top] = x
```

---

## 👉 pop()

```
if top == -1
    print "Underflow"
else
    value = stack[top]
    top = top - 1
    return value
```

---

## 👉 peek()

```
if top == -1
    print "Empty"
else
    return stack[top]
```

---

## 👉 isEmpty()

```
return top == -1
```

---

## 👉 isFull()

```
return top == capacity - 1
```

---

## 👉 size()

```
return top + 1
```

---

# 🔥 6. FULL JAVA CODE

```java
public class StackArray {

    int[] stack;
    int top;
    int capacity;

    // Constructor
    public StackArray(int size) {
        capacity = size;
        stack = new int[size];
        top = -1;
    }

    // PUSH
    public void push(int x) {
        if (isFull()) {
            System.out.println("Stack Overflow");
            return;
        }
        top++;
        stack[top] = x;
        System.out.println(x + " pushed");
    }

    // POP
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        int val = stack[top];
        top--;
        return val;
    }

    // PEEK
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return stack[top];
    }

    // isEmpty
    public boolean isEmpty() {
        return top == -1;
    }

    // isFull
    public boolean isFull() {
        return top == capacity - 1;
    }

    // size
    public int size() {
        return top + 1;
    }

    // display stack
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack Empty");
            return;
        }
        for (int i = 0; i <= top; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    // MAIN METHOD
    public static void main(String[] args) {
        StackArray s = new StackArray(5);

        s.push(10);
        s.push(20);
        s.push(30);

        s.display();

        System.out.println("Top element: " + s.peek());

        System.out.println("Popped: " + s.pop());

        s.display();

        System.out.println("Size: " + s.size());
    }
}
```

---

# 🔥 7. DRY RUN (STEP BY STEP)

### Initial:

```
stack = [ _ _ _ _ _ ]
top = -1
```

---

### push(10)

```
top = 0
stack = [10 _ _ _ _]
```

---

### push(20)

```
top = 1
stack = [10 20 _ _ _]
```

---

### push(30)

```
top = 2
stack = [10 20 30 _ _]
```

---

### peek()

```
returns stack[2] = 30
```

---

### pop()

```
returns 30
top = 1
stack = [10 20 _ _ _]
```

---

# 🔥 8. TIME & SPACE COMPLEXITY

| Operation | Time |
| --------- | ---- |
| push      | O(1) |
| pop       | O(1) |
| peek      | O(1) |
| isEmpty   | O(1) |

### Space:

```
O(N) → array size
```

---

# ⚠️ 9. IMPORTANT EDGE CASES

* Push when full → ❌ Overflow
* Pop when empty → ❌ Underflow
* Always check before operation

---

# 🚀 10. INTERVIEW TIPS

👉 Always mention:

* LIFO concept
* top pointer
* overflow/underflow

👉 Common questions:

* Stack using array
* Stack using linked list
* Two stacks in one array 🔥

---

If you want next level:
👉 Stack using Linked List
👉 Min Stack (important 🔥)
👉 Infix → Postfix

Just tell me 👍


### =========== Q-2: Stack using Linked List  =============
Alright 🔥 now let’s do **Stack using Linked List** with full depth (concept → pseudocode → code → dry run → complexity). This is **very important for interviews**.

---

# 🔥 1. Why Linked List for Stack?

Array Stack has limitation:
❌ Fixed size (overflow problem)

Linked List Stack:
✅ Dynamic size
✅ No overflow (until memory full)

---

# 🔥 2. Structure

We use:

* `Node` → stores data + next pointer
* `top` → points to top element of stack

---

## Node Structure

```java
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
```

---

# 🔥 3. Stack Representation

```
Top → [30] → [20] → [10] → null
```

---

# 🔥 4. Operations

---

## ✅ PUSH (Insert at beginning)

### Idea:

* Create new node
* Point it to current top
* Move top to new node

---

### PSEUDOCODE

```
create new node
newNode.next = top
top = newNode
```

---

## ✅ POP (Remove from beginning)

### Idea:

* Remove top node
* Move top to next

---

### PSEUDOCODE

```
if top == null
   underflow
else
   temp = top
   top = top.next
   return temp.data
```

---

## ✅ PEEK

```
return top.data
```

---

## ✅ isEmpty

```
return top == null
```

---

# 🔥 5. FULL JAVA CODE

```java
public class StackLinkedList {

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node top; // top of stack

    // PUSH
    public void push(int x) {
        Node newNode = new Node(x);

        newNode.next = top;
        top = newNode;

        System.out.println(x + " pushed");
    }

    // POP
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }

        int val = top.data;
        top = top.next;

        return val;
    }

    // PEEK
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }

        return top.data;
    }

    // isEmpty
    public boolean isEmpty() {
        return top == null;
    }

    // DISPLAY
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack Empty");
            return;
        }

        Node temp = top;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // MAIN
    public static void main(String[] args) {

        StackLinkedList s = new StackLinkedList();

        s.push(10);
        s.push(20);
        s.push(30);

        s.display();

        System.out.println("Top element: " + s.peek());

        System.out.println("Popped: " + s.pop());

        s.display();
    }
}
```

---

# 🔥 6. DRY RUN (STEP BY STEP)

---

### Initial:

```
top = null
```

---

### push(10)

```
top → [10] → null
```

---

### push(20)

```
newNode.next = top (10)

top → [20] → [10] → null
```

---

### push(30)

```
top → [30] → [20] → [10] → null
```

---

### peek()

```
return 30
```

---

### pop()

```
remove 30

top → [20] → [10] → null
```

---

# 🔥 7. TIME & SPACE COMPLEXITY

| Operation | Time |
| --------- | ---- |
| push      | O(1) |
| pop       | O(1) |
| peek      | O(1) |

### Space:

```
O(N) (dynamic memory)
```

---

# ⚠️ 8. EDGE CASES

* pop on empty → Underflow
* peek on empty → error
* Always check `top == null`

---

# 🔥 9. ARRAY vs LINKED LIST STACK

| Feature  | Array           | Linked List     |
| -------- | --------------- | --------------- |
| Size     | Fixed           | Dynamic         |
| Overflow | Yes             | No              |
| Memory   | Continuous      | Non-contiguous  |
| Speed    | Slightly faster | Slight overhead |

---

# 🚀 10. INTERVIEW TIP (VERY IMPORTANT)

👉 Always say:

> “Stack using Linked List is preferred when size is unknown because it avoids overflow.”

---

If you want next 🔥:

* Min Stack (VERY IMPORTANT 🔥🔥)
* Stack using two queues
* Expression evaluation (Infix/Postfix)

Just tell 👍

## ========= Q-3: Expression evaluation (Infix/Postfix) ==========

Great choice 🔥 This is a **very important stack topic** and frequently asked in interviews.

I’ll explain clearly step-by-step:

---

# 🔥 1. What is Expression Evaluation?

### Types of Expressions:

| Type        | Example | Description              |
| ----------- | ------- | ------------------------ |
| **Infix**   | `A + B` | Operator in middle       |
| **Postfix** | `A B +` | Operator after operands  |
| **Prefix**  | `+ A B` | Operator before operands |

---

# 🔥 2. Why Postfix is Easy?

👉 No need of brackets
👉 No need of precedence handling
👉 Stack works directly

---

# 🔥 3. Postfix Evaluation (CORE CONCEPT)

---

## 💡 Idea:

* Traverse left → right
* If operand → push to stack
* If operator → pop 2 elements → apply → push result

---

## 🔥 Example

```
Expression: 2 3 4 * +
```

---

## 🧠 Dry Run

| Step                    | Stack   |
| ----------------------- | ------- |
| 2 → push                | [2]     |
| 3 → push                | [2,3]   |
| 4 → push                | [2,3,4] |
| * → pop(4,3) → 3*4=12   | [2,12]  |
| + → pop(12,2) → 2+12=14 | [14]    |

✅ Answer = **14**

---

# 🔥 4. Postfix Evaluation Code (Java)

```java
import java.util.Stack;

public class PostfixEvaluation {

    public static int evaluatePostfix(String exp) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {

            char ch = exp.charAt(i);

            // if digit
            if (Character.isDigit(ch)) {
                stack.push(ch - '0');
            } 
            else {
                int val2 = stack.pop();
                int val1 = stack.pop();

                switch (ch) {
                    case '+': stack.push(val1 + val2); break;
                    case '-': stack.push(val1 - val2); break;
                    case '*': stack.push(val1 * val2); break;
                    case '/': stack.push(val1 / val2); break;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String exp = "234*+";
        System.out.println(evaluatePostfix(exp));
    }
}
```

---

# 🔥 5. Time & Space

* **Time:** O(N)
* **Space:** O(N)

---

# 🔥 6. Infix → Postfix Conversion (IMPORTANT 🔥)

---

## 💡 Why needed?

Because:
👉 Infix is hard to evaluate
👉 Convert → Postfix → Evaluate

---

## 🎯 Rules:

### 1. Operand → add to result

### 2. `(` → push

### 3. `)` → pop until `(`

### 4. Operator:

* Pop higher/equal precedence operators
* Then push current operator

---

## 🔥 Precedence

| Operator | Priority |
| -------- | -------- |
| + -      | 1        |
| * /      | 2        |

---

## 🔥 Example

```
Infix: A + B * C
Postfix: A B C * +
```

---

## 🧠 Dry Run

| Step | Stack     | Output |
| ---- | --------- | ------ |
| A    |           | A      |
| +    | +         | A      |
| B    | +         | AB     |
| *    | + *       | AB     |
| C    | + *       | ABC    |
| End  | pop * → + | ABC*+  |

---

# 🔥 7. Infix → Postfix Code

```java
import java.util.Stack;

public class InfixToPostfix {

    public static int precedence(char ch) {
        if (ch == '+' || ch == '-') return 1;
        if (ch == '*' || ch == '/') return 2;
        return 0;
    }

    public static String convert(String exp) {
        Stack<Character> stack = new Stack<>();
        String result = "";

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            // operand
            if (Character.isLetterOrDigit(ch)) {
                result += ch;
            }
            // (
            else if (ch == '(') {
                stack.push(ch);
            }
            // )
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result += stack.pop();
                }
                stack.pop(); // remove '('
            }
            // operator
            else {
                while (!stack.isEmpty() && 
                       precedence(ch) <= precedence(stack.peek())) {
                    result += stack.pop();
                }
                stack.push(ch);
            }
        }

        // remaining
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        String exp = "A+B*C";
        System.out.println(convert(exp));
    }
}
```

---

# 🔥 8. Full Flow (INTERVIEW GOLD)

```
INFIX → POSTFIX → EVALUATE
```

Example:

```
Infix: 2 + 3 * 4
Postfix: 2 3 4 * +
Answer: 14
```

---

# 🔥 9. Common Mistakes ❌

* Wrong order in pop:

  ```
  val1 op val2 (NOT val2 op val1)
  ```
* Not handling precedence
* Not handling brackets

---

# 🔥 10. Advanced (If Asked)

* Prefix evaluation
* Infix → Prefix
* Multi-digit numbers
* Expression tree

---

# 🚀 Final Interview Tip

👉 Always say:

> “We use stack to handle precedence and evaluation efficiently in O(N) time.”

---

If you want next 🔥:

* Prefix evaluation
* Expression tree (VERY IMPORTANT 🔥🔥)
* Real interview questions

Just tell 👍

## ========= Q-4: Nearest Smaller Element on Left =======
Got it — let’s do this **properly from scratch (NO skipping anything)**:
👉 **Brute Force → Thought Process → Pseudocode → Code → Dry Run → Optimization**

---

# 🧩 Problem: Nearest Smaller Element on Left

For every element, find the **closest smaller element on its left**.
If none → return `-1`.

---

# 🔴 1. BRUTE FORCE (BF)

## 🧠 Thinking (Step-by-step)

* For each element `i`
* Look at all elements to its left (`i-1 → 0`)
* Stop when you find first smaller
* If none → `-1`

---

## 📝 PSEUDOCODE (BF)

```
function NSL_BF(arr):
    create empty result array

    for i from 0 to n-1:
        set found = -1

        for j from i-1 down to 0:
            if arr[j] < arr[i]:
                found = arr[j]
                break

        add found to result

    return result
```

---

## 💻 CODE (JavaScript)

```javascript
function NSL_BF(arr) {
    let result = [];

    for (let i = 0; i < arr.length; i++) {
        let found = -1;

        for (let j = i - 1; j >= 0; j--) {
            if (arr[j] < arr[i]) {
                found = arr[j];
                break;
            }
        }

        result.push(found);
    }

    return result;
}
```

---

## 🔍 DRY RUN (BF)

Input:

```
[4, 5, 2, 10, 8]
```

### Step-by-step:

### i = 0 → 4

* No left → result = -1

### i = 1 → 5

* Check 4 → 4 < 5 ✅ → result = 4

### i = 2 → 2

* Check 5 → not smaller
* Check 4 → not smaller
  → result = -1

### i = 3 → 10

* Check 2 → 2 < 10 ✅ → result = 2

### i = 4 → 8

* Check 10 → not smaller
* Check 2 → 2 < 8 ✅ → result = 2

---

## ⛔ Problems with BF

* Repeating work again and again
* Time Complexity = **O(n²)**

---

# 🟡 2. THINKING FOR OPTIMIZATION

## 🧠 Key Question:

“Why are we checking elements again and again?”

👉 Example:
When processing `10`, we already know useful smaller elements.

👉 Idea:
We should **store useful elements** somewhere.

---

## 🔑 Observation:

* If an element is **greater than current**, it will NEVER be useful later
* Because current element is already smaller

👉 So we can **remove useless elements**

---

# 🟢 3. OPTIMAL APPROACH (STACK)

## 💡 Core Idea:

Use a **stack** to keep only useful smaller elements

---

## 🧠 LOGIC (VERY IMPORTANT)

For each element:

1. Remove all elements ≥ current (useless ones)
2. If stack empty → answer = -1
3. Else → answer = top of stack
4. Push current element

---

## 📝 PSEUDOCODE (OPTIMAL)

```
function NSL_Optimal(arr):
    create empty stack
    create empty result array

    for each element in arr:

        while stack is not empty AND stack.top >= current element:
            pop from stack

        if stack is empty:
            add -1 to result
        else:
            add stack.top to result

        push current element into stack

    return result
```

---

## 💻 CODE (JavaScript)

```javascript
function NSL_Optimal(arr) {
    let stack = [];
    let result = [];

    for (let i = 0; i < arr.length; i++) {

        // Step 1: Remove useless elements
        while (stack.length > 0 && stack[stack.length - 1] >= arr[i]) {
            stack.pop();
        }

        // Step 2: Assign result
        if (stack.length === 0) {
            result.push(-1);
        } else {
            result.push(stack[stack.length - 1]);
        }

        // Step 3: Push current
        stack.push(arr[i]);
    }

    return result;
}
```

---

# 🔍 FULL DRY RUN (OPTIMAL)

Input:

```
[4, 5, 2, 10, 8]
```

---

### Step 1 → element = 4

* Stack empty → result = -1
* Push 4

👉 Stack = [4]

---

### Step 2 → element = 5

* Top = 4 < 5 → keep
* Result = 4
* Push 5

👉 Stack = [4, 5]

---

### Step 3 → element = 2

* 5 ≥ 2 → pop
* 4 ≥ 2 → pop
* Stack empty → result = -1
* Push 2

👉 Stack = [2]

---

### Step 4 → element = 10

* 2 < 10 → keep
* Result = 2
* Push 10

👉 Stack = [2, 10]

---

### Step 5 → element = 8

* 10 ≥ 8 → pop
* 2 < 8 → stop
* Result = 2
* Push 8

👉 Stack = [2, 8]

---

## ✅ Final Output:

```
[-1, 4, -1, 2, 2]
```

---

# ⚡ WHY TIME = O(n)?

Each element:

* Pushed once
* Popped at most once

👉 Total operations = **2n → O(n)**

---

# 🧠 FINAL INTUITION (IMPORTANT)

👉 Stack always stores:

> “Valid candidates for nearest smaller”

👉 We remove:

> “Elements that can never help in future”

---

# 🚀 MASTER PATTERN

Same logic works for:

* Nearest Greater Left
* Nearest Smaller Right
* Nearest Greater Right

Just change:

* Direction
* Comparison

---

If you want next level 🔥
I can give you:
👉 One **universal template** to solve all 4 problems in seconds
👉 OR convert this into a **React visualizer for your project**

## ===== in java ===
Perfect — now let’s convert everything into **Java**, starting from **Brute Force → Optimal (Stack)** with **pseudocode, code, and dry run explanation**.

---

# 🔴 1. BRUTE FORCE (Java)

## 🧠 Idea Recap

* For each element, scan left side
* First smaller → answer
* Else → `-1`

---

## 📝 PSEUDOCODE (BF)

```
function NSL_BF(arr):
    n = length of arr
    create result array of size n

    for i from 0 to n-1:
        found = -1

        for j from i-1 down to 0:
            if arr[j] < arr[i]:
                found = arr[j]
                break

        result[i] = found

    return result
```

---

## 💻 JAVA CODE (BF)

```java
import java.util.Arrays;

public class NSL_BF {

    public static int[] nearestSmallerToLeft(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int found = -1;

            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    found = arr[j];
                    break;
                }
            }

            result[i] = found;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10, 8};
        System.out.println(Arrays.toString(nearestSmallerToLeft(arr)));
    }
}
```

---

## ⛔ Complexity

* Time: **O(n²)**
* Space: **O(n)** (result array)

---

# 🟢 2. OPTIMAL (STACK APPROACH - Java)

## 🧠 Key Idea

* Use **Stack**
* Remove useless elements (≥ current)
* Keep only useful smaller elements

---

## 📝 PSEUDOCODE (OPTIMAL)

```
function NSL_Optimal(arr):
    n = length of arr
    create empty stack
    create result array of size n

    for i from 0 to n-1:

        while stack is not empty AND stack.top >= arr[i]:
            pop from stack

        if stack is empty:
            result[i] = -1
        else:
            result[i] = stack.top

        push arr[i] into stack

    return result
```

---

## 💻 JAVA CODE (OPTIMAL)

```java
import java.util.*;

public class NSL_Optimal {

    public static int[] nearestSmallerToLeft(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            // Step 1: Remove all greater or equal elements
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }

            // Step 2: Assign result
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }

            // Step 3: Push current element
            stack.push(arr[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10, 8};
        System.out.println(Arrays.toString(nearestSmallerToLeft(arr)));
    }
}
```

---

# 🔍 DRY RUN (Java - Optimal)

Input:

```
[4, 5, 2, 10, 8]
```

---

### i = 0 → 4

* Stack empty → result[0] = -1
* Push 4
  👉 Stack = [4]

---

### i = 1 → 5

* 4 < 5 → OK
* result[1] = 4
* Push 5
  👉 Stack = [4, 5]

---

### i = 2 → 2

* 5 ≥ 2 → pop
* 4 ≥ 2 → pop
* Stack empty → result[2] = -1
* Push 2
  👉 Stack = [2]

---

### i = 3 → 10

* 2 < 10 → OK
* result[3] = 2
* Push 10
  👉 Stack = [2, 10]

---

### i = 4 → 8

* 10 ≥ 8 → pop
* 2 < 8 → stop
* result[4] = 2
* Push 8
  👉 Stack = [2, 8]

---

## ✅ Final Output

```
[-1, 4, -1, 2, 2]
```

---

# ⚡ FINAL COMPARISON

| Approach      | Time  | Space | Notes               |
| ------------- | ----- | ----- | ------------------- |
| Brute Force   | O(n²) | O(n)  | Simple but slow     |
| Stack Optimal | O(n)  | O(n)  | Best for interviews |

---

# 🧠 IMPORTANT INTERVIEW POINT

👉 Why pop `>=` and not just `>`?

* Because we need **strictly smaller**
* Equal elements are NOT allowed

---

# 🚀 NEXT STEP (HIGH VALUE)

If you want to master this completely, I can give:

* ✅ One **Java template** for all 4 variations (NSL, NSR, NGL, NGR)
* ✅ Real **LeetCode-level problems**
* ✅ How this is used in **Largest Rectangle Histogram**

Just tell me 👍
