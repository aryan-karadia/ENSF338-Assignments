import sys
import time
import matplotlib.pyplot as plt
import json

sys.setrecursionlimit(20000)

def func1(arr, low, high):
    if low < high:
        pi = func2(arr, low, high)
        func1(arr, low, pi-1)
        func1(arr, pi + 1, high)

def func2(array, start, end):
    p = array[start]
    low = start + 1
    high = end
    while True:
        while low <= high and array[high] >= p:
            high = high - 1
        while low <= high and array[low] <= p:
            low = low + 1
        if low <= high:
            array[low], array[high] = array[high], array[low]
        else:
            break
    array[start], array[high] = array[high], array[start]
    return high

timing_results = []
with open("Ex2/ex2.json") as f:
    data = json.load(f)
    for i, array in enumerate(data):
        start = time.time()
        func1(array, 0, len(array) - 1)
        end = time.time()
        timing_results.append(end - start)

plt.plot(timing_results)
plt.xlabel('Trial Number')
plt.ylabel('Time (s)')
plt.title('Timing Results for func1')
plt.show()
