import timeit
import matplotlib.pyplot as plt

def func(n):
    if n == 0 or n == 1:
        return 1
    return func(n-1) + func(n-2)

def func1(n, memo={}):
    if n == 0 or n == 1:
        return 1
    if n in memo:
        return memo[n]
    else:
        memo[n] = func1(n-1, memo) + func1(n-2, memo)
        return memo[n]

originoutput = []

for i in range(0, 36):
    originoutput.append(timeit.timeit("func(i)", setup="from __main__ import func, i", number=1))

memooutput = []

for i in range(0, 36):
    memooutput.append(timeit.timeit("func1(i)", setup="from __main__ import func1, i", number=1))

plt.plot(originoutput, label="origin")
plt.plot(memooutput, label="memo")
plt.xlabel("nth Fib Number")
plt.ylabel("Time")
plt.legend()
plt.show()
