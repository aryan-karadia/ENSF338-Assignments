# Memoization Implementation

def func(n, memo={}):
    if n == 0 or n == 1:
        return 1
    if n in memo:
        return memo[n]
    else:
        memo[n] = func(n-1, memo) + func(n-2, memo)
        return memo[n]
