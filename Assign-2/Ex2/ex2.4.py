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

def measure_time(array):
    start = time.time()
    func1(array, 0, len(array) - 1)
    end = time.time()
    return end - start

def load_array(filename):
    with open(filename, 'r') as f:
        return json.load(f)

filename = 'Ex2/ex2.json'
array = load_array(filename)

times = [measure_time(array) for _ in range(5)]

plt.plot(range(1, 6), times)
plt.xlabel('Trial number')
plt.ylabel('Time (seconds)')
plt.title('QuickSort performance')
plt.show()
