Summarized from
- http://web.mit.edu/1.124/LectureNotes/sorting.html
- https://en.wikipedia.org/wiki/Sorting_algorithm#Efficient_sorts

## Quicksort
#### Efficiency
Time: O(n log n) average case, but **O(n<sup>2</sup>) worst case** [already sorted file]
Space: O(log n)
Stable: no
**Caveat**: complex but common optimizations make this **extremely** unlikely to encounter worst case, and make it stable
#### Use Cases
- Good default
- Subtle implementation issues can hurt perf
- Unstable, poor worst case
- **Good for most real world use cases**

## Mergesort
#### Efficiency
Time: O(n log n) [all cases]
Space: O(n) [on linked lists, O(1)]
Stable: yes
#### Use Cases
- Whenever sequential access is required (e.g., **linked lists**)
- Reasonable default (good worst time on collections of **any composition**)

## Insertion Sort
#### Efficiency
Time: O(n<sup>2</sup>) (in both worst **and average** cases!)
Space: O(1)
Stable: yes
Online: yes [can be used in a collection that is undergoing modification]
#### Use Cases
- **If used on an almost sorted list**, this is O(n)
- Can be used on a collection that is ***currently being modified***

## Selection Sort
#### Efficiency
Time: O(n<sup>2</sup>)
Space: O(1)
Stable: no
#### Use Case
- Only makes n swaps.  **If swapping is more expensive than comparisons** (e.g., small keys, large records), this is O(n).

## Heap Sort
#### Efficiency
Time: O(n log n)
Space: O(n)
Stable: no
#### Use Case
- Same as selection sort, but with **better time & worse space complexity**
