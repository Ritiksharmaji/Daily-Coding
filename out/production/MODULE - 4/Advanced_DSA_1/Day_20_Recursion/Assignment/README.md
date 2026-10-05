## --- Q-1: Q1. Simple Recursion ----
What will be the output of following program ?

```java
public class Solve {

    // bar(x, y) -> returns x * y using recursion
    static int bar(int x, int y) {
        if (y == 0)
            return 0;
        return x + bar(x, y - 1);
    }

    // foo(x, y) -> returns x^y using recursion
    static int foo(int x, int y) {
        if (y == 0)
            return 1;
        return bar(x, foo(x, y - 1));
    }

    public static void main(String[] args) {
        int x = 3;
        int y = 5;
        System.out.println(foo(x, y)); // Output: 243
    }
}

```
Alright, let’s **decode this recursion step-by-step** like you’d do in an exam or interview 🧠💡
This is a **classic Scaler recursion trap question**.

---

## 📌 Given Code (Core Logic)

```java
static int bar(int x, int y){
    if (y == 0) return 0;
    return (x + bar(x, y-1));
}

static int foo(int x, int y){
    if (y == 0) return 1;
    return bar(x, foo(x, y-1));
}
```

And the call is:

```java
foo(3, 5)
```

---

## 🔍 First, understand what each function does

### 🔹 `bar(x, y)`

```java
bar(x, y) = x + x + x + ... (y times)
```

👉 So:

```
bar(x, y) = x * y
```

---

### 🔹 `foo(x, y)`

```java
foo(x, y) = bar(x, foo(x, y-1))
```

👉 Which means:

```
foo(x, y) = x * foo(x, y-1)
```

💥 This is **exponentiation**

So mathematically:

```
foo(x, y) = x^y
```

---

## 🧮 Dry Run for `foo(3,5)`

Let’s expand **step by step** 👇

### Step 1

```
foo(3,5) = bar(3, foo(3,4))
```

### Step 2

```
foo(3,4) = bar(3, foo(3,3))
```

### Step 3

```
foo(3,3) = bar(3, foo(3,2))
```

### Step 4

```
foo(3,2) = bar(3, foo(3,1))
```

### Step 5

```
foo(3,1) = bar(3, foo(3,0))
```

### Base Case

```
foo(3,0) = 1
```

---

## 🔄 Now resolve bottom-up

```
foo(3,1) = bar(3,1) = 3 * 1 = 3
foo(3,2) = bar(3,3) = 3 * 3 = 9
foo(3,3) = bar(3,9) = 3 * 9 = 27
foo(3,4) = bar(3,27) = 3 * 27 = 81
foo(3,5) = bar(3,81) = 3 * 81 = 243
```

---

## ✅ Final Answer

```
243
```

✔ Correct option: **243**

---

## 🧠 Key Insight (Exam Gold ⭐)

* `bar(x,y)` → multiplication
* `foo(x,y)` → power function
* Overall → **xʸ using recursion**

---

If you want, I can also:

* draw **recursion tree**
* explain **time & space complexity**
* give a **similar MCQ practice question**

Just tell me 👍

## --- Q-2: Q2. Find Factorial! -----
