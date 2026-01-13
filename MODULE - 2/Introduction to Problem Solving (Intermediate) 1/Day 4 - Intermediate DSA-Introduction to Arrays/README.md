## --- notes on Array in java --
Below are **clean, structured, exam-ready + interview-ready NOTES on ARRAYS in JAVA** 📘
(Perfect for BCA / MCA / Interviews / DSA prep)

---

# 📦 ARRAYS IN JAVA – COMPLETE NOTES

---

## 1️⃣ What is an Array?

An **Array** in Java is a **fixed-size, indexed, homogeneous** data structure used to store multiple values of the **same data type** in a **contiguous memory location**.

```java
int[] arr = new int[5];
```

---

## 2️⃣ Key Characteristics of Arrays

| Feature           | Description               |
| ----------------- | ------------------------- |
| Fixed Size        | Size cannot change        |
| Same Data Type    | All elements must be same |
| Indexed           | Index starts from `0`     |
| Contiguous Memory | Stored sequentially       |
| Random Access     | Access in O(1)            |

---

## 3️⃣ Types of Arrays in Java

### 1️⃣ One-Dimensional Array

```java
int[] arr = {10, 20, 30, 40};
```

### 2️⃣ Two-Dimensional Array

```java
int[][] matrix = new int[3][3];
```

### 3️⃣ Multi-Dimensional Array

```java
int[][][] cube = new int[2][2][2];
```

### 4️⃣ Jagged Array (Unequal Columns)

```java
int[][] jagged = new int[3][];
jagged[0] = new int[2];
jagged[1] = new int[4];
jagged[2] = new int[1];
```

---

## 4️⃣ Array Declaration & Initialization

### 🔹 Declaration

```java
int[] a;
int a[];
```

### 🔹 Memory Allocation

```java
a = new int[5];
```

### 🔹 Initialization

```java
int[] a = {1, 2, 3, 4};
```

---

## 5️⃣ Accessing & Updating Elements

```java
int[] arr = {5, 10, 15};

System.out.println(arr[1]); // 10
arr[2] = 20;
```

⏱ Time Complexity: **O(1)**

---

## 6️⃣ Array Length

```java
int n = arr.length;
```

✔ `length` is a **variable**, not a method

---

## 7️⃣ Traversing an Array

### 🔹 Using for loop

```java
for (int i = 0; i < arr.length; i++) {
    System.out.print(arr[i]);
}
```

### 🔹 Using enhanced for-loop

```java
for (int x : arr) {
    System.out.print(x);
}
```

---

## 8️⃣ Default Values in Arrays

| Data Type | Default Value |
| --------- | ------------- |
| int       | 0             |
| float     | 0.0           |
| char      | '\u0000'      |
| boolean   | false         |
| Object    | null          |

---

## 9️⃣ Common Array Operations

### 🔹 Insertion (at index)

```java
arr[index] = value;
```

### 🔹 Deletion (Logical)

```java
arr[index] = 0;
```

### 🔹 Searching

* Linear Search → O(n)
* Binary Search → O(log n) *(sorted array)*

---

## 🔟 Sorting Arrays

### Using Arrays.sort()

```java
import java.util.Arrays;
Arrays.sort(arr);
```

⏱ Time: **O(n log n)**

---

## 1️⃣1️⃣ Arrays Class (java.util.Arrays)

| Method         | Use         |
| -------------- | ----------- |
| sort()         | Sort array  |
| binarySearch() | Search      |
| equals()       | Compare     |
| fill()         | Fill values |
| toString()     | Print       |

```java
System.out.println(Arrays.toString(arr));
```

---

## 1️⃣2️⃣ Passing Array to Method

```java
void print(int[] arr) {
    for (int x : arr) System.out.print(x);
}
```

✔ Arrays are passed **by reference (copy of reference)**

---

## 1️⃣3️⃣ Array of Objects

```java
class Student {
    int id;
}

Student[] s = new Student[3];
s[0] = new Student();
```

---

## 1️⃣4️⃣ Memory Representation

* Array reference stored in **stack**
* Actual array stored in **heap**
* Contiguous memory allocation

---

## 1️⃣5️⃣ Time & Space Complexity of Arrays

| Operation | Time |
| --------- | ---- |
| Access    | O(1) |
| Search    | O(n) |
| Insert    | O(n) |
| Delete    | O(n) |

Space → **O(n)**

---

## 1️⃣6️⃣ Limitations of Arrays ❌

❌ Fixed size
❌ Cannot grow/shrink
❌ Memory wastage
❌ No built-in methods like List

➡️ Use **ArrayList** for dynamic size

---

## 1️⃣7️⃣ Arrays vs ArrayList

| Feature     | Array              | ArrayList       |
| ----------- | ------------------ | --------------- |
| Size        | Fixed              | Dynamic         |
| Performance | Faster             | Slightly slower |
| Data Types  | Primitive + Object | Objects only    |
| Methods     | Limited            | Rich API        |

---

## 1️⃣8️⃣ Common Interview Questions ⭐

1. Difference between `int[] a` and `int a[]`
2. Why array index starts from 0?
3. Why arrays are faster?
4. What happens if index out of range?
   👉 `ArrayIndexOutOfBoundsException`

---

## 1️⃣9️⃣ DSA Patterns Using Arrays

✔ Sliding Window
✔ Two Pointer
✔ Prefix Sum
✔ Contribution Technique
✔ Kadane’s Algorithm

---

## 2️⃣0️⃣ One-Line Summary

> **Array = Fixed size, same type, fast access data structure**

---

If you want:
✅ **PDF notes**
✅ **Important array problems with solutions**
✅ **Java coding interview questions**
✅ **Cheat sheet (1 page)**
✅ **Practice set (easy → hard)**

Just tell me 👍
