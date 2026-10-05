## ----- Q-1: prime number checker function in java ---
Here’s a **complete guide** to writing a **Prime Number Checker in Java** — from basic to optimized, with pseudocode and dry run.

---

# 🔷 1. What is a Prime Number?

A number is **prime** if:

* It has exactly **2 factors** → `1` and itself
* Example: `2, 3, 5, 7, 11`

---

# 🔶 2. Brute Force Approach

## 💡 Idea

Check if any number from `2 → n-1` divides `n`.

---

## 🧠 Pseudocode

```
function isPrime(n):
    if n <= 1:
        return false

    for i from 2 to n-1:
        if n % i == 0:
            return false

    return true
```

---

## 💻 Java Code

```java
public class PrimeCheck {

    public static boolean isPrime(int n) {

        if (n <= 1) {
            return false;
        }

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int n = 7;
        System.out.println(isPrime(n));
    }
}
```

---

## ⏱️ Complexity

* Time: **O(n)** ❌ (slow)

---

# 🔶 3. Optimized Approach (√n)

## 💡 Key Idea

If a number has a factor, it must be ≤ √n

👉 So check only till `√n`

---

## 🧠 Pseudocode

```
function isPrime(n):
    if n <= 1:
        return false

    for i from 2 to √n:
        if n % i == 0:
            return false

    return true
```

---

## 💻 Java Code (BEST ✅)

```java
public class PrimeCheck {

    public static boolean isPrime(int n) {

        if (n <= 1) {
            return false;
        }

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int n = 29;
        System.out.println(isPrime(n));
    }
}
```

---

## ⏱️ Complexity

* Time: **O(√n)** ✅
* Space: **O(1)**

---

# 🔶 4. More Optimized (Skip Even Numbers)

## 💡 Idea

* Check `2` separately
* Then check only **odd numbers**

---

## 💻 Code

```java
public static boolean isPrime(int n) {

    if (n <= 1) return false;
    if (n == 2) return true;
    if (n % 2 == 0) return false;

    for (int
```
