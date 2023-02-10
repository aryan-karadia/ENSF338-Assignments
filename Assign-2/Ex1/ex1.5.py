import timeit
import matplotlib.pyplot as plt

def func2(n, memo={}):
    if n == 0 or n == 1:
        return 1
    if n in memo:
        return memo[n]
    else:
        memo[n] = func2(n-1, memo) + func2(n-2, memo)
        return memo[n]

def func(n):
    if n == 0 or n == 1:
        return 1
    return func(n-1) + func(n-2)

outputMemo = [timeit.timeit(lambda: func2(i)) for i in range(0, 36)]

output = [timeit.timeit(lambda: func(i)) for i in range(0, 36)]

plt.plot(outputMemo, label="Memoization", color="red")
plt.plot(output, label="Original", color="blue")
plt.show()