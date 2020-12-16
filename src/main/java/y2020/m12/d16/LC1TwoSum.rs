use std::collections::{HashMap, HashSet};

pub fn two_sum(nums: Vec<i32>, target: i32) -> Vec<i32> {
    let mut map: HashMap<i32, i32> = HashMap::with_capacity(nums.len());
    for (i, n) in nums.iter().enumerate() {
        let remain = target - n;

        match map.get(&remain) {
            Some(value) => return vec![*value, i as i32],
            None => {
                map.insert(n.clone(), i as i32);
            }
        }
    }

    return vec![];
}

#[cfg(test)]
mod tests {
    use super::two_sum;
    use std::collections::HashSet;
    use std::iter::FromIterator;

    fn to_set(vec: &Vec<i32>) -> HashSet<i32> {
        HashSet::from_iter(vec.iter().cloned())
    }

    fn assert(v1: Vec<i32>, v2: Vec<i32>) {
        assert_eq!(to_set(&v1), to_set(&v2))
    }

    #[test]
    fn tc1() {
        let arr = vec![99, 100, 1, 2, 3, 4, 5, 6];
        let target = 199;
        let expected = vec![0, 1];

        assert(expected, two_sum(arr, target))
    }

    #[test]
    fn tc2() {
        let arr = vec![1, 3, 4, 5, -2, 6, 7, 8, 9, -8, 10, 11, 12, 13];
        let target = -10;
        let expected = vec![4, 9];

        assert(expected, two_sum(arr, target))
    }

    #[test]
    fn tc3() {
        let arr = vec![2, 4, 6, 8, 10, 12, -1];
        let target = 5;
        let expected = vec![2, 6];

        assert(expected, two_sum(arr, target))
    }
}
