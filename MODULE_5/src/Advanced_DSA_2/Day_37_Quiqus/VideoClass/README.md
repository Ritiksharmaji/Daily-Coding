## Q-1: Queue using Array - Simple Implementation #####
```java
class myQueue {
    constructor(capacity) {

        //Maximum number of elements the queue can hold.
        this.capacity = capacity;

        // Array to store queue elements.
        this.arr = new Array(capacity);

        // Current number of elements in the queue.
        this.size = 0;
    }

    //Maximum number of elements the queue can hold.
    isEmpty() {
        return this.size === 0;
    }

    // Check if full
    isFull() {
        return this.size === this.capacity;
    }

    // Enqueue
    enqueue(x) {
        if (this.isFull()) {
            console.log("Queue is full!");
            return;
        }
        this.arr[this.size] = x;
        this.size++;
    }

    // Dequeue
    dequeue() {
        if (this.isEmpty()) {
            console.log("Queue is empty!");
            return;
        }
        for (let i = 1; i < this.size; i++) {
            this.arr[i - 1] = this.arr[i];
        }
        this.size--;
    }

    // Get front element
    getFront() {
        if (this.isEmpty()) {
            console.log("Queue is empty!");
            return -1;
        }
        return this.arr[0];
    }

    // Get rear element
    getRear() {
        if (this.isEmpty()) {
            console.log("Queue is empty!");
            return -1;
        }
        return this.arr[this.size - 1];
    }
}

//Driver Code
let q = new myQueue(3);

q.enqueue(10);
q.enqueue(20);
q.enqueue(30);
console.log("Front:", q.getFront());

        q.dequeue();
console.log("Front:", q.getFront());
        console.log("Rear:", q.getRear());

        q.enqueue(40);
```

I'll explain your **Queue using Simple Array** step-by-step with **logic, code explanation, and a detailed dry run**.

---

# 1️⃣ What This Program Implements

This program implements a **Queue using a simple array**.

A **Queue** follows **FIFO (First In First Out)**.

Example:

```
Insert: 10 → 20 → 30
Remove → 10 removed first
```

---

# 2️⃣ Class Structure

```
class myQueue
```

This class creates a **queue object**.

Inside the constructor we define:

* capacity → maximum elements
* arr → array to store elements
* size → current number of elements

---

# 3️⃣ Constructor

```javascript
constructor(capacity) {
    this.capacity = capacity;
    this.arr = new Array(capacity);
    this.size = 0;
}
```

### Meaning

| Variable | Purpose                               |
| -------- | ------------------------------------- |
| capacity | maximum queue size                    |
| arr      | array storing elements                |
| size     | number of elements currently in queue |

---

### Initial State

When this runs:

```javascript
let q = new myQueue(3);
```

Queue state:

```
capacity = 3
size = 0

arr = [ _, _, _ ]
```

---

# 4️⃣ isEmpty()

```
isEmpty() {
    return this.size === 0;
}
```

Checks if queue has **no elements**.

Example:

```
size = 0 → true
size = 2 → false
```

---

# 5️⃣ isFull()

```
isFull() {
    return this.size === this.capacity;
}
```

Queue is full when:

```
size == capacity
```

Example:

```
capacity = 3
size = 3 → full
```

---

# 6️⃣ Enqueue Operation

```
enqueue(x)
```

Adds element at the **rear of queue**.

Code:

```javascript
enqueue(x) {
    if (this.isFull()) {
        console.log("Queue is full!");
        return;
    }
    this.arr[this.size] = x;
    this.size++;
}
```

Steps:

1. Check if queue is full
2. Insert element at `arr[size]`
3. Increase size

---

# 7️⃣ Dequeue Operation

Removes element from **front of queue**.

Code:

```javascript
dequeue() {
    if (this.isEmpty()) {
        console.log("Queue is empty!");
        return;
    }
    for (let i = 1; i < this.size; i++) {
        this.arr[i - 1] = this.arr[i];
    }
    this.size--;
}
```

Steps:

1. Check if queue empty
2. Shift all elements left
3. Decrease size

⚠ Problem: **Shifting takes O(n)** time.

---

# 8️⃣ getFront()

```
return this.arr[0]
```

Because **front element is always at index 0**.

---

# 9️⃣ getRear()

```
return this.arr[this.size - 1]
```

Rear element is the **last inserted element**.

---

# 🔟 Complete Dry Run

### Step 1

```
let q = new myQueue(3);
```

Queue:

```
arr = [_, _, _]
size = 0
```

---

## Step 2

```
q.enqueue(10)
```

```
arr[0] = 10
size = 1
```

Queue:

```
[10, _, _]
```

---

## Step 3

```
q.enqueue(20)
```

```
arr[1] = 20
size = 2
```

Queue:

```
[10, 20, _]
```

---

## Step 4

```
q.enqueue(30)
```

```
arr[2] = 30
size = 3
```

Queue:

```
[10, 20, 30]
```

Queue is now **FULL**.

---

## Step 5

```
console.log("Front:", q.getFront());
```

Front element:

```
arr[0] = 10
```

Output:

```
Front: 10
```

---

## Step 6

```
q.dequeue()
```

Remove first element.

Before shifting:

```
[10, 20, 30]
```

Shifting process:

```
arr[0] = arr[1] → 20
arr[1] = arr[2] → 30
```

After shift:

```
[20, 30, 30]
```

Decrease size:

```
size = 2
```

Logical queue:

```
[20, 30]
```

---

## Step 7

```
console.log("Front:", q.getFront());
```

Front element:

```
arr[0] = 20
```

Output:

```
Front: 20
```

---

## Step 8

```
console.log("Rear:", q.getRear());
```

Rear element:

```
arr[size-1] = arr[1] = 30
```

Output:

```
Rear: 30
```

---

## Step 9

```
q.enqueue(40)
```

Insert at:

```
arr[2] = 40
```

Increase size:

```
size = 3
```

Final queue:

```
[20, 30, 40]
```

---

# Final Output

```
Front: 10
Front: 20
Rear: 30
```

---

# Time Complexity

| Operation | Complexity |
| --------- | ---------- |
| Enqueue   | O(1)       |
| Dequeue   | O(n) ❌     |
| getFront  | O(1)       |
| getRear   | O(1)       |

---

# Important Interview Note

This implementation is **not efficient** because:

```
Dequeue requires shifting all elements
```

Better solutions:

1️⃣ Queue using **front & rear pointers**
2️⃣ **Circular Queue**
3️⃣ **Queue using Linked List**

---

If you want, I can also show you:

* **Circular Queue implementation with dry run**
* **Queue using Linked List**
* **Interview problems on Queue**

Just tell me.

## ================ Q-2: Implementation of Circular Queue Using Array ========================= ####
```java
package Advanced_DSA_2.Day_37_Quiqus.VideoClass;

/*
Q-2: Implementation of Circular Queue Using Array
*/

public class Problem_2 {

    int[] arr;
    int front;
    int size;
    int capacity;

    // Constructor
    Problem_2(int cap) {

        arr = new int[cap];
        front = 0;
        size = 0;
        capacity = cap;
    }

    // Insert element
    void enqueue(int x) {

        if (size == capacity) {
            System.out.println("Queue is full!");
            return;
        }

        int rear = (front + size) % capacity;

        arr[rear] = x;

        size++;
    }

    // Remove element
    int dequeue() {

        if (size == 0) {
            System.out.println("Queue is empty!");
            return -1;
        }

        int res = arr[front];

        front = (front + 1) % capacity;

        size--;

        return res;
    }

    // Get Front
    int getFront() {

        if (size == 0)
            return -1;

        return arr[front];
    }

    // Get Rear
    int getRear() {

        if (size == 0)
            return -1;

        int rear = (front + size - 1) % capacity;

        return arr[rear];
    }

    // Driver Code
    public static void main(String[] args) {

        Problem_2 q = new Problem_2(5);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println(q.getFront() + " " + q.getRear());

        q.dequeue();

        System.out.println(q.getFront() + " " + q.getRear());

        q.enqueue(40);

        System.out.println(q.getFront() + " " + q.getRear());
    }
}
```

I’ll explain your **Circular Queue using Array** code **line by line + concept + full dry run** so the logic becomes very clear.

---

# 1️⃣ What is a Circular Queue?

A **Circular Queue** is an improved version of a normal queue where the **last position connects back to the first position**.

Normal Queue Problem:

```
[10,20,30,40,50]
dequeue() twice

[_,_,30,40,50]
```

Space at beginning is **wasted**.

Circular Queue solves this by **reusing empty spaces**.

It uses **modulus (%) operation** to wrap around.

---

# 2️⃣ Class Variables

```java
int[] arr;
int front;
int size;
int capacity;
```

| Variable | Meaning                      |
| -------- | ---------------------------- |
| arr      | array storing queue elements |
| front    | index of first element       |
| size     | current number of elements   |
| capacity | maximum queue size           |

---

# 3️⃣ Constructor

```java
Problem_2(int cap) {

    arr = new int[cap];
    front = 0;
    size = 0;
    capacity = cap;
}
```

When object is created:

```
Problem_2 q = new Problem_2(5);
```

Initial state:

```
arr = [_,_,_,_,_]
front = 0
size = 0
capacity = 5
```

---

# 4️⃣ Enqueue Operation

```java
void enqueue(int x)
```

### Step 1

Check if queue is full

```
if(size == capacity)
```

Example:

```
size = 5
capacity = 5
Queue full
```

---

### Step 2

Calculate **rear index**

```
rear = (front + size) % capacity
```

Why?

Because rear must **wrap around the array**.

---

### Step 3

Insert element

```
arr[rear] = x
size++
```

---

# 5️⃣ Dequeue Operation

```java
int dequeue()
```

### Step 1

Check if queue empty

```
if(size == 0)
```

---

### Step 2

Store front element

```
res = arr[front]
```

---

### Step 3

Move front forward

```
front = (front + 1) % capacity
```

---

### Step 4

Decrease size

```
size--
```

---

# 6️⃣ Get Front

```
return arr[front]
```

Front always points to the **first element**.

---

# 7️⃣ Get Rear

```
rear = (front + size - 1) % capacity
```

Because rear is always **last inserted element**.

---

# 8️⃣ Complete Dry Run

## Step 1

```
Problem_2 q = new Problem_2(5)
```

State:

```
arr = [_,_,_,_,_]
front = 0
size = 0
```

---

# Step 2

```
q.enqueue(10)
```

rear:

```
(0 + 0) % 5 = 0
```

Insert:

```
arr[0] = 10
```

State:

```
[10,_,_,_,_]
front = 0
size = 1
```

---

# Step 3

```
q.enqueue(20)
```

rear:

```
(0 + 1) % 5 = 1
```

State:

```
[10,20,_,_,_]
size = 2
```

---

# Step 4

```
q.enqueue(30)
```

rear:

```
(0 + 2) % 5 = 2
```

State:

```
[10,20,30,_,_]
size = 3
```

---

# Step 5

```
System.out.println(q.getFront() + " " + q.getRear());
```

Front:

```
arr[0] = 10
```

Rear:

```
(0 + 3 - 1) % 5 = 2
arr[2] = 30
```

Output:

```
10 30
```

---

# Step 6

```
q.dequeue()
```

Remove front:

```
res = arr[0] = 10
```

Move front:

```
front = (0 + 1) % 5 = 1
```

State:

```
[10,20,30,_,_]
front = 1
size = 2
```

Logical queue:

```
20,30
```

---

# Step 7

```
System.out.println(q.getFront() + " " + q.getRear());
```

Front:

```
arr[1] = 20
```

Rear:

```
(1 + 2 - 1) % 5 = 2
arr[2] = 30
```

Output:

```
20 30
```

---

# Step 8

```
q.enqueue(40)
```

rear:

```
(1 + 2) % 5 = 3
```

Insert:

```
arr[3] = 40
```

State:

```
[10,20,30,40,_]
front = 1
size = 3
```

Logical queue:

```
20,30,40
```

---

# Step 9

```
System.out.println(q.getFront() + " " + q.getRear());
```

Front:

```
arr[1] = 20
```

Rear:

```
(1 + 3 - 1) % 5 = 3
arr[3] = 40
```

Output:

```
20 40
```

---

# 9️⃣ Final Output

```
10 30
20 30
20 40
```

---

# 🔟 Time Complexity

| Operation | Complexity |
| --------- | ---------- |
| Enqueue   | O(1)       |
| Dequeue   | O(1)       |
| getFront  | O(1)       |
| getRear   | O(1)       |

No shifting required.

---

# 🔥 Important Formula (Most Important)

### Rear Calculation

```
rear = (front + size) % capacity
```

### Front Movement

```
front = (front + 1) % capacity
```

---

# 🎯 Interview Difference

| Simple Queue    | Circular Queue  |
| --------------- | --------------- |
| Wastes space    | Uses full array |
| dequeue O(n)    | dequeue O(1)    |
| shifting needed | no shifting     |

---

If you want, I can also show **a visualization diagram of circular queue (very easy to remember)** which most teachers skip but helps a lot in interviews.

## =============== Q-3: Queue - Linked List Implementation ============ ##

```java

public class Problem_3 {

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int new_data) {
            data = new_data;
            next = null;
        }
    }

    Node front, rear;
    int currSize;

    // Constructor
    Problem_3() {
        front = rear = null;
        currSize = 0;
    }

    // Check if queue is empty
    boolean isEmpty() {
        return front == null;
    }

    // Enqueue (insert element)
    void enqueue(int new_data) {

        Node new_node = new Node(new_data);

        if (isEmpty()) {
            front = rear = new_node;
        } else {
            rear.next = new_node;
            rear = new_node;
        }

        currSize++;
    }

    // Dequeue (remove element)
    int dequeue() {

        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }

        int removedData = front.data;

        front = front.next;

        if (front == null) {
            rear = null;
        }

        currSize--;

        return removedData;
    }

    // Get front element
    int getFront() {

        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        return front.data;
    }

    // Get size
    int size() {
        return currSize;
    }

    // Driver Code
    public static void main(String[] args) {

        Problem_3 q = new Problem_3();

        q.enqueue(10);
        q.enqueue(20);

        System.out.println("Dequeue: " + q.dequeue());

        q.enqueue(30);

        System.out.println("Front: " + q.getFront());
        System.out.println("Size: " + q.size());
    }
}
```
Alright Ritik — I’ll explain **Queue implementation using Linked List from 0 → 100** using **your exact code example**, with **concept, structure, operations, and a full dry run**. This is the kind of explanation useful for **DSA interviews and exams**. 🚀

---

# 1️⃣ What is a Queue?

A **Queue** is a **linear data structure** that follows the rule:

**FIFO – First In First Out**

Meaning:

* The **first element inserted** will be the **first element removed**.

Example (Real Life):

Queue at a ticket counter 🎟️

```
Person A -> Person B -> Person C
```

Person A came first → served first.

---

# 2️⃣ Basic Operations of Queue

| Operation  | Meaning                   |
| ---------- | ------------------------- |
| enqueue()  | Insert element in queue   |
| dequeue()  | Remove element from queue |
| getFront() | Get first element         |
| size()     | Get number of elements    |
| isEmpty()  | Check queue empty         |

---

# 3️⃣ Queue Implementation Methods

There are **two common ways**:

1️⃣ **Array Implementation**

2️⃣ **Linked List Implementation** ✅ (Your code)

Why Linked List?

* Dynamic size
* No overflow (until memory full)
* Efficient insertion/deletion

---

# 4️⃣ Structure of Queue Using Linked List

Each element is a **Node**.

Node contains:

```
data  -> value
next  -> pointer to next node
```

Example queue:

```
front                         rear
  ↓                             ↓
[10 | next] -> [20 | next] -> [30 | null]
```

---

# 5️⃣ Understanding the Code

Your class:

```java
public class Problem_3
```

This class represents the **Queue**.

---

# 6️⃣ Node Class

```java
static class Node {
    int data;
    Node next;

    Node(int new_data) {
        data = new_data;
        next = null;
    }
}
```

Purpose: represents **each element of queue**.

Example Node:

```
[ data | next ]
```

Example:

```
[10 | null]
```

---

# 7️⃣ Queue Variables

```java
Node front, rear;
int currSize;
```

| Variable | Meaning            |
| -------- | ------------------ |
| front    | first element      |
| rear     | last element       |
| currSize | number of elements |

Initial state:

```
front = null
rear = null
size = 0
```

Queue is empty.

---

# 8️⃣ Constructor

```java
Problem_3() {
    front = rear = null;
    currSize = 0;
}
```

When queue is created:

```
Queue = empty
```

---

# 9️⃣ isEmpty()

```java
boolean isEmpty() {
    return front == null;
}
```

If front is null → queue empty.

Example

```
front = null
rear = null
```

Return → **true**

---

# 🔟 Enqueue Operation

Insert element at **rear**.

Code:

```java
void enqueue(int new_data) {

    Node new_node = new Node(new_data);

    if (isEmpty()) {
        front = rear = new_node;
    } else {
        rear.next = new_node;
        rear = new_node;
    }

    currSize++;
}
```

---

## Step by Step Logic

### Step 1

Create node

```
Node new_node = new Node(new_data)
```

Example:

```
enqueue(10)

[10 | null]
```

---

### Step 2

Check if queue empty

```
if(isEmpty())
```

If yes:

```
front = rear = new_node
```

---

### Step 3

If queue NOT empty

```
rear.next = new_node
rear = new_node
```

Meaning:

Add node **after rear**.

---

# 1️⃣1️⃣ Dequeue Operation

Remove element from **front**.

Code:

```java
int dequeue() {

    if (isEmpty()) {
        System.out.println("Queue Underflow");
        return -1;
    }

    int removedData = front.data;

    front = front.next;

    if (front == null) {
        rear = null;
    }

    currSize--;

    return removedData;
}
```

---

## Logic

1️⃣ Save front data

2️⃣ Move front forward

3️⃣ If queue becomes empty → rear = null

---

# 1️⃣2️⃣ getFront()

```java
int getFront() {

    if (isEmpty()) {
        System.out.println("Queue is empty");
        return -1;
    }

    return front.data;
}
```

Returns **first element**.

---

# 1️⃣3️⃣ size()

```java
int size() {
    return currSize;
}
```

Returns number of elements.

Time Complexity → **O(1)**

---

# 1️⃣4️⃣ Driver Code

```
Problem_3 q = new Problem_3();
```

Queue created.

State:

```
front = null
rear = null
size = 0
```

---

# 🔥 FULL DRY RUN

Program:

```
q.enqueue(10);
q.enqueue(20);
System.out.println("Dequeue: " + q.dequeue());
q.enqueue(30);
System.out.println("Front: " + q.getFront());
System.out.println("Size: " + q.size());
```

---

# Step 1

```
q.enqueue(10)
```

Create node

```
[10 | null]
```

Queue empty → front = rear = node

Queue:

```
front
 ↓
[10 | null]
 ↑
rear
```

size = 1

---

# Step 2

```
q.enqueue(20)
```

Create node

```
[20 | null]
```

Connect:

```
rear.next = new_node
rear = new_node
```

Queue becomes:

```
front
 ↓
[10 | next] -> [20 | null]
                ↑
               rear
```

size = 2

---

# Step 3

```
q.dequeue()
```

Remove front

```
removedData = 10
```

Move front:

```
front = front.next
```

Queue becomes:

```
front
 ↓
[20 | null]
 ↑
rear
```

size = 1

Output

```
Dequeue: 10
```

---

# Step 4

```
q.enqueue(30)
```

Create node

```
[30 | null]
```

Attach after rear:

```
rear.next = new_node
rear = new_node
```

Queue:

```
front
 ↓
[20 | next] -> [30 | null]
                ↑
               rear
```

size = 2

---

# Step 5

```
q.getFront()
```

Return

```
20
```

Output:

```
Front: 20
```

---

# Step 6

```
q.size()
```

Return:

```
2
```

Output:

```
Size: 2
```

---

# ✅ Final Output

```
Dequeue: 10
Front: 20
Size: 2
```

---

# 1️⃣5️⃣ Time Complexity

| Operation | Complexity |
| --------- | ---------- |
| enqueue   | O(1)       |
| dequeue   | O(1)       |
| getFront  | O(1)       |
| size      | O(1)       |

Very efficient.

---

# 1️⃣6️⃣ Advantages of Linked List Queue

✔ Dynamic size
✔ No overflow
✔ Efficient insertion
✔ Efficient deletion

---

# 1️⃣7️⃣ Visualization

Final queue:

```
front
 ↓
[20] -> [30]
         ↑
        rear
```

---

# ⭐ Interview Tip

If interviewer asks:

**Why maintain rear pointer?**

Answer:

Without rear pointer:

```
enqueue = O(n)
```

With rear pointer:

```
enqueue = O(1)
```

---

✅ If you want, I can also explain:

* **Queue using Array vs Linked List (interview comparison)**
* **Circular Queue (very important for interviews)**
* **Deque implementation**
* **Queue problems asked in FAANG**

Just tell me 👍

## ========== Q-4: Implement a Queue using Stack. ===========

Ritik, now let’s understand **Queue Implementation using Stack** from **0 → 100 with concept, code, and dry run**. This is a **very common DSA interview question**. 🚀

---

# 1️⃣ Problem Statement

Implement a **Queue using Stack**.

We know:

Queue follows **FIFO**

```
First In → First Out
```

But **Stack follows LIFO**

```
Last In → First Out
```

So the challenge is:

👉 **How to simulate FIFO behavior using LIFO stacks?**

---

# 2️⃣ Idea of the Solution

We use **two stacks**

```
stack1 → used for enqueue
stack2 → used for dequeue
```

Why two stacks?

Because we need to **reverse the order**.

---

# 3️⃣ Visualization

Suppose we insert:

```
10
20
30
```

Queue should behave like:

```
Front → 10 20 30 ← Rear
```

But stack stores like:

```
Top
30
20
10
```

So we transfer elements between stacks to maintain **FIFO order**.

---

# 4️⃣ Two Approaches

### Approach 1 (Costly Enqueue)

enqueue = **O(n)**
dequeue = **O(1)**

### Approach 2 (Costly Dequeue) ✅ Most common

enqueue = **O(1)**
dequeue = **O(n)**

We will implement **Approach 2**.

---

# 5️⃣ Algorithm

### Enqueue(x)

```
push element into stack1
```

### Dequeue()

```
1 move all elements from stack1 → stack2
2 pop from stack2
3 move elements back stack2 → stack1
```

This reverses order.

---

# 6️⃣ Java Implementation

```java
import java.util.Stack;

public class QueueUsingStack {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    // Enqueue operation
    void enqueue(int x) {
        stack1.push(x);
    }

    // Dequeue operation
    int dequeue() {

        if (stack1.isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }

        // Move stack1 → stack2
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        // Remove front element
        int res = stack2.pop();

        // Move stack2 → stack1
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        return res;
    }

    // Get front element
    int getFront() {

        if (stack1.isEmpty()) {
            System.out.println("Queue Empty");
            return -1;
        }

        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        int front = stack2.peek();

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        return front;
    }

    public static void main(String[] args) {

        QueueUsingStack q = new QueueUsingStack();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println("Dequeue: " + q.dequeue());

        System.out.println("Front: " + q.getFront());
    }
}
```

---

# 7️⃣ Step-by-Step Dry Run

Initial state

```
stack1 = []
stack2 = []
```

---

# Step 1

```
enqueue(10)
```

Push into stack1

```
stack1 = [10]
stack2 = []
```

Queue view:

```
Front → 10
```

---

# Step 2

```
enqueue(20)
```

```
stack1 = [10,20]
stack2 = []
```

Queue view

```
Front → 10 20
```

---

# Step 3

```
enqueue(30)
```

```
stack1 = [10,20,30]
stack2 = []
```

Queue view

```
Front → 10 20 30
```

---

# Step 4

```
dequeue()
```

Move stack1 → stack2

```
stack1 = []
stack2 = [30,20,10]
```

Stack view

```
Top
10
20
30
```

Now pop from stack2

```
removed = 10
```

---

Move stack2 → stack1

```
stack1 = [20,30]
stack2 = []
```

Queue becomes

```
Front → 20 30
```

Output

```
Dequeue: 10
```

---

# Step 5

```
getFront()
```

Move stack1 → stack2

```
stack1 = []
stack2 = [30,20]
```

Top of stack2

```
front = 20
```

Move elements back

```
stack1 = [20,30]
stack2 = []
```

Output

```
Front: 20
```

---

# 8️⃣ Final Output

```
Dequeue: 10
Front: 20
```

---

# 9️⃣ Visualization

Before dequeue

```
stack1

Top
30
20
10
```

After conversion

```
stack2

Top
10
20
30
```

Now dequeue removes **10 first** → FIFO achieved.

---

# 🔟 Time Complexity

| Operation | Time |
| --------- | ---- |
| enqueue   | O(1) |
| dequeue   | O(n) |
| getFront  | O(n) |

---

# 1️⃣1️⃣ Optimized Approach (Interview Bonus)

Better solution:

```
enqueue → O(1)
dequeue → amortized O(1)
```

Idea:

Only move elements **when stack2 becomes empty**.

If you want, I can also explain this **optimized FAANG-level version** with diagrams. It’s **one of the most asked DSA interview problems**.
= yes: 

Great Ritik 👍 Now let’s learn the **Optimized Queue using Two Stacks** (this is the **interview-level solution** used in companies).

This version makes **both operations almost O(1)** using a smart trick called **Amortized Time Complexity**.

---

# 1️⃣ Problem

Implement **Queue (FIFO)** using **Stacks (LIFO)**.

Queue rule:

```
First In → First Out
```

Stack rule:

```
Last In → First Out
```

So we use **two stacks**.

```
stack1 → for enqueue (input stack)
stack2 → for dequeue (output stack)
```

---

# 2️⃣ Core Idea (Important)

We **DO NOT move elements every time**.

We only move elements **when stack2 becomes empty**.

```
enqueue → push into stack1

dequeue →
    if stack2 empty
        move all elements stack1 → stack2
    pop from stack2
```

Why?

Because reversing stack1 into stack2 **gives FIFO order**.

---

# 3️⃣ Visualization

Suppose we insert

```
10
20
30
```

### stack1

```
Top
30
20
10
```

Now when we move stack1 → stack2

### stack2

```
Top
10
20
30
```

Now **10 is at top → correct FIFO order**.

---

# 4️⃣ Java Code (Optimized Version)

```java
import java.util.Stack;

public class QueueUsingStacks {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    // ENQUEUE
    void enqueue(int x) {
        stack1.push(x);
    }

    // DEQUEUE
    int dequeue() {

        if (stack1.isEmpty() && stack2.isEmpty()) {
            System.out.println("Queue Empty");
            return -1;
        }

        // move elements only if stack2 empty
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    // GET FRONT
    int getFront() {

        if (stack1.isEmpty() && stack2.isEmpty()) {
            System.out.println("Queue Empty");
            return -1;
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.peek();
    }

    public static void main(String[] args) {

        QueueUsingStacks q = new QueueUsingStacks();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println("Dequeue: " + q.dequeue());

        q.enqueue(40);

        System.out.println("Front: " + q.getFront());
    }
}
```

---

# 5️⃣ Full Dry Run

Initial state

```
stack1 = []
stack2 = []
```

---

# Step 1

```
enqueue(10)
```

```
stack1 = [10]
stack2 = []
```

Queue view

```
Front → 10
```

---

# Step 2

```
enqueue(20)
```

```
stack1 = [10,20]
stack2 = []
```

Queue

```
Front → 10 20
```

---

# Step 3

```
enqueue(30)
```

```
stack1 = [10,20,30]
stack2 = []
```

Queue

```
Front → 10 20 30
```

---

# Step 4

```
dequeue()
```

stack2 is empty → move stack1 → stack2

Move elements:

```
stack1.pop() → 30 → stack2.push()
stack1.pop() → 20 → stack2.push()
stack1.pop() → 10 → stack2.push()
```

Now

```
stack1 = []
stack2 = [30,20,10]
```

Top of stack2

```
10
```

Now pop

```
removed = 10
```

State

```
stack1 = []
stack2 = [30,20]
```

Queue

```
Front → 20 30
```

Output

```
Dequeue: 10
```

---

# Step 5

```
enqueue(40)
```

```
stack1 = [40]
stack2 = [30,20]
```

Queue logically

```
Front → 20 30 40
```

---

# Step 6

```
getFront()
```

stack2 not empty

Front

```
20
```

Output

```
Front: 20
```

---

# 6️⃣ Final Output

```
Dequeue: 10
Front: 20
```

---

# 7️⃣ Why This Is Optimized

In the **previous solution** every dequeue required:

```
O(n)
```

But in this version:

Elements move **only once**.

Example:

```
10 20 30
```

Moved **only one time** from stack1 → stack2.

So total operations spread over time become:

```
Amortized O(1)
```

---

# 8️⃣ Time Complexity

| Operation | Complexity     |
| --------- | -------------- |
| enqueue   | O(1)           |
| dequeue   | O(1) amortized |
| getFront  | O(1) amortized |

---

# 9️⃣ Interview Tip ⭐

Interviewers often ask:

**"Why two stacks?"**

Answer:

```
First stack stores elements
Second stack reverses order to maintain FIFO
```

---

# 🔟 When This Question Appears

Common in interviews for:

* product companies
* backend roles
* DSA rounds

---

✅ Since you are learning **Advanced DSA now**, the **next queue questions usually are**:

1️⃣ **Queue using Linked List**
2️⃣ **Stack using Queue**
3️⃣ **Deque Implementation**
4️⃣ **Priority Queue / Heap**
5️⃣ **Sliding Window Maximum (very famous)**

If you want, I can also explain **Stack using Queue with full dry run** (another very common interview question).


## =========================== Q-5: You are given: An integer array arr An integer K You must find the maximum element in every subarray of size K. =====
This is a **very important Queue problem in DSA** called **Sliding Window Maximum**. It is usually solved using a **Deque (Double Ended Queue)** which is a special type of **Queue**.

I will explain **from 0 to 100**:

1. Problem Understanding
2. Brute Force Idea
3. Optimized Queue Idea
4. Dry Run Step-by-Step
5. Java Code
6. Time Complexity

---

# 1️⃣ Problem Statement

You are given:

* An integer array `arr`
* An integer `K`

You must find the **maximum element in every subarray of size K**.

Example:

```
arr = [1,3,-1,-3,5,3,6,7]
K = 3
```

Subarrays of size 3:

```
[1,3,-1] → max = 3
[3,-1,-3] → max = 3
[-1,-3,5] → max = 5
[-3,5,3] → max = 5
[5,3,6] → max = 6
[3,6,7] → max = 7
```

Final Output

```
[3,3,5,5,6,7]
```

---

# 2️⃣ What is a Sliding Window

A **window of size K moves across the array**.

```
Array: 1 3 -1 -3 5 3 6 7
        ----
        window size = 3
```

Then shift right:

```
1 3 -1 -3 5 3 6 7
  ----
```

Then shift again:

```
1 3 -1 -3 5 3 6 7
    ----
```

This is called **Sliding Window**.

---

# 3️⃣ Brute Force Method

For each window:

```
find max of K elements
```

Example:

```
for i from 0 to n-k
    find max of arr[i...i+k-1]
```

Time Complexity

```
O(N*K)
```

Too slow for large arrays.

---

# 4️⃣ Optimized Idea (Using Queue / Deque)

We use a **Deque**.

Deque allows:

```
insert front
insert rear
remove front
remove rear
```

Why Deque?

Because we maintain **indexes of useful elements only**.

Rules:

1️⃣ Remove elements **outside window**

```
if index <= i-k
remove from front
```

2️⃣ Remove **smaller elements**

Because they cannot be maximum later.

```
while arr[last] < arr[i]
remove last
```

3️⃣ Insert current index

```
dq.addLast(i)
```

4️⃣ Front always stores **maximum element index**

---

# 5️⃣ Step-by-Step Dry Run

Array

```
arr = [1,3,-1,-3,5,3,6,7]
k = 3
```

Deque stores **indexes**.

---

## Step 1

```
i = 0
element = 1
```

Deque

```
[0]
```

Array view

```
[1]
```

---

## Step 2

```
i = 1
element = 3
```

Remove smaller elements.

```
1 < 3
remove index 0
```

Deque

```
[1]
```

---

## Step 3

```
i = 2
element = -1
```

Insert normally.

Deque

```
[1,2]
```

Window formed

```
[1,3,-1]
```

Maximum

```
arr[1] = 3
```

Output

```
3
```

---

## Step 4

```
i = 3
element = -3
```

Check window limit

```
1 still valid
```

Insert index

Deque

```
[1,2,3]
```

Window

```
[3,-1,-3]
```

Maximum

```
arr[1] = 3
```

Output

```
3
```

---

## Step 5

```
i = 4
element = 5
```

Remove smaller elements

```
-3 < 5 remove
-1 < 5 remove
3 < 5 remove
```

Deque

```
[4]
```

Window

```
[-1,-3,5]
```

Maximum

```
5
```

Output

```
5
```

---

## Step 6

```
i = 5
element = 3
```

Insert

Deque

```
[4,5]
```

Window

```
[-3,5,3]
```

Max

```
5
```

Output

```
5
```

---

## Step 7

```
i = 6
element = 6
```

Remove smaller

```
3 < 6 remove
5 < 6 remove
```

Deque

```
[6]
```

Window

```
[5,3,6]
```

Max

```
6
```

Output

```
6
```

---

## Step 8

```
i = 7
element = 7
```

Remove smaller

```
6 < 7 remove
```

Deque

```
[7]
```

Window

```
[3,6,7]
```

Max

```
7
```

Output

```
7
```

---

# 6️⃣ Final Output

```
3 3 5 5 6 7
```

---

# 7️⃣ Java Code

```java
import java.util.*;

public class SlidingWindowMaximum {

    static void maxSlidingWindow(int arr[], int k) {

        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {

            // Remove elements outside window
            while (!dq.isEmpty() && dq.peekFirst() <= i - k)
                dq.pollFirst();

            // Remove smaller elements
            while (!dq.isEmpty() && arr[dq.peekLast()] < arr[i])
                dq.pollLast();

            dq.addLast(i);

            // Print max
            if (i >= k - 1)
                System.out.print(arr[dq.peekFirst()] + " ");
        }
    }

    public static void main(String[] args) {

        int arr[] = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        maxSlidingWindow(arr, k);
    }
}
```

Output

```
3 3 5 5 6 7
```

---

# 8️⃣ Time Complexity

```
O(N)
```

Why?

Each element enters and leaves deque **once only**.

---

# 9️⃣ Why Queue / Deque is Used

Deque maintains **useful elements only**.

Example

```
1 3 -1 -3 5
```

When **5 arrives**:

```
all smaller numbers removed
```

Because they **cannot be maximum anymore**.

---

# 🔟 Very Important Interview Question

This question appears in:

* Amazon
* Google
* Microsoft
* Flipkart

It is considered **Top 10 Sliding Window problems**.

---

If you want, I can also show you **the visual diagram version of Sliding Window (very easy to remember for exams)** which most DSA teachers use to explain this problem.
