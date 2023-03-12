import timeit
import random
import matplotlib.pyplot as plt

#inefficient search
def linear_search(arr, x):
    for i in range(len(arr)):
        if arr[i] == x:
            return i
    return -1

#efficient search
def binary_search(arr, x):
    low = 0
    high = len(arr) - 1
    while low <= high:
        mid = (low + high) // 2
        if arr[mid] < x:
            low = mid + 1
        elif arr[mid] > x:
            high = mid - 1
        else:
            return mid
    return -1

# generate a sorted list of 10000 elements
arr = sorted(random.sample(range(10000), 10000))

# perform 100 measurements for each search algorithm
linear_search_times = []
binary_search_times = []
for i in range(100):
    x = random.randint(0, 9999)
    start_time = timeit.default_timer()
    linear_search(arr, x)
    linear_search_times.append(timeit.default_timer() - start_time)
    start_time = timeit.default_timer()
    binary_search(arr, x)
    binary_search_times.append(timeit.default_timer() - start_time)

# plot the distribution of measured times
plt.hist(linear_search_times, bins=10, alpha=0.5, label='Linear Search')
plt.hist(binary_search_times, bins=10, alpha=0.5, label='Binary Search')
plt.legend(loc='upper right')
plt.show()

# print the aggregate of measured times
print('Linear Search: min={:.6f}s, avg={:.6f}s'.format(min(linear_search_times), sum(linear_search_times)/len(linear_search_times)))
print('Binary Search: min={:.6f}s, avg={:.6f}s'.format(min(binary_search_times), sum(binary_search_times)/len(binary_search_times)))
