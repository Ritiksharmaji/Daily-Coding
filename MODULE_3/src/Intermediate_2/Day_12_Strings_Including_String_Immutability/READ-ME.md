## --- Problem-1: Given a String, toggle every character Note-: input has small & Capital chars.
## --- Problem-2: Check Whether the given String is Palindrome or not.
## --- Problem-3: Check whether the given Sub-String is Palindrome or not.
## --- Problem-4: Given a String s , calculate Length of longest palindromic substring.
=======================================================================================
## --- Problem-1: Given a String, toggle every character Note-: input has small & Capital chars.

## --- Problem-2: Check Whether the given String is Palindrome or not.

## --- Problem-3: Check whether the given Sub-String is Palindrome or not.

## --- Problem-4: Given a String s , calculate Length of longest palindromic substring.
This is one of the **most important String interview problems**. There are **4 approaches**, each improving the previous one.

---

# Problem Statement

Given a string `S`, find the **length of the longest palindromic substring**.

A **substring** is a continuous part of the string.

A **palindrome** reads the same forward and backward.

---

## Example 1

```text
Input:
S = "abacab"

Substrings that are palindromes:

a
b
a
c
a
b
aba
aca
bacab

Longest = "bacab"

Length = 5
```

---

## Example 2

```text
Input

fcacabacabgf
```

Palindrome

```text
cacabac
```

Length

```text
7
```

---

# Method-1 : Brute Force

## Idea

Generate every substring.

For every substring,

check whether it is palindrome.

Keep maximum length.

---

## Flow Diagram

```text
Take String

        │

        ▼

Generate every substring

        │

        ▼

Is Palindrome?

        │

   Yes  ▼

Update Answer

        │

        ▼

Return Maximum Length
```

---

# Step 1 : Generate Every Substring

Example

```text
abc
```

Generated substrings

```text
a
ab
abc

b
bc

c
```

Total

```text
N(N+1)/2
```

substrings.

---

# Step 2 : Check Palindrome

Example

```text
bacab
```

Compare

```text
b == b

a == a

c
```

Palindrome ✔

---

Example

```text
abca
```

Compare

```text
a == a

b != c
```

Not palindrome ❌

---

# Dry Run

Input

```text
abacab
```

Generated

| Substring | Palindrome? | Length |
| --------- | ----------- | ------ |
| a         | ✔           | 1      |
| ab        | ❌           | -      |
| aba       | ✔           | 3      |
| abac      | ❌           | -      |
| abaca     | ❌           | -      |
| abacab    | ❌           | -      |
| b         | ✔           | 1      |
| ba        | ❌           | -      |
| bac       | ❌           | -      |
| baca      | ❌           | -      |
| bacab     | ✔           | 5      |
| a         | ✔           | 1      |
| ac        | ❌           | -      |
| aca       | ✔           | 3      |
| acab      | ❌           | -      |
| c         | ✔           | 1      |
| ca        | ❌           | -      |
| cab       | ❌           | -      |
| a         | ✔           | 1      |
| ab        | ❌           | -      |
| b         | ✔           | 1      |

Maximum

```text
5
```

---

# Brute Force Code

```java
public static int longestPalindromeBF(String s){

    int ans = 0;

    for(int start=0;start<s.length();start++){

        for(int end=start;end<s.length();end++){

            if(isPalindrome(s,start,end)){

                ans=Math.max(ans,end-start+1);

            }

        }

    }

    return ans;

}

public static boolean isPalindrome(String s,int L,int R){

    while(L<R){

        if(s.charAt(L)!=s.charAt(R))
            return false;

        L++;
        R--;

    }

    return true;

}
```

---

## Complexity

Generating substrings

```text
O(N²)
```

Checking palindrome

```text
O(N)
```

Total

```text
O(N³)
```

---

# Method-2 : Better (DP)

### Observation

Many palindrome checks are repeated.

Example

```text
abacaba
```

While checking

```text
abacaba
```

you again check

```text
bacab

aca
```

These were already checked.

Store the answer.

---

DP Table

```text
dp[i][j]

true

if

substring(i,j)

is palindrome.
```

Transition

```text
if(s[i]==s[j]){

dp[i][j]=dp[i+1][j-1];

}
```

---

Complexity

```text
Time

O(N²)

Space

O(N²)
```

---

# Method-3 : Optimized (Expand Around Center)

This is the interview favorite.

---

## Observation

Every palindrome has a center.

Example

Odd palindrome

```text
racecar

    e
```

Expand

```text
e

cec

aceca

racecar
```

---

Even palindrome

```text
abba

  ||
```

Expand

```text
bb

abba
```

---

So every index can be

* Odd center
* Even center

---

# Flow Diagram

```text
Every Character

      │

      ▼

Treat as Center

      │

      ▼

Expand Left & Right

      │

      ▼

Characters Equal?

      │

 Yes

      ▼

Increase Length

      │

 No

      ▼

Stop
```

---

# Dry Run

Input

```text
abacab
```

Index

```text
0 1 2 3 4 5
a b a c a b
```

Center = 2

```text
a
```

Expand

```text
a

bab

ababa ❌
```

Length

```text
3
```

---

Center = 3

```text
c
```

Expand

```text
c

aca

bacab
```

Length

```text
5
```

Maximum

```text
5
```

---

# Optimized Code

```java
public static int longestPalindromeCenter(String s){

    int ans=1;

    for(int i=0;i<s.length();i++){

        ans=Math.max(ans,expand(s,i,i));

        ans=Math.max(ans,expand(s,i,i+1));

    }

    return ans;

}

public static int expand(String s,int L,int R){

    while(L>=0 && R<s.length()
            && s.charAt(L)==s.charAt(R)){

        L--;
        R++;

    }

    return R-L-1;

}
```

---

## Complexity

Every center expands.

```text
Time

O(N²)

Space

O(1)
```

---

# Method-4 : Manacher's Algorithm (Most Optimized)

Very advanced algorithm.

Idea

Avoid repeated expansions using previously computed palindrome information.

Complexity

```text
Time

O(N)

Space

O(N)
```

Used rarely outside advanced interviews and competitive programming.

---

# Complexity Comparison

| Method               | Time  | Space |
| -------------------- | ----- | ----- |
| Brute Force          | O(N³) | O(1)  |
| DP                   | O(N²) | O(N²) |
| Expand Around Center | O(N²) | O(1)  |
| Manacher             | O(N)  | O(N)  |

---

# Final Combined Code

```java
public class Problem4 {

    // Brute Force
    public static int longestPalindromeBF(String s){

        int ans=0;

        for(int i=0;i<s.length();i++){

            for(int j=i;j<s.length();j++){

                if(isPalindrome(s,i,j)){

                    ans=Math.max(ans,j-i+1);

                }

            }

        }

        return ans;

    }

    static boolean isPalindrome(String s,int L,int R){

        while(L<R){

            if(s.charAt(L)!=s.charAt(R))
                return false;

            L++;
            R--;

        }

        return true;

    }

    // Expand Around Center
    public static int longestPalindromeCenter(String s){

        int ans=1;

        for(int i=0;i<s.length();i++){

            ans=Math.max(ans,expand(s,i,i));

            ans=Math.max(ans,expand(s,i,i+1));

        }

        return ans;

    }

    static int expand(String s,int L,int R){

        while(L>=0 && R<s.length()
                && s.charAt(L)==s.charAt(R)){

            L--;
            R++;

        }

        return R-L-1;

    }

    public static void main(String[] args){

        String s="fcacabacabgf";

        System.out.println("Brute Force = "
                +longestPalindromeBF(s));

        System.out.println("Center Expansion = "
                +longestPalindromeCenter(s));

    }

}
```

---

# Interview Summary

When asked **"Longest Palindromic Substring"**, think in this progression:

1. **Brute Force**: Generate all substrings and check each palindrome → **O(N³)**.
2. **Dynamic Programming**: Reuse palindrome results for smaller substrings → **O(N²)** time, **O(N²)** space.
3. **Expand Around Center**: Expand from each possible center (odd and even) → **O(N²)** time, **O(1)** space. This is the approach most interviewers expect.
4. **Manacher's Algorithm**: Advanced linear-time solution → **O(N)**, typically only for competitive programming or specialized interviews.
